package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.util.ALog;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.utl.BaseMonitor;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.C9708t9;
import tb.lw2;
import tb.y90;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.b */
/* loaded from: classes.dex */
public class C0214b {

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$a */
    /* loaded from: classes.dex */
    public static class C0215a {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final String g;
        public final String h;

        public C0215a(JSONObject jSONObject) {
            this.a = jSONObject.optInt("port");
            this.b = jSONObject.optString("protocol");
            this.c = jSONObject.optInt("cto");
            this.d = jSONObject.optInt("rto");
            this.e = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_RETRY);
            this.f = jSONObject.optInt("heartbeat");
            this.g = jSONObject.optString("rtt", "");
            this.h = jSONObject.optString("publickey");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$b */
    /* loaded from: classes.dex */
    public static class C0216b {
        public String[] a;
        public C0217c[] b;
        public boolean c;

        public C0216b(JSONObject jSONObject) {
            this.c = false;
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.a = new String[length];
                for (int i = 0; i < length; i++) {
                    this.a[i] = optJSONArray.optString(i);
                    if (lw2.d(this.a[i])) {
                        this.c = true;
                    }
                }
            } else {
                this.a = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("attributes");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.b = new C0217c[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    this.b[i2] = new C0217c(optJSONArray2.optJSONObject(i2));
                }
                return;
            }
            this.b = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$c */
    /* loaded from: classes.dex */
    public static class C0217c {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final String g;
        public final String h;

        public C0217c(JSONObject jSONObject) {
            this.a = jSONObject.optInt("port");
            this.b = jSONObject.optString("protocol");
            this.c = jSONObject.optInt("cto");
            this.d = jSONObject.optInt("rto");
            this.e = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_RETRY);
            this.f = jSONObject.optInt("heartbeat");
            this.h = jSONObject.optString("publickey");
            this.g = jSONObject.optString("rtt");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$d */
    /* loaded from: classes.dex */
    public static class C0218d {
        public String a;
        public int b;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public boolean g;
        public int h;
        public boolean i;
        public HashMap<String, Boolean> j;
        public C0223i[] k;
        public int l;

        public C0218d(JSONObject jSONObject) {
            this.a = jSONObject.optString("host");
            this.b = jSONObject.optInt(RemoteMessageConst.TTL);
            this.c = jSONObject.optString("safeAisles");
            this.d = jSONObject.optString("cname", null);
            this.e = jSONObject.optString("unit", null);
            this.f = jSONObject.optInt(Constants.TAG_CLEAR_STRING) == 1;
            this.g = jSONObject.optBoolean("effectNow");
            this.h = jSONObject.optInt("version");
            this.l = jSONObject.optInt("um");
            JSONArray optJSONArray = jSONObject.optJSONArray("servers");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.k = new C0223i[length];
                for (int i = 0; i < length; i++) {
                    this.k[i] = new C0223i(optJSONArray.optJSONObject(i));
                }
            } else {
                this.k = null;
            }
            if (this.k != null) {
                int i2 = 0;
                while (true) {
                    C0223i[] c0223iArr = this.k;
                    if (i2 >= c0223iArr.length) {
                        break;
                    }
                    C0216b[] c0216bArr = c0223iArr[i2].a;
                    if (c0216bArr != null && c0216bArr.length > 0) {
                        this.i = c0216bArr[0] != null ? c0216bArr[0].c : false;
                    }
                    i2++;
                }
            }
            String optString = jSONObject.optString(y90.AB_STRATEGY);
            if (!TextUtils.isEmpty(optString)) {
                this.j = new HashMap<>();
                String[] split = optString.split(",");
                if (split == null || split.length <= 0) {
                    return;
                }
                for (String str : split) {
                    String[] split2 = str.split("=");
                    if (split2 != null && split2.length == 2) {
                        try {
                            this.j.put(split2[0], Boolean.valueOf(Integer.parseInt(split2[1]) == 1));
                        } catch (Exception unused) {
                        }
                    }
                }
                return;
            }
            this.j = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$e */
    /* loaded from: classes.dex */
    public static class C0219e {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;
        public final String[] f;
        public final String[] g;
        public final C0215a[] h;
        public final C0224j[] i;
        public final boolean j;
        public final boolean k;
        public final int l;
        public final boolean m;
        public final HashMap<String, Boolean> n;
        public final int o;

