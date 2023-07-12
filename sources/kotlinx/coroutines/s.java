package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kj2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class s {
    private static final kj2 a = new kj2("COMPLETING_ALREADY");
    @JvmField
    @NotNull
    public static final kj2 COMPLETING_WAITING_CHILDREN = new kj2("COMPLETING_WAITING_CHILDREN");
    private static final kj2 b = new kj2("COMPLETING_RETRY");
    private static final kj2 c = new kj2("TOO_LATE_TO_CANCEL");
    private static final kj2 d = new kj2("SEALED");
    private static final l e = new l(false);
    private static final l f = new l(true);

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof Incomplete ? new o((Incomplete) obj) : obj;
    }

    @Nullable
    public static final Object h(@Nullable Object obj) {
        Incomplete incomplete;
        o oVar = (o) (!(obj instanceof o) ? null : obj);
        return (oVar == null || (incomplete = oVar.a) == null) ? obj : incomplete;
    }
}
