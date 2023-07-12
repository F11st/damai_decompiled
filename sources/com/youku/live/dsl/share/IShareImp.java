package com.youku.live.dsl.share;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IShareImp implements IShare {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.share.IShare
    public List<ShareTarget> getSupportTargets(ShareMode shareMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833415326")) {
            return (List) ipChange.ipc$dispatch("-1833415326", new Object[]{this, shareMode});
        }
        return null;
    }

    @Override // com.youku.live.dsl.share.IShare
    public void share(IShareInfo iShareInfo, IShareResult iShareResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083256482")) {
            ipChange.ipc$dispatch("2083256482", new Object[]{this, iShareInfo, iShareResult});
        }
    }
}
