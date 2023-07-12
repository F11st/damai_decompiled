package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.MtopResponse;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopFinishEvent extends MtopEvent {
    public MtopResponse mtopResponse;
    public String seqNo;

    public MtopFinishEvent(MtopResponse mtopResponse) {
        this.mtopResponse = mtopResponse;
    }

    public MtopResponse getMtopResponse() {
        return this.mtopResponse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopFinishEvent [seqNo=");
        sb.append(this.seqNo);
        sb.append(", mtopResponse");
        sb.append(this.mtopResponse);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
