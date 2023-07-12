package tb;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class qh0 extends c2 {
    @NotNull
    private final C9605a a = new C9605a();

    /* compiled from: Taobao */
    /* renamed from: tb.qh0$a */
    /* loaded from: classes3.dex */
    public static final class C9605a extends ThreadLocal<Random> {
        C9605a() {
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
