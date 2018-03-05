package com.sharptech.smart.smartbaselibrary.base.factory;


import com.sharptech.smart.smartbaselibrary.base.presenter.BasePresenter;
import com.sharptech.smart.smartbaselibrary.base.view.IBaseView;

/**
 * Created by sunzhibin on 2018/1/2.
 * Presenter工厂接口
 */

public interface IPresenterFactory<V extends IBaseView, P extends BasePresenter<V>> {
    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createPresenter();

}
