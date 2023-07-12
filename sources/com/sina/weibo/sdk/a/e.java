package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.e;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class e extends c<Void, Void, String> {
    private com.sina.weibo.sdk.net.c<String> aa;
    private Throwable ab;
    private String ad;
    private Oauth2AccessToken af;

    public e(String str, Oauth2AccessToken oauth2AccessToken, com.sina.weibo.sdk.net.c<String> cVar) {
        this.ad = str;
        this.af = oauth2AccessToken;
        this.aa = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.a.c
    /* renamed from: n */
    public String l() {
        try {
            e.a aVar = new e.a();
            aVar.i = "https://api.weibo.com/oauth2/access_token";
            return new com.sina.weibo.sdk.net.b().a(aVar.b("client_id", this.ad).b("appKey", this.ad).b("grant_type", "refresh_token").b("refresh_token", this.af.getRefreshToken()).e()).f();
        } catch (Throwable th) {
            th.printStackTrace();
            this.ab = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.a.c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.ab;
        if (th != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.aa;
            if (cVar != null) {
                cVar.onError(th);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.aa;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
