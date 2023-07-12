package cn.damai.seat.contract;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ClickedPerform;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.seat.listener.OnPerformListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.seatui.OnJpgRegionUiListener;
import cn.damai.seat.presenter.BaseSeatPresenter;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface RegionContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static abstract class Presenter extends BaseSeatPresenter<RegionView, RegionModel> {
        public abstract void doPerformChanged(@NonNull ClickedPerform clickedPerform);

        public abstract void load(boolean z);

        public abstract void onPriceClick(PriceLevel priceLevel, int i);

        public abstract void onPromotionClick();

        public abstract void onRegionClick(Region region);

        public abstract void refresh();

        public abstract void start(TbParams tbParams);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface RegionModel extends BaseSeatModel {
        void changePerform(@NonNull ClickedPerform clickedPerform, OnPerformListener onPerformListener);

        TbParams createParams2SeatPage(Region region);

        TbParams getParams();

        List<? extends PriceLevel> getPriceList();

        List<Region> getRegions();

        PriceLevel getSelectPrice();

        boolean isLoadFinish();

        void load(boolean z, OnJpgRegionUiListener onJpgRegionUiListener);

        void loadRegionData(long j, SimpleCallBack<RegionData> simpleCallBack);

        void onPriceSelectChanged(PriceLevel priceLevel);

        void prepare(TbParams tbParams, SimpleCallBack<TbParams> simpleCallBack);

        PromotionDataBean promotion();

        void refresh(OnJpgRegionUiListener onJpgRegionUiListener);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface RegionView extends BaseSeatView {
        void openSeatPage(TbParams tbParams);

        void reopenSeatPage(TbParams tbParams, boolean z);

        void showPriceChanged(PriceLevel priceLevel);

        void showRegionView(Bitmap bitmap, List<Region> list, PriceLevel priceLevel, boolean z);
    }
}
