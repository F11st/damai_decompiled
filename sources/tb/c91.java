package tb;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c91 {
    private static final boolean b = true;
    private static final boolean c = false;
    private final int a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.c91$b */
    /* loaded from: classes11.dex */
    public static class C8995b {
        private static Queue<C8995b> e = new LinkedList();
        int a;
        int b;
        int c;
        int d;

        private C8995b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C8995b c(int i, int i2, int i3) {
            C8995b poll = e.poll();
            if (poll == null) {
                poll = new C8995b();
            }
            poll.a = i;
            poll.b = i2;
            poll.c = i3;
            return poll;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (e.size() < 100) {
                e.add(this);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.c91$c */
    /* loaded from: classes11.dex */
    private static class C8996c implements Comparator<C8995b> {
        private C8996c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C8995b c8995b, C8995b c8995b2) {
            int i = c8995b.a;
            int i2 = c8995b2.a;
            if (i < i2) {
                return -1;
            }
            if (i == i2) {
                int i3 = c8995b.d;
                if (i3 == c8995b2.d) {
                    return 0;
                }
                if (i3 == 0) {
                    return -1;
                }
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.c91$d */
    /* loaded from: classes11.dex */
    public static class C8997d {
        int a;
        int b;
        int c;
        int d;
        C8997d e = null;
        C8997d f = null;

        C8997d(int i, int i2, int i3) {
            if (i > 0) {
                this.a = (i3 - i2) + 1;
            }
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public c91(int i) {
        this.a = i;
    }

    private List<C8995b> b(int i, int i2, int i3, int i4, List<dy2> list) {
        ArrayList arrayList = new ArrayList();
        for (dy2 dy2Var : list) {
            int max = Math.max(i, dy2Var.a - this.a);
            int min = Math.min(i2, dy2Var.b + this.a);
            if (max <= min) {
                int i5 = dy2Var.c;
                int i6 = this.a;
                C8995b c2 = C8995b.c(i5 - i6 >= i3 ? i5 - i6 : i3, max, min);
                c2.d = 0;
                int i7 = dy2Var.d + this.a;
                if (i7 > i4) {
                    i7 = i4;
                }
                C8995b c3 = C8995b.c(i7, max, min);
                c3.d = 1;
                arrayList.add(c2);
                arrayList.add(c3);
            }
        }
        return arrayList;
    }

    private void c(C8997d c8997d, C8995b c8995b, boolean z) {
        int i = c8997d.c;
        int i2 = c8997d.d;
        int i3 = c8995b.b;
        if (i3 <= i && c8995b.c >= i2) {
            if (z) {
                c8997d.b++;
            } else {
                c8997d.b--;
            }
            C8997d c8997d2 = c8997d.e;
            if (c8997d2 != null) {
                c(c8997d2, c8995b, z);
            }
            C8997d c8997d3 = c8997d.f;
            if (c8997d3 != null) {
                c(c8997d3, c8995b, z);
            }
            if (c8997d.b > 0) {
                c8997d.a = (i2 - i) + 1;
                return;
            }
            c8997d.a = 0;
            C8997d c8997d4 = c8997d.e;
            if (c8997d4 != null) {
                c8997d.a = 0 + c8997d4.a;
            }
            C8997d c8997d5 = c8997d.f;
            if (c8997d5 != null) {
                c8997d.a += c8997d5.a;
                return;
            }
            return;
        }
        int i4 = (i + i2) / 2;
        if (i4 >= i3) {
            if (c8997d.e == null) {
                c8997d.e = new C8997d(c8997d.b, i, i4);
            }
            c(c8997d.e, c8995b, z);
        }
        if (i4 < c8995b.c) {
            if (c8997d.f == null) {
                c8997d.f = new C8997d(c8997d.b, i4 + 1, c8997d.d);
            }
            c(c8997d.f, c8995b, z);
        }
        int d = d(c8997d);
        c8997d.b = d;
        if (d > 0) {
            c8997d.a = (i2 - i) + 1;
            return;
        }
        c8997d.a = 0;
        C8997d c8997d6 = c8997d.e;
        if (c8997d6 != null) {
            c8997d.a = 0 + c8997d6.a;
        }
        C8997d c8997d7 = c8997d.f;
        if (c8997d7 != null) {
            c8997d.a += c8997d7.a;
        }
    }

    private int d(C8997d c8997d) {
        C8997d c8997d2 = c8997d.e;
        C8997d c8997d3 = c8997d.f;
        return Math.min(c8997d2 == null ? c8997d.b : c8997d2.b, c8997d3 == null ? c8997d.b : c8997d3.b);
    }

    private int e(int i, int i2, List<C8995b> list) {
        int i3 = 0;
        C8997d c8997d = new C8997d(0, i, i2);
        int i4 = 0;
        for (C8995b c8995b : list) {
            int i5 = c8995b.a;
            if (i5 > i4) {
                int i6 = c8997d.a;
                if (i6 > 1) {
                    i3 += (i5 - i4) * (i6 - 1);
                }
                i4 = i5;
            }
            c(c8997d, c8995b, c8995b.d == 0 ? b : c);
        }
        return i3;
    }

    public float a(View view, List<dy2> list, View view2) {
        float f = 0.0f;
        if (list != null && list.size() != 0) {
            int[] b2 = ry2.b(view, view2);
            int max = Math.max(0, b2[1]);
            int min = Math.min(ry2.screenHeight, b2[1] + view.getHeight());
            int max2 = Math.max(0, b2[0]);
            int min2 = Math.min(ry2.screenWidth, b2[0] + view.getWidth());
            int i = min2 - max2;
            if (i <= 0) {
                i = 0;
            }
            int i2 = min - max;
            int i3 = i * (i2 > 0 ? i2 : 0);
            if (i3 == 0) {
                return 0.0f;
            }
            List<C8995b> b3 = b(max, min, max2, min2, list);
            if (b3.size() == 0) {
                return 0.0f;
            }
            Collections.sort(b3, new C8996c());
            f = (e(max, min, b3) * 1.0f) / i3;
            for (C8995b c8995b : b3) {
                if (c8995b != null) {
                    c8995b.d();
                }
            }
        }
        return f;
    }
}
