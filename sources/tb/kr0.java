package tb;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class kr0 {
    @NotNull
    public static final kr0 INSTANCE = new kr0();

    private kr0() {
    }

    private final void c(String str, String str2) {
        int length = str2.length() / 1000;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            int i3 = i * 1000;
            int i4 = i2 * 1000;
            if (i4 > str2.length()) {
                i4 = str2.length();
            }
            String substring = str2.substring(i3, i4);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Log.e(str, substring);
            if (i == length) {
                return;
            }
            i = i2;
        }
    }

    public final void a(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        c("Alibaba-GaiaX", str);
    }

    public final boolean b() {
        return zr0.INSTANCE.a();
    }
}
