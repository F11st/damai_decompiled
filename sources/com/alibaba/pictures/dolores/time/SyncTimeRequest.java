package com.alibaba.pictures.dolores.time;

import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.playerservice.axp.playinfo.Point;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.jn1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/dolores/time/SyncTimeRequest;", "Lcom/alibaba/pictures/request/BaseRequest;", "Lcom/alibaba/pictures/dolores/time/SyncTimeResponse;", "", "markRequestLabel", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class SyncTimeRequest extends BaseRequest<SyncTimeResponse> {
    private static transient /* synthetic */ IpChange $ipChange;

    public SyncTimeRequest() {
        this.API_NAME = "mtop.common.getTimestamp";
        this.VERSION = jn1.MUL;
        this.NEED_ECODE = false;
        this.NEED_SESSION = false;
    }

    @Override // com.alibaba.pictures.request.BaseRequest, com.alibaba.pictures.dolores.request.DoloresRequest
    @NotNull
    public String markRequestLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1884937862") ? (String) ipChange.ipc$dispatch("-1884937862", new Object[]{this}) : Point.STANDARD;
    }
}
