package tb;

import android.view.View;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.user.userhome.view.usercenter.HeadUserTrackListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class bg1 implements HeadUserTrackListener {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onExposeDnaLayout(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242474383")) {
            ipChange.ipc$dispatch("1242474383", new Object[]{this, view});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtDNAViewClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166356203")) {
            ipChange.ipc$dispatch("-1166356203", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtFollowChangeClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606571140")) {
            ipChange.ipc$dispatch("-606571140", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtHeadAvatarClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921086832")) {
            ipChange.ipc$dispatch("921086832", new Object[]{this});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtHeadBackImgClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883739039")) {
            ipChange.ipc$dispatch("883739039", new Object[]{this});
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenLoginPageClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420057807")) {
            ipChange.ipc$dispatch("-420057807", new Object[]{this});
        } else {
            cn.damai.common.user.c.e().x(vf1.x().H());
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenRealNameAuthClick(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596887841")) {
            ipChange.ipc$dispatch("-1596887841", new Object[]{this, realNameAuthStatusBean});
        } else if (realNameAuthStatusBean == null || realNameAuthStatusBean.getAccountVerifyCode() != 1) {
        } else {
            cn.damai.common.user.c.e().x(vf1.x().U());
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenRelateInfoClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899521650")) {
            ipChange.ipc$dispatch("899521650", new Object[]{this, str});
        } else {
            cn.damai.common.user.c.e().x(vf1.x().i0(str));
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenUserInfoEditClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980174020")) {
            ipChange.ipc$dispatch("980174020", new Object[]{this});
        } else {
            cn.damai.common.user.c.e().x(vf1.x().i0(Constants.TAG_FOR_EDIT));
        }
    }
}
