package tb;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ph0 {
    @NotNull
    public static final ph0 INSTANCE;
    @NotNull
    private static final HashMap<hp0, hp0> a;

    static {
        ph0 ph0Var = new ph0();
        INSTANCE = ph0Var;
        a = new HashMap<>();
        ph0Var.c(C8277c.C8278a.mutableList, ph0Var.a("java.util.ArrayList", "java.util.LinkedList"));
        ph0Var.c(C8277c.C8278a.mutableSet, ph0Var.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        ph0Var.c(C8277c.C8278a.mutableMap, ph0Var.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        ph0Var.c(new hp0("java.util.function.Function"), ph0Var.a("java.util.function.UnaryOperator"));
        ph0Var.c(new hp0("java.util.function.BiFunction"), ph0Var.a("java.util.function.BinaryOperator"));
    }

    private ph0() {
    }

    private final List<hp0> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new hp0(str));
        }
        return arrayList;
    }

    private final void c(hp0 hp0Var, List<hp0> list) {
        AbstractMap abstractMap = a;
        for (Object obj : list) {
            hp0 hp0Var2 = (hp0) obj;
            abstractMap.put(obj, hp0Var);
        }
    }

    @Nullable
    public final hp0 b(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "classFqName");
        return a.get(hp0Var);
    }
}
