package tb;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.h.b.C4802b;
import com.youku.usercenter.passport.RefreshTask;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class u23 {
    private static volatile long b = -1;
    public boolean a;

    /* compiled from: Taobao */
    /* renamed from: tb.u23$a */
    /* loaded from: classes10.dex */
    static class C9763a {
        private static final u23 a = new u23((byte) 0);
    }

    private u23() {
        this.a = true;
    }

    /* synthetic */ u23(byte b2) {
        this();
    }

    public static String a(@NonNull String str, @NonNull e53 e53Var) {
        byte b2 = e53Var.g;
        String str2 = "/api/v1/raw/upload";
        if (b2 != 1) {
            if (b2 == 2) {
                str2 = "/api/v1/file/upload";
            } else if (b2 == 3) {
                str2 = "/api/v1/mix/upload";
            }
        }
        return str + str2;
    }

    public static u23 c() {
        return C9763a.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(@Nullable l01 l01Var) {
        if (l01Var == null || !l01Var.a || TextUtils.isEmpty(l01Var.c)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(l01Var.c);
            String optString = jSONObject.optString("code", "-1");
            l01Var.d(optString);
            if (!"0".equals(optString)) {
                l01Var.a = false;
            }
            if (jSONObject.has("cver")) {
                ((Map) l01Var.d).put("cver", jSONObject.getString("cver"));
            }
            long j = jSONObject.getLong(WPKFactory.CONF_SERVER_TIME) * 1000;
            if (Math.abs(j - e()) > RefreshTask.STOKEN_CHECK_INTERVAL) {
                b = j - SystemClock.elapsedRealtime();
            }
        } catch (Throwable th) {
            w63.c("efs.px.api", "checkPxReturn error", th);
        }
    }

    public static long e() {
        return b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + b;
    }

    @NonNull
    public final l01 b(String str, e53 e53Var, File file, boolean z) {
        String b2 = e53Var.b();
        String a = a(str, e53Var);
        if (this.a) {
            w63.a("efs.px.api", "Upload file, url is ".concat(String.valueOf(a)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", b2);
        C4802b c = new C4802b(a).c(hashMap);
        c.a.d = file;
        C4802b b3 = c.b("type", e53Var.h);
        StringBuilder sb = new StringBuilder();
        sb.append(e53Var.k);
        return b3.b("size", sb.toString()).b("flow_limit", Boolean.toString(z)).d(s53.d()).a().b();
    }
}
