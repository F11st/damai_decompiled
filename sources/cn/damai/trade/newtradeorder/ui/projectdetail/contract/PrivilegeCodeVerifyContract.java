package cn.damai.trade.newtradeorder.ui.projectdetail.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.PrivilegeVerifyBean;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface PrivilegeCodeVerifyContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void verifyAndSignPrivilegeCode(String str, String str2, int i, long j, long j2, String str3);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseView {
        void onReturnVerifyPrivilegeCodeResultError(String str, String str2);

        void onReturnVerifyPrivilegeCodeResultSuccess(PrivilegeVerifyBean privilegeVerifyBean);
    }
}
