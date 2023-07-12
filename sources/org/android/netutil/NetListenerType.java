package org.android.netutil;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public enum NetListenerType {
    NL_NULL(-1),
    NL_NEW_IP_ADDRESS(0),
    NL_INTERFACE_ON_OFF(1);
    
    private long value;

    NetListenerType(long j) {
        this.value = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getValue() {
        return this.value;
    }
}
