package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.google.android.flexbox.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, FlexContainer {
    private static final Rect A = new Rect();
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private List<com.google.android.flexbox.a> h;
    private final com.google.android.flexbox.b i;
    private RecyclerView.Recycler j;
    private RecyclerView.State k;
    private c l;
    private b m;
    private OrientationHelper n;
    private OrientationHelper o;
    private SavedState p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private SparseArray<View> v;
    private final Context w;
    private View x;
    private int y;
    private b.C0223b z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b {
        private int a;
        private int b;
        private int c;
        private int d;
        private boolean e;
        private boolean f;
        private boolean g;

        private b() {
            this.d = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.f) {
                this.c = this.e ? FlexboxLayoutManager.this.n.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.n.getStartAfterPadding();
            } else {
                this.c = this.e ? FlexboxLayoutManager.this.n.getEndAfterPadding() : FlexboxLayoutManager.this.n.getStartAfterPadding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(View view) {
            if (!FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() && FlexboxLayoutManager.this.f) {
                if (this.e) {
                    this.c = FlexboxLayoutManager.this.n.getDecoratedStart(view) + FlexboxLayoutManager.this.n.getTotalSpaceChange();
                } else {
                    this.c = FlexboxLayoutManager.this.n.getDecoratedEnd(view);
                }
            } else if (this.e) {
                this.c = FlexboxLayoutManager.this.n.getDecoratedEnd(view) + FlexboxLayoutManager.this.n.getTotalSpaceChange();
            } else {
                this.c = FlexboxLayoutManager.this.n.getDecoratedStart(view);
            }
            this.a = FlexboxLayoutManager.this.getPosition(view);
            this.g = false;
            int[] iArr = FlexboxLayoutManager.this.i.c;
            int i = this.a;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.b = i2 != -1 ? i2 : 0;
            if (FlexboxLayoutManager.this.h.size() > this.b) {
                this.a = ((com.google.android.flexbox.a) FlexboxLayoutManager.this.h.get(this.b)).o;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s() {
            this.a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.f = false;
            this.g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.b == 0) {
                    this.e = FlexboxLayoutManager.this.a == 1;
                } else {
                    this.e = FlexboxLayoutManager.this.b == 2;
                }
            } else if (FlexboxLayoutManager.this.b == 0) {
                this.e = FlexboxLayoutManager.this.a == 3;
            } else {
                this.e = FlexboxLayoutManager.this.b == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.d + ", mLayoutFromEnd=" + this.e + ", mValid=" + this.f + ", mAssignedFromSavedState=" + this.g + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c {
        private int a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private boolean j;

        private c() {
            this.h = 1;
            this.i = 1;
        }

        static /* synthetic */ int i(c cVar) {
            int i = cVar.c;
            cVar.c = i + 1;
            return i;
        }

        static /* synthetic */ int j(c cVar) {
            int i = cVar.c;
            cVar.c = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean w(RecyclerView.State state, List<com.google.android.flexbox.a> list) {
            int i;
            int i2 = this.d;
            return i2 >= 0 && i2 < state.getItemCount() && (i = this.c) >= 0 && i < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.a + ", mFlexLinePosition=" + this.c + ", mPosition=" + this.d + ", mOffset=" + this.e + ", mScrollingOffset=" + this.f + ", mLastScrollDelta=" + this.g + ", mItemDirection=" + this.h + ", mLayoutDirection=" + this.i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private int A(com.google.android.flexbox.a aVar, c cVar) {
        if (isMainAxisDirectionHorizontal()) {
            return B(aVar, cVar);
        }
        return C(aVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int B(com.google.android.flexbox.a r22, com.google.android.flexbox.FlexboxLayoutManager.c r23) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.B(com.google.android.flexbox.a, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int C(com.google.android.flexbox.a r26, com.google.android.flexbox.FlexboxLayoutManager.c r27) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.C(com.google.android.flexbox.a, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    private void D(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.j) {
            if (cVar.i == -1) {
                E(recycler, cVar);
            } else {
                F(recycler, cVar);
            }
        }
    }

    private void E(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.f < 0) {
            return;
        }
        this.n.getEnd();
        int unused = cVar.f;
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        int i = childCount - 1;
        int i2 = this.i.c[getPosition(getChildAt(i))];
        if (i2 == -1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.h.get(i2);
        int i3 = i;
        while (true) {
            if (i3 < 0) {
                break;
            }
            View childAt = getChildAt(i3);
            if (!g(childAt, cVar.f)) {
                break;
            }
            if (aVar.o == getPosition(childAt)) {
                if (i2 <= 0) {
                    childCount = i3;
                    break;
                }
                i2 += cVar.i;
                aVar = this.h.get(i2);
                childCount = i3;
            }
            i3--;
        }
        recycleChildren(recycler, childCount, i);
    }

    private void F(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        if (cVar.f >= 0 && (childCount = getChildCount()) != 0) {
            int i = this.i.c[getPosition(getChildAt(0))];
            int i2 = -1;
            if (i == -1) {
                return;
            }
            com.google.android.flexbox.a aVar = this.h.get(i);
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                if (!h(childAt, cVar.f)) {
                    break;
                }
                if (aVar.p == getPosition(childAt)) {
                    if (i >= this.h.size() - 1) {
                        i2 = i3;
                        break;
                    }
                    i += cVar.i;
                    aVar = this.h.get(i);
                    i2 = i3;
                }
                i3++;
            }
            recycleChildren(recycler, 0, i2);
        }
    }

    private void G() {
        int widthMode;
        if (isMainAxisDirectionHorizontal()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.l.b = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void H() {
        int layoutDirection = getLayoutDirection();
        int i = this.a;
        if (i == 0) {
            this.f = layoutDirection == 1;
            this.g = this.b == 2;
        } else if (i == 1) {
            this.f = layoutDirection != 1;
            this.g = this.b == 2;
        } else if (i == 2) {
            boolean z = layoutDirection == 1;
            this.f = z;
            if (this.b == 2) {
                this.f = !z;
            }
            this.g = false;
        } else if (i != 3) {
            this.f = false;
            this.g = false;
        } else {
            boolean z2 = layoutDirection == 1;
            this.f = z2;
            if (this.b == 2) {
                this.f = !z2;
            }
            this.g = true;
        }
    }

    private boolean I(RecyclerView.State state, b bVar) {
        View l;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (bVar.e) {
            l = n(state.getItemCount());
        } else {
            l = l(state.getItemCount());
        }
        if (l != null) {
            bVar.r(l);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if ((this.n.getDecoratedStart(l) >= this.n.getEndAfterPadding() || this.n.getDecoratedEnd(l) < this.n.getStartAfterPadding()) ? true : true) {
                    if (bVar.e) {
                        startAfterPadding = this.n.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.n.getStartAfterPadding();
                    }
                    bVar.c = startAfterPadding;
                }
            }
            return true;
        }
        return false;
    }

    private boolean J(RecyclerView.State state, b bVar, SavedState savedState) {
        int i;
        int decoratedStart;
        if (!state.isPreLayout() && (i = this.q) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                bVar.a = this.q;
                bVar.b = this.i.c[bVar.a];
                SavedState savedState2 = this.p;
                if (savedState2 != null && savedState2.hasValidAnchor(state.getItemCount())) {
                    bVar.c = this.n.getStartAfterPadding() + savedState.mAnchorOffset;
                    bVar.g = true;
                    bVar.b = -1;
                    return true;
                } else if (this.r == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.q);
                    if (findViewByPosition != null) {
                        if (this.n.getDecoratedMeasurement(findViewByPosition) > this.n.getTotalSpace()) {
                            bVar.q();
                            return true;
                        } else if (this.n.getDecoratedStart(findViewByPosition) - this.n.getStartAfterPadding() < 0) {
                            bVar.c = this.n.getStartAfterPadding();
                            bVar.e = false;
                            return true;
                        } else if (this.n.getEndAfterPadding() - this.n.getDecoratedEnd(findViewByPosition) < 0) {
                            bVar.c = this.n.getEndAfterPadding();
                            bVar.e = true;
                            return true;
                        } else {
                            if (bVar.e) {
                                decoratedStart = this.n.getDecoratedEnd(findViewByPosition) + this.n.getTotalSpaceChange();
                            } else {
                                decoratedStart = this.n.getDecoratedStart(findViewByPosition);
                            }
                            bVar.c = decoratedStart;
                        }
                    } else {
                        if (getChildCount() > 0) {
                            bVar.e = this.q < getPosition(getChildAt(0));
                        }
                        bVar.q();
                    }
                    return true;
                } else {
                    if (isMainAxisDirectionHorizontal() || !this.f) {
                        bVar.c = this.n.getStartAfterPadding() + this.r;
                    } else {
                        bVar.c = this.r - this.n.getEndPadding();
                    }
                    return true;
                }
            }
            this.q = -1;
            this.r = Integer.MIN_VALUE;
        }
        return false;
    }

    private void K(RecyclerView.State state, b bVar) {
        if (J(state, bVar, this.p) || I(state, bVar)) {
            return;
        }
        bVar.q();
        bVar.a = 0;
        bVar.b = 0;
    }

    private void L(int i) {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        if (i >= findLastVisibleItemPosition) {
            return;
        }
        int childCount = getChildCount();
        this.i.t(childCount);
        this.i.u(childCount);
        this.i.s(childCount);
        if (i >= this.i.c.length) {
            return;
        }
        this.y = i;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        if (findFirstVisibleItemPosition > i || i > findLastVisibleItemPosition) {
            this.q = getPosition(childClosestToStart);
            if (!isMainAxisDirectionHorizontal() && this.f) {
                this.r = this.n.getDecoratedEnd(childClosestToStart) + this.n.getEndPadding();
            } else {
                this.r = this.n.getDecoratedStart(childClosestToStart) - this.n.getStartAfterPadding();
            }
        }
    }

    private void M(int i) {
        int i2;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z = true;
        if (isMainAxisDirectionHorizontal()) {
            int i3 = this.s;
            z = (i3 == Integer.MIN_VALUE || i3 == width) ? false : false;
            i2 = this.l.b ? DisplayMetrics.getheightPixels(this.w.getResources().getDisplayMetrics()) : this.l.a;
        } else {
            int i4 = this.t;
            z = (i4 == Integer.MIN_VALUE || i4 == height) ? false : false;
            if (!this.l.b) {
                i2 = this.l.a;
            } else {
                i2 = DisplayMetrics.getwidthPixels(this.w.getResources().getDisplayMetrics());
            }
        }
        int i5 = i2;
        this.s = width;
        this.t = height;
        int i6 = this.y;
        if (i6 != -1 || (this.q == -1 && !z)) {
            int min = i6 != -1 ? Math.min(i6, this.m.a) : this.m.a;
            this.z.a();
            if (isMainAxisDirectionHorizontal()) {
                if (this.h.size() > 0) {
                    this.i.j(this.h, min);
                    this.i.b(this.z, makeMeasureSpec, makeMeasureSpec2, i5, min, this.m.a, this.h);
                } else {
                    this.i.s(i);
                    this.i.d(this.z, makeMeasureSpec, makeMeasureSpec2, i5, 0, this.h);
                }
            } else if (this.h.size() > 0) {
                this.i.j(this.h, min);
                this.i.b(this.z, makeMeasureSpec2, makeMeasureSpec, i5, min, this.m.a, this.h);
            } else {
                this.i.s(i);
                this.i.g(this.z, makeMeasureSpec, makeMeasureSpec2, i5, 0, this.h);
            }
            this.h = this.z.a;
            this.i.q(makeMeasureSpec, makeMeasureSpec2, min);
            this.i.X(min);
        } else if (this.m.e) {
        } else {
            this.h.clear();
            this.z.a();
            if (isMainAxisDirectionHorizontal()) {
                this.i.e(this.z, makeMeasureSpec, makeMeasureSpec2, i5, this.m.a, this.h);
            } else {
                this.i.h(this.z, makeMeasureSpec, makeMeasureSpec2, i5, this.m.a, this.h);
            }
            this.h = this.z.a;
            this.i.p(makeMeasureSpec, makeMeasureSpec2);
            this.i.W();
            b bVar = this.m;
            bVar.b = this.i.c[bVar.a];
            this.l.c = this.m.b;
        }
    }

    private void N(int i, int i2) {
        this.l.i = i;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !isMainAxisDirectionHorizontal && this.f;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.l.e = this.n.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View o = o(childAt, this.h.get(this.i.c[position]));
            this.l.h = 1;
            c cVar = this.l;
            cVar.d = position + cVar.h;
            if (this.i.c.length <= this.l.d) {
                this.l.c = -1;
            } else {
                c cVar2 = this.l;
                cVar2.c = this.i.c[cVar2.d];
            }
            if (z) {
                this.l.e = this.n.getDecoratedStart(o);
                this.l.f = (-this.n.getDecoratedStart(o)) + this.n.getStartAfterPadding();
                c cVar3 = this.l;
                cVar3.f = cVar3.f >= 0 ? this.l.f : 0;
            } else {
                this.l.e = this.n.getDecoratedEnd(o);
                this.l.f = this.n.getDecoratedEnd(o) - this.n.getEndAfterPadding();
            }
            if ((this.l.c == -1 || this.l.c > this.h.size() - 1) && this.l.d <= getFlexItemCount()) {
                int i3 = i2 - this.l.f;
                this.z.a();
                if (i3 > 0) {
                    if (isMainAxisDirectionHorizontal) {
                        this.i.d(this.z, makeMeasureSpec, makeMeasureSpec2, i3, this.l.d, this.h);
                    } else {
                        this.i.g(this.z, makeMeasureSpec, makeMeasureSpec2, i3, this.l.d, this.h);
                    }
                    this.i.q(makeMeasureSpec, makeMeasureSpec2, this.l.d);
                    this.i.X(this.l.d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.l.e = this.n.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View m = m(childAt2, this.h.get(this.i.c[position2]));
            this.l.h = 1;
            int i4 = this.i.c[position2];
            if (i4 == -1) {
                i4 = 0;
            }
            if (i4 > 0) {
                this.l.d = position2 - this.h.get(i4 - 1).b();
            } else {
                this.l.d = -1;
            }
            this.l.c = i4 > 0 ? i4 - 1 : 0;
            if (z) {
                this.l.e = this.n.getDecoratedEnd(m);
                this.l.f = this.n.getDecoratedEnd(m) - this.n.getEndAfterPadding();
                c cVar4 = this.l;
                cVar4.f = cVar4.f >= 0 ? this.l.f : 0;
            } else {
                this.l.e = this.n.getDecoratedStart(m);
                this.l.f = (-this.n.getDecoratedStart(m)) + this.n.getStartAfterPadding();
            }
        }
        c cVar5 = this.l;
        cVar5.a = i2 - cVar5.f;
    }

    private void O(b bVar, boolean z, boolean z2) {
        if (z2) {
            G();
        } else {
            this.l.b = false;
        }
        if (!isMainAxisDirectionHorizontal() && this.f) {
            this.l.a = bVar.c - getPaddingRight();
        } else {
            this.l.a = this.n.getEndAfterPadding() - bVar.c;
        }
        this.l.d = bVar.a;
        this.l.h = 1;
        this.l.i = 1;
        this.l.e = bVar.c;
        this.l.f = Integer.MIN_VALUE;
        this.l.c = bVar.b;
        if (!z || this.h.size() <= 1 || bVar.b < 0 || bVar.b >= this.h.size() - 1) {
            return;
        }
        c.i(this.l);
        this.l.d += this.h.get(bVar.b).b();
    }

    private void P(b bVar, boolean z, boolean z2) {
        if (z2) {
            G();
        } else {
            this.l.b = false;
        }
        if (!isMainAxisDirectionHorizontal() && this.f) {
            this.l.a = (this.x.getWidth() - bVar.c) - this.n.getStartAfterPadding();
        } else {
            this.l.a = bVar.c - this.n.getStartAfterPadding();
        }
        this.l.d = bVar.a;
        this.l.h = 1;
        this.l.i = -1;
        this.l.e = bVar.c;
        this.l.f = Integer.MIN_VALUE;
        this.l.c = bVar.b;
        if (!z || bVar.b <= 0 || this.h.size() <= bVar.b) {
            return;
        }
        c.j(this.l);
        this.l.d -= this.h.get(bVar.b).b();
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        j();
        View l = l(itemCount);
        View n = n(itemCount);
        if (state.getItemCount() == 0 || l == null || n == null) {
            return 0;
        }
        return Math.min(this.n.getTotalSpace(), this.n.getDecoratedEnd(n) - this.n.getDecoratedStart(l));
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View l = l(itemCount);
        View n = n(itemCount);
        if (state.getItemCount() != 0 && l != null && n != null) {
            int position = getPosition(l);
            int position2 = getPosition(n);
            int abs = Math.abs(this.n.getDecoratedEnd(n) - this.n.getDecoratedStart(l));
            int[] iArr = this.i.c;
            int i = iArr[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (abs / ((iArr[position2] - i) + 1))) + (this.n.getStartAfterPadding() - this.n.getDecoratedStart(l)));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View l = l(itemCount);
        View n = n(itemCount);
        if (state.getItemCount() == 0 || l == null || n == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.n.getDecoratedEnd(n) - this.n.getDecoratedStart(l)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    private void ensureLayoutState() {
        if (this.l == null) {
            this.l = new c();
        }
    }

    private int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.f) {
            int startAfterPadding = i - this.n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i2 = w(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.n.getEndAfterPadding() - i;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -w(-endAfterPadding2, recycler, state);
        }
        int i3 = i + i2;
        if (!z || (endAfterPadding = this.n.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.n.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int startAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.f) {
            int endAfterPadding = this.n.getEndAfterPadding() - i;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i2 = w(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = i - this.n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i2 = -w(startAfterPadding2, recycler, state);
        }
        int i3 = i + i2;
        if (!z || (startAfterPadding = i3 - this.n.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.n.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    private boolean g(View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.f) ? this.n.getDecoratedStart(view) >= this.n.getEnd() - i : this.n.getDecoratedEnd(view) <= i;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private boolean h(View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.f) ? this.n.getDecoratedEnd(view) <= i : this.n.getEnd() - this.n.getDecoratedStart(view) <= i;
    }

    private void i() {
        this.h.clear();
        this.m.s();
        this.m.d = 0;
    }

    private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 <= 0 || i == i3) {
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            } else if (mode != 0) {
                return mode == 1073741824 && size == i;
            } else {
                return true;
            }
        }
        return false;
    }

    private void j() {
        if (this.n != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.b == 0) {
                this.n = OrientationHelper.createHorizontalHelper(this);
                this.o = OrientationHelper.createVerticalHelper(this);
                return;
            }
            this.n = OrientationHelper.createVerticalHelper(this);
            this.o = OrientationHelper.createHorizontalHelper(this);
        } else if (this.b == 0) {
            this.n = OrientationHelper.createVerticalHelper(this);
            this.o = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.n = OrientationHelper.createHorizontalHelper(this);
            this.o = OrientationHelper.createVerticalHelper(this);
        }
    }

    private int k(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f != Integer.MIN_VALUE) {
            if (cVar.a < 0) {
                cVar.f += cVar.a;
            }
            D(recycler, cVar);
        }
        int i = cVar.a;
        int i2 = cVar.a;
        int i3 = 0;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        while (true) {
            if ((i2 > 0 || this.l.b) && cVar.w(state, this.h)) {
                com.google.android.flexbox.a aVar = this.h.get(cVar.c);
                cVar.d = aVar.o;
                i3 += A(aVar, cVar);
                if (isMainAxisDirectionHorizontal || !this.f) {
                    cVar.e += aVar.a() * cVar.i;
                } else {
                    cVar.e -= aVar.a() * cVar.i;
                }
                i2 -= aVar.a();
            }
        }
        cVar.a -= i3;
        if (cVar.f != Integer.MIN_VALUE) {
            cVar.f += i3;
            if (cVar.a < 0) {
                cVar.f += cVar.a;
            }
            D(recycler, cVar);
        }
        return i - cVar.a;
    }

    private View l(int i) {
        View q = q(0, getChildCount(), i);
        if (q == null) {
            return null;
        }
        int i2 = this.i.c[getPosition(q)];
        if (i2 == -1) {
            return null;
        }
        return m(q, this.h.get(i2));
    }

    private View m(View view, com.google.android.flexbox.a aVar) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = aVar.h;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f && !isMainAxisDirectionHorizontal) {
                    if (this.n.getDecoratedEnd(view) >= this.n.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.n.getDecoratedStart(view) <= this.n.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View n(int i) {
        View q = q(getChildCount() - 1, -1, i);
        if (q == null) {
            return null;
        }
        return o(q, this.h.get(this.i.c[getPosition(q)]));
    }

    private View o(View view, com.google.android.flexbox.a aVar) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - aVar.h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f && !isMainAxisDirectionHorizontal) {
                    if (this.n.getDecoratedStart(view) <= this.n.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.n.getDecoratedEnd(view) >= this.n.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View p(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            if (z(childAt, z)) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    private View q(int i, int i2, int i3) {
        j();
        ensureLayoutState();
        int startAfterPadding = this.n.getStartAfterPadding();
        int endAfterPadding = this.n.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.n.getDecoratedStart(childAt) >= startAfterPadding && this.n.getDecoratedEnd(childAt) <= endAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int r(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    private int s(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    private boolean shouldMeasureChild(View view, int i, int i2, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    private int t(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private int u(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    private int w(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        j();
        int i2 = 1;
        this.l.j = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.f;
        if (!z ? i <= 0 : i >= 0) {
            i2 = -1;
        }
        int abs = Math.abs(i);
        N(i2, abs);
        int k = this.l.f + k(recycler, state, this.l);
        if (k < 0) {
            return 0;
        }
        if (z) {
            if (abs > k) {
                i = (-i2) * k;
            }
        } else if (abs > k) {
            i = i2 * k;
        }
        this.n.offsetChildren(-i);
        this.l.g = i;
        return i;
    }

    private int x(int i) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        j();
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.x;
        int width = isMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = isMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i);
            if (i >= 0) {
                if (this.m.d + i <= 0) {
                    return i;
                }
                i2 = this.m.d;
            } else {
                i2 = Math.min((width2 + this.m.d) - width, abs);
            }
        } else if (i <= 0) {
            if (this.m.d + i >= 0) {
                return i;
            }
            i2 = this.m.d;
        } else {
            return Math.min((width2 - this.m.d) - width, i);
        }
        return -i2;
    }

    private boolean z(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int s = s(view);
        int u = u(view);
        int t = t(view);
        int r = r(view);
        return z ? (paddingLeft <= s && width >= t) && (paddingTop <= u && height >= r) : (s >= width || t >= paddingLeft) && (u >= height || r >= paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return !isMainAxisDirectionHorizontal() || getWidth() > this.x.getWidth();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return isMainAxisDirectionHorizontal() || getHeight() > this.x.getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        computeScrollOffset(state);
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        if (isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, i2);
        }
        return new PointF(i2, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int findFirstVisibleItemPosition() {
        View p = p(0, getChildCount(), false);
        if (p == null) {
            return -1;
        }
        return getPosition(p);
    }

    public int findLastVisibleItemPosition() {
        View p = p(getChildCount() - 1, -1, false);
        if (p == null) {
            return -1;
        }
        return getPosition(p);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.d;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int i, int i2) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.a;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int i) {
        View view = this.v.get(i);
        return view != null ? view : this.j.getViewForPosition(i);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return this.k.getItemCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<com.google.android.flexbox.a> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.h.size());
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            com.google.android.flexbox.a aVar = this.h.get(i);
            if (aVar.b() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<com.google.android.flexbox.a> getFlexLinesInternal() {
        return this.h;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.b;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.c;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        if (this.h.size() == 0) {
            return 0;
        }
        int i = Integer.MIN_VALUE;
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.h.get(i2).e);
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.e;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int i) {
        return getFlexItemAt(i);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.h.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.h.get(i2).g;
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.a;
        return i == 0 || i == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.u) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        L(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        L(Math.min(i, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        L(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        L(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        this.j = recycler;
        this.k = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        H();
        j();
        ensureLayoutState();
        this.i.t(itemCount);
        this.i.u(itemCount);
        this.i.s(itemCount);
        this.l.j = false;
        SavedState savedState = this.p;
        if (savedState != null && savedState.hasValidAnchor(itemCount)) {
            this.q = this.p.mAnchorPosition;
        }
        if (!this.m.f || this.q != -1 || this.p != null) {
            this.m.s();
            K(state, this.m);
            this.m.f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.m.e) {
            P(this.m, false, true);
        } else {
            O(this.m, false, true);
        }
        M(itemCount);
        if (this.m.e) {
            k(recycler, state, this.l);
            i2 = this.l.e;
            O(this.m, true, false);
            k(recycler, state, this.l);
            i = this.l.e;
        } else {
            k(recycler, state, this.l);
            i = this.l.e;
            P(this.m, true, false);
            k(recycler, state, this.l);
            i2 = this.l.e;
        }
        if (getChildCount() > 0) {
            if (this.m.e) {
                fixLayoutStartGap(i2 + fixLayoutEndGap(i, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.p = null;
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.y = -1;
        this.m.s();
        this.v.clear();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int i, int i2, com.google.android.flexbox.a aVar) {
        calculateItemDecorationsForChild(view, A);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            aVar.e += leftDecorationWidth;
            aVar.f += leftDecorationWidth;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        aVar.e += topDecorationHeight;
        aVar.f += topDecorationHeight;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(com.google.android.flexbox.a aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.p != null) {
            return new SavedState(this.p);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() <= 0) {
            savedState.invalidateAnchor();
        } else {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.n.getDecoratedStart(childClosestToStart) - this.n.getStartAfterPadding();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal()) {
            int w = w(i, recycler, state);
            this.v.clear();
            return w;
        }
        int x = x(i);
        this.m.d += x;
        this.o.offsetChildren(-x);
        return x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.q = i;
        this.r = Integer.MIN_VALUE;
        SavedState savedState = this.p;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal()) {
            int w = w(i, recycler, state);
            this.v.clear();
            return w;
        }
        int x = x(i);
        this.m.d += x;
        this.o.offsetChildren(-x);
        return x;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int i) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int i) {
        int i2 = this.d;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                removeAllViews();
                i();
            }
            this.d = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int i) {
        if (this.a != i) {
            removeAllViews();
            this.a = i;
            this.n = null;
            this.o = null;
            i();
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<com.google.android.flexbox.a> list) {
        this.h = list;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int i) {
        if (i != 2) {
            int i2 = this.b;
            if (i2 != i) {
                if (i2 == 0 || i == 0) {
                    removeAllViews();
                    i();
                }
                this.b = i;
                this.n = null;
                this.o = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int i) {
        if (this.e != i) {
            this.e = i;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int i, View view) {
        this.v.put(i, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v(int i) {
        return this.i.c[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasValidAnchor(int i) {
            int i2 = this.mAnchorPosition;
            return i2 >= 0 && i2 < i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
    }

    public FlexboxLayoutManager(Context context, int i, int i2) {
        this.e = -1;
        this.h = new ArrayList();
        this.i = new com.google.android.flexbox.b(this);
        this.m = new b();
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.v = new SparseArray<>();
        this.y = -1;
        this.z = new b.C0223b();
        setFlexDirection(i);
        setFlexWrap(i2);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.w = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        L(i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        static class a implements Parcelable.Creator<LayoutParams> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i) {
            this.mAlignSelf = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f) {
            this.mFlexBasisPercent = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f) {
            this.mFlexGrow = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f) {
            this.mFlexShrink = f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i) {
            ((ViewGroup.MarginLayoutParams) this).height = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i) {
            this.mMaxHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i) {
            this.mMaxWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i) {
            this.mMinHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.mMinWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i) {
            ((ViewGroup.MarginLayoutParams) this).width = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.mWrapBefore = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.e = -1;
        this.h = new ArrayList();
        this.i = new com.google.android.flexbox.b(this);
        this.m = new b();
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.v = new SparseArray<>();
        this.y = -1;
        this.z = new b.C0223b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 != 0) {
            if (i3 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.w = context;
    }
}
