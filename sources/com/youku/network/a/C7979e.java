package com.youku.network.a;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.baseproject.utils.Profile;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.d.b.C7900a;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.C8010f;
import com.youku.network.call.C7987a;
import java.util.Map;
import java.util.UUID;
import okhttp3.AbstractC8825p;
import okhttp3.C8816l;
import okhttp3.C8823o;
import okhttp3.C8827q;
import tb.jn1;
import tb.xd1;
import tb.yh2;
import tb.zh2;

/* compiled from: Taobao */
/* renamed from: com.youku.network.a.e */
/* loaded from: classes3.dex */
public class C7979e<I extends C8823o, O extends C8827q> extends AbstractC7975a<I, O> {
    private C7984c a;
    private IAntiFlowManager b;

    public C7979e(IAntiFlowManager iAntiFlowManager) {
        this.b = iAntiFlowManager;
    }

    private String a(String str, Map<String, String> map, String str2, String str3, String str4, C8010f c8010f) {
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty()) {
            return str;
        }
        String a = C7900a.a(map, str2);
        if (TextUtils.isEmpty(a)) {
            return str;
        }
        if ("GET".equalsIgnoreCase(str3) || !(!"POST".equalsIgnoreCase(str3) || str4 == null || c8010f == null)) {
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

    private C8816l a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        C8816l.C8817a c8817a = new C8816l.C8817a();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && yh2.g(entry.getKey())) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (IRequestConst.USER_AGENT.equalsIgnoreCase(key)) {
                    value = a(value);
                }
                c8817a.a(key, value);
            }
        }
        return c8817a.e();
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
    private void a(com.youku.network.C8004d r13, okhttp3.C8827q r14) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.youku.network.a.C7979e.a(com.youku.network.d, okhttp3.q):void");
    }

    private C8004d b(O o) {
        C8004d a = C8004d.a();
        a.b(o.e());
        try {
            a(a, o);
        } catch (Throwable th) {
            th.printStackTrace();
            a.a(AVFSCacheConstants.AVFS_ERROR_FILE_WRITE);
            a.a(th);
        }
        C8816l j = o.j();
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

    private C8823o b(C7984c c7984c) {
        this.a = c7984c;
        String antiCookie = this.b.getAntiCookie(c7984c.k().get(IRequestConst.COOKIE));
        if (!TextUtils.isEmpty(antiCookie)) {
            c7984c.a(IRequestConst.COOKIE, antiCookie);
        }
        AbstractC8825p abstractC8825p = null;
        String h = c7984c.h();
        Map<String, String> l = c7984c.l();
        String n = c7984c.n();
        String m = c7984c.m();
        C8010f L = c7984c.L();
        Map<String, String> k = c7984c.k();
        if (k != null && k.get(IRequestConst.USER_AGENT) == null && k.get("user-agent") == null && Profile.User_Agent != null) {
            k.put(IRequestConst.USER_AGENT, Profile.User_Agent);
        }
        C8816l a = a(k);
        String a2 = a(c7984c.e(), l, n, h, m, L);
        if (!C7987a.b) {
            try {
                if (a2.startsWith("https")) {
                    a2 = zh2.e("http", ":", a2.substring(a2.indexOf(WVUtils.URL_SEPARATOR)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(m)) {
            abstractC8825p = AbstractC8825p.c(xd1.d("application/json; charset=" + n), m);
        } else if (L != null) {
            abstractC8825p = AbstractC8825p.d(xd1.d(L.b + "; charset=" + n), L.a);
        } else if (!"GET".equalsIgnoreCase(h)) {
            String a3 = C7900a.a(l, n);
            abstractC8825p = AbstractC8825p.c(xd1.d("application/x-www-form-urlencoded; charset=" + n), a3);
        }
        C8823o.C8824a j = new C8823o.C8824a().k(a2).f(h, abstractC8825p).j(UUID.randomUUID().toString());
        if (a != null && a.h() > 0) {
            j.e(a);
        }
        return j.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.network.a.InterfaceC7976b
    public /* bridge */ /* synthetic */ C8004d a(Object obj) {
        return a((C7979e<I, O>) ((C8827q) obj));
    }

    public C8004d a(O o) {
        return b((C7979e<I, O>) o);
    }

    public I a(C7984c c7984c) {
        return (I) b(c7984c);
    }
}
