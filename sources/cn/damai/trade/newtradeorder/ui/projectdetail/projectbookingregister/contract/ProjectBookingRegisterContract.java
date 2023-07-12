package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.ProjectBookingRegisterData;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ProjectBookingRegisterContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void bookingRegisterProject(int i, long j, int i2);

        public abstract void retrieveProjectBookingRegisterData(int i, String str);

        public abstract void updateProjectFollowRelation(int i, long j, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void onBookingRegisterError(String str, String str2);

        void onBookingRegisterSuccess(FollowDataBean followDataBean);

        void onProjectFollowError(String str, String str2);

        void onProjectFollowSuccess(FollowDataBean followDataBean);

        void onReturnBookingRegisterDataError(String str, String str2, String str3);

        void onReturnBookingRegisterDataSuccess(int i, ProjectBookingRegisterData projectBookingRegisterData);
    }
}