        public C0219e(JSONObject jSONObject) {
            boolean z;
            this.a = jSONObject.optString("host");
            this.b = jSONObject.optInt(RemoteMessageConst.TTL);
            this.c = jSONObject.optString("safeAisles");
            this.d = jSONObject.optString("cname", null);
            this.e = jSONObject.optString("unit", null);
            this.j = jSONObject.optInt(Constants.TAG_CLEAR_STRING) == 1;
            this.k = jSONObject.optBoolean("effectNow");
            this.l = jSONObject.optInt("version");
            this.o = jSONObject.optInt("um");
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f = new String[length];
                z = false;
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!z) {
                        z = lw2.d(optString);
                    }
                    this.f[i] = optString;
                }
            } else {
                this.f = null;
                z = false;
            }
            this.m = z;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sips");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int length2 = optJSONArray2.length();
                this.g = new String[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    this.g[i2] = optJSONArray2.optString(i2);
                }
            } else {
                this.g = null;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("aisles");
            if (optJSONArray3 != null) {
                int length3 = optJSONArray3.length();
                this.h = new C0215a[length3];
                for (int i3 = 0; i3 < length3; i3++) {
                    this.h[i3] = new C0215a(optJSONArray3.optJSONObject(i3));
                }
            } else {
                this.h = null;
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("strategies");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                int length4 = optJSONArray4.length();
                this.i = new C0224j[length4];
                for (int i4 = 0; i4 < length4; i4++) {
                    this.i[i4] = new C0224j(optJSONArray4.optJSONObject(i4));
                }
            } else {
                this.i = null;
            }
            String optString2 = jSONObject.optString(y90.AB_STRATEGY);
            if (!TextUtils.isEmpty(optString2)) {
                this.n = new HashMap<>();
                String[] split = optString2.split(",");
                if (split == null || split.length <= 0) {
                    return;
                }
                for (String str : split) {
                    String[] split2 = str.split("=");
                    if (split2 != null && split2.length == 2) {
                        try {
                            this.n.put(split2[0], Boolean.valueOf(Integer.parseInt(split2[1]) == 1));
                        } catch (Exception unused) {
                        }
                    }
                }
                return;
            }
            this.n = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$f */
    /* loaded from: classes.dex */
    public static class C0220f {
        public final String a;
        public final C0224j[] b;

        public C0220f(JSONObject jSONObject) {
            this.a = jSONObject.optString("host");
            JSONArray optJSONArray = jSONObject.optJSONArray("strategies");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.b = new C0224j[length];
                for (int i = 0; i < length; i++) {
                    this.b[i] = new C0224j(optJSONArray.optJSONObject(i));
                }
                return;
            }
            this.b = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$g */
    /* loaded from: classes.dex */
    public static class C0221g {
        public final String a;
        public C0219e[] b;
        public C0218d[] c;
        public final C0220f[] d;
        public final int e;
        public final int f;
        public final int g;
        public final String h;

        public C0221g(JSONObject jSONObject) {
            this.a = jSONObject.optString(TbAuthConstants.IP);
            jSONObject.optString("uid", null);
            jSONObject.optString("utdid", null);
            this.e = jSONObject.optInt(y90.CONFIG_VERSION);
            this.f = jSONObject.optInt("fcl");
            this.g = jSONObject.optInt("fct");
            this.h = jSONObject.optString("accessPoint");
            JSONArray optJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                if (C9708t9.N()) {
                    this.c = new C0218d[length];
                    for (int i = 0; i < length; i++) {
                        this.c[i] = new C0218d(optJSONArray.optJSONObject(i));
                    }
                } else {
                    this.b = new C0219e[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        this.b[i2] = new C0219e(optJSONArray.optJSONObject(i2));
                    }
                }
            } else {
                this.b = null;
                this.c = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.d = new C0220f[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.d[i3] = new C0220f(optJSONArray2.optJSONObject(i3));
                }
                return;
            }
            this.d = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$h */
    /* loaded from: classes.dex */
    static class C0222h {
        C0216b[] a;

        public C0222h(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray("channels");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.a = new C0216b[length];
                for (int i = 0; i < length; i++) {
                    this.a[i] = new C0216b(optJSONArray.optJSONObject(i));
                }
                return;
            }
            this.a = null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$i */
    /* loaded from: classes.dex */
    public static class C0223i {
        public C0216b[] a;
        public C0222h[] b;
        public boolean c;

        public C0223i(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray("channels");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.a = new C0216b[length];
                for (int i = 0; i < length; i++) {
                    this.a[i] = new C0216b(optJSONArray.optJSONObject(i));
                }
            } else {
                this.a = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("proxies");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.b = new C0222h[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    this.b[i2] = new C0222h(optJSONArray2.optJSONObject(i2));
                }
            } else {
                this.b = null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("labels");
            if (optJSONObject != null) {
                this.c = "bgp-static".equalsIgnoreCase(optJSONObject.optString("networkRouteProtocolType"));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.b$j */
    /* loaded from: classes.dex */
    public static class C0224j {
        public final String a;
        public final C0215a b;
        public final String c;

        public C0224j(JSONObject jSONObject) {
            this.a = jSONObject.optString(TbAuthConstants.IP);
            this.c = jSONObject.optString(AbstractC3893a.V);
            this.b = new C0215a(jSONObject);
        }
    }

    public static C0221g a(JSONObject jSONObject) {
        try {
            return new C0221g(jSONObject);
        } catch (Exception e) {
            ALog.d("StrategyResultParser", "Parse HttpDns response failed.", null, e, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
