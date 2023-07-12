package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Messages;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;
import tb.ao0;
import tb.bo0;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FlutterBoost {
    public static final String APP_LIFECYCLE_CHANGED_KEY = "app_lifecycle_changed_key";
    public static final String ENGINE_ID = "flutter_boost_default_engine";
    public static final int FLUTTER_APP_STATE_PAUSED = 2;
    public static final int FLUTTER_APP_STATE_RESUMED = 0;
    public static final String LIFECYCLE_STATE = "lifecycleState";
    private Activity a;
    private C5775b b;
    private boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface Callback {
        void onStart(FlutterEngine flutterEngine);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.idlefish.flutterboost.FlutterBoost$a */
    /* loaded from: classes10.dex */
    public class C5770a implements Application.ActivityLifecycleCallbacks {
        private int a = 0;
        private boolean b = false;
        private boolean c;

        public C5770a(boolean z) {
            this.c = false;
            this.c = z;
        }

        private void a() {
            if (this.c) {
                return;
            }
            FlutterBoost.h().l(true);
            FlutterBoost.h().g().A();
        }

        private void b() {
            if (this.c) {
                return;
            }
            FlutterBoost.h().l(false);
            FlutterBoost.h().g().H();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            FlutterBoost.this.a = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (FlutterBoost.this.a == activity) {
                FlutterBoost.this.a = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            FlutterBoost.this.a = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i = this.a + 1;
            this.a = i;
            if (i != 1 || this.b) {
                return;
            }
            b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            boolean isChangingConfigurations = activity.isChangingConfigurations();
            this.b = isChangingConfigurations;
            int i = this.a - 1;
            this.a = i;
            if (i != 0 || isChangingConfigurations) {
                return;
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.idlefish.flutterboost.FlutterBoost$b */
    /* loaded from: classes10.dex */
    public static class C5771b {
        static final FlutterBoost a = new FlutterBoost(null);
    }

    /* synthetic */ FlutterBoost(C5774a c5774a) {
        this();
    }

    public static FlutterBoost h() {
        return C5771b.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Void r0) {
    }

    private void n(Application application, boolean z) {
        application.registerActivityLifecycleCallbacks(new C5770a(z));
    }

    public void d(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LIFECYCLE_STATE, Integer.valueOf(i));
        k(APP_LIFECYCLE_CHANGED_KEY, hashMap);
    }

    public Activity e() {
        return this.a;
    }

    public FlutterEngine f() {
        return FlutterEngineCache.getInstance().get(ENGINE_ID);
    }

    public C5775b g() {
        if (this.b == null) {
            FlutterEngine f = f();
            if (f != null) {
                this.b = bo0.d(f);
            } else {
                throw new RuntimeException("FlutterBoost might *not* have been initialized yet!!!");
            }
        }
        return this.b;
    }

    public void j(C5776c c5776c) {
        g().n().pushFlutterRoute(c5776c);
    }

    public void k(String str, Map<Object, Object> map) {
        Messages.C5772a c5772a = new Messages.C5772a();
        c5772a.h(str);
        c5772a.g(map);
        g().m().A(c5772a, new Messages.FlutterRouterApi.Reply() { // from class: tb.nn0
            @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
            public final void reply(Object obj) {
                FlutterBoost.i((Void) obj);
            }
        });
    }

    void l(boolean z) {
    }

    public void m(Application application, FlutterBoostDelegate flutterBoostDelegate, Callback callback, ao0 ao0Var) {
        if (ao0Var == null) {
            ao0Var = ao0.a();
        }
        this.c = ao0Var.f();
        FlutterEngine f = f();
        if (f == null) {
            if (ao0Var.c() != null) {
                f = ao0Var.c().provideFlutterEngine(application);
            }
            if (f == null) {
                f = new FlutterEngine(application, ao0Var.e());
            }
            FlutterEngineCache.getInstance().put(ENGINE_ID, f);
        }
        if (!f.getDartExecutor().isExecutingDart()) {
            f.getNavigationChannel().setInitialRoute(ao0Var.d());
            f.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), ao0Var.b()));
        }
        if (callback != null) {
            callback.onStart(f);
        }
        g().K(flutterBoostDelegate);
        n(application, this.c);
    }

    private FlutterBoost() {
        this.a = null;
        this.c = false;
    }
}
