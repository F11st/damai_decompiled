package cn.damai.tetris.page;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.NestScrollErrResView;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.pageut.PageUtExecutor;
import cn.damai.message.observer.Action;
import cn.damai.tetris.IOnResultListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.adapter.AbsAdapter;
import cn.damai.tetris.core.holder.AbsViewHolder;
import cn.damai.tetris.core.msg.IMessage;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.uikit.view.DMProgressDialog;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import tb.c21;
import tb.ja;
import tb.m91;
import tb.xr;
import tb.yl2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class AbsFragment<T> extends Fragment implements OnLoadMoreListener, OnRefreshListener, IMessage {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CONMENTS_REQUEST = 5001;
    public static final String CURRENT_AB = "ABTrackInfo";
    public static final int FINISH_ACTIVITY = 1000;
    public static final int FINISH_REQUEST = 2000;
    public static final int FOLLOW_REQUEST = 8001;
    public static final int LOGIN_REQUEST = 3000;
    public static final int ORDER_PAY_ERROR = 1001;
    public static final int SCROLL_TOP_BTN_CLICK = 7001;
    public static final int SYSTEM_MSG_DESTORY = 11004;
    public static final int SYSTEM_MSG_PAUSE = 11003;
    public static final int SYSTEM_MSG_RESUME = 11005;
    public static final int SYSTEM_MSG_START = 11002;
    public static final int SYSTEM_MSG_VISIBLEHINT = 11001;
    public static final String TAG_SHOW_RANK_FOOT_UI = "tag_show_rank_foot_ui";
    public static final int TETRIS_BIZ_CODE_SHARE = 7002;
    public static final int TIXING_REQUEST = 6001;
    public static final int VERCODERESULT = 4000;
    AbsAdapter absAdapter;
    protected LinearLayout bottomBarParent;
    private Action commonAction;
    AbsFragment<T>.g listener;
    protected ViewGroup mBottomView;
    protected View mEmptyFoot;
    private ResponseErrorPage mErrorPage;
    View mErrorView;
    View mLineView;
    protected DamaiRootRecyclerView mRecyclerView;
    private NestScrollErrResView mResView;
    private RelativeLayout mRootView;
    public DMProgressDialog progressDialog;
    Map properties;
    boolean showToTop = true;
    private boolean enableLineView = true;
    private boolean isViewCreated = false;
    private boolean isLazyLoaded = false;
    protected f cdnReqHandler = new f(this);
    public xr mDMMessage = new xr();
    protected ja baseContext = new ja();

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class ReqRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private String cityCode;
        private String pattern;
        private WeakReference<f> reference;
        private String version;

        public ReqRunnable(f fVar, String str, String str2, String str3) {
            this.reference = new WeakReference<>(fVar);
            this.pattern = str;
            this.version = str2;
            this.cityCode = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1764385066")) {
                ipChange.ipc$dispatch("-1764385066", new Object[]{this});
                return;
            }
            Message message = new Message();
            message.what = 0;
            message.obj = AbsFragment.this.getJsonFromCDN(new CdnRequestUtil(this.pattern, this.version, this.cityCode));
            if (this.reference.get() != null) {
                this.reference.get().sendMessage(message);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnLoadMoreListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
        public void onLoadMore(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1498691987")) {
                ipChange.ipc$dispatch("-1498691987", new Object[]{this, view});
                return;
            }
            AbsFragment.this.hookOnLoadMore(view);
            AbsFragment.this.onLoadMore(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements Action<cn.damai.tetris.core.msg.Message> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(cn.damai.tetris.core.msg.Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1533254066")) {
                ipChange.ipc$dispatch("-1533254066", new Object[]{this, message});
                return;
            }
            AbsFragment.this.hookOnMessage(message);
            AbsFragment.this.onMessage(message.what, message.value);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1098639661")) {
                ipChange.ipc$dispatch("-1098639661", new Object[]{this, view});
                return;
            }
            AbsFragment.this.sendMsg(new cn.damai.tetris.core.msg.Message(7001, new Object()));
            AbsFragment.this.mRecyclerView.scrollToPosition(0);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d(AbsFragment absFragment) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-111297749")) {
                ipChange.ipc$dispatch("-111297749", new Object[]{this, dialogInterface});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class e implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "323335262")) {
                ipChange.ipc$dispatch("323335262", new Object[]{this, Integer.valueOf(i)});
            } else {
                AbsFragment.this.onRefresh();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class f extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<AbsFragment> a;

        public f(AbsFragment absFragment) {
            this.a = new WeakReference<>(absFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "493315662")) {
                ipChange.ipc$dispatch("493315662", new Object[]{this, message});
            } else if (message.what == 0 && this.a.get() != null) {
                this.a.get().onCdnResponse((String) message.obj);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class g implements IOnResultListener {
        private static transient /* synthetic */ IpChange $ipChange;
        AbsFragment a;

        public g(AbsFragment absFragment, AbsFragment absFragment2) {
            this.a = absFragment2;
        }

        @Override // cn.damai.tetris.IOnResultListener
        public void onResult(int i, int i2, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1755983466")) {
                ipChange.ipc$dispatch("-1755983466", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
                return;
            }
            AbsFragment absFragment = this.a;
            if (absFragment == null || !absFragment.getUserVisibleHint()) {
                return;
            }
            this.a.onFragmentResult(i, i2, intent);
        }
    }

    private void checkLazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1661980246")) {
            ipChange.ipc$dispatch("1661980246", new Object[]{this});
        } else if (!this.isLazyLoaded && this.isViewCreated && getUserVisibleHint()) {
            this.isLazyLoaded = true;
            lazyLoad();
        }
    }

    @NonNull
    private void initRecycleView(DamaiRootRecyclerView damaiRootRecyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-886932976")) {
            ipChange.ipc$dispatch("-886932976", new Object[]{this, damaiRootRecyclerView});
        } else if (damaiRootRecyclerView == null) {
        } else {
            c21.b(damaiRootRecyclerView);
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(1);
            damaiRootRecyclerView.setLayoutManager(linearLayoutManager);
            damaiRootRecyclerView.setRefreshEnabled(true);
            damaiRootRecyclerView.setIsAutoToDefault(false);
            damaiRootRecyclerView.setOnRefreshListener(this);
            damaiRootRecyclerView.setOnLoadMoreListener(new a());
            damaiRootRecyclerView.setLoadMoreEnabled(true);
            damaiRootRecyclerView.setItemAnimator(null);
            damaiRootRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.tetris.page.AbsFragment.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1955667614")) {
                        ipChange2.ipc$dispatch("-1955667614", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    } else if (!AbsFragment.this.enableLineView || AbsFragment.this.mLineView == null) {
                    } else {
                        if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                            AbsFragment.this.mLineView.setVisibility(8);
                        } else {
                            AbsFragment.this.mLineView.setVisibility(0);
                        }
                    }
                }
            });
            damaiRootRecyclerView.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(getActivity()));
            this.mEmptyFoot = LayoutInflater.from(getActivity()).inflate(R$layout.damai_pageview_footer_empty, (ViewGroup) null);
            this.mEmptyFoot.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            damaiRootRecyclerView.addFooterView(this.mEmptyFoot);
            this.mEmptyFoot.setVisibility(8);
            AbsAdapter<AbsViewHolder, T> adapter = getAdapter(this.baseContext);
            this.absAdapter = adapter;
            if (adapter != null) {
                damaiRootRecyclerView.setAdapter(adapter);
            }
            this.mDMMessage = new xr();
            this.commonAction = new b();
            this.mDMMessage.b(this.baseContext.a(), this.commonAction);
            xr xrVar = this.mDMMessage;
            xrVar.b(this.baseContext.a() + 11004, this.commonAction);
            xr xrVar2 = this.mDMMessage;
            xrVar2.b(this.baseContext.a() + 11003, this.commonAction);
            xr xrVar3 = this.mDMMessage;
            xrVar3.b(this.baseContext.a() + 11002, this.commonAction);
            xr xrVar4 = this.mDMMessage;
            xrVar4.b(this.baseContext.a() + 11001, this.commonAction);
        }
    }

    private void showToTopBtn(@NonNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076972993")) {
            ipChange.ipc$dispatch("-1076972993", new Object[]{this, view});
            return;
        }
        final View findViewById = view.findViewById(R$id.list_move_top);
        findViewById.setOnClickListener(new c());
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.tetris.page.AbsFragment.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1492390944")) {
                    ipChange2.ipc$dispatch("-1492390944", new Object[]{this, recyclerView, Integer.valueOf(i)});
                } else {
                    super.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1210724415")) {
                    ipChange2.ipc$dispatch("1210724415", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                AbsFragment absFragment = AbsFragment.this;
                if (absFragment.showToTop) {
                    if (absFragment.isRecyclerViewOverPage(recyclerView)) {
                        findViewById.setVisibility(0);
                    } else {
                        findViewById.setVisibility(8);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addComponent(BaseResponse baseResponse, BaseLayer baseLayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-835072955")) {
            ipChange.ipc$dispatch("-835072955", new Object[]{this, baseResponse, baseLayer});
        } else if (baseResponse == null || m91.a(baseResponse.layers) || baseLayer == null) {
        } else {
            baseResponse.layers.add(baseLayer);
        }
    }

    public void addData(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540725321")) {
            ipChange.ipc$dispatch("1540725321", new Object[]{this, t});
            return;
        }
        AbsAdapter absAdapter = this.absAdapter;
        if (absAdapter != null) {
            absAdapter.a(t);
            this.absAdapter.notifyDataSetChanged();
        }
    }

    public void disAbleToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518248608")) {
            ipChange.ipc$dispatch("-1518248608", new Object[]{this});
        } else {
            this.showToTop = false;
        }
    }

    public void disableLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266360523")) {
            ipChange.ipc$dispatch("-266360523", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setLoadMoreEnabled(false);
        }
    }

    public void disableRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323767201")) {
            ipChange.ipc$dispatch("-1323767201", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setRefreshEnabled(false);
        }
    }

    public void enableDividerLine(boolean z) {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1678940602")) {
            ipChange.ipc$dispatch("-1678940602", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.enableLineView = z;
        if (z || (view = this.mLineView) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void enableLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2110660268")) {
            ipChange.ipc$dispatch("-2110660268", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setLoadMoreEnabled(true);
        }
    }

    public void enableRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-136334752")) {
            ipChange.ipc$dispatch("-136334752", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setRefreshEnabled(true);
        }
    }

    public abstract AbsAdapter<AbsViewHolder, T> getAdapter(ja jaVar);

    public ja getBaseContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1762277490") ? (ja) ipChange.ipc$dispatch("1762277490", new Object[]{this}) : this.baseContext;
    }

    public String getJsonFromCDN(CdnRequestUtil cdnRequestUtil) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "677717397") ? (String) ipChange.ipc$dispatch("677717397", new Object[]{this, cdnRequestUtil}) : cdnRequestUtil.c();
    }

    public Map getProperties() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1492115300") ? (Map) ipChange.ipc$dispatch("1492115300", new Object[]{this}) : this.properties;
    }

    public int getRecycleViewId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025021512")) {
            return ((Integer) ipChange.ipc$dispatch("1025021512", new Object[]{this})).intValue();
        }
        return -1;
    }

    public void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "524980141")) {
            ipChange.ipc$dispatch("524980141", new Object[]{this});
            return;
        }
        View view = this.mErrorView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideErrorViewV2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037449105")) {
            ipChange.ipc$dispatch("2037449105", new Object[]{this});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.hide();
        }
    }

    public void hideLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1911083147")) {
            ipChange.ipc$dispatch("-1911083147", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
            this.mEmptyFoot.setVisibility(0);
        }
    }

    public void hideNoMoreV2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734605214")) {
            ipChange.ipc$dispatch("734605214", new Object[]{this});
        } else if (this.mRecyclerView != null) {
            this.mEmptyFoot.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hookOnLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158814621")) {
            ipChange.ipc$dispatch("1158814621", new Object[]{this, view});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hookOnMessage(cn.damai.tetris.core.msg.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1362487458")) {
            ipChange.ipc$dispatch("-1362487458", new Object[]{this, message});
        }
    }

    public boolean isLazyLoaded() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-418164461") ? ((Boolean) ipChange.ipc$dispatch("-418164461", new Object[]{this})).booleanValue() : this.isLazyLoaded;
    }

    public boolean isRecyclerViewOverPage(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196867034")) {
            return ((Boolean) ipChange.ipc$dispatch("196867034", new Object[]{this, recyclerView})).booleanValue();
        }
        if (recyclerView != null) {
            try {
                View childAt = recyclerView.getChildAt(0);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (childAt != null && layoutManager != null) {
                    return layoutManager.getPosition(childAt) > 10;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean isViewCreated() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1215739485") ? ((Boolean) ipChange.ipc$dispatch("-1215739485", new Object[]{this})).booleanValue() : this.isViewCreated;
    }

    public void lazyLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170501400")) {
            ipChange.ipc$dispatch("1170501400", new Object[]{this});
        }
    }

    public void loadMoreResetV2(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865919404")) {
            ipChange.ipc$dispatch("1865919404", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setKeepListenLoadMore(z);
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
            this.mEmptyFoot.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-826706812")) {
            ipChange.ipc$dispatch("-826706812", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        onRefresh();
    }

    public void onCdnResponse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789592013")) {
            ipChange.ipc$dispatch("-789592013", new Object[]{this, str});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36217539")) {
            ipChange.ipc$dispatch("-36217539", new Object[]{this, bundle});
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1269661145")) {
            return (View) ipChange.ipc$dispatch("-1269661145", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        if (getRecycleViewId() > 0) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        return layoutInflater.inflate(R$layout.fragment_tetris_default, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164357187")) {
            ipChange.ipc$dispatch("-164357187", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        this.isLazyLoaded = false;
        stopProgressDialog();
        sendMsg(new cn.damai.tetris.core.msg.Message(11004, null), 11004);
        xr xrVar = this.mDMMessage;
        if (xrVar != null) {
            xrVar.a();
            this.mDMMessage = null;
        }
        super.onDestroy();
        if ((getActivity() instanceof DamaiBaseActivity) && this.listener != null) {
            ((DamaiBaseActivity) getActivity()).removeResultListener(this.listener);
            this.listener = null;
        }
        this.mRootView = null;
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.clearOnScrollListeners();
            this.mRecyclerView.setOnLoadMoreListener(null);
            this.mRecyclerView.setOnRefreshListener(null);
            this.mRecyclerView = null;
        }
        this.mBottomView = null;
        this.mEmptyFoot = null;
        this.mLineView = null;
        this.baseContext.setActivity(null);
    }

    public void onFragmentResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213298083")) {
            ipChange.ipc$dispatch("1213298083", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        }
    }

    public abstract void onLoadMore(View view);

    public abstract void onMessage(int i, Object obj);

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919990977")) {
            ipChange.ipc$dispatch("1919990977", new Object[]{this});
            return;
        }
        sendMsg(new cn.damai.tetris.core.msg.Message(11003, null), 11003);
        super.onPause();
    }

    public abstract void onRefresh();

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResponseError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163531438")) {
            ipChange.ipc$dispatch("163531438", new Object[]{this, str, str2, str3});
            return;
        }
        this.mRecyclerView.setVisibility(8);
        ResponseErrorPage responseErrorPage = this.mErrorPage;
        if (responseErrorPage == null || (!responseErrorPage.isShown() && this.mErrorPage.getParent() == null)) {
            ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(getActivity(), str, str2, str3);
            this.mErrorPage = responseErrorPage2;
            responseErrorPage2.setVisibility(0);
            this.mErrorPage.hideTitle();
            this.mErrorPage.setRefreshListener(new e());
            this.mBottomView.addView(this.mErrorPage, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1651882955")) {
            ipChange.ipc$dispatch("-1651882955", new Object[]{this});
            return;
        }
        this.mRecyclerView.setVisibility(0);
        try {
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setVisibility(8);
                this.mBottomView.removeView(this.mErrorPage);
                this.mErrorPage = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037964646")) {
            ipChange.ipc$dispatch("1037964646", new Object[]{this});
            return;
        }
        sendMsg(new cn.damai.tetris.core.msg.Message(11005, null), 11005);
        super.onResume();
        if (this.properties == null || !getUserVisibleHint()) {
            return;
        }
        cn.damai.common.user.c.e().O(getActivity(), this.properties);
        Log.e("abtest", "abs onResume updatePageProperties : size : " + this.properties.size());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963095765")) {
            ipChange.ipc$dispatch("1963095765", new Object[]{this});
            return;
        }
        sendMsg(new cn.damai.tetris.core.msg.Message(11002, null), 11002);
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205805398")) {
            ipChange.ipc$dispatch("1205805398", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        this.isViewCreated = true;
        this.mBottomView = (ViewGroup) view;
        this.baseContext.setActivity(getActivity());
        if (getRecycleViewId() > 0) {
            this.mRecyclerView = (DamaiRootRecyclerView) view.findViewById(getRecycleViewId());
        } else {
            this.mRecyclerView = (DamaiRootRecyclerView) view.findViewById(R$id.teris_page_irecyclerview);
            this.mRootView = (RelativeLayout) view.findViewById(R$id.tetris_root_container);
        }
        this.bottomBarParent = (LinearLayout) view.findViewById(R$id.teris_page_bottombar);
        initRecycleView(this.mRecyclerView);
        if (getRecycleViewId() <= 0) {
            View findViewById = view.findViewById(R$id.teris_page_empty_view);
            this.mErrorView = findViewById;
            findViewById.setVisibility(8);
            this.mLineView = view.findViewById(R$id.view_line);
            if (showToTop()) {
                showToTopBtn(view);
            }
        }
        yl2.a(this.baseContext);
        checkLazyLoad();
        if (getActivity() instanceof DamaiBaseActivity) {
            AbsFragment<T>.g gVar = new g(this, this);
            this.listener = gVar;
            ((DamaiBaseActivity) getActivity()).addResultListener(gVar);
        }
    }

    public void refreshFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123660502")) {
            ipChange.ipc$dispatch("-123660502", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setRefreshing(false);
        }
    }

    public void requestCdn(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1437968274")) {
            ipChange.ipc$dispatch("1437968274", new Object[]{this, str, str2, str3});
        } else {
            new Thread(new ReqRunnable(this.cdnReqHandler, str, str2, str3)).start();
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage
    public void sendMsg(cn.damai.tetris.core.msg.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658506614")) {
            ipChange.ipc$dispatch("-1658506614", new Object[]{this, message});
        } else {
            xr.c(this.baseContext.a(), message);
        }
    }

    public void setData(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586601560")) {
            ipChange.ipc$dispatch("-1586601560", new Object[]{this, t});
            return;
        }
        AbsAdapter absAdapter = this.absAdapter;
        if (absAdapter != null) {
            absAdapter.b(t);
            this.absAdapter.notifyDataSetChanged();
        }
    }

    public void setExAdapter(RecyclerView.Adapter adapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2023129556")) {
            ipChange.ipc$dispatch("2023129556", new Object[]{this, adapter});
        } else if (this.absAdapter == null || adapter == null || adapter.getItemCount() <= 0) {
        } else {
            this.absAdapter.c(adapter);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887373326")) {
            ipChange.ipc$dispatch("1887373326", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (this.baseContext == null) {
            ja jaVar = new ja();
            this.baseContext = jaVar;
            jaVar.setActivity(getActivity());
        }
        sendMsg(new cn.damai.tetris.core.msg.Message(11001, Boolean.valueOf(z)), 11001);
        checkLazyLoad();
    }

    public void showErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260977432")) {
            ipChange.ipc$dispatch("-260977432", new Object[]{this});
            return;
        }
        View view = this.mErrorView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void showErrorViewV2(String str, String str2, OnErrClickListener onErrClickListener) {
        FragmentActivity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040934292")) {
            ipChange.ipc$dispatch("2040934292", new Object[]{this, str, str2, onErrClickListener});
            return;
        }
        if (this.mResView == null && this.mRootView != null && (activity = getActivity()) != null) {
            NestScrollErrResView nestScrollErrResView = new NestScrollErrResView(activity);
            this.mResView = nestScrollErrResView;
            this.mRootView.addView(nestScrollErrResView, -1, -1);
        }
        NestScrollErrResView nestScrollErrResView2 = this.mResView;
        if (nestScrollErrResView2 != null) {
            nestScrollErrResView2.showErrorView(str, str2, onErrClickListener);
        }
    }

    public void showLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1388699354")) {
            ipChange.ipc$dispatch("1388699354", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
            this.mEmptyFoot.setVisibility(8);
        }
    }

    public void showLoadMoreV2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152042626")) {
            ipChange.ipc$dispatch("-1152042626", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setKeepListenLoadMore(false);
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(0);
            this.mEmptyFoot.setVisibility(8);
        }
    }

    public void showNoMoreV2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260579581")) {
            ipChange.ipc$dispatch("-260579581", new Object[]{this});
        } else {
            showNoMoreV2(null);
        }
    }

    public void showNoMoreV3(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2032312361")) {
            ipChange.ipc$dispatch("-2032312361", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setKeepListenLoadMore(false);
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
            if (TextUtils.isEmpty(str)) {
                str = "只有这么多了";
            }
            TextView textView = (TextView) this.mEmptyFoot.findViewById(R$id.foot_tv);
            ImageView imageView = (ImageView) this.mEmptyFoot.findViewById(R$id.foot_icon);
            if (textView != null) {
                textView.setText(str);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setImageDrawable(getResources().getDrawable(i));
            }
            this.mEmptyFoot.setVisibility(0);
        }
    }

    public boolean showToTop() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1019952575") ? ((Boolean) ipChange.ipc$dispatch("1019952575", new Object[]{this})).booleanValue() : this.showToTop;
    }

    public void startProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1838495551")) {
            ipChange.ipc$dispatch("-1838495551", new Object[]{this});
        } else if (getActivity() == null || getActivity().isFinishing()) {
        } else {
            if (this.progressDialog == null) {
                DMProgressDialog a2 = new DMProgressDialog(getActivity()).a();
                this.progressDialog = a2;
                a2.setOnDismissListener(new d(this));
            }
            if (!isAdded() || this.progressDialog.isShowing()) {
                return;
            }
            this.progressDialog.show();
        }
    }

    public void stopProgressDialog() {
        DMProgressDialog dMProgressDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647326651")) {
            ipChange.ipc$dispatch("1647326651", new Object[]{this});
        } else if (getActivity() == null || getActivity().isFinishing() || (dMProgressDialog = this.progressDialog) == null) {
        } else {
            dMProgressDialog.dismiss();
            this.progressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateAB(GlobalConfig globalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509974304")) {
            ipChange.ipc$dispatch("-509974304", new Object[]{this, globalConfig});
        } else if (getActivity() == null || !(getActivity() instanceof DamaiBaseActivity)) {
        } else {
            HashMap hashMap = new HashMap();
            if (globalConfig != null && !TextUtils.isEmpty(globalConfig.pabBucket)) {
                hashMap.put("ABTrackInfo", globalConfig.pabBucket);
            }
            if (getUserVisibleHint()) {
                Map<String, String> g2 = cn.damai.common.user.c.e().g(getActivity());
                if (g2 != null) {
                    g2.putAll(hashMap);
                    hashMap = g2;
                }
                cn.damai.common.user.c.e().O(getActivity(), hashMap);
                if (getActivity() instanceof PageUtExecutor.FragmentPropertiesProvider) {
                    ((PageUtExecutor.FragmentPropertiesProvider) getActivity()).put(globalConfig.pageName, hashMap);
                    Log.e("abtest", " ===== fragment update 1 put  size : " + hashMap.size() + "， name : " + globalConfig.pageName);
                }
                Log.e("abtest", " ===== fragment update 2 updatePageProperties size : " + hashMap.size() + "， name : " + globalConfig.pageName);
                this.properties = hashMap;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateB(BaseResponse baseResponse) {
        GlobalConfig globalConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408796502")) {
            ipChange.ipc$dispatch("-1408796502", new Object[]{this, baseResponse});
        } else if (baseResponse == null || (globalConfig = baseResponse.globalConfig) == null) {
        } else {
            updateB(globalConfig.pageName, globalConfig);
        }
    }

    public void sendMsg(cn.damai.tetris.core.msg.Message message, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125931961")) {
            ipChange.ipc$dispatch("125931961", new Object[]{this, message, Integer.valueOf(i)});
            return;
        }
        xr.c(this.baseContext.a() + i, message);
    }

    public void showNoMoreV2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214091763")) {
            ipChange.ipc$dispatch("-1214091763", new Object[]{this, str});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView != null) {
            damaiRootRecyclerView.setKeepListenLoadMore(false);
            this.mRecyclerView.setLoadMoreStatus(LoadMoreFooterView.Status.THE_END);
            this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
            String str2 = TextUtils.isEmpty(str) ? "只有这么多了" : str;
            View findViewById = this.mEmptyFoot.findViewById(R$id.id_foot_rank_define_layout);
            View findViewById2 = this.mEmptyFoot.findViewById(R$id.id_foot_normal);
            if (TextUtils.equals(TAG_SHOW_RANK_FOOT_UI, str)) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(8);
            } else {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
            }
            TextView textView = (TextView) this.mEmptyFoot.findViewById(R$id.foot_tv);
            if (textView != null) {
                textView.setText(str2);
            }
            this.mEmptyFoot.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateB(String str, GlobalConfig globalConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1932501825")) {
            ipChange.ipc$dispatch("1932501825", new Object[]{this, str, globalConfig});
        } else if (getActivity() == null || !(getActivity() instanceof DamaiBaseActivity)) {
        } else {
            HashMap hashMap = new HashMap();
            if (globalConfig != null && globalConfig.getBuzUTMap() != null) {
                hashMap.putAll(globalConfig.getBuzUTMap());
            }
            if (getUserVisibleHint()) {
                cn.damai.common.user.c.e().L(getActivity(), str);
                cn.damai.common.user.c.e().l(getActivity(), new a.b().i(str).j(hashMap));
            }
        }
    }

    protected void updateB(String str, JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141414543")) {
            ipChange.ipc$dispatch("-1141414543", new Object[]{this, str, jSONArray});
        } else if (getActivity() == null || !(getActivity() instanceof DamaiBaseActivity)) {
        } else {
            HashMap hashMap = new HashMap();
            if (jSONArray != null) {
                hashMap.put("ABTrackInfo", jSONArray.toJSONString());
            }
            if (getUserVisibleHint()) {
                cn.damai.common.user.c.e().L(getActivity(), str);
                cn.damai.common.user.c.e().l(getActivity(), new a.b().i(str).j(hashMap));
            }
        }
    }
}
