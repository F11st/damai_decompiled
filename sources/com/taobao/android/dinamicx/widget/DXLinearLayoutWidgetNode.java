package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.view.DXNativeLinearLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.lz;
import tb.te;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXLinearLayoutWidgetNode extends C6493f implements Cloneable {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int mOrientation;
    int mTotalLength;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode$a */
    /* loaded from: classes11.dex */
    public static class C6443a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXLinearLayoutWidgetNode();
        }
    }

    private void setChildFrame(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4) {
        dXWidgetNode.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        return new DXLinearLayoutWidgetNode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forceUniformHeight(int i, int i2) {
        int c = DXWidgetNode.DXMeasureSpec.c(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 2 && virtualChildAt.layoutHeight == -1) {
                int i4 = virtualChildAt.layoutWidth;
                virtualChildAt.layoutWidth = virtualChildAt.getMeasuredWidth();
                measureChildWithMargins(virtualChildAt, i2, 0, c, 0);
                virtualChildAt.layoutWidth = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void forceUniformWidth(int i, int i2) {
        int c = DXWidgetNode.DXMeasureSpec.c(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            DXWidgetNode virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 2 && virtualChildAt.layoutWidth == -1) {
                int i4 = virtualChildAt.layoutHeight;
                virtualChildAt.layoutHeight = virtualChildAt.getMeasuredHeight();
                measureChildWithMargins(virtualChildAt, c, 0, i2, 0);
                virtualChildAt.layoutHeight = i4;
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f
    public ViewGroup.LayoutParams generateLayoutParams(lz lzVar) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lzVar.a, lzVar.b);
        layoutParams.gravity = lzVar.d;
        return layoutParams;
    }

    int getChildrenSkipCount(DXWidgetNode dXWidgetNode, int i) {
        return 0;
    }

    int getLocationOffset(DXWidgetNode dXWidgetNode) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeftWithDirection;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean isLayoutRtl = isLayoutRtl();
        int i11 = this.paddingTop;
        int i12 = i4 - i2;
        int i13 = this.paddingBottom;
        int i14 = i12 - i13;
        int i15 = (i12 - i11) - i13;
        int virtualChildCount = getVirtualChildCount();
        int i16 = 2;
        switch (DXWidgetNode.getAbsoluteGravity(this.childGravity, getDirection())) {
            case 3:
            case 4:
            case 5:
                paddingLeftWithDirection = getPaddingLeftWithDirection() + (((i3 - i) - this.mTotalLength) / 2);
                break;
            case 6:
            case 7:
            case 8:
                paddingLeftWithDirection = ((getPaddingLeftWithDirection() + i3) - i) - this.mTotalLength;
                break;
            default:
                paddingLeftWithDirection = getPaddingLeftWithDirection();
                break;
        }
        if (isLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i17 = 0;
        while (i17 < virtualChildCount) {
            int i18 = i5 + (i6 * i17);
            DXWidgetNode virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                paddingLeftWithDirection += measureNullChild(i18);
            } else if (virtualChildAt.getVisibility() != i16) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                int i19 = virtualChildAt.layoutGravity;
                if ((virtualChildAt.propertyInitFlag & 1) == 0 && i19 == 0) {
                    i19 = this.childGravity;
                }
                switch (i19) {
                    case 0:
                    case 3:
                    case 6:
                        i7 = virtualChildAt.marginTop + i11;
                        i10 = i7;
                        break;
                    case 1:
                    case 4:
                    case 7:
                        i8 = ((i15 - measuredHeight) / i16) + i11 + virtualChildAt.marginTop;
                        i9 = virtualChildAt.marginBottom;
                        i7 = i8 - i9;
                        i10 = i7;
                        break;
                    case 2:
                    case 5:
                    case 8:
                        i8 = i14 - measuredHeight;
                        i9 = virtualChildAt.marginBottom;
                        i7 = i8 - i9;
                        i10 = i7;
                        break;
                    default:
                        i10 = i11;
                        break;
                }
                int leftMarginWithDirection = paddingLeftWithDirection + virtualChildAt.getLeftMarginWithDirection();
                setChildFrame(virtualChildAt, leftMarginWithDirection + getLocationOffset(virtualChildAt), i10, measuredWidth, measuredHeight);
                i17 += getChildrenSkipCount(virtualChildAt, i18);
                paddingLeftWithDirection = leftMarginWithDirection + measuredWidth + virtualChildAt.getRightMarginWithDirection() + getNextLocationOffset(virtualChildAt);
            }
            i17++;
            i16 = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void layoutVertical(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getDirection()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRightWithDirection()
            int r8 = r0 - r1
            int r1 = r17.getPaddingLeftWithDirection()
            int r0 = r0 - r1
            int r1 = r17.getPaddingRightWithDirection()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.childGravity
            r11 = 1
            r12 = 2
            if (r0 == r11) goto L3f
            if (r0 == r12) goto L35
            r1 = 4
            if (r0 == r1) goto L3f
            r1 = 5
            if (r0 == r1) goto L35
            r1 = 7
            if (r0 == r1) goto L3f
            r1 = 8
            if (r0 == r1) goto L35
            int r0 = r6.paddingTop
            goto L48
        L35:
            int r0 = r6.paddingTop
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.mTotalLength
            int r0 = r0 - r1
            goto L48
        L3f:
            int r0 = r6.paddingTop
            int r1 = r21 - r19
            int r2 = r6.mTotalLength
            int r1 = r1 - r2
            int r1 = r1 / r12
            int r0 = r0 + r1
        L48:
            r1 = 0
            r13 = 0
        L4a:
            if (r13 >= r10) goto Lc1
            com.taobao.android.dinamicx.widget.DXWidgetNode r14 = r6.getVirtualChildAt(r13)
            if (r14 != 0) goto L58
            int r1 = r6.measureNullChild(r13)
            int r0 = r0 + r1
            goto Lbf
        L58:
            int r1 = r14.getVisibility()
            if (r1 == r12) goto Lbf
            int r4 = r14.getMeasuredWidth()
            int r15 = r14.getMeasuredHeight()
            int r1 = r14.layoutGravity
            int r2 = r14.propertyInitFlag
            r2 = r2 & r11
            if (r2 != 0) goto L71
            if (r1 != 0) goto L71
            int r1 = r6.childGravity
        L71:
            int r1 = com.taobao.android.dinamicx.widget.DXWidgetNode.getAbsoluteGravity(r1, r7)
            switch(r1) {
                case 3: goto L8a;
                case 4: goto L8a;
                case 5: goto L8a;
                case 6: goto L83;
                case 7: goto L83;
                case 8: goto L83;
                default: goto L78;
            }
        L78:
            int r1 = r17.getPaddingLeftWithDirection()
            int r2 = r14.getLeftMarginWithDirection()
            int r1 = r1 + r2
        L81:
            r2 = r1
            goto L9d
        L83:
            int r1 = r8 - r4
            int r2 = r14.getRightMarginWithDirection()
            goto L9b
        L8a:
            int r1 = r17.getPaddingLeftWithDirection()
            int r2 = r9 - r4
            int r2 = r2 / r12
            int r1 = r1 + r2
            int r2 = r14.getLeftMarginWithDirection()
            int r1 = r1 + r2
            int r2 = r14.getRightMarginWithDirection()
        L9b:
            int r1 = r1 - r2
            goto L81
        L9d:
            int r1 = r14.marginTop
            int r16 = r0 + r1
            int r0 = r6.getLocationOffset(r14)
            int r3 = r16 + r0
            r0 = r17
            r1 = r14
            r5 = r15
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r0 = r14.marginBottom
            int r15 = r15 + r0
            int r0 = r6.getNextLocationOffset(r14)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.getChildrenSkipCount(r14, r13)
            int r13 = r13 + r0
            r0 = r16
        Lbf:
            int r13 = r13 + r11
            goto L4a
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode.layoutVertical(int, int, int, int):void");
    }

    void measureChildBeforeLayout(DXWidgetNode dXWidgetNode, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(dXWidgetNode, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void measureHorizontal(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 637
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode.measureHorizontal(int, int):void");
    }

    int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void measureVertical(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode.measureVertical(int, int):void");
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXLinearLayoutWidgetNode) {
            this.mOrientation = ((DXLinearLayoutWidgetNode) dXWidgetNode).mOrientation;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeLinearLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view != null && (view instanceof LinearLayout)) {
            ((LinearLayout) view).setOrientation(this.mOrientation);
        }
        super.onRenderView(context, view);
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (-7199229155167727177L == j) {
            this.mOrientation = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (view instanceof DXNativeLinearLayout) {
            if (hasCornerRadius()) {
                DXNativeLinearLayout dXNativeLinearLayout = (DXNativeLinearLayout) view;
                te teVar = new te();
                int i = this.cornerRadius;
                if (i > 0) {
                    teVar.j(view, i);
                } else {
                    teVar.k(view, this.cornerRadiusLeftTop, this.cornerRadiusRightTop, this.cornerRadiusLeftBottom, this.cornerRadiusRightBottom);
                }
                dXNativeLinearLayout.setClipRadiusHandler(teVar);
            } else {
                te cLipRadiusHandler = ((DXNativeLinearLayout) view).getCLipRadiusHandler();
                if (cLipRadiusHandler != null) {
                    cLipRadiusHandler.j(view, 0.0f);
                }
            }
        }
        super.setBackground(view);
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f
    public ViewGroup.LayoutParams generateLayoutParams(@NonNull lz lzVar, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = lzVar.d;
        }
        layoutParams.width = lzVar.a;
        layoutParams.height = lzVar.b;
        return layoutParams;
    }
}
