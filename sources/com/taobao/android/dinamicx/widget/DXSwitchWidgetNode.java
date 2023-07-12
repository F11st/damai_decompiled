package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.view.DXNativeSwitch;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.ey;
import tb.n10;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXSwitchWidgetNode extends DXWidgetNode implements Cloneable {
    public static final int OFF = 0;
    public static final int ON = 1;
    private int switchOn;
    private static int TAG_SWITCH_ON_COLOR = R$id.dx_switch_background_on_color;
    private static int TAG_SWITCH_OFF_COLOR = R$id.dx_switch_background_off_color;
    private int onColor = -45056;
    private int offColor = -1710619;
    private boolean isInitSwitchState = false;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXSwitchWidgetNode$a */
    /* loaded from: classes11.dex */
    public static class C6460a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            return new DXSwitchWidgetNode();
        }
    }

    public DXSwitchWidgetNode() {
        this.accessibility = 1;
    }

    private StateListDrawable getSelector(Drawable drawable, Drawable drawable2) {
        return ey.b(drawable, drawable2, ey.STATE_CHECKED);
    }

    private GradientDrawable getThumbDrawable(Context context, int i) {
        return ey.c((int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()), 16777215, i / 2, -1, i, i);
    }

    private GradientDrawable getTrackDrawable(int i, int i2) {
        return ey.c(0, 16777215, i2 / 2, i, i2, i2);
    }

    private void setBackground(Context context, DXNativeSwitch dXNativeSwitch) {
        Object tag = dXNativeSwitch.getTag(TAG_SWITCH_ON_COLOR);
        Object tag2 = dXNativeSwitch.getTag(TAG_SWITCH_OFF_COLOR);
        if (tag == null || tag2 == null || ((Integer) tag).intValue() != this.onColor || ((Integer) tag2).intValue() != this.offColor) {
            int tryFetchDarkModeColor = tryFetchDarkModeColor("onColor", 1, this.onColor);
            int tryFetchDarkModeColor2 = tryFetchDarkModeColor("offColor", 1, this.offColor);
            GradientDrawable thumbDrawable = getThumbDrawable(context, getMeasuredHeight());
            dXNativeSwitch.setTrackDrawable(getSelector(getTrackDrawable(tryFetchDarkModeColor, getMeasuredHeight()), getTrackDrawable(tryFetchDarkModeColor2, getMeasuredHeight())));
            dXNativeSwitch.setThumbDrawable(thumbDrawable);
            dXNativeSwitch.setTag(TAG_SWITCH_ON_COLOR, Integer.valueOf(tryFetchDarkModeColor));
            dXNativeSwitch.setTag(TAG_SWITCH_OFF_COLOR, Integer.valueOf(tryFetchDarkModeColor2));
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXSwitchWidgetNode();
    }

    public int getOffColor() {
        return this.offColor;
    }

    public int getOnColor() {
        return this.onColor;
    }

    public int getSwitchOn() {
        return this.switchOn;
    }

    public boolean isInitSwitchState() {
        return this.isInitSwitchState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        if (view != null && (view instanceof DXNativeSwitch) && j == 5288679823228297259L) {
            ((DXNativeSwitch) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.taobao.android.dinamicx.widget.DXSwitchWidgetNode.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (DXSwitchWidgetNode.this.isInitSwitchState) {
                        return;
                    }
                    n10 n10Var = new n10(5288679823228297259L);
                    n10Var.f(z);
                    DXSwitchWidgetNode.this.postEvent(n10Var);
                }
            });
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXSwitchWidgetNode) {
            DXSwitchWidgetNode dXSwitchWidgetNode = (DXSwitchWidgetNode) dXWidgetNode;
            this.switchOn = dXSwitchWidgetNode.switchOn;
            this.offColor = dXSwitchWidgetNode.offColor;
            this.onColor = dXSwitchWidgetNode.onColor;
            this.isInitSwitchState = dXSwitchWidgetNode.isInitSwitchState;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeSwitch(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        int a = DXWidgetNode.DXMeasureSpec.a(i);
        int a2 = DXWidgetNode.DXMeasureSpec.a(i2);
        setMeasuredDimension(a == 1073741824 ? DXWidgetNode.DXMeasureSpec.b(i) : 0, a2 == 1073741824 ? DXWidgetNode.DXMeasureSpec.b(i2) : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (view == null || !(view instanceof DXNativeSwitch)) {
            return;
        }
        DXNativeSwitch dXNativeSwitch = (DXNativeSwitch) view;
        dXNativeSwitch.setClickable(true);
        dXNativeSwitch.setTextOn("");
        dXNativeSwitch.setTextOff("");
        dXNativeSwitch.setShowText(false);
        dXNativeSwitch.setThumbTextPadding(0);
        dXNativeSwitch.setSplitTrack(false);
        setBackground(context, dXNativeSwitch);
        this.isInitSwitchState = true;
        dXNativeSwitch.setChecked(this.switchOn == 1);
        this.isInitSwitchState = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (C6495h.DX_PAGE_INDICATOR_ON_COLOR == j) {
            this.onColor = i;
        } else if (C6495h.DX_PAGE_INDICATOR_OFF_COLOR == j) {
            this.offColor = i;
        } else if (6477083193262386775L == j) {
            this.switchOn = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    public void setInitSwitchState(boolean z) {
        this.isInitSwitchState = z;
    }

    public void setOffColor(int i) {
        this.offColor = i;
    }

    public void setOnColor(int i) {
        this.onColor = i;
    }

    public void setSwitchOn(int i) {
        this.switchOn = i;
    }
}
