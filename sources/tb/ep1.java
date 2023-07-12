package tb;

import android.view.View;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.user.userhome.view.usercenter.HeadUserTrackListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ep1 implements HeadUserTrackListener {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onExposeDnaLayout(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-157736322")) {
            ipChange.ipc$dispatch("-157736322", new Object[]{this, view});
        } else {
            iv2.f(view);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtDNAViewClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "527423110")) {
            ipChange.ipc$dispatch("527423110", new Object[]{this, Boolean.valueOf(z)});
        } else {
            iv2.j().o(z);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtFollowChangeClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861079381")) {
            ipChange.ipc$dispatch("-1861079381", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtHeadAvatarClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850401441")) {
            ipChange.ipc$dispatch("850401441", new Object[]{this});
        } else {
            iv2.j().n();
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtHeadBackImgClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1307508082")) {
            ipChange.ipc$dispatch("-1307508082", new Object[]{this});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenLoginPageClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674566048")) {
            ipChange.ipc$dispatch("-1674566048", new Object[]{this});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenRealNameAuthClick(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420146544")) {
            ipChange.ipc$dispatch("-420146544", new Object[]{this, realNameAuthStatusBean});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenRelateInfoClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771725085")) {
            ipChange.ipc$dispatch("-1771725085", new Object[]{this, str});
        } else {
            C0529c.e().x(iv2.j().m(str));
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenUserInfoEditClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564391115")) {
            ipChange.ipc$dispatch("-1564391115", new Object[]{this});
        }
    }
}
