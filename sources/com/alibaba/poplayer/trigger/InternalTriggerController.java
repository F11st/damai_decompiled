package com.alibaba.poplayer.trigger;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.layermanager.e;
import com.alibaba.poplayer.utils.Monitor;
import java.lang.ref.WeakReference;
import tb.d7;
import tb.dt1;
import tb.fw2;
import tb.gq1;

/* compiled from: Taobao */
@Monitor.TargetClass
/* loaded from: classes8.dex */
public class InternalTriggerController implements Application.ActivityLifecycleCallbacks {
    @Monitor.TargetField(name = "page")
    private WeakReference<Activity> a;
    private boolean b = false;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private static class FragmentSwitchBroadcastReceiver extends BroadcastReceiver {
        private InternalTriggerController a;

        public FragmentSwitchBroadcastReceiver(InternalTriggerController internalTriggerController) {
            this.a = internalTriggerController;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra(PopLayer.EXTRA_KEY_FRAGMENT_NAME);
                String stringExtra2 = intent.getStringExtra(PopLayer.EXTRA_KEY_FRAGMENT_PARAM);
                boolean booleanExtra = intent.getBooleanExtra(PopLayer.EXTRA_KEY_FRAGMENT_NEED_ACTIVITY_PARAM, false);
                if (TextUtils.isEmpty(stringExtra)) {
                    dt1.b("FragmentSwitchBroadcastReceiver.onReceive?fragmentName is empty", new Object[0]);
                    return;
                }
                this.a.g(stringExtra, stringExtra2, booleanExtra);
                dt1.b("FragmentSwitchBroadcastReceiver.onReceive?fragmentName=%s,param=%s,needAcParam=%s", stringExtra, stringExtra2, Boolean.valueOf(booleanExtra));
            } catch (Throwable th) {
                dt1.c("FragmentSwitchBroadcastReceiver.onReceive.fail", th);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private class InternalBroadcastReceiver extends BroadcastReceiver {
        public InternalBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("event");
                String stringExtra2 = intent.getStringExtra("param");
                String stringExtra3 = intent.getStringExtra(PopLayer.EXTRA_KEY_EXTRA_PARAMS);
                dt1.b("InternalBroadcastReceiver.onReceive?uri=%s&param=%s", stringExtra, stringExtra2);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (InternalTriggerController.this.c() == null) {
                    dt1.b("InternalBroadcastReceiver.onReceive curActivity is empty.", new Object[0]);
                } else if (stringExtra.startsWith(d7.APP_SCHEME)) {
                    d7.A().x(stringExtra, stringExtra2);
                } else if (stringExtra.startsWith(gq1.PAGE_SCHEME)) {
                    gq1.A().x(stringExtra, stringExtra2);
                } else if (stringExtra.startsWith(com.alibaba.poplayer.trigger.view.d.VIEW_SCHEME)) {
                    com.alibaba.poplayer.trigger.view.d.M().C(stringExtra, stringExtra2);
                } else {
                    if (!TextUtils.isEmpty(stringExtra3) && stringExtra3.contains("clean")) {
                        d7.A().n(InternalTriggerController.this.c(), InternalTriggerController.b(InternalTriggerController.this.c()));
                        gq1.A().n(InternalTriggerController.this.c(), InternalTriggerController.b(InternalTriggerController.this.c()));
                        com.alibaba.poplayer.trigger.view.d.M().n(InternalTriggerController.this.c(), InternalTriggerController.b(InternalTriggerController.this.c()));
                    }
                    d7.A().x(stringExtra, stringExtra2);
                    gq1.A().x(stringExtra, stringExtra2);
                    com.alibaba.poplayer.trigger.view.d.M().C(stringExtra, stringExtra2);
                }
            } catch (Throwable th) {
                dt1.c("InternalBroadcastReceiver.onReceive.fail", th);
            }
        }
    }

    public InternalTriggerController(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        LocalBroadcastManager.getInstance(application).registerReceiver(new InternalBroadcastReceiver(), new IntentFilter(PopLayer.ACTION_POP));
        LocalBroadcastManager.getInstance(application).registerReceiver(new FragmentSwitchBroadcastReceiver(this), new IntentFilter(PopLayer.ACTION_FRAGMENT_SWITCH));
    }

    public static View a(Activity activity) {
        if (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) {
            activity = activity.getParent();
        }
        return activity.getWindow().findViewById(16908290);
    }

