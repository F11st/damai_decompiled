package tb;

import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class uq0 {
    @NotNull
    private final os0 a;
    @NotNull
    private final qr0 b;
    @NotNull
    private final JSONObject c;

    public uq0(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONObject, "templateData");
        this.a = os0Var;
        this.b = qr0Var;
        this.c = jSONObject;
    }

    @NotNull
    public final qr0 a() {
        return this.b;
    }

    @NotNull
    public final os0 b() {
        return this.a;
    }

    @NotNull
    public final JSONObject c() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof uq0) {
            uq0 uq0Var = (uq0) obj;
            return b41.d(this.a, uq0Var.a) && b41.d(this.b, uq0Var.b) && b41.d(this.c, uq0Var.c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXDirtyText(gxTemplateContext=" + this.a + ", gxNode=" + this.b + ", templateData=" + this.c + ')';
    }
}
