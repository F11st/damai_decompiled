package com.alibaba.pictures.share.wxapi;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.sb2;
import tb.vf;
import tb.wt2;
import tb.z11;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class WeixinApi {
    private static transient /* synthetic */ IpChange $ipChange;
    private IWXAPI a;

    private final String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579031416")) {
            return (String) ipChange.ipc$dispatch("1579031416", new Object[]{this, str});
        }
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    private final boolean d(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1994341293") ? ((Boolean) ipChange.ipc$dispatch("1994341293", new Object[]{this, bitmap})).booleanValue() : bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e(android.content.Context r7, com.tencent.mm.opensdk.openapi.IWXAPI r8, com.alibaba.pictures.share.common.share.ShareContent r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.wxapi.WeixinApi.e(android.content.Context, com.tencent.mm.opensdk.openapi.IWXAPI, com.alibaba.pictures.share.common.share.ShareContent, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [tb.wt2] */
    public final void f(Context context, IWXAPI iwxapi, ShareContent shareContent, boolean z) {
        WXImageObject wXImageObject;
        String g;
        String str;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "732955550")) {
            ipChange.ipc$dispatch("732955550", new Object[]{this, context, iwxapi, shareContent, Boolean.valueOf(z)});
            return;
        }
        if (shareContent != null && shareContent.getShareType() == 1) {
            Bitmap e = ShareUtil.e(context, shareContent);
            if (d(e)) {
                return;
            }
            Bitmap i = ShareUtil.i(e, 32);
            ShareManager shareManager = ShareManager.INSTANCE;
            String k = shareManager.b().k();
            if (k != null && (g = ShareUtil.g(context, e, false, 4, null)) != null) {
                Application a = shareManager.a();
                if (a != null) {
                    Uri uriForFile = FileProvider.getUriForFile(a, k, new File(g));
                    if (uriForFile != null) {
                        context.grantUriPermission("com.tencent.mm", uriForFile, 1);
                        str = uriForFile.toString();
                        r1 = wt2.INSTANCE;
                    } else {
                        str = null;
                    }
                    r1 = r1 == null ? str : null;
                    r1 = str;
                }
                sb2.f();
                wt2 wt2Var = wt2.INSTANCE;
                str = r1;
                r1 = str;
            }
            if (!((r1 == null || r1.length() == 0) ? true : true)) {
                wXImageObject = new WXImageObject();
                wXImageObject.imagePath = r1;
            } else {
                shareContent.setImageMaxSizeKb(1000);
                wXImageObject = new WXImageObject(ShareUtil.e(context, shareContent));
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
            wXMediaMessage.thumbData = z11.a(i, true);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = c("img");
            req.message = wXMediaMessage;
            req.scene = z ? 1 : 0;
            if (iwxapi != null) {
                iwxapi.sendReq(req);
            }
            ShareUtil.m(e);
            ShareUtil.m(i);
        } else if ((shareContent != null && shareContent.getShareType() == 2) || (shareContent != null && shareContent.getShareType() == 3)) {
            WXMediaMessage wXMediaMessage2 = new WXMediaMessage(new WXWebpageObject(shareContent.getUrl()));
            wXMediaMessage2.title = shareContent.getTitle();
            wXMediaMessage2.description = shareContent.getContent();
            Bitmap h = ShareUtil.h(context, shareContent, 32);
            wXMediaMessage2.thumbData = z11.a(h, true);
            ShareUtil.m(h);
            SendMessageToWX.Req req2 = new SendMessageToWX.Req();
            req2.transaction = c("webpage");
            req2.message = wXMediaMessage2;
            req2.scene = z ? 1 : 0;
            if (iwxapi != null) {
                iwxapi.sendReq(req2);
            }
        } else if (shareContent != null && shareContent.getShareType() == 4) {
            e(context, iwxapi, shareContent, z);
        } else {
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = shareContent != null ? shareContent.getContent() : null;
            WXMediaMessage wXMediaMessage3 = new WXMediaMessage();
            wXMediaMessage3.mediaObject = wXTextObject;
            wXMediaMessage3.description = shareContent != null ? shareContent.getContent() : null;
            SendMessageToWX.Req req3 = new SendMessageToWX.Req();
            req3.transaction = c("text");
            req3.message = wXMediaMessage3;
            req3.scene = z ? 1 : 0;
            if (iwxapi != null) {
                iwxapi.sendReq(req3);
            }
        }
    }

    public final void g(@NotNull final Context context, @NotNull final ShareContent shareContent, final boolean z, @Nullable final ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981283359")) {
            ipChange.ipc$dispatch("981283359", new Object[]{this, context, shareContent, Boolean.valueOf(z), shareChannel});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(shareContent, "shareParams");
        ShareManager shareManager = ShareManager.INSTANCE;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, shareManager.b().w());
        if (createWXAPI != null) {
            createWXAPI.registerApp(shareManager.b().w());
            if (!createWXAPI.isWXAppInstalled()) {
                String string = context.getString(R$string.weixin_not_install);
                b41.h(string, "context.getString(R.string.weixin_not_install)");
                ShareUtil.n(string);
                vf.a(shareChannel, ShareException.APP_UNINSTALL);
                return;
            } else if (createWXAPI.getWXAppSupportAPI() < 570425345) {
                String string2 = context.getString(R$string.weixin_not_support_api);
                b41.h(string2, "context.getString(R.string.weixin_not_support_api)");
                ShareUtil.n(string2);
                vf.a(shareChannel, ShareException.APP_UNSUPPORT_VERSION);
                return;
            } else {
                new Thread(new Runnable() { // from class: com.alibaba.pictures.share.wxapi.WeixinApi$share$$inlined$apply$lambda$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public final void run() {
                        IWXAPI iwxapi;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-394581677")) {
                            ipChange2.ipc$dispatch("-394581677", new Object[]{this});
                            return;
                        }
                        WeixinApi weixinApi = WeixinApi.this;
                        Context context2 = context;
                        iwxapi = weixinApi.a;
                        weixinApi.f(context2, iwxapi, shareContent, z);
                    }
                }).start();
                wt2 wt2Var = wt2.INSTANCE;
            }
        } else {
            createWXAPI = null;
        }
        this.a = createWXAPI;
    }
}
