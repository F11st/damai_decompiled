package com.taobao.android.service;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import com.taobao.android.modular.IAidlServiceBridge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;
import tb.rc1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Services {
    private static final Map<Activity, List<ServiceConnection>> a;
    private static final Map<Activity, List<IBinder>> b;
    private static ClassLoader c;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.service.Services$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    final class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Services.b(activity);
            Services.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.service.Services$2  reason: invalid class name */
    /* loaded from: classes12.dex */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Intent val$intent;

        AnonymousClass2(Context context, Intent intent) {
            this.val$context = context;
            this.val$intent = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.val$context;
            Toast.makeText(context, "Using mismatched service " + this.val$intent.getAction() + "\nSee logcat for details (TAG:Services" + jn1.BRACKET_END_STR, 1).show();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class InvocationOnMainThreadException extends RuntimeException {
        private static final long serialVersionUID = -2830620447552102268L;
    }

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        a = new HashMap();
        b = new HashMap();
        new ComponentName("", "");
    }

    static void a(Activity activity) {
        List<IBinder> remove = b.remove(activity);
        if (remove == null || remove.isEmpty()) {
            return;
        }
        for (IBinder iBinder : remove) {
            IBinder a2 = AidlBridgeService.a(activity);
            if (a2 != null) {
                try {
                    Log.d("Services", "cleanupBridgeBinderOnActivityDestroyed :" + a2.toString());
                    IAidlServiceBridge.Stub.asInterface(a2).unbindService(iBinder);
                } catch (Exception e) {
                    rc1.d("Services", "Failed to unbind bridge binder: " + a2, e);
                }
            }
        }
    }

    static void b(Activity activity) {
        List<ServiceConnection> remove = a.remove(activity);
        if (remove == null || remove.isEmpty()) {
            return;
        }
        for (ServiceConnection serviceConnection : remove) {
            try {
                d(activity, serviceConnection);
            } catch (RuntimeException e) {
                rc1.d("Services", "Failed to unbind service: " + serviceConnection, e);
            }
        }
    }

    public static ClassLoader c() {
        return c;
    }

    public static void d(Context context, ServiceConnection serviceConnection) {
        if (LocalAidlServices.h(context, serviceConnection)) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException unused) {
            Log.d("Services", "Already unbound: " + serviceConnection.toString());
        }
    }
}
