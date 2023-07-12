package kotlinx.coroutines.selects;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ma1;
import tb.t8;

/* compiled from: Taobao */
@InternalCoroutinesApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&R\u0016\u0010\u0013\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/selects/SelectInstance;", "R", "", "", "trySelect", "Ltb/ma1$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "otherOp", "trySelectOther", "Ltb/t8;", SocialConstants.PARAM_APP_DESC, "performAtomicTrySelect", "", "exception", "Ltb/wt2;", "resumeSelectWithException", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnSelect", "isSelected", "()Z", "Lkotlin/coroutines/Continuation;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes11.dex */
public interface SelectInstance<R> {
    void disposeOnSelect(@NotNull DisposableHandle disposableHandle);

    @NotNull
    Continuation<R> getCompletion();

    boolean isSelected();

    @Nullable
    Object performAtomicTrySelect(@NotNull t8 t8Var);

    void resumeSelectWithException(@NotNull Throwable th);

    boolean trySelect();

    @Nullable
    Object trySelectOther(@Nullable ma1.C9437d c9437d);
}
