package cn.damai.user.userprofile;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class LiveDataResponse extends BaseOutDo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String errorCode;
    public String errorMsg;

    public static LiveDataResponse instance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1525545213") ? (LiveDataResponse) ipChange.ipc$dispatch("-1525545213", new Object[0]) : new LiveDataResponse() { // from class: cn.damai.user.userprofile.LiveDataResponse.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.domain.BaseOutDo
            public Object getData() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2069362715")) {
                    return ipChange2.ipc$dispatch("2069362715", new Object[]{this});
                }
                return null;
            }
        };
    }
}
