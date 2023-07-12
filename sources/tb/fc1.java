package tb;

import com.taobao.opentracing.api.Span;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fc1 extends m2<Long> {
    public fc1(String str) {
        super(str);
    }

    @Override // com.taobao.opentracing.api.tag.Tag
    /* renamed from: a */
    public void set(Span span, Long l) {
        span.setTag(this.a, l);
    }
}
