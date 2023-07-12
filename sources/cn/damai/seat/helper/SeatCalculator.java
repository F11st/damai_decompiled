package cn.damai.seat.helper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcRes;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCombineInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopCalcTicketPriceRequest;
import cn.damai.seat.bean.UtCalculator;
import cn.damai.seat.listener.net.MtopCalcTicketPriceListener;
import cn.damai.seat.listener.net.OnNetBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.List;
import tb.cb2;
import tb.o92;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatCalculator {
    private static transient /* synthetic */ IpChange $ipChange;
    public long a;
    public long b;
    private Pair<String, List<TicketCombineInfo>> c;

    public SeatCalculator(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public MtopBusiness b(final String str, String str2, @NonNull final List<SeatCalcParams> list, final OnNetBizListener<TicketCalcRes> onNetBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043131251")) {
            return (MtopBusiness) ipChange.ipc$dispatch("-1043131251", new Object[]{this, str, str2, list, onNetBizListener});
        }
        c();
        return new MtopCalcTicketPriceRequest(this.a + "", this.b + "", str2, list).request(new MtopCalcTicketPriceListener(this.a, this.b) { // from class: cn.damai.seat.helper.SeatCalculator.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2071249311")) {
                    ipChange2.ipc$dispatch("2071249311", new Object[]{this, str3, str4});
                    return;
                }
                onNetBizListener.onNetFail(str3, str4);
                o92 l = o92.l();
                SeatCalculator seatCalculator = SeatCalculator.this;
                l.t(UtCalculator.fail(seatCalculator.a, seatCalculator.b, list, str3, str4));
            }

            @Override // cn.damai.seat.listener.net.OnNetBizListener
            public void onNetSuccess(@NonNull TicketCalcRes ticketCalcRes) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-125341239")) {
                    ipChange2.ipc$dispatch("-125341239", new Object[]{this, ticketCalcRes});
                    return;
                }
                SeatCalculator.this.c();
                if (ticketCalcRes.isBizSuccess() && !cb2.d(ticketCalcRes.model.ticketModuleDetailVOS)) {
                    SeatCalculator.this.c = new Pair(str, ticketCalcRes.model.ticketModuleDetailVOS);
                }
                onNetBizListener.onNetSuccess(ticketCalcRes);
                o92 l = o92.l();
                SeatCalculator seatCalculator = SeatCalculator.this;
                l.t(UtCalculator.success(seatCalculator.a, seatCalculator.b, list));
            }
        });
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588144906")) {
            ipChange.ipc$dispatch("-588144906", new Object[]{this});
        } else {
            this.c = null;
        }
    }

    @Nullable
    public List<TicketCombineInfo> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886947916")) {
            return (List) ipChange.ipc$dispatch("886947916", new Object[]{this});
        }
        Pair<String, List<TicketCombineInfo>> pair = this.c;
        if (pair != null) {
            return pair.second;
        }
        return null;
    }

    public boolean e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069011598")) {
            return ((Boolean) ipChange.ipc$dispatch("-1069011598", new Object[]{this, str})).booleanValue();
        }
        Pair<String, List<TicketCombineInfo>> pair = this.c;
        return pair != null && TextUtils.equals(str, pair.first);
    }
}
