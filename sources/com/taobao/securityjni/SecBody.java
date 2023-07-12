package com.taobao.securityjni;

import android.content.ContextWrapper;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class SecBody {
    private ISecurityBodyComponent proxy;
    private IStaticDataStoreComponent staticDataStoreComp;

    public SecBody(ContextWrapper contextWrapper) {
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(contextWrapper);
        if (securityGuardManager != null) {
            this.proxy = securityGuardManager.getSecurityBodyComp();
            this.staticDataStoreComp = securityGuardManager.getStaticDataStoreComp();
        }
    }

    public String getSecBodyData(String str) {
        if (this.proxy == null || str == null || str.length() <= 0) {
            return null;
        }
        String GetGlobalAppKey = GlobalInit.GetGlobalAppKey();
        if (GetGlobalAppKey == null) {
            GetGlobalAppKey = this.staticDataStoreComp.getAppKeyByIndex(0);
        }
        return this.proxy.getSecurityBodyData(str, GetGlobalAppKey);
    }
}
