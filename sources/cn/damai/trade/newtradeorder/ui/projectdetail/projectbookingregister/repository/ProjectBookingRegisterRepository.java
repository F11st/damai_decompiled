package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.repository;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.request.ProjectBookingRegisterRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w12;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectBookingRegisterRepository extends ProjectCommonRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public void retrieveProjectBookingRegisterData(String str, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641421125")) {
            ipChange.ipc$dispatch("-641421125", new Object[]{this, str, w12Var});
            return;
        }
        ProjectBookingRegisterRequest projectBookingRegisterRequest = new ProjectBookingRegisterRequest();
        projectBookingRegisterRequest.projectId = str;
        projectBookingRegisterRequest.request(new DMMtopRequestListener<ProjectBookingRegisterData>(ProjectBookingRegisterData.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.repository.ProjectBookingRegisterRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-109765420")) {
                    ipChange2.ipc$dispatch("-109765420", new Object[]{this, str2, str3});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.a(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectBookingRegisterData projectBookingRegisterData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "640725763")) {
                    ipChange2.ipc$dispatch("640725763", new Object[]{this, projectBookingRegisterData});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.b(projectBookingRegisterData);
                }
            }
        });
    }
}
