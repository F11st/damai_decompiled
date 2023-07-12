package com.alibaba.pictures.abtest.request;

import com.alibaba.pictures.abtest.model.ABTestScenarioResultList;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/alibaba/pictures/abtest/request/ABTestExperimentRequest;", "Lcom/alibaba/pictures/request/BaseRequest;", "Lcom/alibaba/pictures/abtest/model/ABTestScenarioResultList;", "", "", "scenarios", "Ljava/util/List;", "getScenarios", "()Ljava/util/List;", "setScenarios", "(Ljava/util/List;)V", "", "preload", "Ljava/lang/Boolean;", "getPreload", "()Ljava/lang/Boolean;", "setPreload", "(Ljava/lang/Boolean;)V", "<init>", "()V", "abTest_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class ABTestExperimentRequest extends BaseRequest<ABTestScenarioResultList> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean preload;
    @Nullable
    private List<String> scenarios;

    public ABTestExperimentRequest() {
        this.API_NAME = "mtop.film.AbAPI.getMultiScenarioAb";
        this.VERSION = "1.0";
        this.NEED_ECODE = false;
        this.NEED_SESSION = true;
    }

    @Nullable
    public final Boolean getPreload() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-178178941") ? (Boolean) ipChange.ipc$dispatch("-178178941", new Object[]{this}) : this.preload;
    }

    @Nullable
    public final List<String> getScenarios() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1496473125") ? (List) ipChange.ipc$dispatch("-1496473125", new Object[]{this}) : this.scenarios;
    }

    public final void setPreload(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080095877")) {
            ipChange.ipc$dispatch("-1080095877", new Object[]{this, bool});
        } else {
            this.preload = bool;
        }
    }

    public final void setScenarios(@Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "143266537")) {
            ipChange.ipc$dispatch("143266537", new Object[]{this, list});
        } else {
            this.scenarios = list;
        }
    }
}
