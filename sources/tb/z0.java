package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class z0 implements com.efs.sdk.base.a.h.a.b<l01> {
    public abstract void a(@Nullable l01 l01Var);

    public abstract void b(@NonNull l01 l01Var);

    @Override // com.efs.sdk.base.a.h.a.b
    /* renamed from: c */
    public void result(@Nullable l01 l01Var) {
        if (l01Var == null || !l01Var.a) {
            a(l01Var);
        } else {
            b(l01Var);
        }
    }
}
