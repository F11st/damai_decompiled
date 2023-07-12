package com.taobao.login4android.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ToastUtil {
    private static final String FIELD_NAME_HANDLER = "mHandler";
    private static final String FIELD_NAME_TN = "mTN";
    private static final String TAG = "ToastUtil";
    private static Toast mToast;
    private static Field sField_TN;
    private static Field sField_TN_Handler;
    private static boolean sIsHookFieldInit;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class ToastRunnable implements Runnable {
        private Context context;
        private int duration;
        private CharSequence text;

        public ToastRunnable(Context context, CharSequence charSequence, int i) {
            this.context = context;
            this.text = charSequence;
            this.duration = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = ToastUtil.mToast = Toast.makeText(this.context.getApplicationContext(), this.text, this.duration);
            ToastUtil.mToast.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        private Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                Log.e(ToastUtil.TAG, "Catch system toast exception:" + e);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler handler = this.a;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    private static void hookToast(Toast toast) {
        if (isNeedHook()) {
            try {
                if (!sIsHookFieldInit) {
                    Field declaredField = Toast.class.getDeclaredField(FIELD_NAME_TN);
                    sField_TN = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = sField_TN.getType().getDeclaredField(FIELD_NAME_HANDLER);
                    sField_TN_Handler = declaredField2;
                    declaredField2.setAccessible(true);
                    sIsHookFieldInit = true;
                }
                Object obj = sField_TN.get(toast);
                sField_TN_Handler.set(obj, new a((Handler) sField_TN_Handler.get(obj)));
            } catch (Exception e) {
                Log.e(TAG, "Hook toast exception=" + e);
            }
        }
    }

    private static boolean isNeedHook() {
        int i = Build.VERSION.SDK_INT;
        return i == 25 || i == 24;
    }

    public static void show(Toast toast) {
        if (toast == null) {
            return;
        }
        hookToast(toast);
        toast.show();
    }

    public static void showToast(Context context, CharSequence charSequence, int i) {
        ToastRunnable toastRunnable = new ToastRunnable(context, charSequence, i);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.runOnUiThread(toastRunnable);
            return;
        }
        new Handler(context.getMainLooper()).post(toastRunnable);
    }
}
