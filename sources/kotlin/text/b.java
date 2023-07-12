package kotlin.text;

import kotlin.PublishedApi;
import tb.n31;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class b {
    @PublishedApi
    public static int a(int i) {
        if (new n31(2, 36).f(i)) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new n31(2, 36));
    }

    public static final int b(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
