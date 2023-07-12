package kotlin.contracts;

import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@ContractsDsl
@ExperimentalContracts
/* loaded from: classes3.dex */
public enum InvocationKind {
    AT_MOST_ONCE,
    AT_LEAST_ONCE,
    EXACTLY_ONCE,
    UNKNOWN
}
