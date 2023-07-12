package tb;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class dv1<E> extends mh<E> implements ProducerScope<E> {
    public dv1(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel) {
        super(coroutineContext, channel, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: f */
    public void onCompleted(@NotNull wt2 wt2Var) {
        SendChannel.a.a(a(), null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public /* bridge */ /* synthetic */ SendChannel getChannel() {
        return getChannel();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    protected void onCancelled(@NotNull Throwable th, boolean z) {
        if (a().close(th) || z) {
            return;
        }
        no.a(getContext(), th);
    }
}
