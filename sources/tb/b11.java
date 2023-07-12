package tb;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b11 {
    private static final Map<String, Typeface> a = new LinkedHashMap();
    private static Typeface b = null;

    public static Typeface a(@NonNull Context context, @Nullable String str) {
        Typeface typeface;
        if (TextUtils.isEmpty(str)) {
            return b(context);
        }
        Map<String, Typeface> map = a;
        synchronized (map) {
            typeface = map.get(str);
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(context.getAssets(), str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (typeface != null) {
                    a.put(str, typeface);
                } else {
                    typeface = b(context);
                }
            }
        }
        return typeface;
    }

    public static Typeface b(@NonNull Context context) {
        if (b == null) {
            b = Typeface.createFromAsset(context.getAssets(), "icon.ttf");
        }
        return b;
    }
}
