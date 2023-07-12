package cn.damai.user.userprofile;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.commonbusiness.scriptmurder.coupon.CouponDetailFragment;
import cn.damai.user.common.SingleLiveEvent;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.bean.MyCommentRequest;
import cn.damai.user.userprofile.bean.UserData;
import cn.damai.user.userprofile.bean.UserInfoRerquest;
import cn.damai.user.userprofile.bean.UserResponse;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.iv2;
import tb.l8;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserIndexViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bid;
    public String circleId;
    public String circleName;
    private final SingleLiveEvent<Integer> clickEvent;
    public String couponId;
    public boolean followLottery;
    public boolean hidingState;
    public SingleLiveEvent<String> myCommentUrl;
    public String pageName;
    String preDescribe;
    public String proId;
    UserIndexRepository repository;
    boolean showCircle;
    public boolean showComment;
    public boolean showPublish;
    public String sinapath;
    MutableLiveData<UserResponse> userInfo;
    public String userid;
    public String usertype;
    public String vanueAddress;

    public UserIndexViewModel(@NonNull Application application) {
        super(application);
        this.showComment = false;
        this.clickEvent = new SingleLiveEvent<>();
        this.showPublish = false;
        this.hidingState = false;
        this.pageName = iv2.USER_HOME_PAGE;
        this.followLottery = false;
        this.repository = new UserIndexRepository(application.getApplicationContext());
    }

    private String getParam(String str, String str2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231406426")) {
            return (String) ipChange.ipc$dispatch("1231406426", new Object[]{this, str, str2, intent});
        }
        if (intent == null || intent.getExtras() == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(str);
        return wh2.j(stringExtra) ? intent.getStringExtra(str2) : stringExtra;
    }

    public SingleLiveEvent<Integer> getClickEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-64814076") ? (SingleLiveEvent) ipChange.ipc$dispatch("-64814076", new Object[]{this}) : this.clickEvent;
    }

    public SingleLiveEvent<String> getMyCommentUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255340590")) {
            return (SingleLiveEvent) ipChange.ipc$dispatch("1255340590", new Object[]{this});
        }
        MyCommentRequest myCommentRequest = new MyCommentRequest();
        myCommentRequest.ipId = this.userid;
        try {
            myCommentRequest.publisherId = Long.parseLong(z20.i());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        SingleLiveEvent<String> b = this.repository.b(myCommentRequest);
        if (this.myCommentUrl == null) {
            this.myCommentUrl = b;
        }
        return this.myCommentUrl;
    }

    public String getPreDescribe() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1018649036") ? (String) ipChange.ipc$dispatch("1018649036", new Object[]{this}) : this.preDescribe;
    }

    public List<String> getTabs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847859805")) {
            return (List) ipChange.ipc$dispatch("847859805", new Object[]{this});
        }
        if (getUserInfoValue() == null) {
            return this.repository.d(1);
        }
        return this.repository.d(getUserInfoValue().type);
    }

    public String getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "38470846") ? (String) ipChange.ipc$dispatch("38470846", new Object[]{this}) : this.userid;
    }

    public UserData getUserInfoValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252366337")) {
            return (UserData) ipChange.ipc$dispatch("252366337", new Object[]{this});
        }
        MutableLiveData<UserResponse> mutableLiveData = this.userInfo;
        if (mutableLiveData == null || mutableLiveData.getValue() == null || this.userInfo.getValue().data == null) {
            return null;
        }
        return this.userInfo.getValue().data;
    }

    public long getUserType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792277609")) {
            return ((Long) ipChange.ipc$dispatch("-1792277609", new Object[]{this})).longValue();
        }
        try {
            if (TextUtils.isEmpty(this.usertype)) {
                return 1L;
            }
            return Long.parseLong(this.usertype);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 1L;
        }
    }

    public Map getUtArgs() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1014427711")) {
            return (Map) ipChange.ipc$dispatch("-1014427711", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", this.userid);
        hashMap.put("biz_type", this.usertype);
        return hashMap;
    }

    public boolean initParams(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-767261577")) {
            return ((Boolean) ipChange.ipc$dispatch("-767261577", new Object[]{this, intent})).booleanValue();
        }
        if (intent == null) {
            return false;
        }
        this.showCircle = intent.getBooleanExtra("circle", false);
        this.showComment = intent.getBooleanExtra("comment", false);
        this.userid = getParam(FeedsViewModel.ARG_USERID, "userId", intent);
        this.proId = intent.getStringExtra("projectId");
        this.usertype = getParam("usertype", RepertoireDetailFragment.USERTYPE, intent);
        this.vanueAddress = intent.getStringExtra(ILocatable.ADDRESS);
        this.followLottery = intent.getBooleanExtra("followLottery", false);
        this.couponId = intent.getStringExtra(CouponDetailFragment.COUPON_ID);
        if (wh2.j(this.userid)) {
            String param = getParam("brandid", "brandId", intent);
            this.userid = param;
            if (!wh2.j(param)) {
                this.usertype = "4";
            } else {
                String param2 = getParam("artistid", l8.KEY_ARTIST_ID, intent);
                this.userid = param2;
                if (!wh2.j(param2)) {
                    this.usertype = "2";
                } else {
                    String stringExtra = intent.getStringExtra(RepertoireDetailFragment.REPERTOIREID);
                    this.userid = stringExtra;
                    if (!wh2.j(stringExtra)) {
                        this.usertype = "5";
                    }
                }
            }
        }
        return true;
    }

    public boolean isShowCircle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1879381735") ? ((Boolean) ipChange.ipc$dispatch("-1879381735", new Object[]{this})).booleanValue() : this.showCircle;
    }

    public MutableLiveData<UserResponse> requestUserInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165117438")) {
            return (MutableLiveData) ipChange.ipc$dispatch("165117438", new Object[]{this});
        }
        UserInfoRerquest userInfoRerquest = new UserInfoRerquest();
        userInfoRerquest.targetId = getUserId();
        userInfoRerquest.targetType = getUserType();
        MutableLiveData<UserResponse> e = this.repository.e(userInfoRerquest);
        if (this.userInfo == null) {
            this.userInfo = e;
        }
        return this.userInfo;
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369795503")) {
            ipChange.ipc$dispatch("1369795503", new Object[]{this});
        } else {
            this.userInfo = null;
        }
    }

    public void setPreDescribe(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-786602198")) {
            ipChange.ipc$dispatch("-786602198", new Object[]{this, str});
        } else {
            this.preDescribe = str;
        }
    }

    public void setShowCircle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492213531")) {
            ipChange.ipc$dispatch("-1492213531", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.showCircle = z;
        }
    }

    public void setShowComment(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088640632")) {
            ipChange.ipc$dispatch("-1088640632", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.showComment = z;
        }
    }
}
