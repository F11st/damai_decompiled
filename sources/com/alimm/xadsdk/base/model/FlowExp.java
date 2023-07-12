package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FlowExp implements BaseInfo {
    @JSONField(name = "SDK_ABTEST")
    private List<String> mAbTestStrategy;

    @JSONField(name = "SDK_ABTEST")
    public List<String> getAbTestStrategy() {
        return this.mAbTestStrategy;
    }

    @JSONField(name = "SDK_ABTEST")
    public void setAbTestStrategy(List<String> list) {
        this.mAbTestStrategy = list;
    }

    public String toString() {
        return "FlowExp{ mAbTestStrategy='" + this.mAbTestStrategy + '}';
    }
}
