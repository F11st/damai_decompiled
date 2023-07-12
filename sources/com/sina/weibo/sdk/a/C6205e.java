package com.sina.weibo.sdk.a;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.C6218b;
import com.sina.weibo.sdk.net.C6221e;
import com.sina.weibo.sdk.net.InterfaceC6219c;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.a.e */
/* loaded from: classes7.dex */
public final class C6205e extends AbstractC6199c<Void, Void, String> {
    private InterfaceC6219c<String> aa;
    private Throwable ab;
    private String ad;
    private Oauth2AccessToken af;

    public C6205e(String str, Oauth2AccessToken oauth2AccessToken, InterfaceC6219c<String> interfaceC6219c) {
        this.ad = str;
        this.af = oauth2AccessToken;
        this.aa = interfaceC6219c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.a.AbstractC6199c
    /* renamed from: n */
    public String l() {
        try {
            C6221e.C6222a c6222a = new C6221e.C6222a();
            c6222a.i = "https://api.weibo.com/oauth2/access_token";
            return new C6218b().a(c6222a.b("client_id", this.ad).b("appKey", this.ad).b("grant_type", "refresh_token").b("refresh_token", this.af.getRefreshToken()).e()).f();
        } catch (Throwable th) {
            th.printStackTrace();
            this.ab = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.a.AbstractC6199c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.ab;
        if (th != null) {
            InterfaceC6219c<String> interfaceC6219c = this.aa;
            if (interfaceC6219c != null) {
                interfaceC6219c.onError(th);
                return;
            }
            return;
        }
        InterfaceC6219c<String> interfaceC6219c2 = this.aa;
        if (interfaceC6219c2 != null) {
            interfaceC6219c2.a(str2);
        }
    }
}
