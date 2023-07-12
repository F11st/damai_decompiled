package cn.damai.tetris.v2.helper;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.AbstractC3291c;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import tb.jn1;
import tb.m81;
import tb.py1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class StaggeredLayoutHelper extends BaseLayoutHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static BitSet m;
    private C2009b[] a;
    private C2008a b;
    private final Runnable c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private List<View> j;
    private WeakReference<VirtualLayoutManager> k;
    private int l;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.v2.helper.StaggeredLayoutHelper$a */
    /* loaded from: classes16.dex */
    public static class C2008a {
        private static transient /* synthetic */ IpChange $ipChange;
        int[] a;
        StaggeredLayoutHelper b;

        C2008a(StaggeredLayoutHelper staggeredLayoutHelper) {
            this.b = staggeredLayoutHelper;
        }

        void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1464322644")) {
                ipChange.ipc$dispatch("-1464322644", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, Integer.MIN_VALUE);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[d(i)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, Integer.MIN_VALUE);
            }
        }

        int b(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1345934174")) {
                return ((Integer) ipChange.ipc$dispatch("-1345934174", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            if (i - this.b.getRange().d().intValue() < this.b.d) {
                return i - this.b.getRange().d().intValue();
            }
            int[] iArr = this.a;
            if (iArr == null || i >= iArr.length || i < 0) {
                return Integer.MIN_VALUE;
            }
            return iArr[i];
        }

        void c(int i, C2009b c2009b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2055108969")) {
                ipChange.ipc$dispatch("-2055108969", new Object[]{this, Integer.valueOf(i), c2009b});
                return;
            }
            a(i);
            this.a[i] = c2009b.a;
        }

        int d(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "534145459")) {
                return ((Integer) ipChange.ipc$dispatch("534145459", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.v2.helper.StaggeredLayoutHelper$b */
    /* loaded from: classes16.dex */
    public static class C2009b {
        private static transient /* synthetic */ IpChange $ipChange;
        final int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        private ArrayList<View> g;

        void b(View view, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1698218071")) {
                ipChange.ipc$dispatch("1698218071", new Object[]{this, view, abstractC3291c});
                return;
            }
            RecyclerView.LayoutParams l = l(view);
            this.g.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.g.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d += abstractC3291c.e(view);
            }
        }

        void c(boolean z, int i, AbstractC3291c abstractC3291c) {
            int n;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "848392924")) {
                ipChange.ipc$dispatch("848392924", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), abstractC3291c});
                return;
            }
            if (z) {
                n = k(abstractC3291c);
            } else {
                n = n(abstractC3291c);
            }
            f();
            if (n != Integer.MIN_VALUE) {
                if ((!z || n >= abstractC3291c.i()) && !z) {
                    abstractC3291c.k();
                }
                if (i != Integer.MIN_VALUE) {
                    n += i;
                }
                this.c = n;
                this.b = n;
                this.f = Integer.MIN_VALUE;
                this.e = Integer.MIN_VALUE;
            }
        }

        void d(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1831737771")) {
                ipChange.ipc$dispatch("1831737771", new Object[]{this, abstractC3291c});
            } else if (this.g.size() == 0) {
                this.c = Integer.MIN_VALUE;
            } else {
                ArrayList<View> arrayList = this.g;
                this.c = abstractC3291c.d(arrayList.get(arrayList.size() - 1));
            }
        }

        void e(@NonNull AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2024930702")) {
                ipChange.ipc$dispatch("-2024930702", new Object[]{this, abstractC3291c});
            } else if (this.g.size() == 0) {
                this.b = Integer.MIN_VALUE;
            } else {
                this.b = abstractC3291c.g(this.g.get(0));
            }
        }

        void f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-356342251")) {
                ipChange.ipc$dispatch("-356342251", new Object[]{this});
                return;
            }
            this.g.clear();
            o();
            this.d = 0;
        }

        boolean g(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1924272074")) {
                return ((Boolean) ipChange.ipc$dispatch("-1924272074", new Object[]{this, view})).booleanValue();
            }
            int size = this.g.size();
            return size > 0 && this.g.get(size - 1) == view;
        }

        boolean h(View view) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-987460099") ? ((Boolean) ipChange.ipc$dispatch("-987460099", new Object[]{this, view})).booleanValue() : this.g.size() > 0 && this.g.get(0) == view;
        }

        public int i() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-424737545") ? ((Integer) ipChange.ipc$dispatch("-424737545", new Object[]{this})).intValue() : this.d;
        }

        int j(int i, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-222844833")) {
                return ((Integer) ipChange.ipc$dispatch("-222844833", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
            }
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i != Integer.MIN_VALUE && this.g.size() == 0) {
                int i3 = this.e;
                return i3 != Integer.MIN_VALUE ? i3 : i;
            }
            d(abstractC3291c);
            return this.c;
        }

        int k(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1936974012") ? ((Integer) ipChange.ipc$dispatch("-1936974012", new Object[]{this, abstractC3291c})).intValue() : j(Integer.MIN_VALUE, abstractC3291c);
        }

        RecyclerView.LayoutParams l(View view) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-502020507") ? (RecyclerView.LayoutParams) ipChange.ipc$dispatch("-502020507", new Object[]{this, view}) : (RecyclerView.LayoutParams) view.getLayoutParams();
        }

        int m(int i, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-949473160")) {
                return ((Integer) ipChange.ipc$dispatch("-949473160", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
            }
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i != Integer.MIN_VALUE && this.g.size() == 0) {
                int i3 = this.f;
                return i3 != Integer.MIN_VALUE ? i3 : i;
            }
            e(abstractC3291c);
            return this.b;
        }

        int n(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "671985675") ? ((Integer) ipChange.ipc$dispatch("671985675", new Object[]{this, abstractC3291c})).intValue() : m(Integer.MIN_VALUE, abstractC3291c);
        }

        void o() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "612197083")) {
                ipChange.ipc$dispatch("612197083", new Object[]{this});
                return;
            }
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.e = Integer.MIN_VALUE;
        }

        void p(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1414347277")) {
                ipChange.ipc$dispatch("1414347277", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int i2 = this.e;
            if (i2 != Integer.MIN_VALUE) {
                this.e = i2 + i;
            }
            int i3 = this.b;
            if (i3 != Integer.MIN_VALUE) {
                this.b = i3 + i;
            }
            int i4 = this.f;
            if (i4 != Integer.MIN_VALUE) {
                this.f = i4 + i;
            }
            int i5 = this.c;
            if (i5 != Integer.MIN_VALUE) {
                this.c = i5 + i;
            }
        }

        void q(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1863861474")) {
                ipChange.ipc$dispatch("1863861474", new Object[]{this, abstractC3291c});
                return;
            }
            int size = this.g.size();
            View remove = this.g.remove(size - 1);
            RecyclerView.LayoutParams l = l(remove);
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d -= abstractC3291c.e(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void r(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1218823191")) {
                ipChange.ipc$dispatch("-1218823191", new Object[]{this, abstractC3291c});
                return;
            }
            View remove = this.g.remove(0);
            RecyclerView.LayoutParams l = l(remove);
            if (this.g.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d -= abstractC3291c.e(remove);
            }
            this.b = Integer.MIN_VALUE;
        }

        void s(View view, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1857818397")) {
                ipChange.ipc$dispatch("1857818397", new Object[]{this, view, abstractC3291c});
                return;
            }
            RecyclerView.LayoutParams l = l(view);
            this.g.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.g.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (l.isItemRemoved() || l.isItemChanged()) {
                this.d += abstractC3291c.e(view);
            }
        }

        void t(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1159404681")) {
                ipChange.ipc$dispatch("-1159404681", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.b = i;
            this.c = i;
            this.f = Integer.MIN_VALUE;
            this.e = Integer.MIN_VALUE;
        }

        private C2009b(int i) {
            this.g = new ArrayList<>();
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
            this.d = 0;
            this.e = Integer.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.a = i;
        }
    }

    public StaggeredLayoutHelper() {
        this(1, 0);
    }

    private boolean c(C2009b c2009b, VirtualLayoutManager virtualLayoutManager, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394853745")) {
            return ((Boolean) ipChange.ipc$dispatch("394853745", new Object[]{this, c2009b, virtualLayoutManager, Integer.valueOf(i)})).booleanValue();
        }
        AbstractC3291c mainOrientationHelper = virtualLayoutManager.getMainOrientationHelper();
        return virtualLayoutManager.getReverseLayout() ? c2009b.k(mainOrientationHelper) < i : c2009b.n(mainOrientationHelper) > i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkForGaps() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.v2.helper.StaggeredLayoutHelper.checkForGaps():void");
    }

    private C2009b d(int i, View view, boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-281976766")) {
            return (C2009b) ipChange.ipc$dispatch("-281976766", new Object[]{this, Integer.valueOf(i), view, Boolean.valueOf(z)});
        }
        int b = this.b.b(i);
        if (b >= 0) {
            C2009b[] c2009bArr = this.a;
            if (b < c2009bArr.length) {
                C2009b c2009b = c2009bArr[b];
                if (z && c2009b.h(view)) {
                    return c2009b;
                }
                if (!z && c2009b.g(view)) {
                    return c2009b;
                }
            }
        }
        while (true) {
            C2009b[] c2009bArr2 = this.a;
            if (i2 >= c2009bArr2.length) {
                return null;
            }
            if (i2 != b) {
                C2009b c2009b2 = c2009bArr2[i2];
                if (z && c2009b2.h(view)) {
                    return c2009b2;
                }
                if (!z && c2009b2.g(view)) {
                    return c2009b2;
                }
            }
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if ((r8.f() == -1) != r9.getReverseLayout()) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (((r8.f() == -1) == r9.getReverseLayout()) == r9.isDoLayoutRTL()) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.damai.tetris.v2.helper.StaggeredLayoutHelper.C2009b e(int r7, com.alibaba.android.vlayout.VirtualLayoutManager.C3287d r8, com.alibaba.android.vlayout.LayoutManagerHelper r9) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.tetris.v2.helper.StaggeredLayoutHelper.$ipChange
            java.lang.String r1 = "-1537478329"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L24
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r2[r4] = r7
            r7 = 2
            r2[r7] = r8
            r7 = 3
            r2[r7] = r9
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            cn.damai.tetris.v2.helper.StaggeredLayoutHelper$b r7 = (cn.damai.tetris.v2.helper.StaggeredLayoutHelper.C2009b) r7
            return r7
        L24:
            com.alibaba.android.vlayout.c r0 = r9.getMainOrientationHelper()
            int r1 = r9.getOrientation()
            r2 = -1
            if (r1 != 0) goto L42
            int r1 = r8.f()
            if (r1 != r2) goto L37
            r1 = 1
            goto L38
        L37:
            r1 = 0
        L38:
            boolean r9 = r9.getReverseLayout()
            if (r1 == r9) goto L40
        L3e:
            r9 = 1
            goto L5b
        L40:
            r9 = 0
            goto L5b
        L42:
            int r1 = r8.f()
            if (r1 != r2) goto L4a
            r1 = 1
            goto L4b
        L4a:
            r1 = 0
        L4b:
            boolean r5 = r9.getReverseLayout()
            if (r1 != r5) goto L53
            r1 = 1
            goto L54
        L53:
            r1 = 0
        L54:
            boolean r9 = r9.isDoLayoutRTL()
            if (r1 != r9) goto L40
            goto L3e
        L5b:
            if (r9 == 0) goto L63
            int r9 = r6.d
            int r3 = r9 + (-1)
            r9 = -1
            goto L66
        L63:
            int r2 = r6.d
            r9 = 1
        L66:
            int r8 = r8.f()
            r1 = 0
            if (r8 != r4) goto L81
            r8 = 2147483647(0x7fffffff, float:NaN)
        L70:
            if (r3 == r2) goto L80
            cn.damai.tetris.v2.helper.StaggeredLayoutHelper$b[] r4 = r6.a
            r4 = r4[r3]
            int r5 = r4.j(r7, r0)
            if (r5 >= r8) goto L7e
            r1 = r4
            r8 = r5
        L7e:
            int r3 = r3 + r9
            goto L70
        L80:
            return r1
        L81:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L83:
            if (r3 == r2) goto L93
            cn.damai.tetris.v2.helper.StaggeredLayoutHelper$b[] r4 = r6.a
            r4 = r4[r3]
            int r5 = r4.m(r7, r0)
            if (r5 <= r8) goto L91
            r1 = r4
            r8 = r5
        L91:
            int r3 = r3 + r9
            goto L83
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.v2.helper.StaggeredLayoutHelper.e(int, com.alibaba.android.vlayout.VirtualLayoutManager$d, com.alibaba.android.vlayout.LayoutManagerHelper):cn.damai.tetris.v2.helper.StaggeredLayoutHelper$b");
    }

    private void ensureLanes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934795959")) {
            ipChange.ipc$dispatch("-934795959", new Object[]{this});
            return;
        }
        C2009b[] c2009bArr = this.a;
        if (c2009bArr == null || c2009bArr.length != this.d || m == null) {
            m = new BitSet(this.d);
            this.a = new C2009b[this.d];
            for (int i = 0; i < this.d; i++) {
                this.a[i] = new C2009b(i);
            }
        }
    }

    private void f(RecyclerView.Recycler recycler, VirtualLayoutManager.C3287d c3287d, C2009b c2009b, int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931942851")) {
            ipChange.ipc$dispatch("-931942851", new Object[]{this, recycler, c3287d, c2009b, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (c3287d.f() == -1) {
            recycleFromEnd(recycler, Math.max(i, getMaxStart(c2009b.n(mainOrientationHelper), mainOrientationHelper)) + (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        } else {
            recycleFromStart(recycler, Math.min(i, getMinEnd(c2009b.k(mainOrientationHelper), mainOrientationHelper)) - (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        }
    }

    private int getMaxEnd(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695411243")) {
            return ((Integer) ipChange.ipc$dispatch("-695411243", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int j = this.a[0].j(i, abstractC3291c);
        for (int i2 = 1; i2 < this.d; i2++) {
            int j2 = this.a[i2].j(i, abstractC3291c);
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    private int getMaxStart(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771544594")) {
            return ((Integer) ipChange.ipc$dispatch("-771544594", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int m2 = this.a[0].m(i, abstractC3291c);
        for (int i2 = 1; i2 < this.d; i2++) {
            int m3 = this.a[i2].m(i, abstractC3291c);
            if (m3 > m2) {
                m2 = m3;
            }
        }
        return m2;
    }

    private int getMinEnd(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970113853")) {
            return ((Integer) ipChange.ipc$dispatch("-970113853", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int j = this.a[0].j(i, abstractC3291c);
        for (int i2 = 1; i2 < this.d; i2++) {
            int j2 = this.a[i2].j(i, abstractC3291c);
            if (j2 < j) {
                j = j2;
            }
        }
        return j;
    }

    private int getMinStart(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527219548")) {
            return ((Integer) ipChange.ipc$dispatch("1527219548", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int m2 = this.a[0].m(i, abstractC3291c);
        for (int i2 = 1; i2 < this.d; i2++) {
            int m3 = this.a[i2].m(i, abstractC3291c);
            if (m3 < m2) {
                m2 = m3;
            }
        }
        return m2;
    }

    private void h(C2009b c2009b, int i, int i2, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199102168")) {
            ipChange.ipc$dispatch("-199102168", new Object[]{this, c2009b, Integer.valueOf(i), Integer.valueOf(i2), abstractC3291c});
            return;
        }
        int i3 = c2009b.i();
        if (i == -1) {
            if (c2009b.n(abstractC3291c) + i3 < i2) {
                m.set(c2009b.a, false);
            }
        } else if (c2009b.k(abstractC3291c) - i3 > i2) {
            m.set(c2009b.a, false);
        }
    }

    private View hasGapsToFix(VirtualLayoutManager virtualLayoutManager, int i, int i2) {
        C2009b[] c2009bArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324202782")) {
            return (View) ipChange.ipc$dispatch("324202782", new Object[]{this, virtualLayoutManager, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (virtualLayoutManager.findViewByPosition(i) == null) {
            return null;
        }
        new BitSet(this.d).set(0, this.d, true);
        for (C2009b c2009b : this.a) {
            if (c2009b.g.size() != 0 && c(c2009b, virtualLayoutManager, i2)) {
                return (View) (virtualLayoutManager.getReverseLayout() ? c2009b.g.get(c2009b.g.size() - 1) : c2009b.g.get(0));
            }
        }
        return null;
    }

    private void recycleForPreLayout(RecyclerView.Recycler recycler, VirtualLayoutManager.C3287d c3287d, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91513592")) {
            ipChange.ipc$dispatch("91513592", new Object[]{this, recycler, c3287d, layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int size = this.j.size() - 1; size >= 0; size--) {
            View view = this.j.get(size);
            if (view != null && mainOrientationHelper.g(view) > mainOrientationHelper.i()) {
                C2009b d = d(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), view, false);
                if (d != null) {
                    d.q(mainOrientationHelper);
                    layoutManagerHelper.removeChildView(view);
                    recycler.recycleView(view);
                }
            } else {
                C2009b d2 = d(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), view, false);
                if (d2 != null) {
                    d2.q(mainOrientationHelper);
                    layoutManagerHelper.removeChildView(view);
                    recycler.recycleView(view);
                    return;
                }
                return;
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333510067")) {
            ipChange.ipc$dispatch("-1333510067", new Object[]{this, recycler, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int childCount = layoutManagerHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = layoutManagerHelper.getChildAt(childCount);
            if (childAt == null || mainOrientationHelper.g(childAt) <= i) {
                return;
            }
            C2009b d = d(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, false);
            if (d != null) {
                d.q(mainOrientationHelper);
                layoutManagerHelper.removeChildView(childAt);
                recycler.recycleView(childAt);
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i, LayoutManagerHelper layoutManagerHelper) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1452396710")) {
            ipChange.ipc$dispatch("1452396710", new Object[]{this, recycler, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        boolean z = true;
        while (layoutManagerHelper.getChildCount() > 0 && z && (childAt = layoutManagerHelper.getChildAt(0)) != null && mainOrientationHelper.d(childAt) < i) {
            C2009b d = d(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, true);
            if (d != null) {
                d.r(mainOrientationHelper);
                layoutManagerHelper.removeChildView(childAt);
                recycler.recycleView(childAt);
            } else {
                z = false;
            }
        }
    }

    private void updateAllRemainingSpans(int i, int i2, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704660665")) {
            ipChange.ipc$dispatch("704660665", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), abstractC3291c});
            return;
        }
        for (int i3 = 0; i3 < this.d; i3++) {
            if (!this.a[i3].g.isEmpty()) {
                h(this.a[i3], i, i2, abstractC3291c);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707002789")) {
            ipChange.ipc$dispatch("707002789", new Object[]{this, recycler, state, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper});
            return;
        }
        super.afterLayout(recycler, state, i, i2, i3, layoutManagerHelper);
        if (i > getRange().e().intValue() || i2 < getRange().d().intValue() || state.isPreLayout() || layoutManagerHelper.getChildCount() <= 0) {
            return;
        }
        ViewCompat.postOnAnimation(layoutManagerHelper.getChildAt(0), this.c);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        int contentHeight;
        int verticalPadding;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-226842309")) {
            ipChange.ipc$dispatch("-226842309", new Object[]{this, recycler, state, layoutManagerHelper});
            return;
        }
        super.beforeLayout(recycler, state, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 1) {
            contentHeight = (((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin()) - getHorizontalPadding();
            verticalPadding = this.l * 2;
        } else {
            contentHeight = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin();
            verticalPadding = getVerticalPadding();
        }
        int i = contentHeight - verticalPadding;
        int i2 = this.e;
        int i3 = this.d;
        int i4 = (int) (((i - (i2 * (i3 - 1))) / i3) + 0.5d);
        this.g = i4;
        int i5 = i - (i4 * i3);
        if (i3 <= 1) {
            this.i = 0;
            this.h = 0;
        } else if (i3 == 2) {
            this.h = i5;
            this.i = i5;
        } else {
            int i6 = layoutManagerHelper.getOrientation() == 1 ? this.e : this.f;
            this.i = i6;
            this.h = i6;
        }
        WeakReference<VirtualLayoutManager> weakReference = this.k;
        if ((weakReference == null || weakReference.get() == null || this.k.get() != layoutManagerHelper) && (layoutManagerHelper instanceof VirtualLayoutManager)) {
            this.k = new WeakReference<>(layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.C3286c c3286c, LayoutManagerHelper layoutManagerHelper) {
        C2009b[] c2009bArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386520158")) {
            ipChange.ipc$dispatch("-386520158", new Object[]{this, state, c3286c, layoutManagerHelper});
            return;
        }
        super.checkAnchorInfo(state, c3286c, layoutManagerHelper);
        ensureLanes();
        py1<Integer> range = getRange();
        if (c3286c.c) {
            if (c3286c.a < (range.d().intValue() + this.d) - 1) {
                c3286c.a = Math.min((range.d().intValue() + this.d) - 1, range.e().intValue());
            }
        } else if (c3286c.a > range.e().intValue() - (this.d - 1)) {
            c3286c.a = Math.max(range.d().intValue(), range.e().intValue() - (this.d - 1));
        }
        View findViewByPosition = layoutManagerHelper.findViewByPosition(c3286c.a);
        int i = layoutManagerHelper.getOrientation() == 1 ? this.f : this.e;
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (findViewByPosition != null) {
            int i2 = Integer.MIN_VALUE;
            int i3 = c3286c.c ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (C2009b c2009b : this.a) {
                if (!c2009b.g.isEmpty()) {
                    if (c3286c.c) {
                        i3 = Math.max(i3, layoutManagerHelper.getPosition((View) c2009b.g.get(c2009b.g.size() - 1)));
                    } else {
                        i3 = Math.min(i3, layoutManagerHelper.getPosition((View) c2009b.g.get(0)));
                    }
                }
            }
            if (!isOutOfRange(i3)) {
                boolean z = i3 == range.d().intValue();
                View findViewByPosition2 = layoutManagerHelper.findViewByPosition(i3);
                if (findViewByPosition2 != null) {
                    if (c3286c.c) {
                        c3286c.a = i3;
                        int d = mainOrientationHelper.d(findViewByPosition);
                        int i4 = c3286c.b;
                        if (d < i4) {
                            int i5 = i4 - d;
                            if (z) {
                                i = 0;
                            }
                            i2 = i5 + i;
                            c3286c.b = mainOrientationHelper.d(findViewByPosition2) + i2;
                        } else {
                            if (z) {
                                i = 0;
                            }
                            c3286c.b = mainOrientationHelper.d(findViewByPosition2) + i;
                            i2 = i;
                        }
                    } else {
                        c3286c.a = i3;
                        int g = mainOrientationHelper.g(findViewByPosition);
                        int i6 = c3286c.b;
                        if (g > i6) {
                            int i7 = i6 - g;
                            if (z) {
                                i = 0;
                            }
                            i2 = i7 - i;
                            c3286c.b = mainOrientationHelper.g(findViewByPosition2) + i2;
                        } else {
                            if (z) {
                                i = 0;
                            }
                            i2 = -i;
                            c3286c.b = mainOrientationHelper.g(findViewByPosition2) + i2;
                        }
                    }
                }
            }
            for (C2009b c2009b2 : this.a) {
                c2009b2.c(layoutManagerHelper.getReverseLayout() ^ c3286c.c, i2, mainOrientationHelper);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractC3303d, com.alibaba.android.vlayout.AbstractC3289a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1884075655")) {
            return ((Integer) ipChange.ipc$dispatch("1884075655", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), layoutManagerHelper})).intValue();
        }
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        View findViewByPosition = layoutManagerHelper.findViewByPosition(getRange().d().intValue() + i);
        if (findViewByPosition == null) {
            return 0;
        }
        ensureLanes();
        if (z3) {
            if (z) {
                if (i == getItemCount() - 1) {
                    return this.mMarginBottom + this.mPaddingBottom + (getMaxEnd(mainOrientationHelper.d(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.d(findViewByPosition));
                }
                if (!z2) {
                    return getMinEnd(mainOrientationHelper.g(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.d(findViewByPosition);
                }
            } else if (i == 0) {
                return ((-this.mMarginTop) - this.mPaddingTop) - (mainOrientationHelper.g(findViewByPosition) - getMinStart(mainOrientationHelper.g(findViewByPosition), mainOrientationHelper));
            } else {
                if (!z2) {
                    return getMaxStart(mainOrientationHelper.d(findViewByPosition), mainOrientationHelper) - mainOrientationHelper.g(findViewByPosition);
                }
            }
        }
        return 0;
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965513007")) {
            ipChange.ipc$dispatch("-965513007", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.l = i;
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public boolean isRecyclable(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper, boolean z) {
        View findViewByPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654731943")) {
            return ((Boolean) ipChange.ipc$dispatch("-654731943", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper, Boolean.valueOf(z)})).booleanValue();
        }
        boolean isRecyclable = super.isRecyclable(i, i2, i3, layoutManagerHelper, z);
        if (isRecyclable && (findViewByPosition = layoutManagerHelper.findViewByPosition(i)) != null) {
            AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            int viewPosition = ((RecyclerView.LayoutParams) findViewByPosition.getLayoutParams()).getViewPosition();
            if (layoutManagerHelper.getReverseLayout()) {
                if (z) {
                    C2009b d = d(viewPosition, findViewByPosition, true);
                    if (d != null) {
                        d.q(mainOrientationHelper);
                    }
                } else {
                    C2009b d2 = d(viewPosition, findViewByPosition, false);
                    if (d2 != null) {
                        d2.r(mainOrientationHelper);
                    }
                }
            } else if (z) {
                C2009b d3 = d(viewPosition, findViewByPosition, true);
                if (d3 != null) {
                    d3.r(mainOrientationHelper);
                }
            } else {
                C2009b d4 = d(viewPosition, findViewByPosition, false);
                if (d4 != null) {
                    d4.q(mainOrientationHelper);
                }
            }
        }
        return isRecyclable;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.C3287d c3287d, m81 m81Var, LayoutManagerHelper layoutManagerHelper) {
        int g;
        int d;
        VirtualLayoutManager.C3287d c3287d2;
        int i;
        int i2;
        int i3;
        int i4;
        C2009b[] c2009bArr;
        C2009b[] c2009bArr2;
        View view;
        int i5;
        C2009b c2009b;
        int childMeasureSpec;
        boolean z;
        int m2;
        int i6;
        int e;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        boolean z3;
        C2009b c2009b2;
        AbstractC3291c abstractC3291c;
        int i13;
        int childMeasureSpec2;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        VirtualLayoutManager.C3287d c3287d3 = c3287d;
        m81 m81Var2 = m81Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035021225")) {
            ipChange.ipc$dispatch("2035021225", new Object[]{this, recycler2, state2, c3287d3, m81Var2, layoutManagerHelper});
        } else if (!isOutOfRange(c3287d.c())) {
            ensureLanes();
            boolean z4 = layoutManagerHelper.getOrientation() == 1;
            AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            AbstractC3291c secondaryOrientationHelper = layoutManagerHelper.getSecondaryOrientationHelper();
            boolean isEnableMarginOverLap = layoutManagerHelper.isEnableMarginOverLap();
            m.set(0, this.d, true);
            if (c3287d.f() == 1) {
                g = c3287d.g() + c3287d.b();
                d = c3287d.d() + g + mainOrientationHelper.j();
            } else {
                g = c3287d.g() - c3287d.b();
                d = (g - c3287d.d()) - mainOrientationHelper.k();
            }
            int i14 = g;
            int i15 = d;
            updateAllRemainingSpans(c3287d.f(), i15, mainOrientationHelper);
            int g2 = c3287d.g();
            this.j.clear();
            while (c3287d3.h(state2) && !m.isEmpty() && !isOutOfRange(c3287d.c())) {
                try {
                    view = c3287d3.l(recycler2);
                } catch (Exception e2) {
                    Log.e("Tetris.StaggeredLayoutHelper.layoutViews", e2.getMessage());
                    e2.printStackTrace();
                    view = null;
                }
                if (view == null) {
                    break;
                }
                VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) view.getLayoutParams();
                int viewPosition = layoutParams.getViewPosition();
                int b = this.b.b(viewPosition);
                if (b == Integer.MIN_VALUE) {
                    c2009b = e(g2, c3287d3, layoutManagerHelper);
                    i5 = i15;
                    this.b.c(viewPosition, c2009b);
                } else {
                    i5 = i15;
                    c2009b = this.a[b];
                }
                C2009b c2009b3 = c2009b;
                boolean z5 = viewPosition - getRange().d().intValue() < this.d;
                boolean z6 = getRange().e().intValue() - viewPosition < this.d;
                if (c3287d.j()) {
                    this.j.add(view);
                }
                layoutManagerHelper.addChildView(c3287d3, view);
                if (z4) {
                    layoutManagerHelper.measureChildWithMargins(view, layoutManagerHelper.getChildMeasureSpec(this.g, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), layoutManagerHelper.getChildMeasureSpec(mainOrientationHelper.l(), Float.isNaN(layoutParams.a) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : (int) ((View.MeasureSpec.getSize(childMeasureSpec2) / layoutParams.a) + 0.5f), true));
                    z = true;
                } else {
                    z = true;
                    layoutManagerHelper.measureChildWithMargins(view, layoutManagerHelper.getChildMeasureSpec(mainOrientationHelper.l(), Float.isNaN(layoutParams.a) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : (int) ((View.MeasureSpec.getSize(childMeasureSpec) * layoutParams.a) + 0.5f), true), layoutManagerHelper.getChildMeasureSpec(this.g, ((ViewGroup.MarginLayoutParams) layoutParams).height, false));
                }
                if (c3287d.f() == z) {
                    int j = c2009b3.j(g2, mainOrientationHelper);
                    if (z5) {
                        i13 = computeStartSpace(layoutManagerHelper, z4, z, isEnableMarginOverLap);
                    } else {
                        i13 = z4 ? this.f : this.e;
                    }
                    int i16 = j + i13;
                    i7 = mainOrientationHelper.e(view) + i16;
                    e = i16;
                } else {
                    if (z6) {
                        m2 = c2009b3.m(g2, mainOrientationHelper);
                        i6 = (z4 ? this.mMarginBottom : this.mMarginRight) + this.mPaddingRight;
                    } else {
                        m2 = c2009b3.m(g2, mainOrientationHelper);
                        i6 = z4 ? this.f : this.e;
                    }
                    int i17 = m2 - i6;
                    e = i17 - mainOrientationHelper.e(view);
                    i7 = i17;
                }
                if (c3287d.f() == 1) {
                    c2009b3.b(view, mainOrientationHelper);
                } else {
                    c2009b3.s(view, mainOrientationHelper);
                }
                int i18 = c2009b3.a;
                if (i18 == this.d - 1) {
                    int i19 = this.g;
                    int i20 = this.h;
                    i8 = ((i18 * (i19 + i20)) - i20) + this.i;
                } else {
                    i8 = i18 * (this.g + this.h);
                }
                int k = i8 + secondaryOrientationHelper.k();
                if (z4) {
                    i9 = this.mMarginLeft;
                    i10 = this.mPaddingLeft;
                } else {
                    i9 = this.mMarginTop;
                    i10 = this.mPaddingTop;
                }
                int i21 = k + i9 + i10;
                int f = i21 + mainOrientationHelper.f(view);
                if (z4) {
                    int i22 = this.l;
                    int i23 = i21 + i22;
                    int i24 = f + i22;
                    Log.d("layoutChildWithMargin", " position: " + viewPosition + " , spanIndex: " + b + " ,isStartLine : " + z5 + " , [ " + i23 + "," + e + "," + i24 + "," + i7 + jn1.ARRAY_END_STR);
                    i11 = g2;
                    i12 = i5;
                    z3 = isEnableMarginOverLap;
                    z2 = z4;
                    layoutChildWithMargin(view, i23, e, i24, i7, layoutManagerHelper);
                    abstractC3291c = mainOrientationHelper;
                    c2009b2 = c2009b3;
                } else {
                    i11 = g2;
                    z2 = z4;
                    i12 = i5;
                    z3 = isEnableMarginOverLap;
                    int i25 = e;
                    int i26 = i7;
                    c2009b2 = c2009b3;
                    abstractC3291c = mainOrientationHelper;
                    layoutChildWithMargin(view, i25, i21, i26, f, layoutManagerHelper);
                }
                h(c2009b2, c3287d.f(), i12, abstractC3291c);
                f(recycler, c3287d, c2009b2, i14, layoutManagerHelper);
                handleStateOnResult(m81Var, view);
                recycler2 = recycler;
                c3287d3 = c3287d;
                m81Var2 = m81Var;
                mainOrientationHelper = abstractC3291c;
                g2 = i11;
                i15 = i12;
                isEnableMarginOverLap = z3;
                z4 = z2;
                state2 = state;
            }
            AbstractC3291c abstractC3291c2 = mainOrientationHelper;
            boolean z7 = z4;
            m81 m81Var3 = m81Var2;
            if (isOutOfRange(c3287d.c())) {
                if (c3287d.f() == -1) {
                    for (C2009b c2009b4 : this.a) {
                        int i27 = c2009b4.b;
                        if (i27 != Integer.MIN_VALUE) {
                            c2009b4.e = i27;
                        }
                    }
                } else {
                    for (C2009b c2009b5 : this.a) {
                        int i28 = c2009b5.c;
                        if (i28 != Integer.MIN_VALUE) {
                            c2009b5.f = i28;
                        }
                    }
                }
            }
            if (c3287d.f() == -1) {
                if (isOutOfRange(c3287d.c())) {
                    c3287d2 = c3287d;
                } else {
                    c3287d2 = c3287d;
                    if (c3287d2.h(state)) {
                        m81Var3.a = c3287d.g() - getMaxStart(abstractC3291c2.k(), abstractC3291c2);
                    }
                }
                int g3 = c3287d.g() - getMinStart(abstractC3291c2.i(), abstractC3291c2);
                if (z7) {
                    i3 = this.mMarginTop;
                    i4 = this.mPaddingTop;
                } else {
                    i3 = this.mMarginLeft;
                    i4 = this.mPaddingLeft;
                }
                m81Var3.a = g3 + i3 + i4;
            } else {
                c3287d2 = c3287d;
                if (!isOutOfRange(c3287d.c()) && c3287d2.h(state)) {
                    m81Var3.a = getMinEnd(abstractC3291c2.i(), abstractC3291c2) - c3287d.g();
                } else {
                    int maxEnd = getMaxEnd(abstractC3291c2.i(), abstractC3291c2) - c3287d.g();
                    if (z7) {
                        i = this.mMarginBottom;
                        i2 = this.mPaddingBottom;
                    } else {
                        i = this.mMarginRight;
                        i2 = this.mPaddingRight;
                    }
                    m81Var3.a = maxEnd + i + i2;
                }
            }
            recycleForPreLayout(recycler, c3287d2, layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985033084")) {
            ipChange.ipc$dispatch("985033084", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onClear(layoutManagerHelper);
        this.k = null;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213291589")) {
            ipChange.ipc$dispatch("-213291589", new Object[]{this, layoutManagerHelper});
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onOffsetChildrenHorizontal(int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356701792")) {
            ipChange.ipc$dispatch("1356701792", new Object[]{this, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenHorizontal(i, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 0) {
            for (C2009b c2009b : this.a) {
                c2009b.p(i);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onOffsetChildrenVertical(int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1074704178")) {
            ipChange.ipc$dispatch("-1074704178", new Object[]{this, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenVertical(i, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 1) {
            for (C2009b c2009b : this.a) {
                c2009b.p(i);
            }
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onRefreshLayout(RecyclerView.State state, VirtualLayoutManager.C3286c c3286c, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961031655")) {
            ipChange.ipc$dispatch("1961031655", new Object[]{this, state, c3286c, layoutManagerHelper});
            return;
        }
        super.onRefreshLayout(state, c3286c, layoutManagerHelper);
        ensureLanes();
        if (isOutOfRange(c3286c.a)) {
            for (C2009b c2009b : this.a) {
                c2009b.f();
            }
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "721024297")) {
            ipChange.ipc$dispatch("721024297", new Object[]{this, bundle});
            return;
        }
        super.onRestoreInstanceState(bundle);
        this.b.a = bundle.getIntArray("StaggeredLayoutHelper_LazySpanLookup");
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onSaveState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744058743")) {
            ipChange.ipc$dispatch("744058743", new Object[]{this, bundle});
            return;
        }
        super.onSaveState(bundle);
        bundle.putIntArray("StaggeredLayoutHelper_LazySpanLookup", this.b.a);
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onScrollStateChanged(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589483750")) {
            ipChange.ipc$dispatch("589483750", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper});
        } else if (i2 > getRange().e().intValue() || i3 < getRange().d().intValue() || i != 0) {
        } else {
            checkForGaps();
        }
    }

    public void setGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487904415")) {
            ipChange.ipc$dispatch("1487904415", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setHGap(i);
        setVGap(i);
    }

    public void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340949695")) {
            ipChange.ipc$dispatch("-1340949695", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.e = i;
        }
    }

    public void setLane(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997363489")) {
            ipChange.ipc$dispatch("-997363489", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
        ensureLanes();
    }

    public void setVGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583558515")) {
            ipChange.ipc$dispatch("1583558515", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.f = i;
        }
    }

    public StaggeredLayoutHelper(int i) {
        this(i, 0);
    }

    public StaggeredLayoutHelper(int i, int i2) {
        this.b = new C2008a(this);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new ArrayList();
        this.k = null;
        this.c = new Runnable() { // from class: cn.damai.tetris.v2.helper.StaggeredLayoutHelper.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1884570810")) {
                    ipChange.ipc$dispatch("1884570810", new Object[]{this});
                } else {
                    StaggeredLayoutHelper.this.checkForGaps();
                }
            }
        };
        setLane(i);
        setGap(i2);
    }
}
