package com.youku.live.livesdk;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.utils.ConfigUtil;
import com.youku.live.livesdk.wkit.utils.PipBroadcastReceiver;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LiveActivityLifecycleCallbackWrapper implements Application.ActivityLifecycleCallbacks {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String U_JEWEL_EXCHARGE_PROTOCAL = "https://terms.alicdn.com/legal-agreement/terms/suit_bu1_unification/suit_bu1_unification202009151951_32970.html";
    private static final String U_JEWEL_SERVICE_PROTOCAL = "https://terms.alicdn.com/legal-agreement/terms/suit_bu1_unification/suit_bu1_unification202004212318_56737.html?hideRightMenu=1";
    private Activity mH5Activity = null;
    private boolean isInPipJumpApp = false;
    private boolean isInPipJumpH5 = false;
    private Activity mActivityInPipJumpApp = null;
    private String mOldCreateActivity = "";
    private boolean isPaused = false;
    private boolean isSaveInstance = false;
    private Handler mHandler = null;
    private InnerRunnable mRunnable = null;
    private final String CLASS_OF_WEB_ACTIVITY = "com.youku.ui.activity.WVWebViewActivity";
    private final String CLASS_OF_WX_ACTIVITY = "com.youku.weex.WXPageActivity";
    private final String CLASS_OF_MINI_APP_ACTIVITY = "com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class InnerRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        WeakReference<Activity> weakReference;
        WeakReference<LiveActivityLifecycleCallbackWrapper> weakReferenceLifecycle;

        public InnerRunnable(Activity activity, LiveActivityLifecycleCallbackWrapper liveActivityLifecycleCallbackWrapper) {
            this.weakReference = null;
            this.weakReferenceLifecycle = null;
            this.weakReference = new WeakReference<>(activity);
            this.weakReferenceLifecycle = new WeakReference<>(liveActivityLifecycleCallbackWrapper);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<LiveActivityLifecycleCallbackWrapper> weakReference;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "26127108")) {
                ipChange.ipc$dispatch("26127108", new Object[]{this});
                return;
            }
            WeakReference<Activity> weakReference2 = this.weakReference;
            if (weakReference2 == null || weakReference2.get() == null || (weakReference = this.weakReferenceLifecycle) == null || weakReference.get() == null) {
                return;
            }
            if (this.weakReferenceLifecycle.get().getH5Activity() != null && !this.weakReferenceLifecycle.get().getH5Activity().isFinishing()) {
                this.weakReferenceLifecycle.get().getH5Activity().finish();
                this.weakReferenceLifecycle.get().releaseH5Activity();
            }
            Log.d("fornia", "pip live Lifecycle InnerRunnable 发送广播PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST");
            LocalBroadcastManager.getInstance(this.weakReference.get().getApplicationContext()).sendBroadcast(new Intent(PipBroadcastReceiver.PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST));
        }
    }

    public Activity getH5Activity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-340769668") ? (Activity) ipChange.ipc$dispatch("-340769668", new Object[]{this}) : this.mH5Activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278755682")) {
            ipChange.ipc$dispatch("-278755682", new Object[]{this, activity, bundle});
            return;
        }
        Log.d("fornia", "pip live Lifecycle onActivityCreated:" + activity.toString() + " onActivityCreated:" + this.mOldCreateActivity);
        if (activity.toString().contains("com.youku.ui.activity.WVWebViewActivity") || activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") || activity.toString().contains("com.youku.weex.WXPageActivity")) {
            Log.d("fornia", "pip live Lifecycle onActivityCreated:" + activity.toString() + " onActivityCreated:" + this.mOldCreateActivity);
            if (activity.toString().equals(this.mOldCreateActivity)) {
                return;
            }
            this.mH5Activity = activity;
            this.mOldCreateActivity = activity.toString();
            if (activity.getIntent() != null) {
                Log.d("fornia", "pip live Lifecycle onActivityCreated:" + activity + " intent:" + activity.getIntent().getDataString());
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1288251045")) {
            ipChange.ipc$dispatch("1288251045", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            if ((activity.toString().contains("com.youku.ui.activity.WVWebViewActivity") || activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") || activity.toString().contains("com.youku.weex.WXPageActivity")) && activity.toString().equals(this.mOldCreateActivity)) {
                Log.d("fornia", "pip live Lifecycle onActivityDestroyed:" + activity.toString() + " mOldDestroyActivity:" + this.mOldCreateActivity);
                if (this.isPaused && !this.isSaveInstance && activity.getIntent() != null && activity.getIntent().getDataString() != null) {
                    Log.d("fornia", "pip live Lifecycle onActivityDestroyed:" + activity + " intent:" + activity.getIntent().getDataString());
                    String dataString = activity.getIntent().getDataString();
                    if (dataString != null && (dataString.contains("bizfrom") || dataString.contains(PipBroadcastReceiver.SOURCE_KEY))) {
                        Log.d("fornia", "pip live Lifecycle onActivityDestroyed 发送广播PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST");
                        LocalBroadcastManager.getInstance(activity.getApplicationContext()).sendBroadcast(new Intent(PipBroadcastReceiver.PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST));
                    }
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeCallbacks(this.mRunnable);
                    this.mRunnable = null;
                    this.mHandler = null;
                }
                this.mRunnable = null;
                this.mH5Activity = null;
                this.mOldCreateActivity = "";
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344901474")) {
            ipChange.ipc$dispatch("1344901474", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            if (!activity.toString().contains("com.youku.ui.activity.WVWebViewActivity") && !activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") && !activity.toString().contains("com.youku.weex.WXPageActivity")) {
                if ((activity instanceof LiveActivity) && ((LiveActivity) activity).getPipType() == 3) {
                    Log.d("fornia", "pip live Lifecycle 跳转手淘 进入小窗 onActivityPaused:" + activity.toString());
                    this.isInPipJumpApp = true;
                    return;
                }
                return;
            }
            Log.d("fornia", "pip live Lifecycle onActivityPaused:" + activity.toString() + " mOldDestroyActivity:" + this.mOldCreateActivity);
            if (activity.toString().equals(this.mOldCreateActivity)) {
                this.isPaused = true;
                if (activity.getIntent() != null && activity.getIntent().getDataString() != null) {
                    Log.d("fornia", "pip live Lifecycle onActivityPaused:" + activity + " intent:" + activity.getIntent().getDataString() + " mHandler:" + this.mHandler);
                    String dataString = activity.getIntent().getDataString();
                    if (dataString != null && dataString.contains("bizfrom") && this.mHandler == null) {
                        this.mRunnable = new InnerRunnable(activity, this);
                        Handler handler = new Handler(activity.getMainLooper());
                        this.mHandler = handler;
                        handler.postDelayed(this.mRunnable, 6000L);
                    }
                } else if (activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") && ConfigUtil.isPipMiniAppOnPauseFinishing() && activity.isFinishing()) {
                    LocalBroadcastManager.getInstance(activity.getApplicationContext()).sendBroadcast(new Intent(PipBroadcastReceiver.MINI_APP_ONPAUSE_FINISHING));
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Activity activity2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646228889")) {
            ipChange.ipc$dispatch("-1646228889", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            if (this.isInPipJumpApp) {
                if (activity instanceof LiveActivity) {
                    return;
                }
                if (this.mActivityInPipJumpApp == null) {
                    this.mActivityInPipJumpApp = activity;
                    Log.d("fornia", "pip live Lifecycle 手淘页面打开 记录底部activity ActivityResumed:" + activity.toString());
                    return;
                }
                Log.d("fornia", "pip live Lifecycle 手淘页面关闭 返回直播间 onActivityResumed:" + activity.toString());
                LocalBroadcastManager.getInstance(activity.getApplicationContext()).sendBroadcast(new Intent(PipBroadcastReceiver.PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST));
                this.mActivityInPipJumpApp = null;
                this.isInPipJumpApp = false;
            } else if (!activity.toString().contains("com.youku.ui.activity.WVWebViewActivity") && !activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") && !activity.toString().contains("com.youku.weex.WXPageActivity")) {
                if (!(activity instanceof LiveActivity) || ((LiveActivity) activity).isInPipMode() || (activity2 = this.mH5Activity) == null || activity2.isFinishing()) {
                    return;
                }
                Log.d("fornia", "pip live Lifecycle onActivityResumed 销毁h5！");
                if ((this.mH5Activity.getIntent() == null || this.mH5Activity.getIntent().getData() == null || !(U_JEWEL_EXCHARGE_PROTOCAL.equals(this.mH5Activity.getIntent().getData().toString()) || U_JEWEL_SERVICE_PROTOCAL.equals(this.mH5Activity.getIntent().getData().toString()))) && !this.mH5Activity.toString().contains("com.youku.weex.WXPageActivity")) {
                    this.mH5Activity.finish();
                    this.mH5Activity = null;
                }
            } else {
                Log.d("fornia", "pip live Lifecycle onActivityResumed:" + activity.toString() + " onActivityCreated:" + this.mOldCreateActivity);
                this.isSaveInstance = false;
                if (activity.toString().equals(this.mOldCreateActivity) && this.isPaused) {
                    this.isPaused = false;
                    if (this.mHandler != null) {
                        Log.d("fornia", "pip live Lifecycle onActivityResumed 移除了广播事件 不是销毁！");
                        this.mHandler.removeCallbacks(this.mRunnable);
                        this.mRunnable = null;
                        this.mHandler = null;
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842687883")) {
            ipChange.ipc$dispatch("-1842687883", new Object[]{this, activity, bundle});
        } else if (activity == null) {
        } else {
            if (activity.toString().contains("com.youku.ui.activity.WVWebViewActivity") || activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") || activity.toString().contains("com.youku.weex.WXPageActivity")) {
                Log.d("fornia", "pip live Lifecycle onActivitySaveInstanceState:" + activity.toString() + " onActivityCreated:" + this.mOldCreateActivity);
                if (activity.toString().equals(this.mOldCreateActivity)) {
                    this.isSaveInstance = true;
                    if (this.isPaused) {
                        this.isPaused = false;
                        if (this.mHandler != null) {
                            Log.d("fornia", "pip live Lifecycle onActivitySaveInstanceState 移除了广播事件 不是销毁！");
                            this.mHandler.removeCallbacks(this.mRunnable);
                            this.mRunnable = null;
                            this.mHandler = null;
                        }
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834482429")) {
            ipChange.ipc$dispatch("1834482429", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            if (activity.toString().contains("com.youku.ui.activity.WVWebViewActivity") || activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") || activity.toString().contains("com.youku.weex.WXPageActivity")) {
                Log.d("fornia", "pip live Lifecycle onActivityStarted:" + activity.toString() + " onActivityCreated:" + this.mOldCreateActivity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625650993")) {
            ipChange.ipc$dispatch("1625650993", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            if (activity.toString().contains("com.youku.ui.activity.WVWebViewActivity") || activity.toString().contains("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity") || activity.toString().contains("com.youku.weex.WXPageActivity")) {
                Log.d("fornia", "pip live Lifecycle onActivityStopped:" + activity.toString() + " mOldCreateActivity:" + this.mOldCreateActivity);
            }
        }
    }

    public void releaseH5Activity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410848283")) {
            ipChange.ipc$dispatch("410848283", new Object[]{this});
        } else {
            this.mH5Activity = null;
        }
    }
}
