package com.taobao.weex.ui.animation;

import android.graphics.drawable.ColorDrawable;
import android.util.Property;
import android.view.View;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BackgroundColorProperty extends Property<View, Integer> {
    private static final String TAG = "BackgroundColorAnimation";

    public BackgroundColorProperty() {
        super(Integer.class, "backgroundColor");
    }

    @Override // android.util.Property
    public Integer get(View view) {
        int i;
        BorderDrawable borderDrawable = WXViewUtils.getBorderDrawable(view);
        if (borderDrawable != null) {
            i = borderDrawable.getColor();
        } else if (view.getBackground() instanceof ColorDrawable) {
            i = ((ColorDrawable) view.getBackground()).getColor();
        } else {
            i = 0;
            WXLogUtils.e(TAG, "Unsupported background type");
        }
        return Integer.valueOf(i);
    }

    @Override // android.util.Property
    public void set(View view, Integer num) {
        BorderDrawable borderDrawable = WXViewUtils.getBorderDrawable(view);
        if (borderDrawable != null) {
            borderDrawable.setColor(num.intValue());
        } else if (view.getBackground() instanceof ColorDrawable) {
            ((ColorDrawable) view.getBackground()).setColor(num.intValue());
        } else {
            WXLogUtils.e(TAG, "Unsupported background type");
        }
    }
}
