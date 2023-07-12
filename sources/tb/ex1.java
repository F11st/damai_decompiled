package tb;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ex1 implements ClassDataFinder {
    @NotNull
    private final NameResolver a;
    @NotNull
    private final fc b;
    @NotNull
    private final Function1<hj, SourceElement> c;
    @NotNull
    private final Map<hj, ProtoBuf$Class> d;

    /* JADX WARN: Multi-variable type inference failed */
    public ex1(@NotNull ProtoBuf$PackageFragment protoBuf$PackageFragment, @NotNull NameResolver nameResolver, @NotNull fc fcVar, @NotNull Function1<? super hj, ? extends SourceElement> function1) {
        int q;
        int e;
        int a;
        b41.i(protoBuf$PackageFragment, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(fcVar, "metadataVersion");
        b41.i(function1, "classSource");
        this.a = nameResolver;
        this.b = fcVar;
        this.c = function1;
        List<ProtoBuf$Class> class_List = protoBuf$PackageFragment.getClass_List();
        b41.h(class_List, "proto.class_List");
        q = kotlin.collections.n.q(class_List, 10);
        e = kotlin.collections.w.e(q);
        a = ty1.a(e, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a);
        for (Object obj : class_List) {
            linkedHashMap.put(pi1.a(this.a, ((ProtoBuf$Class) obj).getFqName()), obj);
        }
        this.d = linkedHashMap;
    }

    @NotNull
    public final Collection<hj> a() {
        return this.d.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    @Nullable
    public ej findClassData(@NotNull hj hjVar) {
        b41.i(hjVar, "classId");
        ProtoBuf$Class protoBuf$Class = this.d.get(hjVar);
        if (protoBuf$Class == null) {
            return null;
        }
        return new ej(this.a, protoBuf$Class, this.b, this.c.invoke(hjVar));
    }
}
