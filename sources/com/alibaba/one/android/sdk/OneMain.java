package com.alibaba.one.android.sdk;

import android.app.Application;
import android.content.Context;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class OneMain {
    public static Context mContext;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface UpdateListener {
        void onUpdated(int i, int i2, String str);
    }

    public static void init(Application application, HashMap<String, Object> hashMap) {
    }

    private static native void initNative(Context context);

    public static void initialize(Context context) {
        mContext = context;
        initNative(context);
    }

    public static Object play(int i, int i2, int i3, Object obj) {
        try {
            if (mContext == null) {
                return null;
            }
            return playNative(i, i2, i3, obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static native Object playNative(int i, int i2, int i3, Object obj);
}
