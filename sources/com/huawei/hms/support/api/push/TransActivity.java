package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.android.hms.push.R;
import com.huawei.hms.push.i;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TransActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwpush_trans_activity);
        getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
        i.a(this, getIntent());
        finish();
    }
}
