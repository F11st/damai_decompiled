package anet.channel.util;

import android.text.TextUtils;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.android.netutil.UdpConnectType;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import tb.hu0;
import tb.t9;
import tb.ti1;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Inet64Util {
    public static final int IPV4_ONLY = 1;
    public static final int IPV6_ONLY = 2;
    public static final int IP_DUAL_STACK = 3;
    public static final int IP_STACK_UNKNOWN = 0;
    static volatile String b;
    static ti1 c;
    public static volatile int f;
    public static volatile int g;
    static final byte[][] a = {new byte[]{-64, 0, 0, -86}, new byte[]{-64, 0, 0, -85}};
    public static volatile String d = null;
    public static volatile String e = null;
    static ConcurrentHashMap<String, ti1> h = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, Integer> i = new ConcurrentHashMap<>();

    static {
        b = null;
        c = null;
        try {
            c = new ti1((Inet6Address) InetAddress.getAllByName("64:ff9b::")[0], 96);
            b = i(NetworkStatusHelper.i());
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ int b() {
        return f();
    }

    static /* synthetic */ ti1 c() throws UnknownHostException {
        return g();
    }

    public static String d(Inet4Address inet4Address) throws Exception {
        if (inet4Address != null) {
            ti1 m = m();
            if (m != null) {
                byte[] address = inet4Address.getAddress();
                byte[] address2 = m.b.getAddress();
                int i2 = m.a / 8;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = i3 + i2;
                    if (i5 > 15 || i4 >= 4) {
                        break;
                    }
                    if (i5 != 8) {
                        address2[i5] = (byte) (address[i4] | address2[i5]);
                        i4++;
                    }
                    i3++;
                }
                return InetAddress.getByAddress(address2).getHostAddress();
            }
            throw new Exception("cannot get nat64 prefix");
        }
        throw new InvalidParameterException("address in null");
    }

    public static String e(String str) throws Exception {
        return d((Inet4Address) Inet4Address.getByName(str));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x003f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static int f() {
        /*
            java.lang.String r0 = "ip stack"
            java.lang.String r1 = "startIpStackDetect"
            java.lang.String r2 = "awcn.Inet64Util"
            r3 = 2
            r4 = 4
            r5 = 3
            r6 = 1
            r7 = 0
            r8 = 0
            java.lang.String r9 = "udp_connect"
            int r10 = l()     // Catch: java.lang.Throwable -> L3d
            boolean r11 = tb.t9.F()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L49
            if (r10 != r5) goto L49
            int r11 = k()     // Catch: java.lang.Throwable -> L3b
            if (r11 != r6) goto L49
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L3b
            r12[r8] = r0     // Catch: java.lang.Throwable -> L3b
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L3b
            r12[r6] = r13     // Catch: java.lang.Throwable -> L3b
            java.lang.String r13 = "new stack"
            r12[r3] = r13     // Catch: java.lang.Throwable -> L3b
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Throwable -> L3b
            r12[r5] = r13     // Catch: java.lang.Throwable -> L3b
            anet.channel.util.ALog.e(r2, r1, r7, r12)     // Catch: java.lang.Throwable -> L3b
            r10 = r11
            goto L49
        L3b:
            r11 = move-exception
            goto L42
        L3d:
            r11 = move-exception
            goto L41
        L3f:
            r11 = move-exception
            r9 = r7
        L41:
            r10 = 0
        L42:
            java.lang.Object[] r12 = new java.lang.Object[r8]
            java.lang.String r13 = "[detectIpStack]error."
            anet.channel.util.ALog.d(r2, r13, r7, r11, r12)
        L49:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r8] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            r4[r6] = r0
            java.lang.String r0 = "detectType"
            r4[r3] = r0
            r4[r5] = r9
            anet.channel.util.ALog.e(r2, r1, r7, r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Inet64Util.f():int");
    }

    private static ti1 g() throws UnknownHostException {
        InetAddress inetAddress;
        boolean z;
        try {
            inetAddress = InetAddress.getByName("ipv4only.arpa");
        } catch (Exception unused) {
            inetAddress = null;
        }
        if (inetAddress instanceof Inet6Address) {
            ALog.f("awcn.Inet64Util", "Resolved AAAA: " + inetAddress.toString(), null, new Object[0]);
            byte[] address = inetAddress.getAddress();
            if (address.length != 16) {
                return null;
            }
            int i2 = 12;
            while (true) {
                z = true;
                if (i2 < 0) {
                    z = false;
                    break;
                }
                byte b2 = address[i2];
                byte[][] bArr = a;
                if ((b2 & bArr[0][0]) != 0 && address[i2 + 1] == 0 && address[i2 + 2] == 0) {
                    int i3 = i2 + 3;
                    if (address[i3] == bArr[0][3] || address[i3] == bArr[1][3]) {
                        break;
                    }
                }
                i2--;
            }
            if (z) {
                address[i2 + 3] = 0;
                address[i2 + 2] = 0;
                address[i2 + 1] = 0;
                address[i2] = 0;
                return new ti1(Inet6Address.getByAddress("ipv4only.arpa", address, 0), i2 * 8);
            }
        } else if (inetAddress instanceof Inet4Address) {
            ALog.f("awcn.Inet64Util", "Resolved A: " + inetAddress.toString(), null, new Object[0]);
        }
        return null;
    }

    private static boolean h(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String k = NetworkStatusHelper.k();
            if (TextUtils.isEmpty(k)) {
                k = "";
            }
            return "WIFI$" + k;
        } else if (networkStatus.isMobile()) {
            return networkStatus.getType() + "$" + NetworkStatusHelper.b();
        } else {
            return "UnknownNetwork";
        }
    }

    public static void j() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    ALog.f("awcn.Inet64Util", "find NetworkInterface:" + displayName, null, new Object[0]);
                    if (displayName.toLowerCase().startsWith("wlan0") && NetworkStatusHelper.i().isWifi()) {
                        for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                            InetAddress address = interfaceAddress.getAddress();
                            if (address instanceof Inet6Address) {
                                e = address.getHostAddress();
                                g = networkInterface.getMTU();
                            } else if (address instanceof Inet4Address) {
                                d = address.getHostAddress();
                                f = networkInterface.getMTU();
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static int k() throws SocketException {
        String str;
        int i2;
        TreeMap treeMap = new TreeMap();
        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (true) {
            str = null;
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                String displayName = networkInterface.getDisplayName();
                ALog.f("awcn.Inet64Util", "find NetworkInterface:" + displayName, null, new Object[0]);
                int i3 = 0;
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress address = interfaceAddress.getAddress();
                    if (address instanceof Inet6Address) {
                        Inet6Address inet6Address = (Inet6Address) address;
                        if (!h(inet6Address)) {
                            ALog.e("awcn.Inet64Util", "Found IPv6 address:" + inet6Address.toString(), null, new Object[0]);
                            i3 |= 2;
                        }
                    } else if (address instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address) address;
                        if (!h(inet4Address) && !inet4Address.getHostAddress().startsWith("192.168.43.")) {
                            ALog.e("awcn.Inet64Util", "Found IPv4 address:" + inet4Address.toString(), null, new Object[0]);
                            i3 |= 1;
                        }
                    }
                }
                if (i3 != 0) {
                    treeMap.put(displayName.toLowerCase(), Integer.valueOf(i3));
                }
            }
        }
        if (treeMap.isEmpty()) {
            return 0;
        }
        if (treeMap.size() == 1) {
            return ((Integer) treeMap.firstEntry().getValue()).intValue();
        }
        if (NetworkStatusHelper.i().isWifi()) {
            str = "wlan";
        } else if (NetworkStatusHelper.i().isMobile()) {
            str = "rmnet";
        }
        if (str != null) {
            Iterator it2 = treeMap.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it2.next();
                if (((String) entry.getKey()).startsWith(str)) {
                    i2 = ((Integer) entry.getValue()).intValue();
                    break;
                }
            }
        }
        return (i2 == 2 && treeMap.containsKey("v4-wlan0")) ? i2 | ((Integer) treeMap.remove("v4-wlan0")).intValue() : i2;
    }

    private static int l() {
        SpdyAgent.getInstance(hu0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        boolean a2 = UdpConnectType.a();
        return UdpConnectType.b() ? (a2 ? 1 : 0) | 2 : a2 ? 1 : 0;
    }

    public static ti1 m() {
        ti1 ti1Var = h.get(b);
        return ti1Var == null ? c : ti1Var;
    }

    public static int n() {
        Integer num = i.get(b);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean o() {
        Integer num = i.get(b);
        return num != null && num.intValue() == 1;
    }

    public static boolean p() {
        Integer num;
        return t9.D() && (num = i.get(b)) != null && num.intValue() == 2;
    }

    public static void q() {
        b = i(NetworkStatusHelper.i());
        if (i.putIfAbsent(b, 0) != null) {
            return;
        }
        int f2 = f();
        i.put(b, Integer.valueOf(f2));
        final NetTypeStat netTypeStat = new NetTypeStat();
        netTypeStat.ipStackType = f2;
        final String str = b;
        if (f2 != 2 && f2 != 3) {
            if (hu0.j()) {
                x6.b().commitStat(netTypeStat);
                return;
            }
            return;
        }
        ThreadPoolExecutorFactory.j(new Runnable() { // from class: anet.channel.util.Inet64Util.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutorFactory.g(new Runnable() { // from class: anet.channel.util.Inet64Util.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ti1 c2;
                        try {
                            if (str.equals(Inet64Util.i(NetworkStatusHelper.i()))) {
                                ALog.e("awcn.Inet64Util", "startIpStackDetect double check", null, new Object[0]);
                                int b2 = Inet64Util.b();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (netTypeStat.ipStackType != b2) {
                                    Inet64Util.i.put(str, Integer.valueOf(b2));
                                    NetTypeStat netTypeStat2 = netTypeStat;
                                    netTypeStat2.lastIpStackType = netTypeStat2.ipStackType;
                                    netTypeStat2.ipStackType = b2;
                                }
                                if ((b2 == 2 || b2 == 3) && (c2 = Inet64Util.c()) != null) {
                                    Inet64Util.h.put(str, c2);
                                    netTypeStat.nat64Prefix = c2.toString();
                                }
                                if (hu0.j()) {
                                    x6.b().commitStat(netTypeStat);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }, ThreadPoolExecutorFactory.b.c);
            }
        }, 1500L, TimeUnit.MILLISECONDS);
    }
}
