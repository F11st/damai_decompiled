package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.ultron.vfw.event.ViewRenderErrorListener;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.taobao.android.dinamic.exception.DinamicException;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class i90 {
    private ay2 a;
    private com.taobao.android.dinamicx.n b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements IDXNotificationListener {
        a() {
        }

        @Override // com.taobao.android.dinamicx.notification.IDXNotificationListener
        public void onNotificationListener(rz rzVar) {
            int i;
            List<s10> list = rzVar.c;
            if (list == null) {
                return;
            }
            for (s10 s10Var : list) {
                if (s10Var != null && (i = s10Var.c) == 1000) {
                    i90 i90Var = i90.this;
                    DXTemplateItem dXTemplateItem = s10Var.a;
                    i90Var.b(dXTemplateItem != null ? dXTemplateItem.name : "", "componentRenderError", String.valueOf(i));
                }
            }
        }
    }

    private i90(ay2 ay2Var) {
        this.a = null;
        this.a = ay2Var;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        vt2.b("DinamicXEngineManager", "componenet render error, name: ", str, "reason", str3);
        ViewRenderErrorListener viewRenderErrorListener = (ViewRenderErrorListener) this.a.getService(ViewRenderErrorListener.class);
        if (viewRenderErrorListener == null) {
            return;
        }
        viewRenderErrorListener.onError(str, str2, str3);
        UmbrellaTracker.commitFailureStability(n90.KEY_FESTRUE_COMPONT, "renderError", "1.0", this.a.k(), null, null, "renderError$" + str, str2 + JSMethod.NOT_SET + str3);
    }

    public static i90 c(@NonNull ay2 ay2Var) {
        if (ay2Var != null) {
            return new i90(ay2Var);
        }
        throw new IllegalArgumentException("params viewEngine can not be null");
    }

    private void e() {
        if (this.b == null) {
            com.taobao.android.dinamicx.n nVar = new com.taobao.android.dinamicx.n(new DXEngineConfig.b(this.a.p()).x(false).u(1).t());
            this.b = nVar;
            nVar.l(new a());
        }
    }

    @NonNull
    public com.taobao.android.dinamicx.n d() {
        return this.b;
    }

    public void f(long j, com.taobao.android.dinamicx.a aVar) {
        this.b.k(j, aVar);
    }

    public void g(String str, w0 w0Var) throws DinamicException {
        this.b.s(str, w0Var);
    }
}
