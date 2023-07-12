package cn.damai.trade.newtradeorder.ui.projectdetail.venuemap;

import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface VenueContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void retrieveVenueDetailInfo(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void onRetrieveVenueInfoError(String str, String str2);

        void onRetrieveVenueInfoSuccess(Venue venue);
    }
}
