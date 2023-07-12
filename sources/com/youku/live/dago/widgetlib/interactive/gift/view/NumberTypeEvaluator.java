package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.TypeEvaluator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.DecimalFormat;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NumberTypeEvaluator implements TypeEvaluator<Integer> {
    private static transient /* synthetic */ IpChange $ipChange;
    private DecimalFormat decimalFormat = new DecimalFormat(".00");

    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1717332952")) {
            return (Integer) ipChange.ipc$dispatch("1717332952", new Object[]{this, Float.valueOf(f), num, num2});
        }
        try {
            f2 = Float.parseFloat(this.decimalFormat.format(f));
        } catch (NumberFormatException unused) {
            f2 = 0.0f;
        }
        return Integer.valueOf((int) (num.intValue() + (f2 * (num2.intValue() - num.intValue()))));
    }
}
