package tb;

import android.taobao.windvane.config.WVAppParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class zk2 extends WVAppParams {
    private boolean a;
    @NotNull
    private final String b;
    private final boolean c;

    public zk2(@NotNull String str, boolean z) {
        b41.i(str, "uaExtra");
        this.b = str;
        this.c = z;
    }

    public final boolean a() {
        return this.c;
    }

    @NotNull
    public final String b() {
        return this.b;
    }

    public final boolean c() {
        return this.a;
    }

    public final void d(boolean z) {
        this.a = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof zk2) {
                zk2 zk2Var = (zk2) obj;
                return b41.d(this.b, zk2Var.b) && this.c == zk2Var.c;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "TaoMaiH5Config(uaExtra=" + this.b + ", online=" + this.c + jn1.BRACKET_END_STR;
    }
}
