package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ServiceOrderInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String afterServiceGuide;
    public String progressUrl;

    public boolean isShowView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-861994021") ? ((Boolean) ipChange.ipc$dispatch("-861994021", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.afterServiceGuide);
    }
}
