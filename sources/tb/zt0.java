package tb;

import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.handler.reply.AbstractC6690a;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import com.taobao.aranger.utils.C6702d;
import com.taobao.aranger.utils.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zt0 extends AbstractC6690a {
    private static final String h = "zt0";
    private static final ConcurrentHashMap<String, Object> i = new ConcurrentHashMap<>();
    private final String b;
    private Object c;
    private String d;
    private Constructor<?> e;
    private Method f;
    private final Class<?> g;

    public zt0(Call call) throws IPCException {
        super(call);
        this.b = call.getServiceWrapper().getTimeStamp();
        Class<?> a = C6702d.e().a(call.getServiceWrapper());
        this.g = a;
        Object obj = i.get(a.getName());
        this.c = obj;
        if (obj == null) {
            boolean z = true;
            Class<?> cls = null;
            try {
                C6702d e = C6702d.e();
                cls = e.b(a.getName() + Constants.PROXY_SUFFIX);
            } catch (IPCException unused) {
                z = false;
            }
            if (z) {
                this.d = TypeUtils.getMethodId(call.getMethodWrapper().getName(), call.getParameterWrappers());
                this.e = TypeUtils.getConstructor(cls, new Class[0]);
                return;
            }
            Method methodForGettingInstance = TypeUtils.getMethodForGettingInstance(this.g, call.getMethodWrapper().getName(), C6702d.e().c(call.getParameterWrappers()));
            this.f = methodForGettingInstance;
            if (Modifier.isStatic(methodForGettingInstance.getModifiers())) {
                return;
            }
            throw new IPCException(40, "Method " + this.f.getName() + " of class " + this.g.getName() + " is not static. Only the static method can be invoked to get an instance.");
        }
    }

    @Override // com.taobao.aranger.core.handler.reply.AbstractC6690a
    public Object a(Object[] objArr) throws IPCException {
        try {
            if (this.c == null) {
                Constructor<?> constructor = this.e;
                if (constructor != null) {
                    Object newInstance = constructor.newInstance(new Object[0]);
                    this.c = newInstance;
                    ((IServiceProxy) newInstance).create(this.d, objArr);
                } else {
                    this.c = this.f.invoke(null, objArr);
                }
                i.putIfAbsent(this.g.getName(), this.c);
            }
            wa2.b().d(this.b, this.c);
            return null;
        } catch (Exception e) {
            z01.c(h, "[GetInstanceReplyHandler][invoke]", e, "timeStamp", this.b);
            if (e instanceof IPCException) {
                throw ((IPCException) e);
            }
            throw new IPCException(24, e);
        }
    }
}
