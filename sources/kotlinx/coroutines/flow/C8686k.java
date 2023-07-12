package kotlinx.coroutines.flow;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.flow.k */
/* loaded from: classes11.dex */
final class C8686k implements SharingStarted {
    @Override // kotlinx.coroutines.flow.SharingStarted
    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> stateFlow) {
        return C8672c.s(SharingCommand.START);
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
