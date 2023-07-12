package kotlin.jvm;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class KotlinReflectionNotSupportedError extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(@Nullable String str) {
        super(str);
    }

    public KotlinReflectionNotSupportedError(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public KotlinReflectionNotSupportedError(@Nullable Throwable th) {
        super(th);
    }
}
