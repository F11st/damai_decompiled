package tb;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class o61 {
    public static final ni1 DEFAULT_ANNOTATION_MEMBER_NAME;
    public static final hp0 DEPRECATED_ANNOTATION;
    public static final hp0 DOCUMENTED_ANNOTATION;
    public static final hp0 ENHANCED_MUTABILITY_ANNOTATION;
    public static final hp0 ENHANCED_NULLABILITY_ANNOTATION;
    public static final hp0 JETBRAINS_MUTABLE_ANNOTATION;
    public static final hp0 JETBRAINS_NOT_NULL_ANNOTATION;
    public static final hp0 JETBRAINS_NULLABLE_ANNOTATION;
    public static final hp0 JETBRAINS_READONLY_ANNOTATION;
    public static final hp0 KOTLIN_JVM_INTERNAL;
    public static final String METADATA_DESC;
    public static final hp0 METADATA_FQ_NAME;
    public static final hp0 MUTABLE_ANNOTATION;
    public static final hp0 PURELY_IMPLEMENTS_ANNOTATION;
    public static final hp0 READONLY_ANNOTATION;
    public static final hp0 REPEATABLE_ANNOTATION;
    public static final hp0 RETENTION_ANNOTATION;
    public static final hp0 TARGET_ANNOTATION;

    static {
        hp0 hp0Var = new hp0("kotlin.Metadata");
        METADATA_FQ_NAME = hp0Var;
        METADATA_DESC = "L" + t61.c(hp0Var).f() + ";";
        DEFAULT_ANNOTATION_MEMBER_NAME = ni1.f("value");
        TARGET_ANNOTATION = new hp0(Target.class.getCanonicalName());
        RETENTION_ANNOTATION = new hp0(Retention.class.getCanonicalName());
        DEPRECATED_ANNOTATION = new hp0(Deprecated.class.getCanonicalName());
        DOCUMENTED_ANNOTATION = new hp0(Documented.class.getCanonicalName());
        REPEATABLE_ANNOTATION = new hp0("java.lang.annotation.Repeatable");
        JETBRAINS_NOT_NULL_ANNOTATION = new hp0("org.jetbrains.annotations.NotNull");
        JETBRAINS_NULLABLE_ANNOTATION = new hp0("org.jetbrains.annotations.Nullable");
        JETBRAINS_MUTABLE_ANNOTATION = new hp0("org.jetbrains.annotations.Mutable");
        JETBRAINS_READONLY_ANNOTATION = new hp0("org.jetbrains.annotations.ReadOnly");
        READONLY_ANNOTATION = new hp0("kotlin.annotations.jvm.ReadOnly");
        MUTABLE_ANNOTATION = new hp0("kotlin.annotations.jvm.Mutable");
        PURELY_IMPLEMENTS_ANNOTATION = new hp0("kotlin.jvm.PurelyImplements");
        KOTLIN_JVM_INTERNAL = new hp0("kotlin.jvm.internal");
        ENHANCED_NULLABILITY_ANNOTATION = new hp0("kotlin.jvm.internal.EnhancedNullability");
        ENHANCED_MUTABILITY_ANNOTATION = new hp0("kotlin.jvm.internal.EnhancedMutability");
    }
}
