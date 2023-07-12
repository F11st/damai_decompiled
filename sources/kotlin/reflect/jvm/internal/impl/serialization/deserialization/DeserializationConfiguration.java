package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface DeserializationConfiguration {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements DeserializationConfiguration {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getAllowUnstableDependencies() {
            return b.a(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getPreserveDeclarationsOrdering() {
            return b.b(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getReleaseCoroutines() {
            return b.c(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return b.d(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipMetadataVersionCheck() {
            return b.e(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipPrereleaseCheck() {
            return b.f(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getTypeAliasesAllowed() {
            return b.g(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
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
