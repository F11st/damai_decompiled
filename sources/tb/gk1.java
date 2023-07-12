package tb;

import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.handler.reply.AbstractC6690a;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import com.taobao.aranger.utils.C6702d;
import com.taobao.aranger.utils.TypeUtils;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gk1 extends AbstractC6690a {
    private static final String f = "gk1";
    private final String b;
    private String c;
    private Constructor<?> d;
    private Constructor<?> e;

    public gk1(Call call) throws IPCException {
        super(call);
        Class<?> cls;
        boolean z;
        this.b = call.getServiceWrapper().getTimeStamp();
        Class<?> a = C6702d.e().a(call.getServiceWrapper());
        try {
            C6702d e = C6702d.e();
            cls = e.b(a.getName() + Constants.PROXY_SUFFIX);
            z = true;
        } catch (IPCException unused) {
            cls = null;
            z = false;
        }
        if (z) {
            this.c = TypeUtils.getMethodId(a.getSimpleName(), call.getParameterWrappers());
            this.d = TypeUtils.getConstructor(cls, new Class[0]);
            return;
        }
        this.e = TypeUtils.getConstructor(a, C6702d.e().c(call.getParameterWrappers()));
    }

    @Override // com.taobao.aranger.core.handler.reply.AbstractC6690a
    public Object a(Object[] objArr) throws IPCException {
        Object newInstance;
        try {
            Constructor<?> constructor = this.d;
            if (constructor != null) {
                newInstance = constructor.newInstance(new Object[0]);
                ((IServiceProxy) newInstance).create(this.c, objArr);
            } else if (objArr.length == 0) {
                newInstance = this.e.newInstance(new Object[0]);
            } else {
                newInstance = this.e.newInstance(objArr);
            }
            wa2.b().d(this.b, newInstance);
            return null;
        } catch (Exception e) {
            z01.c(f, "[NewInstanceReplyHandler][invoke]", e, "timeStamp", this.b);
            if (e instanceof IPCException) {
                throw ((IPCException) e);
            }
            throw new IPCException(23, e);
        }
    }
}
