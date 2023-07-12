package cn.damai.ticklet.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.EmptyDataVO;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TicketSouvenirDetail;
import cn.damai.ticklet.bean.TicketSouvenirInfo;
import cn.damai.ticklet.bean.TicketSouvenirParams;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.activity.TicketSouvenirViewModel;
import cn.damai.ticklet.ui.activity.TickletVenueActivity;
import cn.damai.ticklet.ui.fragment.TickletDialogShowFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.j62;
import tb.kg2;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TicketSouvenirFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView funTitle;
    private ViewGroup mBodyLayout;
    private LinearLayout mErrorView;
    private TextView mFuncNoteTv;
    private ViewGroup mItemExchangeSiteVg;
    private ViewGroup mItemTicketsVg;
    private LinearLayout mLvTitleLayout;
    private TextView mOpenTimeTv;
    private TicketSouvenirParams mParams;
    private TextView mStyleOneDescTv;
    private ViewGroup mStyleOneLayout;
    private TextView mStyleOneTitleTv;
    private TickletDialogShowFragment mTicketShowFragment;
    private View mTicketShowLayout;
    private TextView mTopStateTv;
    private TextView mTvTitle;
    private TextView mTvTitleRightBtn;
    private TicketSouvenirViewModel mViewModel;
    private View mViewStatusBarSpace;
    private View mViewTitleBack;
    private TextView openTimeDesc;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1928242137")) {
                ipChange.ipc$dispatch("1928242137", new Object[]{this, view});
            } else {
                TicketSouvenirFragment.this.quitStepByStep();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements TickletDialogShowFragment.OnClickCloseListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.OnClickCloseListener
        public void onClose(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1959285637")) {
                ipChange.ipc$dispatch("-1959285637", new Object[]{this, Integer.valueOf(i)});
            } else {
                TicketSouvenirFragment.this.closeTicketFragmentPopLayer();
            }
        }

        @Override // cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.OnClickCloseListener
        public void updateTicketSate(UserTicketTable userTicketTable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1377407624")) {
                ipChange.ipc$dispatch("1377407624", new Object[]{this, userTicketTable});
            }
        }
    }

    private void addLiveDataObserver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757024165")) {
            ipChange.ipc$dispatch("757024165", new Object[]{this});
            return;
        }
        this.mViewModel.mSouvenirLiveData.observe(this, new Observer<TicketSouvenirDetail>() { // from class: cn.damai.ticklet.ui.fragment.TicketSouvenirFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable TicketSouvenirDetail ticketSouvenirDetail) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-381017856")) {
                    ipChange2.ipc$dispatch("-381017856", new Object[]{this, ticketSouvenirDetail});
                    return;
                }
                TicketSouvenirFragment.this.stopProgressDialog();
                if (ticketSouvenirDetail == null || ticketSouvenirDetail.souvenirVO == null) {
                    TicketSouvenirFragment.this.mErrorView.setVisibility(0);
                    TicketSouvenirFragment ticketSouvenirFragment = TicketSouvenirFragment.this;
                    EmptyDataVO emptyDataVO = ticketSouvenirDetail.emptyDataVO;
                    ticketSouvenirFragment.onResponseError(emptyDataVO != null ? emptyDataVO.emptyDataMsg : "", null, "mtop.damai.wireless.ticklet2.souvenir.detail.get", ticketSouvenirFragment.mErrorView, true);
                    return;
                }
                TicketSouvenirFragment.this.updateUI(ticketSouvenirDetail);
            }
        });
        this.mViewModel.mNetLiveData.observe(this, new Observer<String>() { // from class: cn.damai.ticklet.ui.fragment.TicketSouvenirFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "178316537")) {
                    ipChange2.ipc$dispatch("178316537", new Object[]{this, str});
                    return;
                }
                TicketSouvenirFragment.this.stopProgressDialog();
                TicketSouvenirFragment.this.mErrorView.setVisibility(0);
                TicketSouvenirFragment ticketSouvenirFragment = TicketSouvenirFragment.this;
                ticketSouvenirFragment.onResponseError(str, null, "mtop.damai.wireless.ticklet2.souvenir.detail.get", ticketSouvenirFragment.mErrorView, true);
            }
        });
    }

    private void bindView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "933766166")) {
            ipChange.ipc$dispatch("933766166", new Object[]{this});
            return;
        }
        this.mErrorView = (LinearLayout) this.rootView.findViewById(R$id.ticket_souvenir_error_v);
        this.mBodyLayout = (ViewGroup) this.rootView.findViewById(R$id.ticket_souvenir_body_layout);
        this.funTitle = (TextView) this.rootView.findViewById(R$id.ticket_souvenir_body_title);
        this.mTopStateTv = (TextView) this.rootView.findViewById(R$id.ticket_souvenir_top_note);
        this.mFuncNoteTv = (TextView) this.rootView.findViewById(R$id.ticket_souvenir_func_note);
        this.openTimeDesc = (TextView) this.rootView.findViewById(R$id.ticket_souvenir_body_time_desc);
        this.mOpenTimeTv = (TextView) this.rootView.findViewById(R$id.ticket_souvenir_openTime);
        this.mStyleOneLayout = (ViewGroup) this.rootView.findViewById(R$id.ticket_exchange_style_1_layout);
        this.mStyleOneTitleTv = (TextView) this.rootView.findViewById(R$id.ticket_souvenir_style_1_name);
        this.mStyleOneDescTv = (TextView) this.rootView.findViewById(R$id.ticket_souvenir_style_1_desc);
        this.mItemTicketsVg = (ViewGroup) this.mStyleOneLayout.findViewById(R$id.ticket_souvenir_ticket_layout);
        this.mItemExchangeSiteVg = (ViewGroup) this.mStyleOneLayout.findViewById(R$id.ticket_souvenir_exchange_site_layout);
        this.mTicketShowLayout = this.rootView.findViewById(R$id.ticket_souvenir_fg_container);
        this.mItemExchangeSiteVg.setOnClickListener(this);
        this.mItemTicketsVg.setOnClickListener(this);
        this.mTicketShowLayout.setOnClickListener(this);
    }

    private void initExtraData() {
        Serializable serializable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060343800")) {
            ipChange.ipc$dispatch("-1060343800", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null || (serializable = arguments.getSerializable("souvenir_params")) == null) {
            return;
        }
        this.mParams = (TicketSouvenirParams) serializable;
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707495397")) {
            ipChange.ipc$dispatch("1707495397", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R$id.ticket_souvenir_header);
        this.mLvTitleLayout = linearLayout;
        this.mViewStatusBarSpace = linearLayout.findViewById(R$id.ticklet_title_bar_space_view);
        this.mViewTitleBack = this.mLvTitleLayout.findViewById(R$id.ticklet_iv_left_icon);
        this.mTvTitle = (TextView) this.mLvTitleLayout.findViewById(R$id.ticklet_title_text);
        TextView textView = (TextView) this.mLvTitleLayout.findViewById(R$id.ticklet_rule_text_url);
        this.mTvTitleRightBtn = textView;
        textView.setVisibility(8);
        this.mTvTitle.setText(R$string.ticklet_souvenir_title);
        this.mViewTitleBack.setOnClickListener(new a());
        setImmersionStyle();
    }

    public static TicketSouvenirFragment instance(@NonNull TicketSouvenirParams ticketSouvenirParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901823924")) {
            return (TicketSouvenirFragment) ipChange.ipc$dispatch("1901823924", new Object[]{ticketSouvenirParams});
        }
        TicketSouvenirFragment ticketSouvenirFragment = new TicketSouvenirFragment();
        Bundle bundle = new Bundle();
        if (ticketSouvenirParams != null) {
            bundle.putSerializable("souvenir_params", ticketSouvenirParams);
            ticketSouvenirFragment.setArguments(bundle);
        }
        return ticketSouvenirFragment;
    }

    private boolean isTicketShowFragmentShowing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516520724")) {
            return ((Boolean) ipChange.ipc$dispatch("1516520724", new Object[]{this})).booleanValue();
        }
        TickletDialogShowFragment tickletDialogShowFragment = this.mTicketShowFragment;
        return tickletDialogShowFragment != null && tickletDialogShowFragment.isVisible();
    }

    private TicketSouvenirViewModel obtainViewModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "925249562") ? (TicketSouvenirViewModel) ipChange.ipc$dispatch("925249562", new Object[]{this}) : (TicketSouvenirViewModel) ViewModelProviders.of(this, new ViewModelProvider.Factory() { // from class: cn.damai.ticklet.ui.fragment.TicketSouvenirFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-530653606") ? (T) ipChange2.ipc$dispatch("-530653606", new Object[]{this, cls}) : new TicketSouvenirViewModel(TicketSouvenirFragment.this.mParams);
            }
        }).get(TicketSouvenirViewModel.class);
    }

    private void reportUT(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "42402619")) {
            ipChange.ipc$dispatch("42402619", new Object[]{this, str, str2, Boolean.valueOf(z)});
        } else {
            c.e().x(un2.k().c(un2.TICKLET_SOUVENIR, str, str2, Boolean.valueOf(z)));
        }
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "81477098")) {
            ipChange.ipc$dispatch("81477098", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(getActivity());
                this.mViewStatusBarSpace.setVisibility(0);
            }
            kg2.f(getActivity(), true, R$color.black);
            kg2.d(true, getActivity());
        } else {
            kg2.f(getActivity(), false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private void updateItem(ViewGroup viewGroup, String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1527503163")) {
            ipChange.ipc$dispatch("-1527503163", new Object[]{this, viewGroup, str, str2, Boolean.valueOf(z)});
            return;
        }
        TextView textView = (TextView) viewGroup.findViewById(R$id.ticket_souvenir_item_tv);
        TextView textView2 = (TextView) viewGroup.findViewById(R$id.ticket_souvenir_state_tv);
        View findViewById = viewGroup.findViewById(R$id.ticket_souvenir_arrow);
        if (textView != null) {
            textView.setText(str);
        }
        boolean isEmpty = TextUtils.isEmpty(str2);
        if (textView2 != null) {
            textView2.setText(str2);
            textView2.setVisibility(isEmpty ? 8 : 0);
        }
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
    }

    private void updateStyleOneLayout(@NonNull TicketSouvenirDetail ticketSouvenirDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-903572320")) {
            ipChange.ipc$dispatch("-903572320", new Object[]{this, ticketSouvenirDetail});
            return;
        }
        TicketSouvenirInfo ticketSouvenirInfo = ticketSouvenirDetail.souvenirVO;
        this.mStyleOneLayout.setVisibility(0);
        this.mStyleOneTitleTv.setText(ticketSouvenirInfo.methodTitle);
        this.mStyleOneDescTv.setText(ticketSouvenirInfo.collectMethodNote);
        this.mItemTicketsVg.setVisibility(0);
        updateItem(this.mItemTicketsVg, "查看换票凭证", ticketSouvenirInfo.getStateText(), ticketSouvenirInfo.isNormalState());
        if ("1".equals(ticketSouvenirInfo.exchangeSiteStatus)) {
            this.mItemExchangeSiteVg.setVisibility(0);
            updateItem(this.mItemExchangeSiteVg, "查看换票地点", null, true);
            return;
        }
        this.mItemExchangeSiteVg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUI(TicketSouvenirDetail ticketSouvenirDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642190581")) {
            ipChange.ipc$dispatch("-642190581", new Object[]{this, ticketSouvenirDetail});
            return;
        }
        this.mErrorView.setVisibility(8);
        stopProgressDialog();
        TicketSouvenirInfo ticketSouvenirInfo = ticketSouvenirDetail.souvenirVO;
        this.mTopStateTv.setText(ticketSouvenirInfo.topNote);
        this.mBodyLayout.setVisibility(0);
        if (!TextUtils.isEmpty(ticketSouvenirInfo.funcTitle)) {
            this.funTitle.setText(ticketSouvenirInfo.funcTitle);
        }
        this.mFuncNoteTv.setText(ticketSouvenirInfo.funcNote);
        if (!TextUtils.isEmpty(ticketSouvenirInfo.timeTitle)) {
            this.openTimeDesc.setText(ticketSouvenirInfo.timeTitle);
        }
        this.mOpenTimeTv.setText(ticketSouvenirInfo.openTime);
        if (ticketSouvenirInfo.isClosedState()) {
            this.mStyleOneLayout.setVisibility(8);
        } else {
            updateStyleOneLayout(ticketSouvenirDetail);
        }
    }

    public void closeTicketFragmentPopLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221124482")) {
            ipChange.ipc$dispatch("-1221124482", new Object[]{this});
        } else if (isUIValid() && isTicketShowFragmentShowing()) {
            getChildFragmentManager().beginTransaction().remove(this.mTicketShowFragment).commitAllowingStateLoss();
            FragmentActivity activity = getActivity();
            j62.b(activity, j62.a(activity));
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.ticklet.ui.fragment.TicketSouvenirFragment.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "627008053")) {
                        ipChange2.ipc$dispatch("627008053", new Object[]{this});
                        return;
                    }
                    TicketSouvenirFragment.this.mTicketShowLayout.setVisibility(8);
                    TicketSouvenirFragment.this.mViewModel.start();
                }
            }, 100L);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-476312233") ? ((Integer) ipChange.ipc$dispatch("-476312233", new Object[]{this})).intValue() : R$layout.fragment_ticket_souvenir;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519281617")) {
            ipChange.ipc$dispatch("1519281617", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        startProgressDialog();
        this.mViewModel.start();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223950970")) {
            ipChange.ipc$dispatch("1223950970", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1475026973")) {
            ipChange.ipc$dispatch("-1475026973", new Object[]{this});
            return;
        }
        initExtraData();
        if (this.mParams == null) {
            return;
        }
        this.mViewModel = obtainViewModel();
        initTitleView();
        bindView();
        addLiveDataObserver();
        startProgressDialog();
        this.mViewModel.start();
    }

    public boolean isUIValid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445386920")) {
            return ((Boolean) ipChange.ipc$dispatch("-1445386920", new Object[]{this})).booleanValue();
        }
        FragmentActivity activity = getActivity();
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    public void onActivityBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261788805")) {
            ipChange.ipc$dispatch("1261788805", new Object[]{this});
        } else {
            quitStepByStep();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861599497")) {
            ipChange.ipc$dispatch("861599497", new Object[]{this, view});
        } else if (this.mViewModel == null || getActivity() == null) {
        } else {
            int id = view.getId();
            if (id == R$id.ticket_souvenir_exchange_site_layout) {
                openTicketVenuePage();
            } else if (id == R$id.ticket_souvenir_ticket_layout) {
                showTicketFragmentPopLayer();
            } else if (id == R$id.ticket_souvenir_fg_container) {
                closeTicketFragmentPopLayer();
            }
        }
    }

    public void openTicketVenuePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2092082666")) {
            ipChange.ipc$dispatch("2092082666", new Object[]{this});
            return;
        }
        TicketSouvenirParams params = this.mViewModel.getParams();
        if (params != null) {
            reportUT("way1", "exchange_place", false);
            Intent intent = new Intent();
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, params.productSystemId);
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, params.performId);
            intent.putExtra("venueName", params.venueName);
            intent.putExtra("from", TickletVenueActivity.TICKLET_VENUE_FROM_EXCHANGE_SITE);
            intent.setClass(getActivity(), TickletVenueActivity.class);
            startActivity(intent);
        }
    }

    public void quitStepByStep() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57759878")) {
            ipChange.ipc$dispatch("-57759878", new Object[]{this});
        } else if (isTicketShowFragmentShowing()) {
            closeTicketFragmentPopLayer();
        } else if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void showTicketFragmentPopLayer() {
        TicketDeatilResult transferDetailResult4Layer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149665281")) {
            ipChange.ipc$dispatch("-1149665281", new Object[]{this});
        } else if (!this.mViewModel.isNormalState() || (transferDetailResult4Layer = this.mViewModel.transferDetailResult4Layer()) == null) {
        } else {
            reportUT("way1", "exchange_voucher", false);
            showTicketFragmentPopLayer(transferDetailResult4Layer);
        }
    }

    public void showTicketFragmentPopLayer(@NonNull TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751889061")) {
            ipChange.ipc$dispatch("-751889061", new Object[]{this, ticketDeatilResult});
        } else if (isUIValid()) {
            this.mTicketShowLayout.setVisibility(0);
            TickletDialogShowFragment tickletDialogShowFragment = TickletDialogShowFragment.getInstance(ticketDeatilResult.getPerformId(), null, ticketDeatilResult, TickletDialogShowFragment.SHOW_TICKLET_FROM_SOUVENIR);
            this.mTicketShowFragment = tickletDialogShowFragment;
            tickletDialogShowFragment.setOnClickCloseListener(new b());
            getChildFragmentManager().beginTransaction().replace(R$id.ticket_souvenir_fg_container, this.mTicketShowFragment).commitAllowingStateLoss();
        }
    }
}
