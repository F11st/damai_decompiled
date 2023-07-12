package com.alibaba.aliweex.bundle;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.aliweex.bundle.WeexPageContract;
import com.alibaba.dynamic.DynamicSdk;
import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.bundle.c */
/* loaded from: classes5.dex */
public class C3080c implements WeexPageContract.IDynamicUrlPresenter {
    private final C3082b a = new C3082b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.bundle.c$b */
    /* loaded from: classes15.dex */
    public class C3082b {
        String a;
        String b;
        String c;
        String d;
        String e;

        private C3082b(C3080c c3080c) {
        }

        public void a() {
            this.c = null;
            this.c = null;
            this.b = null;
            this.d = null;
            this.e = null;
        }

        String b() {
            return TextUtils.isEmpty(this.b) ? this.a : this.b;
        }

        String c() {
            return TextUtils.isEmpty(this.d) ? this.c : this.d;
        }
    }

    private void a(String str, String str2) {
        this.a.a();
        C3082b c3082b = this.a;
        c3082b.a = str;
        c3082b.c = str2;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                if (DynamicSdk.getInstance().isSdkWork()) {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("_wx_tpl");
                    String queryParameter2 = parse.getQueryParameter("wh_weex");
                    if (!TextUtils.isEmpty(queryParameter) && "true".equals(queryParameter2)) {
                        String uri = Uri.parse(str2).buildUpon().clearQuery().build().toString();
                        if (!queryParameter.contains(uri)) {
                            return;
                        }
                        C3082b c3082b2 = this.a;
                        c3082b2.e = null;
                        c3082b2.e = uri;
                        CharSequence redirectUrl = DynamicSdk.getInstance().redirectUrl(uri);
                        if (uri.equals(redirectUrl)) {
                            return;
                        }
                        this.a.b = str.replace(uri, redirectUrl);
                        this.a.d = str2.replace(uri, redirectUrl);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getOriginalRenderUrl() {
        return this.a.c;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getOriginalUrl() {
        return this.a.a;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getRenderUrl() {
        return this.a.c();
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public String getUrl() {
        return this.a.b();
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public void onWXException(WXSDKInstance wXSDKInstance, String str, String str2) {
        if (this.a.d == null || wXSDKInstance == null || !str2.contains("404")) {
            return;
        }
        try {
            DynamicSdk.getInstance().redirectUrlFailed(this.a.e);
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IDynamicUrlPresenter
    public void transformUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, str2);
    }
}
