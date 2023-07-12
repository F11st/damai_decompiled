package tb;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import cn.damai.user.userhome.view.usercenter.HeaderUiController;
import cn.damai.user.userhome.view.usercenter.ModeEmpty;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class gv2 implements HeaderUiController {
    private static transient /* synthetic */ IpChange $ipChange;
    private HeaderUiController a;

    public void a(HeaderUiController headerUiController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-714683267")) {
            ipChange.ipc$dispatch("-714683267", new Object[]{this, headerUiController});
        } else {
            this.a = headerUiController;
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.GetAttentionView
    public AttentionView getAttentionView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030729428")) {
            return (AttentionView) ipChange.ipc$dispatch("-2030729428", new Object[]{this});
        }
        HeaderUiController headerUiController = this.a;
        if (headerUiController != null) {
            return headerUiController.getAttentionView();
        }
        return null;
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void hideRealNameAuthView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791194548")) {
            ipChange.ipc$dispatch("-791194548", new Object[]{this});
            return;
        }
        HeaderUiController headerUiController = this.a;
        if (headerUiController != null) {
            headerUiController.hideRealNameAuthView();
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setBGAtmosphereUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456963640")) {
            ipChange.ipc$dispatch("-456963640", new Object[]{this, str});
            return;
        }
        HeaderUiController headerUiController = this.a;
        if (headerUiController != null) {
            headerUiController.setBGAtmosphereUrl(str);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setUserAvatarUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "723365093")) {
            ipChange.ipc$dispatch("723365093", new Object[]{this, str});
            return;
        }
        HeaderUiController headerUiController = this.a;
        if (headerUiController != null) {
            headerUiController.setUserAvatarUrl(str);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void setUserNickView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425505189")) {
            ipChange.ipc$dispatch("-1425505189", new Object[]{this, str});
            return;
        }
        HeaderUiController headerUiController = this.a;
        if (headerUiController != null) {
            headerUiController.setUserNickView(str);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void showEmptyHeadView(ModeEmpty modeEmpty) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025467017")) {
            ipChange.ipc$dispatch("-2025467017", new Object[]{this, modeEmpty});
            return;
        }
        HeaderUiController headerUiController = this.a;
        if (headerUiController != null) {
            headerUiController.showEmptyHeadView(modeEmpty);
        }
    }

    @Override // cn.damai.user.userhome.view.usercenter.HeaderUiController
    public void update(UserHomeDataBean userHomeDataBean, @Nullable RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "33585936")) {
            ipChange.ipc$dispatch("33585936", new Object[]{this, userHomeDataBean, realNameAuthStatusBean});
            return;
        }
        HeaderUiController headerUiController = this.a;
        if (headerUiController != null) {
            headerUiController.update(userHomeDataBean, realNameAuthStatusBean);
        }
    }
}
