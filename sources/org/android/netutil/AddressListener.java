package org.android.netutil;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public abstract class AddressListener extends NetListener {
    public AddressListener() {
        super(NetListenerType.NL_NEW_IP_ADDRESS);
    }

    public abstract void onNewAddress(String str);
}
