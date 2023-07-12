package tb;

import com.taobao.opentracing.api.Span;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ph2 extends m2<String> {
    public ph2(String str) {
        super(str);
    }

    @Override // com.taobao.opentracing.api.tag.Tag
    /* renamed from: a */
    public void set(Span span, String str) {
        span.setTag(this.a, str);
    }
}
