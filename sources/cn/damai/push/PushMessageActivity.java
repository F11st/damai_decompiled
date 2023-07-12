package cn.damai.push;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.agoo.BaseNotifyClickActivity;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class PushMessageActivity extends BaseNotifyClickActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-300152336")) {
            ipChange.ipc$dispatch("-300152336", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @Override // com.taobao.agoo.BaseNotifyClickActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMessage(android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.push.PushMessageActivity.onMessage(android.content.Intent):void");
    }
}
