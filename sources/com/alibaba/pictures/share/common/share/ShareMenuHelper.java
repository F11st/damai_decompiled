package com.alibaba.pictures.share.common.share;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.ui.dialog.DialogHelper;
import com.alibaba.pictures.share.common.ui.dialog.ReportDialog;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.ShareProvider;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.x;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.o;
import kotlinx.coroutines.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.da0;
import tb.hq2;
import tb.tb2;
import tb.ub2;
import tb.wt2;
import tb.xb2;
import tb.yb2;
import tb.yd1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ShareMenuHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private xb2 a;
    private long b;
    @NotNull
    private final Context c;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a extends ub2 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShareContent b;

        a(ShareContent shareContent) {
            this.b = shareContent;
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionDenied() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1347215275")) {
                ipChange.ipc$dispatch("1347215275", new Object[]{this});
            } else {
                ShareUtil.n("保存图片异常，请授予存储权限");
            }
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-109644983")) {
                ipChange.ipc$dispatch("-109644983", new Object[]{this});
            } else {
                ShareMenuHelper.this.i(this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class b implements ShareManager.IDownloadImage.IDownloadListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage.IDownloadListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1572558168")) {
                ipChange.ipc$dispatch("-1572558168", new Object[]{this});
            } else {
                ShareUtil.n("图片保存失败");
            }
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage.IDownloadListener
        public void onSuccess(@Nullable Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1692623252")) {
                ipChange.ipc$dispatch("-1692623252", new Object[]{this, bitmap});
            } else if (bitmap != null) {
                ShareMenuHelper.this.s(bitmap);
            } else {
                ShareUtil.n("图片保存失败");
                wt2 wt2Var = wt2.INSTANCE;
            }
        }
    }

    public ShareMenuHelper(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.c = context;
        this.a = new xb2(context);
    }

    private final void b(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427154806")) {
            ipChange.ipc$dispatch("427154806", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_Alipay", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.c(shareContent);
        }
    }

    private final void c(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-694916777")) {
            ipChange.ipc$dispatch("-694916777", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_Alipay_Timeline", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.d(shareContent);
        }
    }

    private final void d(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992144440")) {
            ipChange.ipc$dispatch("992144440", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_CopyLink", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.e(shareContent);
        }
    }

    private final void f(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516511532")) {
            ipChange.ipc$dispatch("516511532", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_QQ", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.a(shareContent);
        }
    }

    private final void g(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399545563")) {
            ipChange.ipc$dispatch("-1399545563", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_QZone", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.b(shareContent);
        }
    }

    private final void h(ShareContent shareContent, android.util.Pair<String, Object>[] pairArr) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561229960")) {
            ipChange.ipc$dispatch("-561229960", new Object[]{this, shareContent, pairArr});
            return;
        }
        String str = null;
        if (pairArr != null) {
            num = null;
            for (android.util.Pair<String, Object> pair : pairArr) {
                if (TextUtils.equals((CharSequence) pair.first, "targetId")) {
                    Object obj = pair.second;
                    if (obj instanceof String) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                        str = (String) obj;
                    }
                }
                if (TextUtils.equals((CharSequence) pair.first, "targetType")) {
                    Object obj2 = pair.second;
                    if (obj2 instanceof Integer) {
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        num = (Integer) obj2;
                    }
                }
            }
        } else {
            num = null;
        }
        new ReportDialog(this.c, str, num).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(ShareContent shareContent) {
        boolean F;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985966918")) {
            ipChange.ipc$dispatch("-1985966918", new Object[]{this, shareContent});
            return;
        }
        yb2.b(yb2.INSTANCE, "ShareMenu_SaveLocal", null, null, 6, null);
        if (shareContent == null) {
            return;
        }
        Bitmap defaultImage = shareContent.getDefaultImage();
        if (defaultImage != null) {
            s(defaultImage);
            return;
        }
        List<String> imgUrls = shareContent.getImgUrls();
        if (imgUrls.isEmpty()) {
            return;
        }
        String str = imgUrls.get(0);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        F = o.F(str, "http", false, 2, null);
        if (!F) {
            s(yd1.a(this.c, str));
        } else {
            n(str);
        }
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.g();
        }
    }

    private final void k(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172032366")) {
            ipChange.ipc$dispatch("172032366", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_WeiXin", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.j(shareContent);
        }
    }

    private final void l(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138998417")) {
            ipChange.ipc$dispatch("-2138998417", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_WeiXinTimeLine", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.k(shareContent);
        }
    }

    private final void m(ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605808336")) {
            ipChange.ipc$dispatch("1605808336", new Object[]{this, shareContent});
            return;
        }
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_Weibo", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.h(shareContent);
        }
    }

    private final void n(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570553977")) {
            ipChange.ipc$dispatch("570553977", new Object[]{this, str});
            return;
        }
        ShareManager.IDownloadImage i = ShareManager.INSTANCE.b().i();
        if (i != null) {
            i.download(str, new b());
        }
    }

    public final void e(@NotNull ShareContent shareContent) {
        Map m;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96459380")) {
            ipChange.ipc$dispatch("-96459380", new Object[]{this, shareContent});
            return;
        }
        b41.i(shareContent, "info");
        yb2 yb2Var = yb2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = hq2.a("ShareUrl", url);
        m = x.m(pairArr);
        yb2.b(yb2Var, "ShareMenu_DD", null, m, 2, null);
        xb2 xb2Var = this.a;
        if (xb2Var != null) {
            xb2Var.f(shareContent);
        }
    }

    public final void j(@Nullable Integer num, @Nullable ShareContent shareContent, @Nullable android.util.Pair<String, Object>[] pairArr) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300440119")) {
            ipChange.ipc$dispatch("1300440119", new Object[]{this, num, shareContent, pairArr});
        } else if (p() || shareContent == null) {
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (shareContent.getKind() != null) {
                ShareContent.ShareContentKind kind = shareContent.getKind();
                str = String.valueOf(kind != null ? kind.value : null);
            } else {
                str = "0";
            }
            linkedHashMap.put("type", str);
            linkedHashMap.put("channel", String.valueOf(num));
            String url4UT = shareContent.getUrl4UT();
            String str3 = "";
            if (url4UT == null) {
                url4UT = "";
            }
            linkedHashMap.put("url", url4UT);
            Map<String, String> extraInfo = shareContent.getExtraInfo();
            linkedHashMap.put("extra", (extraInfo == null || (r0 = extraInfo.get("share_film_comment_template")) == null) ? "" : "");
            Map<String, String> extraInfo2 = shareContent.getExtraInfo();
            linkedHashMap.put("show_id", (extraInfo2 == null || (r0 = extraInfo2.get("share_show_id")) == null) ? "" : "");
            Map<String, String> extraInfo3 = shareContent.getExtraInfo();
            if (extraInfo3 != null && (str2 = extraInfo3.get(ShareProvider.SHARE_FROM)) != null) {
                str3 = str2;
            }
            linkedHashMap.put("from", str3);
            yb2.b(yb2.INSTANCE, "ShareCommon", null, linkedHashMap, 2, null);
            int i = ShareChannel.WEIXIN.value;
            if (num != null && num.intValue() == i) {
                k(shareContent);
                return;
            }
            int i2 = ShareChannel.WEIXIN_FRIEND.value;
            if (num != null && num.intValue() == i2) {
                l(shareContent);
                return;
            }
            int i3 = ShareChannel.WEIBO.value;
            if (num != null && num.intValue() == i3) {
                m(shareContent);
                return;
            }
            int i4 = ShareChannel.ALIPAY.value;
            if (num != null && num.intValue() == i4) {
                b(shareContent);
                return;
            }
            int i5 = ShareChannel.ALIPAY_TIMELINE.value;
            if (num != null && num.intValue() == i5) {
                c(shareContent);
                return;
            }
            int i6 = ShareChannel.QQ.value;
            if (num != null && num.intValue() == i6) {
                f(shareContent);
                return;
            }
            int i7 = ShareChannel.QZONE.value;
            if (num != null && num.intValue() == i7) {
                g(shareContent);
                return;
            }
            int i8 = ShareChannel.COPYLINK.value;
            if (num != null && num.intValue() == i8) {
                d(shareContent);
                return;
            }
            int i9 = ShareChannel.SAVELOCAL.value;
            if (num != null && num.intValue() == i9) {
                ShareManager.IApplyPermission f = ShareManager.INSTANCE.b().f();
                if (f != null) {
                    ShareManager.IApplyPermission.a.a(f, new a(shareContent), null, 2, null);
                    return;
                }
                return;
            }
            int i10 = ShareChannel.DD.value;
            if (num != null && num.intValue() == i10) {
                e(shareContent);
                return;
            }
            int i11 = ShareChannel.REPORT.value;
            if (num != null && num.intValue() == i11) {
                h(shareContent, pairArr);
            }
        }
    }

    @NotNull
    public final Context o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "735181085") ? (Context) ipChange.ipc$dispatch("735181085", new Object[]{this}) : this.c;
    }

    public final synchronized boolean p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "295266062")) {
            return ((Boolean) ipChange.ipc$dispatch("295266062", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b < 3000) {
            return true;
        }
        this.b = currentTimeMillis;
        return false;
    }

    public final void q(@Nullable ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948837990")) {
            ipChange.ipc$dispatch("1948837990", new Object[]{this, shareChannel});
        } else if (shareChannel == null) {
        } else {
            switch (tb2.$EnumSwitchMapping$0[shareChannel.ordinal()]) {
                case 1:
                    yb2.b(yb2.INSTANCE, "ShareMenu_Alipay_Success", null, null, 6, null);
                    return;
                case 2:
                    yb2.b(yb2.INSTANCE, "ShareMenu_Alipay_Timeline_Success", null, null, 6, null);
                    return;
                case 3:
                    yb2.b(yb2.INSTANCE, "ShareMenu_Weibo_Success", null, null, 6, null);
                    return;
                case 4:
                    yb2.b(yb2.INSTANCE, "ShareMenu_Weixin_Success", null, null, 6, null);
                    return;
                case 5:
                    yb2.b(yb2.INSTANCE, "ShareMenu_WeixinTimeLine_Success", null, null, 6, null);
                    return;
                case 6:
                    yb2.b(yb2.INSTANCE, "ShareMenu_QQ_Success", null, null, 6, null);
                    return;
                case 7:
                    yb2.b(yb2.INSTANCE, "ShareMenu_Qzone_Success", null, null, 6, null);
                    return;
                case 8:
                    yb2.b(yb2.INSTANCE, "ShareMenu_CopyLink_Success", null, null, 6, null);
                    return;
                case 9:
                    yb2.b(yb2.INSTANCE, "ShareMenu_DD_Success", null, null, 6, null);
                    return;
                default:
                    return;
            }
        }
    }

    public final void r(@Nullable ShareChannel shareChannel, @Nullable ShareException shareException) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987815632")) {
            ipChange.ipc$dispatch("987815632", new Object[]{this, shareChannel, shareException});
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.alibaba.pictures.share.common.ui.dialog.DialogHelper] */
    public final void s(@Nullable Bitmap bitmap) {
        LifecycleCoroutineScope lifecycleScope;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641537269")) {
            ipChange.ipc$dispatch("641537269", new Object[]{this, bitmap});
            return;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Context context = this.c;
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity != null) {
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ?? dialogHelper = new DialogHelper(activity);
            ref$ObjectRef2.element = dialogHelper;
            ((DialogHelper) dialogHelper).e("");
            Context context2 = this.c;
            FragmentActivity fragmentActivity = context2 instanceof FragmentActivity ? context2 : null;
            if (fragmentActivity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) == null) {
                return;
            }
            g.b(lifecycleScope, da0.b(), null, new ShareMenuHelper$saveCommentShareToLocal$1(this, ref$ObjectRef, bitmap, ref$ObjectRef2, null), 2, null);
        }
    }
}
