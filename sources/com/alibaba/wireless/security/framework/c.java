package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import com.alibaba.wireless.security.framework.utils.FLOG;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c implements ISGPluginInfo {
    private String a;
    private String b;
    private ClassLoader c;
    private AssetManager d;
    private a e;
    private ISecurityGuardPlugin f;
    private ISGPluginManager g;

    public c(String str, ISGPluginManager iSGPluginManager, String str2, ClassLoader classLoader, a aVar, ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.a = str;
        this.g = iSGPluginManager;
        this.b = str2;
        this.c = classLoader;
        this.e = aVar;
        this.f = iSecurityGuardPlugin;
    }

    public String a(String str) {
        a aVar = this.e;
        PackageInfo packageInfo = aVar.c;
        return packageInfo != null ? packageInfo.applicationInfo.metaData.getString(str) : aVar.a(str);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public AssetManager getAssetManager() {
        AssetManager assetManager = this.d;
        if (assetManager != null) {
            return assetManager;
        }
        try {
            AssetManager assetManager2 = (AssetManager) AssetManager.class.newInstance();
            com.alibaba.wireless.security.framework.utils.c.a(assetManager2).a("addAssetPath", this.a);
            this.d = assetManager2;
            return assetManager2;
        } catch (Exception e) {
            FLOG.w("", e);
            return null;
        }
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ClassLoader getClassLoader() {
        return this.c;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public PackageInfo getPackageInfo() {
        return this.e.c;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginName() {
        return this.b;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getPluginPath() {
        return this.a;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISecurityGuardPlugin getSGPluginEntry() {
        return this.f;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public ISGPluginManager getSGPluginManager() {
        return this.g;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginInfo
    public String getVersion() {
        a aVar = this.e;
        PackageInfo packageInfo = aVar.c;
        return packageInfo != null ? packageInfo.versionName : aVar.a("version");
    }
}
