package com.alibaba.pictures.bricks.view;

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
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FlowLayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int HORIZONTAL = 0;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int VERTICAL = 1;
    private final LayoutConfiguration config;
    protected List<C3586a> lines;
    private int showLineLimit;
    private boolean singleLine;

    public FlowLayout(Context context) {
        super(context);
        this.singleLine = false;
        this.lines = new ArrayList();
        this.showLineLimit = Integer.MAX_VALUE;
        this.config = new LayoutConfiguration(context, null);
    }

    private void applyGravityToLine(C3586a c3586a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200900728")) {
            ipChange.ipc$dispatch("-200900728", new Object[]{this, c3586a});
            return;
        }
        List<View> j = c3586a.j();
        int size = j.size();
        if (size <= 0) {
            return;
        }
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            f += getWeight((LayoutParams) j.get(i).getLayoutParams());
        }
        LayoutParams layoutParams = (LayoutParams) j.get(size - 1).getLayoutParams();
        int f2 = c3586a.f() - (layoutParams.f() + layoutParams.d());
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
            rect.bottom = c3586a.i();
            Rect rect2 = new Rect();
            Gravity.apply(gravity, f3, i4, rect, rect2);
            i2 += round;
            layoutParams2.l(rect2.left + layoutParams2.d());
            layoutParams2.m(rect2.top);
            layoutParams2.n(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2) - layoutParams2.g());
            layoutParams2.p(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2) - layoutParams2.h());
        }
    }

    private void applyGravityToLines(List<C3586a> list, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734001276")) {
            ipChange.ipc$dispatch("1734001276", new Object[]{this, list, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = list.size();
        if (size <= 0) {
            return;
        }
        C3586a c3586a = list.get(size - 1);
        int i3 = i2 - (c3586a.i() + c3586a.h());
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            C3586a c3586a2 = list.get(i5);
            int gravity = getGravity();
            int round = Math.round((i3 * 1) / size);
            int f = c3586a2.f();
            int i6 = c3586a2.i();
            Rect rect = new Rect();
            rect.top = i4;
            rect.left = 0;
            rect.right = i;
            rect.bottom = i6 + round + i4;
            Rect rect2 = new Rect();
            Gravity.apply(gravity, f, i6, rect, rect2);
            i4 += round;
            c3586a2.a(rect2.left);
            c3586a2.b(rect2.top);
            c3586a2.k(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2));
            c3586a2.l(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2));
        }
    }

    private void applyPositionsToViews(C3586a c3586a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972381476")) {
            ipChange.ipc$dispatch("-972381476", new Object[]{this, c3586a});
            return;
        }
        List<View> j = c3586a.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            View view = j.get(i);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.config.c() == 0) {
                layoutParams.o(getPaddingLeft() + c3586a.g() + layoutParams.d(), getPaddingTop() + c3586a.h() + layoutParams.e());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.f(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.i(), 1073741824));
            } else {
                layoutParams.o(getPaddingLeft() + c3586a.h() + layoutParams.e(), getPaddingTop() + c3586a.g() + layoutParams.d());
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.i(), 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.f(), 1073741824));
            }
        }
    }

    private void calculateLinesAndChildPosition(List<C3586a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078884283")) {
            ipChange.ipc$dispatch("-1078884283", new Object[]{this, list});
            return;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C3586a c3586a = list.get(i2);
            c3586a.b(i);
            i += c3586a.i();
            List<View> j = c3586a.j();
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
        if (AndroidInstantRuntime.support(ipChange, "1798483669")) {
            return (Paint) ipChange.ipc$dispatch("1798483669", new Object[]{this, Integer.valueOf(i)});
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(2.0f);
        return paint;
    }

    private void drawDebugInfo(Canvas canvas, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410167617")) {
            ipChange.ipc$dispatch("-1410167617", new Object[]{this, canvas, view});
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
        if (AndroidInstantRuntime.support(ipChange, "-263832011")) {
            return ((Integer) ipChange.ipc$dispatch("-263832011", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
        }
        if (i != Integer.MIN_VALUE) {
            return i != 1073741824 ? i3 : i2;
        }
        return Math.min(i3, i2);
    }

    private int getGravity(LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1629243729") ? ((Integer) ipChange.ipc$dispatch("-1629243729", new Object[]{this, layoutParams})).intValue() : layoutParams.j() ? layoutParams.b : this.config.a();
    }

    private float getWeight(LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1297607306") ? ((Float) ipChange.ipc$dispatch("1297607306", new Object[]{this, layoutParams})).floatValue() : layoutParams.q() ? layoutParams.c : this.config.d();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "451405098") ? ((Boolean) ipChange.ipc$dispatch("451405098", new Object[]{this, layoutParams})).booleanValue() : layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "586938468")) {
            return ((Boolean) ipChange.ipc$dispatch("586938468", new Object[]{this, canvas, view, Long.valueOf(j)})).booleanValue();
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        drawDebugInfo(canvas, view);
        return drawChild;
    }

    @Override // android.view.View, android.view.ViewParent
    public int getLayoutDirection() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1496205103")) {
            return ((Integer) ipChange.ipc$dispatch("1496205103", new Object[]{this})).intValue();
        }
        LayoutConfiguration layoutConfiguration = this.config;
        if (layoutConfiguration == null) {
            return 0;
        }
        return layoutConfiguration.b();
    }

    public int getOrientation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2095487220") ? ((Integer) ipChange.ipc$dispatch("2095487220", new Object[]{this})).intValue() : this.config.c();
    }

    public int getShowLineLimit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1042844634") ? ((Integer) ipChange.ipc$dispatch("1042844634", new Object[]{this})).intValue() : this.showLineLimit;
    }

    public float getWeightDefault() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1607624584") ? ((Float) ipChange.ipc$dispatch("-1607624584", new Object[]{this})).floatValue() : this.config.d();
    }

    public boolean isDebugDraw() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1955170694") ? ((Boolean) ipChange.ipc$dispatch("1955170694", new Object[]{this})).booleanValue() : this.config.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339602686")) {
            ipChange.ipc$dispatch("-339602686", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.j + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutParams.k + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.j + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + childAt.getMeasuredWidth(), layoutParams.k + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440879824")) {
            ipChange.ipc$dispatch("1440879824", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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
        C3586a c3586a = new C3586a(i5, this.config);
        this.lines.add(c3586a);
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
                boolean z = layoutParams.a || !(mode == 0 || c3586a.e(childAt));
                if ((this.singleLine || this.showLineLimit <= this.lines.size()) && z) {
                    childAt.setVisibility(8);
                    break;
                }
                if (z) {
                    c3586a = new C3586a(i5, this.config);
                    if (this.config.c() == 1 && this.config.b() == 1) {
                        this.lines.add(0, c3586a);
                    } else {
                        this.lines.add(c3586a);
                    }
                }
                if (this.config.c() == 0 && this.config.b() == 1) {
                    c3586a.c(0, childAt);
                }
                c3586a.d(childAt);
            }
            i6++;
        }
        calculateLinesAndChildPosition(this.lines);
        int size3 = this.lines.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size3; i8++) {
            i7 = Math.max(i7, this.lines.get(i8).f());
        }
        int h = c3586a.h() + c3586a.i();
        applyGravityToLines(this.lines, findSize(mode, i5, i7), findSize(mode2, size, h));
        for (int i9 = 0; i9 < size3; i9++) {
            C3586a c3586a2 = this.lines.get(i9);
            applyGravityToLine(c3586a2);
            applyPositionsToViews(c3586a2);
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
        if (AndroidInstantRuntime.support(ipChange, "1540304462")) {
            ipChange.ipc$dispatch("1540304462", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.config.f(z);
        invalidate();
    }

    public void setGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445319404")) {
            ipChange.ipc$dispatch("-1445319404", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.g(i);
        requestLayout();
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450876091")) {
            ipChange.ipc$dispatch("450876091", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.h(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455657878")) {
            ipChange.ipc$dispatch("1455657878", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.config.i(i);
        requestLayout();
    }

    public void setShowLineLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652519024")) {
            ipChange.ipc$dispatch("1652519024", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.showLineLimit = i;
        }
    }

    public void setSingleLine(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575233987")) {
            ipChange.ipc$dispatch("1575233987", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.singleLine = z;
        }
    }

    public void setWeightDefault(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092349100")) {
            ipChange.ipc$dispatch("1092349100", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.config.j(f);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "18700508") ? (LayoutParams) ipChange.ipc$dispatch("18700508", new Object[]{this}) : new LayoutParams(-2, -2);
    }

    public int getGravity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1513492042") ? ((Integer) ipChange.ipc$dispatch("-1513492042", new Object[]{this})).intValue() : this.config.a();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1624220887") ? (LayoutParams) ipChange.ipc$dispatch("1624220887", new Object[]{this, attributeSet}) : new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "826067368") ? (LayoutParams) ipChange.ipc$dispatch("826067368", new Object[]{this, layoutParams}) : new LayoutParams(layoutParams);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
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
            if (AndroidInstantRuntime.support(ipChange, "-1144955840")) {
                ipChange.ipc$dispatch("-1144955840", new Object[]{this, context, attributeSet});
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
            if (AndroidInstantRuntime.support(ipChange, "-388518968")) {
                ipChange.ipc$dispatch("-388518968", new Object[]{this, Integer.valueOf(i)});
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
            return AndroidInstantRuntime.support(ipChange, "-1458124155") ? ((Integer) ipChange.ipc$dispatch("-1458124155", new Object[]{this})).intValue() : this.f;
        }

        int e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-72570671") ? ((Integer) ipChange.ipc$dispatch("-72570671", new Object[]{this})).intValue() : this.i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int f() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "862100278") ? ((Integer) ipChange.ipc$dispatch("862100278", new Object[]{this})).intValue() : this.g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int g() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "154136267") ? ((Integer) ipChange.ipc$dispatch("154136267", new Object[]{this})).intValue() : this.d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int h() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "158389963") ? ((Integer) ipChange.ipc$dispatch("158389963", new Object[]{this})).intValue() : this.e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int i() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1470148992") ? ((Integer) ipChange.ipc$dispatch("-1470148992", new Object[]{this})).intValue() : this.h;
        }

        public boolean j() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1851358515") ? ((Boolean) ipChange.ipc$dispatch("-1851358515", new Object[]{this})).booleanValue() : this.b != 0;
        }

        void l(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1238740261")) {
                ipChange.ipc$dispatch("1238740261", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.f = i;
            }
        }

        void m(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "699772657")) {
                ipChange.ipc$dispatch("699772657", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.i = i;
            }
        }

        void n(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1729465900")) {
                ipChange.ipc$dispatch("1729465900", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.g = i;
            }
        }

        void o(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "809411572")) {
                ipChange.ipc$dispatch("809411572", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            this.j = i;
            this.k = i2;
        }

        void p(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-161391478")) {
                ipChange.ipc$dispatch("-161391478", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.h = i;
            }
        }

        public boolean q() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1883515381") ? ((Boolean) ipChange.ipc$dispatch("-1883515381", new Object[]{this})).booleanValue() : this.c >= 0.0f;
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
