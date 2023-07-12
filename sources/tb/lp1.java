package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.C8213l;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import tb.lh;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class lp1 {
    @NotNull
    private final DeserializedDescriptorResolver a;
    @NotNull
    private final u02 b;
    @NotNull
    private final ConcurrentHashMap<hj, MemberScope> c;

    public lp1(@NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull u02 u02Var) {
        b41.i(deserializedDescriptorResolver, "resolver");
        b41.i(u02Var, "kotlinClassFinder");
        this.a = deserializedDescriptorResolver;
        this.b = u02Var;
        this.c = new ConcurrentHashMap<>();
    }

    @NotNull
    public final MemberScope a(@NotNull t02 t02Var) {
        Collection<KotlinJvmBinaryClass> e;
        List A0;
        b41.i(t02Var, "fileClass");
        ConcurrentHashMap<hj, MemberScope> concurrentHashMap = this.c;
        hj classId = t02Var.getClassId();
        MemberScope memberScope = concurrentHashMap.get(classId);
        if (memberScope == null) {
            hp0 h = t02Var.getClassId().h();
            b41.h(h, "fileClass.classId.packageFqName");
            if (t02Var.getClassHeader().c() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> f = t02Var.getClassHeader().f();
                e = new ArrayList();
                for (String str : f) {
                    hj m = hj.m(t61.d(str).e());
                    b41.h(m, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                    KotlinJvmBinaryClass b = w71.b(this.b, m);
                    if (b != null) {
                        e.add(b);
                    }
                }
            } else {
                e = C8213l.e(t02Var);
            }
            ie0 ie0Var = new ie0(this.a.e().p(), h);
            ArrayList arrayList = new ArrayList();
            for (KotlinJvmBinaryClass kotlinJvmBinaryClass : e) {
                MemberScope c = this.a.c(ie0Var, kotlinJvmBinaryClass);
                if (c != null) {
                    arrayList.add(c);
                }
            }
            A0 = CollectionsKt___CollectionsKt.A0(arrayList);
            lh.C9410a c9410a = lh.Companion;
            MemberScope a = c9410a.a("package " + h + " (" + t02Var + ')', A0);
            MemberScope putIfAbsent = concurrentHashMap.putIfAbsent(classId, a);
            memberScope = putIfAbsent != null ? putIfAbsent : a;
        }
        b41.h(memberScope, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return memberScope;
    }
}
