package tb;

import java.util.Objects;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class la1 {
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;
    @NotNull
    private static final Object a = new kj2("CONDITION_FALSE");
    @NotNull
    private static final Object b = new kj2("LIST_EMPTY");

    @NotNull
    public static final Object a() {
        return a;
    }

    @NotNull
    public static final Object b() {
        return b;
    }

    @PublishedApi
    @NotNull
    public static final ma1 c(@NotNull Object obj) {
        ma1 ma1Var;
        p12 p12Var = (p12) (!(obj instanceof p12) ? null : obj);
        if (p12Var == null || (ma1Var = p12Var.a) == null) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            return (ma1) obj;
        }
        return ma1Var;
    }
}
