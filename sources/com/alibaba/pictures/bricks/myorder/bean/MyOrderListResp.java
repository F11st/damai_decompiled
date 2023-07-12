package com.alibaba.pictures.bricks.myorder.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class MyOrderListResp implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String errorCode;
    @Nullable
    private String errorMsg;
    @Nullable
    private ArrayList<JSONObject> orderList;
    @Nullable
    private Integer totalCount;
    @Nullable
    private Integer totalPageNum;

    @Nullable
    public final String getErrorCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "590601320") ? (String) ipChange.ipc$dispatch("590601320", new Object[]{this}) : this.errorCode;
    }

    @Nullable
    public final String getErrorMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2122331036") ? (String) ipChange.ipc$dispatch("2122331036", new Object[]{this}) : this.errorMsg;
    }

    @Nullable
    public final ArrayList<JSONObject> getOrderList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "900611131") ? (ArrayList) ipChange.ipc$dispatch("900611131", new Object[]{this}) : this.orderList;
    }

    @Nullable
    public final Integer getTotalCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2043077913") ? (Integer) ipChange.ipc$dispatch("2043077913", new Object[]{this}) : this.totalCount;
    }

    @Nullable
    public final Integer getTotalPageNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1191700913") ? (Integer) ipChange.ipc$dispatch("1191700913", new Object[]{this}) : this.totalPageNum;
    }

    public final void setErrorCode(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-836433138")) {
            ipChange.ipc$dispatch("-836433138", new Object[]{this, str});
        } else {
            this.errorCode = str;
        }
    }

    public final void setErrorMsg(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485424834")) {
            ipChange.ipc$dispatch("1485424834", new Object[]{this, str});
        } else {
            this.errorMsg = str;
        }
    }

    public final void setOrderList(@Nullable ArrayList<JSONObject> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "472576477")) {
            ipChange.ipc$dispatch("472576477", new Object[]{this, arrayList});
        } else {
            this.orderList = arrayList;
        }
    }

    public final void setTotalCount(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1202196433")) {
            ipChange.ipc$dispatch("1202196433", new Object[]{this, num});
        } else {
            this.totalCount = num;
        }
    }

    public final void setTotalPageNum(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1010600761")) {
            ipChange.ipc$dispatch("1010600761", new Object[]{this, num});
        } else {
            this.totalPageNum = num;
        }
    }
}
