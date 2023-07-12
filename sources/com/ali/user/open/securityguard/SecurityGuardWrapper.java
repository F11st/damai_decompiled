package com.ali.user.open.securityguard;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.Environment;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.RichWUA;
import com.ali.user.open.core.model.WUAData;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.trace.SDKLogger;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SecurityGuardWrapper implements StorageService {
    private static final String SEED_KEY = "seed_key";
    public static final String TAG = "SecurityGuardWrapper";

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    class WUATask extends AsyncTask<Object, Void, RichWUA> {
        private MemberCallback<RichWUA> dataCallback;

        public WUATask(MemberCallback<RichWUA> memberCallback) {
            this.dataCallback = memberCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public RichWUA doInBackground(Object... objArr) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String valueOf = String.valueOf(currentTimeMillis);
                String appKey = SecurityGuardWrapper.this.getAppKey();
                return new RichWUA(appKey, valueOf, ((ISecurityBodyComponent) SecurityGuardWrapper.this.getSecurityGuardManager().getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(String.valueOf(currentTimeMillis), appKey, "", null, 4, SecurityGuardWrapper.this.convertEnvToMtop()), SecurityGuardWrapper.this.getUmid());
            } catch (Throwable th) {
                SDKLogger.e("SecurityGuardWrapper", th.getMessage());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(RichWUA richWUA) {
            MemberCallback<RichWUA> memberCallback = this.dataCallback;
            if (memberCallback != null) {
                memberCallback.onSuccess(richWUA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int convertEnvToMtop() {
        if (ConfigManager.getInstance().getEnvironment() == Environment.TEST) {
            return 2;
        }
        return ConfigManager.getInstance().getEnvironment() == Environment.PRE ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecurityGuardManager getSecurityGuardManager() {
        try {
            return SecurityGuardManager.getInstance(KernelContext.applicationContext);
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String signForLogin(String str, String str2) {
        try {
            return getSecurityGuardManager().getSafeTokenComp().signWithToken(str, str2.getBytes("UTF-8"), 0);
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public String decrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = getSecurityGuardManager().getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp != null) {
                String dynamicDecryptDDp = dynamicDataEncryptComp.dynamicDecryptDDp(str);
                return TextUtils.isEmpty(dynamicDecryptDDp) ? str : dynamicDecryptDDp;
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public String encode(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                IDynamicDataEncryptComponent dynamicDataEncryptComp = getSecurityGuardManager().getDynamicDataEncryptComp();
                if (dynamicDataEncryptComp != null) {
                    String dynamicEncryptDDp = dynamicDataEncryptComp.dynamicEncryptDDp(str);
                    return TextUtils.isEmpty(dynamicEncryptDDp) ? str : dynamicEncryptDDp;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    @Override // com.ali.user.open.core.service.StorageService
    public String getAppKey() {
        try {
            return getSecurityGuardManager().getStaticDataStoreComp().getAppKeyByIndex(ConfigManager.getAppKeyIndex(), ConfigManager.POSTFIX_OF_SECURITY_JPG);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public String getDDpExValue(String str) {
        try {
            return getSecurityGuardManager().getDynamicDataStoreComp().getStringDDpEx(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public String getUmid() {
        try {
            return getSecurityGuardManager().getUMIDComp().getSecurityToken();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public String getValue(String str, boolean z) {
        try {
            if (z) {
                return getSecurityGuardManager().getDynamicDataStoreComp().getString(str);
            }
            return getSecurityGuardManager().getStaticDataStoreComp().getExtraData(str, ConfigManager.POSTFIX_OF_SECURITY_JPG);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public WUAData getWUA() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String valueOf = String.valueOf(currentTimeMillis);
            String appKey = getAppKey();
            return new WUAData(appKey, valueOf, ((ISecurityBodyComponent) getSecurityGuardManager().getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(String.valueOf(currentTimeMillis), appKey, "", null, 4, convertEnvToMtop()));
        } catch (Throwable th) {
            SDKLogger.e("SecurityGuardWrapper", th.getMessage());
            return null;
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void getWUAData(MemberCallback<RichWUA> memberCallback) {
        if (memberCallback == null) {
            return;
        }
        new WUATask(memberCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void putDDpExValue(String str, String str2) {
        try {
            getSecurityGuardManager().getDynamicDataStoreComp().putStringDDpEx(str, str2, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void putValue(String str, String str2, boolean z) {
        try {
            getSecurityGuardManager().getDynamicDataStoreComp().putString(str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void removeDDpExValue(String str) {
        try {
            getSecurityGuardManager().getDynamicDataStoreComp().removeStringDDpEx(str, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void removeSafeToken(String str) {
        try {
            getSecurityGuardManager().getSafeTokenComp().removeToken(str);
        } catch (SecException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void removeValue(String str, boolean z) {
        if (z) {
            try {
                getSecurityGuardManager().getDynamicDataStoreComp().removeString(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public synchronized boolean saveSafeToken(String str, String str2) {
        if (TextUtils.isEmpty(str) || getSecurityGuardManager() == null) {
            return false;
        }
        try {
            ISafeTokenComponent safeTokenComp = getSecurityGuardManager().getSafeTokenComp();
            if (safeTokenComp != null) {
                return safeTokenComp.saveToken(str, str2, new String[]{"", "", "", ""}[0], 0);
            }
            return false;
        } catch (SecException e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void setUmid(String str) {
    }

    @Override // com.ali.user.open.core.service.StorageService
    public String signMap(String str, TreeMap<String, String> treeMap) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        return signForLogin(str, sb.substring(0, sb.length() - 1));
    }

    @Override // com.ali.user.open.core.service.StorageService
    public void getUmid(final MemberCallback<String> memberCallback) {
        int i = 0;
        try {
            if (ConfigManager.getInstance().getEnvironment() == Environment.TEST) {
                i = 2;
            } else if (ConfigManager.getInstance().getEnvironment() == Environment.PRE) {
                i = 1;
            }
            IUMIDComponent uMIDComp = getSecurityGuardManager().getUMIDComp();
            String securityToken = uMIDComp.getSecurityToken(i);
            if (!TextUtils.isEmpty(securityToken) && securityToken.length() != 24) {
                if (memberCallback != null) {
                    memberCallback.onSuccess(securityToken);
                    return;
                }
                return;
            }
            uMIDComp.initUMID(i, new IUMIDInitListenerEx() { // from class: com.ali.user.open.securityguard.SecurityGuardWrapper.1
                @Override // com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx
                public void onUMIDInitFinishedEx(String str, int i2) {
                    MemberCallback memberCallback2 = memberCallback;
                    if (memberCallback2 != null) {
                        memberCallback2.onSuccess(str);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            if (memberCallback != null) {
                memberCallback.onSuccess("");
            }
        }
    }
}
