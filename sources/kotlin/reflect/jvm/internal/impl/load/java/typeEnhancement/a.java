package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.n;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.eu1;
import tb.hq2;
import tb.i21;
import tb.rq2;
import tb.s51;
import tb.ty1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class a {
    @NotNull
    private final Map<String, eu1> a = new LinkedHashMap();

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0418a {
        @NotNull
        private final String a;
        final /* synthetic */ a b;

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0419a {
            @NotNull
            private final String a;
            @NotNull
            private final List<Pair<String, rq2>> b;
            @NotNull
            private Pair<String, rq2> c;
            final /* synthetic */ C0418a d;

            public C0419a(@NotNull C0418a c0418a, String str) {
                b41.i(c0418a, "this$0");
                b41.i(str, "functionName");
                this.d = c0418a;
                this.a = str;
                this.b = new ArrayList();
                this.c = hq2.a("V", null);
            }

            @NotNull
            public final Pair<String, eu1> a() {
                int q;
                int q2;
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                String b = this.d.b();
                String b2 = b();
                List<Pair<String, rq2>> list = this.b;
                q = n.q(list, 10);
                ArrayList arrayList = new ArrayList(q);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                String k = signatureBuildingComponents.k(b, signatureBuildingComponents.j(b2, arrayList, this.c.getFirst()));
                rq2 second = this.c.getSecond();
                List<Pair<String, rq2>> list2 = this.b;
                q2 = n.q(list2, 10);
                ArrayList arrayList2 = new ArrayList(q2);
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((rq2) ((Pair) it2.next()).getSecond());
                }
                return hq2.a(k, new eu1(second, arrayList2));
            }

            @NotNull
            public final String b() {
                return this.a;
            }

            public final void c(@NotNull String str, @NotNull s51... s51VarArr) {
                Iterable<i21> k0;
                int q;
                int e;
                int a;
                rq2 rq2Var;
                b41.i(str, "type");
                b41.i(s51VarArr, "qualifiers");
                List<Pair<String, rq2>> list = this.b;
                if (s51VarArr.length == 0) {
                    rq2Var = null;
                } else {
                    k0 = ArraysKt___ArraysKt.k0(s51VarArr);
                    q = n.q(k0, 10);
                    e = w.e(q);
                    a = ty1.a(e, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(a);
                    for (i21 i21Var : k0) {
                        linkedHashMap.put(Integer.valueOf(i21Var.c()), (s51) i21Var.d());
                    }
                    rq2Var = new rq2(linkedHashMap);
                }
                list.add(hq2.a(str, rq2Var));
            }

            public final void d(@NotNull String str, @NotNull s51... s51VarArr) {
                Iterable<i21> k0;
                int q;
                int e;
                int a;
                b41.i(str, "type");
                b41.i(s51VarArr, "qualifiers");
                k0 = ArraysKt___ArraysKt.k0(s51VarArr);
                q = n.q(k0, 10);
                e = w.e(q);
                a = ty1.a(e, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(a);
                for (i21 i21Var : k0) {
                    linkedHashMap.put(Integer.valueOf(i21Var.c()), (s51) i21Var.d());
                }
                this.c = hq2.a(str, new rq2(linkedHashMap));
            }

            public final void e(@NotNull JvmPrimitiveType jvmPrimitiveType) {
                b41.i(jvmPrimitiveType, "type");
                String desc = jvmPrimitiveType.getDesc();
                b41.h(desc, "type.desc");
                this.c = hq2.a(desc, null);
            }
        }

        public C0418a(@NotNull a aVar, String str) {
            b41.i(aVar, "this$0");
            b41.i(str, PushClientConstants.TAG_CLASS_NAME);
            this.b = aVar;
            this.a = str;
        }

        public final void a(@NotNull String str, @NotNull Function1<? super C0419a, wt2> function1) {
            b41.i(str, "name");
            b41.i(function1, "block");
            Map map = this.b.a;
            C0419a c0419a = new C0419a(this, str);
            function1.invoke(c0419a);
            Pair<String, eu1> a = c0419a.a();
            map.put(a.getFirst(), a.getSecond());
        }

        @NotNull
        public final String b() {
            return this.a;
        }
    }

    @NotNull
    public final Map<String, eu1> b() {
        return this.a;
    }
}
