package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.collections.C8226x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface NullabilityAnnotationStates<T> {
    @NotNull
    public static final C8331a Companion = C8331a.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates$a */
    /* loaded from: classes3.dex */
    public static final class C8331a {
        static final /* synthetic */ C8331a a = new C8331a();
        @NotNull
        private static final NullabilityAnnotationStates b;

        static {
            Map i;
            i = C8226x.i();
            b = new NullabilityAnnotationStatesImpl(i);
        }

        private C8331a() {
        }

        @NotNull
        public final NullabilityAnnotationStates a() {
            return b;
        }
    }

    @Nullable
    T get(@NotNull hp0 hp0Var);
}
