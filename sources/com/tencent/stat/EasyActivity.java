package com.tencent.stat;

import android.app.Activity;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EasyActivity extends Activity {
    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);
    }
}
