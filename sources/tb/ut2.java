package tb;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack.UserTrackUFWrapper;
import com.ut.device.UTDevice;
import com.ut.mini.extend.UTExtendSwitch;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ut2 {
    private static volatile ut2 c;
    private boolean a = false;
    private boolean b = false;

    private ut2() {
    }

    private void a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            hashMap = new HashMap<>();
        }
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key == null || key.isEmpty() || !key.startsWith("x-")) {
                it.remove();
            }
        }
    }

    public static ut2 b() {
        ut2 ut2Var;
        if (c == null) {
            synchronized (ut2.class) {
                if (c == null) {
                    c = new ut2();
                }
                ut2Var = c;
            }
            return ut2Var;
        }
        return c;
    }

    private HashMap<String, String> e() {
        z70 c2;
        HashMap<String, String> hashMap = new HashMap<>();
        String g = Variables.n().g();
        if (g == null || g.isEmpty()) {
            g = sj.c().a();
        }
        hashMap.put(HttpHeaderConstant.X_APPKEY, g);
        String f = Variables.n().f();
        if ((f == null || f.isEmpty()) && (c2 = x70.c(Variables.n().j())) != null) {
            f = c2.a();
        }
        hashMap.put(HttpHeaderConstant.X_APP_VER, f);
        hashMap.put(HttpHeaderConstant.X_UTDID, UTDevice.getUtdid(Variables.n().j()));
        hashMap.put(HttpHeaderConstant.X_UID, Variables.n().B());
        hashMap.put(HttpHeaderConstant.X_PV, "1");
        hashMap.put(HttpHeaderConstant.X_TTID, Variables.n().h());
        return hashMap;
    }

    public synchronized HashMap<String, String> c() {
        HashMap<String, String> hashMap;
        if (this.b) {
            HashMap<String, String> e = e();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                hashMap = UserTrackUFWrapper.getUFWrapper();
            } catch (Throwable th) {
                Logger.h("UnifiedSecuritySDK2", th, "getSecurityFactorsImpl");
                hashMap = null;
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                a(hashMap);
                hashMap.putAll(e);
                Logger.f("UnifiedSecuritySDK2", "getSecurityFactorsImpl cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                Logger.e("UnifiedSecuritySDK2", hashMap);
                return hashMap;
            }
            return null;
        }
        return null;
    }

    public synchronized void d(Context context) {
        if (UTExtendSwitch.bXmodule) {
            if (this.a) {
                return;
            }
            Logger.f("UnifiedSecuritySDK2", "initSecurity begin");
            String g = Variables.n().g();
            if (g == null || g.isEmpty()) {
                g = sj.c().a();
            }
            long currentTimeMillis = System.currentTimeMillis();
            UserTrackUFWrapper.init(context, g);
            Logger.f("UnifiedSecuritySDK2", "init cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.b = true;
            Logger.f("UnifiedSecuritySDK2", "initSecurity End");
            this.a = true;
        }
    }
}
