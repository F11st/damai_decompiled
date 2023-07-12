package com.youku.gaiax.js.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/youku/gaiax/js/utils/IdGenerator;", "", "", "genLongId", "Ltb/wt2;", "resetLongId$GaiaX_Android_JS", "()V", "resetLongId", "", "genIntId", "resetIntId$GaiaX_Android_JS", "resetIntId", "reset$GaiaX_Android_JS", "reset", "Ljava/util/concurrent/atomic/AtomicLong;", "index", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicInteger;", "index2", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class IdGenerator {
    @NotNull
    public static final IdGenerator INSTANCE = new IdGenerator();
    @NotNull
    private static AtomicLong index = new AtomicLong(1);
    @NotNull
    private static AtomicInteger index2 = new AtomicInteger(1);

    private IdGenerator() {
    }

    public final int genIntId() {
        return index2.getAndIncrement();
    }

    public final long genLongId() {
        return index.getAndIncrement();
    }

    public final void reset$GaiaX_Android_JS() {
        resetIntId$GaiaX_Android_JS();
        resetLongId$GaiaX_Android_JS();
    }

    public final void resetIntId$GaiaX_Android_JS() {
        index2 = new AtomicInteger(1);
    }

    public final void resetLongId$GaiaX_Android_JS() {
        index = new AtomicLong(1L);
    }
}
