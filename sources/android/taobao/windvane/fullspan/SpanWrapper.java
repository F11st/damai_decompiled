package android.taobao.windvane.fullspan;

import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.opentracing.api.SpanContext;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SpanWrapper {
    FalcoSpan falcoSpan;

    public SpanWrapper() {
    }

    public SpanContext context() {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            return falcoSpan.context();
        }
        return null;
    }

    public FalcoStage customStage(String str) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            return falcoSpan.customStage(str);
        }
        return null;
    }

    public void finish() {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.finish();
        }
    }

    public void log(String str) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.log(str);
        }
    }

    public void releaseLog(String str) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.releaseLog(str);
        }
    }

    public void setCustomTag(String str, String str2) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.setTag(str, str2);
            FalcoSpan falcoSpan2 = this.falcoSpan;
            falcoSpan2.log("{\"H5CustomProperty\":\"" + str + "\",\"value\":\"" + str2 + "\"}");
        }
    }

    public void setFailStatus() {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            FalcoSpan.ERROR_CODE.set(falcoSpan, "failed");
        }
    }

    public void setFalcoSpan(FalcoSpan falcoSpan) {
        this.falcoSpan = falcoSpan;
    }

    public void setTag(String str, String str2) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.setTag(str, str2);
            FalcoSpan falcoSpan2 = this.falcoSpan;
            falcoSpan2.log("{\"H5Property\":\"" + str + "\",\"value\":\"" + str2 + "\"}");
        }
    }

    public SpanWrapper(FalcoSpan falcoSpan) {
        this.falcoSpan = falcoSpan;
    }

    public void setFalcoSpan(SpanWrapper spanWrapper) {
        if (spanWrapper != null) {
            this.falcoSpan = spanWrapper.falcoSpan;
        }
    }

    public void finish(String str) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.finish(str);
        }
    }

    public void setTag(String str, boolean z) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.setTag(str, z);
            FalcoSpan falcoSpan2 = this.falcoSpan;
            falcoSpan2.log("{\"H5Property\":\"" + str + "\",\"value\":\"" + z + "\"}");
        }
    }

    public void setTag(String str, Number number) {
        FalcoSpan falcoSpan = this.falcoSpan;
        if (falcoSpan != null) {
            falcoSpan.setTag(str, number);
            FalcoSpan falcoSpan2 = this.falcoSpan;
            falcoSpan2.log("{\"H5Property\":\"" + str + "\",\"value\":\"" + number + "\"}");
        }
    }
}
