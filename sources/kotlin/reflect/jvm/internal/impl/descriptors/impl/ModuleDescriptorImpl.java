package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.C8203e0;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8226x;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bh1;
import tb.c81;
import tb.dl2;
import tb.hp0;
import tb.km;
import tb.ni1;
import tb.sz1;
import tb.t40;
import tb.zg1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl extends t40 implements ModuleDescriptor {
    @NotNull
    private final StorageManager c;
    @NotNull
    private final AbstractC8271b d;
    @NotNull
    private final Map<zg1<?>, Object> e;
    @NotNull
    private final PackageViewDescriptorFactory f;
    @Nullable
    private ModuleDependencies g;
    @Nullable
    private PackageFragmentProvider h;
    private boolean i;
    @NotNull
    private final MemoizedFunctionToNotNull<hp0, PackageViewDescriptor> j;
    @NotNull
    private final Lazy k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull ni1 ni1Var, @NotNull StorageManager storageManager, @NotNull AbstractC8271b abstractC8271b, @Nullable dl2 dl2Var) {
        this(ni1Var, storageManager, abstractC8271b, dl2Var, null, null, 48, null);
        b41.i(ni1Var, "moduleName");
        b41.i(storageManager, "storageManager");
        b41.i(abstractC8271b, "builtIns");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ModuleDescriptorImpl(tb.ni1 r10, kotlin.reflect.jvm.internal.impl.storage.StorageManager r11, kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b r12, tb.dl2 r13, java.util.Map r14, tb.ni1 r15, int r16, tb.k50 r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            r1 = 0
            if (r0 == 0) goto L7
            r6 = r1
            goto L8
        L7:
            r6 = r13
        L8:
            r0 = r16 & 16
            if (r0 == 0) goto L12
            java.util.Map r0 = kotlin.collections.C8223u.i()
            r7 = r0
            goto L13
        L12:
            r7 = r14
        L13:
            r0 = r16 & 32
            if (r0 == 0) goto L19
            r8 = r1
            goto L1a
        L19:
            r8 = r15
        L1a:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.<init>(tb.ni1, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.builtins.b, tb.dl2, java.util.Map, tb.ni1, int, tb.k50):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String ni1Var = getName().toString();
        b41.h(ni1Var, "name.toString()");
        return ni1Var;
    }

    private final km l() {
        return (km) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n() {
        return this.h != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) ModuleDescriptor.C8292a.a(this, declarationDescriptorVisitor, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public AbstractC8271b getBuiltIns() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @Nullable
    public <T> T getCapability(@NotNull zg1<T> zg1Var) {
        b41.i(zg1Var, "capability");
        return (T) this.e.get(zg1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.C8292a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.g;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + j() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public PackageViewDescriptor getPackage(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        i();
        return this.j.invoke(hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    @NotNull
    public Collection<hp0> getSubPackagesOf(@NotNull hp0 hp0Var, @NotNull Function1<? super ni1, Boolean> function1) {
        b41.i(hp0Var, "fqName");
        b41.i(function1, "nameFilter");
        i();
        return k().getSubPackagesOf(hp0Var, function1);
    }

    public void i() {
        if (!o()) {
            throw new InvalidModuleException(b41.r("Accessing invalid module descriptor ", this));
        }
    }

    @NotNull
    public final PackageFragmentProvider k() {
        i();
        return l();
    }

    public final void m(@NotNull PackageFragmentProvider packageFragmentProvider) {
        b41.i(packageFragmentProvider, "providerForModuleContent");
        n();
        this.h = packageFragmentProvider;
    }

    public boolean o() {
        return this.i;
    }

    public final void p(@NotNull List<ModuleDescriptorImpl> list) {
        Set<ModuleDescriptorImpl> d;
        b41.i(list, "descriptors");
        d = C8203e0.d();
        q(list, d);
    }

    public final void q(@NotNull List<ModuleDescriptorImpl> list, @NotNull Set<ModuleDescriptorImpl> set) {
        List g;
        Set d;
        b41.i(list, "descriptors");
        b41.i(set, "friends");
        g = C8214m.g();
        d = C8203e0.d();
        r(new bh1(list, set, g, d));
    }

    public final void r(@NotNull ModuleDependencies moduleDependencies) {
        b41.i(moduleDependencies, "dependencies");
        this.g = moduleDependencies;
    }

    public final void s(@NotNull ModuleDescriptorImpl... moduleDescriptorImplArr) {
        List<ModuleDescriptorImpl> X;
        b41.i(moduleDescriptorImplArr, "descriptors");
        X = ArraysKt___ArraysKt.X(moduleDescriptorImplArr);
        p(X);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
        boolean J;
        b41.i(moduleDescriptor, "targetModule");
        if (b41.d(this, moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.g;
        b41.f(moduleDependencies);
        J = CollectionsKt___CollectionsKt.J(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor);
        return J || getExpectedByModules().contains(moduleDescriptor) || moduleDescriptor.getExpectedByModules().contains(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull ni1 ni1Var, @NotNull StorageManager storageManager, @NotNull AbstractC8271b abstractC8271b, @Nullable dl2 dl2Var, @NotNull Map<zg1<?>, ? extends Object> map, @Nullable ni1 ni1Var2) {
        super(Annotations.Companion.b(), ni1Var);
        Map<zg1<?>, Object> v;
        Lazy b;
        b41.i(ni1Var, "moduleName");
        b41.i(storageManager, "storageManager");
        b41.i(abstractC8271b, "builtIns");
        b41.i(map, "capabilities");
        this.c = storageManager;
        this.d = abstractC8271b;
        if (ni1Var.g()) {
            v = C8226x.v(map);
            this.e = v;
            v.put(c81.a(), new sz1(null));
            PackageViewDescriptorFactory packageViewDescriptorFactory = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.a());
            this.f = packageViewDescriptorFactory == null ? PackageViewDescriptorFactory.C8313b.INSTANCE : packageViewDescriptorFactory;
            this.i = true;
            this.j = storageManager.createMemoizedFunction(new Function1<hp0, PackageViewDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packages$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final PackageViewDescriptor invoke(@NotNull hp0 hp0Var) {
                    PackageViewDescriptorFactory packageViewDescriptorFactory2;
                    StorageManager storageManager2;
                    b41.i(hp0Var, "fqName");
                    packageViewDescriptorFactory2 = ModuleDescriptorImpl.this.f;
                    ModuleDescriptorImpl moduleDescriptorImpl = ModuleDescriptorImpl.this;
                    storageManager2 = moduleDescriptorImpl.c;
                    return packageViewDescriptorFactory2.compute(moduleDescriptorImpl, hp0Var, storageManager2);
                }
            });
            b = C8177b.b(new Function0<km>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final km invoke() {
                    ModuleDependencies moduleDependencies;
                    String j;
                    int q;
                    PackageFragmentProvider packageFragmentProvider;
                    moduleDependencies = ModuleDescriptorImpl.this.g;
                    ModuleDescriptorImpl moduleDescriptorImpl = ModuleDescriptorImpl.this;
                    if (moduleDependencies != null) {
                        List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
                        allDependencies.contains(ModuleDescriptorImpl.this);
                        for (ModuleDescriptorImpl moduleDescriptorImpl2 : allDependencies) {
                            moduleDescriptorImpl2.n();
                        }
                        q = C8215n.q(allDependencies, 10);
                        ArrayList arrayList = new ArrayList(q);
                        for (ModuleDescriptorImpl moduleDescriptorImpl3 : allDependencies) {
                            packageFragmentProvider = moduleDescriptorImpl3.h;
                            b41.f(packageFragmentProvider);
                            arrayList.add(packageFragmentProvider);
                        }
                        return new km(arrayList, b41.r("CompositeProvider@ModuleDescriptor for ", ModuleDescriptorImpl.this.getName()));
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Dependencies of module ");
                    j = moduleDescriptorImpl.j();
                    sb.append(j);
                    sb.append(" were not set before querying module content");
                    throw new AssertionError(sb.toString());
                }
            });
            this.k = b;
            return;
        }
        throw new IllegalArgumentException(b41.r("Module name must be special: ", ni1Var));
    }
}
