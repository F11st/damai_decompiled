package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.q */
/* loaded from: classes3.dex */
public class C8219q extends C8218p {
    public static final <T extends Comparable<? super T>> void t(@NotNull List<T> list) {
        b41.i(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void u(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        b41.i(list, "<this>");
        b41.i(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
