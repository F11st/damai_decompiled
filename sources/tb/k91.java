package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class k91 {
    @NotNull
    public static final <E> E[] d(int i) {
        if (i >= 0) {
            return (E[]) new Object[i];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @NotNull
    public static final <T> T[] e(@NotNull T[] tArr, int i) {
        b41.i(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        b41.h(tArr2, "copyOf(this, newSize)");
        b41.g(tArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
        return tArr2;
    }

    public static final <E> void f(@NotNull E[] eArr, int i) {
        b41.i(eArr, "<this>");
        eArr[i] = null;
    }

    public static final <E> void g(@NotNull E[] eArr, int i, int i2) {
        b41.i(eArr, "<this>");
        while (i < i2) {
            f(eArr, i);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i, int i2, List<?> list) {
        if (i2 != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!b41.d(tArr[i + i3], list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2; i4++) {
            T t = tArr[i + i4];
            i3 = (i3 * 31) + (t != null ? t.hashCode() : 0);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i, int i2) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append(jn1.ARRAY_START_STR);
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append(tArr[i + i3]);
        }
        sb.append(jn1.ARRAY_END_STR);
        String sb2 = sb.toString();
        b41.h(sb2, "sb.toString()");
        return sb2;
    }
}
