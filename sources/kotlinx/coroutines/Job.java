package kotlinx.coroutines;

import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 (2\u00020\u0001:\u0001)J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&J\b\u0010\t\u001a\u00020\bH\u0017J\u0014\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\nH'J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'J\u0013\u0010\u000f\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0017\u001a\u00020\u00162'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0011j\u0002`\u0014H&JE\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0011j\u0002`\u0014H'J\u0011\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0097\u0002R\u0016\u0010\u001c\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "", "start", "cause", "Ltb/wt2;", "cancel", "", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "onCancelling", "invokeImmediately", "other", "plus", "isActive", "()Z", "isCompleted", "isCancelled", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", RichTextNode.CHILDREN, "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "Key", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes8.dex */
public interface Job extends CoroutineContext.Element {
    public static final b Key = b.a;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ void b(Job job, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                job.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R c(@NotNull Job job, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.a.a(job, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E d(@NotNull Job job, @NotNull CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.a.b(job, key);
        }

        public static /* synthetic */ DisposableHandle e(Job job, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return job.invokeOnCompletion(z, z2, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        @NotNull
        public static CoroutineContext f(@NotNull Job job, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.a.c(job, key);
        }

        @NotNull
        public static CoroutineContext g(@NotNull Job job, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.Element.a.d(job, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static Job h(@NotNull Job job, @NotNull Job job2) {
            return job2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class b implements CoroutineContext.Key<Job> {
        static final /* synthetic */ b a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.Key;
        }

        private b() {
        }
    }

    @InternalCoroutinesApi
    @NotNull
    ChildHandle attachChild(@NotNull ChildJob childJob);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(@Nullable Throwable th);

    @InternalCoroutinesApi
    @NotNull
    CancellationException getCancellationException();

    @NotNull
    Sequence<Job> getChildren();

    @NotNull
    SelectClause0 getOnJoin();

    @NotNull
    DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, wt2> function1);

    @InternalCoroutinesApi
    @NotNull
    DisposableHandle invokeOnCompletion(boolean z, boolean z2, @NotNull Function1<? super Throwable, wt2> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @Nullable
    Object join(@NotNull Continuation<? super wt2> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    Job plus(@NotNull Job job);

    boolean start();
}
