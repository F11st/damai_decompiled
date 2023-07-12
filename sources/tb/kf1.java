package tb;

import android.content.ComponentName;
import android.text.TextUtils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.handler.reply.AbstractC6690a;
import com.taobao.aranger.core.ipc.channel.DefaultRemoteChannel;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import com.taobao.aranger.utils.C6702d;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.aranger.utils.ProxyRecoverProvider;
import com.taobao.aranger.utils.TypeUtils;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kf1 extends AbstractC6690a {
    private static final String f = "kf1";
    private String b;
    private Object c;
    private String d;
    private Method e;

    public kf1(Call call) throws IPCException {
        super(call);
        this.b = call.getServiceWrapper().getTimeStamp();
        b();
    }

    private void b() throws IPCException {
        Object c = wa2.b().c(this.b);
        this.c = c;
        if (c != null && (c instanceof IServiceProxy)) {
            this.d = TypeUtils.getMethodId(this.a.getMethodWrapper().getName(), this.a.getParameterWrappers());
        } else {
            this.e = C6702d.e().f(C6702d.e().a(this.a.getServiceWrapper()), this.a.getMethodWrapper(), this.a.getParameterWrappers());
        }
    }

    @Override // com.taobao.aranger.core.handler.reply.AbstractC6690a
    public Object a(Object[] objArr) throws IPCException {
        if (this.c == null) {
            try {
                String k = new DefaultRemoteChannel(IPCUtils.queryContentAuthorityFromProvider(new ComponentName(TextUtils.isEmpty(this.a.getCallingPackage()) ? ARanger.getContext().getPackageName() : this.a.getCallingPackage(), ProxyRecoverProvider.class.getName()))).k(this.b);
                if (!TextUtils.isEmpty(k)) {
                    this.b = k;
                    b();
                }
            } catch (Exception e) {
                z01.c(f, "[MethodInvokeReplyHandler][invoke] recover proxy error", e, "timeStamp", this.b);
            }
            if (this.c == null) {
                z01.d(f, "[MethodInvokeReplyHandler][invoke] proxy is null", "timeStamp", this.b);
                throw new IPCException(22, "can't find ipc object proxy");
            }
        }
        try {
            Object obj = this.c;
            return obj instanceof IServiceProxy ? ((IServiceProxy) obj).invoke(this.d, objArr) : this.e.invoke(obj, objArr);
        } catch (Exception e2) {
            z01.d(f, "[MethodInvokeReplyHandler][invoke]", "timeStamp", this.b);
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            }
            throw new IPCException(3, e2);
        }
    }
}
