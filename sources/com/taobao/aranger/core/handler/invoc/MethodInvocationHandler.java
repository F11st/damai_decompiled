package com.taobao.aranger.core.handler.invoc;

import android.net.Uri;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.annotation.method.MethodName;
import com.taobao.aranger.annotation.method.oneway;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.channel.b;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.core.wrapper.ServiceWrapper;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.utils.TypeUtils;
import com.taobao.aranger.utils.a;
import java.lang.reflect.Method;
import tb.qh;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MethodInvocationHandler extends IPCInvocationHandler {
    private final ServiceWrapper b;
    private final Uri c;
    private final b d;
    private final boolean e;

    public MethodInvocationHandler(ServiceWrapper serviceWrapper, Uri uri, boolean z) {
        this.b = serviceWrapper;
        this.c = uri;
        this.e = z;
        serviceWrapper.setType(3);
        this.d = qh.b(uri);
    }

    @Override // com.taobao.aranger.core.handler.invoc.IPCInvocationHandler
    public Reply a(Method method, Object[] objArr) throws IPCException {
        ParameterWrapper[] b = a.b(method, objArr);
        MethodName methodName = (MethodName) method.getAnnotation(MethodName.class);
        return this.d.f(Call.obtain().setServiceWrapper(this.b).setParameterWrappers(b).setMethodWrapper(MethodWrapper.obtain().setMethodName(methodName == null ? method.getName() : methodName.value()).setReturnType(TypeUtils.getClassId(method.getReturnType()))).setRemoteProviderUri(this.c).setIsSameApp(this.e).setCallingPackage(ARanger.getContext().getPackageName()).setVoid(Constants.VOID.equals(method.getReturnType().getName())).setOneWay(method.getAnnotation(oneway.class) != null));
    }

    @Override // com.taobao.aranger.core.handler.invoc.IPCInvocationHandler, java.lang.reflect.InvocationHandler
    @Keep
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Method method, Object[] objArr) throws IPCException {
        return super.invoke(obj, method, objArr);
    }

    @NonNull
    public String toString() {
        return this.b.getTimeStamp();
    }
}
