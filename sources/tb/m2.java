package tb;

import com.taobao.opentracing.api.tag.Tag;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class m2<T> implements Tag<T> {
    protected final String a;

    public m2(String str) {
        this.a = str;
    }

    @Override // com.taobao.opentracing.api.tag.Tag
    public String getKey() {
        return this.a;
    }
}
