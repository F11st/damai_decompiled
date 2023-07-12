package cn.damai.common.net.mtop.netfit;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMMtopBaseData extends BaseOutDo {
    private static transient /* synthetic */ IpChange $ipChange;
    private String data;

    public void setData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1071514760")) {
            ipChange.ipc$dispatch("-1071514760", new Object[]{this, str});
        } else {
            this.data = str;
        }
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public String getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-579310554") ? (String) ipChange.ipc$dispatch("-579310554", new Object[]{this}) : this.data;
    }
}
