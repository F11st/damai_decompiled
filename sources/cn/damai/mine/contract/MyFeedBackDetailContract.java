package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.MyFeedBackDetail;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface MyFeedBackDetailContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void getFeedBackList(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseDamaiView {
        @Override // cn.damai.commonbusiness.base.BaseDamaiView
        void onNetError(String str, String str2, String str3);

        @Override // cn.damai.commonbusiness.base.BaseDamaiView
        void onNetSuccess();

        void returnFeedBack(MyFeedBackDetail myFeedBackDetail);
    }
}
