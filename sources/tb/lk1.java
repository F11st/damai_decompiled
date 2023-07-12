package tb;

import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BasicInfoBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.DateBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class lk1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public int a = 0;
    public DateBean b;
    public PerformBean c;
    public PriceBean d;
    public BasicInfoBean e;
    public PromotionBean f;

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201266950")) {
            ipChange.ipc$dispatch("1201266950", new Object[]{this});
            return;
        }
        this.c = null;
        this.d = null;
    }
}
