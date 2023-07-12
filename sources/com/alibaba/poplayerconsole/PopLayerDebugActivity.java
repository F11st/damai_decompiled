package com.alibaba.poplayerconsole;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import org.apache.commons.lang3.StringUtils;
import tb.dt1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopLayerDebugActivity extends Activity {
    private static boolean b;
    private TextView a;

    public static boolean a() {
        return b;
    }

    private void b() {
        StandOutWindow.e(getApplicationContext(), PopLayerConsole.class);
        StandOutWindow.E(getApplicationContext(), PopLayerConsole.class, 0);
        TextView textView = new TextView(this);
        this.a = textView;
        setContentView(textView);
        try {
            String queryParameter = getIntent().getData().getQueryParameter("windvane");
            if (queryParameter == null) {
                C3705a.f(new String[0]);
            } else {
                C3705a.f(queryParameter.split(","));
            }
            TextView textView2 = this.a;
            textView2.append("Start monitoring WVPlugins:" + queryParameter + StringUtils.LF);
            String queryParameter2 = getIntent().getData().getQueryParameter("log_cache_size");
            if (queryParameter2 != null) {
                LogCache.f(Integer.parseInt(queryParameter2));
            }
            b = true;
            finish();
            dt1.b("PopLayerDebugActivity.openConsole.monitorWVPlugins{%s}.withLogCache{%s}.success.", queryParameter, queryParameter2);
        } catch (Exception e) {
            dt1.c("PopLayerDebugtActivity.onCreate", e);
            this.a.setTextColor(SupportMenu.CATEGORY_MASK);
            TextView textView3 = this.a;
            textView3.append("Error:" + Log.getStackTraceString(e));
            StandOutWindow.e(getApplicationContext(), PopLayerConsole.class);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        b();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b = false;
        try {
            if (!Settings.canDrawOverlays(this)) {
                startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 0);
            } else {
                b();
            }
        } catch (Throwable th) {
            dt1.c("PopLayerDebugActivity.onCreate.canDrawOverlaysError", th);
            b();
        }
    }
}
