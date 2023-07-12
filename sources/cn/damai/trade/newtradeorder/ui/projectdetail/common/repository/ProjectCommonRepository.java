package cn.damai.trade.newtradeorder.ui.projectdetail.common.repository;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.ProjectDetailCommentBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ProjectRecommendResultBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.DiscussionRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.EvaluatesRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.request.RecommendRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.w12;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectCommonRepository implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;

    public void retrieveDiscussions(long j, long j2, String str, int i, int i2, int i3, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242240253")) {
            ipChange.ipc$dispatch("1242240253", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), w12Var});
            return;
        }
        DiscussionRequest discussionRequest = new DiscussionRequest();
        discussionRequest.itemId = j;
        discussionRequest.categoryId = j2;
        discussionRequest.ipId = str;
        discussionRequest.moduleType = i;
        discussionRequest.pageIndex = i2;
        discussionRequest.pageSize = i3;
        discussionRequest.request(new DMMtopRequestListener<ProjectDetailCommentBean>(ProjectDetailCommentBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "955174300")) {
                    ipChange2.ipc$dispatch("955174300", new Object[]{this, str2, str3});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.a(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "506312113")) {
                    ipChange2.ipc$dispatch("506312113", new Object[]{this, projectDetailCommentBean});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.b(projectDetailCommentBean);
                }
            }
        });
    }

    public void retrieveEvaluates(long j, long j2, String str, int i, int i2, int i3, int i4, boolean z, String str2, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965106855")) {
            ipChange.ipc$dispatch("965106855", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), str2, w12Var});
            return;
        }
        EvaluatesRequest evaluatesRequest = new EvaluatesRequest();
        evaluatesRequest.itemId = j;
        evaluatesRequest.categoryId = j2;
        evaluatesRequest.ipId = str;
        evaluatesRequest.moduleType = i;
        evaluatesRequest.commentType = i2;
        evaluatesRequest.pageIndex = i3;
        evaluatesRequest.pageSize = i4;
        evaluatesRequest.isQueryHotComment = z;
        evaluatesRequest.tourId = str2;
        evaluatesRequest.request(new DMMtopRequestListener<ProjectDetailCommentBean>(ProjectDetailCommentBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "962933659")) {
                    ipChange2.ipc$dispatch("962933659", new Object[]{this, str3, str4});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.a(str3, str4);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectDetailCommentBean projectDetailCommentBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "948066608")) {
                    ipChange2.ipc$dispatch("948066608", new Object[]{this, projectDetailCommentBean});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.b(projectDetailCommentBean);
                }
            }
        });
    }

    public void retrieveRecommendProject(String str, String str2, double d, double d2, int i, int i2, String str3, boolean z, int i3, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428281549")) {
            ipChange.ipc$dispatch("-428281549", new Object[]{this, str, str2, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), str3, Boolean.valueOf(z), Integer.valueOf(i3), w12Var});
            return;
        }
        RecommendRequest recommendRequest = new RecommendRequest();
        recommendRequest.userId = str;
        recommendRequest.cityId = str2;
        recommendRequest.longitude = d;
        recommendRequest.latitude = d2;
        recommendRequest.pageIndex = i;
        recommendRequest.pageSize = i2;
        recommendRequest.projectIdList = str3;
        recommendRequest.returnDefault = z;
        recommendRequest.type = i3;
        recommendRequest.request(new DMMtopRequestListener<ProjectRecommendResultBean.ProjectRecommendDataBean>(ProjectRecommendResultBean.ProjectRecommendDataBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "970693018")) {
                    ipChange2.ipc$dispatch("970693018", new Object[]{this, str4, str5});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.a(str4, str5);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(ProjectRecommendResultBean.ProjectRecommendDataBean projectRecommendDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1020246243")) {
                    ipChange2.ipc$dispatch("-1020246243", new Object[]{this, projectRecommendDataBean});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.b(projectRecommendDataBean);
                }
            }
        });
    }

    public void updateFollowRelation(int i, long j, int i2, final w12 w12Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263817811")) {
            ipChange.ipc$dispatch("-263817811", new Object[]{this, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), w12Var});
            return;
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = String.valueOf(i);
        followRequest.targetId = String.valueOf(j);
        followRequest.targetType = String.valueOf(i2);
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.common.repository.ProjectCommonRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "978452377")) {
                    ipChange2.ipc$dispatch("978452377", new Object[]{this, str, str2});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.a(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1537668441")) {
                    ipChange2.ipc$dispatch("-1537668441", new Object[]{this, followDataBean});
                    return;
                }
                w12 w12Var2 = w12Var;
                if (w12Var2 != null) {
                    w12Var2.b(followDataBean);
                }
            }
        });
    }
}
