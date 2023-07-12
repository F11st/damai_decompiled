package com.squareup.okhttp.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface Network {
    public static final Network DEFAULT = new Network() { // from class: com.squareup.okhttp.internal.Network.1
        @Override // com.squareup.okhttp.internal.Network
        public InetAddress[] resolveInetAddresses(String str) throws UnknownHostException {
            if (str != null) {
                return InetAddress.getAllByName(str);
            }
            throw new UnknownHostException("host == null");
        }
    };

    InetAddress[] resolveInetAddresses(String str) throws UnknownHostException;
}
