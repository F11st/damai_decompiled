package com.alibaba.pictures.share.ddshare;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.android.dingtalk.share.ddsharemodule.DDShareApiFactory;
import com.android.dingtalk.share.ddsharemodule.IDDShareApi;
import com.android.dingtalk.share.ddsharemodule.message.DDImageMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDTextMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDWebpageMessage;
import com.android.dingtalk.share.ddsharemodule.message.SendMessageToDD;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.sb2;
import tb.vf;
import tb.z11;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class DDApi {
    private static transient /* synthetic */ IpChange $ipChange;
    private IDDShareApi a;

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Context context, ShareContent shareContent, ShareChannel shareChannel) {
        boolean F;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136259410")) {
            ipChange.ipc$dispatch("1136259410", new Object[]{this, context, shareContent, shareChannel});
            return;
        }
        DDMediaMessage dDMediaMessage = new DDMediaMessage();
        if (shareContent.getShareType() == 1) {
            List<String> imgUrls = shareContent.getImgUrls();
            Objects.requireNonNull(imgUrls, "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            ArrayList arrayList = (ArrayList) imgUrls;
            if ((!arrayList.isEmpty()) && TextUtils.equals((CharSequence) arrayList.get(0), ShareManager.INSTANCE.b().h())) {
                arrayList.remove(0);
            }
            Bitmap e = ShareUtil.e(context, shareContent);
            String g = ShareUtil.g(context, e, false, 4, null);
            ShareUtil.m(e);
            if (arrayList.isEmpty() && e == null) {
                return;
            }
            DDImageMessage dDImageMessage = new DDImageMessage();
            if ((!arrayList.isEmpty()) && !TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                Object obj = arrayList.get(0);
                b41.h(obj, "imgUrls[0]");
                F = C8604o.F((String) obj, "http", false, 2, null);
                if (F) {
                    dDImageMessage.mImageUrl = (String) arrayList.get(0);
                    dDMediaMessage.mMediaObject = dDImageMessage;
                }
            }
            if (g != null) {
                String str = g.length() > 0 ? g : null;
                if (str != null) {
                    ShareManager shareManager = ShareManager.INSTANCE;
                    String k = shareManager.b().k();
                    if (k != null) {
                        Application a = shareManager.a();
                        if (a != null) {
                            dDImageMessage.mImageUri = FileProvider.getUriForFile(a, k, new File(str));
                        } else {
                            sb2.f();
                        }
                    }
                }
            }
            dDMediaMessage.mMediaObject = dDImageMessage;
        } else if (shareContent.getShareType() != 2 && shareContent.getShareType() != 3) {
            DDTextMessage dDTextMessage = new DDTextMessage();
            dDTextMessage.mText = shareContent.getContent();
            dDMediaMessage.mMediaObject = dDTextMessage;
            dDMediaMessage.mContent = shareContent.getContent();
        } else {
            DDWebpageMessage dDWebpageMessage = new DDWebpageMessage();
            dDWebpageMessage.mUrl = shareContent.getUrl();
            dDMediaMessage.mMediaObject = dDWebpageMessage;
            dDMediaMessage.mTitle = shareContent.getTitle();
            dDMediaMessage.mContent = shareContent.getContent();
            Bitmap h = ShareUtil.h(context, shareContent, 32);
            dDMediaMessage.mThumbData = z11.a(h, true);
            ShareUtil.m(h);
        }
        SendMessageToDD.Req req = new SendMessageToDD.Req();
        req.mMediaMessage = dDMediaMessage;
        IDDShareApi iDDShareApi = this.a;
        if (iDDShareApi == null) {
            b41.A("iddShareApi");
        }
        if (iDDShareApi != null) {
            iDDShareApi.sendReq(req);
        }
    }

    public final void c(@NotNull Context context, @NotNull ShareContent shareContent, @NotNull ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1593565277")) {
            ipChange.ipc$dispatch("1593565277", new Object[]{this, context, shareContent, shareChannel});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(shareContent, "shareParams");
        b41.i(shareChannel, "shareType");
        ShareManager shareManager = ShareManager.INSTANCE;
        IDDShareApi createDDShareApi = DDShareApiFactory.createDDShareApi(context, shareManager.b().g(), true);
        b41.h(createDDShareApi, "DDShareApiFactory.create…           true\n        )");
        this.a = createDDShareApi;
        if (createDDShareApi == null) {
            b41.A("iddShareApi");
        }
        if (!createDDShareApi.isDDAppInstalled()) {
            String string = context.getString(R$string.dd_not_install);
            b41.h(string, "context.getString(R.string.dd_not_install)");
            ShareUtil.n(string);
            vf.a(shareChannel, ShareException.APP_UNINSTALL);
            return;
        }
        IDDShareApi iDDShareApi = this.a;
        if (iDDShareApi == null) {
            b41.A("iddShareApi");
        }
        if (!iDDShareApi.isDDSupportAPI()) {
            String string2 = context.getString(R$string.dd_not_support_api);
            b41.h(string2, "context.getString(R.string.dd_not_support_api)");
            ShareUtil.n(string2);
            vf.a(shareChannel, ShareException.APP_UNSUPPORT_VERSION);
            return;
        }
        ShareManager.IApplyPermission f = shareManager.b().f();
        if (f != null) {
            f.requestStoragePermission(new DDApi$share$1(this, context, shareContent, shareChannel), (Activity) context);
        }
    }
}
