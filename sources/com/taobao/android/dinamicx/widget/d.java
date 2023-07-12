package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.ArrayList;
import tb.lz;
import tb.te;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d extends f {
    private final ArrayList<DXWidgetNode> a = new ArrayList<>(1);
    boolean b = false;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new d();
        }
    }

    private int a() {
        int i = this.paddingBottom;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    private int b() {
        int paddingLeftWithDirection = getPaddingLeftWithDirection();
        if (paddingLeftWithDirection > 0) {
            return paddingLeftWithDirection;
        }
        return 0;
    }

    private int c() {
        int paddingRightWithDirection = getPaddingRightWithDirection();
        if (paddingRightWithDirection > 0) {
            return paddingRightWithDirection;
        }
        return 0;
    }

    private int d() {
        int i = this.paddingTop;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new d();
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void e(int i, int i2, int i3, int i4, boolean z) {
        int leftMarginWithDirection;
        int leftMarginWithDirection2;
        int rightMarginWithDirection;
        int i5;
        int i6;
        int virtualChildCount = getVirtualChildCount();
        int direction = getDirection();
        int b = b();
        int c = (i3 - i) - c();
        int d = d();
        int a2 = (i4 - i2) - a();
        for (int i7 = 0; i7 < virtualChildCount; i7++) {
            DXWidgetNode childAt = getChildAt(i7);
            if (childAt.getVisibility() != 2) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = childAt.layoutGravity;
                if (i8 == 0 && (childAt.propertyInitFlag & 1) == 0) {
                    i8 = 0;
                }
                int absoluteGravity = DXWidgetNode.getAbsoluteGravity(i8, direction);
                switch (absoluteGravity) {
                    case 3:
                    case 4:
                    case 5:
                        leftMarginWithDirection2 = (((c - b) - measuredWidth) / 2) + b + childAt.getLeftMarginWithDirection();
                        rightMarginWithDirection = childAt.getRightMarginWithDirection();
                        leftMarginWithDirection = leftMarginWithDirection2 - rightMarginWithDirection;
                        break;
                    case 6:
                    case 7:
                    case 8:
                        if (!z) {
                            leftMarginWithDirection2 = c - measuredWidth;
                            rightMarginWithDirection = childAt.getRightMarginWithDirection();
                            leftMarginWithDirection = leftMarginWithDirection2 - rightMarginWithDirection;
                            break;
                        }
                    default:
                        leftMarginWithDirection = childAt.getLeftMarginWithDirection() + b;
                        break;
                }
                switch (absoluteGravity) {
                    case 0:
                    case 3:
                    case 6:
                        i5 = childAt.marginTop;
                        i6 = i5 + d;
                        break;
                    case 1:
                    case 4:
                    case 7:
                        i6 = (((((a2 - d) - measuredHeight) / 2) + d) + childAt.marginTop) - childAt.marginBottom;
                        break;
                    case 2:
                    case 5:
                    case 8:
                        i6 = (a2 - measuredHeight) - childAt.marginBottom;
                        break;
                    default:
                        i5 = childAt.marginTop;
                        i6 = i5 + d;
                        break;
                }
                childAt.layout(leftMarginWithDirection, i6, measuredWidth + leftMarginWithDirection, measuredHeight + i6);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public ViewGroup.LayoutParams generateLayoutParams(lz lzVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(lzVar.a, lzVar.b);
        layoutParams.gravity = lzVar.d;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeFrameLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e(i, i2, i3, i4, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int childMeasureSpec;
        int childMeasureSpec2;
        int virtualChildCount = getVirtualChildCount();
        boolean z = (DXWidgetNode.DXMeasureSpec.a(i) == 1073741824 && DXWidgetNode.DXMeasureSpec.a(i2) == 1073741824) ? false : true;
        this.a.clear();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            DXWidgetNode childAt = getChildAt(i6);
            if (this.b || childAt.getVisibility() != 2) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                i5 = Math.max(i5, childAt.getMeasuredWidth() + childAt.marginLeft + childAt.marginRight);
                i4 = Math.max(i4, childAt.getMeasuredHeight() + childAt.marginTop + childAt.marginBottom);
                i3 = DXWidgetNode.combineMeasuredStates(i3, childAt.getMeasuredState());
                if (z && (childAt.layoutWidth == -1 || childAt.layoutHeight == -1)) {
                    this.a.add(childAt);
                }
            }
        }
        int i7 = i3;
        setMeasuredDimension(DXWidgetNode.resolveSizeAndState(Math.max(i5 + b() + c(), getSuggestedMinimumWidth()), i, i7), DXWidgetNode.resolveSizeAndState(Math.max(i4 + d() + a(), getSuggestedMinimumHeight()), i2, i7 << 16));
        int size = this.a.size();
        if (size > 1) {
            for (int i8 = 0; i8 < size; i8++) {
                DXWidgetNode dXWidgetNode = this.a.get(i8);
                int i9 = dXWidgetNode.layoutWidth;
                if (i9 == -1) {
                    childMeasureSpec = DXWidgetNode.DXMeasureSpec.c(Math.max(0, (((getMeasuredWidth() - this.paddingLeft) - this.paddingRight) - dXWidgetNode.marginLeft) - dXWidgetNode.marginRight), 1073741824);
                } else {
                    childMeasureSpec = f.getChildMeasureSpec(i, this.paddingLeft + this.paddingRight + dXWidgetNode.marginLeft + dXWidgetNode.marginRight, i9);
                }
                int i10 = dXWidgetNode.layoutHeight;
                if (i10 == -1) {
                    childMeasureSpec2 = DXWidgetNode.DXMeasureSpec.c(Math.max(0, (((getMeasuredHeight() - this.paddingTop) - this.paddingBottom) - dXWidgetNode.marginTop) - dXWidgetNode.marginBottom), 1073741824);
                } else {
                    childMeasureSpec2 = f.getChildMeasureSpec(i2, this.paddingTop + this.paddingBottom + dXWidgetNode.marginTop + dXWidgetNode.marginBottom, i10);
                }
                dXWidgetNode.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (9346582897824575L == j) {
            this.layoutHeight = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (hasCornerRadius()) {
            DXNativeFrameLayout dXNativeFrameLayout = (DXNativeFrameLayout) view;
            te teVar = new te();
            int i = this.cornerRadius;
            if (i > 0) {
                teVar.j(view, i);
            } else {
                teVar.k(view, this.cornerRadiusLeftTop, this.cornerRadiusRightTop, this.cornerRadiusLeftBottom, this.cornerRadiusRightBottom);
            }
            dXNativeFrameLayout.setClipRadiusHandler(teVar);
        } else {
            te cLipRadiusHandler = ((DXNativeFrameLayout) view).getCLipRadiusHandler();
            if (cLipRadiusHandler != null) {
                cLipRadiusHandler.j(view, 0.0f);
            }
        }
        super.setBackground(view);
    }

    @Override // com.taobao.android.dinamicx.widget.f
    public ViewGroup.LayoutParams generateLayoutParams(@NonNull lz lzVar, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = lzVar.d;
        }
        layoutParams.width = lzVar.a;
        layoutParams.height = lzVar.b;
        return layoutParams;
    }
}
