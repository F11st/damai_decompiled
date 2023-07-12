package kotlin.collections;

import java.util.Collection;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.n */
/* loaded from: classes3.dex */
public class C8215n extends C8214m {
    @PublishedApi
    public static <T> int q(@NotNull Iterable<? extends T> iterable, int i) {
        b41.i(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    @PublishedApi
    @Nullable
    public static final <T> Integer r(@NotNull Iterable<? extends T> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }
}
