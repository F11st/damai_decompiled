package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class wq2 extends o2 {
    @Nullable
    private final Function1<z71, Void> k;
    private final List<z71> l;
    private boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private wq2(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull ni1 ni1Var, int i, @NotNull SourceElement sourceElement, @Nullable Function1<z71, Void> function1, @NotNull SupertypeLoopChecker supertypeLoopChecker, @NotNull StorageManager storageManager) {
        super(storageManager, declarationDescriptor, annotations, ni1Var, variance, z, i, sourceElement, supertypeLoopChecker);
        if (declarationDescriptor == null) {
            a(19);
        }
        if (annotations == null) {
            a(20);
        }
        if (variance == null) {
            a(21);
        }
        if (ni1Var == null) {
            a(22);
        }
        if (sourceElement == null) {
            a(23);
        }
        if (supertypeLoopChecker == null) {
            a(24);
        }
        if (storageManager == null) {
            a(25);
        }
        this.l = new ArrayList(1);
        this.m = false;
        this.k = function1;
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private void h() {
        if (this.m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + n());
    }

    private void i() {
        if (this.m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + n());
        }
    }

    public static wq2 j(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull ni1 ni1Var, int i, @NotNull SourceElement sourceElement, @Nullable Function1<z71, Void> function1, @NotNull SupertypeLoopChecker supertypeLoopChecker, @NotNull StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(12);
        }
        if (annotations == null) {
            a(13);
        }
        if (variance == null) {
            a(14);
        }
        if (ni1Var == null) {
            a(15);
        }
        if (sourceElement == null) {
            a(16);
        }
        if (supertypeLoopChecker == null) {
            a(17);
        }
        if (storageManager == null) {
            a(18);
        }
        return new wq2(declarationDescriptor, annotations, z, variance, ni1Var, i, sourceElement, function1, supertypeLoopChecker, storageManager);
    }

    public static wq2 k(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull ni1 ni1Var, int i, @NotNull SourceElement sourceElement, @NotNull StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(6);
        }
        if (annotations == null) {
            a(7);
        }
        if (variance == null) {
            a(8);
        }
        if (ni1Var == null) {
            a(9);
        }
        if (sourceElement == null) {
            a(10);
        }
        if (storageManager == null) {
            a(11);
        }
        return j(declarationDescriptor, annotations, z, variance, ni1Var, i, sourceElement, null, SupertypeLoopChecker.a.INSTANCE, storageManager);
    }

    @NotNull
    public static TypeParameterDescriptor l(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull ni1 ni1Var, int i, @NotNull StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(0);
        }
        if (annotations == null) {
            a(1);
        }
        if (variance == null) {
            a(2);
        }
        if (ni1Var == null) {
            a(3);
        }
        if (storageManager == null) {
            a(4);
        }
        wq2 k = k(declarationDescriptor, annotations, z, variance, ni1Var, i, SourceElement.NO_SOURCE, storageManager);
        k.g(DescriptorUtilsKt.g(declarationDescriptor).y());
        k.o();
        return k;
    }

    private void m(z71 z71Var) {
        if (a81.a(z71Var)) {
            return;
        }
        this.l.add(z71Var);
    }

    private String n() {
        return getName() + " declared in " + d70.m(getContainingDeclaration());
    }

    @Override // tb.o2
    protected void e(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(27);
        }
        Function1<z71, Void> function1 = this.k;
        if (function1 == null) {
            return;
        }
        function1.invoke(z71Var);
    }

    @Override // tb.o2
    @NotNull
    protected List<z71> f() {
        h();
        List<z71> list = this.l;
        if (list == null) {
            a(28);
        }
        return list;
    }

    public void g(@NotNull z71 z71Var) {
        if (z71Var == null) {
            a(26);
        }
        i();
        m(z71Var);
    }

    public void o() {
        i();
        this.m = true;
    }
}
