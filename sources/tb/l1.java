package tb;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class l1 extends wg1 {
    private final ni1 a;
    protected final NotNullLazyValue<fd2> b;
    private final NotNullLazyValue<MemberScope> c;
    private final NotNullLazyValue<ReceiverParameterDescriptor> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class a implements Function0<fd2> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: tb.l1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0458a implements Function1<b81, fd2> {
            C0458a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public fd2 invoke(b81 b81Var) {
                ClassifierDescriptor e = b81Var.e(l1.this);
                if (e == null) {
                    return l1.this.b.invoke();
                }
                if (e instanceof TypeAliasDescriptor) {
                    return KotlinTypeFactory.b((TypeAliasDescriptor) e, fr2.h(e.getTypeConstructor().getParameters()));
                }
                if (e instanceof wg1) {
                    return fr2.v(e.getTypeConstructor().refine(b81Var), ((wg1) e).b(b81Var), this);
                }
                return e.getDefaultType();
            }
        }

        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public fd2 invoke() {
            l1 l1Var = l1.this;
            return fr2.u(l1Var, l1Var.getUnsubstitutedMemberScope(), new C0458a());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class b implements Function0<MemberScope> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public MemberScope invoke() {
            return new t21(l1.this.getUnsubstitutedMemberScope());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class c implements Function0<ReceiverParameterDescriptor> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public ReceiverParameterDescriptor invoke() {
            return new o81(l1.this);
        }
    }

    public l1(@NotNull StorageManager storageManager, @NotNull ni1 ni1Var) {
        if (storageManager == null) {
            c(0);
        }
        if (ni1Var == null) {
            c(1);
        }
        this.a = ni1Var;
        this.b = storageManager.createLazyValue(new a());
        this.c = storageManager.createLazyValue(new b());
        this.d = storageManager.createLazyValue(new c());
    }

    private static /* synthetic */ void c(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 8 || i == 11 || i == 13 || i == 15) {
            objArr[1] = "getMemberScope";
        } else if (i == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 18) {
            objArr[1] = "substitute";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 8 && i != 11 && i != 13 && i != 15 && i != 16 && i != 18 && i != 19) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // tb.wg1
    @NotNull
    public MemberScope a(@NotNull br2 br2Var, @NotNull b81 b81Var) {
        if (br2Var == null) {
            c(9);
        }
        if (b81Var == null) {
            c(10);
        }
        if (!br2Var.f()) {
            return new SubstitutingScope(b(b81Var), TypeSubstitutor.g(br2Var));
        }
        MemberScope b2 = b(b81Var);
        if (b2 == null) {
            c(11);
        }
        return b2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @NotNull
    /* renamed from: d */
    public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            c(17);
        }
        return typeSubstitutor.k() ? this : new v81(this, typeSubstitutor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public fd2 getDefaultType() {
        fd2 invoke = this.b.invoke();
        if (invoke == null) {
            c(19);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getMemberScope(@NotNull br2 br2Var) {
        if (br2Var == null) {
            c(14);
        }
        MemberScope a2 = a(br2Var, DescriptorUtilsKt.k(d70.g(this)));
        if (a2 == null) {
            c(15);
        }
        return a2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    @NotNull
    public ni1 getName() {
        ni1 ni1Var = this.a;
        if (ni1Var == null) {
            c(2);
        }
        return ni1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public ClassDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor invoke = this.d.invoke();
        if (invoke == null) {
            c(5);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope invoke = this.c.invoke();
        if (invoke == null) {
            c(4);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope b2 = b(DescriptorUtilsKt.k(d70.g(this)));
        if (b2 == null) {
            c(16);
        }
        return b2;
    }
}
