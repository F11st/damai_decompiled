package kotlin.contracts;

import kotlin.Function;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
/* loaded from: classes3.dex */
public interface ContractBuilder {
    @ContractsDsl
    @NotNull
    <R> CallsInPlace callsInPlace(@NotNull Function<? extends R> function, @NotNull InvocationKind invocationKind);

    @ContractsDsl
    @NotNull
    Returns returns();

    @ContractsDsl
    @NotNull
    Returns returns(@Nullable Object obj);

    @ContractsDsl
    @NotNull
    ReturnsNotNull returnsNotNull();
}
