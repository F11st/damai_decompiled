package com.ali.user.mobile.app.dataprovider;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DataProviderFactory {
    private static Context applicationContext;
    private static IDataProvider dataProvider;
    private static OrangeConfig orangeConfig;

    public static synchronized Context getApplicationContext() {
        synchronized (DataProviderFactory.class) {
            Context context = applicationContext;
            if (context != null) {
                return context;
            }
            IDataProvider iDataProvider = dataProvider;
            if (iDataProvider != null) {
                applicationContext = iDataProvider.getContext();
            } else {
                applicationContext = getSystemApp();
            }
            return applicationContext;
        }
    }

    public static IDataProvider getDataProvider() {
        IDataProvider iDataProvider = dataProvider;
        return iDataProvider == null ? new DataProvider() : iDataProvider;
    }

    public static OrangeConfig getOrangeConfig() {
        if (orangeConfig == null) {
            orangeConfig = new OrangeConfig();
        }
        return orangeConfig;
    }

    private static Application getSystemApp() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setDataProvider(IDataProvider iDataProvider) {
        dataProvider = iDataProvider;
    }

    public static void setOrangeConfig(OrangeConfig orangeConfig2) {
        orangeConfig = orangeConfig2;
    }
}
