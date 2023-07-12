package com.alibaba.pictures.bricks.orderresult.couponpayresult.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RecommendListMo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<JSONObject> result;

    @Nullable
    public final ArrayList<JSONObject> getResult() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1978451879") ? (ArrayList) ipChange.ipc$dispatch("1978451879", new Object[]{this}) : this.result;
    }

    public final void setResult(@Nullable ArrayList<JSONObject> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457782665")) {
            ipChange.ipc$dispatch("1457782665", new Object[]{this, arrayList});
        } else {
            this.result = arrayList;
        }
    }
}
