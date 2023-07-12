package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fn;
import tb.ni1;
import tb.z71;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.c */
/* loaded from: classes3.dex */
public abstract class AbstractC8321c extends AbstractC8320b {
    private final boolean f;
    protected NullableLazyValue<fn<?>> g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC8321c(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull ni1 ni1Var, @Nullable z71 z71Var, boolean z, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, ni1Var, z71Var, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (ni1Var == null) {
            a(2);
        }
        if (sourceElement == null) {
            a(3);
        }
        this.f = z;
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void e(@NotNull NullableLazyValue<fn<?>> nullableLazyValue) {
        if (nullableLazyValue == null) {
            a(4);
        }
        this.g = nullableLazyValue;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    @Nullable
    public fn<?> getCompileTimeInitializer() {
        NullableLazyValue<fn<?>> nullableLazyValue = this.g;
        if (nullableLazyValue != null) {
            return nullableLazyValue.invoke();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return this.f;
    }
}
