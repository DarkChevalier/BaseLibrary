package com.sharptech.smart.core.base.proxy;

import com.sharptech.smart.core.base.factory.IPresenterFactory;
import com.sharptech.smart.core.base.presenter.BasePresenter;
import com.sharptech.smart.core.base.view.IBaseView;

/**
 * Created by sunzhibin on 2018/1/2.
 */

public interface IPresenterProxyInterface<V extends IBaseView, P extends BasePresenter<V>> {
    /**
     * 设置创建Presenter的工厂
     *
     * @param presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(IPresenterFactory<V, P> presenterFactory);

    /**
     * 获取Presenter的工厂类
     *
     * @return 返回PresenterMvpFactory类型
     */
    IPresenterFactory<V, P> getPresenterFactory();


    /**
     * 获取创建的Presenter
     *
     * @return 指定类型的Presenter
     */
    P getPresenter();

}
