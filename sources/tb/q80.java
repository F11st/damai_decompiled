package tb;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.expressionv2.C6337g;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class q80 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.q80$a */
    /* loaded from: classes11.dex */
    public class View$OnClickListenerC9600a implements View.OnClickListener {
        final /* synthetic */ DinamicEventHandler a;
        final /* synthetic */ v80 b;
        final /* synthetic */ Object c;
        final /* synthetic */ x80 d;

        View$OnClickListenerC9600a(q80 q80Var, DinamicEventHandler dinamicEventHandler, v80 v80Var, Object obj, x80 x80Var) {
            this.a = dinamicEventHandler;
            this.b = v80Var;
            this.c = obj;
            this.d = x80Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long nanoTime = System.nanoTime();
            try {
                this.a.handleEvent(view, this.b.c(), this.c, this.b.d(), this.b.b());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            } catch (Throwable th) {
                this.b.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.d.a);
                DinamicLog.c("DinamicEventHandler", th, "handle onclick event failed, handler=", this.a.getClass().getName());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.q80$b */
    /* loaded from: classes11.dex */
    public class View$OnLongClickListenerC9601b implements View.OnLongClickListener {
        final /* synthetic */ DinamicEventHandler a;
        final /* synthetic */ v80 b;
        final /* synthetic */ Object c;
        final /* synthetic */ x80 d;

        View$OnLongClickListenerC9601b(q80 q80Var, DinamicEventHandler dinamicEventHandler, v80 v80Var, Object obj, x80 x80Var) {
            this.a = dinamicEventHandler;
            this.b = v80Var;
            this.c = obj;
            this.d = x80Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            long nanoTime = System.nanoTime();
            try {
                this.a.handleEvent(view, this.b.c(), this.c, this.b.d(), this.b.b());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            } catch (Throwable th) {
                this.b.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, this.d.a);
                DinamicLog.c("DinamicEventHandler", th, "handle onlongclick event failed, handler=", this.a.getClass().getName());
                DinamicLog.g(this.b.c(), this.d.a, System.nanoTime() - nanoTime);
            }
            return true;
        }
    }

    private void c(View view, v80 v80Var, x80 x80Var, String str, String str2) {
        Pair<String, String> b = f90.b(str2);
        if (b == null) {
            v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_NOT_FOUND, x80Var.a);
            if (C6313b.e()) {
                DinamicLog.e(C6313b.TAG, String.format("事件表达式 %s=%s 解析出错", str, str2));
                return;
            }
            return;
        }
        DinamicEventHandler b2 = C6313b.b((String) b.first);
        if (b2 == null) {
            v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_NOT_FOUND, x80Var.a);
            if (C6313b.e()) {
                DinamicLog.e(C6313b.TAG, String.format("%s=%s，没有找到%s对应的DinamicEventHandler", str, str2, b.first));
                return;
            }
            return;
        }
        Object a = s80.a((String) b.second, x80Var.a, v80Var);
        if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_TAP)) {
            view.setOnClickListener(new View$OnClickListenerC9600a(this, b2, v80Var, a, x80Var));
            try {
                b2.prepareBindEvent(view, a, v80Var.d());
            } catch (Throwable th) {
                v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, x80Var.a);
                DinamicLog.c("DinamicEventHandler", th, "handler prepareBindEvent failed, handler=", b2.getClass().getName());
            }
        } else if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_LONGTAP)) {
            view.setOnLongClickListener(new View$OnLongClickListenerC9601b(this, b2, v80Var, a, x80Var));
            try {
                b2.prepareBindEvent(view, a, v80Var.d());
            } catch (Throwable th2) {
                v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, x80Var.a);
                DinamicLog.c("DinamicEventHandler", th2, "handler prepareBindEvent failed, handler=", b2.getClass().getName());
            }
        }
    }

    public static void d(View view, v80 v80Var, x80 x80Var, String str) {
        long nanoTime = System.nanoTime();
        try {
            v80Var.f(view.getTag(a90.SUBDATA));
            C6337g.d(view, str, v80Var);
            DinamicLog.g(v80Var.c(), x80Var.a, System.nanoTime() - nanoTime);
        } catch (Throwable unused) {
            v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, x80Var.a);
            DinamicLog.g(v80Var.c(), x80Var.a, System.nanoTime() - nanoTime);
        }
    }

    public void a(View view, v80 v80Var, x80 x80Var, String str, String str2) {
        if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_TAP)) {
            view.setOnClickListener(new r80(v80Var, str2, x80Var));
            C6337g.f(view, str2, v80Var, x80Var);
        } else if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_LONGTAP)) {
            view.setOnLongClickListener(new r80(v80Var, str2, x80Var));
            C6337g.f(view, str2, v80Var, x80Var);
        }
    }

    public void b(View view, v80 v80Var) {
        x80 x80Var = (x80) view.getTag(a90.PROPERTY_KEY);
        if (x80Var == null) {
            return;
        }
        Map<String, String> map = x80Var.d;
        if (map.isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2.startsWith(m80.DINAMIC_PREFIX_AT)) {
                a(view, v80Var, x80Var, str, str2);
            } else {
                c(view, v80Var, x80Var, str, str2);
            }
        }
    }
}
