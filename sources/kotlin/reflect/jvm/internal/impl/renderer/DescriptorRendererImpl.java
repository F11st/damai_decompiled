package kotlin.reflect.jvm.internal.impl.renderer;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlin.text.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a81;
import tb.af2;
import tb.ak0;
import tb.b41;
import tb.bf2;
import tb.bu2;
import tb.ci2;
import tb.d6;
import tb.d70;
import tb.e70;
import tb.f70;
import tb.fd2;
import tb.fn;
import tb.fr2;
import tb.g71;
import tb.gu2;
import tb.hp0;
import tb.ip0;
import tb.j60;
import tb.jf0;
import tb.jg;
import tb.jn1;
import tb.kf0;
import tb.m0;
import tb.m80;
import tb.ni1;
import tb.q12;
import tb.tt1;
import tb.up0;
import tb.v13;
import tb.wt2;
import tb.y7;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    @NotNull
    private final DescriptorRendererOptionsImpl a;
    @NotNull
    private final Lazy b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private final class a implements DeclarationDescriptorVisitor<wt2, StringBuilder> {
        final /* synthetic */ DescriptorRendererImpl a;

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0428a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public a(DescriptorRendererImpl descriptorRendererImpl) {
            b41.i(descriptorRendererImpl, "this$0");
            this.a = descriptorRendererImpl;
        }

        private final void g(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            int i = C0428a.$EnumSwitchMapping$0[this.a.W().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                c(propertyAccessorDescriptor, sb);
                return;
            }
            this.a.C0(propertyAccessorDescriptor, sb);
            sb.append(b41.r(str, " for "));
            DescriptorRendererImpl descriptorRendererImpl = this.a;
            PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
            b41.h(correspondingProperty, "descriptor.correspondingProperty");
            descriptorRendererImpl.j1(correspondingProperty, sb);
        }

        public void a(@NotNull ClassDescriptor classDescriptor, @NotNull StringBuilder sb) {
            b41.i(classDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.I0(classDescriptor, sb);
        }

        public void b(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull StringBuilder sb) {
            b41.i(constructorDescriptor, "constructorDescriptor");
            b41.i(sb, "builder");
            this.a.N0(constructorDescriptor, sb);
        }

        public void c(@NotNull FunctionDescriptor functionDescriptor, @NotNull StringBuilder sb) {
            b41.i(functionDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.R0(functionDescriptor, sb);
        }

        public void d(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StringBuilder sb) {
            b41.i(moduleDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.b1(moduleDescriptor, sb, true);
        }

        public void e(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull StringBuilder sb) {
            b41.i(packageFragmentDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.f1(packageFragmentDescriptor, sb);
        }

        public void f(@NotNull PackageViewDescriptor packageViewDescriptor, @NotNull StringBuilder sb) {
            b41.i(packageViewDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.h1(packageViewDescriptor, sb);
        }

        public void h(@NotNull PropertyDescriptor propertyDescriptor, @NotNull StringBuilder sb) {
            b41.i(propertyDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.j1(propertyDescriptor, sb);
        }

        public void i(@NotNull PropertyGetterDescriptor propertyGetterDescriptor, @NotNull StringBuilder sb) {
            b41.i(propertyGetterDescriptor, "descriptor");
            b41.i(sb, "builder");
            g(propertyGetterDescriptor, sb, "getter");
        }

        public void j(@NotNull PropertySetterDescriptor propertySetterDescriptor, @NotNull StringBuilder sb) {
            b41.i(propertySetterDescriptor, "descriptor");
            b41.i(sb, "builder");
            g(propertySetterDescriptor, sb, "setter");
        }

        public void k(@NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @NotNull StringBuilder sb) {
            b41.i(receiverParameterDescriptor, "descriptor");
            b41.i(sb, "builder");
            sb.append(receiverParameterDescriptor.getName());
        }

        public void l(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull StringBuilder sb) {
            b41.i(typeAliasDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.r1(typeAliasDescriptor, sb);
        }

        public void m(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull StringBuilder sb) {
            b41.i(typeParameterDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.w1(typeParameterDescriptor, sb, true);
        }

        public void n(@NotNull ValueParameterDescriptor valueParameterDescriptor, @NotNull StringBuilder sb) {
            b41.i(valueParameterDescriptor, "descriptor");
            b41.i(sb, "builder");
            this.a.B1(valueParameterDescriptor, true, sb, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb) {
            a(classDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb) {
            b(constructorDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb) {
            c(functionDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitModuleDeclaration(ModuleDescriptor moduleDescriptor, StringBuilder sb) {
            d(moduleDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
            e(packageFragmentDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
            f(packageViewDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
            h(propertyDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb) {
            i(propertyGetterDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb) {
            j(propertySetterDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb) {
            k(receiverParameterDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
            l(typeAliasDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb) {
            m(typeParameterDescriptor, sb);
            return wt2.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ wt2 visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb) {
            n(valueParameterDescriptor, sb);
            return wt2.INSTANCE;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            iArr[RenderingFormat.HTML.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Lazy b2;
        b41.i(descriptorRendererOptionsImpl, WXBridgeManager.OPTIONS);
        this.a = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.U();
        b2 = kotlin.b.b(new Function0<DescriptorRendererImpl>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DescriptorRendererImpl invoke() {
                return (DescriptorRendererImpl) DescriptorRendererImpl.this.i(new Function1<DescriptorRendererOptions, wt2>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ wt2 invoke(DescriptorRendererOptions descriptorRendererOptions) {
                        invoke2(descriptorRendererOptions);
                        return wt2.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
                        List e;
                        Set<hp0> i;
                        b41.i(descriptorRendererOptions, "$this$withOptions");
                        Set<hp0> excludedTypeAnnotationClasses = descriptorRendererOptions.getExcludedTypeAnnotationClasses();
                        e = l.e(c.a.extensionFunctionType);
                        i = f0.i(excludedTypeAnnotationClasses, e);
                        descriptorRendererOptions.setExcludedTypeAnnotationClasses(i);
                    }
                });
            }
        });
        this.b = b2;
    }

    private final boolean A0(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }

    static /* synthetic */ void A1(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.z1(variableDescriptor, sb, z);
    }

    private final void B0(StringBuilder sb, m0 m0Var) {
        RenderingFormat k0 = k0();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (k0 == renderingFormat) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        d1(sb, m0Var.getExpandedType());
        sb.append(" */");
        if (k0() == renderingFormat) {
            sb.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
        if ((getDebugMode() ? r10.declaresDefaultValue() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.a(r10)) != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B1(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r10, boolean r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L10
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r9.U0(r0)
            r12.append(r0)
            java.lang.String r0 = " "
            r12.append(r0)
        L10:
            boolean r0 = r9.p0()
            if (r0 == 0) goto L27
            java.lang.String r0 = "/*"
            r12.append(r0)
            int r0 = r10.getIndex()
            r12.append(r0)
        */
        //  java.lang.String r0 = "*/ "
        /*
            r12.append(r0)
        L27:
            r4 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r12
            r3 = r10
            G0(r1, r2, r3, r4, r5, r6)
            boolean r0 = r10.isCrossinline()
            java.lang.String r1 = "crossinline"
            r9.a1(r12, r0, r1)
            boolean r0 = r10.isNoinline()
            java.lang.String r1 = "noinline"
            r9.a1(r12, r0, r1)
            boolean r0 = r9.e0()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L65
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r0 = r10.getContainingDeclaration()
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor
            if (r3 == 0) goto L55
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r0
            goto L56
        L55:
            r0 = 0
        L56:
            if (r0 != 0) goto L5a
        L58:
            r0 = 0
            goto L61
        L5a:
            boolean r0 = r0.isPrimary()
            if (r0 != r1) goto L58
            r0 = 1
        L61:
            if (r0 == 0) goto L65
            r8 = 1
            goto L66
        L65:
            r8 = 0
        L66:
            if (r8 == 0) goto L71
            boolean r0 = r9.A()
            java.lang.String r3 = "actual"
            r9.a1(r12, r0, r3)
        L71:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.D1(r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function1 r11 = r9.G()
            if (r11 == 0) goto L91
            boolean r11 = r9.getDebugMode()
            if (r11 == 0) goto L8a
            boolean r11 = r10.declaresDefaultValue()
            goto L8e
        L8a:
            boolean r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.a(r10)
        L8e:
            if (r11 == 0) goto L91
            goto L92
        L91:
            r1 = 0
        L92:
            if (r1 == 0) goto La8
            kotlin.jvm.functions.Function1 r11 = r9.G()
            tb.b41.f(r11)
            java.lang.Object r10 = r11.invoke(r10)
            java.lang.String r11 = " = "
            java.lang.String r10 = tb.b41.r(r11, r10)
            r12.append(r10)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.B1(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, boolean, java.lang.StringBuilder, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb) {
        W0(propertyAccessorDescriptor, sb);
    }

    private final void C1(Collection<? extends ValueParameterDescriptor> collection, boolean z, StringBuilder sb) {
        boolean I1 = I1(z);
        int size = collection.size();
        o0().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            o0().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            B1(valueParameterDescriptor, I1, sb, false);
            o0().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        o0().appendAfterValueParameters(size, sb);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void D0(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.isOperator()
            java.lang.String r1 = "functionDescriptor.overriddenDescriptors"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L3a
            java.util.Collection r0 = r6.getOverriddenDescriptors()
            tb.b41.h(r0, r1)
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L19
        L17:
            r0 = 1
            goto L30
        L19:
            java.util.Iterator r0 = r0.iterator()
        L1d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L17
            java.lang.Object r4 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isOperator()
            if (r4 == 0) goto L1d
            r0 = 0
        L30:
            if (r0 != 0) goto L38
            boolean r0 = r5.B()
            if (r0 == 0) goto L3a
        L38:
            r0 = 1
            goto L3b
        L3a:
            r0 = 0
        L3b:
            boolean r4 = r6.isInfix()
            if (r4 == 0) goto L70
            java.util.Collection r4 = r6.getOverriddenDescriptors()
            tb.b41.h(r4, r1)
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L50
        L4e:
            r1 = 1
            goto L67
        L50:
            java.util.Iterator r1 = r4.iterator()
        L54:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L4e
            java.lang.Object r4 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isInfix()
            if (r4 == 0) goto L54
            r1 = 0
        L67:
            if (r1 != 0) goto L6f
            boolean r1 = r5.B()
            if (r1 == 0) goto L70
        L6f:
            r2 = 1
        L70:
            boolean r1 = r6.isTailrec()
            java.lang.String r3 = "tailrec"
            r5.a1(r7, r1, r3)
            r5.q1(r6, r7)
            boolean r6 = r6.isInline()
            java.lang.String r1 = "inline"
            r5.a1(r7, r6, r1)
            java.lang.String r6 = "infix"
            r5.a1(r7, r2, r6)
            java.lang.String r6 = "operator"
            r5.a1(r7, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.D0(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.StringBuilder):void");
    }

    private final void D1(VariableDescriptor variableDescriptor, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        z71 type = variableDescriptor.getType();
        b41.h(type, "variable.type");
        ValueParameterDescriptor valueParameterDescriptor = variableDescriptor instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) variableDescriptor : null;
        z71 varargElementType = valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null;
        z71 z71Var = varargElementType == null ? type : varargElementType;
        a1(sb, varargElementType != null, "vararg");
        if (z3 || (z2 && !j0())) {
            z1(variableDescriptor, sb, z3);
        }
        if (z) {
            b1(variableDescriptor, sb, z2);
            sb.append(": ");
        }
        sb.append(g(z71Var));
        T0(variableDescriptor, sb);
        if (!p0() || varargElementType == null) {
            return;
        }
        sb.append(" /*");
        sb.append(g(type));
        sb.append("*/");
    }

    private final List<String> E0(AnnotationDescriptor annotationDescriptor) {
        int q;
        int q2;
        List m0;
        List<String> t0;
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        int q3;
        Map<ni1, fn<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        List list = null;
        ClassDescriptor f = b0() ? DescriptorUtilsKt.f(annotationDescriptor) : null;
        if (f != null && (unsubstitutedPrimaryConstructor = f.getUnsubstitutedPrimaryConstructor()) != null && (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) != null) {
            ArrayList<ValueParameterDescriptor> arrayList = new ArrayList();
            for (Object obj : valueParameters) {
                if (((ValueParameterDescriptor) obj).declaresDefaultValue()) {
                    arrayList.add(obj);
                }
            }
            q3 = n.q(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(q3);
            for (ValueParameterDescriptor valueParameterDescriptor : arrayList) {
                arrayList2.add(valueParameterDescriptor.getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = m.g();
        }
        ArrayList<ni1> arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            ni1 ni1Var = (ni1) obj2;
            b41.h(ni1Var, AdvanceSetting.NETWORK_TYPE);
            if (!allValueArguments.containsKey(ni1Var)) {
                arrayList3.add(obj2);
            }
        }
        q = n.q(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(q);
        for (ni1 ni1Var2 : arrayList3) {
            arrayList4.add(b41.r(ni1Var2.b(), " = ..."));
        }
        Set<Map.Entry<ni1, fn<?>>> entrySet = allValueArguments.entrySet();
        q2 = n.q(entrySet, 10);
        ArrayList arrayList5 = new ArrayList(q2);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ni1 ni1Var3 = (ni1) entry.getKey();
            fn<?> fnVar = (fn) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(ni1Var3.b());
            sb.append(" = ");
            sb.append(!list.contains(ni1Var3) ? M0(fnVar) : "...");
            arrayList5.add(sb.toString());
        }
        m0 = CollectionsKt___CollectionsKt.m0(arrayList4, arrayList5);
        t0 = CollectionsKt___CollectionsKt.t0(m0);
        return t0;
    }

    private final boolean E1(f70 f70Var, StringBuilder sb) {
        if (P().contains(DescriptorRendererModifier.VISIBILITY)) {
            if (Q()) {
                f70Var = f70Var.f();
            }
            if (d0() || !b41.d(f70Var, e70.DEFAULT_VISIBILITY)) {
                sb.append(U0(f70Var.c()));
                sb.append(" ");
                return true;
            }
            return false;
        }
        return false;
    }

    private final void F0(StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        boolean J;
        if (P().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<hp0> excludedTypeAnnotationClasses = annotated instanceof z71 ? getExcludedTypeAnnotationClasses() : I();
            Function1<AnnotationDescriptor, Boolean> C = C();
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                J = CollectionsKt___CollectionsKt.J(excludedTypeAnnotationClasses, annotationDescriptor.getFqName());
                if (!J && !y0(annotationDescriptor) && (C == null || C.invoke(annotationDescriptor).booleanValue())) {
                    sb.append(b(annotationDescriptor, annotationUseSiteTarget));
                    if (H()) {
                        sb.append('\n');
                        b41.h(sb, "append('\\n')");
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    private final void F1(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        List<z71> L;
        if (u0()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            List<z71> upperBounds = typeParameterDescriptor.getUpperBounds();
            b41.h(upperBounds, "typeParameter.upperBounds");
            L = CollectionsKt___CollectionsKt.L(upperBounds, 1);
            for (z71 z71Var : L) {
                StringBuilder sb2 = new StringBuilder();
                ni1 name = typeParameterDescriptor.getName();
                b41.h(name, "typeParameter.name");
                sb2.append(f(name, false));
                sb2.append(" : ");
                b41.h(z71Var, AdvanceSetting.NETWORK_TYPE);
                sb2.append(g(z71Var));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(U0("where"));
            sb.append(" ");
            CollectionsKt___CollectionsKt.X(arrayList, sb, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, null, 124, null);
        }
    }

    static /* synthetic */ void G0(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.F0(sb, annotated, annotationUseSiteTarget);
    }

    private final String G1(String str, String str2, String str3, String str4, String str5) {
        boolean F;
        boolean F2;
        F = o.F(str, str2, false, 2, null);
        if (F) {
            F2 = o.F(str3, str4, false, 2, null);
            if (F2) {
                int length = str2.length();
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(length);
                b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                int length2 = str4.length();
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String substring2 = str3.substring(length2);
                b41.h(substring2, "(this as java.lang.String).substring(startIndex)");
                String r = b41.r(str5, substring);
                if (b41.d(substring, substring2)) {
                    return r;
                }
                if (y(substring, substring2)) {
                    return b41.r(r, jn1.AND_NOT);
                }
            }
        }
        return null;
    }

    private final void H0(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        b41.h(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        b41.h(parameters, "classifier.typeConstructor.parameters");
        if (p0() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            x1(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    private final boolean H1(z71 z71Var) {
        boolean z;
        if (up0.m(z71Var)) {
            List<TypeProjection> b2 = z71Var.b();
            if (!(b2 instanceof Collection) || !b2.isEmpty()) {
                for (TypeProjection typeProjection : b2) {
                    if (typeProjection.isStarProjection()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            return z;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(ClassDescriptor classDescriptor, StringBuilder sb) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        boolean z = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
        if (!j0()) {
            G0(this, sb, classDescriptor, null, 2, null);
            if (!z) {
                f70 visibility = classDescriptor.getVisibility();
                b41.h(visibility, "klass.visibility");
                E1(visibility, sb);
            }
            if ((classDescriptor.getKind() != ClassKind.INTERFACE || classDescriptor.getModality() != Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                b41.h(modality, "klass.modality");
                Y0(modality, sb, x0(classDescriptor));
            }
            W0(classDescriptor, sb);
            a1(sb, P().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner(), "inner");
            a1(sb, P().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData(), "data");
            a1(sb, P().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline(), "inline");
            a1(sb, P().contains(DescriptorRendererModifier.VALUE) && classDescriptor.isValue(), "value");
            a1(sb, P().contains(DescriptorRendererModifier.FUN) && classDescriptor.isFun(), "fun");
            J0(classDescriptor, sb);
        }
        if (!d70.x(classDescriptor)) {
            if (!j0()) {
                o1(sb);
            }
            b1(classDescriptor, sb, true);
        } else {
            L0(classDescriptor, sb);
        }
        if (z) {
            return;
        }
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        b41.h(declaredTypeParameters, "klass.declaredTypeParameters");
        y1(declaredTypeParameters, sb, false);
        H0(classDescriptor, sb);
        if (!classDescriptor.getKind().isSingleton() && E() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
            sb.append(" ");
            G0(this, sb, unsubstitutedPrimaryConstructor, null, 2, null);
            f70 visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
            b41.h(visibility2, "primaryConstructor.visibility");
            E1(visibility2, sb);
            sb.append(U0("constructor"));
            List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
            b41.h(valueParameters, "primaryConstructor.valueParameters");
            C1(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
        }
        p1(classDescriptor, sb);
        F1(declaredTypeParameters, sb);
    }

    private final boolean I1(boolean z) {
        int i = b.$EnumSwitchMapping$1[T().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            } else if (z) {
                return false;
            }
        }
        return true;
    }

    private final DescriptorRendererImpl J() {
        return (DescriptorRendererImpl) this.b.getValue();
    }

    private final void J0(ClassDescriptor classDescriptor, StringBuilder sb) {
        sb.append(U0(DescriptorRenderer.Companion.a(classDescriptor)));
    }

    private final void L0(DeclarationDescriptor declarationDescriptor, StringBuilder sb) {
        if (Y()) {
            if (j0()) {
                sb.append("companion object");
            }
            o1(sb);
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb.append("of ");
                ni1 name = containingDeclaration.getName();
                b41.h(name, "containingDeclaration.name");
                sb.append(f(name, false));
            }
        }
        if (p0() || !b41.d(declarationDescriptor.getName(), af2.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!j0()) {
                o1(sb);
            }
            ni1 name2 = declarationDescriptor.getName();
            b41.h(name2, "descriptor.name");
            sb.append(f(name2, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String M0(fn<?> fnVar) {
        String o0;
        String Z;
        if (fnVar instanceof y7) {
            Z = CollectionsKt___CollectionsKt.Z(((y7) fnVar).b(), AVFSCacheConstants.COMMA_SEP, jn1.BLOCK_START_STR, "}", 0, null, new Function1<fn<?>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstant$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull fn<?> fnVar2) {
                    String M0;
                    b41.i(fnVar2, AdvanceSetting.NETWORK_TYPE);
                    M0 = DescriptorRendererImpl.this.M0(fnVar2);
                    return M0;
                }
            }, 24, null);
            return Z;
        } else if (fnVar instanceof d6) {
            o0 = StringsKt__StringsKt.o0(DescriptorRenderer.c(this, ((d6) fnVar).b(), null, 2, null), m80.DINAMIC_PREFIX_AT);
            return o0;
        } else if (fnVar instanceof g71) {
            g71.b b2 = ((g71) fnVar).b();
            if (b2 instanceof g71.b.a) {
                return ((g71.b.a) b2).a() + "::class";
            } else if (b2 instanceof g71.b.C0453b) {
                g71.b.C0453b c0453b = (g71.b.C0453b) b2;
                String b3 = c0453b.b().b().b();
                b41.h(b3, "classValue.classId.asSingleFqName().asString()");
                for (int i = 0; i < c0453b.a(); i++) {
                    b3 = "kotlin.Array<" + b3 + '>';
                }
                return b41.r(b3, "::class");
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            return fnVar.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N0(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r18, java.lang.StringBuilder r19) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.N0(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.StringBuilder):void");
    }

    private final void O0(StringBuilder sb, z71 z71Var) {
        G0(this, sb, z71Var, null, 2, null);
        j60 j60Var = z71Var instanceof j60 ? (j60) z71Var : null;
        fd2 o = j60Var != null ? j60Var.o() : null;
        if (a81.a(z71Var)) {
            if ((z71Var instanceof bu2) && V()) {
                sb.append(((bu2) z71Var).l());
            } else if ((z71Var instanceof jf0) && !O()) {
                sb.append(((jf0) z71Var).l());
            } else {
                sb.append(z71Var.c().toString());
            }
            sb.append(s1(z71Var.b()));
        } else if (z71Var instanceof ci2) {
            sb.append(((ci2) z71Var).l().toString());
        } else if (o instanceof ci2) {
            sb.append(((ci2) o).l().toString());
        } else {
            v1(this, sb, z71Var, null, 2, null);
        }
        if (z71Var.d()) {
            sb.append("?");
        }
        if (bf2.c(z71Var)) {
            sb.append("!!");
        }
    }

    private final String P0(String str) {
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "<font color=red><b>" + str + "</b></font>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final String Q0(List<ni1> list) {
        return z(q12.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        if (!j0()) {
            if (!i0()) {
                G0(this, sb, functionDescriptor, null, 2, null);
                f70 visibility = functionDescriptor.getVisibility();
                b41.h(visibility, "function.visibility");
                E1(visibility, sb);
                Z0(functionDescriptor, sb);
                if (K()) {
                    W0(functionDescriptor, sb);
                }
                e1(functionDescriptor, sb);
                if (K()) {
                    D0(functionDescriptor, sb);
                } else {
                    q1(functionDescriptor, sb);
                }
                V0(functionDescriptor, sb);
                if (p0()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(U0("fun"));
            sb.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            b41.h(typeParameters, "function.typeParameters");
            y1(typeParameters, sb, true);
            l1(functionDescriptor, sb);
        }
        b1(functionDescriptor, sb, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        b41.h(valueParameters, "function.valueParameters");
        C1(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb);
        m1(functionDescriptor, sb);
        z71 returnType = functionDescriptor.getReturnType();
        if (!s0() && (n0() || returnType == null || !kotlin.reflect.jvm.internal.impl.builtins.b.A0(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : g(returnType));
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        b41.h(typeParameters2, "function.typeParameters");
        F1(typeParameters2, sb);
    }

    private final void S0(StringBuilder sb, z71 z71Var) {
        ni1 ni1Var;
        char O0;
        int T;
        int T2;
        int length = sb.length();
        G0(J(), sb, z71Var, null, 2, null);
        boolean z = true;
        boolean z2 = sb.length() != length;
        boolean o = up0.o(z71Var);
        boolean d = z71Var.d();
        z71 h = up0.h(z71Var);
        boolean z3 = d || (z2 && h != null);
        if (z3) {
            if (o) {
                sb.insert(length, '(');
            } else {
                if (z2) {
                    O0 = q.O0(sb);
                    kotlin.text.b.c(O0);
                    T = StringsKt__StringsKt.T(sb);
                    if (sb.charAt(T - 1) != ')') {
                        T2 = StringsKt__StringsKt.T(sb);
                        sb.insert(T2, "()");
                    }
                }
                sb.append(jn1.BRACKET_START_STR);
            }
        }
        a1(sb, o, "suspend");
        if (h != null) {
            if ((!H1(h) || h.d()) && !w0(h)) {
                z = false;
            }
            if (z) {
                sb.append(jn1.BRACKET_START_STR);
            }
            c1(sb, h);
            if (z) {
                sb.append(jn1.BRACKET_END_STR);
            }
            sb.append(".");
        }
        sb.append(jn1.BRACKET_START_STR);
        int i = 0;
        for (TypeProjection typeProjection : up0.j(z71Var)) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            if (U()) {
                z71 type = typeProjection.getType();
                b41.h(type, "typeProjection.type");
                ni1Var = up0.c(type);
            } else {
                ni1Var = null;
            }
            if (ni1Var != null) {
                sb.append(f(ni1Var, false));
                sb.append(": ");
            }
            sb.append(h(typeProjection));
            i = i2;
        }
        sb.append(") ");
        sb.append(x());
        sb.append(" ");
        c1(sb, up0.i(z71Var));
        if (z3) {
            sb.append(jn1.BRACKET_END_STR);
        }
        if (d) {
            sb.append("?");
        }
    }

    private final void T0(VariableDescriptor variableDescriptor, StringBuilder sb) {
        fn<?> compileTimeInitializer;
        if (!N() || (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(z(M0(compileTimeInitializer)));
    }

    private final String U0(String str) {
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (D()) {
                    return str;
                }
                return "<b>" + str + "</b>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final void V0(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (P().contains(DescriptorRendererModifier.MEMBER_KIND) && p0() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            sb.append(jg.f(callableMemberDescriptor.getKind().name()));
            sb.append("*/ ");
        }
    }

    private final void W0(MemberDescriptor memberDescriptor, StringBuilder sb) {
        a1(sb, memberDescriptor.isExternal(), "external");
        boolean z = true;
        a1(sb, P().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect(), "expect");
        a1(sb, (P().contains(DescriptorRendererModifier.ACTUAL) && memberDescriptor.isActual()) ? false : false, "actual");
    }

    private final void Y0(Modality modality, StringBuilder sb, Modality modality2) {
        if (c0() || modality != modality2) {
            a1(sb, P().contains(DescriptorRendererModifier.MODALITY), jg.f(modality.name()));
        }
    }

    private final void Z0(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (d70.J(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (S() == OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.getModality() == Modality.OPEN && A0(callableMemberDescriptor)) {
            return;
        }
        Modality modality = callableMemberDescriptor.getModality();
        b41.h(modality, "callable.modality");
        Y0(modality, sb, x0(callableMemberDescriptor));
    }

    private final void a1(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(U0(str));
            sb.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z) {
        ni1 name = declarationDescriptor.getName();
        b41.h(name, "descriptor.name");
        sb.append(f(name, z));
    }

    private final void c1(StringBuilder sb, z71 z71Var) {
        gu2 f = z71Var.f();
        m0 m0Var = f instanceof m0 ? (m0) f : null;
        if (m0Var != null) {
            if (f0()) {
                d1(sb, m0Var.getExpandedType());
                return;
            }
            d1(sb, m0Var.o());
            if (g0()) {
                B0(sb, m0Var);
                return;
            }
            return;
        }
        d1(sb, z71Var);
    }

    private final void d1(StringBuilder sb, z71 z71Var) {
        if ((z71Var instanceof v13) && getDebugMode() && !((v13) z71Var).h()) {
            sb.append("<Not computed yet>");
            return;
        }
        gu2 f = z71Var.f();
        if (f instanceof ak0) {
            sb.append(((ak0) f).m(this, this));
        } else if (f instanceof fd2) {
            n1(sb, (fd2) f);
        }
    }

    private final void e1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (P().contains(DescriptorRendererModifier.OVERRIDE) && A0(callableMemberDescriptor) && S() != OverrideRenderingPolicy.RENDER_OPEN) {
            a1(sb, true, "override");
            if (p0()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb) {
        g1(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (getDebugMode()) {
            sb.append(" in ");
            b1(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    private final void g1(hp0 hp0Var, String str, StringBuilder sb) {
        sb.append(U0(str));
        ip0 j = hp0Var.j();
        b41.h(j, "fqName.toUnsafe()");
        String e = e(j);
        if (e.length() > 0) {
            sb.append(" ");
            sb.append(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(PackageViewDescriptor packageViewDescriptor, StringBuilder sb) {
        g1(packageViewDescriptor.getFqName(), "package", sb);
        if (getDebugMode()) {
            sb.append(" in context of ");
            b1(packageViewDescriptor.getModule(), sb, false);
        }
    }

    private final void i1(StringBuilder sb, tt1 tt1Var) {
        StringBuilder sb2;
        tt1 c = tt1Var.c();
        if (c == null) {
            sb2 = null;
        } else {
            i1(sb, c);
            sb.append('.');
            ni1 name = tt1Var.b().getName();
            b41.h(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(f(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            TypeConstructor typeConstructor = tt1Var.b().getTypeConstructor();
            b41.h(typeConstructor, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb.append(t1(typeConstructor));
        }
        sb.append(s1(tt1Var.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!j0()) {
            if (!i0()) {
                k1(propertyDescriptor, sb);
                f70 visibility = propertyDescriptor.getVisibility();
                b41.h(visibility, "property.visibility");
                E1(visibility, sb);
                boolean z = false;
                a1(sb, P().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst(), m80.CONSTANT_PREFIX);
                W0(propertyDescriptor, sb);
                Z0(propertyDescriptor, sb);
                e1(propertyDescriptor, sb);
                if (P().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z = true;
                }
                a1(sb, z, "lateinit");
                V0(propertyDescriptor, sb);
            }
            A1(this, propertyDescriptor, sb, false, 4, null);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            b41.h(typeParameters, "property.typeParameters");
            y1(typeParameters, sb, true);
            l1(propertyDescriptor, sb);
        }
        b1(propertyDescriptor, sb, true);
        sb.append(": ");
        z71 type = propertyDescriptor.getType();
        b41.h(type, "property.type");
        sb.append(g(type));
        m1(propertyDescriptor, sb);
        T0(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        b41.h(typeParameters2, "property.typeParameters");
        F1(typeParameters2, sb);
    }

    private final void k1(PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (P().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            G0(this, sb, propertyDescriptor, null, 2, null);
            FieldDescriptor backingField = propertyDescriptor.getBackingField();
            if (backingField != null) {
                F0(sb, backingField, AnnotationUseSiteTarget.FIELD);
            }
            FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
            if (delegateField != null) {
                F0(sb, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (W() == PropertyAccessorRenderingPolicy.NONE) {
                PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                if (getter != null) {
                    F0(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                if (setter == null) {
                    return;
                }
                F0(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                b41.h(valueParameters, "setter.valueParameters");
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) k.q0(valueParameters);
                b41.h(valueParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
                F0(sb, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
            }
        }
    }

    private final void l1(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            F0(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            z71 type = extensionReceiverParameter.getType();
            b41.h(type, "receiver.type");
            String g = g(type);
            if (H1(type) && !fr2.m(type)) {
                g = '(' + g + ')';
            }
            sb.append(g);
            sb.append(".");
        }
    }

    private final void m1(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (X() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            z71 type = extensionReceiverParameter.getType();
            b41.h(type, "receiver.type");
            sb.append(g(type));
        }
    }

    private final void n1(StringBuilder sb, fd2 fd2Var) {
        if (!b41.d(fd2Var, fr2.CANT_INFER_FUNCTION_PARAM_TYPE) && !fr2.l(fd2Var)) {
            if (kf0.t(fd2Var)) {
                if (m0()) {
                    String ni1Var = ((kf0.f) fd2Var.c()).b().getName().toString();
                    b41.h(ni1Var, "type.constructor as Unin…escriptor.name.toString()");
                    sb.append(P0(ni1Var));
                    return;
                }
                sb.append("???");
                return;
            } else if (a81.a(fd2Var)) {
                O0(sb, fd2Var);
                return;
            } else if (H1(fd2Var)) {
                S0(sb, fd2Var);
                return;
            } else {
                O0(sb, fd2Var);
                return;
            }
        }
        sb.append("???");
    }

    private final void o1(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final void p1(ClassDescriptor classDescriptor, StringBuilder sb) {
        if (t0() || kotlin.reflect.jvm.internal.impl.builtins.b.l0(classDescriptor.getDefaultType())) {
            return;
        }
        Collection<z71> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        b41.h(supertypes, "klass.typeConstructor.supertypes");
        if (supertypes.isEmpty()) {
            return;
        }
        if (supertypes.size() == 1 && kotlin.reflect.jvm.internal.impl.builtins.b.b0(supertypes.iterator().next())) {
            return;
        }
        o1(sb);
        sb.append(": ");
        CollectionsKt___CollectionsKt.X(supertypes, sb, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, new Function1<z71, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderSuperTypes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(z71 z71Var) {
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                b41.h(z71Var, AdvanceSetting.NETWORK_TYPE);
                return descriptorRendererImpl.g(z71Var);
            }
        }, 60, null);
    }

    private final void q1(FunctionDescriptor functionDescriptor, StringBuilder sb) {
        a1(sb, functionDescriptor.isSuspend(), "suspend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb) {
        G0(this, sb, typeAliasDescriptor, null, 2, null);
        f70 visibility = typeAliasDescriptor.getVisibility();
        b41.h(visibility, "typeAlias.visibility");
        E1(visibility, sb);
        W0(typeAliasDescriptor, sb);
        sb.append(U0("typealias"));
        sb.append(" ");
        b1(typeAliasDescriptor, sb, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        b41.h(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        y1(declaredTypeParameters, sb, false);
        H0(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(g(typeAliasDescriptor.getUnderlyingType()));
    }

    private final void u1(StringBuilder sb, z71 z71Var, TypeConstructor typeConstructor) {
        tt1 a2 = TypeParameterUtilsKt.a(z71Var);
        if (a2 == null) {
            sb.append(t1(typeConstructor));
            sb.append(s1(z71Var.b()));
            return;
        }
        i1(sb, a2);
    }

    private final void v(StringBuilder sb, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor containingDeclaration;
        String name;
        if ((declarationDescriptor instanceof PackageFragmentDescriptor) || (declarationDescriptor instanceof PackageViewDescriptor) || (containingDeclaration = declarationDescriptor.getContainingDeclaration()) == null || (containingDeclaration instanceof ModuleDescriptor)) {
            return;
        }
        sb.append(" ");
        sb.append(X0("defined in"));
        sb.append(" ");
        ip0 m = d70.m(containingDeclaration);
        b41.h(m, "getFqName(containingDeclaration)");
        sb.append(m.e() ? "root package" : e(m));
        if (r0() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
            sb.append(" ");
            sb.append(X0("in file"));
            sb.append(" ");
            sb.append(name);
        }
    }

    private final String v0() {
        return z(jn1.G);
    }

    static /* synthetic */ void v1(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, z71 z71Var, TypeConstructor typeConstructor, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = z71Var.c();
        }
        descriptorRendererImpl.u1(sb, z71Var, typeConstructor);
    }

    private final void w(StringBuilder sb, List<? extends TypeProjection> list) {
        CollectionsKt___CollectionsKt.X(list, sb, AVFSCacheConstants.COMMA_SEP, null, null, 0, null, new Function1<TypeProjection, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$appendTypeProjections$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull TypeProjection typeProjection) {
                b41.i(typeProjection, AdvanceSetting.NETWORK_TYPE);
                if (typeProjection.isStarProjection()) {
                    return jn1.MUL;
                }
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                z71 type = typeProjection.getType();
                b41.h(type, "it.type");
                String g = descriptorRendererImpl.g(type);
                if (typeProjection.getProjectionKind() == Variance.INVARIANT) {
                    return g;
                }
                return typeProjection.getProjectionKind() + ' ' + g;
            }
        }, 60, null);
    }

    private final boolean w0(z71 z71Var) {
        return up0.o(z71Var) || !z71Var.getAnnotations().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(z0());
        }
        if (p0()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        a1(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z2 = true;
        a1(sb, label.length() > 0, label);
        G0(this, sb, typeParameterDescriptor, null, 2, null);
        b1(typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            z71 next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!kotlin.reflect.jvm.internal.impl.builtins.b.h0(next)) {
                sb.append(" : ");
                b41.h(next, "upperBound");
                sb.append(g(next));
            }
        } else if (z) {
            for (z71 z71Var : typeParameterDescriptor.getUpperBounds()) {
                if (!kotlin.reflect.jvm.internal.impl.builtins.b.h0(z71Var)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    b41.h(z71Var, "upperBound");
                    sb.append(g(z71Var));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(v0());
        }
    }

    private final String x() {
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "&rarr;";
            }
            throw new NoWhenBranchMatchedException();
        }
        return z("->");
    }

    private final Modality x0(MemberDescriptor memberDescriptor) {
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null && (memberDescriptor instanceof CallableMemberDescriptor)) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            b41.h(overriddenDescriptors, "this.overriddenDescriptors");
            if (!(!overriddenDescriptors.isEmpty()) || classDescriptor.getModality() == Modality.FINAL) {
                if (classDescriptor.getKind() == ClassKind.INTERFACE && !b41.d(callableMemberDescriptor.getVisibility(), e70.PRIVATE)) {
                    Modality modality = callableMemberDescriptor.getModality();
                    Modality modality2 = Modality.ABSTRACT;
                    return modality == modality2 ? modality2 : Modality.OPEN;
                }
                return Modality.FINAL;
            }
            return Modality.OPEN;
        }
        return Modality.FINAL;
    }

    private final void x1(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            w1(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
        }
    }

    private final boolean y(String str, String str2) {
        String z;
        boolean p;
        z = o.z(str2, "?", "", false, 4, null);
        if (!b41.d(str, z)) {
            p = o.p(str2, "?", false, 2, null);
            if (!p || !b41.d(b41.r(str, "?"), str2)) {
                if (!b41.d('(' + str + ")?", str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean y0(AnnotationDescriptor annotationDescriptor) {
        return b41.d(annotationDescriptor.getFqName(), c.a.parameterName);
    }

    private final void y1(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z) {
        if (!u0() && (!list.isEmpty())) {
            sb.append(z0());
            x1(sb, list);
            sb.append(v0());
            if (z) {
                sb.append(" ");
            }
        }
    }

    private final String z(String str) {
        return k0().escape(str);
    }

    private final String z0() {
        return z(jn1.L);
    }

    private final void z1(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z) {
        if (z || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(U0(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(" ");
        }
    }

    public boolean A() {
        return this.a.b();
    }

    public boolean B() {
        return this.a.c();
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> C() {
        return this.a.d();
    }

    public boolean D() {
        return this.a.e();
    }

    public boolean E() {
        return this.a.f();
    }

    @NotNull
    public ClassifierNamePolicy F() {
        return this.a.g();
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> G() {
        return this.a.h();
    }

    public boolean H() {
        return this.a.i();
    }

    @NotNull
    public Set<hp0> I() {
        return this.a.j();
    }

    public boolean K() {
        return this.a.k();
    }

    @NotNull
    public String K0(@NotNull ClassifierDescriptor classifierDescriptor) {
        b41.i(classifierDescriptor, "klass");
        if (kf0.r(classifierDescriptor)) {
            return classifierDescriptor.getTypeConstructor().toString();
        }
        return F().renderClassifier(classifierDescriptor, this);
    }

    public boolean L() {
        return this.a.l();
    }

    public boolean M() {
        return this.a.m();
    }

    public boolean N() {
        return this.a.n();
    }

    public boolean O() {
        return this.a.o();
    }

    @NotNull
    public Set<DescriptorRendererModifier> P() {
        return this.a.p();
    }

    public boolean Q() {
        return this.a.q();
    }

    @NotNull
    public final DescriptorRendererOptionsImpl R() {
        return this.a;
    }

    @NotNull
    public OverrideRenderingPolicy S() {
        return this.a.r();
    }

    @NotNull
    public ParameterNameRenderingPolicy T() {
        return this.a.s();
    }

    public boolean U() {
        return this.a.t();
    }

    public boolean V() {
        return this.a.u();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy W() {
        return this.a.v();
    }

    public boolean X() {
        return this.a.w();
    }

    @NotNull
    public String X0(@NotNull String str) {
        b41.i(str, "message");
        int i = b.$EnumSwitchMapping$0[k0().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "<i>" + str + "</i>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    public boolean Y() {
        return this.a.x();
    }

    public boolean Z() {
        return this.a.y();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String a(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new a(this), sb);
        if (q0()) {
            v(sb, declarationDescriptor);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean a0() {
        return this.a.z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String b(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget) {
        b41.i(annotationDescriptor, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(b41.r(annotationUseSiteTarget.getRenderName(), ":"));
        }
        z71 type = annotationDescriptor.getType();
        sb.append(g(type));
        if (L()) {
            List<String> E0 = E0(annotationDescriptor);
            if (M() || (!E0.isEmpty())) {
                CollectionsKt___CollectionsKt.X(E0, sb, AVFSCacheConstants.COMMA_SEP, jn1.BRACKET_START_STR, jn1.BRACKET_END_STR, 0, null, null, 112, null);
            }
        }
        if (p0() && (a81.a(type) || (type.c().getDeclarationDescriptor() instanceof NotFoundClasses.b))) {
            sb.append(" /* annotation class not found */");
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean b0() {
        return this.a.A();
    }

    public boolean c0() {
        return this.a.B();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String d(@NotNull String str, @NotNull String str2, @NotNull kotlin.reflect.jvm.internal.impl.builtins.b bVar) {
        String K0;
        String K02;
        boolean F;
        b41.i(str, "lowerRendered");
        b41.i(str2, "upperRendered");
        b41.i(bVar, "builtIns");
        if (y(str, str2)) {
            F = o.F(str2, jn1.BRACKET_START_STR, false, 2, null);
            if (F) {
                return '(' + str + ")!";
            }
            return b41.r(str, jn1.AND_NOT);
        }
        ClassifierNamePolicy F2 = F();
        ClassDescriptor w = bVar.w();
        b41.h(w, "builtIns.collection");
        K0 = StringsKt__StringsKt.K0(F2.renderClassifier(w, this), "Collection", null, 2, null);
        String r = b41.r(K0, "Mutable");
        String G1 = G1(str, r, str2, K0, K0 + "(Mutable)");
        if (G1 != null) {
            return G1;
        }
        String G12 = G1(str, b41.r(K0, "MutableMap.MutableEntry"), str2, b41.r(K0, "Map.Entry"), b41.r(K0, "(Mutable)Map.(Mutable)Entry"));
        if (G12 != null) {
            return G12;
        }
        ClassifierNamePolicy F3 = F();
        ClassDescriptor j = bVar.j();
        b41.h(j, "builtIns.array");
        K02 = StringsKt__StringsKt.K0(F3.renderClassifier(j, this), "Array", null, 2, null);
        String G13 = G1(str, b41.r(K02, z("Array<")), str2, b41.r(K02, z("Array<out ")), b41.r(K02, z("Array<(out) ")));
        if (G13 != null) {
            return G13;
        }
        return '(' + str + ".." + str2 + ')';
    }

    public boolean d0() {
        return this.a.C();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String e(@NotNull ip0 ip0Var) {
        b41.i(ip0Var, "fqName");
        List<ni1> h = ip0Var.h();
        b41.h(h, "fqName.pathSegments()");
        return Q0(h);
    }

    public boolean e0() {
        return this.a.D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String f(@NotNull ni1 ni1Var, boolean z) {
        b41.i(ni1Var, "name");
        String z2 = z(q12.b(ni1Var));
        if (D() && k0() == RenderingFormat.HTML && z) {
            return "<b>" + z2 + "</b>";
        }
        return z2;
    }

    public boolean f0() {
        return this.a.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String g(@NotNull z71 z71Var) {
        b41.i(z71Var, "type");
        StringBuilder sb = new StringBuilder();
        c1(sb, l0().invoke(z71Var));
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean g0() {
        return this.a.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.a.getAnnotationArgumentsRenderingPolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.a.getDebugMode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.a.getEnhancedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public Set<hp0> getExcludedTypeAnnotationClasses() {
        return this.a.getExcludedTypeAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String h(@NotNull TypeProjection typeProjection) {
        List<? extends TypeProjection> e;
        b41.i(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        e = l.e(typeProjection);
        w(sb, e);
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean h0() {
        return this.a.G();
    }

    public boolean i0() {
        return this.a.H();
    }

    public boolean j0() {
        return this.a.I();
    }

    @NotNull
    public RenderingFormat k0() {
        return this.a.J();
    }

    @NotNull
    public Function1<z71, z71> l0() {
        return this.a.K();
    }

    public boolean m0() {
        return this.a.L();
    }

    public boolean n0() {
        return this.a.M();
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler o0() {
        return this.a.N();
    }

    public boolean p0() {
        return this.a.O();
    }

    public boolean q0() {
        return this.a.P();
    }

    public boolean r0() {
        return this.a.Q();
    }

    public boolean s0() {
        return this.a.R();
    }

    @NotNull
    public String s1(@NotNull List<? extends TypeProjection> list) {
        b41.i(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z0());
        w(sb, list);
        sb.append(v0());
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        b41.i(annotationArgumentsRenderingPolicy, "<set-?>");
        this.a.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        b41.i(classifierNamePolicy, "<set-?>");
        this.a.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z) {
        this.a.setDebugMode(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(@NotNull Set<hp0> set) {
        b41.i(set, "<set-?>");
        this.a.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        b41.i(set, "<set-?>");
        this.a.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        b41.i(parameterNameRenderingPolicy, "<set-?>");
        this.a.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z) {
        this.a.setReceiverAfterName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z) {
        this.a.setRenderCompanionObjectName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z) {
        this.a.setStartFromName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        b41.i(renderingFormat, "<set-?>");
        this.a.setTextFormat(renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z) {
        this.a.setVerbose(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z) {
        this.a.setWithDefinedIn(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z) {
        this.a.setWithoutSuperTypes(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z) {
        this.a.setWithoutTypeParameters(z);
    }

    public boolean t0() {
        return this.a.S();
    }

    @NotNull
    public String t1(@NotNull TypeConstructor typeConstructor) {
        b41.i(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor ? true : declarationDescriptor instanceof TypeAliasDescriptor) {
            return K0(declarationDescriptor);
        }
        if (declarationDescriptor == null) {
            if (typeConstructor instanceof IntersectionTypeConstructor) {
                return ((IntersectionTypeConstructor) typeConstructor).d(new Function1<z71, Object>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderTypeConstructor$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Object invoke(@NotNull z71 z71Var) {
                        b41.i(z71Var, AdvanceSetting.NETWORK_TYPE);
                        return z71Var instanceof ci2 ? ((ci2) z71Var).l() : z71Var;
                    }
                });
            }
            return typeConstructor.toString();
        }
        throw new IllegalStateException(b41.r("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
    }

    public boolean u0() {
        return this.a.T();
    }
}
