package com.alient.onearch.adapter.monitor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/alient/onearch/adapter/monitor/MonitorConstant;", "", "", "SAMPLING", "I", "", "COMPONENT_RENDER_ERROR", "Ljava/lang/String;", "COROUTINE_RUN_FAILED", "CMS_VIEW_HOLDER_POSITION_ERROR", "CMS_LAYOUT_CHILDREN_ERROR", "SAVE_STATE_DATA_ERROR", "getSAVE_STATE_DATA_ERROR", "()Ljava/lang/String;", "setSAVE_STATE_DATA_ERROR", "(Ljava/lang/String;)V", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class MonitorConstant {
    @NotNull
    public static final String CMS_LAYOUT_CHILDREN_ERROR = "2300002";
    @NotNull
    public static final String CMS_VIEW_HOLDER_POSITION_ERROR = "1990000";
    @NotNull
    public static final String COMPONENT_RENDER_ERROR = "1930001";
    @NotNull
    public static final String COROUTINE_RUN_FAILED = "1930002";
    public static final int SAMPLING = 10000;
    @NotNull
    public static final MonitorConstant INSTANCE = new MonitorConstant();
    @NotNull
    private static String SAVE_STATE_DATA_ERROR = "1810001";

    private MonitorConstant() {
    }

    @NotNull
    public final String getSAVE_STATE_DATA_ERROR() {
        return SAVE_STATE_DATA_ERROR;
    }

    public final void setSAVE_STATE_DATA_ERROR(@NotNull String str) {
        b41.i(str, "<set-?>");
        SAVE_STATE_DATA_ERROR = str;
    }
}
