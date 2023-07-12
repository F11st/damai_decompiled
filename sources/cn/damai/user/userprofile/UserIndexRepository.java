package cn.damai.user.userprofile;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.user.common.SingleLiveEvent;
import cn.damai.user.userprofile.bean.FeedsData;
import cn.damai.user.userprofile.bean.FeedsRequest;
import cn.damai.user.userprofile.bean.FeedsResponse;
import cn.damai.user.userprofile.bean.MyCommentRequest;
import cn.damai.user.userprofile.bean.UserData;
import cn.damai.user.userprofile.bean.UserInfoRerquest;
import cn.damai.user.userprofile.bean.UserResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UserIndexRepository {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String[] c = {"详情", ErrControlViewInfo.TYPE_PROJECT, "圈子", "评价"};
    MutableLiveData<FeedsResponse> a;
    SingleLiveEvent<String> b;

    public UserIndexRepository(Context context) {
    }

    private List<String> c(int... iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858148435")) {
            return (List) ipChange.ipc$dispatch("-858148435", new Object[]{this, iArr});
        }
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            String[] strArr = c;
            if (i < strArr.length) {
                arrayList.add(strArr[i]);
            }
        }
        return arrayList;
    }

    public MutableLiveData<FeedsResponse> a(FeedsRequest feedsRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061089319")) {
            return (MutableLiveData) ipChange.ipc$dispatch("1061089319", new Object[]{this, feedsRequest});
        }
        if (this.a == null) {
            this.a = new MutableLiveData<>();
        }
        feedsRequest.request(new DMMtopRequestListener<FeedsData>(FeedsData.class) { // from class: cn.damai.user.userprofile.UserIndexRepository.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2137922873")) {
                    ipChange2.ipc$dispatch("2137922873", new Object[]{this, str, str2});
                    return;
                }
                FeedsResponse feedsResponse = new FeedsResponse();
                feedsResponse.errorCode = str;
                feedsResponse.errorMsg = str2;
                UserIndexRepository.this.a.setValue(feedsResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FeedsData feedsData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1513078489")) {
                    ipChange2.ipc$dispatch("1513078489", new Object[]{this, feedsData});
                    return;
                }
                FeedsResponse feedsResponse = new FeedsResponse();
                feedsResponse.data = feedsData;
                UserIndexRepository.this.a.setValue(feedsResponse);
            }
        });
        return this.a;
    }

    public SingleLiveEvent<String> b(MyCommentRequest myCommentRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86387985")) {
            return (SingleLiveEvent) ipChange.ipc$dispatch("86387985", new Object[]{this, myCommentRequest});
        }
        if (this.b == null) {
            this.b = new SingleLiveEvent<>();
        }
        myCommentRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) { // from class: cn.damai.user.userprofile.UserIndexRepository.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2130163514")) {
                    ipChange2.ipc$dispatch("2130163514", new Object[]{this, str, str2});
                } else {
                    UserIndexRepository.this.b.call();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CommentsResultBean commentsResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "266178557")) {
                    ipChange2.ipc$dispatch("266178557", new Object[]{this, commentsResultBean});
                } else if (commentsResultBean != null && commentsResultBean.getData() != null && commentsResultBean.getData().size() > 0 && commentsResultBean.getData().get(0) != null) {
                    UserIndexRepository.this.b.setValue(commentsResultBean.getData().get(0).getUrl());
                } else {
                    UserIndexRepository.this.b.call();
                }
            }
        });
        return this.b;
    }

    public List<String> d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22889227")) {
            return (List) ipChange.ipc$dispatch("-22889227", new Object[]{this, Integer.valueOf(i)});
        }
        if (i != 1) {
            return i != 5 ? c(1, 2) : c(0, 2, 3);
        }
        return c(2);
    }

    public MutableLiveData<UserResponse> e(UserInfoRerquest userInfoRerquest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196430853")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-196430853", new Object[]{this, userInfoRerquest});
        }
        final MutableLiveData<UserResponse> mutableLiveData = new MutableLiveData<>();
        userInfoRerquest.request(new DMMtopRequestListener<UserData>(UserData.class) { // from class: cn.damai.user.userprofile.UserIndexRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2145682232")) {
                    ipChange2.ipc$dispatch("2145682232", new Object[]{this, str, str2});
                    return;
                }
                UserResponse userResponse = new UserResponse();
                userResponse.errorCode = str;
                userResponse.errorMsg = str2;
                mutableLiveData.setValue(userResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(UserData userData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "768486722")) {
                    ipChange2.ipc$dispatch("768486722", new Object[]{this, userData});
                    return;
                }
                UserResponse userResponse = new UserResponse();
                userResponse.data = userData;
                mutableLiveData.setValue(userResponse);
            }
        });
        return mutableLiveData;
    }
}
