package kotlin.collections;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class t extends s {
    public static final <T> void G(@NotNull List<T> list) {
        b41.i(list, "<this>");
        Collections.reverse(list);
    }
}
