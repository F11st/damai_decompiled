package com.alibaba.pictures.share.weiboshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.uc.webview.export.media.MessageID;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlinx.coroutines.C8690g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.da0;
import tb.vf;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0003H\u0014J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016R\u001c\u0010#\u001a\u00020\u000e8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/alibaba/pictures/share/weiboshare/WeiboShareActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/sina/weibo/sdk/share/WbShareCallback;", "Ltb/wt2;", "setupWindowFlags", "sendMultiMessage", "Lcom/sina/weibo/sdk/api/TextObject;", "getTextObj", "Lcom/sina/weibo/sdk/api/ImageObject;", "getImageObj", "Lcom/sina/weibo/sdk/api/WebpageObject;", "getWebpageObj", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "shareParams", "", "getWeiboShareText", "Landroid/graphics/Bitmap;", "bitmap", "", "checkBitmap", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onDestroy", "onComplete", "Lcom/sina/weibo/sdk/common/UiError;", "error", MessageID.onError, "onCancel", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "shareBmp", "Landroid/graphics/Bitmap;", "<init>", "()V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class WeiboShareActivity extends FragmentActivity implements WbShareCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String TAG = "WeiboShare";
    private Bitmap shareBmp;
    private ShareContent shareParams;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1491573911") ? ((Boolean) ipChange.ipc$dispatch("-1491573911", new Object[]{this, bitmap})).booleanValue() : bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageObject getImageObj() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365854490")) {
            return (ImageObject) ipChange.ipc$dispatch("-1365854490", new Object[]{this});
        }
        ImageObject imageObject = new ImageObject();
        Bitmap e = ShareUtil.e(this, this.shareParams);
        this.shareBmp = e;
        Bitmap b = e != null ? ShareUtil.b(e, 1000) : null;
        this.shareBmp = b;
        imageObject.setImageData(b);
        return imageObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextObject getTextObj() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245075506")) {
            return (TextObject) ipChange.ipc$dispatch("1245075506", new Object[]{this});
        }
        TextObject textObject = new TextObject();
        String weiboShareText = getWeiboShareText(this.shareParams);
        if (weiboShareText.length() > 130) {
            String substring = weiboShareText.substring(0, 130);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            weiboShareText = substring + "...";
        }
        textObject.text = weiboShareText;
        return textObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.sina.weibo.sdk.api.WebpageObject getWebpageObj() {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.share.weiboshare.WeiboShareActivity.$ipChange
            java.lang.String r1 = "-232583210"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r6
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            com.sina.weibo.sdk.api.WebpageObject r0 = (com.sina.weibo.sdk.api.WebpageObject) r0
            return r0
        L17:
            com.sina.weibo.sdk.api.WebpageObject r0 = new com.sina.weibo.sdk.api.WebpageObject
            r0.<init>()
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            r0.identify = r1
            java.lang.String r1 = ""
            r0.title = r1
            java.lang.String r1 = " "
            r0.description = r1
            com.alibaba.pictures.share.common.share.ShareContent r1 = r6.shareParams
            r2 = 16
            android.graphics.Bitmap r1 = com.alibaba.pictures.share.common.util.ShareUtil.h(r6, r1, r2)
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r3.<init>()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            if (r1 == 0) goto L48
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L6e
            r5 = 85
            r1.compress(r4, r5, r3)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L6e
            goto L48
        L46:
            r1 = move-exception
            goto L5b
        L48:
            byte[] r1 = r3.toByteArray()     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L6e
            r0.thumbData = r1     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L6e
            r3.close()     // Catch: java.io.IOException -> L52
            goto L63
        L52:
            r1 = move-exception
            r1.printStackTrace()
            goto L63
        L57:
            r0 = move-exception
            goto L70
        L59:
            r1 = move-exception
            r3 = r2
        L5b:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L6e
            if (r3 == 0) goto L63
            r3.close()     // Catch: java.io.IOException -> L52
        L63:
            com.alibaba.pictures.share.common.share.ShareContent r1 = r6.shareParams
            if (r1 == 0) goto L6b
            java.lang.String r2 = r1.getUrl()
        L6b:
            r0.actionUrl = r2
            return r0
        L6e:
            r0 = move-exception
            r2 = r3
        L70:
            if (r2 == 0) goto L7a
            r2.close()     // Catch: java.io.IOException -> L76
            goto L7a
        L76:
            r1 = move-exception
            r1.printStackTrace()
        L7a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.share.weiboshare.WeiboShareActivity.getWebpageObj():com.sina.weibo.sdk.api.WebpageObject");
    }

    private final String getWeiboShareText(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1005871600")) {
            return (String) ipChange.ipc$dispatch("1005871600", new Object[]{this, shareContent});
        }
        String content = shareContent != null ? shareContent.getContent() : null;
        if (content == null || content.length() == 0) {
            content = shareContent != null ? shareContent.getTitle() : null;
        }
        if (content != null && content.length() != 0) {
            z = false;
        }
        if (z) {
            String v = ShareManager.INSTANCE.b().v();
            if (v == null) {
                v = "";
            }
            return v;
        }
        return content;
    }

    private final void sendMultiMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899211060")) {
            ipChange.ipc$dispatch("899211060", new Object[]{this});
        } else {
            C8690g.b(LifecycleOwnerKt.getLifecycleScope(this), da0.b(), null, new WeiboShareActivity$sendMultiMessage$1(this, null), 2, null);
        }
    }

    private final void setupWindowFlags() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751956784")) {
            ipChange.ipc$dispatch("751956784", new Object[]{this});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            requestWindowFeature(1);
            if (i >= 19) {
                getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            }
        }
    }

    @NotNull
    public final String getTAG() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2054442714") ? (String) ipChange.ipc$dispatch("2054442714", new Object[]{this}) : this.TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598112476")) {
            ipChange.ipc$dispatch("1598112476", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        IWBAPI c = ShareManager.INSTANCE.c();
        if (c != null) {
            c.doResultIntent(intent, this);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561108049")) {
            ipChange.ipc$dispatch("561108049", new Object[]{this});
        } else {
            vf.a(ShareChannel.WEIBO, 1001);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86005682")) {
            ipChange.ipc$dispatch("86005682", new Object[]{this});
        } else {
            vf.b(ShareChannel.WEIBO);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088924133")) {
            ipChange.ipc$dispatch("1088924133", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setupWindowFlags();
        IWBAPI c = ShareManager.INSTANCE.c();
        if (c != null && !c.isWBAppInstalled()) {
            ShareUtil.n("分享失败，请先安装微博客户端");
            finish();
            return;
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("ShareParams");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.alibaba.pictures.share.common.share.ShareContent");
        this.shareParams = (ShareContent) serializableExtra;
        sendMultiMessage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-212745627")) {
            ipChange.ipc$dispatch("-212745627", new Object[]{this});
            return;
        }
        super.onDestroy();
        ShareUtil.m(this.shareBmp);
        this.shareBmp = null;
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onError(@Nullable UiError uiError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008395706")) {
            ipChange.ipc$dispatch("-2008395706", new Object[]{this, uiError});
        } else if (uiError != null) {
            vf.a(ShareChannel.WEIBO, uiError.errorCode);
        } else {
            vf.a(ShareChannel.WEIBO, 1003);
            wt2 wt2Var = wt2.INSTANCE;
        }
    }
}
