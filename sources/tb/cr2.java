package tb;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class cr2 {
    @NotNull
    public static final fd2 a(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        gu2 f = z71Var.f();
        fd2 fd2Var = f instanceof fd2 ? (fd2) f : null;
        if (fd2Var != null) {
            return fd2Var;
        }
        throw new IllegalStateException(b41.r("This is should be simple type: ", z71Var).toString());
    }

    @JvmOverloads
    @NotNull
    public static final z71 b(@NotNull z71 z71Var, @NotNull List<? extends TypeProjection> list, @NotNull Annotations annotations) {
        b41.i(z71Var, "<this>");
        b41.i(list, "newArguments");
        b41.i(annotations, "newAnnotations");
        return e(z71Var, list, annotations, null, 4, null);
    }

    @JvmOverloads
    @NotNull
    public static final z71 c(@NotNull z71 z71Var, @NotNull List<? extends TypeProjection> list, @NotNull Annotations annotations, @NotNull List<? extends TypeProjection> list2) {
        b41.i(z71Var, "<this>");
        b41.i(list, "newArguments");
        b41.i(annotations, "newAnnotations");
        b41.i(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == z71Var.b()) && annotations == z71Var.getAnnotations()) {
            return z71Var;
        }
        gu2 f = z71Var.f();
        if (f instanceof ak0) {
            ak0 ak0Var = (ak0) f;
            return KotlinTypeFactory.d(d(ak0Var.k(), list, annotations), d(ak0Var.l(), list2, annotations));
        } else if (f instanceof fd2) {
            return d((fd2) f, list, annotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @JvmOverloads
    @NotNull
    public static final fd2 d(@NotNull fd2 fd2Var, @NotNull List<? extends TypeProjection> list, @NotNull Annotations annotations) {
        b41.i(fd2Var, "<this>");
        b41.i(list, "newArguments");
        b41.i(annotations, "newAnnotations");
        if (list.isEmpty() && annotations == fd2Var.getAnnotations()) {
            return fd2Var;
        }
        if (list.isEmpty()) {
            return fd2Var.k(annotations);
        }
        return KotlinTypeFactory.i(annotations, fd2Var.c(), list, fd2Var.d(), null, 16, null);
    }

    public static /* synthetic */ z71 e(z71 z71Var, List list, Annotations annotations, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = z71Var.b();
        }
        if ((i & 2) != 0) {
            annotations = z71Var.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return c(z71Var, list, annotations, list2);
    }

    public static /* synthetic */ fd2 f(fd2 fd2Var, List list, Annotations annotations, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fd2Var.b();
        }
        if ((i & 2) != 0) {
            annotations = fd2Var.getAnnotations();
        }
        return d(fd2Var, list, annotations);
    }
}
