package cn.damai.mine.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.activity.RealNameAuthActivity;
import cn.damai.mine.adapter.RealNameChooseAutherAdapter;
import cn.damai.mine.bean.RealNameCustomerBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.vf1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameChooseAutherFragment extends DamaiBaseMvpFragment implements RealNameChooseAutherAdapter.OnCustomerItemClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RealNameCustomerBean> customerBeans;
    private RealNameChooseAutherAdapter mAutherAdapter;
    private RecyclerView mChooseAutherIrc;
    private RealNameCustomerBean mSelectedCustomer;

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1052450863") ? ((Integer) ipChange.ipc$dispatch("1052450863", new Object[]{this})).intValue() : R$layout.realname_choose_auther;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388699143")) {
            ipChange.ipc$dispatch("-388699143", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088877742")) {
            ipChange.ipc$dispatch("-2088877742", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817921013")) {
            ipChange.ipc$dispatch("-1817921013", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("data")) {
            this.customerBeans = arguments.getParcelableArrayList("data");
            this.mSelectedCustomer = (RealNameCustomerBean) arguments.getParcelable("selectedCustomer");
        }
        this.mChooseAutherIrc = (RecyclerView) this.rootView.findViewById(R$id.chooseauther_irc);
        this.mChooseAutherIrc.setLayoutManager(new LinearLayoutManager(getContext()));
        RealNameChooseAutherAdapter realNameChooseAutherAdapter = new RealNameChooseAutherAdapter(getContext(), this.customerBeans);
        this.mAutherAdapter = realNameChooseAutherAdapter;
        realNameChooseAutherAdapter.c(this);
        this.mAutherAdapter.d(this.mSelectedCustomer);
        this.mChooseAutherIrc.setAdapter(this.mAutherAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "856135473")) {
            ipChange.ipc$dispatch("856135473", new Object[]{this, view});
        }
    }

    @Override // cn.damai.mine.adapter.RealNameChooseAutherAdapter.OnCustomerItemClickListener
    public void onItemClick(RealNameCustomerBean realNameCustomerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47850600")) {
            ipChange.ipc$dispatch("-47850600", new Object[]{this, realNameCustomerBean});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof RealNameAuthActivity)) {
            return;
        }
        RealNameAuthActivity realNameAuthActivity = (RealNameAuthActivity) activity;
        realNameAuthActivity.dismissChooseAuthFragment();
        C0529c.e().x(vf1.x().X());
        realNameAuthActivity.refreshUI(realNameCustomerBean, true);
    }
}
