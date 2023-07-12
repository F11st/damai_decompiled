package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ProfileInfoBean extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    public ProfileInfo profileInfo;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public ProfileInfo getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "799595040") ? (ProfileInfo) ipChange.ipc$dispatch("799595040", new Object[]{this}) : this.profileInfo;
    }
}
