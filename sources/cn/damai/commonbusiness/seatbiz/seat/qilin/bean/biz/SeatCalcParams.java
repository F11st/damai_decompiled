package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SeatCalcParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int count;
    public int price;
    public String priceId;

    public SeatCalcParams(String str, int i, int i2) {
        this.priceId = str;
        this.price = i;
        this.count = i2;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257686619")) {
            return ((Boolean) ipChange.ipc$dispatch("1257686619", new Object[]{this, obj})).booleanValue();
        }
        if (obj != null && (obj instanceof SeatCalcParams)) {
            return TextUtils.equals(this.priceId, ((SeatCalcParams) obj).priceId);
        }
        return false;
    }

    public SeatCalcParams() {
    }
}
