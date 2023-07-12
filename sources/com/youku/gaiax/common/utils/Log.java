package com.youku.gaiax.common.utils;

import android.view.View;
import com.ali.user.open.core.util.ParamsConstants;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.impl.GaiaXContext;
import com.youku.gaiax.impl.utils.PropUtils;
import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ld2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002J\"\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002J\"\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011¨\u0006\u0019"}, d2 = {"Lcom/youku/gaiax/common/utils/Log;", "", "", "tag", "msg", "Ltb/wt2;", "longE", "", ParamsConstants.Key.PARAM_TRACE_ID, "ext", "traceContainer", "Lcom/youku/gaiax/impl/GaiaXContext;", "gxContext", "traceStack", AgooConstants.MESSAGE_TRACE, "d", "e", "", "isLog", "isJSLog", "isLaunchLog", "isMonitorLog", "isTimeLog", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Log {
    @NotNull
    public static final Log INSTANCE = new Log();

    private Log() {
    }

    private final void longE(String str, String str2) {
        int length = str2.length() / 1000;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            int i3 = i * 1000;
            int i4 = i2 * 1000;
            if (i4 > str2.length()) {
                i4 = str2.length();
            }
            String substring = str2.substring(i3, i4);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            android.util.Log.e(str, substring);
            if (i == length) {
                return;
            }
            i = i2;
        }
    }

    public static /* synthetic */ void trace$default(Log log, GaiaXContext gaiaXContext, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        log.trace(gaiaXContext, str, str2);
    }

    public static /* synthetic */ void traceContainer$default(Log log, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        log.traceContainer(i, str, str2);
    }

    public static /* synthetic */ void traceStack$default(Log log, GaiaXContext gaiaXContext, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        log.traceStack(gaiaXContext, str, str2);
    }

    public final void d(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            str = "[GaiaX]";
        }
        if (str2 == null) {
            str2 = "";
        }
        longE(str, str2);
    }

    public final void e(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            str = "[GaiaX]";
        }
        if (str2 == null) {
            str2 = "";
        }
        longE(str, str2);
    }

    public final boolean isJSLog() {
        return PropUtils.INSTANCE.isJSLog();
    }

    public final boolean isLaunchLog() {
        return PropUtils.INSTANCE.isLaunchLog();
    }

    public final boolean isLog() {
        return PropUtils.INSTANCE.isLog();
    }

    public final boolean isMonitorLog() {
        return PropUtils.INSTANCE.isMonitorLog();
    }

    public final boolean isTimeLog() {
        return PropUtils.INSTANCE.isTimeLog();
    }

    public final void trace(@Nullable GaiaXContext gaiaXContext, @NotNull String str, @NotNull String str2) {
        GaiaX.Params params;
        GaiaX.Params params2;
        GaiaX.Params params3;
        ld2<Float> viewPort;
        GaiaX.Params params4;
        ld2<Float> viewPort2;
        View rootView;
        b41.i(str, "tag");
        b41.i(str2, "ext");
        Integer num = null;
        if (gaiaXContext != null) {
            gaiaXContext.setCallStack(null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("traceId=");
        sb.append(gaiaXContext == null ? null : Integer.valueOf(gaiaXContext.getTraceId()));
        sb.append(" tag=");
        sb.append(str);
        sb.append(" tId=");
        sb.append((Object) ((gaiaXContext == null || (params = gaiaXContext.getParams()) == null) ? null : params.getTemplateId()));
        sb.append(" bId=");
        sb.append((Object) ((gaiaXContext == null || (params2 = gaiaXContext.getParams()) == null) ? null : params2.getTemplateBiz()));
        sb.append(" size=");
        sb.append((gaiaXContext == null || (params3 = gaiaXContext.getParams()) == null || (viewPort = params3.getViewPort()) == null) ? null : viewPort.b());
        sb.append('-');
        sb.append((gaiaXContext == null || (params4 = gaiaXContext.getParams()) == null || (viewPort2 = params4.getViewPort()) == null) ? null : viewPort2.a());
        sb.append(" vw=");
        if (gaiaXContext != null && (rootView = gaiaXContext.getRootView()) != null) {
            num = Integer.valueOf(rootView.hashCode());
        }
        sb.append(num);
        sb.append(' ');
        sb.append(str2);
        d("[GaiaX]", sb.toString());
    }

    public final void traceContainer(int i, @NotNull String str, @NotNull String str2) {
        b41.i(str, "tag");
        b41.i(str2, "ext");
        d("[GaiaX]", "traceId=" + i + " tag=" + str + ' ' + str2);
    }

    public final void traceStack(@Nullable GaiaXContext gaiaXContext, @NotNull String str, @NotNull String str2) {
        GaiaX.Params params;
        GaiaX.Params params2;
        GaiaX.Params params3;
        ld2<Float> viewPort;
        GaiaX.Params params4;
        ld2<Float> viewPort2;
        View rootView;
        b41.i(str, "tag");
        b41.i(str2, "ext");
        if (gaiaXContext != null) {
            gaiaXContext.initCall();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("traceId=");
        sb.append(gaiaXContext == null ? null : Integer.valueOf(gaiaXContext.getTraceId()));
        sb.append(" tag=");
        sb.append(str);
        sb.append(" tId=");
        sb.append((Object) ((gaiaXContext == null || (params = gaiaXContext.getParams()) == null) ? null : params.getTemplateId()));
        sb.append(" bId=");
        sb.append((Object) ((gaiaXContext == null || (params2 = gaiaXContext.getParams()) == null) ? null : params2.getTemplateBiz()));
        sb.append(" size=");
        sb.append((gaiaXContext == null || (params3 = gaiaXContext.getParams()) == null || (viewPort = params3.getViewPort()) == null) ? null : viewPort.b());
        sb.append('-');
        sb.append((gaiaXContext == null || (params4 = gaiaXContext.getParams()) == null || (viewPort2 = params4.getViewPort()) == null) ? null : viewPort2.a());
        sb.append(" vw=");
        sb.append((gaiaXContext == null || (rootView = gaiaXContext.getRootView()) == null) ? null : Integer.valueOf(rootView.hashCode()));
        sb.append(' ');
        sb.append(str2);
        sb.append("\n\t\t\tst=");
        sb.append((Object) (gaiaXContext != null ? gaiaXContext.getCallStack() : null));
        d("[GaiaX]", sb.toString());
    }
}
