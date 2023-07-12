package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ew {
    C4536b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ew$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4535a.values().length];
            a = iArr;
            try {
                iArr[EnumC4535a.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC4535a.PERFECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC4535a.FIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ew$a */
    /* loaded from: classes10.dex */
    public enum EnumC4535a {
        FAIL,
        PERFECT,
        FIT
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ew$b */
    /* loaded from: classes10.dex */
    class C4536b {
        static final /* synthetic */ boolean e = true;
        String a;
        C4537c b;
        C4536b c = null;
        C4536b d = null;

        C4536b(C4537c c4537c) {
            this.b = c4537c;
        }

        C4536b a(int i, int i2, String str) {
            if (!a()) {
                C4536b a = this.c.a(i, i2, str);
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

        EnumC4535a b(int i, int i2) {
            int i3;
            C4537c c4537c = this.b;
            int i4 = c4537c.c;
            if (i > i4 || i2 > (i3 = c4537c.d)) {
                return EnumC4535a.FAIL;
            }
            if (i == i4 && i2 == i3) {
                return EnumC4535a.PERFECT;
            }
            return EnumC4535a.FIT;
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
            C4537c c4537c;
            C4537c c4537c2;
            C4537c c4537c3 = this.b;
            int i3 = c4537c3.c;
            int i4 = i3 - i;
            int i5 = c4537c3.d;
            int i6 = i5 - i2;
            boolean z = e;
            if (!z && i4 < 0) {
                throw new AssertionError();
            }
            if (!z && i6 < 0) {
                throw new AssertionError();
            }
            if (i4 > i6) {
                c4537c2 = new C4537c(c4537c3.a, c4537c3.b, i, i5);
                C4537c c4537c4 = this.b;
                c4537c = new C4537c(c4537c2.a + i, c4537c4.b, c4537c4.c - i, c4537c4.d);
            } else {
                C4537c c4537c5 = new C4537c(c4537c3.a, c4537c3.b, i3, i2);
                C4537c c4537c6 = this.b;
                c4537c = new C4537c(c4537c6.a, c4537c5.b + i2, c4537c6.c, c4537c6.d - i2);
                c4537c2 = c4537c5;
            }
            this.c = new C4536b(c4537c2);
            this.d = new C4536b(c4537c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ew$c */
    /* loaded from: classes10.dex */
    public static class C4537c {
        public int a;
        public int b;
        public int c;
        public int d;

        C4537c(int i, int i2, int i3, int i4) {
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
        this.a = new C4536b(new C4537c(0, 0, i, i2));
    }

    public C4537c a(int i, int i2, String str) {
        C4536b a = this.a.a(i, i2, str);
        if (a != null) {
            C4537c c4537c = a.b;
            return new C4537c(c4537c.a, c4537c.b, c4537c.c, c4537c.d);
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
