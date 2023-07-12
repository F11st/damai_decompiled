package com.youku.live.messagechannel.message;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum MCSysMessageName {
    SYS_PROBE("SYS_PROBE"),
    SYS_MASS_SUBSCRIBE("SYS_MASS_SUBSCRIBE");
    
    private String name;

    MCSysMessageName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
