package cn.damai.seat.listener.net;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.e11;
import tb.t82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class MtopCalcTicketPriceListener extends DMMtopRequestListener<TicketCalcRes> implements OnNetBizListener<TicketCalcRes> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long itemId;
    private long performId;

    public MtopCalcTicketPriceListener(long j, long j2) {
        super(TicketCalcRes.class);
        this.itemId = j;
        this.performId = j2;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079789954")) {
            ipChange.ipc$dispatch("2079789954", new Object[]{this, str, str2});
            return;
        }
        onNetFail(str, str2);
        if (e11.b().c(str)) {
            return;
        }
        t82.o(this.itemId + "", this.performId + "", str, str2);
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onSuccess(TicketCalcRes ticketCalcRes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "526879468")) {
            ipChange.ipc$dispatch("526879468", new Object[]{this, ticketCalcRes});
        } else if (ticketCalcRes == null) {
            onFail("", "麦麦开小差了，请稍后重试哦");
        } else {
            onNetSuccess(ticketCalcRes);
        }
    }
}
