package anet.channel.status;

import android.content.Context;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.ox1;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkStatusHelper {
    private static boolean a;
    static CopyOnWriteArraySet<INetworkStatusChangeListener> b = new CopyOnWriteArraySet<>();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface INetworkStatusChangeListener {
        void onNetworkStatusChanged(NetworkStatus networkStatus);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum NetworkStatus {
        NONE,
        NO,
        G2,
        G3,
        G4,
        WIFI,
        G5;

        public String getType() {
            return this == G2 ? "2G" : this == G3 ? "3G" : this == G4 ? "4G" : this == G5 ? "5G" : toString();
        }

        public boolean isMobile() {
            return this == G2 || this == G3 || this == G4 || this == G5;
        }

        public boolean isWifi() {
            return this == WIFI;
        }
    }

    public static void a(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        b.add(iNetworkStatusChangeListener);
    }

    public static String b() {
        return NetworkStatusMonitor.e;
    }

    public static String c() {
        return NetworkStatusMonitor.h;
    }

    public static Network d() {
        return NetworkStatusMonitor.c();
    }

    public static String e() {
        return NetworkStatusMonitor.d;
    }

    public static String f() {
        NetworkStatus networkStatus = NetworkStatusMonitor.c;
        if (networkStatus != NetworkStatus.WIFI || l() == null) {
            if (networkStatus.isMobile() && NetworkStatusMonitor.e.contains("wap")) {
                return "wap";
            }
            if (networkStatus.isMobile()) {
                ox1.a();
                return "";
            }
            return "";
        }
        return "proxy";
    }

    public static int g() {
        return NetworkStatusMonitor.e();
    }

    public static String h() {
        return NetworkStatusMonitor.i;
    }

    public static NetworkStatus i() {
        return NetworkStatusMonitor.c;
    }

    public static String j(NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String h = zh2.h(k());
            String str = TextUtils.isEmpty(h) ? "" : h;
            return "WIFI$" + str;
        } else if (networkStatus.isMobile()) {
            return networkStatus.getType() + "$" + b();
        } else {
            return "";
        }
    }

    public static String k() {
        return NetworkStatusMonitor.g;
    }

    public static Pair<String, Integer> l() {
        if (NetworkStatusMonitor.c != NetworkStatus.WIFI) {
            return null;
        }
        return NetworkStatusMonitor.j;
    }

    public static String m() {
        return NetworkStatusMonitor.f;
    }

    public static boolean n() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (NetworkStatusMonitor.b) {
                return true;
            }
        } else if (NetworkStatusMonitor.c != NetworkStatus.NO) {
            return true;
        }
        try {
            NetworkInfo d = NetworkStatusMonitor.d();
            if (d != null) {
                if (d.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean o() {
        NetworkStatus networkStatus = NetworkStatusMonitor.c;
        String str = NetworkStatusMonitor.e;
        if (networkStatus != NetworkStatus.WIFI || l() == null) {
            if (networkStatus.isMobile()) {
                if (str.contains("wap")) {
                    return true;
                }
                ox1.a();
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean p() {
        return NetworkStatusMonitor.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(final NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.i(new Runnable() { // from class: anet.channel.status.NetworkStatusHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator<INetworkStatusChangeListener> it = NetworkStatusHelper.b.iterator();
                    while (it.hasNext()) {
                        INetworkStatusChangeListener next = it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        next.onNetworkStatusChanged(NetworkStatus.this);
                        if (System.currentTimeMillis() - currentTimeMillis > 500) {
                            ALog.e("awcn.NetworkStatusHelper", "call back cost too much time", null, "listener", next);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public static void r() {
        try {
            NetworkStatus i = i();
            StringBuilder sb = new StringBuilder(128);
            sb.append("\nNetwork detail*******************************\n");
            sb.append("Status: ");
            sb.append(i.getType());
            sb.append('\n');
            sb.append("Subtype: ");
            sb.append(e());
            sb.append('\n');
            if (i != NetworkStatus.NO) {
                if (i.isMobile()) {
                    sb.append("Apn: ");
                    sb.append(b());
                    sb.append('\n');
                    sb.append("Carrier: ");
                    sb.append(c());
                    sb.append('\n');
                } else {
                    sb.append("BSSID: ");
                    sb.append(k());
                    sb.append('\n');
                    sb.append("SSID: ");
                    sb.append(m());
                    sb.append('\n');
                }
            }
            if (o()) {
                sb.append("Proxy: ");
                sb.append(f());
                sb.append('\n');
                Pair<String, Integer> l = l();
                if (l != null) {
                    sb.append("ProxyHost: ");
                    sb.append((String) l.first);
                    sb.append('\n');
                    sb.append("ProxyPort: ");
                    sb.append(l.second);
                    sb.append('\n');
                }
            }
            sb.append("*********************************************");
            ALog.f("awcn.NetworkStatusHelper", sb.toString(), null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void s(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        b.remove(iNetworkStatusChangeListener);
    }

    public static synchronized void t(Context context) {
        synchronized (NetworkStatusHelper.class) {
            if (context != null) {
                if (a) {
                    return;
                }
                NetworkStatusMonitor.a = context;
                NetworkStatusMonitor.m();
                NetworkStatusMonitor.l();
                a = true;
                return;
            }
            throw new NullPointerException("context is null");
        }
    }
}
