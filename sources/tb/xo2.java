package tb;

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
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.uplayer.AliMediaPlayer;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class xo2 extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final b Companion = new b(null);
    @Nullable
    private static WeakReference<Activity> d;
    @NotNull
    private final Toast a;
    @NotNull
    private final String b;
    private boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2018302424")) {
                ipChange.ipc$dispatch("2018302424", new Object[]{this, activity, bundle});
                return;
            }
            b41.i(activity, "activity");
            Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-258846677")) {
                ipChange.ipc$dispatch("-258846677", new Object[]{this, activity});
                return;
            }
            b41.i(activity, "activity");
            Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1412545124")) {
                ipChange.ipc$dispatch("-1412545124", new Object[]{this, activity});
                return;
            }
            b41.i(activity, "activity");
            try {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED);
                xo2.this.c();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1227727507")) {
                ipChange.ipc$dispatch("-1227727507", new Object[]{this, activity});
                return;
            }
            b41.i(activity, "activity");
            try {
                Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1616503599")) {
                ipChange.ipc$dispatch("1616503599", new Object[]{this, activity, bundle});
                return;
            }
            b41.i(activity, "activity");
            b41.i(bundle, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2041983485")) {
                ipChange.ipc$dispatch("-2041983485", new Object[]{this, activity});
                return;
            }
            b41.i(activity, "activity");
            b bVar = xo2.Companion;
            xo2.d = new WeakReference(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2044152375")) {
                ipChange.ipc$dispatch("2044152375", new Object[]{this, activity});
                return;
            }
            b41.i(activity, "activity");
            Log.e("ToastHelper", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED);
            if (activity == xo2.Companion.a()) {
                xo2.d = null;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
            this();
        }

        @Nullable
        public final Activity a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1512025589")) {
                return (Activity) ipChange.ipc$dispatch("1512025589", new Object[]{this});
            }
            if (xo2.d == null) {
                return null;
            }
            WeakReference weakReference = xo2.d;
            b41.f(weakReference);
            return (Activity) weakReference.get();
        }

        @NotNull
        public final WindowManager b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1096362984")) {
                return (WindowManager) ipChange.ipc$dispatch("-1096362984", new Object[]{this});
            }
            if (a() != null) {
                Activity a = a();
                b41.f(a);
                Object systemService = a.getSystemService(v.ATTACH_MODE_WINDOW);
                b41.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                return (WindowManager) systemService;
            }
            Object systemService2 = AppInfoProviderProxy.getApplication().getSystemService(v.ATTACH_MODE_WINDOW);
            b41.g(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
            return (WindowManager) systemService2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xo2(@NotNull Toast toast, @NotNull Application application) {
        super(Looper.getMainLooper());
        b41.i(toast, "mToast");
        b41.i(application, "application");
        this.a = toast;
        String packageName = application.getPackageName();
        b41.h(packageName, "application.packageName");
        this.b = packageName;
        application.registerActivityLifecycleCallbacks(new a());
    }

    public final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-629587041")) {
            ipChange.ipc$dispatch("-629587041", new Object[]{this});
            return;
        }
        removeMessages(0);
        if (this.c) {
            try {
                Companion.b().removeView(this.a.getView());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
            this.c = false;
        }
    }

    public final void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798716612")) {
            ipChange.ipc$dispatch("-798716612", new Object[]{this});
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
                Companion.b().addView(this.a.getView(), layoutParams);
                this.c = true;
                sendEmptyMessageDelayed(0, ((Long) (this.a.getDuration() == 1 ? 3500 : 2000L)).longValue());
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1126097595")) {
            ipChange.ipc$dispatch("-1126097595", new Object[]{this, message});
            return;
        }
        b41.i(message, "msg");
        c();
    }
}
