package anet.channel.strategy.dispatch;

import android.util.Base64InputStream;
import anet.channel.detect.Ipv6Detector;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.ALog;
import anet.channel.util.Inet64Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import tb.hu0;
import tb.jg1;
import tb.jn1;
import tb.ln0;
import tb.lw2;
import tb.qj1;
import tb.t9;
import tb.x6;
import tb.y90;
import tb.ym;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a {
    static AtomicInteger a = new AtomicInteger(0);
    static HostnameVerifier b = new C0016a();
    static Random c = new Random();

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.dispatch.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0016a implements HostnameVerifier {
        C0016a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(y90.a(), sSLSession);
        }
    }

    private static String a(String str, String str2, int i, Map<String, String> map, int i2) {
        StringBuilder sb = new StringBuilder(64);
        if (i2 == 2 && "https".equalsIgnoreCase(str) && c.nextBoolean()) {
            str = "http";
        }
        sb.append(str);
        sb.append(jg1.SCHEME_SLASH);
        if (str2 != null) {
            if (t9.k() && Inet64Util.p() && lw2.c(str2)) {
                try {
                    str2 = Inet64Util.e(str2);
                } catch (Exception unused) {
                }
            }
            if (lw2.d(str2)) {
                sb.append(jn1.ARRAY_START);
                sb.append(str2);
                sb.append(jn1.ARRAY_END);
            } else {
                sb.append(str2);
            }
            if (i == 0) {
                i = "https".equalsIgnoreCase(str) ? 443 : 80;
            }
            sb.append(":");
            sb.append(i);
        } else {
            sb.append(y90.a());
        }
        sb.append(y90.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put("deviceId", map.remove("deviceId"));
        treeMap.put("platform", map.remove("platform"));
        sb.append(jn1.CONDITION_IF);
        sb.append(lw2.b(treeMap, "utf-8"));
        return sb.toString();
    }

    static void b(String str, long j, long j2) {
        try {
            ln0 ln0Var = new ln0();
            ln0Var.a = "amdc";
            ln0Var.b = "http";
            ln0Var.c = str;
            ln0Var.d = j;
            ln0Var.e = j2;
            qj1.a().commitFlow(ln0Var);
        } catch (Exception e) {
            ALog.d("awcn.DispatchCore", "commit flow info failed!", null, e, new Object[0]);
        }
    }

    static void c(String str, String str2, URL url, int i, int i2) {
        if ((i2 != 1 || i == 2) && hu0.j()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i;
                x6.b().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    static List<IConnStrategy> d(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.o()) {
            list = anet.channel.strategy.a.a().getConnStrategyListByHost(y90.a());
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                IConnStrategy next = listIterator.next();
                if (!next.getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                } else if (Inet64Util.p() && lw2.c(next.getIp())) {
                    listIterator.remove();
                } else if (Inet64Util.o() || Ipv6Detector.d() == 0) {
                    if (lw2.d(next.getIp())) {
                        listIterator.remove();
                    }
                }
            }
        }
        return list;
    }

    static String e(InputStream inputStream, boolean z) {
        Throwable th;
        IOException e;
        FilterInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (z) {
            try {
                try {
                    bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                ALog.d("awcn.DispatchCore", "", null, e, new Object[0]);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                return null;
            }
        }
        FilterInputStream base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = base64InputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
            try {
                base64InputStream.close();
            } catch (IOException unused3) {
            }
            return str;
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = base64InputStream;
            ALog.d("awcn.DispatchCore", "", null, e, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = base64InputStream;
            bufferedInputStream.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x02ba A[Catch: all -> 0x02dd, TryCatch #14 {all -> 0x02dd, blocks: (B:113:0x02b0, B:115:0x02ba, B:116:0x02be), top: B:158:0x02b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f(java.lang.String r21, java.util.Map r22, int r23) {
        /*
            Method dump skipped, instructions count: 751
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.a.f(java.lang.String, java.util.Map, int):int");
    }

    public static void g(Map map) {
        String a2;
        IConnStrategy iConnStrategy;
        boolean z;
        String str;
        if (map == null) {
            return;
        }
        String schemeByHost = anet.channel.strategy.a.a().getSchemeByHost(y90.a(), "http");
        List<IConnStrategy> d = d(schemeByHost);
        String[] c2 = Inet64Util.p() ? y90.c() : null;
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            HashMap hashMap = new HashMap(map);
            if (i != 2) {
                iConnStrategy = !d.isEmpty() ? d.remove(0) : null;
                if (iConnStrategy != null) {
                    a2 = a(schemeByHost, iConnStrategy.getIp(), iConnStrategy.getPort(), hashMap, i);
                } else {
                    if (c2 == null || c2.length <= 0 || z2) {
                        z = z2;
                        str = null;
                    } else {
                        str = c2[c.nextInt(c2.length)];
                        z = true;
                    }
                    boolean z3 = z;
                    a2 = a(schemeByHost, str, 0, hashMap, i);
                    z2 = z3;
                }
            } else {
                String[] b2 = y90.b();
                if (b2 != null && b2.length > 0) {
                    a2 = a(schemeByHost, b2[c.nextInt(b2.length)], 0, hashMap, i);
                } else {
                    a2 = a(schemeByHost, null, 0, hashMap, i);
                }
                iConnStrategy = null;
            }
            int f = f(a2, hashMap, i);
            if (iConnStrategy != null) {
                ym ymVar = new ym();
                ymVar.a = f == 0;
                anet.channel.strategy.a.a().notifyConnEvent(y90.a(), iConnStrategy, ymVar);
            }
            if (f == 0 || f == 2) {
                return;
            }
        }
    }
}
