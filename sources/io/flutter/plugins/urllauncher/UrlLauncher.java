package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class UrlLauncher {
    @Nullable
    private Activity activity;
    private final Context applicationContext;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    enum LaunchStatus {
        OK,
        NO_ACTIVITY,
        ACTIVITY_NOT_FOUND
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UrlLauncher(Context context, @Nullable Activity activity) {
        this.applicationContext = context;
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canLaunch(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        ComponentName resolveActivity = intent.resolveActivity(this.applicationContext.getPackageManager());
        return (resolveActivity == null || "{com.android.fallback/com.android.fallback.Fallback}".equals(resolveActivity.toShortString())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeWebView() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaunchStatus launch(String str, Bundle bundle, boolean z, boolean z2, boolean z3) {
        Intent putExtra;
        Activity activity = this.activity;
        if (activity == null) {
            return LaunchStatus.NO_ACTIVITY;
        }
        if (z) {
            putExtra = WebViewActivity.createIntent(activity, str, z2, z3, bundle);
        } else {
            putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", bundle);
        }
        try {
            this.activity.startActivity(putExtra);
            return LaunchStatus.OK;
        } catch (ActivityNotFoundException unused) {
            return LaunchStatus.ACTIVITY_NOT_FOUND;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActivity(@Nullable Activity activity) {
        this.activity = activity;
    }
}
