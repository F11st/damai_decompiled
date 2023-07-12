package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface TypeAliasExpansionReportStrategy {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements TypeAliasExpansionReportStrategy {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(@NotNull TypeSubstitutor typeSubstitutor, @NotNull z71 z71Var, @NotNull z71 z71Var2, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
            b41.i(typeSubstitutor, "substitutor");
            b41.i(z71Var, "unsubstitutedArgument");
            b41.i(z71Var2, "argument");
            b41.i(typeParameterDescriptor, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(@NotNull TypeAliasDescriptor typeAliasDescriptor, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull z71 z71Var) {
            b41.i(typeAliasDescriptor, "typeAlias");
            b41.i(z71Var, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(@NotNull TypeAliasDescriptor typeAliasDescriptor) {
            b41.i(typeAliasDescriptor, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(@NotNull AnnotationDescriptor annotationDescriptor) {
            b41.i(annotationDescriptor, "annotation");
        }
    }

    void boundsViolationInSubstitution(@NotNull TypeSubstitutor typeSubstitutor, @NotNull z71 z71Var, @NotNull z71 z71Var2, @NotNull TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(@NotNull TypeAliasDescriptor typeAliasDescriptor, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull z71 z71Var);

    void recursiveTypeAlias(@NotNull TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(@NotNull AnnotationDescriptor annotationDescriptor);
}
