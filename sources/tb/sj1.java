package tb;

import com.taobao.weex.utils.WXLogUtils;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class sj1 {
    private static sj1 c;
    private Object a;
    private ExecutorService b;

    private sj1() {
        try {
            Method method = Class.forName("com.taobao.weex.devtools.inspector.network.GeneralEventReporter").getMethod("getInstance", new Class[0]);
            if (method != null) {
                this.a = method.invoke(null, new Object[0]);
                this.b = Executors.newSingleThreadExecutor();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static sj1 d() {
        if (c == null) {
            synchronized (sj1.class) {
                if (c == null) {
                    c = new sj1();
                }
            }
        }
        return c;
    }

    public void a(String str, int i, int i2) {
        Object obj = this.a;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            Method b = f12.b(cls, "dataReceived", String.class, cls2, cls2);
            if (b != null) {
                f12.c(this.a, b, str, Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    public void b(String str, int i, int i2) {
        Object obj = this.a;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            Method b = f12.b(cls, "dataSent", String.class, cls2, cls2);
            if (b != null) {
                f12.c(this.a, b, str, Integer.valueOf(i), Integer.valueOf(i2));
            }
        }
    }

    public void c(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void e(String str, String str2) {
        Method b;
        Object obj = this.a;
        if (obj == null || (b = f12.b(obj.getClass(), "httpExchangeFailed", String.class, String.class)) == null) {
            return;
        }
        f12.c(this.a, b, str, str2);
    }

    public InputStream f(String str, String str2, String str3, InputStream inputStream, boolean z) {
        Method b;
        Object obj = this.a;
        return (obj == null || (b = f12.b(obj.getClass(), "interpretResponseStream", String.class, String.class, String.class, InputStream.class, Boolean.TYPE)) == null) ? inputStream : (InputStream) f12.c(this.a, b, str, str2, str3, inputStream, Boolean.valueOf(z));
    }

    public boolean g() {
        Object invoke;
        try {
            Class<?> a = f12.a("com.taobao.weex.devtools.inspector.network.NetworkEventReporterImpl");
            if (a != null) {
                Method b = f12.b(a, gn1.TYPE_OPEN_URL_METHOD_GET, new Class[0]);
                Method b2 = f12.b(a, "isEnabled", new Class[0]);
                if (b != null && (invoke = b.invoke(null, new Object[0])) != null && b2 != null) {
                    boolean booleanValue = ((Boolean) f12.c(invoke, b2, new Object[0])).booleanValue();
                    WXLogUtils.d("NetworkEventReporterProxy", "Is reporter enabled ? " + booleanValue);
                    return booleanValue;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void h(a31 a31Var) {
        Method b;
        Object obj = this.a;
        if (obj == null || (b = f12.b(obj.getClass(), "requestWillBeSent", Map.class)) == null) {
            return;
        }
        f12.c(this.a, b, a31Var.f());
    }

    public void i(b31 b31Var) {
        Method b;
        Object obj = this.a;
        if (obj == null || (b = f12.b(obj.getClass(), "responseHeadersReceived", Map.class)) == null) {
            return;
        }
        f12.c(this.a, b, b31Var.f());
    }

    public void j(String str, String str2) {
        Method b;
        Object obj = this.a;
        if (obj == null || (b = f12.b(obj.getClass(), "responseReadFailed", String.class, String.class)) == null) {
            return;
        }
        f12.c(this.a, b, str, str2);
    }

    public void k(String str) {
        Method b;
        Object obj = this.a;
        if (obj == null || (b = f12.b(obj.getClass(), "responseReadFinished", String.class)) == null) {
            return;
        }
        f12.c(this.a, b, str);
    }
}
