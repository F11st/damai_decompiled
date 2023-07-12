package com.youku.arch.v3.recyclerview.layouthelper;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GridFixAutoStatLayoutHelper extends BaseLayoutHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static boolean DEBUG = false;
    private static final int MAIN_DIR_SPEC = View.MeasureSpec.makeMeasureSpec(0, 0);
    private static final String TAG = "GridLayoutHelper";
    float mAspectRatio;
    private int mHGap;
    private boolean mHGapDirty;
    private boolean mIgnoreExtra;
    private boolean mIsAutoExpand;
    private boolean mLayoutWithAnchor;
    private int mOrigHGap;
    private int mRawSpanCount;
    private View[] mSet;
    private int mSizePerSpan;
    private int[] mSpanCols;
    private int mSpanCount;
    private int[] mSpanIndices;
    @NonNull
    private SpanSizeLookup mSpanSizeLookup;
    private int mTotalSize;
    private int mVGap;
    private float[] mWeights;
    private int mWidthForHGap;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        private static transient /* synthetic */ IpChange $ipChange;

        DefaultSpanSizeLookup() {
        }

        @Override // com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1294789681") ? ((Integer) ipChange.ipc$dispatch("1294789681", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue() : (i - this.mStartPosition) % i2;
        }

        @Override // com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper.SpanSizeLookup
        public int getSpanSize(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-467714147")) {
                return ((Integer) ipChange.ipc$dispatch("-467714147", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            return 1;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static abstract class SpanSizeLookup {
        private static transient /* synthetic */ IpChange $ipChange;
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        int mStartPosition = 0;

        int findReferenceIndexFromCache(int i) {
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-747274063")) {
                return ((Integer) ipChange.ipc$dispatch("-747274063", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int size = this.mSpanIndexCache.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.mSpanIndexCache.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.mSpanIndexCache.size()) {
                return -1;
            }
            return this.mSpanIndexCache.keyAt(i4);
        }

        int getCachedSpanIndex(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1926208816")) {
                return ((Integer) ipChange.ipc$dispatch("1926208816", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
            }
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-79536419")) {
                return ((Integer) ipChange.ipc$dispatch("-79536419", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
            }
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int spanSize2 = getSpanSize(i5);
                i3 += spanSize2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = spanSize2;
                }
            }
            return i3 + spanSize > i2 ? i4 + 1 : i4;
        }

        public int getSpanIndex(int i, int i2) {
            int i3;
            int findReferenceIndexFromCache;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1618048494")) {
                return ((Integer) ipChange.ipc$dispatch("1618048494", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
            }
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            int i4 = this.mStartPosition;
            if (!this.mCacheSpanIndices || this.mSpanIndexCache.size() <= 0 || (findReferenceIndexFromCache = findReferenceIndexFromCache(i)) < 0) {
                i3 = 0;
            } else {
                int i5 = findReferenceIndexFromCache + 1;
                i3 = this.mSpanIndexCache.get(findReferenceIndexFromCache) + getSpanSize(findReferenceIndexFromCache);
                i4 = i5;
            }
            while (i4 < i) {
                int spanSize2 = getSpanSize(i4);
                i3 += spanSize2;
                if (i3 == i2) {
                    i3 = 0;
                } else if (i3 > i2) {
                    i3 = spanSize2;
                }
                i4++;
            }
            if (spanSize + i3 <= i2) {
                return i3;
            }
            return 0;
        }

        public abstract int getSpanSize(int i);

        public int getStartPosition() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1968088683") ? ((Integer) ipChange.ipc$dispatch("1968088683", new Object[]{this})).intValue() : this.mStartPosition;
        }

        public void invalidateSpanIndexCache() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-387884136")) {
                ipChange.ipc$dispatch("-387884136", new Object[]{this});
            } else {
                this.mSpanIndexCache.clear();
            }
        }

        public boolean isSpanIndexCacheEnabled() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1015012828") ? ((Boolean) ipChange.ipc$dispatch("-1015012828", new Object[]{this})).booleanValue() : this.mCacheSpanIndices;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "145740")) {
                ipChange.ipc$dispatch("145740", new Object[]{this, Boolean.valueOf(z)});
            } else {
                this.mCacheSpanIndices = z;
            }
        }

        public void setStartPosition(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "270313471")) {
                ipChange.ipc$dispatch("270313471", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.mStartPosition = i;
            }
        }
    }

    public GridFixAutoStatLayoutHelper() {
        this(1, -1, -1);
    }

    private void adjustHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348503122")) {
            ipChange.ipc$dispatch("348503122", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mHGapDirty || this.mWidthForHGap != i) {
            this.mWidthForHGap = i;
            int i2 = this.mSpanCount;
            if (i2 == 2) {
                int i3 = this.mOrigHGap;
                if (((i - i3) & 1) != 0) {
                    this.mHGap = i3 - 1;
                } else {
                    this.mHGap = i3;
                }
            } else if (i2 != 3) {
                this.mHGap = this.mOrigHGap;
            } else {
                int i4 = this.mOrigHGap;
                int i5 = (i - (i4 << 1)) % 3;
                if (i5 == 1) {
                    this.mHGap = i4 - 1;
                } else if (i5 == 2) {
                    this.mHGap = i4 + 1;
                } else {
                    this.mHGap = i4;
                }
            }
            this.mHGapDirty = false;
        }
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z, LayoutManagerHelper layoutManagerHelper) {
        int i3;
        int i4;
        int i5;
        int i6;
        IpChange ipChange = $ipChange;
        int i7 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1804600450")) {
            ipChange.ipc$dispatch("-1804600450", new Object[]{this, recycler, state, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), layoutManagerHelper});
            return;
        }
        if (z) {
            i4 = i;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = i - 1;
            i4 = -1;
            i5 = -1;
        }
        if (layoutManagerHelper.getOrientation() == 1 && layoutManagerHelper.isDoLayoutRTL()) {
            i7 = i2 - 1;
            i6 = -1;
        } else {
            i6 = 1;
        }
        while (i3 != i4) {
            int spanSize = getSpanSize(recycler, state, layoutManagerHelper.getPosition(this.mSet[i3]));
            if (i6 == -1 && spanSize > 1) {
                this.mSpanIndices[i3] = i7 - (spanSize - 1);
            } else {
                this.mSpanIndices[i3] = i7;
            }
            i7 += spanSize * i6;
            i3 += i5;
        }
    }

    private void ensureSpanCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711546997")) {
            ipChange.ipc$dispatch("711546997", new Object[]{this});
            return;
        }
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
        int[] iArr = this.mSpanIndices;
        if (iArr == null || iArr.length != this.mSpanCount) {
            this.mSpanIndices = new int[this.mSpanCount];
        }
        int[] iArr2 = this.mSpanCols;
        if (iArr2 == null || iArr2.length != this.mSpanCount) {
            this.mSpanCols = new int[this.mSpanCount];
        }
    }

    private int getMainDirSpec(int i, int i2, int i3, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-137986427")) {
            return ((Integer) ipChange.ipc$dispatch("-137986427", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)})).intValue();
        }
        if (!Float.isNaN(f) && f > 0.0f && i3 > 0) {
            return View.MeasureSpec.makeMeasureSpec((int) ((i3 / f) + 0.5f), 1073741824);
        }
        if (!Float.isNaN(this.mAspectRatio)) {
            float f2 = this.mAspectRatio;
            if (f2 > 0.0f) {
                return View.MeasureSpec.makeMeasureSpec((int) ((i2 / f2) + 0.5f), 1073741824);
            }
        }
        if (i < 0) {
            return MAIN_DIR_SPEC;
        }
        return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764836350")) {
            return ((Integer) ipChange.ipc$dispatch("1764836350", new Object[]{this, recycler, state, Integer.valueOf(i)})).intValue();
        }
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976811299")) {
            return ((Integer) ipChange.ipc$dispatch("-1976811299", new Object[]{this, recycler, state, Integer.valueOf(i)})).intValue();
        }
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            return 0;
        }
        return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
    }

    private int updateCellWidth(int i, int i2, int i3, int i4, int i5, int i6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786955988")) {
            return ((Integer) ipChange.ipc$dispatch("786955988", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})).intValue();
        }
        if ((i4 + 1) % i6 == 0) {
            int i7 = this.mHGap;
            float[] fArr = this.mWeights;
            if (fArr == null || fArr.length <= 0) {
                int i8 = i6 - 1;
                int i9 = i7 * i8;
                return (i5 * i) + i9 != i2 ? (i2 - (i8 * i)) - i9 : i;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                i10 += this.mSpanCols[i11];
            }
            int i12 = (((i6 - 1) * i7) + i10) - i2;
            return i12 > 0 ? i - i12 : i;
        }
        return i;
    }

    @Override // com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125682324")) {
            ipChange.ipc$dispatch("-125682324", new Object[]{this, state, cVar, layoutManagerHelper});
        } else if (state.getItemCount() <= 0 || state.isPreLayout()) {
        } else {
            int cachedSpanIndex = this.mSpanSizeLookup.getCachedSpanIndex(cVar.a, this.mSpanCount);
            if (!cVar.c) {
                while (cachedSpanIndex > 0) {
                    int i = cVar.a;
                    if (i <= 0) {
                        break;
                    }
                    int i2 = i - 1;
                    cVar.a = i2;
                    cachedSpanIndex = this.mSpanSizeLookup.getCachedSpanIndex(i2, this.mSpanCount);
                }
            } else {
                while (cachedSpanIndex < this.mSpanCount - 1 && cVar.a < getRange().e().intValue()) {
                    int i3 = cVar.a + 1;
                    cVar.a = i3;
                    cachedSpanIndex = this.mSpanSizeLookup.getCachedSpanIndex(i3, this.mSpanCount);
                }
            }
            this.mLayoutWithAnchor = true;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.d, com.alibaba.android.vlayout.a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        int i2;
        int i3;
        int i4;
        int i5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1947111933")) {
            return ((Integer) ipChange.ipc$dispatch("1947111933", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), layoutManagerHelper})).intValue();
        }
        boolean z3 = layoutManagerHelper.getOrientation() == 1;
        if (z) {
            if (i == getItemCount() - 1) {
                if (z3) {
                    i4 = this.mMarginBottom;
                    i5 = this.mPaddingBottom;
                } else {
                    i4 = this.mMarginRight;
                    i5 = this.mPaddingRight;
                }
                return i4 + i5;
            }
        } else if (i == 0) {
            if (z3) {
                i2 = -this.mMarginTop;
                i3 = this.mPaddingTop;
            } else {
                i2 = -this.mMarginLeft;
                i3 = this.mPaddingLeft;
            }
            return i2 - i3;
        }
        return super.computeAlignOffset(i, z, z2, layoutManagerHelper);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public float getAspectRatio() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "366526561") ? ((Float) ipChange.ipc$dispatch("366526561", new Object[]{this})).floatValue() : this.mAspectRatio;
    }

    public int getHGap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-523481653") ? ((Integer) ipChange.ipc$dispatch("-523481653", new Object[]{this})).intValue() : this.mHGap;
    }

    public int getRawSpanCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1000519452") ? ((Integer) ipChange.ipc$dispatch("1000519452", new Object[]{this})).intValue() : this.mRawSpanCount;
    }

    public int getSpanCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1074401682") ? ((Integer) ipChange.ipc$dispatch("1074401682", new Object[]{this})).intValue() : this.mSpanCount;
    }

    public int getVGap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-983332007") ? ((Integer) ipChange.ipc$dispatch("-983332007", new Object[]{this})).intValue() : this.mVGap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0272, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02a1, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0156, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0184, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x025b, code lost:
        if (r0 == getRange().e().intValue()) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x026e, code lost:
        if (r0 == getRange().d().intValue()) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0270, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0208 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022d  */
    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutViews(androidx.recyclerview.widget.RecyclerView.Recycler r34, androidx.recyclerview.widget.RecyclerView.State r35, com.alibaba.android.vlayout.VirtualLayoutManager.d r36, tb.m81 r37, com.alibaba.android.vlayout.LayoutManagerHelper r38) {
        /*
            Method dump skipped, instructions count: 1818
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.recyclerview.layouthelper.GridFixAutoStatLayoutHelper.layoutViews(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, com.alibaba.android.vlayout.VirtualLayoutManager$d, tb.m81, com.alibaba.android.vlayout.LayoutManagerHelper):void");
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465248626")) {
            ipChange.ipc$dispatch("1465248626", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onClear(layoutManagerHelper);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2143808261")) {
            ipChange.ipc$dispatch("2143808261", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onItemsChanged(layoutManagerHelper);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.a
    public void onRangeChange(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173454606")) {
            ipChange.ipc$dispatch("1173454606", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mSpanSizeLookup.setStartPosition(i);
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void setAspectRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-602517789")) {
            ipChange.ipc$dispatch("-602517789", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mAspectRatio = f;
        }
    }

    public void setAutoExpand(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2093051683")) {
            ipChange.ipc$dispatch("2093051683", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsAutoExpand = z;
        }
    }

    public void setGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281917417")) {
            ipChange.ipc$dispatch("1281917417", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setVGap(i);
        setHGap(i);
    }

    public void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863387959")) {
            ipChange.ipc$dispatch("863387959", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        this.mOrigHGap = i;
        this.mHGap = i;
        this.mHGapDirty = true;
    }

    public void setIgnoreExtra(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907578558")) {
            ipChange.ipc$dispatch("-907578558", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIgnoreExtra = z;
        }
    }

    public void setRawSpanCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592366074")) {
            ipChange.ipc$dispatch("-592366074", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRawSpanCount = i;
        setSpanCount(i);
    }

    public void setSpanCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410268088")) {
            ipChange.ipc$dispatch("1410268088", new Object[]{this, Integer.valueOf(i)});
        } else if (i == this.mSpanCount) {
        } else {
            if (i >= 1) {
                this.mSpanCount = i;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                ensureSpanCount();
                this.mHGapDirty = true;
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "714565996")) {
            ipChange.ipc$dispatch("714565996", new Object[]{this, spanSizeLookup});
        } else if (spanSizeLookup != null) {
            spanSizeLookup.setStartPosition(this.mSpanSizeLookup.getStartPosition());
            this.mSpanSizeLookup = spanSizeLookup;
        }
    }

    public void setVGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507071127")) {
            ipChange.ipc$dispatch("-507071127", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        this.mVGap = i;
    }

    public void setWeights(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-932311776")) {
            ipChange.ipc$dispatch("-932311776", new Object[]{this, fArr});
        } else if (fArr != null) {
            this.mWeights = Arrays.copyOf(fArr, fArr.length);
        } else {
            this.mWeights = new float[0];
        }
    }

    public GridFixAutoStatLayoutHelper(int i) {
        this(i, -1, -1);
    }

    public GridFixAutoStatLayoutHelper(int i, int i2) {
        this(i, i2, 0);
    }

    public GridFixAutoStatLayoutHelper(int i, int i2, int i3) {
        this(i, i2, i3, i3);
    }

    public GridFixAutoStatLayoutHelper(int i, int i2, int i3, int i4) {
        this.mSpanCount = 4;
        this.mSizePerSpan = 0;
        this.mTotalSize = 0;
        this.mIsAutoExpand = false;
        this.mIgnoreExtra = false;
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mVGap = 0;
        this.mOrigHGap = 0;
        this.mHGapDirty = false;
        this.mWidthForHGap = 0;
        this.mHGap = 0;
        this.mWeights = new float[0];
        this.mAspectRatio = Float.NaN;
        this.mLayoutWithAnchor = false;
        setRawSpanCount(i);
        this.mSpanSizeLookup.setSpanIndexCacheEnabled(true);
        setItemCount(i2);
        setVGap(i3);
        setHGap(i4);
    }
}
