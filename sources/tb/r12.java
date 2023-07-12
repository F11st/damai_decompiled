package tb;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractChannel;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class r12<E> extends AbstractChannel<E> {
    public r12(@Nullable Function1<? super E, wt2> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean J() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean K() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean p() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean q() {
        return true;
    }
}
