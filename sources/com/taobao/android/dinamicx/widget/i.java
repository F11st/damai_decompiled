package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.view.DXNativeScrollerIndicator;
import tb.c10;
import tb.hy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i extends DXWidgetNode {
    public static final int DEFAULT_INDICATOR_BG_COLOR = -2171170;
    public static final int DEFAULT_INDICATOR_COLOR = -35072;
    public static final double DEFAULT_INDICATOR_RATIO = 0.5d;
    public static final long DX_SCROLLER_INDICATOR = 4185989886676328692L;
    public static final long DX_SCROLLER_INDICATOR_COLOR = -5151416374116397110L;
    public static final long DX_SCROLLER_INDICATOR_INDICATOR_RATIO = -5150348073123091510L;
    private int a = DEFAULT_INDICATOR_COLOR;
    private double b = 0.5d;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new i();
        }
    }

    public i() {
        this.backGroundColor = DEFAULT_INDICATOR_BG_COLOR;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new i();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public double getDefaultValueForDoubleAttr(long j) {
        if (j == DX_SCROLLER_INDICATOR_INDICATOR_RATIO) {
            return 0.5d;
        }
        return super.getDefaultValueForDoubleAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        return j == -5151416374116397110L ? DEFAULT_INDICATOR_COLOR : j == -2819959685970048978L ? DEFAULT_INDICATOR_BG_COLOR : super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof i) {
            i iVar = (i) dXWidgetNode;
            this.a = iVar.a;
            this.b = iVar.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeScrollerIndicator(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(hy hyVar) {
        DXNativeScrollerIndicator dXNativeScrollerIndicator;
        c10 c10Var;
        RecyclerView h;
        if (super.onEvent(hyVar)) {
            return true;
        }
        if (hyVar.b() != 5288751146867425108L || (dXNativeScrollerIndicator = (DXNativeScrollerIndicator) getDXRuntimeContext().getNativeView()) == null || (h = (c10Var = (c10) hyVar).h()) == null) {
            return false;
        }
        if (((LinearLayoutManager) h.getLayoutManager()).getOrientation() == 1) {
            dXNativeScrollerIndicator.setHorizontal(false);
            return true;
        }
        int i = c10Var.f().a - c10Var.i().a;
        dXNativeScrollerIndicator.refreshScrollIndicator(i > 0 ? c10Var.g() / i : 0.0d, this.b, getMeasuredWidth(), getMeasuredHeight());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        super.onRenderView(context, view);
        i iVar = (i) getDXRuntimeContext().getWidgetNode();
        DXNativeScrollerIndicator dXNativeScrollerIndicator = (DXNativeScrollerIndicator) view;
        dXNativeScrollerIndicator.setScrollBarThumbColor(tryFetchDarkModeColor("indicatorColor", 2, iVar.a));
        dXNativeScrollerIndicator.refreshScrollIndicator(0.0d, iVar.b, iVar.getMeasuredWidth(), iVar.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        if (j == DX_SCROLLER_INDICATOR_INDICATOR_RATIO) {
            this.b = d > 0.0d ? Math.min(1.0d, d) : 0.5d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == -5151416374116397110L) {
            this.a = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        DXNativeScrollerIndicator dXNativeScrollerIndicator = (DXNativeScrollerIndicator) view;
        dXNativeScrollerIndicator.setRadii((float) (getMeasuredHeight() * 0.5d));
        dXNativeScrollerIndicator.setScrollBarTrackColor(this.backGroundColor);
    }
}
