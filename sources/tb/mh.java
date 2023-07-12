package tb;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class mh<E> extends kotlinx.coroutines.a<wt2> implements Channel<E> {
    @NotNull
    private final Channel<E> a;

    public mh(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, boolean z) {
        super(coroutineContext, z);
        this.a = channel;
    }

    static /* synthetic */ Object b(mh mhVar, Continuation continuation) {
        return mhVar.a.receive(continuation);
    }

    static /* synthetic */ Object c(mh mhVar, Continuation continuation) {
        return mhVar.a.mo1285receiveOrClosedZYPwvRU(continuation);
    }

    static /* synthetic */ Object d(mh mhVar, Continuation continuation) {
        return mhVar.a.receiveOrNull(continuation);
    }

    static /* synthetic */ Object e(mh mhVar, Object obj, Continuation continuation) {
        return mhVar.a.send(obj, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Channel<E> a() {
        return this.a;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(@NotNull Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, null, 1, null);
        this.a.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable th) {
        return this.a.close(th);
    }

    @NotNull
    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceive() {
        return this.a.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<yw2<E>> getOnReceiveOrClosed() {
        return this.a.getOnReceiveOrClosed();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        return this.a.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this.a.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @ExperimentalCoroutinesApi
    public void invokeOnClose(@NotNull Function1<? super Throwable, wt2> function1) {
        this.a.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.a.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.a.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return this.a.isFull();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return this.a.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        return this.a.offer(e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public E poll() {
        return this.a.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation<? super E> continuation) {
        return b(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @InternalCoroutinesApi
    @Nullable
    /* renamed from: receiveOrClosed-ZYPwvRU */
    public Object mo1285receiveOrClosedZYPwvRU(@NotNull Continuation<? super yw2<? extends E>> continuation) {
        return c(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @ObsoleteCoroutinesApi
    @Nullable
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return d(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e, @NotNull Continuation<? super wt2> continuation) {
        return e(this, e, continuation);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(@Nullable Throwable th) {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }
}
