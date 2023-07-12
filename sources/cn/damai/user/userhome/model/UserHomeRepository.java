package cn.damai.user.userhome.model;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UserHomeRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public void requestUserCenterData(DMMtopRequestListener<UserHomeDataBean> dMMtopRequestListener, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "538496138")) {
            ipChange.ipc$dispatch("538496138", new Object[]{this, dMMtopRequestListener, str});
            return;
        }
        UserHomeDataRequest userHomeDataRequest = new UserHomeDataRequest();
        userHomeDataRequest.targetHavanaId = str;
        userHomeDataRequest.request(dMMtopRequestListener);
    }
}
