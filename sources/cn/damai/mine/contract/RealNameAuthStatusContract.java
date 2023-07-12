package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.mine.bean.RealNameVerifyBean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface RealNameAuthStatusContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getAuthResult();

        public abstract void getFaceVerifyToken(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseView {
        void faceVerifing();

        void faceVerifySuccess();

        void getAuthStatus(RealNameAuthStatusBean realNameAuthStatusBean);

        void getAuthStatusFailed(String str, String str2);

        void getFaceVerifyTokenFailed(String str, String str2);

        void getFaceVerifyTokenSuccess(RealNameVerifyBean realNameVerifyBean);
    }
}
