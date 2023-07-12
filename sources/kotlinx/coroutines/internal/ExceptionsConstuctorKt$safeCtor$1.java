package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "e", "invoke", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes11.dex */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Function1 $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$safeCtor$1(Function1 function1) {
        super(1);
        this.$block = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Throwable invoke(@NotNull Throwable th) {
        Object m1271constructorimpl;
        try {
            Result.C8174a c8174a = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl((Throwable) this.$block.invoke(th));
        } catch (Throwable th2) {
            Result.C8174a c8174a2 = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th2));
        }
        if (Result.m1277isFailureimpl(m1271constructorimpl)) {
            m1271constructorimpl = null;
        }
        return (Throwable) m1271constructorimpl;
    }
}
