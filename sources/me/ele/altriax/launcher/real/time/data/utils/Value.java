package me.ele.altriax.launcher.real.time.data.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Value {
    private static final String TRUE = "true";

    public static double decimalPlaces(int i, double d) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    public static boolean stringTrue(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "true".equals(str);
    }
}
