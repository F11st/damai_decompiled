package tb;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class a51 extends dj implements JavaCallableMemberDescriptor {
    private Boolean F;
    private Boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected a51(@NotNull ClassDescriptor classDescriptor, @Nullable a51 a51Var, @NotNull Annotations annotations, boolean z, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(classDescriptor, a51Var, annotations, z, kind, sourceElement);
        if (classDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (kind == null) {
            a(2);
        }
        if (sourceElement == null) {
            a(3);
        }
        this.F = null;
        this.G = null;
    }

    @NotNull
    public static a51 M(@NotNull ClassDescriptor classDescriptor, @NotNull Annotations annotations, boolean z, @NotNull SourceElement sourceElement) {
        if (classDescriptor == null) {
            a(4);
        }
        if (annotations == null) {
            a(5);
        }
        if (sourceElement == null) {
            a(6);
        }
        return new a51(classDescriptor, null, annotations, z, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    protected a51 L(@NotNull ClassDescriptor classDescriptor, @Nullable a51 a51Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, @NotNull Annotations annotations) {
        if (classDescriptor == null) {
            a(12);
        }
        if (kind == null) {
            a(13);
        }
        if (sourceElement == null) {
            a(14);
        }
        if (annotations == null) {
            a(15);
        }
        return new a51(classDescriptor, a51Var, annotations, this.D, kind, sourceElement);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.dj, kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    @NotNull
    /* renamed from: N */
    public a51 f(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable ni1 ni1Var, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(7);
        }
        if (kind == null) {
            a(8);
        }
        if (annotations == null) {
            a(9);
        }
        if (sourceElement == null) {
            a(10);
        }
        if (kind != CallableMemberDescriptor.Kind.DECLARATION && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + StringUtils.LF + "newOwner: " + declarationDescriptor + StringUtils.LF + "kind: " + kind);
        }
        a51 L = L((ClassDescriptor) declarationDescriptor, (a51) functionDescriptor, kind, sourceElement, annotations);
        L.s(k());
        L.t(hasSynthesizedParameterNames());
        return L;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
    @NotNull
    /* renamed from: O */
    public a51 enhance(@Nullable z71 z71Var, @NotNull List<ax2> list, @NotNull z71 z71Var2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair) {
        if (list == null) {
            a(16);
        }
        if (z71Var2 == null) {
            a(17);
        }
        a51 f = f(getContainingDeclaration(), null, getKind(), null, getAnnotations(), getSource());
        f.l(z71Var == null ? null : x60.f(f, z71Var, Annotations.Companion.b()), getDispatchReceiverParameter(), getTypeParameters(), yv2.a(list, getValueParameters(), f), z71Var2, getModality(), getVisibility());
        if (pair != null) {
            f.o(pair.getFirst(), pair.getSecond());
        }
        return f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.G.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public boolean k() {
        return this.F.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public void s(boolean z) {
        this.F = Boolean.valueOf(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public void t(boolean z) {
        this.G = Boolean.valueOf(z);
    }
}
