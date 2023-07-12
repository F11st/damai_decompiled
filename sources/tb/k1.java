package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class k1 {
    public static final int RECEIVE_NULL_ON_CLOSE = 1;
    public static final int RECEIVE_RESULT = 2;
    public static final int RECEIVE_THROWS_ON_CLOSE = 0;
    @JvmField
    @NotNull
    public static final kj2 EMPTY = new kj2("EMPTY");
    @JvmField
    @NotNull
    public static final kj2 OFFER_SUCCESS = new kj2("OFFER_SUCCESS");
    @JvmField
    @NotNull
    public static final kj2 OFFER_FAILED = new kj2("OFFER_FAILED");
    @JvmField
    @NotNull
    public static final kj2 POLL_FAILED = new kj2("POLL_FAILED");
    @JvmField
    @NotNull
    public static final kj2 ENQUEUE_FAILED = new kj2("ENQUEUE_FAILED");
    @JvmField
    @NotNull
    public static final kj2 HANDLER_INVOKED = new kj2("ON_CLOSE_HANDLER_INVOKED");
}
