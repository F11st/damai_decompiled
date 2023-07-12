package com.alibaba.security.tools.flexible.component;

import android.view.View;
import com.alibaba.security.tools.flexible.FlexibleComponent;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PaddingComp implements IFlexibleComp {
    private static final String TAG = "PaddingComp";

    @Override // com.alibaba.security.tools.flexible.component.IFlexibleComp
    public void adaptive(View view, BigDecimal bigDecimal) {
        int i;
        int i2;
        int i3;
        int i4 = 1;
        if (view.getPaddingLeft() > 0) {
            i = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingLeft());
        } else {
            i = view.getPaddingLeft() == -10 ? 1 : 0;
        }
        if (view.getPaddingTop() > 0) {
            i2 = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingTop());
        } else {
            i2 = view.getPaddingTop() == -10 ? 1 : 0;
        }
        if (view.getPaddingRight() > 0) {
            i3 = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingRight());
        } else {
            i3 = view.getPaddingRight() == -10 ? 1 : 0;
        }
        if (view.getPaddingBottom() > 0) {
            i4 = FlexibleComponent.INSTANCE.calculate(bigDecimal, view.getPaddingBottom());
        } else if (view.getPaddingBottom() != -10) {
            i4 = 0;
        }
        view.setPadding(i, i2, i3, i4);
    }
}
