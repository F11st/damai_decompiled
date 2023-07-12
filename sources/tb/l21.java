package tb;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.utils.Logger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
class l21 {
    public static final int IPV4_ONLY = 1;
    public static final int IPV6_ONLY = 2;
    public static final int IP_DUAL_STACK = 3;
    public static final int IP_STACK_UNKNOWN = 0;
    private static int a = -1;

    public static synchronized int a() {
        synchronized (l21.class) {
            int i = a;
            if (i >= 0) {
                return i;
            }
            long currentTimeMillis = System.currentTimeMillis();
            a = 0;
            try {
                a = c();
            } catch (Exception unused) {
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            f41.d(a);
            f41.a(currentTimeMillis2);
            Logger.m("Inet64Util", "detectIpStack status", Integer.valueOf(a));
            return a;
        }
    }

    private static boolean b(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static int c() throws SocketException {
        int i;
        TreeMap treeMap = new TreeMap();
        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                String displayName = networkInterface.getDisplayName();
                Logger.r("Inet64Util", "find NetworkInterface", displayName);
                int i2 = 0;
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress address = interfaceAddress.getAddress();
                    if (address instanceof Inet6Address) {
                        Inet6Address inet6Address = (Inet6Address) address;
                        if (!b(inet6Address)) {
                            Logger.m("Inet64Util", "Found IPv6 address", inet6Address.toString());
                            i2 |= 2;
                        }
                    } else if (address instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address) address;
                        if (!b(inet4Address) && !inet4Address.getHostAddress().startsWith("192.168.43.")) {
                            Logger.r("Inet64Util", "Found IPv4 address", inet4Address.toString());
                            i2 |= 1;
                        }
                    }
                }
                if (i2 != 0) {
                    treeMap.put(displayName.toLowerCase(), Integer.valueOf(i2));
                }
            }
        }
        if (treeMap.isEmpty()) {
            return 0;
        }
        if (treeMap.size() == 1) {
            return ((Integer) treeMap.firstEntry().getValue()).intValue();
        }
        Context j = Variables.n().j();
        String str = null;
        if (NetworkUtil.p(j)) {
            str = "wlan";
        } else if (NetworkUtil.o(j)) {
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
                    i = ((Integer) entry.getValue()).intValue();
                    break;
                }
            }
        }
        if (i == 2 && treeMap.containsKey("v4-wlan0")) {
            return 3;
        }
        return i;
    }
}
