package cn.damai.ultron.payresult.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmPaySuccessBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<DmPayButtonBean> buttons;
    public String isPaid;
    public String orderId;
    public String paymentInfo;
    public String projectId;
    public boolean requestSuccess;
    public String reservedDesc;
    public String resultDesc;
    public String tip;

    public boolean isPayState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1620354921") ? ((Boolean) ipChange.ipc$dispatch("-1620354921", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.isPaid) && "true".equalsIgnoreCase(this.isPaid);
    }
}
