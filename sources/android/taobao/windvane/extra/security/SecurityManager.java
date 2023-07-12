package android.taobao.windvane.extra.security;

import android.content.ContextWrapper;
import android.taobao.windvane.config.GlobalConfig;
import android.text.TextUtils;
import com.taobao.securityjni.GlobalInit;
import com.taobao.securityjni.SecretUtil;
import com.taobao.securityjni.tools.DataContext;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SecurityManager {
    public static final int TYPE_SIGN_MTOP = 0;
    public static final int TYPE_SIGN_TOP = 1;
    private static SecurityManager mSecurityManager;
    private boolean isInit = false;
    private SecretUtil mSecretUtil;

    private SecurityManager() {
        init(GlobalConfig.context);
    }

    public static synchronized SecurityManager getInstance() {
        SecurityManager securityManager;
        synchronized (SecurityManager.class) {
            if (mSecurityManager == null) {
                mSecurityManager = new SecurityManager();
            }
            securityManager = mSecurityManager;
        }
        return securityManager;
    }

    private String getMTopSign(HashMap<String, String> hashMap, String str) {
        if (!this.isInit || hashMap == null || str == null) {
            return null;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (!TextUtils.isEmpty(hashMap.get("api"))) {
            hashMap2.put("API", hashMap.get("api"));
        }
        if (!TextUtils.isEmpty(hashMap.get("data"))) {
            hashMap2.put("DATA", hashMap.get("data"));
        }
        if (!TextUtils.isEmpty(hashMap.get("ecode"))) {
            hashMap2.put("ECODE", hashMap.get("ecode"));
        }
        if (!TextUtils.isEmpty(hashMap.get("imei"))) {
            hashMap2.put("IMEI", hashMap.get("imei"));
        }
        if (!TextUtils.isEmpty(hashMap.get("imsi"))) {
            hashMap2.put("IMSI", hashMap.get("imsi"));
        }
        if (!TextUtils.isEmpty(hashMap.get("t"))) {
            hashMap2.put("TIME", hashMap.get("t"));
        }
        if (!TextUtils.isEmpty(hashMap.get("v"))) {
            hashMap2.put("V", hashMap.get("v"));
        }
        DataContext dataContext = new DataContext();
        dataContext.extData = str.getBytes();
        return this.mSecretUtil.getSign(hashMap2, dataContext);
    }

    private String getTopSing(TreeMap<String, String> treeMap, String str) {
        if (!this.isInit || treeMap == null || str == null) {
            return null;
        }
        DataContext dataContext = new DataContext();
        dataContext.extData = str.getBytes();
        return this.mSecretUtil.getTopSign(treeMap, dataContext);
    }

    public String getLoginTopToken(String str, String str2, String str3) {
        if (!this.isInit || str3 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        DataContext dataContext = new DataContext();
        dataContext.extData = str3.getBytes();
        return this.mSecretUtil.getLoginTopToken(str, str2, dataContext);
    }

    public String getSecBody(ContextWrapper contextWrapper, String str, String str2) {
        ISecurityBodyComponent securityBodyComp;
        if (this.isInit && str2 != null && !TextUtils.isEmpty(str)) {
            try {
                SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(contextWrapper);
                if (securityGuardManager != null && (securityBodyComp = securityGuardManager.getSecurityBodyComp()) != null && securityBodyComp.initSecurityBody(str2)) {
                    return securityBodyComp.getSecurityBodyData(str, str2);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String getSign(int i, Map<String, String> map, String str) {
        if (this.isInit) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return getTopSing((TreeMap) map, str);
            }
            return getMTopSign((HashMap) map, str);
        }
        return null;
    }

    public void init(ContextWrapper contextWrapper) {
        try {
            GlobalInit.SetGlobalAppKey(GlobalConfig.getInstance().getAppKey());
            this.mSecretUtil = new SecretUtil(contextWrapper);
            GlobalInit.GlobalSecurityInitAsyncSo(contextWrapper);
            this.isInit = true;
        } catch (Throwable unused) {
        }
    }
}
