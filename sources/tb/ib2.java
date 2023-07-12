package tb;

import android.view.View;
import androidx.annotation.NonNull;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ib2 implements ICalculator {
    private final View a;
    private final View b;
    private final boolean c;
    private final List<C9258a> d = new ArrayList();
    private final List<C9258a> e = new ArrayList();
    private final List<C9258a> f = new ArrayList();
    private final List<C9258a> g = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: tb.ib2$a */
    /* loaded from: classes11.dex */
    public static class C9258a implements Comparable<C9258a> {
        private static Queue<C9258a> c = new LinkedList();
        int a;
        int b;

        public static C9258a b(int i, int i2) {
            C9258a poll = c.poll();
            if (poll == null) {
                poll = new C9258a();
            }
            poll.a = i;
            poll.b = i2;
            return poll;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull C9258a c9258a) {
            int i = this.a;
            int i2 = c9258a.a;
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 0 : -1;
        }

        public void c() {
            if (c.size() < 100) {
                c.add(this);
            }
            this.a = 0;
            this.b = 0;
        }
    }

    public ib2(View view, View view2, boolean z) {
        this.a = view;
        this.b = view2;
        this.c = z;
    }

    private int a(List<C9258a> list, List<C9258a> list2, boolean z) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            C9258a c9258a = list.get(i5);
            if (i4 <= c9258a.a) {
                i = (i + i2) - b(i3, i4, list2, z);
                int i6 = c9258a.a;
                int i7 = c9258a.b;
                int i8 = i7 - i6;
                i3 = i6;
                i2 = i8;
                i4 = i7;
            } else {
                int i9 = c9258a.b;
                if (i4 < i9) {
                    i2 = i9 - i3;
                    i4 = i9;
                }
            }
        }
        return (i + i2) - b(i3, i4, list2, z);
    }

    private int b(int i, int i2, List<C9258a> list, boolean z) {
        int i3 = 0;
        if (z && list != null) {
            for (C9258a c9258a : list) {
                if (c9258a.b >= i) {
                    int i4 = c9258a.a;
                    if (i2 < i4) {
                        break;
                    }
                    i3 += Math.min(c9258a.b, i2) - Math.max(i4, i);
                }
            }
        }
        return i3;
    }

    private void c(List<dy2> list, List<C9258a> list2, List<C9258a> list3) {
        if (list == null) {
            return;
        }
        for (dy2 dy2Var : list) {
            C9258a b = C9258a.b(dy2Var.c, dy2Var.d);
            C9258a b2 = C9258a.b(dy2Var.a, dy2Var.b);
            list2.add(b);
            list3.add(b2);
        }
        Collections.sort(list2);
        Collections.sort(list3);
    }

    private List<C9258a> d(List<C9258a> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            C9258a c9258a = list.get(i3);
            if (i2 <= c9258a.a) {
                arrayList.add(C9258a.b(i, i2));
                i = c9258a.a;
                i2 = c9258a.b;
            } else {
                int i4 = c9258a.b;
                if (i2 < i4) {
                    i2 = i4;
                }
            }
        }
        if (i != i2) {
            arrayList.add(C9258a.b(i, i2));
        }
        return arrayList;
    }

    private void e(List<C9258a> list) {
        if (list != null) {
            for (C9258a c9258a : list) {
                c9258a.c();
            }
            list.clear();
        }
    }

    private void f(List<dy2> list, List<C9258a> list2, List<C9258a> list3) {
        if (list != null) {
            for (dy2 dy2Var : list) {
                dy2Var.c();
            }
            list.clear();
        }
        e(list2);
        e(list3);
    }

    @Override // com.taobao.monitor.impl.data.calculator.ICalculator
    public ff calculate() {
        ey2 ey2Var = new ey2(this.a, this.b);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ey2Var.b(arrayList, arrayList2);
        View f = ey2Var.f();
        c(arrayList, this.d, this.e);
        c(arrayList2, this.f, this.g);
        List<C9258a> d = d(this.f);
        List<C9258a> d2 = d(this.g);
        float a = a(this.d, d, this.c) / ry2.screenWidth;
        float a2 = a(this.e, d2, this.c) / ry2.screenHeight;
        f(arrayList, this.d, this.e);
        f(arrayList2, this.f, this.g);
        e(d);
        e(d2);
        ey2Var.n();
        float f2 = (a > 0.6f ? 0.4f : a * 0.5f) + (a2 <= 0.8f ? a2 * 0.5f : 0.4f);
        boolean g = ey2Var.g();
        View e = ey2Var.e();
        if (f == this.b) {
            f = null;
        }
        return new ff(ib2.class, f2, g, e, f);
    }
}
