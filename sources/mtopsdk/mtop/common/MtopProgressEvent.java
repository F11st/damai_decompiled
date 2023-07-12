package mtopsdk.mtop.common;

import tb.jn1;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class MtopProgressEvent extends MtopEvent {
    String desc;
    public String seqNo;
    int size;
    int total;

    public MtopProgressEvent(String str, int i, int i2) {
        this.desc = str;
        this.size = i;
        this.total = i2;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getSize() {
        return this.size;
    }

    public int getTotal() {
        return this.total;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("MtopProgressEvent [seqNo=");
        sb.append(this.seqNo);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", total=");
        sb.append(this.total);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
