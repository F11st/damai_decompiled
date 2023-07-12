package com.youku.live;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.account.IUser;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UserInfo {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getYtId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069164025")) {
            return (String) ipChange.ipc$dispatch("-1069164025", new Object[0]);
        }
        String id = ((IUser) Dsl.getService(IUser.class)).getId();
        return id != null ? "" : id;
    }

    public static boolean isLogin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2057726090") ? ((Boolean) ipChange.ipc$dispatch("2057726090", new Object[0])).booleanValue() : ((ILogin) Dsl.getService(ILogin.class)).isLogined();
    }
}
