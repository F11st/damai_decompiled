package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8201d0;
import kotlin.collections.C8203e0;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.gj;
import tb.hj;
import tb.hp0;
import tb.ip0;
import tb.k50;
import tb.ni1;
import tb.tg2;
import tb.tj;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    @NotNull
    private static final ni1 f;
    @NotNull
    private static final hj g;
    @NotNull
    private final ModuleDescriptor a;
    @NotNull
    private final Function1<ModuleDescriptor, DeclarationDescriptor> b;
    @NotNull
    private final NotNullLazyValue c;
    static final /* synthetic */ KProperty<Object>[] d = {a12.i(new PropertyReference1Impl(a12.b(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    @NotNull
    public static final C8281a Companion = new C8281a(null);
    @NotNull
    private static final hp0 e = C8277c.BUILT_INS_PACKAGE_FQ_NAME;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$a */
    /* loaded from: classes3.dex */
    public static final class C8281a {
        private C8281a() {
        }

        public /* synthetic */ C8281a(k50 k50Var) {
            this();
        }

        @NotNull
        public final hj a() {
            return JvmBuiltInClassDescriptorFactory.g;
        }
    }

    static {
        ip0 ip0Var = C8277c.C8278a.cloneable;
        ni1 i = ip0Var.i();
        b41.h(i, "cloneable.shortName()");
        f = i;
        hj m = hj.m(ip0Var.l());
        b41.h(m, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        g = m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(@NotNull final StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> function1) {
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "moduleDescriptor");
        b41.i(function1, "computeContainingDeclaration");
        this.a = moduleDescriptor;
        this.b = function1;
        this.c = storageManager.createLazyValue(new Function0<gj>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$cloneable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final gj invoke() {
                Function1 function12;
                ModuleDescriptor moduleDescriptor2;
                ni1 ni1Var;
                ModuleDescriptor moduleDescriptor3;
                List e2;
                Set<ClassConstructorDescriptor> d2;
                function12 = JvmBuiltInClassDescriptorFactory.this.b;
                moduleDescriptor2 = JvmBuiltInClassDescriptorFactory.this.a;
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) function12.invoke(moduleDescriptor2);
                ni1Var = JvmBuiltInClassDescriptorFactory.f;
                Modality modality = Modality.ABSTRACT;
                ClassKind classKind = ClassKind.INTERFACE;
                moduleDescriptor3 = JvmBuiltInClassDescriptorFactory.this.a;
                e2 = C8213l.e(moduleDescriptor3.getBuiltIns().i());
                gj gjVar = new gj(declarationDescriptor, ni1Var, modality, classKind, e2, SourceElement.NO_SOURCE, false, storageManager);
                tj tjVar = new tj(storageManager, gjVar);
                d2 = C8203e0.d();
                gjVar.e(tjVar, d2, null);
                return gjVar;
            }
        });
    }

    private final gj f() {
        return (gj) tg2.a(this.c, this, d[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @Nullable
    public ClassDescriptor createClass(@NotNull hj hjVar) {
        b41.i(hjVar, "classId");
        if (b41.d(hjVar, g)) {
            return f();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull hp0 hp0Var) {
        Set d2;
        Set c;
        b41.i(hp0Var, "packageFqName");
        if (b41.d(hp0Var, e)) {
            c = C8201d0.c(f());
            return c;
        }
        d2 = C8203e0.d();
        return d2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(@NotNull hp0 hp0Var, @NotNull ni1 ni1Var) {
        b41.i(hp0Var, "packageFqName");
        b41.i(ni1Var, "name");
        return b41.d(ni1Var, f) && b41.d(hp0Var, e);
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int i, k50 k50Var) {
        this(storageManager, moduleDescriptor, (i & 4) != 0 ? new Function1<ModuleDescriptor, BuiltInsPackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final BuiltInsPackageFragment invoke(@NotNull ModuleDescriptor moduleDescriptor2) {
                b41.i(moduleDescriptor2, "module");
                List<PackageFragmentDescriptor> fragments = moduleDescriptor2.getPackage(JvmBuiltInClassDescriptorFactory.e).getFragments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fragments) {
                    if (obj instanceof BuiltInsPackageFragment) {
                        arrayList.add(obj);
                    }
                }
                return (BuiltInsPackageFragment) C8212k.P(arrayList);
            }
        } : function1);
    }
}
