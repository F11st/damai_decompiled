package cn.damai.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.damai.commonbusiness.share.ShareManager;
import com.alibaba.pictures.bricks.util.share.ShareProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DmShareImpl implements ShareProxy.IShareProxy {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.util.share.ShareProxy.IShareProxy
    public void share(Activity activity, Bundle bundle, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062189212")) {
            ipChange.ipc$dispatch("2062189212", new Object[]{this, activity, bundle, view});
            return;
        }
        ShareManager.E().T(activity, bundle, view);
        ShareManager.E().l0();
    }
}
