package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.utils.LogUtils;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class InteractionInfo implements BaseInfo {
    private static final String TAG = "InteractionInfo";
    @JSONField(name = "creative")
    private InteractionCreativeInfo mCreativeInfo;
    @JSONField(serialize = false)
    private String mCreativePath;
    @JSONField(name = "monitor")
    private Map<String, List<MonitorInfo>> mMonitorInfo;
    @JSONField(serialize = false)
    private int mType = -1;
    @JSONField(serialize = false)
    private int mXCoord = -1;
    @JSONField(serialize = false)
    private int mYCoord = -1;
    @JSONField(serialize = false)
    private int mWidth = -1;
    @JSONField(serialize = false)
    private int mHeight = -1;

    public InteractionCreativeInfo getCreativeInfo() {
        return this.mCreativeInfo;
    }

    public String getCreativeName() {
        InteractionCreativeInfo interactionCreativeInfo = this.mCreativeInfo;
        return interactionCreativeInfo != null ? interactionCreativeInfo.getCreativeName() : "";
    }

    public String getCreativePath() {
        return this.mCreativePath;
    }

    public String getCreativeType() {
        InteractionCreativeInfo interactionCreativeInfo = this.mCreativeInfo;
        return interactionCreativeInfo != null ? interactionCreativeInfo.getCreativeType() : "";
    }

    public String getCreativeUrl() {
        InteractionCreativeInfo interactionCreativeInfo = this.mCreativeInfo;
        return interactionCreativeInfo != null ? interactionCreativeInfo.getCreativeUrl() : "";
    }

    public int getHeight() {
        InteractionCreativeInfo interactionCreativeInfo;
        if (this.mHeight == -1 && (interactionCreativeInfo = this.mCreativeInfo) != null) {
            this.mHeight = interactionCreativeInfo.getHeight();
        }
        return this.mHeight;
    }

    public Map<String, List<MonitorInfo>> getMonitorInfo() {
        return this.mMonitorInfo;
    }

    public int getType() {
        InteractionCreativeInfo interactionCreativeInfo;
        if (this.mType == -1 && (interactionCreativeInfo = this.mCreativeInfo) != null) {
            this.mType = interactionCreativeInfo.getType();
        }
        return this.mType;
    }

    public int getWidth() {
        InteractionCreativeInfo interactionCreativeInfo;
        if (this.mWidth == -1 && (interactionCreativeInfo = this.mCreativeInfo) != null) {
            this.mWidth = interactionCreativeInfo.getWidth();
        }
        return this.mWidth;
    }

    public int getXCoord() {
        InteractionCreativeInfo interactionCreativeInfo;
        if (this.mXCoord == -1 && (interactionCreativeInfo = this.mCreativeInfo) != null) {
            this.mXCoord = interactionCreativeInfo.getXCoord();
        }
        return this.mXCoord;
    }

    public int getYCoord() {
        InteractionCreativeInfo interactionCreativeInfo;
        if (this.mYCoord == -1 && (interactionCreativeInfo = this.mCreativeInfo) != null) {
            this.mYCoord = interactionCreativeInfo.getYCoord();
        }
        return this.mYCoord;
    }

    public InteractionInfo setCreativeInfo(InteractionCreativeInfo interactionCreativeInfo) {
        this.mCreativeInfo = interactionCreativeInfo;
        return this;
    }

    public InteractionInfo setCreativePath(String str) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setCreativePath: creativePath = " + str);
        }
        this.mCreativePath = str;
        return this;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public InteractionInfo setMonitorInfo(Map<String, List<MonitorInfo>> map) {
        this.mMonitorInfo = map;
        return this;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setXCoord(int i) {
        this.mXCoord = i;
    }

    public void setYCoord(int i) {
        this.mYCoord = i;
    }
}
