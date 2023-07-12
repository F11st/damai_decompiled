package cn.damai.seat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.ShortTag;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.bean.SeatProfile;
import cn.damai.seat.contract.SeatContract;
import cn.damai.seat.helper.SeatListLayerPanel;
import cn.damai.seat.helper.SeatListV2Panel;
import cn.damai.seat.helper.SeatLoadingPanel;
import cn.damai.seat.helper.SeatPriceListPanel;
import cn.damai.seat.listener.OnSeatRemoveListener;
import cn.damai.seat.model.SeatModel;
import cn.damai.seat.presenter.SeatPresenter;
import cn.damai.seat.view.SeatView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.monitor.procedure.ViewToken;
import java.util.List;
import tb.f92;
import tb.g92;
import tb.q92;
import tb.r92;
import tb.u82;
import tb.w6;
import tb.xp1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SeatActivity extends BaseSeatActivity<SeatPresenter, SeatModel> implements SeatContract.SeatView {
    private static transient /* synthetic */ IpChange $ipChange;
    private u82 mBottomPanel;
    private ViewGroup mFgContainer;
    private SeatLoadingPanel mLoadingPanel;
    private ViewGroup mMainView;
    private TbParams mParams;
    private SeatListLayerPanel mPriceDetailPopUpPanel;
    private SeatListV2Panel mSeatListV2HolScrollPanel;
    private SeatView mSeatView;
    private FrameLayout mViewContainer;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.SeatActivity$a */
    /* loaded from: classes7.dex */
    public class C1703a extends u82 {
        private static transient /* synthetic */ IpChange $ipChange;

        C1703a(Activity activity, View view) {
            super(activity, view);
        }

        @Override // tb.u82
        public void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1262941053")) {
                ipChange.ipc$dispatch("-1262941053", new Object[]{this});
            } else {
                ((SeatPresenter) SeatActivity.this.mPresenter).onConfirmClick();
            }
        }

        @Override // tb.u82
        public void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1741960897")) {
                ipChange.ipc$dispatch("1741960897", new Object[]{this});
            } else {
                SeatActivity.this.mPriceDetailPopUpPanel.h(!SeatActivity.this.mPriceDetailPopUpPanel.d());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.SeatActivity$b */
    /* loaded from: classes7.dex */
    public class C1704b implements SeatListLayerPanel.OnPanelStateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1704b() {
        }

        @Override // cn.damai.seat.helper.SeatListLayerPanel.OnPanelStateListener
        public void onExpandChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "566112304")) {
                ipChange.ipc$dispatch("566112304", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            if (z && SeatActivity.this.mParams != null) {
                q92.n().k(SeatActivity.this.mParams.itemId, SeatActivity.this.mParams.performId);
            }
            SeatActivity.this.mBottomPanel.d(!z);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.SeatActivity$c */
    /* loaded from: classes7.dex */
    public class C1705c implements OnSeatRemoveListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1705c() {
        }

        @Override // cn.damai.seat.listener.OnSeatRemoveListener
        public void onSeatRemove(SeatNew seatNew) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1828358351")) {
                ipChange.ipc$dispatch("-1828358351", new Object[]{this, seatNew});
            } else {
                ((SeatPresenter) SeatActivity.this.mPresenter).onSeatChanged(seatNew, false);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.ui.SeatActivity$d */
    /* loaded from: classes7.dex */
    public class C1706d implements SeatView.OnSeatClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1706d() {
        }

        @Override // cn.damai.seat.view.SeatView.OnSeatClickListener
        public void onSeatClick(SeatNew seatNew, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "351001496")) {
                ipChange.ipc$dispatch("351001496", new Object[]{this, seatNew, Boolean.valueOf(z)});
            } else if (r92.c()) {
            } else {
                ((SeatPresenter) SeatActivity.this.mPresenter).onSeatChanged(seatNew, z);
            }
        }
    }

    public static void open(Activity activity, TbParams tbParams, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627164108")) {
            ipChange.ipc$dispatch("1627164108", new Object[]{activity, tbParams, Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent(activity, SeatActivity.class);
        intent.putExtra("EXTRA_DATA", tbParams);
        activity.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734581642")) {
            ipChange.ipc$dispatch("734581642", new Object[]{this});
            return;
        }
        super.finish();
        if (w6.b().c() instanceof RegionActivity) {
            overridePendingTransition(-1, -1);
        }
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public ViewGroup getFragmentContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1619022317") ? (ViewGroup) ipChange.ipc$dispatch("-1619022317", new Object[]{this}) : this.mFgContainer;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-907690587") ? ((Integer) ipChange.ipc$dispatch("-907690587", new Object[]{this})).intValue() : R$layout.activity_seat;
    }

    @Override // cn.damai.seat.contract.BaseSeatView
    public ViewGroup getMainView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2009299716") ? (ViewGroup) ipChange.ipc$dispatch("-2009299716", new Object[]{this}) : this.mMainView;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928817547")) {
            ipChange.ipc$dispatch("-928817547", new Object[]{this});
        } else {
            ((SeatPresenter) this.mPresenter).setVM(this, (SeatContract.SeatModel) this.mModel);
        }
    }

    @Override // cn.damai.seat.ui.BaseSeatActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037691144")) {
            ipChange.ipc$dispatch("2037691144", new Object[]{this});
            return;
        }
        super.initView();
        this.mMainView = (ViewGroup) findViewById(R$id.main_view);
        this.mFgContainer = (ViewGroup) findViewById(R$id.promotion_container);
        this.mViewContainer = (FrameLayout) findViewById(R$id.seat_view_container);
        this.mFgContainer.setOnClickListener(this);
        View findViewById = findViewById(R$id.seat_jpg_bottom_bar);
        View findViewById2 = findViewById(R$id.seat_select_container);
        View findViewById3 = findViewById(R$id.bottom_bar_top_divide_line);
        this.mBottomPanel = new C1703a(this, findViewById);
        this.mPriceDetailPopUpPanel = new SeatListLayerPanel(this, (ViewStub) findViewById(R$id.seat_selected_list_new_layer_stub), new C1704b());
        this.mSeatListV2HolScrollPanel = new SeatListV2Panel(this, findViewById2, findViewById3, new C1705c());
        this.mLoadingPanel = new SeatLoadingPanel((ViewStub) findViewById(R$id.loading_layer_stub));
        TbParams tbParams = (TbParams) obtainExtra();
        this.mParams = tbParams;
        if (tbParams != null) {
            ((SeatPresenter) this.mPresenter).start(tbParams);
            this.mSeatListV2HolScrollPanel.i(this.mParams);
            setDamaiUTKeyBuilder(q92.o(this.mParams.itemId));
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void invalidateSeatView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869439944")) {
            ipChange.ipc$dispatch("-869439944", new Object[]{this});
            return;
        }
        SeatView seatView = this.mSeatView;
        if (seatView != null) {
            seatView.invalidate();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571277935")) {
            ipChange.ipc$dispatch("-571277935", new Object[]{this});
            return;
        }
        SeatListLayerPanel seatListLayerPanel = this.mPriceDetailPopUpPanel;
        if (seatListLayerPanel != null && seatListLayerPanel.d()) {
            this.mPriceDetailPopUpPanel.h(false);
        } else if (dismissFragment(this.mFragment, this.mFgContainer)) {
        } else {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858532590")) {
            ipChange.ipc$dispatch("858532590", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.tb_seat_tip_close) {
            showDiffRowView(false);
        } else if (id == R$id.header_promotion_desc) {
            ((SeatPresenter) this.mPresenter).onPromotionClick();
        } else if (id == R$id.promotion_container) {
            dismissFragment(this.mFragment, this.mFgContainer);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void onOpenPurchaseActivity(Bundle bundle) {
        TbParams tbParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205077008")) {
            ipChange.ipc$dispatch("205077008", new Object[]{this, bundle});
        } else if (bundle == null || (tbParams = this.mParams) == null) {
        } else {
            xp1.a(this, bundle, tbParams.isUseNewUltron);
        }
    }

    @Override // cn.damai.seat.ui.BaseSeatActivity
    public void onSeatPriceClick(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "261249566")) {
            ipChange.ipc$dispatch("261249566", new Object[]{this, priceLevel, Integer.valueOf(i)});
        } else {
            ((SeatPresenter) this.mPresenter).onPriceClick(priceLevel, i);
        }
    }

    @Override // cn.damai.seat.ui.BaseSeatActivity
    public void onUIResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797945283")) {
            ipChange.ipc$dispatch("-797945283", new Object[]{this});
        } else {
            ((SeatPresenter) this.mPresenter).refresh();
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void showBottomBar(PriceBarInfo priceBarInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235950185")) {
            ipChange.ipc$dispatch("-1235950185", new Object[]{this, priceBarInfo});
        } else {
            this.mBottomPanel.e(priceBarInfo);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void showDiffRowView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-219812956")) {
            ipChange.ipc$dispatch("-219812956", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void showLoadingLayer(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540441481")) {
            ipChange.ipc$dispatch("540441481", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mLoadingPanel.d(z);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void showPriceChanged(PriceLevel priceLevel, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9349460")) {
            ipChange.ipc$dispatch("9349460", new Object[]{this, priceLevel, Boolean.valueOf(z)});
            return;
        }
        SeatPriceListPanel seatPriceListPanel = this.mListPanel;
        if (seatPriceListPanel != null) {
            seatPriceListPanel.n(priceLevel);
        }
        if (this.mSeatView != null) {
            long o = f92.o(priceLevel);
            if (z) {
                this.mSeatView.setSelectedPriceIdAndZoomToSeat(o);
            } else {
                this.mSeatView.setSelectedPriceId(o);
            }
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void showSeatUiList(g92 g92Var, List<ItemSeatV2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176264917")) {
            ipChange.ipc$dispatch("-176264917", new Object[]{this, g92Var, list});
            return;
        }
        SeatListV2Panel seatListV2Panel = this.mSeatListV2HolScrollPanel;
        if (seatListV2Panel != null) {
            seatListV2Panel.n(g92Var, list);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void showSeatView(SeatProfile seatProfile, g92 g92Var, PriceLevel priceLevel, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514534937")) {
            ipChange.ipc$dispatch("-1514534937", new Object[]{this, seatProfile, g92Var, priceLevel, Boolean.valueOf(z)});
            return;
        }
        if (this.mSeatView == null && z) {
            SeatView seatView = new SeatView(this);
            this.mSeatView = seatView;
            seatView.setTag(ViewToken.APM_VIEW_TOKEN, ViewToken.APM_VIEW_VALID);
            this.mSeatView.setData(seatProfile);
            this.mSeatView.setProvider(g92Var);
            this.mSeatView.init(this.mContext);
            this.mSeatView.setListener(new C1706d());
            this.mViewContainer.removeAllViews();
            this.mViewContainer.addView(this.mSeatView, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.mSeatView != null) {
            this.mSeatView.setSelectedPriceId(f92.o(priceLevel));
            if (z) {
                this.mSeatView.invalidate();
            }
        }
        if (z) {
            showLoading(false);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void updatePromotionTags(List<ShortTag> list, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523675575")) {
            ipChange.ipc$dispatch("-1523675575", new Object[]{this, list, Boolean.valueOf(z)});
            return;
        }
        SeatListV2Panel seatListV2Panel = this.mSeatListV2HolScrollPanel;
        if (seatListV2Panel != null) {
            seatListV2Panel.m(list, z);
        }
    }

    @Override // cn.damai.seat.contract.SeatContract.SeatView
    public void updateSeatListV2Panel(List<TicketMainUiModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000014526")) {
            ipChange.ipc$dispatch("-2000014526", new Object[]{this, list});
            return;
        }
        SeatListLayerPanel seatListLayerPanel = this.mPriceDetailPopUpPanel;
        if (seatListLayerPanel != null) {
            seatListLayerPanel.i(list);
        }
    }
}
