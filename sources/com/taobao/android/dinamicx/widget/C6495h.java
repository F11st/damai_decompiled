package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.DXNativeBouncePageIndicator;
import com.taobao.android.dinamicx.view.DXNativePageIndicator;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.b00;
import tb.hy;
import tb.z00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.h */
/* loaded from: classes11.dex */
public class C6495h extends DXWidgetNode {
    public static final int DEFAULT_OFF_COLOR = 14606046;
    public static final int DEFAULT_ON_COLOR = 16742144;
    public static final long DXPAGEINDICATOR_ITEMMARGIN = -884050990290307049L;
    public static final long DXPAGEINDICATOR_ITEMROUNDDIAMETER = -8559743205145630989L;
    public static final long DXPAGEINDICATOR_ITEMSELECTEDBORDERCOLOR = 956057309702335052L;
    public static final long DXPAGEINDICATOR_ITEMSELECTEDBORDERWIDTH = 1687099697943502157L;
    public static final long DXPAGEINDICATOR_ITEMUNSELECTEDBORDERCOLOR = -2071489811568019695L;
    public static final long DXPAGEINDICATOR_ITEMUNSELECTEDBORDERWIDTH = 852679479955548690L;
    public static final long DXPAGEINDICATOR_MAXDISPLAYCOUNT = -3284462966979738828L;
    public static final long DX_PAGE_INDICATOR = -4649639459667590873L;
    public static final long DX_PAGE_INDICATOR_HIDES_FOR_SINGLE_PAGE = 5486881853309576485L;
    public static final long DX_PAGE_INDICATOR_OFF_COLOR = 5279668588453924930L;
    public static final long DX_PAGE_INDICATOR_ON_COLOR = 5176469557014791523L;
    public static final long DX_PAGE_INDICATOR_PAGE_COUNT = 7816476278377541039L;
    private int c;
    private int d;
    private boolean e;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int a = DEFAULT_ON_COLOR;
    private int b = DEFAULT_OFF_COLOR;
    private int f = z00.j(DinamicXEngine.i(), "8ap", 16);
    private int g = z00.j(DinamicXEngine.i(), "3ap", 9);

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.h$a */
    /* loaded from: classes11.dex */
    public static class C6496a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new C6495h();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new C6495h();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == DX_PAGE_INDICATOR_ON_COLOR) {
            return DEFAULT_ON_COLOR;
        }
        if (j == DX_PAGE_INDICATOR_OFF_COLOR) {
            return DEFAULT_OFF_COLOR;
        }
        if (j == DXPAGEINDICATOR_ITEMUNSELECTEDBORDERWIDTH || DXPAGEINDICATOR_ITEMSELECTEDBORDERCOLOR == j || DXPAGEINDICATOR_ITEMSELECTEDBORDERWIDTH == j || DXPAGEINDICATOR_ITEMUNSELECTEDBORDERCOLOR == j) {
            return 0;
        }
        if (j == DXPAGEINDICATOR_ITEMMARGIN) {
            return z00.j(DinamicXEngine.i(), "3ap", 9);
        }
        if (j == DXPAGEINDICATOR_ITEMROUNDDIAMETER) {
            return z00.j(DinamicXEngine.i(), "8ap", 16);
        }
        if (j == DXPAGEINDICATOR_MAXDISPLAYCOUNT) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        int i;
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof C6495h) {
            C6495h c6495h = (C6495h) dXWidgetNode;
            this.e = c6495h.e;
            this.d = c6495h.d;
            this.c = c6495h.c;
            this.b = c6495h.b;
            this.a = c6495h.a;
            this.g = c6495h.g;
            this.f = c6495h.f;
            this.i = c6495h.i;
            this.j = c6495h.j;
            this.k = c6495h.k;
            this.l = c6495h.l;
            if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) != 1 || (i = c6495h.h) == 0) {
                return;
            }
            this.h = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) == 1 && this.h != 0) {
            return new DXNativeBouncePageIndicator(context);
        }
        return new DXNativePageIndicator(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(hy hyVar) {
        if (super.onEvent(hyVar)) {
            return true;
        }
        if (hyVar.b() == -8975195222378757716L) {
            if (this.d <= 0) {
                return true;
            }
            b00 b00Var = (b00) hyVar;
            if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) == 1 && this.h != 0) {
                DXNativeBouncePageIndicator dXNativeBouncePageIndicator = (DXNativeBouncePageIndicator) getDXRuntimeContext().getNativeView();
                if (dXNativeBouncePageIndicator != null) {
                    dXNativeBouncePageIndicator.setSelectedView(b00Var.d);
                }
            } else {
                DXNativePageIndicator dXNativePageIndicator = (DXNativePageIndicator) getDXRuntimeContext().getNativeView();
                if (dXNativePageIndicator != null) {
                    dXNativePageIndicator.setSelectedView(b00Var.d);
                }
            }
            this.c = b00Var.d;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int b;
        int b2;
        int i3;
        int i4;
        int a = DXWidgetNode.DXMeasureSpec.a(i);
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        int i5 = 0;
        boolean z = a != 1073741824;
        boolean z2 = a2 != 1073741824;
        if (z || z2) {
            if (z) {
                if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) == 1 && (i4 = this.h) != 0) {
                    i3 = Math.min(i4, this.d);
                } else {
                    i3 = this.d;
                }
                if (i3 > 0) {
                    int i6 = 0;
                    while (i5 < i3) {
                        i6 += this.f;
                        if (i5 != i3 - 1) {
                            i6 += this.g;
                        }
                        i5++;
                    }
                    i5 = i6;
                }
                b = i5;
            } else {
                b = DXWidgetNode.DXMeasureSpec.b(i);
            }
            if (z2) {
                b2 = this.f;
            } else {
                b2 = DXWidgetNode.DXMeasureSpec.b(i2);
            }
        } else {
            b = DXWidgetNode.DXMeasureSpec.b(i);
            b2 = DXWidgetNode.DXMeasureSpec.b(i2);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(b, i), DXWidgetNode.resolveSize(b2, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        int i;
        int i2;
        super.onRenderView(context, view);
        C6495h c6495h = (C6495h) getDXRuntimeContext().getWidgetNode();
        if (getDefaultValueForIntAttr(DXPAGEINDICATOR_MAXDISPLAYCOUNT) == 1 && this.h != 0) {
            DXNativeBouncePageIndicator dXNativeBouncePageIndicator = (DXNativeBouncePageIndicator) view;
            dXNativeBouncePageIndicator.setItemRoundDiameter(c6495h.f);
            dXNativeBouncePageIndicator.setItemMargin(c6495h.g);
            dXNativeBouncePageIndicator.setItemSelectedBorderWidth(c6495h.j);
            dXNativeBouncePageIndicator.setItemSelectedBorderColor(c6495h.i);
            dXNativeBouncePageIndicator.setItemUnSelectedBorderWidth(c6495h.l);
            dXNativeBouncePageIndicator.setItemUnSelectedBorderColor(c6495h.k);
            int tryFetchDarkModeColor = tryFetchDarkModeColor("onColor", 1, c6495h.a);
            int tryFetchDarkModeColor2 = tryFetchDarkModeColor("offColor", 1, c6495h.b);
            dXNativeBouncePageIndicator.setSelectedDrawable(tryFetchDarkModeColor);
            dXNativeBouncePageIndicator.setUnselectedDrawable(tryFetchDarkModeColor2);
            dXNativeBouncePageIndicator.setMaxDisplayCount(c6495h.h);
            if ((c6495h.e && c6495h.d == 1) || (i2 = c6495h.d) <= 0) {
                dXNativeBouncePageIndicator.addChildViews(0, 0);
                return;
            }
            this.c = c6495h.c;
            dXNativeBouncePageIndicator.addChildViews(i2, c6495h.c);
            return;
        }
        DXNativePageIndicator dXNativePageIndicator = (DXNativePageIndicator) view;
        dXNativePageIndicator.setItemRoundDiameter(c6495h.f);
        dXNativePageIndicator.setItemMargin(c6495h.g);
        dXNativePageIndicator.setItemSelectedBorderWidth(c6495h.j);
        dXNativePageIndicator.setItemSelectedBorderColor(c6495h.i);
        dXNativePageIndicator.setItemUnSelectedBorderWidth(c6495h.l);
        dXNativePageIndicator.setItemUnSelectedBorderColor(c6495h.k);
        int tryFetchDarkModeColor3 = tryFetchDarkModeColor("onColor", 1, c6495h.a);
        int tryFetchDarkModeColor4 = tryFetchDarkModeColor("offColor", 1, c6495h.b);
        dXNativePageIndicator.setSelectedDrawable(tryFetchDarkModeColor3);
        dXNativePageIndicator.setUnselectedDrawable(tryFetchDarkModeColor4);
        if ((c6495h.e && c6495h.d == 1) || (i = c6495h.d) <= 0) {
            dXNativePageIndicator.addChildViews(0, 0);
            return;
        }
        this.c = c6495h.c;
        dXNativePageIndicator.addChildViews(i, c6495h.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DX_PAGE_INDICATOR_ON_COLOR) {
            this.a = i;
        } else if (j == DX_PAGE_INDICATOR_OFF_COLOR) {
            this.b = i;
        } else if (j == DX_PAGE_INDICATOR_PAGE_COUNT) {
            this.d = i;
        } else if (j == DX_PAGE_INDICATOR_HIDES_FOR_SINGLE_PAGE) {
            this.e = i != 0;
        } else if (j == DXPAGEINDICATOR_ITEMMARGIN) {
            this.g = i;
        } else if (j == DXPAGEINDICATOR_ITEMROUNDDIAMETER) {
            this.f = i;
        } else if (j == DXPAGEINDICATOR_ITEMSELECTEDBORDERCOLOR) {
            this.i = i;
        } else if (j == DXPAGEINDICATOR_ITEMSELECTEDBORDERWIDTH) {
            this.j = i;
        } else if (j == DXPAGEINDICATOR_ITEMUNSELECTEDBORDERCOLOR) {
            this.k = i;
        } else if (j == DXPAGEINDICATOR_ITEMUNSELECTEDBORDERWIDTH) {
            this.l = i;
        } else if (j == DXPAGEINDICATOR_MAXDISPLAYCOUNT) {
            this.h = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }
}
