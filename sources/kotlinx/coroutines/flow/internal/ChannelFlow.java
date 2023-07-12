package kotlinx.coroutines.flow.internal;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayList;
import kotlin.collections.k;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.k40;
import tb.o40;
import tb.ro;
import tb.wt2;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes11.dex */
public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    @JvmField
    @NotNull
    public final CoroutineContext a;
    @JvmField
    public final int b;
    @JvmField
    @NotNull
    public final BufferOverflow c;

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        this.a = coroutineContext;
        this.b = i;
        this.c = bufferOverflow;
        if (k40.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
    }

    static /* synthetic */ Object b(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object d = ro.d(new ChannelFlow$collect$2(channelFlow, flowCollector, null), continuation);
        return d == kotlin.coroutines.intrinsics.a.d() ? d : wt2.INSTANCE;
    }

    private final int f() {
        int i = this.b;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    @Nullable
    protected String a() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super wt2> continuation);

    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super wt2> continuation) {
        return b(this, flowCollector, continuation);
    }

    @NotNull
    protected abstract ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow);

    @NotNull
    public final Function2<ProducerScope<? super T>, Continuation<? super wt2>, Object> e() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        if (k40.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext plus = coroutineContext.plus(this.a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i2 = this.b;
            if (i2 != -3) {
                if (i != -3) {
                    if (i2 != -2) {
                        if (i != -2) {
                            if (k40.a()) {
                                if (!(this.b >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            if (k40.a()) {
                                if (!(i >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            i2 = this.b + i;
                            if (i2 < 0) {
                                i = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i = i2;
            }
            bufferOverflow = this.c;
        }
        return (b41.d(plus, this.a) && i == this.b && bufferOverflow == this.c) ? this : d(plus, i, bufferOverflow);
    }

    @NotNull
    public ReceiveChannel<T> g(@NotNull CoroutineScope coroutineScope) {
        return ProduceKt.f(coroutineScope, this.a, f(), this.c, CoroutineStart.ATOMIC, null, e(), 16, null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String a = a();
        if (a != null) {
            arrayList.add(a);
        }
        if (this.a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.a);
        }
        if (this.b != -3) {
            arrayList.add("capacity=" + this.b);
        }
        if (this.c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.c);
        }
        return o40.a(this) + jn1.ARRAY_START + k.Z(arrayList, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, null, 62, null) + jn1.ARRAY_END;
    }
}
