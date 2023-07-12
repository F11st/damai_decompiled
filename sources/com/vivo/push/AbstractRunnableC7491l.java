package com.vivo.push;

import android.content.Context;
import com.vivo.push.b.C7426n;
import com.vivo.push.util.C7523p;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.l */
/* loaded from: classes11.dex */
public abstract class AbstractRunnableC7491l implements Runnable {
    protected Context a;
    private int b;
    private AbstractC7496o c;

    public AbstractRunnableC7491l(AbstractC7496o abstractC7496o) {
        this.b = -1;
        this.c = abstractC7496o;
        int b = abstractC7496o.b();
        this.b = b;
        if (b >= 0) {
            this.a = C7481e.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.b;
    }

    protected abstract void a(AbstractC7496o abstractC7496o);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a;
        if (context != null && !(this.c instanceof C7426n)) {
            C7523p.a(context, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(jn1.BLOCK_START_STR);
        AbstractC7496o abstractC7496o = this.c;
        sb.append(abstractC7496o == null ? "[null]" : abstractC7496o.toString());
        sb.append("}");
        return sb.toString();
    }
}
