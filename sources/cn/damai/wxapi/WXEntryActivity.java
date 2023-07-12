package cn.damai.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import cn.damai.common.AppConfig;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.util.Utils;
import cn.damai.wxapi.WXEntryActivity;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.open.oauth.wechat.WechatAuthRespHandler;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.TokenModel;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import tb.cb1;
import tb.cm2;
import tb.mm2;
import tb.v20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String APP_ID_CRYPT = "qu1pe0lqy2H+MnEtd89\\/rch4lvA7kPSd";
    public static final String APP_SECRET = "d8c945e2efaee7a7bb4ca5eb1c913eaa";
    public static final String MINI_ID = "gh_8f607e128043";
    private static final int THUMB_SIZE = 150;
    public static final int TIMELINE_SUPPORTED_VERSION = 553779201;
    public static final String WX_GET_TOKEN_URL = "￼https://api.weixin.qq.com/sns/oauth2/access_token";
    public static int mWXfrom;
    public IWXAPI api;
    byte[] arraybyte;
    Bitmap bitmap;
    Bundle bundle;
    private String fromWhere;
    private Bitmap imageBitmap;
    private String imageModeUrl;
    String message;
    private boolean miniprogram;
    String producturl;
    private long projectId;
    String title;
    String imageurl = null;
    int way = 0;
    String sinaSharePath = null;
    Handler handler = new Handler() { // from class: cn.damai.wxapi.WXEntryActivity.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-980091731")) {
                ipChange.ipc$dispatch("-980091731", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            WXEntryActivity.this.shareMessage();
        }
    };
    private String snsType = "weixin";

    private byte[] Bitmap2Bytes(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077672811")) {
            return (byte[]) ipChange.ipc$dispatch("1077672811", new Object[]{this, bitmap});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String buildTransaction(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898597954")) {
            return (String) ipChange.ipc$dispatch("898597954", new Object[]{this, str});
        }
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixImgSize(int i, int i2) {
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001374635")) {
            ipChange.ipc$dispatch("-1001374635", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        double d = i;
        double width = this.bitmap.getWidth();
        double d2 = (d * 1.0d) / width;
        double d3 = i2;
        double height = this.bitmap.getHeight();
        double max = Math.max(d2, (1.0d * d3) / height);
        if (max == d2) {
            i3 = 0;
            this.bitmap = Bitmap.createScaledBitmap(this.bitmap, i, (int) (height * max), false);
        } else {
            i3 = 0;
            this.bitmap = Bitmap.createScaledBitmap(this.bitmap, (int) (width * max), i2, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.bitmap, i3, i3, i, i2);
        this.bitmap = createBitmap;
        if (Bitmap2Bytes(createBitmap).length > 130000) {
            fixImgSize((int) (d * 0.9d), (int) (d3 * 0.9d));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initExtras(android.content.Intent r5) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.wxapi.WXEntryActivity.$ipChange
            java.lang.String r1 = "1503192174"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            android.os.Bundle r5 = r5.getExtras()
            r4.bundle = r5
            if (r5 != 0) goto L20
            return
        L20:
            java.lang.String r0 = "title"
            java.lang.String r5 = r5.getString(r0)
            r4.title = r5
            android.os.Bundle r5 = r4.bundle
            java.lang.String r0 = "message"
            java.lang.String r5 = r5.getString(r0)
            r4.message = r5
            android.os.Bundle r5 = r4.bundle
            java.lang.String r0 = "imageurl"
            java.lang.String r5 = r5.getString(r0)
            r4.imageurl = r5
            android.os.Bundle r5 = r4.bundle
            java.lang.String r0 = "producturl"
            java.lang.String r5 = r5.getString(r0)
            r4.producturl = r5
            android.os.Bundle r5 = r4.bundle
            java.lang.String r0 = "fromWhere"
            java.lang.String r5 = r5.getString(r0)
            r4.fromWhere = r5
            android.os.Bundle r5 = r4.bundle
            java.lang.String r0 = "projectId"
            long r0 = r5.getLong(r0)
            r4.projectId = r0
            android.os.Bundle r5 = r4.bundle
            java.lang.String r0 = "way"
            int r5 = r5.getInt(r0)
            r4.way = r5
            android.os.Bundle r5 = r4.bundle
            java.lang.String r0 = "miniprogram"
            boolean r5 = r5.getBoolean(r0, r3)
            r4.miniprogram = r5
            android.content.Intent r5 = r4.getIntent()
            android.os.Bundle r5 = r5.getExtras()
            java.lang.String r0 = "imageModeUrl"
            java.lang.String r5 = r5.getString(r0)
            r4.imageModeUrl = r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto Lb9
            r5 = 0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            java.lang.String r1 = r4.imageModeUrl     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9f
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> Lad
            r4.imageBitmap = r0     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> Lad
            r1.close()     // Catch: java.io.IOException -> La8
            goto Lb9
        L9b:
            r0 = move-exception
            r1 = r5
            r5 = r0
            goto Lae
        L9f:
            r1 = r5
        La0:
            r4.imageBitmap = r5     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto Lb9
            r1.close()     // Catch: java.io.IOException -> La8
            goto Lb9
        La8:
            r5 = move-exception
            r5.printStackTrace()
            goto Lb9
        Lad:
            r5 = move-exception
        Lae:
            if (r1 == 0) goto Lb8
            r1.close()     // Catch: java.io.IOException -> Lb4
            goto Lb8
        Lb4:
            r0 = move-exception
            r0.printStackTrace()
        Lb8:
            throw r5
        Lb9:
            android.content.Intent r5 = r4.getIntent()
            android.os.Bundle r5 = r5.getExtras()
            java.lang.String r0 = "sinaSharePath"
            boolean r5 = r5.containsKey(r0)
            if (r5 == 0) goto Ld7
            android.content.Intent r5 = r4.getIntent()
            android.os.Bundle r5 = r5.getExtras()
            java.lang.String r5 = r5.getString(r0)
            r4.sinaSharePath = r5
        Ld7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.wxapi.WXEntryActivity.initExtras(android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadImgFromUrl$0(DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514865419")) {
            ipChange.ipc$dispatch("-1514865419", new Object[]{this, dVar});
            return;
        }
        share(this.way);
        finish();
    }

    private void onRespLogin(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1442758423")) {
            ipChange.ipc$dispatch("-1442758423", new Object[]{this, baseResp});
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            Log.i("WXTest", "onResp ERR_AUTH_DENIED");
            SNSAuth.invokeError(this.snsType, -1, getResources().getString(R$string.aliuser_SNS_platform_auth_fail));
        } else if (i == -2) {
            Log.i("WXTest", "onResp ERR_USER_CANCEL ");
            SNSAuth.getListener().onCancel(this, this.snsType);
        } else if (i != 0) {
            Log.i("WXTest", "onResp default errCode " + baseResp.errCode);
        } else {
            Log.i("WXTest", "onResp OK");
            if (baseResp instanceof SendAuth.Resp) {
                String str = ((SendAuth.Resp) baseResp).code;
                Log.i("WXTest", "onResp code = " + str);
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.snsType = this.snsType;
                TokenModel tokenModel = new TokenModel();
                tokenModel.authToken = str;
                tokenModel.consumerKey = mm2.c().k();
                sNSSignInAccount.token = JSON.toJSONString(tokenModel);
                sNSSignInAccount.app_id = mm2.c().k();
                SNSAuth.invokeTokenLogin(sNSSignInAccount);
            } else {
                SNSAuth.invokeError(this.snsType, -1, getResources().getString(R$string.aliuser_SNS_platform_auth_fail));
            }
        }
        finish();
    }

    private void onRespShare(BaseResp baseResp) {
        String b;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792313121")) {
            ipChange.ipc$dispatch("-792313121", new Object[]{this, baseResp});
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            b = cm2.b(this, R$string.data_string_010);
        } else if (i == -2) {
            b = cm2.b(this, R$string.errcode_cancel);
        } else if (i != 0) {
            b = cm2.b(this, R$string.data_string_011);
        } else {
            b = cm2.b(this, R$string.errcode_success);
        }
        ToastUtil.i(b);
        finish();
    }

    public static void setWXType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487104774")) {
            ipChange.ipc$dispatch("-1487104774", new Object[]{Integer.valueOf(i)});
        } else {
            mWXfrom = i;
        }
    }

    private void shareMiniProgram(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493818464")) {
            ipChange.ipc$dispatch("-493818464", new Object[]{this, str});
            return;
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = this.producturl;
        wXMiniProgramObject.miniprogramType = 0;
        if (AppConfig.v()) {
            wXMiniProgramObject.userName = "gh_8f607e128043";
        } else {
            wXMiniProgramObject.userName = "gh_8f607e128043";
        }
        wXMiniProgramObject.path = "" + str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = this.title;
        wXMediaMessage.description = this.message;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            wXMediaMessage.thumbData = Bitmap2Bytes(bitmap);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = wXMediaMessage;
        req.scene = 0;
        this.api.sendReq(req);
    }

    public boolean checkSharetype() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-422595689") ? ((Boolean) ipChange.ipc$dispatch("-422595689", new Object[]{this})).booleanValue() : this.api.getWXAppSupportAPI() >= 553779201;
    }

    public void loadImgFromUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194260166")) {
            ipChange.ipc$dispatch("194260166", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            a.b().c(str).n(new DMImageCreator.DMImageSuccListener() { // from class: cn.damai.wxapi.WXEntryActivity.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.e eVar) {
                    Bitmap bitmap;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1429897897")) {
                        ipChange2.ipc$dispatch("1429897897", new Object[]{this, eVar});
                    } else if (eVar == null || (bitmap = eVar.b) == null) {
                    } else {
                        WXEntryActivity wXEntryActivity = WXEntryActivity.this;
                        wXEntryActivity.bitmap = bitmap;
                        if (bitmap != null) {
                            if (wXEntryActivity.miniprogram) {
                                WXEntryActivity.this.fixImgSize(500, 400);
                            } else {
                                WXEntryActivity wXEntryActivity2 = WXEntryActivity.this;
                                wXEntryActivity2.bitmap = Utils.f(wXEntryActivity2.bitmap, 100000);
                            }
                            WXEntryActivity.this.bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(Utils.g(WXEntryActivity.this.bitmap, 90, 130000)), null, null);
                            WXEntryActivity wXEntryActivity3 = WXEntryActivity.this;
                            wXEntryActivity3.share(wXEntryActivity3.way);
                            return;
                        }
                        wXEntryActivity.share(wXEntryActivity.way);
                        ToastUtil a = ToastUtil.a();
                        WXEntryActivity wXEntryActivity4 = WXEntryActivity.this;
                        a.j(wXEntryActivity4, cm2.b(wXEntryActivity4, R$string.data_string_012));
                    }
                }
            }).e(new DMImageCreator.DMImageFailListener() { // from class: tb.jz2
                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public final void onFail(DMImageCreator.d dVar) {
                    WXEntryActivity.this.lambda$loadImgFromUrl$0(dVar);
                }
            }).f();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226464235")) {
            ipChange.ipc$dispatch("1226464235", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(83);
        linearLayout.setBackgroundDrawable(null);
        setContentView(linearLayout);
        this.api = WXAgent.createWxApi();
        if (AppConfig.v()) {
            this.api.registerApp(v20.a(WXAgent.APP_ID_DEBUG_CRYPT));
        } else {
            this.api.registerApp(v20.a(WXAgent.APP_ID_CRYPT));
        }
        this.api.handleIntent(getIntent(), this);
        initExtras(getIntent());
        if (this.title == null || mWXfrom == 1) {
            return;
        }
        this.handler.sendEmptyMessage(0);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251202027")) {
            ipChange.ipc$dispatch("251202027", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774891782")) {
            ipChange.ipc$dispatch("1774891782", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        cb1.g("aa", "onnewintent");
        this.bundle = intent.getExtras();
        setIntent(intent);
        this.api.handleIntent(intent, this);
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942919252")) {
            ipChange.ipc$dispatch("1942919252", new Object[]{this, baseReq});
        } else {
            baseReq.getType();
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "645487200")) {
            ipChange.ipc$dispatch("645487200", new Object[]{this, baseResp});
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            Log.i("WXTest", "onResp ERR_AUTH_DENIED");
            WechatAuthRespHandler.getInstance().handleWechatFail();
        } else if (i == -2) {
            Log.i("WXTest", "onResp ERR_USER_CANCEL ");
            WechatAuthRespHandler.getInstance().handleWechatFail();
        } else if (i != 0) {
            Log.i("WXTest", "onResp default errCode " + baseResp.errCode);
        } else {
            Log.i("WXTest", "onResp OK");
            if (baseResp instanceof SendAuth.Resp) {
                WechatAuthRespHandler.getInstance().handleWechatAuthCode(((SendAuth.Resp) baseResp).code);
            } else {
                WechatAuthRespHandler.getInstance().handleWechatFail();
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026840200")) {
            ipChange.ipc$dispatch("-1026840200", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    public void openWchart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627986387")) {
            ipChange.ipc$dispatch("1627986387", new Object[]{this});
        } else {
            this.api.openWXApp();
        }
    }

    public void share(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340065604")) {
            ipChange.ipc$dispatch("-340065604", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            if (this.bitmap == null) {
                this.bitmap = ((BitmapDrawable) getResources().getDrawable(R$drawable.logo)).getBitmap();
            }
            if (GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(this.fromWhere) && this.way == 0 && TextUtils.isEmpty(this.imageModeUrl)) {
                StringBuilder sb = new StringBuilder();
                sb.append("/pages/home/index?url=");
                sb.append(URLEncoder.encode("/pages/detail/item?id=" + this.projectId));
                shareMiniProgram(sb.toString());
                finish();
            } else if (this.miniprogram) {
                shareMiniProgram("/pages/home/index?url=" + URLEncoder.encode(this.producturl));
                finish();
            } else {
                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = this.producturl;
                WXMediaMessage wXMediaMessage = null;
                Bitmap bitmap = this.imageBitmap;
                if (bitmap != null) {
                    wXMediaMessage = new WXMediaMessage(new WXImageObject(bitmap));
                } else if (this.bitmap != null) {
                    wXMediaMessage = new WXMediaMessage(wXWebpageObject);
                    wXMediaMessage.title = this.title;
                    if (i == 0) {
                        wXMediaMessage.description = this.message;
                    }
                    byte[] Bitmap2Bytes = Bitmap2Bytes(this.bitmap);
                    this.arraybyte = Bitmap2Bytes;
                    wXMediaMessage.thumbData = Bitmap2Bytes;
                    wXMediaMessage.setThumbImage(this.bitmap);
                }
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = buildTransaction("testapp");
                req.message = wXMediaMessage;
                if (i != 0) {
                    req.scene = 1;
                }
                this.api.sendReq(req);
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            ToastUtil.i(cm2.b(this, R$string.data_string_009));
        }
    }

    public void shareMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-810926020")) {
            ipChange.ipc$dispatch("-810926020", new Object[]{this});
            return;
        }
        try {
            if (Utils.b(this, true)) {
                if (!TextUtils.isEmpty(this.imageModeUrl)) {
                    share(this.way);
                } else if (TextUtils.isEmpty(this.imageurl)) {
                    share(this.way);
                } else {
                    loadImgFromUrl(this.imageurl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
