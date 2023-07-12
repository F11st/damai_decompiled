package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wz1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class zz1 extends wz1 implements JavaArrayAnnotationArgument {
    @NotNull
    private final Object[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zz1(@Nullable ni1 ni1Var, @NotNull Object[] objArr) {
        super(ni1Var, null);
        b41.i(objArr, "values");
        this.b = objArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    @NotNull
    public List<wz1> getElements() {
        Object[] objArr = this.b;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            wz1.C9889a c9889a = wz1.Factory;
            b41.f(obj);
            arrayList.add(c9889a.a(obj, null));
        }
        return arrayList;
    }
}
