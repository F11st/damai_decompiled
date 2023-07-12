package cn.damai.trade.newtradeorder.ui.projectdetail.common.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectSwitchIdDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.contract.ProjectContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.ProjectIdSwitchRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectPresenter extends ProjectContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.common.contract.ProjectContract.Presenter
    public void retrieveOldProjectItemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388242288")) {
            ipChange.ipc$dispatch("-388242288", new Object[]{this, str});
            return;
        }
        ProjectIdSwitchRequest projectIdSwitchRequest = new ProjectIdSwitchRequest();
        projectIdSwitchRequest.oldProjectId = str;
        projectIdSwitchRequest.request(new DMMtopRequestListener<ProjectSwitchIdDataBean.ProjectSwitchIdResultBean>(ProjectSwitchIdDataBean.ProjectSwitchIdResultBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.presenter.ProjectPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "501017766")) {
                    ipChange2.ipc$dispatch("501017766", new Object[]{this, str2, str3});
                } else {
                    ((ProjectContract.View) ProjectPresenter.this.mView).onRetrieveOldProjectIdError(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectSwitchIdDataBean.ProjectSwitchIdResultBean projectSwitchIdResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1658506425")) {
                    ipChange2.ipc$dispatch("-1658506425", new Object[]{this, projectSwitchIdResultBean});
                } else {
                    ((ProjectContract.View) ProjectPresenter.this.mView).onRetrieveOldProjectIdSuccess(projectSwitchIdResultBean);
                }
            }
        });
    }
}
