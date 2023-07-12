package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class m70 implements ClassDataFinder {
    @NotNull
    private final PackageFragmentProvider a;

    public m70(@NotNull PackageFragmentProvider packageFragmentProvider) {
        b41.i(packageFragmentProvider, "packageFragmentProvider");
        this.a = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    @Nullable
    public ej findClassData(@NotNull hj hjVar) {
        ej findClassData;
        b41.i(hjVar, "classId");
        PackageFragmentProvider packageFragmentProvider = this.a;
        hp0 h = hjVar.h();
        b41.h(h, "classId.packageFqName");
        for (PackageFragmentDescriptor packageFragmentDescriptor : kp1.c(packageFragmentProvider, h)) {
            if ((packageFragmentDescriptor instanceof n70) && (findClassData = ((n70) packageFragmentDescriptor).d().findClassData(hjVar)) != null) {
                return findClassData;
            }
        }
        return null;
    }
}
