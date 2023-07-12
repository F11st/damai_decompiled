package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.collections.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface NullabilityAnnotationStates<T> {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();
        @NotNull
        private static final NullabilityAnnotationStates b;

        static {
            Map i;
            i = x.i();
            b = new NullabilityAnnotationStatesImpl(i);
        }

        private a() {
        }

        @NotNull
        public final NullabilityAnnotationStates a() {
            return b;
        }
    }

    @Nullable
    T get(@NotNull hp0 hp0Var);
}
