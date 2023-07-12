package tb;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class mk {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384560931")) {
            return ((Integer) ipChange.ipc$dispatch("-384560931", new Object[]{str})).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return Color.parseColor("#00000000");
            }
            Matcher matcher = Pattern.compile("^#[0-9a-fA-F]{6}$").matcher(str);
            if (TextUtils.isEmpty("#00000000") || !matcher.matches()) {
                str = "#00000000";
            }
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int b(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1627474860") ? ((Integer) ipChange.ipc$dispatch("1627474860", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : Color.argb(Math.round(f * 255.0f), (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }
}
