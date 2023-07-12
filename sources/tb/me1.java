package tb;

import java.util.HashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class me1 {
    @Nullable
    public static final Set<ni1> a(@NotNull Iterable<? extends MemberScope> iterable) {
        b41.i(iterable, "<this>");
        HashSet hashSet = new HashSet();
        for (MemberScope memberScope : iterable) {
            Set<ni1> classifierNames = memberScope.getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            kotlin.collections.r.v(hashSet, classifierNames);
        }
        return hashSet;
    }
}
