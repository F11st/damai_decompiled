package kotlinx.coroutines.flow;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted;", "", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "command", "Companion", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes11.dex */
public interface SharingStarted {
    public static final C8669a Companion = C8669a.c;

    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.flow.SharingStarted$a */
    /* loaded from: classes11.dex */
    public static final class C8669a {
        static final /* synthetic */ C8669a c = new C8669a();
        @NotNull
        private static final SharingStarted a = new C8686k();
        @NotNull
        private static final SharingStarted b = new StartedLazily();

        private C8669a() {
        }

        @NotNull
        public final SharingStarted a() {
            return a;
        }

        @NotNull
        public final SharingStarted b() {
            return b;
        }
    }

    @NotNull
    Flow<SharingCommand> command(@NotNull StateFlow<Integer> stateFlow);
}
