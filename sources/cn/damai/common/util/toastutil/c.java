package cn.damai.common.util.toastutil;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.tlog.protocol.Constants;
import com.youku.uplayer.AliMediaPlayer;
import tb.k3;
import tb.mu0;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public final class c extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Toast a;
    private final String b;
    private boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "475793183")) {
                ipChange.ipc$dispatch("475793183", new Object[]{this, activity, bundle});
            } else {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1854558204")) {
                ipChange.ipc$dispatch("-1854558204", new Object[]{this, activity});
            } else {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "268278883")) {
                ipChange.ipc$dispatch("268278883", new Object[]{this, activity});
                return;
            }
            try {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED);
                c.this.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-661790842")) {
                ipChange.ipc$dispatch("-661790842", new Object[]{this, activity});
                return;
            }
            try {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-58563658")) {
                ipChange.ipc$dispatch("-58563658", new Object[]{this, activity, bundle});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1476046820")) {
                ipChange.ipc$dispatch("-1476046820", new Object[]{this, activity});
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1684878256")) {
                ipChange.ipc$dispatch("-1684878256", new Object[]{this, activity});
            } else {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Toast toast, Application application) {
        super(Looper.getMainLooper());
        this.a = toast;
        this.b = application.getPackageName();
        mu0.a().registerActivityLifecycleCallbacks(new a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "342457382")) {
            ipChange.ipc$dispatch("342457382", new Object[]{this});
            return;
        }
        removeMessages(0);
        if (this.c) {
            try {
                ((WindowManager) k3.b().c().getSystemService(v.ATTACH_MODE_WINDOW)).removeView(this.a.getView());
            } catch (IllegalArgumentException | NullPointerException unused) {
            }
            this.c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2017934211")) {
            ipChange.ipc$dispatch("2017934211", new Object[]{this});
        } else if (this.c) {
        } else {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            layoutParams.setTitle("Toast");
            layoutParams.flags = AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR;
            layoutParams.packageName = this.b;
            layoutParams.gravity = this.a.getGravity();
            layoutParams.x = this.a.getXOffset();
            layoutParams.y = this.a.getYOffset();
            try {
                ((WindowManager) k3.b().c().getSystemService(v.ATTACH_MODE_WINDOW)).addView(this.a.getView(), layoutParams);
                this.c = true;
                sendEmptyMessageDelayed(0, this.a.getDuration() == 1 ? 3500L : 2000L);
            } catch (WindowManager.BadTokenException | IllegalStateException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067216290")) {
            ipChange.ipc$dispatch("-2067216290", new Object[]{this, message});
        } else {
            a();
        }
    }
}
