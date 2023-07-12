package com.youku.live.dago.liveplayback;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ToastUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String FIELD_NAME_HANDLER = "mHandler";
    private static final String FIELD_NAME_TN = "mTN";
    private static final String TAG = "ToastUtil";
    private static Toast mToast;
    private static Field sField_TN;
    private static Field sField_TN_Handler;
    private static boolean sIsHookFieldInit;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class SafelyHandlerWarpper extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private Handler originHandler;

        public SafelyHandlerWarpper(Handler handler) {
            this.originHandler = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1156649830")) {
                ipChange.ipc$dispatch("1156649830", new Object[]{this, message});
                return;
            }
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                Log.e(ToastUtil.TAG, "Catch system toast exception:" + e);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1043032236")) {
                ipChange.ipc$dispatch("-1043032236", new Object[]{this, message});
                return;
            }
            Handler handler = this.originHandler;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ToastRunnable implements Runnable {
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

    public static void cancelToast() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-920795028")) {
            ipChange.ipc$dispatch("-920795028", new Object[0]);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper.getThread() == Thread.currentThread()) {
            mToast.cancel();
        } else {
            new Handler(mainLooper).post(new Runnable() { // from class: com.youku.live.dago.liveplayback.ToastUtil.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1258324225")) {
                        ipChange2.ipc$dispatch("1258324225", new Object[]{this});
                    } else {
                        ToastUtil.mToast.cancel();
                    }
                }
            });
        }
    }

    private static void hookToast(Toast toast) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566104360")) {
            ipChange.ipc$dispatch("566104360", new Object[]{toast});
        } else if (isNeedHook()) {
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
                sField_TN_Handler.set(obj, new SafelyHandlerWarpper((Handler) sField_TN_Handler.get(obj)));
            } catch (Exception e) {
                Log.e(TAG, "Hook toast exception=" + e);
            }
        }
    }

    private static boolean isNeedHook() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058441746")) {
            return ((Boolean) ipChange.ipc$dispatch("1058441746", new Object[0])).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        return i == 25 || i == 24;
    }

    public static void printStack() {
        StackTraceElement[] stackTraceElementArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792614570")) {
            ipChange.ipc$dispatch("-792614570", new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null || (stackTraceElementArr = allStackTraces.get(Thread.currentThread())) == null) {
            return;
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement.toString().contains("printStack") || sb.toString().contains("printStack")) {
                sb.append(stackTraceElement.toString() + StringUtils.LF);
            }
        }
        String[] split = sb.toString().split(StringUtils.LF);
        if (split != null && split.length > 1) {
            String str = split[1];
        }
        new HashMap(16).put("exception", sb.toString());
    }

    public static void show(Toast toast) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2102223673")) {
            ipChange.ipc$dispatch("-2102223673", new Object[]{toast});
        } else if (toast == null) {
        } else {
            hookToast(toast);
            toast.show();
        }
    }

    public static void showToast(Context context, CharSequence charSequence, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1590761798")) {
            ipChange.ipc$dispatch("1590761798", new Object[]{context, charSequence, Integer.valueOf(i)});
            return;
        }
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

    public static void showToast(Context context, CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026896035")) {
            ipChange.ipc$dispatch("-2026896035", new Object[]{context, charSequence});
        } else {
            showToast(context, charSequence, 0);
        }
    }
}
