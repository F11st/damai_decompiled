package tb;

import com.taobao.weex.annotation.JSMethod;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class qi1 {
    @NotNull
    public static final qi1 INSTANCE = new qi1();
    @NotNull
    private static final Regex a = new Regex("[^\\p{L}\\p{Digit}]");

    private qi1() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String str) {
        b41.i(str, "name");
        return a.replace(str, JSMethod.NOT_SET);
    }
}
