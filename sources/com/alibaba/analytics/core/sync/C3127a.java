package com.alibaba.analytics.core.sync;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.C3109b;
import com.alibaba.analytics.core.config.C3115f;
import com.alibaba.analytics.core.config.timestamp.ConfigTimeStampMgr;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.C3143b;
import com.alibaba.analytics.utils.Logger;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.WXBridgeManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import tb.cv0;
import tb.ea2;
import tb.fa2;
import tb.jn1;
import tb.os2;
import tb.qe;
import tb.to2;
import tb.u6;
import tb.ut2;
import tb.xs2;
import tb.z02;

/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.sync.a */
/* loaded from: classes15.dex */
public class C3127a {
    public static final fa2 mMonitor = new fa2();
    static String a = null;
    private static long b = 0;
    private static boolean c = false;
    private static Class d = null;
    private static final String e = String.valueOf((char) 1);
    private static GZIPOutputStream f = null;
    private static ByteArrayOutputStream g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        b(f);
        b(g);
    }

    static void b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String c() {
        String format;
        String a2 = u6.a();
        Context j = Variables.n().j();
        String f2 = Variables.n().f();
        if (f2 == null) {
            f2 = "";
        }
        Map<String, String> b2 = xs2.b(j);
        String str = (b2 == null || (str = b2.get(LogField.APPVERSION.toString())) == null) ? "" : "";
        String b3 = u6.b();
        if (b3 == null) {
            b3 = "";
        }
        String str2 = b2 != null ? b2.get(LogField.UTDID.toString()) : "";
        String fullSDKVersion = os2.a().getFullSDKVersion();
        String str3 = to2.b().d() ? "1" : "0";
        if (Variables.n().M() && !C3109b.a()) {
            format = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s&ipv6=%s&dk=%s&ao=a", a2, f2, str, b3, str2, fullSDKVersion, str3, Variables.n().l());
        } else {
            format = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s&ipv6=%s&ao=a", a2, f2, str, b3, str2, fullSDKVersion, str3);
        }
        StringBuilder sb = new StringBuilder(format);
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ut_sample");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ut_sample"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("utap_system");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("utap_system"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ap_stat");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ap_stat"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ap_alarm");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ap_alarm"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ap_counter");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ap_counter"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ut_bussiness");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ut_bussiness"));
        sb.append("&");
        sb.append(JSMethod.NOT_SET);
        sb.append("ut_realtime");
        sb.append("=");
        sb.append(ConfigTimeStampMgr.c().b("ut_realtime"));
        if (!Variables.n().J()) {
            sb.append("&");
            sb.append("_sip");
            sb.append("=");
            sb.append(C3129c.b().d());
            sb.append("&");
            sb.append("_sipnw");
            sb.append("=");
            sb.append(C3129c.b().c());
            sb.append("&");
            sb.append("_fo");
            sb.append("=");
            sb.append(C3129c.b().a());
        }
        String sb2 = sb.toString();
        Logger.m("PostData", "send url :" + sb2);
        return sb2;
    }

    public static byte[] d(Map<String, String> map) throws Exception {
        return e(map, 1);
    }

    static byte[] e(Map<String, String> map, int i) throws Exception {
        byte[] a2;
        int i2;
        int i3;
        if (!Variables.n().I() && !Variables.n().J()) {
            C3130d.s();
            GZIPOutputStream gZIPOutputStream = f;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.write(h(map));
                f.flush();
                a2 = g.toByteArray();
                g.reset();
                i2 = 2;
            } else {
                a2 = cv0.a(h(map));
                i2 = 1;
            }
            i3 = 2;
        } else {
            a2 = cv0.a(g(map));
            i2 = 1;
            i3 = 1;
        }
        if (a2 == null) {
            return null;
        }
        if (a2.length >= 16777216) {
            if (Variables.n().O()) {
                mMonitor.onEvent(ea2.a(ea2.r, String.valueOf(a2.length), Double.valueOf(1.0d)));
            }
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(i3);
        byteArrayOutputStream.write(qe.e(a2.length));
        byteArrayOutputStream.write(i);
        byte b2 = (byte) (i2 | 8);
        if (Variables.n().M()) {
            b2 = (byte) (b2 | 16);
        }
        byteArrayOutputStream.write((byte) (b2 | 32));
        byteArrayOutputStream.write(0);
        if (Variables.n().J()) {
            byteArrayOutputStream.write(0);
        } else {
            String j = j(a2, i);
            Logger.f("BizRequest", WXBridgeManager.OPTIONS, j);
            if (j != null && !j.isEmpty()) {
                byteArrayOutputStream.write(1);
                byteArrayOutputStream.write(C3143b.f(j.getBytes().length));
                byteArrayOutputStream.write(j.getBytes());
            } else {
                byteArrayOutputStream.write(0);
            }
        }
        byteArrayOutputStream.write(a2);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            Logger.h(null, e2, new Object[0]);
        }
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] f(Map<String, String> map) throws Exception {
        return e(map, 2);
    }

    private static byte[] g(Map<String, String> map) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String c2 = c();
        if (c2 != null && c2.length() > 0) {
            byteArrayOutputStream.write(qe.d(c2.getBytes().length));
            byteArrayOutputStream.write(c2.getBytes());
        } else {
            byteArrayOutputStream.write(qe.d(0));
        }
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                try {
                    try {
                        byteArrayOutputStream.write(qe.f(Integer.valueOf(str).intValue()));
                        String str2 = map.get(str);
                        if (str2 != null) {
                            byteArrayOutputStream.write(qe.f(str2.getBytes().length));
                            byteArrayOutputStream.write(str2.getBytes());
                        } else {
                            byteArrayOutputStream.write(qe.f(0));
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Exception unused2) {
                    Logger.m("BizRequest", "EventId NumberFormatException. eventId", str, ",eventLogs", map.get(str));
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    private static byte[] h(Map<String, String> map) throws Exception {
        String[] split;
        String[] i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(C3143b.e(c()));
        if (map != null && map.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            for (String str : map.keySet()) {
                try {
                    try {
                        byteArrayOutputStream.write(C3143b.f(Integer.valueOf(str).intValue()));
                        String str2 = map.get(str);
                        if (str2 != null) {
                            for (String str3 : str2.split(e)) {
                                if (!TextUtils.isEmpty(str3) && (i = i(str3)) != null && 34 == i.length) {
                                    for (String str4 : i) {
                                        byteArrayOutputStream2.write(C3143b.c(str4));
                                    }
                                    byteArrayOutputStream2.write(0);
                                }
                            }
                            byteArrayOutputStream.write(C3143b.f(byteArrayOutputStream2.size()));
                            byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                            byteArrayOutputStream2.reset();
                        } else {
                            byteArrayOutputStream.write(0);
                        }
                    } catch (Exception unused) {
                        Logger.m("BizRequest", "EventId NumberFormatException. eventId", str, ",eventLogs", map.get(str));
                    }
                } catch (Throwable unused2) {
                }
            }
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return byteArray;
    }

    private static String[] i(String str) {
        String[] strArr = new String[34];
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= 33) {
                break;
            }
            int indexOf = str.indexOf(jn1.OR, i2);
            if (indexOf == -1) {
                strArr[i] = str.substring(i2);
                break;
            }
            strArr[i] = str.substring(i2, indexOf);
            i2 = indexOf + 2;
            i++;
        }
        strArr[33] = str.substring(i2);
        return strArr;
    }

    private static String j(byte[] bArr, int i) {
        HashMap<String, String> c2;
        if (i == 2 || !C3115f.a() || (c2 = ut2.b().c()) == null || c2.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : c2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            value = (value == null || value.isEmpty()) ? "" : "";
            if (z) {
                sb.append(key);
                sb.append("=");
                sb.append(value);
                z = false;
            } else {
                sb.append("&");
                sb.append(key);
                sb.append("=");
                sb.append(value);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    public static void k() {
        if (Build.VERSION.SDK_INT >= 19) {
            a();
            g = new ByteArrayOutputStream();
            try {
                f = new GZIPOutputStream((OutputStream) g, true);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(byte[] bArr) {
        int i = -1;
        if (bArr != null && bArr.length >= 12) {
            b = bArr.length;
            if (qe.b(bArr, 1, 3) + 8 != bArr.length) {
                Logger.i("", "recv len error");
            } else {
                boolean z = 1 == (bArr[5] & 1);
                int b2 = qe.b(bArr, 8, 4);
                int length = bArr.length - 12 >= 0 ? bArr.length - 12 : 0;
                if (length <= 0) {
                    a = null;
                } else if (z) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 12, bArr2, 0, length);
                    byte[] b3 = cv0.b(bArr2);
                    a = new String(b3, 0, b3.length);
                } else {
                    a = new String(bArr, 12, length);
                }
                i = b2;
            }
        } else {
            Logger.i("", "recv errCode UNKNOWN_ERROR");
        }
        if (107 == i) {
            Variables.n().X(true);
        }
        if (109 == i) {
            Variables.n().W(true);
        }
        if (115 == i) {
            Variables.n().b0(true);
        }
        if (116 == i) {
            Variables.n().Q(true);
        }
        Logger.f("", "errCode", Integer.valueOf(i));
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(long j) {
        Object c2;
        try {
            Context j2 = Variables.n().j();
            if (j2 != null) {
                if (!c && d != null) {
                    d = Class.forName("com.taobao.analysis.FlowCenter");
                    c = true;
                }
                Class cls = d;
                if (cls != null && (c2 = z02.c(cls, "getInstance")) != null) {
                    Logger.f("", "sendBytes", Long.valueOf(j), "mReceivedDataLen", Long.valueOf(b));
                    Object[] objArr = {j2, "ut", Boolean.TRUE, "ut", Long.valueOf(j), Long.valueOf(b)};
                    Class cls2 = Long.TYPE;
                    z02.b(c2, "commitFlow", objArr, Context.class, String.class, Boolean.TYPE, String.class, cls2, cls2);
                }
            }
        } catch (Throwable unused) {
        }
        b = 0L;
    }
}
