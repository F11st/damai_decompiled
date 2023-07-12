package com.alibaba.pictures.request;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import mtopsdk.mtop.domain.IMTOPDataObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/alibaba/pictures/request/BaseRequest;", "BizResponse", "Lmtopsdk/mtop/domain/IMTOPDataObject;", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "", "markRequestLabel", "platform", "Ljava/lang/String;", "API_NAME", "VERSION", "", "NEED_ECODE", "Z", "NEED_SESSION", "asac", "tpp_page", "Ljava/lang/reflect/Type;", "type", "Ljava/lang/reflect/Type;", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public class BaseRequest<BizResponse> implements IMTOPDataObject, DoloresRequest<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @JvmField
    @Nullable
    public String API_NAME;
    @JvmField
    public boolean NEED_ECODE;
    @JvmField
    public boolean NEED_SESSION;
    @JvmField
    @Nullable
    public String VERSION;
    @JvmField
    @Nullable
    public String asac;
    @JvmField
    @NotNull
    public String platform = "4";
    @JvmField
    @Nullable
    public String tpp_page;
    @JvmField
    @Nullable
    public Type type;

    @NotNull
    public String markRequestLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "782035704") ? (String) ipChange.ipc$dispatch("782035704", new Object[]{this}) : "tpp";
    }
}
