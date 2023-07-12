package com.taobao.securityjni;

import android.content.ContextWrapper;
import com.taobao.securityjni.tools.DataContext;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.staticdatastore.IStaticDataStoreComponent;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class StaticDataStore {
    public static final int APP_KEY_TYPE = 1;
    public static final int EXTRA_KEY_TYPE = 3;
    public static final int INVALID_KEY_TYPE = 4;
    public static final int SECURITY_KEY_TYPE = 2;
    private IStaticDataStoreComponent proxy;

    public StaticDataStore(ContextWrapper contextWrapper) {
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(contextWrapper);
        if (securityGuardManager != null) {
            this.proxy = securityGuardManager.getStaticDataStoreComp();
        }
    }

    @Deprecated
    public String getAppKey() {
        return getAppKey(new DataContext(0, null));
    }

    public String getAppKeyByIndex(int i) {
        IStaticDataStoreComponent iStaticDataStoreComponent = this.proxy;
        if (iStaticDataStoreComponent == null || i < 0 || i > 8) {
            return null;
        }
        return iStaticDataStoreComponent.getAppKeyByIndex(i);
    }

    public String getExtraData(String str) {
        IStaticDataStoreComponent iStaticDataStoreComponent = this.proxy;
        if (iStaticDataStoreComponent == null || str == null) {
            return null;
        }
        return iStaticDataStoreComponent.getExtraData(str);
    }

    public int getKeyType(String str) {
        IStaticDataStoreComponent iStaticDataStoreComponent = this.proxy;
        if (iStaticDataStoreComponent == null || str == null) {
            return 4;
        }
        return iStaticDataStoreComponent.getKeyType(str);
    }

    @Deprecated
    public String getMMPid() {
        return null;
    }

    @Deprecated
    public String getTtid() {
        return null;
    }

    public String getAppKey(DataContext dataContext) {
        if (dataContext == null) {
            return null;
        }
        int i = dataContext.index;
        if (i < 0) {
            i = 0;
        }
        return getAppKeyByIndex(i);
    }
}
