package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Objects;
import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class xk1 extends ka1 implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    @NotNull
    public xk1 getList() {
        return this;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @NotNull
    public final String t(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object j = j();
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        boolean z = true;
        for (ma1 ma1Var = (ma1) j; !b41.d(ma1Var, this); ma1Var = ma1Var.k()) {
            if (ma1Var instanceof f61) {
                f61 f61Var = (f61) ma1Var;
                if (z) {
                    z = false;
                } else {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
                sb.append(f61Var);
            }
        }
        sb.append(jn1.ARRAY_END_STR);
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return k40.c() ? t("Active") : super.toString();
    }
}
