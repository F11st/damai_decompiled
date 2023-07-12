package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$styleable;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class NineGridView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_COUNT = 9;
    private static final String TAG = "NineGridView";
    private boolean isPrintLog;
    private AbstractC2586a mAdapter;
    private int mChildSpacingPx;
    private Path mCornerRadiusPath;
    private int mCornerRadiusPx;
    private RectF mLastRectF;
    private C2589d mObserver;
    private C2587b mRecycler;
    private RectF mTempRectF;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ViewChangedObserver {
        void notifyDataSetChanged();

        void notifyItemChanged(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.NineGridView$a */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC2586a<VH extends C2588c> {
        private static transient /* synthetic */ IpChange $ipChange;
        private ViewChangedObserver a;

        public final void a(boolean z, ViewChangedObserver viewChangedObserver) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-334004479")) {
                ipChange.ipc$dispatch("-334004479", new Object[]{this, Boolean.valueOf(z), viewChangedObserver});
            } else if (z) {
                this.a = viewChangedObserver;
            } else {
                this.a = null;
            }
        }

        public abstract void b(VH vh, int i);

        public abstract VH c(@NonNull ViewGroup viewGroup, int i);

        public final VH d(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1001145769")) {
                return (VH) ipChange.ipc$dispatch("1001145769", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            VH c = c(viewGroup, i);
            if (c != null) {
                c.b = i;
            }
            return c;
        }

        public abstract int e();

        public int f(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-858475936")) {
                return ((Integer) ipChange.ipc$dispatch("-858475936", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            return 0;
        }

        public final void g() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1543126586")) {
                ipChange.ipc$dispatch("1543126586", new Object[]{this});
                return;
            }
            ViewChangedObserver viewChangedObserver = this.a;
            if (viewChangedObserver != null) {
                viewChangedObserver.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.NineGridView$b */
    /* loaded from: classes8.dex */
    public class C2587b {
        private static transient /* synthetic */ IpChange $ipChange;
        private final HashMap<Integer, List<C2588c>> a = new HashMap<>();

        public C2587b() {
        }

        public C2588c a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-106123445")) {
                return (C2588c) ipChange.ipc$dispatch("-106123445", new Object[]{this, Integer.valueOf(i)});
            }
            List<C2588c> list = this.a.get(Integer.valueOf(i));
            if (list == null || list.size() <= 0) {
                return null;
            }
            Iterator<C2588c> it = list.iterator();
            while (it.hasNext()) {
                C2588c next = it.next();
                if (next.a.getParent() == null) {
                    it.remove();
                    return next;
                }
                it.remove();
            }
            return null;
        }

        public void b(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-199952")) {
                ipChange.ipc$dispatch("-199952", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag(R$id.id_nine_grid_child_tag);
            if (tag instanceof C2588c) {
                C2588c c2588c = (C2588c) tag;
                List<C2588c> list = this.a.get(Integer.valueOf(c2588c.b));
                if (list == null) {
                    list = new ArrayList<>(9);
                    this.a.put(Integer.valueOf(c2588c.b), list);
                }
                if (list.contains(c2588c)) {
                    return;
                }
                if (NineGridView.this.isPrintLog) {
                    NineGridView nineGridView = NineGridView.this;
                    nineGridView.printLog("Recycler collect viewHolder hash=" + c2588c.hashCode());
                }
                list.add(c2588c);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.NineGridView$c */
    /* loaded from: classes8.dex */
    public static class C2588c {
        public final View a;
        public int b = -1;

        public C2588c(View view) {
            this.a = view;
            view.setTag(R$id.id_nine_grid_child_tag, this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.NineGridView$d */
    /* loaded from: classes8.dex */
    public class C2589d implements ViewChangedObserver {
        private static transient /* synthetic */ IpChange $ipChange;

        public C2589d() {
        }

        @Override // cn.damai.uikit.view.NineGridView.ViewChangedObserver
        public void notifyDataSetChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1443113704")) {
                ipChange.ipc$dispatch("-1443113704", new Object[]{this});
            } else {
                NineGridView.this.notifyDataSetChanged();
            }
        }

        @Override // cn.damai.uikit.view.NineGridView.ViewChangedObserver
        public void notifyItemChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "44780526")) {
                ipChange.ipc$dispatch("44780526", new Object[]{this, Integer.valueOf(i)});
            }
        }
    }

    public NineGridView(@NonNull Context context) {
        this(context, null);
    }

    public static String mode2NameStr(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-303791078") ? (String) ipChange.ipc$dispatch("-303791078", new Object[]{Integer.valueOf(i)}) : i != Integer.MIN_VALUE ? i != 1073741824 ? "UNSPECIFIED" : "EXACTLY" : "AT_MOST";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402191983")) {
            ipChange.ipc$dispatch("402191983", new Object[]{this});
            return;
        }
        removeAllViews();
        AbstractC2586a abstractC2586a = this.mAdapter;
        if (abstractC2586a == null) {
            return;
        }
        int min = Math.min(9, abstractC2586a.e());
        for (int i = 0; i < min; i++) {
            int f = this.mAdapter.f(i);
            C2588c a = this.mRecycler.a(f);
            boolean z = a != null;
            if (a == null) {
                a = this.mAdapter.d(this, f);
            }
            if (a != null) {
                addView(a.a);
                this.mAdapter.b(a, i);
            }
            if (this.isPrintLog) {
                if (z) {
                    printLog("NotifyDataSetChanged use cache holder pos=" + i + " hash=" + a.hashCode());
                } else {
                    printLog("NotifyDataSetChanged create new viewHolder pos=" + i + " hash=" + a.hashCode());
                }
            }
        }
    }

    private void prepareClipRadiusPathIfAllow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685095830")) {
            ipChange.ipc$dispatch("685095830", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0 && this.mCornerRadiusPx > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (i == 0) {
                    this.mTempRectF.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                } else {
                    this.mTempRectF.left = Math.min(childAt.getLeft(), this.mTempRectF.left);
                    this.mTempRectF.top = Math.min(childAt.getTop(), this.mTempRectF.top);
                    this.mTempRectF.right = Math.max(childAt.getRight(), this.mTempRectF.right);
                    this.mTempRectF.bottom = Math.max(childAt.getBottom(), this.mTempRectF.bottom);
                }
            }
            if (this.mTempRectF.equals(this.mLastRectF)) {
                return;
            }
            this.mLastRectF.set(this.mTempRectF);
            Path path = new Path();
            this.mCornerRadiusPath = path;
            RectF rectF = this.mTempRectF;
            int i2 = this.mCornerRadiusPx;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            return;
        }
        this.mCornerRadiusPath = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printLog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531919929")) {
            ipChange.ipc$dispatch("-1531919929", new Object[]{this, str});
        } else if (this.isPrintLog) {
            Log.e(TAG, str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923891889")) {
            ipChange.ipc$dispatch("-1923891889", new Object[]{this, canvas});
            return;
        }
        prepareClipRadiusPathIfAllow();
        if (this.mCornerRadiusPath != null) {
            canvas.save();
            canvas.clipPath(this.mCornerRadiusPath);
        }
        super.dispatchDraw(canvas);
        if (this.mCornerRadiusPath != null) {
            canvas.restore();
        }
    }

    public void enableLog(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146668801")) {
            ipChange.ipc$dispatch("-2146668801", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isPrintLog = z;
        }
    }

    public void notifyItemChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815868155")) {
            ipChange.ipc$dispatch("-815868155", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1681769737")) {
            ipChange.ipc$dispatch("1681769737", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        if (childCount <= 1) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int i5 = childCount == 4 ? 2 : 3;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (i9 != 0 && i9 % i5 == 0) {
                i6 += i7 + this.mChildSpacingPx;
                i7 = 0;
                i8 = 0;
            }
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            childAt.layout(i8, i6, i8 + measuredWidth, i6 + measuredHeight);
            i8 += measuredWidth + this.mChildSpacingPx;
            i7 = Math.max(i7, measuredHeight);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407229079")) {
            ipChange.ipc$dispatch("1407229079", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int childCount = getChildCount();
        printLog("NineGView onMeasure  childCount=" + childCount);
        if (childCount <= 1) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            i3 = size;
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            i3 = size2;
        } else {
            i3 = getContext() != null ? DisplayMetrics.getwidthPixels(l62.b(getContext())) : 0;
        }
        int i4 = (int) ((i3 - (this.mChildSpacingPx * 2)) / 3.0f);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        int i5 = childCount == 4 ? 2 : 3;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            childAt.measure(makeMeasureSpec, makeMeasureSpec2);
            if (i8 < i5) {
                i6 += childAt.getMeasuredWidth() + this.mChildSpacingPx;
            }
            if (i8 % i5 == 0) {
                i7 += childAt.getMeasuredHeight() + this.mChildSpacingPx;
            }
        }
        int i9 = this.mChildSpacingPx;
        int i10 = i6 - i9;
        int i11 = i7 - i9;
        int resolveSize = FrameLayout.resolveSize(i10, i);
        int resolveSize2 = FrameLayout.resolveSize(i11, i2);
        printLog("onMeasure wMode=" + mode2NameStr(mode) + " wSize=" + size + " hMode=" + mode2NameStr(mode2) + " hSize=" + size2);
        printLog("onMeasure childUseWidth=" + i10 + " childUseHeight=" + i11 + " finalW=" + resolveSize + " finalH=" + resolveSize2);
        setMeasuredDimension(resolveSize, resolveSize2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018990680")) {
            ipChange.ipc$dispatch("2018990680", new Object[]{this, view});
        } else {
            this.mRecycler.b(view);
        }
    }

    public void setAdapter(AbstractC2586a abstractC2586a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681346612")) {
            ipChange.ipc$dispatch("-1681346612", new Object[]{this, abstractC2586a});
            return;
        }
        AbstractC2586a abstractC2586a2 = this.mAdapter;
        if (abstractC2586a2 != null) {
            abstractC2586a2.a(false, null);
        }
        this.mAdapter = abstractC2586a;
        if (abstractC2586a != null) {
            abstractC2586a.a(true, this.mObserver);
        }
        notifyDataSetChanged();
    }

    public NineGridView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-916071453") ? (FrameLayout.LayoutParams) ipChange.ipc$dispatch("-916071453", new Object[]{this}) : new FrameLayout.LayoutParams(-2, -2);
    }

    public NineGridView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRecycler = new C2587b();
        this.mObserver = new C2589d();
        this.mTempRectF = new RectF();
        this.mLastRectF = new RectF();
        this.isPrintLog = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NineGridView);
        this.mCornerRadiusPx = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_clip_children_bound_radius, 0);
        this.mChildSpacingPx = obtainStyledAttributes.getDimensionPixelSize(R$styleable.NineGridView_nine_child_spacing, 0);
        obtainStyledAttributes.recycle();
    }
}
