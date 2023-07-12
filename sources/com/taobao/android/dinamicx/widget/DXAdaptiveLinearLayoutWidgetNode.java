package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.view.DXNativeAdaptiveLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXAdaptiveLinearLayoutWidgetNode extends DXLinearLayoutWidgetNode {
    public static final long DXADAPTIVELINEARLAYOUT_ALWAYSSHOWINDICATOR = 2031908517150824674L;
    public static final long DXADAPTIVELINEARLAYOUT_MOREINDICATORUSERID = -205834946367932241L;
    private boolean alwaysShowIndicator = false;
    private String moreIndicatorUserId;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXAdaptiveLinearLayoutWidgetNode();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXAdaptiveLinearLayoutWidgetNode();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == DXADAPTIVELINEARLAYOUT_ALWAYSSHOWINDICATOR) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode
    protected void measureHorizontal(int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int i4 = 0;
        int i5 = 0;
        boolean z3 = true;
        boolean z4 = false;
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i6);
            if (virtualChildAt == null || virtualChildAt.getVisibility() == 2) {
                i4 = i4;
            } else {
                int i7 = i4;
                measureChildWithMargins(virtualChildAt, i, 0, i2, 0);
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int i8 = this.mTotalLength;
                this.mTotalLength = Math.max(i8, measuredWidth + i8 + virtualChildAt.marginLeft + virtualChildAt.marginRight);
                if (mode == 1073741824 || virtualChildAt.layoutHeight != -1) {
                    z2 = false;
                } else {
                    z2 = true;
                    z4 = true;
                }
                int i9 = virtualChildAt.marginTop + virtualChildAt.marginBottom;
                int measuredHeight = virtualChildAt.getMeasuredHeight() + i9;
                i5 = Math.max(i5, measuredHeight);
                z3 = z3 && virtualChildAt.layoutHeight == -1;
                if (!z2) {
                    i9 = measuredHeight;
                }
                i4 = Math.max(i7, i9);
            }
        }
        int i10 = i4;
        this.mTotalLength += this.paddingLeft + this.paddingRight;
        DXWidgetNode dXWidgetNode = null;
        String str = this.moreIndicatorUserId;
        if (str == null || (dXWidgetNode = queryWTByUserId(str)) == null || dXWidgetNode.getVisibility() == 2) {
            i3 = 0;
            z = false;
        } else {
            i3 = dXWidgetNode.getMeasuredWidth() + dXWidgetNode.marginLeft + dXWidgetNode.marginRight;
            z = true;
        }
        if (z && !this.alwaysShowIndicator) {
            this.mTotalLength -= i3;
        }
        int max = Math.max(this.mTotalLength, getSuggestedMinimumWidth());
        if (max > size) {
            if (z && !this.alwaysShowIndicator) {
                max = this.mTotalLength + i3;
                this.mTotalLength = max;
            }
            for (int i11 = virtualChildCount - 1; i11 >= 0; i11--) {
                DXWidgetNode virtualChildAt2 = getVirtualChildAt(i11);
                if (virtualChildAt2.getVisibility() != 2 && (virtualChildAt2 != dXWidgetNode || !z)) {
                    max = ((max - virtualChildAt2.getMeasuredWidth()) - virtualChildAt2.getMarginLeft()) - virtualChildAt2.getMarginRight();
                    virtualChildAt2.setVisibility(2);
                    if (max <= size) {
                        break;
                    }
                }
            }
        } else if (z && !this.alwaysShowIndicator) {
            dXWidgetNode.setVisibility(2);
        }
        if (!z3 && mode != 1073741824) {
            i5 = i10;
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(max, i), DXWidgetNode.resolveSize(Math.max(i5 + this.paddingTop + this.paddingBottom, getSuggestedMinimumHeight()), i2));
        this.mTotalLength = max;
        if (z4) {
            forceUniformHeight(virtualChildCount, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode
    protected void measureVertical(int i, int i2) {
        boolean z;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int i3 = 0;
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = false;
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i5);
            if (virtualChildAt == null || virtualChildAt.getVisibility() == 2) {
                i3 = i3;
            } else {
                int i6 = i3;
                measureChildWithMargins(virtualChildAt, i, 0, i2, 0);
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                int i7 = this.mTotalLength;
                this.mTotalLength = Math.max(i7, i7 + measuredHeight + virtualChildAt.getMarginTop() + virtualChildAt.getMarginBottom());
                if (mode == 1073741824 || virtualChildAt.layoutWidth != -1) {
                    z = false;
                } else {
                    z = true;
                    z3 = true;
                }
                int marginLeft = virtualChildAt.getMarginLeft() + virtualChildAt.getMarginRight();
                i4 = Math.max(i4, virtualChildAt.getMeasuredWidth() + marginLeft);
                z2 = z2 && virtualChildAt.layoutHeight == -1;
                if (z) {
                    measuredHeight = marginLeft;
                }
                i3 = Math.max(i6, measuredHeight);
            }
        }
        int i8 = i3;
        int i9 = this.mTotalLength + this.paddingTop + this.paddingBottom;
        this.mTotalLength = i9;
        int max = Math.max(i9, getSuggestedMinimumHeight());
        if (max > size) {
            for (int i10 = virtualChildCount - 1; i10 >= 0; i10--) {
                DXWidgetNode virtualChildAt2 = getVirtualChildAt(i10);
                max = ((max - virtualChildAt2.getMeasuredHeight()) - virtualChildAt2.getMarginTop()) - virtualChildAt2.getMarginBottom();
                virtualChildAt2.setVisibility(2);
                if (max <= size) {
                    break;
                }
            }
        }
        if (!z2 && mode2 != 1073741824) {
            i4 = i8;
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(Math.max(i4 + this.paddingLeft + this.paddingRight, getSuggestedMinimumWidth()), i), DXWidgetNode.resolveSize(max, i2));
        this.mTotalLength = max;
        if (z3) {
            forceUniformWidth(virtualChildCount, i2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        boolean z;
        if ((this.propertyInitFlag & 2) == 0) {
            return;
        }
        if (getListData() != null && !getListData().isEmpty() && getChildren() != null) {
            DXWidgetNode dXWidgetNode = null;
            String str = this.moreIndicatorUserId;
            if (str == null || (dXWidgetNode = queryWTByUserId(str)) == null) {
                z = false;
            } else {
                removeChildWithAutoId(dXWidgetNode.getAutoId());
                z = true;
            }
            ArrayList arrayList = (ArrayList) getChildren();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < getListData().size(); i++) {
                Object obj = getListData().get(i);
                if (i == 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        bindContext((DXWidgetNode) it.next(), obj, i);
                    }
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        DXWidgetNode dXWidgetNode2 = (DXWidgetNode) it2.next();
                        DXRuntimeContext cloneWithWidgetNode = dXWidgetNode2.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode2);
                        cloneWithWidgetNode.setSubData(obj);
                        cloneWithWidgetNode.setSubdataIndex(i);
                        arrayList2.add(g.b(dXWidgetNode2, cloneWithWidgetNode));
                    }
                }
            }
            if (z) {
                arrayList2.add(dXWidgetNode);
            }
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                addChild((DXWidgetNode) arrayList2.get(i2), false);
            }
            return;
        }
        removeAllChild();
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXAdaptiveLinearLayoutWidgetNode)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXAdaptiveLinearLayoutWidgetNode dXAdaptiveLinearLayoutWidgetNode = (DXAdaptiveLinearLayoutWidgetNode) dXWidgetNode;
        this.alwaysShowIndicator = dXAdaptiveLinearLayoutWidgetNode.alwaysShowIndicator;
        this.moreIndicatorUserId = dXAdaptiveLinearLayoutWidgetNode.moreIndicatorUserId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeAdaptiveLinearLayout(context);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXADAPTIVELINEARLAYOUT_ALWAYSSHOWINDICATOR) {
            this.alwaysShowIndicator = i != 0;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == DXADAPTIVELINEARLAYOUT_MOREINDICATORUSERID) {
            this.moreIndicatorUserId = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
