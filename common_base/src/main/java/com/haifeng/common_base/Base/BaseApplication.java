package com.haifeng.common_base.Base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.haifeng.common_base.BuildConfig;
import com.haifeng.common_base.manager.ActivityMananger;

/**
 * 创建人：Liuhaifeng
 * 时间：2020/1/6
 * 描述：
 */
public class BaseApplication extends Application {

    private static BaseApplication application;

    private ActivityMananger manager;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        manager = new ActivityMananger();
        initARouter();
    }

    public static BaseApplication getApplication() {
        return application;
    }

    /**
     * 初始化路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();  // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application);// 尽可能早，推荐在Application中初始化
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        exitApp();
    }


    public void exitApp() {
        if (manager == null) {
            manager = new ActivityMananger();
        }
        manager.finishall();

        System.exit(0);

    }
}
