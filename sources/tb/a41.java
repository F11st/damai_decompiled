package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a41 {
    @NotNull
    public static final gu2 a(@NotNull List<? extends gu2> list) {
        int q;
        int q2;
        fd2 k;
        b41.i(list, "types");
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                q = kotlin.collections.n.q(list, 10);
                ArrayList arrayList = new ArrayList(q);
                boolean z = false;
                boolean z2 = false;
                for (gu2 gu2Var : list) {
                    z = z || a81.a(gu2Var);
                    if (gu2Var instanceof fd2) {
                        k = (fd2) gu2Var;
                    } else if (gu2Var instanceof ak0) {
                        if (md0.a(gu2Var)) {
                            return gu2Var;
                        }
                        k = ((ak0) gu2Var).k();
                        z2 = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList.add(k);
                }
                if (z) {
                    fd2 j = kf0.j(b41.r("Intersection of error types: ", list));
                    b41.h(j, "createErrorType(\"Interse… of error types: $types\")");
                    return j;
                } else if (!z2) {
                    return TypeIntersector.INSTANCE.c(arrayList);
                } else {
                    q2 = kotlin.collections.n.q(list, 10);
                    ArrayList arrayList2 = new ArrayList(q2);
                    for (gu2 gu2Var2 : list) {
                        arrayList2.add(dk0.d(gu2Var2));
                    }
                    TypeIntersector typeIntersector = TypeIntersector.INSTANCE;
                    return KotlinTypeFactory.d(typeIntersector.c(arrayList), typeIntersector.c(arrayList2));
                }
            }
            return (gu2) kotlin.collections.k.q0(list);
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}
