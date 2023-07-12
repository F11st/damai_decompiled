package cn.damai.seat.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.bean.SeatProfile;
import cn.damai.seat.bean.biz.OrderAfterChooseSeatInfo;
import cn.damai.seat.contract.SeatContract;
import cn.damai.seat.listener.Action;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.seatui.OnJpgSeatUiListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.g92;
import tb.q92;
import tb.sm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SeatPresenter extends SeatContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnJpgSeatUiListener mUiListener = new C1685a();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.presenter.SeatPresenter$a */
    /* loaded from: classes7.dex */
    public class C1685a implements OnJpgSeatUiListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.seat.presenter.SeatPresenter$a$a */
        /* loaded from: classes7.dex */
        public class C1686a extends sm1 {
            private static transient /* synthetic */ IpChange $ipChange;

            C1686a() {
            }

            @Override // tb.sm1
            public void a(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1084316454")) {
                    ipChange.ipc$dispatch("1084316454", new Object[]{this, Integer.valueOf(i)});
                } else {
                    SeatPresenter.this.load(true);
                }
            }
        }

        C1685a() {
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void onFail(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1794600473")) {
                ipChange.ipc$dispatch("-1794600473", new Object[]{this, Integer.valueOf(i), str, str2, str3});
                return;
            }
            ((SeatContract.SeatView) SeatPresenter.this.mView).showLoading(false);
            ((SeatContract.SeatView) SeatPresenter.this.mView).showErrorView(str, str2, str3, new C1686a());
        }

        @Override // cn.damai.seat.listener.seatui.OnJpgSeatUiListener
        public void onSelectSeatChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1745271615")) {
                ipChange.ipc$dispatch("1745271615", new Object[]{this});
                return;
            }
            ((SeatContract.SeatView) SeatPresenter.this.mView).invalidateSeatView();
            SeatPresenter.this.updateBottomBar();
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showHeadView(HeadBean headBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-486936564")) {
                ipChange.ipc$dispatch("-486936564", new Object[]{this, headBean});
            } else {
                ((SeatContract.SeatView) SeatPresenter.this.mView).showHeader(headBean);
            }
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, g92 g92Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1324490442")) {
                ipChange.ipc$dispatch("-1324490442", new Object[]{this, list, priceLevel, g92Var});
            } else {
                ((SeatContract.SeatView) SeatPresenter.this.mView).showPriceList(list, g92Var, priceLevel);
            }
        }

        @Override // cn.damai.seat.listener.seatui.OnJpgSeatUiListener
        public void showSeatUi(SeatProfile seatProfile, g92 g92Var, PriceLevel priceLevel, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1223070372")) {
                ipChange.ipc$dispatch("-1223070372", new Object[]{this, seatProfile, g92Var, priceLevel, Boolean.valueOf(z)});
                return;
            }
            if (z) {
                ((SeatContract.SeatView) SeatPresenter.this.mView).hideErrorView();
            }
            ((SeatContract.SeatView) SeatPresenter.this.mView).showSeatView(seatProfile, g92Var, priceLevel, z);
        }

        @Override // cn.damai.seat.listener.seatui.ApiType
        public void toast(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1290217879")) {
                ipChange.ipc$dispatch("1290217879", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            SeatPresenter seatPresenter = SeatPresenter.this;
            Context context = seatPresenter.mContext;
            if (context != null) {
                if (i == R$string.seat_sold_reselect_tip) {
                    ((SeatContract.SeatView) seatPresenter.mView).showBottomToast(context.getString(i));
                } else {
                    ((SeatContract.SeatView) seatPresenter.mView).showErrorTips(context.getString(i));
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.presenter.SeatPresenter$b */
    /* loaded from: classes7.dex */
    public class C1687b implements SimpleCallBack<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1687b() {
        }

        @Override // cn.damai.seat.listener.SimpleCallBack
        /* renamed from: a */
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-149895176")) {
                ipChange.ipc$dispatch("-149895176", new Object[]{this, str});
                return;
            }
            ((SeatContract.SeatView) SeatPresenter.this.mView).showErrorTips("您已进入" + str);
            SeatPresenter.this.load(true);
        }

        @Override // cn.damai.seat.listener.SimpleCallBack
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1559307377")) {
                ipChange.ipc$dispatch("-1559307377", new Object[]{this, str, str2});
                return;
            }
            ((SeatContract.SeatView) SeatPresenter.this.mView).showLoading(false);
            ((SeatContract.SeatView) SeatPresenter.this.mView).showErrorView(str, str2, null, null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.presenter.SeatPresenter$c */
    /* loaded from: classes7.dex */
    public class C1688c implements SeatComputeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1688c() {
        }

        @Override // cn.damai.seat.listener.SeatComputeListener
        public void doNetWork(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2047760506")) {
                ipChange.ipc$dispatch("-2047760506", new Object[]{this, Boolean.valueOf(z)});
            } else {
                ((SeatContract.SeatView) SeatPresenter.this.mView).showLoadingLayer(z);
            }
        }

        @Override // cn.damai.seat.listener.OnPriceBarListener
        public void onPriceBarV2InfoChanged(PriceBarInfo priceBarInfo, @Nullable List<TicketMainUiModel> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1255904474")) {
                ipChange.ipc$dispatch("1255904474", new Object[]{this, priceBarInfo, list});
                return;
            }
            ((SeatContract.SeatView) SeatPresenter.this.mView).showBottomBar(priceBarInfo);
            ((SeatContract.SeatView) SeatPresenter.this.mView).updateSeatListV2Panel(list);
            ((SeatContract.SeatView) SeatPresenter.this.mView).updatePromotionTags(priceBarInfo.usedPromotionList, false);
        }

        @Override // cn.damai.seat.listener.SeatComputeListener
        public void onSeatListChanged(@Nullable List<ItemSeatV2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1535193040")) {
                ipChange.ipc$dispatch("1535193040", new Object[]{this, list});
            } else {
                ((SeatContract.SeatView) SeatPresenter.this.mView).showSeatUiList(((SeatContract.SeatModel) SeatPresenter.this.mModel).getIconProvider(), list);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.presenter.SeatPresenter$d */
    /* loaded from: classes7.dex */
    public class C1689d implements Action {
        private static transient /* synthetic */ IpChange $ipChange;

        C1689d() {
        }

        @Override // cn.damai.seat.listener.Action
        public void call() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "405714396")) {
                ipChange.ipc$dispatch("405714396", new Object[]{this});
                return;
            }
            SeatPresenter seatPresenter = SeatPresenter.this;
            ((SeatContract.SeatView) seatPresenter.mView).showPriceChanged(((SeatContract.SeatModel) seatPresenter.mModel).getSelectPrice(), false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.presenter.SeatPresenter$e */
    /* loaded from: classes7.dex */
    public class C1690e implements OnSubmitListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1690e() {
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void doNetWork(boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1050165172")) {
                ipChange.ipc$dispatch("-1050165172", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (z2) {
                ((SeatContract.SeatView) SeatPresenter.this.mView).showLoading(z);
            } else {
                ((SeatContract.SeatView) SeatPresenter.this.mView).showLoadingLayer(z);
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onOpenPurchase(@Nullable Bundle bundle) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1676817885")) {
                ipChange.ipc$dispatch("-1676817885", new Object[]{this, bundle});
            } else {
                ((SeatContract.SeatView) SeatPresenter.this.mView).onOpenPurchaseActivity(bundle);
            }
        }

        @Override // cn.damai.seat.listener.OnPriceBarListener
        public void onPriceBarV2InfoChanged(PriceBarInfo priceBarInfo, @Nullable List<TicketMainUiModel> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1496144220")) {
                ipChange.ipc$dispatch("1496144220", new Object[]{this, priceBarInfo, list});
                return;
            }
            ((SeatContract.SeatView) SeatPresenter.this.mView).showBottomBar(priceBarInfo);
            ((SeatContract.SeatView) SeatPresenter.this.mView).updateSeatListV2Panel(list);
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onSubmitFailed(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-462552987")) {
                ipChange.ipc$dispatch("-462552987", new Object[]{this, str, str2, str3});
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void onSubmitSuccess(String str, OrderAfterChooseSeatInfo orderAfterChooseSeatInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1394833232")) {
                ipChange.ipc$dispatch("1394833232", new Object[]{this, str, orderAfterChooseSeatInfo});
            }
        }

        @Override // cn.damai.seat.listener.OnSubmitListener
        public void seatPreLockFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "309696745")) {
                ipChange.ipc$dispatch("309696745", new Object[]{this});
            } else {
                SeatPresenter.this.refresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBottomBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388006817")) {
            ipChange.ipc$dispatch("388006817", new Object[]{this});
        } else {
            ((SeatContract.SeatModel) this.mModel).computeSeat(new C1688c());
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void load(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "74813776")) {
            ipChange.ipc$dispatch("74813776", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((SeatContract.SeatView) this.mView).showLoading(true);
        ((SeatContract.SeatModel) this.mModel).load(z, this.mUiListener);
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onConfirmClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1020175075")) {
            ipChange.ipc$dispatch("1020175075", new Object[]{this});
            return;
        }
        TbParams params = ((SeatContract.SeatModel) this.mModel).getParams();
        q92.n().g(params.itemId, params.performId);
        ((SeatContract.SeatModel) this.mModel).submitSeat(new C1690e());
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onPriceClick(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-811585492")) {
            ipChange.ipc$dispatch("-811585492", new Object[]{this, priceLevel, Integer.valueOf(i)});
            return;
        }
        if (priceLevel != null) {
            q92.n().i("seatselect", ((SeatContract.SeatModel) this.mModel).getParams().itemId, i, priceLevel.originalPrice(), priceLevel.getPriceType());
        }
        ((SeatContract.SeatModel) this.mModel).changePrice(priceLevel, i);
        ((SeatContract.SeatView) this.mView).showPriceChanged(((SeatContract.SeatModel) this.mModel).getSelectPrice(), true);
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onPromotionClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889318982")) {
            ipChange.ipc$dispatch("1889318982", new Object[]{this});
            return;
        }
        PromotionDataBean promotion = ((SeatContract.SeatModel) this.mModel).promotion();
        if (promotion != null) {
            TbParams params = ((SeatContract.SeatModel) this.mModel).getParams();
            q92.n().h("seatselect", params.itemId, params.performId);
            ((SeatContract.SeatView) this.mView).showPromotionFragment(promotion);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void onSeatChanged(SeatNew seatNew, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930169967")) {
            ipChange.ipc$dispatch("1930169967", new Object[]{this, seatNew, Boolean.valueOf(z)});
        } else if (((SeatContract.SeatModel) this.mModel).changeSeat(seatNew, z, new C1689d())) {
            if (z) {
                q92.n().l(((SeatContract.SeatModel) this.mModel).getParams().itemId, seatNew.sid);
            }
            ((SeatContract.SeatView) this.mView).invalidateSeatView();
            ((SeatContract.SeatView) this.mView).showDiffRowView(((SeatContract.SeatModel) this.mModel).shouldShowDiffRowTip());
            updateBottomBar();
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32756069")) {
            ipChange.ipc$dispatch("32756069", new Object[]{this});
        } else if (((SeatContract.SeatModel) this.mModel).isLoadFinish()) {
            ((SeatContract.SeatView) this.mView).showLoading(true);
            ((SeatContract.SeatModel) this.mModel).refresh(this.mUiListener);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.Presenter
    public void start(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231957872")) {
            ipChange.ipc$dispatch("-1231957872", new Object[]{this, tbParams});
        } else {
            ((SeatContract.SeatModel) this.mModel).prepare(tbParams, new C1687b());
        }
    }
}
