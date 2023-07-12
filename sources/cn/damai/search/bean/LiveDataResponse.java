package cn.damai.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class LiveDataResponse extends BaseOutDo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String errorCode;
    public String errorMsg;
    public boolean requestFail;

    public static LiveDataResponse instance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2050034119") ? (LiveDataResponse) ipChange.ipc$dispatch("-2050034119", new Object[0]) : new LiveDataResponse() { // from class: cn.damai.search.bean.LiveDataResponse.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.domain.BaseOutDo
            public Object getData() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "108360828")) {
                    return ipChange2.ipc$dispatch("108360828", new Object[]{this});
                }
                return null;
            }
        };
    }
}
