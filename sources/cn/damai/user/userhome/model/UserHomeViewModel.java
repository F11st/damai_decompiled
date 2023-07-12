package cn.damai.user.userhome.model;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserHomeViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private UserHomeRepository repository;
    private String userId;

    public UserHomeViewModel(@NonNull Application application) {
        super(application);
        this.repository = new UserHomeRepository();
    }

    private String getParam(String str, String str2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-252423719")) {
            return (String) ipChange.ipc$dispatch("-252423719", new Object[]{this, str, str2, intent});
        }
        if (intent == null || intent.getExtras() == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(str);
        return wh2.j(stringExtra) ? intent.getStringExtra(str2) : stringExtra;
    }

    public String getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "99809183") ? (String) ipChange.ipc$dispatch("99809183", new Object[]{this}) : this.userId;
    }

    public void initParams(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073743444")) {
            ipChange.ipc$dispatch("1073743444", new Object[]{this, intent});
        } else if (intent == null) {
        } else {
            this.userId = getParam("userId", FeedsViewModel.ARG_USERID, intent);
        }
    }

    public void requestMineUserCenterData(DMMtopRequestListener<UserHomeDataBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1560439827")) {
            ipChange.ipc$dispatch("-1560439827", new Object[]{this, dMMtopRequestListener});
        } else {
            this.repository.requestUserCenterData(dMMtopRequestListener, getUserId());
        }
    }
}
