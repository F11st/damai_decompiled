package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.a.C6197b;
import com.sina.weibo.sdk.a.C6204d;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.C6212c;
import com.sina.weibo.sdk.b.C6214e;
import com.sina.weibo.sdk.net.InterfaceC6219c;
import com.sina.weibo.sdk.web.b.AbstractC6238b;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.web.b.d */
/* loaded from: classes7.dex */
public final class C6241d extends AbstractC6238b {
    public WeiboMultiMessage aE;
    private byte[] aF;
    String aG;
    public String ae;
    public String packageName;
    private String text;

    public C6241d(AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    @Override // com.sina.weibo.sdk.web.b.AbstractC6238b
    protected final void a(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.aE;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.writeToBundle(bundle);
        }
        bundle.putString("token", this.ae);
        bundle.putString("packageName", this.packageName);
    }

    @Override // com.sina.weibo.sdk.web.b.AbstractC6238b
    protected final void b(Bundle bundle) {
        byte[] bArr;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        this.aE = weiboMultiMessage;
        weiboMultiMessage.readFromBundle(bundle);
        this.ae = bundle.getString("token");
        this.packageName = bundle.getString("packageName");
        StringBuilder sb = new StringBuilder();
        TextObject textObject = this.aE.textObject;
        if (textObject != null) {
            sb.append(textObject.text);
        }
        ImageObject imageObject = this.aE.imageObject;
        if (imageObject != null) {
            String str = imageObject.imagePath;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    FileInputStream fileInputStream = null;
                    try {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                fileInputStream2.read(bArr2);
                                this.aF = C6214e.b(bArr2);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileInputStream = fileInputStream2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                bArr = imageObject.imageData;
                                if (bArr != null) {
                                    this.aF = C6214e.b(bArr);
                                }
                                this.text = sb.toString();
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                }
            }
            bArr = imageObject.imageData;
            if (bArr != null && bArr.length > 0) {
                this.aF = C6214e.b(bArr);
            }
        }
        this.text = sb.toString();
    }

    @Override // com.sina.weibo.sdk.web.b.AbstractC6238b
    public final String getUrl() {
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.text);
        buildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.aC.a().getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.ae)) {
            buildUpon.appendQueryParameter(Constants.PARAM_ACCESS_TOKEN, this.ae);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.aG)) {
            buildUpon.appendQueryParameter("picinfo", this.aG);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_".concat(String.valueOf(appKey)));
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.b.AbstractC6238b
    public final boolean t() {
        byte[] bArr = this.aF;
        if (bArr == null || bArr.length <= 0) {
            return super.t();
        }
        return true;
    }

    public C6241d(Context context) {
        this.Z = context;
    }

    @Override // com.sina.weibo.sdk.web.b.AbstractC6238b
    public final void a(final AbstractC6238b.InterfaceC6239a interfaceC6239a) {
        C6197b c6197b;
        C6204d c6204d = new C6204d(this.Z, new String(this.aF), this.aC.a().getAppKey(), this.ae, new InterfaceC6219c<String>() { // from class: com.sina.weibo.sdk.web.b.d.1
            @Override // com.sina.weibo.sdk.net.InterfaceC6219c
            public final /* synthetic */ void a(String str) {
                String str2 = str;
                C6212c.a("WbShareTag", "handle image result :".concat(String.valueOf(str2)));
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.optInt("code");
                        String optString = jSONObject.optString("data");
                        if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                            C6241d.this.aG = optString;
                            AbstractC6238b.InterfaceC6239a interfaceC6239a2 = interfaceC6239a;
                            if (interfaceC6239a2 != null) {
                                interfaceC6239a2.onComplete();
                                return;
                            }
                            return;
                        }
                        AbstractC6238b.InterfaceC6239a interfaceC6239a3 = interfaceC6239a;
                        if (interfaceC6239a3 != null) {
                            interfaceC6239a3.onError("图片内容不合适，禁止上传！");
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        AbstractC6238b.InterfaceC6239a interfaceC6239a4 = interfaceC6239a;
                        if (interfaceC6239a4 != null) {
                            interfaceC6239a4.onError("解析服务端返回的字符串时发生异常！");
                            return;
                        }
                        return;
                    }
                }
                AbstractC6238b.InterfaceC6239a interfaceC6239a5 = interfaceC6239a;
                if (interfaceC6239a5 != null) {
                    interfaceC6239a5.onError("处理图片，服务端返回null!");
                }
            }

            @Override // com.sina.weibo.sdk.net.InterfaceC6219c
            public final void onError(Throwable th) {
                AbstractC6238b.InterfaceC6239a interfaceC6239a2 = interfaceC6239a;
                if (interfaceC6239a2 != null) {
                    interfaceC6239a2.onError(th.getMessage());
                }
            }
        });
        c6197b = C6197b.C6198a.K;
        c6197b.a(c6204d);
    }
}
