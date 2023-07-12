package com.youku.arch.probe.plugins;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.arch.ntk.a.g;
import com.youku.arch.ntk.a.h;
import com.youku.arch.ntk.a.i;
import com.youku.arch.ntk.a.l;
import com.youku.arch.ntk.b.f;
import com.youku.arch.probe.plugins.BasePlugin;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class d extends BasePlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String c = "d";
    private List<Integer> d;
    private boolean e;
    private int f;
    private String g;
    private List<Integer> h;
    private String i;
    private int j;
    private String k;
    private String l;
    private String m;
    private int n;
    private List<Integer> o;
    private List<String> p;
    private int q;
    private volatile int r;
    private volatile int s;
    private volatile int t;
    private int u;
    private int v;
    private int w;
    private volatile String x;
    private PhoneStateListener y;

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58324898")) {
            ipChange.ipc$dispatch("-58324898", new Object[]{this});
            return;
        }
        if (this.e) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                if (this.h.get(i3).intValue() < -1) {
                    if (this.h.get(i3).intValue() < com.youku.arch.probe.a.c.a) {
                        i2++;
                    }
                    i++;
                }
            }
            if (i > 0) {
                double d = (i2 * 1.0d) / i;
                if (d > 0.5d) {
                    this.v = 1;
                } else if (d > 0.2d) {
                    this.v = 2;
                } else {
                    this.v = 3;
                }
            } else {
                this.v = 0;
            }
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < this.o.size(); i6++) {
                if (this.o.get(i6).intValue() > 0) {
                    if (this.o.get(i6).intValue() > com.youku.arch.probe.a.c.c) {
                        i5++;
                    }
                    i4++;
                }
            }
            if (i4 > 0) {
                double d2 = (i5 * 1.0d) / i4;
                if (d2 > 0.5d) {
                    this.w = 1;
                    return;
                } else if (d2 > 0.2d) {
                    this.w = 2;
                    return;
                } else {
                    this.w = 3;
                    return;
                }
            }
        } else {
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < this.d.size(); i9++) {
                if (this.d.get(i9).intValue() >= 0 && this.d.get(i9).intValue() < 10) {
                    if (this.d.get(i9).intValue() < com.youku.arch.probe.a.c.b) {
                        i8++;
                    }
                    i7++;
                }
            }
            if (i7 > 0) {
                double d3 = (i8 * 1.0d) / i7;
                if (d3 > 0.5d) {
                    this.v = 1;
                } else if (d3 > 0.2d) {
                    this.v = 2;
                } else {
                    this.v = 3;
                }
            } else {
                this.v = 0;
            }
        }
        this.w = 0;
    }

    private String g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223417981")) {
            return (String) ipChange.ipc$dispatch("-223417981", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder("netType:");
        sb.append(this.e ? "wifi" : "mobile_" + this.f);
        sb.append(",signalStrength:");
        for (Integer num : this.d) {
            sb.append(num.intValue());
            sb.append("|");
        }
        sb.append(",ipv4:");
        sb.append(this.k);
        sb.append(",ipv6:");
        sb.append(this.l);
        sb.append(",ssid:");
        sb.append(this.g);
        sb.append(",rssi:");
        for (Integer num2 : this.h) {
            sb.append(num2.intValue());
            sb.append("|");
        }
        sb.append(",freq:");
        sb.append(this.i);
        sb.append(",metered:");
        sb.append(this.j);
        sb.append(",gate_ip:");
        sb.append(this.m);
        sb.append(",RTTs:");
        for (Integer num3 : this.o) {
            sb.append(num3.intValue());
            sb.append("|");
        }
        sb.append(",devCnt:");
        sb.append(this.p.size());
        sb.append(",qualityCode:");
        sb.append(this.n);
        return sb.toString();
    }

    private boolean h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-58265312") ? ((Boolean) ipChange.ipc$dispatch("-58265312", new Object[]{this})).booleanValue() : "1".equals(ApasServiceManager.getInstance().getConfig("speed_test", "check_fd_leak", "1")) && com.youku.arch.ntk.b.b().a();
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58235525")) {
            ipChange.ipc$dispatch("-58235525", new Object[]{this});
            return;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        if (nextElement instanceof Inet6Address) {
                            this.l = nextElement.getHostAddress();
                        } else {
                            this.k = nextElement.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58205747")) {
            return ((Integer) ipChange.ipc$dispatch("-58205747", new Object[]{this})).intValue();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            int networkType = Build.VERSION.SDK_INT < 30 ? com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager) : com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDataNetworkType(telephonyManager);
            if (networkType == 14 || networkType == 15) {
                return 3;
            }
            if (networkType != 20) {
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                        return 3;
                    default:
                        return 4;
                }
            }
            return 5;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public com.youku.arch.analysis.net.a a(com.youku.arch.analysis.net.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2146301069")) {
            return (com.youku.arch.analysis.net.a) ipChange.ipc$dispatch("2146301069", new Object[]{this, aVar});
        }
        if (aVar == null) {
            return null;
        }
        aVar.a = this.v;
        aVar.b = this.w;
        aVar.f = this.e;
        return aVar;
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58473853")) {
            ipChange.ipc$dispatch("-58473853", new Object[]{this});
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(this.y, 0);
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a(BasePlugin.NotiType notiType) {
        String extraInfo;
        l[] lVarArr;
        com.youku.arch.ntk.a.b bVar;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991645557")) {
            ipChange.ipc$dispatch("991645557", new Object[]{this, notiType});
            return;
        }
        this.q++;
        String str2 = c;
        com.youku.b.a.a.a(str2, "trigger begins type:" + notiType);
        ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo.isConnected()) {
                this.e = true;
                WifiManager wifiManager = (WifiManager) this.b.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    connectionInfo.getIpAddress();
                    if (TextUtils.isEmpty(connectionInfo.getSSID()) || "<unknown ssid>".equals(connectionInfo.getSSID())) {
                        com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
                        extraInfo = TextUtils.isEmpty(networkInfo.getExtraInfo()) ? "unknown" : networkInfo.getExtraInfo();
                    } else {
                        extraInfo = connectionInfo.getSSID();
                    }
                    this.g = extraInfo;
                    this.h.add(Integer.valueOf(connectionInfo.getRssi()));
                    this.t = connectionInfo.getRssi();
                    if (this.h.size() > this.u) {
                        this.h.remove(0);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        int frequency = connectionInfo.getFrequency();
                        if (frequency >= 2000 && frequency < 3000) {
                            str = "2.4G";
                        } else if (frequency >= 5000) {
                            str = "5G";
                        } else {
                            str = "unknown(" + frequency + jn1.BRACKET_END_STR;
                        }
                        this.i = str;
                    } else {
                        this.i = "unknown";
                    }
                    i();
                    this.m = com.youku.arch.probe.a.b.a(wifiManager.getDhcpInfo().gateway);
                    if (h()) {
                        this.o.add(-2);
                        this.s = -2;
                        if (this.o.size() > this.u) {
                            this.o.remove(0);
                        }
                    } else {
                        f.a aVar = new f.a();
                        aVar.b = !TextUtils.isEmpty(this.m) ? this.m : "www.youku.com";
                        aVar.c = 0;
                        aVar.e = 1;
                        aVar.d = "";
                        aVar.f = 5000;
                        aVar.a = 2;
                        JSONObject parseObject = JSON.parseObject(JSON.toJSONString(aVar));
                        i iVar = new i();
                        iVar.f = new JSONObject[]{parseObject};
                        iVar.b = 0;
                        g a = com.youku.arch.ntk.b.b().a(new h(), iVar);
                        if (a != null && (lVarArr = a.c) != null && lVarArr.length > 0 && (bVar = lVarArr[0].a[0]) != null) {
                            if (TextUtils.isEmpty(bVar.a) && !jn1.MUL.equals(bVar.a)) {
                                this.m = bVar.a;
                            }
                            this.o.add(Integer.valueOf(bVar.b[0]));
                            int[] iArr = bVar.b;
                            if (iArr[0] > 0) {
                                this.s = iArr[0];
                            }
                            if (this.o.size() > this.u) {
                                this.o.remove(0);
                            }
                        }
                        if (notiType == BasePlugin.NotiType.LOOP && this.q % com.youku.arch.probe.a.c.g == 1) {
                            d();
                        }
                    }
                }
            } else {
                this.f = j();
                i();
                this.e = false;
            }
            this.d.add(Integer.valueOf(this.r));
            if (this.d.size() > this.u) {
                this.d.remove(0);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.j = connectivityManager.isActiveNetworkMetered() ? 1 : 0;
            }
        }
        this.n = c();
        f();
        this.x = g();
        com.youku.b.a.a.a(str2, "trigger ends");
        AdapterForTLog.loge("speedtest", b());
    }

    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1280172546") ? (String) ipChange.ipc$dispatch("-1280172546", new Object[]{this}) : this.x;
    }

    public int c() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-58414284")) {
            return ((Integer) ipChange.ipc$dispatch("-58414284", new Object[]{this})).intValue();
        }
        if (!this.e) {
            if (this.r < 2) {
                return SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION;
            }
            return 1100;
        }
        if (!this.h.isEmpty()) {
            List<Integer> list = this.h;
            if (list.get(list.size() - 1).intValue() < com.youku.arch.probe.a.c.a) {
                return 1102;
            }
        }
        if (!this.o.isEmpty()) {
            for (Integer num : this.o) {
                int intValue = num.intValue();
                if (intValue < 0 || intValue > com.youku.arch.probe.a.c.c) {
                    i++;
                }
            }
            if ((i * 1.0d) / this.o.size() >= 0.5d) {
                return 1103;
            }
        }
        return 1100;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
        if (r4 == null) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00da A[EDGE_INSN: B:100:0x00da->B:51:0x00da ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bb A[Catch: all -> 0x00de, IOException -> 0x00e1, TryCatch #11 {IOException -> 0x00e1, all -> 0x00de, blocks: (B:42:0x00b0, B:43:0x00b5, B:45:0x00bb, B:47:0x00c3, B:49:0x00cb), top: B:89:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0104  */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.util.List, java.util.List<java.lang.String>] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x00f1 -> B:80:0x0108). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.probe.plugins.d.d():void");
    }

    public Map<String, Integer> e() {
        Integer valueOf;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "621362164")) {
            return (Map) ipChange.ipc$dispatch("621362164", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("isWifi", Integer.valueOf(this.e ? 1 : 0));
        if (this.e) {
            hashMap.put("rssi", Integer.valueOf(this.t));
            valueOf = Integer.valueOf(this.s);
            str = "rtt";
        } else {
            valueOf = Integer.valueOf(this.r);
            str = "signalStrength";
        }
        hashMap.put(str, valueOf);
        return hashMap;
    }
}
