package com.youku.arch.probe.plugins;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.probe.plugins.BasePlugin;
import com.youku.network.c.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import ntk.dns.DnsEngine;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class b extends BasePlugin implements a.InterfaceC0395a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String c = "b";
    public static int h = 2;
    private volatile String A;
    private volatile String B;
    private int C;
    private Map<String, String> D;
    private boolean E;
    private volatile int F;
    private int G;
    private volatile String H;
    private int I;
    private int J;
    private int K;
    private List<Integer> L;
    private double M;
    private double N;
    private double O;
    public volatile int d;
    public volatile int e;
    public volatile int f;
    public volatile int g;
    int i;
    private List<com.youku.arch.probe.b.b> j;
    private volatile com.youku.arch.probe.b.b k;
    private volatile int l;
    private volatile int m;
    private volatile double n;
    private volatile long o;
    private List<Integer> p;
    private List<Integer> q;
    private volatile double r;
    private volatile double s;
    private double t;
    private double u;
    private double v;
    private int w;
    private volatile int x;
    private volatile String y;
    private volatile String z;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class a {
        public String a;
        public String b;
        public long c;
        public long d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public int j;
    }

    public static String a(ArrayList<Double> arrayList, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1904505113")) {
            return (String) ipChange.ipc$dispatch("-1904505113", new Object[]{arrayList, Double.valueOf(d)});
        }
        int size = arrayList.size();
        if (size == 0) {
            return "-1";
        }
        if (size == 1) {
            return arrayList.get(0).toString();
        }
        double d2 = ((size - 1) * (d / 100.0d)) + 1.0d;
        int i = (int) d2;
        int i2 = i - 1;
        return String.format(Locale.ENGLISH, "%.2f", Double.valueOf(arrayList.get(i2).doubleValue() + ((arrayList.get(i).doubleValue() - arrayList.get(i2).doubleValue()) * (d2 - i))));
    }

    private void a(com.youku.arch.probe.b.b bVar, String str) {
        int i;
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753542253")) {
            ipChange.ipc$dispatch("753542253", new Object[]{this, bVar, str});
        } else if (!TextUtils.isEmpty(str)) {
            String[] split2 = str.split(";");
            if (split2.length > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (String str2 : split2) {
                    for (String str3 : str2.split("&")) {
                        if (str3.contains("tcpi_rtt=") && !TextUtils.isEmpty(str3.substring(9))) {
                            arrayList.add(Long.valueOf(Long.parseLong(str3.substring(9))));
                        }
                        if (str3.contains("tcpi_rttvar=") && !TextUtils.isEmpty(str3.substring(12))) {
                            arrayList2.add(Long.valueOf(Long.parseLong(str3.substring(12))));
                        }
                        if (str3.contains("tcpi_speed=") && !TextUtils.isEmpty(str3.substring(11))) {
                            arrayList3.add(Long.valueOf((long) (Double.parseDouble(str3.substring(11)) / 1000.0d)));
                        }
                        if (str3.contains("tcpi_lastrev=") && !TextUtils.isEmpty(str3.substring(13))) {
                            arrayList4.add(Long.valueOf(Long.parseLong(str3.substring(13))));
                        }
                    }
                }
                Collections.sort(arrayList);
                Collections.sort(arrayList3);
                Collections.sort(arrayList4);
                Collections.sort(arrayList2);
                if (arrayList.size() > 0) {
                    bVar.b = ((Long) arrayList.get(arrayList.size() / 2)).longValue();
                }
                if (arrayList2.size() > 0) {
                    bVar.c = ((Long) arrayList2.get(arrayList2.size() / 2)).longValue();
                }
                if (arrayList3.size() > 0) {
                    i = 1;
                    bVar.d = ((Long) arrayList3.get(arrayList3.size() - 1)).longValue();
                } else {
                    i = 1;
                }
                if (arrayList4.size() > 0) {
                    bVar.e = ((Long) arrayList4.get(arrayList4.size() - i)).longValue();
                }
            }
        }
    }

    private String g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363966591")) {
            return (String) ipChange.ipc$dispatch("-363966591", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder("mtop_rt:");
        StringBuilder sb2 = new StringBuilder("nc_rt:");
        StringBuilder sb3 = new StringBuilder("nc_rt_var:");
        StringBuilder sb4 = new StringBuilder("tcpi_speed:");
        StringBuilder sb5 = new StringBuilder("tcpi_last_recv:");
        StringBuilder sb6 = new StringBuilder("rx_byte:");
        for (com.youku.arch.probe.b.b bVar : this.j) {
            sb.append(bVar.a);
            sb.append("|");
            sb2.append(bVar.b);
            sb2.append("|");
            sb3.append(bVar.c);
            sb3.append("|");
            sb4.append(bVar.d);
            sb4.append("|");
            sb5.append(bVar.e);
            sb5.append("|");
            sb6.append(bVar.f);
            sb6.append("|");
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append((CharSequence) sb);
        sb7.append(",");
        sb7.append((CharSequence) sb2);
        sb7.append(",");
        sb7.append((CharSequence) sb3);
        sb7.append(",");
        sb7.append((CharSequence) sb4);
        sb7.append(",");
        sb7.append((CharSequence) sb5);
        sb7.append(",");
        sb7.append("traffic_info:");
        sb7.append(this.q);
        sb7.append(",");
        sb7.append((CharSequence) sb6);
        sb7.append(",");
        sb7.append("nc_type:");
        sb7.append(this.d);
        sb7.append(",last_speed:");
        sb7.append(this.r);
        sb7.append(",cur_hh_bw:");
        sb7.append(this.z);
        sb7.append(",bw_day:");
        sb7.append(this.C);
        if (com.youku.arch.probe.a.a.r > 0) {
            sb7.append(",fre_4G_bw:");
            sb7.append(this.A);
            sb7.append(",fre_4G_t:");
            sb7.append(this.B);
        }
        return sb7.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751081310")) {
            ipChange.ipc$dispatch("751081310", new Object[]{this});
        } else if (this.b != null) {
            File file = new File(this.b.getFilesDir().getAbsolutePath(), "NetBW.log");
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public com.youku.arch.analysis.net.a a(com.youku.arch.analysis.net.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656040053")) {
            return (com.youku.arch.analysis.net.a) ipChange.ipc$dispatch("-1656040053", new Object[]{this, aVar});
        }
        if (aVar == null) {
            return null;
        }
        aVar.c = this.e;
        aVar.d = this.f;
        aVar.e = this.g;
        return aVar;
    }

    public String a(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454883065")) {
            return (String) ipChange.ipc$dispatch("-1454883065", new Object[]{this, Boolean.valueOf(z), str});
        }
        if (this.E) {
            if (!z) {
                str = "4G";
            } else if (str == null || !com.youku.arch.probe.a.b.a(str)) {
                str = "unknown";
            }
            String str2 = this.D.containsKey(str) ? this.D.get(str) : "";
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "";
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750872773")) {
            ipChange.ipc$dispatch("750872773", new Object[]{this});
        } else {
            com.youku.network.c.a.a(this);
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a(BasePlugin.NotiType notiType) {
        int i;
        List list;
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557916471")) {
            ipChange.ipc$dispatch("557916471", new Object[]{this, notiType});
            return;
        }
        this.I++;
        com.youku.arch.probe.b.b bVar = new com.youku.arch.probe.b.b();
        synchronized (this) {
            bVar.a = this.l;
            this.l = 0;
            Collections.sort(this.L);
            if (this.L.size() > 0) {
                List<Integer> list2 = this.L;
                i = list2.get(list2.size() / 2).intValue();
            } else {
                i = 0;
            }
            this.L.clear();
        }
        if (i > 0) {
            this.m = i;
            this.n = System.currentTimeMillis() / 1000;
        }
        if (this.F == 1) {
            long totalRxBytes = TrafficStats.getTotalRxBytes();
            if (this.o > totalRxBytes) {
                this.o = 0L;
            }
            if (this.o > 0) {
                long j = ((totalRxBytes - this.o) / 1000) / this.J;
                bVar.f = j;
                if (j >= com.youku.arch.probe.a.c.j && this.p.size() < 6) {
                    this.p.add(Integer.valueOf((int) bVar.f));
                } else if (!this.p.isEmpty()) {
                    int i2 = 0;
                    for (Integer num2 : this.p) {
                        i2 += num2.intValue();
                    }
                    if (i2 * this.J > com.youku.arch.probe.a.c.i) {
                        Collections.sort(this.p);
                        if (this.p.size() == 6) {
                            list = this.q;
                            List<Integer> list3 = this.p;
                            num = list3.get(list3.size() / 2);
                        } else {
                            list = this.q;
                            List<Integer> list4 = this.p;
                            num = list4.get(list4.size() - 1);
                        }
                        list.add(num);
                        if (this.q.size() > 3) {
                            this.q.remove(0);
                        }
                    }
                    this.p.clear();
                }
            }
            this.o = totalRxBytes;
        } else {
            this.o = -1L;
            this.p.clear();
        }
        if (this.k != null) {
            this.k.f = bVar.f;
        }
        if (notiType == BasePlugin.NotiType.LOOP && this.I % h == 1) {
            a(bVar, DnsEngine.getInstance().dumpTcpInfo());
            this.j.add(bVar);
            this.k = bVar;
            if (this.j.size() > this.G) {
                this.j.remove(0);
            }
            c();
            this.H = g();
            AdapterForTLog.loge("speedtest", b());
        }
    }

    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1420721156") ? (String) ipChange.ipc$dispatch("-1420721156", new Object[]{this}) : this.H;
    }

    public void c() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "750932355")) {
            ipChange.ipc$dispatch("750932355", new Object[]{this});
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.j.size(); i6++) {
            if (this.j.get(i6).a > 0) {
                if (this.j.get(i6).a > com.youku.arch.probe.a.c.d) {
                    i3++;
                }
                i2++;
            }
            if (this.j.get(i6).b > 0) {
                if (this.j.get(i6).b > com.youku.arch.probe.a.c.e) {
                    i5++;
                }
                i4++;
            }
        }
        int i7 = i4;
        if (i2 > 0) {
            double d = (i3 * 1.0d) / i2;
            if (d > 0.5d) {
                this.e = 1;
            } else if (d > 0.2d) {
                this.e = 2;
            } else {
                this.e = 3;
            }
        } else {
            this.e = 0;
        }
        if (i7 > 0) {
            double d2 = (i5 * 1.0d) / i7;
            if (d2 > 0.5d) {
                this.f = 1;
            } else if (d2 > 0.2d) {
                this.f = 2;
            } else {
                this.f = 3;
            }
            i = 0;
        } else {
            i = 0;
            this.f = 0;
        }
        this.g = i;
        if (this.q.size() > 0) {
            ArrayList arrayList = new ArrayList(this.q);
            Collections.sort(arrayList);
            if (((Integer) arrayList.get(this.q.size() / 2)).intValue() < com.youku.arch.probe.a.c.f) {
                this.g = 1;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:6|(3:7|8|9)|(2:11|(20:13|14|15|17|18|20|21|(2:23|(16:25|27|28|29|30|31|32|(1:34)(2:63|(1:65))|35|(2:(2:(1:(2:40|(6:42|43|(1:45)|46|(1:48)|49)(1:50))(1:55))(2:57|(1:59))|52)|60)(2:(6:62|43|(0)|46|(0)|49)|60)|53|43|(0)|46|(0)|49))|72|31|32|(0)(0)|35|(0)(0)|53|43|(0)|46|(0)|49))|82|20|21|(0)|72|31|32|(0)(0)|35|(0)(0)|53|43|(0)|46|(0)|49) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        r9 = -1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c6, code lost:
        if (r9 > 0.0d) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00cf, code lost:
        if (r9 > 0.0d) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d1, code lost:
        r20 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: NumberFormatException -> 0x0083, TryCatch #4 {NumberFormatException -> 0x0083, blocks: (B:21:0x0050, B:23:0x0058, B:25:0x005f), top: B:86:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] d() {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.probe.plugins.b.d():double[]");
    }

    public String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786668417")) {
            return (String) ipChange.ipc$dispatch("-786668417", new Object[]{this});
        }
        String str = this.y;
        return "4G".equals(str) ? a(false, str) : a(true, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Long> f() {
        /*
            r7 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.probe.plugins.b.$ipChange
            java.lang.String r1 = "-594564907"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r3 = 0
            r2[r3] = r7
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.util.Map r0 = (java.util.Map) r0
            return r0
        L17:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = r7.m
            long r1 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "mtop_rt"
            r0.put(r2, r1)
            double r1 = r7.n
            long r1 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "mtop_time"
            r0.put(r2, r1)
            com.youku.arch.probe.b.b r1 = r7.k
            r4 = 0
            if (r1 == 0) goto L3f
            com.youku.arch.probe.b.b r1 = r7.k
            long r1 = r1.b
            goto L40
        L3f:
            r1 = r4
        L40:
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "ntk_rt"
            r0.put(r2, r1)
            com.youku.arch.probe.b.b r1 = r7.k
            if (r1 == 0) goto L52
            com.youku.arch.probe.b.b r1 = r7.k
            long r1 = r1.e
            goto L54
        L52:
            r1 = -1
        L54:
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "ntk_last_rc"
            r0.put(r2, r1)
            int r1 = r7.x
            long r1 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "isNtk"
            r0.put(r2, r1)
            double r1 = r7.r
            long r1 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "lastSpeed"
            r0.put(r2, r1)
            double r1 = r7.s
            long r1 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "lastSpeedTime"
            r0.put(r2, r1)
            java.lang.String r1 = r7.e()
            if (r1 == 0) goto L99
            java.lang.String r2 = "/"
            java.lang.String[] r1 = r1.split(r2)
            int r2 = r1.length
            r6 = 3
            if (r2 < r6) goto L99
            r1 = r1[r3]
            double r1 = java.lang.Double.parseDouble(r1)
            long r1 = (long) r1
            goto L9a
        L99:
            r1 = r4
        L9a:
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "historySpeed"
            r0.put(r2, r1)
            com.youku.arch.probe.b.b r1 = r7.k
            if (r1 == 0) goto Lac
            com.youku.arch.probe.b.b r1 = r7.k
            long r1 = r1.f
            goto Lad
        Lac:
            r1 = r4
        Lad:
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "traffic"
            r0.put(r2, r1)
            com.youku.arch.probe.b.b r1 = r7.k
            if (r1 == 0) goto Lbe
            com.youku.arch.probe.b.b r1 = r7.k
            long r4 = r1.d
        Lbe:
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.String r2 = "tcpSpeed"
            r0.put(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.probe.plugins.b.f():java.util.Map");
    }
}
