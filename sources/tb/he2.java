package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class he2 {
    @Nullable
    public static ee2 a(me2 me2Var) {
        File b = oi0.b(me2Var);
        if (b == null) {
            return null;
        }
        return new ee2(me2Var.b(), b.getAbsolutePath(), me2Var.a(), me2Var.c());
    }

    @NonNull
    public static ie2 b(pe2 pe2Var, String str) {
        List<me2> b = pe2Var.b();
        ie2 ie2Var = new ie2(pe2Var.d(), str);
        if (b != null) {
            for (me2 me2Var : b) {
                ie2Var.a(a(me2Var));
            }
        }
        return ie2Var;
    }

    @NonNull
    public static me2 c(String str, String str2, long j, int i) {
        return new me2(str, i, str2, j);
    }
}
