package com.taobao.tao.log.trace;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.taobao.tao.log.logger.TraceLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class TBSpan {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long ROOT_SPAN_ID = 0;
    private static final String TAG = "TBSpan";
    public static final long UNKNOWN_SPAN_ID = -1;
    private static final AtomicLong nextId = new AtomicLong(0);
    private SpanContext context;
    private long finishMicros;
    private boolean finished;
    private Map<String, Object> flags;
    private boolean hasError;
    private String operationName;
    private long parentId;
    private long previousId;
    private List<Reference> references;
    private boolean reportError;
    private boolean saveBaggage;
    private long startMicros;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class Reference {
        private final SpanContext context;
        private final String referenceType;

        public Reference(SpanContext spanContext, String str) {
            this.context = spanContext;
            this.referenceType = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Reference.class != obj.getClass()) {
                return false;
            }
            Reference reference = (Reference) obj;
            return this.context.equals(reference.context) && this.referenceType.equals(reference.referenceType);
        }

        public SpanContext getContext() {
            return this.context;
        }

        public String getReferenceType() {
            return this.referenceType;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.context, this.referenceType});
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class SpanContext {
        private final Map<String, String> baggage;
        private final String sceneName;
        private final long spanId;
        private final String traceId;

        public SpanContext(String str) {
            this(str, -1L, null, null);
        }

        public Iterable<Map.Entry<String, String>> baggageItems() {
            return this.baggage.entrySet();
        }

        public String getBaggageItem(String str) {
            return this.baggage.get(str);
        }

        public String sceneName() {
            return this.sceneName;
        }

        public long spanId() {
            return this.spanId;
        }

        public String toSpanId() {
            return String.valueOf(this.spanId);
        }

        public String traceId() {
            return String.valueOf(this.traceId);
        }

        public SpanContext withBaggageItem(String str, String str2) {
            HashMap hashMap = new HashMap(this.baggage);
            hashMap.put(str, str2);
            return new SpanContext(this.traceId, this.spanId, hashMap, this.sceneName);
        }

        public SpanContext(String str, long j, Map<String, String> map, String str2) {
            this.baggage = map;
            this.traceId = str;
            this.spanId = j;
            this.sceneName = str2;
        }

        public SpanContext(SpanContext spanContext) {
            this.baggage = spanContext.baggage;
            this.traceId = spanContext.traceId;
            this.spanId = spanContext.spanId;
            this.sceneName = spanContext.sceneName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TBSpan(String str, String str2, long j, long j2, Map<String, Object> map, Reference reference) {
        initSpan(str, str2, j, map, reference);
        finish(j2);
    }

    private static SpanContext findParentRef(List<Reference> list, String str) {
        if (list.isEmpty()) {
            return null;
        }
        for (Reference reference : list) {
            if (str.equals(reference.getReferenceType())) {
                return reference.getContext();
            }
        }
        return list.get(0).getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean finishedCheck(String str, Object... objArr) {
        if (this.finished) {
            Log.e(TAG, String.format(str, objArr));
            return true;
        }
        return false;
    }

    private void initSpan(String str, String str2, long j, Map<String, Object> map, Reference reference) {
        this.operationName = str;
        this.startMicros = j;
        if (map == null) {
            this.flags = new HashMap();
        } else {
            this.flags = new HashMap(map);
        }
        if (reference == null) {
            this.references = null;
            this.context = new SpanContext(nextTraceId(), nextId(), new HashMap(), str2);
            this.parentId = 0L;
            this.previousId = 0L;
        } else {
            ArrayList arrayList = new ArrayList();
            this.references = arrayList;
            arrayList.add(reference);
            SpanContext spanContext = reference.context;
            String str3 = reference.referenceType;
            str3.hashCode();
            char c = 65535;
            switch (str3.hashCode()) {
                case -1491332377:
                    if (str3.equals(References.FOLLOWS_FROM)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1186832576:
                    if (str3.equals(References.LINK_TRACE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1659508698:
                    if (str3.equals(References.CHILD_OF)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.context = new SpanContext(spanContext.traceId, nextId(), mergeBaggages(reference), str2);
                    this.parentId = -1L;
                    this.previousId = spanContext.spanId;
                    break;
                case 1:
                    this.context = new SpanContext(spanContext.traceId, nextId(), mergeBaggages(reference), str2);
                    this.parentId = -1L;
                    this.previousId = -1L;
                    break;
                case 2:
                    this.context = new SpanContext(spanContext.traceId, nextId(), mergeBaggages(reference), str2);
                    this.parentId = spanContext.spanId;
                    this.previousId = -1L;
                    break;
                default:
                    Log.e(TAG, "Unknown reference type: " + reference.referenceType);
                    this.context = new SpanContext(nextTraceId(), nextId(), new HashMap(), str2);
                    this.parentId = 0L;
                    this.previousId = 0L;
                    break;
            }
        }
        this.hasError = false;
        this.reportError = false;
        this.saveBaggage = false;
    }

    private static Map<String, String> mergeBaggages(List<Reference> list) {
        HashMap hashMap = new HashMap();
        for (Reference reference : list) {
            if (reference.getContext().baggage != null) {
                hashMap.putAll(reference.getContext().baggage);
            }
        }
        return hashMap;
    }

    static long nextId() {
        return nextId.addAndGet(1L);
    }

    static String nextTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long nowMicros() {
        return System.currentTimeMillis();
    }

    private void onSceneError() {
        this.hasError = true;
        OnTraceErrorListener traceErrorListener = TBTracer.getTraceErrorListener();
        if (traceErrorListener == null || TextUtils.isEmpty(this.context.sceneName)) {
            return;
        }
        traceErrorListener.onError(this.context.sceneName, this.flags);
    }

    private synchronized TBSpan setObjectTag(String str, Object obj) {
        if (!finishedCheck("Adding tag {%s:%s} to already finished span", str, obj)) {
            this.flags.put(str, obj);
        }
        return this;
    }

    public synchronized SpanContext context() {
        return this.context;
    }

    public TBSpan error(String str) {
        if (!finishedCheck("set error {%s} to already finished span", str)) {
            setFlag(FlagConst.FLAG_ERROR, true);
            setFlag(FlagConst.FLAG_ERROR_CODE, str);
            onSceneError();
        }
        return this;
    }

    public void finish() {
        finish(nowMicros());
    }

    public long finishMicros() {
        return this.finishMicros;
    }

    public Map<String, Object> flags() {
        return new HashMap(this.flags);
    }

    public synchronized String getBaggageItem(String str) {
        return this.context.getBaggageItem(str);
    }

    public LogEntry getLogger(String str) {
        return new LogEntry(System.currentTimeMillis(), str, null);
    }

    public boolean isSaveBaggage() {
        return this.saveBaggage;
    }

    public TBSpan log(String str) {
        return log(System.currentTimeMillis(), str, null);
    }

    public String operationName() {
        return this.operationName;
    }

    public long parentId() {
        return this.parentId;
    }

    public long previousId() {
        return this.previousId;
    }

    public TBSpan reportError() {
        if (!finishedCheck("report error on already finished span", new Object[0])) {
            this.reportError = true;
        }
        return this;
    }

    public TBSpan saveBaggage(boolean z) {
        this.saveBaggage = z;
        return this;
    }

    public synchronized TBSpan setBaggageItem(String str, String str2) {
        if (!finishedCheck("Adding baggage {%s:%s} to already finished span", str, str2)) {
            this.context = this.context.withBaggageItem(str, str2);
        }
        return this;
    }

    public TBSpan setFlag(String str, String str2) {
        return setObjectTag(str, str2);
    }

    public TBSpan setOperationName(String str) {
        if (!finishedCheck("Setting operationName {%s} on already finished span", str)) {
            this.operationName = str;
        }
        return this;
    }

    public long spanId() {
        return this.context.spanId;
    }

    public long startMicros() {
        return this.startMicros;
    }

    public String toParentId() {
        return String.valueOf(this.parentId);
    }

    public String toPreviousId() {
        return String.valueOf(this.previousId);
    }

    public String toSpanId() {
        return this.context.toSpanId();
    }

    public String toString() {
        return "{traceId:" + this.context.traceId() + ", spanId:" + this.context.spanId() + ", parentId:" + this.parentId + ", operationName:\"" + this.operationName + "\"}";
    }

    public String traceId() {
        return this.context.traceId;
    }

    public synchronized void finish(long j) {
        if (!finishedCheck("Finishing already finished span", new Object[0])) {
            this.finishMicros = j;
            this.finished = true;
            boolean z = this.reportError;
            TraceLogger.writerFinish(this);
        }
    }

    public final TBSpan log(String str, Map<String, String> map) {
        return log(System.currentTimeMillis(), str, map);
    }

    public TBSpan setFlag(String str, boolean z) {
        return setObjectTag(str, Boolean.valueOf(z));
    }

    public TBSpan log(long j, String str) {
        return log(j, str, null);
    }

    public TBSpan setFlag(String str, long j) {
        return setObjectTag(str, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TBSpan(String str, String str2, long j, Map<String, Object> map, Reference reference) {
        initSpan(str, str2, j, map, reference);
        TraceLogger.writeStart(this);
    }

    public final synchronized TBSpan log(long j, String str, Map<String, String> map) {
        if (!finishedCheck("Adding logs %s at %d to already finished span", map, Long.valueOf(j))) {
            TraceLogger.writeLog(this, new LogEntry(j, str, map));
        }
        return this;
    }

    public TBSpan setFlag(String str, int i) {
        return setObjectTag(str, Integer.valueOf(i));
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class LogEntry {
        private final String event;
        private Map<String, String> fields;
        private TBSpan span;
        private final long timestamp;

        public LogEntry(TBSpan tBSpan, long j, String str, Map<String, String> map) {
            this.timestamp = j;
            this.event = str;
            this.fields = map;
            this.span = tBSpan;
        }

        public LogEntry addField(String str, String str2) {
            if (this.fields == null) {
                this.fields = new HashMap();
            }
            this.fields.put(str, str2);
            return this;
        }

        public String event() {
            return this.event;
        }

        public Map<String, ?> fields() {
            return this.fields;
        }

        public void log() {
            TBSpan tBSpan = this.span;
            if (tBSpan == null || tBSpan.finishedCheck("Write logs to already finished span", new Object[0])) {
                return;
            }
            TraceLogger.writeLog(this.span, this);
        }

        public long timestamp() {
            return this.timestamp;
        }

        public LogEntry(long j, String str, Map<String, String> map) {
            this.timestamp = j;
            this.event = str;
            this.fields = map;
            this.span = null;
        }
    }

    private static Map<String, String> mergeBaggages(Reference reference) {
        HashMap hashMap = new HashMap();
        if (reference.getContext().baggage != null) {
            hashMap.putAll(reference.getContext().baggage);
        }
        return hashMap;
    }

    public TBSpan error(String str, String str2) {
        if (!finishedCheck("set error {%s} to already finished span", str)) {
            setFlag(FlagConst.FLAG_ERROR, true);
            setFlag(FlagConst.FLAG_ERROR_CODE, str);
            setFlag(FlagConst.FLAG_ERROR_MSG, str2);
            onSceneError();
        }
        return this;
    }

    public TBSpan error(String str, String str2, String str3) {
        if (!finishedCheck("set error {%s,%s} to already finished span", str, str2)) {
            setFlag(FlagConst.FLAG_ERROR, true);
            setFlag(FlagConst.FLAG_ERROR_CODE, str);
            setFlag(FlagConst.FLAG_ERROR_SUBCODE, str2);
            setFlag(FlagConst.FLAG_ERROR_MSG, str3);
            onSceneError();
        }
        return this;
    }
}
