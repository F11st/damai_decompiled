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
public class d91 {
    private static final boolean a = true;
    private static final boolean b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.d91$b */
    /* loaded from: classes11.dex */
    public static class C9035b {
        private static Queue<C9035b> e = new LinkedList();
        int a;
        int b;
        int c;
        int d;

        private C9035b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static C9035b c(int i, int i2, int i3) {
            C9035b poll = e.poll();
            if (poll == null) {
                poll = new C9035b();
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
    /* renamed from: tb.d91$c */
    /* loaded from: classes11.dex */
    private static class C9036c implements Comparator<C9035b> {
        private C9036c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C9035b c9035b, C9035b c9035b2) {
            int i = c9035b.a;
            int i2 = c9035b2.a;
            if (i < i2) {
                return -1;
            }
            if (i == i2) {
                int i3 = c9035b.d;
                if (i3 == c9035b2.d) {
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
    /* renamed from: tb.d91$d */
    /* loaded from: classes11.dex */
    public static class C9037d {
        int a;
        int b;
        int c;
        int d;
        C9037d e = null;
        C9037d f = null;

        C9037d(int i, int i2, int i3) {
            if (i > 0) {
                this.a = (i3 - i2) + 1;
            }
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    private List<C9035b> b(int i, int i2, int i3, int i4, List<dy2> list) {
        ArrayList arrayList = new ArrayList();
        for (dy2 dy2Var : list) {
            int max = Math.max(i, dy2Var.a - dy2Var.f);
            int min = Math.min(i2, dy2Var.b + dy2Var.h);
            if (max <= min) {
                int i5 = dy2Var.c;
                int i6 = dy2Var.e;
                C9035b c = C9035b.c(i5 - i6 >= i3 ? i5 - i6 : i3, max, min);
                c.d = 0;
                int i7 = dy2Var.d + dy2Var.g;
                if (i7 > i4) {
                    i7 = i4;
                }
                C9035b c2 = C9035b.c(i7, max, min);
                c2.d = 1;
                arrayList.add(c);
                arrayList.add(c2);
            }
        }
        return arrayList;
    }

    private void c(C9037d c9037d, C9035b c9035b, boolean z) {
        int i = c9037d.c;
        int i2 = c9037d.d;
        int i3 = c9035b.b;
        if (i3 <= i && c9035b.c >= i2) {
            if (z) {
                c9037d.b++;
            } else {
                c9037d.b--;
            }
            C9037d c9037d2 = c9037d.e;
            if (c9037d2 != null) {
                c(c9037d2, c9035b, z);
            }
            C9037d c9037d3 = c9037d.f;
            if (c9037d3 != null) {
                c(c9037d3, c9035b, z);
            }
            if (c9037d.b > 0) {
                c9037d.a = (i2 - i) + 1;
                return;
            }
            c9037d.a = 0;
            C9037d c9037d4 = c9037d.e;
            if (c9037d4 != null) {
                c9037d.a = 0 + c9037d4.a;
            }
            C9037d c9037d5 = c9037d.f;
            if (c9037d5 != null) {
                c9037d.a += c9037d5.a;
                return;
            }
            return;
        }
        int i4 = (i + i2) / 2;
        if (i4 >= i3) {
            if (c9037d.e == null) {
                c9037d.e = new C9037d(c9037d.b, i, i4);
            }
            c(c9037d.e, c9035b, z);
        }
        if (i4 < c9035b.c) {
            if (c9037d.f == null) {
                c9037d.f = new C9037d(c9037d.b, i4 + 1, c9037d.d);
            }
            c(c9037d.f, c9035b, z);
        }
        int d = d(c9037d);
        c9037d.b = d;
        if (d > 0) {
            c9037d.a = (i2 - i) + 1;
            return;
        }
        c9037d.a = 0;
        C9037d c9037d6 = c9037d.e;
        if (c9037d6 != null) {
            c9037d.a = 0 + c9037d6.a;
        }
        C9037d c9037d7 = c9037d.f;
        if (c9037d7 != null) {
            c9037d.a += c9037d7.a;
        }
    }

    private int d(C9037d c9037d) {
        C9037d c9037d2 = c9037d.e;
        C9037d c9037d3 = c9037d.f;
        return Math.min(c9037d2 == null ? c9037d.b : c9037d2.b, c9037d3 == null ? c9037d.b : c9037d3.b);
    }

    private int e(int i, int i2, List<C9035b> list) {
        int i3 = 0;
        C9037d c9037d = new C9037d(0, i, i2);
        int i4 = 0;
        for (C9035b c9035b : list) {
            int i5 = c9035b.a;
            if (i5 > i4) {
                int i6 = c9037d.a;
                if (i6 > 1) {
                    i3 += (i5 - i4) * (i6 - 1);
                }
                i4 = i5;
            }
            c(c9037d, c9035b, c9035b.d == 0 ? a : b);
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
            List<C9035b> b3 = b(max, min, max2, min2, list);
            if (b3.size() == 0) {
                return 0.0f;
            }
            Collections.sort(b3, new C9036c());
            f = (e(max, min, b3) * 1.0f) / i3;
            for (C9035b c9035b : b3) {
                if (c9035b != null) {
                    c9035b.d();
                }
            }
        }
        return f;
    }
}
