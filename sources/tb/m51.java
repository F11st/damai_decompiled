package tb;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class m51 extends bx1 implements JavaCallableMemberDescriptor {
    private final boolean A;
    @Nullable
    private final Pair<CallableDescriptor.UserDataKey<?>, ?> B;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m51(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull f70 f70Var, boolean z, @NotNull ni1 ni1Var, @NotNull SourceElement sourceElement, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, boolean z2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        super(declarationDescriptor, propertyDescriptor, annotations, modality, f70Var, z, ni1Var, kind, sourceElement, false, false, false, false, false, false);
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (modality == null) {
            a(2);
        }
        if (f70Var == null) {
            a(3);
        }
        if (ni1Var == null) {
            a(4);
        }
        if (sourceElement == null) {
            a(5);
        }
        if (kind == null) {
            a(6);
        }
        this.A = z2;
        this.B = pair;
    }

    private static /* synthetic */ void a(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(format);
        }
    }

    @NotNull
    public static m51 v(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull f70 f70Var, boolean z, @NotNull ni1 ni1Var, @NotNull SourceElement sourceElement, boolean z2) {
        if (declarationDescriptor == null) {
            a(7);
        }
        if (annotations == null) {
            a(8);
        }
        if (modality == null) {
            a(9);
        }
        if (f70Var == null) {
            a(10);
        }
        if (ni1Var == null) {
            a(11);
        }
        if (sourceElement == null) {
            a(12);
        }
        return new m51(declarationDescriptor, annotations, modality, f70Var, z, ni1Var, sourceElement, null, CallableMemberDescriptor.Kind.DECLARATION, z2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    @NotNull
    public JavaCallableMemberDescriptor enhance(@Nullable z71 z71Var, @NotNull List<ax2> list, @NotNull z71 z71Var2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        cx1 cx1Var;
        dx1 dx1Var;
        if (list == null) {
            a(19);
        }
        if (z71Var2 == null) {
            a(20);
        }
        PropertyDescriptor original = getOriginal() == this ? null : getOriginal();
        m51 m51Var = new m51(getContainingDeclaration(), getAnnotations(), getModality(), getVisibility(), isVar(), getName(), getSource(), original, getKind(), this.A, pair);
        cx1 getter = getGetter();
        if (getter != null) {
            cx1Var = r15;
            cx1 cx1Var2 = new cx1(m51Var, getter.getAnnotations(), getter.getModality(), getter.getVisibility(), getter.isDefault(), getter.isExternal(), getter.isInline(), getKind(), original == null ? null : original.getGetter(), getter.getSource());
            cx1Var.h(getter.getInitialSignatureDescriptor());
            cx1Var.k(z71Var2);
        } else {
            cx1Var = null;
        }
        PropertySetterDescriptor setter = getSetter();
        if (setter != null) {
            dx1 dx1Var2 = new dx1(m51Var, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), getKind(), original == null ? null : original.getSetter(), setter.getSource());
            dx1Var2.h(dx1Var2.getInitialSignatureDescriptor());
            dx1Var2.l(setter.getValueParameters().get(0));
            dx1Var = dx1Var2;
        } else {
            dx1Var = null;
        }
        m51Var.o(cx1Var, dx1Var, getBackingField(), getDelegateField());
        m51Var.s(p());
        NullableLazyValue<fn<?>> nullableLazyValue = this.g;
        if (nullableLazyValue != null) {
            m51Var.e(nullableLazyValue);
        }
        m51Var.setOverriddenDescriptors(getOverriddenDescriptors());
        m51Var.t(z71Var2, getTypeParameters(), getDispatchReceiverParameter(), z71Var == null ? null : x60.f(this, z71Var, Annotations.Companion.b()));
        return m51Var;
    }

    @Override // tb.bx1, kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair = this.B;
        if (pair == null || !pair.getFirst().equals(userDataKey)) {
            return null;
        }
        return (V) this.B.getSecond();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override // tb.bx1
    @NotNull
    protected bx1 i(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull f70 f70Var, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ni1 ni1Var, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(13);
        }
        if (modality == null) {
            a(14);
        }
        if (f70Var == null) {
            a(15);
        }
        if (kind == null) {
            a(16);
        }
        if (ni1Var == null) {
            a(17);
        }
        if (sourceElement == null) {
            a(18);
        }
        return new m51(declarationDescriptor, getAnnotations(), modality, f70Var, isVar(), ni1Var, sourceElement, propertyDescriptor, kind, this.A, this.B);
    }

    @Override // tb.bx1, kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        z71 type = getType();
        return this.A && dn.a(type) && (!sq2.i(type) || kotlin.reflect.jvm.internal.impl.builtins.b.t0(type));
    }
}
