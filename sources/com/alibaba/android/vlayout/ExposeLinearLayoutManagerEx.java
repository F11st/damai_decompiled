package com.alibaba.android.vlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import tb.m81;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ExposeLinearLayoutManagerEx extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    static final int FLAG_INVALID = 4;
    static final int FLAG_UPDATED = 2;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final String TAG = "ExposeLLManagerEx";
    public static final int VERTICAL = 1;
    private static Field vhField;
    private static Method vhSetFlags;
    private Object[] emptyArgs;
    private m81 layoutChunkResultCache;
    private final a mAnchorInfo;
    private final b mChildHelperWrapper;
    protected Bundle mCurrentPendingSavedState;
    private int mCurrentPendingScrollPosition;
    private final Method mEnsureLayoutStateMethod;
    private boolean mLastStackFromEnd;
    protected c mLayoutState;
    private com.alibaba.android.vlayout.c mOrientationHelper;
    private int mPendingScrollPositionOffset;
    private RecyclerView mRecyclerView;
    private boolean mShouldReverseLayoutExpose;
    protected int recycleOffset;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a {
        public int a;
        public int b;
        public boolean c;

        protected a() {
        }

        void a() {
            this.b = this.c ? ExposeLinearLayoutManagerEx.this.mOrientationHelper.i() : ExposeLinearLayoutManagerEx.this.mOrientationHelper.k();
        }

        public void b(View view) {
            if (this.c) {
                this.b = ExposeLinearLayoutManagerEx.this.mOrientationHelper.d(view) + ExposeLinearLayoutManagerEx.this.computeAlignOffset(view, this.c, true) + ExposeLinearLayoutManagerEx.this.mOrientationHelper.m();
            } else {
                this.b = ExposeLinearLayoutManagerEx.this.mOrientationHelper.g(view) + ExposeLinearLayoutManagerEx.this.computeAlignOffset(view, this.c, true);
            }
            this.a = ExposeLinearLayoutManagerEx.this.getPosition(view);
        }

        public boolean c(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.isItemRemoved() || layoutParams.getViewPosition() < 0 || layoutParams.getViewPosition() >= state.getItemCount()) {
                return false;
            }
            b(view);
            return true;
        }

        void d() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b {
        private Object a;
        private Method b;
        private Method c;
        private Method d;
        private Method e;
        private Field f;
        private Object g;
        private Method h;
        private Field i;
        private List j;
        private RecyclerView.LayoutManager k;
        private Object[] l = new Object[1];

        b(RecyclerView.LayoutManager layoutManager) {
            this.k = layoutManager;
            try {
                Field declaredField = RecyclerView.LayoutManager.class.getDeclaredField("mChildHelper");
                this.i = declaredField;
                declaredField.setAccessible(true);
                a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void a() {
            try {
                if (this.a == null) {
                    Object obj = this.i.get(this.k);
                    this.a = obj;
                    if (obj == null) {
                        return;
                    }
                    Class<?> cls = obj.getClass();
                    Method declaredMethod = cls.getDeclaredMethod("hide", View.class);
                    this.b = declaredMethod;
                    declaredMethod.setAccessible(true);
                    try {
                        Class<?> cls2 = Integer.TYPE;
                        Method declaredMethod2 = cls.getDeclaredMethod("findHiddenNonRemovedView", cls2, cls2);
                        this.c = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                        Method declaredMethod3 = cls.getDeclaredMethod("findHiddenNonRemovedView", Integer.TYPE);
                        this.d = declaredMethod3;
                        declaredMethod3.setAccessible(true);
                    }
                    Method declaredMethod4 = cls.getDeclaredMethod("isHidden", View.class);
                    this.e = declaredMethod4;
                    declaredMethod4.setAccessible(true);
                    Field declaredField = cls.getDeclaredField("mBucket");
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(this.a);
                    this.g = obj2;
                    Method declaredMethod5 = obj2.getClass().getDeclaredMethod(Constants.TAG_CLEAR_STRING, Integer.TYPE);
                    this.h = declaredMethod5;
                    declaredMethod5.setAccessible(true);
                    Field declaredField2 = cls.getDeclaredField("mHiddenViews");
                    this.f = declaredField2;
                    declaredField2.setAccessible(true);
                    this.j = (List) this.f.get(this.a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        View b(int i, int i2) {
            try {
                a();
                Method method = this.c;
                if (method != null) {
                    return (View) method.invoke(this.a, Integer.valueOf(i), -1);
                }
                Method method2 = this.d;
                if (method2 != null) {
                    return (View) method2.invoke(this.a, Integer.valueOf(i));
                }
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }

        void c(View view) {
            try {
                a();
                if (this.j.indexOf(view) < 0) {
                    Object[] objArr = this.l;
                    objArr[0] = view;
                    this.b.invoke(this.a, objArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        boolean d(View view) {
            try {
                a();
                Object[] objArr = this.l;
                objArr[0] = view;
                return ((Boolean) this.e.invoke(this.a, objArr)).booleanValue();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }

        void e(View view) {
            try {
                a();
                this.l[0] = Integer.valueOf(ExposeLinearLayoutManagerEx.this.mRecyclerView.indexOfChild(view));
                this.h.invoke(this.g, this.l);
                List list = this.j;
                if (list != null) {
                    list.remove(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class c {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_START = -1;
        static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "_ExposeLLayoutManager#LayoutState";
        public int mAvailable;
        public int mCurrentPosition;
        public int mItemDirection;
        public int mLayoutDirection;
        public int mOffset;
        public int mScrollingOffset;
        private Method vhIsRemoved;
        public boolean mOnRefresLayout = false;
        public boolean mRecycle = true;
        public int mExtra = 0;
        public int mFixOffset = 0;
        public boolean mIsPreLayout = false;
        public List<RecyclerView.ViewHolder> mScrapList = null;

        public c() {
            this.vhIsRemoved = null;
            try {
                Method declaredMethod = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", new Class[0]);
                this.vhIsRemoved = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0053 A[EDGE_INSN: B:32:0x0053->B:26:0x0053 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0050 A[ADDED_TO_REGION, SYNTHETIC] */
        @android.annotation.SuppressLint({"LongLogTag"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private android.view.View nextFromLimitedList() {
            /*
                r9 = this;
                java.util.List<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r9.mScrapList
                int r0 = r0.size()
                r1 = 0
                r2 = 0
                r3 = 2147483647(0x7fffffff, float:NaN)
                r5 = r1
                r4 = 0
            Ld:
                if (r4 >= r0) goto L53
                java.util.List<androidx.recyclerview.widget.RecyclerView$ViewHolder> r6 = r9.mScrapList
                java.lang.Object r6 = r6.get(r4)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r6
                boolean r7 = r9.mIsPreLayout
                if (r7 != 0) goto L3b
                java.lang.reflect.Method r7 = r9.vhIsRemoved     // Catch: java.lang.reflect.InvocationTargetException -> L2a java.lang.IllegalAccessException -> L2f
                java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L2a java.lang.IllegalAccessException -> L2f
                java.lang.Object r7 = r7.invoke(r6, r8)     // Catch: java.lang.reflect.InvocationTargetException -> L2a java.lang.IllegalAccessException -> L2f
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.reflect.InvocationTargetException -> L2a java.lang.IllegalAccessException -> L2f
                boolean r7 = r7.booleanValue()     // Catch: java.lang.reflect.InvocationTargetException -> L2a java.lang.IllegalAccessException -> L2f
                goto L34
            L2a:
                r7 = move-exception
                r7.printStackTrace()
                goto L33
            L2f:
                r7 = move-exception
                r7.printStackTrace()
            L33:
                r7 = 0
            L34:
                boolean r8 = r9.mIsPreLayout
                if (r8 != 0) goto L3b
                if (r7 == 0) goto L3b
                goto L50
            L3b:
                int r7 = r6.getPosition()
                int r8 = r9.mCurrentPosition
                int r7 = r7 - r8
                int r8 = r9.mItemDirection
                int r7 = r7 * r8
                if (r7 >= 0) goto L49
                goto L50
            L49:
                if (r7 >= r3) goto L50
                r5 = r6
                if (r7 != 0) goto L4f
                goto L53
            L4f:
                r3 = r7
            L50:
                int r4 = r4 + 1
                goto Ld
            L53:
                if (r5 == 0) goto L61
                int r0 = r5.getPosition()
                int r1 = r9.mItemDirection
                int r0 = r0 + r1
                r9.mCurrentPosition = r0
                android.view.View r0 = r5.itemView
                return r0
            L61:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx.c.nextFromLimitedList():android.view.View");
        }

        public boolean hasMore(RecyclerView.State state) {
            int i = this.mCurrentPosition;
            return i >= 0 && i < state.getItemCount();
        }

        @SuppressLint({"LongLogTag"})
        void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        public View next(RecyclerView.Recycler recycler) {
            if (this.mScrapList != null) {
                return nextFromLimitedList();
            }
            View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return viewForPosition;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class d {
        private static Method b;
        private static Method c;
        private static Method d;
        private static Method e;
        private static Method f;
        private RecyclerView.ViewHolder a;

        static {
            try {
                Method declaredMethod = RecyclerView.ViewHolder.class.getDeclaredMethod("shouldIgnore", new Class[0]);
                b = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = RecyclerView.ViewHolder.class.getDeclaredMethod("isInvalid", new Class[0]);
                c = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", new Class[0]);
                d = declaredMethod3;
                declaredMethod3.setAccessible(true);
                Class cls = Integer.TYPE;
                Method declaredMethod4 = RecyclerView.ViewHolder.class.getDeclaredMethod("setFlags", cls, cls);
                f = declaredMethod4;
                declaredMethod4.setAccessible(true);
                try {
                    e = RecyclerView.ViewHolder.class.getDeclaredMethod("isChanged", new Class[0]);
                } catch (NoSuchMethodException unused) {
                    e = RecyclerView.ViewHolder.class.getDeclaredMethod("isUpdated", new Class[0]);
                }
                e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
        }

        public d(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        public static void e(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            try {
                f.invoke(viewHolder, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }

        boolean a() {
            Method method = e;
            if (method == null) {
                return true;
            }
            try {
                return ((Boolean) method.invoke(this.a, new Object[0])).booleanValue();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return true;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return true;
            }
        }

        boolean b() {
            Method method = c;
            if (method == null) {
                return true;
            }
            try {
                return ((Boolean) method.invoke(this.a, new Object[0])).booleanValue();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return true;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return true;
            }
        }

        boolean c() {
            Method method = d;
            if (method == null) {
                return true;
            }
            try {
                return ((Boolean) method.invoke(this.a, new Object[0])).booleanValue();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return true;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return true;
            }
        }

        public boolean d() {
            return b() || c() || a();
        }
    }

    public ExposeLinearLayoutManagerEx(Context context) {
        this(context, 1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void attachViewHolder(RecyclerView.LayoutParams layoutParams, RecyclerView.ViewHolder viewHolder) {
        try {
            if (vhField == null) {
                vhField = RecyclerView.LayoutParams.class.getDeclaredField("mViewHolder");
            }
            vhField.setAccessible(true);
            vhField.set(layoutParams, viewHolder);
            if (vhSetFlags == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = RecyclerView.ViewHolder.class.getDeclaredMethod("setFlags", cls, cls);
                vhSetFlags = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            vhSetFlags.invoke(viewHolder, 4, 4);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    private int convertFocusDirectionToLayoutDirectionExpose(int i) {
        int orientation = getOrientation();
        if (i != 1) {
            if (i != 2) {
                return i != 17 ? i != 33 ? i != 66 ? (i == 130 && orientation == 1) ? 1 : Integer.MIN_VALUE : orientation == 0 ? 1 : Integer.MIN_VALUE : orientation == 1 ? -1 : Integer.MIN_VALUE : orientation == 0 ? -1 : Integer.MIN_VALUE;
            }
            return 1;
        }
        return -1;
    }

    private View findReferenceChildInternal(int i, int i2, int i3) {
        ensureLayoutStateExpose();
        int k = this.mOrientationHelper.k();
        int i4 = this.mOrientationHelper.i();
        int i5 = i2 > i ? 1 : -1;
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
                } else if (this.mOrientationHelper.g(childAt) < i4 && this.mOrientationHelper.d(childAt) >= k) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    private int fixLayoutEndGapExpose(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i2;
        int i3 = this.mOrientationHelper.i() - i;
        if (i3 > 0) {
            int i4 = -scrollInternalBy(-i3, recycler, state);
            int i5 = i + i4;
            if (!z || (i2 = this.mOrientationHelper.i() - i5) <= 0) {
                return i4;
            }
            this.mOrientationHelper.n(i2);
            return i2 + i4;
        }
        return 0;
    }

    private int fixLayoutStartGapExpose(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int k;
        int k2 = i - this.mOrientationHelper.k();
        if (k2 > 0) {
            int i2 = -scrollInternalBy(k2, recycler, state);
            int i3 = i + i2;
            if (!z || (k = i3 - this.mOrientationHelper.k()) <= 0) {
                return i2;
            }
            this.mOrientationHelper.n(-k);
            return i2 - k;
        }
        return 0;
    }

    private View getChildClosestToEndExpose() {
        return getChildAt(this.mShouldReverseLayoutExpose ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStartExpose() {
        return getChildAt(this.mShouldReverseLayoutExpose ? getChildCount() - 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isViewHolderUpdated(RecyclerView.ViewHolder viewHolder) {
        return new d(viewHolder).d();
    }

    private void layoutForPredictiveAnimationsExpose(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        if (!state.willRunPredictiveAnimations() || getChildCount() == 0 || state.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
        int size = scrapList.size();
        int position = getPosition(getChildAt(0));
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = scrapList.get(i3);
            if (((viewHolder.getPosition() < position) != this.mShouldReverseLayoutExpose ? (char) 65535 : (char) 1) == 65535) {
                i4 += this.mOrientationHelper.e(viewHolder.itemView);
            } else {
                i5 += this.mOrientationHelper.e(viewHolder.itemView);
            }
            i3++;
        }
        this.mLayoutState.mScrapList = scrapList;
        if (i4 > 0) {
            updateLayoutStateToFillStartExpose(getPosition(getChildClosestToStartExpose()), i);
            c cVar = this.mLayoutState;
            cVar.mExtra = i4;
            cVar.mAvailable = 0;
            cVar.mCurrentPosition += this.mShouldReverseLayoutExpose ? 1 : -1;
            cVar.mOnRefresLayout = true;
            fill(recycler, cVar, state, false);
        }
        if (i5 > 0) {
            updateLayoutStateToFillEndExpose(getPosition(getChildClosestToEndExpose()), i2);
            c cVar2 = this.mLayoutState;
            cVar2.mExtra = i5;
            cVar2.mAvailable = 0;
            cVar2.mCurrentPosition += this.mShouldReverseLayoutExpose ? -1 : 1;
            cVar2.mOnRefresLayout = true;
            fill(recycler, cVar2, state, false);
        }
        this.mLayoutState.mScrapList = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private View myFindFirstReferenceChild(int i) {
        return findReferenceChildInternal(0, getChildCount(), i);
    }

    private View myFindLastReferenceChild(int i) {
        return findReferenceChildInternal(getChildCount() - 1, -1, i);
    }

    private View myFindReferenceChildClosestToEnd(RecyclerView.State state) {
        boolean z = this.mShouldReverseLayoutExpose;
        int itemCount = state.getItemCount();
        return z ? myFindFirstReferenceChild(itemCount) : myFindLastReferenceChild(itemCount);
    }

    private View myFindReferenceChildClosestToStart(RecyclerView.State state) {
        boolean z = this.mShouldReverseLayoutExpose;
        int itemCount = state.getItemCount();
        return z ? myFindLastReferenceChild(itemCount) : myFindFirstReferenceChild(itemCount);
    }

    private void myResolveShouldLayoutReverse() {
        if (getOrientation() != 1 && isLayoutRTL()) {
            this.mShouldReverseLayoutExpose = !getReverseLayout();
        } else {
            this.mShouldReverseLayoutExpose = getReverseLayout();
        }
    }

    private void recycleByLayoutStateExpose(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.mRecycle) {
            if (cVar.mLayoutDirection == -1) {
                recycleViewsFromEndExpose(recycler, cVar.mScrollingOffset);
            } else {
                recycleViewsFromStartExpose(recycler, cVar.mScrollingOffset);
            }
        }
    }

    private void recycleViewsFromEndExpose(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int h = this.mOrientationHelper.h() - i;
        if (this.mShouldReverseLayoutExpose) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.mOrientationHelper.g(getChildAt(i2)) - this.recycleOffset < h) {
                    recycleChildren(recycler, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = childCount - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            if (this.mOrientationHelper.g(getChildAt(i4)) - this.recycleOffset < h) {
                recycleChildren(recycler, i3, i4);
                return;
            }
        }
    }

    private void recycleViewsFromStartExpose(RecyclerView.Recycler recycler, int i) {
        if (i < 0) {
            return;
        }
        int childCount = getChildCount();
        if (!this.mShouldReverseLayoutExpose) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.mOrientationHelper.d(getChildAt(i2)) + this.recycleOffset > i) {
                    recycleChildren(recycler, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = childCount - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            if (this.mOrientationHelper.d(getChildAt(i4)) + this.recycleOffset > i) {
                recycleChildren(recycler, i3, i4);
                return;
            }
        }
    }

    private boolean updateAnchorFromChildrenExpose(RecyclerView.State state, a aVar) {
        View myFindReferenceChildClosestToStart;
        int k;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild == null || !aVar.c(focusedChild, state)) {
            if (this.mLastStackFromEnd != getStackFromEnd()) {
                return false;
            }
            if (aVar.c) {
                myFindReferenceChildClosestToStart = myFindReferenceChildClosestToEnd(state);
            } else {
                myFindReferenceChildClosestToStart = myFindReferenceChildClosestToStart(state);
            }
            if (myFindReferenceChildClosestToStart != null) {
                aVar.b(myFindReferenceChildClosestToStart);
                if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                    if ((this.mOrientationHelper.g(myFindReferenceChildClosestToStart) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(myFindReferenceChildClosestToStart) < this.mOrientationHelper.k()) ? true : true) {
                        if (aVar.c) {
                            k = this.mOrientationHelper.i();
                        } else {
                            k = this.mOrientationHelper.k();
                        }
                        aVar.b = k;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private boolean updateAnchorFromPendingDataExpose(RecyclerView.State state, a aVar) {
        int i;
        int g;
        if (!state.isPreLayout() && (i = this.mCurrentPendingScrollPosition) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                aVar.a = this.mCurrentPendingScrollPosition;
                Bundle bundle = this.mCurrentPendingSavedState;
                if (bundle != null && bundle.getInt("AnchorPosition") >= 0) {
                    boolean z = this.mCurrentPendingSavedState.getBoolean("AnchorLayoutFromEnd");
                    aVar.c = z;
                    if (z) {
                        aVar.b = this.mOrientationHelper.i() - this.mCurrentPendingSavedState.getInt("AnchorOffset");
                    } else {
                        aVar.b = this.mOrientationHelper.k() + this.mCurrentPendingSavedState.getInt("AnchorOffset");
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mCurrentPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.l()) {
                            aVar.a();
                            return true;
                        } else if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.k() < 0) {
                            aVar.b = this.mOrientationHelper.k();
                            aVar.c = false;
                            return true;
                        } else if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                            aVar.b = this.mOrientationHelper.i();
                            aVar.c = true;
                            return true;
                        } else {
                            if (aVar.c) {
                                g = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.m();
                            } else {
                                g = this.mOrientationHelper.g(findViewByPosition);
                            }
                            aVar.b = g;
                        }
                    } else {
                        if (getChildCount() > 0) {
                            aVar.c = (this.mCurrentPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayoutExpose;
                        }
                        aVar.a();
                    }
                    return true;
                } else {
                    boolean z2 = this.mShouldReverseLayoutExpose;
                    aVar.c = z2;
                    if (z2) {
                        aVar.b = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.b = this.mOrientationHelper.k() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
            this.mCurrentPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayoutExpose(RecyclerView.State state, a aVar) {
        if (updateAnchorFromPendingDataExpose(state, aVar) || updateAnchorFromChildrenExpose(state, aVar)) {
            return;
        }
        aVar.a();
        aVar.a = getStackFromEnd() ? state.getItemCount() - 1 : 0;
    }

    private void updateLayoutStateToFillEndExpose(a aVar) {
        updateLayoutStateToFillEndExpose(aVar.a, aVar.b);
    }

    private void updateLayoutStateToFillStartExpose(a aVar) {
        updateLayoutStateToFillStartExpose(aVar.a, aVar.b);
    }

    private void validateChildOrderExpose() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int g = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayoutExpose) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int g2 = this.mOrientationHelper.g(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(g2 < g);
                    throw new RuntimeException(sb.toString());
                } else if (g2 > g) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int g3 = this.mOrientationHelper.g(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(g3 < g);
                throw new RuntimeException(sb2.toString());
            } else if (g3 < g) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addHiddenView(View view, boolean z) {
        addView(view, z ? 0 : -1);
        this.mChildHelperWrapper.c(view);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mCurrentPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    protected int computeAlignOffset(int i, boolean z, boolean z2) {
        return 0;
    }

    protected int computeAlignOffset(View view, boolean z, boolean z2) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayoutExpose ? -1 : 1;
        if (getOrientation() == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ensureLayoutStateExpose() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new c();
        }
        if (this.mOrientationHelper == null) {
            this.mOrientationHelper = com.alibaba.android.vlayout.c.b(this, getOrientation());
        }
        try {
            this.mEnsureLayoutStateMethod.invoke(this, this.emptyArgs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int fill(RecyclerView.Recycler recycler, c cVar, RecyclerView.State state, boolean z) {
        int i = cVar.mAvailable;
        int i2 = cVar.mScrollingOffset;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.mScrollingOffset = i2 + i;
            }
            recycleByLayoutStateExpose(recycler, cVar);
        }
        int i3 = cVar.mAvailable + cVar.mExtra + this.recycleOffset;
        while (i3 > 0 && cVar.hasMore(state)) {
            this.layoutChunkResultCache.a();
            layoutChunk(recycler, state, cVar, this.layoutChunkResultCache);
            m81 m81Var = this.layoutChunkResultCache;
            if (!m81Var.b) {
                cVar.mOffset += m81Var.a * cVar.mLayoutDirection;
                if (!m81Var.c || this.mLayoutState.mScrapList != null || !state.isPreLayout()) {
                    int i4 = cVar.mAvailable;
                    int i5 = this.layoutChunkResultCache.a;
                    cVar.mAvailable = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.mScrollingOffset;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + this.layoutChunkResultCache.a;
                    cVar.mScrollingOffset = i7;
                    int i8 = cVar.mAvailable;
                    if (i8 < 0) {
                        cVar.mScrollingOffset = i7 + i8;
                    }
                    recycleByLayoutStateExpose(recycler, cVar);
                }
                if (z && this.layoutChunkResultCache.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.mAvailable;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findFirstVisibleItemPosition() {
        ensureLayoutStateExpose();
        return super.findFirstVisibleItemPosition();
    }

    protected View findHiddenView(int i) {
        return this.mChildHelperWrapper.b(i, -1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findLastVisibleItemPosition() {
        ensureLayoutStateExpose();
        try {
            return super.findLastVisibleItemPosition();
        } catch (Exception e) {
            Log.d("LastItem", "itemCount: " + getItemCount());
            Log.d("LastItem", "childCount: " + getChildCount());
            Log.d("LastItem", "child: " + getChildAt(getChildCount() + (-1)));
            Log.d("LastItem", "RV childCount: " + this.mRecyclerView.getChildCount());
            Log.d("LastItem", "RV child: " + this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-1)));
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideView(View view) {
        this.mChildHelperWrapper.c(view);
    }

    public boolean isEnableMarginOverLap() {
        return false;
    }

    protected boolean isHidden(View view) {
        return this.mChildHelperWrapper.d(view);
    }

    protected void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar, m81 m81Var) {
        int i;
        int i2;
        int i3;
        int i4;
        View next = cVar.next(recycler);
        if (next == null) {
            m81Var.b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) next.getLayoutParams();
        if (cVar.mScrapList == null) {
            if (this.mShouldReverseLayoutExpose == (cVar.mLayoutDirection == -1)) {
                addView(next);
            } else {
                addView(next, 0);
            }
        } else {
            if (this.mShouldReverseLayoutExpose == (cVar.mLayoutDirection == -1)) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, 0);
            }
        }
        measureChildWithMargins(next, 0, 0);
        m81Var.a = this.mOrientationHelper.e(next);
        if (getOrientation() == 1) {
            if (isLayoutRTL()) {
                i4 = getWidth() - getPaddingRight();
                i = i4 - this.mOrientationHelper.f(next);
            } else {
                i = getPaddingLeft();
                i4 = this.mOrientationHelper.f(next) + i;
            }
            if (cVar.mLayoutDirection == -1) {
                i2 = cVar.mOffset;
                i3 = i2 - m81Var.a;
            } else {
                i3 = cVar.mOffset;
                i2 = m81Var.a + i3;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f = this.mOrientationHelper.f(next) + paddingTop;
            if (cVar.mLayoutDirection == -1) {
                int i5 = cVar.mOffset;
                int i6 = i5 - m81Var.a;
                i4 = i5;
                i2 = f;
                i = i6;
                i3 = paddingTop;
            } else {
                int i7 = cVar.mOffset;
                int i8 = m81Var.a + i7;
                i = i7;
                i2 = f;
                i3 = paddingTop;
                i4 = i8;
            }
        }
        layoutDecorated(next, i + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i3, i4 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i2 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            m81Var.c = true;
        }
        m81Var.d = next.isFocusable();
    }

    public void onAnchorReady(RecyclerView.State state, a aVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        this.mRecyclerView = null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirectionExpose;
        View myFindReferenceChildClosestToEnd;
        View childClosestToEndExpose;
        myResolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirectionExpose = convertFocusDirectionToLayoutDirectionExpose(i)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirectionExpose == -1) {
            myFindReferenceChildClosestToEnd = myFindReferenceChildClosestToStart(state);
        } else {
            myFindReferenceChildClosestToEnd = myFindReferenceChildClosestToEnd(state);
        }
        if (myFindReferenceChildClosestToEnd == null) {
            return null;
        }
        ensureLayoutStateExpose();
        updateLayoutStateExpose(convertFocusDirectionToLayoutDirectionExpose, (int) (this.mOrientationHelper.l() * MAX_SCROLL_FACTOR), false, state);
        c cVar = this.mLayoutState;
        cVar.mScrollingOffset = Integer.MIN_VALUE;
        cVar.mRecycle = false;
        cVar.mOnRefresLayout = false;
        fill(recycler, cVar, state, true);
        if (convertFocusDirectionToLayoutDirectionExpose == -1) {
            childClosestToEndExpose = getChildClosestToStartExpose();
        } else {
            childClosestToEndExpose = getChildClosestToEndExpose();
        }
        if (childClosestToEndExpose == myFindReferenceChildClosestToEnd || !childClosestToEndExpose.isFocusable()) {
            return null;
        }
        return childClosestToEndExpose;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int fixLayoutEndGapExpose;
        int i6;
        View findViewByPosition;
        int g;
        int i7;
        Bundle bundle = this.mCurrentPendingSavedState;
        if (bundle != null && bundle.getInt("AnchorPosition") >= 0) {
            this.mCurrentPendingScrollPosition = this.mCurrentPendingSavedState.getInt("AnchorPosition");
        }
        ensureLayoutStateExpose();
        this.mLayoutState.mRecycle = false;
        myResolveShouldLayoutReverse();
        this.mAnchorInfo.d();
        this.mAnchorInfo.c = this.mShouldReverseLayoutExpose ^ getStackFromEnd();
        updateAnchorInfoForLayoutExpose(state, this.mAnchorInfo);
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if ((state.getTargetScrollPosition() < this.mAnchorInfo.a) == this.mShouldReverseLayoutExpose) {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        } else {
            i = 0;
        }
        int k = extraLayoutSpace + this.mOrientationHelper.k();
        int j = i + this.mOrientationHelper.j();
        if (state.isPreLayout() && (i6 = this.mCurrentPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayoutExpose) {
                i7 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                g = this.mPendingScrollPositionOffset;
            } else {
                g = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.k();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i8 = i7 - g;
            if (i8 > 0) {
                k += i8;
            } else {
                j -= i8;
            }
        }
        onAnchorReady(state, this.mAnchorInfo);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        this.mLayoutState.mOnRefresLayout = true;
        a aVar = this.mAnchorInfo;
        if (aVar.c) {
            updateLayoutStateToFillStartExpose(aVar);
            c cVar = this.mLayoutState;
            cVar.mExtra = k;
            fill(recycler, cVar, state, false);
            c cVar2 = this.mLayoutState;
            i2 = cVar2.mOffset;
            int i9 = cVar2.mAvailable;
            if (i9 > 0) {
                j += i9;
            }
            updateLayoutStateToFillEndExpose(this.mAnchorInfo);
            c cVar3 = this.mLayoutState;
            cVar3.mExtra = j;
            cVar3.mCurrentPosition += cVar3.mItemDirection;
            fill(recycler, cVar3, state, false);
            i3 = this.mLayoutState.mOffset;
        } else {
            updateLayoutStateToFillEndExpose(aVar);
            c cVar4 = this.mLayoutState;
            cVar4.mExtra = j;
            fill(recycler, cVar4, state, false);
            c cVar5 = this.mLayoutState;
            int i10 = cVar5.mOffset;
            int i11 = cVar5.mAvailable;
            if (i11 > 0) {
                k += i11;
            }
            updateLayoutStateToFillStartExpose(this.mAnchorInfo);
            c cVar6 = this.mLayoutState;
            cVar6.mExtra = k;
            cVar6.mCurrentPosition += cVar6.mItemDirection;
            fill(recycler, cVar6, state, false);
            i2 = this.mLayoutState.mOffset;
            i3 = i10;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayoutExpose ^ getStackFromEnd()) {
                int fixLayoutEndGapExpose2 = fixLayoutEndGapExpose(i3, recycler, state, true);
                i4 = i2 + fixLayoutEndGapExpose2;
                i5 = i3 + fixLayoutEndGapExpose2;
                fixLayoutEndGapExpose = fixLayoutStartGapExpose(i4, recycler, state, false);
            } else {
                int fixLayoutStartGapExpose = fixLayoutStartGapExpose(i2, recycler, state, true);
                i4 = i2 + fixLayoutStartGapExpose;
                i5 = i3 + fixLayoutStartGapExpose;
                fixLayoutEndGapExpose = fixLayoutEndGapExpose(i5, recycler, state, false);
            }
            i2 = i4 + fixLayoutEndGapExpose;
            i3 = i5 + fixLayoutEndGapExpose;
        }
        layoutForPredictiveAnimationsExpose(recycler, state, i2, i3);
        if (!state.isPreLayout()) {
            this.mCurrentPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            this.mOrientationHelper.o();
        }
        this.mLastStackFromEnd = getStackFromEnd();
        this.mCurrentPendingSavedState = null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            this.mCurrentPendingSavedState = (Bundle) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mCurrentPendingSavedState != null) {
            return new Bundle(this.mCurrentPendingSavedState);
        }
        Bundle bundle = new Bundle();
        if (getChildCount() > 0) {
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayoutExpose;
            bundle.putBoolean("AnchorLayoutFromEnd", z);
            if (z) {
                View childClosestToEndExpose = getChildClosestToEndExpose();
                bundle.putInt("AnchorOffset", this.mOrientationHelper.i() - this.mOrientationHelper.d(childClosestToEndExpose));
                bundle.putInt("AnchorPosition", getPosition(childClosestToEndExpose));
            } else {
                View childClosestToStartExpose = getChildClosestToStartExpose();
                bundle.putInt("AnchorPosition", getPosition(childClosestToStartExpose));
                bundle.putInt("AnchorOffset", this.mOrientationHelper.g(childClosestToStartExpose) - this.mOrientationHelper.k());
            }
        } else {
            bundle.putInt("AnchorPosition", -1);
        }
        return bundle;
    }

    protected void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            removeAndRecycleViewAt(i3, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation() == 1) {
            return 0;
        }
        return scrollInternalBy(i, recycler, state);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int scrollInternalBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.mLayoutState.mRecycle = true;
        ensureLayoutStateExpose();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutStateExpose(i2, abs, true, state);
        c cVar = this.mLayoutState;
        int i3 = cVar.mScrollingOffset;
        cVar.mOnRefresLayout = false;
        int fill = i3 + fill(recycler, cVar, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.n(-i);
        return i;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.mCurrentPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        Bundle bundle = this.mCurrentPendingSavedState;
        if (bundle != null) {
            bundle.putInt("AnchorPosition", -1);
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int i, int i2) {
        this.mCurrentPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        Bundle bundle = this.mCurrentPendingSavedState;
        if (bundle != null) {
            bundle.putInt("AnchorPosition", -1);
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getOrientation() == 0) {
            return 0;
        }
        return scrollInternalBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int i) {
        super.setOrientation(i);
        this.mOrientationHelper = null;
    }

    public void setRecycleOffset(int i) {
        this.recycleOffset = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showView(View view) {
        this.mChildHelperWrapper.e(view);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mCurrentPendingSavedState == null && this.mLastStackFromEnd == getStackFromEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLayoutStateExpose(int i, int i2, boolean z, RecyclerView.State state) {
        int k;
        this.mLayoutState.mExtra = getExtraLayoutSpace(state);
        c cVar = this.mLayoutState;
        cVar.mLayoutDirection = i;
        if (i == 1) {
            cVar.mExtra += this.mOrientationHelper.j();
            View childClosestToEndExpose = getChildClosestToEndExpose();
            c cVar2 = this.mLayoutState;
            cVar2.mItemDirection = this.mShouldReverseLayoutExpose ? -1 : 1;
            int position = getPosition(childClosestToEndExpose);
            c cVar3 = this.mLayoutState;
            cVar2.mCurrentPosition = position + cVar3.mItemDirection;
            cVar3.mOffset = this.mOrientationHelper.d(childClosestToEndExpose) + computeAlignOffset(childClosestToEndExpose, true, false);
            k = this.mLayoutState.mOffset - this.mOrientationHelper.i();
        } else {
            View childClosestToStartExpose = getChildClosestToStartExpose();
            this.mLayoutState.mExtra += this.mOrientationHelper.k();
            c cVar4 = this.mLayoutState;
            cVar4.mItemDirection = this.mShouldReverseLayoutExpose ? 1 : -1;
            int position2 = getPosition(childClosestToStartExpose);
            c cVar5 = this.mLayoutState;
            cVar4.mCurrentPosition = position2 + cVar5.mItemDirection;
            cVar5.mOffset = this.mOrientationHelper.g(childClosestToStartExpose) + computeAlignOffset(childClosestToStartExpose, false, false);
            k = (-this.mLayoutState.mOffset) + this.mOrientationHelper.k();
        }
        c cVar6 = this.mLayoutState;
        cVar6.mAvailable = i2;
        if (z) {
            cVar6.mAvailable = i2 - k;
        }
        cVar6.mScrollingOffset = k;
    }

    public ExposeLinearLayoutManagerEx(Context context, int i, boolean z) {
        super(context, i, z);
        this.mShouldReverseLayoutExpose = false;
        this.mCurrentPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mCurrentPendingSavedState = null;
        this.emptyArgs = new Object[0];
        this.layoutChunkResultCache = new m81();
        this.mAnchorInfo = new a();
        setOrientation(i);
        setReverseLayout(z);
        this.mChildHelperWrapper = new b(this);
        try {
            Method declaredMethod = LinearLayoutManager.class.getDeclaredMethod("ensureLayoutState", new Class[0]);
            this.mEnsureLayoutStateMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            try {
                Method declaredMethod2 = RecyclerView.LayoutManager.class.getDeclaredMethod("setItemPrefetchEnabled", Boolean.TYPE);
                if (declaredMethod2 != null) {
                    declaredMethod2.invoke(this, Boolean.FALSE);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void updateLayoutStateToFillEndExpose(int i, int i2) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.i() - i2;
        c cVar = this.mLayoutState;
        cVar.mItemDirection = this.mShouldReverseLayoutExpose ? -1 : 1;
        cVar.mCurrentPosition = i;
        cVar.mLayoutDirection = 1;
        cVar.mOffset = i2;
        cVar.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStartExpose(int i, int i2) {
        this.mLayoutState.mAvailable = i2 - this.mOrientationHelper.k();
        c cVar = this.mLayoutState;
        cVar.mCurrentPosition = i;
        cVar.mItemDirection = this.mShouldReverseLayoutExpose ? 1 : -1;
        cVar.mLayoutDirection = -1;
        cVar.mOffset = i2;
        cVar.mScrollingOffset = Integer.MIN_VALUE;
    }
}
