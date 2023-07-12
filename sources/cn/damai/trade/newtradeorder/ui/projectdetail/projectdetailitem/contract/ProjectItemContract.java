package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.contract;

import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectInformationBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectRecommendListBean;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ProjectItemContract {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static abstract class Presenter extends AbstractC0470a<View, Model> {
        public abstract void getProjectDetailData(int i, String str);

        public abstract void getProjectDetailDiscussion(long j, long j2, String str);

        public abstract void getProjectDetailEvaluates(long j, long j2, String str, int i, int i2, int i3, int i4, boolean z, String str2);

        public abstract void getProjectNATData(String str);

        public abstract void getRecommendProjectList(String str, String str2, double d, double d2, int i, int i2, String str3, boolean z, int i3);

        public abstract void getSubProjectDetailCheckData(String str, String str2);

        public abstract void updateProjectFollowRelation(int i, long j, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface View extends BaseDamaiView {
        void onPraiseViewOnClick(CommentsItemBean commentsItemBean);

        void onRetrieveDiscussionError(String str, String str2);

        void onRetrieveDiscussionSuccess(ProjectDetailCommentBean projectDetailCommentBean);

        void onReturnProjectDetailCommentError(String str, String str2);

        void onReturnProjectDetailCommentSuccess(ProjectDetailCommentBean projectDetailCommentBean);

        void onReturnProjectDetailDataSuccess(int i, ProjectDetailDataBean projectDetailDataBean);

        void onReturnProjectNATDataFail(String str, String str2);

        void onReturnProjectNATDataSuccess(ProjectInformationBean projectInformationBean);

        void onReturnProjectRecommendError(String str, String str2);

        void onReturnProjectRecommendSuccess(ProjectRecommendListBean projectRecommendListBean);

        void onReturnSkuBeanDataFail(String str, String str2);

        void onReturnSkuBeanDataSuccess(SkuBean skuBean);

        void onUpdateProjectFollowStatusError(String str, String str2);

        void onUpdateProjectFollowStatusSuccess(FollowDataBean followDataBean);
    }
}
