package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import org.jetbrains.annotations.NotNull;
import tb.b81;
import tb.hk1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    @NotNull
    public static final C8548a Companion = C8548a.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$a */
    /* loaded from: classes3.dex */
    public static final class C8548a {
        static final /* synthetic */ C8548a a = new C8548a();
        @NotNull
        private static final hk1 b = new hk1(b81.C8955a.INSTANCE, null, 2, null);

        private C8548a() {
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
