package tb;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class yz1 {
    @Nullable
    public static final vz1 a(@NotNull Annotation[] annotationArr, @NotNull hp0 hp0Var) {
        Annotation annotation;
        b41.i(annotationArr, "<this>");
        b41.i(hp0Var, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (b41.d(ReflectClassUtilKt.a(s61.b(s61.a(annotation))).b(), hp0Var)) {
                break;
            }
            i++;
        }
        if (annotation == null) {
            return null;
        }
        return new vz1(annotation);
    }

    @NotNull
    public static final List<vz1> b(@NotNull Annotation[] annotationArr) {
        b41.i(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new vz1(annotation));
        }
        return arrayList;
    }
}
