package com.alibaba.security.tools.flexible.component;

import android.view.View;
import android.widget.TextView;
import com.alibaba.security.tools.flexible.FlexibleComponent;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TextSizeComp implements IFlexibleComp {
    private static final String TAG = "TextSizeComp";

    @Override // com.alibaba.security.tools.flexible.component.IFlexibleComp
    public void adaptive(View view, BigDecimal bigDecimal) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            float textSize = textView.getTextSize();
            FlexibleComponent flexibleComponent = FlexibleComponent.INSTANCE;
            textView.setTextSize(0, flexibleComponent.calculate(bigDecimal, textSize) * flexibleComponent.getScaledDensity());
        }
    }
}
