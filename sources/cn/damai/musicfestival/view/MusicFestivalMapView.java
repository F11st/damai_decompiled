package cn.damai.musicfestival.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MusicFestivalMapView extends FrameLayout implements Comparator<View> {
    private static transient /* synthetic */ IpChange $ipChange;
    private AbstractC1484b mAdapter;
    private C1486d mRecycleBin;
    private AbstractC1485c mSetObserver;
    private List<View> mSortList;
    private Rect mTemp;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.musicfestival.view.MusicFestivalMapView$a */
    /* loaded from: classes6.dex */
    public class C1483a extends AbstractC1485c {
        private static transient /* synthetic */ IpChange $ipChange;

        C1483a() {
        }

        @Override // cn.damai.musicfestival.view.MusicFestivalMapView.AbstractC1485c
        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-971114286")) {
                ipChange.ipc$dispatch("-971114286", new Object[]{this});
            } else {
                MusicFestivalMapView.this.removeChildThenFillViews();
            }
        }

        @Override // cn.damai.musicfestival.view.MusicFestivalMapView.AbstractC1485c
        public void b(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "109234142")) {
                ipChange.ipc$dispatch("109234142", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            C1487e findChildViewHolder = MusicFestivalMapView.this.findChildViewHolder(i);
            if (findChildViewHolder != null && MusicFestivalMapView.this.mAdapter != null) {
                MusicFestivalMapView.this.mAdapter.f(findChildViewHolder, i);
            }
            MusicFestivalMapView.this.sortChildViewsIfNeed();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.musicfestival.view.MusicFestivalMapView$b */
    /* loaded from: classes15.dex */
    public static abstract class AbstractC1484b<VH extends C1487e> {
        private static transient /* synthetic */ IpChange $ipChange;
        private AbstractC1485c a;

        public void a(AbstractC1485c abstractC1485c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "843488897")) {
                ipChange.ipc$dispatch("843488897", new Object[]{this, abstractC1485c});
            } else {
                this.a = abstractC1485c;
            }
        }

        public abstract int b();

        public int c(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "705255076")) {
                return ((Integer) ipChange.ipc$dispatch("705255076", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            return 0;
        }

        public void d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1142556491")) {
                ipChange.ipc$dispatch("1142556491", new Object[]{this});
                return;
            }
            AbstractC1485c abstractC1485c = this.a;
            if (abstractC1485c != null) {
                abstractC1485c.a();
            }
        }

        public void e(int i) {
            AbstractC1485c abstractC1485c;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1191603937")) {
                ipChange.ipc$dispatch("1191603937", new Object[]{this, Integer.valueOf(i)});
            } else if (i >= 0 && (abstractC1485c = this.a) != null) {
                abstractC1485c.b(i);
            }
        }

        public abstract void f(@NonNull VH vh, int i);

        public abstract VH g(@NonNull ViewGroup viewGroup, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.musicfestival.view.MusicFestivalMapView$c */
    /* loaded from: classes15.dex */
    public static abstract class AbstractC1485c {
        private static transient /* synthetic */ IpChange $ipChange;

        public abstract void a();

        public abstract void b(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.musicfestival.view.MusicFestivalMapView$d */
    /* loaded from: classes15.dex */
    public static class C1486d {
        private static transient /* synthetic */ IpChange $ipChange;
        private final SparseArray<List<C1487e>> a = new SparseArray<>();

        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1677429495")) {
                ipChange.ipc$dispatch("-1677429495", new Object[]{this});
            } else {
                this.a.clear();
            }
        }

        public C1487e b(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-647393450")) {
                return (C1487e) ipChange.ipc$dispatch("-647393450", new Object[]{this, Integer.valueOf(i)});
            }
            List<C1487e> list = this.a.get(i);
            if (cb2.d(list)) {
                return null;
            }
            return list.remove(list.size() - 1);
        }

        public void c(View view) {
            C1487e c1487e;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-216673983")) {
                ipChange.ipc$dispatch("-216673983", new Object[]{this, view});
            } else if (view.getParent() != null) {
            } else {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof MfmLayoutParams) {
                    MfmLayoutParams mfmLayoutParams = (MfmLayoutParams) layoutParams;
                    if (mfmLayoutParams.markUnRecycler || (c1487e = mfmLayoutParams.mViewHolder) == null) {
                        return;
                    }
                    int i = c1487e.a;
                    List<C1487e> list = this.a.get(i);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.a.put(i, list);
                    }
                    list.add(c1487e);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.musicfestival.view.MusicFestivalMapView$e */
    /* loaded from: classes15.dex */
    public static class C1487e {
        public static final int NO_POS = -1;
        public static final int NO_VIEW_TYPE = -1;
        public int a = -1;
        public int b = -1;
        public final View c;

        public C1487e(View view) {
            this.c = view;
            view.setTag(this);
        }
    }

    public MusicFestivalMapView(@NonNull Context context) {
        super(context);
        this.mRecycleBin = new C1486d();
        this.mSortList = new ArrayList(30);
        this.mTemp = new Rect();
        this.mSetObserver = new C1483a();
    }

    private void ensureLayoutParams(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972859094")) {
            ipChange.ipc$dispatch("-1972859094", new Object[]{this, view});
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(generateDefaultLayoutParams());
        } else if (layoutParams instanceof MfmLayoutParams) {
        } else {
            view.setLayoutParams(generateLayoutParams(layoutParams));
        }
    }

    private void layoutChildAsFrameLayout(View view, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734036271")) {
            ipChange.ipc$dispatch("1734036271", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = layoutParams.gravity;
        if (i7 == -1) {
            i7 = BadgeDrawable.TOP_START;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i7, getLayoutDirection());
        int i8 = i7 & 112;
        int i9 = absoluteGravity & 7;
        if (i9 == 1) {
            i5 = ((paddingLeft + (((paddingRight - paddingLeft) - measuredWidth) / 2)) + layoutParams.leftMargin) - layoutParams.rightMargin;
        } else if (i9 != 5) {
            i5 = paddingLeft + layoutParams.leftMargin;
        } else {
            i5 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
        }
        if (i8 == 16) {
            i6 = ((paddingTop + (((paddingBottom - paddingTop) - measuredHeight) / 2)) + layoutParams.topMargin) - layoutParams.bottomMargin;
        } else if (i8 != 80) {
            i6 = paddingTop + layoutParams.topMargin;
        } else {
            i6 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
        }
        view.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeChildThenFillViews() {
        int b;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717054304")) {
            ipChange.ipc$dispatch("-717054304", new Object[]{this});
            return;
        }
        removeAllViews();
        AbstractC1484b abstractC1484b = this.mAdapter;
        if (abstractC1484b != null && (b = abstractC1484b.b()) > 0) {
            this.mSortList.clear();
            for (int i = 0; i < b; i++) {
                int c = this.mAdapter.c(i);
                C1487e b2 = this.mRecycleBin.b(c);
                if (b2 == null) {
                    b2 = this.mAdapter.g(this, c);
                }
                this.mAdapter.f(b2, i);
                ensureLayoutParams(b2.c);
                MfmLayoutParams mfmLayoutParams = (MfmLayoutParams) b2.c.getLayoutParams();
                mfmLayoutParams.mViewHolder = b2;
                mfmLayoutParams.eatAxisZChanged();
                b2.a = c;
                b2.b = i;
                this.mSortList.add(b2.c);
            }
            Collections.sort(this.mSortList, this);
            for (View view : this.mSortList) {
                addView(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortChildViewsIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2060886675")) {
            ipChange.ipc$dispatch("2060886675", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0 && isChildAxisZChanged()) {
            this.mSortList.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                ((MfmLayoutParams) childAt.getLayoutParams()).markUnRecycler = true;
                this.mSortList.add(childAt);
            }
            Collections.sort(this.mSortList, this);
            removeAllViews();
            for (View view : this.mSortList) {
                MfmLayoutParams mfmLayoutParams = (MfmLayoutParams) view.getLayoutParams();
                mfmLayoutParams.markUnRecycler = false;
                mfmLayoutParams.eatAxisZChanged();
                addView(view);
            }
        }
    }

    public C1487e findChildViewHolder(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687949664")) {
            return (C1487e) ipChange.ipc$dispatch("1687949664", new Object[]{this, Integer.valueOf(i)});
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                C1487e c1487e = ((MfmLayoutParams) getChildAt(i2).getLayoutParams()).mViewHolder;
                if (c1487e != null && c1487e.b == i) {
                    return c1487e;
                }
            }
            return null;
        }
        return null;
    }

    public C1487e getViewHolder(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792709278")) {
            return (C1487e) ipChange.ipc$dispatch("-1792709278", new Object[]{this, view});
        }
        if (view != null) {
            Object tag = view.getTag();
            if (tag instanceof C1487e) {
                return (C1487e) tag;
            }
            return null;
        }
        return null;
    }

    public boolean isChildAxisZChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691289355")) {
            return ((Boolean) ipChange.ipc$dispatch("691289355", new Object[]{this})).booleanValue();
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && ((MfmLayoutParams) childAt.getLayoutParams()).isAxisZChanged()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1373392615")) {
            ipChange.ipc$dispatch("1373392615", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                MfmLayoutParams mfmLayoutParams = (MfmLayoutParams) childAt.getLayoutParams();
                if (mfmLayoutParams.layoutAsFrameLayout) {
                    layoutChildAsFrameLayout(childAt, i, i2, i3, i4);
                } else {
                    int measuredHeight = childAt.getMeasuredHeight();
                    int measuredWidth = childAt.getMeasuredWidth();
                    float f = mfmLayoutParams.xRatioInWidth;
                    float f2 = mfmLayoutParams.yRatioInHeight;
                    int i7 = ((int) ((f * width) - (measuredWidth / 2.0f))) - mfmLayoutParams.leftOffsetInRatioMode;
                    int i8 = measuredWidth + i7;
                    int i9 = (int) (f2 * height);
                    int i10 = i9 - measuredHeight;
                    this.mTemp.set(i7, i10, i8, i9);
                    if (i7 < paddingLeft) {
                        i5 = 0;
                        this.mTemp.offset(paddingLeft - i7, 0);
                    } else {
                        i5 = 0;
                    }
                    if (i10 < paddingTop) {
                        this.mTemp.offset(i5, paddingTop - i10);
                    }
                    int i11 = width - paddingRight;
                    if (i8 > i11) {
                        this.mTemp.offset(i11 - i8, i5);
                    }
                    int i12 = height - paddingBottom;
                    if (i9 > i12) {
                        this.mTemp.offset(i5, i12 - i9);
                    }
                    Rect rect = this.mTemp;
                    childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "873076666")) {
            ipChange.ipc$dispatch("873076666", new Object[]{this, view});
            return;
        }
        super.onViewRemoved(view);
        this.mRecycleBin.c(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084066555")) {
            ipChange.ipc$dispatch("2084066555", new Object[]{this});
            return;
        }
        sortChildViewsIfNeed();
        super.requestLayout();
    }

    public void setAdapter(AbstractC1484b abstractC1484b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914181693")) {
            ipChange.ipc$dispatch("1914181693", new Object[]{this, abstractC1484b});
            return;
        }
        AbstractC1484b abstractC1484b2 = this.mAdapter;
        this.mAdapter = abstractC1484b;
        removeAllViews();
        this.mRecycleBin.a();
        if (abstractC1484b2 != null) {
            abstractC1484b2.a(null);
        }
        AbstractC1484b abstractC1484b3 = this.mAdapter;
        if (abstractC1484b3 != null) {
            abstractC1484b3.a(this.mSetObserver);
            this.mAdapter.d();
        }
    }

    @Override // java.util.Comparator
    public int compare(View view, View view2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "867836386") ? ((Integer) ipChange.ipc$dispatch("867836386", new Object[]{this, view, view2})).intValue() : ((MfmLayoutParams) view.getLayoutParams()).axisZ - ((MfmLayoutParams) view2.getLayoutParams()).axisZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1924820159") ? (FrameLayout.LayoutParams) ipChange.ipc$dispatch("-1924820159", new Object[]{this}) : new MfmLayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1241294727") ? (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-1241294727", new Object[]{this, layoutParams}) : new MfmLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1171996314") ? (FrameLayout.LayoutParams) ipChange.ipc$dispatch("-1171996314", new Object[]{this, attributeSet}) : new MfmLayoutParams(getContext(), attributeSet);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class MfmLayoutParams extends FrameLayout.LayoutParams {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final int DEFAULT_LP_AXIS_Z = 0;
        public int axisZ;
        public int lastAxisZ;
        public boolean layoutAsFrameLayout;
        public int leftOffsetInRatioMode;
        public C1487e mViewHolder;
        public boolean markUnRecycler;
        public float xRatioInWidth;
        public float yRatioInHeight;

        public MfmLayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.leftOffsetInRatioMode = 0;
            this.axisZ = 0;
            this.lastAxisZ = 0;
            this.markUnRecycler = false;
            this.layoutAsFrameLayout = false;
        }

        public static void setLocationAndZ(ViewGroup.LayoutParams layoutParams, float f, float f2, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1961295773")) {
                ipChange.ipc$dispatch("-1961295773", new Object[]{layoutParams, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
            } else if (layoutParams instanceof MfmLayoutParams) {
                MfmLayoutParams mfmLayoutParams = (MfmLayoutParams) layoutParams;
                mfmLayoutParams.xRatioInWidth = f;
                mfmLayoutParams.yRatioInHeight = f2;
                mfmLayoutParams.leftOffsetInRatioMode = i2;
                mfmLayoutParams.setAxisZ(i);
            }
        }

        public void eatAxisZChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2071046113")) {
                ipChange.ipc$dispatch("2071046113", new Object[]{this});
            } else {
                this.lastAxisZ = this.axisZ;
            }
        }

        public boolean isAxisZChanged() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-53425355") ? ((Boolean) ipChange.ipc$dispatch("-53425355", new Object[]{this})).booleanValue() : this.axisZ != this.lastAxisZ;
        }

        public void setAxisZ(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1977531364")) {
                ipChange.ipc$dispatch("1977531364", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.axisZ = i;
            }
        }

        public MfmLayoutParams(int i, int i2) {
            super(i, i2);
            this.leftOffsetInRatioMode = 0;
            this.axisZ = 0;
            this.lastAxisZ = 0;
            this.markUnRecycler = false;
            this.layoutAsFrameLayout = false;
        }

        public MfmLayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.leftOffsetInRatioMode = 0;
            this.axisZ = 0;
            this.lastAxisZ = 0;
            this.markUnRecycler = false;
            this.layoutAsFrameLayout = false;
        }
    }

    public MusicFestivalMapView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRecycleBin = new C1486d();
        this.mSortList = new ArrayList(30);
        this.mTemp = new Rect();
        this.mSetObserver = new C1483a();
    }

    public MusicFestivalMapView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRecycleBin = new C1486d();
        this.mSortList = new ArrayList(30);
        this.mTemp = new Rect();
        this.mSetObserver = new C1483a();
    }
}
