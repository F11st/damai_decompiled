package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.collections.C8213l;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cm1;
import tb.h2;
import tb.kj2;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class StateFlowImpl<T> extends h2<C8689n> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private volatile Object _state;
    private int e;

    public StateFlowImpl(@NotNull Object obj) {
        this._state = obj;
    }

    private final boolean h(Object obj, Object obj2) {
        int i;
        C8689n[] e;
        e();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && (!b41.d(obj3, obj))) {
                return false;
            }
            if (b41.d(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i2 = this.e;
            if ((i2 & 1) == 0) {
                int i3 = i2 + 1;
                this.e = i3;
                C8689n[] e2 = e();
                wt2 wt2Var = wt2.INSTANCE;
                while (true) {
                    if (e2 != null) {
                        for (C8689n c8689n : e2) {
                            if (c8689n != null) {
                                c8689n.f();
                            }
                        }
                    }
                    synchronized (this) {
                        i = this.e;
                        if (i == i3) {
                            this.e = i3 + 1;
                            return true;
                        }
                        e = e();
                        wt2 wt2Var2 = wt2.INSTANCE;
                    }
                    e2 = e;
                    i3 = i;
                }
            } else {
                this.e = i2 + 2;
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if ((!tb.b41.d(r12, r13)) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d8 -> B:34:0x00a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00ec -> B:34:0x00a6). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.wt2> r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = (T) cm1.NULL;
        }
        if (t2 == null) {
            t2 = (T) cm1.NULL;
        }
        return h(t, t2);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super wt2> continuation) {
        setValue(t);
        return wt2.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.h2
    @NotNull
    /* renamed from: f */
    public C8689n b() {
        return new C8689n();
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return C8688m.d(this, coroutineContext, i, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.h2
    @NotNull
    /* renamed from: g */
    public C8689n[] c(int i) {
        return new C8689n[i];
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        List<T> e;
        e = C8213l.e(getValue());
        return e;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        kj2 kj2Var = cm1.NULL;
        T t = (T) this._state;
        if (t == kj2Var) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) cm1.NULL;
        }
        h(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }
}
