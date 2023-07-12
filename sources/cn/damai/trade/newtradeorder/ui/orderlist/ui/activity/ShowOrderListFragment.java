package cn.damai.trade.newtradeorder.ui.orderlist.ui.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.login.LoginManager;
import cn.damai.pay.DamaiPayConstants;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.orderlist.ui.adapter.ShowOrderListPageAdapter;
import cn.damai.uikit.snake.EqualLinearView;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.pp2;
import tb.tr2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ShowOrderListFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String mFromWhere = "damai";
    private int mCurrentPage;
    private OrderListFragment[] mOrderFragments;
    private ShowOrderListPageAdapter mPageAdapter;
    private BroadcastReceiver mReceiver;
    private String[] mTitles;
    public String mUserCode;
    private ViewPager mViewPager;
    private EqualLinearView tabLayout;
    private final int TO_MINE = 0;
    private final int BACK_PAGE = 1;
    private final int TO_HOME_PAGE = 2;
    private int mFromPage = 0;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class OrderListPageChangeListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        OrderListPageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-538638110")) {
                ipChange.ipc$dispatch("-538638110", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-275015807")) {
                ipChange.ipc$dispatch("-275015807", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "195967661")) {
                ipChange.ipc$dispatch("195967661", new Object[]{this, Integer.valueOf(i)});
            } else if (ShowOrderListFragment.this.mOrderFragments == null || i >= ShowOrderListFragment.this.mOrderFragments.length) {
            } else {
                ShowOrderListFragment.this.mCurrentPage = i;
                ShowOrderListFragment.this.tabLayout.selectTitle(i);
                if (i == 0) {
                    C0529c.e().x(pp2.u().W(ShowOrderListFragment.this.mUserCode));
                } else if (i == 1) {
                    C0529c.e().x(pp2.u().X(ShowOrderListFragment.this.mUserCode));
                } else if (i != 2) {
                } else {
                    C0529c.e().x(pp2.u().Y(ShowOrderListFragment.this.mUserCode));
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.ShowOrderListFragment$a */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2236a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        DialogInterface$OnClickListenerC2236a(Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1848143821")) {
                ipChange.ipc$dispatch("1848143821", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            C0529c.e().A(pp2.u().i("paysucc", "1"), "selectsuggestmessage", "message");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + this.a.getPackageName()));
            ShowOrderListFragment.this.startActivity(intent);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.ShowOrderListFragment$b */
    /* loaded from: classes16.dex */
    public class DialogInterface$OnClickListenerC2237b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC2237b(ShowOrderListFragment showOrderListFragment) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1477242452")) {
                ipChange.ipc$dispatch("-1477242452", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                C0529c.e().A(pp2.u().i("paysucc", "0"), "selectsuggestmessage", "message");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.ShowOrderListFragment$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2238c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2238c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "134075493")) {
                ipChange.ipc$dispatch("134075493", new Object[]{this, view});
                return;
            }
            ScrollTitleBean scrollTitleBean = (ScrollTitleBean) view.getTag();
            if (scrollTitleBean == null || ShowOrderListFragment.this.mViewPager == null) {
                return;
            }
            ShowOrderListFragment.this.mViewPager.setCurrentItem(scrollTitleBean.index);
        }
    }

    private OrderListFragment getCurrentFragment() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987515490")) {
            return (OrderListFragment) ipChange.ipc$dispatch("-987515490", new Object[]{this});
        }
        OrderListFragment[] orderListFragmentArr = this.mOrderFragments;
        if (orderListFragmentArr != null && (i = this.mCurrentPage) < orderListFragmentArr.length) {
            return orderListFragmentArr[i];
        }
        return null;
    }

    private void handleIntent(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921971372")) {
            ipChange.ipc$dispatch("-1921971372", new Object[]{this, bundle});
        } else if (bundle == null) {
        } else {
            if (bundle.containsKey("sRemind")) {
                this.mFromPage = 2;
            } else if (bundle.containsKey("backPage")) {
                this.mFromPage = 1;
            }
            if (bundle.containsKey("from_where")) {
                mFromWhere = bundle.getString("from_where");
            }
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isFinishing() || !bundle.containsKey("from_pay")) {
                return;
            }
            String string = bundle.getString("from_pay");
            if ((!"wxpay".equals(string) && !"zhifubao".equals(string)) || DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS_SHOW.equals(z20.B(DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS)) || PermissionsHelper.a(activity.getApplicationContext())) {
                return;
            }
            z20.T(DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS, DamaiPayConstants.PAY_SUCCESS_PUSH_OPEN_STAYUS_SHOW);
            PermissionsHelper.b(activity, getResources().getString(R$string.trade_orderlist_pay_success_push), "去设置", new DialogInterface$OnClickListenerC2236a(activity), "不再提示", new DialogInterface$OnClickListenerC2237b(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[LOOP:0: B:21:0x0059->B:23:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099 A[LOOP:1: B:25:0x0097->B:26:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initOrderPage() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.ShowOrderListFragment.initOrderPage():void");
    }

    private void initTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42756063")) {
            ipChange.ipc$dispatch("-42756063", new Object[]{this});
        }
    }

    private void registerBroad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024282137")) {
            ipChange.ipc$dispatch("-2024282137", new Object[]{this});
            return;
        }
        this.mReceiver = new BroadcastReceiver() { // from class: cn.damai.trade.newtradeorder.ui.orderlist.ui.activity.ShowOrderListFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1927084466")) {
                    ipChange2.ipc$dispatch("1927084466", new Object[]{this, context, intent});
                    return;
                }
                FragmentActivity activity = ShowOrderListFragment.this.getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                ShowOrderListFragment.this.getActivity().finish();
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_close");
        if (getActivity() != null) {
            getActivity().registerReceiver(this.mReceiver, intentFilter);
        }
    }

    public void checkLogin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "144053187")) {
            ipChange.ipc$dispatch("144053187", new Object[]{this});
        } else if (LoginManager.k().q()) {
            initOrderPage();
        } else {
            DMNav.from(getActivity()).forResult(1000).toUri(NavUri.b(cs.v));
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-760890293") ? ((Integer) ipChange.ipc$dispatch("-760890293", new Object[]{this})).intValue() : R$layout.order_list_show_fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354224035")) {
            ipChange.ipc$dispatch("-1354224035", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955378322")) {
            ipChange.ipc$dispatch("-1955378322", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683724399")) {
            ipChange.ipc$dispatch("683724399", new Object[]{this});
            return;
        }
        this.mViewPager = (ViewPager) this.rootView.findViewById(R$id.view_pager);
        this.tabLayout = (EqualLinearView) this.rootView.findViewById(R$id.indicator);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1296490280")) {
            ipChange.ipc$dispatch("1296490280", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        checkLogin();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        OrderListFragment currentFragment;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855176554")) {
            ipChange.ipc$dispatch("-855176554", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            initOrderPage();
        } else if (i == 1101 && i2 == -1 && intent.getBooleanExtra("refresh", false) && (currentFragment = getCurrentFragment()) != null) {
            currentFragment.requestOrderList();
        }
    }

    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597838710")) {
            ipChange.ipc$dispatch("-1597838710", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        int i = this.mFromPage;
        if (i == 0) {
            tr2.b().q(activity, tr2.SCHEME_MINEPAGE);
            activity.finish();
        } else if (i == 1) {
            activity.finish();
        } else if (i != 2) {
        } else {
            DMNav.from(activity).toUri(NavUri.b(cs.n));
            activity.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548087147")) {
            ipChange.ipc$dispatch("-548087147", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111926123")) {
            ipChange.ipc$dispatch("1111926123", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        handleIntent(getArguments());
        registerBroad();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059894123")) {
            ipChange.ipc$dispatch("1059894123", new Object[]{this});
            return;
        }
        super.onDestroy();
        if (this.mReceiver == null || getActivity() == null) {
            return;
        }
        getActivity().unregisterReceiver(this.mReceiver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483753094")) {
            ipChange.ipc$dispatch("483753094", new Object[]{this, intent});
            return;
        }
        handleIntent(intent.getExtras());
        OrderListFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.requestOrderList();
        }
    }
}
