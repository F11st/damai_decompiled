package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import com.taobao.analysis.v3.FalcoBusinessSpan;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.analysis.v3.FalcoGlobalTracer;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.analysis.v3.FalcoTracer;
import com.taobao.opentracing.api.SpanContext;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zz {
    public static FalcoAbilitySpan a(SpanContext spanContext, String str, String str2) {
        FalcoTracer.FalcoSpanBuilder buildSpan;
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer == null || (buildSpan = falcoTracer.buildSpan(str, str2)) == null) {
                return null;
            }
            if (spanContext != null) {
                buildSpan.asChildOf(spanContext);
            }
            return buildSpan.startAbilitySpan();
        } catch (Throwable th) {
            ry.b(th);
            return null;
        }
    }

    public static FalcoAbilitySpan b(Map<String, String> map, String str, String str2) {
        FalcoTracer.FalcoSpanBuilder buildSpan;
        SpanContext extractMapToContext;
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer == null || (buildSpan = falcoTracer.buildSpan(str, str2)) == null) {
                return null;
            }
            if (map != null && (extractMapToContext = falcoTracer.extractMapToContext(map)) != null) {
                buildSpan.asChildOf(extractMapToContext);
            }
            return buildSpan.startAbilitySpan();
        } catch (Throwable th) {
            ry.b(th);
            return null;
        }
    }

    public static FalcoBusinessSpan c(String str, String str2) {
        FalcoTracer.FalcoSpanBuilder buildSpan;
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer == null || (buildSpan = falcoTracer.buildSpan(str, str2)) == null) {
                return null;
            }
            return buildSpan.startBusinessSpan();
        } catch (Throwable th) {
            ry.b(th);
            return null;
        }
    }

    public static FalcoContainerSpan d(SpanContext spanContext, String str, String str2) {
        FalcoTracer.FalcoSpanBuilder buildSpan;
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer == null || (buildSpan = falcoTracer.buildSpan(str, str2)) == null) {
                return null;
            }
            if (spanContext != null) {
                buildSpan.asChildOf(spanContext);
            }
            return buildSpan.startContainerSpan();
        } catch (Throwable th) {
            ry.b(th);
            return null;
        }
    }

    public static FalcoContainerSpan e(Map<String, String> map, String str, String str2) {
        FalcoTracer.FalcoSpanBuilder buildSpan;
        SpanContext extractMapToContext;
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer == null || (buildSpan = falcoTracer.buildSpan(str, str2)) == null) {
                return null;
            }
            if (map != null && (extractMapToContext = falcoTracer.extractMapToContext(map)) != null) {
                buildSpan.asChildOf(extractMapToContext);
            }
            return buildSpan.startContainerSpan();
        } catch (Throwable th) {
            ry.b(th);
            return null;
        }
    }

    @Nullable
    public static FalcoStage f(FalcoSpan falcoSpan) {
        if (falcoSpan == null) {
            return null;
        }
        try {
            return falcoSpan.customStage("DXAbility");
        } catch (Throwable th) {
            ry.b(th);
            return null;
        }
    }

    @Nullable
    public static FalcoStage g(FalcoSpan falcoSpan, @Nullable JSONObject jSONObject) {
        if (falcoSpan != null) {
            try {
                if (k(jSONObject)) {
                    return falcoSpan.customStage(l61.c(jSONObject, TLogEventConst.PARAM_UPLOAD_STAGE, ""));
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
        return null;
    }

    public static void h(FalcoStage falcoStage) {
        if (falcoStage == null) {
            return;
        }
        try {
            nz.g("DXOpenTracerUtil", "finishStage： " + falcoStage.name());
            falcoStage.finish(Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static Map<String, String> i(FalcoSpan falcoSpan) {
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            if (falcoTracer == null || falcoSpan == null) {
                return null;
            }
            return falcoTracer.injectContextToMap(falcoSpan.context());
        } catch (Throwable th) {
            ry.b(th);
            return null;
        }
    }

    public static Map<String, String> j(FalcoSpan falcoSpan) {
        FalcoTracer falcoTracer = FalcoGlobalTracer.get();
        if (falcoTracer == null || falcoSpan == null) {
            return null;
        }
        return falcoTracer.injectContextToMap(falcoSpan.context());
    }

    public static boolean k(@Nullable JSONObject jSONObject) {
        return !TextUtils.isEmpty(l61.c(jSONObject, TLogEventConst.PARAM_UPLOAD_STAGE, ""));
    }

    public static void l(FalcoSpan falcoSpan) {
        if (falcoSpan == null) {
            return;
        }
        try {
            falcoSpan.finish();
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void m(FalcoSpan falcoSpan) {
        if (falcoSpan == null) {
            return;
        }
        try {
            falcoSpan.startTime();
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void n(FalcoSpan falcoSpan, String str) {
        if (falcoSpan == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            falcoSpan.releaseLog(str);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void o(FalcoSpan falcoSpan, String str) {
        if (falcoSpan == null) {
            return;
        }
        try {
            falcoSpan.setTag("errorMsg", str);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void p(FalcoSpan falcoSpan, String str, long j) {
        if (falcoSpan == null) {
            return;
        }
        try {
            falcoSpan.setTag(str, Long.valueOf(j));
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void q(FalcoSpan falcoSpan, String str, String str2) {
        if (falcoSpan == null) {
            return;
        }
        try {
            falcoSpan.setTag(str, str2);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public static void r(FalcoStage falcoStage) {
        if (falcoStage == null) {
            return;
        }
        try {
            nz.g("DXOpenTracerUtil", "startStage： " + falcoStage.name());
            falcoStage.start(Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            ry.b(th);
        }
    }
}
