package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hp0;
import tb.zg1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PackageViewDescriptorFactory {
    @NotNull
    public static final C8312a Companion = C8312a.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory$a */
    /* loaded from: classes3.dex */
    public static final class C8312a {
        static final /* synthetic */ C8312a a = new C8312a();
        @NotNull
        private static final zg1<PackageViewDescriptorFactory> b = new zg1<>("PackageViewDescriptorFactory");

        private C8312a() {
        }

        @NotNull
        public final zg1<PackageViewDescriptorFactory> a() {
            return b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory$b */
    /* loaded from: classes3.dex */
    public static final class C8313b implements PackageViewDescriptorFactory {
        @NotNull
        public static final C8313b INSTANCE = new C8313b();

        private C8313b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory
        @NotNull
        public PackageViewDescriptor compute(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull hp0 hp0Var, @NotNull StorageManager storageManager) {
            b41.i(moduleDescriptorImpl, "module");
            b41.i(hp0Var, "fqName");
            b41.i(storageManager, "storageManager");
            return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, hp0Var, storageManager);
        }
    }

    @NotNull
    PackageViewDescriptor compute(@NotNull ModuleDescriptorImpl moduleDescriptorImpl, @NotNull hp0 hp0Var, @NotNull StorageManager storageManager);
}
