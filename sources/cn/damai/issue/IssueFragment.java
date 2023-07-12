package cn.damai.issue;

import android.animation.Animator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import cn.damai.comment.R$anim;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.QueryThemeCliqueInfoBean;
import cn.damai.comment.bean.QueryThemeResultBean;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.comment.view.DMCommentSubItemView;
import cn.damai.comment.view.OnItemClickListener;
import cn.damai.comment.view.OnTipsSelectedListener;
import cn.damai.comment.view.PublishDMSelectView;
import cn.damai.comment.view.PublishInputTipsView;
import cn.damai.common.AppConfig;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.image.luban.Luban;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.uploader.AusResult;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.utils.MediaUtils;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.evaluate.request.EvaluateSuccessRenderRequest;
import cn.damai.evaluate.ui.EvaluateSuccessActivity;
import cn.damai.issue.bean.DraftBean;
import cn.damai.issue.bean.DraftExtra;
import cn.damai.issue.bean.DraftMd5NameAssembler;
import cn.damai.issue.listener.OnCheckDraftListener;
import cn.damai.issue.listener.OnDialogListener;
import cn.damai.issue.net.CommentGradeTagBean;
import cn.damai.issue.net.EvaluteSuccessRenderResponse;
import cn.damai.issue.net.IssueLiveDataResponse;
import cn.damai.issue.net.IssueRenderLiveDataResponse;
import cn.damai.issue.net.IssueRenderResponse;
import cn.damai.issue.net.IssueResponse;
import cn.damai.issue.tool.IDraftContentProvider;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.issue.tool.draft.DraftBox;
import cn.damai.issue.tool.draft.DraftEmptyBox;
import cn.damai.issue.tool.draft.IDraftBox;
import cn.damai.issue.view.CorrelationType;
import cn.damai.issue.view.CorrelationView;
import cn.damai.issue.view.DMLinearLayoutIssue;
import cn.damai.issue.view.DMSortableNinePhotoLayout;
import cn.damai.issue.view.SpoilerSwitchView;
import cn.damai.login.LoginManager;
import cn.damai.model.IssueViewModel;
import cn.damai.network.NetworkType;
import cn.damai.tetris.component.brand.bean.ProjectDO;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.BottomActionDialog;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.uikit.view.MyScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.view.DMRatingBar;
import com.alibaba.pictures.uploader.FileUploadListener;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.UploadErrorCode;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskResult;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import tb.b23;
import tb.b82;
import tb.cb1;
import tb.el;
import tb.g41;
import tb.h4;
import tb.i41;
import tb.ir1;
import tb.jn1;
import tb.k23;
import tb.ko;
import tb.m61;
import tb.mr1;
import tb.mu0;
import tb.on1;
import tb.pf0;
import tb.q50;
import tb.rx2;
import tb.s11;
import tb.t60;
import tb.uu2;
import tb.w11;
import tb.wc0;
import tb.wh2;
import tb.wj1;
import tb.xj1;
import tb.xr;
import tb.z20;
import tb.zk;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class IssueFragment extends DamaiBaseMvpFragment implements DMCommentSubItemView.GradeChangeLister, IDraftContentProvider {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_CODE_COVER_VEDIO = 1003;
    private static final int REQUEST_CODE_LOGIN = 1000;
    private static final int REQUEST_CODE_PREVIEW_VEDIO = 1002;
    private static final int REQUEST_CODE_SELECT_ALBUM = 17;
    private static final int REQUEST_CODE_SELECT_VEDIO = 1001;
    private static final int REQUEST_CODE_SHARE = 104;
    private static final int REQUEST_CODE_TAKE_PHOTO = 102;
    private static final int REQUEST_CODE_TO_IDOL = 101;
    public static final int REQUEST_CORRELATION_PROJECT = 105;
    private static final int REQUEST_PRIVILEGE_PROJECT = 103;
    private static final int VEDIO_MAX_COUNT = 1;
    private View associatedHolder;
    private RelativeLayout associatedLayout;
    private DMIconFontTextView associatedProjectArrow;
    private RoundRadiusImageView associatedProjectImage;
    private TextView associatedProjectName;
    private TextView associatedProjectTimeAddress;
    private TextView associatedProjectTip;
    private TextView associatedTipHint;
    private ConstraintLayout clCircleLayout;
    private CorrelationView correlationView;
    private Bitmap coverBitmap;
    private PublishDMSelectView dmSelectView;
    Observer<CommentsResultBean> evaluateDetailObserver;
    private LottieAnimationView fullStarLottie;
    private ImageView giftIntroduce;
    private TextView gradeTip;
    private LinearLayout guideAnimLayout;
    private LottieAnimationView guideLottie;
    private View holder_view;
    private PublishInputTipsView inputTipsView;
    private IssueCircleSelect issueCircleSelect;
    Observer<IssueLiveDataResponse> issueObserver;
    Observer<IssueRenderLiveDataResponse> issueRenderResponseObserver;
    IssueViewModel issueViewModel;
    private DMLinearLayoutIssue issue_window_layout;
    private DMIconFontTextView ivCircleScreen;
    private ConstraintLayout llThemeLayout;
    private FileUploader mCoverUploader;
    private DMRatingBar mDMRatingBar;
    private IDraftBox mDraftBox;
    private EditText mEditor;
    private TextView mEditorLimitTip;
    private TextView mEvaGift;
    private RelativeLayout mEvaluateLayout;
    private String mFilePath;
    private int mImagesPublishCount;
    private boolean mIsUploadImageFailure;
    private TextView mIssueEvaluateTip;
    private DMIconFontTextView mIssueTitleCancel;
    private TextView mIssueTitleConfirm;
    private TextView mIssueTitlecontent;
    private TextView mRatingBarDesc;
    private DMSortableNinePhotoLayout mShowNiePhoto;
    private FileUploader mSubmitUploader;
    private LinearLayout mSumItemBar;
    private TextView mTeachGoodEvaluate;
    private DraftExtra mTempDraftExtra;
    FileUploader mVideoUploader;
    private LinearLayout.LayoutParams params;
    private String privilegeType;
    private ViewGroup.LayoutParams rootParam;
    private MyScrollView scrollView;
    boolean softShowing;
    private SpoilerSwitchView spoilerSwitchView;
    private LinearLayout submitLayout;
    Observer<QueryThemeResultBean> themeObserver;
    private TextView tvCircleContent;
    private TextView tvThemeContent;
    private CommentsVideoBean videoBean;
    private int viewHeight;
    private int mEditorLimit = 10000;
    private ArrayList<uu2> mImagesSelectData = new ArrayList<>();
    private ArrayList<String> mEditAddImages = new ArrayList<>();
    private ArrayList<Image> mEditAddSelectImages = new ArrayList<>();
    private ArrayList<String> mPaths = new ArrayList<>();
    private int mIsRequestLoading = 0;
    private int visibleWindowDisplayHeight = 0;
    private int tempBottom = 0;
    private TextWatcher mOnTextChangedListener = new p();
    private boolean isDelay = false;
    private DMRatingBar.OnStarChangeListener mOnStarChangeListener = new DMRatingBar.OnStarChangeListener() { // from class: cn.damai.issue.IssueFragment.10
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.issue.IssueFragment$10$a */
        /* loaded from: classes14.dex */
        public class a implements Animator.AnimatorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "685345202")) {
                    ipChange.ipc$dispatch("685345202", new Object[]{this, animator});
                    return;
                }
                pf0.g().o(IssueFragment.this.mDMRatingBar);
                pf0.g().m(IssueFragment.this.fullStarLottie);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-783720771")) {
                    ipChange.ipc$dispatch("-783720771", new Object[]{this, animator});
                    return;
                }
                pf0.g().o(IssueFragment.this.mDMRatingBar);
                pf0.g().m(IssueFragment.this.fullStarLottie);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1296046479")) {
                    ipChange.ipc$dispatch("-1296046479", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1314181334")) {
                    ipChange.ipc$dispatch("1314181334", new Object[]{this, animator});
                }
            }
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onEventActionUp() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-457994634")) {
                ipChange.ipc$dispatch("-457994634", new Object[]{this});
                return;
            }
            if (!IssueFragment.this.issueViewModel.isPrivilege()) {
                IssueFragment.this.gradeTip();
            }
            if (IssueFragment.this.issueViewModel.getmGrades() != 10 || "1".equals(IssueFragment.this.issueViewModel.getItemType())) {
                return;
            }
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) IssueFragment.this.fullStarLottie.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).height = t60.a(IssueFragment.this.getContext(), 33.0f) - t60.a(IssueFragment.this.getContext(), 0.4f);
            ((ViewGroup.MarginLayoutParams) layoutParams).width = t60.a(IssueFragment.this.getContext(), 168.0f) - t60.a(IssueFragment.this.getContext(), 0.3f);
            pf0.g().n(IssueFragment.this.mDMRatingBar);
            pf0.g().o(IssueFragment.this.fullStarLottie);
            IssueFragment.this.fullStarLottie.playAnimation();
            if (Build.VERSION.SDK_INT >= 11) {
                IssueFragment.this.fullStarLottie.addAnimatorListener(new a());
            }
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onStarChange(float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1943223143")) {
                ipChange.ipc$dispatch("-1943223143", new Object[]{this, Float.valueOf(f2)});
                return;
            }
            SoftInputUtils.a(IssueFragment.this.getActivity());
            pf0.g().o(IssueFragment.this.mDMRatingBar);
            pf0.g().m(IssueFragment.this.fullStarLottie);
            cb1.b("IssueActivity", "点击总评分 分评分无或者已经显示");
            IssueFragment.this.issueViewModel.setmGrades((int) (f2 * 2.0f));
            IssueFragment issueFragment = IssueFragment.this;
            issueFragment.gradesDesc(el.a(issueFragment.issueViewModel.getmGrades()));
            if (IssueFragment.this.mSumItemBar == null || IssueFragment.this.mSumItemBar.getChildCount() <= 0 || IssueFragment.this.mSumItemBar.getVisibility() != 8 || IssueFragment.this.isDelay) {
                IssueFragment.this.updateIssueButtonStatus();
                return;
            }
            cb1.b("IssueActivity", "点击总评分0");
            IssueFragment.this.isDelay = true;
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.issue.IssueFragment.10.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "919967082")) {
                        ipChange2.ipc$dispatch("919967082", new Object[]{this});
                        return;
                    }
                    IssueFragment issueFragment2 = IssueFragment.this;
                    issueFragment2.issueViewModel.animateToggle(issueFragment2.mSumItemBar, IssueFragment.this.viewHeight);
                    pf0.g().o(IssueFragment.this.mSumItemBar);
                    IssueFragment.this.updateIssueButtonStatus();
                    cb1.b("IssueActivity", "点击总评分1");
                }
            }, 50L);
        }
    };
    String coverPath = "";
    DMSortableNinePhotoLayout.OnNinePhotoClickListener mShowPhotoListener = new c();
    private DMSortableNinePhotoLayout.OnSortListener mOnSortListener = new d();
    private View.OnClickListener mOnClickListener = new f();
    private FileUploadListener mSubmitFilesListener = new j();
    private FileUploadListener mCoverUploadListener = new k();
    private FileUploadListener mCoverUpdateListener = new l();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements OnCheckDraftListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.issue.IssueFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0054a implements OnDialogListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ DraftBean a;

            C0054a(DraftBean draftBean) {
                this.a = draftBean;
            }

            @Override // cn.damai.issue.listener.OnDialogListener
            public void onDialogClick(DialogInterface dialogInterface, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-192161520")) {
                    ipChange.ipc$dispatch("-192161520", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
                    return;
                }
                if (z) {
                    i41.y();
                } else {
                    i41.x();
                }
                if (!z) {
                    IssueFragment.this.mDraftBox.deleteCurDraft();
                }
                IssueFragment.this.mDraftBox.startAutoDraft();
                if (z) {
                    DraftBean draftBean = this.a;
                    String str = draftBean.userInput;
                    String str2 = draftBean.themeName;
                    String str3 = draftBean.themeId;
                    List<QueryThemeCliqueInfoBean> list = draftBean.circle;
                    List<QueryThemeCliqueInfoBean> list2 = draftBean.circleList;
                    IssueFragment.this.issueViewModel.setComeFromCircle(false);
                    IssueFragment.this.issueViewModel.setComeFromTheme(false);
                    IssueFragment.this.ivCircleScreen.setVisibility(0);
                    if (!TextUtils.isEmpty(str3)) {
                        IssueFragment.this.issueViewModel.setThemeId(this.a.themeId);
                        IssueFragment.this.updateTheme(str2);
                    }
                    if (list2 != null && list != null) {
                        IssueFragment.this.issueViewModel.setCircleList(list2);
                        IssueFragment.this.issueViewModel.setCircle(list.get(0));
                        IssueFragment.this.updateCircle(list2, list.get(0));
                    }
                    IssueFragment.this.issueViewModel.setStoreId(this.a.storeId);
                    IssueFragment.this.issueViewModel.setItemType(this.a.itemType);
                    if (IssueFragment.this.issueViewModel.isPrivilege()) {
                        IssueFragment.this.mEditor.setText(str);
                        DraftExtra draftExtra = this.a.mExtra;
                        if (draftExtra == null || !draftExtra.isValid()) {
                            return;
                        }
                        IssueFragment.this.privilegeView(true, wc0.g(this.a.mExtra), true);
                    } else if (IssueFragment.this.issueViewModel.isEvaluate()) {
                        IssueFragment.this.mEditor.setText(str);
                    } else if (IssueFragment.this.issueViewModel.isEdit()) {
                        IssueFragment.this.mEditor.setText(str);
                    }
                }
            }
        }

        a() {
        }

        @Override // cn.damai.issue.listener.OnCheckDraftListener
        public void onHasDraft(DraftBean draftBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "474658730")) {
                ipChange.ipc$dispatch("474658730", new Object[]{this, draftBean});
            } else if (IssueFragment.this.isActivityOk()) {
                FragmentActivity activity = IssueFragment.this.getActivity();
                if (AppConfig.v()) {
                    String e = m61.e(draftBean);
                    cb1.c(DraftBox.TAG, "命中草稿： " + e);
                }
                wc0.e(activity, new C0054a(draftBean));
            }
        }

        @Override // cn.damai.issue.listener.OnCheckDraftListener
        public void onNoneDraft() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2046385274")) {
                ipChange.ipc$dispatch("-2046385274", new Object[]{this});
            } else {
                IssueFragment.this.mDraftBox.startAutoDraft();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b extends q50 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ String c;

        b(long j, long j2, String str) {
            this.a = j;
            this.b = j2;
            this.c = str;
        }

        @Override // tb.q50
        public void a(@NonNull uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-935253111")) {
                ipChange.ipc$dispatch("-935253111", new Object[]{this, uu2Var});
                return;
            }
            IssueFragment.this.delVideo(true);
            cb1.c("uploader end fail", (System.currentTimeMillis() - this.a) + "");
            b23.g("IssueFragment:jsondata={HavanaId:" + z20.i() + ",videoSize:" + cn.damai.common.image.luban.b.b(this.c) + ",apn:" + IssueFragment.this.getNetworkType() + "}", "-7300", "上传视频失败");
        }

        @Override // tb.q50
        public void b(@NonNull uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1163342416")) {
                ipChange.ipc$dispatch("-1163342416", new Object[]{this, uu2Var});
            } else if (!IssueFragment.this.isAdded() || uu2Var.d() == null) {
            } else {
                ITaskResult d = uu2Var.d();
                String str = null;
                if (!TextUtils.isEmpty(d.getFileUrl())) {
                    str = d.getFileUrl();
                } else if (d.getResult() != null && d.getResult().containsKey("x-arup-file-url")) {
                    str = d.getResult().get("x-arup-file-url");
                }
                if (str != null) {
                    IssueFragment.this.videoBean = new CommentsVideoBean();
                    IssueFragment.this.videoBean.setUrl(str);
                    IssueFragment.this.videoBean.setVideoTime(String.valueOf(this.b));
                    cb1.c("uploader fileUrl", str);
                    cb1.c("uploader end success", (System.currentTimeMillis() - this.a) + "");
                    Bitmap d2 = MediaUtils.c().d(this.c);
                    IssueFragment issueFragment = IssueFragment.this;
                    issueFragment.uploadVideoCover(d2, issueFragment.mCoverUploadListener, false);
                    return;
                }
                cb1.c("uploader success,but fileUrl == null", (System.currentTimeMillis() - this.a) + "");
                IssueFragment.this.delVideo(true);
            }
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onSingleTaskProgress(@NonNull uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1187534520")) {
                ipChange.ipc$dispatch("-1187534520", new Object[]{this, uu2Var});
                return;
            }
            int c = uu2Var.c();
            DMSortableNinePhotoLayout dMSortableNinePhotoLayout = IssueFragment.this.mShowNiePhoto;
            dMSortableNinePhotoLayout.notifyItemChanged(0, "progress:" + c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements DMSortableNinePhotoLayout.OnNinePhotoClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickAddNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2131130092")) {
                ipChange.ipc$dispatch("2131130092", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), arrayList});
            } else if (IssueFragment.this.mIsRequestLoading == 0) {
                IssueFragment.this.openAlbum();
            } else {
                IssueFragment.this.uploadingTip();
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickAddVideoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-577821519")) {
                ipChange.ipc$dispatch("-577821519", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), arrayList});
            } else {
                pf0.k(IssueFragment.this.getActivity(), 1001, 1);
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickChangeVideoCoverItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, int i, Image image, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "983835213")) {
                ipChange.ipc$dispatch("983835213", new Object[]{this, dMSortableNinePhotoLayout, Integer.valueOf(i), image, arrayList});
            } else if (IssueFragment.this.mIsRequestLoading == 0) {
                s11.c(IssueFragment.this.getActivity(), 1003, true, 1, new ArrayList());
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickDeleteNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, Image image, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1279772218")) {
                ipChange.ipc$dispatch("1279772218", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), image, arrayList});
            } else if (image == null) {
            } else {
                if ("2".equals(image.getType())) {
                    IssueFragment.this.videoBean = null;
                    FileUploader fileUploader = IssueFragment.this.mVideoUploader;
                    if (fileUploader != null) {
                        fileUploader.p();
                    }
                    IssueFragment.this.delVideo(false);
                    return;
                }
                int delImagePosCorrect = IssueFragment.this.delImagePosCorrect(i);
                if (wh2.e(IssueFragment.this.mEditAddImages) > 0 && IssueFragment.this.mEditAddImages.contains(IssueFragment.this.issueViewModel.getmImages().get(delImagePosCorrect))) {
                    IssueFragment.this.mEditAddImages.remove(IssueFragment.this.issueViewModel.getmImages().get(delImagePosCorrect));
                }
                if (delImagePosCorrect < wh2.e(IssueFragment.this.issueViewModel.getmSelectImages())) {
                    IssueFragment.this.issueViewModel.getmSelectImages().get(delImagePosCorrect).setShowNum(0);
                    IssueFragment.this.issueViewModel.getmSelectImages().remove(delImagePosCorrect);
                }
                if (delImagePosCorrect < wh2.e(IssueFragment.this.issueViewModel.getmImages())) {
                    IssueFragment.this.issueViewModel.getmImages().remove(delImagePosCorrect);
                }
                if (i < IssueFragment.this.mShowNiePhoto.getItemCount()) {
                    IssueFragment.this.mShowNiePhoto.removeItem(i);
                }
                IssueFragment.this.setmEvaGiftContent();
                IssueFragment.this.updateIssueButtonStatus();
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, Image image, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2080019237")) {
                ipChange.ipc$dispatch("2080019237", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), image, arrayList});
            } else if (IssueFragment.this.mIsRequestLoading != 0) {
                IssueFragment.this.uploadingTip();
            } else {
                pf0.j(IssueFragment.this.getActivity(), IssueFragment.this.delImagePosCorrect(i), false, IssueFragment.this.issueViewModel.getmSelectImages().size(), IssueFragment.this.issueViewModel.getmSelectImages(), "1", 18);
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickPalyerVideoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1526738343")) {
                ipChange.ipc$dispatch("-1526738343", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), arrayList});
            } else if (IssueFragment.this.mIsRequestLoading == 0) {
                ArrayList arrayList2 = new ArrayList();
                if (IssueFragment.this.mShowNiePhoto.getData() == null || IssueFragment.this.mShowNiePhoto.getData().size() <= 0 || IssueFragment.this.mShowNiePhoto.getData().get(0) == null) {
                    return;
                }
                Image image = new Image();
                image.setPath(IssueFragment.this.mShowNiePhoto.getData().get(0).getPath());
                image.setType(IssueFragment.this.mShowNiePhoto.getData().get(0).getType());
                image.setThumbnail(IssueFragment.this.mShowNiePhoto.getData().get(0).getThumbnail());
                arrayList2.add(image);
                pf0.j(IssueFragment.this.getActivity(), i, true, arrayList2.size(), arrayList2, "2", 1002);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d implements DMSortableNinePhotoLayout.OnSortListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnSortListener
        public void onSortComplete(ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1399640364")) {
                ipChange.ipc$dispatch("-1399640364", new Object[]{this, arrayList});
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < wh2.e(arrayList); i++) {
                String path = arrayList.get(i).getPath();
                for (int i2 = 0; i2 < wh2.e(IssueFragment.this.issueViewModel.getmSelectImages()); i2++) {
                    Image image = IssueFragment.this.issueViewModel.getmSelectImages().get(i2);
                    String path2 = image.getPath();
                    if (path.equals(path2)) {
                        arrayList2.add(image);
                        arrayList3.add(path2);
                    }
                }
            }
            IssueFragment.this.issueViewModel.getmImages().clear();
            IssueFragment.this.issueViewModel.getmSelectImages().clear();
            IssueFragment.this.issueViewModel.getmImages().addAll(arrayList3);
            IssueFragment.this.issueViewModel.getmSelectImages().addAll(arrayList2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class e implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1886958527")) {
                ipChange.ipc$dispatch("-1886958527", new Object[]{this});
                return;
            }
            i41.i().q("picture_upload");
            try {
                int i = IssueFragment.this.getSelectVideo() == null ? 9 : 8;
                if (IssueFragment.this.issueViewModel.isEdit()) {
                    for (int i2 = 0; i2 < wh2.e(IssueFragment.this.issueViewModel.getmImages()); i2++) {
                        if (IssueFragment.this.issueViewModel.getmImages().get(i2).startsWith("http")) {
                            i--;
                        }
                    }
                    s11.c(IssueFragment.this.getActivity(), 17, false, i, IssueFragment.this.mEditAddImages);
                    return;
                }
                s11.c(IssueFragment.this.getActivity(), 17, false, i, IssueFragment.this.issueViewModel.getmImages());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* loaded from: classes5.dex */
        public class a implements OnGrantListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.common.askpermission.OnGrantListener
            public void onGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2082115379")) {
                    ipChange.ipc$dispatch("2082115379", new Object[]{this});
                } else {
                    IssueFragment.this.onIssueClicked();
                }
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1591961537")) {
                ipChange.ipc$dispatch("-1591961537", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.issue_title_cancel) {
                IssueFragment.this.onBackClicked();
            } else if (id != R$id.tv_circle_tip_content && id != R$id.iv_circle_screen) {
                if (id == R$id.issue_title_confirm) {
                    if (IssueFragment.this.issueViewModel.isEvaluate() || IssueFragment.this.issueViewModel.isEdit() || IssueFragment.this.issueViewModel.isPrivilege()) {
                        if (IssueFragment.this.issueViewModel.isPrivilege() && "0".equals(IssueFragment.this.issueViewModel.getmTargetId())) {
                            ToastUtil.i("请选择关联项目哦");
                            return;
                        } else if (IssueFragment.this.issueViewModel.getmGrades() != 0 && IssueFragment.this.issueViewModel.getmGrades() >= 0) {
                            if (!wh2.j(IssueFragment.this.issueViewModel.getmEditorContent())) {
                                if (IssueFragment.this.getSelectVideo() != null && IssueFragment.this.mIsRequestLoading != 0) {
                                    IssueFragment.this.uploadingTip();
                                    return;
                                }
                            } else {
                                ToastUtil.i("请输入评价内容哦");
                                return;
                            }
                        } else if ("1".equals(IssueFragment.this.issueViewModel.getItemType())) {
                            ToastUtil.i("请给店铺打总分哦");
                            return;
                        } else if ("2".equals(IssueFragment.this.issueViewModel.getItemType())) {
                            ToastUtil.i("请给剧本打总分哦");
                            return;
                        } else {
                            ToastUtil.i("请给演出打总分哦");
                            return;
                        }
                    }
                    if ((!IssueFragment.this.issueViewModel.isEdit() || wh2.e(IssueFragment.this.mEditAddImages) <= 0) && wh2.e(IssueFragment.this.issueViewModel.getmImages()) <= 0) {
                        IssueFragment.this.onIssueClicked();
                    } else {
                        ir1.b(IssueFragment.this.getActivity(), false, mr1.STORAGE, "用于选取、上传图片/视频", new a());
                    }
                } else if (id == R$id.issue_title_teach_good_evaluate) {
                    i41.i().u(IssueFragment.this.issueViewModel.getmIssueType(), IssueFragment.this.issueViewModel.isEvaluate() ? IssueFragment.this.issueViewModel.getmItemId() : "");
                    Bundle bundle = new Bundle();
                    bundle.putString("url", g41.ISSUE_TEACH_GOOD_URL);
                    DMNav.from(IssueFragment.this.getActivity()).withExtras(bundle).toUri(NavUri.b(a.c.d));
                } else if (id == R$id.issue_evaluate_associated_project) {
                    i41.i().r();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("hint", "搜索关键词查找关联项目");
                    if (IssueFragment.this.issueViewModel.isComeFromTheme()) {
                        bundle2.putString("themeId", IssueFragment.this.issueViewModel.getThemeId());
                    }
                    DMNav.from(IssueFragment.this.getActivity()).withExtras(bundle2).forResult(103).toUri(NavUri.b("search_privilege_result"));
                }
            } else if (IssueFragment.this.issueViewModel.isComeFromCircle() || IssueFragment.this.issueCircleSelect.e() <= 0) {
            } else {
                IssueFragment.this.issueCircleSelect.k();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class g implements OnDialogListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // cn.damai.issue.listener.OnDialogListener
        public void onDialogClick(DialogInterface dialogInterface, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-179039320")) {
                ipChange.ipc$dispatch("-179039320", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
            } else {
                IssueFragment.this.finishByUser();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class h implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "142042638")) {
                ipChange.ipc$dispatch("142042638", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("text", IssueFragment.this.issueViewModel.getmEditorContent());
            if (IssueFragment.this.issueViewModel.isFromHome() && IssueFragment.this.getActivity() != null && !IssueFragment.this.getActivity().isFinishing()) {
                intent.putExtra("tip", IssueFragment.this.getString(R$string.damai_homepage_comment_await_comment_tips));
            }
            IssueFragment.this.getActivity().setResult(-1, intent);
            SoftInputUtils.a(IssueFragment.this.getActivity());
            IssueFragment.this.finish();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class i implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i(IssueFragment issueFragment) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1111623661")) {
                ipChange.ipc$dispatch("1111623661", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class j extends q50 {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onAllSuccess(@NonNull List<uu2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-628247526")) {
                ipChange.ipc$dispatch("-628247526", new Object[]{this, list});
                return;
            }
            if (!list.isEmpty()) {
                for (uu2 uu2Var : list) {
                    IssueFragment.this.mImagesSelectData.add(uu2Var);
                }
                IssueFragment.this.requestIssue();
            }
            IssueFragment.this.mIsRequestLoading = 0;
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-89522735")) {
                ipChange.ipc$dispatch("-89522735", new Object[]{this});
                return;
            }
            cb1.c("uploader cover cancel", "cancel");
            IssueFragment.this.mIsUploadImageFailure = true;
            IssueFragment.this.mIsRequestLoading = 0;
            IssueFragment.this.requestIssue();
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onFailure(@NonNull UploadErrorCode uploadErrorCode, @NonNull List<uu2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2115617391")) {
                ipChange.ipc$dispatch("-2115617391", new Object[]{this, uploadErrorCode, list});
                return;
            }
            cb1.c("uploader cover fail", "fail");
            IssueFragment.this.mIsUploadImageFailure = true;
            IssueFragment.this.mIsRequestLoading = 0;
            IssueFragment.this.requestIssue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class k extends q50 {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        @Override // tb.q50
        public void a(uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493797465")) {
                ipChange.ipc$dispatch("-493797465", new Object[]{this, uu2Var});
                return;
            }
            cb1.c("uploader cover fail", "fail");
            IssueFragment.this.delVideo(true);
        }

        @Override // tb.q50
        public void b(@NonNull uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-721886770")) {
                ipChange.ipc$dispatch("-721886770", new Object[]{this, uu2Var});
                return;
            }
            String imageUrl = uu2Var != null ? IssueFragment.this.imageUrl(uu2Var.d()) : null;
            if (!TextUtils.isEmpty(imageUrl)) {
                IssueFragment.this.updateVideoBean(imageUrl);
                IssueFragment.this.mShowNiePhoto.notifyItemChanged(0, "success");
                IssueFragment.this.mIsRequestLoading = 0;
                IssueFragment.this.mShowNiePhoto.setIsSortable(true);
                cb1.c("uploader cover success", imageUrl);
                cb1.c("uploader all success", JSON.toJSONString(IssueFragment.this.videoBean));
                return;
            }
            IssueFragment.this.delVideo(true);
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418029074")) {
                ipChange.ipc$dispatch("1418029074", new Object[]{this});
                return;
            }
            cb1.c("uploader cover cancel", "cancel");
            IssueFragment.this.delVideo(true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class l extends q50 {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        @Override // tb.q50
        public void b(@NonNull uu2 uu2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1059613165")) {
                ipChange.ipc$dispatch("1059613165", new Object[]{this, uu2Var});
                return;
            }
            IssueFragment.this.stopProgressDialog();
            String imageUrl = IssueFragment.this.imageUrl(uu2Var.d());
            if (!TextUtils.isEmpty(imageUrl)) {
                IssueFragment.this.updateVideoBean(imageUrl);
                if (IssueFragment.this.mShowNiePhoto.getData().size() > 0) {
                    IssueFragment.this.mShowNiePhoto.getData().get(0).setThumbnail(IssueFragment.this.coverPath);
                }
                IssueFragment.this.mShowNiePhoto.notifyItemChanged(0);
                IssueFragment.this.mIsRequestLoading = 0;
                IssueFragment.this.mShowNiePhoto.setIsSortable(true);
                cb1.c("uploader cover update success", imageUrl);
                return;
            }
            IssueFragment.this.updateCoverFail();
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1369386413")) {
                ipChange.ipc$dispatch("-1369386413", new Object[]{this});
                return;
            }
            cb1.c("uploader cover cancel", "cancel");
            IssueFragment.this.updateCoverFail();
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onFailure(@NonNull UploadErrorCode uploadErrorCode, @NonNull List<uu2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1875377645")) {
                ipChange.ipc$dispatch("-1875377645", new Object[]{this, uploadErrorCode, list});
                return;
            }
            cb1.c("uploader cover fail", "fail");
            IssueFragment.this.updateCoverFail();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class m implements DMLinearLayoutIssue.IssueSoftControl {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // cn.damai.issue.view.DMLinearLayoutIssue.IssueSoftControl
        public void dispatchDown(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-852266697")) {
                ipChange.ipc$dispatch("-852266697", new Object[]{this, motionEvent});
                return;
            }
            IssueFragment issueFragment = IssueFragment.this;
            if (!issueFragment.softShowing || issueFragment.inputTipsView.touchInSelf((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                return;
            }
            SoftInputUtils.a(IssueFragment.this.getActivity());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class n implements OnTipsSelectedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // cn.damai.comment.view.OnTipsSelectedListener
        public void onTipsSelected(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "611984503")) {
                ipChange.ipc$dispatch("611984503", new Object[]{this, str});
                return;
            }
            int selectionEnd = IssueFragment.this.mEditor.getSelectionEnd();
            if (selectionEnd == 0) {
                Editable text = IssueFragment.this.mEditor.getText();
                text.insert(selectionEnd, str + StringUtils.LF);
                return;
            }
            Editable text2 = IssueFragment.this.mEditor.getText();
            text2.insert(selectionEnd, StringUtils.LF + str + StringUtils.LF);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class o implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        o() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 3)
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1285816821")) {
                ipChange.ipc$dispatch("1285816821", new Object[]{this});
                return;
            }
            Rect rect = new Rect();
            IssueFragment.this.issue_window_layout.getWindowVisibleDisplayFrame(rect);
            cb1.b("IssueActivity", "r.bottom = " + rect.bottom + "  visibleWindowDisplayHeight = " + IssueFragment.this.visibleWindowDisplayHeight);
            int i = IssueFragment.this.tempBottom;
            int i2 = rect.bottom;
            if (i != i2) {
                IssueFragment.this.tempBottom = i2;
                if (IssueFragment.this.visibleWindowDisplayHeight > rect.bottom && IssueFragment.this.isGreaterMVersion()) {
                    cb1.b("IssueActivity", "输入框show");
                    IssueFragment issueFragment = IssueFragment.this;
                    issueFragment.softShowing = true;
                    issueFragment.params.height = IssueFragment.this.visibleWindowDisplayHeight - rect.bottom;
                    if (IssueFragment.this.inputTipsView.getNeedShowWhenKeyboardOpen()) {
                        IssueFragment.this.submitLayout.setVisibility(8);
                        IssueFragment.this.inputTipsView.setVisibility(0);
                    }
                } else {
                    cb1.b("IssueActivity", "输入框hide");
                    IssueFragment.this.visibleWindowDisplayHeight = rect.bottom;
                    IssueFragment.this.params.height = 0;
                    IssueFragment issueFragment2 = IssueFragment.this;
                    issueFragment2.softShowing = false;
                    if (issueFragment2.inputTipsView.getNeedShowWhenKeyboardOpen()) {
                        IssueFragment.this.inputTipsView.setVisibility(8);
                        IssueFragment.this.submitLayout.setVisibility(0);
                    }
                }
                IssueFragment.this.issue_window_layout.requestLayout();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class p implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        p() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1658631388")) {
                ipChange.ipc$dispatch("-1658631388", new Object[]{this, editable});
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "913819551")) {
                ipChange.ipc$dispatch("913819551", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1157374911")) {
                ipChange.ipc$dispatch("1157374911", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            } else {
                IssueFragment.this.onEditorContentChanged(charSequence);
            }
        }
    }

    private void addVideo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946566393")) {
            ipChange.ipc$dispatch("-946566393", new Object[]{this, str, str2});
            return;
        }
        Image image = new Image();
        image.setPath(str);
        image.setType("2");
        image.setThumbnail(str2);
        this.mShowNiePhoto.addFirstItem(image);
    }

    private void associatedProjectView(String str, String str2, String str3, String str4, String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044178019")) {
            ipChange.ipc$dispatch("-2044178019", new Object[]{this, str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.associatedTipHint;
        if (textView != null && textView.getVisibility() == 0) {
            this.associatedTipHint.setVisibility(8);
        }
        if (this.associatedProjectImage.getVisibility() == 8) {
            this.associatedProjectImage.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str4) && !this.issueViewModel.isEvaluate()) {
            cn.damai.common.image.a.b().e(str4).k(new DMRoundedCornersBitmapProcessor(t60.a(getActivity(), 6.0f), 0)).d(getResources().getDrawable(R$drawable.uikit_default_image_bg_grey)).g(this.associatedProjectImage);
        } else {
            this.associatedProjectImage.setImageResource(R$drawable.uikit_default_image_bg_grey);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (this.associatedProjectName.getVisibility() == 8) {
                this.associatedProjectName.setVisibility(0);
            }
            this.associatedProjectName.setText(str3);
        } else {
            this.associatedProjectName.setText("");
        }
        if (!TextUtils.isEmpty(str5)) {
            if (this.associatedProjectTimeAddress.getVisibility() == 8) {
                this.associatedProjectTimeAddress.setVisibility(0);
            }
            this.associatedProjectTimeAddress.setText(str5);
        } else {
            this.associatedProjectTimeAddress.setText("");
        }
        if (TextUtils.isEmpty(str) || z) {
            return;
        }
        updateThemeByPojId(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindInputTips(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381478473")) {
            ipChange.ipc$dispatch("1381478473", new Object[]{this, list});
            return;
        }
        this.inputTipsView.bindData(list);
        this.inputTipsView.setVisibility(this.softShowing ? 0 : 8);
    }

    private int checkUploadParamsValid() {
        DMCommentSubItemView dMCommentSubItemView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052149683")) {
            return ((Integer) ipChange.ipc$dispatch("1052149683", new Object[]{this})).intValue();
        }
        if (this.mIsUploadImageFailure) {
            return 1;
        }
        if (this.issueViewModel.getStoreId() != null && "1".equals(this.issueViewModel.getItemType())) {
            if (this.issueViewModel.isEvaluate() && this.correlationView.getCorrelationId() == null && this.correlationView.isClickable()) {
                return 2;
            }
            if (this.correlationView.getCorrelationId() != null) {
                for (int i2 = 0; i2 < this.mSumItemBar.getChildCount(); i2++) {
                    if ((this.mSumItemBar.getChildAt(i2) instanceof DMCommentSubItemView) && (dMCommentSubItemView = (DMCommentSubItemView) this.mSumItemBar.getChildAt(i2)) != null) {
                        if ((dMCommentSubItemView.getGrades() == 0) & (dMCommentSubItemView.getTagBean() != null)) {
                            return 3;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int delImagePosCorrect(int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1810476753") ? ((Integer) ipChange.ipc$dispatch("-1810476753", new Object[]{this, Integer.valueOf(i2)})).intValue() : (this.mShowNiePhoto.getData() == null || this.mShowNiePhoto.getData().size() <= 0 || this.mShowNiePhoto.getData().get(0) == null || !"2".equals(this.mShowNiePhoto.getData().get(0).getType())) ? i2 : i2 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delVideo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495628183")) {
            ipChange.ipc$dispatch("1495628183", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.videoBean = null;
        if (this.mShowNiePhoto.getItemCount() > 0) {
            this.mShowNiePhoto.removeItem(0);
        }
        this.mShowNiePhoto.setIsSortable(true);
        setmEvaGiftContent();
        updateIssueButtonStatus();
        this.mIsRequestLoading = 0;
        if (!z || getActivity() == null || getActivity().isFinishing() || !isAdded()) {
            return;
        }
        ToastUtil.a().e(getActivity(), getResources().getString(R$string.issue_add_video_upload_fail));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchDraftCheckIfNeed() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "338571993")) {
            ipChange.ipc$dispatch("338571993", new Object[]{this});
            return;
        }
        IssueViewModel issueViewModel = this.issueViewModel;
        if (issueViewModel == null || this.mDraftBox == null) {
            return;
        }
        if ((issueViewModel.isEdit() || this.issueViewModel.isPrivilege() || this.issueViewModel.isEvaluate()) ? true : true) {
            this.mDraftBox.checkCacheDraft(new a());
        }
    }

    private void editClearFocus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214465096")) {
            ipChange.ipc$dispatch("-1214465096", new Object[]{this});
            return;
        }
        this.issue_window_layout.setFocusable(true);
        this.issue_window_layout.setFocusableInTouchMode(true);
        this.mEditor.clearFocus();
    }

    private void evaluteSuceessRender(final IssueResponse issueResponse, String str, boolean z, final DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806966926")) {
            ipChange.ipc$dispatch("806966926", new Object[]{this, issueResponse, str, Boolean.valueOf(z), dMShareMessage});
            return;
        }
        EvaluateSuccessRenderRequest evaluateSuccessRenderRequest = new EvaluateSuccessRenderRequest();
        evaluateSuccessRenderRequest.canEnterActivity = z;
        evaluateSuccessRenderRequest.commentId = str;
        if (!wh2.j(this.issueViewModel.getmIpId())) {
            evaluateSuccessRenderRequest.ipId = this.issueViewModel.getmIpId();
        }
        if (!wh2.j(this.issueViewModel.getmItemId())) {
            evaluateSuccessRenderRequest.itemId = this.issueViewModel.getmItemId();
        }
        evaluateSuccessRenderRequest.request(new DMMtopRequestListener<EvaluteSuccessRenderResponse>(EvaluteSuccessRenderResponse.class) { // from class: cn.damai.issue.IssueFragment.21
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1908547905")) {
                    ipChange2.ipc$dispatch("-1908547905", new Object[]{this, str2, str3});
                    return;
                }
                if (dMShareMessage != null && IssueFragment.this.getContext() != null && (IssueFragment.this.getContext() instanceof IssueActivity)) {
                    dMShareMessage.requestCode = 104;
                    if (IssueFragment.this.issueViewModel.getScriptId() == null && IssueFragment.this.issueViewModel.getStoreId() == null) {
                        GenerateImageUtil.p((IssueActivity) IssueFragment.this.getContext(), dMShareMessage);
                    } else {
                        IssueFragment issueFragment = IssueFragment.this;
                        issueFragment.startActivity(EvaluateSuccessActivity.createIntent(issueFragment.getContext(), IssueFragment.this.issueViewModel.getItemType(), IssueFragment.this.issueViewModel.getStoreId(), issueResponse, null, dMShareMessage));
                    }
                }
                IssueFragment.this.notifyPublishSuccess();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(EvaluteSuccessRenderResponse evaluteSuccessRenderResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-143364208")) {
                    ipChange2.ipc$dispatch("-143364208", new Object[]{this, evaluteSuccessRenderResponse});
                    return;
                }
                if (evaluteSuccessRenderResponse != null) {
                    EvaluteSuccessRenderResponse.CommentSuccessInfo commentSuccessInfo = evaluteSuccessRenderResponse.commentInfo;
                    if (commentSuccessInfo != null) {
                        dMShareMessage.shareFooter = commentSuccessInfo.getUserCommentTotal();
                    }
                    if (evaluteSuccessRenderResponse.activityInfo != null) {
                        DMShareMessage.AdsBanner adsBanner = new DMShareMessage.AdsBanner();
                        EvaluteSuccessRenderResponse.EvaSuccessActivityInfo evaSuccessActivityInfo = evaluteSuccessRenderResponse.activityInfo;
                        adsBanner.title = evaSuccessActivityInfo.activityName;
                        adsBanner.subTitle = evaSuccessActivityInfo.activityDes;
                        dMShareMessage.adsBanner = adsBanner;
                    }
                    EvaluteSuccessRenderResponse.CommentProjectDO commentProjectDO = evaluteSuccessRenderResponse.projectDO;
                    if (commentProjectDO != null) {
                        DMShareMessage dMShareMessage2 = dMShareMessage;
                        dMShareMessage2.projectCity = commentProjectDO.cityName;
                        dMShareMessage2.projectTime = commentProjectDO.showTime;
                        dMShareMessage2.remarkValue = commentProjectDO.itemScore;
                        if (!TextUtils.isEmpty(commentProjectDO.projectId)) {
                            dMShareMessage.projectId = evaluteSuccessRenderResponse.projectDO.projectId;
                        }
                        if (!TextUtils.isEmpty(evaluteSuccessRenderResponse.projectDO.projectName)) {
                            dMShareMessage.shareTitle = evaluteSuccessRenderResponse.projectDO.projectName;
                        }
                        if (!TextUtils.isEmpty(evaluteSuccessRenderResponse.projectDO.projectPoster)) {
                            dMShareMessage.sharePictureUrl = evaluteSuccessRenderResponse.projectDO.projectPoster;
                        }
                    }
                    DMShareMessage.YYMemberIntegrate yYMemberIntegrate = evaluteSuccessRenderResponse.vipScore;
                    if (yYMemberIntegrate != null) {
                        dMShareMessage.vipScore = yYMemberIntegrate;
                    }
                }
                if (dMShareMessage != null && IssueFragment.this.getContext() != null && (IssueFragment.this.getContext() instanceof IssueActivity)) {
                    dMShareMessage.requestCode = 104;
                    if (IssueFragment.this.issueViewModel.getScriptId() == null && IssueFragment.this.issueViewModel.getStoreId() == null) {
                        GenerateImageUtil.p((IssueActivity) IssueFragment.this.getContext(), dMShareMessage);
                    } else {
                        IssueFragment issueFragment = IssueFragment.this;
                        issueFragment.startActivity(EvaluateSuccessActivity.createIntent(issueFragment.getContext(), IssueFragment.this.issueViewModel.getItemType(), IssueFragment.this.issueViewModel.getStoreId(), issueResponse, evaluteSuccessRenderResponse, dMShareMessage));
                    }
                }
                IssueFragment.this.notifyPublishSuccess();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742891878")) {
            ipChange.ipc$dispatch("-742891878", new Object[]{this});
            return;
        }
        getActivity().finish();
        if (this.issueViewModel.isFromHome()) {
            if (Build.VERSION.SDK_INT >= 5) {
                getActivity().overridePendingTransition(R$anim.anim_no, R$anim.anim_bottom_out);
            }
        } else if (Build.VERSION.SDK_INT >= 5) {
            getActivity().overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishByUser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603955016")) {
            ipChange.ipc$dispatch("-1603955016", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("text", this.issueViewModel.getmEditorContent());
        if (this.issueViewModel.isFromHome() && getActivity() != null && !getActivity().isFinishing()) {
            intent.putExtra("tip", getString(R$string.damai_homepage_comment_await_comment_tips));
        }
        getActivity().setResult(-1, intent);
        SoftInputUtils.a(getActivity());
        finish();
    }

    private ArrayList<String> getImageListParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762108414")) {
            return (ArrayList) ipChange.ipc$dispatch("1762108414", new Object[]{this});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.issueViewModel.isEdit()) {
            for (int i2 = 0; i2 < wh2.e(this.issueViewModel.getmImages()); i2++) {
                if (this.issueViewModel.getmImages().get(i2).startsWith("http")) {
                    arrayList.add(this.issueViewModel.getmImages().get(i2));
                }
            }
        }
        Iterator<String> it = this.mPaths.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int i3 = 0;
            while (true) {
                if (i3 < wh2.e(this.mImagesSelectData)) {
                    uu2 uu2Var = this.mImagesSelectData.get(i3);
                    if (uu2Var.d() != null && !TextUtils.isEmpty(next) && !TextUtils.isEmpty(uu2Var.b()) && next.equals(uu2Var.b())) {
                        arrayList.add(imageUrl(uu2Var.d()));
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNetworkType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697634683")) {
            return (String) ipChange.ipc$dispatch("-697634683", new Object[]{this});
        }
        NetworkType b2 = wj1.b(mu0.a().getApplicationContext());
        return b2 == NetworkType.NETWORK_WIFI ? "WiFi" : b2 == NetworkType.NETWORK_2G ? "2G" : b2 == NetworkType.NETWORK_3G ? "3G" : b2 == NetworkType.NETWORK_4G ? "4G" : "none";
    }

    private void getRenderTags() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121678584")) {
            ipChange.ipc$dispatch("121678584", new Object[]{this});
            return;
        }
        startProgressDialog();
        if (this.issueRenderResponseObserver == null) {
            this.issueRenderResponseObserver = new Observer<IssueRenderLiveDataResponse>() { // from class: cn.damai.issue.IssueFragment.2
                private static transient /* synthetic */ IpChange $ipChange;

                /* compiled from: Taobao */
                /* renamed from: cn.damai.issue.IssueFragment$2$a */
                /* loaded from: classes5.dex */
                public class a implements DMImageCreator.DMImageFailListener {
                    private static transient /* synthetic */ IpChange $ipChange;

                    a() {
                    }

                    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                    public void onFail(DMImageCreator.d dVar) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-110245045")) {
                            ipChange.ipc$dispatch("-110245045", new Object[]{this, dVar});
                        } else {
                            IssueFragment.this.giftIntroduce.setVisibility(8);
                        }
                    }
                }

                /* compiled from: Taobao */
                /* renamed from: cn.damai.issue.IssueFragment$2$b */
                /* loaded from: classes5.dex */
                public class b implements DMImageCreator.DMImageSuccListener {
                    private static transient /* synthetic */ IpChange $ipChange;

                    b() {
                    }

                    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                    public void onSuccess(DMImageCreator.e eVar) {
                        Bitmap bitmap;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1807689568")) {
                            ipChange.ipc$dispatch("-1807689568", new Object[]{this, eVar});
                        } else if (eVar == null || (bitmap = eVar.b) == null) {
                            IssueFragment.this.giftIntroduce.setVisibility(8);
                        } else {
                            IssueFragment.this.giftIntroduce.setVisibility(0);
                            IssueFragment.this.giftIntroduce.setImageBitmap(bitmap);
                        }
                    }
                }

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable IssueRenderLiveDataResponse issueRenderLiveDataResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1497894118")) {
                        ipChange2.ipc$dispatch("1497894118", new Object[]{this, issueRenderLiveDataResponse});
                    } else if (issueRenderLiveDataResponse == null || issueRenderLiveDataResponse.data == null || !IssueFragment.this.isActivityOk()) {
                        if (issueRenderLiveDataResponse != null) {
                            IssueFragment issueFragment = IssueFragment.this;
                            issueFragment.onResponseError(issueRenderLiveDataResponse.errorCode, issueRenderLiveDataResponse.errorMsg, "mtop.damai.wireless.comment.render", issueFragment.issue_window_layout, true);
                        }
                    } else {
                        IssueFragment.this.stopProgressDialog();
                        IssueFragment issueFragment2 = IssueFragment.this;
                        issueFragment2.onResponseSuccess(issueFragment2.issue_window_layout);
                        IssueFragment.this.dispatchDraftCheckIfNeed();
                        IssueRenderResponse issueRenderResponse = issueRenderLiveDataResponse.data;
                        IssueFragment.this.renderSubItemEvaluate(issueRenderResponse.getGradeTags());
                        IssueFragment.this.issueViewModel.setCommentGradeTexts(issueRenderResponse.getCommentGradeTexts());
                        IssueFragment.this.gradeTip();
                        IssueFragment.this.bindInputTips(issueRenderResponse.getIconTitle());
                        IssueFragment.this.associatedProjectTimeAddress.setVisibility(0);
                        IssueFragment.this.associatedProjectName.setVisibility(0);
                        IssueFragment.this.setRatingPartStaticData(issueRenderResponse.getItemType());
                        if (issueRenderResponse.getStoreInfo() != null && "1".equals(issueRenderResponse.getItemType())) {
                            IssueFragment.this.dmSelectView.bindData(issueRenderResponse.getDmInfoList(), null);
                            IssueFragment.this.associatedProjectTimeAddress.setText(issueRenderResponse.getStoreInfo().getDes());
                            IssueFragment.this.associatedProjectName.setText(issueRenderResponse.getStoreInfo().getStoreName());
                            IssueFragment.this.associatedProjectImage.getLayoutParams().width = t60.a(IssueFragment.this.getContext(), 42.0f);
                            cn.damai.common.image.a.b().e(issueRenderResponse.getStoreInfo().getStoreImgUrl()).k(new DMRoundedCornersBitmapProcessor(t60.a(IssueFragment.this.getActivity(), 6.0f), 0)).d(IssueFragment.this.getResources().getDrawable(R$drawable.store_defult_img)).g(IssueFragment.this.associatedProjectImage);
                            IssueFragment.this.correlationView.setDefaultData(issueRenderResponse.associatedScriptNum, CorrelationType.SCRIPT, issueRenderResponse.getStoreInfo().getStoreId());
                            IssueFragment.this.issueViewModel.setStoreId(issueRenderResponse.getStoreInfo().getStoreId() + "");
                            IssueFragment.this.issueViewModel.setItemType(issueRenderResponse.getItemType());
                        } else if (issueRenderResponse.scriptInfo != null && "2".equals(issueRenderResponse.getItemType())) {
                            IssueFragment.this.associatedProjectTimeAddress.setText(issueRenderResponse.scriptInfo.getDes());
                            IssueFragment.this.associatedProjectName.setText(issueRenderResponse.scriptInfo.getName());
                            cn.damai.common.image.a.b().e(issueRenderResponse.scriptInfo.getPosterUrl()).k(new DMRoundedCornersBitmapProcessor(t60.a(IssueFragment.this.getActivity(), 6.0f), 0)).d(IssueFragment.this.getResources().getDrawable(R$drawable.uikit_default_image_bg_grey)).g(IssueFragment.this.associatedProjectImage);
                            IssueFragment.this.correlationView.setDefaultData(issueRenderResponse.associatedStoreNum, CorrelationType.STORE, issueRenderResponse.scriptInfo.getId());
                            IssueFragment.this.spoilerSwitchView.setVisibility(0);
                            IssueFragment.this.issueViewModel.setItemType(issueRenderResponse.getItemType());
                        } else {
                            ProjectDO projectDO = issueRenderLiveDataResponse.data.projectDO;
                            if (projectDO != null) {
                                String timeDes = TextUtils.isEmpty(IssueFragment.this.issueViewModel.getTimeDes()) ? "时间待定" : IssueFragment.this.issueViewModel.getTimeDes();
                                String venueName = TextUtils.isEmpty(projectDO.getVenueName()) ? "场馆待定" : projectDO.getVenueName();
                                String str = timeDes + " | " + venueName;
                                if (!TextUtils.isEmpty(projectDO.getVenueCity())) {
                                    str = projectDO.getVenueCity() + " | " + timeDes + " | " + venueName;
                                }
                                if (!TextUtils.isEmpty(IssueFragment.this.issueViewModel.getTimeAddress())) {
                                    str = IssueFragment.this.issueViewModel.getTimeAddress();
                                }
                                IssueFragment.this.issueViewModel.setmProjectName(projectDO.getName());
                                IssueFragment.this.issueViewModel.setmProjectPoster(projectDO.getVerticalPic());
                                IssueFragment.this.issueViewModel.setTimeAddress(str);
                                cn.damai.common.image.a.b().e(IssueFragment.this.issueViewModel.getmProjectPoster()).k(new DMRoundedCornersBitmapProcessor(t60.a(IssueFragment.this.getActivity(), 6.0f), 0)).d(IssueFragment.this.getResources().getDrawable(R$drawable.uikit_default_image_bg_grey)).g(IssueFragment.this.associatedProjectImage);
                                IssueFragment.this.associatedProjectTimeAddress.setText(IssueFragment.this.issueViewModel.getTimeAddress());
                                IssueFragment.this.associatedProjectName.setText(IssueFragment.this.issueViewModel.getmProjectName());
                            }
                            IssueFragment.this.inputTipsView.setVisibility(8);
                            IssueFragment.this.dmSelectView.setVisibility(8);
                        }
                        if (issueRenderResponse.getNoticeInfo() != null) {
                            IssueFragment.this.issueViewModel.setNoticeInfos(issueRenderResponse.getNoticeInfo().getActivityIntroduce());
                            IssueFragment.this.setmEvaGiftContent();
                            if (TextUtils.isEmpty(issueRenderResponse.getNoticeInfo().getActivityPic())) {
                                IssueFragment.this.giftIntroduce.setVisibility(8);
                            } else {
                                cn.damai.common.image.a.b().e(issueRenderResponse.getNoticeInfo().getActivityPic()).k(new DMRoundedCornersBitmapProcessor(12, 0)).n(new b()).e(new a()).f();
                            }
                        }
                    }
                }
            };
        }
        this.issueViewModel.getRenderTags().observe(this, this.issueRenderResponseObserver);
    }

    private ArrayList<String> getResponseImageList(List<CommentImageInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891384566")) {
            return (ArrayList) ipChange.ipc$dispatch("891384566", new Object[]{this, list});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (CommentImageInfoBean commentImageInfoBean : list) {
                arrayList.add(commentImageInfoBean.url);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Image getSelectVideo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396931206")) {
            return (Image) ipChange.ipc$dispatch("-396931206", new Object[]{this});
        }
        DMSortableNinePhotoLayout dMSortableNinePhotoLayout = this.mShowNiePhoto;
        if (dMSortableNinePhotoLayout == null || dMSortableNinePhotoLayout.getData() == null || this.mShowNiePhoto.getData().size() <= 0 || this.mShowNiePhoto.getData().get(0) == null || !"2".equals(this.mShowNiePhoto.getData().get(0).getType())) {
            return null;
        }
        return this.mShowNiePhoto.getData().get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gradeTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1622193737")) {
            ipChange.ipc$dispatch("1622193737", new Object[]{this});
            return;
        }
        String e2 = pf0.g().e(this.issueViewModel.getmGrades(), this.issueViewModel.getCommentGradeTexts(), "");
        if (!TextUtils.isEmpty(e2)) {
            pf0.g().o(this.gradeTip);
            this.gradeTip.setText(e2);
            return;
        }
        pf0.g().m(this.gradeTip);
    }

    private String gradesCombine() {
        DMCommentSubItemView dMCommentSubItemView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172376838")) {
            return (String) ipChange.ipc$dispatch("1172376838", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        sb.append(String.format("\"%1$s%2$s%3$s\"", "1", ":", Integer.valueOf(this.issueViewModel.getmGrades())));
        LinearLayout linearLayout = this.mSumItemBar;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.mSumItemBar.getChildCount(); i2++) {
                if ((this.mSumItemBar.getChildAt(i2) instanceof DMCommentSubItemView) && (dMCommentSubItemView = (DMCommentSubItemView) this.mSumItemBar.getChildAt(i2)) != null && dMCommentSubItemView.getTagBean() != null) {
                    sb.append(",");
                    if (!TextUtils.isEmpty(dMCommentSubItemView.getTagBean().getDesc())) {
                        sb.append(String.format("\"%1$s%2$s%3$s%4$s%5$s\"", Long.valueOf(dMCommentSubItemView.getTagBean().getType()), ":", Integer.valueOf(dMCommentSubItemView.getGrades()), ":", dMCommentSubItemView.getTagBean().getDesc()));
                    } else {
                        sb.append(String.format("\"%1$s%2$s%3$s\"", Long.valueOf(dMCommentSubItemView.getTagBean().getType()), ":", Integer.valueOf(dMCommentSubItemView.getGrades())));
                    }
                }
            }
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gradesDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868688010")) {
            ipChange.ipc$dispatch("1868688010", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mRatingBarDesc.setText(str);
            this.mRatingBarDesc.setVisibility(0);
        } else {
            this.mRatingBarDesc.setVisibility(8);
        }
    }

    private void guideAnimShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897266643")) {
            ipChange.ipc$dispatch("897266643", new Object[]{this});
        } else if (!this.issueViewModel.isEvaluate() || this.issueViewModel.isFromHome() || g41.b.equals(z20.B(g41.a))) {
        } else {
            pf0.h(this.guideAnimLayout, this.guideLottie);
        }
    }

    private void handleEditContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180256586")) {
            ipChange.ipc$dispatch("-1180256586", new Object[]{this});
            return;
        }
        this.mDMRatingBar.setStarMark(this.issueViewModel.getmGrades() / 2.0f);
        this.mEditor.setText(this.issueViewModel.getmEditorContent());
        this.mEditor.setSelection(this.issueViewModel.getmEditorContent().length());
        CommentsVideoBean commentsVideoBean = this.videoBean;
        if (commentsVideoBean != null && !TextUtils.isEmpty(commentsVideoBean.getCoverUrl())) {
            addVideo(this.videoBean.getUrl(), this.videoBean.getCoverUrl());
        }
        this.mShowNiePhoto.setData(pf0.d(this.issueViewModel.getmImages(), getSelectVideo(), "1"));
    }

    private void imageAus(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-634606303")) {
            ipChange.ipc$dispatch("-634606303", new Object[]{this, arrayList});
            return;
        }
        this.mPaths.clear();
        this.mImagesSelectData.clear();
        this.mImagesPublishCount = 0;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.mPaths.add(pf0.f(arrayList.get(i2)));
            }
        }
        if (this.mIsRequestLoading == 0) {
            FileUploader q = FileUploader.q("damai_comment_oss");
            this.mSubmitUploader = q;
            q.C(this.mSubmitFilesListener).y().G(this.mPaths);
            startProgressDialog();
        }
        this.mIsUploadImageFailure = false;
        this.mIsRequestLoading = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String imageUrl(ITaskResult iTaskResult) {
        AusResult ausResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329952325")) {
            return (String) ipChange.ipc$dispatch("-1329952325", new Object[]{this, iTaskResult});
        }
        if (iTaskResult == null || TextUtils.isEmpty(iTaskResult.getBizResult()) || (ausResult = (AusResult) ko.e().parseJson(iTaskResult.getBizResult(), (Class<Object>) AusResult.class)) == null || TextUtils.isEmpty(ausResult.ossBucketName) || TextUtils.isEmpty(ausResult.ossEndpoint) || TextUtils.isEmpty(ausResult.ossObjectKey)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://" + ausResult.ossBucketName);
        stringBuffer.append(".");
        stringBuffer.append(ausResult.ossEndpoint.substring(8));
        stringBuffer.append("/");
        stringBuffer.append(ausResult.ossObjectKey);
        return stringBuffer.toString();
    }

    private void initContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741291633")) {
            ipChange.ipc$dispatch("-1741291633", new Object[]{this});
            return;
        }
        this.issue_window_layout = (DMLinearLayoutIssue) findViewById(R$id.issue_window_layout);
        this.mIssueTitleCancel = (DMIconFontTextView) findViewById(R$id.issue_title_cancel);
        this.mTeachGoodEvaluate = (TextView) findViewById(R$id.issue_title_teach_good_evaluate);
        this.submitLayout = (LinearLayout) findViewById(R$id.issue_submit_bottom_layout);
        this.mIssueTitlecontent = (TextView) findViewById(R$id.issue_title_content);
        this.mIssueTitleConfirm = (TextView) findViewById(R$id.issue_title_confirm);
        this.scrollView = (MyScrollView) findViewById(R$id.issue_scrollview);
        this.holder_view = findViewById(R$id.holder_view);
        this.mEvaluateLayout = (RelativeLayout) findViewById(R$id.issue_evaluate_layout);
        this.mIssueEvaluateTip = (TextView) findViewById(R$id.issue_evaluate_tip);
        this.mDMRatingBar = (cn.damai.uikit.view.DMRatingBar) findViewById(R$id.issue_evaluate_grade_view);
        this.mRatingBarDesc = (TextView) findViewById(R$id.issue_comment_grade_desc);
        this.mSumItemBar = (LinearLayout) findViewById(R$id.issue_subitem_evaluate_layout);
        this.gradeTip = (TextView) findViewById(R$id.issue_grade_tip);
        this.mEditor = (EditText) findViewById(R$id.issue_editor);
        this.mEditorLimitTip = (TextView) findViewById(R$id.issue_editor_limit);
        this.mEvaGift = (TextView) findViewById(R$id.issue_evaluate_gift);
        this.mShowNiePhoto = (DMSortableNinePhotoLayout) findViewById(R$id.issue_show_photo);
        this.giftIntroduce = (ImageView) findViewById(R$id.comment_gift_introduce);
        this.associatedProjectTip = (TextView) findViewById(R$id.issue_associated_project_tip);
        this.associatedLayout = (RelativeLayout) findViewById(R$id.issue_evaluate_associated_project);
        int i2 = R$id.issue_associated_tip_hint;
        this.associatedTipHint = (TextView) findViewById(i2);
        this.associatedTipHint = (TextView) findViewById(i2);
        this.associatedProjectImage = (RoundRadiusImageView) findViewById(R$id.issue_associated_project_image);
        this.associatedProjectName = (TextView) findViewById(R$id.issue_associated_project_name);
        this.associatedProjectTimeAddress = (TextView) findViewById(R$id.issue_associated_project_time_address);
        this.associatedProjectArrow = (DMIconFontTextView) findViewById(R$id.issue_associated_icon_arrow);
        this.associatedHolder = findViewById(R$id.issue_evaluate_associated_holder);
        this.llThemeLayout = (ConstraintLayout) findViewById(R$id.ll_theme_tip_layout);
        this.tvThemeContent = (TextView) findViewById(R$id.tv_theme_tip_content);
        this.clCircleLayout = (ConstraintLayout) findViewById(R$id.ll_circle_tip_layout);
        this.tvCircleContent = (TextView) findViewById(R$id.tv_circle_tip_content);
        this.ivCircleScreen = (DMIconFontTextView) findViewById(R$id.iv_circle_screen);
        IssueCircleSelect issueCircleSelect = new IssueCircleSelect(getContext());
        this.issueCircleSelect = issueCircleSelect;
        issueCircleSelect.d(this.clCircleLayout);
        this.guideAnimLayout = (LinearLayout) findViewById(R$id.issue_first_entry_guide_anim);
        this.guideLottie = (LottieAnimationView) findViewById(R$id.issue_first_entry_guide_lottie);
        this.fullStarLottie = (LottieAnimationView) findViewById(R$id.issue_full_star_lottie);
        this.dmSelectView = (PublishDMSelectView) findViewById(R$id.issue_dm_select);
        this.inputTipsView = (PublishInputTipsView) findViewById(R$id.publish_input_tips_view);
        this.correlationView = (CorrelationView) findViewById(R$id.correlation_view);
        this.spoilerSwitchView = (SpoilerSwitchView) findViewById(R$id.spoiler_view);
        updateIssueButtonStatus(false);
    }

    private void initIssueViewModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413317202")) {
            ipChange.ipc$dispatch("1413317202", new Object[]{this});
            return;
        }
        IssueViewModel issueViewModel = (IssueViewModel) new ViewModelProvider(getActivity(), new ViewModelProvider.AndroidViewModelFactory(mu0.a())).get(IssueViewModel.class);
        this.issueViewModel = issueViewModel;
        boolean intentValue = issueViewModel.getIntentValue(getArguments(), getActivity().getIntent());
        if (on1.b()) {
            this.mDraftBox = new DraftBox(new DraftMd5NameAssembler(this.issueViewModel), this);
        } else {
            this.mDraftBox = new DraftEmptyBox();
        }
        if (intentValue) {
            return;
        }
        ToastUtil.i("请求数据出错.");
    }

    private void initSetting() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-233080131")) {
            ipChange.ipc$dispatch("-233080131", new Object[]{this});
            return;
        }
        this.mShowNiePhoto.init(getActivity());
        this.mShowNiePhoto.setIsSortable(true);
        if (this.issueViewModel.isEvaluate()) {
            str = getString(R$string.issue_comment_edit_hint);
            guideAnimShow();
            this.mDMRatingBar.setStarMark(this.issueViewModel.getmGrades() / 2.0f);
            this.associatedLayout.setVisibility(0);
            this.associatedHolder.setVisibility(0);
            this.associatedProjectArrow.setVisibility(8);
            associatedProjectView(this.issueViewModel.getmItemId(), "1", this.issueViewModel.getmProjectName(), this.issueViewModel.getmProjectPoster(), this.issueViewModel.getTimeAddress(), false);
        } else if (this.issueViewModel.isEdit()) {
            this.mIssueTitlecontent.setText(BottomActionDialog.EDIT);
            handleEditContent();
            str = "记录下你的现场感受吧";
        } else if (this.issueViewModel.isPrivilege()) {
            this.associatedProjectTip.setVisibility(0);
            this.associatedLayout.setVisibility(0);
            this.associatedLayout.setOnClickListener(this.mOnClickListener);
            this.associatedHolder.setVisibility(0);
            str = getString(R$string.issue_comment_edit_hint);
            privilegeView(false, null, false);
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            cn.damai.common.user.c.e().G(this.associatedLayout, b82.SEARCH_ITEM_ASSOCIATE, "top", i41.PAGE_EVALUATE_SUBMIT, hashMap);
        } else {
            str = "";
        }
        editClearFocus();
        if (!TextUtils.isEmpty(this.issueViewModel.getAppPublishHint())) {
            str = this.issueViewModel.getAppPublishHint();
        }
        if (this.issueViewModel.isComeFromTheme()) {
            updateTheme(this.issueViewModel.getThemeName());
        }
        if (this.issueViewModel.isComeFromCircle()) {
            updateCircle(this.issueViewModel.getCircle());
        }
        this.mEditor.setHint(str);
        this.mEditorLimitTip.setVisibility(0);
        showEditorLimitTip();
        updateIssueButtonStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGreaterMVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1060091194") ? ((Boolean) ipChange.ipc$dispatch("-1060091194", new Object[]{this})).booleanValue() : Build.VERSION.SDK_INT >= 23;
    }

    private boolean isNetAvailable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "156106843") ? ((Boolean) ipChange.ipc$dispatch("156106843", new Object[]{this})).booleanValue() : xj1.b(getActivity());
    }

    private void keyBoradChangeView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462702481")) {
            ipChange.ipc$dispatch("-1462702481", new Object[]{this});
            return;
        }
        this.params = (LinearLayout.LayoutParams) this.holder_view.getLayoutParams();
        Rect rect = new Rect();
        this.issue_window_layout.getWindowVisibleDisplayFrame(rect);
        this.visibleWindowDisplayHeight = rect.bottom;
        this.mEditor.getViewTreeObserver().addOnGlobalLayoutListener(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323256656")) {
            ipChange.ipc$dispatch("323256656", new Object[]{this});
        } else {
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.issue.IssueFragment.22
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2077422742")) {
                        ipChange2.ipc$dispatch("2077422742", new Object[]{this});
                        return;
                    }
                    xr.c("comment_publish_success", IssueFragment.this.issueViewModel.getmTargetId());
                    if (IssueFragment.this.issueViewModel.isFromHome()) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("needRefresh", true);
                    if (IssueFragment.this.getActivity() == null || IssueFragment.this.getActivity().isFinishing()) {
                        return;
                    }
                    IssueFragment.this.getActivity().setResult(-1, intent);
                    IssueFragment.this.finish();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589166684")) {
            ipChange.ipc$dispatch("1589166684", new Object[]{this});
            return;
        }
        if (this.issueViewModel.isEvaluate()) {
            i41.i().s(this.issueViewModel.getmIssueType(), this.issueViewModel.getmItemId());
        }
        if (!this.issueViewModel.isEvaluate() && !this.issueViewModel.isPrivilege() && !this.issueViewModel.isEdit()) {
            if (wh2.j(this.issueViewModel.getmEditorContent()) && wh2.e(this.mShowNiePhoto.getData()) <= 0) {
                SoftInputUtils.a(getActivity());
                finish();
                return;
            }
            String string = getResources().getString(R$string.edit_content_text);
            new h4(getActivity()).e(string).h(getResources().getString(R$string.edit_comment_tv), new i(this)).f(getResources().getString(R$string.edit_back_tv), new h()).c(false).j();
            return;
        }
        IDraftBox iDraftBox = this.mDraftBox;
        if (iDraftBox == null || !iDraftBox.checkBackPressed(new g())) {
            finishByUser();
        }
    }

    private void onBackFromShare(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816054869")) {
            ipChange.ipc$dispatch("-1816054869", new Object[]{this, intent});
            return;
        }
        cb1.b("wpf", "IssueFragment.onBackFromShare/in data:" + intent);
        if (intent == null) {
            intent = new Intent();
        }
        if (this.issueViewModel.isFromHome()) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                intent.putExtra("tip", getString(R$string.damai_homepage_commented_tips));
            }
            getActivity().setResult(-1, intent);
            finish();
        }
    }

    private void onCoverVideoResult(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325720438")) {
            ipChange.ipc$dispatch("-1325720438", new Object[]{this, intent});
        } else if (intent == null) {
        } else {
            new ArrayList();
            new ArrayList();
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(s11.SELECT_RESULT);
            intent.getParcelableArrayListExtra("imagelist");
            if (stringArrayListExtra.size() > 0) {
                String str = stringArrayListExtra.get(0);
                this.coverPath = str;
                Bitmap b2 = w11.b(str, -1, -1);
                if (b2 == null) {
                    try {
                        this.coverPath = Luban.l(this.mActivity).k(this.coverPath).h(this.coverPath).getAbsolutePath();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    b2 = cn.damai.common.util.a.i(this.coverPath);
                }
                if (isNetAvailable()) {
                    uploadVideoCover(b2, this.mCoverUpdateListener, true);
                } else {
                    ToastUtil.i(getResources().getString(R$string.damai_base_net_toast));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEditorContentChanged(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034442742")) {
            ipChange.ipc$dispatch("-2034442742", new Object[]{this, charSequence});
            return;
        }
        cb1.c(DraftBox.TAG, "onEditorContentChanged");
        try {
            this.issueViewModel.setmEditorContent(charSequence.toString().trim());
            if (this.mEditorLimit - this.issueViewModel.inputCount() <= 0) {
                IssueViewModel issueViewModel = this.issueViewModel;
                issueViewModel.setmEditorContent(issueViewModel.getmEditorContent().substring(0, this.mEditorLimit));
                this.mEditor.removeTextChangedListener(this.mOnTextChangedListener);
                this.mEditor.setText(this.issueViewModel.getmEditorContent());
                this.mEditor.setSelection(this.issueViewModel.getmEditorContent().length());
                this.mEditor.addTextChangedListener(this.mOnTextChangedListener);
            }
            showEditorLimitTip();
            setmEvaGiftContent();
            updateIssueButtonStatus();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onIssueClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "972948576")) {
            ipChange.ipc$dispatch("972948576", new Object[]{this});
            return;
        }
        SoftInputUtils.a(getActivity());
        if (this.issueViewModel.isEdit()) {
            if (wh2.e(this.mEditAddImages) > 0) {
                imageAus(this.mEditAddImages);
            } else {
                requestIssue();
            }
        } else if (wh2.e(this.issueViewModel.getmImages()) > 0) {
            imageAus(this.issueViewModel.getmImages());
        } else {
            requestIssue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onIssueCommentSuccess(IssueResponse issueResponse) {
        IssueResponse.UserDOBeanX userDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267151881")) {
            ipChange.ipc$dispatch("-1267151881", new Object[]{this, issueResponse});
            return;
        }
        IssueResponse.CommentsDOBean commentsDO = issueResponse.getCommentsDO();
        if (commentsDO == null || (userDO = issueResponse.getUserDO()) == null) {
            return;
        }
        DMShareMessage dMShareMessage = new DMShareMessage();
        dMShareMessage.projectId = this.issueViewModel.getmTargetId();
        dMShareMessage.sharePictureUrl = this.issueViewModel.getmProjectPoster();
        dMShareMessage.shareLink = commentsDO.getUrl();
        dMShareMessage.evaluateGrade = this.issueViewModel.getmGrades();
        dMShareMessage.evaluateGradeDesc = el.a(this.issueViewModel.getmGrades());
        if (issueResponse.getCommentsDO() != null && wh2.e(issueResponse.getCommentsDO().getGradeDOList()) > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= issueResponse.getCommentsDO().getGradeDOList().size()) {
                    break;
                }
                CommentGradeBean commentGradeBean = issueResponse.getCommentsDO().getGradeDOList().get(i2);
                if (commentGradeBean == null || commentGradeBean.type != 1) {
                    i2++;
                } else {
                    dMShareMessage.evaluateGradeDesc = commentGradeBean.valueDesc;
                    if (!TextUtils.isEmpty(commentGradeBean.value)) {
                        try {
                            dMShareMessage.evaluateGrade = Integer.valueOf(commentGradeBean.value).intValue();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        if (issueResponse.getCommentsDO() != null && this.issueViewModel.getItemType() != null) {
            dMShareMessage.dmInfo = issueResponse.getCommentsDO().getDmInfo();
            dMShareMessage.storeInfo = issueResponse.getCommentsDO().getStoreInfo();
            try {
                dMShareMessage.itemType = Integer.parseInt(this.issueViewModel.getItemType());
            } catch (NumberFormatException unused2) {
                dMShareMessage.itemType = 0;
            }
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            dMShareMessage.windowTitle = getActivity().getString(R$string.ticklet_share_title);
        } else {
            dMShareMessage.windowTitle = "分享评价";
        }
        dMShareMessage.shareTitle = this.issueViewModel.getmProjectName();
        dMShareMessage.shareContent = this.issueViewModel.getmEditorContent();
        dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE;
        dMShareMessage.commentType = this.issueViewModel.getmCommentType();
        dMShareMessage.userNick = userDO.getNickname();
        dMShareMessage.userHeaderIcon = userDO.getHeaderImage();
        dMShareMessage.vip = userDO.isVip();
        dMShareMessage.memberFlag = userDO.getPerformFilmVipDO() != null ? userDO.getPerformFilmVipDO().memberFlag : k23.h();
        dMShareMessage.vipLevelIcon = userDO.getVipLevelIcon();
        dMShareMessage.evaluateTime = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Long.valueOf(commentsDO.getGmtCreateTime()));
        dMShareMessage.extraMedia = CommentItemMoreUtil.l(issueResponse.getCommentsDO().getVideoDO(), getResponseImageList(issueResponse.getCommentsDO().getImageDOList()));
        evaluteSuceessRender(issueResponse, issueResponse.getCommentsDO().getCommentId(), issueResponse.isCanEnterActivity(), dMShareMessage);
    }

    private void onPreviewImageResult(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790350661")) {
            ipChange.ipc$dispatch("-790350661", new Object[]{this, intent});
        } else if (intent == null) {
        } else {
            this.issueViewModel.setmImages(intent.getStringArrayListExtra("selected"));
            this.issueViewModel.setmSelectImages(intent.getParcelableArrayListExtra("selectedList"));
            this.mShowNiePhoto.setData(pf0.d(this.issueViewModel.getmImages(), getSelectVideo(), "1"));
            setmEvaGiftContent();
            updateIssueButtonStatus();
        }
    }

    private void onPreviewVideoResult(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707126171")) {
            ipChange.ipc$dispatch("1707126171", new Object[]{this, intent});
        } else if (intent == null) {
        } else {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selected");
            if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                delVideo(false);
            }
        }
    }

    private void onSelectAlbumResult(Intent intent, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377029331")) {
            ipChange.ipc$dispatch("1377029331", new Object[]{this, intent, str});
        } else if (intent != null) {
            if ("2".equals(str)) {
                new ArrayList();
                new ArrayList();
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(s11.SELECT_RESULT);
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("imagelist");
                if (stringArrayListExtra.size() > 0 && !TextUtils.isEmpty(stringArrayListExtra.get(0)) && parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                    this.mShowNiePhoto.setIsSortable(false);
                    addVideo(stringArrayListExtra.get(0), null);
                    cb1.c("uploader fileUrl", "开始添加视频上传");
                    uploader(stringArrayListExtra.get(0), ((Image) parcelableArrayListExtra.get(0)).getDuration());
                }
            } else {
                if (this.issueViewModel.isEdit()) {
                    this.mEditAddImages = intent.getStringArrayListExtra(s11.SELECT_RESULT);
                    for (int i2 = 0; i2 < wh2.e(this.mEditAddImages); i2++) {
                        if (!this.issueViewModel.getmImages().contains(this.mEditAddImages.get(i2))) {
                            this.issueViewModel.getmImages().add(this.mEditAddImages.get(i2));
                        }
                    }
                    this.mEditAddSelectImages = intent.getParcelableArrayListExtra("imagelist");
                    for (int i3 = 0; i3 < wh2.e(this.mEditAddSelectImages); i3++) {
                        if (!this.issueViewModel.getmSelectImages().contains(this.mEditAddSelectImages.get(i3))) {
                            this.issueViewModel.getmSelectImages().add(this.mEditAddSelectImages.get(i3));
                        }
                    }
                } else {
                    this.issueViewModel.setmImages(intent.getStringArrayListExtra(s11.SELECT_RESULT));
                    this.issueViewModel.setmSelectImages(intent.getParcelableArrayListExtra("imagelist"));
                }
                this.mShowNiePhoto.setData(pf0.d(this.issueViewModel.getmImages(), getSelectVideo(), str));
            }
            setmEvaGiftContent();
            updateIssueButtonStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAlbum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285877896")) {
            ipChange.ipc$dispatch("-1285877896", new Object[]{this});
        } else {
            ir1.b(getActivity(), false, mr1.STORAGE, "用于选取图片文件进行发布", new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void privilegeView(boolean z, Intent intent, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193889994")) {
            ipChange.ipc$dispatch("193889994", new Object[]{this, Boolean.valueOf(z), intent, Boolean.valueOf(z2)});
        } else if (z && intent != null) {
            this.issueViewModel.setmTargetId(intent.getStringExtra(IssueConstants.ProjectID));
            String stringExtra = intent.getStringExtra("projectName");
            String stringExtra2 = intent.getStringExtra("projectImage");
            String stringExtra3 = intent.getStringExtra("timeAddress");
            this.privilegeType = intent.getStringExtra(IssueConstants.privilegeType);
            this.mTempDraftExtra = new DraftExtra(this.issueViewModel.getmTargetId(), stringExtra, stringExtra2, stringExtra3, this.privilegeType, this.issueViewModel.getThemeName());
            this.mEvaluateLayout.setVisibility(0);
            associatedProjectView(this.issueViewModel.getmTargetId(), this.privilegeType, stringExtra, stringExtra2, stringExtra3, z2);
            updateIssueButtonStatus();
        } else {
            this.associatedTipHint.setVisibility(0);
            this.associatedProjectImage.setVisibility(8);
            this.associatedProjectName.setVisibility(8);
            this.associatedProjectTimeAddress.setVisibility(8);
            this.mEvaluateLayout.setVisibility(8);
            this.mTempDraftExtra = null;
        }
    }

    private void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047966154")) {
            ipChange.ipc$dispatch("-1047966154", new Object[]{this});
            return;
        }
        this.mIssueTitleCancel.setOnClickListener(this.mOnClickListener);
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        String str = this.issueViewModel.isEvaluate() ? this.issueViewModel.getmItemId() : "";
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("item_id", str);
        }
        cn.damai.common.user.c.e().G(this.mIssueTitleCancel, "cancel_comment", "top", i41.PAGE_EVALUATE_SUBMIT, hashMap);
        this.mTeachGoodEvaluate.setOnClickListener(this.mOnClickListener);
        this.mIssueTitleConfirm.setOnClickListener(this.mOnClickListener);
        this.mEditor.addTextChangedListener(this.mOnTextChangedListener);
        this.mShowNiePhoto.setOnNinePhotoClickListener(this.mShowPhotoListener);
        this.mShowNiePhoto.setOnSortListener(this.mOnSortListener);
        this.mDMRatingBar.setOnStarChangeListener(this.mOnStarChangeListener);
        this.tvCircleContent.setOnClickListener(this.mOnClickListener);
        this.ivCircleScreen.setOnClickListener(this.mOnClickListener);
        this.guideAnimLayout.setOnClickListener(null);
        this.issue_window_layout.setListener(new m());
        this.inputTipsView.setTipsSelectedListener(new n());
        this.dmSelectView.setOnItemClickListener(new OnItemClickListener() { // from class: cn.damai.issue.IssueFragment.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.comment.view.OnItemClickListener
            public void onItemClick(@NotNull View view, int i2, @org.jetbrains.annotations.Nullable DmInfo dmInfo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1190383351")) {
                    ipChange2.ipc$dispatch("-1190383351", new Object[]{this, view, Integer.valueOf(i2), dmInfo});
                } else if (dmInfo != null) {
                    IssueFragment.this.dmSelectView.postDelayed(new Runnable() { // from class: cn.damai.issue.IssueFragment.7.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-401762030")) {
                                ipChange3.ipc$dispatch("-401762030", new Object[]{this});
                                return;
                            }
                            int bottom = IssueFragment.this.dmSelectView.getBottom() - IssueFragment.this.scrollView.getMeasuredHeight();
                            if (bottom > IssueFragment.this.scrollView.getScrollY()) {
                                IssueFragment.this.scrollView.scrollTo(0, bottom);
                            }
                        }
                    }, 50L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderSubItemEvaluate(List<CommentGradeTagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105173416")) {
            ipChange.ipc$dispatch("-1105173416", new Object[]{this, list});
            return;
        }
        this.viewHeight = 0;
        if (list != null && list.size() > 0) {
            this.mSumItemBar.removeAllViews();
            for (int i2 = 0; i2 < list.size(); i2++) {
                new CommentGradeTagBean();
                CommentGradeTagBean commentGradeTagBean = list.get(i2);
                if (commentGradeTagBean != null) {
                    DMCommentSubItemView dMCommentSubItemView = new DMCommentSubItemView(getActivity());
                    dMCommentSubItemView.setData(commentGradeTagBean, zk.a(TextUtils.isEmpty(commentGradeTagBean.getValue()) ? 0.0f : Float.valueOf(commentGradeTagBean.getValue()).floatValue()), R$drawable.comment_evalaute_default_icon);
                    dMCommentSubItemView.setGradeChangeLister(this);
                    dMCommentSubItemView.setPadding(0, t60.a(getActivity(), 21.0f), 0, 0);
                    this.mSumItemBar.addView(dMCommentSubItemView);
                    this.viewHeight += t60.a(getActivity(), 47.0f);
                    if (this.issueViewModel.getmGrades() > 0) {
                        pf0.g().o(this.mSumItemBar);
                    }
                }
            }
            return;
        }
        pf0.g().m(this.mSumItemBar);
    }

    private void requestEvaluateDetail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7799428")) {
            ipChange.ipc$dispatch("7799428", new Object[]{this});
            return;
        }
        startProgressDialog();
        if (this.evaluateDetailObserver == null) {
            this.evaluateDetailObserver = new Observer<CommentsResultBean>() { // from class: cn.damai.issue.IssueFragment.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable CommentsResultBean commentsResultBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-484854701")) {
                        ipChange2.ipc$dispatch("-484854701", new Object[]{this, commentsResultBean});
                        return;
                    }
                    IssueFragment.this.stopProgressDialog();
                    if (commentsResultBean == null || commentsResultBean.getData() == null || commentsResultBean.getData().size() <= 0 || commentsResultBean.getData().get(0) == null) {
                        return;
                    }
                    IssueFragment.this.setDetailInfoView(commentsResultBean.getData().get(0));
                    IssueFragment.this.dispatchDraftCheckIfNeed();
                }
            };
        }
        this.issueViewModel.requestEvaluateDetail().observe(this, this.evaluateDetailObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestIssue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135549373")) {
            ipChange.ipc$dispatch("-2135549373", new Object[]{this});
        } else if (isActivityOk()) {
            if (!LoginManager.k().q()) {
                LoginManager.k().x(getActivity(), new Intent(), 1000);
                return;
            }
            int checkUploadParamsValid = checkUploadParamsValid();
            if (checkUploadParamsValid == 0) {
                if (this.issueObserver == null) {
                    this.issueObserver = new Observer<IssueLiveDataResponse>() { // from class: cn.damai.issue.IssueFragment.20
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // androidx.lifecycle.Observer
                        public void onChanged(@Nullable IssueLiveDataResponse issueLiveDataResponse) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "262115664")) {
                                ipChange2.ipc$dispatch("262115664", new Object[]{this, issueLiveDataResponse});
                                return;
                            }
                            IssueFragment.this.stopProgressDialog();
                            if (issueLiveDataResponse != null && issueLiveDataResponse.data != null && IssueFragment.this.isActivityOk()) {
                                if (IssueFragment.this.mDraftBox != null) {
                                    IssueFragment.this.mDraftBox.notifyPublishSuccess();
                                }
                                IssueResponse issueResponse = issueLiveDataResponse.data;
                                HashMap hashMap = new HashMap();
                                hashMap.put("usercode", z20.E());
                                if (IssueFragment.this.issueViewModel.isEvaluate()) {
                                    hashMap.put("type", "1");
                                } else if (IssueFragment.this.issueViewModel.isPrivilege()) {
                                    hashMap.put("type", "0");
                                } else if (IssueFragment.this.issueViewModel.isEdit()) {
                                    hashMap.put("type", "2");
                                }
                                i41.i().t(hashMap);
                                DmInfo selectedDm = IssueFragment.this.dmSelectView.getSelectedDm();
                                if (selectedDm != null && IssueFragment.this.dmSelectView.getVisibility() == 0) {
                                    i41.n(String.valueOf(selectedDm.getDmId()));
                                    ArrayList<String> arrayList = selectedDm.dmTags;
                                    if (arrayList != null && arrayList.size() > 0 && selectedDm.allDmTags != null) {
                                        for (int i2 = 0; i2 < selectedDm.dmTags.size(); i2++) {
                                            i41.o(String.valueOf(selectedDm.getDmId()), IssueFragment.this.dmSelectView.getSelectedDmIndex(), selectedDm.dmTags.get(i2), selectedDm.allDmTags.indexOf(selectedDm.dmTags.get(i2)));
                                        }
                                    }
                                }
                                IssueFragment.this.mImagesPublishCount = 0;
                                if (IssueFragment.this.issueViewModel.isShowToastAfterPublishSuccess()) {
                                    if (IssueFragment.this.issueViewModel.isPrivilege()) {
                                        ToastUtil.a().e(IssueFragment.this.getActivity(), IssueFragment.this.getString(R$string.issue_success_privilege));
                                    } else {
                                        ToastUtil.a().e(IssueFragment.this.getActivity(), IssueFragment.this.getString(R$string.issue_success));
                                    }
                                }
                                IssueFragment.this.mIsRequestLoading = 0;
                                if (!IssueFragment.this.issueViewModel.isEvaluate() || issueResponse == null || issueResponse.getCommentsDO() == null || issueResponse.getUserDO() == null) {
                                    IssueFragment.this.notifyPublishSuccess();
                                } else {
                                    try {
                                        IssueFragment.this.onIssueCommentSuccess(issueResponse);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("result", (Object) "success");
                                WVStandardEventCenter.postNotificationToJS("publishEvent", jSONObject.toString());
                                return;
                            }
                            IssueFragment.this.stopProgressDialog();
                            IssueFragment.this.mImagesPublishCount = 0;
                            if (IssueFragment.this.getActivity() != null && issueLiveDataResponse != null) {
                                IssueFragment.this.getActivity().setResult(-1);
                                ToastUtil.a().e(IssueFragment.this.getActivity(), issueLiveDataResponse.errorMsg);
                            }
                            IssueFragment.this.mIsRequestLoading = 0;
                            IssueFragment.this.updateIssueButtonStatus(true);
                        }
                    };
                }
                IssueViewModel issueViewModel = this.issueViewModel;
                ArrayList<String> imageListParams = getImageListParams();
                CommentsVideoBean commentsVideoBean = this.videoBean;
                issueViewModel.requestIssue(imageListParams, commentsVideoBean != null ? JSON.toJSONString(commentsVideoBean) : null, gradesCombine(), this.privilegeType, this.issueViewModel.getThemeId(), this.issueViewModel.getCircle(), this.dmSelectView.getSelectedDm(), this.spoilerSwitchView.getIsSpoiler(), this.correlationView.getCorrelationId()).observe(this, this.issueObserver);
                startProgressDialog();
                updateIssueButtonStatus(false);
            } else if (checkUploadParamsValid == 1) {
                ToastUtil.a().e(getActivity(), "图片上传出错了，请重新上传～");
            } else if (checkUploadParamsValid == 2) {
                ToastUtil.a().e(getContext(), "剧本不能为空哦~");
            } else if (checkUploadParamsValid != 3) {
            } else {
                ToastUtil.a().e(getContext(), "细分项不能为空哦~~");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailInfoView(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527131301")) {
            ipChange.ipc$dispatch("-527131301", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean != null) {
            bindInputTips(commentsItemBean.getIconTitle());
            setRatingPartStaticData(String.valueOf(commentsItemBean.getItemType()));
            if (commentsItemBean.getItemType() == 1) {
                this.dmSelectView.bindData(commentsItemBean.getAllDmInfo(), commentsItemBean.getDmInfo());
            }
            ArrayList arrayList = new ArrayList();
            String str = "";
            if (wh2.e(commentsItemBean.getGradeDOList()) > 0) {
                for (int i2 = 0; i2 < commentsItemBean.getGradeDOList().size(); i2++) {
                    CommentGradeBean commentGradeBean = commentsItemBean.getGradeDOList().get(i2);
                    if (commentGradeBean != null) {
                        if (commentGradeBean.type == 1) {
                            if (!TextUtils.isEmpty(commentGradeBean.value)) {
                                this.issueViewModel.setmGrades((int) Float.parseFloat(commentGradeBean.value));
                                str = el.a(this.issueViewModel.getmGrades());
                            }
                        } else {
                            CommentGradeTagBean commentGradeTagBean = new CommentGradeTagBean();
                            commentGradeTagBean.setDesc(commentGradeBean.desc);
                            commentGradeTagBean.setValue(commentGradeBean.value);
                            commentGradeTagBean.setType(commentGradeBean.type);
                            arrayList.add(commentGradeTagBean);
                        }
                    }
                }
            }
            this.issueViewModel.updateDetailInfoView(commentsItemBean);
            this.issueViewModel.setItemType(String.valueOf(commentsItemBean.getItemType()));
            if (commentsItemBean.getStoreInfo() != null && 1 == commentsItemBean.getItemType()) {
                this.issueViewModel.setStoreId(commentsItemBean.getStoreInfo().getStoreId());
                this.correlationView.setDefaultData(commentsItemBean.getAssociatedScriptNum(), CorrelationType.SCRIPT, commentsItemBean.getStoreInfo().getStoreId(), Boolean.FALSE);
                if (commentsItemBean.getScriptInfo() != null && commentsItemBean.getScriptInfo().getId() != null) {
                    this.correlationView.setSelectData(commentsItemBean.getScriptInfo().getId(), commentsItemBean.getScriptInfo().getName());
                } else {
                    this.correlationView.setVisibility(8);
                }
            } else if (commentsItemBean.getScriptInfo() != null && 2 == commentsItemBean.getItemType()) {
                this.issueViewModel.setScriptId(commentsItemBean.getScriptInfo().getId());
                this.spoilerSwitchView.setVisibility(0);
                this.spoilerSwitchView.setIsSpoiler(commentsItemBean.isSpoilerType());
                this.correlationView.setDefaultData(commentsItemBean.getAssociatedStoreNum(), CorrelationType.STORE, commentsItemBean.getScriptInfo().getId());
                if (commentsItemBean.getStoreInfo() != null) {
                    this.correlationView.setSelectData(commentsItemBean.getStoreInfo().getStoreId(), commentsItemBean.getStoreInfo().getStoreName());
                }
            }
            this.videoBean = commentsItemBean.getVideoDO();
            handleEditContent();
            gradesDesc(str);
            renderSubItemEvaluate(arrayList);
            updateIssueButtonStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRatingPartStaticData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731255139")) {
            ipChange.ipc$dispatch("-731255139", new Object[]{this, str});
            return;
        }
        this.mDMRatingBar.setMarkDrawable(R$drawable.rating_fill, R$drawable.rating_empty);
        setTeachGoodEvaluate();
        if ("1".equals(str)) {
            this.mIssueEvaluateTip.setText("店铺打分");
            this.mEditor.setHint(getString(R$string.issue_store_edit_hint));
            this.mDMRatingBar.setMarkDrawable(R$drawable.rating_fill_type_2, R$drawable.rating_empty_type_2);
        } else if ("2".equals(str)) {
            this.mIssueEvaluateTip.setText("剧本打分");
            this.mEditor.setHint(getString(R$string.issue_script_edit_hint));
        } else {
            this.mIssueEvaluateTip.setText("总体打分");
        }
        this.mDMRatingBar.invalidate();
    }

    private void setTeachGoodEvaluate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368174556")) {
            ipChange.ipc$dispatch("-1368174556", new Object[]{this});
            return;
        }
        this.mTeachGoodEvaluate.setVisibility(0);
        this.mTeachGoodEvaluate.setText("😉想被精选么？点我");
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        String str = this.issueViewModel.isEvaluate() ? this.issueViewModel.getmItemId() : "";
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("item_id", str);
        }
        cn.damai.common.user.c.e().G(this.mTeachGoodEvaluate, "tips", "top", i41.PAGE_EVALUATE_SUBMIT, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setmEvaGiftContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804278999")) {
            ipChange.ipc$dispatch("-1804278999", new Object[]{this});
        } else if (isActivityOk()) {
            SpannableStringBuilder spannableStringBuilder = this.issueViewModel.setmEvaGiftContent(getActivity(), wh2.e(this.mShowNiePhoto.getData()));
            if (spannableStringBuilder != null && spannableStringBuilder.length() > 0) {
                this.mEvaGift.setVisibility(0);
                this.mEvaGift.setText(spannableStringBuilder);
                return;
            }
            this.mEvaGift.setVisibility(8);
        }
    }

    private void showEditorLimitTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084676099")) {
            ipChange.ipc$dispatch("1084676099", new Object[]{this});
        } else if (this.issueViewModel.inputCount() >= this.mEditorLimit) {
            ToastUtil.i("字数超限，最多可以输入10000字哦~");
        }
    }

    private void updateCircle(QueryThemeCliqueInfoBean queryThemeCliqueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818558737")) {
            ipChange.ipc$dispatch("-818558737", new Object[]{this, queryThemeCliqueInfoBean});
        } else if (TextUtils.isEmpty(queryThemeCliqueInfoBean.getName())) {
        } else {
            this.clCircleLayout.setVisibility(0);
            this.issueCircleSelect.i(queryThemeCliqueInfoBean);
            this.tvCircleContent.setText(queryThemeCliqueInfoBean.getName());
            this.ivCircleScreen.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCoverFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349940303")) {
            ipChange.ipc$dispatch("-349940303", new Object[]{this});
            return;
        }
        this.mIsRequestLoading = 0;
        stopProgressDialog();
        this.mShowNiePhoto.setIsSortable(true);
        ToastUtil.a().e(getActivity(), getResources().getString(R$string.issue_add_video_upload_fail));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        if ("0".equals(r5.issueViewModel.getmTargetId()) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (checkUploadParamsValid() == 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateIssueButtonStatus() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.issue.IssueFragment.$ipChange
            java.lang.String r1 = "-1147046423"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L14
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L14:
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            boolean r0 = r0.isEvaluate()
            if (r0 != 0) goto L50
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            boolean r0 = r0.isEdit()
            if (r0 == 0) goto L25
            goto L50
        L25:
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            boolean r0 = r0.isPrivilege()
            if (r0 == 0) goto L6d
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            java.lang.String r0 = r0.getmEditorContent()
            boolean r0 = tb.wh2.j(r0)
            if (r0 != 0) goto L6b
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            int r0 = r0.getmGrades()
            if (r0 <= 0) goto L6b
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            java.lang.String r0 = r0.getmTargetId()
            java.lang.String r1 = "0"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L6b
            goto L6c
        L50:
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            java.lang.String r0 = r0.getmEditorContent()
            boolean r0 = tb.wh2.j(r0)
            if (r0 != 0) goto L6b
            cn.damai.model.IssueViewModel r0 = r5.issueViewModel
            int r0 = r0.getmGrades()
            if (r0 <= 0) goto L6b
            int r0 = r5.checkUploadParamsValid()
            if (r0 != 0) goto L6b
            goto L6c
        L6b:
            r3 = 0
        L6c:
            r4 = r3
        L6d:
            r5.updateIssueButtonStatus(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.issue.IssueFragment.updateIssueButtonStatus():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTheme(String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "461912039")) {
            ipChange.ipc$dispatch("461912039", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.llThemeLayout.setVisibility(0);
            TextView textView = this.tvThemeContent;
            if (str.length() > 14) {
                str2 = str.substring(0, 14) + "...";
            } else {
                str2 = str;
            }
            textView.setText(str2);
            this.issueViewModel.setThemeName(str);
        } else {
            this.issueViewModel.setThemeName("");
            this.llThemeLayout.setVisibility(8);
        }
    }

    private void updateThemeByPojId(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378984526")) {
            ipChange.ipc$dispatch("-378984526", new Object[]{this, str, str2});
            return;
        }
        startProgressDialog();
        if (this.themeObserver == null) {
            this.themeObserver = new Observer<QueryThemeResultBean>() { // from class: cn.damai.issue.IssueFragment.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.lifecycle.Observer
                public void onChanged(@Nullable QueryThemeResultBean queryThemeResultBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "408945125")) {
                        ipChange2.ipc$dispatch("408945125", new Object[]{this, queryThemeResultBean});
                        return;
                    }
                    IssueFragment.this.stopProgressDialog();
                    if (queryThemeResultBean != null) {
                        IssueFragment.this.bindInputTips(queryThemeResultBean.getIconTitle());
                        if (!IssueFragment.this.issueViewModel.isComeFromTheme()) {
                            IssueFragment.this.issueViewModel.setThemeId(String.valueOf(queryThemeResultBean.getThemeId()));
                            IssueFragment.this.updateTheme(queryThemeResultBean.getThemeName());
                        }
                        if (IssueFragment.this.issueViewModel.isComeFromCircle()) {
                            return;
                        }
                        if (queryThemeResultBean.getCliqueInfos() != null) {
                            IssueFragment.this.updateCircle(queryThemeResultBean.getCliqueInfos());
                            IssueFragment issueFragment = IssueFragment.this;
                            issueFragment.issueViewModel.setCircle(issueFragment.issueCircleSelect.f());
                            IssueFragment.this.issueViewModel.setCircleList(queryThemeResultBean.getCliqueInfos());
                            return;
                        }
                        IssueFragment.this.issueViewModel.setCircle(null);
                        IssueFragment.this.issueViewModel.setCircleList(null);
                        IssueFragment.this.updateCircle(new ArrayList());
                        return;
                    }
                    IssueFragment.this.issueViewModel.setThemeId("");
                    IssueFragment.this.issueViewModel.setThemeName("");
                    IssueFragment.this.updateTheme("");
                }
            };
        }
        String str3 = "1";
        this.issueViewModel.requestThemeTipsByPojId(str, ("1".equals(str2) || "3".equals(str2)) ? "0" : "0").observe(this, this.themeObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoBean(String str) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308122715")) {
            ipChange.ipc$dispatch("-308122715", new Object[]{this, str});
            return;
        }
        CommentsVideoBean commentsVideoBean = this.videoBean;
        if (commentsVideoBean == null || (bitmap = this.coverBitmap) == null) {
            return;
        }
        commentsVideoBean.setHeight(String.valueOf(bitmap.getHeight()));
        this.videoBean.setWidth(String.valueOf(this.coverBitmap.getWidth()));
        this.videoBean.setCoverUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadVideoCover(Bitmap bitmap, FileUploadListener fileUploadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-381075200")) {
            ipChange.ipc$dispatch("-381075200", new Object[]{this, bitmap, fileUploadListener, Boolean.valueOf(z)});
        } else if (isNetAvailable()) {
            cb1.c("uploader fileUrl", "封面上传有网络");
            try {
                if (z) {
                    try {
                        this.mShowNiePhoto.setIsSortable(false);
                        this.mIsRequestLoading = 3;
                        startProgressDialog();
                    } catch (Exception e2) {
                        if (z) {
                            updateCoverFail();
                        } else {
                            delVideo(true);
                        }
                        e2.printStackTrace();
                        if (bitmap == null) {
                            return;
                        }
                    }
                }
                String initPicPath = this.issueViewModel.initPicPath(this.mFilePath);
                this.mFilePath = initPicPath;
                if (!wh2.j(initPicPath) && bitmap != null) {
                    this.coverBitmap = bitmap;
                    String str = this.mFilePath + "/coverUrl.jpg";
                    cn.damai.common.util.a.d(str);
                    cn.damai.common.util.a.u(bitmap, str);
                    FileUploader q = FileUploader.q("damai_comment_oss");
                    this.mCoverUploader = q;
                    q.C(fileUploadListener).D(str);
                } else if (z) {
                    updateCoverFail();
                } else {
                    delVideo(true);
                }
                if (bitmap == null) {
                    return;
                }
                bitmap.recycle();
            } catch (Throwable th) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        } else {
            if (z) {
                updateCoverFail();
            } else {
                delVideo(false);
                ToastUtil.i(getResources().getString(R$string.damai_base_net_toast));
            }
            cb1.c("uploader fileUrl", "封面上传无网络");
        }
    }

    private void uploader(String str, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493389051")) {
            ipChange.ipc$dispatch("1493389051", new Object[]{this, str, Long.valueOf(j2)});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        cb1.c("uploader start", currentTimeMillis + "");
        this.mIsRequestLoading = 2;
        if (isNetAvailable()) {
            cb1.c("uploader fileUrl", "有网络");
            FileUploader q = FileUploader.q(rx2.MtopUploadBiz);
            this.mVideoUploader = q;
            q.C(new b(currentTimeMillis, j2, str)).D(str);
            this.mShowNiePhoto.post(new Runnable() { // from class: cn.damai.issue.IssueFragment.12
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-420593195")) {
                        ipChange2.ipc$dispatch("-420593195", new Object[]{this});
                    } else if (IssueFragment.this.mShowNiePhoto != null) {
                        IssueFragment.this.mShowNiePhoto.notifyItemChanged(0, "start");
                    }
                }
            });
            return;
        }
        cb1.c("uploader ", "无网络 ");
        delVideo(false);
        ToastUtil.i(getResources().getString(R$string.damai_base_net_toast));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadingTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132711629")) {
            ipChange.ipc$dispatch("-1132711629", new Object[]{this});
            return;
        }
        int i2 = this.mIsRequestLoading;
        if (i2 == 2) {
            ToastUtil.i("视频上传中，请稍等");
        } else if (i2 == 3) {
            ToastUtil.i("封面上传中，请稍等");
        }
    }

    public final <T extends View> T findViewById(@IdRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561672264")) {
            return (T) ipChange.ipc$dispatch("1561672264", new Object[]{this, Integer.valueOf(i2)});
        }
        if (i2 == -1) {
            return null;
        }
        return (T) this.rootView.findViewById(i2);
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public Activity getDraftActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "278530261") ? (Activity) ipChange.ipc$dispatch("278530261", new Object[]{this}) : getActivity();
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    public List<QueryThemeCliqueInfoBean> getDraftCircle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704021387")) {
            return (List) ipChange.ipc$dispatch("-1704021387", new Object[]{this});
        }
        if (this.issueCircleSelect != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.issueCircleSelect.f());
            return arrayList;
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    public List<QueryThemeCliqueInfoBean> getDraftCircleList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508079053")) {
            return (List) ipChange.ipc$dispatch("-1508079053", new Object[]{this});
        }
        IssueViewModel issueViewModel = this.issueViewModel;
        if (issueViewModel != null) {
            return issueViewModel.getCircleList();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public DraftExtra getDraftExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1732927376")) {
            return (DraftExtra) ipChange.ipc$dispatch("-1732927376", new Object[]{this});
        }
        DraftExtra draftExtra = this.mTempDraftExtra;
        if (draftExtra != null) {
            return new DraftExtra(draftExtra);
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012167294")) {
            return (String) ipChange.ipc$dispatch("-2012167294", new Object[]{this});
        }
        IssueViewModel issueViewModel = this.issueViewModel;
        if (issueViewModel != null) {
            return issueViewModel.getmEditorContent();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftItemType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121873963")) {
            return (String) ipChange.ipc$dispatch("1121873963", new Object[]{this});
        }
        IssueViewModel issueViewModel = this.issueViewModel;
        if (issueViewModel != null) {
            return issueViewModel.getItemType();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftStoreId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030944084")) {
            return (String) ipChange.ipc$dispatch("1030944084", new Object[]{this});
        }
        IssueViewModel issueViewModel = this.issueViewModel;
        if (issueViewModel != null) {
            return issueViewModel.getStoreId();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftTheme() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "752151553")) {
            return (String) ipChange.ipc$dispatch("752151553", new Object[]{this});
        }
        IssueViewModel issueViewModel = this.issueViewModel;
        if (issueViewModel != null) {
            return issueViewModel.getThemeName();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftThemeId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252611132")) {
            return (String) ipChange.ipc$dispatch("1252611132", new Object[]{this});
        }
        IssueViewModel issueViewModel = this.issueViewModel;
        if (issueViewModel != null) {
            return issueViewModel.getThemeId();
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351409346")) {
            return ((Integer) ipChange.ipc$dispatch("1351409346", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.comment.view.DMCommentSubItemView.GradeChangeLister
    public void gradeChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354881046")) {
            ipChange.ipc$dispatch("354881046", new Object[]{this});
        } else {
            updateIssueButtonStatus();
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219487622")) {
            ipChange.ipc$dispatch("219487622", new Object[]{this, Integer.valueOf(i2)});
        } else {
            getRenderTags();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414957211")) {
            ipChange.ipc$dispatch("-414957211", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    @RequiresApi(api = 12)
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-475153896")) {
            ipChange.ipc$dispatch("-475153896", new Object[]{this});
        } else if (getActivity() == null) {
        } else {
            initIssueViewModel();
            initContentView();
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", z20.E());
            i41.m(hashMap);
            cn.damai.common.user.c.e().G(this.mIssueTitleConfirm, "release", "bottom", i41.PAGE_EVALUATE_SUBMIT, hashMap);
            registerListener();
            initSetting();
            setDamaiUTKeyBuilder(i41.i().j());
            i41.i().l(this.issueViewModel, this.correlationView);
            if ((!TextUtils.isEmpty(this.issueViewModel.getmItemId()) && this.issueViewModel.isEvaluate()) || this.issueViewModel.getScriptId() != null) {
                getRenderTags();
            } else if (!TextUtils.isEmpty(this.issueViewModel.getmCommentId()) && this.issueViewModel.isEdit()) {
                requestEvaluateDetail();
            } else {
                dispatchDraftCheckIfNeed();
            }
        }
    }

    public boolean isActivityOk() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11100196")) {
            return ((Boolean) ipChange.ipc$dispatch("-11100196", new Object[]{this})).booleanValue();
        }
        FragmentActivity activity = getActivity();
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441805313")) {
            ipChange.ipc$dispatch("-1441805313", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        cb1.b("wpf", "onActivityResult/in data:");
        if (i3 == -1) {
            if (i2 == 17) {
                onSelectAlbumResult(intent, "1");
            } else if (i2 != 18) {
                switch (i2) {
                    case 103:
                        if (intent != null && "3".equals(intent.getStringExtra(IssueConstants.privilegeType))) {
                            String stringExtra = intent.getStringExtra("projectName");
                            String stringExtra2 = intent.getStringExtra("projectImage");
                            String stringExtra3 = intent.getStringExtra("timeAddress");
                            String stringExtra4 = intent.getStringExtra("targetId");
                            String stringExtra5 = intent.getStringExtra("time");
                            if (this.issueViewModel.getCircle() == null || !this.issueViewModel.isComeFromCircle()) {
                                str = null;
                                str2 = null;
                            } else {
                                str = String.valueOf(this.issueViewModel.getCircle().getId());
                                str2 = this.issueViewModel.getCircle().getName();
                            }
                            if (this.issueViewModel.isComeFromTheme()) {
                                String themeId = this.issueViewModel.getThemeId();
                                str4 = this.issueViewModel.getThemeName();
                                str3 = themeId;
                            } else {
                                str3 = null;
                                str4 = null;
                            }
                            CommentItemMoreUtil.h(getActivity(), stringExtra4, intent.getStringExtra(IssueConstants.ProjectID), stringExtra, stringExtra2, stringExtra5, stringExtra3, str, str2, str3, str4);
                            finish();
                            return;
                        }
                        privilegeView(true, intent, false);
                        return;
                    case 104:
                        onBackFromShare(intent);
                        return;
                    case 105:
                        if (intent != null) {
                            ScriptSelectMo scriptSelectMo = (ScriptSelectMo) intent.getSerializableExtra("selectResult");
                            if (scriptSelectMo != null) {
                                this.correlationView.setSelectData(scriptSelectMo.getTargetId(), scriptSelectMo.getTargetName());
                            } else {
                                this.correlationView.setSelectData(null, null);
                                this.correlationView.restore();
                            }
                            updateIssueButtonStatus();
                            return;
                        }
                        return;
                    default:
                        switch (i2) {
                            case 1000:
                                requestIssue();
                                return;
                            case 1001:
                                onSelectAlbumResult(intent, "2");
                                return;
                            case 1002:
                                onPreviewVideoResult(intent);
                                return;
                            case 1003:
                                onCoverVideoResult(intent);
                                return;
                            default:
                                return;
                        }
                }
            } else {
                onPreviewImageResult(intent);
            }
        }
    }

    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57417599")) {
            ipChange.ipc$dispatch("-57417599", new Object[]{this});
        } else {
            onBackClicked();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685556734")) {
            ipChange.ipc$dispatch("1685556734", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967622366")) {
            return (View) ipChange.ipc$dispatch("-1967622366", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        View inflate = layoutInflater.inflate(R$layout.activity_issue, viewGroup, false);
        this.rootView = inflate;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-505594654")) {
            ipChange.ipc$dispatch("-505594654", new Object[]{this});
            return;
        }
        super.onDestroy();
        FileUploader fileUploader = this.mCoverUploader;
        if (fileUploader != null) {
            fileUploader.p();
            this.mCoverUploader = null;
        }
        FileUploader fileUploader2 = this.mSubmitUploader;
        if (fileUploader2 != null) {
            fileUploader2.p();
            this.mSubmitUploader = null;
        }
        IDraftBox iDraftBox = this.mDraftBox;
        if (iDraftBox != null) {
            iDraftBox.release();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "195672993")) {
            ipChange.ipc$dispatch("195672993", new Object[]{this});
            return;
        }
        super.onResume();
        keyBoradChangeView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCircle(List<QueryThemeCliqueInfoBean> list, QueryThemeCliqueInfoBean queryThemeCliqueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169090528")) {
            ipChange.ipc$dispatch("1169090528", new Object[]{this, list, queryThemeCliqueInfoBean});
            return;
        }
        this.issueCircleSelect.m(list);
        this.issueCircleSelect.i(queryThemeCliqueInfoBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCircle(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172684645")) {
            ipChange.ipc$dispatch("172684645", new Object[]{this, list});
            return;
        }
        this.issueViewModel.setCircleList(list);
        this.issueCircleSelect.m(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIssueButtonStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198654965")) {
            ipChange.ipc$dispatch("-1198654965", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIssueTitleConfirm.setEnabled(true);
        if (z) {
            this.mIssueTitleConfirm.setBackgroundResource(R$drawable.issue_issue_button_bg);
        } else {
            this.mIssueTitleConfirm.setBackgroundResource(R$drawable.comment_submit_unable_btn_99);
        }
    }
}
