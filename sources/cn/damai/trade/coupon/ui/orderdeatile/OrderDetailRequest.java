package cn.damai.trade.coupon.ui.orderdeatile;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class OrderDetailRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String dmChannel;
    @Nullable
    private String orderId;
    @Nullable
    private String sVersion;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    @NotNull
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-87798861") ? (String) ipChange.ipc$dispatch("-87798861", new Object[]{this}) : "mtop.damai.wireless.secondaryorde.orderdetail";
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1693328104") ? (String) ipChange.ipc$dispatch("1693328104", new Object[]{this}) : this.dmChannel;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-90595110")) {
            return ((Boolean) ipChange.ipc$dispatch("-90595110", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52337366")) {
            return ((Boolean) ipChange.ipc$dispatch("52337366", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "637283063") ? (String) ipChange.ipc$dispatch("637283063", new Object[]{this}) : this.orderId;
    }

    @Nullable
    public final String getSVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1314530323") ? (String) ipChange.ipc$dispatch("-1314530323", new Object[]{this}) : this.sVersion;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    @NotNull
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2079937862") ? (String) ipChange.ipc$dispatch("2079937862", new Object[]{this}) : "1.0";
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1011641202")) {
            ipChange.ipc$dispatch("-1011641202", new Object[]{this, str});
        } else {
            this.dmChannel = str;
        }
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959652191")) {
            ipChange.ipc$dispatch("959652191", new Object[]{this, str});
        } else {
            this.orderId = str;
        }
    }

    public final void setSVersion(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978062191")) {
            ipChange.ipc$dispatch("-1978062191", new Object[]{this, str});
        } else {
            this.sVersion = str;
        }
    }
}
