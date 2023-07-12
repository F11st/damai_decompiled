package tb;

import android.content.Context;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.musicfestival.model.MusicPageNav;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class x72 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(BaccountInfo baccountInfo, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1463519929")) {
            ipChange.ipc$dispatch("1463519929", new Object[]{baccountInfo, context});
        } else if (baccountInfo == null || context == null) {
        } else {
            if (baccountInfo.type.equals("5")) {
                if (baccountInfo.isMusicType()) {
                    MusicPageNav.openH5MusicIpPage(context, baccountInfo.damaiId);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(RepertoireDetailFragment.REPERTOIREID, baccountInfo.damaiId);
                DMNav.from(context).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(FeedsViewModel.ARG_USERID, baccountInfo.damaiId);
            bundle2.putString("usertype", baccountInfo.type);
            DMNav.from(context).withExtras(bundle2).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }
}
