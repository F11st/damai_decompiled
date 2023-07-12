package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
@TargetApi(14)
/* loaded from: classes11.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private Set<String> a = new HashSet();

    private static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        eo a;
        String packageName;
        String m858a;
        int i;
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (TextUtils.isEmpty(stringExtra) || intExtra <= 0 || this.a.contains(stringExtra)) {
            return;
        }
        this.a.add(stringExtra);
        if (intExtra == 3000) {
            a = eo.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            m858a = en.m858a(intExtra);
            i = 3008;
        } else if (intExtra != 1000) {
            return;
        } else {
            a = eo.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            m858a = en.m858a(intExtra);
            i = 1008;
        }
        a.a(packageName, m858a, stringExtra, i, null);
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
