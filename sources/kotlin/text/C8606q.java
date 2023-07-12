package kotlin.text;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ty1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.text.q */
/* loaded from: classes3.dex */
public class C8606q extends C8605p {
    @NotNull
    public static final String N0(@NotNull String str, int i) {
        int d;
        b41.i(str, "<this>");
        if (i >= 0) {
            d = ty1.d(i, str.length());
            String substring = str.substring(d);
            b41.h(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static char O0(@NotNull CharSequence charSequence) {
        int T;
        b41.i(charSequence, "<this>");
        if (!(charSequence.length() == 0)) {
            T = StringsKt__StringsKt.T(charSequence);
            return charSequence.charAt(T);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }
}
