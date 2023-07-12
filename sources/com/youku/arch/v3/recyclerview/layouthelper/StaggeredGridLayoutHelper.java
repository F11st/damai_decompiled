package com.youku.arch.v3.recyclerview.layouthelper;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import tb.m81;
import tb.py1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StaggeredGridLayoutHelper extends BaseLayoutHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int INVALID_LINE = Integer.MIN_VALUE;
    private static final int INVALID_SPAN_ID = Integer.MIN_VALUE;
    private static final String LOOKUP_BUNDLE_KEY = "StaggeredGridLayoutHelper_LazySpanLookup";
    private static final String TAG = "GridLayoutHelper";
    private int anchorPosition;
    private final Runnable checkForGapsRunnable;
    private int mColLength;
    private int mEachGap;
    private int mHGap;
    private int mLastGap;
    private WeakReference<VirtualLayoutManager> mLayoutManager;
    private boolean mLayoutWithAnchor;
    private final LazySpanLookup mLazySpanLookup;
    private int mNumLanes;
    private int mRawLane;
    private BitSet mRemainingSpans;
    private Span[] mSpans;
    private int mVGap;
    private final List<View> preLayoutViewList;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class LazySpanLookup {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final int MIN_SIZE = 10;
        int[] mData;

        LazySpanLookup() {
        }

        void clear() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2032997469")) {
                ipChange.ipc$dispatch("2032997469", new Object[]{this});
                return;
            }
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, Integer.MIN_VALUE);
            }
        }

        void ensureSize(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "674249378")) {
                ipChange.ipc$dispatch("674249378", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.mData = iArr2;
                Arrays.fill(iArr2, Integer.MIN_VALUE);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[sizeForPosition(i)];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, Integer.MIN_VALUE);
            }
        }

        int getSpan(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "124238700")) {
                return ((Integer) ipChange.ipc$dispatch("124238700", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length || i < 0) {
                return Integer.MIN_VALUE;
            }
            return iArr[i];
        }

        int invalidateAfter(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1934252429")) {
                return ((Integer) ipChange.ipc$dispatch("1934252429", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int[] iArr = this.mData;
            if (iArr != null && i < iArr.length) {
                Arrays.fill(iArr, i, iArr.length, Integer.MIN_VALUE);
                return this.mData.length;
            }
            return -1;
        }

        void offsetForAddition(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-741146856")) {
                ipChange.ipc$dispatch("-741146856", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            ensureSize(i3);
            int[] iArr2 = this.mData;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.mData, i, i3, Integer.MIN_VALUE);
        }

        void offsetForRemoval(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1037559882")) {
                ipChange.ipc$dispatch("1037559882", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            ensureSize(i3);
            int[] iArr2 = this.mData;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.mData;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, Integer.MIN_VALUE);
        }

        void setSpan(int i, Span span) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1329931991")) {
                ipChange.ipc$dispatch("1329931991", new Object[]{this, Integer.valueOf(i), span});
                return;
            }
            ensureSize(i);
            this.mData[i] = span.mIndex;
        }

        int sizeForPosition(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "42536573")) {
                return ((Integer) ipChange.ipc$dispatch("42536573", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Span {
        private static transient /* synthetic */ IpChange $ipChange = null;
        static final int INVALID_OFFSET = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        int mLastEdgeEnd;
        int mLastEdgeStart;
        private ArrayList<View> mViews;

        void appendToSpan(View view, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1315722847")) {
                ipChange.ipc$dispatch("-1315722847", new Object[]{this, view, abstractC3291c});
                return;
            }
            RecyclerView.LayoutParams layoutParams = getLayoutParams(view);
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += abstractC3291c.e(view);
            }
        }

        void cacheReferenceLineAndClear(boolean z, int i, AbstractC3291c abstractC3291c) {
            int startLine;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1450057170")) {
                ipChange.ipc$dispatch("1450057170", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), abstractC3291c});
                return;
            }
            if (z) {
                startLine = getEndLine(abstractC3291c);
            } else {
                startLine = getStartLine(abstractC3291c);
            }
            clear();
            if (startLine == Integer.MIN_VALUE) {
                return;
            }
            if ((!z || startLine >= abstractC3291c.i()) && !z) {
                abstractC3291c.k();
            }
            if (i != Integer.MIN_VALUE) {
                startLine += i;
            }
            this.mCachedEnd = startLine;
            this.mCachedStart = startLine;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
        }

        void calculateCachedEnd(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1721753633")) {
                ipChange.ipc$dispatch("1721753633", new Object[]{this, abstractC3291c});
            } else if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            } else {
                ArrayList<View> arrayList = this.mViews;
                this.mCachedEnd = abstractC3291c.d(arrayList.get(arrayList.size() - 1));
            }
        }

        void calculateCachedStart(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-345504920")) {
                ipChange.ipc$dispatch("-345504920", new Object[]{this, abstractC3291c});
            } else if (this.mViews.size() == 0) {
                this.mCachedStart = Integer.MIN_VALUE;
            } else {
                this.mCachedStart = abstractC3291c.g(this.mViews.get(0));
            }
        }

        void clear() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-698394869")) {
                ipChange.ipc$dispatch("-698394869", new Object[]{this});
                return;
            }
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        boolean findEnd(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1879086336")) {
                return ((Boolean) ipChange.ipc$dispatch("1879086336", new Object[]{this, view})).booleanValue();
            }
            int size = this.mViews.size();
            return size > 0 && this.mViews.get(size - 1) == view;
        }

        boolean findStart(View view) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-977196985") ? ((Boolean) ipChange.ipc$dispatch("-977196985", new Object[]{this, view})).booleanValue() : this.mViews.size() > 0 && this.mViews.get(0) == view;
        }

        public int getDeletedSize() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2031417151") ? ((Integer) ipChange.ipc$dispatch("-2031417151", new Object[]{this})).intValue() : this.mDeletedSize;
        }

        int getEndLine(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-590431302") ? ((Integer) ipChange.ipc$dispatch("-590431302", new Object[]{this, abstractC3291c})).intValue() : getEndLine(Integer.MIN_VALUE, abstractC3291c);
        }

        RecyclerView.LayoutParams getLayoutParams(View view) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1344909403") ? (RecyclerView.LayoutParams) ipChange.ipc$dispatch("1344909403", new Object[]{this, view}) : (RecyclerView.LayoutParams) view.getLayoutParams();
        }

        int getNormalizedOffset(int i, int i2, int i3, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2125043240")) {
                return ((Integer) ipChange.ipc$dispatch("2125043240", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), abstractC3291c})).intValue();
            }
            if (this.mViews.size() == 0) {
                return 0;
            }
            if (i < 0) {
                int endLine = getEndLine(0, abstractC3291c) - i3;
                if (endLine <= 0) {
                    return 0;
                }
                return (-i) > endLine ? -endLine : i;
            }
            int startLine = i2 - getStartLine(0, abstractC3291c);
            if (startLine <= 0) {
                return 0;
            }
            return startLine < i ? startLine : i;
        }

        int getStartLine(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1914373889") ? ((Integer) ipChange.ipc$dispatch("1914373889", new Object[]{this, abstractC3291c})).intValue() : getStartLine(Integer.MIN_VALUE, abstractC3291c);
        }

        void invalidateCache() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1950230447")) {
                ipChange.ipc$dispatch("-1950230447", new Object[]{this});
                return;
            }
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
        }

        boolean isEmpty(int i, int i2, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-740656113")) {
                return ((Boolean) ipChange.ipc$dispatch("-740656113", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), abstractC3291c})).booleanValue();
            }
            int size = this.mViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.mViews.get(i3);
                if (abstractC3291c.g(view) < i2 && abstractC3291c.d(view) > i) {
                    return false;
                }
            }
            return true;
        }

        void onOffset(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-811827197")) {
                ipChange.ipc$dispatch("-811827197", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int i2 = this.mLastEdgeStart;
            if (i2 != Integer.MIN_VALUE) {
                this.mLastEdgeStart = i2 + i;
            }
            int i3 = this.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                this.mCachedStart = i3 + i;
            }
            int i4 = this.mLastEdgeEnd;
            if (i4 != Integer.MIN_VALUE) {
                this.mLastEdgeEnd = i4 + i;
            }
            int i5 = this.mCachedEnd;
            if (i5 != Integer.MIN_VALUE) {
                this.mCachedEnd = i5 + i;
            }
        }

        void popEnd(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1205308504")) {
                ipChange.ipc$dispatch("1205308504", new Object[]{this, abstractC3291c});
                return;
            }
            int size = this.mViews.size();
            View remove = this.mViews.remove(size - 1);
            RecyclerView.LayoutParams layoutParams = getLayoutParams(remove);
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= abstractC3291c.e(remove);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        void popStart(AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1566932447")) {
                ipChange.ipc$dispatch("1566932447", new Object[]{this, abstractC3291c});
                return;
            }
            View remove = this.mViews.remove(0);
            RecyclerView.LayoutParams layoutParams = getLayoutParams(remove);
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= abstractC3291c.e(remove);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        void prependToSpan(View view, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1380036845")) {
                ipChange.ipc$dispatch("-1380036845", new Object[]{this, view, abstractC3291c});
                return;
            }
            RecyclerView.LayoutParams layoutParams = getLayoutParams(view);
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += abstractC3291c.e(view);
            }
        }

        void setLine(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "708445889")) {
                ipChange.ipc$dispatch("708445889", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.mCachedStart = i;
            this.mCachedEnd = i;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
        }

        private Span(int i) {
            this.mViews = new ArrayList<>();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mLastEdgeStart = Integer.MIN_VALUE;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mIndex = i;
        }

        int getEndLine(int i, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1429693783")) {
                return ((Integer) ipChange.ipc$dispatch("-1429693783", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
            }
            int i2 = this.mCachedEnd;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i != Integer.MIN_VALUE && this.mViews.size() == 0) {
                int i3 = this.mLastEdgeStart;
                return i3 != Integer.MIN_VALUE ? i3 : i;
            }
            calculateCachedEnd(abstractC3291c);
            return this.mCachedEnd;
        }

        int getStartLine(int i, AbstractC3291c abstractC3291c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1090144190")) {
                return ((Integer) ipChange.ipc$dispatch("-1090144190", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
            }
            int i2 = this.mCachedStart;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (i != Integer.MIN_VALUE && this.mViews.size() == 0) {
                int i3 = this.mLastEdgeEnd;
                return i3 != Integer.MIN_VALUE ? i3 : i;
            }
            calculateCachedStart(abstractC3291c);
            return this.mCachedStart;
        }
    }

    public StaggeredGridLayoutHelper() {
        this(1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010e A[LOOP:1: B:59:0x010c->B:60:0x010e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkForGaps() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper.checkForGaps():void");
    }

    private boolean checkSpanForGap(Span span, VirtualLayoutManager virtualLayoutManager, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135465265")) {
            return ((Boolean) ipChange.ipc$dispatch("2135465265", new Object[]{this, span, virtualLayoutManager, Integer.valueOf(i)})).booleanValue();
        }
        AbstractC3291c mainOrientationHelper = virtualLayoutManager.getMainOrientationHelper();
        if (virtualLayoutManager.getReverseLayout()) {
            if (span.getEndLine(mainOrientationHelper) != i) {
                return true;
            }
        } else if (span.getStartLine(mainOrientationHelper) != i) {
            return true;
        }
        return false;
    }

    private void ensureLanes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346474771")) {
            ipChange.ipc$dispatch("1346474771", new Object[]{this});
            return;
        }
        Span[] spanArr = this.mSpans;
        if (spanArr == null || spanArr.length != this.mNumLanes || this.mRemainingSpans == null) {
            this.mRemainingSpans = new BitSet(this.mNumLanes);
            this.mSpans = new Span[this.mNumLanes];
            for (int i = 0; i < this.mNumLanes; i++) {
                this.mSpans[i] = new Span(i);
            }
        }
    }

    private Span findSpan(int i, View view, boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1782450862")) {
            return (Span) ipChange.ipc$dispatch("1782450862", new Object[]{this, Integer.valueOf(i), view, Boolean.valueOf(z)});
        }
        int span = this.mLazySpanLookup.getSpan(i);
        if (span >= 0) {
            Span[] spanArr = this.mSpans;
            if (span < spanArr.length) {
                Span span2 = spanArr[span];
                if (z && span2.findStart(view)) {
                    return span2;
                }
                if (!z && span2.findEnd(view)) {
                    return span2;
                }
            }
        }
        while (true) {
            Span[] spanArr2 = this.mSpans;
            if (i2 >= spanArr2.length) {
                return null;
            }
            if (i2 != span) {
                Span span3 = spanArr2[i2];
                if (z && span3.findStart(view)) {
                    return span3;
                }
                if (!z && span3.findEnd(view)) {
                    return span3;
                }
            }
            i2++;
        }
    }

    private int getMaxEnd(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1638649759")) {
            return ((Integer) ipChange.ipc$dispatch("1638649759", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int endLine = this.mSpans[0].getEndLine(i, abstractC3291c);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i, abstractC3291c);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288149816")) {
            return ((Integer) ipChange.ipc$dispatch("288149816", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int startLine = this.mSpans[0].getStartLine(i, abstractC3291c);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i, abstractC3291c);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363947149")) {
            return ((Integer) ipChange.ipc$dispatch("1363947149", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int endLine = this.mSpans[0].getEndLine(i, abstractC3291c);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i, abstractC3291c);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708053338")) {
            return ((Integer) ipChange.ipc$dispatch("-1708053338", new Object[]{this, Integer.valueOf(i), abstractC3291c})).intValue();
        }
        int startLine = this.mSpans[0].getStartLine(i, abstractC3291c);
        for (int i2 = 1; i2 < this.mNumLanes; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i, abstractC3291c);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
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
    private com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper.Span getNextSpan(int r7, com.alibaba.android.vlayout.VirtualLayoutManager.C3287d r8, com.alibaba.android.vlayout.LayoutManagerHelper r9) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper.$ipChange
            java.lang.String r1 = "259694279"
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
            com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper$Span r7 = (com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper.Span) r7
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
            int r9 = r6.mNumLanes
            int r3 = r9 + (-1)
            r9 = -1
            goto L66
        L63:
            int r2 = r6.mNumLanes
            r9 = 1
        L66:
            int r8 = r8.f()
            r1 = 0
            if (r8 != r4) goto L81
            r8 = 2147483647(0x7fffffff, float:NaN)
        L70:
            if (r3 == r2) goto L80
            com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper$Span[] r4 = r6.mSpans
            r4 = r4[r3]
            int r5 = r4.getEndLine(r7, r0)
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
            com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper$Span[] r4 = r6.mSpans
            r4 = r4[r3]
            int r5 = r4.getStartLine(r7, r0)
            if (r5 <= r8) goto L91
            r1 = r4
            r8 = r5
        L91:
            int r3 = r3 + r9
            goto L83
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper.getNextSpan(int, com.alibaba.android.vlayout.VirtualLayoutManager$d, com.alibaba.android.vlayout.LayoutManagerHelper):com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper$Span");
    }

    private View hasGapsToFix(VirtualLayoutManager virtualLayoutManager, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925867028")) {
            return (View) ipChange.ipc$dispatch("925867028", new Object[]{this, virtualLayoutManager, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (virtualLayoutManager.findViewByPosition(i) != null && this.mSpans != null) {
            new BitSet(this.mNumLanes).set(0, this.mNumLanes, true);
            int length = this.mSpans.length;
            for (int i3 = 0; i3 < length; i3++) {
                Span span = this.mSpans[i3];
                if (span.mViews.size() != 0 && checkSpanForGap(span, virtualLayoutManager, i2)) {
                    return (View) (virtualLayoutManager.getReverseLayout() ? span.mViews.get(span.mViews.size() - 1) : span.mViews.get(0));
                }
            }
        }
        return null;
    }

    private void recycle(RecyclerView.Recycler recycler, VirtualLayoutManager.C3287d c3287d, Span span, int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516962409")) {
            ipChange.ipc$dispatch("1516962409", new Object[]{this, recycler, c3287d, span, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (c3287d.f() == -1) {
            recycleFromEnd(recycler, Math.max(i, getMaxStart(span.getStartLine(mainOrientationHelper), mainOrientationHelper)) + (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        } else {
            recycleFromStart(recycler, Math.min(i, getMinEnd(span.getEndLine(mainOrientationHelper), mainOrientationHelper)) - (mainOrientationHelper.h() - mainOrientationHelper.k()), layoutManagerHelper);
        }
    }

    private void recycleForPreLayout(RecyclerView.Recycler recycler, VirtualLayoutManager.C3287d c3287d, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408906306")) {
            ipChange.ipc$dispatch("408906306", new Object[]{this, recycler, c3287d, layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int size = this.preLayoutViewList.size() - 1; size >= 0; size--) {
            View view = this.preLayoutViewList.get(size);
            if (view != null && mainOrientationHelper.g(view) > mainOrientationHelper.i()) {
                Span findSpan = findSpan(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewPosition(), view, false);
                if (findSpan != null) {
                    findSpan.popEnd(mainOrientationHelper);
                }
                layoutManagerHelper.removeChildView(view);
                recycler.recycleView(view);
            } else {
                Span findSpan2 = findSpan(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewPosition(), view, false);
                if (findSpan2 != null) {
                    findSpan2.popEnd(mainOrientationHelper);
                }
                layoutManagerHelper.removeChildView(view);
                recycler.recycleView(view);
                return;
            }
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1593922109")) {
            ipChange.ipc$dispatch("-1593922109", new Object[]{this, recycler, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        for (int childCount = layoutManagerHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = layoutManagerHelper.getChildAt(childCount);
            if (childAt == null || mainOrientationHelper.g(childAt) <= i) {
                return;
            }
            Span findSpan = findSpan(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, false);
            if (findSpan != null) {
                findSpan.popEnd(mainOrientationHelper);
                layoutManagerHelper.removeChildView(childAt);
                recycler.recycleView(childAt);
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i, LayoutManagerHelper layoutManagerHelper) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "304527516")) {
            ipChange.ipc$dispatch("304527516", new Object[]{this, recycler, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        boolean z = true;
        while (layoutManagerHelper.getChildCount() > 0 && z && (childAt = layoutManagerHelper.getChildAt(0)) != null && mainOrientationHelper.d(childAt) < i) {
            Span findSpan = findSpan(((RecyclerView.LayoutParams) childAt.getLayoutParams()).getViewPosition(), childAt, true);
            if (findSpan != null) {
                findSpan.popStart(mainOrientationHelper);
                layoutManagerHelper.removeChildView(childAt);
                recycler.recycleView(childAt);
            } else {
                z = false;
            }
        }
    }

    private void updateAllRemainingSpans(int i, int i2, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1910880849")) {
            ipChange.ipc$dispatch("-1910880849", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), abstractC3291c});
            return;
        }
        for (int i3 = 0; i3 < this.mNumLanes; i3++) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2, abstractC3291c);
            }
        }
    }

    private void updateRemainingSpans(Span span, int i, int i2, AbstractC3291c abstractC3291c) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997038972")) {
            ipChange.ipc$dispatch("997038972", new Object[]{this, span, Integer.valueOf(i), Integer.valueOf(i2), abstractC3291c});
            return;
        }
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (span.getStartLine(abstractC3291c) + deletedSize < i2) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        } else if (span.getEndLine(abstractC3291c) - deletedSize > i2) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560108773")) {
            ipChange.ipc$dispatch("-560108773", new Object[]{this, recycler, state, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper});
            return;
        }
        super.afterLayout(recycler, state, i, i2, i3, layoutManagerHelper);
        this.mLayoutWithAnchor = false;
        if (i > getRange().e().intValue() || i2 < getRange().d().intValue() || state.isPreLayout() || layoutManagerHelper.getChildCount() <= 0) {
            return;
        }
        ViewCompat.postOnAnimation(layoutManagerHelper.getChildAt(0), this.checkForGapsRunnable);
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.AbstractC3289a
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper layoutManagerHelper) {
        int contentHeight;
        int verticalPadding;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175189553")) {
            ipChange.ipc$dispatch("1175189553", new Object[]{this, recycler, state, layoutManagerHelper});
            return;
        }
        super.beforeLayout(recycler, state, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() == 1) {
            contentHeight = ((layoutManagerHelper.getContentWidth() - layoutManagerHelper.getPaddingLeft()) - layoutManagerHelper.getPaddingRight()) - getHorizontalMargin();
            verticalPadding = getHorizontalPadding();
        } else {
            contentHeight = ((layoutManagerHelper.getContentHeight() - layoutManagerHelper.getPaddingTop()) - layoutManagerHelper.getPaddingBottom()) - getVerticalMargin();
            verticalPadding = getVerticalPadding();
        }
        int i = contentHeight - verticalPadding;
        int i2 = this.mHGap;
        int i3 = this.mNumLanes;
        int i4 = (int) (((i - (i2 * (i3 - 1))) / i3) + 0.5d);
        this.mColLength = i4;
        int i5 = i - (i4 * i3);
        if (i3 <= 1) {
            this.mLastGap = 0;
            this.mEachGap = 0;
        } else if (i3 == 2) {
            this.mEachGap = i5;
            this.mLastGap = i5;
        } else {
            int i6 = layoutManagerHelper.getOrientation() == 1 ? this.mHGap : this.mVGap;
            this.mLastGap = i6;
            this.mEachGap = i6;
        }
        WeakReference<VirtualLayoutManager> weakReference = this.mLayoutManager;
        if ((weakReference == null || weakReference.get() == null || this.mLayoutManager.get() != layoutManagerHelper) && (layoutManagerHelper instanceof VirtualLayoutManager)) {
            this.mLayoutManager = new WeakReference<>((VirtualLayoutManager) layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.C3286c c3286c, LayoutManagerHelper layoutManagerHelper) {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "110763244")) {
            ipChange.ipc$dispatch("110763244", new Object[]{this, state, c3286c, layoutManagerHelper});
            return;
        }
        super.checkAnchorInfo(state, c3286c, layoutManagerHelper);
        ensureLanes();
        py1<Integer> range = getRange();
        if (c3286c.c) {
            if (c3286c.a < (range.d().intValue() + this.mNumLanes) - 1) {
                c3286c.a = Math.min((range.d().intValue() + this.mNumLanes) - 1, range.e().intValue());
            }
        } else if (c3286c.a > range.e().intValue() - (this.mNumLanes - 1)) {
            c3286c.a = Math.max(range.d().intValue(), range.e().intValue() - (this.mNumLanes - 1));
        }
        View findViewByPosition = layoutManagerHelper.findViewByPosition(c3286c.a);
        int i3 = layoutManagerHelper.getOrientation() == 1 ? this.mVGap : this.mHGap;
        AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
        if (findViewByPosition == null) {
            int length = this.mSpans.length;
            while (i2 < length) {
                Span span = this.mSpans[i2];
                span.clear();
                span.setLine(c3286c.b);
                i2++;
            }
            return;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = c3286c.c ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int length2 = this.mSpans.length;
        for (int i6 = 0; i6 < length2; i6++) {
            Span span2 = this.mSpans[i6];
            if (!span2.mViews.isEmpty()) {
                if (c3286c.c) {
                    i5 = Math.max(i5, layoutManagerHelper.getPosition((View) span2.mViews.get(span2.mViews.size() - 1)));
                } else {
                    i5 = Math.min(i5, layoutManagerHelper.getPosition((View) span2.mViews.get(0)));
                }
            }
        }
        if (!isOutOfRange(i5)) {
            boolean z = i5 == range.d().intValue();
            View findViewByPosition2 = layoutManagerHelper.findViewByPosition(i5);
            if (findViewByPosition2 != null) {
                if (c3286c.c) {
                    c3286c.a = i5;
                    int d = mainOrientationHelper.d(findViewByPosition);
                    int i7 = c3286c.b;
                    if (d < i7) {
                        int i8 = i7 - d;
                        if (z) {
                            i3 = 0;
                        }
                        i = i8 + i3;
                        c3286c.b = mainOrientationHelper.d(findViewByPosition2) + i;
                    } else {
                        if (z) {
                            i3 = 0;
                        }
                        c3286c.b = mainOrientationHelper.d(findViewByPosition2) + i3;
                        i = i3;
                    }
                } else {
                    c3286c.a = i5;
                    int g = mainOrientationHelper.g(findViewByPosition);
                    int i9 = c3286c.b;
                    if (g > i9) {
                        int i10 = i9 - g;
                        if (z) {
                            i3 = 0;
                        }
                        i = i10 - i3;
                        c3286c.b = mainOrientationHelper.g(findViewByPosition2) + i;
                    } else {
                        if (z) {
                            i3 = 0;
                        }
                        int i11 = -i3;
                        c3286c.b = mainOrientationHelper.g(findViewByPosition2) + i11;
                        i4 = i11;
                    }
                }
                i4 = i;
            }
        } else {
            this.anchorPosition = c3286c.a;
            this.mLayoutWithAnchor = true;
        }
        int length3 = this.mSpans.length;
        while (i2 < length3) {
            this.mSpans[i2].cacheReferenceLineAndClear(layoutManagerHelper.getReverseLayout() ^ c3286c.c, i4, mainOrientationHelper);
            i2++;
        }
    }

    @Override // com.alibaba.android.vlayout.layout.AbstractC3303d, com.alibaba.android.vlayout.AbstractC3289a
    public int computeAlignOffset(int i, boolean z, boolean z2, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253465475")) {
            return ((Integer) ipChange.ipc$dispatch("-1253465475", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), layoutManagerHelper})).intValue();
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

    public int getColLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2065289681") ? ((Integer) ipChange.ipc$dispatch("2065289681", new Object[]{this})).intValue() : this.mColLength;
    }

    public int getHGap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1051675979") ? ((Integer) ipChange.ipc$dispatch("1051675979", new Object[]{this})).intValue() : this.mHGap;
    }

    public int getLane() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1062759405") ? ((Integer) ipChange.ipc$dispatch("1062759405", new Object[]{this})).intValue() : this.mNumLanes;
    }

    public int getRawLane() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "771541283") ? ((Integer) ipChange.ipc$dispatch("771541283", new Object[]{this})).intValue() : this.mRawLane;
    }

    public int getVGap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "591825625") ? ((Integer) ipChange.ipc$dispatch("591825625", new Object[]{this})).intValue() : this.mVGap;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public boolean isRecyclable(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper, boolean z) {
        View findViewByPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861580893")) {
            return ((Boolean) ipChange.ipc$dispatch("-1861580893", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper, Boolean.valueOf(z)})).booleanValue();
        }
        boolean isRecyclable = super.isRecyclable(i, i2, i3, layoutManagerHelper, z);
        if (isRecyclable && (findViewByPosition = layoutManagerHelper.findViewByPosition(i)) != null) {
            AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            int viewPosition = ((RecyclerView.LayoutParams) findViewByPosition.getLayoutParams()).getViewPosition();
            if (layoutManagerHelper.getReverseLayout()) {
                if (z) {
                    Span findSpan = findSpan(viewPosition, findViewByPosition, true);
                    if (findSpan != null) {
                        findSpan.popEnd(mainOrientationHelper);
                    }
                } else {
                    Span findSpan2 = findSpan(viewPosition, findViewByPosition, false);
                    if (findSpan2 != null) {
                        findSpan2.popStart(mainOrientationHelper);
                    }
                }
            } else if (z) {
                Span findSpan3 = findSpan(viewPosition, findViewByPosition, true);
                if (findSpan3 != null) {
                    findSpan3.popStart(mainOrientationHelper);
                }
            } else {
                Span findSpan4 = findSpan(viewPosition, findViewByPosition, false);
                if (findSpan4 != null) {
                    findSpan4.popEnd(mainOrientationHelper);
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
        Span span;
        boolean z;
        int startLine;
        int i5;
        int i6;
        int e;
        int i7;
        int i8;
        int i9;
        View view;
        int i10;
        boolean z2;
        Span span2;
        int i11;
        AbstractC3291c abstractC3291c;
        int i12;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        VirtualLayoutManager.C3287d c3287d3 = c3287d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318493983")) {
            ipChange.ipc$dispatch("318493983", new Object[]{this, recycler2, state2, c3287d3, m81Var, layoutManagerHelper});
        } else if (!isOutOfRange(c3287d.c())) {
            ensureLanes();
            boolean z3 = layoutManagerHelper.getOrientation() == 1;
            AbstractC3291c mainOrientationHelper = layoutManagerHelper.getMainOrientationHelper();
            AbstractC3291c secondaryOrientationHelper = layoutManagerHelper.getSecondaryOrientationHelper();
            boolean isEnableMarginOverLap = layoutManagerHelper.isEnableMarginOverLap();
            this.mRemainingSpans.set(0, this.mNumLanes, true);
            if (c3287d.f() == 1) {
                g = c3287d.g() + c3287d.b();
                d = c3287d.d() + g + mainOrientationHelper.j();
            } else {
                g = c3287d.g() - c3287d.b();
                d = (g - c3287d.d()) - mainOrientationHelper.k();
            }
            int i13 = g;
            int i14 = d;
            updateAllRemainingSpans(c3287d.f(), i14, mainOrientationHelper);
            int g2 = c3287d.g();
            this.preLayoutViewList.clear();
            while (c3287d3.h(state2) && !this.mRemainingSpans.isEmpty() && !isOutOfRange(c3287d.c())) {
                int c = c3287d.c();
                View l = c3287d3.l(recycler2);
                if (l == null) {
                    break;
                }
                VirtualLayoutManager.LayoutParams layoutParams = (VirtualLayoutManager.LayoutParams) l.getLayoutParams();
                int viewPosition = layoutParams.getViewPosition();
                int i15 = i14;
                int span3 = this.mLazySpanLookup.getSpan(viewPosition);
                if (span3 == Integer.MIN_VALUE) {
                    span = getNextSpan(g2, c3287d3, layoutManagerHelper);
                    this.mLazySpanLookup.setSpan(viewPosition, span);
                } else {
                    span = this.mSpans[span3];
                }
                Span span4 = span;
                boolean z4 = viewPosition - getRange().d().intValue() < this.mNumLanes;
                boolean z5 = getRange().e().intValue() - viewPosition < this.mNumLanes;
                if (c3287d.j()) {
                    this.preLayoutViewList.add(l);
                }
                layoutManagerHelper.addChildView(c3287d3, l);
                if (z3) {
                    int childMeasureSpec = layoutManagerHelper.getChildMeasureSpec(this.mColLength, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    layoutManagerHelper.measureChildWithMargins(l, childMeasureSpec, layoutManagerHelper.getChildMeasureSpec(mainOrientationHelper.l(), Float.isNaN(layoutParams.a) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : (int) ((View.MeasureSpec.getSize(childMeasureSpec) / layoutParams.a) + 0.5f), true));
                    z = true;
                } else {
                    int childMeasureSpec2 = layoutManagerHelper.getChildMeasureSpec(this.mColLength, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    int l2 = mainOrientationHelper.l();
                    int size = Float.isNaN(layoutParams.a) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : (int) ((View.MeasureSpec.getSize(childMeasureSpec2) * layoutParams.a) + 0.5f);
                    z = true;
                    layoutManagerHelper.measureChildWithMargins(l, layoutManagerHelper.getChildMeasureSpec(l2, size, true), childMeasureSpec2);
                }
                if (c3287d.f() == z) {
                    e = span4.getEndLine(g2, mainOrientationHelper);
                    if (z4) {
                        i12 = computeStartSpace(layoutManagerHelper, z3, z, isEnableMarginOverLap);
                    } else if (this.mLayoutWithAnchor) {
                        if (Math.abs(c - this.anchorPosition) >= this.mNumLanes) {
                            i12 = z3 ? this.mVGap : this.mHGap;
                        }
                        i6 = mainOrientationHelper.e(l) + e;
                    } else {
                        i12 = z3 ? this.mVGap : this.mHGap;
                    }
                    e += i12;
                    i6 = mainOrientationHelper.e(l) + e;
                } else {
                    if (z5) {
                        startLine = span4.getStartLine(g2, mainOrientationHelper);
                        i5 = (z3 ? this.mMarginBottom : this.mMarginRight) + this.mPaddingRight;
                    } else {
                        startLine = span4.getStartLine(g2, mainOrientationHelper);
                        i5 = z3 ? this.mVGap : this.mHGap;
                    }
                    int i16 = startLine - i5;
                    i6 = i16;
                    e = i16 - mainOrientationHelper.e(l);
                }
                if (c3287d.f() == 1) {
                    span4.appendToSpan(l, mainOrientationHelper);
                } else {
                    span4.prependToSpan(l, mainOrientationHelper);
                }
                int i17 = span4.mIndex;
                if (i17 == this.mNumLanes - 1) {
                    int i18 = this.mColLength;
                    int i19 = this.mEachGap;
                    i7 = ((i17 * (i18 + i19)) - i19) + this.mLastGap;
                } else {
                    i7 = i17 * (this.mColLength + this.mEachGap);
                }
                int k = i7 + secondaryOrientationHelper.k();
                if (z3) {
                    i8 = this.mMarginLeft;
                    i9 = this.mPaddingLeft;
                } else {
                    i8 = this.mMarginTop;
                    i9 = this.mPaddingTop;
                }
                int i20 = k + i8 + i9;
                int f = i20 + mainOrientationHelper.f(l);
                if (z3) {
                    view = l;
                    i10 = g2;
                    z2 = isEnableMarginOverLap;
                    layoutChildWithMargin(l, i20, e, f, i6, layoutManagerHelper);
                    i11 = i15;
                    span2 = span4;
                    abstractC3291c = mainOrientationHelper;
                } else {
                    view = l;
                    i10 = g2;
                    z2 = isEnableMarginOverLap;
                    int i21 = e;
                    span2 = span4;
                    int i22 = i6;
                    i11 = i15;
                    abstractC3291c = mainOrientationHelper;
                    layoutChildWithMargin(view, i21, i20, i22, f, layoutManagerHelper);
                }
                updateRemainingSpans(span2, c3287d.f(), i11, abstractC3291c);
                recycle(recycler, c3287d, span2, i13, layoutManagerHelper);
                handleStateOnResult(m81Var, view);
                recycler2 = recycler;
                c3287d3 = c3287d;
                i14 = i11;
                mainOrientationHelper = abstractC3291c;
                isEnableMarginOverLap = z2;
                g2 = i10;
                state2 = state;
            }
            AbstractC3291c abstractC3291c2 = mainOrientationHelper;
            if (isOutOfRange(c3287d.c())) {
                if (c3287d.f() == -1) {
                    int length = this.mSpans.length;
                    for (int i23 = 0; i23 < length; i23++) {
                        Span span5 = this.mSpans[i23];
                        int i24 = span5.mCachedStart;
                        if (i24 != Integer.MIN_VALUE) {
                            span5.mLastEdgeStart = i24;
                        }
                    }
                } else {
                    int length2 = this.mSpans.length;
                    for (int i25 = 0; i25 < length2; i25++) {
                        Span span6 = this.mSpans[i25];
                        int i26 = span6.mCachedEnd;
                        if (i26 != Integer.MIN_VALUE) {
                            span6.mLastEdgeEnd = i26;
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
                        m81Var.a = c3287d.g() - getMaxStart(abstractC3291c2.k(), abstractC3291c2);
                    }
                }
                int g3 = c3287d.g() - getMinStart(abstractC3291c2.i(), abstractC3291c2);
                if (z3) {
                    i3 = this.mMarginTop;
                    i4 = this.mPaddingTop;
                } else {
                    i3 = this.mMarginLeft;
                    i4 = this.mPaddingLeft;
                }
                m81Var.a = g3 + i3 + i4;
            } else {
                c3287d2 = c3287d;
                if (!isOutOfRange(c3287d.c()) && c3287d2.h(state)) {
                    m81Var.a = getMinEnd(abstractC3291c2.i(), abstractC3291c2) - c3287d.g();
                } else {
                    int maxEnd = getMaxEnd(abstractC3291c2.i(), abstractC3291c2) - c3287d.g();
                    if (z3) {
                        i = this.mMarginBottom;
                        i2 = this.mPaddingBottom;
                    } else {
                        i = this.mMarginRight;
                        i2 = this.mPaddingRight;
                    }
                    m81Var.a = maxEnd + i + i2;
                }
            }
            recycleForPreLayout(recycler, c3287d2, layoutManagerHelper);
        }
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318757874")) {
            ipChange.ipc$dispatch("318757874", new Object[]{this, layoutManagerHelper});
            return;
        }
        super.onClear(layoutManagerHelper);
        this.mLazySpanLookup.clear();
        this.mSpans = null;
        this.mLayoutManager = null;
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onItemsChanged(LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245787269")) {
            ipChange.ipc$dispatch("245787269", new Object[]{this, layoutManagerHelper});
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onOffsetChildrenHorizontal(int i, LayoutManagerHelper layoutManagerHelper) {
        Span[] spanArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377174998")) {
            ipChange.ipc$dispatch("377174998", new Object[]{this, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenHorizontal(i, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() != 0 || (spanArr = this.mSpans) == null) {
            return;
        }
        int length = spanArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onOffsetChildrenVertical(int i, LayoutManagerHelper layoutManagerHelper) {
        Span[] spanArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604721604")) {
            ipChange.ipc$dispatch("604721604", new Object[]{this, Integer.valueOf(i), layoutManagerHelper});
            return;
        }
        super.onOffsetChildrenVertical(i, layoutManagerHelper);
        if (layoutManagerHelper.getOrientation() != 1 || (spanArr = this.mSpans) == null) {
            return;
        }
        int length = spanArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onRefreshLayout(RecyclerView.State state, VirtualLayoutManager.C3286c c3286c, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836652239")) {
            ipChange.ipc$dispatch("-1836652239", new Object[]{this, state, c3286c, layoutManagerHelper});
            return;
        }
        super.onRefreshLayout(state, c3286c, layoutManagerHelper);
        ensureLanes();
        if (isOutOfRange(c3286c.a)) {
            int length = this.mSpans.length;
            for (int i = 0; i < length; i++) {
                this.mSpans[i].clear();
            }
        }
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onRestoreInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-702241421")) {
            ipChange.ipc$dispatch("-702241421", new Object[]{this, bundle});
            return;
        }
        super.onRestoreInstanceState(bundle);
        this.mLazySpanLookup.mData = bundle.getIntArray(LOOKUP_BUNDLE_KEY);
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onSaveState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975126381")) {
            ipChange.ipc$dispatch("1975126381", new Object[]{this, bundle});
            return;
        }
        super.onSaveState(bundle);
        bundle.putIntArray(LOOKUP_BUNDLE_KEY, this.mLazySpanLookup.mData);
    }

    @Override // com.alibaba.android.vlayout.AbstractC3289a
    public void onScrollStateChanged(int i, int i2, int i3, LayoutManagerHelper layoutManagerHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479499612")) {
            ipChange.ipc$dispatch("479499612", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), layoutManagerHelper});
        } else if (i2 > getRange().e().intValue() || i3 < getRange().d().intValue() || i != 0) {
        } else {
            checkForGaps();
        }
    }

    public void setGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437892247")) {
            ipChange.ipc$dispatch("-1437892247", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setHGap(i);
        setVGap(i);
    }

    public void setHGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1846333001")) {
            ipChange.ipc$dispatch("-1846333001", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHGap = i;
        }
    }

    public void setLane(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502746795")) {
            ipChange.ipc$dispatch("-1502746795", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mNumLanes = i;
        ensureLanes();
    }

    public void setRawLane(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671236935")) {
            ipChange.ipc$dispatch("671236935", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mRawLane = i;
        setLane(i);
    }

    public void setVGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1078175209")) {
            ipChange.ipc$dispatch("1078175209", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mVGap = i;
        }
    }

    public StaggeredGridLayoutHelper(int i) {
        this(i, 0);
    }

    public StaggeredGridLayoutHelper(int i, int i2) {
        this.mNumLanes = 0;
        this.mHGap = 0;
        this.mVGap = 0;
        this.mColLength = 0;
        this.mEachGap = 0;
        this.mLastGap = 0;
        this.mRemainingSpans = null;
        this.mLazySpanLookup = new LazySpanLookup();
        this.preLayoutViewList = new ArrayList();
        this.mLayoutManager = null;
        this.checkForGapsRunnable = new Runnable() { // from class: com.youku.arch.v3.recyclerview.layouthelper.StaggeredGridLayoutHelper.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "339628548")) {
                    ipChange.ipc$dispatch("339628548", new Object[]{this});
                } else {
                    StaggeredGridLayoutHelper.this.checkForGaps();
                }
            }
        };
        setRawLane(i);
        setGap(i2);
    }
}
