package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface DeserializationConfiguration {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration$a */
    /* loaded from: classes3.dex */
    public static final class C8506a implements DeserializationConfiguration {
        @NotNull
        public static final C8506a INSTANCE = new C8506a();

        private C8506a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getAllowUnstableDependencies() {
            return C8507b.a(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getPreserveDeclarationsOrdering() {
            return C8507b.b(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getReleaseCoroutines() {
            return C8507b.c(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return C8507b.d(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipMetadataVersionCheck() {
            return C8507b.e(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipPrereleaseCheck() {
            return C8507b.f(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getTypeAliasesAllowed() {
            return C8507b.g(this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration$b */
    /* loaded from: classes3.dex */
    public static final class C8507b {
        public static boolean a(@NotNull DeserializationConfiguration deserializationConfiguration) {
            b41.i(deserializationConfiguration, "this");
            return false;
        }

        public static boolean b(@NotNull DeserializationConfiguration deserializationConfiguration) {
            b41.i(deserializationConfiguration, "this");
            return false;
        }

        public static boolean c(@NotNull DeserializationConfiguration deserializationConfiguration) {
            b41.i(deserializationConfiguration, "this");
            return false;
        }

        public static boolean d(@NotNull DeserializationConfiguration deserializationConfiguration) {
            b41.i(deserializationConfiguration, "this");
            return false;
        }

        public static boolean e(@NotNull DeserializationConfiguration deserializationConfiguration) {
            b41.i(deserializationConfiguration, "this");
            return false;
        }

        public static boolean f(@NotNull DeserializationConfiguration deserializationConfiguration) {
            b41.i(deserializationConfiguration, "this");
            return false;
        }

        public static boolean g(@NotNull DeserializationConfiguration deserializationConfiguration) {
            b41.i(deserializationConfiguration, "this");
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    boolean getPreserveDeclarationsOrdering();

    boolean getReleaseCoroutines();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
