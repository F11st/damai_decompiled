package com.alibaba.pictures.abtest.request;

import com.alibaba.pictures.abtest.model.ABTestExperiment;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/alibaba/pictures/abtest/request/ABTestUploadRequest;", "Lcom/alibaba/pictures/request/BaseRequest;", "Lcom/alibaba/pictures/abtest/model/ABTestExperiment;", "", "scenario", "Ljava/lang/String;", "getScenario", "()Ljava/lang/String;", "setScenario", "(Ljava/lang/String;)V", "abUploadInfo", "getAbUploadInfo", "setAbUploadInfo", "<init>", "()V", "abTest_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class ABTestUploadRequest extends BaseRequest<ABTestExperiment> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String abUploadInfo;
    @Nullable
    private String scenario;

    public ABTestUploadRequest() {
        this.API_NAME = "mtop.film.AbAPI.uploadAb";
        this.VERSION = "1.0";
        this.NEED_ECODE = false;
        this.NEED_SESSION = true;
    }

    @Nullable
    public final String getAbUploadInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-64599343") ? (String) ipChange.ipc$dispatch("-64599343", new Object[]{this}) : this.abUploadInfo;
    }

    @Nullable
    public final String getScenario() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1369409519") ? (String) ipChange.ipc$dispatch("-1369409519", new Object[]{this}) : this.scenario;
    }

    public final void setAbUploadInfo(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604698579")) {
            ipChange.ipc$dispatch("-1604698579", new Object[]{this, str});
        } else {
            this.abUploadInfo = str;
        }
    }

    public final void setScenario(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "615650029")) {
            ipChange.ipc$dispatch("615650029", new Object[]{this, str});
        } else {
            this.scenario = str;
        }
    }
}
