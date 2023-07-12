package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = NewKotlinTypeChecker.Companion.a();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface TypeConstructorEquality {
        boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2);
    }

    boolean equalTypes(@NotNull z71 z71Var, @NotNull z71 z71Var2);

    boolean isSubtypeOf(@NotNull z71 z71Var, @NotNull z71 z71Var2);
}
