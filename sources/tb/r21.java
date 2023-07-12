package tb;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class r21<E> {
    @NotNull
    public static Object a(@Nullable Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i, k50 k50Var) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    @NotNull
    public static final Object c(Object obj, E e) {
        if (!k40.a() || (!(e instanceof List))) {
            if (obj == null) {
                return a(e);
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(e);
                return a(obj);
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e);
            return a(arrayList);
        }
        throw new AssertionError();
    }
}
