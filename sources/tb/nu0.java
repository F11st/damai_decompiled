package tb;

import cn.damai.category.grab.bean.GrabBean;
import cn.damai.category.grab.request.GrabRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class nu0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a(GrabRequest grabRequest, DMMtopRequestListener<GrabBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653943520")) {
            ipChange.ipc$dispatch("-1653943520", new Object[]{this, grabRequest, dMMtopRequestListener});
        } else {
            grabRequest.request(dMMtopRequestListener);
        }
    }
}
