package tb;

import com.taobao.opentracing.api.Span;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class o31 extends m2<Integer> {
    public o31(String str) {
        super(str);
    }

    @Override // com.taobao.opentracing.api.tag.Tag
    /* renamed from: a */
    public void set(Span span, Integer num) {
        span.setTag(this.a, num);
    }
}
