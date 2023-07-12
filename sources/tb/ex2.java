package tb;

import com.alibaba.wireless.security.SecExceptionCode;
import com.youku.uplayer.AliMediaPlayer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ex2 {
    private static final ex2[] d = a();
    private final int a;
    private final C9119b[] b;
    private final int c;

    /* compiled from: Taobao */
    /* renamed from: tb.ex2$a */
    /* loaded from: classes10.dex */
    public static final class C9118a {
        private final int a;
        private final int b;

        C9118a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    private ex2(int i, int[] iArr, C9119b c9119b, C9119b c9119b2, C9119b c9119b3, C9119b c9119b4) {
        C9118a[] a;
        this.a = i;
        this.b = new C9119b[]{c9119b, c9119b2, c9119b3, c9119b4};
        int b = c9119b.b();
        int i2 = 0;
        for (C9118a c9118a : c9119b.a()) {
            i2 += c9118a.a() * (c9118a.b() + b);
        }
        this.c = i2;
    }

    private static ex2[] a() {
        return new ex2[]{new ex2(1, new int[0], new C9119b(7, new C9118a(1, 19)), new C9119b(10, new C9118a(1, 16)), new C9119b(13, new C9118a(1, 13)), new C9119b(17, new C9118a(1, 9))), new ex2(2, new int[]{6, 18}, new C9119b(10, new C9118a(1, 34)), new C9119b(16, new C9118a(1, 28)), new C9119b(22, new C9118a(1, 22)), new C9119b(28, new C9118a(1, 16))), new ex2(3, new int[]{6, 22}, new C9119b(15, new C9118a(1, 55)), new C9119b(26, new C9118a(1, 44)), new C9119b(18, new C9118a(2, 17)), new C9119b(22, new C9118a(2, 13))), new ex2(4, new int[]{6, 26}, new C9119b(20, new C9118a(1, 80)), new C9119b(18, new C9118a(2, 32)), new C9119b(26, new C9118a(2, 24)), new C9119b(16, new C9118a(4, 9))), new ex2(5, new int[]{6, 30}, new C9119b(26, new C9118a(1, 108)), new C9119b(24, new C9118a(2, 43)), new C9119b(18, new C9118a(2, 15), new C9118a(2, 16)), new C9119b(22, new C9118a(2, 11), new C9118a(2, 12))), new ex2(6, new int[]{6, 34}, new C9119b(18, new C9118a(2, 68)), new C9119b(16, new C9118a(4, 27)), new C9119b(24, new C9118a(4, 19)), new C9119b(28, new C9118a(4, 15))), new ex2(7, new int[]{6, 22, 38}, new C9119b(20, new C9118a(2, 78)), new C9119b(18, new C9118a(4, 31)), new C9119b(18, new C9118a(2, 14), new C9118a(4, 15)), new C9119b(26, new C9118a(4, 13), new C9118a(1, 14))), new ex2(8, new int[]{6, 24, 42}, new C9119b(24, new C9118a(2, 97)), new C9119b(22, new C9118a(2, 38), new C9118a(2, 39)), new C9119b(22, new C9118a(4, 18), new C9118a(2, 19)), new C9119b(26, new C9118a(4, 14), new C9118a(2, 15))), new ex2(9, new int[]{6, 26, 46}, new C9119b(30, new C9118a(2, 116)), new C9119b(22, new C9118a(3, 36), new C9118a(2, 37)), new C9119b(20, new C9118a(4, 16), new C9118a(4, 17)), new C9119b(24, new C9118a(4, 12), new C9118a(4, 13))), new ex2(10, new int[]{6, 28, 50}, new C9119b(18, new C9118a(2, 68), new C9118a(2, 69)), new C9119b(26, new C9118a(4, 43), new C9118a(1, 44)), new C9119b(24, new C9118a(6, 19), new C9118a(2, 20)), new C9119b(28, new C9118a(6, 15), new C9118a(2, 16))), new ex2(11, new int[]{6, 30, 54}, new C9119b(20, new C9118a(4, 81)), new C9119b(30, new C9118a(1, 50), new C9118a(4, 51)), new C9119b(28, new C9118a(4, 22), new C9118a(4, 23)), new C9119b(24, new C9118a(3, 12), new C9118a(8, 13))), new ex2(12, new int[]{6, 32, 58}, new C9119b(24, new C9118a(2, 92), new C9118a(2, 93)), new C9119b(22, new C9118a(6, 36), new C9118a(2, 37)), new C9119b(26, new C9118a(4, 20), new C9118a(6, 21)), new C9119b(28, new C9118a(7, 14), new C9118a(4, 15))), new ex2(13, new int[]{6, 34, 62}, new C9119b(26, new C9118a(4, 107)), new C9119b(22, new C9118a(8, 37), new C9118a(1, 38)), new C9119b(24, new C9118a(8, 20), new C9118a(4, 21)), new C9119b(22, new C9118a(12, 11), new C9118a(4, 12))), new ex2(14, new int[]{6, 26, 46, 66}, new C9119b(30, new C9118a(3, 115), new C9118a(1, 116)), new C9119b(24, new C9118a(4, 40), new C9118a(5, 41)), new C9119b(20, new C9118a(11, 16), new C9118a(5, 17)), new C9119b(24, new C9118a(11, 12), new C9118a(5, 13))), new ex2(15, new int[]{6, 26, 48, 70}, new C9119b(22, new C9118a(5, 87), new C9118a(1, 88)), new C9119b(24, new C9118a(5, 41), new C9118a(5, 42)), new C9119b(30, new C9118a(5, 24), new C9118a(7, 25)), new C9119b(24, new C9118a(11, 12), new C9118a(7, 13))), new ex2(16, new int[]{6, 26, 50, 74}, new C9119b(24, new C9118a(5, 98), new C9118a(1, 99)), new C9119b(28, new C9118a(7, 45), new C9118a(3, 46)), new C9119b(24, new C9118a(15, 19), new C9118a(2, 20)), new C9119b(30, new C9118a(3, 15), new C9118a(13, 16))), new ex2(17, new int[]{6, 30, 54, 78}, new C9119b(28, new C9118a(1, 107), new C9118a(5, 108)), new C9119b(28, new C9118a(10, 46), new C9118a(1, 47)), new C9119b(28, new C9118a(1, 22), new C9118a(15, 23)), new C9119b(28, new C9118a(2, 14), new C9118a(17, 15))), new ex2(18, new int[]{6, 30, 56, 82}, new C9119b(30, new C9118a(5, 120), new C9118a(1, 121)), new C9119b(26, new C9118a(9, 43), new C9118a(4, 44)), new C9119b(28, new C9118a(17, 22), new C9118a(1, 23)), new C9119b(28, new C9118a(2, 14), new C9118a(19, 15))), new ex2(19, new int[]{6, 30, 58, 86}, new C9119b(28, new C9118a(3, 113), new C9118a(4, 114)), new C9119b(26, new C9118a(3, 44), new C9118a(11, 45)), new C9119b(26, new C9118a(17, 21), new C9118a(4, 22)), new C9119b(26, new C9118a(9, 13), new C9118a(16, 14))), new ex2(20, new int[]{6, 34, 62, 90}, new C9119b(28, new C9118a(3, 107), new C9118a(5, 108)), new C9119b(26, new C9118a(3, 41), new C9118a(13, 42)), new C9119b(30, new C9118a(15, 24), new C9118a(5, 25)), new C9119b(28, new C9118a(15, 15), new C9118a(10, 16))), new ex2(21, new int[]{6, 28, 50, 72, 94}, new C9119b(28, new C9118a(4, 116), new C9118a(4, 117)), new C9119b(26, new C9118a(17, 42)), new C9119b(28, new C9118a(17, 22), new C9118a(6, 23)), new C9119b(30, new C9118a(19, 16), new C9118a(6, 17))), new ex2(22, new int[]{6, 26, 50, 74, 98}, new C9119b(28, new C9118a(2, 111), new C9118a(7, 112)), new C9119b(28, new C9118a(17, 46)), new C9119b(30, new C9118a(7, 24), new C9118a(16, 25)), new C9119b(24, new C9118a(34, 13))), new ex2(23, new int[]{6, 30, 54, 78, 102}, new C9119b(30, new C9118a(4, 121), new C9118a(5, 122)), new C9119b(28, new C9118a(4, 47), new C9118a(14, 48)), new C9119b(30, new C9118a(11, 24), new C9118a(14, 25)), new C9119b(30, new C9118a(16, 15), new C9118a(14, 16))), new ex2(24, new int[]{6, 28, 54, 80, 106}, new C9119b(30, new C9118a(6, 117), new C9118a(4, 118)), new C9119b(28, new C9118a(6, 45), new C9118a(14, 46)), new C9119b(30, new C9118a(11, 24), new C9118a(16, 25)), new C9119b(30, new C9118a(30, 16), new C9118a(2, 17))), new ex2(25, new int[]{6, 32, 58, 84, 110}, new C9119b(26, new C9118a(8, 106), new C9118a(4, 107)), new C9119b(28, new C9118a(8, 47), new C9118a(13, 48)), new C9119b(30, new C9118a(7, 24), new C9118a(22, 25)), new C9119b(30, new C9118a(22, 15), new C9118a(13, 16))), new ex2(26, new int[]{6, 30, 58, 86, 114}, new C9119b(28, new C9118a(10, 114), new C9118a(2, 115)), new C9119b(28, new C9118a(19, 46), new C9118a(4, 47)), new C9119b(28, new C9118a(28, 22), new C9118a(6, 23)), new C9119b(30, new C9118a(33, 16), new C9118a(4, 17))), new ex2(27, new int[]{6, 34, 62, 90, 118}, new C9119b(30, new C9118a(8, 122), new C9118a(4, 123)), new C9119b(28, new C9118a(22, 45), new C9118a(3, 46)), new C9119b(30, new C9118a(8, 23), new C9118a(26, 24)), new C9119b(30, new C9118a(12, 15), new C9118a(28, 16))), new ex2(28, new int[]{6, 26, 50, 74, 98, 122}, new C9119b(30, new C9118a(3, 117), new C9118a(10, 118)), new C9119b(28, new C9118a(3, 45), new C9118a(23, 46)), new C9119b(30, new C9118a(4, 24), new C9118a(31, 25)), new C9119b(30, new C9118a(11, 15), new C9118a(31, 16))), new ex2(29, new int[]{6, 30, 54, 78, 102, 126}, new C9119b(30, new C9118a(7, 116), new C9118a(7, 117)), new C9119b(28, new C9118a(21, 45), new C9118a(7, 46)), new C9119b(30, new C9118a(1, 23), new C9118a(37, 24)), new C9119b(30, new C9118a(19, 15), new C9118a(26, 16))), new ex2(30, new int[]{6, 26, 52, 78, 104, 130}, new C9119b(30, new C9118a(5, 115), new C9118a(10, 116)), new C9119b(28, new C9118a(19, 47), new C9118a(10, 48)), new C9119b(30, new C9118a(15, 24), new C9118a(25, 25)), new C9119b(30, new C9118a(23, 15), new C9118a(25, 16))), new ex2(31, new int[]{6, 30, 56, 82, 108, 134}, new C9119b(30, new C9118a(13, 115), new C9118a(3, 116)), new C9119b(28, new C9118a(2, 46), new C9118a(29, 47)), new C9119b(30, new C9118a(42, 24), new C9118a(1, 25)), new C9119b(30, new C9118a(23, 15), new C9118a(28, 16))), new ex2(32, new int[]{6, 34, 60, 86, 112, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR}, new C9119b(30, new C9118a(17, 115)), new C9119b(28, new C9118a(10, 46), new C9118a(23, 47)), new C9119b(30, new C9118a(10, 24), new C9118a(35, 25)), new C9119b(30, new C9118a(19, 15), new C9118a(35, 16))), new ex2(33, new int[]{6, 30, 58, 86, 114, 142}, new C9119b(30, new C9118a(17, 115), new C9118a(1, 116)), new C9119b(28, new C9118a(14, 46), new C9118a(21, 47)), new C9119b(30, new C9118a(29, 24), new C9118a(19, 25)), new C9119b(30, new C9118a(11, 15), new C9118a(46, 16))), new ex2(34, new int[]{6, 34, 62, 90, 118, 146}, new C9119b(30, new C9118a(13, 115), new C9118a(6, 116)), new C9119b(28, new C9118a(14, 46), new C9118a(23, 47)), new C9119b(30, new C9118a(44, 24), new C9118a(7, 25)), new C9119b(30, new C9118a(59, 16), new C9118a(1, 17))), new ex2(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new C9119b(30, new C9118a(12, 121), new C9118a(7, 122)), new C9119b(28, new C9118a(12, 47), new C9118a(26, 48)), new C9119b(30, new C9118a(39, 24), new C9118a(14, 25)), new C9119b(30, new C9118a(22, 15), new C9118a(41, 16))), new ex2(36, new int[]{6, 24, 50, 76, 102, 128, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER}, new C9119b(30, new C9118a(6, 121), new C9118a(14, 122)), new C9119b(28, new C9118a(6, 47), new C9118a(34, 48)), new C9119b(30, new C9118a(46, 24), new C9118a(10, 25)), new C9119b(30, new C9118a(2, 15), new C9118a(64, 16))), new ex2(37, new int[]{6, 28, 54, 80, 106, 132, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED}, new C9119b(30, new C9118a(17, 122), new C9118a(4, 123)), new C9119b(28, new C9118a(29, 46), new C9118a(14, 47)), new C9119b(30, new C9118a(49, 24), new C9118a(10, 25)), new C9119b(30, new C9118a(24, 15), new C9118a(46, 16))), new ex2(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new C9119b(30, new C9118a(4, 122), new C9118a(18, 123)), new C9119b(28, new C9118a(13, 46), new C9118a(32, 47)), new C9119b(30, new C9118a(48, 24), new C9118a(14, 25)), new C9119b(30, new C9118a(42, 15), new C9118a(32, 16))), new ex2(39, new int[]{6, 26, 54, 82, 110, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR, 166}, new C9119b(30, new C9118a(20, 117), new C9118a(4, 118)), new C9119b(28, new C9118a(40, 47), new C9118a(7, 48)), new C9119b(30, new C9118a(43, 24), new C9118a(22, 25)), new C9119b(30, new C9118a(10, 15), new C9118a(67, 16))), new ex2(40, new int[]{6, 30, 58, 86, 114, 142, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT}, new C9119b(30, new C9118a(19, 118), new C9118a(6, 119)), new C9119b(28, new C9118a(18, 47), new C9118a(31, 48)), new C9119b(30, new C9118a(34, 24), new C9118a(34, 25)), new C9119b(30, new C9118a(20, 15), new C9118a(61, 16)))};
    }

    public static ex2 e(int i) {
        if (i >= 1 && i <= 40) {
            return d[i - 1];
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return (this.a * 4) + 17;
    }

    public C9119b c(df0 df0Var) {
        return this.b[df0Var.b()];
    }

    public int d() {
        return this.c;
    }

    public int f() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    /* compiled from: Taobao */
    /* renamed from: tb.ex2$b */
    /* loaded from: classes10.dex */
    public static final class C9119b {
        private final int a;
        private final C9118a[] b;

        C9119b(int i, C9118a c9118a) {
            this.a = i;
            this.b = new C9118a[]{c9118a};
        }

        public C9118a[] a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        public int c() {
            int i = 0;
            int i2 = 0;
            while (true) {
                C9118a[] c9118aArr = this.b;
                if (i >= c9118aArr.length) {
                    return i2;
                }
                i2 += c9118aArr[i].a();
                i++;
            }
        }

        public int d() {
            return this.a * c();
        }

        C9119b(int i, C9118a c9118a, C9118a c9118a2) {
            this.a = i;
            this.b = new C9118a[]{c9118a, c9118a2};
        }
    }
}
