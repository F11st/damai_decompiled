package tb;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.apshare.AlipayApi;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.share.ShareService;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alibaba.pictures.share.ddshare.DDApi;
import com.alibaba.pictures.share.wxapi.WeixinApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class wb2 extends ShareService {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final wb2 INSTANCE = new wb2();
    private static ShareService.ShareActionListener a;

    private wb2() {
    }

    @Override // com.alibaba.pictures.share.common.share.ShareService
    @Nullable
    public ShareService.ShareActionListener a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1272937980") ? (ShareService.ShareActionListener) ipChange.ipc$dispatch("1272937980", new Object[]{this}) : a;
    }

    @Override // com.alibaba.pictures.share.common.share.ShareService
    public void b(@Nullable Context context, @Nullable ShareContent shareContent, @Nullable ShareChannel shareChannel, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1360154194")) {
            ipChange.ipc$dispatch("1360154194", new Object[]{this, context, shareContent, shareChannel, str});
        } else if (shareContent == null) {
            throw new ShareException("share content is null");
        } else {
            if (context == null) {
                return;
            }
            if (shareChannel != null) {
                try {
                    switch (vb2.$EnumSwitchMapping$0[shareChannel.ordinal()]) {
                        case 1:
                            sb2.c(null, "WEIXIN:" + str, 1, null);
                            new WeixinApi().g(context, shareContent, false, shareChannel);
                            return;
                        case 2:
                            sb2.c(null, "WEIXIN_FRIEND:" + str, 1, null);
                            new WeixinApi().g(context, shareContent, true, shareChannel);
                            return;
                        case 3:
                            sb2.c(null, "QQ:" + str, 1, null);
                            new cy1().b(context, shareContent, false, shareChannel);
                            return;
                        case 4:
                            sb2.c(null, "QZONE:" + str, 1, null);
                            new cy1().b(context, shareContent, true, shareChannel);
                            return;
                        case 5:
                            sb2.c(null, "WEIBO:" + str, 1, null);
                            new o13().a(context, shareContent, shareChannel);
                            return;
                        case 6:
                            sb2.c(null, "ALIPAY:" + str, 1, null);
                            new AlipayApi().f(context, shareContent, shareChannel, false);
                            return;
                        case 7:
                            sb2.c(null, "ALIPAY_TIMELINE:" + str, 1, null);
                            new AlipayApi().f(context, shareContent, shareChannel, true);
                            return;
                        case 8:
                            sb2.c(null, "DD:" + str, 1, null);
                            new DDApi().c(context, shareContent, shareChannel);
                            return;
                        case 9:
                            sb2.c(null, "COPYLINK:" + str, 1, null);
                            String url = shareContent.getUrl();
                            if (Build.VERSION.SDK_INT < 11) {
                                Object systemService = context.getApplicationContext().getSystemService("clipboard");
                                if (systemService != null) {
                                    ((ClipboardManager) systemService).setText(url);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type android.text.ClipboardManager");
                                }
                            } else {
                                Object systemService2 = context.getApplicationContext().getSystemService("clipboard");
                                if (systemService2 != null) {
                                    ((android.content.ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("Copied Text", url));
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
                                }
                            }
                            vf.b(ShareChannel.COPYLINK);
                            String string = context.getString(R$string.link_copy_success);
                            b41.h(string, "context.getString(R.string.link_copy_success)");
                            ShareUtil.n(string);
                            return;
                    }
                } catch (Exception e) {
                    sb2.b("ShareServiceImpl", e.toString());
                    return;
                }
            }
            sb2.c(null, "NONE:" + str, 1, null);
        }
    }

    public void c(@Nullable ShareService.ShareActionListener shareActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912386520")) {
            ipChange.ipc$dispatch("912386520", new Object[]{this, shareActionListener});
        } else {
            a = shareActionListener;
        }
    }
}
