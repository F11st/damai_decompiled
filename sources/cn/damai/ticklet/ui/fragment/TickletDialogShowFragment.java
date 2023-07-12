package cn.damai.ticklet.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.PriorityTask;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.screenshot.ScreenShotBean;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.member.R$anim;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.ticklet.manager.DataHelper;
import cn.damai.ticklet.net.TickletDetailRequest;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.activity.TickletTransferManageActivity;
import cn.damai.ticklet.ui.adapter.TickletDetailViewPagerAdapter;
import cn.damai.ticklet.ui.observer.ObserverTicket;
import cn.damai.ticklet.utils.UTTimeUtils;
import cn.damai.ticklet.view.TickletDetailViewPager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.cb1;
import tb.er1;
import tb.in2;
import tb.j62;
import tb.nu1;
import tb.rn2;
import tb.un2;
import tb.wh2;
import tb.xn2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDialogShowFragment extends DamaiBaseMvpFragment implements ScreenShotDetector.IScreenShotDetectorListener, TickletTicketCallback, TickletDetailInterface, ObserverTicket {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FROM_DETAIL = 1;
    public static final int FROM_LIST_LOCAL = 3;
    public static final int FROM_LIST_NET = 2;
    public static final String SHOW_TICKLET_FROM_DETAIL = "FROM_DETAIL";
    public static final String SHOW_TICKLET_FROM_SOUVENIR = "FROM_SOUVENIR_PAGE";
    public static final String SHOW_TICKLET_FROM_UNBIND_FACE = "FROM_UNBING_FACE_PAGE";
    private TickletDetailViewPagerAdapter adapter;
    private RelativeLayout floatLayerLayout;
    private FragmentManager fm;
    private String from;
    private Activity mActivity;
    private OnClickCloseListener mOnClickCloseListener;
    private TickletScreenCapture mTickletScreenFragment;
    private FrameLayout mTickletShowAllContainer;
    public String orderId;
    public String performId;
    private int pos;
    public String productSystemId;
    private rn2 server;
    private TicketDeatilResult ticketDetailResults;
    private RelativeLayout ticklet_rl_layout;
    private FragmentTransaction transaction;
    private TextView tvProjectName;
    private UTTimeUtils utTimeUtils;
    private TickletDetailViewPager viewPager;
    private int page = 1;
    private boolean isSwitchVisible = false;
    private int rendererTime = 0;
    ScreenShotDetector.IScreenShotExtraListener screenShotExtraListener = new C2071b();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnClickCloseListener {
        void onClose(int i);

        void updateTicketSate(UserTicketTable userTicketTable);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.fragment.TickletDialogShowFragment$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2070a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2070a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "186990134")) {
                ipChange.ipc$dispatch("186990134", new Object[]{this, view});
            } else if (TickletDialogShowFragment.this.mOnClickCloseListener != null) {
                TickletDialogShowFragment.this.mOnClickCloseListener.onClose(TickletDialogShowFragment.this.viewPager.getCurrentItem());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.fragment.TickletDialogShowFragment$b */
    /* loaded from: classes7.dex */
    public class C2071b implements ScreenShotDetector.IScreenShotExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2071b() {
        }

        @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotExtraListener
        public void onDetected(String str, Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-329424190")) {
                ipChange.ipc$dispatch("-329424190", new Object[]{this, str, activity});
            } else if (TickletDialogShowFragment.this.viewPager == null || TickletDialogShowFragment.this.adapter == null) {
            } else {
                List<UserTicketTable> g = TickletDialogShowFragment.this.adapter.g();
                if (TickletDialogShowFragment.this.mActivity == null || g == null || g.size() <= 0) {
                    return;
                }
                UserTicketTable userTicketTable = g.get(TickletDialogShowFragment.this.viewPager.getCurrentItem());
                if (userTicketTable == null || !userTicketTable.isPaperTicket()) {
                    TickletDialogShowFragment.this.showCapture(userTicketTable, str);
                } else {
                    TickletDialogShowFragment.this.showCapture(userTicketTable, str);
                }
            }
        }
    }

    private List<UserTicketTable> converTicket(List<UserTicketTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123832203")) {
            return (List) ipChange.ipc$dispatch("123832203", new Object[]{this, list});
        }
        if (list != null) {
            Collections.sort(list);
        }
        return list;
    }

    public static TickletDialogShowFragment getInstance(String str, String str2, TicketDeatilResult ticketDeatilResult, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647587969")) {
            return (TickletDialogShowFragment) ipChange.ipc$dispatch("647587969", new Object[]{str, str2, ticketDeatilResult, str3});
        }
        TickletDialogShowFragment tickletDialogShowFragment = new TickletDialogShowFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TicketDetailExtFragment.PERFORM_ID, str);
        bundle.putString("orderId", str2);
        bundle.putSerializable("ticketDeatilResult", ticketDeatilResult);
        bundle.putString("from", str3);
        tickletDialogShowFragment.setArguments(bundle);
        return tickletDialogShowFragment;
    }

    private void goTransferTicketPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16530966")) {
            ipChange.ipc$dispatch("-16530966", new Object[]{this});
        } else if (TextUtils.isEmpty(this.performId)) {
        } else {
            Intent intent = new Intent();
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, this.performId);
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, this.productSystemId);
            intent.setClass(this.mActivity, TickletTransferManageActivity.class);
            startActivity(intent);
        }
    }

    private void initClickListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238589082")) {
            ipChange.ipc$dispatch("-1238589082", new Object[]{this});
            return;
        }
        this.tvProjectName = (TextView) this.rootView.findViewById(R$id.ticklet_float_layer_perform_name);
        ((DMIconFontTextView) this.rootView.findViewById(R$id.dft_close)).setOnClickListener(new View$OnClickListenerC2070a());
    }

    private void initData() {
        TicketDeatilResult ticketDeatilResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2093740258")) {
            ipChange.ipc$dispatch("-2093740258", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.performId = arguments.getString(TicketDetailExtFragment.PERFORM_ID);
            this.orderId = arguments.getString("orderId");
            this.productSystemId = arguments.getString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
            this.ticketDetailResults = (TicketDeatilResult) arguments.getSerializable("ticketDeatilResult");
            this.from = arguments.getString("from");
            this.pos = arguments.getInt("pos");
        }
        rn2 a = rn2.a();
        this.server = a;
        a.registerObserver(this);
        screenBright();
        this.utTimeUtils.n();
        if ((SHOW_TICKLET_FROM_DETAIL.equals(this.from) || SHOW_TICKLET_FROM_SOUVENIR.equals(this.from) || SHOW_TICKLET_FROM_UNBIND_FACE.equals(this.from)) && (ticketDeatilResult = this.ticketDetailResults) != null && ticketDeatilResult.getUserPerformVO() != null && wh2.e(this.ticketDetailResults.getTicketInfoList()) > 0) {
            notifyData(this.ticketDetailResults.getTicketInfoList(), 1);
            return;
        }
        TicketDeatilResult ticketDeatilResult2 = this.ticketDetailResults;
        if (ticketDeatilResult2 != null && ticketDeatilResult2.getTicketInfoList() != null && this.ticketDetailResults.getTicketInfoList().size() > 0) {
            notifyData(this.ticketDetailResults.getTicketInfoList(), 3);
        }
        requestDetailData();
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195908380")) {
            ipChange.ipc$dispatch("-1195908380", new Object[]{this});
            return;
        }
        TickletDetailViewPager tickletDetailViewPager = (TickletDetailViewPager) this.rootView.findViewById(R$id.verticalviewpager);
        this.viewPager = tickletDetailViewPager;
        tickletDetailViewPager.setOffscreenPageLimit(3);
        TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = new TickletDetailViewPagerAdapter(this.mActivity, in2.TICKLET_TICKET_VIEW_FLOAT_LAYER);
        this.adapter = tickletDetailViewPagerAdapter;
        this.viewPager.setAdapter(tickletDetailViewPagerAdapter);
        this.adapter.l(this.viewPager);
        this.adapter.i(this);
        FrameLayout frameLayout = (FrameLayout) this.rootView.findViewById(R$id.ticklet_showall_container);
        this.mTickletShowAllContainer = frameLayout;
        frameLayout.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performFloatDetailErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158427290")) {
            ipChange.ipc$dispatch("1158427290", new Object[]{this, str, str2});
            return;
        }
        xn2.d(xn2.f("场次详情", "mtop.damai.wireless.ticklet2.perform.detail.get", str, str2, " performId:" + this.performId), xn2.TICKLET_FLOAT_NETWORK_ERROR_CODE, str, xn2.TICKLET_FLOAT_NETWORK_ERROR_MSG);
    }

    private void renderGestureFail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117038741")) {
            ipChange.ipc$dispatch("-117038741", new Object[]{this, str});
            return;
        }
        xn2.d(xn2.f(xn2.TICKLET_FLOAT_RENDER_GESTURE_MSG, "", "", "", "performId:" + str), xn2.TICKLET_FLOAT_RENDER_GESTURE_ERROR_CODE, "", xn2.TICKLET_FLOAT_RENDER_GESTURE_MSG);
    }

    private void renderListErrorXFlushMonitor(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116410940")) {
            ipChange.ipc$dispatch("1116410940", new Object[]{this, str, str2, str3});
            return;
        }
        xn2.c(xn2.f(xn2.TICKLET_FLOAT_NETWORK_ERROR_MSG_LIST, "", str, str2, "performId:" + str3), xn2.TICKLET_FLOAT_RENDER_ERROR_CODE, xn2.TICKLET_FLOAT_RENDER_CODE_MSG);
    }

    private void renderNotListErrorXFlushMonitor(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599962449")) {
            ipChange.ipc$dispatch("-599962449", new Object[]{this, str, str2, str3});
            return;
        }
        xn2.c(xn2.f(xn2.TICKLET_FLOAT_NETWORK_ERROR_MSG_NOT_LIST, "", str, str2, "performId:" + str3), xn2.TICKLET_FLOAT_RENDER_ERROR_CODE, xn2.TICKLET_FLOAT_RENDER_CODE_MSG);
    }

    private void requestDetailData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727600056")) {
            ipChange.ipc$dispatch("-727600056", new Object[]{this});
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        TickletDetailRequest tickletDetailRequest = new TickletDetailRequest();
        tickletDetailRequest.performId = this.performId;
        tickletDetailRequest.orderId = this.orderId;
        tickletDetailRequest.productSystemId = this.productSystemId;
        tickletDetailRequest.request(new DMMtopRequestListener<TicketDeatilResult>(TicketDeatilResult.class) { // from class: cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1137814685")) {
                    ipChange2.ipc$dispatch("1137814685", new Object[]{this, str, str2});
                } else {
                    TickletDialogShowFragment.this.performFloatDetailErrorXFlushMonitor(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(final TicketDeatilResult ticketDeatilResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1422723332")) {
                    ipChange2.ipc$dispatch("-1422723332", new Object[]{this, ticketDeatilResult});
                } else if (ticketDeatilResult == null) {
                } else {
                    final ArrayList arrayList = new ArrayList();
                    arrayList.addAll(ticketDeatilResult.getTicketInfoList());
                    nu1.a(new PriorityTask("DETAIL_DB_FLOAT_DATA", this) { // from class: cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.2.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.util.PriorityTask
                        public void doTask() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1891339805")) {
                                ipChange3.ipc$dispatch("-1891339805", new Object[]{this});
                                return;
                            }
                            DataHelper.getInstance().saveOrUpdateTicketTables(arrayList);
                            try {
                                un2.k().g(ticketDeatilResult.getPerformId(), String.valueOf(ticketDeatilResult.getTicketNum()), String.valueOf(er1.c().g(ticketDeatilResult.getPerformId())), in2.e);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    if (ticketDeatilResult.getTicketInfoList() == null) {
                        return;
                    }
                    ticketDeatilResult.setLoadTime(System.currentTimeMillis() - currentTimeMillis);
                    TickletDialogShowFragment.this.ticketDetailResults = ticketDeatilResult;
                    TickletDialogShowFragment.this.notifyData(ticketDeatilResult.getTicketInfoList(), 2);
                }
            }
        });
    }

    private void screenBright() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095177102")) {
            ipChange.ipc$dispatch("-1095177102", new Object[]{this});
        } else {
            j62.b(this.mActivity, 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCapture(final UserTicketTable userTicketTable, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38981502")) {
            ipChange.ipc$dispatch("38981502", new Object[]{this, userTicketTable, str});
        } else {
            new Handler(this.mActivity.getMainLooper()).post(new Runnable() { // from class: cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1746886039")) {
                        ipChange2.ipc$dispatch("1746886039", new Object[]{this});
                    } else if (!(TickletDialogShowFragment.this.mActivity instanceof TicketDeatilActivity) || !((TicketDeatilActivity) TickletDialogShowFragment.this.mActivity).isDialogShowFragmentHide()) {
                        TickletDialogShowFragment.this.showScreenTicklet(userTicketTable, str);
                    } else {
                        ((TicketDeatilActivity) TickletDialogShowFragment.this.mActivity).showDetectView(str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showScreenTicklet(UserTicketTable userTicketTable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1013266678")) {
            ipChange.ipc$dispatch("-1013266678", new Object[]{this, userTicketTable, str});
            return;
        }
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            TickletScreenCapture tickletScreenCapture = new TickletScreenCapture();
            this.mTickletScreenFragment = tickletScreenCapture;
            tickletScreenCapture.setTickletDetailInterface(this);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", userTicketTable);
            bundle.putString(TicketDetailExtFragment.PERFORM_ID, this.performId);
            bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, this.productSystemId);
            bundle.putString("projectId", this.ticketDetailResults.getProjectId());
            bundle.putInt("souvenirState", this.ticketDetailResults.getEsouvenirEnable());
            bundle.putString("from", TickletScreenCapture.CAPTURE_FROM_VOUCHER);
            bundle.putString("imagePath", str);
            this.mTickletScreenFragment.setArguments(bundle);
            FragmentManager childFragmentManager = getChildFragmentManager();
            this.fm = childFragmentManager;
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            this.transaction = beginTransaction;
            beginTransaction.replace(R$id.ticklet_showall_container, this.mTickletScreenFragment);
            if (this.fm.isDestroyed()) {
                return;
            }
            this.transaction.commitAllowingStateLoss();
            this.mTickletShowAllContainer.setVisibility(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526108772")) {
            ipChange.ipc$dispatch("-1526108772", new Object[]{this});
            return;
        }
        this.tvProjectName.setVisibility(0);
        this.tvProjectName.setText(this.ticketDetailResults.getProjectName());
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDetailInterface
    public void captureGoTransferManagePage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780157797")) {
            ipChange.ipc$dispatch("1780157797", new Object[]{this});
        } else {
            goTransferTicketPage();
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void cardCorrespondingNumRequest(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253341714")) {
            ipChange.ipc$dispatch("-1253341714", new Object[]{this, str, str2, str3, str4});
        }
    }

    public int getCurrentItemPos() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1768166343")) {
            return ((Integer) ipChange.ipc$dispatch("1768166343", new Object[]{this})).intValue();
        }
        TickletDetailViewPager tickletDetailViewPager = this.viewPager;
        if (tickletDetailViewPager == null) {
            return 0;
        }
        return tickletDetailViewPager.getCurrentItem();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-764445961") ? ((Integer) ipChange.ipc$dispatch("-764445961", new Object[]{this})).intValue() : R$layout.ticket_show_dialog;
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDetailInterface
    public void goFeedBackPage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111129702")) {
            ipChange.ipc$dispatch("111129702", new Object[]{this, str});
            return;
        }
        Activity activity = this.mActivity;
        ((DamaiBaseActivity) activity).onFeedbackClick(((DamaiBaseActivity) activity).getDetectBean(str), (DamaiBaseActivity) this.mActivity);
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2138371121")) {
            ipChange.ipc$dispatch("2138371121", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletDetailInterface
    public void hideTickletShowAllFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869064704")) {
            ipChange.ipc$dispatch("-869064704", new Object[]{this});
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        this.fm = childFragmentManager;
        if (childFragmentManager == null) {
            this.mTickletScreenFragment = null;
            this.mTickletShowAllContainer.setVisibility(8);
            return;
        }
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        this.transaction = beginTransaction;
        beginTransaction.remove(this.mTickletScreenFragment);
        this.transaction.commitAllowingStateLoss();
        this.mTickletScreenFragment = null;
        this.mTickletShowAllContainer.setVisibility(8);
        j62.b(this.mActivity, 1.0f);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059110886")) {
            ipChange.ipc$dispatch("-1059110886", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212259907")) {
            ipChange.ipc$dispatch("1212259907", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        this.rendererTime = 0;
        initViewPager();
        this.ticklet_rl_layout = (RelativeLayout) this.rootView.findViewById(R$id.ticklet_rl_layout);
        this.floatLayerLayout = (RelativeLayout) this.rootView.findViewById(R$id.ticklet_float_layer_layout);
        initClickListener();
        ScreenShotDetector.k().w(this);
        initData();
    }

    public void notifyData(List<UserTicketTable> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111232819")) {
            ipChange.ipc$dispatch("-111232819", new Object[]{this, list, Integer.valueOf(i)});
            return;
        }
        this.rendererTime++;
        if (i != 1) {
            list = converTicket(new ArrayList(list));
        }
        TicketDeatilResult ticketDeatilResult = this.ticketDetailResults;
        if (ticketDeatilResult != null) {
            if (i == 2) {
                this.utTimeUtils.q(ticketDeatilResult.loadTime);
            } else if (i == 3) {
                this.utTimeUtils.m(ticketDeatilResult.loadTime);
            }
            this.utTimeUtils.l();
            viewRefresh();
            TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = this.adapter;
            if (tickletDetailViewPagerAdapter != null) {
                tickletDetailViewPagerAdapter.j(list);
                this.adapter.k(this.ticketDetailResults, SHOW_TICKLET_FROM_UNBIND_FACE.equals(this.from) ? "1" : null);
                this.adapter.notifyDataSetChanged();
                this.viewPager.setCurrentItem(this.pos);
            }
            if (i == 1) {
                this.utTimeUtils.o(this.mActivity.getWindow().getDecorView());
            } else {
                this.utTimeUtils.p(this.mActivity.getWindow().getDecorView());
            }
            xn2.b(xn2.TICKLET_PERFORM_DETAIL_RENDER_POINT, "mtop.damai.wireless.ticklet2.perform.detail.get");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("取票凭证浮层数据获取失败   ");
        sb.append(i == 3 ? "本地化数据" : "接口数据");
        renderFailXflush(sb.toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55285508")) {
            ipChange.ipc$dispatch("-55285508", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        cb1.b("TimeDown", "-------onActivityCreated  " + getClass().getName());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "888724841")) {
            ipChange.ipc$dispatch("888724841", new Object[]{this, view});
        } else {
            view.getId();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1591542505")) {
            ipChange.ipc$dispatch("-1591542505", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.utTimeUtils = new UTTimeUtils(UTTimeUtils.q);
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_VOUCHER));
        cb1.b("TimeDown", "-------onCreate  " + getClass().getName());
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-983889075")) {
            return (Animation) ipChange.ipc$dispatch("-983889075", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        if (z) {
            return AnimationUtils.loadAnimation(getActivity(), R$anim.dialog_show);
        }
        return AnimationUtils.loadAnimation(getActivity(), R$anim.dialog_hide);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264625687")) {
            ipChange.ipc$dispatch("264625687", new Object[]{this});
            return;
        }
        super.onDestroy();
        TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = this.adapter;
        if (tickletDetailViewPagerAdapter != null) {
            tickletDetailViewPagerAdapter.h();
        }
        rn2 rn2Var = this.server;
        if (rn2Var != null) {
            rn2Var.removeObserver(this);
        }
        cb1.b("TimeDown", "-------onDestroy  " + getClass().getName());
        this.isSwitchVisible = false;
    }

    @Override // cn.damai.commonbusiness.screenshot.ScreenShotDetector.IScreenShotDetectorListener
    public void onFeedbackClick(ScreenShotBean screenShotBean, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1688771921")) {
            ipChange.ipc$dispatch("-1688771921", new Object[]{this, screenShotBean, activity});
        } else {
            ((DamaiBaseActivity) this.mActivity).onFeedbackClick(screenShotBean, activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100788325")) {
            ipChange.ipc$dispatch("-1100788325", new Object[]{this});
            return;
        }
        super.onPause();
        cb1.b("TimeDown", "-------onPause  " + getClass().getName());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883086796")) {
            ipChange.ipc$dispatch("1883086796", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.isSwitchVisible) {
            TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = this.adapter;
            if (tickletDetailViewPagerAdapter != null) {
                tickletDetailViewPagerAdapter.notifyDataSetChanged();
            }
            this.isSwitchVisible = false;
        }
        ScreenShotDetector.k().x(this.screenShotExtraListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1294196446")) {
            ipChange.ipc$dispatch("-1294196446", new Object[]{this, bundle});
            return;
        }
        super.onSaveInstanceState(bundle);
        cb1.b("TimeDown", "-------onSaveInstanceState  " + getClass().getName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1057683537")) {
            ipChange.ipc$dispatch("-1057683537", new Object[]{this});
            return;
        }
        super.onStart();
        cb1.b("TimeDown", "-------onStart  " + getClass().getName());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1641245911")) {
            ipChange.ipc$dispatch("1641245911", new Object[]{this});
            return;
        }
        super.onStop();
        this.isSwitchVisible = true;
        cb1.b("TimeDown", "-------onStop  " + getClass().getName());
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void renderFailXflush(String str) {
        TicketDeatilResult ticketDeatilResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948505218")) {
            ipChange.ipc$dispatch("948505218", new Object[]{this, str});
        } else if ((SHOW_TICKLET_FROM_DETAIL.equals(this.from) || SHOW_TICKLET_FROM_SOUVENIR.equals(this.from) || SHOW_TICKLET_FROM_UNBIND_FACE.equals(this.from)) && (ticketDeatilResult = this.ticketDetailResults) != null && ticketDeatilResult.getTicketInfoList() != null && this.ticketDetailResults.getTicketInfoList().size() > 0) {
            if (this.rendererTime == 1) {
                renderNotListErrorXFlushMonitor("", str, this.performId);
            }
        } else if (this.rendererTime == 2) {
            renderListErrorXFlushMonitor("", str, this.performId);
        }
    }

    public void setOnClickCloseListener(OnClickCloseListener onClickCloseListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513481328")) {
            ipChange.ipc$dispatch("513481328", new Object[]{this, onClickCloseListener});
        } else {
            this.mOnClickCloseListener = onClickCloseListener;
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void showTickletDialog(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230576464")) {
            ipChange.ipc$dispatch("-230576464", new Object[]{this, str, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.ticklet.ui.observer.ObserverTicket
    public void update(UserTicketTable userTicketTable) {
        TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "398160398")) {
            ipChange.ipc$dispatch("398160398", new Object[]{this, userTicketTable});
        } else if (userTicketTable == null || (tickletDetailViewPagerAdapter = this.adapter) == null) {
        } else {
            tickletDetailViewPagerAdapter.n(userTicketTable);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void viewPageSlide(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269637486")) {
            ipChange.ipc$dispatch("269637486", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.viewPager.setCurrentItem(i);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletTicketCallback
    public void viewPageViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345174082")) {
            ipChange.ipc$dispatch("-345174082", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public static TickletDialogShowFragment getInstance(String str, String str2, String str3, TicketDeatilResult ticketDeatilResult, int i, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-222198282")) {
            return (TickletDialogShowFragment) ipChange.ipc$dispatch("-222198282", new Object[]{str, str2, str3, ticketDeatilResult, Integer.valueOf(i), str4});
        }
        TickletDialogShowFragment tickletDialogShowFragment = new TickletDialogShowFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TicketDetailExtFragment.PERFORM_ID, str);
        bundle.putString("orderId", str2);
        bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str3);
        bundle.putSerializable("ticketDeatilResult", ticketDeatilResult);
        bundle.putString("from", str4);
        bundle.putInt("pos", i);
        tickletDialogShowFragment.setArguments(bundle);
        return tickletDialogShowFragment;
    }
}
