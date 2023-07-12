package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.collections.C8212k;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class zd implements ClassDescriptorFactory {
    @NotNull
    private final StorageManager a;
    @NotNull
    private final ModuleDescriptor b;

    public zd(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "module");
        this.a = storageManager;
        this.b = moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @Nullable
    public ClassDescriptor createClass(@NotNull hj hjVar) {
        boolean K;
        b41.i(hjVar, "classId");
        if (hjVar.k() || hjVar.l()) {
            return null;
        }
        String b = hjVar.i().b();
        b41.h(b, "classId.relativeClassName.asString()");
        K = StringsKt__StringsKt.K(b, "Function", false, 2, null);
        if (K) {
            hp0 h = hjVar.h();
            b41.h(h, "classId.packageFqName");
            FunctionClassKind.C8279a.C8280a c = FunctionClassKind.Companion.c(b, h);
            if (c == null) {
                return null;
            }
            FunctionClassKind a = c.a();
            int b2 = c.b();
            List<PackageFragmentDescriptor> fragments = this.b.getPackage(h).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof BuiltInsPackageFragment) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (obj2 instanceof FunctionInterfacePackageFragment) {
                    arrayList2.add(obj2);
                }
            }
            PackageFragmentDescriptor packageFragmentDescriptor = (FunctionInterfacePackageFragment) C8212k.R(arrayList2);
            if (packageFragmentDescriptor == null) {
                packageFragmentDescriptor = (BuiltInsPackageFragment) C8212k.P(arrayList);
            }
            return new qp0(this.a, packageFragmentDescriptor, a, b2);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    @NotNull
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull hp0 hp0Var) {
        Set d;
        b41.i(hp0Var, "packageFqName");
        d = C8203e0.d();
        return d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(@NotNull hp0 hp0Var, @NotNull ni1 ni1Var) {
        boolean F;
        boolean F2;
        boolean F3;
        boolean F4;
        b41.i(hp0Var, "packageFqName");
        b41.i(ni1Var, "name");
        String b = ni1Var.b();
        b41.h(b, "name.asString()");
        F = C8604o.F(b, "Function", false, 2, null);
        if (!F) {
            F2 = C8604o.F(b, "KFunction", false, 2, null);
            if (!F2) {
                F3 = C8604o.F(b, "SuspendFunction", false, 2, null);
                if (!F3) {
                    F4 = C8604o.F(b, "KSuspendFunction", false, 2, null);
                    if (!F4) {
                        return false;
                    }
                }
            }
        }
        return FunctionClassKind.Companion.c(b, hp0Var) != null;
    }
}
