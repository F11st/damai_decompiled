package cn.damai.discover.main.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class FollowStateBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String status;

    public boolean isFollowed() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1113069597") ? ((Boolean) ipChange.ipc$dispatch("-1113069597", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.status) || TextUtils.equals("2", this.status);
    }
}
