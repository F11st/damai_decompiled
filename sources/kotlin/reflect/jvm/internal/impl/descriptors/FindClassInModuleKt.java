package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hj;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FindClassInModuleKt {
    @Nullable
    public static final ClassDescriptor a(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hj hjVar) {
        b41.i(moduleDescriptor, "<this>");
        b41.i(hjVar, "classId");
        ClassifierDescriptor b = b(moduleDescriptor, hjVar);
        if (b instanceof ClassDescriptor) {
            return (ClassDescriptor) b;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014c  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor b(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r10, @org.jetbrains.annotations.NotNull tb.hj r11) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.b(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, tb.hj):kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor");
    }

    @NotNull
    public static final ClassDescriptor c(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hj hjVar, @NotNull NotFoundClasses notFoundClasses) {
        Sequence h;
        Sequence v;
        List<Integer> B;
        b41.i(moduleDescriptor, "<this>");
        b41.i(hjVar, "classId");
        b41.i(notFoundClasses, "notFoundClasses");
        ClassDescriptor a = a(moduleDescriptor, hjVar);
        if (a != null) {
            return a;
        }
        h = SequencesKt__SequencesKt.h(hjVar, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE);
        v = SequencesKt___SequencesKt.v(h, new Function1<hj, Integer>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(@NotNull hj hjVar2) {
                b41.i(hjVar2, AdvanceSetting.NETWORK_TYPE);
                return 0;
            }
        });
        B = SequencesKt___SequencesKt.B(v);
        return notFoundClasses.d(hjVar, B);
    }

    @Nullable
    public static final TypeAliasDescriptor d(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hj hjVar) {
        b41.i(moduleDescriptor, "<this>");
        b41.i(hjVar, "classId");
        ClassifierDescriptor b = b(moduleDescriptor, hjVar);
        if (b instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) b;
        }
        return null;
    }
}
