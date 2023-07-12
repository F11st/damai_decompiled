package cn.damai.comment.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.comment.R$color;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.comment.adapter.CommentDetailAdapter;
import cn.damai.comment.bean.CommentBaseBean;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.bean.CommentProjectInfoBean;
import cn.damai.comment.bean.CommentRepertoireInfoBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.contract.CommentsDetailContract;
import cn.damai.comment.presenter.CommentDetailPresenter;
import cn.damai.comment.request.PraiseRequest;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.comment.util.EvaluateUserInfoUtil;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.evaluate.ui.item.EvaluateItemDataBinder;
import cn.damai.evaluate.view.DMEvaluateDetailHeadView;
import cn.damai.evaluate.view.DMEvaluateDetailPraiseView;
import cn.damai.login.LoginManager;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import cn.damai.uikit.view.BottomActionDialog;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.UserTagView;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.C9548pb;
import tb.al;
import tb.bl;
import tb.cb2;
import tb.cl;
import tb.cs;
import tb.dl;
import tb.g41;
import tb.kg2;
import tb.m62;
import tb.pf0;
import tb.t60;
import tb.xr;
import tb.yk;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CommentDetailActivity extends DamaiBaseActivity<CommentDetailPresenter, CommentsDetailContract.Model> implements CommentsDetailContract.View, OnRefreshListener, OnLoadMoreListener, PraiseRequest.PraiseRequestCallBack, EvaluateItemDataBinder.EvaluateItemUTReportListener, EvaluateItemDataBinder.EvaluateItemOtherListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMAvatar avatar;
    private ImageView commentUserVipTag;
    private IRecyclerView irc;
    private boolean isRefresh;
    private boolean isShowSoftInput;
    private boolean isVEvaluate;
    private ImageView mBack2Top;
    private RelativeLayout mCommentAndStar;
    private CommentDetailAdapter mCommentDetailAdapter;
    private CommentsItemBean mCurrentItemBean;
    private List<CommentsItemBean> mCurrentItems;
    private CommentProjectInfoBean mCurrentProjectInfoBean;
    private CommentRepertoireInfoBean mCurrentRepertoireInfoBean;
    private TextView mErrorTips;
    private LinearLayout mErrorView;
    private HandlerC0449g mHandler;
    private LinearLayoutManager mLinearLayoutManager;
    private CommentsItemBean mMainCommentItemBean;
    private DMEvaluateDetailHeadView mMainEvaluateHeadCardView;
    private EditText mReplyContent;
    private int mScrollDistance;
    private TextView mSendComment;
    private TextView mTitleMore;
    private String mainCommentId;
    private PraiseRequest praiseRequest;
    private DMEvaluateDetailPraiseView praiseView;
    private LinearLayout rlUserLayout;
    private boolean softInputIsShow;
    private int totalPage;
    private TextView tvRelation;
    private TextView tvTime;
    private TextView userName;
    private UserTagView userTagView;
    private int pageIndex = 1;
    private int maxNum = 200;
    private int mVTag = 0;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.ui.CommentDetailActivity$a */
    /* loaded from: classes13.dex */
    public class C0443a implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0443a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1549673133")) {
                ipChange.ipc$dispatch("1549673133", new Object[]{this, editable});
                return;
            }
            if (editable.toString().length() > CommentDetailActivity.this.maxNum) {
                ToastUtil.i("最多可写200字哦");
                CommentDetailActivity.this.mReplyContent.setText(editable.toString().substring(0, CommentDetailActivity.this.maxNum));
                CommentDetailActivity.this.mReplyContent.setSelection(CommentDetailActivity.this.maxNum);
            }
            CommentDetailActivity.this.setSubmitBtnBackground(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1221378634")) {
                ipChange.ipc$dispatch("-1221378634", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1830567254")) {
                ipChange.ipc$dispatch("1830567254", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.ui.CommentDetailActivity$b */
    /* loaded from: classes4.dex */
    public class C0444b implements SoftInputUtils.OnSoftKeyboardChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0444b() {
        }

        @Override // cn.damai.comment.util.SoftInputUtils.OnSoftKeyboardChangeListener
        public void onSoftKeyBoardChange(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-907791989")) {
                ipChange.ipc$dispatch("-907791989", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            CommentDetailActivity.this.softInputIsShow = z;
            if (z) {
                CommentDetailActivity.this.praiseView.setVisibility(8);
                CommentDetailActivity.this.mReplyContent.setFocusable(true);
                CommentDetailActivity.this.mReplyContent.requestFocus();
                CommentDetailActivity.this.mSendComment.setVisibility(0);
                return;
            }
            CommentDetailActivity.this.praiseView.setVisibility(0);
            CommentDetailActivity.this.mReplyContent.setFocusable(true);
            CommentDetailActivity.this.mReplyContent.requestFocus();
            CommentDetailActivity.this.resetBottom();
            CommentDetailActivity.this.mSendComment.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.ui.CommentDetailActivity$c */
    /* loaded from: classes13.dex */
    public class View$OnTouchListenerC0445c implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnTouchListenerC0445c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-865268164")) {
                return ((Boolean) ipChange.ipc$dispatch("-865268164", new Object[]{this, view, motionEvent})).booleanValue();
            }
            if (MotionEventCompat.getActionMasked(motionEvent) == 2) {
                SoftInputUtils.a(CommentDetailActivity.this);
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.ui.CommentDetailActivity$d */
    /* loaded from: classes13.dex */
    public class DialogInterface$OnClickListenerC0446d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC0446d(CommentDetailActivity commentDetailActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1013281983")) {
                ipChange.ipc$dispatch("-1013281983", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.ui.CommentDetailActivity$e */
    /* loaded from: classes13.dex */
    public class DialogInterface$OnClickListenerC0447e implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;

        DialogInterface$OnClickListenerC0447e(CommentsItemBean commentsItemBean) {
            this.a = commentsItemBean;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-43700960")) {
                ipChange.ipc$dispatch("-43700960", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            CommentDetailActivity.this.deleteCommentRequest(this.a);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.ui.CommentDetailActivity$f */
    /* loaded from: classes4.dex */
    public class C0448f implements CommentItemMoreUtil.OnCommentDeleteSuccessListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0448f() {
        }

        @Override // cn.damai.comment.util.CommentItemMoreUtil.OnCommentDeleteSuccessListener
        public void onFailure(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1224084338")) {
                ipChange.ipc$dispatch("1224084338", new Object[]{this, str, str2});
            }
        }

        @Override // cn.damai.comment.util.CommentItemMoreUtil.OnCommentDeleteSuccessListener
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1824890161")) {
                ipChange.ipc$dispatch("-1824890161", new Object[]{this, str});
            } else if (str == null || !str.equals(CommentDetailActivity.this.mainCommentId)) {
                CommentDetailActivity.this.initData();
            } else {
                CommentDetailActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.ui.CommentDetailActivity$g */
    /* loaded from: classes13.dex */
    public class HandlerC0449g extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC0449g() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "193342442")) {
                ipChange.ipc$dispatch("193342442", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            if (message.what != 1000) {
                return;
            }
            CommentDetailActivity.this.pageIndex = 1;
            CommentDetailActivity.this.initData();
        }
    }

    static /* synthetic */ int access$712(CommentDetailActivity commentDetailActivity, int i) {
        int i2 = commentDetailActivity.mScrollDistance + i;
        commentDetailActivity.mScrollDistance = i2;
        return i2;
    }

    private void addShowPublishCityTag(List<al> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511418385")) {
            ipChange.ipc$dispatch("1511418385", new Object[]{this, list});
        } else if (!cb2.d(list)) {
            for (al alVar : list) {
                alVar.o = true;
            }
        }
    }

    private boolean canEdit() {
        CommentsItemBean commentsItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1409741416")) {
            return ((Boolean) ipChange.ipc$dispatch("1409741416", new Object[]{this})).booleanValue();
        }
        if (!isOwner() || (commentsItemBean = this.mCurrentItemBean) == null || TextUtils.isEmpty(commentsItemBean.getCommentType()) || this.mCurrentItemBean.isProhibitEditing()) {
            return false;
        }
        String commentType = this.mCurrentItemBean.getCommentType();
        return "32".equals(commentType) || "62".equals(commentType) || "65".equals(commentType) || g41.ISSUE_PARAM_COMMENT_TYPE_SCRIPT.equals(commentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteCommentRequest(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636799349")) {
            ipChange.ipc$dispatch("636799349", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean == null) {
        } else {
            this.mCurrentItemBean = commentsItemBean;
            if (LoginManager.k().q()) {
                HashMap hashMap = new HashMap();
                hashMap.put(g41.ISSUE_PARAM_COMMENT_ID, commentsItemBean.getCommentId());
                ((CommentDetailPresenter) this.mPresenter).deleteComment(hashMap);
                return;
            }
            LoginManager.k().w(this, new Intent());
        }
    }

    private void getFocus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860390666")) {
            ipChange.ipc$dispatch("1860390666", new Object[]{this});
            return;
        }
        this.mReplyContent.setFocusable(true);
        this.mReplyContent.setFocusableInTouchMode(true);
        this.mReplyContent.requestFocus();
        this.mReplyContent.requestFocusFromTouch();
    }

    private String getItemId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619459962")) {
            return (String) ipChange.ipc$dispatch("-1619459962", new Object[]{this});
        }
        CommentProjectInfoBean commentProjectInfoBean = this.mCurrentProjectInfoBean;
        String projectId = commentProjectInfoBean != null ? commentProjectInfoBean.getProjectId() : "";
        CommentRepertoireInfoBean commentRepertoireInfoBean = this.mCurrentRepertoireInfoBean;
        return commentRepertoireInfoBean != null ? commentRepertoireInfoBean.getRepertoireId() : projectId;
    }

    private String getProjectId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128195730")) {
            return (String) ipChange.ipc$dispatch("2128195730", new Object[]{this});
        }
        CommentProjectInfoBean commentProjectInfoBean = this.mCurrentProjectInfoBean;
        return commentProjectInfoBean != null ? commentProjectInfoBean.getProjectId() : "";
    }

    private String getProjectImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840395002")) {
            return (String) ipChange.ipc$dispatch("1840395002", new Object[]{this});
        }
        CommentProjectInfoBean commentProjectInfoBean = this.mCurrentProjectInfoBean;
        return commentProjectInfoBean != null ? commentProjectInfoBean.getProjectPoster() : "";
    }

    private String getProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "862546690")) {
            return (String) ipChange.ipc$dispatch("862546690", new Object[]{this});
        }
        CommentProjectInfoBean commentProjectInfoBean = this.mCurrentProjectInfoBean;
        return commentProjectInfoBean != null ? commentProjectInfoBean.getProjectName() : "";
    }

    private void getRelationInfo() {
        CommentsItemBean commentsItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239361630")) {
            ipChange.ipc$dispatch("239361630", new Object[]{this});
        } else if (!LoginManager.k().q() || (commentsItemBean = this.mMainCommentItemBean) == null || commentsItemBean.getUserDO() == null || isOwner()) {
        } else {
            ((CommentDetailPresenter) this.mPresenter).getRelationInfo(this.mMainCommentItemBean.getUserDO().getDamaiUserId(), "1");
        }
    }

    private String getRepertoireId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790022890")) {
            return (String) ipChange.ipc$dispatch("1790022890", new Object[]{this});
        }
        CommentRepertoireInfoBean commentRepertoireInfoBean = this.mCurrentRepertoireInfoBean;
        return commentRepertoireInfoBean != null ? commentRepertoireInfoBean.getRepertoireId() : "";
    }

    private void initBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2075446671")) {
            ipChange.ipc$dispatch("-2075446671", new Object[]{this});
            return;
        }
        this.mCommentAndStar = (RelativeLayout) findViewById(R$id.comment_and_star);
        ImageView imageView = (ImageView) findViewById(R$id.evaluate_back_to_top);
        this.mBack2Top = imageView;
        imageView.setOnClickListener(this);
        this.praiseView = (DMEvaluateDetailPraiseView) findViewById(R$id.detail_praise_layout);
        this.mReplyContent = (EditText) findViewById(R$id.comment_reply_content);
        this.mSendComment = (TextView) findViewById(R$id.comment_publish_submit);
        this.praiseView.setOnClickListener(this);
        this.mSendComment.setOnClickListener(this);
        this.mReplyContent.setOnClickListener(this);
        this.mReplyContent.setPadding(t60.a(this, 15.0f), 0, t60.a(this, 5.0f), 0);
        this.mReplyContent.addTextChangedListener(new C0443a());
        this.mHandler = new HandlerC0449g();
        SoftInputUtils.c(this, new C0444b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801777582")) {
            ipChange.ipc$dispatch("-1801777582", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("targetType", "3");
        hashMap.put(g41.ISSUE_PARAM_COMMENT_TYPE, Constants.VIA_REPORT_TYPE_START_GROUP);
        hashMap.put("mainCommentId", this.mainCommentId);
        hashMap.put("isQueryAppend", "true");
        hashMap.put("isQueryIpInfo", "true");
        if (this.pageIndex == 1) {
            hashMap.put("isQueryMainComment", "true");
        } else {
            hashMap.put("isQueryMainComment", "false");
        }
        hashMap.put("isQueryProjectInfo", "true");
        hashMap.put("pageIndex", String.valueOf(this.pageIndex));
        hashMap.put("queryUploadFlag", "query_upload_video");
        ((CommentDetailPresenter) this.mPresenter).getCommentDetailList(hashMap);
    }

    private void initDeleteMainCommentListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1513836319")) {
            ipChange.ipc$dispatch("1513836319", new Object[]{this});
        } else {
            CommentItemMoreUtil.k(new C0448f());
        }
    }

    private void initErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467220769")) {
            ipChange.ipc$dispatch("467220769", new Object[]{this});
            return;
        }
        this.mErrorView = (LinearLayout) findViewById(R$id.errorView);
        findViewById(R$id.layout_header_view).setVisibility(8);
        findViewById(R$id.btn_operation).setVisibility(8);
        this.mErrorTips = (TextView) findViewById(R$id.tv_tip);
    }

    private void initExtras() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472460487")) {
            ipChange.ipc$dispatch("-472460487", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(g41.ISSUE_PARAM_COMMENT_ID)) {
                this.mainCommentId = extras.getString(g41.ISSUE_PARAM_COMMENT_ID);
            } else {
                this.mainCommentId = extras.getString("id");
            }
            this.isShowSoftInput = extras.getBoolean("isShowSoftInput");
            this.isVEvaluate = extras.getBoolean("isVEvaluate");
        }
    }

    private void initOtherInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779826576")) {
            ipChange.ipc$dispatch("-1779826576", new Object[]{this});
            return;
        }
        PraiseRequest praiseRequest = new PraiseRequest();
        this.praiseRequest = praiseRequest;
        praiseRequest.b(this);
    }

    private void initProjectHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995474077")) {
            ipChange.ipc$dispatch("-995474077", new Object[]{this});
            return;
        }
        DMEvaluateDetailHeadView dMEvaluateDetailHeadView = new DMEvaluateDetailHeadView(this);
        this.mMainEvaluateHeadCardView = dMEvaluateDetailHeadView;
        this.irc.addHeaderView(dMEvaluateDetailHeadView);
    }

    private void initRecycleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-474090506")) {
            ipChange.ipc$dispatch("-474090506", new Object[]{this});
            return;
        }
        this.irc = (IRecyclerView) findViewById(R$id.comment_detail_irecyclerview);
        CommentDetailAdapter commentDetailAdapter = new CommentDetailAdapter(this);
        this.mCommentDetailAdapter = commentDetailAdapter;
        commentDetailAdapter.d(this);
        this.mCommentDetailAdapter.e(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.irc.setLayoutManager(this.mLinearLayoutManager);
        this.irc.setRefreshEnabled(true);
        this.irc.setLoadMoreEnabled(true);
        this.irc.setIsAutoToDefault(false);
        this.irc.setOnRefreshListener(this);
        this.irc.setOnLoadMoreListener(this);
        this.irc.setRefreshHeaderView(PullToRefreshHeaderView.getInstance(this, R$color.color_ffffff));
        this.irc.getLoadMoreFooterView().setVisibility(8);
        this.irc.setAdapter(this.mCommentDetailAdapter);
        this.irc.setOnTouchListener(new View$OnTouchListenerC0445c());
        this.irc.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.comment.ui.CommentDetailActivity.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1994016326")) {
                    ipChange2.ipc$dispatch("1994016326", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                CommentDetailActivity.access$712(CommentDetailActivity.this, i2);
                int i3 = DisplayMetrics.getheightPixels(t60.b(CommentDetailActivity.this));
                pf0.b(CommentDetailActivity.this.mBack2Top, CommentDetailActivity.this.mScrollDistance > i3, m62.a(CommentDetailActivity.this, 42.0f));
            }
        });
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616699958")) {
            ipChange.ipc$dispatch("616699958", new Object[]{this});
            return;
        }
        this.rlUserLayout = (LinearLayout) findViewById(R$id.evaluate_detail_user_info);
        this.userName = (TextView) findViewById(R$id.comment_user_name);
        this.commentUserVipTag = (ImageView) findViewById(R$id.comment_vip_icon);
        UserTagView userTagView = (UserTagView) findViewById(cn.damai.commonbusiness.R$id.user_tag_view);
        this.userTagView = userTagView;
        userTagView.setIconSize(this.mContext, 63, 16);
        this.mTitleMore = (TextView) findViewById(R$id.comment_detail_more);
        this.avatar = (DMAvatar) findViewById(R$id.detail_uikit_damai_avatar);
        this.tvRelation = (TextView) findViewById(R$id.evaluate_detail_title_relation);
        this.tvTime = (TextView) findViewById(R$id.comment_date);
        this.avatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_30x30);
        findViewById(R$id.mine_add_address_title_left_icon).setOnClickListener(this);
        this.rlUserLayout.setOnClickListener(this);
        this.mTitleMore.setOnClickListener(this);
        this.tvRelation.setOnClickListener(this);
    }

    private void initTitleStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-887529069")) {
            ipChange.ipc$dispatch("-887529069", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
        }
    }

    private boolean isOwner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276754521")) {
            return ((Boolean) ipChange.ipc$dispatch("1276754521", new Object[]{this})).booleanValue();
        }
        CommentsItemBean commentsItemBean = this.mCurrentItemBean;
        if (commentsItemBean == null || TextUtils.isEmpty(commentsItemBean.getIsOwner())) {
            return false;
        }
        return Boolean.parseBoolean(this.mCurrentItemBean.getIsOwner());
    }

    private void notifyDeleteSuccess(final long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1414058763")) {
            ipChange.ipc$dispatch("-1414058763", new Object[]{this, Long.valueOf(j)});
        } else {
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.comment.ui.CommentDetailActivity.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "881692511")) {
                        ipChange2.ipc$dispatch("881692511", new Object[]{this});
                    } else {
                        xr.c("comment_delete_success", Long.valueOf(j));
                    }
                }
            }, 1000L);
        }
    }

    private void praiseUpdateRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1904515212")) {
            ipChange.ipc$dispatch("-1904515212", new Object[]{this});
            return;
        }
        clickPraiseUTReport(true, this.mMainCommentItemBean);
        if (LoginManager.k().q()) {
            CommentsItemBean commentsItemBean = this.mMainCommentItemBean;
            if (commentsItemBean == null || this.praiseRequest == null) {
                return;
            }
            CommentPraiseInfoBean praiseInfo = commentsItemBean.getPraiseInfo();
            this.praiseRequest.a(praiseInfo != null ? praiseInfo.isHasPraised() : false, this.mMainCommentItemBean.getCommentId());
            this.praiseView.updateItemData(praiseInfo);
            this.praiseView.setData(praiseInfo);
            C0529c.e().G(this.praiseView, "likes", "bottom", dl.EVALUATE_DETAIL_PAGE, dl.I().k(z20.E(), this.mMainCommentItemBean.getCommentId(), this.mMainCommentItemBean.getUserDO().getDamaiUserId()));
            return;
        }
        LoginManager.k().v(this);
    }

    private void refreshBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1568434488")) {
            ipChange.ipc$dispatch("1568434488", new Object[]{this});
        } else if (this.mCurrentItemBean == null) {
        } else {
            this.mReplyContent.setHint("说点什么吧…");
        }
    }

    private void refreshMainCommentHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989875572")) {
            ipChange.ipc$dispatch("989875572", new Object[]{this});
        } else {
            this.mMainEvaluateHeadCardView.setData(this.mMainCommentItemBean, this.mCurrentProjectInfoBean, this.mCurrentRepertoireInfoBean);
        }
    }

    private void refreshTitleUser(CommentsResultBean commentsResultBean) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821739554")) {
            ipChange.ipc$dispatch("-1821739554", new Object[]{this, commentsResultBean});
        } else if (commentsResultBean == null || commentsResultBean.getMainComment() == null) {
        } else {
            CommentsItemBean mainComment = commentsResultBean.getMainComment();
            CommentUserDoBean userDO = mainComment.getUserDO();
            if (isOwner()) {
                if (canEdit()) {
                    this.tvRelation.setText(BottomActionDialog.EDIT);
                    this.tvRelation.setVisibility(0);
                } else {
                    this.tvRelation.setVisibility(8);
                }
            } else {
                this.tvRelation.setTag(0);
                this.tvRelation.setVisibility(0);
                Map<String, String> l = dl.I().l(z20.E(), this.mMainCommentItemBean.getCommentId(), this.mMainCommentItemBean.getUserDO().getDamaiUserId(), this.mMainCommentItemBean.getScriptInfo() != null ? this.mMainCommentItemBean.getScriptInfo().getId() : "");
                if (!TextUtils.isEmpty(getProjectId())) {
                    l.put("item_id", getProjectId());
                }
                C0529c.e().G(this.tvRelation, StarFragment.KEY_FOLLOW, "top", dl.EVALUATE_DETAIL_PAGE, l);
            }
            EvaluateUserInfoUtil.a().b(userDO, this.avatar, this.commentUserVipTag, this.userName, this.userTagView, mainComment.getItemType());
            if (TextUtils.isEmpty(mainComment.publishCityName)) {
                str = mainComment.getGmtDisplay();
            } else {
                str = mainComment.getGmtDisplay() + " " + mainComment.publishCityName;
            }
            this.tvTime.setText(str);
        }
    }

    private void relationUpdateRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069147060")) {
            ipChange.ipc$dispatch("2069147060", new Object[]{this});
        } else if (LoginManager.k().q()) {
            if (this.tvRelation.getTag() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("operateType", "0".equals(this.tvRelation.getTag().toString()) ? "1" : "0");
                hashMap.put("targetId", this.mMainCommentItemBean.getUserDO().getDamaiUserId());
                hashMap.put("targetType", "1");
                ((CommentDetailPresenter) this.mPresenter).relationUpdate(hashMap, "1");
            }
        } else {
            LoginManager.k().v(this);
        }
    }

    private void replyDetailContentClick(boolean z, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277838372")) {
            ipChange.ipc$dispatch("1277838372", new Object[]{this, Boolean.valueOf(z), commentsItemBean});
            return;
        }
        EditText editText = this.mReplyContent;
        if (editText != null) {
            editText.setText("");
        }
        this.mCurrentItemBean = commentsItemBean;
        refreshBottom();
        if (this.softInputIsShow) {
            SoftInputUtils.a(this);
        } else {
            showSoftInputWindow();
        }
        if (commentsItemBean == null || commentsItemBean.getUserDO() == null) {
            return;
        }
        C0529c.e().x(dl.I().w(z ? "item" : "reply_btn", commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), bl.a(commentsItemBean, this.mCurrentItems)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830183548")) {
            ipChange.ipc$dispatch("-830183548", new Object[]{this});
            return;
        }
        CommentsItemBean commentsItemBean = this.mMainCommentItemBean;
        if (commentsItemBean == null) {
            return;
        }
        this.mCurrentItemBean = commentsItemBean;
        if ((commentsItemBean.getItemType() == 1 || this.mCurrentItemBean.getItemType() == 2) && this.mCurrentItemBean.isHideInteraction()) {
            IRecyclerView iRecyclerView = this.irc;
            if (iRecyclerView != null) {
                iRecyclerView.setPadding(0, 0, 0, 0);
            }
            this.mCommentAndStar.setVisibility(8);
        } else {
            IRecyclerView iRecyclerView2 = this.irc;
            if (iRecyclerView2 != null) {
                iRecyclerView2.setPadding(0, 0, 0, t60.a(this.mContext, 50.0f));
            }
            this.mCommentAndStar.setVisibility(0);
        }
        if (this.mMainCommentItemBean.getUserDO() == null) {
            return;
        }
        this.mReplyContent.setHint("说点什么吧…");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubmitBtnBackground(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2088697414")) {
            ipChange.ipc$dispatch("2088697414", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mSendComment.setBackgroundResource(R$drawable.submit_enable_btn);
            this.mSendComment.setClickable(true);
        } else {
            this.mSendComment.setBackgroundResource(R$drawable.comment_submit_unable_btn);
            this.mSendComment.setClickable(false);
        }
    }

    private void showSoftInputDelay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356212908")) {
            ipChange.ipc$dispatch("356212908", new Object[]{this});
        } else if (!this.isShowSoftInput || this.isRefresh) {
        } else {
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.comment.ui.CommentDetailActivity.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1078206016")) {
                        ipChange2.ipc$dispatch("1078206016", new Object[]{this});
                        return;
                    }
                    CommentDetailActivity.this.showSoftInputWindow();
                    CommentDetailActivity.this.isShowSoftInput = false;
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSoftInputWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588880597")) {
            ipChange.ipc$dispatch("-1588880597", new Object[]{this});
            return;
        }
        SoftInputUtils.d(this);
        getFocus();
    }

    private void submitReply() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1311392556")) {
            ipChange.ipc$dispatch("1311392556", new Object[]{this});
        } else if (this.mMainCommentItemBean == null || this.mCurrentItemBean == null || TextUtils.isEmpty(this.mainCommentId)) {
        } else {
            if (!TextUtils.isEmpty(this.mReplyContent.getText().toString().trim())) {
                if (LoginManager.k().q()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("targetId", this.mCurrentItemBean.getCommentId());
                    hashMap.put("targetType", String.valueOf(3));
                    hashMap.put(g41.ISSUE_PARAM_COMMENT_TYPE, String.valueOf(17));
                    hashMap.put("text", this.mReplyContent.getText().toString());
                    hashMap.put("mainCommentId", String.valueOf(this.mainCommentId));
                    ((CommentDetailPresenter) this.mPresenter).publishComment(hashMap);
                    return;
                }
                LoginManager.k().x(this, new Intent(), 100);
                return;
            }
            ToastUtil.i("不能发布空白内容哦");
        }
    }

    private void updatePageUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514572043")) {
            ipChange.ipc$dispatch("-1514572043", new Object[]{this});
            return;
        }
        CommentsItemBean commentsItemBean = this.mMainCommentItemBean;
        if (commentsItemBean == null || commentsItemBean.getUserDO() == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", String.valueOf(z20.E()));
        hashMap.put("item_id", getProjectId());
        hashMap.put("evaluate_id", this.mMainCommentItemBean.getCommentId());
        hashMap.put("repertoire_id", getRepertoireId());
        hashMap.put(C9548pb.PUBLISHER_ID, this.mMainCommentItemBean.getUserDO().getDamaiUserId());
        C0525a.C0527b c0527b = new C0525a.C0527b();
        c0527b.i(dl.EVALUATE_DETAIL_PAGE).j(hashMap);
        C0529c.e().l(this, c0527b);
    }

    private void updatePraiseView(CommentPraiseInfoBean commentPraiseInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209554310")) {
            ipChange.ipc$dispatch("-1209554310", new Object[]{this, commentPraiseInfoBean});
        } else {
            this.praiseView.setData(commentPraiseInfoBean);
        }
    }

    public void clickCircleUTReport(CommentsItemBean commentsItemBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741500863")) {
            ipChange.ipc$dispatch("-1741500863", new Object[]{this, commentsItemBean, str});
        } else if (commentsItemBean == null || this.mCurrentProjectInfoBean == null || commentsItemBean.getUserDO() == null) {
        } else {
            C0529c.e().x(dl.I().m(this.isVEvaluate ? "0" : "1", z20.E(), this.mCurrentProjectInfoBean.getProjectId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getCommentType(), commentsItemBean.getTargetId(), str));
        }
    }

    public void clickGridImageUTReport(CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854309235")) {
            ipChange.ipc$dispatch("854309235", new Object[]{this, commentsItemBean, Integer.valueOf(i)});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null) {
        } else {
            C0529c.e().x(dl.I().o(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), i, getProjectId(), commentsItemBean.getScriptInfo() != null ? commentsItemBean.getScriptInfo().getId() : ""));
        }
    }

    public void clickPraiseUTReport(boolean z, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1283686927")) {
            ipChange.ipc$dispatch("-1283686927", new Object[]{this, Boolean.valueOf(z), commentsItemBean});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null) {
        } else {
            C0529c.e().x(dl.I().t(z, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), bl.a(commentsItemBean, this.mCurrentItems)));
        }
    }

    public void clickTransmitUTReport(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1742308887")) {
            ipChange.ipc$dispatch("1742308887", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean == null || this.mCurrentProjectInfoBean == null || commentsItemBean.getUserDO() == null) {
        } else {
            C0529c.e().x(dl.I().y(this.isVEvaluate ? "0" : "1", z20.E(), this.mCurrentProjectInfoBean.getProjectId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getTargetId(), commentsItemBean.getCommentType()));
        }
    }

    public void clickUserInfoUTReport(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1711293198")) {
            ipChange.ipc$dispatch("1711293198", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean == null || this.mCurrentProjectInfoBean == null || commentsItemBean.getUserDO() == null) {
        } else {
            C0529c.e().x(dl.I().r(this.isVEvaluate ? "0" : "1", z20.E(), this.mCurrentProjectInfoBean.getProjectId(), commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getCommentType(), this.mMainCommentItemBean.getScriptInfo() != null ? this.mMainCommentItemBean.getScriptInfo().getId() : ""));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "792059028")) {
            ipChange.ipc$dispatch("792059028", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemOtherListener
    public void deleteComment(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114656846")) {
            ipChange.ipc$dispatch("2114656846", new Object[]{this, commentsItemBean});
        } else {
            showDeleteCommentDialog(commentsItemBean);
        }
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.View
    public void deleteCommentFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329227135")) {
            ipChange.ipc$dispatch("-1329227135", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.View
    public void deleteCommentSuccess(Map<String, String> map, CommentBaseBean commentBaseBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253231091")) {
            ipChange.ipc$dispatch("-1253231091", new Object[]{this, map, commentBaseBean});
            return;
        }
        if (map != null && map.containsKey(g41.ISSUE_PARAM_COMMENT_ID)) {
            String str = map.get(g41.ISSUE_PARAM_COMMENT_ID);
            if (str != null && str.equals(this.mainCommentId)) {
                if (!TextUtils.isEmpty(getProjectId())) {
                    notifyDeleteSuccess(Long.parseLong(getProjectId()));
                }
                finish();
            } else {
                initData();
            }
        }
        ToastUtil.i("删除成功");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2090596138") ? ((Integer) ipChange.ipc$dispatch("-2090596138", new Object[]{this})).intValue() : R$layout.comment_detail_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048997733")) {
            ipChange.ipc$dispatch("2048997733", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "465281382")) {
            ipChange.ipc$dispatch("465281382", new Object[]{this});
        } else {
            ((CommentDetailPresenter) this.mPresenter).setVM(this, (CommentsDetailContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504222583")) {
            ipChange.ipc$dispatch("1504222583", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtras();
        initTitle();
        initTitleStatusBar();
        initErrorView();
        initBottom();
        initRecycleView();
        initProjectHeaderView();
        initData();
        initDeleteMainCommentListener();
        initOtherInfo();
    }

    @Override // cn.damai.comment.request.PraiseRequest.PraiseRequestCallBack
    public void notifyPraiseClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-962053605")) {
            ipChange.ipc$dispatch("-962053605", new Object[]{this});
        } else if (isFinishing()) {
        } else {
            xr.c("evaluate_praise", this.mMainCommentItemBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114000798")) {
            ipChange.ipc$dispatch("2114000798", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
        if (i2 == -1) {
            if (i == 100) {
                submitReply();
            } else if (i == 1005) {
                submitReply();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1993996189")) {
            ipChange.ipc$dispatch("1993996189", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.mine_add_address_title_left_icon) {
            SoftInputUtils.a(this);
            finish();
        } else if (id == R$id.comment_detail_more) {
            openShare("top");
        } else if (id == R$id.comment_reply_content) {
            if (!LoginManager.k().q()) {
                LoginManager.k().v(this);
                return;
            }
            CommentsItemBean commentsItemBean = this.mMainCommentItemBean;
            if (commentsItemBean != null && commentsItemBean.getUserDO() != null) {
                C0529c.e().x(dl.I().p(this.mMainCommentItemBean.getCommentId(), this.mMainCommentItemBean.getUserDO().getDamaiUserId()));
            }
            showSoftInputWindow();
        } else if (id == R$id.comment_publish_submit) {
            submitReply();
        } else if (id == R$id.evaluate_detail_title_relation) {
            if (isOwner()) {
                Bundle bundle = new Bundle();
                bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, this.mMainCommentItemBean.getCommentId());
                bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_EDIT);
                DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b("issue"));
                return;
            }
            CommentsItemBean commentsItemBean2 = this.mMainCommentItemBean;
            if (commentsItemBean2 == null || commentsItemBean2.getUserDO() == null) {
                return;
            }
            C0529c.e().x(dl.I().v(this.mMainCommentItemBean.getCommentId(), this.mMainCommentItemBean.getUserDO().getDamaiUserId(), getProjectId(), this.mMainCommentItemBean.getScriptInfo() != null ? this.mMainCommentItemBean.getScriptInfo().getId() : ""));
            relationUpdateRequest();
        } else if (id == R$id.detail_praise_layout) {
            praiseUpdateRequest();
        } else if (id == R$id.evaluate_detail_user_info) {
            CommentsItemBean commentsItemBean3 = this.mMainCommentItemBean;
            if (commentsItemBean3 == null || commentsItemBean3.getUserDO() == null) {
                return;
            }
            clickUserInfoUTReport(true, this.mMainCommentItemBean);
            SoftInputUtils.a(this);
            Bundle bundle2 = new Bundle();
            bundle2.putString(FeedsViewModel.ARG_USERID, this.mMainCommentItemBean.getUserDO().getDamaiUserId());
            DMNav.from(this).withExtras(bundle2).toUri(NavUri.b(cs.ARTISTID_THEME));
        } else if (id == R$id.evaluate_back_to_top) {
            this.irc.smoothScrollToPosition(0);
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemOtherListener
    public void onClickShareBtn(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "364598012")) {
            ipChange.ipc$dispatch("364598012", new Object[]{this, commentsItemBean});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687869085")) {
            ipChange.ipc$dispatch("-1687869085", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(dl.I().h("", z20.E()));
        C0529c.e().K(this);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1003418988")) {
            ipChange.ipc$dispatch("-1003418988", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428382336")) {
            ipChange.ipc$dispatch("1428382336", new Object[]{this, view});
            return;
        }
        int i = this.pageIndex;
        if (i < this.totalPage) {
            this.pageIndex = i + 1;
            initData();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1126752513")) {
            ipChange.ipc$dispatch("1126752513", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939539040")) {
            ipChange.ipc$dispatch("939539040", new Object[]{this, str, str2, str3});
        }
    }

    @Override // cn.damai.commonbusiness.base.BaseDamaiView
    public void onNetSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1527396121")) {
            ipChange.ipc$dispatch("-1527396121", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1056384286")) {
            ipChange.ipc$dispatch("-1056384286", new Object[]{this});
            return;
        }
        this.isRefresh = true;
        this.pageIndex = 1;
        initData();
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportImageInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1353271298")) {
            ipChange.ipc$dispatch("1353271298", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            clickGridImageUTReport(commentsItemBean, i2);
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportItemClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-371072769")) {
            ipChange.ipc$dispatch("-371072769", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportMoreInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262097297")) {
            ipChange.ipc$dispatch("-262097297", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportPraiseViewClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-418476271")) {
            ipChange.ipc$dispatch("-418476271", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else {
            clickPraiseUTReport(false, commentsItemBean);
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportReplyClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707214912")) {
            ipChange.ipc$dispatch("-707214912", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportSyncCircleClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1017739577")) {
            ipChange.ipc$dispatch("-1017739577", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportTransferClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591013159")) {
            ipChange.ipc$dispatch("1591013159", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemUTReportListener
    public void onReportUserInfoClickEvent(boolean z, CommentsItemBean commentsItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1274100679")) {
            ipChange.ipc$dispatch("-1274100679", new Object[]{this, Boolean.valueOf(z), commentsItemBean, Integer.valueOf(i)});
        } else {
            clickUserInfoUTReport(false, commentsItemBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119917824")) {
            ipChange.ipc$dispatch("-2119917824", new Object[]{this});
            return;
        }
        super.onResume();
        initDeleteMainCommentListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812078837")) {
            ipChange.ipc$dispatch("-812078837", new Object[]{this});
            return;
        }
        super.onStop();
        CommentItemMoreUtil.k(null);
    }

    public void openShare(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727348717")) {
            ipChange.ipc$dispatch("-727348717", new Object[]{this, str});
            return;
        }
        if (this.softInputIsShow) {
            SoftInputUtils.a(this);
        }
        CommentsItemBean commentsItemBean = this.mMainCommentItemBean;
        if (commentsItemBean != null) {
            if (this.mCurrentProjectInfoBean == null && this.mCurrentRepertoireInfoBean == null) {
                if (commentsItemBean.getItemType() == 1 && this.mMainCommentItemBean.getStoreInfo() == null) {
                    return;
                }
                if (this.mMainCommentItemBean.getItemType() == 2 && this.mMainCommentItemBean.getScriptInfo() == null) {
                    return;
                }
            }
            if (this.mMainCommentItemBean.getTextDOList() == null || this.mMainCommentItemBean.getTextDOList().size() == 0 || this.mMainCommentItemBean.getUserDO() == null) {
                return;
            }
            C0529c.e().x(dl.I().x(str, getProjectId(), getRepertoireId(), this.mMainCommentItemBean.getCommentId(), this.mMainCommentItemBean.getUserDO().getDamaiUserId(), this.mMainCommentItemBean.getScriptInfo() != null ? this.mMainCommentItemBean.getScriptInfo().getId() : ""));
            if (this.mMainCommentItemBean.getItemType() == 1 && this.mMainCommentItemBean.getStoreInfo() != null) {
                CommentItemMoreUtil.j(this, GenerateImageUtil.TYPE_FROMWHERE_DETAILCOMMENT, cl.b(this.mMainCommentItemBean.getStoreInfo().getStoreId()), this.mMainCommentItemBean.getStoreInfo().getStoreImgUrl(), this.mMainCommentItemBean.getStoreInfo().getStoreName(), this.mMainCommentItemBean.getStoreInfo().getDes(), "", this.mMainCommentItemBean, isOwner(), R$layout.comment_detail_layout, false);
            } else if (this.mMainCommentItemBean.getItemType() == 2 && this.mMainCommentItemBean.getScriptInfo() != null) {
                CommentItemMoreUtil.j(this, GenerateImageUtil.TYPE_FROMWHERE_DETAILCOMMENT, cl.b(this.mMainCommentItemBean.getScriptInfo().getId()), this.mMainCommentItemBean.getScriptInfo().getPosterUrl(), this.mMainCommentItemBean.getScriptInfo().getName(), this.mMainCommentItemBean.getScriptInfo().getDes(), "", this.mMainCommentItemBean, isOwner(), R$layout.comment_detail_layout, false);
            } else {
                CommentProjectInfoBean commentProjectInfoBean = this.mCurrentProjectInfoBean;
                if (commentProjectInfoBean != null) {
                    CommentItemMoreUtil.i(this, GenerateImageUtil.TYPE_FROMWHERE_DETAILCOMMENT, cl.b(commentProjectInfoBean.getProjectId()), this.mCurrentProjectInfoBean.getProjectPoster(), this.mCurrentProjectInfoBean.getProjectName(), this.mCurrentProjectInfoBean.getCityName(), this.mCurrentProjectInfoBean.getShowTime(), this.mMainCommentItemBean, isOwner(), R$layout.comment_detail_layout);
                    return;
                }
                CommentRepertoireInfoBean commentRepertoireInfoBean = this.mCurrentRepertoireInfoBean;
                if (commentRepertoireInfoBean != null) {
                    CommentItemMoreUtil.i(this, GenerateImageUtil.TYPE_FROMWHERE_DETAILCOMMENT, cl.b(commentRepertoireInfoBean.getRepertoireId()), this.mCurrentRepertoireInfoBean.getRepertoirePic(), this.mCurrentRepertoireInfoBean.getRepertoireName(), null, null, this.mMainCommentItemBean, isOwner(), R$layout.comment_detail_layout);
                }
            }
        }
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.View
    public void publishCommentFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746865331")) {
            ipChange.ipc$dispatch("746865331", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            if (str.equals("FAIL_SYS_SESSION_EXPIRED")) {
                str2 = "登录超时，请重新登录";
            }
            ToastUtil.i(str2);
        }
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.View
    public void publishCommentSuccess(CommentBaseBean commentBaseBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850211018")) {
            ipChange.ipc$dispatch("1850211018", new Object[]{this, commentBaseBean});
            return;
        }
        ToastUtil.i("发布成功");
        this.mHandler.sendEmptyMessageDelayed(1000, 2000L);
        SoftInputUtils.a(this);
        this.mReplyContent.setText("");
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.View
    public void relationUserUpdateSuccess(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564349128")) {
            ipChange.ipc$dispatch("-1564349128", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.tvRelation.setText("关注");
            this.tvRelation.setTag(Integer.valueOf(i));
            this.tvRelation.setTextColor(getResources().getColor(R$color.white));
            this.tvRelation.setBackgroundResource(R$drawable.submit_enable_btn_h36);
        } else if (1 == i) {
            this.tvRelation.setText("已关注");
            this.tvRelation.setTag(Integer.valueOf(i));
            this.tvRelation.setTextColor(getResources().getColor(R$color.color_9C9CA5));
            this.tvRelation.setBackgroundResource(R$drawable.submit_btn_f5f5f5);
        } else if (2 == i) {
            this.tvRelation.setText("互相关注");
            this.tvRelation.setTag(Integer.valueOf(i));
            this.tvRelation.setTextColor(getResources().getColor(R$color.color_9C9CA5));
            this.tvRelation.setBackgroundResource(R$drawable.submit_btn_f5f5f5);
        }
    }

    @Override // cn.damai.evaluate.ui.item.EvaluateItemDataBinder.EvaluateItemOtherListener
    public void replyContentClick(boolean z, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000806771")) {
            ipChange.ipc$dispatch("2000806771", new Object[]{this, Boolean.valueOf(z), commentsItemBean});
        } else if (!LoginManager.k().q()) {
            LoginManager.k().v(this);
        } else {
            replyDetailContentClick(z, commentsItemBean);
        }
    }

    public void replyMainComment(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549626100")) {
            ipChange.ipc$dispatch("1549626100", new Object[]{this, commentsItemBean});
            return;
        }
        if (commentsItemBean != null && this.mCurrentProjectInfoBean != null && commentsItemBean.getUserDO() != null) {
            C0529c.e().x(dl.I().q(this.isVEvaluate ? "0" : "1", z20.E(), this.mCurrentProjectInfoBean.getProjectId(), commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), commentsItemBean.getCommentType()));
        }
        showSoftInputWindow();
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.View
    public void returnCommentDetailList(CommentsResultBean commentsResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426542586")) {
            ipChange.ipc$dispatch("426542586", new Object[]{this, commentsResultBean});
        } else if (commentsResultBean == null) {
        } else {
            this.mErrorView.setVisibility(8);
            if (this.pageIndex == 1) {
                this.irc.setRefreshing(false);
                this.mMainCommentItemBean = commentsResultBean.getMainComment();
                this.mCurrentItemBean = commentsResultBean.getMainComment();
                if (this.mMainCommentItemBean != null) {
                    this.mCurrentProjectInfoBean = commentsResultBean.getProjectInfo();
                    this.mCurrentRepertoireInfoBean = commentsResultBean.getRepertoireInfo();
                    refreshMainCommentHeader();
                    refreshTitleUser(commentsResultBean);
                    updatePraiseView(this.mMainCommentItemBean.getPraiseInfo());
                    getRelationInfo();
                    updatePageUT();
                }
            }
            this.mCurrentItems = commentsResultBean.getData();
            int total = commentsResultBean.getTotal();
            if (total % 15 == 0) {
                this.totalPage = total / 15;
            } else {
                this.totalPage = (total / 15) + 1;
            }
            CommentsItemBean commentsItemBean = this.mCurrentItemBean;
            if (commentsItemBean != null && !commentsItemBean.isHideInteraction()) {
                if (this.pageIndex == 1) {
                    List<al> c = yk.c(commentsResultBean);
                    addShowPublishCityTag(c);
                    this.mCommentDetailAdapter.c(c);
                } else {
                    List<al> a = yk.a(commentsResultBean);
                    addShowPublishCityTag(a);
                    this.mCommentDetailAdapter.a(a);
                }
            }
            resetBottom();
            refreshBottom();
            showSoftInputDelay();
            C0529c.e().G(this.mReplyContent, "reply_btn", "bottom", dl.EVALUATE_DETAIL_PAGE, dl.I().k(z20.E(), this.mMainCommentItemBean.getCommentId(), this.mMainCommentItemBean.getUserDO().getDamaiUserId()));
        }
    }

    @Override // cn.damai.comment.contract.CommentsDetailContract.View
    public void returnCommentDetailListError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816503274")) {
            ipChange.ipc$dispatch("-1816503274", new Object[]{this, str, str2});
            return;
        }
        if (this.pageIndex == 1) {
            this.irc.setRefreshing(false);
        }
        if (!TextUtils.isEmpty(str2)) {
            ToastUtil.i(str2);
        }
        if (TextUtils.isEmpty(str) || !str.equals("FAIL_BIZ_NO_RESULT") || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mErrorView.setVisibility(0);
        this.mTitleMore.setVisibility(8);
        this.mErrorTips.setText(str2);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304955190")) {
            return (String) ipChange.ipc$dispatch("-304955190", new Object[]{this});
        }
        return null;
    }

    public void showDeleteCommentDialog(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1161486851")) {
            ipChange.ipc$dispatch("1161486851", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean == null) {
        } else {
            C0529c.e().x(dl.I().n(commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), bl.a(commentsItemBean, this.mCurrentItems)));
            DMDialog dMDialog = new DMDialog(this);
            if (Constants.VIA_REPORT_TYPE_START_GROUP.equals(commentsItemBean.getCommentType())) {
                dMDialog.p(R$string.comment_delete_tips);
            } else {
                dMDialog.p(R$string.evaluate_delete_tips);
            }
            dMDialog.i("取消", new DialogInterface$OnClickListenerC0446d(this));
            dMDialog.n("确定删除", new DialogInterface$OnClickListenerC0447e(commentsItemBean));
            dMDialog.show();
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761841495")) {
            ipChange.ipc$dispatch("-761841495", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449701669")) {
            ipChange.ipc$dispatch("449701669", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301841481")) {
            ipChange.ipc$dispatch("1301841481", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970966780")) {
            ipChange.ipc$dispatch("-970966780", new Object[]{this});
        }
    }

    public void clickUserInfoUTReport(boolean z, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889945422")) {
            ipChange.ipc$dispatch("1889945422", new Object[]{this, Boolean.valueOf(z), commentsItemBean});
        } else if (commentsItemBean == null || commentsItemBean.getUserDO() == null) {
        } else {
            C0529c.e().x(dl.I().s(z, commentsItemBean.getCommentId(), commentsItemBean.getUserDO().getDamaiUserId(), bl.a(commentsItemBean, this.mCurrentItems), getProjectId(), commentsItemBean.getScriptInfo() != null ? commentsItemBean.getScriptInfo().getId() : ""));
        }
    }
}
