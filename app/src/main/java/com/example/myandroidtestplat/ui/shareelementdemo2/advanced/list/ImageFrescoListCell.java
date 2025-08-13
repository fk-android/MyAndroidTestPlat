package com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myandroidtestplat.R;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.Image;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


import java.lang.ref.SoftReference;
import java.util.Objects;

/**
 * Created by huangwei on 2018/9/19 0019.
 */
public class ImageFrescoListCell extends ImageListCell {
    private SoftReference<CloseableStaticBitmap> mBitmapReference;

    public ImageFrescoListCell(Image image) {
        super(image);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SimpleDraweeView imageView = holder.itemView.findViewById(R.id.list_item_img_fresco);
        ViewCompat.setTransitionName(imageView, mData.url);
        setSize(holder.itemView);

        GenericDraweeHierarchy hierarchy = imageView.getHierarchy();
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);

        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder().setUri(mData.url).setOldController(imageView.getController())
                .setControllerListener(new ControllerListener<ImageInfo>() {
                    @Override
                    public void onSubmit(String id, Object callerContext) {

                    }

                    @Override
                    public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                        if(imageInfo instanceof CloseableStaticBitmap){
                            CloseableStaticBitmap bitmapCloseableReference = ((CloseableStaticBitmap) imageInfo);
                            mBitmapReference = new SoftReference<>(bitmapCloseableReference);
                        }
                    }

                    @Override
                    public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {

                    }

                    @Override
                    public void onIntermediateImageFailed(String id, Throwable throwable) {

                    }

                    @Override
                    public void onFailure(String id, Throwable throwable) {

                    }

                    @Override
                    public void onRelease(String id) {

                    }
                }).build();
        imageView.setController(controller);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnCellClickListener!=null){
                    mOnCellClickListener.onCellClick(ImageFrescoListCell.this);
                }
            }
        });
    }

    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_image_fresco, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    protected int getType() {
        return 3;
    }

    @Override
    public View getShareElement() {
        return mViewHolder.itemView.findViewById(R.id.list_item_img_fresco);
    }

    @Override
    public Bitmap getThumbnail() {
        if (mViewHolder == null || mViewHolder.itemView == null) {
            return null;
        }
        if (mBitmapReference!=null && mBitmapReference.get()!=null) {
            // 替代原来的方法
            Bitmap bitmap = null;
            if (mBitmapReference.get() != null) {
                bitmap = ( mBitmapReference.get()).getUnderlyingBitmap();
            }
//            bitmap=getBitmapFromCache(Uri.parse("https://bpic.588ku.com/element_origin_min_pic/23/07/11/d32dabe266d10da8b21bd640a2e9b611.jpg!r650"));

           return bitmap;
        }


        return null;
    }

    // 获取Bitmap的替代方法
    private void getBitmapFromFresco(String imageUrl, SimpleDraweeView mSimpleDraweeView) {
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(imageUrl))
                .setRequestPriority(Priority.HIGH)
                .setPostprocessor(new BasePostprocessor() {
                    @Override
                    public void process(Bitmap bitmap) {
                        // 在这里处理获取到的bitmap
                        handleBitmap(bitmap);
                    }
                })
                .build();

        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(imageRequest)
                        .setOldController(mSimpleDraweeView.getController())
                        .build();

        mSimpleDraweeView.setController(controller);
    }

    // 处理获取到的Bitmap
    private void handleBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            // 在这里使用bitmap，例如创建副本
            Bitmap copiedBitmap = Bitmap.createBitmap(bitmap);
            // 进行后续操作...
        }
    }

    // 从缓存中获取Bitmap
    private Bitmap getBitmapFromCache(Uri uri) {
        ImagePipeline imagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
        DataSource<CloseableReference<CloseableImage>> dataSource =
                imagePipeline.fetchImageFromBitmapCache(Objects.requireNonNull(ImageRequest.fromUri(uri)), null);

        try {
            CloseableReference<CloseableImage> imageReference = dataSource.getResult();
            if (imageReference != null) {
                try {
                    CloseableImage image = imageReference.get();
                    if (image instanceof CloseableBitmap) {
                        return ((CloseableBitmap) image).getUnderlyingBitmap();
                    }
                } finally {
                    CloseableReference.closeSafely(imageReference);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dataSource.close();
        }
        return null;
    }
}
