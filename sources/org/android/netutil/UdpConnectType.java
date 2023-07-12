package org.android.netutil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UdpConnectType {
    public static boolean a() {
        return nativeTestUdpConnectIpv4() != 0;
    }

    public static boolean b() {
        return nativeTestUdpConnectIpv6() != 0;
    }

    private static native int nativeTestUdpConnectIpv4();

    private static native int nativeTestUdpConnectIpv6();
}
