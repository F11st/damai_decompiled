package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.MtopResponse;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopCacheEvent extends MtopFinishEvent {
    public MtopCacheEvent(MtopResponse mtopResponse) {
        super(mtopResponse);
    }

    @Override // mtopsdk.mtop.common.MtopFinishEvent
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopCacheEvent [seqNo=");
        sb.append(this.seqNo);
        sb.append(", mtopResponse=");
        sb.append(this.mtopResponse);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
