package com.taobao.tao.log.logger;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.taobao.tao.log.LogCategory;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogNative;
import com.taobao.tao.log.trace.FlagConst;
import com.taobao.tao.log.trace.TBSpan;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class TraceLogger {
    private static final String FIELD_BAGGAGE = "bag";
    private static final String FIELD_FINISH_TIME = "finish";
    private static final String FIELD_FLAGS = "flag";
    private static final String FIELD_LOG_EVENT = "event";
    private static final String FIELD_LOG_FIELD = "field";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_PARENT_ID = "pID";
    private static final String FIELD_PREVIOUS_ID = "prevID";
    private static final String FIELD_SCENE_NAME = "scene";
    private static final String FIELD_SPAN_ID = "sID";
    private static final String FIELD_START_TIME = "start";
    private static final String FIELD_TIME = "ts";
    private static final String FIELD_TRACE_ID = "tID";
    private static final String FIELD_TYPE = "type";
    private static final String TAG = "Trace";
    private static final int TYPE_FINISH = 3;
    private static final int TYPE_LOG = 2;
    private static final int TYPE_START = 1;

    private static void write(TBSpan tBSpan, String str) {
        String str2 = (String) tBSpan.flags().get(FlagConst.FLAG_MODULE);
        String str3 = (String) tBSpan.flags().get(FlagConst.FLAG_TAG);
        if (TextUtils.isEmpty(str2)) {
            str2 = "Diagnose";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = TAG;
        }
        TLogNative.writeLog(LogCategory.SpanLog, LogLevel.I, str2, str3, str);
    }

    public static void writeLog(TBSpan tBSpan, TBSpan.LogEntry logEntry) {
        try {
            JSONObject jSONObject = new JSONObject(true);
            jSONObject.put("type", (Object) 2);
            jSONObject.put(FIELD_TRACE_ID, (Object) tBSpan.traceId());
            jSONObject.put(FIELD_SPAN_ID, (Object) tBSpan.toSpanId());
            jSONObject.put("ts", (Object) Long.valueOf(logEntry.timestamp()));
            jSONObject.put("event", (Object) logEntry.event());
            jSONObject.put(FIELD_LOG_FIELD, (Object) logEntry.fields());
            write(tBSpan, jSONObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeStart(TBSpan tBSpan) {
        try {
            JSONObject jSONObject = new JSONObject(true);
            jSONObject.put("type", (Object) 1);
            jSONObject.put("name", (Object) tBSpan.operationName());
            jSONObject.put(FIELD_TRACE_ID, (Object) tBSpan.traceId());
            jSONObject.put(FIELD_SPAN_ID, (Object) tBSpan.toSpanId());
            jSONObject.put(FIELD_PARENT_ID, (Object) Long.valueOf(tBSpan.parentId()));
            jSONObject.put(FIELD_PREVIOUS_ID, (Object) Long.valueOf(tBSpan.previousId()));
            String sceneName = tBSpan.context().sceneName();
            if (!TextUtils.isEmpty(sceneName)) {
                jSONObject.put("scene", (Object) sceneName);
            }
            write(tBSpan, jSONObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writerFinish(TBSpan tBSpan) {
        try {
            JSONObject jSONObject = new JSONObject(true);
            jSONObject.put("type", (Object) 3);
            jSONObject.put("name", (Object) tBSpan.operationName());
            jSONObject.put(FIELD_TRACE_ID, (Object) tBSpan.traceId());
            jSONObject.put(FIELD_SPAN_ID, (Object) tBSpan.toSpanId());
            jSONObject.put(FIELD_PARENT_ID, (Object) Long.valueOf(tBSpan.parentId()));
            jSONObject.put(FIELD_PREVIOUS_ID, (Object) Long.valueOf(tBSpan.previousId()));
            String sceneName = tBSpan.context().sceneName();
            if (!TextUtils.isEmpty(sceneName)) {
                jSONObject.put("scene", (Object) sceneName);
            }
            jSONObject.put("start", (Object) Long.valueOf(tBSpan.startMicros()));
            jSONObject.put("finish", (Object) Long.valueOf(tBSpan.finishMicros()));
            if (!tBSpan.flags().isEmpty()) {
                jSONObject.put("flag", (Object) tBSpan.flags());
            }
            if (tBSpan.isSaveBaggage()) {
                jSONObject.put(FIELD_BAGGAGE, (Object) tBSpan.context().baggageItems());
            }
            write(tBSpan, jSONObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
