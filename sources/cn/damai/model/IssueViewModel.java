package cn.damai.model;

import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.QueryThemeCliqueInfoBean;
import cn.damai.comment.bean.QueryThemeResultBean;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.C0535a;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.discover.content.net.ContentDetailApi;
import cn.damai.evaluate.request.CommentListRequest;
import cn.damai.issue.net.CommentGradeText;
import cn.damai.issue.net.IssueActivityIntroduce;
import cn.damai.issue.net.IssueEditRequest;
import cn.damai.issue.net.IssueLiveDataResponse;
import cn.damai.issue.net.IssueRenderLiveDataResponse;
import cn.damai.issue.net.IssueRenderRequest;
import cn.damai.issue.net.IssueRenderResponse;
import cn.damai.issue.net.IssueRequest;
import cn.damai.issue.net.IssueResponse;
import cn.damai.issue.net.QueryThemeRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.b23;
import tb.g41;
import tb.h41;
import tb.ir1;
import tb.mr1;
import tb.pf0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class IssueViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String appPublishHint;
    private QueryThemeCliqueInfoBean circle;
    private List<QueryThemeCliqueInfoBean> circleList;
    ArrayList<CommentGradeText> commentGradeTexts;
    private boolean isComeFromCircle;
    private boolean isComeFromTheme;
    private boolean isShowToastAfterPublishSuccess;
    private String itemType;
    private String mCommentId;
    private String mCommentType;
    private String mEditorContent;
    private int mGrades;
    private ArrayList<String> mImages;
    private String mIpId;
    private String mIssueFrom;
    private String mIssueType;
    private String mItemId;
    private String mProjectName;
    private String mProjectPoster;
    private ArrayList<Image> mSelectImages;
    private String mStoreId;
    private String mTargetId;
    private String mTargetType;
    ArrayList<IssueActivityIntroduce> noticeInfos;
    private String performBeginTime;
    h41 repository;
    private String scriptId;
    private String themeId;
    private String themeName;
    private String timeAddress;
    private String timeDes;
    private String uniqueOrderId;
    private String watchActivityId;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.model.IssueViewModel$a */
    /* loaded from: classes15.dex */
    public class C1480a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LinearLayout a;

        C1480a(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1062304658")) {
                ipChange.ipc$dispatch("1062304658", new Object[]{this, valueAnimator});
            } else {
                IssueViewModel.this.setViewHeight(this.a, (int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public IssueViewModel(@NonNull Application application) {
        super(application);
        this.mImages = new ArrayList<>();
        this.mSelectImages = new ArrayList<>();
        this.noticeInfos = new ArrayList<>();
        this.commentGradeTexts = new ArrayList<>();
        this.repository = new h41(application.getApplicationContext());
    }

    private void scriptMurderParams(IssueRequest issueRequest, DmInfo dmInfo, Boolean bool, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222856068")) {
            ipChange.ipc$dispatch("-1222856068", new Object[]{this, issueRequest, dmInfo, bool, str});
            return;
        }
        issueRequest.spoilerType = bool.booleanValue();
        if (dmInfo != null) {
            issueRequest.dmId = dmInfo.getDmId();
            issueRequest.dmTags = dmInfo.dmTags;
        }
        if (this.mStoreId != null && "1".equals(this.itemType)) {
            setmCommentType("32");
            issueRequest.commentType = "32";
            issueRequest.targetId = getmTargetId();
            issueRequest.storeId = getStoreId();
            issueRequest.scriptId = str;
        } else if (this.scriptId == null || !"2".equals(this.itemType)) {
        } else {
            setmCommentType(g41.ISSUE_PARAM_COMMENT_TYPE_SCRIPT);
            issueRequest.commentType = g41.ISSUE_PARAM_COMMENT_TYPE_SCRIPT;
            String str2 = this.scriptId;
            issueRequest.targetId = str2;
            issueRequest.scriptId = str2;
            issueRequest.storeId = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewHeight(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078533348")) {
            ipChange.ipc$dispatch("2078533348", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        view.getLayoutParams().height = i;
        view.requestLayout();
    }

    public void animateToggle(LinearLayout linearLayout, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018357032")) {
            ipChange.ipc$dispatch("2018357032", new Object[]{this, linearLayout, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT >= 11) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, i);
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new C1480a(linearLayout));
            ofFloat.start();
        }
    }

    public String getAppPublishHint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1400062634") ? (String) ipChange.ipc$dispatch("1400062634", new Object[]{this}) : this.appPublishHint;
    }

    public QueryThemeCliqueInfoBean getCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-127727722") ? (QueryThemeCliqueInfoBean) ipChange.ipc$dispatch("-127727722", new Object[]{this}) : this.circle;
    }

    public List<QueryThemeCliqueInfoBean> getCircleList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-678552118") ? (List) ipChange.ipc$dispatch("-678552118", new Object[]{this}) : this.circleList;
    }

    public ArrayList<CommentGradeText> getCommentGradeTexts() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1462268555") ? (ArrayList) ipChange.ipc$dispatch("1462268555", new Object[]{this}) : this.commentGradeTexts;
    }

    @RequiresApi(api = 12)
    public boolean getIntentValue(Bundle bundle, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237884373")) {
            return ((Boolean) ipChange.ipc$dispatch("-237884373", new Object[]{this, bundle, intent})).booleanValue();
        }
        if (bundle != null) {
            this.mCommentType = bundle.getString(g41.ISSUE_PARAM_COMMENT_TYPE, "32");
            if (bundle.containsKey("publisherType")) {
                String string = bundle.getString("publisherType", g41.ISSUE_TYPE_EVALUATE);
                if ("ReleaseType_Evaluate".equals(string)) {
                    this.mIssueType = g41.ISSUE_TYPE_EVALUATE;
                    this.mCommentType = "32";
                } else if ("ReleaseType_Edit_Evaluate".equals(string)) {
                    this.mIssueType = g41.ISSUE_TYPE_EDIT;
                } else if ("ReleaseType_Discovery_Privilege".equals(string)) {
                    this.mIssueType = g41.ISSUE_TYPE_PRIVILEGE;
                    this.mCommentType = "62";
                }
            } else {
                this.mIssueType = bundle.getString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_PRIVILEGE);
                this.mCommentType = "62";
            }
            if (intent != null && intent.getData() != null && !TextUtils.isEmpty(intent.getData().getPath()) && intent.getData().getPath().contains("activity/savecomment/index.html")) {
                this.mIssueType = g41.ISSUE_TYPE_PRIVILEGE;
                this.mCommentType = "62";
            }
            this.mIssueFrom = bundle.getString(g41.ISSUE_FROM, "");
            this.appPublishHint = bundle.getString("appPublishHint");
            this.timeAddress = bundle.getString("timeAddress", "");
            if (!bundle.getString(g41.ISSUE_PARAM_PERFORM_TIMR, "").isEmpty()) {
                this.performBeginTime = bundle.getString(g41.ISSUE_PARAM_PERFORM_TIMR, "");
            } else {
                this.performBeginTime = bundle.getString(g41.ISSUE_PARAM_PERFORM_BEGIN_TIMR, "");
            }
            this.mTargetId = bundle.getString("targetId", "0");
            this.mTargetType = bundle.getString("targetType", "0");
            this.isShowToastAfterPublishSuccess = bundle.getBoolean(g41.ISSUE_PARAM_TOAST_SWITCH, true);
            this.mItemId = bundle.getString("itemId", "");
            this.uniqueOrderId = bundle.getString(g41.ISSUE_PARAM_ORDER_ID, "");
            this.watchActivityId = bundle.getString(g41.ISSUE_PARAM_WATCH_ACTIVITY_ID, "");
            this.timeDes = bundle.getString(g41.ISSUE_PARAM_TIMEDES, "");
            this.mIpId = bundle.getString(g41.ISSUE_PARAM_IPID);
            this.mProjectName = bundle.getString("projectName");
            this.mProjectPoster = bundle.getString(g41.ISSUE_PARAM_PROJECT_POSTER);
            this.mGrades = bundle.getInt(g41.ISSUE_PARAM_GRADES, 0);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("images");
            if (wh2.e(stringArrayList) > 0) {
                this.mImages.addAll(stringArrayList);
                for (int i = 0; i < wh2.e(this.mImages); i++) {
                    this.mSelectImages.add(new Image(this.mImages.get(i), ((int) System.currentTimeMillis()) / 1000, (((int) System.currentTimeMillis()) / 1000) + ".jpg", true));
                }
            }
            this.mEditorContent = bundle.getString("text");
            this.mCommentId = bundle.getString(g41.ISSUE_PARAM_COMMENT_ID);
            this.themeId = bundle.getString("themeId");
            this.themeName = bundle.getString(g41.ISSUE_PARAM_LIVE_THEME_NAME);
            String string2 = bundle.getString("circleId");
            String string3 = bundle.getString("circleName");
            this.isComeFromTheme = !TextUtils.isEmpty(this.themeId);
            boolean z = !TextUtils.isEmpty(string2);
            this.isComeFromCircle = z;
            if (z) {
                QueryThemeCliqueInfoBean queryThemeCliqueInfoBean = new QueryThemeCliqueInfoBean();
                this.circle = queryThemeCliqueInfoBean;
                try {
                    queryThemeCliqueInfoBean.setId(Long.parseLong(string2));
                } catch (NumberFormatException unused) {
                    this.circle.setId(0L);
                }
                this.circle.setName(string3);
                ArrayList arrayList = new ArrayList();
                this.circleList = arrayList;
                arrayList.add(this.circle);
            }
            this.scriptId = bundle.getString("scriptId");
            return true;
        }
        return false;
    }

    public String getItemType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1951400898") ? (String) ipChange.ipc$dispatch("1951400898", new Object[]{this}) : this.itemType;
    }

    public ArrayList<IssueActivityIntroduce> getNoticeInfos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2124001452") ? (ArrayList) ipChange.ipc$dispatch("2124001452", new Object[]{this}) : this.noticeInfos;
    }

    public String getPerformBeginTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1635328394") ? (String) ipChange.ipc$dispatch("1635328394", new Object[]{this}) : this.performBeginTime;
    }

    public MutableLiveData<IssueRenderLiveDataResponse> getRenderTags() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1003531624")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1003531624", new Object[]{this});
        }
        final MutableLiveData<IssueRenderLiveDataResponse> mutableLiveData = new MutableLiveData<>();
        IssueRenderRequest issueRenderRequest = new IssueRenderRequest();
        issueRenderRequest.itemId = this.mItemId;
        issueRenderRequest.ipId = this.mIpId;
        issueRenderRequest.performTime = this.performBeginTime;
        issueRenderRequest.scriptId = this.scriptId;
        issueRenderRequest.request(new DMMtopRequestListener<IssueRenderResponse>(IssueRenderResponse.class) { // from class: cn.damai.model.IssueViewModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-597803923")) {
                    ipChange2.ipc$dispatch("-597803923", new Object[]{this, str, str2});
                    return;
                }
                IssueRenderLiveDataResponse issueRenderLiveDataResponse = new IssueRenderLiveDataResponse();
                b23.a(b23.i("mtop.damai.wireless.comment.render", "发布器评价渲染接口", str, str2, ""), "-8200", "发布器评价渲染错误");
                issueRenderLiveDataResponse.errorCode = str;
                issueRenderLiveDataResponse.errorMsg = str2;
                mutableLiveData.setValue(issueRenderLiveDataResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(IssueRenderResponse issueRenderResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1178309362")) {
                    ipChange2.ipc$dispatch("1178309362", new Object[]{this, issueRenderResponse});
                } else if (issueRenderResponse == null) {
                } else {
                    IssueRenderLiveDataResponse issueRenderLiveDataResponse = new IssueRenderLiveDataResponse();
                    issueRenderLiveDataResponse.data = issueRenderResponse;
                    mutableLiveData.setValue(issueRenderLiveDataResponse);
                }
            }
        });
        return mutableLiveData;
    }

    public h41 getRepository() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1135222078") ? (h41) ipChange.ipc$dispatch("-1135222078", new Object[]{this}) : this.repository;
    }

    public String getScriptId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1482984549") ? (String) ipChange.ipc$dispatch("-1482984549", new Object[]{this}) : this.scriptId;
    }

    public String getStoreId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "642061021") ? (String) ipChange.ipc$dispatch("642061021", new Object[]{this}) : this.mStoreId;
    }

    public String getThemeId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "863728069") ? (String) ipChange.ipc$dispatch("863728069", new Object[]{this}) : this.themeId;
    }

    public String getThemeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1184869237") ? (String) ipChange.ipc$dispatch("1184869237", new Object[]{this}) : this.themeName;
    }

    public String getTimeAddress() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1110185704") ? (String) ipChange.ipc$dispatch("1110185704", new Object[]{this}) : this.timeAddress;
    }

    public String getTimeDes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1509736582") ? (String) ipChange.ipc$dispatch("1509736582", new Object[]{this}) : this.timeDes;
    }

    public String getmCommentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1933387298") ? (String) ipChange.ipc$dispatch("1933387298", new Object[]{this}) : this.mCommentId;
    }

    public String getmCommentType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "218538945") ? (String) ipChange.ipc$dispatch("218538945", new Object[]{this}) : this.mCommentType;
    }

    public String getmEditorContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-828424940") ? (String) ipChange.ipc$dispatch("-828424940", new Object[]{this}) : this.mEditorContent;
    }

    public int getmGrades() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "917268585") ? ((Integer) ipChange.ipc$dispatch("917268585", new Object[]{this})).intValue() : this.mGrades;
    }

    public ArrayList<String> getmImages() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1393880364") ? (ArrayList) ipChange.ipc$dispatch("-1393880364", new Object[]{this}) : this.mImages;
    }

    public String getmIpId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1655992784") ? (String) ipChange.ipc$dispatch("1655992784", new Object[]{this}) : this.mIpId;
    }

    public String getmIssueFrom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "162163691") ? (String) ipChange.ipc$dispatch("162163691", new Object[]{this}) : this.mIssueFrom;
    }

    public String getmIssueType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-86410373") ? (String) ipChange.ipc$dispatch("-86410373", new Object[]{this}) : this.mIssueType;
    }

    public String getmItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1016473092") ? (String) ipChange.ipc$dispatch("-1016473092", new Object[]{this}) : this.mItemId;
    }

    public String getmProjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "443812684") ? (String) ipChange.ipc$dispatch("443812684", new Object[]{this}) : this.mProjectName;
    }

    public String getmProjectPoster() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "860083086") ? (String) ipChange.ipc$dispatch("860083086", new Object[]{this}) : this.mProjectPoster;
    }

    public ArrayList<Image> getmSelectImages() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-122884744") ? (ArrayList) ipChange.ipc$dispatch("-122884744", new Object[]{this}) : this.mSelectImages;
    }

    public String getmTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-639737542") ? (String) ipChange.ipc$dispatch("-639737542", new Object[]{this}) : this.mTargetId;
    }

    public String getmTargetType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1346730201") ? (String) ipChange.ipc$dispatch("1346730201", new Object[]{this}) : this.mTargetType;
    }

    public String initPicPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067042060")) {
            return (String) ipChange.ipc$dispatch("-2067042060", new Object[]{this, str});
        }
        if (ir1.i(mr1.STORAGE)) {
            String m = C0535a.m();
            if (wh2.j(m)) {
                return str;
            }
            String str2 = m + "/publish";
            C0535a.f(str2);
            C0535a.t(str2, false);
            return str2;
        }
        return str;
    }

    public int inputCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485622793")) {
            return ((Integer) ipChange.ipc$dispatch("-1485622793", new Object[]{this})).intValue();
        }
        if (TextUtils.isEmpty(getmEditorContent())) {
            return 0;
        }
        return pf0.c(getmEditorContent());
    }

    public boolean isComeFromCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1794698373") ? ((Boolean) ipChange.ipc$dispatch("1794698373", new Object[]{this})).booleanValue() : this.isComeFromCircle;
    }

    public boolean isComeFromTheme() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1629816396") ? ((Boolean) ipChange.ipc$dispatch("-1629816396", new Object[]{this})).booleanValue() : this.isComeFromTheme;
    }

    public boolean isEdit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "156749497") ? ((Boolean) ipChange.ipc$dispatch("156749497", new Object[]{this})).booleanValue() : g41.ISSUE_TYPE_EDIT.equals(getmIssueType());
    }

    public boolean isEvaluate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2102983882") ? ((Boolean) ipChange.ipc$dispatch("2102983882", new Object[]{this})).booleanValue() : g41.ISSUE_TYPE_EVALUATE.equals(getmIssueType());
    }

    public boolean isFromHome() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1883245638") ? ((Boolean) ipChange.ipc$dispatch("-1883245638", new Object[]{this})).booleanValue() : "homepage".equals(getmIssueFrom());
    }

    public boolean isPrivilege() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-373068834") ? ((Boolean) ipChange.ipc$dispatch("-373068834", new Object[]{this})).booleanValue() : g41.ISSUE_TYPE_PRIVILEGE.equals(getmIssueType());
    }

    public boolean isShowToastAfterPublishSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "856957405") ? ((Boolean) ipChange.ipc$dispatch("856957405", new Object[]{this})).booleanValue() : this.isShowToastAfterPublishSuccess;
    }

    public MutableLiveData<CommentsResultBean> requestEvaluateDetail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12858252")) {
            return (MutableLiveData) ipChange.ipc$dispatch("12858252", new Object[]{this});
        }
        final MutableLiveData<CommentsResultBean> mutableLiveData = new MutableLiveData<>();
        CommentListRequest commentListRequest = new CommentListRequest();
        commentListRequest.commentId = this.mCommentId;
        commentListRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) { // from class: cn.damai.model.IssueViewModel.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-613322641")) {
                    ipChange2.ipc$dispatch("-613322641", new Object[]{this, str, str2});
                    return;
                }
                mutableLiveData.setValue(new CommentsResultBean());
                b23.a(b23.i("mtop.damai.wireless.comment.list.get", "发布器编辑接口", str, str2, ""), "-8202", "发布器编辑接口错误");
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CommentsResultBean commentsResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1366844008")) {
                    ipChange2.ipc$dispatch("1366844008", new Object[]{this, commentsResultBean});
                } else {
                    mutableLiveData.setValue(commentsResultBean);
                }
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<IssueLiveDataResponse> requestIssue(ArrayList<String> arrayList, String str, String str2, String str3, String str4, QueryThemeCliqueInfoBean queryThemeCliqueInfoBean, DmInfo dmInfo, Boolean bool, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033548337")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1033548337", new Object[]{this, arrayList, str, str2, str3, str4, queryThemeCliqueInfoBean, dmInfo, bool, str5});
        }
        final MutableLiveData<IssueLiveDataResponse> mutableLiveData = new MutableLiveData<>();
        final IssueRequest issueRequest = new IssueRequest();
        if (isEdit()) {
            issueRequest = new IssueEditRequest();
        }
        Long l = null;
        try {
            l = Long.valueOf(str4);
        } catch (NumberFormatException e) {
            Log.d("IssueViewModel", e.getMessage());
        }
        issueRequest.images = arrayList;
        issueRequest.video = str;
        issueRequest.grades = str2;
        issueRequest.text = getmEditorContent();
        if (queryThemeCliqueInfoBean != null) {
            issueRequest.cliqueId = Long.valueOf(queryThemeCliqueInfoBean.getId());
        }
        if (l != null) {
            issueRequest.associatedThemeId = l;
        }
        if (!TextUtils.isEmpty(this.uniqueOrderId)) {
            issueRequest.uniqueOrderId = this.uniqueOrderId;
        }
        if (!TextUtils.isEmpty(this.watchActivityId)) {
            issueRequest.watchActivityId = this.watchActivityId;
        }
        if (isEvaluate()) {
            setmCommentType("32");
            issueRequest.targetId = getmTargetId();
            issueRequest.targetType = getmTargetType();
            issueRequest.commentType = getmCommentType();
            issueRequest.targetValidTime = getPerformBeginTime();
            if (!wh2.j(getmIpId())) {
                issueRequest.ipId = getmIpId();
            }
            if (!wh2.j(getmItemId())) {
                issueRequest.itemId = getmItemId();
            }
        } else if (isEdit()) {
            issueRequest.commentId = getmCommentId();
        } else if (isPrivilege()) {
            issueRequest.targetId = getmTargetId();
            if ("1".equals(str3)) {
                issueRequest.itemId = getmTargetId();
            } else if ("2".equals(str3)) {
                issueRequest.ipId = getmTargetId();
            }
            issueRequest.targetType = getmTargetType();
            issueRequest.commentType = getmCommentType();
        }
        scriptMurderParams(issueRequest, dmInfo, bool, str5);
        issueRequest.request(new DMMtopRequestListener<IssueResponse>(IssueResponse.class) { // from class: cn.damai.model.IssueViewModel.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str6, String str7) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-621082000")) {
                    ipChange2.ipc$dispatch("-621082000", new Object[]{this, str6, str7});
                    return;
                }
                IssueLiveDataResponse issueLiveDataResponse = new IssueLiveDataResponse();
                StringBuilder sb = new StringBuilder();
                if (IssueViewModel.this.isEvaluate()) {
                    sb.append("publisherType:ReleaseType_Evaluate");
                } else if (IssueViewModel.this.isEdit()) {
                    sb.append("publisherType:ReleaseType_Edit_Evaluate");
                    sb.append(",commentId:");
                    sb.append(issueRequest.commentId);
                } else if (IssueViewModel.this.isPrivilege()) {
                    sb.append("publisherType:ReleaseType_Privilege");
                } else {
                    sb.append("publisherType:Error");
                }
                sb.append(",targetId:");
                sb.append(issueRequest.targetId);
                sb.append(",commentType:");
                sb.append(issueRequest.commentType);
                sb.append(",itemId:");
                sb.append(issueRequest.itemId);
                b23.a(b23.i(ContentDetailApi.CONTENT_COMMENT_PUBLISH, "发布器发布接口", str6, str7, sb.toString()), "-8200", "发布器发布错误");
                issueLiveDataResponse.errorCode = str6;
                issueLiveDataResponse.errorMsg = str7;
                mutableLiveData.setValue(issueLiveDataResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(IssueResponse issueResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1523528315")) {
                    ipChange2.ipc$dispatch("-1523528315", new Object[]{this, issueResponse});
                    return;
                }
                IssueLiveDataResponse issueLiveDataResponse = new IssueLiveDataResponse();
                issueLiveDataResponse.data = issueResponse;
                mutableLiveData.setValue(issueLiveDataResponse);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<QueryThemeResultBean> requestThemeTipsByPojId(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064567484")) {
            return (MutableLiveData) ipChange.ipc$dispatch("2064567484", new Object[]{this, str, str2});
        }
        final MutableLiveData<QueryThemeResultBean> mutableLiveData = new MutableLiveData<>();
        QueryThemeRequest queryThemeRequest = new QueryThemeRequest();
        try {
            queryThemeRequest.targetId = Long.valueOf(str);
            queryThemeRequest.targetType = Integer.valueOf(str2);
        } catch (NumberFormatException e) {
            Log.d("requestThemeTipsByPojId", e.getMessage());
        }
        queryThemeRequest.request(new DMMtopRequestListener<QueryThemeResultBean>(QueryThemeResultBean.class) { // from class: cn.damai.model.IssueViewModel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-605563282")) {
                    ipChange2.ipc$dispatch("-605563282", new Object[]{this, str3, str4});
                } else {
                    mutableLiveData.setValue(new QueryThemeResultBean());
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(QueryThemeResultBean queryThemeResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1573119996")) {
                    ipChange2.ipc$dispatch("1573119996", new Object[]{this, queryThemeResultBean});
                } else {
                    mutableLiveData.setValue(queryThemeResultBean);
                }
            }
        });
        return mutableLiveData;
    }

    public void setAppPublishHint(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335161972")) {
            ipChange.ipc$dispatch("1335161972", new Object[]{this, str});
        } else {
            this.appPublishHint = str;
        }
    }

    public void setCircle(QueryThemeCliqueInfoBean queryThemeCliqueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065523126")) {
            ipChange.ipc$dispatch("-2065523126", new Object[]{this, queryThemeCliqueInfoBean});
        } else {
            this.circle = queryThemeCliqueInfoBean;
        }
    }

    public void setCircleList(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462939714")) {
            ipChange.ipc$dispatch("1462939714", new Object[]{this, list});
        } else {
            this.circleList = list;
        }
    }

    public void setComeFromCircle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839312813")) {
            ipChange.ipc$dispatch("-839312813", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isComeFromCircle = z;
        }
    }

    public void setComeFromTheme(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113692860")) {
            ipChange.ipc$dispatch("-113692860", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isComeFromTheme = z;
        }
    }

    public void setCommentGradeTexts(ArrayList<CommentGradeText> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636104307")) {
            ipChange.ipc$dispatch("-636104307", new Object[]{this, arrayList});
        } else {
            this.commentGradeTexts = arrayList;
        }
    }

    public void setItemType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "481557852")) {
            ipChange.ipc$dispatch("481557852", new Object[]{this, str});
        } else {
            this.itemType = str;
        }
    }

    public void setNoticeInfos(ArrayList<IssueActivityIntroduce> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227982988")) {
            ipChange.ipc$dispatch("227982988", new Object[]{this, arrayList});
        } else {
            this.noticeInfos = arrayList;
        }
    }

    public void setPerformBeginTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016222060")) {
            ipChange.ipc$dispatch("-2016222060", new Object[]{this, str});
        } else {
            this.performBeginTime = str;
        }
    }

    public void setRepository(h41 h41Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232493634")) {
            ipChange.ipc$dispatch("232493634", new Object[]{this, h41Var});
        } else {
            this.repository = h41Var;
        }
    }

    public void setScriptId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389791395")) {
            ipChange.ipc$dispatch("1389791395", new Object[]{this, str});
        } else {
            this.scriptId = str;
        }
    }

    public void setShowToastAfterPublishSuccess(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645197317")) {
            ipChange.ipc$dispatch("-1645197317", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isShowToastAfterPublishSuccess = z;
        }
    }

    public void setStoreId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107768889")) {
            ipChange.ipc$dispatch("1107768889", new Object[]{this, str});
        } else {
            this.mStoreId = str;
        }
    }

    public void setThemeId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-610487215")) {
            ipChange.ipc$dispatch("-610487215", new Object[]{this, str});
        } else {
            this.themeId = str;
        }
    }

    public void setThemeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "406003105")) {
            ipChange.ipc$dispatch("406003105", new Object[]{this, str});
        } else {
            this.themeName = str;
        }
    }

    public void setTimeAddress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051034510")) {
            ipChange.ipc$dispatch("2051034510", new Object[]{this, str});
        } else {
            this.timeAddress = str;
        }
    }

    public void setTimeDes(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059059792")) {
            ipChange.ipc$dispatch("-2059059792", new Object[]{this, str});
        } else {
            this.timeDes = str;
        }
    }

    public void setmCommentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990547964")) {
            ipChange.ipc$dispatch("1990547964", new Object[]{this, str});
        } else {
            this.mCommentId = str;
        }
    }

    public void setmCommentType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417346243")) {
            ipChange.ipc$dispatch("-1417346243", new Object[]{this, str});
        } else {
            this.mCommentType = str;
        }
    }

    public void setmEditorContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971523914")) {
            ipChange.ipc$dispatch("971523914", new Object[]{this, str});
        } else {
            this.mEditorContent = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.text.SpannableStringBuilder setmEvaGiftContent(android.content.Context r13, int r14) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.model.IssueViewModel.setmEvaGiftContent(android.content.Context, int):android.text.SpannableStringBuilder");
    }

    public void setmGrades(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "893816001")) {
            ipChange.ipc$dispatch("893816001", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mGrades = i;
        }
    }

    public void setmImages(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149980316")) {
            ipChange.ipc$dispatch("-149980316", new Object[]{this, arrayList});
        } else {
            this.mImages = arrayList;
        }
    }

    public void setmIpId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007431002")) {
            ipChange.ipc$dispatch("-2007431002", new Object[]{this, str});
        } else {
            this.mIpId = str;
        }
    }

    public void setmIssueFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377776301")) {
            ipChange.ipc$dispatch("-1377776301", new Object[]{this, str});
        } else {
            this.mIssueFrom = str;
        }
    }

    public void setmIssueType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493637693")) {
            ipChange.ipc$dispatch("-493637693", new Object[]{this, str});
        } else {
            this.mIssueType = str;
        }
    }

    public void setmItemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232818938")) {
            ipChange.ipc$dispatch("1232818938", new Object[]{this, str});
        } else {
            this.mItemId = str;
        }
    }

    public void setmProjectName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271172370")) {
            ipChange.ipc$dispatch("1271172370", new Object[]{this, str});
        } else {
            this.mProjectName = str;
        }
    }

    public void setmProjectPoster(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1775665168")) {
            ipChange.ipc$dispatch("1775665168", new Object[]{this, str});
        } else {
            this.mProjectPoster = str;
        }
    }

    public void setmSelectImages(ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534266944")) {
            ipChange.ipc$dispatch("1534266944", new Object[]{this, arrayList});
        } else {
            this.mSelectImages = arrayList;
        }
    }

    public void setmTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322232196")) {
            ipChange.ipc$dispatch("-322232196", new Object[]{this, str});
        } else {
            this.mTargetId = str;
        }
    }

    public void setmTargetType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793979325")) {
            ipChange.ipc$dispatch("793979325", new Object[]{this, str});
        } else {
            this.mTargetType = str;
        }
    }

    public void updateDetailInfoView(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210073984")) {
            ipChange.ipc$dispatch("210073984", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean != null) {
            if (commentsItemBean.getTextDOList() != null && commentsItemBean.getTextDOList().size() > 0 && commentsItemBean.getTextDOList().get(0) != null) {
                this.mEditorContent = commentsItemBean.getTextDOList().get(0).getValue();
            }
            ArrayList<String> d = CommentItemMoreUtil.d(commentsItemBean.getImageDOList());
            if (wh2.e(d) > 0) {
                this.mImages.clear();
                this.mSelectImages.clear();
                this.mImages.addAll(d);
                for (int i = 0; i < wh2.e(this.mImages); i++) {
                    this.mSelectImages.add(new Image(this.mImages.get(i), ((int) System.currentTimeMillis()) / 1000, (((int) System.currentTimeMillis()) / 1000) + ".jpg", true));
                }
            }
        }
    }
}
