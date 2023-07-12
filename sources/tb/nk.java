package tb;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class nk {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001791547")) {
            return ((Integer) ipChange.ipc$dispatch("1001791547", new Object[]{str})).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return Color.parseColor("#00000000");
        }
        return Color.parseColor((TextUtils.isEmpty("#00000000") || !Pattern.compile("^#[0-9a-fA-F]{6}$").matcher(str).matches()) ? "#00000000" : "#00000000");
    }

    public static String b(String str) {
        String hexString;
        String hexString2;
        String hexString3;
        String hexString4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064608462")) {
            return (String) ipChange.ipc$dispatch("-1064608462", new Object[]{str});
        }
        if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return str;
        }
        String str2 = "#ffffff";
        try {
            String[] split = str.replace("rgba", "").replace(jn1.BRACKET_START_STR, "").replace(jn1.BRACKET_END_STR, "").replace(StringUtils.LF, "").replace(" ", "").split(",");
            if (Integer.toHexString(Integer.parseInt(split[0])).length() == 1) {
                hexString = "0" + Integer.toHexString(Integer.parseInt(split[0]));
            } else {
                hexString = Integer.toHexString(Integer.parseInt(split[0]));
            }
            if (Integer.toHexString(Integer.parseInt(split[1])).length() == 1) {
                hexString2 = "0" + Integer.toHexString(Integer.parseInt(split[1]));
            } else {
                hexString2 = Integer.toHexString(Integer.parseInt(split[1]));
            }
            if (Integer.toHexString(Integer.parseInt(split[2])).length() == 1) {
                hexString3 = "0" + Integer.toHexString(Integer.parseInt(split[2]));
            } else {
                hexString3 = Integer.toHexString(Integer.parseInt(split[2]));
            }
            if (Integer.toHexString(Float.valueOf(Float.parseFloat(split[3]) * 255.0f).intValue()).length() == 1) {
                hexString4 = "0" + Integer.toHexString(Float.valueOf(Float.parseFloat(split[3]) * 255.0f).intValue());
            } else {
                hexString4 = Integer.toHexString(Float.valueOf(Float.parseFloat(split[3]) * 255.0f).intValue());
            }
            str2 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + hexString4 + hexString + hexString2 + hexString3;
            Color.parseColor(str);
            return str2;
        } catch (ArrayIndexOutOfBoundsException e) {
            cb1.d(e);
            return str2;
        } catch (NumberFormatException e2) {
            cb1.d(e2);
            return str2;
        } catch (IllegalArgumentException e3) {
            cb1.d(e3);
            return str2;
        }
    }

    public static int c(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-45143282") ? ((Integer) ipChange.ipc$dispatch("-45143282", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue() : Color.argb(Math.round(f * 255.0f), (16711680 & i) >> 16, (65280 & i) >> 8, i & 255);
    }
}
