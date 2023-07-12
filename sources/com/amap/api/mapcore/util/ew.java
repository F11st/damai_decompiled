package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ew {
    b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ew$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.PERFECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.FIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum a {
        FAIL,
        PERFECT,
        FIT
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class b {
        static final /* synthetic */ boolean e = true;
        String a;
        c b;
        b c = null;
        b d = null;

        b(c cVar) {
            this.b = cVar;
        }

        b a(int i, int i2, String str) {
            if (!a()) {
                b a = this.c.a(i, i2, str);
                return a == null ? this.d.a(i, i2, str) : a;
            } else if (this.a != null) {
                return null;
            } else {
                int i3 = AnonymousClass1.a[b(i, i2).ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            a(i, i2);
                        }
                        return this.c.a(i, i2, str);
                    }
                    this.a = str;
                    return this;
                }
                return null;
            }
        }

        boolean b() {
            return (this.a == null && a()) ? false : true;
        }

        a b(int i, int i2) {
            int i3;
            c cVar = this.b;
            int i4 = cVar.c;
            if (i > i4 || i2 > (i3 = cVar.d)) {
                return a.FAIL;
            }
            if (i == i4 && i2 == i3) {
                return a.PERFECT;
            }
            return a.FIT;
        }

        boolean a() {
            return this.c == null;
        }

        boolean a(String str) {
            if (a()) {
                if (str.equals(this.a)) {
                    this.a = null;
                    return true;
                }
                return false;
            }
            boolean a = this.c.a(str);
            if (!a) {
                a = this.d.a(str);
            }
            if (a && !this.c.b() && !this.d.b()) {
                this.c = null;
                this.d = null;
            }
            return a;
        }

        void a(int i, int i2) {
            c cVar;
            c cVar2;
            c cVar3 = this.b;
            int i3 = cVar3.c;
            int i4 = i3 - i;
            int i5 = cVar3.d;
            int i6 = i5 - i2;
            boolean z = e;
            if (!z && i4 < 0) {
                throw new AssertionError();
            }
            if (!z && i6 < 0) {
                throw new AssertionError();
            }
            if (i4 > i6) {
                cVar2 = new c(cVar3.a, cVar3.b, i, i5);
                c cVar4 = this.b;
                cVar = new c(cVar2.a + i, cVar4.b, cVar4.c - i, cVar4.d);
            } else {
                c cVar5 = new c(cVar3.a, cVar3.b, i3, i2);
                c cVar6 = this.b;
                cVar = new c(cVar6.a, cVar5.b + i2, cVar6.c, cVar6.d - i2);
                cVar2 = cVar5;
            }
            this.c = new b(cVar2);
            this.d = new b(cVar);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c {
        public int a;
        public int b;
        public int c;
        public int d;

        c(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public String toString() {
            return "[ x: " + this.a + ", y: " + this.b + ", w: " + this.c + ", h: " + this.d + " ]";
        }
    }

    public ew(int i, int i2) {
        this.a = new b(new c(0, 0, i, i2));
    }

    public c a(int i, int i2, String str) {
        b a2 = this.a.a(i, i2, str);
        if (a2 != null) {
            c cVar = a2.b;
            return new c(cVar.a, cVar.b, cVar.c, cVar.d);
        }
        return null;
    }

    public int b() {
        return this.a.b.d;
    }

    public boolean a(String str) {
        return this.a.a(str);
    }

    public int a() {
        return this.a.b.c;
    }
}
