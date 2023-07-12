package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailCanResellBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String canResell;
    public String errorCode;
    public String errorMsg;
    public String resellUrl;

    public boolean isCanResell() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1669487231") ? ((Boolean) ipChange.ipc$dispatch("-1669487231", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.canResell) || this.canResell.equals("false")) ? false : true;
    }
}
