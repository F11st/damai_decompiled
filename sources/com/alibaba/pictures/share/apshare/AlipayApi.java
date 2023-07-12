package com.alibaba.pictures.share.apshare;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alipay.share.sdk.openapi.APAPIFactory;
import com.alipay.share.sdk.openapi.APImageObject;
import com.alipay.share.sdk.openapi.APMediaMessage;
import com.alipay.share.sdk.openapi.APTextObject;
import com.alipay.share.sdk.openapi.APWebPageObject;
import com.alipay.share.sdk.openapi.IAPApi;
import com.alipay.share.sdk.openapi.SendMessageToZFB;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gl2;
import tb.vf;
import tb.z11;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class AlipayApi {
    private static transient /* synthetic */ IpChange $ipChange;
    private IAPApi a;

    private final String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2015529143")) {
            return (String) ipChange.ipc$dispatch("-2015529143", new Object[]{this, str});
        }
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Context context, IAPApi iAPApi, ShareContent shareContent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-695368475")) {
            ipChange.ipc$dispatch("-695368475", new Object[]{this, context, iAPApi, shareContent, Boolean.valueOf(z)});
        } else if (shareContent.getShareType() == 1) {
            Bitmap e = ShareUtil.e(context, shareContent);
            APImageObject aPImageObject = new APImageObject(e);
            APMediaMessage aPMediaMessage = new APMediaMessage();
            aPMediaMessage.mediaObject = aPImageObject;
            aPMediaMessage.thumbData = z11.a(ShareUtil.i(e, 32), true);
            SendMessageToZFB.Req req = new SendMessageToZFB.Req();
            req.message = aPMediaMessage;
            req.transaction = c("image");
            if (z) {
                req.scene = 1;
            }
            if (iAPApi != null) {
                iAPApi.sendReq(req);
            }
        } else if (shareContent.getShareType() != 2 && shareContent.getShareType() != 3) {
            APTextObject aPTextObject = new APTextObject();
            aPTextObject.text = shareContent.getContent();
            APMediaMessage aPMediaMessage2 = new APMediaMessage();
            aPMediaMessage2.mediaObject = aPTextObject;
            aPMediaMessage2.description = shareContent.getContent();
            SendMessageToZFB.Req req2 = new SendMessageToZFB.Req();
            req2.transaction = c("text");
            if (z) {
                req2.scene = 1;
            }
            req2.message = aPMediaMessage2;
            if (iAPApi != null) {
                iAPApi.sendReq(req2);
            }
        } else {
            APMediaMessage aPMediaMessage3 = new APMediaMessage(new APWebPageObject(shareContent.getUrl()));
            aPMediaMessage3.title = shareContent.getTitle();
            aPMediaMessage3.description = shareContent.getContent();
            Bitmap h = ShareUtil.h(context, shareContent, 32);
            aPMediaMessage3.thumbData = z11.a(h, true);
            ShareUtil.m(h);
            SendMessageToZFB.Req req3 = new SendMessageToZFB.Req();
            req3.transaction = c("webpage");
            if (z) {
                req3.scene = 1;
            }
            req3.message = aPMediaMessage3;
            if (iAPApi != null) {
                iAPApi.sendReq(req3);
            }
        }
    }

    public final boolean e(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229944923")) {
            return ((Boolean) ipChange.ipc$dispatch("229944923", new Object[]{this, context})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 64);
            if (packageInfo != null) {
                return packageInfo.versionCode >= 77;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void f(@NotNull final Context context, @NotNull final ShareContent shareContent, @Nullable ShareChannel shareChannel, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604474832")) {
            ipChange.ipc$dispatch("-1604474832", new Object[]{this, context, shareContent, shareChannel, Boolean.valueOf(z)});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(shareContent, "shareParams");
        IAPApi createZFBApi = APAPIFactory.createZFBApi(context, ShareManager.INSTANCE.b().a());
        this.a = createZFBApi;
        if (createZFBApi != null && !createZFBApi.isZFBAppInstalled()) {
            String string = context.getString(R$string.alipay_not_install);
            b41.h(string, "context.getString(R.string.alipay_not_install)");
            ShareUtil.n(string);
            vf.a(shareChannel, ShareException.APP_UNINSTALL);
        } else if (!e(context)) {
            String string2 = context.getString(R$string.alipay_not_support_api);
            b41.h(string2, "context.getString(R.string.alipay_not_support_api)");
            ShareUtil.n(string2);
            vf.a(shareChannel, ShareException.APP_UNSUPPORT_VERSION);
        } else {
            gl2.INSTANCE.b(new Runnable() { // from class: com.alibaba.pictures.share.apshare.AlipayApi$share$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public final void run() {
                    IAPApi iAPApi;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-698108614")) {
                        ipChange2.ipc$dispatch("-698108614", new Object[]{this});
                        return;
                    }
                    AlipayApi alipayApi = AlipayApi.this;
                    Context context2 = context;
                    iAPApi = alipayApi.a;
                    alipayApi.d(context2, iAPApi, shareContent, z);
                }
            });
        }
    }
}
