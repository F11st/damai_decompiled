package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BlockingIgnoringReceiver extends CountDownLatch implements Consumer<Throwable>, Action {
    public Throwable error;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    @Override // io.reactivex.functions.Action
    public void run() {
        countDown();
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.error = th;
        countDown();
    }
}
