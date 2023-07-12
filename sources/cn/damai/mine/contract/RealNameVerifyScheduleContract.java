package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.mine.bean.RealNameVerifyScheduleBean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface RealNameVerifyScheduleContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void fetchRealNameVerifySchedule();
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseView {
        void fetchRealNameVerifyScheduleFailed(String str, String str2);

        void fetchRealNameVerifyScheduleSuccess(RealNameVerifyScheduleBean realNameVerifyScheduleBean);
    }
}
