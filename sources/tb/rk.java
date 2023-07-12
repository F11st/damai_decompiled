package tb;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class rk {
    public static GradientDrawable a(List<String> list) {
        return b(list, null);
    }

    public static GradientDrawable b(List<String> list, float[] fArr) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        if (list.size() == 1) {
            list.add(list.get(0));
        }
        return d((String[]) list.toArray(new String[list.size()]), fArr);
    }

    public static GradientDrawable c(String[] strArr) {
        return d(strArr, null);
    }

    public static GradientDrawable d(String[] strArr, float[] fArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        if (strArr.length == 1) {
            strArr = new String[]{strArr[0], strArr[0]};
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!(str instanceof String)) {
                str = null;
            }
            arrayList.add(Integer.valueOf(e(str, 0)));
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        if (fArr != null) {
            gradientDrawable.setCornerRadii(fArr);
        }
        return gradientDrawable;
    }

    public static int e(String str, int i) {
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
