package kotlinx.coroutines;

import java.lang.Throwable;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u0000*\u0012\b\u0000\u0010\u0002*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0003J\u0011\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CopyableThrowable;", "", "T", "", "createCopy", "()Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@ExperimentalCoroutinesApi
/* loaded from: classes8.dex */
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    @Nullable
    T createCopy();
}
