package cn.damai.mine.contract;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.AcquireScoreDto;
import cn.damai.mine.bean.LostScoreDto;
import cn.damai.mine.bean.UserScoreDto;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IntegralContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void requestIntegralList();

        public abstract void requestPointsIntegral(String str);

        public abstract void requestSumptionIntegral(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends BaseDamaiView {
        void returnIntegralList(UserScoreDto userScoreDto);

        void returnPointsIntegral(AcquireScoreDto acquireScoreDto);

        void returnSumptionIntegral(LostScoreDto lostScoreDto);
    }
}
