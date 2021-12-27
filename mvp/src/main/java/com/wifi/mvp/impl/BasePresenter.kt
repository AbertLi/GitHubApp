package com.wifi.mvp.impl

import android.os.Bundle
import com.wifi.mvp.IMvpView
import com.wifi.mvp.IPresenter

abstract class BasePresenter<out V : IMvpView<BasePresenter<V>>> : IPresenter<V> {
    override lateinit var view: @UnsafeVariance V//有协变,需要注解告诉编译器，此处没有问题。

    override fun onCreate(saveInstanceState: Bundle?) = Unit
    override fun onSaveInstanceState(outState: Bundle) = Unit
    override fun onViewStateRestored(saveInstanceState: Bundle?) = Unit
    override fun onConfigurationChange(newState: Bundle) = Unit
    override fun onStart() = Unit
    override fun onResume() = Unit
    override fun onPause() = Unit
    override fun onStop() = Unit
    override fun onDestroy() = Unit
}