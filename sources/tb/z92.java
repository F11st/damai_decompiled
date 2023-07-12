package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class z92 implements ISecurity {
    private static String b = "awcn.DefaultSecurityGuard";
    private static boolean c;
    private static Map<String, Integer> d;
    private static Map<String, byte[]> e = new ConcurrentHashMap();
    private static SharedPreferences f;
    private String a;

    static {
        try {
            int i = SecurityGuardManager.i;
            c = true;
            HashMap hashMap = new HashMap();
            d = hashMap;
            hashMap.put(ISecurity.SIGN_ALGORITHM_HMAC_SHA1, 3);
            d.put(ISecurity.CIPHER_ALGORITHM_AES128, 16);
        } catch (Throwable unused) {
            c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z92(String str) {
        this.a = null;
        this.a = str;
        if (hu0.c() != null) {
            f = hu0.c().getSharedPreferences("network_ssl_ticket", 0);
        }
    }

    private byte[] d(Context context, String str) {
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null || (dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp()) == null) {
                return null;
            }
            return dynamicDataStoreComp.getByteArray(str);
        } catch (Throwable th) {
            ALog.d(b, "getBytes", null, th, new Object[0]);
            return null;
        }
    }

    private byte[] e(String str) {
        Context c2 = hu0.c();
        byte[] bArr = e.get(str);
        if (bArr == null && c2 != null) {
            try {
                SharedPreferences sharedPreferences = f;
                if (sharedPreferences != null) {
                    byte[] bArr2 = null;
                    String string = sharedPreferences.getString(str, null);
                    if (string != null && string.length() > 0) {
                        bArr2 = string.getBytes("UTF-8");
                    }
                    bArr = a(c2, bArr2);
                    if (bArr != null && bArr.length > 0) {
                        e.put(str, bArr);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return bArr;
    }

    public byte[] a(Context context, byte[] bArr) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        if (context == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null || (dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp()) == null) {
                return null;
            }
            return dynamicDataEncryptComp.dynamicDecryptByteArray(bArr);
        } catch (Throwable th) {
            ALog.d(b, "dynamicEncryptByteArray", null, th, new Object[0]);
            return null;
        }
    }

    public byte[] b(Context context, byte[] bArr) {
        IDynamicDataEncryptComponent dynamicDataEncryptComp;
        if (context == null || bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null || (dynamicDataEncryptComp = securityGuardManager.getDynamicDataEncryptComp()) == null) {
                return null;
            }
            return dynamicDataEncryptComp.dynamicEncryptByteArray(bArr);
        } catch (Throwable th) {
            ALog.d(b, "dynamicEncryptByteArray", null, th, new Object[0]);
            return null;
        }
    }

    public byte[] c(Context context, String str) {
        byte[] e2 = e(str);
        if ((e2 == null || e2.length == 0) && (e2 = d(context, str)) != null && e2.length > 0) {
            f(context, str, e2);
        }
        return e2;
    }

    @Override // anet.channel.security.ISecurity
    public byte[] decrypt(Context context, String str, String str2, byte[] bArr) {
        Integer num;
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (!c || context == null || bArr == null || TextUtils.isEmpty(str2) || !d.containsKey(str) || (num = d.get(str)) == null) {
            return null;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager != null && (staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp()) != null) {
                return staticDataEncryptComp.staticBinarySafeDecryptNoB64(num.intValue(), str2, bArr, this.a);
            }
        } catch (Throwable th) {
            ALog.d(b, "staticBinarySafeDecryptNoB64", null, th, new Object[0]);
        }
        return null;
    }

    public boolean f(Context context, String str, byte[] bArr) {
        byte[] bArr2;
        if (bArr == null || bArr.length <= 0) {
            bArr2 = null;
        } else {
            e.put(str, bArr);
            bArr2 = b(context, bArr);
        }
        if (bArr2 == null || bArr2.length == 0) {
            return false;
        }
        try {
            SharedPreferences sharedPreferences = f;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(str, new String(bArr2, "UTF-8")).apply();
                return true;
            }
            return true;
        } catch (Exception e2) {
            ALog.d(b, "putSSLMeta error", null, e2, new Object[0]);
            return true;
        }
    }

    @Override // anet.channel.security.ISecurity
    public byte[] getBytes(Context context, String str) {
        if (C9708t9.P()) {
            return c(context, str);
        }
        return d(context, str);
    }

    @Override // anet.channel.security.ISecurity
    public boolean isSecOff() {
        return false;
    }

    @Override // anet.channel.security.ISecurity
    public boolean saveBytes(Context context, String str, byte[] bArr) {
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (C9708t9.P()) {
            return f(context, str, bArr);
        }
        if (context == null || bArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager == null || (dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp()) == null) {
                return false;
            }
            return dynamicDataStoreComp.putByteArray(str, bArr) != 0;
        } catch (Throwable th) {
            ALog.d(b, "saveBytes", null, th, new Object[0]);
            return false;
        }
    }

    @Override // anet.channel.security.ISecurity
    public String sign(Context context, String str, String str2, String str3) {
        if (c && context != null && !TextUtils.isEmpty(str2) && d.containsKey(str)) {
            try {
                ISecureSignatureComponent secureSignatureComp = SecurityGuardManager.getInstance(context).getSecureSignatureComp();
                if (secureSignatureComp != null) {
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = str2;
                    securityGuardParamContext.paramMap.put("INPUT", str3);
                    securityGuardParamContext.requestType = d.get(str).intValue();
                    return secureSignatureComp.signRequest(securityGuardParamContext, this.a);
                }
            } catch (Throwable th) {
                ALog.d(b, "Securityguard sign request failed.", null, th, new Object[0]);
            }
        }
        return null;
    }
}
