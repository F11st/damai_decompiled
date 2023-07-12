package com.sina.weibo.sdk.a;

import android.content.Context;
import com.sina.weibo.sdk.net.C6218b;
import com.sina.weibo.sdk.net.C6221e;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.InterfaceC6219c;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.a.d */
/* loaded from: classes7.dex */
public final class C6204d extends AbstractC6199c<Void, Void, String> {
    private Context Z;
    private InterfaceC6219c<String> aa;
    private Throwable ab;
    private String ac;
    private String ad;
    private String ae;

    public C6204d(Context context, String str, String str2, String str3, InterfaceC6219c<String> interfaceC6219c) {
        this.Z = context;
        this.ac = str;
        this.ad = str2;
        this.ae = str3;
        this.aa = interfaceC6219c;
    }

    private String d(String str) {
        return HttpManager.a(this.Z, "", this.ae, this.ad, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.a.AbstractC6199c
    /* renamed from: n */
    public String l() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            C6221e.C6222a c6222a = new C6221e.C6222a();
            c6222a.i = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new C6218b().a(c6222a.a("oauth_timestamp", valueOf).a("oauth_sign", d(valueOf)).b("appKey", this.ad).b("oauth_timestamp", valueOf).b("oauth_sign", d(valueOf)).b("img", this.ac).e()).f();
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
