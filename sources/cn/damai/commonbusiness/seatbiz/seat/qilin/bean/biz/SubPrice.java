package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import android.graphics.Color;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SubPrice implements PriceLine, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String color;
    private int colorInt = -1;
    public int count;
    public float dashPrice;
    public long priceId;
    public String priceTitle;
    public float salePrice;
    public long skuId;

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public int colorInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124626742")) {
            return ((Integer) ipChange.ipc$dispatch("-2124626742", new Object[]{this})).intValue();
        }
        int i = this.colorInt;
        if (i == -1) {
            try {
                this.colorInt = Color.parseColor(this.color);
            } catch (Exception unused) {
                this.colorInt = Color.parseColor("#FF0000");
            }
            return this.colorInt;
        }
        return i;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public long getPriceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1154546807") ? ((Long) ipChange.ipc$dispatch("-1154546807", new Object[]{this})).longValue() : this.priceId;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public String getPriceTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1949322174") ? (String) ipChange.ipc$dispatch("1949322174", new Object[]{this}) : this.priceTitle;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine
    public float originalPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "275457215") ? ((Float) ipChange.ipc$dispatch("275457215", new Object[]{this})).floatValue() : this.dashPrice;
    }
}
