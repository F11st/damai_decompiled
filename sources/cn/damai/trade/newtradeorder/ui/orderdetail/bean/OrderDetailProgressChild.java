package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailProgressChild {
    private static transient /* synthetic */ IpChange $ipChange;
    public String highLightText;
    public String itemDate;
    public String itemText;

    public boolean getHighLight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-916111726") ? ((Boolean) ipChange.ipc$dispatch("-916111726", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.highLightText) && this.highLightText.equals("true");
    }
}
