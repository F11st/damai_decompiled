package cn.damai.h5container.action;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UpdateVersionRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String API_NAME;
    public String dexcode;
    public boolean isYunos;
    public List<String> updateTypes;
    public String VERSION = "1.0";
    public String model = null;
    public String locale = null;
    public String md5Sum = null;
    public String city = null;
    public long patchVersion = 0;
    public long dexpatchVersion = 0;
    public long apiLevel = 0;
    public String appVersion = null;
    public String brand = null;
    public String identifier = null;

    public UpdateVersionRequest(boolean z) {
        this.API_NAME = "mtop.client.mudp.update";
        if (z) {
            this.API_NAME = "mtop.client.mudp.update.outer";
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-974090057") ? (String) ipChange.ipc$dispatch("-974090057", new Object[]{this}) : this.API_NAME;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189500330")) {
            return ((Boolean) ipChange.ipc$dispatch("-189500330", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506298542")) {
            return ((Boolean) ipChange.ipc$dispatch("-506298542", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1193646666") ? (String) ipChange.ipc$dispatch("1193646666", new Object[]{this}) : this.VERSION;
    }
}
