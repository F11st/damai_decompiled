package tb;

import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class np1 implements Comparator<SeatNew> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Long> a = new ArrayList();

    public np1(List<SubPrice> list) {
        if (cb2.d(list)) {
            return;
        }
        for (SubPrice subPrice : list) {
            this.a.add(Long.valueOf(subPrice.getPriceId()));
        }
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(SeatNew seatNew, SeatNew seatNew2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561437612")) {
            return ((Integer) ipChange.ipc$dispatch("-561437612", new Object[]{this, seatNew, seatNew2})).intValue();
        }
        long j = seatNew.priceLevel;
        long j2 = seatNew2.priceLevel;
        if (j == j2) {
            return f92.q(seatNew).compareTo(f92.q(seatNew2));
        }
        return this.a.indexOf(Long.valueOf(j)) - this.a.indexOf(Long.valueOf(j2));
    }
}
