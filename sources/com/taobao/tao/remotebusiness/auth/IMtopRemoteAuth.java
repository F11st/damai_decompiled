package com.taobao.tao.remotebusiness.auth;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class IMtopRemoteAuth implements IRemoteAuth {
    public abstract void authorize(AuthParam authParam, AuthListener authListener);

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    @Deprecated
    public void authorize(String str, String str2, String str3, boolean z, AuthListener authListener) {
        AuthParam authParam = new AuthParam(null, str, z);
        authParam.apiInfo = str2;
        authParam.failInfo = str3;
        authorize(authParam, authListener);
    }

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    @Deprecated
    public String getAuthToken() {
        return null;
    }

    public abstract String getAuthToken(AuthParam authParam);

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    @Deprecated
    public boolean isAuthInfoValid() {
        return false;
    }

    public abstract boolean isAuthInfoValid(AuthParam authParam);

    @Override // com.taobao.tao.remotebusiness.auth.IRemoteAuth
    @Deprecated
    public boolean isAuthorizing() {
        return false;
    }

    public abstract boolean isAuthorizing(AuthParam authParam);
}
