package tb;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class r7 {
    @NotNull
    public static final <T> Iterator<T> a(@NotNull T[] tArr) {
        b41.i(tArr, "array");
        return new q7(tArr);
    }
}
