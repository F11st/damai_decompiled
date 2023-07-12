package com.taobao.android.ultron.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import tb.co2;
import tb.h6;
import tb.vt2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UltronSwitchActivity extends Activity {
    private boolean a() {
        Intent intent = getIntent();
        if (intent == null) {
            return true;
        }
        Uri data = intent.getData();
        return ((co2.b(this, data)) && vt2.e(this, data)) && h6.b(this, data);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            Intent intent = new Intent();
            intent.setData(Uri.parse("http://m.taobao.com/index.htm"));
            intent.setAction("android.intent.action.VIEW");
            intent.setComponent(ComponentName.createRelative("com.taobao.taobao", "com.taobao.browser.BrowserActivity"));
            startActivity(intent);
            finish();
        }
    }
}
