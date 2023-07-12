package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface DescriptorRendererOptions {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        public static boolean a(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
            b41.i(descriptorRendererOptions, "this");
            return descriptorRendererOptions.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean b(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
            b41.i(descriptorRendererOptions, "this");
            return descriptorRendererOptions.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    @NotNull
    AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    @NotNull
    Set<hp0> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy);

    void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy);

    void setDebugMode(boolean z);

    void setExcludedTypeAnnotationClasses(@NotNull Set<hp0> set);

    void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set);

    void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void setReceiverAfterName(boolean z);

    void setRenderCompanionObjectName(boolean z);

    void setStartFromName(boolean z);

    void setTextFormat(@NotNull RenderingFormat renderingFormat);

    void setVerbose(boolean z);

    void setWithDefinedIn(boolean z);

    void setWithoutSuperTypes(boolean z);

    void setWithoutTypeParameters(boolean z);
}
