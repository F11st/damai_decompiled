package cn.damai.commonbusiness.wannasee.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.bean.RankBean;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.bean.FocusEvent;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.wannasee.adapter.MultiAdapter;
import cn.damai.commonbusiness.wannasee.bean.PageData;
import cn.damai.commonbusiness.wannasee.bean.PageType;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.commonbusiness.wannasee.listener.MultiClickUt;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.OnErrClickListener;
import cn.damai.commonbusiness.wannasee.listener.OnWannaBeanListener;
import cn.damai.commonbusiness.wannasee.listener.PtrChildHandler;
import cn.damai.commonbusiness.wannasee.listener.RefreshCallBack;
import cn.damai.commonbusiness.wannasee.model.WannaSeeModel;
import cn.damai.commonbusiness.wannasee.ut.CardType;
import cn.damai.login.LoginManager;
import cn.damai.message.observer.Action;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.RefreshHeaderLayout;
import cn.damai.uikit.irecycler.helper.UpLoadMorePanel;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.List;
import tb.cb2;
import tb.m62;
import tb.mu0;
import tb.pb;
import tb.t3;
import tb.v3;
import tb.x3;
import tb.xr;
import tb.z91;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MultipleListFragment extends BaseFuncFragment implements PtrChildHandler, UpLoadMorePanel.LoadMoreEventListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_REQ_LOGIN = 4387;
    private static final String EXTRA_TYPE = "EXTRA_TYPE";
    public boolean isEnableDeleteItem;
    private FragmentActivity mActivity;
    private MultiAdapter mAdapter;
    private int mItemOffset;
    private OnWannaBeanListener mListener;
    private ViewGroup mMainView;
    private WannaSeeModel mModel;
    private UpLoadMorePanel mMorePanel;
    private DamaiRootRecyclerView mRecyclerView;
    private PageType mType;
    public String mUserId;
    private String mUtPageName;
    private WantSeePosterTips wantSeePosterTips;
    public boolean isNeedLogin = true;
    private boolean isViewCreated = false;
    private boolean isFocusChanged = false;
    private xr mFocusSubscriber = new xr();
    private t3 mLoginListener = new c();
    private boolean ensureInitRecyclerView = false;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements OnErrClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnErrClickListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-277622765")) {
                ipChange.ipc$dispatch("-277622765", new Object[]{this});
            } else {
                MultipleListFragment.this.openLoginActivity();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b extends k {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PtrFrameLayout c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MultipleListFragment multipleListFragment, boolean z, PtrFrameLayout ptrFrameLayout) {
            super(z);
            this.c = ptrFrameLayout;
        }

        @Override // cn.damai.commonbusiness.wannasee.fragment.MultipleListFragment.k, cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(PageData<List> pageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1544332321")) {
                ipChange.ipc$dispatch("1544332321", new Object[]{this, pageData});
                return;
            }
            super.onBizSuccess(pageData);
            PtrFrameLayout ptrFrameLayout = this.c;
            if (ptrFrameLayout != null) {
                ptrFrameLayout.refreshComplete();
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.fragment.MultipleListFragment.k, cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1387122915")) {
                ipChange.ipc$dispatch("-1387122915", new Object[]{this, str, str2});
                return;
            }
            super.onBizFail(str, str2);
            PtrFrameLayout ptrFrameLayout = this.c;
            if (ptrFrameLayout != null) {
                ptrFrameLayout.refreshComplete();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c extends t3 {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // tb.t3, cn.damai.login.havana.ILoginListener
        public void onLoginSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-241510692")) {
                ipChange.ipc$dispatch("-241510692", new Object[]{this});
                return;
            }
            MultipleListFragment multipleListFragment = MultipleListFragment.this;
            if (multipleListFragment.isNeedLogin) {
                multipleListFragment.tryLoadIfLoginChanged();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements Action<FocusEvent> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(FocusEvent focusEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-405363631")) {
                ipChange.ipc$dispatch("-405363631", new Object[]{this, focusEvent});
            } else {
                MultipleListFragment.this.isFocusChanged = true;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e extends x3 {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utNoteClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "741628448")) {
                ipChange.ipc$dispatch("741628448", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else {
                pb.j(z91.u().z(MultipleListFragment.this.mUtPageName, null, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, i));
            }
        }

        @Override // tb.x3, cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utProjectClick(ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1347248474")) {
                ipChange.ipc$dispatch("-1347248474", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            } else {
                pb.j(z91.u().A(MultipleListFragment.this.mUtPageName, projectItemBean.id, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, i, projectItemBean.recommendHintType));
            }
        }

        @Override // tb.x3, cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utRankClick(RankBean rankBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "794618506")) {
                ipChange.ipc$dispatch("794618506", new Object[]{this, rankBean, Integer.valueOf(i)});
            } else {
                pb.j(z91.u().z(MultipleListFragment.this.mUtPageName, null, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, i));
            }
        }

        @Override // tb.x3, cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utRecommendClick(RecommendProjects recommendProjects, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1907040817")) {
                ipChange.ipc$dispatch("-1907040817", new Object[]{this, recommendProjects, Integer.valueOf(i)});
            } else if (recommendProjects == null) {
            } else {
                ProjectItemBean bricksBean = ProjectItemBean.toBricksBean(recommendProjects.getItem(i));
                z91 u = z91.u();
                String str = MultipleListFragment.this.mUtPageName;
                String spmc = recommendProjects.getSpmc();
                pb.j(u.C(str, spmc, "item_" + i, MultipleListFragment.this.mType.tabName, bricksBean != null ? bricksBean.id : null));
            }
        }

        @Override // tb.x3, cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utRecommendFollowClick(RecommendProjects recommendProjects, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1791135200")) {
                ipChange.ipc$dispatch("-1791135200", new Object[]{this, recommendProjects, Integer.valueOf(i)});
            } else if (recommendProjects == null) {
            } else {
                ProjectItemBean bricksBean = ProjectItemBean.toBricksBean(recommendProjects.getItem(i));
                pb.j(z91.u().B(MultipleListFragment.this.mUtPageName, recommendProjects.getSpmc(), "favorite", MultipleListFragment.this.mType.tabName, bricksBean != null ? bricksBean.id : null));
            }
        }

        @Override // tb.x3, cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utRecommendRefreshClick(RecommendProjects recommendProjects, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-162905620")) {
                ipChange.ipc$dispatch("-162905620", new Object[]{this, recommendProjects, Integer.valueOf(i)});
            } else if (recommendProjects == null) {
            } else {
                ProjectItemBean bricksBean = ProjectItemBean.toBricksBean(recommendProjects.getItem(i));
                pb.j(z91.u().D(MultipleListFragment.this.mUtPageName, recommendProjects.getSpmc(), Constants.Event.CHANGE, MultipleListFragment.this.mType.tabName, bricksBean != null ? bricksBean.id : null));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class f extends v3 {
        private static transient /* synthetic */ IpChange $ipChange;

        f(Activity activity, MultiClickUt multiClickUt) {
            super(activity, multiClickUt);
        }

        @Override // tb.v3, cn.damai.commonbusiness.wannasee.listener.OnMultiListClickListener
        public void onRecommendFollowSuccessClick(RecommendProjects recommendProjects, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1323144834")) {
                ipChange.ipc$dispatch("1323144834", new Object[]{this, recommendProjects, Integer.valueOf(i)});
                return;
            }
            ProjectItemBean bricksBean = ProjectItemBean.toBricksBean(recommendProjects.getItem(i));
            if (bricksBean == null) {
                return;
            }
            WantSeePosterTips.b.c cVar = WantSeePosterTips.b.c.INSTANCE;
            cVar.p(bricksBean.schema);
            cVar.r(bricksBean.verticalPic);
            MultipleListFragment.this.wantSeePosterTips.setPageSource(cVar);
            MultipleListFragment.this.wantSeePosterTips.hideCloseView();
            MultipleListFragment.this.wantSeePosterTips.showAnim();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class g implements OnItemBindListener<JSONObject> {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(@Nullable View view, JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "622492323")) {
                ipChange.ipc$dispatch("622492323", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            } else {
                z91.o(view, MultipleListFragment.this.mUtPageName, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, jSONObject.getString("id") != null ? jSONObject.getString("id") : "", i, null);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(@Nullable JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-827417970")) {
                ipChange.ipc$dispatch("-827417970", new Object[]{this, jSONObject, Integer.valueOf(i)});
            } else {
                pb.j(z91.u().z(MultipleListFragment.this.mUtPageName, null, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, i));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class h implements MultiAdapter.Exposure {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureNote(View view, NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "547244107")) {
                ipChange.ipc$dispatch("547244107", new Object[]{this, view, noteBean, Integer.valueOf(i)});
            } else {
                z91.o(view, MultipleListFragment.this.mUtPageName, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, noteBean.id, i, CardType.note);
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureProject(View view, ProjectItemBean projectItemBean, int i) {
            MarketTagBean gotTopTag;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1395182513")) {
                ipChange.ipc$dispatch("1395182513", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
                return;
            }
            String str = null;
            if (projectItemBean.ifIsNewMarketTag() && (gotTopTag = projectItemBean.gotTopTag(true)) != null) {
                str = gotTopTag.type;
            }
            z91.p(view, MultipleListFragment.this.mUtPageName, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, projectItemBean.id, i, null, projectItemBean.recommendHintType, str);
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureRank(View view, RankBean rankBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1436860225")) {
                ipChange.ipc$dispatch("-1436860225", new Object[]{this, view, rankBean, Integer.valueOf(i)});
            } else {
                z91.o(view, MultipleListFragment.this.mUtPageName, MultipleListFragment.this.mType.tabIndex, MultipleListFragment.this.mType.tabName, rankBean.id, i, rankBean.isRankListType() ? CardType.ranklist : CardType.shoppinglist);
            }
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureRecommend(View view, RecommendProjects recommendProjects, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1665996454")) {
                ipChange.ipc$dispatch("-1665996454", new Object[]{this, view, recommendProjects, Integer.valueOf(i)});
                return;
            }
            ProjectItemBean bricksBean = ProjectItemBean.toBricksBean(recommendProjects.getItem(i));
            if (bricksBean == null || view == null) {
                return;
            }
            String str = MultipleListFragment.this.mUtPageName;
            String spmc = recommendProjects.getSpmc();
            z91.l(view, str, spmc, "item_" + i, MultipleListFragment.this.mType.tabName, bricksBean.id);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class i implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Object tag;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1959931828")) {
                return ((Boolean) ipChange.ipc$dispatch("1959931828", new Object[]{this, view})).booleanValue();
            }
            MultipleListFragment multipleListFragment = MultipleListFragment.this;
            if (!multipleListFragment.isEnableDeleteItem || multipleListFragment.mType == PageType.RECORD || (tag = view.getTag()) == null) {
                return false;
            }
            if (tag instanceof ProjectItemBean) {
                ProjectItemBean projectItemBean = (ProjectItemBean) tag;
                MultipleListFragment.this.showFollowDialog(projectItemBean.id, projectItemBean.isNewItem == 1 ? 7 : 6, projectItemBean.pos);
                return true;
            }
            if (tag instanceof RankBean) {
                RankBean rankBean = (RankBean) tag;
                MultipleListFragment.this.showFollowDialog(rankBean.id, rankBean.type, rankBean.pos);
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class j implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        j(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "19851650")) {
                ipChange.ipc$dispatch("19851650", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            MultipleListFragment.this.requestCancelFollow(this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class k implements OnBizListener<PageData<List>> {
        private static transient /* synthetic */ IpChange $ipChange;
        final boolean a;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public class a implements OnErrClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.wannasee.listener.OnErrClickListener
            public void onClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1847825929")) {
                    ipChange.ipc$dispatch("1847825929", new Object[]{this});
                } else {
                    MultipleListFragment.this.tryLoad(true);
                }
            }
        }

        public k(boolean z) {
            this.a = z;
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(PageData<List> pageData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "909308765")) {
                ipChange.ipc$dispatch("909308765", new Object[]{this, pageData});
                return;
            }
            if (this.a) {
                MultipleListFragment.this.hideErrResView();
                if (cb2.d(pageData.data)) {
                    MultipleListFragment.this.showEmptyView(MultipleListFragment.this.mType == null ? "" : MultipleListFragment.this.mType.getPageEmptyMsg());
                }
            }
            if (pageData.hasMore) {
                MultipleListFragment.this.mMorePanel.d();
            } else {
                MultipleListFragment.this.mMorePanel.g();
            }
            MultipleListFragment.this.mAdapter.m(pageData.data, this.a);
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2011771039")) {
                ipChange.ipc$dispatch("-2011771039", new Object[]{this, str, str2});
            } else if (this.a) {
                MultipleListFragment.this.showErrorView(str, str2, new a());
            } else {
                ToastUtil.i(str2);
                MultipleListFragment.this.mMorePanel.d();
            }
        }
    }

    private void ensureInitRecyclerView(DamaiRootRecyclerView damaiRootRecyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365439754")) {
            ipChange.ipc$dispatch("-1365439754", new Object[]{this, damaiRootRecyclerView});
        } else if (this.ensureInitRecyclerView) {
        } else {
            this.ensureInitRecyclerView = true;
            damaiRootRecyclerView.setRefreshEnabled(false);
            damaiRootRecyclerView.setIsAutoToDefault(false);
            damaiRootRecyclerView.setLoadMoreEnabled(true);
            damaiRootRecyclerView.setItemAnimator(null);
            UpLoadMorePanel upLoadMorePanel = new UpLoadMorePanel(this.mActivity, damaiRootRecyclerView, this);
            this.mMorePanel = upLoadMorePanel;
            upLoadMorePanel.a();
            PageType pageType = PageType.RECORD;
            PageType pageType2 = this.mType;
            if (pageType == pageType2) {
                this.mItemOffset = m62.a(this.mActivity, 6.0f);
                int a2 = m62.a(this.mActivity, 15.0f);
                damaiRootRecyclerView.setPadding(a2, 0, a2, 0);
                damaiRootRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.commonbusiness.wannasee.fragment.MultipleListFragment.9
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-17417006")) {
                            ipChange2.ipc$dispatch("-17417006", new Object[]{this, rect, view, recyclerView, state});
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams instanceof RecyclerView.LayoutParams) {
                            if (((RecyclerView.LayoutParams) layoutParams).getViewAdapterPosition() > 1) {
                                rect.set(MultipleListFragment.this.mItemOffset, MultipleListFragment.this.mItemOffset, MultipleListFragment.this.mItemOffset, MultipleListFragment.this.mItemOffset);
                            } else {
                                rect.set(0, 0, 0, 0);
                            }
                        }
                    }
                });
            } else if (PageType.VALID_SHOW == pageType2 || PageType.SHOW == pageType2) {
                damaiRootRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: cn.damai.commonbusiness.wannasee.fragment.MultipleListFragment.10
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "980496226")) {
                            ipChange2.ipc$dispatch("980496226", new Object[]{this, rect, view, recyclerView, state});
                        } else if (recyclerView.getChildAdapterPosition(view) > 1) {
                            rect.bottom = m62.a(mu0.a(), 9.0f);
                        } else {
                            rect.bottom = 0;
                        }
                    }
                });
            }
        }
    }

    public static MultipleListFragment instance(PageType pageType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1429260498")) {
            return (MultipleListFragment) ipChange.ipc$dispatch("-1429260498", new Object[]{pageType});
        }
        MultipleListFragment multipleListFragment = new MultipleListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_TYPE, pageType);
        multipleListFragment.setArguments(bundle);
        return multipleListFragment;
    }

    private boolean isStaggeredLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1985102662") ? ((Boolean) ipChange.ipc$dispatch("-1985102662", new Object[]{this})).booleanValue() : PageType.RECORD == this.mType;
    }

    private boolean isViewPrepared() {
        FragmentActivity fragmentActivity;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1140425024") ? ((Boolean) ipChange.ipc$dispatch("1140425024", new Object[]{this})).booleanValue() : (this.mType == null || !this.isViewCreated || (fragmentActivity = this.mActivity) == null || fragmentActivity.isFinishing()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLoginActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1110869716")) {
            ipChange.ipc$dispatch("1110869716", new Object[]{this});
            return;
        }
        FragmentActivity fragmentActivity = this.mActivity;
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        LoginManager.k().y(this, new Intent(), 4387);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCancelFollow(String str, int i2, final int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "695512114")) {
            ipChange.ipc$dispatch("695512114", new Object[]{this, str, Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (this.mModel != null) {
            startProgressDialog();
            this.mModel.cancelFollowData(str, String.valueOf(i2), new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.commonbusiness.wannasee.fragment.MultipleListFragment.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-311465913")) {
                        ipChange2.ipc$dispatch("-311465913", new Object[]{this, str2, str3});
                        return;
                    }
                    MultipleListFragment.this.stopProgressDialog();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "网络不稳定 辛苦稍后重试";
                    }
                    ToastUtil.i(str3);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(FollowDataBean followDataBean) {
                    int i4;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1993189575")) {
                        ipChange2.ipc$dispatch("-1993189575", new Object[]{this, followDataBean});
                        return;
                    }
                    MultipleListFragment.this.stopProgressDialog();
                    ToastUtil.f(MultipleListFragment.this.getString(R$string.damai_mycollect_delete_success));
                    if (MultipleListFragment.this.mAdapter == null || (i4 = i3) <= -1 || i4 >= MultipleListFragment.this.mAdapter.getItemCount()) {
                        return;
                    }
                    MultipleListFragment.this.mAdapter.f().remove(i3);
                    if (MultipleListFragment.this.mAdapter != null) {
                        MultipleListFragment.this.mAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFollowDialog(String str, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2140353732")) {
            ipChange.ipc$dispatch("-2140353732", new Object[]{this, str, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        DMDialog dMDialog = new DMDialog(getActivity());
        dMDialog.v("是否取消想看?");
        dMDialog.i("否", null);
        dMDialog.n("是", new j(str, i2, i3));
        dMDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryLoad(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215764115")) {
            ipChange.ipc$dispatch("1215764115", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.isNeedLogin) {
            if (!LoginManager.k().q()) {
                showLoginView(new a());
            } else {
                this.mModel.load(z, new k(z));
            }
        } else {
            this.mModel.load(z, new k(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryLoadIfLoginChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818585735")) {
            ipChange.ipc$dispatch("-1818585735", new Object[]{this});
        } else if (isViewPrepared() && isShowingLoginView() && LoginManager.k().q()) {
            hideErrResView();
            tryLoad(true);
        }
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861991142")) {
            return ((Boolean) ipChange.ipc$dispatch("-861991142", new Object[]{this, ptrFrameLayout, view, view2})).booleanValue();
        }
        return LoginManager.k().q() && isViewPrepared() && isAdded();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-338013209") ? ((Integer) ipChange.ipc$dispatch("-338013209", new Object[]{this})).intValue() : R$layout.fragment_multiple_list;
    }

    @Override // cn.damai.commonbusiness.wannasee.fragment.BaseFuncFragment
    public ViewGroup getMainView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-679693945") ? (ViewGroup) ipChange.ipc$dispatch("-679693945", new Object[]{this}) : this.mMainView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.wannasee.fragment.BaseFuncFragment, cn.damai.common.app.base.BaseFragment
    public void initView() {
        ViewGroup.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339609773")) {
            ipChange.ipc$dispatch("-339609773", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        this.isViewCreated = true;
        this.mMainView = (ViewGroup) this.rootView.findViewById(R$id.main_view);
        super.initView();
        this.wantSeePosterTips = (WantSeePosterTips) this.rootView.findViewById(R$id.want_see_poster_tips);
        this.mRecyclerView = (DamaiRootRecyclerView) this.rootView.findViewById(R$id.multi_list);
        if (isStaggeredLayout()) {
            int a2 = m62.a(mu0.a(), 21.0f);
            this.mRecyclerView.setPadding(a2, 0, a2, 0);
            this.mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        } else {
            this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        }
        FragmentActivity fragmentActivity = this.mActivity;
        MultiAdapter multiAdapter = new MultiAdapter(fragmentActivity, new f(fragmentActivity, new e()), true);
        this.mAdapter = multiAdapter;
        multiAdapter.l(new g());
        this.mAdapter.i(new h());
        this.mAdapter.k(new i());
        this.mRecyclerView.setAdapter(this.mAdapter);
        RefreshHeaderLayout refreshHeaderLayout = this.mRecyclerView.mRefreshHeaderContainer;
        if (refreshHeaderLayout != null && (layoutParams = refreshHeaderLayout.getLayoutParams()) != null) {
            layoutParams.height = 1;
        }
        ensureInitRecyclerView(this.mRecyclerView);
        tryLoad(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "189229575")) {
            ipChange.ipc$dispatch("189229575", new Object[]{this, bundle});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mType = (PageType) arguments.getSerializable(EXTRA_TYPE);
        }
        if (this.mType == null) {
            this.mType = PageType.RECORD;
        }
        WannaSeeModel wannaSeeModel = new WannaSeeModel(this.mType, this.mUserId, this.mListener, this.isNeedLogin);
        this.mModel = wannaSeeModel;
        wannaSeeModel.setUtPageName(this.mUtPageName);
        LoginManager.k().c(this.mLoginListener);
        this.mFocusSubscriber.b(this.mType.isProject() ? FocusEvent.EVENT_NAME_PROJECT_FOCUS_CHANGED : FocusEvent.EVENT_NAME_NOTE_FOCUS_CHANGED, new d());
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-598694137")) {
            ipChange.ipc$dispatch("-598694137", new Object[]{this});
            return;
        }
        super.onDestroy();
        LoginManager.k().C(this.mLoginListener);
        xr xrVar = this.mFocusSubscriber;
        if (xrVar != null) {
            xrVar.a();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436986658")) {
            ipChange.ipc$dispatch("1436986658", new Object[]{this});
            return;
        }
        this.isViewCreated = false;
        super.onDestroyView();
    }

    @Override // cn.damai.commonbusiness.wannasee.listener.PtrChildHandler
    public void onRefreshBegin(PtrFrameLayout ptrFrameLayout, RefreshCallBack refreshCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1874066331")) {
            ipChange.ipc$dispatch("1874066331", new Object[]{this, ptrFrameLayout, refreshCallBack});
        } else {
            this.mModel.load(true, new b(this, true, ptrFrameLayout));
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331217116")) {
            ipChange.ipc$dispatch("331217116", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.isFocusChanged) {
            this.isFocusChanged = false;
            tryLoad(true);
        }
    }

    public void setListener(OnWannaBeanListener onWannaBeanListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304767402")) {
            ipChange.ipc$dispatch("1304767402", new Object[]{this, onWannaBeanListener});
        } else {
            this.mListener = onWannaBeanListener;
        }
    }

    public void setUtPageName(String str, String str2, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822521477")) {
            ipChange.ipc$dispatch("-1822521477", new Object[]{this, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.mUtPageName = str;
        this.mUserId = str2;
        this.isEnableDeleteItem = z;
        this.isNeedLogin = z2;
    }

    @Override // cn.damai.uikit.irecycler.helper.UpLoadMorePanel.LoadMoreEventListener
    public void startLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "512782981")) {
            ipChange.ipc$dispatch("512782981", new Object[]{this});
        } else {
            tryLoad(false);
        }
    }
}
