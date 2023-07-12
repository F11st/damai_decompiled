package com.taobao.weex.ui.animation;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.IRenderResult;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
abstract class LayoutParamsProperty extends Property<View, Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutParamsProperty() {
        super(Integer.class, "layoutParams");
    }

    protected abstract Integer getProperty(ViewGroup.LayoutParams layoutParams);

    protected abstract void setProperty(ViewGroup.LayoutParams layoutParams, Integer num);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Integer get(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            return getProperty(layoutParams);
        }
        return 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public void set(View view, Integer num) {
        ViewGroup.LayoutParams layoutParams;
        WXComponent component;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        setProperty(layoutParams, num);
        if ((view instanceof IRenderResult) && (component = ((IRenderResult) view).getComponent()) != null) {
            component.notifyNativeSizeChanged(layoutParams.width, layoutParams.height);
        }
        view.requestLayout();
    }
}
