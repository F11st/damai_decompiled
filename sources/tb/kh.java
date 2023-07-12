package tb;

import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.produce.Producer;
import java.lang.reflect.Type;
import tb.a22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kh<OUT, CONTEXT extends a22> {
    private final boolean a;
    private final Producer<OUT, CONTEXT> b;
    private jh c;

    public <NEXT_OUT extends Releasable> kh(jh<OUT, NEXT_OUT, CONTEXT> jhVar, boolean z) {
        cu1.c(jhVar);
        this.a = z;
        if (z && jhVar.m() && jhVar.j() != jhVar.h()) {
            d(jhVar.getName());
        }
        this.b = jhVar;
        this.c = jhVar;
    }

    public static <O, NEXT_O extends Releasable, CONTEXT extends a22> kh<O, CONTEXT> b(jh<O, NEXT_O, CONTEXT> jhVar, boolean z) {
        return new kh<>(jhVar, z);
    }

    public Producer<OUT, CONTEXT> a() {
        return this.b;
    }

    public <NEXT_O, NN_O extends Releasable> kh<OUT, CONTEXT> c(jh<NEXT_O, NN_O, CONTEXT> jhVar) {
        cu1.c(jhVar);
        if (this.a) {
            Type j = jhVar.j();
            if (jhVar.m() && j != jhVar.h()) {
                d(jhVar.getName());
            }
            Type h = this.c.h();
            if (h != j) {
                throw new RuntimeException("NEXT_OUT " + h + " of last producer(" + this.c.getClass().getSimpleName() + ") not equal OUT " + j + " of next producer(" + jhVar.getClass().getSimpleName() + jn1.BRACKET_END_STR);
            }
        }
        this.c = this.c.B(jhVar);
        return this;
    }

    public void d(String str) {
        throw new IllegalArgumentException(str + " skip to consume new result, require OUT class must equal NEXT_OUT class");
    }
}
