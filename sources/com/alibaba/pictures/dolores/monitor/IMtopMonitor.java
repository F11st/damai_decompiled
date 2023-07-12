package com.alibaba.pictures.dolores.monitor;

import com.ali.user.open.core.util.ParamsConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.bo2;
import tb.dc0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&JD\u0010\f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&JD\u0010\r\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&J0\u0010\u0010\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H&J&\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&J&\u0010\u0015\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u001c\u0010\u0016\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&J2\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u001b"}, d2 = {"Lcom/alibaba/pictures/dolores/monitor/IMtopMonitor;", "", "", "requestClsName", "errorCode", "errorMsg", "requestData", "Ltb/wt2;", "commitRequestError", "apiName", "apiVersion", ParamsConstants.Key.PARAM_TRACE_ID, "mtopResponseFailure", "mtopResponseError", "api", "info", "mtopJsonFailure", "mtopJsonEmpty", "mtopResponseSuccess", "Ltb/bo2;", "timeMonitor", "mtopRequestTime", "mtopLoginCancel", "BizResponse", "Ltb/dc0;", "response", "mtopRequestAndResponse", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IMtopMonitor {
    void commitRequestError(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);

    void mtopJsonEmpty(@Nullable String str, @Nullable Object obj);

    void mtopJsonFailure(@Nullable String str, @Nullable String str2, @Nullable Object obj, @Nullable String str3);

    void mtopLoginCancel(@Nullable String str, @Nullable String str2);

    <BizResponse> void mtopRequestAndResponse(@Nullable String str, @Nullable dc0<BizResponse> dc0Var, @Nullable String str2);

    void mtopRequestTime(@Nullable String str, @Nullable String str2, @Nullable bo2 bo2Var);

    void mtopResponseError(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6);

    void mtopResponseFailure(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6);

    void mtopResponseSuccess(@Nullable String str, @Nullable String str2, @Nullable String str3);
}
