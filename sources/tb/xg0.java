package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class xg0 {
    public final String a;
    public final String b;
    public final JSONObject c;

    public xg0(String str, String str2, JSONObject jSONObject) {
        this.a = str;
        this.b = str2;
        this.c = jSONObject;
    }

    public static xg0 a(@Nullable String str, @Nullable String str2) {
        return new xg0(str, str2, null);
    }

    public static xg0 b(@Nullable String str, @Nullable JSONObject jSONObject) {
        return new xg0(str, null, jSONObject);
    }

    public static boolean c(@Nullable xg0 xg0Var) {
        return (xg0Var == null || ((TextUtils.isEmpty(xg0Var.b) || "{}".equals(xg0Var.b)) && xg0Var.c == null)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xg0.class != obj.getClass()) {
            return false;
        }
        xg0 xg0Var = (xg0) obj;
        String str = this.a;
        if (str == null ? xg0Var.a == null : str.equals(xg0Var.a)) {
            String str2 = this.b;
            String str3 = xg0Var.b;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
