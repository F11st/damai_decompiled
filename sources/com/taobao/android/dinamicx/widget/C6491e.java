package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.view.DXNativeGridLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import java.util.Iterator;
import tb.hz;
import tb.z00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.widget.e */
/* loaded from: classes11.dex */
public class C6491e extends C6489d {
    public static final long DXGRIDLAYOUT_MAXCOLCOUNT = -7092152831124183944L;
    public static final long DXGRIDLAYOUT_MAXROWCOUNT = -8743048525866445678L;
    public static final long DXGRIDLAYOUT_MINCOLCOUNT = -787266499800216458L;
    public static final long DXGRIDLAYOUT_MINROWCOUNT = -2438162194542478192L;
    public static final long DXGRIDLAYOUT_ORIENTATION = -7199229155167727177L;
    public static final int DXGRIDLAYOUT_ORIENTATION_HORIZONTAL = 0;
    public static final int DXGRIDLAYOUT_ORIENTATION_VERTICAL = 1;
    public static final long DX_GRID_LAYOUT = 7789579202915247118L;
    public static final long DX_GRID_LAYOUT_COLUMN_COUNT = 4480460401770252962L;
    public static final long DX_GRID_LAYOUT_COLUMN_SPACING = -7076735627431451296L;
    public static final long DX_GRID_LAYOUT_ITEM_HEIGHT = -889779179579457774L;
    public static final long DX_GRID_LAYOUT_ITEM_WIDTH = -5480582194049152328L;
    public static final long DX_GRID_LAYOUT_LINE_COLOR = -1442755333969665872L;
    public static final long DX_GRID_LAYOUT_LINE_WIDTH = -1442710627541559887L;
    public static final long DX_GRID_LAYOUT_NEED_SEPARATOR = -7975214338005072550L;
    public static final long DX_GRID_LAYOUT_ROW_COUNT = 6173497815537313897L;
    public static final long DX_GRID_LAYOUT_ROW_SPACING = -5965488911581852121L;
    private int d;
    private int e;
    private int f;
    private int m;
    private float[] n;
    private int c = 0;
    private int g = -8421505;
    private int h = z00.j(DinamicXEngine.i(), "0.5np", 0);
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int o = 0;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.e$a */
    /* loaded from: classes11.dex */
    public static class C6492a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new C6491e();
        }
    }

    private int f() {
        int i = 0;
        for (int i2 = 0; i2 < getVirtualChildCount(); i2++) {
            i += i(getVirtualChildAt(i2));
        }
        return i;
    }

    private int g() {
        int i = 0;
        for (int i2 = 0; i2 < getVirtualChildCount(); i2++) {
            i += h(getVirtualChildAt(i2));
        }
        return i;
    }

    private int h(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode instanceof hz) {
            return ((hz) dXWidgetNode).f();
        }
        return 1;
    }

    private int i(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode instanceof hz) {
            return ((hz) dXWidgetNode).g();
        }
        return 1;
    }

    private void j(boolean z, int i, int i2, int i3, int i4) {
        int leftMarginWithDirection;
        int rightMarginWithDirection;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.c > 0 && this.f > 0 && this.e > 0) {
            int virtualChildCount = getVirtualChildCount();
            int i9 = 0;
            for (int i10 = 0; i10 < virtualChildCount; i10++) {
                DXWidgetNode virtualChildAt = getVirtualChildAt(i10);
                int i11 = this.c;
                int i12 = i9 / i11;
                int i13 = i9 % i11;
                if (i13 > 0) {
                    int h = h(virtualChildAt) + i13;
                    int i14 = this.c;
                    if (h > i14) {
                        i9 += i14 - i13;
                        i12++;
                        if (i12 > this.k) {
                            return;
                        }
                        i13 = 0;
                    }
                }
                i9 += h(virtualChildAt);
                int i15 = (this.e * i12) + (i12 * this.m) + this.paddingTop;
                int i16 = (this.f * i13) + (i13 * this.d) + this.paddingLeft;
                int h2 = h(virtualChildAt);
                if (virtualChildAt != null && virtualChildAt.getVisibility() != 2) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    int i17 = virtualChildAt.layoutGravity;
                    if (i17 == 0 && (virtualChildAt.propertyInitFlag & 1) == 0) {
                        i17 = this.childGravity;
                    }
                    int absoluteGravity = DXWidgetNode.getAbsoluteGravity(i17, getDirection());
                    switch (absoluteGravity) {
                        case 3:
                        case 4:
                        case 5:
                            leftMarginWithDirection = ((((this.f * h2) + ((h2 - 1) * this.d)) - measuredWidth) / 2) + virtualChildAt.getLeftMarginWithDirection();
                            rightMarginWithDirection = virtualChildAt.getRightMarginWithDirection();
                            i5 = i16 + (leftMarginWithDirection - rightMarginWithDirection);
                            break;
                        case 6:
                        case 7:
                        case 8:
                            leftMarginWithDirection = ((this.f * h2) + ((h2 - 1) * this.d)) - measuredWidth;
                            rightMarginWithDirection = virtualChildAt.getRightMarginWithDirection();
                            i5 = i16 + (leftMarginWithDirection - rightMarginWithDirection);
                            break;
                        default:
                            i5 = i16 + virtualChildAt.getLeftMarginWithDirection();
                            break;
                    }
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 2) {
                            if (absoluteGravity != 4) {
                                if (absoluteGravity != 5) {
                                    if (absoluteGravity != 7) {
                                        if (absoluteGravity != 8) {
                                            i8 = virtualChildAt.marginTop;
                                            int i18 = i15 + i8;
                                            virtualChildAt.layout(i5, i18, measuredWidth + i5, measuredHeight + i18);
                                        }
                                    }
                                }
                            }
                        }
                        i6 = this.e - measuredHeight;
                        i7 = virtualChildAt.marginBottom;
                        i8 = i6 - i7;
                        int i182 = i15 + i8;
                        virtualChildAt.layout(i5, i182, measuredWidth + i5, measuredHeight + i182);
                    }
                    i6 = ((this.e - measuredHeight) / 2) + virtualChildAt.marginTop;
                    i7 = virtualChildAt.marginBottom;
                    i8 = i6 - i7;
                    int i1822 = i15 + i8;
                    virtualChildAt.layout(i5, i1822, measuredWidth + i5, measuredHeight + i1822);
                }
            }
            return;
        }
        this.n = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.C6491e.k(boolean, int, int, int, int):void");
    }

    @Override // com.taobao.android.dinamicx.widget.C6489d, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new C6491e();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == 4480460401770252962L) {
            return 0;
        }
        if (j == DX_GRID_LAYOUT_LINE_COLOR) {
            return -8421505;
        }
        if (j == DX_GRID_LAYOUT_NEED_SEPARATOR || j == DX_GRID_LAYOUT_ROW_COUNT) {
            return 0;
        }
        if (j == DXGRIDLAYOUT_MAXCOLCOUNT || j == DXGRIDLAYOUT_MAXROWCOUNT || j == DXGRIDLAYOUT_MINCOLCOUNT || j == DXGRIDLAYOUT_MINROWCOUNT) {
            return -1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    protected void l() {
        if (this.i) {
            int i = this.k;
            int i2 = (this.c - 1) + (i - 1);
            int i3 = this.o;
            if (i3 == 1) {
                i2 = (this.j - 1) + (this.l - 1);
            }
            float[] fArr = new float[i2 * 4];
            int i4 = i - 1;
            if (i3 == 1) {
                i4 = this.j - 1;
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                int i8 = i7 + 1;
                fArr[i7] = this.paddingLeft;
                int i9 = i8 + 1;
                int i10 = i6 + 1;
                int i11 = this.m;
                fArr[i8] = (this.e * i10) + (i6 * i11) + (i11 / 2) + this.paddingTop;
                int i12 = i9 + 1;
                fArr[i9] = getMeasuredWidth() - this.paddingRight;
                i7 = i12 + 1;
                int i13 = this.m;
                fArr[i12] = (this.e * i10) + (i6 * i13) + (i13 / 2) + this.paddingTop;
                i6 = i10;
            }
            int i14 = this.c - 1;
            if (this.o == 1) {
                i14 = this.l - 1;
            }
            while (i5 < i14) {
                int i15 = i7 + 1;
                int i16 = i5 + 1;
                int i17 = this.f;
                int i18 = this.d;
                int i19 = this.paddingLeft;
                fArr[i7] = (i16 * i17) + (i5 * i18) + (i18 / 2) + i19;
                int i20 = i15 + 1;
                fArr[i15] = this.paddingTop;
                int i21 = i20 + 1;
                fArr[i20] = (i17 * i16) + (i5 * i18) + (i18 / 2) + i19;
                i7 = i21 + 1;
                fArr[i21] = getMeasuredHeight() - this.paddingBottom;
                i5 = i16;
            }
            this.n = fArr;
            int min = Math.min(this.d, this.m);
            if (this.h > min) {
                this.h = min;
            }
            setDisableFlatten(true);
            return;
        }
        this.n = null;
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f
    public void measureChildWithMargins(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4) {
        dXWidgetNode.measure(C6493f.getChildMeasureSpec(i, dXWidgetNode.marginLeft + dXWidgetNode.marginRight + i2, dXWidgetNode.layoutWidth), C6493f.getChildMeasureSpec(i3, dXWidgetNode.marginTop + dXWidgetNode.marginBottom + i4, dXWidgetNode.layoutHeight));
    }

    protected void measureHorizontal(int i, int i2) {
        int b;
        int b2;
        int i3;
        int virtualChildCount = getVirtualChildCount();
        DXWidgetNode.DXMeasureSpec.c(this.f, 1073741824);
        int c = DXWidgetNode.DXMeasureSpec.c(this.e, 1073741824);
        int i4 = 0;
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            DXWidgetNode childAt = getChildAt(i5);
            int h = h(childAt);
            measureChildWithMargins(childAt, DXWidgetNode.DXMeasureSpec.c((this.f * h) + ((h - 1) * this.d), 1073741824), 0, c, 0);
        }
        int a = DXWidgetNode.DXMeasureSpec.a(i);
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        boolean z = a != 1073741824;
        boolean z2 = a2 != 1073741824;
        if (this.c > 0 && (i4 = this.j) <= 0) {
            int g = g();
            int i6 = this.c;
            if (g % i6 == 0) {
                i3 = g / i6;
            } else {
                i3 = (g / i6) + 1;
            }
            i4 = i3;
            int i7 = this.q;
            int i8 = this.s;
            if (i8 > 0 && ((i7 < 0 || i7 > i8) && i4 < i8)) {
                i4 = i8;
            }
        }
        this.k = i4;
        if (z || z2) {
            if (z) {
                int i9 = this.c;
                if (i9 > 0) {
                    b = (this.f * i9) + (this.d * (i9 - 1)) + this.paddingLeft + this.paddingRight;
                } else {
                    b = this.paddingLeft + this.paddingRight;
                }
            } else {
                b = DXWidgetNode.DXMeasureSpec.b(i);
            }
            if (!z2) {
                b2 = DXWidgetNode.DXMeasureSpec.b(i2);
            } else if (i4 > 0) {
                b2 = (this.e * i4) + (this.m * (i4 - 1)) + this.paddingTop + this.paddingBottom;
            } else {
                b2 = this.paddingTop + this.paddingBottom;
            }
        } else {
            b = DXWidgetNode.DXMeasureSpec.b(i);
            b2 = DXWidgetNode.DXMeasureSpec.b(i2);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(b, i), DXWidgetNode.resolveSize(b2, i2));
    }

    protected void measureVertical(int i, int i2) {
        int b;
        int b2;
        int i3;
        int virtualChildCount = getVirtualChildCount();
        int c = DXWidgetNode.DXMeasureSpec.c(this.f, 1073741824);
        DXWidgetNode.DXMeasureSpec.c(this.e, 1073741824);
        int i4 = 0;
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            DXWidgetNode childAt = getChildAt(i5);
            int i6 = i(childAt);
            measureChildWithMargins(childAt, c, 0, DXWidgetNode.DXMeasureSpec.c((this.e * i6) + ((i6 - 1) * this.m), 1073741824), 0);
        }
        int a = DXWidgetNode.DXMeasureSpec.a(i);
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        boolean z = a != 1073741824;
        boolean z2 = a2 != 1073741824;
        if (this.j > 0 && (i4 = this.c) <= 0) {
            int f = f();
            int i7 = this.j;
            if (f % i7 == 0) {
                i3 = f / i7;
            } else {
                i3 = (f / i7) + 1;
            }
            i4 = i3;
            int i8 = this.p;
            if (i8 <= 0 || i8 <= this.r || i4 <= i8) {
                int i9 = this.r;
                if (i9 > 0 && ((i8 < 0 || i8 > i9) && i4 < i9)) {
                    i4 = i9;
                }
            } else {
                i4 = i8;
            }
        }
        this.l = i4;
        if (z || z2) {
            if (!z) {
                b = DXWidgetNode.DXMeasureSpec.b(i);
            } else if (i4 > 0) {
                b = (this.f * i4) + (this.d * (i4 - 1)) + this.paddingLeft + this.paddingRight;
            } else {
                b = this.paddingLeft + this.paddingRight;
            }
            if (z2) {
                int i10 = this.j;
                if (i10 > 0) {
                    b2 = this.paddingTop + this.paddingBottom + (this.e * i10) + (this.m * (i10 - 1));
                } else {
                    b2 = this.paddingTop + this.paddingBottom;
                }
            } else {
                b2 = DXWidgetNode.DXMeasureSpec.b(i2);
            }
        } else {
            b = DXWidgetNode.DXMeasureSpec.b(i);
            b2 = DXWidgetNode.DXMeasureSpec.b(i2);
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(b, i), DXWidgetNode.resolveSize(b2, i2));
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if ((this.propertyInitFlag & 2) == 0) {
            return;
        }
        if (getChildren() != null && this.originItems == null) {
            this.originItems = new ArrayList();
            for (DXWidgetNode dXWidgetNode : getChildren()) {
                this.originItems.add(dXWidgetNode.deepClone(getDXRuntimeContext()));
            }
        }
        JSONArray listData = getListData();
        if (listData != null && !listData.isEmpty() && getChildren() != null) {
            removeAllChild();
            for (DXWidgetNode dXWidgetNode2 : this.originItems) {
                addChild(dXWidgetNode2.deepClone(getDXRuntimeContext()));
            }
            ArrayList arrayList = (ArrayList) getChildren();
            ArrayList arrayList2 = new ArrayList();
            int size = listData.size();
            int i = this.j * this.c;
            if (i > 0) {
                size = Math.min(i, size);
            }
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = listData.get(i2);
                if (i2 == 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        bindContext((DXWidgetNode) it.next(), obj, i2);
                    }
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        DXWidgetNode dXWidgetNode3 = (DXWidgetNode) it2.next();
                        DXRuntimeContext cloneWithWidgetNode = dXWidgetNode3.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode3);
                        cloneWithWidgetNode.setSubData(obj);
                        cloneWithWidgetNode.setSubdataIndex(i2);
                        arrayList2.add(C6494g.b(dXWidgetNode3, cloneWithWidgetNode));
                    }
                }
            }
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                addChild((DXWidgetNode) arrayList2.get(i3), false);
            }
            return;
        }
        removeAllChild();
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof C6491e)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        C6491e c6491e = (C6491e) dXWidgetNode;
        this.c = c6491e.c;
        this.d = c6491e.d;
        this.e = c6491e.e;
        this.f = c6491e.f;
        this.g = c6491e.g;
        this.h = c6491e.h;
        this.i = c6491e.i;
        this.j = c6491e.j;
        this.m = c6491e.m;
        this.n = c6491e.n;
        this.k = c6491e.k;
        this.o = c6491e.o;
        this.p = c6491e.p;
        this.r = c6491e.r;
        this.q = c6491e.q;
        this.s = c6491e.s;
    }

    @Override // com.taobao.android.dinamicx.widget.C6489d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeGridLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6489d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.o == 1) {
            k(z, i, i2, i3, i4);
        } else {
            j(z, i, i2, i3, i4);
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6489d, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (this.o == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        super.onRenderView(context, view);
        ((DXNativeGridLayout) view).setLines(this.i, this.g, this.h, this.n);
    }

    @Override // com.taobao.android.dinamicx.widget.C6489d, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 4480460401770252962L) {
            this.c = i;
        } else if (j == DX_GRID_LAYOUT_COLUMN_SPACING) {
            this.d = i;
        } else if (j == DX_GRID_LAYOUT_ITEM_HEIGHT) {
            this.e = i;
        } else if (j == -5480582194049152328L) {
            this.f = i;
        } else if (j == DX_GRID_LAYOUT_LINE_COLOR) {
            this.g = i;
        } else if (j == DX_GRID_LAYOUT_LINE_WIDTH) {
            this.h = i;
        } else if (j == DX_GRID_LAYOUT_NEED_SEPARATOR) {
            this.i = i != 0;
        } else if (j == DX_GRID_LAYOUT_ROW_COUNT) {
            this.j = i;
        } else if (j == DX_GRID_LAYOUT_ROW_SPACING) {
            this.m = i;
        } else if (j == -7199229155167727177L) {
            this.o = i;
        } else if (j == DXGRIDLAYOUT_MAXCOLCOUNT) {
            this.p = i;
        } else if (j == DXGRIDLAYOUT_MAXROWCOUNT) {
            this.q = i;
        } else if (j == DXGRIDLAYOUT_MINCOLCOUNT) {
            this.r = i;
        } else if (j == DXGRIDLAYOUT_MINROWCOUNT) {
            this.s = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }
}
