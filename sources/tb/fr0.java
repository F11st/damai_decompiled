package tb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class fr0 {
    @NotNull
    public static final fr0 INSTANCE = new fr0();
    @Nullable
    private static ConcurrentHashMap<String, Pattern> a;

    private fr0() {
    }

    private final String a(String str) {
        int hashCode = str.hashCode();
        return hashCode != 36 ? hashCode != 63 ? (hashCode == 94 && str.equals("^")) ? "\\^" : str : !str.equals("?") ? str : "\\?" : !str.equals("$") ? str : "\\$";
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c4  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.CharSequence b(@org.jetbrains.annotations.NotNull android.view.View r10, @org.jetbrains.annotations.NotNull tb.qs0 r11, @org.jetbrains.annotations.NotNull com.alibaba.fastjson.JSONObject r12, @org.jetbrains.annotations.NotNull java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.fr0.b(android.view.View, tb.qs0, com.alibaba.fastjson.JSONObject, java.lang.String):java.lang.CharSequence");
    }
}
