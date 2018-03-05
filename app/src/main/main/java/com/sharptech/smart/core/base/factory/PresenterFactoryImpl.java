package com.sharptech.smart.core.base.factory;
import com.sharptech.smart.core.base.presenter.BasePresenter;
import com.sharptech.smart.core.base.view.IBaseView;

/**
 * Created by sunzhibin on 2018/1/2.
 *
 * @description Presenter工厂实现类
 */

public class PresenterFactoryImpl<V extends IBaseView, P extends BasePresenter<V>> implements IPresenterFactory<V, P> {
    /**
     * 需要创建的Presenter的类型
     */
    private final Class<P> mPresenterClass;

    public PresenterFactoryImpl(Class<P> mPresenterClass) {
        this.mPresenterClass = mPresenterClass;
    }

    /**
     * 根据注解创建Presenter的工厂实现类
     *
     * @param viewClazz 需要创建Presenter的V层实现类
     * @param <V>       当前View实现的接口类型
     * @param <P>       当前要创建的Presenter类型
     * @return 工厂类
     */
    public static <V extends IBaseView, P extends BasePresenter<V>> PresenterFactoryImpl<V, P> createFactory(Class<?> viewClazz) {
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if (annotation != null) {
            aClass = (Class<P>) annotation.value();
        }
        return aClass == null ? null : new PresenterFactoryImpl<>(aClass);
    }

    @Override
    public P createPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }
}
