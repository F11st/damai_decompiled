package com.ut.mini.behavior;

import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public enum UTEventId {
    PAGE(2001),
    EXPOSURE(2201),
    CLICK(2201),
    SCROLL(GLMapStaticValue.AM_PARAMETERNAME_ON_OFF_DBLITE),
    SCENE(GLMapStaticValue.AM_PARAMETERNAME_SHOW_OPTION);
    
    private int eventId;

    UTEventId(int i) {
        this.eventId = i;
    }

    public int getEventId() {
        return this.eventId;
    }
}
