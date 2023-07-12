package com.ali.user.mobile.service.impl;

import android.content.Context;
import android.content.ContextWrapper;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.service.StorageService;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SecurityGuardWrapper implements StorageService {
    public static final String TAG = "SecurityGuardWrapper";
    private static SecurityGuardManager mSecurityGuardManager;

    private SecurityGuardManager getSecurityGuardManager() {
        if (mSecurityGuardManager == null) {
            init(DataProviderFactory.getApplicationContext());
        }
        return mSecurityGuardManager;
    }

    @Override // com.ali.user.mobile.service.StorageService
    public String get(String str) {
        try {
            IDynamicDataStoreComponent dynamicDataStoreComp = getSecurityGuardManager().getDynamicDataStoreComp();
            return dynamicDataStoreComp != null ? dynamicDataStoreComp.getStringDDpEx(str, 0) : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // com.ali.user.mobile.service.StorageService
    public String getAppKey(int i) {
        try {
            return getSecurityGuardManager().getStaticDataStoreComp().getAppKeyByIndex(i, "");
        } catch (Throwable th) {
            TLogAdapter.d("SecurityGuardWrapper", "can't get appkey from blackbox." + th.getMessage());
            return "";
        }
    }

    @Override // com.ali.user.mobile.service.StorageService
    public void init(Context context) {
        if (mSecurityGuardManager == null) {
            try {
                mSecurityGuardManager = SecurityGuardManager.getInstance(new ContextWrapper(context));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ali.user.mobile.service.StorageService
    public void put(String str, String str2) {
        try {
            IDynamicDataStoreComponent dynamicDataStoreComp = getSecurityGuardManager().getDynamicDataStoreComp();
            if (dynamicDataStoreComp != null) {
                dynamicDataStoreComp.putStringDDpEx(str, str2, 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.service.StorageService
    public void remove(String str) {
        try {
            getSecurityGuardManager().getDynamicDataStoreComp().removeStringDDpEx(str, 0);
        } catch (Throwable unused) {
        }
    }
}
