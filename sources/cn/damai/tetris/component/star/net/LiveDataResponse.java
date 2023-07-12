package cn.damai.tetris.component.star.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class LiveDataResponse extends BaseOutDo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String errorCode;
    public String errorMsg;

    public static LiveDataResponse instance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "638059353") ? (LiveDataResponse) ipChange.ipc$dispatch("638059353", new Object[0]) : new LiveDataResponse() { // from class: cn.damai.tetris.component.star.net.LiveDataResponse.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.domain.BaseOutDo
            public Object getData() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2062454059")) {
                    return ipChange2.ipc$dispatch("2062454059", new Object[]{this});
                }
                return null;
            }
        };
    }
}
