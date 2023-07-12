package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ExpandFlowLayout<T> extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ZIP_LINE_COUNT = 2;
    public static final Rect mTemp = new Rect();
    private boolean isExpand;
    private a<T> mAdapter;
    private ExpandBtnView mBtnViewImpl;
    private View mExpandBtnView;
    private final List<b> mLineViewsList;
    private final Pools.SimplePool<b> mPool;
    private final Stack<View> mRemovedViewStack;
    private final List<b> mTempList;
    private final List<View> mViewShouldBeRemovedList;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ExpandBtnView {
        View getExpandBtnView();

        void setExpand(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class a<T> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final List<T> a = new ArrayList();
        private ExpandFlowLayout<T> b;

        public T a(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "11789420") ? (T) ipChange.ipc$dispatch("11789420", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i);
        }

        public int b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1161781903") ? ((Integer) ipChange.ipc$dispatch("-1161781903", new Object[]{this})).intValue() : this.a.size();
        }

        public abstract View c(ViewGroup viewGroup, View view, T t, int i);

        public void d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987430070")) {
                ipChange.ipc$dispatch("1987430070", new Object[]{this});
            } else {
                this.b = null;
            }
        }

        public void e(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "810510378")) {
                ipChange.ipc$dispatch("810510378", new Object[]{this, Boolean.valueOf(z)});
            } else {
                this.b.setExpand(z);
            }
        }

        public void f(ExpandFlowLayout<T> expandFlowLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-822420139")) {
                ipChange.ipc$dispatch("-822420139", new Object[]{this, expandFlowLayout});
            } else {
                this.b = expandFlowLayout;
            }
        }

        public void g(List<T> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1333906676")) {
                ipChange.ipc$dispatch("-1333906676", new Object[]{this, list});
                return;
            }
            this.a.clear();
            if (list != null && list.size() > 0) {
                this.a.addAll(list);
            }
            ExpandFlowLayout<T> expandFlowLayout = this.b;
            if (expandFlowLayout != null) {
                expandFlowLayout.requestLayout();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        public final ArrayList<View> a = new ArrayList<>();
        public int b;

        public void a(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-968428322")) {
                ipChange.ipc$dispatch("-968428322", new Object[]{this, view});
            } else {
                this.a.add(view);
            }
        }

        public int b() {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1542114250")) {
                return ((Integer) ipChange.ipc$dispatch("-1542114250", new Object[]{this})).intValue();
            }
            Iterator<View> it = this.a.iterator();
            while (it.hasNext()) {
                Rect rect = ExpandFlowLayout.mTemp;
                ExpandFlowLayout.computeViewBound(it.next(), rect);
                i += com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect);
            }
            return i;
        }

        public void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1142592506")) {
                ipChange.ipc$dispatch("-1142592506", new Object[]{this});
                return;
            }
            this.a.clear();
            this.b = 0;
        }

        public int d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1660845177") ? ((Integer) ipChange.ipc$dispatch("-1660845177", new Object[]{this})).intValue() : this.a.size();
        }

        public void e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2141699887")) {
                ipChange.ipc$dispatch("-2141699887", new Object[]{this});
                return;
            }
            this.b = 0;
            if (this.a.size() > 0) {
                Iterator<View> it = this.a.iterator();
                while (it.hasNext()) {
                    Rect rect = ExpandFlowLayout.mTemp;
                    ExpandFlowLayout.computeViewBound(it.next(), rect);
                    this.b = Math.max(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect), this.b);
                }
            }
        }
    }

    public ExpandFlowLayout(@NonNull Context context) {
        this(context, null);
    }

    private b acquireEmptyLine() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1027245145")) {
            return (b) ipChange.ipc$dispatch("-1027245145", new Object[]{this});
        }
        b acquire = this.mPool.acquire();
        if (acquire == null) {
            return new b();
        }
        acquire.c();
        return acquire;
    }

    public static void computeViewBound(View view, Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937583790")) {
            ipChange.ipc$dispatch("1937583790", new Object[]{view, rect});
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i = marginLayoutParams.topMargin;
        rect.set(0, 0, measuredWidth + marginLayoutParams.rightMargin + marginLayoutParams.leftMargin, measuredHeight + i + marginLayoutParams.bottomMargin);
    }

    private void onLayoutInner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2129216044")) {
            ipChange.ipc$dispatch("-2129216044", new Object[]{this});
            return;
        }
        int size = this.mLineViewsList.size();
        if (size <= 0) {
            return;
        }
        int paddingTop = getPaddingTop();
        for (int i = 0; i < size; i++) {
            b bVar = this.mLineViewsList.get(i);
            if (bVar != null && bVar.d() != 0) {
                int d = bVar.d();
                ArrayList<View> arrayList = bVar.a;
                int paddingLeft = getPaddingLeft();
                for (int i2 = 0; i2 < d; i2++) {
                    View view = arrayList.get(i2);
                    Rect rect = mTemp;
                    computeViewBound(view, rect);
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i3 = marginLayoutParams.topMargin + paddingTop;
                    int i4 = marginLayoutParams.leftMargin + paddingLeft;
                    view.layout(i4, i3, measuredWidth + i4, measuredHeight + i3);
                    paddingLeft += com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect);
                }
                paddingTop += bVar.b;
            }
        }
    }

    private void releaseViewLine(List<b> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236754062")) {
            ipChange.ipc$dispatch("-1236754062", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            for (b bVar : list) {
                bVar.c();
                this.mPool.release(bVar);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168946284")) {
            ipChange.ipc$dispatch("-1168946284", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        try {
            onLayoutInner();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "237783522")) {
            ipChange.ipc$dispatch("237783522", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        try {
            removeAllViews();
            this.mViewShouldBeRemovedList.clear();
            releaseViewLine(this.mLineViewsList);
            this.mLineViewsList.clear();
            a<T> aVar = this.mAdapter;
            if (aVar != null && aVar.b() > 0) {
                int b2 = this.mAdapter.b();
                for (int i3 = 0; i3 < b2; i3++) {
                    T a2 = this.mAdapter.a(i3);
                    View view = null;
                    if (!this.mRemovedViewStack.empty()) {
                        view = this.mRemovedViewStack.pop();
                    }
                    addView(this.mAdapter.c(this, view, a2, i3));
                }
                View view2 = this.mExpandBtnView;
                if (view2 != null) {
                    addView(view2);
                }
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    measureChild(getChildAt(i4), i, i2);
                }
                int size = View.MeasureSpec.getSize(i);
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                b acquireEmptyLine = acquireEmptyLine();
                this.mLineViewsList.add(acquireEmptyLine);
                int i5 = paddingLeft;
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = getChildAt(i6);
                    Rect rect = mTemp;
                    computeViewBound(childAt, rect);
                    int width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect);
                    if (width > i5 && acquireEmptyLine.d() > 0) {
                        acquireEmptyLine = acquireEmptyLine();
                        this.mLineViewsList.add(acquireEmptyLine);
                        i5 = paddingLeft;
                    }
                    acquireEmptyLine.a(childAt);
                    i5 -= width;
                    acquireEmptyLine.b = Math.max(acquireEmptyLine.b, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect));
                }
                int size2 = this.mLineViewsList.size();
                if (!this.isExpand && size2 >= 2) {
                    this.mTempList.clear();
                    for (int i7 = 0; i7 < size2; i7++) {
                        b bVar = this.mLineViewsList.get(i7);
                        if (i7 < 2) {
                            this.mTempList.add(bVar);
                        } else {
                            this.mViewShouldBeRemovedList.addAll(bVar.a);
                        }
                    }
                    this.mLineViewsList.clear();
                    this.mLineViewsList.addAll(this.mTempList);
                }
                List<b> list = this.mLineViewsList;
                b bVar2 = list.get(list.size() - 1);
                ArrayList<View> arrayList = bVar2.a;
                View view3 = this.mExpandBtnView;
                if (view3 != null) {
                    if (this.isExpand) {
                        boolean z2 = size2 <= 2;
                        if (size2 != 3 || bVar2.d() != 1) {
                            z = false;
                        }
                        if ((z2 || z) && arrayList.contains(this.mExpandBtnView)) {
                            arrayList.remove(this.mExpandBtnView);
                            if (bVar2.d() == 0) {
                                this.mLineViewsList.remove(bVar2);
                            } else {
                                bVar2.e();
                            }
                            this.mViewShouldBeRemovedList.add(this.mExpandBtnView);
                        }
                    } else if (size2 <= 2) {
                        if (arrayList.contains(view3)) {
                            arrayList.remove(this.mExpandBtnView);
                            if (bVar2.d() == 0) {
                                this.mLineViewsList.remove(bVar2);
                            } else {
                                bVar2.e();
                            }
                            this.mViewShouldBeRemovedList.add(this.mExpandBtnView);
                        }
                    } else if (this.mViewShouldBeRemovedList.size() > 1 && this.mViewShouldBeRemovedList.contains(this.mExpandBtnView)) {
                        View view4 = this.mExpandBtnView;
                        Rect rect2 = mTemp;
                        computeViewBound(view4, rect2);
                        int width2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2);
                        int b3 = paddingLeft - bVar2.b();
                        if (bVar2.d() > 0 && b3 < width2) {
                            ListIterator<View> listIterator = arrayList.listIterator(bVar2.d());
                            while (listIterator.hasPrevious()) {
                                View previous = listIterator.previous();
                                Rect rect3 = mTemp;
                                computeViewBound(previous, rect3);
                                b3 += com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect3);
                                listIterator.remove();
                                this.mViewShouldBeRemovedList.add(previous);
                                if (b3 >= width2) {
                                    break;
                                }
                            }
                        }
                        arrayList.add(this.mExpandBtnView);
                        bVar2.e();
                        this.mViewShouldBeRemovedList.remove(this.mExpandBtnView);
                    }
                }
                int size3 = this.mViewShouldBeRemovedList.size();
                if (size3 > 0) {
                    for (int i8 = 0; i8 < size3; i8++) {
                        removeView(this.mViewShouldBeRemovedList.get(i8));
                    }
                }
                if (View.MeasureSpec.getMode(i2) == 1073741824) {
                    paddingTop = View.MeasureSpec.getSize(i2);
                } else {
                    paddingTop = getPaddingTop() + getPaddingBottom();
                    int size4 = this.mLineViewsList.size();
                    for (int i9 = 0; i9 < size4; i9++) {
                        paddingTop += this.mLineViewsList.get(i9).b;
                    }
                }
                setMeasuredDimension(size, paddingTop);
                return;
            }
            super.onMeasure(i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933015533")) {
            ipChange.ipc$dispatch("1933015533", new Object[]{this, view});
        } else if (this.mExpandBtnView != view) {
            this.mRemovedViewStack.add(view);
        }
    }

    public void setAdapter(a<T> aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309995588")) {
            ipChange.ipc$dispatch("-1309995588", new Object[]{this, aVar});
            return;
        }
        a<T> aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.d();
        }
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.f(this);
        }
        requestLayout();
    }

    public void setExpand(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834226607")) {
            ipChange.ipc$dispatch("834226607", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isExpand = z;
        ExpandBtnView expandBtnView = this.mBtnViewImpl;
        if (expandBtnView != null) {
            expandBtnView.setExpand(z);
        }
        requestLayout();
    }

    public void setExpandBtnView(ExpandBtnView expandBtnView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465342076")) {
            ipChange.ipc$dispatch("1465342076", new Object[]{this, expandBtnView});
            return;
        }
        this.mBtnViewImpl = expandBtnView;
        if (expandBtnView == null) {
            this.mExpandBtnView = null;
        } else {
            this.mExpandBtnView = expandBtnView.getExpandBtnView();
        }
    }

    public ExpandFlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandFlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isExpand = false;
        this.mRemovedViewStack = new Stack<>();
        this.mLineViewsList = new ArrayList();
        this.mViewShouldBeRemovedList = new ArrayList();
        this.mTempList = new ArrayList();
        this.mPool = new Pools.SimplePool<>(10);
    }
}
