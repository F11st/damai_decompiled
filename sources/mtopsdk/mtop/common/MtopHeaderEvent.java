package mtopsdk.mtop.common;

import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopHeaderEvent extends MtopEvent {
    private int code;
    private Map<String, List<String>> headers;
    public String seqNo;

    public MtopHeaderEvent(int i, Map<String, List<String>> map) {
        this.code = i;
        this.headers = map;
    }

    public int getCode() {
        return this.code;
    }

    public Map<String, List<String>> getHeader() {
        return this.headers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopHeaderEvent [seqNo=");
        sb.append(this.seqNo);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
