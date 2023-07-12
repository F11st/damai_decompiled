package com.taobao.tao.log.trace;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.tao.log.trace.TBSpan;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class TBTracer {
    public static OnTraceErrorListener errorListener;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class SpanBuilder {
        private Map<String, Object> initialTags;
        private final String operationName;
        private TBSpan.Reference reference;
        private final String sceneName;
        private long startMicros;

        SpanBuilder(String str) {
            this(str, null);
        }

        protected SpanBuilder addReference(String str, TBSpan.SpanContext spanContext) {
            if (spanContext != null) {
                this.reference = new TBSpan.Reference(spanContext, str);
            }
            return this;
        }

        public SpanBuilder asChildOf(TBSpan.SpanContext spanContext) {
            return addReference(References.CHILD_OF, spanContext);
        }

        public SpanBuilder bizCode(String str) {
            withFlag(FlagConst.FLAG_BIZ_CODE, str);
            return this;
        }

        public SpanBuilder bizSubCode(String str) {
            withFlag(FlagConst.FLAG_BIZ_SUBCODE, str);
            return this;
        }

        public SpanBuilder followsFrom(TBSpan tBSpan) {
            return tBSpan == null ? this : addReference(References.FOLLOWS_FROM, tBSpan.context());
        }

        public TBSpan instant() {
            if (this.startMicros == 0) {
                this.startMicros = TBSpan.nowMicros();
            }
            String str = this.operationName;
            String str2 = this.sceneName;
            long j = this.startMicros;
            return new TBSpan(str, str2, j, j, this.initialTags, this.reference);
        }

        public SpanBuilder link(String str) {
            return TextUtils.isEmpty(str) ? this : addReference(References.LINK_TRACE, new TBSpan.SpanContext(str));
        }

        public SpanBuilder module(String str) {
            withFlag(FlagConst.FLAG_MODULE, str);
            return this;
        }

        public TBSpan start() {
            if (this.startMicros == 0) {
                this.startMicros = TBSpan.nowMicros();
            }
            return new TBSpan(this.operationName, this.sceneName, this.startMicros, this.initialTags, this.reference);
        }

        public SpanBuilder tag(String str) {
            withFlag(FlagConst.FLAG_TAG, str);
            return this;
        }

        public SpanBuilder withFlag(String str, String str2) {
            this.initialTags.put(str, str2);
            return this;
        }

        public SpanBuilder withStartTimestamp(long j) {
            this.startMicros = j;
            return this;
        }

        SpanBuilder(String str, String str2) {
            this.initialTags = new HashMap();
            this.operationName = str;
            this.sceneName = str2;
        }

        public SpanBuilder asChildOf(TBSpan tBSpan) {
            return tBSpan == null ? this : addReference(References.CHILD_OF, tBSpan.context());
        }

        public SpanBuilder followsFrom(TBSpan.SpanContext spanContext) {
            return addReference(References.FOLLOWS_FROM, spanContext);
        }

        public SpanBuilder withFlag(String str, boolean z) {
            this.initialTags.put(str, Boolean.valueOf(z));
            return this;
        }

        public SpanBuilder withFlag(String str, long j) {
            this.initialTags.put(str, Long.valueOf(j));
            return this;
        }

        public SpanBuilder withFlag(String str, int i) {
            this.initialTags.put(str, Integer.valueOf(i));
            return this;
        }
    }

    public static SpanBuilder buildSpan(String str) {
        return buildSpan(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OnTraceErrorListener getTraceErrorListener() {
        return errorListener;
    }

    public static void removeTraceErrorListener() {
        errorListener = null;
    }

    public static void setTraceErrorListener(OnTraceErrorListener onTraceErrorListener) {
        errorListener = onTraceErrorListener;
    }

    public static SpanBuilder buildSpan(String str, String str2) {
        return new SpanBuilder(str, str2);
    }
}
