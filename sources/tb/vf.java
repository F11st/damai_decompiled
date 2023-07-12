package tb;

import android.app.Application;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.share.ShareService;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.passport.result.AbsResult;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@JvmName(name = "CallBackUtils")
/* loaded from: classes8.dex */
public final class vf {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@Nullable ShareChannel shareChannel, int i) {
        ShareManager.IShareMonitor r;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150176136")) {
            ipChange.ipc$dispatch("-1150176136", new Object[]{shareChannel, Integer.valueOf(i)});
            return;
        }
        sb2.d("CallBackUtils", "onException:" + i);
        wb2 wb2Var = wb2.INSTANCE;
        if (shareChannel == ShareChannel.WEIBO && i == 1003) {
            Application a = ShareManager.INSTANCE.a();
            if (a != null) {
                String string = a.getString(R$string.share_fail);
                b41.h(string, "getString(R.string.share_fail)");
                ShareUtil.n(string);
            } else {
                sb2.f();
                wt2 wt2Var = wt2.INSTANCE;
            }
        }
        ShareService.ShareActionListener a2 = wb2Var.a();
        if (a2 != null) {
            a2.onException(shareChannel, new ShareException(i));
        }
        if (shareChannel == null || (r = ShareManager.INSTANCE.b().r()) == null) {
            return;
        }
        r.shareResult(shareChannel, 2, new ShareException(i).getStatusMsg());
    }

    public static final void b(@Nullable ShareChannel shareChannel) {
        ShareManager.IShareMonitor r;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-291152905")) {
            ipChange.ipc$dispatch("-291152905", new Object[]{shareChannel});
            return;
        }
        sb2.d("CallBackUtils", "onSuccess");
        ShareService.ShareActionListener a = wb2.INSTANCE.a();
        if (a != null) {
            a.onComplete(shareChannel);
        }
        if (shareChannel == null || (r = ShareManager.INSTANCE.b().r()) == null) {
            return;
        }
        r.shareResult(shareChannel, 1, AbsResult.MSG_SUCCESS);
    }
}
