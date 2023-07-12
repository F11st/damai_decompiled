package cn.damai.seat.contract;

import android.os.Bundle;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.ShortTag;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.bean.SeatProfile;
import cn.damai.seat.listener.Action;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.seatui.OnJpgSeatUiListener;
import cn.damai.seat.presenter.BaseSeatPresenter;
import java.util.List;
import tb.g92;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface SeatContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static abstract class Presenter extends BaseSeatPresenter<SeatView, SeatModel> {
        public abstract void load(boolean z);

        public abstract void onConfirmClick();

        public abstract void onPriceClick(PriceLevel priceLevel, int i);

        public abstract void onPromotionClick();

        public abstract void onSeatChanged(SeatNew seatNew, boolean z);

        public abstract void refresh();

        public abstract void start(TbParams tbParams);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface SeatModel extends BaseSeatModel {
        boolean changePrice(PriceLevel priceLevel, int i);

        boolean changeSeat(SeatNew seatNew, boolean z, Action action);

        void computeSeat(SeatComputeListener seatComputeListener);

        TbParams getParams();

        List<PriceLevel> getPriceList();

        SeatProfile getSeatInfo();

        PriceLevel getSelectPrice();

        boolean isLoadFinish();

        void load(boolean z, OnJpgSeatUiListener onJpgSeatUiListener);

        void prepare(TbParams tbParams, SimpleCallBack<String> simpleCallBack);

        PromotionDataBean promotion();

        void refresh(OnJpgSeatUiListener onJpgSeatUiListener);

        boolean shouldShowDiffRowTip();

        void submitSeat(OnSubmitListener onSubmitListener);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface SeatView extends BaseSeatView {
        void invalidateSeatView();

        void onOpenPurchaseActivity(Bundle bundle);

        void showBottomBar(PriceBarInfo priceBarInfo);

        void showDiffRowView(boolean z);

        void showLoadingLayer(boolean z);

        void showPriceChanged(PriceLevel priceLevel, boolean z);

        void showSeatUiList(g92 g92Var, List<ItemSeatV2> list);

        void showSeatView(SeatProfile seatProfile, g92 g92Var, PriceLevel priceLevel, boolean z);

        void updatePromotionTags(List<ShortTag> list, boolean z);

        void updateSeatListV2Panel(List<TicketMainUiModel> list);
    }
}
