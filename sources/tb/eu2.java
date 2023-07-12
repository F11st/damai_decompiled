package tb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class eu2 {
    @NotNull
    public static final eu2 INSTANCE = new eu2();
    @NotNull
    private static final Set<ni1> a;
    @NotNull
    private static final HashMap<hj, hj> b;
    @NotNull
    private static final HashMap<hj, hj> c;
    @NotNull
    private static final Set<ni1> d;

    static {
        Set<ni1> E0;
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        int i = 0;
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.getTypeName());
        }
        E0 = CollectionsKt___CollectionsKt.E0(arrayList);
        a = E0;
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType unsignedArrayType : values2) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        CollectionsKt___CollectionsKt.E0(arrayList2);
        b = new HashMap<>();
        c = new HashMap<>();
        kotlin.collections.x.k(hq2.a(UnsignedArrayType.UBYTEARRAY, ni1.f("ubyteArrayOf")), hq2.a(UnsignedArrayType.USHORTARRAY, ni1.f("ushortArrayOf")), hq2.a(UnsignedArrayType.UINTARRAY, ni1.f("uintArrayOf")), hq2.a(UnsignedArrayType.ULONGARRAY, ni1.f("ulongArrayOf")));
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values3) {
            linkedHashSet.add(unsignedType2.getArrayClassId().j());
        }
        d = linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        int length = values4.length;
        while (i < length) {
            UnsignedType unsignedType3 = values4[i];
            i++;
            b.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            c.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    private eu2() {
    }

    @JvmStatic
    public static final boolean d(@NotNull z71 z71Var) {
        ClassifierDescriptor declarationDescriptor;
        b41.i(z71Var, "type");
        if (fr2.w(z71Var) || (declarationDescriptor = z71Var.c().getDeclarationDescriptor()) == null) {
            return false;
        }
        return INSTANCE.c(declarationDescriptor);
    }

    @Nullable
    public final hj a(@NotNull hj hjVar) {
        b41.i(hjVar, "arrayClassId");
        return b.get(hjVar);
    }

    public final boolean b(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return d.contains(ni1Var);
    }

    public final boolean c(@NotNull DeclarationDescriptor declarationDescriptor) {
        b41.i(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && b41.d(((PackageFragmentDescriptor) containingDeclaration).getFqName(), kotlin.reflect.jvm.internal.impl.builtins.c.BUILT_INS_PACKAGE_FQ_NAME) && a.contains(declarationDescriptor.getName());
    }
}
