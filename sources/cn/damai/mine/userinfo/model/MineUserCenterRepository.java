package cn.damai.mine.userinfo.model;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.mine.bean.VipCardInfoWrap;
import cn.damai.mine.net.UnloginVipInfoRequest;
import cn.damai.mine.userinfo.bean.UserCenterDataBean;
import cn.damai.user.userhome.model.UserHomeDataRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MineUserCenterRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public void requestUnLoginVipInfo(DMMtopRequestListener<VipCardInfoWrap> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621512115")) {
            ipChange.ipc$dispatch("1621512115", new Object[]{this, dMMtopRequestListener});
        } else {
            new UnloginVipInfoRequest().request(dMMtopRequestListener);
        }
    }

    public void requestUserCenterData(DMMtopRequestListener<UserCenterDataBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620813630")) {
            ipChange.ipc$dispatch("-620813630", new Object[]{this, dMMtopRequestListener});
            return;
        }
        UserHomeDataRequest userHomeDataRequest = new UserHomeDataRequest();
        userHomeDataRequest.mySelf = true;
        userHomeDataRequest.request(dMMtopRequestListener);
    }
}
