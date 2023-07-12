package com.alimm.xadsdk.business.playerad.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdEvent implements Serializable {
    private Object mEventParam;
    private int mEventType;

    public AdEvent(int i) {
        this(i, null);
    }

    public AdEvent(int i, Object obj) {
        this.mEventType = i;
        this.mEventParam = obj;
    }

    public Object getParam() {
        return this.mEventParam;
    }

    public int getType() {
        return this.mEventType;
    }
}
