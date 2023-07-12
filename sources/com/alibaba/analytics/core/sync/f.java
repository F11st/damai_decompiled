package com.alibaba.analytics.core.sync;

import android.os.SystemClock;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.core.sync.UploadLog;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.ea2;
import tb.fa2;
import tb.gi1;
import tb.qa1;
import tb.qo2;
import tb.tc;
import tb.to2;
import tb.vo2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class f extends UploadLog {
    private static f o;
    private volatile boolean d = false;
    private int e = -1;
    private int f = 0;
    private float g = 200.0f;
    private int h = 0;
    private long i = 0;
    private boolean j = false;
    protected int k = -1;
    public final fa2 l = new fa2();
    private boolean m = true;
    private boolean n = true;

    private List<qa1> f(List<qa1> list, qa1 qa1Var) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(qa1Var);
        return list;
    }

    private Map<String, String> g(List<qa1> list) {
        HashMap hashMap = null;
        List<qa1> list2 = null;
        hashMap = null;
        if (list != null && list.size() != 0) {
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList = null;
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                qa1 qa1Var = list.get(i2);
                if (i > 5242880) {
                    list2 = f(list2, qa1Var);
                    Logger.f("UploadLogFromDB", "log delay to upload because totalUploadSize Exceed. log", qa1Var, "totalUploadSize", Integer.valueOf(i));
                } else if (SystemConfigMgr.i().g() && SystemConfigMgr.i().e(com.alibaba.analytics.core.logbuilder.a.e(qa1Var.b()))) {
                    list2 = f(list2, qa1Var);
                    if (list.get(i2).b.compareToIgnoreCase("3") >= 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(list.get(i2));
                    }
                    Logger.f("UploadLogFromDB", "log delay to upload because delay config. log", qa1Var);
                } else {
                    StringBuilder sb = (StringBuilder) hashMap2.get(qa1Var.a);
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap2.put(qa1Var.a, sb);
                    } else {
                        sb.append((char) 1);
                        i++;
                    }
                    String b = list.get(i2).b();
                    sb.append(b);
                    i += b.length();
                }
            }
            if (list2 != null) {
                list.removeAll(list2);
            }
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ((qa1) arrayList.get(i3)).b = "2";
                }
                LogStoreMgr.l().p(arrayList);
            }
            hashMap = new HashMap();
            this.h = i;
            for (String str : hashMap2.keySet()) {
                hashMap.put(str, ((StringBuilder) hashMap2.get(str)).toString());
            }
            if (list.size() > 0) {
                this.g = this.h / list.size();
            }
            Logger.f("UploadLogFromDB", "averagePackageSize", Float.valueOf(this.g), "mUploadByteSize", Integer.valueOf(this.h), AdUtConstants.XAD_UT_ARG_COUNT, Integer.valueOf(list.size()));
        }
        return hashMap;
    }

    private int h(Boolean bool, long j) {
        if (j < 0) {
            return this.e;
        }
        float f = this.h / ((float) j);
        if (!bool.booleanValue()) {
            this.e /= 2;
            this.f++;
        } else if (j > 45000) {
            return this.e;
        } else {
            this.e = (int) (((f * 45000.0f) / this.g) - this.f);
        }
        int i = this.e;
        if (i < 1) {
            this.e = 1;
            this.f = 0;
        } else if (i > 350) {
            this.e = 350;
        }
        Logger.f("UploadLogFromDB", "winsize", Integer.valueOf(this.e));
        return this.e;
    }

    public static f i() {
        if (o == null) {
            synchronized (f.class) {
                if (o == null) {
                    o = new f();
                }
            }
        }
        return o;
    }

    private void l() {
        int i = this.e / 2;
        this.e = i;
        if (i < 1) {
            this.e = 1;
            this.f = 0;
        } else if (i > 350) {
            this.e = 350;
        }
        Logger.f("UploadLogFromDB", "winsize", Integer.valueOf(this.e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n() {
        Logger.d();
        if (!NetworkUtil.m(Variables.n().j())) {
            Logger.f("UploadLogFromDB", "Network is Disconnected");
            return;
        }
        UploadLog.NetworkStatus networkStatus = UploadLog.NetworkStatus.ALL;
        UploadLog.NetworkStatus networkStatus2 = this.c;
        if (networkStatus != networkStatus2 && networkStatus2 != a()) {
            Logger.v("UploadLogFromDB", "current networkstatus", a(), "mAllowedNetworkStatus", this.c);
        } else if (this.d) {
        } else {
            this.d = true;
            try {
                this.i = 0L;
            } finally {
                try {
                    return;
                } finally {
                }
            }
            if (!gi1.a(Variables.n().j())) {
                Logger.f("UploadLogFromDB", "Other Process is Uploading, break");
                return;
            }
            List<qa1> k = LogStoreMgr.l().k(j());
            if (k != null && k.size() != 0) {
                if (this.k <= 0) {
                    this.k = this.a;
                }
                Logger.f("UploadLogFromDB", "mUploadIndex", Integer.valueOf(this.k), "mMaxUploadTimes", Integer.valueOf(this.a));
                if (o(k, this.k == this.a)) {
                    this.k = this.a;
                } else {
                    int i = this.k - 1;
                    this.k = i;
                    if (i > 0) {
                        UploadQueueMgr.getInstance().add("i");
                    } else {
                        this.k = this.a;
                    }
                }
                return;
            }
            Logger.f("UploadLogFromDB", "logs is null");
            this.k = this.a;
            this.d = false;
        }
    }

    private boolean o(List<qa1> list, boolean z) throws Exception {
        byte[] bArr;
        tc v;
        String str;
        Logger.f("UploadLogFromDB", "firstRequest", Boolean.valueOf(z), "firstLaunch", Boolean.valueOf(this.m));
        this.m = false;
        Map<String, String> g = g(list);
        if (g != null && g.size() != 0) {
            if (!Variables.n().J()) {
                if (this.n && z && c.b().d() == 2 && c.b().c() == 0 && vo2.b().c() == 0 && vo2.b().a() > 0) {
                    Logger.f("UploadLogFromDB", "forceCloseSession");
                    d.q();
                    this.n = false;
                }
                if (d.w()) {
                    qo2 e = c.b().e();
                    Logger.f("UploadLogFromDB", "CreateSession tnet host", e.a(), "port", Integer.valueOf(e.b()), "type", Integer.valueOf(e.d()));
                    if (e.d() == 1) {
                        to2.b().g(true);
                    } else {
                        to2.b().g(false);
                    }
                } else {
                    qo2 f = c.b().f();
                    Logger.f("UploadLogFromDB", "TempSession tnet host", f.a(), "port", Integer.valueOf(f.b()), "type", Integer.valueOf(f.d()));
                }
            } else {
                to2.b().g(false);
            }
            try {
                bArr = a.d(g);
            } catch (Exception e2) {
                Logger.i(null, e2.toString());
                bArr = null;
            }
            if (bArr == null) {
                l();
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Variables.n().J()) {
                v = h.a(bArr);
            } else {
                v = d.v(bArr);
                v.f = z;
            }
            boolean a = v.a();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j = elapsedRealtime2 - elapsedRealtime;
            h(Boolean.valueOf(a), j);
            c.b().g(v);
            if (a) {
                Variables.n().t0();
                this.j = true;
                str = "UploadLogFromDB";
                this.i += LogStoreMgr.l().i(list);
                if (Variables.n().O()) {
                    this.l.onEvent(ea2.a(ea2.k, null, Double.valueOf(this.h)));
                }
                try {
                    b(v.e);
                } catch (Exception unused) {
                }
            } else {
                str = "UploadLogFromDB";
                if (Variables.n().O()) {
                    if (this.j && !Variables.n().J()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("rt", String.valueOf(v.c));
                        hashMap.put("pSize", String.valueOf(this.h));
                        hashMap.put("errCode", String.valueOf(v.a));
                        hashMap.put("type", "1");
                        this.l.onEvent(ea2.a(ea2.j, JSON.toJSONString(hashMap), Double.valueOf(1.0d)));
                    } else {
                        Variables.n().q0();
                    }
                }
            }
            Object[] objArr = {"isSendSuccess", Boolean.valueOf(a), "upload log count", Integer.valueOf(list.size()), "upload consume", Long.valueOf(j), "delete consume", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime2)};
            String str2 = str;
            Logger.m(str2, objArr);
            try {
                Thread.sleep(100L);
            } catch (Throwable th) {
                Logger.u(str2, th, new Object[0]);
            }
            return false;
        }
        Logger.f("UploadLogFromDB", "postDataMap is null");
        this.d = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        if (this.e == -1) {
            k();
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        String h = NetworkUtil.h();
        if ("Wi-Fi".equalsIgnoreCase(h)) {
            this.e = 50;
        } else if ("4G".equalsIgnoreCase(h)) {
            this.e = 40;
        } else if ("3G".equalsIgnoreCase(h)) {
            this.e = 30;
        } else {
            this.e = 40;
        }
        this.f = 0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001d -> B:17:0x0022). Please submit an issue!!! */
    public void m() {
        try {
            if (!Variables.n().F()) {
                n();
            } else {
                Logger.v("UploadLogFromDB", "isAllServiceClosed");
            }
        } catch (Throwable th) {
            Logger.h("UploadLogFromDB", th, new Object[0]);
        }
        try {
            IUploadExcuted iUploadExcuted = this.b;
            if (iUploadExcuted != null) {
                iUploadExcuted.onUploadExcuted(this.i);
            }
        } catch (Throwable th2) {
            Logger.h("UploadLogFromDB", th2, new Object[0]);
        }
    }
}
