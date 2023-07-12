package tb;

import cn.damai.tool2.bufferkit.BufferListener;
import cn.damai.tool2.bufferkit.BufferRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class nx1<T> implements BufferRequest<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final BufferRequest<T> a;

    public nx1(BufferRequest<T> bufferRequest) {
        this.a = bufferRequest;
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264596563")) {
            ipChange.ipc$dispatch("-1264596563", new Object[]{this});
            return;
        }
        try {
            BufferRequest<T> bufferRequest = this.a;
            if (bufferRequest != null) {
                bufferRequest.cancel();
                td.d(this.a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void doRequest(BufferListener<T> bufferListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130634683")) {
            ipChange.ipc$dispatch("-1130634683", new Object[]{this, bufferListener});
        }
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getGroupType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2133156164")) {
            return (String) ipChange.ipc$dispatch("-2133156164", new Object[]{this});
        }
        BufferRequest<T> bufferRequest = this.a;
        if (bufferRequest != null) {
            return bufferRequest.getGroupType();
        }
        return null;
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getUniKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62057086")) {
            return (String) ipChange.ipc$dispatch("-62057086", new Object[]{this});
        }
        BufferRequest<T> bufferRequest = this.a;
        if (bufferRequest != null) {
            return bufferRequest.getUniKey();
        }
        return null;
    }
}
