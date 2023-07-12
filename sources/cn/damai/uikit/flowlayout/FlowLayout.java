package cn.damai.uikit.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import cn.damai.common.DamaiConstants;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FlowLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int HORIZONTAL = 0;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int VERTICAL = 1;
    private final LayoutConfiguration config;
    protected List<a> lines;
    private int showLineLimit;
    private boolean singleLine;

    public FlowLayout(Context context) {
        super(context);
        this.singleLine = false;
        this.lines = new ArrayList();
        this.showLineLimit = Integer.MAX_VALUE;
        this.config = new LayoutConfiguration(context, null);
    }

    private void applyGravityToLine(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713050234")) {
            ipChange.ipc$dispatch("-1713050234", new Object[]{this, aVar});
            return;
        }
        List<View> j = aVar.j();
        int size = j.size();
        if (size <= 0) {
            return;
        }
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            f += getWeight((LayoutParams) j.get(i).getLayoutParams());
        }
        LayoutParams layoutParams = (LayoutParams) j.get(size - 1).getLayoutParams();
        int f2 = aVar.f() - (layoutParams.f() + layoutParams.d());
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            LayoutParams layoutParams2 = (LayoutParams) j.get(i3).getLayoutParams();
            float weight = getWeight(layoutParams2);
            int gravity = getGravity(layoutParams2);
            int round = Math.round((f2 * weight) / f);
            int f3 = layoutParams2.f() + layoutParams2.g();
            int i4 = layoutParams2.i() + layoutParams2.h();
            Rect rect = new Rect();
            rect.top = 0;
            rect.left = i2;
            rect.right = f3 + round + i2;
            rect.bottom = aVar.i();
            Rect rect2 = new Rect();
            Gravity.apply(gravity, f3, i4, rect, rect2);
            i2 += round;
            layoutParams2.l(rect2.left + layoutParams2.d());
            layoutParams2.m(rect2.top);
            layoutParams2.n(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2) - layoutParams2.g());
            layoutParams2.p(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) - layoutParams2.h());
        }
    }

    private void applyGravityToLines(List<a> list, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653739269")) {
            ipChange.ipc$dispatch("-653739269", new Object[]{this, list, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = list.size();
        if (size <= 0) {
            return;
        }
        a aVar = list.get(size - 1);
        int i3 = i2 - (aVar.i() + aVar.h());
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            a aVar2 = list.get(i5);
            int gravity = getGravity();
            int round = Math.round((i3 * 1) / size);
            int f = aVar2.f();
            int i6 = aVar2.i();
            Rect rect = new Rect();
            rect.top = i4;
            rect.left = 0;
            rect.right = i;
            rect.bottom = i6 + round + i4;
            Rect rect2 = new Rect();
            Gravity.apply(gravity, f, i6, rect, rect2);
            i4 += round;
            aVar2.a(rect2.left);
            aVar2.b(rect2.top);
            aVar2.k(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2));
            aVar2.l(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2));
        }
    }

    private void applyPositionsToViews(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105311280")) {
            ipChange.ipc$dispatch("-2105311280", new Object[]{this, aVar});
            return;
        }
        List<View> j = aVar.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            View view = j.get(i);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.config.c() == 0) {
                layoutParams.o(getPaddingLeft() + aVar.g() + layoutParams.d(), getPaddingTop() + aVar.h() + layoutParams.e());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.f(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.i(), 1073741824));
            } else {
                layoutParams.o(getPaddingLeft() + aVar.h() + layoutParams.e(), getPaddingTop() + aVar.g() + layoutParams.d());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.i(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.f(), 1073741824));
            }
        }
    }

    private void calculateLinesAndChildPosition(List<a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917089958")) {
            ipChange.ipc$dispatch("917089958", new Object[]{this, list});
            return;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = list.get(i2);
            aVar.b(i);
            i += aVar.i();
            List<View> j = aVar.j();
            int size2 = j.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                LayoutParams layoutParams = (LayoutParams) j.get(i4).getLayoutParams();
                layoutParams.l(i3);
                i3 += layoutParams.f() + layoutParams.g();
            }
        }
    }

    private Paint createPaint(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018346260")) {
            return (Paint) ipChange.ipc$dispatch("1018346260", new Object[]{this, Integer.valueOf(i)});
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    private void drawDebugInfo(Canvas canvas, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-220835906")) {
            ipChange.ipc$dispatch("-220835906", new Object[]{this, canvas, view});
        } else if (this.config.e()) {
            Paint createPaint = createPaint(InputDeviceCompat.SOURCE_ANY);
            Paint createPaint2 = createPaint(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin > 0) {
                float right = view.getRight();
                float top = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(right, top, right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, top, createPaint);
                int i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                canvas.drawLine((i + right) - 4.0f, top - 4.0f, right + i, top, createPaint);
                int i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                canvas.drawLine((i2 + right) - 4.0f, top + 4.0f, right + i2, top, createPaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin > 0) {
                float left = view.getLeft();
                float top2 = view.getTop() + (view.getHeight() / 2.0f);
                canvas.drawLine(left, top2, left - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, top2, createPaint);
                int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                canvas.drawLine((left - i3) + 4.0f, top2 - 4.0f, left - i3, top2, createPaint);
                int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                canvas.drawLine((left - i4) + 4.0f, top2 + 4.0f, left - i4, top2, createPaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin > 0) {
                float left2 = view.getLeft() + (view.getWidth() / 2.0f);
                float bottom = view.getBottom();
                canvas.drawLine(left2, bottom, left2, bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, createPaint);
                int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                canvas.drawLine(left2 - 4.0f, (i5 + bottom) - 4.0f, left2, bottom + i5, createPaint);
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                canvas.drawLine(left2 + 4.0f, (i6 + bottom) - 4.0f, left2, bottom + i6, createPaint);
            }
            if (((ViewGroup.MarginLayoutParams) layoutParams).topMargin > 0) {
                float left3 = view.getLeft() + (view.getWidth() / 2.0f);
                float top3 = view.getTop();
                canvas.drawLine(left3, top3, left3, top3 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, createPaint);
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                canvas.drawLine(left3 - 4.0f, (top3 - i7) + 4.0f, left3, top3 - i7, createPaint);
                int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                canvas.drawLine(left3 + 4.0f, (top3 - i8) + 4.0f, left3, top3 - i8, createPaint);
            }
            if (layoutParams.a) {
                if (this.config.c() == 0) {
                    float left4 = view.getLeft();
                    float top4 = view.getTop() + (view.getHeight() / 2.0f);
                    canvas.drawLine(left4, top4 - 6.0f, left4, top4 + 6.0f, createPaint2);
                    return;
                }
                float left5 = view.getLeft() + (view.getWidth() / 2.0f);
                float top5 = view.getTop();
                canvas.drawLine(left5 - 6.0f, top5, left5 + 6.0f, top5, createPaint2);
            }
        }
    }

    private int findSize(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247696756")) {
            return ((Integer) ipChange.ipc$dispatch("1247696756", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
        }
        if (i != Integer.MIN_VALUE) {
            return i != 1073741824 ? i3 : i2;
        }
        return Math.min(i3, i2);
    }

    private int getGravity(LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1723241443") ? ((Integer) ipChange.ipc$dispatch("1723241443", new Object[]{this, layoutParams})).intValue() : layoutParams.j() ? layoutParams.b : this.config.a();
    }

    private float getWeight(LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1499241188") ? ((Float) ipChange.ipc$dispatch("1499241188", new Object[]{this, layoutParams})).floatValue() : layoutParams.q() ? layoutParams.c : this.config.d();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1883773579") ? ((Boolean) ipChange.ipc$dispatch("1883773579", new Object[]{this, layoutParams})).booleanValue() : layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019306949")) {
            return ((Boolean) ipChange.ipc$dispatch("2019306949", new Object[]{this, canvas, view, Long.valueOf(j)})).booleanValue();
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        drawDebugInfo(canvas, view);
        return drawChild;
    }

    @Override // android.view.View, android.view.ViewParent
    public int getLayoutDirection() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2115888880")) {
            return ((Integer) ipChange.ipc$dispatch("-2115888880", new Object[]{this})).intValue();
        }
        LayoutConfiguration layoutConfiguration = this.config;
        if (layoutConfiguration == null) {
            return 0;
        }
        return layoutConfiguration.b();
    }

    public int getOrientation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-683113643") ? ((Integer) ipChange.ipc$dispatch("-683113643", new Object[]{this})).intValue() : this.config.c();
    }

    public int getShowLineLimit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2017893893") ? ((Integer) ipChange.ipc$dispatch("-2017893893", new Object[]{this})).intValue() : this.showLineLimit;
    }

    public float getWeightDefault() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-373395815") ? ((Float) ipChange.ipc$dispatch("-373395815", new Object[]{this})).floatValue() : this.config.d();
    }

    public boolean isDebugDraw() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-828267835") ? ((Boolean) ipChange.ipc$dispatch("-828267835", new Object[]{this})).booleanValue() : this.config.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540596353")) {
            ipChange.ipc$dispatch("540596353", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.j + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutParams.k + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.j + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + childAt.getMeasuredWidth(), layoutParams.k + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342558705")) {
            ipChange.ipc$dispatch("-1342558705", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = this.config.c() == 0 ? size : size2;
        if (this.config.c() == 0) {
            size = size2;
        }
        if (this.config.c() != 0) {
            mode = mode2;
        }
        this.config.c();
        this.lines.clear();
        a aVar = new a(i5, this.config);
        this.lines.add(aVar);
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height));
                layoutParams.c(this.config.c());
                if (this.config.c() == 0) {
                    layoutParams.n(childAt.getMeasuredWidth());
                    layoutParams.p(childAt.getMeasuredHeight());
                } else {
                    layoutParams.n(childAt.getMeasuredHeight());
                    layoutParams.p(childAt.getMeasuredWidth());
                }
                boolean z = layoutParams.a || !(mode == 0 || aVar.e(childAt));
                if ((this.singleLine || this.showLineLimit <= this.lines.size()) && z) {
                    childAt.setVisibility(8);
                    break;
                }
                if (z) {
                    aVar = new a(i5, this.config);
                    if (this.config.c() == 1 && this.config.b() == 1) {
                        this.lines.add(0, aVar);
                    } else {
                        this.lines.add(aVar);
                    }
                }
                if (this.config.c() == 0 && this.config.b() == 1) {
                    aVar.c(0, childAt);
                }
                aVar.d(childAt);
            }
            i6++;
        }
        calculateLinesAndChildPosition(this.lines);
        int size3 = this.lines.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size3; i8++) {
            i7 = Math.max(i7, this.lines.get(i8).f());
        }
        int h = aVar.h() + aVar.i();
        applyGravityToLines(this.lines, findSize(mode, i5, i7), findSize(mode2, size, h));
        for (int i9 = 0; i9 < size3; i9++) {
            a aVar2 = this.lines.get(i9);
            applyGravityToLine(aVar2);
            applyPositionsToViews(aVar2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.config.c() == 0) {
            i3 = paddingLeft + i7;
            i4 = paddingBottom + h;
        } else {
            i3 = paddingLeft + h;
            i4 = paddingBottom + i7;
        }
        setMeasuredDimension(ViewGroup.resolveSize(i3, i), ViewGroup.resolveSize(i4, i2));
    }

    public void setDebugDraw(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1874463795")) {
            ipChange.ipc$dispatch("-1874463795", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.config.f(z);
        invalidate();
    }

    public void setGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "66209363")) {
            ipChange.ipc$dispatch("66209363", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.g(i);
        requestLayout();
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145112314")) {
            ipChange.ipc$dispatch("145112314", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.h(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218377045")) {
            ipChange.ipc$dispatch("1218377045", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.i(i);
        requestLayout();
    }

    public void setShowLineLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1258905199")) {
            ipChange.ipc$dispatch("1258905199", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.showLineLimit = i;
        }
    }

    public void setSingleLine(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203366876")) {
            ipChange.ipc$dispatch("-1203366876", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.singleLine = z;
        }
    }

    public void setWeightDefault(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698735275")) {
            ipChange.ipc$dispatch("698735275", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.config.j(f);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1662276970") ? (LayoutParams) ipChange.ipc$dispatch("-1662276970", new Object[]{this}) : new LayoutParams(-2, -2);
    }

    public int getGravity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-910543721") ? ((Integer) ipChange.ipc$dispatch("-910543721", new Object[]{this})).intValue() : this.config.a();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1151622523") ? (LayoutParams) ipChange.ipc$dispatch("1151622523", new Object[]{this, attributeSet}) : new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1217470710") ? (LayoutParams) ipChange.ipc$dispatch("-1217470710", new Object[]{this, layoutParams}) : new LayoutParams(layoutParams);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static transient /* synthetic */ IpChange $ipChange;
        public boolean a;
        @ViewDebug.ExportedProperty(mapping = {@ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 48, to = "TOP"), @ViewDebug.IntToString(from = 80, to = "BOTTOM"), @ViewDebug.IntToString(from = 3, to = "LEFT"), @ViewDebug.IntToString(from = 5, to = "RIGHT"), @ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug.IntToString(from = 17, to = DamaiConstants.TAB_CENTER), @ViewDebug.IntToString(from = 119, to = "FILL")})
        public int b;
        public float c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = false;
            this.b = 0;
            this.c = -1.0f;
            k(context, attributeSet);
        }

        private void k(Context context, AttributeSet attributeSet) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2033536543")) {
                ipChange.ipc$dispatch("-2033536543", new Object[]{this, context, attributeSet});
                return;
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout_LayoutParams);
            try {
                this.a = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_LayoutParams_layout_newLine, false);
                this.b = obtainStyledAttributes.getInt(R$styleable.FlowLayout_LayoutParams_android_layout_gravity, 0);
                this.c = obtainStyledAttributes.getFloat(R$styleable.FlowLayout_LayoutParams_layout_weight, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        void c(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1168656377")) {
                ipChange.ipc$dispatch("-1168656377", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 0) {
                this.d = ((ViewGroup.MarginLayoutParams) this).leftMargin + ((ViewGroup.MarginLayoutParams) this).rightMargin;
                this.e = ((ViewGroup.MarginLayoutParams) this).topMargin + ((ViewGroup.MarginLayoutParams) this).bottomMargin;
            } else {
                this.d = ((ViewGroup.MarginLayoutParams) this).topMargin + ((ViewGroup.MarginLayoutParams) this).bottomMargin;
                this.e = ((ViewGroup.MarginLayoutParams) this).leftMargin + ((ViewGroup.MarginLayoutParams) this).rightMargin;
            }
        }

        int d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-77931900") ? ((Integer) ipChange.ipc$dispatch("-77931900", new Object[]{this})).intValue() : this.f;
        }

        int e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1512973426") ? ((Integer) ipChange.ipc$dispatch("1512973426", new Object[]{this})).intValue() : this.i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int f() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1479054487") ? ((Integer) ipChange.ipc$dispatch("1479054487", new Object[]{this})).intValue() : this.g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int g() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1304548938") ? ((Integer) ipChange.ipc$dispatch("1304548938", new Object[]{this})).intValue() : this.d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int h() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1736750356") ? ((Integer) ipChange.ipc$dispatch("-1736750356", new Object[]{this})).intValue() : this.e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int i() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "47631743") ? ((Integer) ipChange.ipc$dispatch("47631743", new Object[]{this})).intValue() : this.h;
        }

        public boolean j() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-700945844") ? ((Boolean) ipChange.ipc$dispatch("-700945844", new Object[]{this})).booleanValue() : this.b != 0;
        }

        void l(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1075027206")) {
                ipChange.ipc$dispatch("1075027206", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.f = i;
            }
        }

        void m(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1687967888")) {
                ipChange.ipc$dispatch("-1687967888", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.i = i;
            }
        }

        void n(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-619790101")) {
                ipChange.ipc$dispatch("-619790101", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.g = i;
            }
        }

        void o(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "615974101")) {
                ipChange.ipc$dispatch("615974101", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            this.j = i;
            this.k = i2;
        }

        void p(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-354828949")) {
                ipChange.ipc$dispatch("-354828949", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.h = i;
            }
        }

        public boolean q() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1201636012") ? ((Boolean) ipChange.ipc$dispatch("1201636012", new Object[]{this})).booleanValue() : this.c >= 0.0f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = false;
            this.b = 0;
            this.c = -1.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = false;
            this.b = 0;
            this.c = -1.0f;
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.singleLine = false;
        this.lines = new ArrayList();
        this.showLineLimit = Integer.MAX_VALUE;
        this.config = new LayoutConfiguration(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.singleLine = false;
        this.lines = new ArrayList();
        this.showLineLimit = Integer.MAX_VALUE;
        this.config = new LayoutConfiguration(context, attributeSet);
    }
}