    public static String b(Activity activity) {
        if (activity == null) {
            return "";
        }
        String obj = activity.toString();
        return (e.i && activity.isChild() && (activity.getParent() instanceof Activity)) ? activity.getParent().toString() : obj;
    }

    private boolean d(Activity activity) {
        return ((PopLayer.PopupAllowedFromFragment) activity.getClass().getAnnotation(PopLayer.PopupAllowedFromFragment.class)) != null;
    }

    private boolean e(Activity activity) {
        PopLayer.PopupOnlyManually popupOnlyManually = (PopLayer.PopupOnlyManually) activity.getClass().getAnnotation(PopLayer.PopupOnlyManually.class);
        boolean isMunualPopPageContains = PopLayer.getReference().isMunualPopPageContains(activity.getClass().getName());
        dt1.b("EventManager.isManaulPopup?contains=%s&popupOnlyManually=%s", Boolean.valueOf(isMunualPopPageContains), popupOnlyManually);
        return isMunualPopPageContains || popupOnlyManually != null;
    }

    private void f(Activity activity, String str, String str2, boolean z) {
        String name;
        try {
            if (activity == null) {
                dt1.b("EventManager.onActivityOrInnerViewResumed.activity is null", new Object[0]);
                return;
            }
            boolean z2 = !TextUtils.isEmpty(str);
            if (z2 && !d(activity)) {
                dt1.b("EventManager.onActivityOrFragmentResumed.isAllowedPopupFromFragmentNotice=false", new Object[0]);
                return;
            }
            boolean e = e(activity);
            Activity activity2 = (Activity) fw2.c(this.a);
            if (PopLayer.getReference().isSamePage(activity, activity2) && !z2) {
                if (e) {
                    return;
                }
                d7.A().o();
                gq1.A().o();
                com.alibaba.poplayer.trigger.view.d.M().o();
            } else if (PopLayer.getReference().isValidActivity(activity)) {
                if (activity2 != null) {
                    gq1.A().n(activity2, b(activity2));
                    com.alibaba.poplayer.trigger.view.d.M().n(activity2, b(activity2));
                    d7.A().n(activity2, b(activity2));
                }
                this.a = new WeakReference<>(activity);
                if (z2) {
                    name = activity.getClass().getName() + "." + str;
                } else {
                    name = activity.getClass().getName();
                }
                if (z && TextUtils.isEmpty(str2)) {
                    str2 = PopLayer.getReference().getActivityInfo(activity);
                }
                PopLayer.getReference().internalNotifyNativeUrlChanged(str2);
                String b = b(activity);
                e.f().k(activity, b);
                d7.A().u(activity, name, str2, b);
                gq1.A().u(activity, name, str2, b);
                com.alibaba.poplayer.trigger.view.d.M().u(activity, name, str2, b);
                if (e) {
                    return;
                }
                d7.A().D();
                gq1.A().B();
                com.alibaba.poplayer.trigger.view.d.M().O();
                dt1.b("EventManager.onActivityOrFragmentResumed.posttoService{uri:%s,param:%s}", name, str2);
            }
        } catch (Throwable th) {
            dt1.c("EventManager.onActivityOrInnerViewResumed.fail.", th);
        }
    }

    public Activity c() {
        return (Activity) fw2.c(this.a);
    }

    void g(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            f((Activity) fw2.c(this.a), str, str2, z);
        } catch (Throwable th) {
            dt1.c("EventManager.onFragmentResumed.fail.", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            dt1.b("EventManager.onActivityCreated.activity{%s}.withParam{%s}", activity.getClass().getName(), activity.getIntent() == null ? null : activity.getIntent().getDataString());
        } catch (Throwable th) {
            dt1.c("EventManager.onActivityCreated.error", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity == null) {
            return;
        }
        gq1.A().y(b(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            dt1.b("EventManager.onActivityPaused.activity{%s}", activity.getClass().getName());
            d7.A().s();
            gq1.A().s();
            com.alibaba.poplayer.trigger.view.d.M().s();
            com.alibaba.poplayer.trigger.view.d.M().l(activity);
            gq1.A().l(activity);
            d7.A().l(activity);
        } catch (Throwable th) {
            dt1.c("EventManager.onActivityPaused.removeWebView.error.", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            f(activity, null, null, true);
            com.alibaba.poplayer.trigger.view.d.M().m(activity);
            gq1.A().m(activity);
            d7.A().m(activity);
            if (this.b) {
                return;
            }
            PopLayer.getReference().onCurActivityInited();
            this.b = true;
        } catch (Throwable th) {
            dt1.c("onActivityResumed error", th);
        }
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
