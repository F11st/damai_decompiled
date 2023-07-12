package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.kj2;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.s */
/* loaded from: classes8.dex */
public final class C8705s {
    private static final kj2 a = new kj2("COMPLETING_ALREADY");
    @JvmField
    @NotNull
    public static final kj2 COMPLETING_WAITING_CHILDREN = new kj2("COMPLETING_WAITING_CHILDREN");
    private static final kj2 b = new kj2("COMPLETING_RETRY");
    private static final kj2 c = new kj2("TOO_LATE_TO_CANCEL");
    private static final kj2 d = new kj2("SEALED");
    private static final C8698l e = new C8698l(false);
    private static final C8698l f = new C8698l(true);

    @Nullable
    public static final Object g(@Nullable Object obj) {
        return obj instanceof Incomplete ? new C8701o((Incomplete) obj) : obj;
    }

    @Nullable
    public static final Object h(@Nullable Object obj) {
        Incomplete incomplete;
        C8701o c8701o = (C8701o) (!(obj instanceof C8701o) ? null : obj);
        return (c8701o == null || (incomplete = c8701o.a) == null) ? obj : incomplete;
    }
}
