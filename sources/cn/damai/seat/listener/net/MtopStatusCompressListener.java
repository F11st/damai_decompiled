package cn.damai.seat.listener.net;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.e11;
import tb.jh1;
import tb.t82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class MtopStatusCompressListener extends DMMtopRequestListener<CompressSeatStatus> implements OnNetBizListener<CompressSeatStatus> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long itemId;
    private jh1 mMonitor;
    private long performId;

    public MtopStatusCompressListener(long j, long j2) {
        super(CompressSeatStatus.class);
        this.mMonitor = new jh1(true);
        this.itemId = j;
        this.performId = j2;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "705687330")) {
            ipChange.ipc$dispatch("705687330", new Object[]{this, str, str2});
            return;
        }
        jh1.e("mtop.damai.wireless.seat.queryperformseatstatus", str, str2);
        onNetFail(str, str2);
        if (e11.b().c(str)) {
            return;
        }
        if (str == null) {
            str = "unknown";
        }
        if (str2 == null) {
            str2 = "unknown";
        }
        t82.n("mtop.damai.wireless.seat.queryperformseatstatus", str, str2, this.itemId + "", this.performId + "");
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onSuccess(CompressSeatStatus compressSeatStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546103809")) {
            ipChange.ipc$dispatch("1546103809", new Object[]{this, compressSeatStatus});
        } else if (compressSeatStatus == null) {
            onFail("", "麦麦开小差了，请稍后重试哦");
        } else {
            this.mMonitor.a("mtop.damai.wireless.seat.queryperformseatstatus");
            jh1.f("mtop.damai.wireless.seat.queryperformseatstatus");
            onNetSuccess(compressSeatStatus);
        }
    }
}
