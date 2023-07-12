package tb;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class q80 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ DinamicEventHandler a;
        final /* synthetic */ v80 b;
        final /* synthetic */ Object c;
        final /* synthetic */ x80 d;

        a(q80 q80Var, DinamicEventHandler dinamicEventHandler, v80 v80Var, Object obj, x80 x80Var) {
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
    /* loaded from: classes11.dex */
    public class b implements View.OnLongClickListener {
        final /* synthetic */ DinamicEventHandler a;
        final /* synthetic */ v80 b;
        final /* synthetic */ Object c;
        final /* synthetic */ x80 d;

        b(q80 q80Var, DinamicEventHandler dinamicEventHandler, v80 v80Var, Object obj, x80 x80Var) {
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
        Pair<String, String> b2 = f90.b(str2);
        if (b2 == null) {
            v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_NOT_FOUND, x80Var.a);
            if (com.taobao.android.dinamic.b.e()) {
                DinamicLog.e(com.taobao.android.dinamic.b.TAG, String.format("事件表达式 %s=%s 解析出错", str, str2));
                return;
            }
            return;
        }
        DinamicEventHandler b3 = com.taobao.android.dinamic.b.b((String) b2.first);
        if (b3 == null) {
            v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_NOT_FOUND, x80Var.a);
            if (com.taobao.android.dinamic.b.e()) {
                DinamicLog.e(com.taobao.android.dinamic.b.TAG, String.format("%s=%s，没有找到%s对应的DinamicEventHandler", str, str2, b2.first));
                return;
            }
            return;
        }
        Object a2 = s80.a((String) b2.second, x80Var.a, v80Var);
        if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_TAP)) {
            view.setOnClickListener(new a(this, b3, v80Var, a2, x80Var));
            try {
                b3.prepareBindEvent(view, a2, v80Var.d());
            } catch (Throwable th) {
                v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, x80Var.a);
                DinamicLog.c("DinamicEventHandler", th, "handler prepareBindEvent failed, handler=", b3.getClass().getName());
            }
        } else if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_LONGTAP)) {
            view.setOnLongClickListener(new b(this, b3, v80Var, a2, x80Var));
            try {
                b3.prepareBindEvent(view, a2, v80Var.d());
            } catch (Throwable th2) {
                v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, x80Var.a);
                DinamicLog.c("DinamicEventHandler", th2, "handler prepareBindEvent failed, handler=", b3.getClass().getName());
            }
        }
    }

    public static void d(View view, v80 v80Var, x80 x80Var, String str) {
        long nanoTime = System.nanoTime();
        try {
            v80Var.f(view.getTag(a90.SUBDATA));
            com.taobao.android.dinamic.expressionv2.g.d(view, str, v80Var);
            DinamicLog.g(v80Var.c(), x80Var.a, System.nanoTime() - nanoTime);
        } catch (Throwable unused) {
            v80Var.e().b().a(p80.ERROR_CODE_EVENT_HANDLER_EXCEPTION, x80Var.a);
            DinamicLog.g(v80Var.c(), x80Var.a, System.nanoTime() - nanoTime);
        }
    }

    public void a(View view, v80 v80Var, x80 x80Var, String str, String str2) {
        if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_TAP)) {
            view.setOnClickListener(new r80(v80Var, str2, x80Var));
            com.taobao.android.dinamic.expressionv2.g.f(view, str2, v80Var, x80Var);
        } else if (TextUtils.equals(str, DAttrConstant.VIEW_EVENT_LONGTAP)) {
            view.setOnLongClickListener(new r80(v80Var, str2, x80Var));
            com.taobao.android.dinamic.expressionv2.g.f(view, str2, v80Var, x80Var);
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
