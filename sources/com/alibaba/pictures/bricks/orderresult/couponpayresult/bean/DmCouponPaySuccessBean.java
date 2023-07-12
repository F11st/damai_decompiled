package com.alibaba.pictures.bricks.orderresult.couponpayresult.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DmCouponPaySuccessBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public List<DmPayButtonBean> buttons;
    public String isPaid;
    public String orderId;
    public String paymentInfo;
    public String projectId;
    public List<GaiaxRender> render;
    public boolean requestSuccess;
    public String resultDesc;
    public String tip;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class DmPayButtonBean implements Serializable {
        public String buttonText;
        public String buttonType;
        public String buttonUrlParam;
        public String nativeUrl;
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class GaiaxRender implements Serializable {
        private static final long serialVersionUID = -1;
        public String type;
        public String url;
    }

    public String getPayState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "620215795") ? (String) ipChange.ipc$dispatch("620215795", new Object[]{this}) : TextUtils.isEmpty(this.isPaid) ? "500" : "true".equalsIgnoreCase(this.isPaid) ? "200" : "201";
    }

    public boolean isPayState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1695630801") ? ((Boolean) ipChange.ipc$dispatch("-1695630801", new Object[]{this})).booleanValue() : !TextUtils.isEmpty(this.isPaid) && "true".equalsIgnoreCase(this.isPaid);
    }
}
