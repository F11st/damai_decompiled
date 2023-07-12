package tb;

import android.content.Context;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareService;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class xb2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ShareService a;
    @NotNull
    private final Context b;

    public xb2(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.b = context;
        this.a = wb2.INSTANCE;
    }

    private final void i(ShareContent shareContent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424829373")) {
            ipChange.ipc$dispatch("-424829373", new Object[]{this, shareContent, Boolean.valueOf(z)});
        } else if (shareContent == null) {
        } else {
            if (z) {
                this.a.b(this.b, shareContent, ShareChannel.WEIXIN, com.alipay.sdk.m.k.b.l);
            } else {
                this.a.b(this.b, shareContent, ShareChannel.WEIXIN_FRIEND, com.alipay.sdk.m.k.b.l);
            }
        }
    }

    public final void a(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603430334")) {
            ipChange.ipc$dispatch("603430334", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            this.a.b(this.b, shareContent, ShareChannel.QQ, com.alipay.sdk.m.k.b.l);
        }
    }

    public final void b(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409626753")) {
            ipChange.ipc$dispatch("-409626753", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            this.a.b(this.b, shareContent, ShareChannel.QZONE, com.alipay.sdk.m.k.b.l);
        }
    }

    public final void c(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643318936")) {
            ipChange.ipc$dispatch("-1643318936", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            this.a.b(this.b, shareContent, ShareChannel.ALIPAY, com.alipay.sdk.m.k.b.l);
        }
    }

    public final void d(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284108247")) {
            ipChange.ipc$dispatch("-284108247", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            this.a.b(this.b, shareContent, ShareChannel.ALIPAY_TIMELINE, com.alipay.sdk.m.k.b.l);
        }
    }

    public final void e(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479821266")) {
            ipChange.ipc$dispatch("479821266", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            this.a.b(this.b, shareContent, ShareChannel.COPYLINK, com.alipay.sdk.m.k.b.l);
        }
    }

    public final void f(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731086306")) {
            ipChange.ipc$dispatch("-1731086306", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            this.a.b(this.b, shareContent, ShareChannel.DD, com.alipay.sdk.m.k.b.l);
        }
    }

    public final void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313777657")) {
            ipChange.ipc$dispatch("-1313777657", new Object[]{this});
        }
    }

    public final void h(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622134390")) {
            ipChange.ipc$dispatch("-622134390", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            this.a.b(this.b, shareContent, ShareChannel.WEIBO, com.alipay.sdk.m.k.b.l);
        }
    }

    public final void j(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149983360")) {
            ipChange.ipc$dispatch("-149983360", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            i(shareContent, true);
        }
    }

    public final void k(@Nullable ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155547071")) {
            ipChange.ipc$dispatch("-1155547071", new Object[]{this, shareContent});
        } else if (shareContent == null) {
        } else {
            i(shareContent, false);
        }
    }
}
