package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WishHeaPricetBean implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -2808187885385146670L;
    public int heat;
    public String heatDesc;
    public long priceId;
    public String priceName;
    public long skuId;

    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2114270949") ? ipChange.ipc$dispatch("2114270949", new Object[]{this}) : super.clone();
    }
}
