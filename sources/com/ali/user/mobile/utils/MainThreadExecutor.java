package com.ali.user.mobile.utils;

import android.os.Handler;
import android.os.Looper;
import com.ali.user.mobile.log.TLogAdapter;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class MainThreadExecutor {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static void execute(Runnable runnable) {
        try {
            mHandler.post(runnable);
        } catch (Exception e) {
            TLogAdapter.e("login.MainThreadExecutor", "MainThreadExecutor.excute failed.", e);
            e.printStackTrace();
        }
    }

    public static void postDelayed(Runnable runnable, long j) {
        try {
            mHandler.postDelayed(runnable, j);
        } catch (Exception e) {
            TLogAdapter.e("login.MainThreadExecutor", "MainThreadExecutor.excute failed.", e);
            e.printStackTrace();
        }
    }
}
