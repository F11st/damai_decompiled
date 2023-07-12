package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PriceInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 21212;
    public HashMap<String, ArrayList<PriceSummary>> standColor;

    public PriceInfo() {
    }

    public boolean hasSeat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716702912")) {
            return ((Boolean) ipChange.ipc$dispatch("-1716702912", new Object[]{this})).booleanValue();
        }
        if (!cb2.f(this.standColor)) {
            for (String str : this.standColor.keySet()) {
                if (!cb2.d(this.standColor.get(str))) {
                    return true;
                }
            }
        }
        return false;
    }

    public PriceInfo(HashMap<String, ArrayList<PriceSummary>> hashMap) {
        this.standColor = hashMap;
    }
}
