package com.youku.network.a;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.baseproject.utils.Profile;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.network.f;
import java.util.Map;
import java.util.UUID;
import okhttp3.l;
import okhttp3.o;
import okhttp3.p;
import okhttp3.q;
import tb.jn1;
import tb.xd1;
import tb.yh2;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class e<I extends o, O extends q> extends a<I, O> {
    private com.youku.network.c a;
    private IAntiFlowManager b;

    public e(IAntiFlowManager iAntiFlowManager) {
        this.b = iAntiFlowManager;
    }

    private String a(String str, Map<String, String> map, String str2, String str3, String str4, f fVar) {
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty()) {
            return str;
        }
        String a = com.youku.d.b.a.a(map, str2);
        if (TextUtils.isEmpty(a)) {
            return str;
        }
        if ("GET".equalsIgnoreCase(str3) || !(!"POST".equalsIgnoreCase(str3) || str4 == null || fVar == null)) {
            StringBuilder sb = new StringBuilder(str);
            if (sb.indexOf("?") == -1) {
                sb.append(jn1.CONDITION_IF);
            } else if (str.charAt(str.length() - 1) != '&') {
                sb.append('&');
            }
            sb.append(a);
            return sb.toString();
        }
        return str;
    }

    private l a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        l.a aVar = new l.a();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && yh2.g(entry.getKey())) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (IRequestConst.USER_AGENT.equalsIgnoreCase(key)) {
                    value = a(value);
                }
                aVar.a(key, value);
            }
        }
        return aVar.e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        r13.a(-3016);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.youku.network.d r13, okhttp3.q r14) {
        /*
            r12 = this;
            okhttp3.r r14 = r14.a()
            if (r14 == 0) goto L7e
            long r0 = com.youku.network.config.YKNetworkConfig.a()
            long r2 = r14.f()
            boolean r2 = com.youku.network.config.YKNetworkConfig.a(r2, r0)
            r3 = -3016(0xfffffffffffff438, float:NaN)
            if (r2 == 0) goto L1a
            r13.a(r3)
            goto L7e
        L1a:
            r2 = 1
            r4 = 0
            java.io.InputStream r5 = r14.c()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r6.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L50
            r7 = 0
        L2b:
            int r9 = r5.read(r4)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L50
            r10 = -1
            r11 = 0
            if (r9 == r10) goto L42
            r6.write(r4, r11, r9)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L50
            long r9 = (long) r9     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L50
            long r7 = r7 + r9
            boolean r9 = com.youku.network.config.YKNetworkConfig.a(r7, r0)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L50
            if (r9 == 0) goto L2b
            r13.a(r3)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L50
            r2 = 0
        L42:
            r5.close()     // Catch: java.lang.Exception -> L49
            r14.close()     // Catch: java.lang.Exception -> L49
            goto L66
        L49:
            r14 = move-exception
            r14.printStackTrace()
            goto L66
        L4e:
            r0 = move-exception
            goto L55
        L50:
            r13 = move-exception
            r4 = r5
            goto L70
        L53:
            r0 = move-exception
            r6 = r4
        L55:
            r4 = r5
            goto L5b
        L57:
            r13 = move-exception
            goto L70
        L59:
            r0 = move-exception
            r6 = r4
        L5b:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L57
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.lang.Exception -> L49
        L63:
            r14.close()     // Catch: java.lang.Exception -> L49
        L66:
            if (r2 == 0) goto L7e
            byte[] r14 = r6.toByteArray()
            r13.a(r14)
            goto L7e
        L70:
            if (r4 == 0) goto L75
            r4.close()     // Catch: java.lang.Exception -> L79
        L75:
            r14.close()     // Catch: java.lang.Exception -> L79
            goto L7d
        L79:
            r14 = move-exception
            r14.printStackTrace()
        L7d:
            throw r13
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.network.a.e.a(com.youku.network.d, okhttp3.q):void");
    }

    private com.youku.network.d b(O o) {
        com.youku.network.d a = com.youku.network.d.a();
        a.b(o.e());
        try {
            a(a, o);
        } catch (Throwable th) {
            th.printStackTrace();
            a.a(AVFSCacheConstants.AVFS_ERROR_FILE_WRITE);
            a.a(th);
        }
        l j = o.j();
        if (j != null) {
            try {
                a.a(j.i());
            } catch (Throwable th2) {
                th2.printStackTrace();
                a.a(-3015);
                a.a(th2);
            }
        }
        a.a(o.k());
        this.b.afterCall(a.d(), a.f());
        return a;
    }

    private o b(com.youku.network.c cVar) {
        this.a = cVar;
        String antiCookie = this.b.getAntiCookie(cVar.k().get(IRequestConst.COOKIE));
        if (!TextUtils.isEmpty(antiCookie)) {
            cVar.a(IRequestConst.COOKIE, antiCookie);
        }
        p pVar = null;
        String h = cVar.h();
        Map<String, String> l = cVar.l();
        String n = cVar.n();
        String m = cVar.m();
        f L = cVar.L();
        Map<String, String> k = cVar.k();
        if (k != null && k.get(IRequestConst.USER_AGENT) == null && k.get("user-agent") == null && Profile.User_Agent != null) {
            k.put(IRequestConst.USER_AGENT, Profile.User_Agent);
        }
        l a = a(k);
        String a2 = a(cVar.e(), l, n, h, m, L);
        if (!com.youku.network.call.a.b) {
            try {
                if (a2.startsWith("https")) {
                    a2 = zh2.e("http", ":", a2.substring(a2.indexOf(WVUtils.URL_SEPARATOR)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(m)) {
            pVar = p.c(xd1.d("application/json; charset=" + n), m);
        } else if (L != null) {
            pVar = p.d(xd1.d(L.b + "; charset=" + n), L.a);
        } else if (!"GET".equalsIgnoreCase(h)) {
            String a3 = com.youku.d.b.a.a(l, n);
            pVar = p.c(xd1.d("application/x-www-form-urlencoded; charset=" + n), a3);
        }
        o.a j = new o.a().k(a2).f(h, pVar).j(UUID.randomUUID().toString());
        if (a != null && a.h() > 0) {
            j.e(a);
        }
        return j.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.network.a.b
    public /* bridge */ /* synthetic */ com.youku.network.d a(Object obj) {
        return a((e<I, O>) ((q) obj));
    }

    public com.youku.network.d a(O o) {
        return b((e<I, O>) o);
    }

    public I a(com.youku.network.c cVar) {
        return (I) b(cVar);
    }
}
