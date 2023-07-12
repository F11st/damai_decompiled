package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class LiveDataCommonResponse extends BaseOutDo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String errorCode;
    public String errorMsg;

    public static LiveDataCommonResponse instance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1910253209") ? (LiveDataCommonResponse) ipChange.ipc$dispatch("1910253209", new Object[0]) : new LiveDataCommonResponse() { // from class: cn.damai.issue.net.LiveDataCommonResponse.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.domain.BaseOutDo
            public Object getData() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-88895529")) {
                    return ipChange2.ipc$dispatch("-88895529", new Object[]{this});
                }
                return null;
            }
        };
    }
}
