package android.taobao.windvane.util;

import android.taobao.windvane.fullspan.SpanWrapper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.analysis.v3.FalcoGlobalTracer;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.analysis.v3.FalcoTracer;
import com.taobao.opentracing.api.SpanContext;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FullTraceUtils {
    private static final String TAG = "FullTraceUtils";

    public static void addCustomProperty(SpanWrapper spanWrapper, String str, String str2) {
        if (spanWrapper != null) {
            spanWrapper.setCustomTag(str, str2);
        }
    }

    public static void addCustomStage(FalcoSpan falcoSpan, String str, Long l) {
        if (falcoSpan != null) {
            addStageInternal(l, falcoSpan, str);
            falcoSpan.log("{\"H5CustomStage\":\"" + str + "\",\"time\":\"" + l + "\"}");
        }
    }

    public static void addCustomStageAndFinish(FalcoSpan falcoSpan, String str) {
        addStage(falcoSpan, str);
        if (falcoSpan != null) {
            if (TextUtils.isEmpty(str)) {
                falcoSpan.finish();
            } else {
                falcoSpan.finish(str);
            }
        }
    }

    public static void addProperty(SpanWrapper spanWrapper, String str, String str2) {
        if (spanWrapper != null) {
            spanWrapper.setTag(str, str2);
        }
    }

    public static void addStage(FalcoSpan falcoSpan, String str) {
        addStage(falcoSpan, str, Long.valueOf(System.currentTimeMillis()));
    }

    private static void addStageInternal(Long l, @NonNull FalcoSpan falcoSpan, String str) {
        try {
            FalcoStage customStage = falcoSpan.customStage(str);
            customStage.start(l);
            customStage.finish(l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static FalcoSpan makeSpanChildOf(String str, String str2, SpanWrapper spanWrapper) {
        if (spanWrapper != null) {
            return makeSpanChildOf(str, str2, spanWrapper.context());
        }
        TaoLog.i(TAG, "falcoSpan=null " + CommonUtils.getStackTrace(new Exception().fillInStackTrace()));
        return null;
    }

    public static void addStage(FalcoSpan falcoSpan, String str, Long l) {
        if (falcoSpan != null) {
            addStageInternal(l, falcoSpan, str);
            falcoSpan.log("{\"H5Stage\":\"" + str + "\",\"time\":\"" + l + "\"}");
        }
    }

    public static FalcoSpan makeSpanChildOf(String str, String str2, FalcoSpan falcoSpan) {
        if (falcoSpan != null) {
            return makeSpanChildOf(str, str2, falcoSpan.context());
        }
        TaoLog.i(TAG, "falcoSpan=null " + CommonUtils.getStackTrace(new Exception().fillInStackTrace()));
        return null;
    }

    public static void addStage(SpanWrapper spanWrapper, String str) {
        addStage(spanWrapper, str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void addStage(SpanWrapper spanWrapper, String str, Long l) {
        if (spanWrapper != null) {
            addStageInternal(l, spanWrapper, str);
            spanWrapper.log("{\"H5Stage\":\"" + str + "\",\"time\":\"" + l + "\"}");
        }
    }

    private static void addStageInternal(Long l, @NonNull SpanWrapper spanWrapper, String str) {
        try {
            FalcoStage customStage = spanWrapper.customStage(str);
            customStage.start(l);
            customStage.finish(l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static FalcoSpan makeSpanChildOf(String str, String str2, SpanContext spanContext) {
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer != null) {
                FalcoTracer.FalcoSpanBuilder buildSpan = falcoTracer.buildSpan(str, str2);
                if (spanContext != null) {
                    buildSpan.asChildOf(spanContext);
                } else {
                    TaoLog.i(TAG, "spanContext=null " + CommonUtils.getStackTrace(new Exception().fillInStackTrace()));
                }
                return buildSpan.startContainerSpan();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static FalcoSpan makeSpanChildOf(String str, String str2, Map<String, String> map) {
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer != null) {
                FalcoTracer.FalcoSpanBuilder buildSpan = falcoTracer.buildSpan(str, str2);
                if (map != null) {
                    SpanContext extractMapToContext = falcoTracer.extractMapToContext(map);
                    if (extractMapToContext != null) {
                        buildSpan.asChildOf(extractMapToContext);
                    } else {
                        TaoLog.i(TAG, "openTracingContextMap=" + map + CommonUtils.getStackTrace(new Exception().fillInStackTrace()));
                    }
                } else {
                    TaoLog.i(TAG, "openTracingContextMap==null " + CommonUtils.getStackTrace(new Exception().fillInStackTrace()));
                }
                return buildSpan.startContainerSpan();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
