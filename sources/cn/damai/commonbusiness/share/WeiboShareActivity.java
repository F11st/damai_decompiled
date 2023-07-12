package cn.damai.commonbusiness.share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import tb.mm2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WeiboShareActivity extends Activity implements WbShareCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Bitmap f;
    private String g;
    private IWBAPI h;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.share.WeiboShareActivity$a */
    /* loaded from: classes.dex */
    public class C0893a implements WbAuthListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0893a() {
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1598461512")) {
                ipChange.ipc$dispatch("1598461512", new Object[]{this});
            } else {
                WeiboShareActivity.this.finish();
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onComplete(Oauth2AccessToken oauth2AccessToken) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1018235599")) {
                ipChange.ipc$dispatch("-1018235599", new Object[]{this, oauth2AccessToken});
            } else {
                WeiboShareActivity.this.g();
            }
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onError(UiError uiError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-187706243")) {
                ipChange.ipc$dispatch("-187706243", new Object[]{this, uiError});
            } else {
                WeiboShareActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.share.WeiboShareActivity$b */
    /* loaded from: classes.dex */
    public class C0894b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0894b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "15425477")) {
                ipChange.ipc$dispatch("15425477", new Object[]{this, c0501d});
            } else {
                WeiboShareActivity.this.j(null);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.share.WeiboShareActivity$c */
    /* loaded from: classes.dex */
    public class C0895c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0895c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1711822438")) {
                ipChange.ipc$dispatch("-1711822438", new Object[]{this, c0502e});
            } else {
                WeiboShareActivity.this.j(c0502e.b);
            }
        }
    }

    private ImageObject b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500129712")) {
            return (ImageObject) ipChange.ipc$dispatch("-1500129712", new Object[]{this});
        }
        ImageObject imageObject = new ImageObject();
        if (!TextUtils.isEmpty(this.e)) {
            imageObject.setImageData(BitmapFactory.decodeFile(this.e));
        } else {
            Bitmap bitmap = this.f;
            if (bitmap != null) {
                imageObject.setImageData(bitmap);
            }
        }
        return imageObject;
    }

    private String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "761156434") ? (String) ipChange.ipc$dispatch("761156434", new Object[]{this}) : this.b;
    }

    private TextObject d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083553252")) {
            return (TextObject) ipChange.ipc$dispatch("-1083553252", new Object[]{this});
        }
        TextObject textObject = new TextObject();
        textObject.text = c();
        textObject.title = this.a;
        textObject.actionUrl = this.d;
        return textObject;
    }

    private WebpageObject e() {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924109760")) {
            return (WebpageObject) ipChange.ipc$dispatch("-1924109760", new Object[]{this});
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.title = "";
        webpageObject.description = this.b;
        if (!TextUtils.isEmpty(this.e)) {
            bitmap = BitmapFactory.decodeFile(this.e);
        } else {
            bitmap = ((BitmapDrawable) getResources().getDrawable(R$drawable.logo)).getBitmap();
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                        webpageObject.thumbData = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        webpageObject.actionUrl = this.d;
                        webpageObject.defaultText = this.b;
                        return webpageObject;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        webpageObject.actionUrl = this.d;
        webpageObject.defaultText = this.b;
        return webpageObject;
    }

    private void f() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416164451")) {
            ipChange.ipc$dispatch("-1416164451", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.a = extras.getString("title");
        this.b = extras.getString("message");
        this.c = extras.getString("imageurl");
        this.d = extras.getString("producturl");
        if (extras.containsKey("sinaSharePath")) {
            this.e = extras.getString("sinaSharePath");
        }
        if (TextUtils.isEmpty(this.b) || "bytype".equals(extras.getString("fromWhere", ""))) {
            return;
        }
        if (this.b.contains(this.d)) {
            String str2 = this.b;
            this.b = str2.substring(0, str2.indexOf(this.d));
        }
        if (this.b.length() > 140) {
            if (this.b.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                int indexOf = this.b.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                String substring = this.b.substring(indexOf);
                this.b = this.b.substring(0, indexOf).substring(0, 140 - this.b.substring(indexOf).length()) + substring;
            } else {
                this.b = ("大麦#去现场为所爱#" + this.b).substring(0, 140);
            }
        } else if (!this.b.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            this.b = "大麦#去现场为所爱#" + this.b;
        }
        if (this.b.length() + 10 > 140) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b.substring(0, str.length() - 10));
            sb.append("（@大麦官博 发布）");
            this.b = sb.toString();
            return;
        }
        this.b += "（@大麦官博 发布）";
    }

    private void h(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189431415")) {
            ipChange.ipc$dispatch("1189431415", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else {
            i(z, z2);
        }
    }

    private void i(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380256482")) {
            ipChange.ipc$dispatch("-380256482", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (z) {
            weiboMultiMessage.textObject = d();
        }
        if (z2) {
            weiboMultiMessage.imageObject = b();
        }
        weiboMultiMessage.mediaObject = e();
        this.h.shareMessage(this, weiboMultiMessage, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326975062")) {
            ipChange.ipc$dispatch("1326975062", new Object[]{this, bitmap});
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(this.b)) {
            weiboMultiMessage.textObject = d();
        }
        if (bitmap != null) {
            ImageObject imageObject = new ImageObject();
            imageObject.setImageData(bitmap);
            weiboMultiMessage.imageObject = imageObject;
        }
        weiboMultiMessage.mediaObject = e();
        this.h.shareMessage(this, weiboMultiMessage, false);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63772333")) {
            ipChange.ipc$dispatch("-63772333", new Object[]{this});
        } else {
            C0504a.b().h(this).c(this.c).n(new C0895c()).e(new C0894b()).f();
        }
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336877492")) {
            ipChange.ipc$dispatch("-1336877492", new Object[]{this});
        } else {
            this.h.authorize(this, new C0893a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0061 -> B:45:0x0071). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.share.WeiboShareActivity.$ipChange
            java.lang.String r1 = "1063556895"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L14
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L14:
            android.content.Intent r0 = r5.getIntent()
            if (r0 == 0) goto L34
            android.content.Intent r0 = r5.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L34
            android.content.Intent r0 = r5.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r1 = "imageModeUrl"
            java.lang.String r0 = r0.getString(r1)
            r5.g = r0
        L34:
            java.lang.String r0 = r5.g
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L71
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            java.lang.String r2 = r5.g     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L65
            r5.f = r1     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L65
            r2.close()     // Catch: java.io.IOException -> L60
            goto L71
        L53:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L66
        L57:
            r2 = r0
        L58:
            r5.f = r0     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L71
            r2.close()     // Catch: java.io.IOException -> L60
            goto L71
        L60:
            r0 = move-exception
            r0.printStackTrace()
            goto L71
        L65:
            r0 = move-exception
        L66:
            if (r2 == 0) goto L70
            r2.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r1 = move-exception
            r1.printStackTrace()
        L70:
            throw r0
        L71:
            android.graphics.Bitmap r0 = r5.f
            if (r0 == 0) goto L79
            r5.h(r3, r4)
            goto La1
        L79:
            r5.f()
            java.lang.String r0 = r5.e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L90
            java.lang.String r0 = r5.c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L90
            r5.k()
            goto La1
        L90:
            java.lang.String r0 = r5.b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r0 = r0 ^ r4
            java.lang.String r1 = r5.e
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ r4
            r5.h(r0, r1)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.share.WeiboShareActivity.g():void");
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051233978")) {
            ipChange.ipc$dispatch("-2051233978", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        IWBAPI iwbapi = this.h;
        if (iwbapi != null) {
            iwbapi.authorizeCallback(this, i, i2, intent);
            this.h.doResultIntent(intent, this);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264932549")) {
            ipChange.ipc$dispatch("-264932549", new Object[]{this});
        } else {
            finish();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829940764")) {
            ipChange.ipc$dispatch("829940764", new Object[]{this});
            return;
        }
        Toast.makeText(this, "微博分享成功", 0).show();
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719583045")) {
            ipChange.ipc$dispatch("-1719583045", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.layout_wbshare);
        AuthInfo authInfo = new AuthInfo(this, mm2.c().h(), mm2.d, mm2.e);
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(this);
        this.h = createWBAPI;
        createWBAPI.registerApp(this, authInfo);
        this.h.setLoggerEnable(true);
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(this);
        if (readAccessToken != null && !wh2.j(readAccessToken.getAccessToken()) && readAccessToken.isSessionValid()) {
            g();
        } else {
            l();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onError(UiError uiError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1362774864")) {
            ipChange.ipc$dispatch("-1362774864", new Object[]{this, uiError});
        } else {
            finish();
        }
    }
}
