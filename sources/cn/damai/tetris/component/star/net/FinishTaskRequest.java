package cn.damai.tetris.component.star.net;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FinishTaskRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private String FinishTaskApi = "mtop.damai.wireless.play.imkt.task.data.report";
    private String FinishTaskVersion = "1.0";
    public String dataId;
    public String taskId;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1906498341") ? (String) ipChange.ipc$dispatch("1906498341", new Object[]{this}) : this.FinishTaskApi;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215276120")) {
            return ((Boolean) ipChange.ipc$dispatch("-1215276120", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565645348")) {
            return ((Boolean) ipChange.ipc$dispatch("1565645348", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-220732232") ? (String) ipChange.ipc$dispatch("-220732232", new Object[]{this}) : this.FinishTaskVersion;
    }
}
