package com.example.myandroidtestplat.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidtestplat.databinding.ActivitySmplesBinding

/**
 * @Description: 样例入口
 * @Author: ext.zhgzhenzhong1
 * @CreateDate: 2025/8/11 17:21
 */
open class BaseActivity: AppCompatActivity() {
    var mActivity:AppCompatActivity?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity=this
    }
}