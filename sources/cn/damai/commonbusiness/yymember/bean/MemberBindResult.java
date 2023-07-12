package cn.damai.commonbusiness.yymember.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MemberBindResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String returnCode;
    public String returnMessage;
    public ReturnValue returnValue;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ReturnValue implements Serializable {
        public String dmHavanaId;
        public String tbUserId;
    }

    public boolean isSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1902892615") ? ((Boolean) ipChange.ipc$dispatch("-1902892615", new Object[]{this})).booleanValue() : TextUtils.equals("0", this.returnCode);
    }
}
