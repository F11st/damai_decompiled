package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuSaveInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuItem;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendListBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.repository.ProjectItemRepository;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.rd2;
import tb.w12;
import tb.zn2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectItemPresenter extends ProjectItemContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectItemRepository mRepository = new ProjectItemRepository();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter$a */
    /* loaded from: classes8.dex */
    public class C2277a extends w12<ProjectDetailDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        C2277a(int i) {
            this.a = i;
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1773556509")) {
                ipChange.ipc$dispatch("-1773556509", new Object[]{this, str, str2});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onNetError(str, str2, "mtop.alibaba.damai.detail.getdetail");
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(ProjectDetailDataBean projectDetailDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "516733661")) {
                ipChange.ipc$dispatch("516733661", new Object[]{this, projectDetailDataBean});
                return;
            }
            ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnProjectDetailDataSuccess(this.a, projectDetailDataBean);
            ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onNetSuccess();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter$b */
    /* loaded from: classes8.dex */
    public class C2278b extends w12<ProjectInformationBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2278b() {
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1781315868")) {
                ipChange.ipc$dispatch("-1781315868", new Object[]{this, str, str2});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnProjectNATDataFail(str, str2);
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(ProjectInformationBean projectInformationBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-367374611")) {
                ipChange.ipc$dispatch("-367374611", new Object[]{this, projectInformationBean});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnProjectNATDataSuccess(projectInformationBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter$c */
    /* loaded from: classes8.dex */
    public class C2279c extends w12<ProjectRecommendListBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2279c() {
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1796834586")) {
                ipChange.ipc$dispatch("-1796834586", new Object[]{this, str, str2});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnProjectRecommendError(str, str2);
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(ProjectRecommendListBean projectRecommendListBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1244877089")) {
                ipChange.ipc$dispatch("1244877089", new Object[]{this, projectRecommendListBean});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnProjectRecommendSuccess(projectRecommendListBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter$d */
    /* loaded from: classes8.dex */
    public class C2280d extends w12<ProjectDetailCommentBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2280d() {
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1804593945")) {
                ipChange.ipc$dispatch("-1804593945", new Object[]{this, str, str2});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnProjectDetailCommentError(str, str2);
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(ProjectDetailCommentBean projectDetailCommentBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-549881732")) {
                ipChange.ipc$dispatch("-549881732", new Object[]{this, projectDetailCommentBean});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnProjectDetailCommentSuccess(projectDetailCommentBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter$e */
    /* loaded from: classes8.dex */
    public class C2281e extends w12<ProjectDetailCommentBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2281e() {
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1812353304")) {
                ipChange.ipc$dispatch("-1812353304", new Object[]{this, str, str2});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onRetrieveDiscussionError(str, str2);
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(ProjectDetailCommentBean projectDetailCommentBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-991636227")) {
                ipChange.ipc$dispatch("-991636227", new Object[]{this, projectDetailCommentBean});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onRetrieveDiscussionSuccess(projectDetailCommentBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter$f */
    /* loaded from: classes8.dex */
    public class C2282f extends w12<FollowDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2282f() {
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1820112663")) {
                ipChange.ipc$dispatch("-1820112663", new Object[]{this, str, str2});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onUpdateProjectFollowStatusError(str, str2);
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(FollowDataBean followDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1010573143")) {
                ipChange.ipc$dispatch("1010573143", new Object[]{this, followDataBean});
            } else {
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onUpdateProjectFollowStatusSuccess(followDataBean);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectDetailData(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545230092")) {
            ipChange.ipc$dispatch("1545230092", new Object[]{this, Integer.valueOf(i), str});
        } else {
            this.mRepository.retrieveProjectItemData(str, new C2277a(i));
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectDetailDiscussion(long j, long j2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030420371")) {
            ipChange.ipc$dispatch("-2030420371", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str});
        } else {
            this.mRepository.retrieveDiscussions(j, j2, str, 1, 1, 3, new C2281e());
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectDetailEvaluates(long j, long j2, String str, int i, int i2, int i3, int i4, boolean z, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210733553")) {
            ipChange.ipc$dispatch("-210733553", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), str2});
        } else {
            this.mRepository.retrieveEvaluates(j, j2, str, i, i2, i3, i4, z, str2, new C2280d());
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getProjectNATData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1164314669")) {
            ipChange.ipc$dispatch("1164314669", new Object[]{this, str});
        } else {
            this.mRepository.retrieveProjectNATData(str, new C2278b());
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getRecommendProjectList(String str, String str2, double d, double d2, int i, int i2, String str3, boolean z, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273248569")) {
            ipChange.ipc$dispatch("-273248569", new Object[]{this, str, str2, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), str3, Boolean.valueOf(z), Integer.valueOf(i3)});
        } else {
            this.mRepository.retrieveRecommendProject(str, str2, d, d2, i, i2, str3, z, i3, new C2279c());
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void getSubProjectDetailCheckData(String str, String str2) {
        SkuSaveInfo skuSaveInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833332351")) {
            ipChange.ipc$dispatch("-1833332351", new Object[]{this, str, str2});
            return;
        }
        try {
            skuSaveInfo = rd2.a(Long.parseLong(str));
        } catch (Exception unused) {
            skuSaveInfo = null;
        }
        SkuRequest skuRequest = new SkuRequest();
        skuRequest.itemId = str;
        if (skuSaveInfo != null) {
            SkuItem skuItem = skuRequest.exParams;
            skuItem.dataId = skuSaveInfo.dataId;
            skuItem.dataType = "2";
        } else {
            SkuItem skuItem2 = skuRequest.exParams;
            skuItem2.dataId = null;
            skuItem2.dataType = null;
        }
        if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
            skuRequest.exParams.privilegeActId = str2;
        }
        zn2.c();
        skuRequest.request(new DMMtopResultRequestListener<SkuBean>(SkuBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.presenter.ProjectItemPresenter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1789075227")) {
                    ipChange2.ipc$dispatch("-1789075227", new Object[]{this, str3, str4});
                } else {
                    ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnSkuBeanDataFail(str3, str4);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(SkuBean skuBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1597573351")) {
                    ipChange2.ipc$dispatch("1597573351", new Object[]{this, skuBean});
                    return;
                }
                zn2.b();
                ((ProjectItemContract.View) ProjectItemPresenter.this.mView).onReturnSkuBeanDataSuccess(skuBean);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract.ProjectItemContract.Presenter
    public void updateProjectFollowRelation(int i, long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120516020")) {
            ipChange.ipc$dispatch("120516020", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        } else {
            this.mRepository.updateFollowRelation(i, j, i2, new C2282f());
        }
    }
}
