package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.am;
import tb.dm;
import tb.jn1;
import tb.k50;
import tb.lo;
import tb.no;
import tb.o40;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* renamed from: kotlinx.coroutines.a */
/* loaded from: classes8.dex */
public abstract class AbstractC8619a<T> extends JobSupport implements Job, Continuation<T> {
    @NotNull
    private final CoroutineContext context;
    @JvmField
    @NotNull
    protected final CoroutineContext parentContext;

    public /* synthetic */ AbstractC8619a(CoroutineContext coroutineContext, boolean z, int i, k50 k50Var) {
        this(coroutineContext, (i & 2) != 0 ? true : z);
    }

    public static /* synthetic */ void getContext$annotations() {
    }

    protected void afterResume(@Nullable Object obj) {
        afterCompletion(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    @NotNull
    public String cancellationExceptionMessage() {
        return o40.a(this) + " was cancelled";
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public final CoroutineContext getContext() {
        return this.context;
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        no.a(this.context, th);
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        initParentJobInternal$kotlinx_coroutines_core((Job) this.parentContext.get(Job.Key));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        String b = lo.b(this.context);
        if (b != null) {
            return jn1.QUOTE + b + "\":" + super.nameString$kotlinx_coroutines_core();
        }
        return super.nameString$kotlinx_coroutines_core();
    }

    protected void onCancelled(@NotNull Throwable th, boolean z) {
    }

    protected void onCompleted(T t) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    protected final void onCompletionInternal(@Nullable Object obj) {
        if (obj instanceof am) {
            am amVar = (am) obj;
            onCancelled(amVar.a, amVar.a());
            return;
        }
        onCompleted(obj);
    }

    protected void onStart() {
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object obj) {
        Object makeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(dm.d(obj, null, 1, null));
        if (makeCompletingOnce$kotlinx_coroutines_core == C8705s.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(makeCompletingOnce$kotlinx_coroutines_core);
    }

    public final void start(@NotNull CoroutineStart coroutineStart, @NotNull Function1<? super Continuation<? super T>, ? extends Object> function1) {
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function1, this);
    }

    public AbstractC8619a(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(z);
        this.parentContext = coroutineContext;
        this.context = coroutineContext.plus(this);
    }

    public final <R> void start(@NotNull CoroutineStart coroutineStart, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        initParentJob$kotlinx_coroutines_core();
        coroutineStart.invoke(function2, r, this);
    }
}
