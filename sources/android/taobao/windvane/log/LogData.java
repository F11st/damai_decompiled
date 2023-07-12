package android.taobao.windvane.log;

import android.text.TextUtils;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import java.util.Map;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LogData {
    String errorCode;
    String errorMsg;
    String event;
    StringBuilder ext;
    int level;
    String module;
    String pid;
    long timestamp;
    String uid;

    /* JADX INFO: Access modifiers changed from: private */
    public static void addKVToString(StringBuilder sb, String str, String str2) {
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        sb.append(":");
        sb.append("\"");
        sb.append(str2);
        sb.append("\"");
        sb.append(",");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addObjToString(StringBuilder sb, String str, Object obj) {
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        sb.append(":");
        sb.append(obj.toString());
        sb.append(",");
    }

    private String getLevelString(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "UNKNOWN" : "ERROR" : "WARN" : MonitorItemConstants.LEVEL_INFO : "DEBUG" : "VERBOSE";
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getEvent() {
        return this.event;
    }

    public String getExt() {
        return this.ext.toString();
    }

    public int getLevel() {
        return this.level;
    }

    public String getModule() {
        return this.module;
    }

    public String getPid() {
        return this.pid;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getUid() {
        return this.uid;
    }

    public String toLogString() {
        StringBuilder sb = new StringBuilder(jn1.BLOCK_START_STR);
        addKVToString(sb, "level", getLevelString(this.level));
        addKVToString(sb, "module", this.module);
        addKVToString(sb, "event", this.event);
        if (!TextUtils.isEmpty(this.uid)) {
            addKVToString(sb, "id", this.uid);
        }
        addKVToString(sb, "parentId", this.pid);
        addKVToString(sb, "time", "" + this.timestamp);
        if (!TextUtils.isEmpty(this.errorCode)) {
            addKVToString(sb, "errorCode", this.errorCode);
        }
        if (!TextUtils.isEmpty(this.errorMsg)) {
            addKVToString(sb, "errorMsg", this.errorMsg);
        }
        StringBuilder sb2 = this.ext;
        if (sb2 != null) {
            addObjToString(sb, "ext", sb2.toString());
        }
        return sb.substring(0, sb.length() - 1) + "}";
    }

    public void write() {
        WMLogGlobal.getInstance().writeLog(this);
    }

    private LogData(Builder builder) {
        this.event = "";
        this.uid = "";
        this.pid = "";
        this.timestamp = 0L;
        this.errorCode = "";
        this.errorMsg = "";
        this.module = builder.module;
        this.level = builder.level;
        this.event = builder.event;
        this.uid = builder.uid;
        this.pid = builder.pid;
        this.timestamp = builder.timestamp;
        this.errorCode = builder.errorCode;
        this.errorMsg = builder.errorMsg;
        this.ext = builder.ext;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Builder {
        int level;
        String module;
        String event = "";
        String pid = "";
        long timestamp = 0;
        String errorCode = "";
        String errorMsg = "";
        StringBuilder ext = new StringBuilder(jn1.BLOCK_START_STR);
        String uid = "";

        public Builder append(String str, Map<String, String> map) {
            if (map != null) {
                StringBuilder sb = new StringBuilder(jn1.BLOCK_START_STR);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(value)) {
                        LogData.addKVToString(sb, key, value);
                    }
                }
                if (sb.length() > 1) {
                    sb.setLength(sb.length() - 1);
                    sb.append("}");
                    LogData.addObjToString(this.ext, str, sb.toString());
                }
            }
            return this;
        }

        public LogData build() {
            StringBuilder sb = this.ext;
            sb.setLength(sb.length() - 1);
            this.ext.append("}");
            return new LogData(this);
        }

        public Builder errorCode(String str) {
            this.errorCode = str;
            return this;
        }

        public Builder errorMsg(String str) {
            this.errorMsg = str;
            return this;
        }

        public Builder event(String str) {
            this.event = str;
            return this;
        }

        public Builder level(int i) {
            this.level = i;
            return this;
        }

        public Builder module(String str) {
            this.module = str;
            return this;
        }

        public Builder pid(String str) {
            this.pid = str;
            return this;
        }

        public Builder timestamp(long j) {
            this.timestamp = j;
            return this;
        }

        public Builder uid(String str) {
            this.uid = str;
            return this;
        }

        public Builder append(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str2.startsWith(jn1.BLOCK_START_STR) || str2.startsWith(jn1.ARRAY_START_STR)) {
                    LogData.addObjToString(this.ext, str, str2);
                } else {
                    LogData.addKVToString(this.ext, str, str2);
                }
            }
            return this;
        }

        public Builder append(String str, JSONObject jSONObject) {
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                LogData.addObjToString(this.ext, str, jSONObject);
            }
            return this;
        }
    }
}
