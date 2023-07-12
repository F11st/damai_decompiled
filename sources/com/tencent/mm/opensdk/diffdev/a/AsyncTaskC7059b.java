package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.tencent.mm.opensdk.channel.a.C7054a;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.tencent.mm.opensdk.diffdev.a.b */
/* loaded from: classes11.dex */
public class AsyncTaskC7059b extends AsyncTask<Void, Void, C7060a> {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private OAuthListener f;
    private AsyncTaskC7061c g;

    /* compiled from: Taobao */
    /* renamed from: com.tencent.mm.opensdk.diffdev.a.b$a */
    /* loaded from: classes11.dex */
    static class C7060a {
        public OAuthErrCode a;
        public String b;
        public String c;
        public String d;
        public byte[] e;

        private C7060a() {
        }

        public static C7060a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            C7060a c7060a = new C7060a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i)));
                            c7060a.a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString("errmsg");
                            return c7060a;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode != null && decode.length != 0) {
                                c7060a.a = OAuthErrCode.WechatAuth_Err_OK;
                                c7060a.e = decode;
                                c7060a.b = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("appname");
                                c7060a.c = string2;
                                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", c7060a.b, string2, Integer.valueOf(c7060a.e.length)));
                                return c7060a;
                            }
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            c7060a.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return c7060a;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        c7060a.a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return c7060a;
                    } catch (Exception e) {
                        format = String.format("parse json fail, ex = %s", e.getMessage());
                        Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        c7060a.a = oAuthErrCode;
                        return c7060a;
                    }
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                }
            }
            c7060a.a = oAuthErrCode;
            return c7060a;
        }
    }

    public AsyncTaskC7059b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = oAuthListener;
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        AsyncTaskC7061c asyncTaskC7061c = this.g;
        return asyncTaskC7061c == null ? cancel(true) : asyncTaskC7061c.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected C7060a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.a, this.c, this.d, this.b, this.e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a = C7054a.a(format, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return C7060a.a(a);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(C7060a c7060a) {
        C7060a c7060a2 = c7060a;
        OAuthErrCode oAuthErrCode = c7060a2.a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + c7060a2.e.length);
            this.f.onAuthGotQrcode(c7060a2.d, c7060a2.e);
            AsyncTaskC7061c asyncTaskC7061c = new AsyncTaskC7061c(c7060a2.b, this.f);
            this.g = asyncTaskC7061c;
            if (Build.VERSION.SDK_INT >= 11) {
                asyncTaskC7061c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else {
                asyncTaskC7061c.execute(new Void[0]);
                return;
            }
        }
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
        this.f.onAuthFinish(c7060a2.a, null);
    }
}
