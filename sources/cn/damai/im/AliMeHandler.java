package cn.damai.im;

import android.app.Activity;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class AliMeHandler extends Activity {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320625706")) {
            ipChange.ipc$dispatch("-1320625706", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        AliMeUtil.l(this, AliMeUtil.FROM_ACT, getIntent() != null ? getIntent().getLongExtra("projectId", 0L) : 0L);
        finish();
    }
}
