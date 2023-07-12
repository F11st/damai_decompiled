package com.alibaba.pictures.bricks.myorder.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.myorder.bean.MyOrderListResp;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class MyOrderListRequest extends DamaiBaseRequest<MyOrderListResp> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int bizType;
    @Nullable
    private String dmChannel;
    private int pageNum;
    private int pageSize;
    private int queryType;

    public MyOrderListRequest() {
        this.API_NAME = "mtop.damai.wireless.order.secondaryorderlist";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
        this.pageSize = 20;
        this.pageNum = 1;
        this.bizType = 1;
    }

    public final int getBizType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "645785265") ? ((Integer) ipChange.ipc$dispatch("645785265", new Object[]{this})).intValue() : this.bizType;
    }

    @Nullable
    public final String getDmChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1041765359") ? (String) ipChange.ipc$dispatch("1041765359", new Object[]{this}) : this.dmChannel;
    }

    public final int getPageNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1692135143") ? ((Integer) ipChange.ipc$dispatch("1692135143", new Object[]{this})).intValue() : this.pageNum;
    }

    public final int getPageSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "729404322") ? ((Integer) ipChange.ipc$dispatch("729404322", new Object[]{this})).intValue() : this.pageSize;
    }

    public final int getQueryType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1614632996") ? ((Integer) ipChange.ipc$dispatch("-1614632996", new Object[]{this})).intValue() : this.queryType;
    }

    public final void setBizType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067767673")) {
            ipChange.ipc$dispatch("1067767673", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.bizType = i;
        }
    }

    public final void setDmChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264750183")) {
            ipChange.ipc$dispatch("264750183", new Object[]{this, str});
        } else {
            this.dmChannel = str;
        }
    }

    public final void setPageNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855124477")) {
            ipChange.ipc$dispatch("-855124477", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageNum = i;
        }
    }

    public final void setPageSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047479872")) {
            ipChange.ipc$dispatch("2047479872", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageSize = i;
        }
    }

    public final void setQueryType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345428306")) {
            ipChange.ipc$dispatch("-345428306", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.queryType = i;
        }
    }
}
