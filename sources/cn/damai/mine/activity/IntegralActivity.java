package cn.damai.mine.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.baseview.abcpullrefresh.actionbarcompat.PullToRefreshLayout;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.view.MyListView;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.bean.AcquireScoreDto;
import cn.damai.mine.bean.LostScoreDto;
import cn.damai.mine.bean.UserScoreDto;
import cn.damai.mine.contract.IntegralContract;
import cn.damai.mine.presenter.IntegralPresenter;
import com.alibaba.security.common.track.model.C3834a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cm2;
import tb.gh1;
import tb.jn1;
import tb.vf1;
import tb.w2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class IntegralActivity extends DamaiBaseActivity<IntegralPresenter, IntegralContract.Model> implements IntegralContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private View headView;
    private LinearLayout integral_consume_llyt;
    private LinearLayout integral_consume_top_llyt;
    private TextView integral_consume_top_tv;
    private View integral_consume_top_view;
    private TextView integral_consume_tv;
    private View integral_consume_view;
    private TextView integral_count_tv;
    private LinearLayout integral_obtain_llyt;
    private LinearLayout integral_obtain_top_llyt;
    private TextView integral_obtain_top_tv;
    private View integral_obtain_top_view;
    private TextView integral_obtain_tv;
    private View integral_obtain_view;
    private TextView integral_surplus_tv;
    private LinearLayout integral_top_llyt;
    MyListView lv_list;
    private AcquireAdapter mAcquireAdapter;
    private TextView mBtnScoreTip;
    private View mHeaderView;
    private LostScoreAdapter mLostScoreAdapter;
    private LinearLayout mScoreTipLayout;
    private TextView mTvScoreTip;
    private IntegralActivity myActivity;
    View null_page;
    PullToRefreshLayout pull_down_view;
    private TextView tv_exchange;
    private List<AcquireScoreDto.AcquireScoreModel> acquireScoreDtoList = new ArrayList();
    private List<LostScoreDto.LostScoreModel> lostScoreDtoList = new ArrayList();
    private boolean isFlag = true;
    private int pointIndex = 1;
    private int sumptionIndex = 1;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class AcquireAdapter extends BaseAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        private AcquireAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714829870")) {
                return ((Integer) ipChange.ipc$dispatch("-1714829870", new Object[]{this})).intValue();
            }
            if (IntegralActivity.this.acquireScoreDtoList == null) {
                return 0;
            }
            return IntegralActivity.this.acquireScoreDtoList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-538839848")) {
                return ipChange.ipc$dispatch("-538839848", new Object[]{this, Integer.valueOf(i)});
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-193850807")) {
                return ((Long) ipChange.ipc$dispatch("-193850807", new Object[]{this, Integer.valueOf(i)})).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C1389i c1389i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "468071")) {
                return (View) ipChange.ipc$dispatch("468071", new Object[]{this, Integer.valueOf(i), view, viewGroup});
            }
            if (view == null) {
                c1389i = new C1389i(null);
                view2 = ((BaseActivity) IntegralActivity.this).mInflater.inflate(R$layout.integral_list_item, (ViewGroup) null);
                c1389i.a = (TextView) view2.findViewById(R$id.tv_integralitem_no);
                c1389i.b = (TextView) view2.findViewById(R$id.tv_integral_price);
                c1389i.c = (TextView) view2.findViewById(R$id.tv_integral_stauts);
                c1389i.d = (TextView) view2.findViewById(R$id.tv_integralitem_name);
                c1389i.e = (TextView) view2.findViewById(R$id.tv_integralitem_date);
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R$id.integral_list_rlyt);
                view2.setTag(c1389i);
            } else {
                view2 = view;
                c1389i = (C1389i) view.getTag();
            }
            AcquireScoreDto.AcquireScoreModel acquireScoreModel = (AcquireScoreDto.AcquireScoreModel) IntegralActivity.this.acquireScoreDtoList.get(i);
            if (i == IntegralActivity.this.acquireScoreDtoList.size() - 1) {
                new LinearLayout.LayoutParams(-1, -2).bottomMargin = 130;
            }
            if (acquireScoreModel != null) {
                if (acquireScoreModel.businessAcquireId != null) {
                    TextView textView = c1389i.a;
                    textView.setText("" + acquireScoreModel.businessAcquireId);
                }
                String str = acquireScoreModel.businessName;
                if (str != null) {
                    c1389i.d.setText(str);
                }
                c1389i.c.setText("交易获得");
                TextView textView2 = c1389i.b;
                textView2.setText(jn1.PLUS + acquireScoreModel.score);
                c1389i.b.setTextColor(IntegralActivity.this.getResources().getColor(R$color.main_color));
                String str2 = acquireScoreModel.acquireTime;
                if (str2 != null) {
                    c1389i.e.setText(str2);
                }
            }
            return view2;
        }

        /* synthetic */ AcquireAdapter(IntegralActivity integralActivity, C1381a c1381a) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class LostScoreAdapter extends BaseAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        private LostScoreAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "277519962")) {
                return ((Integer) ipChange.ipc$dispatch("277519962", new Object[]{this})).intValue();
            }
            if (IntegralActivity.this.lostScoreDtoList == null) {
                return 0;
            }
            return IntegralActivity.this.lostScoreDtoList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1164721488")) {
                return ipChange.ipc$dispatch("1164721488", new Object[]{this, Integer.valueOf(i)});
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1101076271")) {
                return ((Long) ipChange.ipc$dispatch("-1101076271", new Object[]{this, Integer.valueOf(i)})).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C1389i c1389i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1889573087")) {
                return (View) ipChange.ipc$dispatch("1889573087", new Object[]{this, Integer.valueOf(i), view, viewGroup});
            }
            if (view == null) {
                c1389i = new C1389i(null);
                view2 = ((BaseActivity) IntegralActivity.this).mInflater.inflate(R$layout.integral_list_item, (ViewGroup) null);
                c1389i.a = (TextView) view2.findViewById(R$id.tv_integralitem_no);
                c1389i.b = (TextView) view2.findViewById(R$id.tv_integral_price);
                c1389i.c = (TextView) view2.findViewById(R$id.tv_integral_stauts);
                c1389i.d = (TextView) view2.findViewById(R$id.tv_integralitem_name);
                c1389i.e = (TextView) view2.findViewById(R$id.tv_integralitem_date);
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R$id.integral_list_rlyt);
                view2.setTag(c1389i);
            } else {
                view2 = view;
                c1389i = (C1389i) view.getTag();
            }
            LostScoreDto.LostScoreModel lostScoreModel = (LostScoreDto.LostScoreModel) IntegralActivity.this.lostScoreDtoList.get(i);
            if (i == IntegralActivity.this.lostScoreDtoList.size() - 1) {
                new LinearLayout.LayoutParams(-1, -2).bottomMargin = 130;
            }
            if (lostScoreModel != null) {
                if (lostScoreModel.businessAbatementId != null) {
                    TextView textView = c1389i.a;
                    textView.setText("" + lostScoreModel.businessAbatementId);
                }
                String str = lostScoreModel.businessName;
                if (str != null) {
                    c1389i.d.setText(str);
                }
                TextView textView2 = c1389i.b;
                textView2.setText("-" + lostScoreModel.score);
                c1389i.b.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_009944));
                String str2 = lostScoreModel.lostTime;
                if (str2 != null) {
                    c1389i.e.setText(str2);
                }
                c1389i.c.setText("交易扣减");
            }
            return view2;
        }

        /* synthetic */ LostScoreAdapter(IntegralActivity integralActivity, C1381a c1381a) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$a */
    /* loaded from: classes6.dex */
    public class C1381a implements OnLoadMoreListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1381a() {
        }

        @Override // cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener
        public void onLoadStarted(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2026529400")) {
                ipChange.ipc$dispatch("-2026529400", new Object[]{this, view});
            } else if (IntegralActivity.this.isFlag) {
                IntegralActivity.access$112(IntegralActivity.this, 1);
                IntegralActivity.this.requestPointsIntegral();
            } else {
                IntegralActivity.access$312(IntegralActivity.this, 1);
                IntegralActivity.this.requestSumptionIntegral();
            }
        }

        @Override // cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener
        public void onScroll(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1018116220")) {
                ipChange.ipc$dispatch("1018116220", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                IntegralActivity.this.integral_top_llyt.setVisibility(0);
                IntegralActivity.this.updateStatus();
                IntegralActivity.this.headView.setVisibility(4);
            } else {
                IntegralActivity.this.integral_top_llyt.setVisibility(8);
                IntegralActivity.this.headView.setVisibility(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$b */
    /* loaded from: classes6.dex */
    public class C1382b implements OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1382b() {
        }

        @Override // cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener
        public void onRefreshStarted(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-156798158")) {
                ipChange.ipc$dispatch("-156798158", new Object[]{this, view});
                return;
            }
            IntegralActivity.this.pull_down_view.setRefreshing(true);
            IntegralActivity.this.requestIntegralList();
            if (IntegralActivity.this.isFlag) {
                IntegralActivity.this.pointIndex = 1;
                IntegralActivity.this.requestPointsIntegral();
            } else {
                IntegralActivity.this.sumptionIndex = 1;
                IntegralActivity.this.requestSumptionIntegral();
            }
            IntegralActivity.this.pull_down_view.setRefreshComplete();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$c */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1383c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1383c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1369164439")) {
                ipChange.ipc$dispatch("1369164439", new Object[]{this, view});
                return;
            }
            if (!IntegralActivity.this.isFlag) {
                IntegralActivity.this.lv_list.setSelection(0);
                if (IntegralActivity.this.acquireScoreDtoList.size() != 0) {
                    IntegralActivity.this.flushPointsAdapter();
                } else {
                    IntegralActivity.this.pull_down_view.setRefreshing(true);
                    IntegralActivity.this.requestPointsIntegral();
                    IntegralActivity.this.pull_down_view.setRefreshComplete();
                }
            }
            IntegralActivity.this.isFlag = true;
            IntegralActivity.this.updateStatus();
            IntegralActivity.this.integral_obtain_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_111111));
            IntegralActivity.this.integral_consume_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_888888));
            IntegralActivity.this.integral_consume_view.setVisibility(4);
            IntegralActivity.this.integral_obtain_view.setVisibility(0);
            IntegralActivity.this.integral_consume_top_llyt.requestLayout();
            IntegralActivity.this.integral_obtain_top_llyt.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$d */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1384d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1384d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-814512488")) {
                ipChange.ipc$dispatch("-814512488", new Object[]{this, view});
                return;
            }
            if (IntegralActivity.this.isFlag) {
                IntegralActivity.this.lv_list.setSelection(0);
                if (IntegralActivity.this.lostScoreDtoList.size() != 0) {
                    IntegralActivity.this.flushSumptionAdapter();
                } else {
                    IntegralActivity.this.pull_down_view.setRefreshing(true);
                    IntegralActivity.this.requestSumptionIntegral();
                    IntegralActivity.this.pull_down_view.setRefreshComplete();
                }
            }
            IntegralActivity.this.isFlag = false;
            IntegralActivity.this.updateStatus();
            IntegralActivity.this.integral_consume_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_111111));
            IntegralActivity.this.integral_obtain_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_888888));
            IntegralActivity.this.integral_obtain_view.setVisibility(4);
            IntegralActivity.this.integral_consume_view.setVisibility(0);
            IntegralActivity.this.integral_consume_top_llyt.requestLayout();
            IntegralActivity.this.integral_obtain_top_llyt.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$e */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1385e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1385e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1296777881")) {
                ipChange.ipc$dispatch("1296777881", new Object[]{this, view});
                return;
            }
            if (!IntegralActivity.this.isFlag) {
                IntegralActivity.this.lv_list.setSelection(0);
                if (IntegralActivity.this.acquireScoreDtoList.size() == 0) {
                    IntegralActivity.this.pull_down_view.setRefreshing(true);
                    IntegralActivity.this.requestPointsIntegral();
                    IntegralActivity.this.pull_down_view.setRefreshComplete();
                } else {
                    IntegralActivity.this.null_page.setVisibility(8);
                    IntegralActivity.this.flushPointsAdapter();
                }
            }
            IntegralActivity.this.isFlag = true;
            IntegralActivity.this.integral_obtain_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_111111));
            IntegralActivity.this.integral_consume_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_888888));
            IntegralActivity.this.integral_consume_view.setVisibility(4);
            IntegralActivity.this.integral_obtain_view.setVisibility(0);
            IntegralActivity.this.integral_obtain_llyt.requestLayout();
            IntegralActivity.this.integral_consume_llyt.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$f */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1386f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1386f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-886899046")) {
                ipChange.ipc$dispatch("-886899046", new Object[]{this, view});
                return;
            }
            if (IntegralActivity.this.isFlag) {
                IntegralActivity.this.lv_list.setSelection(0);
                if (IntegralActivity.this.lostScoreDtoList.size() != 0) {
                    IntegralActivity.this.flushSumptionAdapter();
                } else {
                    IntegralActivity.this.pull_down_view.setRefreshing(true);
                    IntegralActivity.this.requestSumptionIntegral();
                    IntegralActivity.this.pull_down_view.setRefreshComplete();
                }
            }
            IntegralActivity.this.isFlag = false;
            IntegralActivity.this.integral_consume_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_111111));
            IntegralActivity.this.integral_obtain_tv.setTextColor(IntegralActivity.this.getResources().getColor(R$color.color_888888));
            IntegralActivity.this.integral_obtain_view.setVisibility(4);
            IntegralActivity.this.integral_consume_view.setVisibility(0);
            IntegralActivity.this.integral_obtain_llyt.requestLayout();
            IntegralActivity.this.integral_consume_llyt.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$g */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1387g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1387g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1224391323")) {
                ipChange.ipc$dispatch("1224391323", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("title", cm2.b(IntegralActivity.this, R$string.main_header_01));
            bundle.putString("from", gh1.MODULE_BANNER);
            bundle.putBoolean("qiandao", true);
            DMNav.from(IntegralActivity.this).withExtras(bundle).forResult(100).toUri("https://mat.damai.cn/duiba/index.aspx");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$h */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1388h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1388h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-959285604")) {
                ipChange.ipc$dispatch("-959285604", new Object[]{this, view});
                return;
            }
            String str = (String) view.getTag();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            DMNav.from(IntegralActivity.this).withExtras(bundle).toUri(NavUri.b(C3834a.C3837c.d));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.IntegralActivity$i */
    /* loaded from: classes15.dex */
    private static class C1389i {
        TextView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;

        private C1389i() {
        }

        /* synthetic */ C1389i(C1381a c1381a) {
            this();
        }
    }

    static /* synthetic */ int access$112(IntegralActivity integralActivity, int i) {
        int i2 = integralActivity.pointIndex + i;
        integralActivity.pointIndex = i2;
        return i2;
    }

    static /* synthetic */ int access$312(IntegralActivity integralActivity, int i) {
        int i2 = integralActivity.sumptionIndex + i;
        integralActivity.sumptionIndex = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushPointsAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596087217")) {
            ipChange.ipc$dispatch("-1596087217", new Object[]{this});
            return;
        }
        this.integral_top_llyt.setVisibility(8);
        this.headView.setVisibility(0);
        AcquireAdapter acquireAdapter = new AcquireAdapter(this, null);
        this.mAcquireAdapter = acquireAdapter;
        this.lv_list.setAdapter((ListAdapter) acquireAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushSumptionAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210193541")) {
            ipChange.ipc$dispatch("1210193541", new Object[]{this});
            return;
        }
        this.lv_list.setAdapter((ListAdapter) null);
        this.integral_top_llyt.setVisibility(8);
        this.headView.setVisibility(0);
        LostScoreAdapter lostScoreAdapter = new LostScoreAdapter(this, null);
        this.mLostScoreAdapter = lostScoreAdapter;
        this.lv_list.setAdapter((ListAdapter) lostScoreAdapter);
    }

    private void initContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522216005")) {
            ipChange.ipc$dispatch("522216005", new Object[]{this});
            return;
        }
        this.pull_down_view = (PullToRefreshLayout) this.myActivity.findViewById(R$id.pull_refresh_layout);
        this.lv_list = (MyListView) findViewById(R$id.list_view);
        View inflate = this.mInflater.inflate(R$layout.integral_activity_content, (ViewGroup) null);
        this.headView = inflate;
        this.integral_surplus_tv = (TextView) inflate.findViewById(R$id.integral_surplus_tv);
        this.integral_top_llyt = (LinearLayout) findViewById(R$id.integral_top_llyt);
        this.integral_count_tv = (TextView) this.headView.findViewById(R$id.integral_count_tv);
        this.integral_obtain_llyt = (LinearLayout) this.headView.findViewById(R$id.integral_obtain_llyt);
        this.integral_consume_llyt = (LinearLayout) this.headView.findViewById(R$id.integral_consume_llyt);
        this.integral_consume_tv = (TextView) this.headView.findViewById(R$id.integral_consume_tv);
        this.integral_obtain_tv = (TextView) this.headView.findViewById(R$id.integral_obtain_tv);
        this.tv_exchange = (TextView) this.headView.findViewById(R$id.tv_exchange);
        this.integral_obtain_view = this.headView.findViewById(R$id.integral_obtain_view);
        this.integral_consume_view = this.headView.findViewById(R$id.integral_consume_view);
        this.null_page = this.myActivity.findViewById(R$id.null_page);
        this.lv_list.addHeaderView(this.headView);
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356056829")) {
            ipChange.ipc$dispatch("1356056829", new Object[]{this});
            return;
        }
        this.isFlag = true;
        this.null_page.setVisibility(8);
        requestIntegralList();
        requestPointsIntegral();
        new w2().a(this.myActivity, this.pull_down_view, this.lv_list, new C1382b()).b(this.myActivity, this.pull_down_view, this.lv_list, new C1381a());
        this.integral_obtain_top_llyt.setOnClickListener(new View$OnClickListenerC1383c());
        this.integral_consume_top_llyt.setOnClickListener(new View$OnClickListenerC1384d());
        this.integral_obtain_llyt.setOnClickListener(new View$OnClickListenerC1385e());
        this.integral_consume_llyt.setOnClickListener(new View$OnClickListenerC1386f());
        this.tv_exchange.setOnClickListener(new View$OnClickListenerC1387g());
    }

    private void initScoreTipView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582505785")) {
            ipChange.ipc$dispatch("582505785", new Object[]{this});
            return;
        }
        this.mScoreTipLayout = (LinearLayout) findViewById(R$id.ll_score_tip);
        this.mTvScoreTip = (TextView) findViewById(R$id.tv_score_tip);
        this.mBtnScoreTip = (TextView) findViewById(R$id.btn_score_tip);
    }

    private void initTopView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488751895")) {
            ipChange.ipc$dispatch("-488751895", new Object[]{this});
            return;
        }
        this.integral_obtain_top_llyt = (LinearLayout) findViewById(R$id.integral_obtain_llyt);
        this.integral_consume_top_llyt = (LinearLayout) findViewById(R$id.integral_consume_llyt);
        this.integral_consume_top_tv = (TextView) findViewById(R$id.integral_consume_tv);
        this.integral_obtain_top_tv = (TextView) findViewById(R$id.integral_obtain_tv);
        this.integral_obtain_top_view = findViewById(R$id.integral_obtain_view);
        this.integral_consume_top_view = findViewById(R$id.integral_consume_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPointsIntegral() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922707253")) {
            ipChange.ipc$dispatch("922707253", new Object[]{this});
        } else {
            ((IntegralPresenter) this.mPresenter).requestPointsIntegral(String.valueOf(this.pointIndex));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSumptionIntegral() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "869431423")) {
            ipChange.ipc$dispatch("869431423", new Object[]{this});
        } else {
            ((IntegralPresenter) this.mPresenter).requestSumptionIntegral(String.valueOf(this.sumptionIndex));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485939996")) {
            ipChange.ipc$dispatch("485939996", new Object[]{this});
        } else if (this.isFlag) {
            this.integral_obtain_top_tv.setTextColor(getResources().getColor(R$color.color_111111));
            this.integral_consume_top_tv.setTextColor(getResources().getColor(R$color.color_888888));
            this.integral_consume_top_view.setVisibility(4);
            this.integral_obtain_top_view.setVisibility(0);
        } else {
            this.integral_consume_top_tv.setTextColor(getResources().getColor(R$color.color_111111));
            this.integral_obtain_top_tv.setTextColor(getResources().getColor(R$color.color_888888));
            this.integral_obtain_top_view.setVisibility(4);
            this.integral_consume_top_view.setVisibility(0);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-171262913")) {
            ipChange.ipc$dispatch("-171262913", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i == 10004) {
            Bundle bundle = new Bundle();
            bundle.putString("title", cm2.b(this, R$string.damai_more_aboutintegral));
            DMNav.from(this).withExtras(bundle).toUri("https://mobile.damai.cn/help/help_integral_about.html");
        }
        if (i == 10003) {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "285657675") ? ((Integer) ipChange.ipc$dispatch("285657675", new Object[]{this})).intValue() : R$layout.integral_activity;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596545392")) {
            ipChange.ipc$dispatch("-1596545392", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877405797")) {
            ipChange.ipc$dispatch("-877405797", new Object[]{this});
        } else {
            ((IntegralPresenter) this.mPresenter).setVM(this, (IntegralContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "367089698")) {
            ipChange.ipc$dispatch("367089698", new Object[]{this});
            return;
        }
        this.myActivity = this;
        initScoreTipView();
        initContentView();
        initTopView();
        initData();
        setRightIcon(R$drawable.integral_head_right_icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828167464")) {
            ipChange.ipc$dispatch("-1828167464", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().M());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353994817")) {
            ipChange.ipc$dispatch("-353994817", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791960970")) {
            ipChange.ipc$dispatch("-791960970", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801127925")) {
            ipChange.ipc$dispatch("-1801127925", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877971950")) {
            ipChange.ipc$dispatch("-877971950", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946399760")) {
            ipChange.ipc$dispatch("-946399760", new Object[]{this});
        } else {
            super.onStart();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367741046")) {
            ipChange.ipc$dispatch("1367741046", new Object[]{this});
        } else {
            super.onStop();
        }
    }

    public void requestIntegralList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123379110")) {
            ipChange.ipc$dispatch("-2123379110", new Object[]{this});
        } else {
            ((IntegralPresenter) this.mPresenter).requestIntegralList();
        }
    }

    @Override // cn.damai.mine.contract.IntegralContract.View
    public void returnIntegralList(UserScoreDto userScoreDto) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621215854")) {
            ipChange.ipc$dispatch("1621215854", new Object[]{this, userScoreDto});
        } else if (userScoreDto != null) {
            this.integral_count_tv.setText(userScoreDto.validScore);
            this.integral_surplus_tv.setText(userScoreDto.expiringScore);
            if (TextUtils.isEmpty(userScoreDto.notice)) {
                this.mScoreTipLayout.setVisibility(8);
                return;
            }
            this.mTvScoreTip.setText(userScoreDto.notice);
            if (TextUtils.isEmpty(userScoreDto.noticeUrl)) {
                this.mBtnScoreTip.setVisibility(8);
            } else {
                this.mBtnScoreTip.setVisibility(0);
                this.mBtnScoreTip.setTag(userScoreDto.noticeUrl);
                this.mBtnScoreTip.setOnClickListener(new View$OnClickListenerC1388h());
            }
            this.mScoreTipLayout.setVisibility(0);
        }
    }

    @Override // cn.damai.mine.contract.IntegralContract.View
    public void returnPointsIntegral(AcquireScoreDto acquireScoreDto) {
        List<AcquireScoreDto.AcquireScoreModel> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45177502")) {
            ipChange.ipc$dispatch("-45177502", new Object[]{this, acquireScoreDto});
        } else if (acquireScoreDto == null || (list = acquireScoreDto.acquireScoreDtos) == null) {
        } else {
            if (this.pointIndex == 1) {
                this.acquireScoreDtoList = list;
                if (list.size() != 0) {
                    this.pull_down_view.setVisibility(0);
                } else {
                    this.null_page.setVisibility(0);
                }
                flushPointsAdapter();
                return;
            }
            this.null_page.setVisibility(8);
            if (acquireScoreDto.acquireScoreDtos.size() != 0) {
                int size = this.acquireScoreDtoList.size();
                this.acquireScoreDtoList.addAll(acquireScoreDto.acquireScoreDtos);
                flushPointsAdapter();
                if (size <= 0) {
                    this.lv_list.setSelection(0);
                } else {
                    this.lv_list.setSelection(size - 1);
                }
            }
        }
    }

    @Override // cn.damai.mine.contract.IntegralContract.View
    public void returnSumptionIntegral(LostScoreDto lostScoreDto) {
        List<LostScoreDto.LostScoreModel> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1040603792")) {
            ipChange.ipc$dispatch("-1040603792", new Object[]{this, lostScoreDto});
        } else if (lostScoreDto == null || (list = lostScoreDto.lostScoreDtos) == null) {
        } else {
            if (this.sumptionIndex == 1) {
                this.lostScoreDtoList = list;
                if (list.size() != 0) {
                    this.null_page.setVisibility(8);
                    flushSumptionAdapter();
                } else {
                    this.null_page.setVisibility(0);
                }
                flushSumptionAdapter();
                return;
            }
            this.null_page.setVisibility(8);
            if (lostScoreDto.lostScoreDtos.size() != 0) {
                int size = this.lostScoreDtoList.size();
                this.lostScoreDtoList.addAll(lostScoreDto.lostScoreDtos);
                flushSumptionAdapter();
                if (size <= 0) {
                    this.lv_list.setSelection(0);
                } else {
                    this.lv_list.setSelection(size - 1);
                }
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1951879551") ? (String) ipChange.ipc$dispatch("1951879551", new Object[]{this}) : "我的积分";
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2104528674")) {
            ipChange.ipc$dispatch("-2104528674", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771152358")) {
            ipChange.ipc$dispatch("-1771152358", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380914562")) {
            ipChange.ipc$dispatch("-380914562", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1405287033")) {
            ipChange.ipc$dispatch("1405287033", new Object[]{this});
        }
    }
}
