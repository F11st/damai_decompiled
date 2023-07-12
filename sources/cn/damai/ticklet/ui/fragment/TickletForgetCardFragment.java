package cn.damai.ticklet.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.member.R$anim;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletForgetCardResult;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletDetailCallback;
import cn.damai.ticklet.ui.adapter.TickletForgetCardAdapter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.widget.PullToRefreshArrowLoadingView;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.update.utils.ErrorCode;
import java.util.ArrayList;
import tb.py2;
import tb.t60;
import tb.un2;
import tb.v;
import tb.xh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletForgetCardFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletForgetCardAdapter adapter;
    private TextView alipayCrad;
    private DMIconFontTextView alipayRightArrow;
    private TickletDetailCallback cardCallback;
    private String cardNum;
    private TextView dft_close;
    private TickletForgetCardResult forgetCardResult;
    private View headerView;
    private IRecyclerView irc;
    private LinearLayoutManager mLinearLayoutManager;
    private String name;
    private String performId;
    private TextView tvCardNum;
    private TextView tvName;

    private void closeForget() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "30695029")) {
            ipChange.ipc$dispatch("30695029", new Object[]{this});
            return;
        }
        this.adapter.clear();
        this.adapter = null;
        this.cardCallback.closeTickletForgetCard();
    }

    public static TickletForgetCardFragment getInstance(TickletForgetCardResult tickletForgetCardResult, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "558997695")) {
            return (TickletForgetCardFragment) ipChange.ipc$dispatch("558997695", new Object[]{tickletForgetCardResult, str, str2, str3});
        }
        TickletForgetCardFragment tickletForgetCardFragment = new TickletForgetCardFragment();
        Bundle bundle = new Bundle();
        bundle.putString("cardNum", str2);
        bundle.putString("name", str);
        bundle.putString(TicketDetailExtFragment.PERFORM_ID, str3);
        bundle.putSerializable("forgetCardResult", tickletForgetCardResult);
        tickletForgetCardFragment.setArguments(bundle);
        return tickletForgetCardFragment;
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041331882")) {
            ipChange.ipc$dispatch("-2041331882", new Object[]{this});
            return;
        }
        if (TextUtils.isEmpty(this.name) && TextUtils.isEmpty(this.cardNum)) {
            this.headerView.setVisibility(8);
        } else {
            this.headerView.setVisibility(0);
            py2.F(this.tvName, this.name);
            py2.F(this.tvCardNum, this.cardNum);
            if ("1".equals(this.forgetCardResult.eCertState)) {
                this.alipayCrad.setVisibility(0);
                this.alipayRightArrow.setVisibility(0);
            }
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) getContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        int e = t60.e(getContext(), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)) + ErrorCode.ERROR_MD5_UPDATE;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.irc.getLayoutParams();
        if (this.forgetCardResult.forgotCardInfos.size() > 2) {
            layoutParams.height = t60.a(getContext(), e > 345 ? 345.0f : e);
            this.irc.setLayoutParams(layoutParams);
        } else if (this.forgetCardResult.forgotCardInfos.size() == 2) {
            layoutParams.height = t60.a(getContext(), e > 290 ? 290.0f : e);
            this.irc.setLayoutParams(layoutParams);
        } else {
            layoutParams.height = t60.a(getContext(), e > 185 ? 185.0f : e);
            this.irc.setLayoutParams(layoutParams);
        }
        this.adapter.setData(this.forgetCardResult.forgotCardInfos);
        this.adapter.notifyDataSetChanged();
    }

    private void initHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483210990")) {
            ipChange.ipc$dispatch("483210990", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.ticklet_forget_card_header_view, (ViewGroup) null);
        this.headerView = inflate;
        this.tvName = (TextView) inflate.findViewById(R$id.ticklet_forget_card_header_name);
        this.tvCardNum = (TextView) this.headerView.findViewById(R$id.ticklet_forget_card_header_num);
        this.alipayCrad = (TextView) this.headerView.findViewById(R$id.forget_alipay_electronic_card);
        this.alipayRightArrow = (DMIconFontTextView) this.headerView.findViewById(R$id.forget_alipay_right_arrow);
        this.alipayCrad.setOnClickListener(this);
        this.alipayRightArrow.setOnClickListener(this);
        this.irc.addHeaderView(this.headerView);
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250968483")) {
            ipChange.ipc$dispatch("-250968483", new Object[]{this});
            return;
        }
        this.irc = (IRecyclerView) this.rootView.findViewById(R$id.ticklet_card_list);
        TickletForgetCardAdapter tickletForgetCardAdapter = new TickletForgetCardAdapter(getContext());
        this.adapter = tickletForgetCardAdapter;
        this.irc.setAdapter(tickletForgetCardAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        TextView textView = new TextView(this.mActivity);
        textView.setBackgroundResource(R$drawable.shape_solid_bottom_radius4_white);
        this.irc.addFooterView(textView);
        this.irc.setLayoutManager(this.mLinearLayoutManager);
        this.irc.setRefreshEnabled(false);
        this.irc.setIsAutoToDefault(false);
        this.irc.setLoadMoreEnabled(false);
        this.irc.setRefreshHeaderView(PullToRefreshArrowLoadingView.getInstance(this.mActivity));
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-804877889") ? ((Integer) ipChange.ipc$dispatch("-804877889", new Object[]{this})).intValue() : R$layout.ticklet_ticket_forget_card_view;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907242903")) {
            ipChange.ipc$dispatch("-1907242903", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1919094046")) {
            ipChange.ipc$dispatch("-1919094046", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264668283")) {
            ipChange.ipc$dispatch("1264668283", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        initIRecyclerView();
        initHeaderView();
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) this.rootView.findViewById(R$id.dft_close);
        this.dft_close = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
    }

    public void notifyData(UserTicketTable userTicketTable) {
        ArrayList<TickletForgetCardResult.TickletForgetCardData> arrayList;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1720409184")) {
            ipChange.ipc$dispatch("-1720409184", new Object[]{this, userTicketTable});
            return;
        }
        TickletForgetCardResult tickletForgetCardResult = this.forgetCardResult;
        if (tickletForgetCardResult == null || (arrayList = tickletForgetCardResult.forgotCardInfos) == null || arrayList.size() <= 0 || userTicketTable == null || xh2.c(userTicketTable.voucherUniqueKey)) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        while (true) {
            if (i >= this.forgetCardResult.forgotCardInfos.size()) {
                break;
            }
            TickletForgetCardResult.TickletForgetCardData tickletForgetCardData = this.forgetCardResult.forgotCardInfos.get(i);
            if (tickletForgetCardData.voucherUniqueKey.equals(userTicketTable.voucherUniqueKey)) {
                if (!xh2.c(userTicketTable.voucherState)) {
                    tickletForgetCardData.state = userTicketTable.voucherState;
                }
                bool = Boolean.TRUE;
            } else {
                i++;
            }
        }
        if (bool.booleanValue()) {
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1859252129")) {
            ipChange.ipc$dispatch("1859252129", new Object[]{this, view});
        } else if (view.getId() == R$id.dft_close) {
            closeForget();
        } else if (view.getId() == R$id.forget_alipay_electronic_card || view.getId() == R$id.forget_alipay_right_arrow) {
            py2.f().k(getContext(), this.performId, this.forgetCardResult.ecertTipsInfo);
            closeForget();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569967649")) {
            ipChange.ipc$dispatch("-1569967649", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_FORGET_CARD));
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944037867")) {
            return (Animation) ipChange.ipc$dispatch("-1944037867", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        if (z) {
            return AnimationUtils.loadAnimation(getActivity(), R$anim.dialog_show);
        }
        return AnimationUtils.loadAnimation(getActivity(), R$anim.dialog_hide);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889285343")) {
            ipChange.ipc$dispatch("1889285343", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1935495172")) {
            ipChange.ipc$dispatch("1935495172", new Object[]{this});
            return;
        }
        super.onResume();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cardNum = arguments.getString("cardNum");
            this.name = arguments.getString("name");
            this.performId = arguments.getString(TicketDetailExtFragment.PERFORM_ID);
            this.forgetCardResult = (TickletForgetCardResult) arguments.getSerializable("forgetCardResult");
        }
        initData();
    }

    public void setOnClickCloseListener(TickletDetailCallback tickletDetailCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967482520")) {
            ipChange.ipc$dispatch("-967482520", new Object[]{this, tickletDetailCallback});
        } else {
            this.cardCallback = tickletDetailCallback;
        }
    }
}
