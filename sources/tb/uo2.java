package tb;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class uo2 {
    private static volatile uo2 i;
    private Object a = null;
    private Object b = null;
    private Method c = null;
    private Object d = null;
    private Method e = null;
    private Method f = null;
    private boolean g = false;
    private String h = "";

    private uo2() {
    }

    public static uo2 c() {
        uo2 uo2Var;
        if (i == null) {
            synchronized (uo2.class) {
                if (i == null) {
                    i = new uo2();
                    i.d();
                }
                uo2Var = i;
            }
            return uo2Var;
        }
        return i;
    }

    private synchronized void d() {
        Logger.q();
        IUTRequestAuthentication w = Variables.n().w();
        if (w instanceof UTBaseRequestAuthentication) {
            this.g = false;
        }
        if (w != null) {
            int i2 = SecurityGuardManager.i;
            if (w instanceof UTSecurityThridRequestAuthentication) {
                this.h = ((UTSecurityThridRequestAuthentication) w).getAuthcode();
            }
            this.a = SecurityGuardManager.class.getMethod("getInstance", Context.class).invoke(null, Variables.n().j());
            this.b = SecurityGuardManager.class.getMethod("getStaticDataEncryptComp", new Class[0]).invoke(this.a, new Object[0]);
            this.d = SecurityGuardManager.class.getMethod("getDynamicDataStoreComp", new Class[0]).invoke(this.a, new Object[0]);
            this.c = IStaticDataEncryptComponent.class.getMethod("staticBinarySafeDecryptNoB64", Integer.TYPE, String.class, byte[].class, String.class);
            this.e = IDynamicDataStoreComponent.class.getMethod("putByteArray", String.class, byte[].class);
            this.f = IDynamicDataStoreComponent.class.getMethod("getByteArray", String.class);
            this.g = true;
        }
    }

    public byte[] a(String str) {
        Object obj;
        Method method = this.f;
        if (method != null && (obj = this.d) != null) {
            try {
                Object invoke = method.invoke(obj, str);
                if (invoke == null) {
                    return null;
                }
                return (byte[]) invoke;
            } catch (Throwable th) {
                Logger.h(null, th, new Object[0]);
            }
        }
        return null;
    }

    public boolean b() {
        Logger.r("", "mInitSecurityCheck", Boolean.valueOf(this.g));
        return this.g;
    }

    public int e(String str, byte[] bArr) {
        Object obj;
        Method method = this.e;
        if (method == null || (obj = this.d) == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(obj, str, bArr);
            if (invoke == null) {
                return 0;
            }
            int intValue = ((Integer) invoke).intValue();
            Logger.f("", "ret", Integer.valueOf(intValue));
            return intValue;
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
            return -1;
        }
    }

    public byte[] f(int i2, String str, byte[] bArr) {
        Object obj;
        Method method = this.c;
        if (method != null && (obj = this.b) != null) {
            try {
                Object invoke = method.invoke(obj, Integer.valueOf(i2), str, bArr, this.h);
                Logger.m("", "mStaticDataEncryptCompObj", this.b, "i", Integer.valueOf(i2), "str", str, "bArr", bArr, "authcode", this.h, "obj", invoke);
                if (invoke == null) {
                    return null;
                }
                return (byte[]) invoke;
            } catch (Throwable th) {
                Logger.h(null, th, new Object[0]);
            }
        }
        return null;
    }
}
