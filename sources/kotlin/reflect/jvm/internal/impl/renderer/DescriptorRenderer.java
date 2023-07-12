package kotlin.reflect.jvm.internal.impl.renderer;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.e0;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ip0;
import tb.jn1;
import tb.k50;
import tb.ni1;
import tb.wt2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class DescriptorRenderer {
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    @NotNull
    public static final a Companion;
    @JvmField
    @NotNull
    public static final DescriptorRenderer DEBUG_TEXT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    @JvmField
    @NotNull
    public static final DescriptorRenderer HTML;
    @JvmField
    @NotNull
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ValueParametersHandler {

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class a implements ValueParametersHandler {
            @NotNull
            public static final a INSTANCE = new a();

            private a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb) {
                b41.i(valueParameterDescriptor, "parameter");
                b41.i(sb, "builder");
                if (i != i2 - 1) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int i, @NotNull StringBuilder sb) {
                b41.i(sb, "builder");
                sb.append(jn1.BRACKET_END_STR);
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb) {
                b41.i(valueParameterDescriptor, "parameter");
                b41.i(sb, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int i, @NotNull StringBuilder sb) {
                b41.i(sb, "builder");
                sb.append(jn1.BRACKET_START_STR);
            }
        }

        void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb);

        void appendAfterValueParameters(int i, @NotNull StringBuilder sb);

        void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb);

        void appendBeforeValueParameters(int i, @NotNull StringBuilder sb);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$a$a */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0427a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassKind.values().length];
                iArr[ClassKind.CLASS.ordinal()] = 1;
                iArr[ClassKind.INTERFACE.ordinal()] = 2;
                iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                iArr[ClassKind.OBJECT.ordinal()] = 4;
                iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final String a(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            b41.i(classifierDescriptorWithTypeParameters, "classifier");
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
                if (classDescriptor.isCompanionObject()) {
                    return "companion object";
                }
                switch (C0427a.$EnumSwitchMapping$0[classDescriptor.getKind().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            throw new AssertionError(b41.r("Unexpected classifier: ", classifierDescriptorWithTypeParameters));
        }

        @NotNull
        public final DescriptorRenderer b(@NotNull Function1<? super DescriptorRendererOptions, wt2> function1) {
            b41.i(function1, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.V();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }
    }

    static {
        a aVar = new a(null);
        Companion = aVar;
        COMPACT_WITH_MODIFIERS = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setWithDefinedIn(false);
            }
        });
        COMPACT = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                Set<? extends DescriptorRendererModifier> d;
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setWithDefinedIn(false);
                d = e0.d();
                descriptorRendererOptions.setModifiers(d);
            }
        });
        COMPACT_WITHOUT_SUPERTYPES = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                Set<? extends DescriptorRendererModifier> d;
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setWithDefinedIn(false);
                d = e0.d();
                descriptorRendererOptions.setModifiers(d);
                descriptorRendererOptions.setWithoutSuperTypes(true);
            }
        });
        COMPACT_WITH_SHORT_TYPES = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                Set<? extends DescriptorRendererModifier> d;
                b41.i(descriptorRendererOptions, "$this$withOptions");
                d = e0.d();
                descriptorRendererOptions.setModifiers(d);
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.b.INSTANCE);
                descriptorRendererOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
            }
        });
        ONLY_NAMES_WITH_SHORT_TYPES = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                Set<? extends DescriptorRendererModifier> d;
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setWithDefinedIn(false);
                d = e0.d();
                descriptorRendererOptions.setModifiers(d);
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.b.INSTANCE);
                descriptorRendererOptions.setWithoutTypeParameters(true);
                descriptorRendererOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.NONE);
                descriptorRendererOptions.setReceiverAfterName(true);
                descriptorRendererOptions.setRenderCompanionObjectName(true);
                descriptorRendererOptions.setWithoutSuperTypes(true);
                descriptorRendererOptions.setStartFromName(true);
            }
        });
        FQ_NAMES_IN_TYPES = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
            }
        });
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
            }
        });
        SHORT_NAMES_IN_TYPES = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.b.INSTANCE);
                descriptorRendererOptions.setParameterNameRenderingPolicy(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
            }
        });
        DEBUG_TEXT = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$DEBUG_TEXT$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setDebugMode(true);
                descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.a.INSTANCE);
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
            }
        });
        HTML = aVar.b(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$Companion$HTML$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                invoke2(descriptorRendererOptions);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                b41.i(descriptorRendererOptions, "$this$withOptions");
                descriptorRendererOptions.setTextFormat(RenderingFormat.HTML);
                descriptorRendererOptions.setModifiers(DescriptorRendererModifier.ALL);
            }
        });
    }

    public static /* synthetic */ String c(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.b(annotationDescriptor, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    @NotNull
    public abstract String a(@NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract String b(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget);

    @NotNull
    public abstract String d(@NotNull String str, @NotNull String str2, @NotNull b bVar);

    @NotNull
    public abstract String e(@NotNull ip0 ip0Var);

    @NotNull
    public abstract String f(@NotNull ni1 ni1Var, boolean z);

    @NotNull
    public abstract String g(@NotNull z71 z71Var);

    @NotNull
    public abstract String h(@NotNull TypeProjection typeProjection);

    @NotNull
    public final DescriptorRenderer i(@NotNull Function1<? super DescriptorRendererOptions, wt2> function1) {
        b41.i(function1, "changeOptions");
        DescriptorRendererOptionsImpl a2 = ((DescriptorRendererImpl) this).R().a();
        function1.invoke(a2);
        a2.V();
        return new DescriptorRendererImpl(a2);
    }
}
