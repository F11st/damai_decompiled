package cn.damai.mine.report;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ReportResponse extends BaseOutDo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String msg;
    public int status;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public ReportResponse getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-145343968") ? (ReportResponse) ipChange.ipc$dispatch("-145343968", new Object[]{this}) : this;
    }
}
