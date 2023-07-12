package com.ali.user.mobile.service;

import android.text.TextUtils;
import com.ali.user.mobile.config.BeanConfig;
import com.ali.user.mobile.log.TLogAdapter;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ServiceFactory {
    private static final String TAG = "BeanLoader";

    private ServiceFactory() {
    }

    private static String getBeanClassName(String str) {
        try {
            return (String) BeanConfig.class.getMethod("getBeanClassName", String.class).invoke(BeanConfig.class.getConstructor(new Class[0]).newInstance(new Object[0]), str);
        } catch (ClassNotFoundException e) {
            TLogAdapter.d(TAG, e.getMessage());
            return "";
        } catch (InvocationTargetException e2) {
            TLogAdapter.d(TAG, e2.getMessage());
            return "";
        } catch (Exception e3) {
            TLogAdapter.d(TAG, e3.getMessage());
            return "";
        }
    }

    public static <T> T getService(Class<T> cls) {
        registerService(cls);
        return (T) ServiceContainer.getInstance().getService(cls);
    }

    public static boolean registerService(Class<?> cls) {
        Class cls2;
        Object newInstance;
        if (cls == null) {
            return false;
        }
        try {
            if (ServiceContainer.getInstance().getService(cls) != null) {
                return true;
            }
            String beanClassName = getBeanClassName(cls.getName());
            if (TextUtils.isEmpty(beanClassName)) {
                return false;
            }
            try {
                newInstance = Class.forName(beanClassName).getField("INSTANCE").get(null);
            } catch (NoSuchFieldException unused) {
                newInstance = cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            if (newInstance != null) {
                return ServiceContainer.getInstance().registerService(cls, newInstance);
            }
            return false;
        } catch (ClassNotFoundException e) {
            TLogAdapter.e(TAG, e.getMessage());
            return false;
        } catch (InvocationTargetException e2) {
            TLogAdapter.e(TAG, e2.getMessage());
            return false;
        } catch (Exception e3) {
            TLogAdapter.e(TAG, e3.getMessage());
            return false;
        }
    }
}
