package tb;

import android.graphics.Color;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ok {
    public static int a(String str, int i) {
        if (str == null || str.length() <= 0) {
            return i;
        }
        String lowerCase = str.toLowerCase(Locale.SIMPLIFIED_CHINESE);
        StringBuilder sb = new StringBuilder(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        for (int i2 = 1; i2 < 9 && i2 < lowerCase.length(); i2++) {
            char charAt = lowerCase.charAt(i2);
            if ((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'f')) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        return (sb2.length() == 7 || sb2.length() == 9) ? Color.parseColor(sb2) : i;
    }
}
