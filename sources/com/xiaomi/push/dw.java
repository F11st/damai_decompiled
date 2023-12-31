package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class dw {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f228a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f229b;
        private boolean d;
        private boolean e;
        private int a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f230c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f227a = Collections.emptyList();
        private int c = -1;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        public a a(int i) {
            this.f228a = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) {
            while (true) {
                int m673a = bVar.m673a();
                if (m673a == 0) {
                    return this;
                }
                if (m673a == 8) {
                    a(bVar.c());
                } else if (m673a == 16) {
                    a(bVar.m679a());
                } else if (m673a == 24) {
                    b(bVar.m682b());
                } else if (m673a == 32) {
                    b(bVar.m679a());
                } else if (m673a == 42) {
                    a(bVar.m676a());
                } else if (!a(bVar, m673a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            Objects.requireNonNull(str);
            if (this.f227a.isEmpty()) {
                this.f227a = new ArrayList();
            }
            this.f227a.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f229b = true;
            this.f230c = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public List<String> m775a() {
            return this.f227a;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) {
            if (m776a()) {
                cVar.m730b(1, c());
            }
            if (m778c()) {
                cVar.m722a(2, m777b());
            }
            if (m779d()) {
                cVar.m717a(3, d());
            }
            if (f()) {
                cVar.m722a(4, m780e());
            }
            for (String str : m775a()) {
                cVar.m721a(5, str);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m776a() {
            return this.f228a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int i = 0;
            int b = m776a() ? c.b(1, c()) + 0 : 0;
            if (m778c()) {
                b += c.a(2, m777b());
            }
            if (m779d()) {
                b += c.a(3, d());
            }
            if (f()) {
                b += c.a(4, m780e());
            }
            for (String str : m775a()) {
                i += c.a(str);
            }
            int size = b + i + (m775a().size() * 1);
            this.c = size;
            return size;
        }

        public a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        public a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public boolean m777b() {
            return this.f230c;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public boolean m778c() {
            return this.f229b;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public boolean m779d() {
            return this.d;
        }

        public int e() {
            return this.f227a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public boolean m780e() {
            return this.f;
        }

        public boolean f() {
            return this.e;
        }
    }
}
