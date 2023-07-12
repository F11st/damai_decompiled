package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SvgDecryptBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean needDecrypt;
    public String safeKey;
    public String safeToken;
    public String svgHash;
    public String svgKeyHash;
    public String timeStamp;

    public boolean isNeedDecrypt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1800577203") ? ((Boolean) ipChange.ipc$dispatch("1800577203", new Object[]{this})).booleanValue() : this.needDecrypt;
    }
}
