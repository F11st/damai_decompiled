package com.xiaomi.push;

import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class dx {

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$a */
    /* loaded from: classes11.dex */
    public static final class C7635a extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f233a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f235b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f237c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f239d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f241e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f242f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private long f231a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f232a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f234b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f236c = "";

        /* renamed from: d  reason: collision with other field name */
        private String f238d = "";

        /* renamed from: e  reason: collision with other field name */
        private String f240e = "";
        private int b = 1;
        private int c = 0;
        private int d = 0;
        private String f = "";
        private int e = -1;

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.e < 0) {
                b();
            }
            return this.e;
        }

        /* renamed from: a  reason: collision with other method in class */
        public long m781a() {
            return this.f231a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public C7635a m782a() {
            this.f242f = false;
            this.f238d = "";
            return this;
        }

        public C7635a a(int i) {
            this.f233a = true;
            this.a = i;
            return this;
        }

        public C7635a a(long j) {
            this.f235b = true;
            this.f231a = j;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7635a a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                switch (m673a) {
                    case 0:
                        return this;
                    case 8:
                        a(c7605b.m682b());
                        break;
                    case 16:
                        a(c7605b.m683b());
                        break;
                    case 26:
                        a(c7605b.m676a());
                        break;
                    case 34:
                        b(c7605b.m676a());
                        break;
                    case 42:
                        c(c7605b.m676a());
                        break;
                    case 50:
                        d(c7605b.m676a());
                        break;
                    case 58:
                        e(c7605b.m676a());
                        break;
                    case 64:
                        b(c7605b.m682b());
                        break;
                    case 72:
                        c(c7605b.m682b());
                        break;
                    case 80:
                        d(c7605b.m682b());
                        break;
                    case 90:
                        f(c7605b.m676a());
                        break;
                    default:
                        if (a(c7605b, m673a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public C7635a a(String str) {
            this.f237c = true;
            this.f232a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m783a() {
            return this.f232a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m784a()) {
                c7614c.m717a(1, c());
            }
            if (m786b()) {
                c7614c.m731b(2, m781a());
            }
            if (m788c()) {
                c7614c.m721a(3, m783a());
            }
            if (m790d()) {
                c7614c.m721a(4, m785b());
            }
            if (m792e()) {
                c7614c.m721a(5, m787c());
            }
            if (m794f()) {
                c7614c.m721a(6, m789d());
            }
            if (g()) {
                c7614c.m721a(7, m791e());
            }
            if (h()) {
                c7614c.m717a(8, d());
            }
            if (i()) {
                c7614c.m717a(9, e());
            }
            if (j()) {
                c7614c.m717a(10, f());
            }
            if (k()) {
                c7614c.m721a(11, m793f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m784a() {
            return this.f233a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m784a() ? 0 + C7614c.a(1, c()) : 0;
            if (m786b()) {
                a += C7614c.b(2, m781a());
            }
            if (m788c()) {
                a += C7614c.a(3, m783a());
            }
            if (m790d()) {
                a += C7614c.a(4, m785b());
            }
            if (m792e()) {
                a += C7614c.a(5, m787c());
            }
            if (m794f()) {
                a += C7614c.a(6, m789d());
            }
            if (g()) {
                a += C7614c.a(7, m791e());
            }
            if (h()) {
                a += C7614c.a(8, d());
            }
            if (i()) {
                a += C7614c.a(9, e());
            }
            if (j()) {
                a += C7614c.a(10, f());
            }
            if (k()) {
                a += C7614c.a(11, m793f());
            }
            this.e = a;
            return a;
        }

        public C7635a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public C7635a b(String str) {
            this.f239d = true;
            this.f234b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m785b() {
            return this.f234b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m786b() {
            return this.f235b;
        }

        public int c() {
            return this.a;
        }

        public C7635a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public C7635a c(String str) {
            this.f241e = true;
            this.f236c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m787c() {
            return this.f236c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m788c() {
            return this.f237c;
        }

        public int d() {
            return this.b;
        }

        public C7635a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        public C7635a d(String str) {
            this.f242f = true;
            this.f238d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m789d() {
            return this.f238d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m790d() {
            return this.f239d;
        }

        public int e() {
            return this.c;
        }

        public C7635a e(String str) {
            this.g = true;
            this.f240e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m791e() {
            return this.f240e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m792e() {
            return this.f241e;
        }

        public int f() {
            return this.d;
        }

        public C7635a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* renamed from: f  reason: collision with other method in class */
        public String m793f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m794f() {
            return this.f242f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$b */
    /* loaded from: classes11.dex */
    public static final class C7636b extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f243a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f245c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f246d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f244b = false;
        private int a = 0;
        private int b = 0;
        private int c = 0;
        private int d = -1;

        public static C7636b a(byte[] bArr) {
            return (C7636b) new C7636b().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        public C7636b a(int i) {
            this.f245c = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7636b a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 8) {
                    a(c7605b.m679a());
                } else if (m673a == 24) {
                    a(c7605b.m682b());
                } else if (m673a == 32) {
                    b(c7605b.m682b());
                } else if (m673a == 40) {
                    c(c7605b.m682b());
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7636b a(boolean z) {
            this.f243a = true;
            this.f244b = z;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m796b()) {
                c7614c.m722a(1, m795a());
            }
            if (m797c()) {
                c7614c.m717a(3, c());
            }
            if (m798d()) {
                c7614c.m717a(4, d());
            }
            if (m799e()) {
                c7614c.m717a(5, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m795a() {
            return this.f244b;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m796b() ? 0 + C7614c.a(1, m795a()) : 0;
            if (m797c()) {
                a += C7614c.a(3, c());
            }
            if (m798d()) {
                a += C7614c.a(4, d());
            }
            if (m799e()) {
                a += C7614c.a(5, e());
            }
            this.d = a;
            return a;
        }

        public C7636b b(int i) {
            this.f246d = true;
            this.b = i;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m796b() {
            return this.f243a;
        }

        public int c() {
            return this.a;
        }

        public C7636b c(int i) {
            this.e = true;
            this.c = i;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m797c() {
            return this.f245c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m798d() {
            return this.f246d;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m799e() {
            return this.e;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$c */
    /* loaded from: classes11.dex */
    public static final class C7637c extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f248a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f249b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f250c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f251d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f252e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f253f;

        /* renamed from: a  reason: collision with other field name */
        private String f247a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private int a = -1;

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7637c a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 10) {
                    a(c7605b.m676a());
                } else if (m673a == 18) {
                    b(c7605b.m676a());
                } else if (m673a == 26) {
                    c(c7605b.m676a());
                } else if (m673a == 34) {
                    d(c7605b.m676a());
                } else if (m673a == 42) {
                    e(c7605b.m676a());
                } else if (m673a == 50) {
                    f(c7605b.m676a());
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7637c a(String str) {
            this.f248a = true;
            this.f247a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m800a() {
            return this.f247a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m801a()) {
                c7614c.m721a(1, m800a());
            }
            if (m803b()) {
                c7614c.m721a(2, m802b());
            }
            if (m804c()) {
                c7614c.m721a(3, c());
            }
            if (m805d()) {
                c7614c.m721a(4, d());
            }
            if (m806e()) {
                c7614c.m721a(5, e());
            }
            if (m807f()) {
                c7614c.m721a(6, f());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m801a() {
            return this.f248a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m801a() ? 0 + C7614c.a(1, m800a()) : 0;
            if (m803b()) {
                a += C7614c.a(2, m802b());
            }
            if (m804c()) {
                a += C7614c.a(3, c());
            }
            if (m805d()) {
                a += C7614c.a(4, d());
            }
            if (m806e()) {
                a += C7614c.a(5, e());
            }
            if (m807f()) {
                a += C7614c.a(6, f());
            }
            this.a = a;
            return a;
        }

        public C7637c b(String str) {
            this.f249b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m802b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m803b() {
            return this.f249b;
        }

        public C7637c c(String str) {
            this.f250c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m804c() {
            return this.f250c;
        }

        public C7637c d(String str) {
            this.f251d = true;
            this.d = str;
            return this;
        }

        public String d() {
            return this.d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m805d() {
            return this.f251d;
        }

        public C7637c e(String str) {
            this.f252e = true;
            this.e = str;
            return this;
        }

        public String e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m806e() {
            return this.f252e;
        }

        public C7637c f(String str) {
            this.f253f = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m807f() {
            return this.f253f;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$d */
    /* loaded from: classes11.dex */
    public static final class C7638d extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f255a;

        /* renamed from: c  reason: collision with other field name */
        private boolean f257c;
        private boolean d;
        private boolean e;

        /* renamed from: b  reason: collision with other field name */
        private boolean f256b = false;

        /* renamed from: a  reason: collision with other field name */
        private String f254a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

        public static C7638d a(byte[] bArr) {
            return (C7638d) new C7638d().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7638d a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 8) {
                    a(c7605b.m679a());
                } else if (m673a == 18) {
                    a(c7605b.m676a());
                } else if (m673a == 26) {
                    b(c7605b.m676a());
                } else if (m673a == 34) {
                    c(c7605b.m676a());
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7638d a(String str) {
            this.f257c = true;
            this.f254a = str;
            return this;
        }

        public C7638d a(boolean z) {
            this.f255a = true;
            this.f256b = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m808a() {
            return this.f254a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m811b()) {
                c7614c.m722a(1, m809a());
            }
            if (m812c()) {
                c7614c.m721a(2, m808a());
            }
            if (d()) {
                c7614c.m721a(3, m810b());
            }
            if (e()) {
                c7614c.m721a(4, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m809a() {
            return this.f256b;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m811b() ? 0 + C7614c.a(1, m809a()) : 0;
            if (m812c()) {
                a += C7614c.a(2, m808a());
            }
            if (d()) {
                a += C7614c.a(3, m810b());
            }
            if (e()) {
                a += C7614c.a(4, c());
            }
            this.a = a;
            return a;
        }

        public C7638d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m810b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m811b() {
            return this.f255a;
        }

        public C7638d c(String str) {
            this.e = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m812c() {
            return this.f257c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$e */
    /* loaded from: classes11.dex */
    public static final class C7639e extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f260a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f262b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f264c;

        /* renamed from: d  reason: collision with other field name */
        private boolean f266d;

        /* renamed from: e  reason: collision with other field name */
        private boolean f267e;

        /* renamed from: f  reason: collision with other field name */
        private boolean f268f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f259a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f261b = "";

        /* renamed from: c  reason: collision with other field name */
        private String f263c = "";
        private int b = 0;

        /* renamed from: d  reason: collision with other field name */
        private String f265d = "";
        private String e = "";
        private String f = "";

        /* renamed from: a  reason: collision with other field name */
        private C7636b f258a = null;
        private int c = 0;
        private int d = -1;

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        /* renamed from: a  reason: collision with other method in class */
        public C7636b m813a() {
            return this.f258a;
        }

        public C7639e a(int i) {
            this.f260a = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7639e a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                switch (m673a) {
                    case 0:
                        return this;
                    case 8:
                        a(c7605b.c());
                        break;
                    case 18:
                        a(c7605b.m676a());
                        break;
                    case 26:
                        b(c7605b.m676a());
                        break;
                    case 34:
                        c(c7605b.m676a());
                        break;
                    case 40:
                        b(c7605b.m682b());
                        break;
                    case 50:
                        d(c7605b.m676a());
                        break;
                    case 58:
                        e(c7605b.m676a());
                        break;
                    case 66:
                        f(c7605b.m676a());
                        break;
                    case 74:
                        C7636b c7636b = new C7636b();
                        c7605b.a(c7636b);
                        a(c7636b);
                        break;
                    case 80:
                        c(c7605b.m682b());
                        break;
                    default:
                        if (a(c7605b, m673a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public C7639e a(C7636b c7636b) {
            Objects.requireNonNull(c7636b);
            this.i = true;
            this.f258a = c7636b;
            return this;
        }

        public C7639e a(String str) {
            this.f262b = true;
            this.f259a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m814a() {
            return this.f259a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m815a()) {
                c7614c.m730b(1, c());
            }
            if (m817b()) {
                c7614c.m721a(2, m814a());
            }
            if (m819c()) {
                c7614c.m721a(3, m816b());
            }
            if (m821d()) {
                c7614c.m721a(4, m818c());
            }
            if (m823e()) {
                c7614c.m717a(5, d());
            }
            if (m824f()) {
                c7614c.m721a(6, m820d());
            }
            if (g()) {
                c7614c.m721a(7, m822e());
            }
            if (h()) {
                c7614c.m721a(8, f());
            }
            if (i()) {
                c7614c.m720a(9, (AbstractC7646e) m813a());
            }
            if (j()) {
                c7614c.m717a(10, e());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m815a() {
            return this.f260a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int b = m815a() ? 0 + C7614c.b(1, c()) : 0;
            if (m817b()) {
                b += C7614c.a(2, m814a());
            }
            if (m819c()) {
                b += C7614c.a(3, m816b());
            }
            if (m821d()) {
                b += C7614c.a(4, m818c());
            }
            if (m823e()) {
                b += C7614c.a(5, d());
            }
            if (m824f()) {
                b += C7614c.a(6, m820d());
            }
            if (g()) {
                b += C7614c.a(7, m822e());
            }
            if (h()) {
                b += C7614c.a(8, f());
            }
            if (i()) {
                b += C7614c.a(9, (AbstractC7646e) m813a());
            }
            if (j()) {
                b += C7614c.a(10, e());
            }
            this.d = b;
            return b;
        }

        public C7639e b(int i) {
            this.f267e = true;
            this.b = i;
            return this;
        }

        public C7639e b(String str) {
            this.f264c = true;
            this.f261b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m816b() {
            return this.f261b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m817b() {
            return this.f262b;
        }

        public int c() {
            return this.a;
        }

        public C7639e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public C7639e c(String str) {
            this.f266d = true;
            this.f263c = str;
            return this;
        }

        /* renamed from: c  reason: collision with other method in class */
        public String m818c() {
            return this.f263c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m819c() {
            return this.f264c;
        }

        public int d() {
            return this.b;
        }

        public C7639e d(String str) {
            this.f268f = true;
            this.f265d = str;
            return this;
        }

        /* renamed from: d  reason: collision with other method in class */
        public String m820d() {
            return this.f265d;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m821d() {
            return this.f266d;
        }

        public int e() {
            return this.c;
        }

        public C7639e e(String str) {
            this.g = true;
            this.e = str;
            return this;
        }

        /* renamed from: e  reason: collision with other method in class */
        public String m822e() {
            return this.e;
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m823e() {
            return this.f267e;
        }

        public C7639e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: f  reason: collision with other method in class */
        public boolean m824f() {
            return this.f268f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$f */
    /* loaded from: classes11.dex */
    public static final class C7640f extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f271a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f272b;
        private boolean c;

        /* renamed from: a  reason: collision with other field name */
        private String f270a = "";
        private String b = "";

        /* renamed from: a  reason: collision with other field name */
        private C7636b f269a = null;
        private int a = -1;

        public static C7640f a(byte[] bArr) {
            return (C7640f) new C7640f().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public C7636b m825a() {
            return this.f269a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7640f a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 10) {
                    a(c7605b.m676a());
                } else if (m673a == 18) {
                    b(c7605b.m676a());
                } else if (m673a == 26) {
                    C7636b c7636b = new C7636b();
                    c7605b.a(c7636b);
                    a(c7636b);
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7640f a(C7636b c7636b) {
            Objects.requireNonNull(c7636b);
            this.c = true;
            this.f269a = c7636b;
            return this;
        }

        public C7640f a(String str) {
            this.f271a = true;
            this.f270a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m826a() {
            return this.f270a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m827a()) {
                c7614c.m721a(1, m826a());
            }
            if (m829b()) {
                c7614c.m721a(2, m828b());
            }
            if (c()) {
                c7614c.m720a(3, (AbstractC7646e) m825a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m827a() {
            return this.f271a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m827a() ? 0 + C7614c.a(1, m826a()) : 0;
            if (m829b()) {
                a += C7614c.a(2, m828b());
            }
            if (c()) {
                a += C7614c.a(3, (AbstractC7646e) m825a());
            }
            this.a = a;
            return a;
        }

        public C7640f b(String str) {
            this.f272b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m828b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m829b() {
            return this.f272b;
        }

        public boolean c() {
            return this.c;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$g */
    /* loaded from: classes11.dex */
    public static final class C7641g extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f274a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f275b;

        /* renamed from: c  reason: collision with other field name */
        private boolean f276c;

        /* renamed from: a  reason: collision with other field name */
        private String f273a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

        public static C7641g a(byte[] bArr) {
            return (C7641g) new C7641g().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7641g a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 10) {
                    a(c7605b.m676a());
                } else if (m673a == 18) {
                    b(c7605b.m676a());
                } else if (m673a == 26) {
                    c(c7605b.m676a());
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7641g a(String str) {
            this.f274a = true;
            this.f273a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m830a() {
            return this.f273a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m831a()) {
                c7614c.m721a(1, m830a());
            }
            if (m833b()) {
                c7614c.m721a(2, m832b());
            }
            if (m834c()) {
                c7614c.m721a(3, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m831a() {
            return this.f274a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m831a() ? 0 + C7614c.a(1, m830a()) : 0;
            if (m833b()) {
                a += C7614c.a(2, m832b());
            }
            if (m834c()) {
                a += C7614c.a(3, c());
            }
            this.a = a;
            return a;
        }

        public C7641g b(String str) {
            this.f275b = true;
            this.b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m832b() {
            return this.b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m833b() {
            return this.f275b;
        }

        public C7641g c(String str) {
            this.f276c = true;
            this.c = str;
            return this;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m834c() {
            return this.f276c;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$h */
    /* loaded from: classes11.dex */
    public static final class C7642h extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f278a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f279b;
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        private String f277a = "";
        private int b = -1;

        public static C7642h a(byte[] bArr) {
            return (C7642h) new C7642h().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        public C7642h a(int i) {
            this.f278a = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7642h a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 8) {
                    a(c7605b.m682b());
                } else if (m673a == 18) {
                    a(c7605b.m676a());
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7642h a(String str) {
            this.f279b = true;
            this.f277a = str;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m835a() {
            return this.f277a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m836a()) {
                c7614c.m717a(1, c());
            }
            if (m837b()) {
                c7614c.m721a(2, m835a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m836a() {
            return this.f278a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m836a() ? 0 + C7614c.a(1, c()) : 0;
            if (m837b()) {
                a += C7614c.a(2, m835a());
            }
            this.b = a;
            return a;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m837b() {
            return this.f279b;
        }

        public int c() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$i */
    /* loaded from: classes11.dex */
    public static final class C7643i extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f281a;

        /* renamed from: a  reason: collision with other field name */
        private C7593a f280a = C7593a.a;
        private int a = -1;

        public static C7643i a(byte[] bArr) {
            return (C7643i) new C7643i().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public C7593a m838a() {
            return this.f280a;
        }

        public C7643i a(C7593a c7593a) {
            this.f281a = true;
            this.f280a = c7593a;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7643i a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 10) {
                    a(c7605b.m675a());
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m839a()) {
                c7614c.m719a(1, m838a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m839a() {
            return this.f281a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m839a() ? 0 + C7614c.a(1, m838a()) : 0;
            this.a = a;
            return a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$j */
    /* loaded from: classes11.dex */
    public static final class C7644j extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f284a;
        private boolean b;

        /* renamed from: a  reason: collision with other field name */
        private C7593a f282a = C7593a.a;

        /* renamed from: a  reason: collision with other field name */
        private C7636b f283a = null;
        private int a = -1;

        public static C7644j a(byte[] bArr) {
            return (C7644j) new C7644j().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public C7593a m840a() {
            return this.f282a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public C7636b m841a() {
            return this.f283a;
        }

        public C7644j a(C7593a c7593a) {
            this.f284a = true;
            this.f282a = c7593a;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7644j a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 10) {
                    a(c7605b.m675a());
                } else if (m673a == 18) {
                    C7636b c7636b = new C7636b();
                    c7605b.a(c7636b);
                    a(c7636b);
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7644j a(C7636b c7636b) {
            Objects.requireNonNull(c7636b);
            this.b = true;
            this.f283a = c7636b;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m842a()) {
                c7614c.m719a(1, m840a());
            }
            if (m843b()) {
                c7614c.m720a(2, (AbstractC7646e) m841a());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m842a() {
            return this.f284a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m842a() ? 0 + C7614c.a(1, m840a()) : 0;
            if (m843b()) {
                a += C7614c.a(2, (AbstractC7646e) m841a());
            }
            this.a = a;
            return a;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m843b() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.dx$k */
    /* loaded from: classes11.dex */
    public static final class C7645k extends AbstractC7646e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f287a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f290b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean g;

        /* renamed from: a  reason: collision with other field name */
        private String f286a = "";

        /* renamed from: b  reason: collision with other field name */
        private String f289b = "";

        /* renamed from: a  reason: collision with other field name */
        private long f285a = 0;

        /* renamed from: b  reason: collision with other field name */
        private long f288b = 0;
        private boolean f = false;
        private int a = 0;
        private int b = -1;

        public static C7645k a(byte[] bArr) {
            return (C7645k) new C7645k().a(bArr);
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        /* renamed from: a  reason: collision with other method in class */
        public long m844a() {
            return this.f285a;
        }

        public C7645k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        public C7645k a(long j) {
            this.c = true;
            this.f285a = j;
            return this;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public C7645k a(C7605b c7605b) {
            while (true) {
                int m673a = c7605b.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 10) {
                    a(c7605b.m676a());
                } else if (m673a == 18) {
                    b(c7605b.m676a());
                } else if (m673a == 24) {
                    a(c7605b.m674a());
                } else if (m673a == 32) {
                    b(c7605b.m674a());
                } else if (m673a == 40) {
                    a(c7605b.m679a());
                } else if (m673a == 48) {
                    a(c7605b.m682b());
                } else if (!a(c7605b, m673a)) {
                    return this;
                }
            }
        }

        public C7645k a(String str) {
            this.f287a = true;
            this.f286a = str;
            return this;
        }

        public C7645k a(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m845a() {
            return this.f286a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public void a(C7614c c7614c) {
            if (m846a()) {
                c7614c.m721a(1, m845a());
            }
            if (m849b()) {
                c7614c.m721a(2, m848b());
            }
            if (m850c()) {
                c7614c.m718a(3, m844a());
            }
            if (d()) {
                c7614c.m718a(4, m847b());
            }
            if (f()) {
                c7614c.m722a(5, e());
            }
            if (g()) {
                c7614c.m717a(6, c());
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m846a() {
            return this.f287a;
        }

        @Override // com.xiaomi.push.AbstractC7646e
        public int b() {
            int a = m846a() ? 0 + C7614c.a(1, m845a()) : 0;
            if (m849b()) {
                a += C7614c.a(2, m848b());
            }
            if (m850c()) {
                a += C7614c.a(3, m844a());
            }
            if (d()) {
                a += C7614c.a(4, m847b());
            }
            if (f()) {
                a += C7614c.a(5, e());
            }
            if (g()) {
                a += C7614c.a(6, c());
            }
            this.b = a;
            return a;
        }

        /* renamed from: b  reason: collision with other method in class */
        public long m847b() {
            return this.f288b;
        }

        public C7645k b(long j) {
            this.d = true;
            this.f288b = j;
            return this;
        }

        public C7645k b(String str) {
            this.f290b = true;
            this.f289b = str;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public String m848b() {
            return this.f289b;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m849b() {
            return this.f290b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m850c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }

        public boolean g() {
            return this.g;
        }
    }
}
