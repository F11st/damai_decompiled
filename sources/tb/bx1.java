package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class bx1 extends kotlin.reflect.jvm.internal.impl.descriptors.impl.c implements PropertyDescriptor {
    private final Modality h;
    private f70 i;
    private Collection<? extends PropertyDescriptor> j;
    private final PropertyDescriptor k;
    private final CallableMemberDescriptor.Kind l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private ReceiverParameterDescriptor s;
    private ReceiverParameterDescriptor t;
    private List<TypeParameterDescriptor> u;
    private cx1 v;
    private PropertySetterDescriptor w;
    private boolean x;
    private FieldDescriptor y;
    private FieldDescriptor z;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class a {
        private DeclarationDescriptor a;
        private Modality b;
        private f70 c;
        private CallableMemberDescriptor.Kind f;
        private ReceiverParameterDescriptor i;
        private ni1 k;
        private z71 l;
        private PropertyDescriptor d = null;
        private boolean e = false;
        private br2 g = br2.EMPTY;
        private boolean h = true;
        private List<TypeParameterDescriptor> j = null;

        public a() {
            this.a = bx1.this.getContainingDeclaration();
            this.b = bx1.this.getModality();
            this.c = bx1.this.getVisibility();
            this.f = bx1.this.getKind();
            this.i = bx1.this.s;
            this.k = bx1.this.getName();
            this.l = bx1.this.getType();
        }

        private static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 2) {
                objArr[1] = "setOriginal";
            } else if (i == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i == 5) {
                objArr[1] = "setReturnType";
            } else if (i == 7) {
                objArr[1] = "setModality";
            } else if (i == 9) {
                objArr[1] = "setVisibility";
            } else if (i == 11) {
                objArr[1] = "setKind";
            } else if (i == 19) {
                objArr[1] = "setName";
            } else if (i == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i == 16) {
                objArr[1] = "setSubstitution";
            } else if (i != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Nullable
        public PropertyDescriptor n() {
            return bx1.this.j(this);
        }

        PropertyGetterDescriptor o() {
            PropertyDescriptor propertyDescriptor = this.d;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getGetter();
        }

        PropertySetterDescriptor p() {
            PropertyDescriptor propertyDescriptor = this.d;
            if (propertyDescriptor == null) {
                return null;
            }
            return propertyDescriptor.getSetter();
        }

        @NotNull
        public a q(boolean z) {
            this.h = z;
            return this;
        }

        @NotNull
        public a r(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(10);
            }
            this.f = kind;
            return this;
        }

        @NotNull
        public a s(@NotNull Modality modality) {
            if (modality == null) {
                a(6);
            }
            this.b = modality;
            return this;
        }

        @NotNull
        public a t(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.d = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        @NotNull
        public a u(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                a(0);
            }
            this.a = declarationDescriptor;
            return this;
        }

        @NotNull
        public a v(@NotNull br2 br2Var) {
            if (br2Var == null) {
                a(15);
            }
            this.g = br2Var;
            return this;
        }

        @NotNull
        public a w(@NotNull f70 f70Var) {
            if (f70Var == null) {
                a(8);
            }
            this.c = f70Var;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx1(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull f70 f70Var, boolean z, @NotNull ni1 ni1Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(declarationDescriptor, annotations, ni1Var, null, z, sourceElement);
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
        if (kind == null) {
            a(5);
        }
        if (sourceElement == null) {
            a(6);
        }
        this.j = null;
        this.h = modality;
        this.i = f70Var;
        this.k = propertyDescriptor == null ? this : propertyDescriptor;
        this.l = kind;
        this.m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        this.q = z6;
        this.r = z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r11) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.bx1.a(int):void");
    }

    @NotNull
    public static bx1 h(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull f70 f70Var, boolean z, @NotNull ni1 ni1Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
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
        if (kind == null) {
            a(12);
        }
        if (sourceElement == null) {
            a(13);
        }
        return new bx1(declarationDescriptor, null, annotations, modality, f70Var, z, ni1Var, kind, sourceElement, z2, z3, z4, z5, z6, z7);
    }

    @NotNull
    private SourceElement l(boolean z, @Nullable PropertyDescriptor propertyDescriptor) {
        SourceElement sourceElement;
        if (z) {
            if (propertyDescriptor == null) {
                propertyDescriptor = getOriginal();
            }
            sourceElement = propertyDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            a(23);
        }
        return sourceElement;
    }

    private static FunctionDescriptor m(@NotNull TypeSubstitutor typeSubstitutor, @NotNull PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (typeSubstitutor == null) {
            a(25);
        }
        if (propertyAccessorDescriptor == null) {
            a(26);
        }
        if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor);
        }
        return null;
    }

    private static f70 r(f70 f70Var, CallableMemberDescriptor.Kind kind) {
        return (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && e70.g(f70Var.f())) ? e70.INVISIBLE_FAKE : f70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: g */
    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, f70 f70Var, CallableMemberDescriptor.Kind kind, boolean z) {
        PropertyDescriptor n = q().u(declarationDescriptor).t(null).s(modality).w(f70Var).r(kind).q(z).n();
        if (n == null) {
            a(37);
        }
        return n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        cx1 cx1Var = this.v;
        if (cx1Var != null) {
            arrayList.add(cx1Var);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.w;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getBackingField() {
        return this.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getDelegateField() {
        return this.z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.l;
        if (kind == null) {
            a(34);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.h;
        if (modality == null) {
            a(19);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.j;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            a(36);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public z71 getReturnType() {
        z71 type = getType();
        if (type == null) {
            a(18);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public PropertySetterDescriptor getSetter() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.u;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        f70 f70Var = this.i;
        if (f70Var == null) {
            a(20);
        }
        return f70Var;
    }

    @NotNull
    protected bx1 i(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull f70 f70Var, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ni1 ni1Var, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(27);
        }
        if (modality == null) {
            a(28);
        }
        if (f70Var == null) {
            a(29);
        }
        if (kind == null) {
            a(30);
        }
        if (ni1Var == null) {
            a(31);
        }
        if (sourceElement == null) {
            a(32);
        }
        return new bx1(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, f70Var, isVar(), ni1Var, kind, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.m;
    }

    @Nullable
    protected PropertyDescriptor j(@NotNull a aVar) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        iz1 iz1Var;
        NullableLazyValue<fn<?>> nullableLazyValue;
        if (aVar == null) {
            a(24);
        }
        bx1 i = i(aVar.a, aVar.b, aVar.c, aVar.d, aVar.f, aVar.k, l(aVar.e, aVar.d));
        List<TypeParameterDescriptor> typeParameters = aVar.j == null ? getTypeParameters() : aVar.j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor b = b70.b(typeParameters, aVar.g, i, arrayList);
        z71 z71Var = aVar.l;
        Variance variance = Variance.OUT_VARIANCE;
        z71 q = b.q(z71Var, variance);
        if (q == null) {
            return null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = aVar.i;
        if (receiverParameterDescriptor2 != null) {
            receiverParameterDescriptor = receiverParameterDescriptor2.substitute(b);
            if (receiverParameterDescriptor == null) {
                return null;
            }
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = this.t;
        if (receiverParameterDescriptor3 != null) {
            z71 q2 = b.q(receiverParameterDescriptor3.getType(), Variance.IN_VARIANCE);
            if (q2 == null) {
                return null;
            }
            iz1Var = new iz1(i, new dh0(i, q2, this.t.getValue()), this.t.getAnnotations());
        } else {
            iz1Var = null;
        }
        i.t(q, arrayList, receiverParameterDescriptor, iz1Var);
        cx1 cx1Var = this.v == null ? null : new cx1(i, this.v.getAnnotations(), aVar.b, r(this.v.getVisibility(), aVar.f), this.v.isDefault(), this.v.isExternal(), this.v.isInline(), aVar.f, aVar.o(), SourceElement.NO_SOURCE);
        if (cx1Var != null) {
            z71 returnType = this.v.getReturnType();
            cx1Var.h(m(b, this.v));
            cx1Var.k(returnType != null ? b.q(returnType, variance) : null);
        }
        dx1 dx1Var = this.w == null ? null : new dx1(i, this.w.getAnnotations(), aVar.b, r(this.w.getVisibility(), aVar.f), this.w.isDefault(), this.w.isExternal(), this.w.isInline(), aVar.f, aVar.p(), SourceElement.NO_SOURCE);
        if (dx1Var != null) {
            List<ValueParameterDescriptor> j = kotlin.reflect.jvm.internal.impl.descriptors.impl.a.j(dx1Var, this.w.getValueParameters(), b, false, false, null);
            if (j == null) {
                i.s(true);
                j = Collections.singletonList(dx1.j(dx1Var, DescriptorUtilsKt.g(aVar.a).H(), this.w.getValueParameters().get(0).getAnnotations()));
            }
            if (j.size() == 1) {
                dx1Var.h(m(b, this.w));
                dx1Var.l(j.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        FieldDescriptor fieldDescriptor = this.y;
        ii0 ii0Var = fieldDescriptor == null ? null : new ii0(fieldDescriptor.getAnnotations(), i);
        FieldDescriptor fieldDescriptor2 = this.z;
        i.o(cx1Var, dx1Var, ii0Var, fieldDescriptor2 != null ? new ii0(fieldDescriptor2.getAnnotations(), i) : null);
        if (aVar.h) {
            yd2 a2 = yd2.a();
            for (PropertyDescriptor propertyDescriptor : getOverriddenDescriptors()) {
                a2.add(propertyDescriptor.substitute(b));
            }
            i.setOverriddenDescriptors(a2);
        }
        if (isConst() && (nullableLazyValue = this.g) != null) {
            i.e(nullableLazyValue);
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    /* renamed from: k */
    public cx1 getGetter() {
        return this.v;
    }

    public void n(@Nullable cx1 cx1Var, @Nullable PropertySetterDescriptor propertySetterDescriptor) {
        o(cx1Var, propertySetterDescriptor, null, null);
    }

    public void o(@Nullable cx1 cx1Var, @Nullable PropertySetterDescriptor propertySetterDescriptor, @Nullable FieldDescriptor fieldDescriptor, @Nullable FieldDescriptor fieldDescriptor2) {
        this.v = cx1Var;
        this.w = propertySetterDescriptor;
        this.y = fieldDescriptor;
        this.z = fieldDescriptor2;
    }

    public boolean p() {
        return this.x;
    }

    @NotNull
    public a q() {
        return new a();
    }

    public void s(boolean z) {
        this.x = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            a(35);
        }
        this.j = collection;
    }

    public void t(@NotNull z71 z71Var, @NotNull List<? extends TypeParameterDescriptor> list, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (z71Var == null) {
            a(14);
        }
        if (list == null) {
            a(15);
        }
        d(z71Var);
        this.u = new ArrayList(list);
        this.t = receiverParameterDescriptor2;
        this.s = receiverParameterDescriptor;
    }

    public void u(@NotNull f70 f70Var) {
        if (f70Var == null) {
            a(16);
        }
        this.i = f70Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public PropertyDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(22);
        }
        return typeSubstitutor.k() ? this : q().v(typeSubstitutor.j()).t(getOriginal()).n();
    }

    @Override // tb.u40, tb.t40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.k;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original == null) {
            a(33);
        }
        return original;
    }
}
