package cn.damai.evaluate.presenter;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.comment.bean.CommentPerformInfoBean;
import cn.damai.comment.bean.CommentProjectInfoBean;
import cn.damai.comment.bean.CommentRepertoireInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.bean.EvaluateParams;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.evaluate.contract.EvaluateListContract;
import cn.damai.evaluate.request.CommentListHeaderRequest;
import cn.damai.evaluate.request.CommentListRequest;
import cn.damai.evaluate.ui.EvaluateListFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.al;
import tb.cl;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class EvaluateListPresenter extends EvaluateListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private int commentItemPosition;
    private String contentLabelId;
    private String contentLabelList;
    private boolean isLoadCompleted;
    private boolean isLoading;
    private int mFromWhere;
    private String mIpId;
    private long mItemId;
    private boolean openQueryStoreInfo;
    private CommentPerformInfoBean performInfo;
    private CommentProjectInfoBean projectInfoBean;
    private CommentRepertoireInfoBean repertoireInfo;
    @Nullable
    private String scriptId;
    @Nullable
    private String storeId;
    private String tourId;
    @Nullable
    private String venueId;
    private int pageIndex = 1;
    private List<CommentsItemBean> currentCommentsItemBeans = new ArrayList();

    private void getData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1742897474")) {
            ipChange.ipc$dispatch("-1742897474", new Object[]{this});
            return;
        }
        this.isLoading = true;
        ((EvaluateListContract.View) this.mView).showLoading("");
        CommentListRequest commentListRequest = new CommentListRequest();
        commentListRequest.targetType = String.valueOf(0);
        commentListRequest.pageIndex = String.valueOf(this.pageIndex);
        commentListRequest.isQueryContent = true;
        if (this.mFromWhere == EvaluateListFragment.EVALUATELIST_ALLREADY) {
            commentListRequest.myself = true;
            commentListRequest.isQueryAppend = "true";
            commentListRequest.commentTypes = "[32,62,65]";
            commentListRequest.isQueryContentTargetInfo = true;
            commentListRequest.sort = "1";
            commentListRequest.dataModule = "4";
            commentListRequest.queryUploadFlag = "query_upload_video";
        } else {
            commentListRequest.commentTypes = "[32,62,65,66]";
            commentListRequest.itemId = String.valueOf(this.mItemId);
            if (!TextUtils.isEmpty(this.mIpId)) {
                commentListRequest.ipId = this.mIpId;
            }
            commentListRequest.venueId = this.venueId;
            commentListRequest.storeId = this.storeId;
            commentListRequest.scriptId = this.scriptId;
            if (this.openQueryStoreInfo) {
                commentListRequest.queryStoreInfo = "1";
            }
            commentListRequest.isQueryProjectInfo = "true";
            commentListRequest.isQueryIpInfo = "true";
            commentListRequest.isQueryHotComment = "true";
            commentListRequest.isQueryCommentEntry = true;
            commentListRequest.dataModule = "1";
            if (!TextUtils.isEmpty(this.tourId)) {
                commentListRequest.tourId = this.tourId;
            }
            if (this.mFromWhere == EvaluateListFragment.EVALUATELIST_REPERTOIRE) {
                commentListRequest.isQueryGradeStat = false;
                commentListRequest.isShowContentLabel = false;
            } else {
                commentListRequest.isQueryGradeStat = true;
                commentListRequest.isShowContentLabel = true;
                commentListRequest.contentLabelList = this.contentLabelList;
                commentListRequest.contentLabelId = this.contentLabelId;
            }
            commentListRequest.sort = "2";
        }
        commentListRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) { // from class: cn.damai.evaluate.presenter.EvaluateListPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1870804080")) {
                    ipChange2.ipc$dispatch("-1870804080", new Object[]{this, str, str2});
                    return;
                }
                ((EvaluateListContract.View) EvaluateListPresenter.this.mView).stopLoading();
                EvaluateListPresenter.this.returnCommentsListError(str, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CommentsResultBean commentsResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "580516967")) {
                    ipChange2.ipc$dispatch("580516967", new Object[]{this, commentsResultBean});
                    return;
                }
                ((EvaluateListContract.View) EvaluateListPresenter.this.mView).stopLoading();
                EvaluateListPresenter.this.returnCommentsList(commentsResultBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnCommentsList(CommentsResultBean commentsResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "614484420")) {
            ipChange.ipc$dispatch("614484420", new Object[]{this, commentsResultBean});
            return;
        }
        this.isLoading = false;
        ((EvaluateListContract.View) this.mView).stopRefreshing();
        if (this.pageIndex == 1) {
            this.projectInfoBean = commentsResultBean.getProjectInfo();
            this.repertoireInfo = commentsResultBean.getRepertoireInfo();
            CommentPerformInfoBean performInfo = commentsResultBean.getPerformInfo();
            this.performInfo = performInfo;
            ((EvaluateListContract.View) this.mView).showEntryView(performInfo);
            ((EvaluateListContract.View) this.mView).setCommentHeaderLabel(commentsResultBean);
            CommentListHeaderRequest commentListHeaderRequest = new CommentListHeaderRequest();
            commentListHeaderRequest.itemId = String.valueOf(this.mItemId);
            String str = this.storeId;
            commentListHeaderRequest.storeId = str;
            commentListHeaderRequest.venueId = this.venueId;
            commentListHeaderRequest.scriptId = this.scriptId;
            if (this.openQueryStoreInfo) {
                commentListHeaderRequest.queryStoreInfo = "1";
            }
            if (this.mItemId <= 0 && TextUtils.isEmpty(str) && TextUtils.isEmpty(this.venueId) && TextUtils.isEmpty(this.scriptId)) {
                ((EvaluateListContract.View) this.mView).refreshCommentStateScoreHeader(new CommentsResultBean(), 0);
            } else {
                commentListHeaderRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) { // from class: cn.damai.evaluate.presenter.EvaluateListPresenter.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                    public void onFail(String str2, String str3) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1878563439")) {
                            ipChange2.ipc$dispatch("-1878563439", new Object[]{this, str2, str3});
                        } else {
                            ((EvaluateListContract.View) EvaluateListPresenter.this.mView).refreshCommentStateScoreHeader(new CommentsResultBean(), 0);
                        }
                    }

                    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                    public void onSuccess(CommentsResultBean commentsResultBean2) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1350102138")) {
                            ipChange2.ipc$dispatch("-1350102138", new Object[]{this, commentsResultBean2});
                        } else if (!TextUtils.isEmpty(EvaluateListPresenter.this.storeId) && TextUtils.isEmpty(EvaluateListPresenter.this.scriptId)) {
                            ((EvaluateListContract.View) EvaluateListPresenter.this.mView).refreshCommentStateScoreHeader(commentsResultBean2, 2);
                        } else {
                            ((EvaluateListContract.View) EvaluateListPresenter.this.mView).refreshCommentStateScoreHeader(commentsResultBean2, 1);
                        }
                    }
                });
            }
        }
        if (commentsResultBean != null) {
            List<CommentsItemBean> data = commentsResultBean.getData();
            if (this.pageIndex == 1) {
                this.currentCommentsItemBeans.clear();
                ArrayList arrayList = new ArrayList();
                if (wh2.e(data) > 0) {
                    this.currentCommentsItemBeans.addAll(data);
                    arrayList.addAll(updateCommentList(false, data));
                }
                if (arrayList.size() > 0) {
                    ((EvaluateListContract.View) this.mView).hideEmptyView();
                } else {
                    ((EvaluateListContract.View) this.mView).showEmptyView();
                }
                if (this.commentItemPosition + 1 >= commentsResultBean.getTotal() && arrayList.size() != 0) {
                    arrayList.add(new al(2));
                    this.isLoadCompleted = true;
                }
                ((EvaluateListContract.View) this.mView).updateData(arrayList);
            } else if (wh2.e(data) > 0) {
                this.currentCommentsItemBeans.addAll(data);
                ((EvaluateListContract.View) this.mView).hideEmptyView();
                List<al> updateCommentList = updateCommentList(false, data);
                if (this.commentItemPosition + 1 >= commentsResultBean.getTotal()) {
                    updateCommentList.add(new al(2));
                    this.isLoadCompleted = true;
                }
                ((EvaluateListContract.View) this.mView).addDataAndRefresh(updateCommentList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnCommentsListError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544864012")) {
            ipChange.ipc$dispatch("544864012", new Object[]{this, str, str2});
            return;
        }
        this.isLoading = false;
        int i = this.pageIndex;
        if (i == 1) {
            ((EvaluateListContract.View) this.mView).stopRefreshing();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            ((EvaluateListContract.View) this.mView).showTip(str, str2);
            return;
        }
        this.pageIndex = i - 1;
        ((EvaluateListContract.View) this.mView).showErrorTips(str2);
    }

    private List<al> updateCommentList(boolean z, List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-911020052")) {
            return (List) ipChange.ipc$dispatch("-911020052", new Object[]{this, Boolean.valueOf(z), list});
        }
        ArrayList arrayList = new ArrayList();
        int e = wh2.e(list);
        for (int i = 0; i < e; i++) {
            CommentsItemBean commentsItemBean = list.get(i);
            al alVar = new al(0);
            alVar.q(commentsItemBean);
            alVar.p(z);
            if (this.mFromWhere == EvaluateListFragment.EVALUATELIST_ALLREADY && commentsItemBean.getTargetDataDO() != null) {
                alVar.v(cl.b(commentsItemBean.getTargetDataDO().getTargetId()));
                alVar.w(commentsItemBean.getTargetDataDO().getTargetImg());
                alVar.x(commentsItemBean.getTargetDataDO().getTargetName());
                alVar.t(commentsItemBean.getTargetDataDO().getTargetCityName());
                alVar.y(commentsItemBean.getTargetDataDO().getTargetShowTime());
                alVar.u(true);
            } else {
                CommentProjectInfoBean commentProjectInfoBean = this.projectInfoBean;
                if (commentProjectInfoBean != null) {
                    alVar.w(commentProjectInfoBean.getProjectPoster());
                    alVar.v(cl.b(this.projectInfoBean.getProjectId()));
                    if (!TextUtils.isEmpty(this.projectInfoBean.getSubTitle())) {
                        alVar.x(this.projectInfoBean.getSubTitle());
                    } else if (!TextUtils.isEmpty(this.projectInfoBean.getProjectName())) {
                        alVar.x(this.projectInfoBean.getProjectName());
                    }
                    alVar.t(this.projectInfoBean.getCityName());
                    alVar.y(this.projectInfoBean.getShowTime());
                }
                CommentRepertoireInfoBean commentRepertoireInfoBean = this.repertoireInfo;
                if (commentRepertoireInfoBean != null) {
                    alVar.v(cl.b(commentRepertoireInfoBean.getRepertoireId()));
                    alVar.w(this.repertoireInfo.getRepertoirePic());
                    alVar.x(this.repertoireInfo.getRepertoireName());
                }
            }
            if (z) {
                alVar.s(i);
            } else {
                int i2 = this.commentItemPosition + 1;
                this.commentItemPosition = i2;
                alVar.s(i2);
            }
            arrayList.add(alVar);
        }
        return arrayList;
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.Presenter
    public void create() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031761296")) {
            ipChange.ipc$dispatch("-2031761296", new Object[]{this});
        }
    }

    public String getContentLabelId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "648518702") ? (String) ipChange.ipc$dispatch("648518702", new Object[]{this}) : this.contentLabelId;
    }

    public String getContentLabelList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1561153073") ? (String) ipChange.ipc$dispatch("1561153073", new Object[]{this}) : this.contentLabelList;
    }

    public CommentPerformInfoBean getPerformInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1811563330") ? (CommentPerformInfoBean) ipChange.ipc$dispatch("-1811563330", new Object[]{this}) : this.performInfo;
    }

    public CommentProjectInfoBean getProjectInfoBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "269814414") ? (CommentProjectInfoBean) ipChange.ipc$dispatch("269814414", new Object[]{this}) : this.projectInfoBean;
    }

    @Nullable
    public String getScriptId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "160147646") ? (String) ipChange.ipc$dispatch("160147646", new Object[]{this}) : this.scriptId;
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.Presenter
    public void initExtras(EvaluateParams evaluateParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "557943573")) {
            ipChange.ipc$dispatch("557943573", new Object[]{this, evaluateParams});
            return;
        }
        this.mItemId = evaluateParams.itemId;
        this.mIpId = evaluateParams.ipId;
        this.tourId = evaluateParams.tourId;
        this.mFromWhere = evaluateParams.fromWhere;
        this.venueId = evaluateParams.venueId;
        this.storeId = evaluateParams.storeId;
        this.scriptId = evaluateParams.scriptId;
        this.openQueryStoreInfo = evaluateParams.openQueryStoreInfo;
    }

    public boolean isProjectSupportWantSee() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889983937")) {
            return ((Boolean) ipChange.ipc$dispatch("-889983937", new Object[]{this})).booleanValue();
        }
        CommentProjectInfoBean commentProjectInfoBean = this.projectInfoBean;
        return (commentProjectInfoBean == null || commentProjectInfoBean.isXiaJia() || this.projectInfoBean.wantSee) ? false : true;
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.Presenter
    public void loadMoreData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288688153")) {
            ipChange.ipc$dispatch("-288688153", new Object[]{this});
        } else if (this.isLoading || this.isLoadCompleted) {
        } else {
            this.pageIndex++;
            getData();
        }
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.Presenter
    public void refresh(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845492544")) {
            ipChange.ipc$dispatch("845492544", new Object[]{this, Integer.valueOf(i)});
        } else if (this.isLoading) {
        } else {
            this.isLoadCompleted = false;
            this.pageIndex = 1;
            this.commentItemPosition = -1;
            if (i == 0) {
                this.contentLabelList = null;
                this.contentLabelId = null;
            }
            getData();
        }
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.Presenter
    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154237025")) {
            ipChange.ipc$dispatch("-154237025", new Object[]{this});
        } else {
            refresh(0);
        }
    }

    public void setContentLabelId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487863440")) {
            ipChange.ipc$dispatch("-487863440", new Object[]{this, str});
        } else {
            this.contentLabelId = str;
        }
    }

    @Override // cn.damai.evaluate.contract.EvaluateListContract.Presenter
    public void setContentLabelList(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20689715")) {
            ipChange.ipc$dispatch("-20689715", new Object[]{this, str});
        } else {
            this.contentLabelList = str;
        }
    }

    public void setScriptId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787281888")) {
            ipChange.ipc$dispatch("787281888", new Object[]{this, str});
        } else {
            this.scriptId = str;
        }
    }
}
