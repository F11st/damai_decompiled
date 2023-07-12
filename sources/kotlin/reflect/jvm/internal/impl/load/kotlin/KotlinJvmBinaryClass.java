package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hj;
import tb.ij;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KotlinJvmBinaryClass {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface AnnotationArgumentVisitor {
        void visit(@Nullable ni1 ni1Var, @Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull ni1 ni1Var, @NotNull hj hjVar);

        @Nullable
        AnnotationArrayArgumentVisitor visitArray(@NotNull ni1 ni1Var);

        void visitClassLiteral(@NotNull ni1 ni1Var, @NotNull ij ijVar);

        void visitEnd();

        void visitEnum(@NotNull ni1 ni1Var, @NotNull hj hjVar, @NotNull ni1 ni1Var2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface AnnotationArrayArgumentVisitor {
        void visit(@Nullable Object obj);

        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull hj hjVar);

        void visitClassLiteral(@NotNull ij ijVar);

        void visitEnd();

        void visitEnum(@NotNull hj hjVar, @NotNull ni1 ni1Var);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitAnnotation(@NotNull hj hjVar, @NotNull SourceElement sourceElement);

        void visitEnd();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface MemberVisitor {
        @Nullable
        AnnotationVisitor visitField(@NotNull ni1 ni1Var, @NotNull String str, @Nullable Object obj);

        @Nullable
        MethodAnnotationVisitor visitMethod(@NotNull ni1 ni1Var, @NotNull String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        @Nullable
        AnnotationArgumentVisitor visitParameterAnnotation(int i, @NotNull hj hjVar, @NotNull SourceElement sourceElement);
    }

    @NotNull
    KotlinClassHeader getClassHeader();

    @NotNull
    hj getClassId();

    @NotNull
    String getLocation();

    void loadClassAnnotations(@NotNull AnnotationVisitor annotationVisitor, @Nullable byte[] bArr);

    void visitMembers(@NotNull MemberVisitor memberVisitor, @Nullable byte[] bArr);
}
