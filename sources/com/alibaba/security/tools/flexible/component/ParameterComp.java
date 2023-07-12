package com.alibaba.security.tools.flexible.component;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.security.tools.flexible.FlexibleComponent;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ParameterComp implements IFlexibleComp {
    private static final String TAG = "ParameterComp";

    @Override // com.alibaba.security.tools.flexible.component.IFlexibleComp
    public void adaptive(View view, BigDecimal bigDecimal) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            view.setLayoutParams(autoLayoutParameters(layoutParams, bigDecimal, view));
        }
    }

    ViewGroup.LayoutParams autoLayoutParameters(ViewGroup.LayoutParams layoutParams, BigDecimal bigDecimal, View view) {
        int i = layoutParams.width;
        if (i > 0) {
            layoutParams.width = FlexibleComponent.INSTANCE.calculate(bigDecimal, i);
        } else if (i == -10) {
            layoutParams.width = 1;
        }
        int i2 = layoutParams.height;
        if (i2 > 0) {
            layoutParams.height = FlexibleComponent.INSTANCE.calculate(bigDecimal, i2);
        } else if (i2 == -10) {
            layoutParams.height = 1;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = marginLayoutParams.leftMargin;
            if (i3 > 0) {
                marginLayoutParams.leftMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i3);
            } else if (i3 == -10) {
                marginLayoutParams.leftMargin = 1;
            }
            int i4 = marginLayoutParams.rightMargin;
            if (i4 > 0) {
                marginLayoutParams.rightMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i4);
            } else if (i4 == -10) {
                marginLayoutParams.rightMargin = 1;
            }
            int i5 = marginLayoutParams.topMargin;
            if (i5 > 0) {
                marginLayoutParams.topMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i5);
            } else if (i5 == -10) {
                marginLayoutParams.topMargin = 1;
            }
            int i6 = marginLayoutParams.bottomMargin;
            if (i6 > 0) {
                marginLayoutParams.bottomMargin = FlexibleComponent.INSTANCE.calculate(bigDecimal, i6);
            } else if (i6 == -10) {
                marginLayoutParams.bottomMargin = 1;
            }
        }
        return layoutParams;
    }
}
