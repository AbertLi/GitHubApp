package com.wifi.githubapp.ui.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wifi.githubapp.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initView()
    }

    private fun initView(){

    }
}