package mtopsdk.mtop.domain;

import java.io.Serializable;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopRequest implements Serializable, IMTOPDataObject {
    private static final long serialVersionUID = -439476282014493612L;
    private String apiName;
    public Map<String, String> dataParams;
    private boolean needEcode;
    private boolean needSession;
    private String version;
    private String data = "{}";
    private String requestLog = "";

    public String getApiName() {
        return this.apiName;
    }

    public String getData() {
        return this.data;
    }

    public String getKey() {
        if (StringUtils.isBlank(this.apiName) || StringUtils.isBlank(this.version)) {
            return null;
        }
        return StringUtils.concatStr2LowerCase(this.apiName, this.version);
    }

    public String getRequestLog() {
        if (StringUtils.isBlank(this.requestLog)) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("MtopRequest [apiName=");
            sb.append(this.apiName);
            sb.append(", version=");
            sb.append(this.version);
            sb.append(", needEcode=");
            sb.append(this.needEcode);
            sb.append(", needSession=");
            sb.append(this.needSession);
            sb.append(jn1.ARRAY_END_STR);
            this.requestLog = sb.toString();
        }
        return this.requestLog;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isLegalRequest() {
        return StringUtils.isNotBlank(this.apiName) && StringUtils.isNotBlank(this.version) && StringUtils.isNotBlank(this.data);
    }

    public boolean isNeedEcode() {
        return this.needEcode;
    }

    public boolean isNeedSession() {
        return this.needSession;
    }

    public void setApiName(String str) {
        this.apiName = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setNeedEcode(boolean z) {
        this.needEcode = z;
    }

    public void setNeedSession(boolean z) {
        this.needSession = z;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("MtopRequest [apiName=");
        sb.append(this.apiName);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", needEcode=");
        sb.append(this.needEcode);
        sb.append(", needSession=");
        sb.append(this.needSession);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
