package com.taobao.android.launcher.common;

import android.app.Activity;
import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface OnDemandReceiver {
    void onAppAttach(Context context);

    void onAppCreated(Context context);

    void onAppMain(Context context);

    void onAppPreCreated(Context context);

    void onAppSecurityGuard(Context context);

    void onBackground(Activity activity);

    void onBootFinished();

    void onColdLogin();

    void onFirstActivityCreated(Activity activity);

    void onFirstActivityDestroyed(Activity activity);

    void onFirstActivityStarted(Activity activity);

    void onFirstActivityStopped(Activity activity);

    void onForeground(Activity activity);

    void onIdle();

    void onLogin();

    void onLogout();

    void onSchemaWaked();

    void onSchemaWaked(Activity activity);

    void onSchemaWebWaked();
}
