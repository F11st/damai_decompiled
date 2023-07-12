package org.android.netutil;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public abstract class NetListener {
    long native_ptr = 0;
    NetListenerType netListenerType;

    public NetListener(NetListenerType netListenerType) {
        this.netListenerType = netListenerType;
    }
}
