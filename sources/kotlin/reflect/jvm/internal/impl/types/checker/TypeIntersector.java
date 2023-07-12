package kotlin.reflect.jvm.internal.impl.types.checker;

import com.alibaba.gaiax.GXTemplateEngine;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.bf2;
import tb.ci2;
import tb.dk0;
import tb.em1;
import tb.fd2;
import tb.gu2;
import tb.hk1;
import tb.j60;
import tb.k50;
import tb.z71;
import tb.zj1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypeIntersector {
    @NotNull
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class ResultNullability {
        public static final ResultNullability START = new START(GXTemplateEngine.b.STATE_START, 0);
        public static final ResultNullability ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
        public static final ResultNullability UNKNOWN = new UNKNOWN("UNKNOWN", 2);
        public static final ResultNullability NOT_NULL = new NOT_NULL("NOT_NULL", 3);
        private static final /* synthetic */ ResultNullability[] $VALUES = $values();

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @NotNull
            public ResultNullability combine(@NotNull gu2 gu2Var) {
                b41.i(gu2Var, "nextType");
                return getResultNullability(gu2Var);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static final class NOT_NULL extends ResultNullability {
            NOT_NULL(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @NotNull
            public NOT_NULL combine(@NotNull gu2 gu2Var) {
                b41.i(gu2Var, "nextType");
                return this;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static final class START extends ResultNullability {
            START(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @NotNull
            public ResultNullability combine(@NotNull gu2 gu2Var) {
                b41.i(gu2Var, "nextType");
                return getResultNullability(gu2Var);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @NotNull
            public ResultNullability combine(@NotNull gu2 gu2Var) {
                b41.i(gu2Var, "nextType");
                ResultNullability resultNullability = getResultNullability(gu2Var);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        private static final /* synthetic */ ResultNullability[] $values() {
            return new ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        private ResultNullability(String str, int i) {
        }

        public /* synthetic */ ResultNullability(String str, int i, k50 k50Var) {
            this(str, i);
        }

        public static ResultNullability valueOf(String str) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        @NotNull
        public abstract ResultNullability combine(@NotNull gu2 gu2Var);

        @NotNull
        protected final ResultNullability getResultNullability(@NotNull gu2 gu2Var) {
            b41.i(gu2Var, "<this>");
            return gu2Var.d() ? ACCEPT_NULL : ((gu2Var instanceof j60) && (((j60) gu2Var).o() instanceof ci2)) ? NOT_NULL : gu2Var instanceof ci2 ? UNKNOWN : em1.INSTANCE.a(gu2Var) ? NOT_NULL : UNKNOWN;
        }
    }

    private TypeIntersector() {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051 A[EDGE_INSN: B:27:0x0051->B:18:0x0051 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<tb.fd2> b(java.util.Collection<? extends tb.fd2> r8, kotlin.jvm.functions.Function2<? super tb.fd2, ? super tb.fd2, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            tb.b41.h(r8, r1)
        Le:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L57
            java.lang.Object r1 = r8.next()
            tb.fd2 r1 = (tb.fd2) r1
            boolean r2 = r0.isEmpty()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L24
        L22:
            r3 = 0
            goto L51
        L24:
            java.util.Iterator r2 = r0.iterator()
        L28:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L22
            java.lang.Object r5 = r2.next()
            tb.fd2 r5 = (tb.fd2) r5
            if (r5 == r1) goto L4e
            java.lang.String r6 = "lower"
            tb.b41.h(r5, r6)
            java.lang.String r6 = "upper"
            tb.b41.h(r1, r6)
            java.lang.Object r5 = r9.invoke(r5, r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L4e
            r5 = 1
            goto L4f
        L4e:
            r5 = 0
        L4f:
            if (r5 == 0) goto L28
        L51:
            if (r3 == 0) goto Le
            r8.remove()
            goto Le
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.b(java.util.Collection, kotlin.jvm.functions.Function2):java.util.Collection");
    }

    private final fd2 d(final Set<? extends fd2> set) {
        if (set.size() == 1) {
            return (fd2) k.p0(set);
        }
        new Function0<String>() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String Z;
                Z = CollectionsKt___CollectionsKt.Z(set, null, null, null, 0, null, null, 63, null);
                return b41.r("This collections cannot be empty! input types: ", Z);
            }
        };
        Collection<fd2> b = b(set, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        b.isEmpty();
        fd2 b2 = IntegerLiteralTypeConstructor.Companion.b(b);
        if (b2 == null) {
            Collection<fd2> b3 = b(b, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.a()));
            b3.isEmpty();
            return b3.size() < 2 ? (fd2) k.p0(b3) : new IntersectionTypeConstructor(set).b();
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(z71 z71Var, z71 z71Var2) {
        hk1 a = NewKotlinTypeChecker.Companion.a();
        return a.isSubtypeOf(z71Var, z71Var2) && !a.isSubtypeOf(z71Var2, z71Var);
    }

    @NotNull
    public final fd2 c(@NotNull List<? extends fd2> list) {
        int q;
        b41.i(list, "types");
        list.size();
        ArrayList<gu2> arrayList = new ArrayList();
        for (fd2 fd2Var : list) {
            if (fd2Var.c() instanceof IntersectionTypeConstructor) {
                Collection<z71> supertypes = fd2Var.c().getSupertypes();
                b41.h(supertypes, "type.constructor.supertypes");
                q = n.q(supertypes, 10);
                ArrayList arrayList2 = new ArrayList(q);
                for (z71 z71Var : supertypes) {
                    b41.h(z71Var, AdvanceSetting.NETWORK_TYPE);
                    fd2 d = dk0.d(z71Var);
                    if (fd2Var.d()) {
                        d = d.j(true);
                    }
                    arrayList2.add(d);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(fd2Var);
            }
        }
        ResultNullability resultNullability = ResultNullability.START;
        for (gu2 gu2Var : arrayList) {
            resultNullability = resultNullability.combine(gu2Var);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            fd2 fd2Var2 = (fd2) it.next();
            if (resultNullability == ResultNullability.NOT_NULL) {
                if (fd2Var2 instanceof zj1) {
                    fd2Var2 = bf2.k((zj1) fd2Var2);
                }
                fd2Var2 = bf2.i(fd2Var2, false, 1, null);
            }
            linkedHashSet.add(fd2Var2);
        }
        return d(linkedHashSet);
    }
}
