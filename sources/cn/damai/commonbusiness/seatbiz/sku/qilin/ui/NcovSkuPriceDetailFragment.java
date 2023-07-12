package cn.damai.commonbusiness.seatbiz.sku.qilin.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketSubUiModel;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuPriceDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.hj1;
import tb.kg1;
import tb.m91;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NcovSkuPriceDetailFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_CALC = "calc";
    private TicketCalcBean mBean;
    private View mCloseBtn;
    private LinearLayout mContainer;
    private OnPriceDetailListener mOnPriceDetailListener;
    private View mTopView;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnPriceDetailListener {
        void onClose();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "466919117")) {
                ipChange.ipc$dispatch("466919117", new Object[]{this, view});
            } else if (NcovSkuPriceDetailFragment.this.mOnPriceDetailListener != null) {
                NcovSkuPriceDetailFragment.this.mOnPriceDetailListener.onClose();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1716757810")) {
                ipChange.ipc$dispatch("-1716757810", new Object[]{this, view});
            } else if (NcovSkuPriceDetailFragment.this.mOnPriceDetailListener != null) {
                NcovSkuPriceDetailFragment.this.mOnPriceDetailListener.onClose();
            }
        }
    }

    public static NcovSkuPriceDetailFragment getInstance(TicketCalcBean ticketCalcBean, OnPriceDetailListener onPriceDetailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310986246")) {
            return (NcovSkuPriceDetailFragment) ipChange.ipc$dispatch("-310986246", new Object[]{ticketCalcBean, onPriceDetailListener});
        }
        NcovSkuPriceDetailFragment ncovSkuPriceDetailFragment = new NcovSkuPriceDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CALC, ticketCalcBean);
        ncovSkuPriceDetailFragment.setArguments(bundle);
        ncovSkuPriceDetailFragment.setPriceDetailListener(onPriceDetailListener);
        return ncovSkuPriceDetailFragment;
    }

    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343196893")) {
            ipChange.ipc$dispatch("1343196893", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mBean = (TicketCalcBean) arguments.getSerializable(KEY_CALC);
        }
    }

    private void initLayout() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448338229")) {
            ipChange.ipc$dispatch("1448338229", new Object[]{this});
            return;
        }
        View findViewById = this.rootView.findViewById(R$id.view_top);
        this.mTopView = findViewById;
        findViewById.setOnClickListener(new a());
        View findViewById2 = this.rootView.findViewById(R$id.btn_close);
        this.mCloseBtn = findViewById2;
        findViewById2.setOnClickListener(new b());
        this.mContainer = (LinearLayout) this.rootView.findViewById(R$id.container);
        TicketCalcBean ticketCalcBean = this.mBean;
        if (ticketCalcBean == null || m91.a(ticketCalcBean.calculateModuleVOS)) {
            return;
        }
        this.mContainer.removeAllViews();
        for (int i = 0; i < this.mBean.calculateModuleVOS.size(); i++) {
            final TicketMainUiModel ticketMainUiModel = this.mBean.calculateModuleVOS.get(i);
            if (ticketMainUiModel != null) {
                View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.fragment_sku_price_detail_step, (ViewGroup) null);
                View findViewById3 = inflate.findViewById(R$id.layout_step);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_title);
                TextView textView2 = (TextView) inflate.findViewById(R$id.tv_price);
                ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_icon);
                String str2 = ticketMainUiModel.moduleType;
                if (str2 != null) {
                    if (!"1".equals(str2) && !"5".equals(ticketMainUiModel.moduleType)) {
                        textView2.setTextColor(this.mActivity.getResources().getColor(R$color.color_FF2869));
                    } else {
                        textView2.setTextColor(this.mActivity.getResources().getColor(R$color.color_000000));
                    }
                }
                textView.setText(ticketMainUiModel.moduleTitle);
                textView2.setText(ticketMainUiModel.moduleTotalAmtText);
                if (!TextUtils.isEmpty(ticketMainUiModel.moduleIconURL)) {
                    kg1.q(imageView.getContext()).j(ticketMainUiModel.moduleIconURL).e(R$drawable.commonbusiness_help_icon).g(imageView);
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                if (!TextUtils.isEmpty(ticketMainUiModel.iconJumpURL)) {
                    findViewById3.setOnClickListener(new View.OnClickListener() { // from class: tb.gj1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            NcovSkuPriceDetailFragment.this.lambda$initLayout$0(ticketMainUiModel, view);
                        }
                    });
                }
                View findViewById4 = inflate.findViewById(R$id.layout_step_detail);
                if (!m91.a(ticketMainUiModel.moduleDetailVOList)) {
                    TicketSubUiModel ticketSubUiModel = ticketMainUiModel.moduleDetailVOList.get(0);
                    if (ticketSubUiModel != null) {
                        findViewById4.setVisibility(0);
                        TextView textView3 = (TextView) inflate.findViewById(R$id.tv_detail_title);
                        TextView textView4 = (TextView) inflate.findViewById(R$id.tv_detail_price);
                        if (TextUtils.isEmpty(ticketSubUiModel.skuName)) {
                            str = "";
                        } else if (ticketSubUiModel.skuName.length() > 15) {
                            str = ticketSubUiModel.skuName.substring(0, 15) + "...";
                        } else {
                            str = ticketSubUiModel.skuName;
                        }
                        textView3.setText(str + "   x " + ticketSubUiModel.count);
                        textView4.setText(ticketSubUiModel.amountText);
                    }
                } else {
                    findViewById4.setVisibility(8);
                }
                this.mContainer.addView(inflate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLayout$0(TicketMainUiModel ticketMainUiModel, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789218348")) {
            ipChange.ipc$dispatch("-789218348", new Object[]{this, ticketMainUiModel, view});
            return;
        }
        hj1.B = true;
        DMNav.from(this.mActivity).toUri(ticketMainUiModel.iconJumpURL);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2142671552") ? ((Integer) ipChange.ipc$dispatch("2142671552", new Object[]{this})).intValue() : R$layout.fragment_sku_price_detail_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351508680")) {
            ipChange.ipc$dispatch("1351508680", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317957219")) {
            ipChange.ipc$dispatch("317957219", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342888358")) {
            ipChange.ipc$dispatch("-342888358", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        initBundle();
        initLayout();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295340096")) {
            ipChange.ipc$dispatch("-295340096", new Object[]{this, view});
        }
    }

    public void setPriceDetailListener(OnPriceDetailListener onPriceDetailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45391551")) {
            ipChange.ipc$dispatch("-45391551", new Object[]{this, onPriceDetailListener});
        } else {
            this.mOnPriceDetailListener = onPriceDetailListener;
        }
    }
}
