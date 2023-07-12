package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.presenter;

import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.repository.ProjectBookingRegisterRepository;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w12;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectBookingRegisterPresenter extends ProjectBookingRegisterContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectBookingRegisterRepository mBookingRegisterRepository = new ProjectBookingRegisterRepository();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.presenter.ProjectBookingRegisterPresenter$a */
    /* loaded from: classes8.dex */
    public class C2253a extends w12<ProjectBookingRegisterData> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        C2253a(int i) {
            this.a = i;
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1281879040")) {
                ipChange.ipc$dispatch("-1281879040", new Object[]{this, str, str2});
            } else {
                ((ProjectBookingRegisterContract.View) ProjectBookingRegisterPresenter.this.mView).onReturnBookingRegisterDataError(str, str2, "mtop.damai.item.projectdetail.projectid.get");
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(ProjectBookingRegisterData projectBookingRegisterData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-988235945")) {
                ipChange.ipc$dispatch("-988235945", new Object[]{this, projectBookingRegisterData});
            } else if (projectBookingRegisterData != null) {
                ((ProjectBookingRegisterContract.View) ProjectBookingRegisterPresenter.this.mView).onReturnBookingRegisterDataSuccess(this.a, projectBookingRegisterData);
            } else {
                ((ProjectBookingRegisterContract.View) ProjectBookingRegisterPresenter.this.mView).onReturnBookingRegisterDataError("", "", "mtop.damai.item.projectdetail.projectid.get");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.presenter.ProjectBookingRegisterPresenter$b */
    /* loaded from: classes8.dex */
    public class C2254b extends w12<FollowDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2254b() {
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1289638399")) {
                ipChange.ipc$dispatch("-1289638399", new Object[]{this, str, str2});
            } else {
                ((ProjectBookingRegisterContract.View) ProjectBookingRegisterPresenter.this.mView).onProjectFollowError(str, str2);
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(FollowDataBean followDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1667386561")) {
                ipChange.ipc$dispatch("-1667386561", new Object[]{this, followDataBean});
            } else {
                ((ProjectBookingRegisterContract.View) ProjectBookingRegisterPresenter.this.mView).onProjectFollowSuccess(followDataBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.presenter.ProjectBookingRegisterPresenter$c */
    /* loaded from: classes8.dex */
    public class C2255c extends w12<FollowDataBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2255c() {
        }

        @Override // tb.w12
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1297397758")) {
                ipChange.ipc$dispatch("-1297397758", new Object[]{this, str, str2});
            } else {
                ((ProjectBookingRegisterContract.View) ProjectBookingRegisterPresenter.this.mView).onBookingRegisterError(str, str2);
            }
        }

        @Override // tb.w12
        /* renamed from: c */
        public void b(FollowDataBean followDataBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "957067166")) {
                ipChange.ipc$dispatch("957067166", new Object[]{this, followDataBean});
            } else {
                ((ProjectBookingRegisterContract.View) ProjectBookingRegisterPresenter.this.mView).onBookingRegisterSuccess(followDataBean);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.Presenter
    public void bookingRegisterProject(int i, long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250124861")) {
            ipChange.ipc$dispatch("-1250124861", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        } else {
            this.mBookingRegisterRepository.updateFollowRelation(i, j, i2, new C2255c());
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.Presenter
    public void retrieveProjectBookingRegisterData(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1205834150")) {
            ipChange.ipc$dispatch("-1205834150", new Object[]{this, Integer.valueOf(i), str});
        } else {
            this.mBookingRegisterRepository.retrieveProjectBookingRegisterData(str, new C2253a(i));
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract.ProjectBookingRegisterContract.Presenter
    public void updateProjectFollowRelation(int i, long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542464913")) {
            ipChange.ipc$dispatch("542464913", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        } else {
            this.mBookingRegisterRepository.updateFollowRelation(i, j, i2, new C2254b());
        }
    }
}
