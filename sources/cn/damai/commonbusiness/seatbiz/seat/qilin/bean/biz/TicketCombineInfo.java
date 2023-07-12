package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TicketCombineInfo implements IBuyParam, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String count;
    public String itemId;
    public String skuId;

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.IBuyParam
    public String getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2145089920") ? (String) ipChange.ipc$dispatch("-2145089920", new Object[]{this}) : this.count;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.IBuyParam
    public String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-617566733") ? (String) ipChange.ipc$dispatch("-617566733", new Object[]{this}) : this.itemId;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.IBuyParam
    public String getSkuId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1740649975") ? (String) ipChange.ipc$dispatch("-1740649975", new Object[]{this}) : this.skuId;
    }
}
