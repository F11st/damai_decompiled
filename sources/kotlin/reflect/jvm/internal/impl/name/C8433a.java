package kotlin.reflect.jvm.internal.impl.name;

import com.taobao.weex.common.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.name.a */
/* loaded from: classes3.dex */
public final class C8433a {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.name.a$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C8434a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public static final <V> V a(@NotNull hp0 hp0Var, @NotNull Map<hp0, ? extends V> map) {
        Object next;
        b41.i(hp0Var, "<this>");
        b41.i(map, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<hp0, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<hp0, ? extends V> next2 = it.next();
            hp0 key = next2.getKey();
            if (!b41.d(hp0Var, key) && !b(hp0Var, key)) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(next2.getKey(), next2.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int length = g((hp0) ((Map.Entry) next).getKey(), hp0Var).b().length();
                do {
                    Object next3 = it2.next();
                    int length2 = g((hp0) ((Map.Entry) next3).getKey(), hp0Var).b().length();
                    if (length > length2) {
                        next = next3;
                        length = length2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return null;
        }
        return (V) entry.getValue();
    }

    public static final boolean b(@NotNull hp0 hp0Var, @NotNull hp0 hp0Var2) {
        b41.i(hp0Var, "<this>");
        b41.i(hp0Var2, "packageName");
        return b41.d(f(hp0Var), hp0Var2);
    }

    private static final boolean c(String str, String str2) {
        boolean F;
        F = C8604o.F(str, str2, false, 2, null);
        return F && str.charAt(str2.length()) == '.';
    }

    public static final boolean d(@NotNull hp0 hp0Var, @NotNull hp0 hp0Var2) {
        b41.i(hp0Var, "<this>");
        b41.i(hp0Var2, "packageName");
        if (b41.d(hp0Var, hp0Var2) || hp0Var2.d()) {
            return true;
        }
        String b = hp0Var.b();
        b41.h(b, "this.asString()");
        String b2 = hp0Var2.b();
        b41.h(b2, "packageName.asString()");
        return c(b, b2);
    }

    public static final boolean e(@Nullable String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            i++;
            int i2 = C8434a.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i2 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        return state != State.AFTER_DOT;
    }

    @Nullable
    public static final hp0 f(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "<this>");
        if (hp0Var.d()) {
            return null;
        }
        return hp0Var.e();
    }

    @NotNull
    public static final hp0 g(@NotNull hp0 hp0Var, @NotNull hp0 hp0Var2) {
        b41.i(hp0Var, "<this>");
        b41.i(hp0Var2, Constants.Name.PREFIX);
        if (!d(hp0Var, hp0Var2) || hp0Var2.d()) {
            return hp0Var;
        }
        if (b41.d(hp0Var, hp0Var2)) {
            hp0 hp0Var3 = hp0.ROOT;
            b41.h(hp0Var3, "ROOT");
            return hp0Var3;
        }
        String b = hp0Var.b();
        b41.h(b, "asString()");
        String substring = b.substring(hp0Var2.b().length() + 1);
        b41.h(substring, "(this as java.lang.String).substring(startIndex)");
        return new hp0(substring);
    }
}
