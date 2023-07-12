package okhttp3.internal.cache;

import android.taobao.windvane.connect.HttpConnector;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import mtopsdk.common.util.HttpHeaderConstant;
import okhttp3.l;
import okhttp3.o;
import okhttp3.q;
import tb.c01;
import tb.g01;
import tb.ue;
import tb.w31;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class b {
    @Nullable
    public final o a;
    @Nullable
    public final q b;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class a {
        final long a;
        final o b;
        final q c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, o oVar, q qVar) {
            this.l = -1;
            this.a = j;
            this.b = oVar;
            this.c = qVar;
            if (qVar != null) {
                this.i = qVar.r();
                this.j = qVar.p();
                l j2 = qVar.j();
                int h = j2.h();
                for (int i = 0; i < h; i++) {
                    String e = j2.e(i);
                    String j3 = j2.j(i);
                    if (HttpHeaderConstant.DATE.equalsIgnoreCase(e)) {
                        this.d = c01.b(j3);
                        this.e = j3;
                    } else if ("Expires".equalsIgnoreCase(e)) {
                        this.h = c01.b(j3);
                    } else if ("Last-Modified".equalsIgnoreCase(e)) {
                        this.f = c01.b(j3);
                        this.g = j3;
                    } else if ("ETag".equalsIgnoreCase(e)) {
                        this.k = j3;
                    } else if ("Age".equalsIgnoreCase(e)) {
                        this.l = g01.f(j3, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return max + (j - this.i) + (this.a - j);
        }

        private long b() {
            long j;
            long j2;
            ue c = this.c.c();
            if (c.d() != -1) {
                return TimeUnit.SECONDS.toMillis(c.d());
            }
            if (this.h != null) {
                Date date = this.d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.j;
                }
                long time = this.h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f == null || this.c.q().i().y() != null) {
                return 0L;
            } else {
                Date date2 = this.d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.i;
                }
                long time2 = j - this.f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        private b d() {
            if (this.c == null) {
                return new b(this.b, null);
            }
            if (this.b.f() && this.c.f() == null) {
                return new b(this.b, null);
            }
            if (!b.a(this.c, this.b)) {
                return new b(this.b, null);
            }
            ue b = this.b.b();
            if (!b.h() && !e(this.b)) {
                ue c = this.c.c();
                long a = a();
                long b2 = b();
                if (b.d() != -1) {
                    b2 = Math.min(b2, TimeUnit.SECONDS.toMillis(b.d()));
                }
                long j = 0;
                long millis = b.f() != -1 ? TimeUnit.SECONDS.toMillis(b.f()) : 0L;
                if (!c.g() && b.e() != -1) {
                    j = TimeUnit.SECONDS.toMillis(b.e());
                }
                if (!c.h()) {
                    long j2 = millis + a;
                    if (j2 < j + b2) {
                        q.a m = this.c.m();
                        if (j2 >= b2) {
                            m.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a > 86400000 && f()) {
                            m.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, m.c());
                    }
                }
                String str = this.k;
                String str2 = HttpConnector.IF_MODIFY_SINCE;
                if (str != null) {
                    str2 = HttpConnector.IF_NONE_MATCH;
                } else if (this.f != null) {
                    str = this.g;
                } else if (this.d != null) {
                    str = this.e;
                } else {
                    return new b(this.b, null);
                }
                l.a f = this.b.e().f();
                w31.a.b(f, str2, str);
                return new b(this.b.h().e(f.e()).b(), this.c);
            }
            return new b(this.b, null);
        }

        private static boolean e(o oVar) {
            return (oVar.c(HttpConnector.IF_MODIFY_SINCE) == null && oVar.c(HttpConnector.IF_NONE_MATCH) == null) ? false : true;
        }

        private boolean f() {
            return this.c.c().d() == -1 && this.h == null;
        }

        public b c() {
            b d = d();
            return (d.a == null || !this.b.b().j()) ? d : new b(null, null);
        }
    }

    b(o oVar, q qVar) {
        this.a = oVar;
        this.b = qVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.c().b() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(okhttp3.q r3, okhttp3.o r4) {
        /*
            int r0 = r3.e()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.g(r0)
            if (r0 != 0) goto L5a
            tb.ue r0 = r3.c()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            tb.ue r0 = r3.c()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            tb.ue r0 = r3.c()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            tb.ue r3 = r3.c()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            tb.ue r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.b.a(okhttp3.q, okhttp3.o):boolean");
    }
}
