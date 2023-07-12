package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository;

import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailComponentResultBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailItemResultDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.ProjectItemDetailRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.ProjectItemRecommendRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.request.ProjectNATRequest;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.e11;
import tb.w12;
import tb.zn2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectItemRepository extends ProjectCommonRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailCallback(w12 w12Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655515703")) {
            ipChange.ipc$dispatch("-655515703", new Object[]{this, w12Var, str, str2});
        } else if (w12Var != null) {
            w12Var.a(str, str2);
        }
    }

    public void retrieveProjectItemData(String str, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-755659113")) {
            ipChange.ipc$dispatch("-755659113", new Object[]{this, str, w12Var});
            return;
        }
        ProjectItemDetailRequest projectItemDetailRequest = new ProjectItemDetailRequest();
        projectItemDetailRequest.itemId = str;
        DMMtopRequestListener<ProjectDetailItemResultDataBean> dMMtopRequestListener = new DMMtopRequestListener<ProjectDetailItemResultDataBean>(ProjectDetailItemResultDataBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "47748689")) {
                    ipChange2.ipc$dispatch("47748689", new Object[]{this, str2, str3});
                } else {
                    ProjectItemRepository.this.onFailCallback(w12Var, str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectDetailItemResultDataBean projectDetailItemResultDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "453969983")) {
                    ipChange2.ipc$dispatch("453969983", new Object[]{this, projectDetailItemResultDataBean});
                    return;
                }
                zn2.b();
                if (projectDetailItemResultDataBean == null) {
                    ProjectItemRepository.this.onFailCallback(w12Var, e11.FAIL_SYS_TRAFFIC_LIMIT, "麦麦开小差了，请稍后重试哦");
                    return;
                }
                String errorMsg = projectDetailItemResultDataBean.getErrorMsg();
                String result = projectDetailItemResultDataBean.getResult();
                if (!TextUtils.isEmpty(errorMsg)) {
                    w12 w12Var2 = w12Var;
                    if (w12Var2 != null) {
                        w12Var2.a("9994", errorMsg);
                    }
                } else if (TextUtils.isEmpty(result)) {
                    ProjectItemRepository.this.onFailCallback(w12Var, e11.FAIL_SYS_TRAFFIC_LIMIT, "麦麦开小差了，请稍后重试哦");
                } else {
                    ProjectDetailDataBean projectDetailDataBean = null;
                    try {
                        ProjectDetailComponentResultBean projectDetailComponentResultBean = (ProjectDetailComponentResultBean) JSON.parseObject(projectDetailItemResultDataBean.getResult(), ProjectDetailComponentResultBean.class);
                        if (projectDetailComponentResultBean != null && projectDetailComponentResultBean.getDetailViewComponentMap() != null) {
                            projectDetailDataBean = projectDetailComponentResultBean.getDetailViewComponentMap().getItem();
                        }
                    } catch (Exception e) {
                        if (AppConfig.v()) {
                            e.printStackTrace();
                        }
                    }
                    if (projectDetailDataBean == null) {
                        ProjectItemRepository.this.onFailCallback(w12Var, e11.FAIL_SYS_TRAFFIC_LIMIT, "麦麦开小差了，请稍后重试哦");
                        return;
                    }
                    w12 w12Var3 = w12Var;
                    if (w12Var3 != null) {
                        w12Var3.b(projectDetailDataBean);
                    }
                }
            }
        };
        zn2.c();
        projectItemDetailRequest.request(dMMtopRequestListener);
    }

    public void retrieveProjectNATData(String str, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224112813")) {
            ipChange.ipc$dispatch("-1224112813", new Object[]{this, str, w12Var});
            return;
        }
        ProjectNATRequest projectNATRequest = new ProjectNATRequest();
        projectNATRequest.itemId = str;
        projectNATRequest.request(new DMMtopRequestListener<ProjectInformationBean>(ProjectInformationBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "39989330")) {
                    ipChange2.ipc$dispatch("39989330", new Object[]{this, str2, str3});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.a(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectInformationBean projectInformationBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1958170789")) {
                    ipChange2.ipc$dispatch("-1958170789", new Object[]{this, projectInformationBean});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.b(projectInformationBean);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository
    public void retrieveRecommendProject(String str, String str2, double d, double d2, int i, int i2, String str3, boolean z, int i3, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549523989")) {
            ipChange.ipc$dispatch("-1549523989", new Object[]{this, str, str2, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), str3, Boolean.valueOf(z), Integer.valueOf(i3), w12Var});
            return;
        }
        ProjectItemRecommendRequest projectItemRecommendRequest = new ProjectItemRecommendRequest();
        projectItemRecommendRequest.cityId = str2;
        projectItemRecommendRequest.longitude = d;
        projectItemRecommendRequest.latitude = d2;
        projectItemRecommendRequest.pageIndex = i;
        projectItemRecommendRequest.pageSize = i2;
        projectItemRecommendRequest.projectIdList = str3;
        projectItemRecommendRequest.returnDefault = z;
        projectItemRecommendRequest.type = i3;
        projectItemRecommendRequest.request(new DMMtopRequestListener<ProjectRecommendListBean>(ProjectRecommendListBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "32229971")) {
                    ipChange2.ipc$dispatch("32229971", new Object[]{this, str4, str5});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.a(str4, str5);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectRecommendListBean projectRecommendListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1973178418")) {
                    ipChange2.ipc$dispatch("-1973178418", new Object[]{this, projectRecommendListBean});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.b(projectRecommendListBean);
                }
            }
        });
    }
}
