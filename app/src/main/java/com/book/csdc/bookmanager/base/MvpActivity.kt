package com.book.csdc.bookmanager.base

import android.os.Bundle

/**
 * Created by linxj on 2017/6/1.
 */

open class MvpActivity<P:BaseMvpPresenter<V>,V:IPresentView> : BaseActivity() {

    protected var mPresent:P? = null
    protected var mView:V? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMvpView()
        mPresent?.create(this,this.mView)
    }

     fun initMvpView(){
         val mvpHelper = MvpHelper<P, V>(this)
         mView = getViewInstance()
         mPresent = mvpHelper.getPresentClass()?.newInstance()
    }

    /**
     * 返回实现[V]的实例，默认是当前Activity

     * @return [V]的实例
     */
    protected fun getViewInstance(): V? {
        try {
            val vClass = MvpHelper<P, V>(this).getViewClass()
            if (vClass!!.isInstance(this)) {
                return this as V
            }
        } catch (e: Exception) {

        }
        return null
    }

    override fun onDestroy() {
        mPresent?.destory()
        mPresent = null
        mView = null
        super.onDestroy()
    }
}