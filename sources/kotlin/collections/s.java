package kotlin.collections;

import java.util.List;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.n31;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class s extends r {
    @JvmName(name = "asReversedMutable")
    @NotNull
    public static <T> List<T> D(@NotNull List<T> list) {
        b41.i(list, "<this>");
        return new a0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E(List<?> list, int i) {
        int i2;
        int i3;
        int i4;
        i2 = m.i(list);
        if (new n31(0, i2).f(i)) {
            i4 = m.i(list);
            return i4 - i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Element index ");
        sb.append(i);
        sb.append(" must be in range [");
        i3 = m.i(list);
        sb.append(new n31(0, i3));
        sb.append("].");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int F(List<?> list, int i) {
        if (new n31(0, list.size()).f(i)) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new n31(0, list.size()) + "].");
    }
}
