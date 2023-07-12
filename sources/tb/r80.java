package tb;

import android.view.View;
import com.taobao.android.dinamic.expressionv2.C6337g;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r80 implements View.OnClickListener, View.OnLongClickListener {
    private v80 a;
    private String b;
    private x80 c;

    public r80(v80 v80Var, String str, x80 x80Var) {
        this.a = v80Var;
        this.b = str;
        this.c = x80Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long nanoTime = System.nanoTime();
        try {
            this.a.f(view.getTag(a90.SUBDATA));
            C6337g.d(view, this.b, this.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
        } catch (Throwable unused) {
            this.a.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.c.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        long nanoTime = System.nanoTime();
        try {
            this.a.f(view.getTag(a90.SUBDATA));
            C6337g.d(view, this.b, this.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
            return true;
        } catch (Throwable unused) {
            this.a.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.c.a);
            DinamicLog.g(this.a.c(), this.c.a, System.nanoTime() - nanoTime);
            return true;
        }
    }
}
