package com.example.myandroidtestplat.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.example.myandroidtestplat.databinding.ActivitySmplesBinding

/**
 * @Description: 共享元素-过度效果
 * @Author: ext.zhgzhenzhong1
 * @CreateDate: 2025/8/11 17:21
 */
class ShareElementsActivity: BaseActivity() {

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
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}