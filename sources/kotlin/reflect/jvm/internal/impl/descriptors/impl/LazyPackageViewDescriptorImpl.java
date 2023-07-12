package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.hp0;
import tb.kp1;
import tb.lh;
import tb.qi2;
import tb.t40;
import tb.tg2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LazyPackageViewDescriptorImpl extends t40 implements PackageViewDescriptor {
    static final /* synthetic */ KProperty<Object>[] h = {a12.i(new PropertyReference1Impl(a12.b(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(LazyPackageViewDescriptorImpl.class), DXRecyclerLayout.LOAD_MORE_EMPTY, "getEmpty()Z"))};
    @NotNull
    private final ModuleDescriptorImpl c;
    @NotNull
    private final hp0 d;
    @NotNull
    private final NotNullLazyValue e;
    @NotNull
    private final NotNullLazyValue f;
    @NotNull
    private final MemberScope g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull hp0 hp0Var, @NotNull StorageManager storageManager) {
        super(Annotations.Companion.b(), hp0Var.h());
        b41.i(moduleDescriptorImpl, "module");
        b41.i(hp0Var, "fqName");
        b41.i(storageManager, "storageManager");
        this.c = moduleDescriptorImpl;
        this.d = hp0Var;
        this.e = storageManager.createLazyValue(new Function0<List<? extends PackageFragmentDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$fragments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends PackageFragmentDescriptor> invoke() {
                return kp1.c(LazyPackageViewDescriptorImpl.this.getModule().k(), LazyPackageViewDescriptorImpl.this.getFqName());
            }
        });
        this.f = storageManager.createLazyValue(new Function0<Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$empty$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(kp1.b(LazyPackageViewDescriptorImpl.this.getModule().k(), LazyPackageViewDescriptorImpl.this.getFqName()));
            }
        });
        this.g = new LazyScopeAdapter(storageManager, new Function0<MemberScope>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$memberScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope invoke() {
                int q;
                List n0;
                if (LazyPackageViewDescriptorImpl.this.isEmpty()) {
                    return MemberScope.b.INSTANCE;
                }
                List<PackageFragmentDescriptor> fragments = LazyPackageViewDescriptorImpl.this.getFragments();
                q = n.q(fragments, 10);
                ArrayList arrayList = new ArrayList(q);
                for (PackageFragmentDescriptor packageFragmentDescriptor : fragments) {
                    arrayList.add(packageFragmentDescriptor.getMemberScope());
                }
                n0 = CollectionsKt___CollectionsKt.n0(arrayList, new qi2(LazyPackageViewDescriptorImpl.this.getModule(), LazyPackageViewDescriptorImpl.this.getFqName()));
                lh.a aVar = lh.Companion;
                return aVar.a("package view scope for " + LazyPackageViewDescriptorImpl.this.getFqName() + " in " + LazyPackageViewDescriptorImpl.this.getModule().getName(), n0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        b41.i(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @Nullable
    /* renamed from: c */
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().d()) {
            return null;
        }
        ModuleDescriptorImpl module = getModule();
        hp0 e = getFqName().e();
        b41.h(e, "fqName.parent()");
        return module.getPackage(e);
    }

    protected final boolean d() {
        return ((Boolean) tg2.a(this.f, this, h[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    /* renamed from: e */
    public ModuleDescriptorImpl getModule() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        return packageViewDescriptor != null && b41.d(getFqName(), packageViewDescriptor.getFqName()) && b41.d(getModule(), packageViewDescriptor.getModule());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public hp0 getFqName() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) tg2.a(this.e, this, h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    @NotNull
    public MemberScope getMemberScope() {
        return this.g;
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public boolean isEmpty() {
        return d();
    }
}
