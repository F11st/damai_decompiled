package com.alibaba.pictures.bricks.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponOrderInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String expireTime;
    @Nullable
    private String orderCreateTime;
    @Nullable
    private String orderFinishTime;
    @Nullable
    private String orderId;
    @Nullable
    private String orderPayTime;
    @Nullable
    private String orderPayWay;
    @Nullable
    private String showStatus;
    @Nullable
    private String tradeNo;

    @JSONField(deserialize = false, serialize = false)
    @NotNull
    public final String formatOrderInfoText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25366744")) {
            return (String) ipChange.ipc$dispatch("-25366744", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        String str = this.orderId;
        if (str != null) {
            sb.append("订单编号：");
            sb.append(str);
        }
        String str2 = this.orderCreateTime;
        if (str2 != null) {
            sb.append(StringUtils.LF);
            sb.append("创建时间：");
            sb.append(str2);
        }
        String str3 = this.orderPayTime;
        if (str3 != null) {
            sb.append(StringUtils.LF);
            sb.append("付款时间：");
            sb.append(str3);
        }
        String str4 = this.orderPayWay;
        if (str4 != null) {
            sb.append(StringUtils.LF);
            sb.append("支付方式：");
            sb.append(str4);
        }
        String str5 = this.tradeNo;
        if (str5 != null) {
            sb.append(StringUtils.LF);
            sb.append("支付流水号：");
            sb.append(str5);
        }
        String str6 = this.orderFinishTime;
        if (str6 != null) {
            sb.append(StringUtils.LF);
            sb.append("成交时间：");
            sb.append(str6);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply {\n…  }\n\n        }.toString()");
        return sb2;
    }

    @Nullable
    public final String getExpireTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2143085112") ? (String) ipChange.ipc$dispatch("2143085112", new Object[]{this}) : this.expireTime;
    }

    @Nullable
    public final String getOrderCreateTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-81135903") ? (String) ipChange.ipc$dispatch("-81135903", new Object[]{this}) : this.orderCreateTime;
    }

    @Nullable
    public final String getOrderFinishTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1442467192") ? (String) ipChange.ipc$dispatch("1442467192", new Object[]{this}) : this.orderFinishTime;
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1259661843") ? (String) ipChange.ipc$dispatch("1259661843", new Object[]{this}) : this.orderId;
    }

    @Nullable
    public final String getOrderPayTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-705620397") ? (String) ipChange.ipc$dispatch("-705620397", new Object[]{this}) : this.orderPayTime;
    }

    @Nullable
    public final String getOrderPayWay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-917552737") ? (String) ipChange.ipc$dispatch("-917552737", new Object[]{this}) : this.orderPayWay;
    }

    @Nullable
    public final String getShowStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1944949893") ? (String) ipChange.ipc$dispatch("-1944949893", new Object[]{this}) : this.showStatus;
    }

    @Nullable
    public final String getTradeNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1203908943") ? (String) ipChange.ipc$dispatch("1203908943", new Object[]{this}) : this.tradeNo;
    }

    public final void setExpireTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98754394")) {
            ipChange.ipc$dispatch("-98754394", new Object[]{this, str});
        } else {
            this.expireTime = str;
        }
    }

    public final void setOrderCreateTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061567669")) {
            ipChange.ipc$dispatch("2061567669", new Object[]{this, str});
        } else {
            this.orderCreateTime = str;
        }
    }

    public final void setOrderFinishTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048623358")) {
            ipChange.ipc$dispatch("2048623358", new Object[]{this, str});
        } else {
            this.orderFinishTime = str;
        }
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221442109")) {
            ipChange.ipc$dispatch("-1221442109", new Object[]{this, str});
        } else {
            this.orderId = str;
        }
    }

    public final void setOrderPayTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514773")) {
            ipChange.ipc$dispatch("-1514773", new Object[]{this, str});
        } else {
            this.orderPayTime = str;
        }
    }

    public final void setOrderPayWay(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-679315017")) {
            ipChange.ipc$dispatch("-679315017", new Object[]{this, str});
        } else {
            this.orderPayWay = str;
        }
    }

    public final void setShowStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021179331")) {
            ipChange.ipc$dispatch("2021179331", new Object[]{this, str});
        } else {
            this.showStatus = str;
        }
    }

    public final void setTradeNo(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345185287")) {
            ipChange.ipc$dispatch("1345185287", new Object[]{this, str});
        } else {
            this.tradeNo = str;
        }
    }
}
