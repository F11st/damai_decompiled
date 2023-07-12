package kotlinx.coroutines.debug.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/debug/internal/b$a;", AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Lkotlinx/coroutines/debug/internal/b$a;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes9.dex */
final class DebugProbesImpl$dumpCoroutinesSynchronized$1$2 extends Lambda implements Function1<b.a<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$1$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$1$2();

    DebugProbesImpl$dumpCoroutinesSynchronized$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(b.a<?> aVar) {
        return Boolean.valueOf(invoke2(aVar));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@NotNull b.a<?> aVar) {
        boolean e;
        e = b.INSTANCE.e(aVar);
        return !e;
    }
}
