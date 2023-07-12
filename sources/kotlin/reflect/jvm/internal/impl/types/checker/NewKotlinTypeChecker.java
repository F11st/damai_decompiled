package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;
import tb.b81;
import tb.hk1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();
        @NotNull
        private static final hk1 b = new hk1(b81.a.INSTANCE, null, 2, null);

        private a() {
        }

        @NotNull
        public final hk1 a() {
            return b;
        }
    }

    @NotNull
    b81 getKotlinTypeRefiner();

    @NotNull
    OverridingUtil getOverridingUtil();
}
