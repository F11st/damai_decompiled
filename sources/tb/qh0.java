package tb;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class qh0 extends c2 {
    @NotNull
    private final a a = new a();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @NotNull
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // tb.c2
    @NotNull
    public Random getImpl() {
        Random random = this.a.get();
        b41.h(random, "implStorage.get()");
        return random;
    }
}
