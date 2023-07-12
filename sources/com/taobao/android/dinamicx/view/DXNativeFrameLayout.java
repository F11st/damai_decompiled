package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import tb.nz;
import tb.ry;
import tb.te;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXNativeFrameLayout extends FrameLayout {
    private te cLipRadiusHandler;
    private boolean isV2;

    public DXNativeFrameLayout(@NonNull Context context) {
        super(context);
        this.isV2 = false;
    }

    private void layoutChildForDX(int i, int i2, int i3, int i4, boolean z) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                DXWidgetNode dXWidgetNode = (DXWidgetNode) childAt.getTag(DXWidgetNode.TAG_WIDGET_NODE);
                childAt.layout(dXWidgetNode.getLeft(), dXWidgetNode.getTop(), dXWidgetNode.getLeft() + dXWidgetNode.getMeasuredWidth(), dXWidgetNode.getTop() + dXWidgetNode.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        DXRuntimeContext dXRuntimeContext;
        try {
            te teVar = this.cLipRadiusHandler;
            if (teVar == null) {
                super.dispatchDraw(canvas);
            } else if (teVar.h()) {
                super.dispatchDraw(canvas);
            } else {
                this.cLipRadiusHandler.b(this, canvas);
                super.dispatchDraw(canvas);
                this.cLipRadiusHandler.a(this, canvas);
            }
        } catch (Throwable th) {
            ry.b(th);
            Object tag = getTag(DXWidgetNode.TAG_WIDGET_NODE);
            if (!(tag instanceof DXWidgetNode) || (dXRuntimeContext = ((DXWidgetNode) tag).getDXRuntimeContext()) == null) {
                return;
            }
            C6368e c6368e = new C6368e(dXRuntimeContext.getBizType());
            C6368e.C6369a c6369a = new C6368e.C6369a("native", "native_crash", C6368e.DX_NATIVE_CRASH_3);
            if (c6368e.c == null) {
                c6368e.c = new ArrayList();
            }
            c6368e.c.add(c6369a);
            c6369a.e = ry.a(th);
            c6368e.b = dXRuntimeContext.getDxTemplateItem();
            if (dXRuntimeContext.getDxError() != null) {
                c6368e.b(dXRuntimeContext.getDxError().a());
            }
            DXAppMonitor.n(c6368e);
        }
    }

    public te getCLipRadiusHandler() {
        return this.cLipRadiusHandler;
    }

    public boolean isV2() {
        return this.isV2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.isV2) {
            super.onLayout(z, i, i2, i3, i4);
        } else {
            layoutChildForDX(i, i2, i3, i4, false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        DXRuntimeContext dXRuntimeContext;
        try {
            if (this.isV2) {
                super.onMeasure(i, i2);
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            setMeasuredDimension(layoutParams.width, layoutParams.height);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                childAt.measure(View.MeasureSpec.makeMeasureSpec(layoutParams2.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824));
            }
        } catch (Throwable th) {
            Object tag = getTag(DXWidgetNode.TAG_WIDGET_NODE);
            if ((tag instanceof DXWidgetNode) && (dXRuntimeContext = ((DXWidgetNode) tag).getDXRuntimeContext()) != null) {
                C6368e c6368e = new C6368e(dXRuntimeContext.getBizType());
                C6368e.C6369a c6369a = new C6368e.C6369a("native", "native_crash", C6368e.DX_NATIVE_ONMEASURE_CRASH);
                if (c6368e.c == null) {
                    c6368e.c = new ArrayList();
                }
                c6368e.c.add(c6369a);
                c6369a.e = ry.a(th);
                c6368e.b = dXRuntimeContext.getDxTemplateItem();
                if (dXRuntimeContext.getDxError() != null) {
                    c6368e.b(dXRuntimeContext.getDxError().a());
                }
                DXAppMonitor.n(c6368e);
                return;
            }
            C6368e c6368e2 = new C6368e(nz.TAG);
            C6368e.C6369a c6369a2 = new C6368e.C6369a("native", "native_crash", C6368e.DX_NATIVE_ONMEASURE_CRASH_2);
            c6369a2.e = ry.a(th);
            if (c6368e2.c == null) {
                c6368e2.c = new ArrayList();
            }
            c6368e2.c.add(c6369a2);
            DXAppMonitor.n(c6368e2);
        }
    }

    public void setClipRadiusHandler(te teVar) {
        this.cLipRadiusHandler = teVar;
    }

    public void setV2(boolean z) {
        this.isV2 = z;
    }

    public DXNativeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isV2 = false;
    }

    public DXNativeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isV2 = false;
    }
}
