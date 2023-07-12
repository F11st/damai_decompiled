package tb;

import android.graphics.Typeface;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bp0 {
    private static bp0 b = new bp0();
    private ConcurrentHashMap<String, Typeface> a = new ConcurrentHashMap<>();

    public static bp0 a() {
        return b;
    }

    public Typeface b(String str, Typeface typeface) {
        Typeface typeface2 = this.a.get(str);
        if (typeface2 == null) {
            this.a.put(str, typeface);
            return typeface;
        }
        return typeface2;
    }
}
