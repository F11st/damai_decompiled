package kotlin.random;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.c2;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class PlatformRandom extends c2 implements Serializable {
    @NotNull
    private static final a Companion = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    @NotNull
    private final java.util.Random impl;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public PlatformRandom(@NotNull java.util.Random random) {
        b41.i(random, "impl");
        this.impl = random;
    }

    @Override // tb.c2
    @NotNull
    public java.util.Random getImpl() {
        return this.impl;
    }
}
