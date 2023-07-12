package cn.damai.evaluate.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.comment.bean.CommentTextDoBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0525a;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.evaluate.adapter.TickletToEvaluateAdapter;
import cn.damai.evaluate.request.CommentListRequest;
import cn.damai.evaluate.request.ToCommentListRequest;
import cn.damai.issue.net.ToEvaListResponse;
import cn.damai.message.observer.Action;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.b23;
import tb.g41;
import tb.t60;
import tb.un2;
import tb.yn2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class TickletToCommentFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private int hasMore;
    private View headerView;
    private ImageView imgeGift;
    private IRecyclerView irc;
    private boolean isHttpRequestFinish = true;
    private boolean isImageLoadSuccess = false;
    private LinearLayout mErrorPageView;
    private String mPagingKey;
    private TickletToEvaluateAdapter mTickletToEvaluateAdapter;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.evaluate.ui.TickletToCommentFragment$a */
    /* loaded from: classes5.dex */
    public class C1084a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1084a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2099126398")) {
                ipChange.ipc$dispatch("2099126398", new Object[]{this, obj});
            } else {
                TickletToCommentFragment.this.onRefresh();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.evaluate.ui.TickletToCommentFragment$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC1085b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ToEvaListResponse a;

        View$OnClickListenerC1085b(ToEvaListResponse toEvaListResponse) {
            this.a = toEvaListResponse;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1883594740")) {
                ipChange.ipc$dispatch("1883594740", new Object[]{this, view});
            } else if (TextUtils.isEmpty(this.a.commentGiftLink) || TickletToCommentFragment.this.mActivity == null) {
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("url", this.a.commentGiftLink);
                DMNav.from(TickletToCommentFragment.this.mActivity).withExtras(bundle).toUri(NavUri.b(C3834a.C3837c.d));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.evaluate.ui.TickletToCommentFragment$c */
    /* loaded from: classes5.dex */
    public class C1086c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1086c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "423118759")) {
                ipChange.ipc$dispatch("423118759", new Object[]{this, c0501d});
            } else {
                TickletToCommentFragment.this.imgeGift.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.evaluate.ui.TickletToCommentFragment$d */
    /* loaded from: classes5.dex */
    public class C1087d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1087d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1141137412")) {
                ipChange.ipc$dispatch("-1141137412", new Object[]{this, c0502e});
            } else if (c0502e == null || c0502e.b == null) {
                TickletToCommentFragment.this.imgeGift.setVisibility(8);
            } else {
                TickletToCommentFragment.this.imgeGift.setVisibility(0);
                TickletToCommentFragment.this.imgeGift.setImageBitmap(c0502e.b);
                TickletToCommentFragment.this.isImageLoadSuccess = true;
            }
        }
    }

    private void fetchNewCommentListData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024772970")) {
            ipChange.ipc$dispatch("-1024772970", new Object[]{this});
            return;
        }
        CommentListRequest commentListRequest = new CommentListRequest();
        commentListRequest.targetType = "0";
        commentListRequest.commentType = "32";
        commentListRequest.onTop = "true";
        commentListRequest.pageIndex = "1";
        commentListRequest.pageSize = "10";
        commentListRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) { // from class: cn.damai.evaluate.ui.TickletToCommentFragment.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "764370521")) {
                    ipChange2.ipc$dispatch("764370521", new Object[]{this, str, str2});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CommentsResultBean commentsResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1490451390")) {
                    ipChange2.ipc$dispatch("1490451390", new Object[]{this, commentsResultBean});
                } else {
                    TickletToCommentFragment.this.refreshHeaderView(commentsResultBean);
                }
            }
        });
    }

    private void fetchToCommentListData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605388703")) {
            ipChange.ipc$dispatch("-605388703", new Object[]{this});
            return;
        }
        if (getUserVisibleHint()) {
            startProgressDialog();
        }
        ToCommentListRequest toCommentListRequest = new ToCommentListRequest();
        toCommentListRequest.pagingKey = this.mPagingKey;
        this.isHttpRequestFinish = false;
        toCommentListRequest.request(new DMMtopRequestListener<ToEvaListResponse>(ToEvaListResponse.class) { // from class: cn.damai.evaluate.ui.TickletToCommentFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "772129880")) {
                    ipChange2.ipc$dispatch("772129880", new Object[]{this, str, str2});
                    return;
                }
                TickletToCommentFragment.this.stopProgressDialog();
                TickletToCommentFragment.this.isHttpRequestFinish = true;
                TickletToCommentFragment.this.mTickletToEvaluateAdapter.clear();
                TickletToCommentFragment.this.irc.setVisibility(8);
                TickletToCommentFragment.this.mErrorPageView.setVisibility(0);
                TickletToCommentFragment tickletToCommentFragment = TickletToCommentFragment.this;
                tickletToCommentFragment.onResponseError(str2, str, "mtop.damai.wireless.ticklet.comment.get", tickletToCommentFragment.mErrorPageView, true);
                TickletToCommentFragment.this.toCommentListErrorXFlushMonitor(str, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ToEvaListResponse toEvaListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "369295907")) {
                    ipChange2.ipc$dispatch("369295907", new Object[]{this, toEvaListResponse});
                    return;
                }
                TickletToCommentFragment.this.stopProgressDialog();
                TickletToCommentFragment.this.mErrorPageView.setVisibility(8);
                TickletToCommentFragment.this.irc.setVisibility(0);
                TickletToCommentFragment.this.refreshUI(toEvaListResponse);
            }
        });
    }

    public static TickletToCommentFragment getInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818220197")) {
            return (TickletToCommentFragment) ipChange.ipc$dispatch("-818220197", new Object[]{str, str2});
        }
        TickletToCommentFragment tickletToCommentFragment = new TickletToCommentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("projectId", str);
        bundle.putString(g41.ISSUE_PARAM_IPID, str2);
        tickletToCommentFragment.setArguments(bundle);
        return tickletToCommentFragment;
    }

    private void giftImageLoad(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768431280")) {
            ipChange.ipc$dispatch("-768431280", new Object[]{this, str});
        } else {
            C0504a.b().e(str).n(new C1087d()).e(new C1086c()).f();
        }
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1606799546")) {
            ipChange.ipc$dispatch("1606799546", new Object[]{this});
            return;
        }
        this.irc = (IRecyclerView) this.rootView.findViewById(R$id.ticklet_history_list_irecyclerview);
        TickletToEvaluateAdapter tickletToEvaluateAdapter = new TickletToEvaluateAdapter(this.mActivity);
        this.mTickletToEvaluateAdapter = tickletToEvaluateAdapter;
        this.irc.setAdapter(tickletToEvaluateAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.irc.setLayoutManager(linearLayoutManager);
        this.irc.setRefreshEnabled(true);
        this.irc.setIsAutoToDefault(false);
        this.irc.setOnRefreshListener(this);
        this.irc.setOnLoadMoreListener(this);
        this.irc.setLoadMoreEnabled(true);
        this.irc.getLoadMoreFooterView().setVisibility(8);
        View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.ticklet_tocomment_topflipper, (ViewGroup) null);
        this.headerView = inflate;
        this.irc.addHeaderView(this.headerView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((FrameLayout) inflate.findViewById(R$id.tocomment_topflipper_container)).getLayoutParams();
        layoutParams.leftMargin = t60.a(this.mActivity, 21.0f);
        layoutParams.rightMargin = t60.a(this.mActivity, 21.0f);
        this.irc.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this.mActivity));
    }

    private void initPageView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772237039")) {
            ipChange.ipc$dispatch("772237039", new Object[]{this});
            return;
        }
        this.mErrorPageView = (LinearLayout) this.rootView.findViewById(R$id.errorPageView);
        this.imgeGift = (ImageView) this.rootView.findViewById(R$id.ticklet_tocomment_gift);
    }

    private void onListenerCommentPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289701513")) {
            ipChange.ipc$dispatch("-1289701513", new Object[]{this});
        } else {
            this.mDMMessage.b("comment_publish_success", new C1084a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshHeaderView(CommentsResultBean commentsResultBean) {
        List<CommentsItemBean> data;
        CommentTextDoBean commentTextDoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-763876188")) {
            ipChange.ipc$dispatch("-763876188", new Object[]{this, commentsResultBean});
            return;
        }
        ViewFlipper viewFlipper = (ViewFlipper) this.headerView.findViewById(R$id.viewflipper);
        if (commentsResultBean == null || (data = commentsResultBean.getData()) == null || data.size() <= 0) {
            return;
        }
        viewFlipper.removeAllViews();
        for (CommentsItemBean commentsItemBean : data) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.ticklet_tocomment_viewflipper_layout, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.ticklet_comment_header);
            TextView textView = (TextView) inflate.findViewById(R$id.ticklet_comment_content);
            CommentUserDoBean userDO = commentsItemBean.getUserDO();
            if (userDO != null && !TextUtils.isEmpty(userDO.getHeaderImage())) {
                C0504a.b().c(userDO.getHeaderImage()).g(imageView);
            }
            List<CommentTextDoBean> textDOList = commentsItemBean.getTextDOList();
            if (textDOList != null && textDOList.size() > 0 && (commentTextDoBean = textDOList.get(0)) != null && !TextUtils.isEmpty(commentTextDoBean.getValue())) {
                textView.setText(commentTextDoBean.getValue());
            }
            viewFlipper.addView(inflate);
        }
        viewFlipper.startFlipping();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(ToEvaListResponse toEvaListResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487104954")) {
            ipChange.ipc$dispatch("-487104954", new Object[]{this, toEvaListResponse});
            return;
        }
        this.irc.setRefreshing(false);
        if (toEvaListResponse != null) {
            this.mPagingKey = toEvaListResponse.getPagingKey();
            List<ToEvaListResponse.EvaluateInfo> performCardInfoList = toEvaListResponse.getPerformCardInfoList();
            if (performCardInfoList != null && performCardInfoList.size() > 0) {
                this.mErrorPageView.setVisibility(8);
                if (this.hasMore == 1) {
                    this.mTickletToEvaluateAdapter.c(performCardInfoList);
                } else {
                    this.mTickletToEvaluateAdapter.setData(performCardInfoList);
                }
                this.hasMore = Integer.parseInt(toEvaListResponse.getHasMore());
                this.isHttpRequestFinish = true;
            } else {
                if (TextUtils.isEmpty(this.mPagingKey)) {
                    this.mTickletToEvaluateAdapter.clear();
                }
                this.isHttpRequestFinish = true;
                this.mErrorPageView.setVisibility(0);
                onResponseError(3, getString(R$string.ticklet_tocomment_list_empty_tips), "", "", this.mErrorPageView, true);
            }
            if (TextUtils.isEmpty(toEvaListResponse.commentGiftIcon) || this.isImageLoadSuccess) {
                return;
            }
            giftImageLoad(toEvaListResponse.commentGiftIcon);
            ((RelativeLayout.LayoutParams) this.imgeGift.getLayoutParams()).bottomMargin = (DisplayMetrics.getheightPixels(t60.b(this.mActivity)) * 40) / 100;
            this.imgeGift.setOnClickListener(new View$OnClickListenerC1085b(toEvaListResponse));
            return;
        }
        this.isHttpRequestFinish = true;
        this.mErrorPageView.setVisibility(0);
        onResponseError(3, getString(R$string.ticklet_tocomment_list_empty_tips), "", "", this.mErrorPageView, true);
    }

    private void resetPageState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636582240")) {
            ipChange.ipc$dispatch("636582240", new Object[]{this});
            return;
        }
        this.mPagingKey = "";
        this.hasMore = 0;
        this.imgeGift.setVisibility(8);
        this.isImageLoadSuccess = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCommentListErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361571683")) {
            ipChange.ipc$dispatch("1361571683", new Object[]{this, str, str2});
        } else if ("FAIL_SYS_SESSION_EXPIRED".equals(str)) {
        } else {
            b23.a(yn2.a("mtop.damai.wireless.ticklet.comment.get", str, str2), "-5830", "票夹待评价列表加载失败");
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1052890140") ? ((Integer) ipChange.ipc$dispatch("1052890140", new Object[]{this})).intValue() : R$layout.ticklet_tocomment_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215922668")) {
            ipChange.ipc$dispatch("215922668", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        resetPageState();
        fetchToCommentListData();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525470785")) {
            ipChange.ipc$dispatch("-525470785", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1350535298")) {
            ipChange.ipc$dispatch("-1350535298", new Object[]{this});
            return;
        }
        if (this.mActivity == null) {
            this.mActivity = getActivity();
        }
        setDamaiUTKeyBuilder(new C0525a.C0527b().j(new HashMap()).i(un2.TICKLET_MYCOMMENT_LIST_PAGE));
        initPageView();
        initIRecyclerView();
        fetchToCommentListData();
        fetchNewCommentListData();
        onListenerCommentPublishSuccess();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540881892")) {
            ipChange.ipc$dispatch("1540881892", new Object[]{this, view});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782571737")) {
            ipChange.ipc$dispatch("1782571737", new Object[]{this, view});
        } else if (this.hasMore == 1 && this.isHttpRequestFinish) {
            fetchToCommentListData();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640434619")) {
            ipChange.ipc$dispatch("640434619", new Object[]{this});
        } else if (this.isHttpRequestFinish) {
            resetPageState();
            fetchToCommentListData();
        }
    }
}
