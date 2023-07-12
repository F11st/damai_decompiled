package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import tb.ry;
import tb.te;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXNativeLinearLayout extends LinearLayout {
    private te cLipRadiusHandler;

    public DXNativeLinearLayout(Context context) {
        super(context);
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
            e eVar = new e(dXRuntimeContext.getBizType());
            e.a aVar = new e.a("native", "native_crash", e.DX_NATIVE_CRASH_4);
            if (eVar.c == null) {
                eVar.c = new ArrayList();
            }
            eVar.c.add(aVar);
            aVar.e = ry.a(th);
            eVar.b = dXRuntimeContext.getDxTemplateItem();
            if (dXRuntimeContext.getDxError() != null) {
                eVar.b(dXRuntimeContext.getDxError().a());
            }
            DXAppMonitor.n(eVar);
        }
    }

    public te getCLipRadiusHandler() {
        return this.cLipRadiusHandler;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            DXWidgetNode dXWidgetNode = (DXWidgetNode) childAt.getTag(DXWidgetNode.TAG_WIDGET_NODE);
            childAt.layout(dXWidgetNode.getLeft(), dXWidgetNode.getTop(), dXWidgetNode.getLeft() + dXWidgetNode.getMeasuredWidth(), dXWidgetNode.getTop() + dXWidgetNode.getMeasuredHeight());
        }
    }

    public void setClipRadiusHandler(te teVar) {
        this.cLipRadiusHandler = teVar;
    }

    public DXNativeLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DXNativeLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
