package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.yw2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H§@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0004J\u0011\u0010\t\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH¦\u0002J\u001a\u0010\u0011\u001a\u00020\u00102\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H\u0017J\u0014\u0010\u0011\u001a\u00020\u00132\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0012H'R\u001c\u0010\u0014\u001a\u00020\u00138&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\u00020\u00138&@'X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001a8&@'X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u001cR+\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u001a8&@'X§\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b!\u0010\u001c\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", ExifInterface.LONGITUDE_EAST, "", DataflowMonitorModel.METHOD_NAME_RECEIVE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrNull", "Ltb/yw2;", "receiveOrClosed-ZYPwvRU", "receiveOrClosed", "poll", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Ltb/wt2;", "cancel", "", "", "isClosedForReceive", "()Z", "isClosedForReceive$annotations", "()V", "isEmpty", "isEmpty$annotations", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveOrNull", "getOnReceiveOrNull$annotations", "onReceiveOrNull", "getOnReceiveOrClosed", "getOnReceiveOrClosed$annotations", "onReceiveOrClosed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public interface ReceiveChannel<E> {

    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.channels.ReceiveChannel$a */
    /* loaded from: classes9.dex */
    public static final class C8639a {
        public static /* synthetic */ void b(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                receiveChannel.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(@Nullable Throwable th);

    @NotNull
    SelectClause1<E> getOnReceive();

    @NotNull
    SelectClause1<yw2<E>> getOnReceiveOrClosed();

    @NotNull
    SelectClause1<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    @NotNull
    ChannelIterator<E> iterator();

    @Nullable
    E poll();

    @Nullable
    Object receive(@NotNull Continuation<? super E> continuation);

    @InternalCoroutinesApi
    @Nullable
    /* renamed from: receiveOrClosed-ZYPwvRU */
    Object mo1285receiveOrClosedZYPwvRU(@NotNull Continuation<? super yw2<? extends E>> continuation);

    @ObsoleteCoroutinesApi
    @Nullable
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    Object receiveOrNull(@NotNull Continuation<? super E> continuation);
}
