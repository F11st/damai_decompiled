package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AdItem implements BaseInfo {
    private static final String LANDING_DEFAULT = "default";
    @JSONField(name = "creative")
    private AdCreativeInfo mCreativeInfo;
    @JSONField(name = "landing")
    private Map<String, List<LandingInfo>> mLandingInfo;
    @JSONField(name = "monitor")
    private Map<String, List<MonitorInfo>> mMonitorInfo;

    public AdCreativeInfo getCreativeInfo() {
        return this.mCreativeInfo;
    }

    public List<LandingInfo> getDefaultLandingInfo() {
        Map<String, List<LandingInfo>> map = this.mLandingInfo;
        if (map != null) {
            return map.get("default");
        }
        return null;
    }

    public Map<String, List<LandingInfo>> getLandingInfo() {
        return this.mLandingInfo;
    }

    public Map<String, List<MonitorInfo>> getMonitorInfo() {
        return this.mMonitorInfo;
    }

    public AdItem setCreativeInfo(AdCreativeInfo adCreativeInfo) {
        this.mCreativeInfo = adCreativeInfo;
        return this;
    }

    public AdItem setLandingInfo(Map<String, List<LandingInfo>> map) {
        this.mLandingInfo = map;
        return this;
    }

    public AdItem setMonitorInfo(Map<String, List<MonitorInfo>> map) {
        this.mMonitorInfo = map;
        return this;
    }
}
