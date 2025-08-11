package com.example.myandroidtestplat.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.example.myandroidtestplat.databinding.ActivitySmplesBinding
import com.example.myandroidtestplat.ui.shareelements.ui.list.ShareElementsListActivity

/**
 * @Description: 样例入口
 * @Author: ext.zhgzhenzhong1
 * @CreateDate: 2025/8/11 17:21
 */
class SmplesActivity: BaseActivity() {

    private var _binding:ActivitySmplesBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivitySmplesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.tvFlipimageview.setOnClickListener{
            startActivity(Intent(mActivity,
                FlipimageviewActivity::class.java))
        }
        binding.tvShareElement.setOnClickListener{
            startActivity(Intent(mActivity,
                ShareElementsListActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}