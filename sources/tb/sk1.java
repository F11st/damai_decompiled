package tb;

import android.view.View;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.user.userhome.view.usercenter.HeadUserTrackListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class sk1 implements HeadUserTrackListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private HeadUserTrackListener a;

    public void a(HeadUserTrackListener headUserTrackListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915789971")) {
            ipChange.ipc$dispatch("-1915789971", new Object[]{this, headUserTrackListener});
        } else {
            this.a = headUserTrackListener;
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onExposeDnaLayout(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535376511")) {
            ipChange.ipc$dispatch("1535376511", new Object[]{this, view});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onExposeDnaLayout(view);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtDNAViewClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37535195")) {
            ipChange.ipc$dispatch("-37535195", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtDNAViewClick(z);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtFollowChangeClick(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417424492")) {
            ipChange.ipc$dispatch("1417424492", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtFollowChangeClick(z);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtHeadAvatarClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908650368")) {
            ipChange.ipc$dispatch("-908650368", new Object[]{this});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtHeadAvatarClick();
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtHeadBackImgClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3539313")) {
            ipChange.ipc$dispatch("-3539313", new Object[]{this});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtHeadBackImgClick();
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenLoginPageClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1603937825")) {
            ipChange.ipc$dispatch("1603937825", new Object[]{this});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtOpenLoginPageClick();
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenRealNameAuthClick(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1752326639")) {
            ipChange.ipc$dispatch("1752326639", new Object[]{this, realNameAuthStatusBean});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtOpenRealNameAuthClick(realNameAuthStatusBean);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenRelateInfoClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243095678")) {
            ipChange.ipc$dispatch("-1243095678", new Object[]{this, str});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtOpenRelateInfoClick(str);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeadUserTrackListener
    public void onUtOpenUserInfoEditClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788178388")) {
            ipChange.ipc$dispatch("788178388", new Object[]{this});
            return;
        }
        HeadUserTrackListener headUserTrackListener = this.a;
        if (headUserTrackListener != null) {
            headUserTrackListener.onUtOpenUserInfoEditClick();
        }
    }
}
