package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaResolverSettings {
    @NotNull
    public static final C8340a Companion = C8340a.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings$a */
    /* loaded from: classes3.dex */
    public static final class C8340a {
        static final /* synthetic */ C8340a a = new C8340a();

        private C8340a() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings$b */
    /* loaded from: classes3.dex */
    public static final class C8341b implements JavaResolverSettings {
        @NotNull
        public static final C8341b INSTANCE = new C8341b();

        private C8341b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean getTypeEnhancementImprovementsInStrictMode() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings
        public boolean isReleaseCoroutines() {
            return false;
        }
    }

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getTypeEnhancementImprovementsInStrictMode();

    boolean isReleaseCoroutines();
}
