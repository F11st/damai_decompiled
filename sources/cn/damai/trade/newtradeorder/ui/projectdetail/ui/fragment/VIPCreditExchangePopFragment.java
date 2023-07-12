package cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponCreditsBean;
import cn.damai.commonbusiness.seatbiz.promotion.viewholder.SeniorVipAdditionalView;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.presenter.VIPCreditExchangePresenter;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectMemberPrompt;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.adapter.VIPCreditExchangeAdapter;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment.VIPCreditExchangePopFragment;
import com.alibaba.pictures.bricks.view.BricksThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ea0;
import tb.gb;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class VIPCreditExchangePopFragment extends DamaiBaseMvpFragment<VIPCreditExchangePresenter, VIPCreditExchangeContract.Model> implements VIPCreditExchangeContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private VIPCreditExchangeAdapter adapter;
    @Nullable
    private View closeBtn;
    @Nullable
    private View.OnClickListener closeListener;
    @Nullable
    private TextView creditExchangeExtView;
    @Nullable
    private TextView creditExchangeTv;
    @Nullable
    private View creditExchangeView;
    @Nullable
    private TextView creditStockView;
    @Nullable
    private TextView creditTotalView;
    @Nullable
    private TextView creditView;
    @Nullable
    private ProjectMemberPrompt data;
    @Nullable
    private IExchangeResult exchangeListener;
    @Nullable
    private RecyclerView recycleView;
    @Nullable
    private TextView seniorBaseCreditView;
    @Nullable
    private TextView seniorCreditStockView;
    @Nullable
    private TextView seniorCreditView;
    @Nullable
    private ConstraintLayout seniorVipContainer;
    @Nullable
    private TextView titleTv;
    @Nullable
    private LinearLayout vipContainer;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface IExchangeResult {
        void exchangeResult(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class ItemDecoration extends RecyclerView.ItemDecoration {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1793244360")) {
                ipChange.ipc$dispatch("-1793244360", new Object[]{this, rect, view, recyclerView, state});
                return;
            }
            b41.i(rect, "outRect");
            b41.i(view, "view");
            b41.i(recyclerView, "parent");
            b41.i(state, "state");
            super.getItemOffsets(rect, view, recyclerView, state);
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            b41.f(layoutManager);
            if (childLayoutPosition == layoutManager.getItemCount() - 1) {
                rect.set(0, 0, 0, ea0.a(9.0f));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final VIPCreditExchangePopFragment a(@NotNull ProjectMemberPrompt projectMemberPrompt, @Nullable IExchangeResult iExchangeResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "416058164")) {
                return (VIPCreditExchangePopFragment) ipChange.ipc$dispatch("416058164", new Object[]{this, projectMemberPrompt, iExchangeResult});
            }
            b41.i(projectMemberPrompt, "data");
            VIPCreditExchangePopFragment vIPCreditExchangePopFragment = new VIPCreditExchangePopFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", projectMemberPrompt);
            vIPCreditExchangePopFragment.setArguments(bundle);
            vIPCreditExchangePopFragment.setExchangeListener(iExchangeResult);
            return vIPCreditExchangePopFragment;
        }
    }

    private final String formatStock(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221866068")) {
            return (String) ipChange.ipc$dispatch("-221866068", new Object[]{this, l});
        }
        if (l != null) {
            ProjectMemberPrompt projectMemberPrompt = this.data;
            if (!b41.d(projectMemberPrompt != null ? projectMemberPrompt.getButtonStatus() : null, "7")) {
                ProjectMemberPrompt projectMemberPrompt2 = this.data;
                if (!b41.d(projectMemberPrompt2 != null ? projectMemberPrompt2.getButtonStatus() : null, "9")) {
                    if (l.longValue() < 10000) {
                        return "仅剩" + l + (char) 20221;
                    }
                    try {
                        return "仅剩" + new DecimalFormat("0.0") + "万份";
                    } catch (Exception unused) {
                        return "仅剩" + l + (char) 20221;
                    }
                }
            }
        }
        return null;
    }

    private final void setupView() {
        int parseColor;
        int parseColor2;
        String buttonStatus;
        String str;
        String userScore;
        Integer baseScore;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1025161038")) {
            ipChange.ipc$dispatch("-1025161038", new Object[]{this});
            return;
        }
        TextView textView = this.titleTv;
        if (textView != null) {
            ProjectMemberPrompt projectMemberPrompt = this.data;
            textView.setText(projectMemberPrompt != null ? projectMemberPrompt.getLayerTitle() : null);
        }
        View view = this.closeBtn;
        if (view != null) {
            view.setOnClickListener(this.closeListener);
        }
        int i = R$drawable.vip_credit_exchange_bottom_bg;
        int i2 = R$drawable.vip_credit_exchange_bottom_bg_unable;
        Color.parseColor("#582331");
        Color.parseColor("#7F582331");
        ProjectMemberPrompt projectMemberPrompt2 = this.data;
        if (projectMemberPrompt2 != null && projectMemberPrompt2.isSeniorVip()) {
            ConstraintLayout constraintLayout = this.seniorVipContainer;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            LinearLayout linearLayout = this.vipContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView2 = this.seniorCreditView;
            if (textView2 != null) {
                ProjectMemberPrompt projectMemberPrompt3 = this.data;
                textView2.setText(projectMemberPrompt3 != null ? projectMemberPrompt3.getScore() : null);
            }
            TextView textView3 = this.seniorCreditStockView;
            if (textView3 != null) {
                ProjectMemberPrompt projectMemberPrompt4 = this.data;
                textView3.setText(formatStock(projectMemberPrompt4 != null ? projectMemberPrompt4.getPoolRemainingCount() : null));
            }
            TextView textView4 = this.seniorCreditStockView;
            if (textView4 != null) {
                CharSequence text = textView4 != null ? textView4.getText() : null;
                textView4.setVisibility(text == null || text.length() == 0 ? 8 : 0);
            }
            ProjectMemberPrompt projectMemberPrompt5 = this.data;
            if (projectMemberPrompt5 != null && (baseScore = projectMemberPrompt5.getBaseScore()) != null) {
                String str2 = "淘麦VIP" + baseScore.intValue() + "积分";
                TextView textView5 = this.seniorBaseCreditView;
                if (textView5 != null) {
                    textView5.setText(str2);
                }
                TextView textView6 = this.seniorBaseCreditView;
                if (textView6 != null) {
                    int paintFlags = textView6.getPaintFlags();
                    TextView textView7 = this.seniorBaseCreditView;
                    if (textView7 != null) {
                        textView7.setPaintFlags(paintFlags | 16);
                    }
                }
            }
            i = R$drawable.senior_vip_credit_exchange_bottom_bg;
            i2 = R$drawable.senior_vip_credit_exchange_bottom_bg_unable;
            ProjectMemberPrompt projectMemberPrompt6 = this.data;
            Integer scoreDiscount = projectMemberPrompt6 != null ? projectMemberPrompt6.getScoreDiscount() : null;
            String str3 = "积分" + scoreDiscount + (char) 25240;
            TextView textView8 = (TextView) this.rootView.findViewById(R$id.tv_discount);
            if (scoreDiscount != null && scoreDiscount.intValue() != 0) {
                textView8.setVisibility(0);
                textView8.setText(str3);
            } else {
                this.rootView.findViewById(R$id.tag).setVisibility(8);
            }
            parseColor = Color.parseColor("#EBEEFF");
            parseColor2 = Color.parseColor("#7FEBEEFF");
        } else {
            LinearLayout linearLayout2 = this.vipContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            ConstraintLayout constraintLayout2 = this.seniorVipContainer;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            TextView textView9 = this.creditView;
            if (textView9 != null) {
                ProjectMemberPrompt projectMemberPrompt7 = this.data;
                textView9.setText(projectMemberPrompt7 != null ? projectMemberPrompt7.getScore() : null);
            }
            TextView textView10 = this.creditStockView;
            if (textView10 != null) {
                ProjectMemberPrompt projectMemberPrompt8 = this.data;
                textView10.setText(formatStock(projectMemberPrompt8 != null ? projectMemberPrompt8.getPoolRemainingCount() : null));
            }
            TextView textView11 = this.creditStockView;
            if (textView11 != null) {
                CharSequence text2 = textView11 != null ? textView11.getText() : null;
                textView11.setVisibility(text2 == null || text2.length() == 0 ? 8 : 0);
            }
            parseColor = Color.parseColor("#582331");
            parseColor2 = Color.parseColor("#7F582331");
        }
        TextView textView12 = this.creditTotalView;
        if (textView12 != null) {
            ProjectMemberPrompt projectMemberPrompt9 = this.data;
            if (projectMemberPrompt9 == null || (userScore = projectMemberPrompt9.getUserScore()) == null) {
                str = null;
            } else {
                str = "你有" + userScore + "积分";
            }
            textView12.setText(str);
        }
        TextView textView13 = this.creditExchangeTv;
        if (textView13 != null) {
            ProjectMemberPrompt projectMemberPrompt10 = this.data;
            textView13.setText((projectMemberPrompt10 == null || (r8 = projectMemberPrompt10.getLayerButtonText()) == null) ? "暂不可兑" : "暂不可兑");
        }
        ProjectMemberPrompt projectMemberPrompt11 = this.data;
        if (b41.d(projectMemberPrompt11 != null ? projectMemberPrompt11.getButtonStatus() : null, "10")) {
            TextView textView14 = this.creditExchangeExtView;
            if (textView14 != null) {
                ProjectMemberPrompt projectMemberPrompt12 = this.data;
                textView14.setText(projectMemberPrompt12 != null ? projectMemberPrompt12.getExchangeStartTime() : null);
            }
            TextView textView15 = this.creditExchangeExtView;
            if (textView15 != null) {
                textView15.setVisibility(0);
            }
        } else {
            TextView textView16 = this.creditExchangeExtView;
            if (textView16 != null) {
                textView16.setVisibility(8);
            }
        }
        ProjectMemberPrompt projectMemberPrompt13 = this.data;
        if (b41.d(projectMemberPrompt13 != null ? projectMemberPrompt13.getButtonStatus() : null, "6")) {
            View view2 = this.creditExchangeView;
            if (view2 != null) {
                view2.setBackgroundResource(i);
            }
            TextView textView17 = this.creditExchangeTv;
            if (textView17 != null) {
                textView17.setTextColor(parseColor);
            }
        } else {
            View view3 = this.creditExchangeView;
            if (view3 != null) {
                view3.setBackgroundResource(i2);
            }
            TextView textView18 = this.creditExchangeTv;
            if (textView18 != null) {
                textView18.setTextColor(parseColor2);
            }
            TextView textView19 = this.creditExchangeExtView;
            if (textView19 != null) {
                textView19.setTextColor(parseColor2);
            }
        }
        c e = c.e();
        View view4 = this.creditExchangeView;
        HashMap hashMap = new HashMap();
        ProjectMemberPrompt projectMemberPrompt14 = this.data;
        hashMap.put("preemption_stage", projectMemberPrompt14 != null && projectMemberPrompt14.isPromptBeforeSale() ? "1" : "2");
        ProjectMemberPrompt projectMemberPrompt15 = this.data;
        if (projectMemberPrompt15 != null && (buttonStatus = projectMemberPrompt15.getButtonStatus()) != null) {
            String str4 = (String) hashMap.put("preemption_btn_status", buttonStatus);
        }
        ProjectMemberPrompt projectMemberPrompt16 = this.data;
        hashMap.put("is_exclusivepurchase", (projectMemberPrompt16 == null || !projectMemberPrompt16.isSpecialBuy()) ? false : false ? "1" : "0");
        wt2 wt2Var = wt2.INSTANCE;
        e.G(view4, "exchangebtn", "preemption_layer", gb.PROJECT_PAGE, hashMap);
        View view5 = this.creditExchangeView;
        if (view5 != null) {
            view5.setOnClickListener(new View.OnClickListener() { // from class: tb.uw2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    VIPCreditExchangePopFragment.m101setupView$lambda13(VIPCreditExchangePopFragment.this, view6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupView$lambda-13  reason: not valid java name */
    public static final void m101setupView$lambda13(final VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        String buttonStatus;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001794922")) {
            ipChange.ipc$dispatch("-1001794922", new Object[]{vIPCreditExchangePopFragment, view});
            return;
        }
        b41.i(vIPCreditExchangePopFragment, "this$0");
        c e = c.e();
        a.b g = new a.b().i(gb.PROJECT_PAGE).f("preemption_layer").l("exchangebtn").g(false);
        HashMap hashMap = new HashMap();
        ProjectMemberPrompt projectMemberPrompt = vIPCreditExchangePopFragment.data;
        hashMap.put("is_exclusivepurchase", projectMemberPrompt != null && projectMemberPrompt.isSpecialBuy() ? "1" : "0");
        ProjectMemberPrompt projectMemberPrompt2 = vIPCreditExchangePopFragment.data;
        hashMap.put("preemption_stage", projectMemberPrompt2 != null && projectMemberPrompt2.isPromptBeforeSale() ? "1" : "2");
        ProjectMemberPrompt projectMemberPrompt3 = vIPCreditExchangePopFragment.data;
        if (projectMemberPrompt3 != null && (buttonStatus = projectMemberPrompt3.getButtonStatus()) != null) {
            hashMap.put("preemption_btn_status", buttonStatus);
        }
        wt2 wt2Var = wt2.INSTANCE;
        e.x(g.j(hashMap));
        ProjectMemberPrompt projectMemberPrompt4 = vIPCreditExchangePopFragment.data;
        if (b41.d(projectMemberPrompt4 != null ? projectMemberPrompt4.getButtonStatus() : null, "6")) {
            int parseColor = Color.parseColor("#F38066");
            int parseColor2 = Color.parseColor("#582331");
            ProjectMemberPrompt projectMemberPrompt5 = vIPCreditExchangePopFragment.data;
            boolean z = projectMemberPrompt5 != null && projectMemberPrompt5.isSeniorVip();
            if (z) {
                parseColor = Color.parseColor("#210276");
                parseColor2 = Color.parseColor("#DCE6FF");
            }
            Context context = vIPCreditExchangePopFragment.getContext();
            if (context != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("本次兑换将消耗");
                int length = sb.length();
                ProjectMemberPrompt projectMemberPrompt6 = vIPCreditExchangePopFragment.data;
                sb.append(projectMemberPrompt6 != null ? projectMemberPrompt6.getScore() : null);
                int length2 = sb.length();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("积分\n（当前有");
                ProjectMemberPrompt projectMemberPrompt7 = vIPCreditExchangePopFragment.data;
                sb2.append(projectMemberPrompt7 != null ? projectMemberPrompt7.getUserScore() : null);
                sb2.append("积分）");
                sb.append(sb2.toString());
                SpannableString spannableString = new SpannableString(sb.toString());
                spannableString.setSpan(new ForegroundColorSpan(parseColor), length, length2, 18);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("使用规则\n");
                ProjectMemberPrompt projectMemberPrompt8 = vIPCreditExchangePopFragment.data;
                sb3.append(projectMemberPrompt8 != null ? projectMemberPrompt8.getExchangeRule() : null);
                SpannableString spannableString2 = new SpannableString(sb3.toString());
                spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, 4, 18);
                spannableString2.setSpan(new AbsoluteSizeSpan(16, true), 0, 4, 18);
                final BricksThemeDialog bricksThemeDialog = new BricksThemeDialog(context);
                if (z) {
                    SeniorVipAdditionalView seniorVipAdditionalView = new SeniorVipAdditionalView(context, null, 0, 6, null);
                    ProjectMemberPrompt projectMemberPrompt9 = vIPCreditExchangePopFragment.data;
                    Integer scoreDiscount = projectMemberPrompt9 != null ? projectMemberPrompt9.getScoreDiscount() : null;
                    ProjectMemberPrompt projectMemberPrompt10 = vIPCreditExchangePopFragment.data;
                    seniorVipAdditionalView.setData(scoreDiscount, projectMemberPrompt10 != null ? projectMemberPrompt10.getReductionScore() : null);
                    bricksThemeDialog.o(R$drawable.score_icon).r(GridBean.TYPE_PIC_URL, 83).e(seniorVipAdditionalView).q(GridBean.TYPE_PIC_URL, 55).p(R$drawable.senior_vip_score_bg).l(GravityCompat.START).n("确认兑换此特权吗").m(spannableString).k(spannableString2).f(R$drawable.bg_senior_vip_exchange_dialog_cancel).g(R$drawable.sku_senior_vip_promotion_profit_bg);
                } else {
                    bricksThemeDialog.o(R$drawable.score_icon).r(GridBean.TYPE_PIC_URL, 83).q(GridBean.TYPE_PIC_URL, 55).p(R$drawable.score_bg).n("确认兑换此特权吗").m(spannableString).k(spannableString2).l(GravityCompat.START).f(R$drawable.bg_vip_exchange_dialog_cancel).g(R$drawable.sku_promotion_profit_bg);
                }
                bricksThemeDialog.j("确认兑换", parseColor2, new View.OnClickListener() { // from class: tb.tw2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        VIPCreditExchangePopFragment.m102setupView$lambda13$lambda12$lambda10(VIPCreditExchangePopFragment.this, view2);
                    }
                }).h("放弃优惠", parseColor, new DialogInterface.OnClickListener() { // from class: tb.sw2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        VIPCreditExchangePopFragment.m103setupView$lambda13$lambda12$lambda11(BricksThemeDialog.this, dialogInterface, i);
                    }
                }).i(true, null).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupView$lambda-13$lambda-12$lambda-10  reason: not valid java name */
    public static final void m102setupView$lambda13$lambda12$lambda10(VIPCreditExchangePopFragment vIPCreditExchangePopFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114218790")) {
            ipChange.ipc$dispatch("-1114218790", new Object[]{vIPCreditExchangePopFragment, view});
            return;
        }
        b41.i(vIPCreditExchangePopFragment, "this$0");
        vIPCreditExchangePopFragment.showLoading("");
        VIPCreditExchangePresenter vIPCreditExchangePresenter = (VIPCreditExchangePresenter) vIPCreditExchangePopFragment.mPresenter;
        ProjectMemberPrompt projectMemberPrompt = vIPCreditExchangePopFragment.data;
        String exchange4Dm = projectMemberPrompt != null ? projectMemberPrompt.getExchange4Dm() : null;
        ProjectMemberPrompt projectMemberPrompt2 = vIPCreditExchangePopFragment.data;
        String spreadId = projectMemberPrompt2 != null ? projectMemberPrompt2.getSpreadId() : null;
        ProjectMemberPrompt projectMemberPrompt3 = vIPCreditExchangePopFragment.data;
        vIPCreditExchangePresenter.requestExchange(exchange4Dm, spreadId, "204", projectMemberPrompt3 != null ? projectMemberPrompt3.getAsac() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupView$lambda-13$lambda-12$lambda-11  reason: not valid java name */
    public static final void m103setupView$lambda13$lambda12$lambda11(BricksThemeDialog bricksThemeDialog, DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565654748")) {
            ipChange.ipc$dispatch("1565654748", new Object[]{bricksThemeDialog, dialogInterface, Integer.valueOf(i)});
            return;
        }
        b41.i(bricksThemeDialog, "$dialog");
        bricksThemeDialog.dismiss();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract.View
    public void exchangeFail(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1747650281")) {
            ipChange.ipc$dispatch("1747650281", new Object[]{this, str, str2});
        } else if (getActivity() == null || requireActivity().isFinishing()) {
        } else {
            stopLoading();
            ToastUtil.b("啊哦，兑换失败了~", 1);
            View.OnClickListener onClickListener = this.closeListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.closeBtn);
            }
            IExchangeResult iExchangeResult = this.exchangeListener;
            if (iExchangeResult != null) {
                iExchangeResult.exchangeResult(false);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract.View
    public void exchangeSuccess(@NotNull CouponCreditsBean couponCreditsBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736834136")) {
            ipChange.ipc$dispatch("-1736834136", new Object[]{this, couponCreditsBean});
            return;
        }
        b41.i(couponCreditsBean, "data");
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        stopLoading();
        ToastUtil.b("已兑换成功，去购票享优惠吧~", 1);
        View.OnClickListener onClickListener = this.closeListener;
        if (onClickListener != null) {
            onClickListener.onClick(this.closeBtn);
        }
        IExchangeResult iExchangeResult = this.exchangeListener;
        if (iExchangeResult != null) {
            iExchangeResult.exchangeResult(true);
        }
    }

    @Nullable
    public final View.OnClickListener getCloseListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-872214551") ? (View.OnClickListener) ipChange.ipc$dispatch("-872214551", new Object[]{this}) : this.closeListener;
    }

    @Nullable
    public final IExchangeResult getExchangeListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1154535384") ? (IExchangeResult) ipChange.ipc$dispatch("1154535384", new Object[]{this}) : this.exchangeListener;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1177262745") ? ((Integer) ipChange.ipc$dispatch("1177262745", new Object[]{this})).intValue() : R$layout.fragment_vip_creadit_exchange_pop_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738008753")) {
            ipChange.ipc$dispatch("-1738008753", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967802692")) {
            ipChange.ipc$dispatch("-967802692", new Object[]{this});
        } else {
            ((VIPCreditExchangePresenter) this.mPresenter).mView = this;
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688848993")) {
            ipChange.ipc$dispatch("688848993", new Object[]{this});
            return;
        }
        this.titleTv = (TextView) this.rootView.findViewById(R$id.layer_title);
        this.closeBtn = this.rootView.findViewById(R$id.layer_close);
        this.seniorVipContainer = (ConstraintLayout) this.rootView.findViewById(R$id.ll_senior_vip_integral);
        this.vipContainer = (LinearLayout) this.rootView.findViewById(R$id.ll_integral);
        this.creditView = (TextView) this.rootView.findViewById(R$id.tv_integral_number);
        this.seniorCreditView = (TextView) this.rootView.findViewById(R$id.tv_senior_vip_integral_number);
        this.seniorBaseCreditView = (TextView) this.rootView.findViewById(R$id.tv_senior_vip_integral_base);
        this.creditStockView = (TextView) this.rootView.findViewById(R$id.tv_stock);
        this.seniorCreditStockView = (TextView) this.rootView.findViewById(R$id.senior_tv_stock);
        this.creditTotalView = (TextView) this.rootView.findViewById(R$id.tv_use_integral);
        this.creditExchangeTv = (TextView) this.rootView.findViewById(R$id.btn_exchange);
        this.creditExchangeView = this.rootView.findViewById(R$id.cl_exchange);
        this.creditExchangeExtView = (TextView) this.rootView.findViewById(R$id.btn_exchange_ext);
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R$id.recyclerview);
        this.recycleView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        VIPCreditExchangeAdapter vIPCreditExchangeAdapter = new VIPCreditExchangeAdapter();
        this.adapter = vIPCreditExchangeAdapter;
        RecyclerView recyclerView2 = this.recycleView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(vIPCreditExchangeAdapter);
        }
        RecyclerView recyclerView3 = this.recycleView;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new ItemDecoration());
        }
        setupView();
        VIPCreditExchangeAdapter vIPCreditExchangeAdapter2 = this.adapter;
        if (vIPCreditExchangeAdapter2 != null) {
            vIPCreditExchangeAdapter2.a(this.data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1154978330")) {
            ipChange.ipc$dispatch("1154978330", new Object[]{this, bundle});
        } else {
            super.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-277987320")) {
            ipChange.ipc$dispatch("-277987320", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343671289")) {
            ipChange.ipc$dispatch("-1343671289", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076345799")) {
            ipChange.ipc$dispatch("-2076345799", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data") : null;
        this.data = serializable instanceof ProjectMemberPrompt ? (ProjectMemberPrompt) serializable : null;
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666121109")) {
            ipChange.ipc$dispatch("-1666121109", new Object[]{this, Boolean.valueOf(z)});
        } else {
            super.onHiddenChanged(z);
        }
    }

    public final void setCloseListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1161552685")) {
            ipChange.ipc$dispatch("1161552685", new Object[]{this, onClickListener});
        } else {
            this.closeListener = onClickListener;
        }
    }

    public final void setExchangeListener(@Nullable IExchangeResult iExchangeResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742234460")) {
            ipChange.ipc$dispatch("-742234460", new Object[]{this, iExchangeResult});
        } else {
            this.exchangeListener = iExchangeResult;
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2100041727")) {
            ipChange.ipc$dispatch("2100041727", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1254481147")) {
            ipChange.ipc$dispatch("1254481147", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637874079")) {
            ipChange.ipc$dispatch("1637874079", new Object[]{this, str});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.mBaseActivity;
        if (damaiBaseActivity != null) {
            String[] strArr = new String[1];
            if (str == null) {
                str = "";
            }
            strArr[0] = str;
            damaiBaseActivity.showLoading(strArr);
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "569439706")) {
            ipChange.ipc$dispatch("569439706", new Object[]{this});
            return;
        }
        DamaiBaseActivity damaiBaseActivity = this.mBaseActivity;
        if (damaiBaseActivity != null) {
            damaiBaseActivity.hideLoading();
        }
    }
}
