package com.tencent.stat;

import android.app.ListActivity;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EasyListActivity extends ListActivity {
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
