package com.alibaba.mobsec.privacydoublelist.b;

import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.b.c;
import com.alibaba.mobsec.privacydoublelist.config.ConfigCenter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class b implements InvocationHandler {
    public final /* synthetic */ c.a a;

    public b(c.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            if (PdlEnvUtils.a) {
                Log.d("AOP-OrangeConfigHelper", "In OrangeListener: " + method.getName() + " called");
            }
        } catch (Throwable th) {
            if (PdlEnvUtils.a) {
                Log.e("AOP-OrangeConfigHelper", "", th);
            }
        }
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (method.getName().equals("onConfigUpdate") && objArr != null && objArr.length >= 2) {
            ((ConfigCenter.a) this.a).a((String) objArr[0], (Map) objArr[1]);
            return null;
        }
        return null;
    }
}
