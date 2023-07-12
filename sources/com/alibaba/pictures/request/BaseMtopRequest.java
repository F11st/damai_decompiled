package com.alibaba.pictures.request;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import mtopsdk.mtop.domain.MtopRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/alibaba/pictures/request/BaseMtopRequest;", "BizResponse", "Lmtopsdk/mtop/domain/MtopRequest;", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "", "markRequestLabel", "platform", "Ljava/lang/String;", "getPlatform", "()Ljava/lang/String;", "setPlatform", "(Ljava/lang/String;)V", "asac", "getAsac", "setAsac", "tpp_page", "getTpp_page", "setTpp_page", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public class BaseMtopRequest<BizResponse> extends MtopRequest implements DoloresRequest<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String asac;
    @NotNull
    private String platform = "4";
    @Nullable
    private String tpp_page;

    @Nullable
    public final String getAsac() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-965845070") ? (String) ipChange.ipc$dispatch("-965845070", new Object[]{this}) : this.asac;
    }

    @NotNull
    public final String getPlatform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-742249135") ? (String) ipChange.ipc$dispatch("-742249135", new Object[]{this}) : this.platform;
    }

    @Nullable
    public final String getTpp_page() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1558355416") ? (String) ipChange.ipc$dispatch("1558355416", new Object[]{this}) : this.tpp_page;
    }

    @Override // com.alibaba.pictures.dolores.request.DoloresRequest
    @NotNull
    public String markRequestLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1082771424") ? (String) ipChange.ipc$dispatch("1082771424", new Object[]{this}) : "tpp";
    }

    public final void setAsac(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169182868")) {
            ipChange.ipc$dispatch("-169182868", new Object[]{this, str});
        } else {
            this.asac = str;
        }
    }

    public final void setPlatform(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417214547")) {
            ipChange.ipc$dispatch("-1417214547", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.platform = str;
    }

    public final void setTpp_page(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1182049798")) {
            ipChange.ipc$dispatch("1182049798", new Object[]{this, str});
        } else {
            this.tpp_page = str;
        }
    }
}
