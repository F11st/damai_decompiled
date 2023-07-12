package cn.damai.seat.bean;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;
import java.util.List;
import tb.bb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class UtCalculator implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String errCode;
    public final String errMsg;
    public final long itemId;
    public final List<SeatCalcParams> params;
    public final long performId;
    public final boolean success;

    public UtCalculator(boolean z, long j, long j2, List<SeatCalcParams> list, String str, String str2) {
        this.success = z;
        this.itemId = j;
        this.performId = j2;
        this.params = list;
        this.errCode = str;
        this.errMsg = str2;
    }

    public static UtCalculator fail(long j, long j2, List<SeatCalcParams> list, String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-22793419") ? (UtCalculator) ipChange.ipc$dispatch("-22793419", new Object[]{Long.valueOf(j), Long.valueOf(j2), list, str, str2}) : new UtCalculator(false, j, j2, list, str, str2);
    }

    public static UtCalculator success(long j, long j2, List<SeatCalcParams> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1236916150") ? (UtCalculator) ipChange.ipc$dispatch("-1236916150", new Object[]{Long.valueOf(j), Long.valueOf(j2), list}) : new UtCalculator(true, j, j2, list, null, null);
    }

    public String getParamsInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702788850")) {
            return (String) ipChange.ipc$dispatch("-702788850", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        if (!bb2.d(this.params)) {
            for (SeatCalcParams seatCalcParams : this.params) {
                int i = seatCalcParams.count;
                int i2 = seatCalcParams.price;
                String str = seatCalcParams.priceId;
                sb.append("count-");
                sb.append(i);
                sb.append("-price-");
                sb.append(i2);
                sb.append("-priceId-");
                sb.append(str);
                sb.append(JSMethod.NOT_SET);
            }
        }
        return sb.toString();
    }
}
