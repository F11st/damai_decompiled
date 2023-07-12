package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a51;
import tb.a70;
import tb.ax2;
import tb.b41;
import tb.cx1;
import tb.d70;
import tb.dj;
import tb.dx1;
import tb.e51;
import tb.e70;
import tb.f51;
import tb.f70;
import tb.fj;
import tb.fr2;
import tb.h51;
import tb.hj;
import tb.i51;
import tb.k50;
import tb.kk;
import tb.m51;
import tb.mf1;
import tb.mw2;
import tb.n61;
import tb.ni1;
import tb.o61;
import tb.ow2;
import tb.q51;
import tb.q81;
import tb.r81;
import tb.ty1;
import tb.u51;
import tb.we0;
import tb.x60;
import tb.yd2;
import tb.yv2;
import tb.z60;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    @NotNull
    private final ClassDescriptor m;
    @NotNull
    private final JavaClass n;
    private final boolean o;
    @NotNull
    private final NotNullLazyValue<List<ClassConstructorDescriptor>> p;
    @NotNull
    private final NotNullLazyValue<Set<ni1>> q;
    @NotNull
    private final NotNullLazyValue<Map<ni1, JavaField>> r;
    @NotNull
    private final MemoizedFunctionToNullable<ni1, fj> s;

    public /* synthetic */ LazyJavaClassMemberScope(r81 r81Var, ClassDescriptor classDescriptor, JavaClass javaClass, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i, k50 k50Var) {
        this(r81Var, classDescriptor, javaClass, z, (i & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> A0(ni1 ni1Var) {
        int q;
        Collection<JavaMethod> findMethodsByName = r().invoke().findMethodsByName(ni1Var);
        q = n.q(findMethodsByName, 10);
        ArrayList arrayList = new ArrayList(q);
        for (JavaMethod javaMethod : findMethodsByName) {
            arrayList.add(B(javaMethod));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<SimpleFunctionDescriptor> B0(ni1 ni1Var) {
        Set<SimpleFunctionDescriptor> q0 = q0(ni1Var);
        ArrayList arrayList = new ArrayList();
        for (Object obj : q0) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            if (!(SpecialBuiltinMembers.a(simpleFunctionDescriptor) || BuiltinMethodsWithSpecialGenericSignature.k(simpleFunctionDescriptor) != null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean C0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        ni1 name = simpleFunctionDescriptor.getName();
        b41.h(name, "name");
        if (builtinMethodsWithSpecialGenericSignature.l(name)) {
            ni1 name2 = simpleFunctionDescriptor.getName();
            b41.h(name2, "name");
            Set<SimpleFunctionDescriptor> q0 = q0(name2);
            ArrayList<FunctionDescriptor> arrayList = new ArrayList();
            for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : q0) {
                FunctionDescriptor k = BuiltinMethodsWithSpecialGenericSignature.k(simpleFunctionDescriptor2);
                if (k != null) {
                    arrayList.add(k);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            for (FunctionDescriptor functionDescriptor : arrayList) {
                if (t0(simpleFunctionDescriptor, functionDescriptor)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final void N(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i, JavaMethod javaMethod, z71 z71Var, z71 z71Var2) {
        Annotations b = Annotations.Companion.b();
        ni1 name = javaMethod.getName();
        z71 o = fr2.o(z71Var);
        b41.h(o, "makeNotNullable(returnType)");
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, i, b, name, o, javaMethod.getHasAnnotationParameterDefaultValue(), false, false, z71Var2 == null ? null : fr2.o(z71Var2), p().a().t().source(javaMethod)));
    }

    private final void O(Collection<SimpleFunctionDescriptor> collection, ni1 ni1Var, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z) {
        List m0;
        int q;
        Collection<? extends SimpleFunctionDescriptor> d = a70.d(ni1Var, collection2, collection, v(), p().a().c(), p().a().k().getOverridingUtil());
        b41.h(d, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (!z) {
            collection.addAll(d);
            return;
        }
        m0 = CollectionsKt___CollectionsKt.m0(collection, d);
        q = n.q(d, 10);
        ArrayList arrayList = new ArrayList(q);
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : d) {
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.e(simpleFunctionDescriptor);
            if (simpleFunctionDescriptor2 == null) {
                b41.h(simpleFunctionDescriptor, "resolvedOverride");
            } else {
                b41.h(simpleFunctionDescriptor, "resolvedOverride");
                simpleFunctionDescriptor = Y(simpleFunctionDescriptor, simpleFunctionDescriptor2, m0);
            }
            arrayList.add(simpleFunctionDescriptor);
        }
        collection.addAll(arrayList);
    }

    private final void P(ni1 ni1Var, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : collection2) {
            kk.a(collection3, w0(simpleFunctionDescriptor, function1, ni1Var, collection));
            kk.a(collection3, v0(simpleFunctionDescriptor, function1, collection));
            kk.a(collection3, x0(simpleFunctionDescriptor, function1));
        }
    }

    private final void Q(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        for (PropertyDescriptor propertyDescriptor : set) {
            m51 a0 = a0(propertyDescriptor, function1);
            if (a0 != null) {
                collection.add(a0);
                if (set2 == null) {
                    return;
                }
                set2.add(propertyDescriptor);
                return;
            }
        }
    }

    private final void R(ni1 ni1Var, Collection<PropertyDescriptor> collection) {
        JavaMethod javaMethod = (JavaMethod) k.r0(r().invoke().findMethodsByName(ni1Var));
        if (javaMethod == null) {
            return;
        }
        collection.add(c0(this, javaMethod, null, Modality.FINAL, 2, null));
    }

    private final Collection<z71> U() {
        if (this.o) {
            Collection<z71> supertypes = v().getTypeConstructor().getSupertypes();
            b41.h(supertypes, "ownerDescriptor.typeConstructor.supertypes");
            return supertypes;
        }
        return p().a().k().getKotlinTypeRefiner().f(v());
    }

    private final List<ValueParameterDescriptor> V(dj djVar) {
        Pair pair;
        Collection<JavaMethod> methods = this.n.getMethods();
        ArrayList arrayList = new ArrayList(methods.size());
        q51 d = u51.d(TypeUsage.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : methods) {
            if (b41.d(((JavaMethod) obj).getName(), o61.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<JavaMethod> list2 = (List) pair2.component2();
        list.size();
        JavaMethod javaMethod = (JavaMethod) k.R(list);
        if (javaMethod != null) {
            JavaType returnType = javaMethod.getReturnType();
            if (returnType instanceof JavaArrayType) {
                JavaArrayType javaArrayType = (JavaArrayType) returnType;
                pair = new Pair(p().g().k(javaArrayType, d, true), p().g().o(javaArrayType.getComponentType(), d));
            } else {
                pair = new Pair(p().g().o(returnType, d), null);
            }
            N(arrayList, djVar, 0, javaMethod, (z71) pair.component1(), (z71) pair.component2());
        }
        int i = 0;
        int i2 = javaMethod == null ? 0 : 1;
        for (JavaMethod javaMethod2 : list2) {
            N(arrayList, djVar, i + i2, javaMethod2, p().g().o(javaMethod2.getReturnType(), d), null);
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassConstructorDescriptor W() {
        List<ValueParameterDescriptor> emptyList;
        boolean isAnnotationType = this.n.isAnnotationType();
        if ((this.n.isInterface() || !this.n.hasDefaultConstructor()) && !isAnnotationType) {
            return null;
        }
        ClassDescriptor v = v();
        a51 M = a51.M(v, Annotations.Companion.b(), true, p().a().t().source(this.n));
        b41.h(M, "createJavaConstructor(\n ….source(jClass)\n        )");
        if (isAnnotationType) {
            emptyList = V(M);
        } else {
            emptyList = Collections.emptyList();
        }
        M.t(false);
        M.J(emptyList, o0(v));
        M.s(true);
        M.A(v.getDefaultType());
        p().a().h().recordConstructor(this.n, M);
        return M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassConstructorDescriptor X() {
        ClassDescriptor v = v();
        a51 M = a51.M(v, Annotations.Companion.b(), true, p().a().t().source(this.n));
        b41.h(M, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<ValueParameterDescriptor> d0 = d0(M);
        M.t(false);
        M.J(d0, o0(v));
        M.s(false);
        M.A(v.getDefaultType());
        return M;
    }

    private final SimpleFunctionDescriptor Y(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z;
        boolean z2 = false;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : collection) {
                if (!b41.d(simpleFunctionDescriptor, simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && h0(simpleFunctionDescriptor2, callableDescriptor)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = true;
        if (z2) {
            return simpleFunctionDescriptor;
        }
        SimpleFunctionDescriptor build = simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        b41.f(build);
        return build;
    }

    private final SimpleFunctionDescriptor Z(FunctionDescriptor functionDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Object obj;
        int q;
        ni1 name = functionDescriptor.getName();
        b41.h(name, "overridden.name");
        Iterator<T> it = function1.invoke(name).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (t0((SimpleFunctionDescriptor) obj, functionDescriptor)) {
                break;
            }
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        b41.h(valueParameters, "overridden.valueParameters");
        q = n.q(valueParameters, 10);
        ArrayList arrayList = new ArrayList(q);
        for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
            z71 type = valueParameterDescriptor.getType();
            b41.h(type, "it.type");
            arrayList.add(new ax2(type, valueParameterDescriptor.declaresDefaultValue()));
        }
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        b41.h(valueParameters2, "override.valueParameters");
        newCopyBuilder.setValueParameters(yv2.a(arrayList, valueParameters2, functionDescriptor));
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        return newCopyBuilder.build();
    }

    private final m51 a0(PropertyDescriptor propertyDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        List<? extends TypeParameterDescriptor> g;
        dx1 dx1Var = null;
        if (g0(propertyDescriptor, function1)) {
            SimpleFunctionDescriptor m0 = m0(propertyDescriptor, function1);
            b41.f(m0);
            if (propertyDescriptor.isVar()) {
                simpleFunctionDescriptor = n0(propertyDescriptor, function1);
                b41.f(simpleFunctionDescriptor);
            } else {
                simpleFunctionDescriptor = null;
            }
            if (simpleFunctionDescriptor != null) {
                simpleFunctionDescriptor.getModality();
                m0.getModality();
            }
            h51 h51Var = new h51(v(), m0, simpleFunctionDescriptor, propertyDescriptor);
            z71 returnType = m0.getReturnType();
            b41.f(returnType);
            g = m.g();
            h51Var.t(returnType, g, s(), null);
            cx1 h = x60.h(h51Var, m0.getAnnotations(), false, false, false, m0.getSource());
            h.h(m0);
            h.k(h51Var.getType());
            b41.h(h, "createGetter(\n          …escriptor.type)\n        }");
            if (simpleFunctionDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
                b41.h(valueParameters, "setterMethod.valueParameters");
                ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) k.R(valueParameters);
                if (valueParameterDescriptor != null) {
                    dx1Var = x60.k(h51Var, simpleFunctionDescriptor.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor.getSource());
                    dx1Var.h(simpleFunctionDescriptor);
                } else {
                    throw new AssertionError(b41.r("No parameter found for ", simpleFunctionDescriptor));
                }
            }
            h51Var.n(h, dx1Var);
            return h51Var;
        }
        return null;
    }

    private final m51 b0(JavaMethod javaMethod, z71 z71Var, Modality modality) {
        List<? extends TypeParameterDescriptor> g;
        m51 v = m51.v(v(), q81.a(p(), javaMethod), modality, mw2.a(javaMethod.getVisibility()), false, javaMethod.getName(), p().a().t().source(javaMethod), false);
        b41.h(v, "create(\n            owne…inal = */ false\n        )");
        cx1 b = x60.b(v, Annotations.Companion.b());
        b41.h(b, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        v.n(b, null);
        z71 j = z71Var == null ? j(javaMethod, ContextKt.f(p(), v, javaMethod, 0, 4, null)) : z71Var;
        g = m.g();
        v.t(j, g, s(), null);
        b.k(j);
        return v;
    }

    static /* synthetic */ m51 c0(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaMethod javaMethod, z71 z71Var, Modality modality, int i, Object obj) {
        if ((i & 2) != 0) {
            z71Var = null;
        }
        return lazyJavaClassMemberScope.b0(javaMethod, z71Var, modality);
    }

    private final List<ValueParameterDescriptor> d0(dj djVar) {
        Collection<JavaRecordComponent> recordComponents = this.n.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        z71 z71Var = null;
        q51 d = u51.d(TypeUsage.COMMON, false, null, 2, null);
        int i = 0;
        for (JavaRecordComponent javaRecordComponent : recordComponents) {
            int i2 = i + 1;
            z71 o = p().g().o(javaRecordComponent.getType(), d);
            arrayList.add(new ValueParameterDescriptorImpl(djVar, null, i, Annotations.Companion.b(), javaRecordComponent.getName(), o, false, false, false, javaRecordComponent.isVararg() ? p().a().m().getBuiltIns().k(o) : z71Var, p().a().t().source(javaRecordComponent)));
            i = i2;
            z71Var = null;
        }
        return arrayList;
    }

    private final SimpleFunctionDescriptor e0(SimpleFunctionDescriptor simpleFunctionDescriptor, ni1 ni1Var) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setName(ni1Var);
        newCopyBuilder.setSignatureChange();
        newCopyBuilder.setPreserveSourceElement();
        SimpleFunctionDescriptor build = newCopyBuilder.build();
        b41.f(build);
        return build;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (tb.fj2.a(r3, p().a().q().isReleaseCoroutines()) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor f0(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.getValueParameters()
            java.lang.String r1 = "valueParameters"
            tb.b41.h(r0, r1)
            java.lang.Object r0 = kotlin.collections.k.d0(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            r2 = 0
            if (r0 != 0) goto L14
        L12:
            r0 = r2
            goto L50
        L14:
            tb.z71 r3 = r0.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.c()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.getDeclarationDescriptor()
            if (r3 != 0) goto L24
        L22:
            r3 = r2
            goto L3a
        L24:
            tb.ip0 r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.j(r3)
            if (r3 != 0) goto L2b
            goto L22
        L2b:
            boolean r4 = r3.f()
            if (r4 == 0) goto L32
            goto L33
        L32:
            r3 = r2
        L33:
            if (r3 != 0) goto L36
            goto L22
        L36:
            tb.hp0 r3 = r3.l()
        L3a:
            tb.r81 r4 = r5.p()
            tb.n51 r4 = r4.a()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r4 = r4.q()
            boolean r4 = r4.isReleaseCoroutines()
            boolean r3 = tb.fj2.a(r3, r4)
            if (r3 == 0) goto L12
        L50:
            if (r0 != 0) goto L53
            return r2
        L53:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r2 = r6.newCopyBuilder()
            java.util.List r6 = r6.getValueParameters()
            tb.b41.h(r6, r1)
            r1 = 1
            java.util.List r6 = kotlin.collections.k.M(r6, r1)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r2.setValueParameters(r6)
            tb.z71 r0 = r0.getType()
            java.util.List r0 = r0.b()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            tb.z71 r0 = r0.getType()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r6 = r6.setReturnType(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = r6.build()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r6
            r0 = r6
            tb.cd2 r0 = (tb.cd2) r0
            if (r0 != 0) goto L8a
            goto L8d
        L8a:
            r0.B(r1)
        L8d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.f0(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor");
    }

    private final boolean g0(PropertyDescriptor propertyDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (e51.a(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor m0 = m0(propertyDescriptor, function1);
        SimpleFunctionDescriptor n0 = n0(propertyDescriptor, function1);
        if (m0 == null) {
            return false;
        }
        if (propertyDescriptor.isVar()) {
            return n0 != null && n0.getModality() == m0.getModality();
        }
        return true;
    }

    private final boolean h0(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.OverrideCompatibilityInfo.Result c = OverridingUtil.DEFAULT.G(callableDescriptor2, callableDescriptor, true).c();
        b41.h(c, "DEFAULT.isOverridableByW…iptor, this, true).result");
        return c == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !i51.Companion.a(callableDescriptor2, callableDescriptor);
    }

    private final boolean i0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z;
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.Companion;
        ni1 name = simpleFunctionDescriptor.getName();
        b41.h(name, "name");
        List<ni1> b = aVar.b(name);
        if (!(b instanceof Collection) || !b.isEmpty()) {
            for (ni1 ni1Var : b) {
                Set<SimpleFunctionDescriptor> q0 = q0(ni1Var);
                ArrayList<SimpleFunctionDescriptor> arrayList = new ArrayList();
                for (Object obj : q0) {
                    if (SpecialBuiltinMembers.a((SimpleFunctionDescriptor) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    SimpleFunctionDescriptor e0 = e0(simpleFunctionDescriptor, ni1Var);
                    if (!arrayList.isEmpty()) {
                        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : arrayList) {
                            if (j0(simpleFunctionDescriptor2, e0)) {
                                z = true;
                                continue;
                                break;
                            }
                        }
                    }
                }
                z = false;
                continue;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean j0(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.k(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        b41.h(functionDescriptor, "if (superDescriptor.isRe…iginal else subDescriptor");
        return h0(functionDescriptor, simpleFunctionDescriptor);
    }

    private final boolean k0(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z;
        SimpleFunctionDescriptor f0 = f0(simpleFunctionDescriptor);
        if (f0 == null) {
            return false;
        }
        ni1 name = simpleFunctionDescriptor.getName();
        b41.h(name, "name");
        Set<SimpleFunctionDescriptor> q0 = q0(name);
        if ((q0 instanceof Collection) && q0.isEmpty()) {
            return false;
        }
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : q0) {
            if (simpleFunctionDescriptor2.isSuspend() && h0(f0, simpleFunctionDescriptor2)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private final SimpleFunctionDescriptor l0(PropertyDescriptor propertyDescriptor, String str, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        ni1 f = ni1.f(str);
        b41.h(f, "identifier(getterName)");
        Iterator<T> it = function1.invoke(f).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                z71 returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final SimpleFunctionDescriptor m0(PropertyDescriptor propertyDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertyGetterDescriptor propertyGetterDescriptor = getter == null ? null : (PropertyGetterDescriptor) SpecialBuiltinMembers.d(getter);
        String a = propertyGetterDescriptor != null ? ClassicBuiltinSpecialProperties.INSTANCE.a(propertyGetterDescriptor) : null;
        if (a != null && !SpecialBuiltinMembers.f(v(), propertyGetterDescriptor)) {
            return l0(propertyDescriptor, a, function1);
        }
        String b = propertyDescriptor.getName().b();
        b41.h(b, "name.asString()");
        return l0(propertyDescriptor, n61.a(b), function1);
    }

    private final SimpleFunctionDescriptor n0(PropertyDescriptor propertyDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        z71 returnType;
        String b = propertyDescriptor.getName().b();
        b41.h(b, "name.asString()");
        ni1 f = ni1.f(n61.d(b));
        b41.h(f, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = function1.invoke(f).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && b.A0(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                b41.h(valueParameters, "descriptor.valueParameters");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) k.q0(valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final f70 o0(ClassDescriptor classDescriptor) {
        f70 visibility = classDescriptor.getVisibility();
        b41.h(visibility, "classDescriptor.visibility");
        if (b41.d(visibility, f51.PROTECTED_STATIC_VISIBILITY)) {
            f70 f70Var = f51.PROTECTED_AND_PACKAGE;
            b41.h(f70Var, "PROTECTED_AND_PACKAGE");
            return f70Var;
        }
        return visibility;
    }

    private final Set<SimpleFunctionDescriptor> q0(ni1 ni1Var) {
        Collection<z71> U = U();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (z71 z71Var : U) {
            r.v(linkedHashSet, z71Var.getMemberScope().getContributedFunctions(ni1Var, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<PropertyDescriptor> s0(ni1 ni1Var) {
        Set<PropertyDescriptor> E0;
        int q;
        Collection<z71> U = U();
        ArrayList arrayList = new ArrayList();
        for (z71 z71Var : U) {
            Collection<? extends PropertyDescriptor> contributedVariables = z71Var.getMemberScope().getContributedVariables(ni1Var, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            q = n.q(contributedVariables, 10);
            ArrayList arrayList2 = new ArrayList(q);
            for (PropertyDescriptor propertyDescriptor : contributedVariables) {
                arrayList2.add(propertyDescriptor);
            }
            r.v(arrayList, arrayList2);
        }
        E0 = CollectionsKt___CollectionsKt.E0(arrayList);
        return E0;
    }

    private final boolean t0(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String c = mf1.c(simpleFunctionDescriptor, false, false, 2, null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        b41.h(original, "builtinWithErasedParameters.original");
        return b41.d(c, mf1.c(original, false, false, 2, null)) && !h0(simpleFunctionDescriptor, functionDescriptor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (tb.n61.c(r4) == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean u0(final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7) {
        /*
            r6 = this;
            tb.ni1 r0 = r7.getName()
            java.lang.String r1 = "function.name"
            tb.b41.h(r0, r1)
            java.util.List r0 = tb.zw1.a(r0)
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1b
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L1b
        L19:
            r0 = 0
            goto L78
        L1b:
            java.util.Iterator r0 = r0.iterator()
        L1f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L19
            java.lang.Object r1 = r0.next()
            tb.ni1 r1 = (tb.ni1) r1
            java.util.Set r1 = r6.s0(r1)
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L3b
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L3b
        L39:
            r1 = 0
            goto L75
        L3b:
            java.util.Iterator r1 = r1.iterator()
        L3f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L39
            java.lang.Object r4 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r4
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 r5 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1
            r5.<init>()
            boolean r5 = r6.g0(r4, r5)
            if (r5 == 0) goto L71
            boolean r4 = r4.isVar()
            if (r4 != 0) goto L6f
            tb.ni1 r4 = r7.getName()
            java.lang.String r4 = r4.b()
            java.lang.String r5 = "function.name.asString()"
            tb.b41.h(r4, r5)
            boolean r4 = tb.n61.c(r4)
            if (r4 != 0) goto L71
        L6f:
            r4 = 1
            goto L72
        L71:
            r4 = 0
        L72:
            if (r4 == 0) goto L3f
            r1 = 1
        L75:
            if (r1 == 0) goto L1f
            r0 = 1
        L78:
            if (r0 == 0) goto L7b
            return r3
        L7b:
            boolean r0 = r6.i0(r7)
            if (r0 != 0) goto L8e
            boolean r0 = r6.C0(r7)
            if (r0 != 0) goto L8e
            boolean r7 = r6.k0(r7)
            if (r7 != 0) goto L8e
            goto L8f
        L8e:
            r2 = 0
        L8f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.u0(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor):boolean");
    }

    private final SimpleFunctionDescriptor v0(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor Z;
        FunctionDescriptor k = BuiltinMethodsWithSpecialGenericSignature.k(simpleFunctionDescriptor);
        if (k == null || (Z = Z(k, function1)) == null) {
            return null;
        }
        if (!u0(Z)) {
            Z = null;
        }
        if (Z == null) {
            return null;
        }
        return Y(Z, k, collection);
    }

    private final SimpleFunctionDescriptor w0(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1, ni1 ni1Var, Collection<? extends SimpleFunctionDescriptor> collection) {
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.d(simpleFunctionDescriptor);
        if (simpleFunctionDescriptor2 == null) {
            return null;
        }
        String b = SpecialBuiltinMembers.b(simpleFunctionDescriptor2);
        b41.f(b);
        ni1 f = ni1.f(b);
        b41.h(f, "identifier(nameInJava)");
        for (SimpleFunctionDescriptor simpleFunctionDescriptor3 : function1.invoke(f)) {
            SimpleFunctionDescriptor e0 = e0(simpleFunctionDescriptor3, ni1Var);
            if (j0(simpleFunctionDescriptor2, e0)) {
                return Y(e0, simpleFunctionDescriptor2, collection);
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor x0(SimpleFunctionDescriptor simpleFunctionDescriptor, Function1<? super ni1, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (simpleFunctionDescriptor.isSuspend()) {
            ni1 name = simpleFunctionDescriptor.getName();
            b41.h(name, "descriptor.name");
            for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : function1.invoke(name)) {
                SimpleFunctionDescriptor f0 = f0(simpleFunctionDescriptor2);
                if (f0 == null || !h0(f0, simpleFunctionDescriptor)) {
                    f0 = null;
                    continue;
                }
                if (f0 != null) {
                    return f0;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a51 y0(JavaConstructor javaConstructor) {
        int q;
        List<TypeParameterDescriptor> m0;
        ClassDescriptor v = v();
        a51 M = a51.M(v, q81.a(p(), javaConstructor), false, p().a().t().source(javaConstructor));
        b41.h(M, "createJavaConstructor(\n …ce(constructor)\n        )");
        r81 e = ContextKt.e(p(), M, javaConstructor, v.getDeclaredTypeParameters().size());
        LazyJavaScope.b D = D(e, M, javaConstructor.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = v.getDeclaredTypeParameters();
        b41.h(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        List<JavaTypeParameter> typeParameters = javaConstructor.getTypeParameters();
        q = n.q(typeParameters, 10);
        ArrayList arrayList = new ArrayList(q);
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = e.f().resolveTypeParameter(javaTypeParameter);
            b41.f(resolveTypeParameter);
            arrayList.add(resolveTypeParameter);
        }
        m0 = CollectionsKt___CollectionsKt.m0(declaredTypeParameters, arrayList);
        M.K(D.a(), mw2.a(javaConstructor.getVisibility()), m0);
        M.s(false);
        M.t(D.b());
        M.A(v.getDefaultType());
        e.a().h().recordConstructor(javaConstructor, M);
        return M;
    }

    private final JavaMethodDescriptor z0(JavaRecordComponent javaRecordComponent) {
        List<? extends TypeParameterDescriptor> g;
        List<ValueParameterDescriptor> g2;
        JavaMethodDescriptor J = JavaMethodDescriptor.J(v(), q81.a(p(), javaRecordComponent), javaRecordComponent.getName(), p().a().t().source(javaRecordComponent), true);
        b41.h(J, "createJavaMethod(\n      …omponent), true\n        )");
        z71 o = p().g().o(javaRecordComponent.getType(), u51.d(TypeUsage.COMMON, false, null, 2, null));
        ReceiverParameterDescriptor s = s();
        g = m.g();
        g2 = m.g();
        J.I(null, s, g, g2, o, Modality.Companion.a(false, false, true), e70.PUBLIC, null);
        J.M(false, false);
        p().a().h().recordMethod(javaRecordComponent, J);
        return J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    protected LazyJavaScope.a A(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull z71 z71Var, @NotNull List<? extends ValueParameterDescriptor> list2) {
        b41.i(javaMethod, "method");
        b41.i(list, "methodTypeParameters");
        b41.i(z71Var, "returnType");
        b41.i(list2, "valueParameters");
        SignaturePropagator.b resolvePropagatedSignature = p().a().s().resolvePropagatedSignature(javaMethod, v(), z71Var, null, list2, list);
        b41.h(resolvePropagatedSignature, "c.components.signaturePr…dTypeParameters\n        )");
        z71 d = resolvePropagatedSignature.d();
        b41.h(d, "propagated.returnType");
        z71 c = resolvePropagatedSignature.c();
        List<ValueParameterDescriptor> f = resolvePropagatedSignature.f();
        b41.h(f, "propagated.valueParameters");
        List<TypeParameterDescriptor> e = resolvePropagatedSignature.e();
        b41.h(e, "propagated.typeParameters");
        boolean g = resolvePropagatedSignature.g();
        List<String> b = resolvePropagatedSignature.b();
        b41.h(b, "propagated.errors");
        return new LazyJavaScope.a(d, c, f, e, g, b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    /* renamed from: S */
    public LinkedHashSet<ni1> g(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        b41.i(z60Var, "kindFilter");
        Collection<z71> supertypes = v().getTypeConstructor().getSupertypes();
        b41.h(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<ni1> linkedHashSet = new LinkedHashSet<>();
        for (z71 z71Var : supertypes) {
            r.v(linkedHashSet, z71Var.getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(r().invoke().getMethodNames());
        linkedHashSet.addAll(r().invoke().getRecordComponentNames());
        linkedHashSet.addAll(e(z60Var, function1));
        linkedHashSet.addAll(p().a().w().getMethodNames(v()));
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    /* renamed from: T */
    public ClassDeclaredMemberIndex i() {
        return new ClassDeclaredMemberIndex(this.n, new Function1<JavaMember, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeMemberIndex$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull JavaMember javaMember) {
                b41.i(javaMember, AdvanceSetting.NETWORK_TYPE);
                return Boolean.valueOf(!javaMember.isStatic());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<ni1> e(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        Set<ni1> i;
        b41.i(z60Var, "kindFilter");
        i = f0.i(this.q.invoke(), this.r.invoke().keySet());
        return i;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        recordLookup(ni1Var, lookupLocation);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) u();
        fj invoke = lazyJavaClassMemberScope == null ? null : lazyJavaClassMemberScope.s.invoke(ni1Var);
        return invoke == null ? this.s.invoke(ni1Var) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        recordLookup(ni1Var, lookupLocation);
        return super.getContributedFunctions(ni1Var, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        recordLookup(ni1Var, lookupLocation);
        return super.getContributedVariables(ni1Var, lookupLocation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void h(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull ni1 ni1Var) {
        b41.i(collection, "result");
        b41.i(ni1Var, "name");
        if (this.n.isRecord() && r().invoke().findRecordComponentByName(ni1Var) != null) {
            boolean z = true;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                JavaRecordComponent findRecordComponentByName = r().invoke().findRecordComponentByName(ni1Var);
                b41.f(findRecordComponentByName);
                collection.add(z0(findRecordComponentByName));
            }
        }
        p().a().w().generateMethods(v(), ni1Var, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void k(@NotNull Collection<SimpleFunctionDescriptor> collection, @NotNull ni1 ni1Var) {
        List g;
        List m0;
        boolean z;
        b41.i(collection, "result");
        b41.i(ni1Var, "name");
        Set<SimpleFunctionDescriptor> q0 = q0(ni1Var);
        if (!SpecialGenericSignatures.Companion.k(ni1Var) && !BuiltinMethodsWithSpecialGenericSignature.INSTANCE.l(ni1Var)) {
            if (!(q0 instanceof Collection) || !q0.isEmpty()) {
                for (FunctionDescriptor functionDescriptor : q0) {
                    if (functionDescriptor.isSuspend()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : q0) {
                    if (u0((SimpleFunctionDescriptor) obj)) {
                        arrayList.add(obj);
                    }
                }
                O(collection, ni1Var, arrayList, false);
                return;
            }
        }
        yd2 a = yd2.Companion.a();
        g = m.g();
        Collection<? extends SimpleFunctionDescriptor> d = a70.d(ni1Var, q0, g, v(), ErrorReporter.DO_NOTHING, p().a().k().getOverridingUtil());
        b41.h(d, "resolveOverridesForNonSt….overridingUtil\n        )");
        P(ni1Var, collection, d, collection, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        P(ni1Var, collection, d, a, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : q0) {
            if (u0((SimpleFunctionDescriptor) obj2)) {
                arrayList2.add(obj2);
            }
        }
        m0 = CollectionsKt___CollectionsKt.m0(arrayList2, a);
        O(collection, ni1Var, m0, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void l(@NotNull ni1 ni1Var, @NotNull Collection<PropertyDescriptor> collection) {
        Set<? extends PropertyDescriptor> h;
        Set i;
        b41.i(ni1Var, "name");
        b41.i(collection, "result");
        if (this.n.isAnnotationType()) {
            R(ni1Var, collection);
        }
        Set<PropertyDescriptor> s0 = s0(ni1Var);
        if (s0.isEmpty()) {
            return;
        }
        yd2.b bVar = yd2.Companion;
        yd2 a = bVar.a();
        yd2 a2 = bVar.a();
        Q(s0, collection, a, new Function1<ni1, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull ni1 ni1Var2) {
                Collection<SimpleFunctionDescriptor> A0;
                b41.i(ni1Var2, AdvanceSetting.NETWORK_TYPE);
                A0 = LazyJavaClassMemberScope.this.A0(ni1Var2);
                return A0;
            }
        });
        h = f0.h(s0, a);
        Q(h, a2, null, new Function1<ni1, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$computeNonDeclaredProperties$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull ni1 ni1Var2) {
                Collection<SimpleFunctionDescriptor> B0;
                b41.i(ni1Var2, AdvanceSetting.NETWORK_TYPE);
                B0 = LazyJavaClassMemberScope.this.B0(ni1Var2);
                return B0;
            }
        });
        i = f0.i(s0, a2);
        Collection<? extends PropertyDescriptor> d = a70.d(ni1Var, i, collection, v(), p().a().c(), p().a().k().getOverridingUtil());
        b41.h(d, "resolveOverridesForNonSt…rridingUtil\n            )");
        collection.addAll(d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public Set<ni1> m(@NotNull z60 z60Var, @Nullable Function1<? super ni1, Boolean> function1) {
        b41.i(z60Var, "kindFilter");
        if (this.n.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(r().invoke().getFieldNames());
        Collection<z71> supertypes = v().getTypeConstructor().getSupertypes();
        b41.h(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        for (z71 z71Var : supertypes) {
            r.v(linkedHashSet, z71Var.getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @NotNull
    public final NotNullLazyValue<List<ClassConstructorDescriptor>> p0() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    /* renamed from: r0 */
    public ClassDescriptor v() {
        return this.m;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        ow2.a(p().a().l(), lookupLocation, v(), ni1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @Nullable
    protected ReceiverParameterDescriptor s() {
        return d70.l(v());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public String toString() {
        return b41.r("Lazy Java member scope for ", this.n.getFqName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public boolean z(@NotNull JavaMethodDescriptor javaMethodDescriptor) {
        b41.i(javaMethodDescriptor, "<this>");
        if (this.n.isAnnotationType()) {
            return false;
        }
        return u0(javaMethodDescriptor);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope(@NotNull final r81 r81Var, @NotNull ClassDescriptor classDescriptor, @NotNull JavaClass javaClass, boolean z, @Nullable LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(r81Var, lazyJavaClassMemberScope);
        b41.i(r81Var, c.a);
        b41.i(classDescriptor, "ownerDescriptor");
        b41.i(javaClass, "jClass");
        this.m = classDescriptor;
        this.n = javaClass;
        this.o = z;
        this.p = r81Var.e().createLazyValue(new Function0<List<? extends ClassConstructorDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$constructors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends ClassConstructorDescriptor> invoke() {
                JavaClass javaClass2;
                JavaClass javaClass3;
                List<? extends ClassConstructorDescriptor> A0;
                ClassConstructorDescriptor W;
                ?? k;
                ClassConstructorDescriptor X;
                JavaClass javaClass4;
                a51 y0;
                javaClass2 = LazyJavaClassMemberScope.this.n;
                Collection<JavaConstructor> constructors = javaClass2.getConstructors();
                ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList(constructors.size());
                for (JavaConstructor javaConstructor : constructors) {
                    y0 = LazyJavaClassMemberScope.this.y0(javaConstructor);
                    arrayList.add(y0);
                }
                javaClass3 = LazyJavaClassMemberScope.this.n;
                if (javaClass3.isRecord()) {
                    X = LazyJavaClassMemberScope.this.X();
                    boolean z2 = false;
                    String c = mf1.c(X, false, false, 2, null);
                    if (!arrayList.isEmpty()) {
                        for (ClassConstructorDescriptor classConstructorDescriptor : arrayList) {
                            if (b41.d(mf1.c(classConstructorDescriptor, false, false, 2, null), c)) {
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        arrayList.add(X);
                        JavaResolverCache h = r81Var.a().h();
                        javaClass4 = LazyJavaClassMemberScope.this.n;
                        h.recordConstructor(javaClass4, X);
                    }
                }
                r81Var.a().w().generateConstructors(LazyJavaClassMemberScope.this.v(), arrayList);
                SignatureEnhancement r = r81Var.a().r();
                r81 r81Var2 = r81Var;
                LazyJavaClassMemberScope lazyJavaClassMemberScope2 = LazyJavaClassMemberScope.this;
                boolean isEmpty = arrayList.isEmpty();
                ArrayList arrayList2 = arrayList;
                if (isEmpty) {
                    W = lazyJavaClassMemberScope2.W();
                    k = m.k(W);
                    arrayList2 = k;
                }
                A0 = CollectionsKt___CollectionsKt.A0(r.e(r81Var2, arrayList2));
                return A0;
            }
        });
        this.q = r81Var.e().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClassIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends ni1> invoke() {
                JavaClass javaClass2;
                Set<? extends ni1> E0;
                javaClass2 = LazyJavaClassMemberScope.this.n;
                E0 = CollectionsKt___CollectionsKt.E0(javaClass2.getInnerClassNames());
                return E0;
            }
        });
        this.r = r81Var.e().createLazyValue(new Function0<Map<ni1, ? extends JavaField>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$enumEntryIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<ni1, ? extends JavaField> invoke() {
                JavaClass javaClass2;
                int q;
                int e;
                int a;
                javaClass2 = LazyJavaClassMemberScope.this.n;
                Collection<JavaField> fields = javaClass2.getFields();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fields) {
                    if (((JavaField) obj).isEnumEntry()) {
                        arrayList.add(obj);
                    }
                }
                q = n.q(arrayList, 10);
                e = w.e(q);
                a = ty1.a(e, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a);
                for (Object obj2 : arrayList) {
                    linkedHashMap.put(((JavaField) obj2).getName(), obj2);
                }
                return linkedHashMap;
            }
        });
        this.s = r81Var.e().createMemoizedFunctionWithNullableValues(new Function1<ni1, fj>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final fj invoke(@NotNull ni1 ni1Var) {
                NotNullLazyValue notNullLazyValue;
                JavaClass javaClass2;
                NotNullLazyValue notNullLazyValue2;
                b41.i(ni1Var, "name");
                notNullLazyValue = LazyJavaClassMemberScope.this.q;
                if (!((Set) notNullLazyValue.invoke()).contains(ni1Var)) {
                    notNullLazyValue2 = LazyJavaClassMemberScope.this.r;
                    JavaField javaField = (JavaField) ((Map) notNullLazyValue2.invoke()).get(ni1Var);
                    if (javaField != null) {
                        StorageManager e = r81Var.e();
                        final LazyJavaClassMemberScope lazyJavaClassMemberScope2 = LazyJavaClassMemberScope.this;
                        return we0.f(r81Var.e(), LazyJavaClassMemberScope.this.v(), ni1Var, e.createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final Set<? extends ni1> invoke() {
                                Set<? extends ni1> i;
                                i = f0.i(LazyJavaClassMemberScope.this.getFunctionNames(), LazyJavaClassMemberScope.this.getVariableNames());
                                return i;
                            }
                        }), q81.a(r81Var, javaField), r81Var.a().t().source(javaField));
                    }
                    return null;
                }
                JavaClassFinder d = r81Var.a().d();
                hj h = DescriptorUtilsKt.h(LazyJavaClassMemberScope.this.v());
                b41.f(h);
                hj d2 = h.d(ni1Var);
                b41.h(d2, "ownerDescriptor.classId!…createNestedClassId(name)");
                javaClass2 = LazyJavaClassMemberScope.this.n;
                JavaClass findClass = d.findClass(new JavaClassFinder.a(d2, null, javaClass2, 2, null));
                if (findClass == null) {
                    return null;
                }
                r81 r81Var2 = r81Var;
                LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(r81Var2, LazyJavaClassMemberScope.this.v(), findClass, null, 8, null);
                r81Var2.a().e().reportClass(lazyJavaClassDescriptor);
                return lazyJavaClassDescriptor;
            }
        });
    }
}
