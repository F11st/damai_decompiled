package cn.damai.discover.content.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.bean.FollowEvent;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.share.IImageShareInfoProvider;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.commonbusiness.share.live.LiveShareImageBean;
import cn.damai.commonbusiness.wannasee.adapter.MultiAdapter;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.discover.content.bean.ContentCommentList;
import cn.damai.discover.content.bean.ContentDetail;
import cn.damai.discover.content.bean.ContentRecommendList;
import cn.damai.discover.content.bean.ContentShareInfo;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.discover.content.bean.FollowInfo;
import cn.damai.discover.content.bean.RelatedBrandOrArtist;
import cn.damai.discover.content.bean.TwoTuple;
import cn.damai.discover.content.net.ContentCard;
import cn.damai.discover.content.net.ContentDetailApi;
import cn.damai.discover.content.net.ContentDetailRequest;
import cn.damai.discover.content.net.ContentDetailResponse;
import cn.damai.discover.content.net.ContentPraiseRequest;
import cn.damai.discover.content.net.ContentPraiseResponse;
import cn.damai.discover.content.net.PublishCommentRequest;
import cn.damai.discover.content.ui.decoration.StaggeredGridItemDecoration;
import cn.damai.discover.content.ui.viewholder.ContentBannerViewHolder;
import cn.damai.discover.content.ui.viewholder.ContentCommentViewHolder;
import cn.damai.discover.content.ui.viewholder.ContentShareViewHolder;
import cn.damai.discover.content.util.KeyboardObservable;
import cn.damai.discover.content.util.SoftInputUtils;
import cn.damai.discover.content.view.UserInfoView;
import cn.damai.discover.content.view.Wanna2SeePanel;
import cn.damai.discover.main.request.FollowPeopleRequest;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.R$string;
import cn.damai.rank.view.WantSeeTips;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.wantsee.GuideUtProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.cs;
import tb.ew1;
import tb.g03;
import tb.jm1;
import tb.k23;
import tb.kg2;
import tb.m62;
import tb.m91;
import tb.nn;
import tb.on;
import tb.pb;
import tb.pn;
import tb.q91;
import tb.s62;
import tb.t60;
import tb.un;
import tb.v3;
import tb.vn;
import tb.wh2;
import tb.wn;
import tb.x3;
import tb.xn;
import tb.xr;
import tb.yn;
import tb.z20;
import tb.zc0;
import tb.zn;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ContentDetailActivity extends SimpleBaseActivity implements IImageShareInfoProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    StaggeredGridLayoutManager layoutManager;
    private vn mArtistBrandRelatedViewHolder;
    private DMIconFontTextView mBackIcon;
    private ContentBannerViewHolder mBannerViewHolder;
    private String mBaseHint;
    private nn mCircleViewHolder;
    private ContentCommentViewHolder mCommentViewHolder;
    private MultiAdapter mContentDetailAdapter;
    private DamaiRootRecyclerView mContentDetailList;
    private String mContentId;
    ContentDetailResponse mContentResponse;
    private wn mContentStoreInfoViewHolder;
    private String mContentUserName;
    private pn mDMTagViewHolder;
    private on mDateViewHolder;
    private LottieAnimationView mDianZanIcon;
    private View mDianZanView;
    private zc0 mDramaRelateViewHolder;
    private TextView mFollowBtn;
    private EditText mInput;
    private String mInputContent;
    private LinearLayout mInputLayout;
    private FrameLayout mPageContainer;
    private TextView mPraiseCountFlip;
    private LinearLayout mPraiseLayout;
    private ew1 mProjectRelateViewHolder;
    private TextView mPublishBtn;
    private un mRecommendTitle;
    private cn.damai.discover.content.ui.viewholder.a mRichTextViewHolder;
    private s62 mScriptCardViewHolder;
    private int mScrollDistance;
    private Wanna2SeePanel mSeePanel;
    private View mShareBtn;
    private String mSourceId;
    private String mSourceType;
    private xn mTextViewHolder;
    private String mThemeName;
    private zn mTitleViewHolder;
    private yn mTopicViewHolder;
    private UserInfoView mUserInfoView;
    private ContentShareViewHolder mWanna2SeeViewHolder;
    private WantSeeTips wantSeeTips;
    private q91 mUt = new q91();
    private Integer currentPageIndex = 1;
    private boolean hasMore = false;
    private v3 mMultiListClickListener = new v3(this, new c());
    private MultiAdapter.Exposure mExposure = new d();
    private boolean keyBoardShowd = false;
    private ContentCommentViewHolder.OnCommentClickListener mOnCommentClickListener = new e();
    private ContentCommentViewHolder.OnLoadMoreClickListener onLoadMoreClickListener = new f();
    private boolean scrollToAncr = false;
    float x = 0.0f;
    float y = 0.0f;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements UserInfoView.DnaClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // cn.damai.discover.content.view.UserInfoView.DnaClickListener
        public void onDnaClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2106105653")) {
                ipChange.ipc$dispatch("2106105653", new Object[]{this});
                return;
            }
            cn.damai.common.user.c.e().x(ContentDetailActivity.this.mUt.I());
            if (TextUtils.isEmpty(this.a)) {
                DialogUtil.b(ContentDetailActivity.this).show();
            } else {
                DMNav.from(ContentDetailActivity.this).toUri(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements GuideUtProvider {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideCloseBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-728505173") ? (Map) ipChange.ipc$dispatch("-728505173", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideExposeArgMap() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "704302315")) {
                return (Map) ipChange.ipc$dispatch("704302315", new Object[]{this});
            }
            HashMap hashMap = new HashMap();
            hashMap.put(pb.CNT_CONTENT_ID, ContentDetailActivity.this.mContentId);
            return hashMap;
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public Map<String, String> getGuideGoMineBtnArgMap() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "745864088") ? (Map) ipChange.ipc$dispatch("745864088", new Object[]{this}) : getGuideExposeArgMap();
        }

        @Override // cn.damai.wantsee.GuideUtProvider
        @NonNull
        public String getSpmB() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1354215804") ? (String) ipChange.ipc$dispatch("-1354215804", new Object[]{this}) : "content";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c extends x3 {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.wannasee.listener.MultiClickUt
        public void utNoteClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1338432598")) {
                ipChange.ipc$dispatch("-1338432598", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else {
                cn.damai.common.user.c.e().x(ContentDetailActivity.this.mUt.D(noteBean.content, noteBean.id, i));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d extends MultiAdapter.f {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.commonbusiness.wannasee.adapter.MultiAdapter.Exposure
        public void exposureNote(View view, NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1949737261")) {
                ipChange.ipc$dispatch("-1949737261", new Object[]{this, view, noteBean, Integer.valueOf(i)});
            } else {
                ContentDetailActivity.this.mUt.N(view, ContentDetailActivity.this.mThemeName, noteBean.id, i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class e implements ContentCommentViewHolder.OnCommentClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.discover.content.ui.viewholder.ContentCommentViewHolder.OnCommentClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1472405035")) {
                ipChange.ipc$dispatch("-1472405035", new Object[]{this, view});
                return;
            }
            try {
                if (ContentDetailActivity.this.keyBoardShowd) {
                    SoftInputUtils.a(ContentDetailActivity.this);
                    ContentDetailActivity.this.keyBoardShowd = false;
                    return;
                }
                ContentCommentList.CommentListItem commentListItem = (ContentCommentList.CommentListItem) view.getTag();
                ContentDetailActivity.this.showSoftKey();
                ContentDetailActivity.this.keyBoardShowd = true;
                ContentDetailActivity.this.mInput.setHint(ContentDetailActivity.this.updateInputText(commentListItem.userDO.nickname));
                ContentDetailActivity.this.mInput.setFocusableInTouchMode(true);
                ContentDetailActivity.this.mPublishBtn.setTag(commentListItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class f implements ContentCommentViewHolder.OnLoadMoreClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.discover.content.ui.viewholder.ContentCommentViewHolder.OnLoadMoreClickListener
        public void onClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-207466116")) {
                ipChange.ipc$dispatch("-207466116", new Object[]{this});
                return;
            }
            try {
                if (ContentDetailActivity.this.hasMore) {
                    ContentDetailActivity.this.requestMoreComments();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class g implements KeyboardObservable.OnSoftKeyboardChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // cn.damai.discover.content.util.KeyboardObservable.OnSoftKeyboardChangeListener
        public void onSoftKeyBoardChange(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1851110921")) {
                ipChange.ipc$dispatch("-1851110921", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
                return;
            }
            ContentDetailActivity.this.mPraiseLayout.setVisibility(z ? 8 : 0);
            ContentDetailActivity.this.mPublishBtn.setVisibility(z ? 0 : 8);
            if (z) {
                ContentDetailActivity.this.mInput.setFocusable(true);
                ContentDetailActivity.this.mInput.setFocusableInTouchMode(true);
                ContentDetailActivity.this.mInput.findFocus();
                return;
            }
            ContentDetailActivity.this.mPublishBtn.setTag(ContentDetailActivity.this.mSourceId);
            ContentDetailActivity.this.mInput.setHint(ContentDetailActivity.this.mBaseHint);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class h implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1728416511")) {
                ipChange.ipc$dispatch("1728416511", new Object[]{this, editable});
                return;
            }
            ContentDetailActivity.this.mInputContent = editable.toString();
            ContentDetailActivity contentDetailActivity = ContentDetailActivity.this;
            contentDetailActivity.updatePublishBtuttonEnable(!TextUtils.isEmpty(contentDetailActivity.mInputContent));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1088043172")) {
                ipChange.ipc$dispatch("1088043172", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1218322620")) {
                ipChange.ipc$dispatch("-1218322620", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    static /* synthetic */ int access$212(ContentDetailActivity contentDetailActivity, int i) {
        int i2 = contentDetailActivity.mScrollDistance + i;
        contentDetailActivity.mScrollDistance = i2;
        return i2;
    }

    private String formatCityAndTime(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-420206482")) {
            return (String) ipChange.ipc$dispatch("-420206482", new Object[]{this, projectItemBean});
        }
        String str = projectItemBean.cityName;
        String str2 = projectItemBean.showTime;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return !TextUtils.isEmpty(str) ? str : !TextUtils.isEmpty(str2) ? str2 : "";
        }
        return str + " | " + str2;
    }

    private void initBottomBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898683070")) {
            ipChange.ipc$dispatch("898683070", new Object[]{this});
            return;
        }
        this.mInputLayout = (LinearLayout) findViewById(R$id.content_detail_publisher_layout);
        this.mInput = (EditText) findViewById(R$id.content_detail_publisher_input);
        this.mPraiseLayout = (LinearLayout) findViewById(R$id.content_detail_publisher_praise);
        this.mDianZanView = findViewById(R$id.content_detail_dian_zan_layout);
        this.mPraiseCountFlip = (TextView) findViewById(R$id.content_detail_publisher_praise_count_v2);
        this.mDianZanIcon = (LottieAnimationView) findViewById(R$id.content_detail_dian_zan_icon);
        View findViewById = findViewById(R$id.content_detail_bottom_follow_layout);
        this.mPublishBtn = (TextView) findViewById(R$id.content_detail_publisher_btn);
        this.mDianZanView.setOnClickListener(this);
        this.mPublishBtn.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        new KeyboardObservable().e(this, new g());
        this.mInput.addTextChangedListener(new h());
    }

    private void initContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906852376")) {
            ipChange.ipc$dispatch("-906852376", new Object[]{this});
            return;
        }
        this.mBaseHint = getString(R$string.msg_say_something);
        this.mPageContainer = (FrameLayout) findViewById(R$id.live_content_detail_page_container);
        this.mContentDetailList = (DamaiRootRecyclerView) findViewById(R$id.live_content_detail_list);
        this.layoutManager = new StaggeredGridLayoutManager(2, 1);
        this.mContentDetailList.addItemDecoration(new StaggeredGridItemDecoration());
        this.mContentDetailList.setLayoutManager(this.layoutManager);
        this.mContentDetailList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: cn.damai.discover.content.ui.ContentDetailActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "509984063")) {
                    ipChange2.ipc$dispatch("509984063", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
                ContentDetailActivity.access$212(ContentDetailActivity.this, i2);
                DisplayMetrics.getheightPixels(t60.b(ContentDetailActivity.this));
                m62.a(ContentDetailActivity.this, 42.0f);
            }
        });
        MultiAdapter multiAdapter = new MultiAdapter(this, this.mMultiListClickListener);
        this.mContentDetailAdapter = multiAdapter;
        multiAdapter.i(this.mExposure);
        this.mContentDetailList.setAdapter(this.mContentDetailAdapter);
        this.mContentDetailList.setLoadMoreFooterView(new View(this));
        this.mContentDetailList.getHeaderContainer().setBackgroundColor(-1);
        ContentBannerViewHolder contentBannerViewHolder = new ContentBannerViewHolder(this);
        this.mBannerViewHolder = contentBannerViewHolder;
        this.mContentDetailList.addHeaderView(contentBannerViewHolder.b);
        zn znVar = new zn(this);
        this.mTitleViewHolder = znVar;
        this.mContentDetailList.addHeaderView(znVar.b);
        xn xnVar = new xn(this);
        this.mTextViewHolder = xnVar;
        this.mContentDetailList.addHeaderView(xnVar.b);
        cn.damai.discover.content.ui.viewholder.a aVar = new cn.damai.discover.content.ui.viewholder.a(this);
        this.mRichTextViewHolder = aVar;
        this.mContentDetailList.addHeaderView(aVar.b);
        pn pnVar = new pn(this);
        this.mDMTagViewHolder = pnVar;
        this.mContentDetailList.addHeaderView(pnVar.b);
        nn nnVar = new nn(this);
        this.mCircleViewHolder = nnVar;
        this.mContentDetailList.addHeaderView(nnVar.b);
        yn ynVar = new yn(this);
        this.mTopicViewHolder = ynVar;
        this.mContentDetailList.addHeaderView(ynVar.b);
        on onVar = new on(this);
        this.mDateViewHolder = onVar;
        this.mContentDetailList.addHeaderView(onVar.b);
        zc0 zc0Var = new zc0(this);
        this.mDramaRelateViewHolder = zc0Var;
        this.mContentDetailList.addHeaderView(zc0Var.b);
        ew1 ew1Var = new ew1(this);
        this.mProjectRelateViewHolder = ew1Var;
        this.mContentDetailList.addHeaderView(ew1Var.b);
        s62 s62Var = new s62(this);
        this.mScriptCardViewHolder = s62Var;
        this.mContentDetailList.addHeaderView(s62Var.b);
        wn wnVar = new wn(this);
        this.mContentStoreInfoViewHolder = wnVar;
        this.mContentDetailList.addHeaderView(wnVar.b);
        vn vnVar = new vn(this);
        this.mArtistBrandRelatedViewHolder = vnVar;
        this.mContentDetailList.addHeaderView(vnVar.b);
        Wanna2SeePanel wanna2SeePanel = new Wanna2SeePanel(this);
        this.mSeePanel = wanna2SeePanel;
        ContentShareViewHolder contentShareViewHolder = new ContentShareViewHolder(this, wanna2SeePanel);
        this.mWanna2SeeViewHolder = contentShareViewHolder;
        this.mContentDetailList.addHeaderView(contentShareViewHolder.b);
        ContentCommentViewHolder contentCommentViewHolder = new ContentCommentViewHolder(this);
        this.mCommentViewHolder = contentCommentViewHolder;
        this.mContentDetailList.addHeaderView(contentCommentViewHolder.b);
        this.mCommentViewHolder.i(this.mOnCommentClickListener);
        this.mCommentViewHolder.j(this.onLoadMoreClickListener);
        un unVar = new un(this);
        this.mRecommendTitle = unVar;
        this.mContentDetailList.addHeaderView(unVar.b);
        WantSeeTips wantSeeTips = (WantSeeTips) findViewById(R$id.want_see_tips_content_detail);
        this.wantSeeTips = wantSeeTips;
        wantSeeTips.setPageSource(WantSeeTips.a.C0065a.INSTANCE);
        this.mBannerViewHolder.setLiveUt(this.mUt);
        this.mTextViewHolder.setLiveUt(this.mUt);
        this.mTopicViewHolder.setLiveUt(this.mUt);
        this.mWanna2SeeViewHolder.setLiveUt(this.mUt);
        this.mCommentViewHolder.setLiveUt(this.mUt);
        this.mRecommendTitle.setLiveUt(this.mUt);
        this.mArtistBrandRelatedViewHolder.setLiveUt(this.mUt);
        this.mTitleViewHolder.setLiveUt(this.mUt);
        this.mRichTextViewHolder.setLiveUt(this.mUt);
        this.mDramaRelateViewHolder.setLiveUt(this.mUt);
        this.mProjectRelateViewHolder.setLiveUt(this.mUt);
        this.mDateViewHolder.setLiveUt(this.mUt);
        initBottomBar();
    }

    private void initStatuBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866834482")) {
            ipChange.ipc$dispatch("866834482", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
        }
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333142377")) {
            ipChange.ipc$dispatch("333142377", new Object[]{this});
            return;
        }
        this.mBackIcon = (DMIconFontTextView) findViewById(R$id.content_detail_back_icon);
        this.mUserInfoView = (UserInfoView) findViewById(R$id.content_detail_user_info);
        this.mFollowBtn = (TextView) findViewById(R$id.content_detail_follow_btn);
        this.mShareBtn = (TextView) findViewById(R$id.content_detail_share_btn);
        this.mBackIcon.setOnClickListener(this);
        this.mUserInfoView.setOnClickListener(this);
        this.mFollowBtn.setOnClickListener(this);
        this.mShareBtn.setOnClickListener(this);
    }

    private void requestContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-783123094")) {
            ipChange.ipc$dispatch("-783123094", new Object[]{this});
            return;
        }
        ContentDetailRequest contentDetailRequest = new ContentDetailRequest();
        contentDetailRequest.contentId = getString("contentId");
        contentDetailRequest.request(new DMMtopRequestListener<ContentDetailResponse>(ContentDetailResponse.class) { // from class: cn.damai.discover.content.ui.ContentDetailActivity.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "325124159")) {
                    ipChange2.ipc$dispatch("325124159", new Object[]{this, str, str2});
                    return;
                }
                ContentDetailActivity contentDetailActivity = ContentDetailActivity.this;
                contentDetailActivity.onResponseError(str2, str, ContentDetailApi.CONTENT_DETAIL_PAGE, contentDetailActivity.mPageContainer, true);
                ContentDetailActivity.this.stopProgressDialog();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ContentDetailResponse contentDetailResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-140830869")) {
                    ipChange2.ipc$dispatch("-140830869", new Object[]{this, contentDetailResponse});
                    return;
                }
                ContentDetailActivity.this.setUpView(contentDetailResponse);
                ContentCommentList contentCommentList = contentDetailResponse.commentList;
                if (contentCommentList != null) {
                    ContentDetailActivity contentDetailActivity = ContentDetailActivity.this;
                    int i = contentCommentList.pageIndex;
                    contentDetailActivity.currentPageIndex = Integer.valueOf(i == 0 ? contentDetailActivity.currentPageIndex.intValue() : i + 1);
                    ContentDetailActivity.this.hasMore = contentDetailResponse.commentList.hasNext;
                }
                ContentDetailActivity contentDetailActivity2 = ContentDetailActivity.this;
                contentDetailActivity2.onResponseSuccess(contentDetailActivity2.mPageContainer);
                ContentDetailActivity.this.stopProgressDialog();
            }
        });
        startProgressDialog();
    }

    private void requestFollow(final ContentDetail.ContentUserInfo contentUserInfo) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "131864427")) {
            ipChange.ipc$dispatch("131864427", new Object[]{this, contentUserInfo});
            return;
        }
        ContentDetailResponse contentDetailResponse = this.mContentResponse;
        if (contentDetailResponse != null && contentDetailResponse.myself) {
            z = true;
        }
        FollowPeopleRequest followPeopleRequest = new FollowPeopleRequest();
        followPeopleRequest.operateType = !contentUserInfo.focus ? 1 : 0;
        if (!z && TextUtils.equals("4", contentUserInfo.btype)) {
            str = contentUserInfo.bid;
            str2 = contentUserInfo.btype;
        } else {
            str = contentUserInfo.havanaIdStr;
            str2 = contentUserInfo.targetType;
        }
        followPeopleRequest.targetId = str;
        followPeopleRequest.targetType = str2;
        followPeopleRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.discover.content.ui.ContentDetailActivity.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "317364800")) {
                    ipChange2.ipc$dispatch("317364800", new Object[]{this, str3, str4});
                } else {
                    ContentDetailActivity.this.stopProgressDialog();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1974925152")) {
                    ipChange2.ipc$dispatch("-1974925152", new Object[]{this, followDataBean});
                    return;
                }
                contentUserInfo.focus = followDataBean.getStatus() != 0;
                ContentDetailActivity.this.updateFollow(contentUserInfo.focus);
                xr.c(FollowEvent.LIVE_FOLLOW_EVENT, Boolean.valueOf(contentUserInfo.focus));
                cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
                q91 q91Var = ContentDetailActivity.this.mUt;
                ContentDetail.ContentUserInfo contentUserInfo2 = contentUserInfo;
                e2.x(q91Var.J(contentUserInfo2.havanaIdStr, contentUserInfo2.focus ? "1" : "0"));
                ContentDetailActivity.this.stopProgressDialog();
            }
        });
        startProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestMoreComments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1291296226")) {
            ipChange.ipc$dispatch("-1291296226", new Object[]{this});
            return;
        }
        ContentDetailRequest contentDetailRequest = new ContentDetailRequest();
        contentDetailRequest.contentId = getString("contentId");
        contentDetailRequest.pageIndex = this.currentPageIndex;
        contentDetailRequest.request(new DMMtopRequestListener<ContentDetailResponse>(ContentDetailResponse.class) { // from class: cn.damai.discover.content.ui.ContentDetailActivity.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "219596088")) {
                    ipChange2.ipc$dispatch("219596088", new Object[]{this, str, str2});
                } else {
                    ContentDetailActivity.this.stopProgressDialog();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ContentDetailResponse contentDetailResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1636672996")) {
                    ipChange2.ipc$dispatch("1636672996", new Object[]{this, contentDetailResponse});
                    return;
                }
                ContentCommentList contentCommentList = contentDetailResponse.commentList;
                if (contentCommentList != null) {
                    ContentDetailActivity contentDetailActivity = ContentDetailActivity.this;
                    int i = contentCommentList.pageIndex;
                    contentDetailActivity.currentPageIndex = Integer.valueOf(i == 0 ? contentDetailActivity.currentPageIndex.intValue() : i + 1);
                    ContentDetailActivity.this.hasMore = contentDetailResponse.commentList.hasNext;
                    ContentDetailActivity.this.mCommentViewHolder.d(contentDetailResponse.commentList, ContentDetailActivity.this.hasMore);
                }
                ContentDetailActivity.this.stopProgressDialog();
            }
        });
        startProgressDialog();
    }

    private void requestPraise(final ContentDetail.PraiseInfo praiseInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275543084")) {
            ipChange.ipc$dispatch("-275543084", new Object[]{this, praiseInfo});
        } else if (praiseInfo == null) {
        } else {
            ContentPraiseRequest contentPraiseRequest = new ContentPraiseRequest();
            contentPraiseRequest.operate = praiseInfo.hasPraised ? "1" : "0";
            contentPraiseRequest.targetId = praiseInfo.sourceId;
            contentPraiseRequest.targetType = "1";
            contentPraiseRequest.sourceType = praiseInfo.sourceType;
            contentPraiseRequest.request(new DMMtopRequestListener<ContentPraiseResponse>(ContentPraiseResponse.class) { // from class: cn.damai.discover.content.ui.ContentDetailActivity.12
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "204077370")) {
                        ipChange2.ipc$dispatch("204077370", new Object[]{this, str, str2});
                    } else {
                        ContentDetailActivity.this.stopProgressDialog();
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(ContentPraiseResponse contentPraiseResponse) {
                    int i;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-8939813")) {
                        ipChange2.ipc$dispatch("-8939813", new Object[]{this, contentPraiseResponse});
                        return;
                    }
                    ContentDetailActivity.this.stopProgressDialog();
                    ContentDetail.PraiseInfo praiseInfo2 = praiseInfo;
                    boolean z = !praiseInfo2.hasPraised;
                    praiseInfo2.hasPraised = z;
                    if (z) {
                        i = praiseInfo2.praiseCount + 1;
                    } else {
                        i = praiseInfo2.praiseCount - 1;
                    }
                    praiseInfo2.praiseCount = i;
                    ContentDetailActivity.this.updatePraise(z, i, true);
                    cn.damai.common.user.c.e().x(ContentDetailActivity.this.mUt.r());
                }
            });
            startProgressDialog();
        }
    }

    private void requestPublish(String str, final ContentCommentList.CommentListItem commentListItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586193035")) {
            ipChange.ipc$dispatch("-1586193035", new Object[]{this, str, commentListItem});
        } else if (TextUtils.isEmpty(this.mInputContent)) {
        } else {
            PublishCommentRequest publishCommentRequest = new PublishCommentRequest();
            publishCommentRequest.loginKey = z20.q();
            publishCommentRequest.commentType = Constants.VIA_REPORT_TYPE_START_GROUP;
            publishCommentRequest.targetId = str;
            publishCommentRequest.targetType = "3";
            publishCommentRequest.mainCommentId = this.mSourceId;
            publishCommentRequest.sourceType = this.mSourceType;
            publishCommentRequest.text = this.mInputContent;
            publishCommentRequest.request(new DMMtopRequestListener<ContentCommentList>(ContentCommentList.class) { // from class: cn.damai.discover.content.ui.ContentDetailActivity.11
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "211836729")) {
                        ipChange2.ipc$dispatch("211836729", new Object[]{this, str2, str3});
                        return;
                    }
                    ContentDetailActivity.this.stopProgressDialog();
                    ContentDetailActivity.this.mInputContent = "";
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(ContentCommentList contentCommentList) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1267066405")) {
                        ipChange2.ipc$dispatch("-1267066405", new Object[]{this, contentCommentList});
                        return;
                    }
                    if (commentListItem != null) {
                        ArrayList<ContentCommentList.CommentListItem> arrayList = new ArrayList<>();
                        arrayList.add(commentListItem);
                        contentCommentList.commentsDO.appendComments = arrayList;
                    }
                    ContentDetailActivity.this.mCommentViewHolder.e(contentCommentList.commentsDO);
                    ContentDetailActivity.this.stopProgressDialog();
                    ContentDetailActivity.this.mInputContent = "";
                    SoftInputUtils.a(ContentDetailActivity.this);
                    cn.damai.common.user.c.e().x(ContentDetailActivity.this.mUt.s());
                }
            });
            startProgressDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpView(ContentDetailResponse contentDetailResponse) {
        String str;
        String h2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16916651")) {
            ipChange.ipc$dispatch("-16916651", new Object[]{this, contentDetailResponse});
        } else if (contentDetailResponse == null) {
            ToastUtil.a().e(this, "加载失败~");
        } else {
            this.mContentResponse = contentDetailResponse;
            ContentDetail contentDetail = contentDetailResponse.contentDetail;
            if (contentDetail != null) {
                int i = contentDetail.itemType;
                boolean z = i == 1 || i == 2;
                this.mWanna2SeeViewHolder.k(i == 2);
                String str2 = contentDetail.sourceId;
                this.mSourceId = str2;
                this.mSourceType = contentDetail.sourceType;
                this.mPublishBtn.setTag(str2);
                ContentDetail.ContentUserInfo contentUserInfo = contentDetail.userInfo;
                if (contentUserInfo != null) {
                    this.mUserInfoView.setAvatarUrl(contentUserInfo.headImg);
                    UserInfoView userInfoView = this.mUserInfoView;
                    PerformFilmVipDO performFilmVipDO = contentUserInfo.performFilmVipDO;
                    if (performFilmVipDO != null) {
                        int i2 = contentUserInfo.userTypeCode;
                        h2 = i2 == 2 ? String.valueOf(i2) : performFilmVipDO.memberFlag;
                    } else {
                        h2 = k23.h();
                    }
                    userInfoView.setVip(false, h2);
                    this.mUserInfoView.setIsOldVip(contentUserInfo.vip);
                    this.mUserInfoView.setUserName(contentUserInfo.nickname);
                    int i3 = contentUserInfo.userTypeCode;
                    if (2 != i3) {
                        this.mUserInfoView.setUserTagType(i3, z);
                    } else {
                        this.mUserInfoView.showUserTagType(false);
                    }
                    this.mUserInfoView.setTag(contentUserInfo);
                    updateFollow(contentUserInfo.focus);
                    updateDna(!TextUtils.isEmpty(contentDetailResponse.similarity), contentDetailResponse.similarity, contentDetailResponse.goDnaUrl, contentDetail.publishTimeStr);
                    this.mFollowBtn.setTag(contentUserInfo);
                    this.mShareBtn.setTag(contentDetailResponse.shareInfo);
                    this.mUt.O(this.mShareBtn);
                    this.mUserInfoView.setVisibility(0);
                    this.mFollowBtn.setVisibility(0);
                    this.mShareBtn.setVisibility(0);
                    this.mContentUserName = contentUserInfo.nickname;
                    this.mInput.setHint(this.mBaseHint);
                    updateUtB(contentUserInfo.havanaIdStr);
                } else {
                    this.mUserInfoView.setVisibility(8);
                    this.mFollowBtn.setVisibility(8);
                }
                this.mBannerViewHolder.z(contentDetail.videoInfo);
                this.mBannerViewHolder.y(contentDetail.title);
                this.mBannerViewHolder.s(contentDetail.image);
                this.mTitleViewHolder.g(contentDetail);
                this.mTextViewHolder.d(contentDetail);
                this.mRichTextViewHolder.d(contentDetail);
                ContentDetail.PraiseInfo praiseInfo = contentDetail.praiseInfo;
                if (praiseInfo == null) {
                    updatePraise(false, 0, false);
                } else {
                    praiseInfo.sourceId = contentDetail.sourceId;
                    praiseInfo.sourceType = contentDetail.sourceType;
                    updatePraise(praiseInfo.hasPraised, praiseInfo.praiseCount, false);
                    this.mDianZanView.setTag(praiseInfo);
                }
                this.mSeePanel.h(contentDetail.focusCount, contentDetail.itemType == 2);
                this.mDMTagViewHolder.d(contentDetail.dmInfo);
                this.mScriptCardViewHolder.d(contentDetail.scriptInfo);
                if (TextUtils.isEmpty(contentDetail.publishCityName)) {
                    str = contentDetail.publishTimeStr + " 发布";
                } else {
                    str = contentDetail.publishTimeStr + " 发布于 " + contentDetail.publishCityName;
                }
                this.mDateViewHolder.d(str);
            }
            ContentTour.ContentTopic contentTopic = contentDetailResponse.themeInfo;
            this.mTopicViewHolder.d(contentTopic);
            if (contentTopic != null) {
                this.mThemeName = contentTopic.name;
            }
            this.mCircleViewHolder.d(contentDetailResponse.cliqueInfo);
            ContentCard contentCard = contentDetailResponse.card;
            if (contentCard != null) {
                if (contentCard.isDramaRelateCard()) {
                    this.mDramaRelateViewHolder.e(new TwoTuple<>(contentCard.title, contentCard.ipInfo));
                } else if (contentCard.isStoreCard()) {
                    this.mContentStoreInfoViewHolder.d(contentCard.storeInfo);
                } else if (contentCard.isProjectRelateCard()) {
                    this.mProjectRelateViewHolder.i(new TwoTuple<>(contentCard.title, contentCard.itemInfo));
                } else if (contentCard.isArtistBrandRelateCard()) {
                    this.mArtistBrandRelatedViewHolder.e(new TwoTuple<>(contentCard, contentCard.artist));
                }
            }
            this.mWanna2SeeViewHolder.g(new FollowInfo(contentDetailResponse.contentDetail, contentCard));
            ContentCommentList contentCommentList = contentDetailResponse.commentList;
            if (contentCommentList != null && contentDetail != null) {
                contentCommentList.sourceId = contentDetail.sourceId;
                contentCommentList.sourceType = contentDetail.sourceType;
            }
            this.mCommentViewHolder.g(contentCommentList);
            if (contentDetailResponse.commentList != null) {
                TextView textView = (TextView) findViewById(R$id.content_detail_comment_text);
                int i4 = contentDetailResponse.commentList.totalComment;
                textView.setText(i4 == 0 ? "回复" : jm1.g(i4));
                findViewById(R$id.content_detail_bottom_comment_layout).setOnClickListener(new View.OnClickListener() { // from class: cn.damai.discover.content.ui.ContentDetailActivity.13
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1846271189")) {
                            ipChange2.ipc$dispatch("1846271189", new Object[]{this, view});
                        } else if (ContentDetailActivity.this.mCommentViewHolder != null) {
                            if (ContentDetailActivity.this.scrollToAncr) {
                                ContentDetailActivity.this.showSoftKey();
                                return;
                            }
                            ContentDetailActivity.this.mContentDetailList.scrollToPosition(0);
                            ContentDetailActivity.this.mContentDetailList.postDelayed(new Runnable() { // from class: cn.damai.discover.content.ui.ContentDetailActivity.13.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-254427314")) {
                                        ipChange3.ipc$dispatch("-254427314", new Object[]{this});
                                        return;
                                    }
                                    ContentDetailActivity.this.mContentDetailList.smoothScrollBy(0, ContentDetailActivity.this.mCommentViewHolder.f());
                                    ContentDetailActivity.this.scrollToAncr = true;
                                    Log.d(GXTemplateEngine.g.TYPE_ON_SCROLL_STATE_CHANGED, "scrollToAncr ===== : " + ContentDetailActivity.this.scrollToAncr);
                                }
                            }, 100L);
                            ContentDetailActivity contentDetailActivity = ContentDetailActivity.this;
                            int i5 = R$id.comment_list_empty_ll;
                            if (contentDetailActivity.findViewById(i5) == null || ContentDetailActivity.this.findViewById(i5).getVisibility() != 0) {
                                return;
                            }
                            ContentDetailActivity.this.showSoftKey();
                        }
                    }
                });
            }
            ContentRecommendList contentRecommendList = contentDetailResponse.recommendList;
            if (contentRecommendList != null && wh2.e(contentRecommendList.card) > 0) {
                this.mContentDetailAdapter.j(contentRecommendList.card);
                this.mRecommendTitle.d(Boolean.TRUE);
            } else {
                this.mRecommendTitle.d(Boolean.FALSE);
            }
            Wanna2SeePanel wanna2SeePanel = this.mSeePanel;
            if (wanna2SeePanel != null) {
                wanna2SeePanel.g(this.mContentDetailList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSoftKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246915998")) {
            ipChange.ipc$dispatch("246915998", new Object[]{this});
            return;
        }
        this.mInput.requestFocus();
        this.mInput.setFocusable(true);
        this.mInput.setText("");
        SoftInputUtils.c(this);
    }

    private void updateDna(boolean z, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587087882")) {
            ipChange.ipc$dispatch("587087882", new Object[]{this, Boolean.valueOf(z), str, str2, str3});
        } else if (z) {
            this.mUserInfoView.setDna(true, str + "%");
            this.mUserInfoView.setDnaClickListener(new a(str2));
            this.mUt.P(this.mUserInfoView.getDnaView());
        } else {
            this.mUserInfoView.setDna(false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFollow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631235034")) {
            ipChange.ipc$dispatch("631235034", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mFollowBtn.setText(z ? "已关注" : "关注");
        this.mFollowBtn.setTextColor(Color.parseColor(z ? "#9C9CA5" : "#FF74BA"));
        this.mFollowBtn.setBackgroundResource(z ? R$drawable.bg_color_c6c6c6_corners : R$drawable.bg_color_ff2869_ff3299_corners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String updateInputText(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-207645458") ? (String) ipChange.ipc$dispatch("-207645458", new Object[]{this, str}) : String.format("%s%s%s", "回复@", str, " 说点什么吧…");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePraise(boolean z, int i, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197435114")) {
            ipChange.ipc$dispatch("-197435114", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)});
            return;
        }
        if (i > 0) {
            this.mPraiseCountFlip.setText(jm1.g(i));
        } else {
            this.mPraiseCountFlip.setText("点赞");
        }
        this.mDianZanIcon.setAnimation(!z ? R$raw.lottie_dian_zan_dismiss : R$raw.lottie_dian_zan);
        if (z2) {
            this.mDianZanIcon.playAnimation();
        } else {
            this.mDianZanIcon.setProgress(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePublishBtuttonEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614846273")) {
            ipChange.ipc$dispatch("-1614846273", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mPublishBtn.setBackgroundResource(R$drawable.bg_color_ff2869_ff3299);
        } else {
            this.mPublishBtn.setBackgroundResource(R$drawable.bg_color_66ff2869_66ff3299);
        }
    }

    private void updateUtB(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737117306")) {
            ipChange.ipc$dispatch("-737117306", new Object[]{this, str});
        } else if (this.mBuilder != null) {
            this.mUt.R(str);
            this.mBuilder.j(this.mUt.C());
            cn.damai.common.user.c.e().l(this, this.mBuilder);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1385111656")) {
            return ((Boolean) ipChange.ipc$dispatch("-1385111656", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            if (SoftInputUtils.b(this, motionEvent)) {
                SoftInputUtils.a(this);
            }
            this.x = motionEvent.getX();
            this.y = motionEvent.getY();
        }
        if (motionEvent.getAction() == 1) {
            if (Math.abs((motionEvent.getX() - this.x) + (motionEvent.getY() - this.y)) > t60.a(this, 10.0f)) {
                this.scrollToAncr = false;
            }
            Log.d(GXTemplateEngine.g.TYPE_ON_SCROLL_STATE_CHANGED, "scrollToAncr dispatchKeyEvent ===== : " + this.scrollToAncr);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // cn.damai.commonbusiness.share.IImageShareInfoProvider
    public Object getImageShareInfo() {
        StoreInfo storeInfo;
        ProjectItemBean projectItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541998332")) {
            return ipChange.ipc$dispatch("-541998332", new Object[]{this});
        }
        if (this.mContentResponse == null) {
            return null;
        }
        LiveShareImageBean liveShareImageBean = new LiveShareImageBean();
        ContentDetail contentDetail = this.mContentResponse.contentDetail;
        if (contentDetail != null) {
            liveShareImageBean.mLivePicList = new ArrayList();
            ArrayList<ContentDetail.ContentBanner> arrayList = contentDetail.image;
            if (arrayList != null) {
                Iterator<ContentDetail.ContentBanner> it = arrayList.iterator();
                while (it.hasNext()) {
                    liveShareImageBean.mLivePicList.add(it.next().url);
                }
            } else {
                ContentDetail.CoverImage coverImage = contentDetail.coverImg;
                if (coverImage != null && !wh2.j(coverImage.url)) {
                    liveShareImageBean.mLivePicList.add(contentDetail.coverImg.url);
                }
            }
            liveShareImageBean.mUserTitleSub = contentDetail.publishTimeStr;
            ContentDetail.ContentUserInfo contentUserInfo = contentDetail.userInfo;
            if (contentUserInfo != null) {
                liveShareImageBean.mIvAccountImage = contentUserInfo.headImg;
                liveShareImageBean.mUserTitle = contentUserInfo.nickname;
                liveShareImageBean.mIsVip = contentUserInfo.vip;
            }
            ArrayList<ContentDetail.ContentText> arrayList2 = contentDetail.content;
            if (arrayList2 != null && !arrayList2.isEmpty() && contentDetail.content.get(0) != null) {
                liveShareImageBean.mNoteText = contentDetail.content.get(0).value;
            } else if (!wh2.j(contentDetail.title)) {
                liveShareImageBean.mNoteText = contentDetail.title;
            }
        }
        ContentTour itemInfo = this.mContentResponse.getItemInfo();
        DramaV1Bean ipInfo = this.mContentResponse.getIpInfo();
        List<RelatedBrandOrArtist> artistItem = this.mContentResponse.getArtistItem();
        if (itemInfo != null && (projectItemBean = itemInfo.itemInfo) != null) {
            liveShareImageBean.mProjectImage = projectItemBean.verticalPic;
            liveShareImageBean.mProjectTitle = projectItemBean.name;
            liveShareImageBean.mProjectInfo = formatCityAndTime(projectItemBean);
        } else if (ipInfo != null) {
            liveShareImageBean.mProjectImage = ipInfo.pic;
            liveShareImageBean.mProjectTitle = ipInfo.title;
            liveShareImageBean.mProjectInfo = DramaV1Bean.getContactStr(ipInfo.tags);
        } else if (!m91.a(artistItem)) {
            ArrayList arrayList3 = new ArrayList();
            for (RelatedBrandOrArtist relatedBrandOrArtist : artistItem) {
                LiveShareImageBean.ShareArtistItem shareArtistItem = new LiveShareImageBean.ShareArtistItem();
                shareArtistItem.mArtistAvatar = relatedBrandOrArtist.headPic;
                shareArtistItem.mArtistName = relatedBrandOrArtist.name;
                if (relatedBrandOrArtist.fansCount > 0) {
                    shareArtistItem.mArtistDesc = jm1.g(relatedBrandOrArtist.fansCount) + "粉丝";
                }
                arrayList3.add(shareArtistItem);
            }
            liveShareImageBean.mArtistList = arrayList3;
        }
        ContentDetailResponse contentDetailResponse = this.mContentResponse;
        DmInfo dmInfo = contentDetailResponse.contentDetail.dmInfo;
        if (dmInfo != null) {
            liveShareImageBean.dmInfo = dmInfo;
        }
        ContentCard contentCard = contentDetailResponse.card;
        if (contentCard != null && (storeInfo = contentCard.storeInfo) != null) {
            liveShareImageBean.storeInfo = storeInfo;
            liveShareImageBean.itemType = 1;
        }
        ContentShareInfo contentShareInfo = contentDetailResponse.shareInfo;
        if (contentShareInfo != null) {
            liveShareImageBean.mShareQrcode = contentShareInfo.shareUrl;
        }
        return liveShareImageBean;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "398145902") ? ((Integer) ipChange.ipc$dispatch("398145902", new Object[]{this})).intValue() : R$layout.activity_content_detail;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890589645")) {
            ipChange.ipc$dispatch("1890589645", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.handleError(i);
        requestContent();
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036796449")) {
            ipChange.ipc$dispatch("-2036796449", new Object[]{this});
            return;
        }
        super.initView();
        removeHeadTitleView();
        initStatuBar();
        initTitleView();
        initContentView();
        requestContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124376070")) {
            ipChange.ipc$dispatch("124376070", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299402245")) {
            ipChange.ipc$dispatch("299402245", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.content_detail_back_icon) {
            SoftInputUtils.a(this);
            finish();
        } else if (id == R$id.content_detail_user_info) {
            ContentDetail.ContentUserInfo contentUserInfo = (ContentDetail.ContentUserInfo) view.getTag();
            if (contentUserInfo == null || this.mContentResponse == null) {
                return;
            }
            cn.damai.common.user.c.e().x(this.mUt.K(contentUserInfo.havanaIdStr));
            Bundle bundle = new Bundle();
            String str = contentUserInfo.bid;
            String str2 = contentUserInfo.btype;
            if (this.mContentResponse.myself || !TextUtils.equals("4", str2)) {
                str = contentUserInfo.havanaIdStr;
                str2 = contentUserInfo.targetType;
            }
            bundle.putString("userId", str);
            bundle.putString(RepertoireDetailFragment.USERTYPE, str2);
            DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b(cs.Y));
        } else if (id == R$id.content_detail_follow_btn) {
            ContentDetail.ContentUserInfo contentUserInfo2 = (ContentDetail.ContentUserInfo) view.getTag();
            if (contentUserInfo2 == null) {
                return;
            }
            requestFollow(contentUserInfo2);
        } else if (id == R$id.content_detail_dian_zan_layout) {
            ContentDetail.PraiseInfo praiseInfo = (ContentDetail.PraiseInfo) view.getTag();
            if (praiseInfo == null) {
                return;
            }
            requestPraise(praiseInfo);
        } else if (id == R$id.content_detail_publisher_btn) {
            if (view.getTag() instanceof String) {
                requestPublish((String) view.getTag(), null);
            } else {
                Object tag = view.getTag();
                if (tag instanceof ContentCommentList.CommentListItem) {
                    ContentCommentList.CommentListItem commentListItem = (ContentCommentList.CommentListItem) tag;
                    requestPublish(commentListItem.commentId, commentListItem);
                }
            }
            this.mInput.setText("");
        } else if (id == R$id.content_detail_back_to_top) {
            this.mContentDetailList.smoothScrollToPosition(0);
        } else if (id == R$id.content_detail_bottom_follow_layout) {
            ContentShareViewHolder contentShareViewHolder = this.mWanna2SeeViewHolder;
            if (contentShareViewHolder != null) {
                cn.damai.common.user.c.e().x(this.mUt.t(contentShareViewHolder.i()));
                this.mWanna2SeeViewHolder.j();
            }
        } else if (id == R$id.content_detail_share_btn) {
            Object tag2 = view.getTag();
            if (tag2 instanceof ContentShareInfo) {
                ContentShareInfo contentShareInfo = (ContentShareInfo) tag2;
                cn.damai.common.user.c.e().x(this.mUt.F());
                Bundle bundle2 = new Bundle();
                bundle2.putString("imageurl", contentShareInfo.shareImage);
                bundle2.putString("title", contentShareInfo.shareTitle);
                bundle2.putString("message", contentShareInfo.shareSubTitle);
                bundle2.putString("producturl", contentShareInfo.shareUrl);
                bundle2.putBoolean("showGenerateImage", this.mContentResponse.contentDetail.itemType != 2);
                bundle2.putString("shareType", "chat_h5");
                bundle2.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_LIVE_IMAGE);
                ShareManager.E().Q(this, bundle2, getWindow().getDecorView(), this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614293499")) {
            ipChange.ipc$dispatch("1614293499", new Object[]{this, bundle});
            return;
        }
        String string = getString("contentId");
        this.mContentId = string;
        this.mUt.Q(string);
        setDamaiUTKeyBuilder(this.mUt.B());
        cn.damai.common.user.c.e().K(this);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671873541")) {
            ipChange.ipc$dispatch("-1671873541", new Object[]{this});
            return;
        }
        Wanna2SeePanel wanna2SeePanel = this.mSeePanel;
        if (wanna2SeePanel != null) {
            wanna2SeePanel.e();
        }
        ContentBannerViewHolder contentBannerViewHolder = this.mBannerViewHolder;
        if (contentBannerViewHolder != null) {
            contentBannerViewHolder.u();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456971391")) {
            ipChange.ipc$dispatch("456971391", new Object[]{this});
            return;
        }
        super.onPause();
        ContentBannerViewHolder contentBannerViewHolder = this.mBannerViewHolder;
        if (contentBannerViewHolder != null) {
            contentBannerViewHolder.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResponseError(String str, String str2, String str3, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1703817262")) {
            ipChange.ipc$dispatch("1703817262", new Object[]{this, str, str2, str3, view, Boolean.valueOf(z)});
            return;
        }
        super.onResponseError(str, str2, str3, view, z);
        this.mInputLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResponseSuccess(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877789313")) {
            ipChange.ipc$dispatch("-877789313", new Object[]{this, view});
            return;
        }
        super.onResponseSuccess(view);
        this.mInputLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365969560")) {
            ipChange.ipc$dispatch("-1365969560", new Object[]{this});
            return;
        }
        super.onResume();
        ContentBannerViewHolder contentBannerViewHolder = this.mBannerViewHolder;
        if (contentBannerViewHolder != null) {
            contentBannerViewHolder.w();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471664482")) {
            return (String) ipChange.ipc$dispatch("471664482", new Object[]{this});
        }
        return null;
    }

    public void showWantSeeTips() {
        WantSeeTips wantSeeTips;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579532616")) {
            ipChange.ipc$dispatch("-1579532616", new Object[]{this});
        } else if (g03.INSTANCE.e(this, new b()) || (wantSeeTips = this.wantSeeTips) == null) {
        } else {
            wantSeeTips.showAnim();
        }
    }
}
