package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.collections.k;
import kotlin.collections.l;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.c81;
import tb.d70;
import tb.fn;
import tb.hj;
import tb.hp0;
import tb.ip0;
import tb.ni1;
import tb.sz1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DescriptorUtilsKt {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class a<N> implements DFS.Neighbors {
        public static final a<N> INSTANCE = new a<>();

        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
        @NotNull
        /* renamed from: a */
        public final Iterable<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
            int q;
            Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
            q = n.q(overriddenDescriptors, 10);
            ArrayList arrayList = new ArrayList(q);
            for (ValueParameterDescriptor valueParameterDescriptor2 : overriddenDescriptors) {
                arrayList.add(valueParameterDescriptor2.getOriginal());
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b<N> implements DFS.Neighbors {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
        @NotNull
        /* renamed from: a */
        public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
            List g;
            if (this.a) {
                callableMemberDescriptor = callableMemberDescriptor == null ? null : callableMemberDescriptor.getOriginal();
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor != null ? callableMemberDescriptor.getOverriddenDescriptors() : null;
            if (overriddenDescriptors == null) {
                g = m.g();
                return g;
            }
            return overriddenDescriptors;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends DFS.b<CallableMemberDescriptor, CallableMemberDescriptor> {
        final /* synthetic */ Ref$ObjectRef<CallableMemberDescriptor> a;
        final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Ref$ObjectRef<CallableMemberDescriptor> ref$ObjectRef, Function1<? super CallableMemberDescriptor, Boolean> function1) {
            this.a = ref$ObjectRef;
            this.b = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.b, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        /* renamed from: a */
        public void afterChildren(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            b41.i(callableMemberDescriptor, "current");
            if (this.a.element == null && this.b.invoke(callableMemberDescriptor).booleanValue()) {
                this.a.element = callableMemberDescriptor;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        /* renamed from: b */
        public boolean beforeChildren(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            b41.i(callableMemberDescriptor, "current");
            return this.a.element == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        @Nullable
        /* renamed from: c */
        public CallableMemberDescriptor result() {
            return this.a.element;
        }
    }

    static {
        b41.h(ni1.f("value"), "identifier(\"value\")");
    }

    public static final boolean a(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
        List e;
        b41.i(valueParameterDescriptor, "<this>");
        e = l.e(valueParameterDescriptor);
        Boolean e2 = DFS.e(e, a.INSTANCE, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        b41.h(e2, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return e2.booleanValue();
    }

    @Nullable
    public static final fn<?> b(@NotNull AnnotationDescriptor annotationDescriptor) {
        b41.i(annotationDescriptor, "<this>");
        return (fn) k.Q(annotationDescriptor.getAllValueArguments().values());
    }

    @Nullable
    public static final CallableMemberDescriptor c(@NotNull CallableMemberDescriptor callableMemberDescriptor, boolean z, @NotNull Function1<? super CallableMemberDescriptor, Boolean> function1) {
        List e;
        b41.i(callableMemberDescriptor, "<this>");
        b41.i(function1, "predicate");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        e = l.e(callableMemberDescriptor);
        return (CallableMemberDescriptor) DFS.b(e, new b(z), new c(ref$ObjectRef, function1));
    }

    public static /* synthetic */ CallableMemberDescriptor d(CallableMemberDescriptor callableMemberDescriptor, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(callableMemberDescriptor, z, function1);
    }

    @Nullable
    public static final hp0 e(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        ip0 j = j(declarationDescriptor);
        if (!j.f()) {
            j = null;
        }
        if (j == null) {
            return null;
        }
        return j.l();
    }

    @Nullable
    public static final ClassDescriptor f(@NotNull AnnotationDescriptor annotationDescriptor) {
        b41.i(annotationDescriptor, "<this>");
        ClassifierDescriptor declarationDescriptor = annotationDescriptor.getType().c().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.builtins.b g(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        return l(declarationDescriptor).getBuiltIns();
    }

    @Nullable
    public static final hj h(@Nullable ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        hj h;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new hj(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (h = h((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return h.d(classifierDescriptor.getName());
    }

    @NotNull
    public static final hp0 i(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        hp0 n = d70.n(declarationDescriptor);
        b41.h(n, "getFqNameSafe(this)");
        return n;
    }

    @NotNull
    public static final ip0 j(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        ip0 m = d70.m(declarationDescriptor);
        b41.h(m, "getFqName(this)");
        return m;
    }

    @NotNull
    public static final b81 k(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "<this>");
        sz1 sz1Var = (sz1) moduleDescriptor.getCapability(c81.a());
        b81 b81Var = sz1Var == null ? null : (b81) sz1Var.a();
        return b81Var == null ? b81.a.INSTANCE : b81Var;
    }

    @NotNull
    public static final ModuleDescriptor l(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        ModuleDescriptor g = d70.g(declarationDescriptor);
        b41.h(g, "getContainingModule(this)");
        return g;
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> m(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        return d.n(n(declarationDescriptor), 1);
    }

    @NotNull
    public static final Sequence<DeclarationDescriptor> n(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "<this>");
        return d.h(declarationDescriptor, new Function1<DeclarationDescriptor, DeclarationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$parentsWithSelf$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final DeclarationDescriptor invoke(@NotNull DeclarationDescriptor declarationDescriptor2) {
                b41.i(declarationDescriptor2, AdvanceSetting.NETWORK_TYPE);
                return declarationDescriptor2.getContainingDeclaration();
            }
        });
    }

    @NotNull
    public static final CallableMemberDescriptor o(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        b41.i(callableMemberDescriptor, "<this>");
        if (callableMemberDescriptor instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
            b41.h(correspondingProperty, "correspondingProperty");
            return correspondingProperty;
        }
        return callableMemberDescriptor;
    }

    @Nullable
    public static final ClassDescriptor p(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "<this>");
        for (z71 z71Var : classDescriptor.getDefaultType().c().getSupertypes()) {
            if (!kotlin.reflect.jvm.internal.impl.builtins.b.b0(z71Var)) {
                ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
                if (d70.w(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean q(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "<this>");
        sz1 sz1Var = (sz1) moduleDescriptor.getCapability(c81.a());
        return (sz1Var == null ? null : (b81) sz1Var.a()) != null;
    }

    @Nullable
    public static final ClassDescriptor r(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hp0 hp0Var, @NotNull LookupLocation lookupLocation) {
        b41.i(moduleDescriptor, "<this>");
        b41.i(hp0Var, "topLevelClassFqName");
        b41.i(lookupLocation, "location");
        hp0Var.d();
        hp0 e = hp0Var.e();
        b41.h(e, "topLevelClassFqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(e).getMemberScope();
        ni1 g = hp0Var.g();
        b41.h(g, "topLevelClassFqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(g, lookupLocation);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }
}
