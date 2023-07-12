package com.youku.live.dago.widgetlib.ailpchat;

import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public enum ConnectState {
    CONNECTED("connected", 1),
    DISCONNECTED("disconnected", 2),
    UNKONW("unkown", 3);
    
    private int index;
    private String name;

    ConnectState(String str, int i) {
        this.name = str;
        this.index = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.index + JSMethod.NOT_SET + this.name;
    }
}
