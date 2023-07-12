package com.taobao.weex.ui.animation;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WidthProperty extends LayoutParamsProperty {
    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    public /* bridge */ /* synthetic */ Integer get(View view) {
        return super.get(view);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    protected Integer getProperty(ViewGroup.LayoutParams layoutParams) {
        return Integer.valueOf(layoutParams.width);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    public /* bridge */ /* synthetic */ void set(View view, Integer num) {
        super.set(view, num);
    }

    @Override // com.taobao.weex.ui.animation.LayoutParamsProperty
    protected void setProperty(ViewGroup.LayoutParams layoutParams, Integer num) {
        layoutParams.width = num.intValue();
    }
}
