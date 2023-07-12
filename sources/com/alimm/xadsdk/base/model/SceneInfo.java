package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SceneInfo implements BaseInfo {
    @JSONField(name = "id")
    private String mId;
    @JSONField(name = "start_time")
    private int mStartTime;

    public String getId() {
        return this.mId;
    }

    public int getStartTime() {
        return this.mStartTime;
    }

    public SceneInfo setId(String str) {
        this.mId = str;
        return this;
    }

    public SceneInfo setStartTime(int i) {
        this.mStartTime = i;
        return this;
    }

    public String toString() {
        return "Scene{id=" + this.mId + ", start_time=" + this.mStartTime + "}";
    }
}
