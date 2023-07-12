package kotlinx.coroutines.flow;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class StartedLazily implements SharingStarted {
    @Override // kotlinx.coroutines.flow.SharingStarted
    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> stateFlow) {
        return c.r(new StartedLazily$command$1(stateFlow, null));
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
