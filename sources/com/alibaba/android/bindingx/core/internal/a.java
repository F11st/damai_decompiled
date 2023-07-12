package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.taobao.weex.common.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tb.bb1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class a extends AbstractEventHandler {
    protected int n;
    protected int o;
    private boolean p;

    public a(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.p = false;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void e(@NonNull Map<String, Object> map) {
        i("exit", ((Double) map.get("internal_x")).doubleValue(), ((Double) map.get("internal_y")).doubleValue(), 0.0d, 0.0d, 0.0d, 0.0d, new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    protected void f(String str, @NonNull Map<String, Object> map) {
        i("interceptor", ((Double) map.get("internal_x")).doubleValue(), ((Double) map.get("internal_y")).doubleValue(), ((Double) map.get("dx")).doubleValue(), ((Double) map.get(Constants.Name.DISTANCE_Y)).doubleValue(), ((Double) map.get("tdx")).doubleValue(), ((Double) map.get("tdy")).doubleValue(), Collections.singletonMap("interceptor", str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(String str, double d, double d2, double d3, double d4, double d5, double d6, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            double nativeToWeb = this.h.e().nativeToWeb(d, new Object[0]);
            double nativeToWeb2 = this.h.e().nativeToWeb(d2, new Object[0]);
            hashMap.put(Constants.Name.X, Double.valueOf(nativeToWeb));
            hashMap.put(Constants.Name.Y, Double.valueOf(nativeToWeb2));
            double nativeToWeb3 = this.h.e().nativeToWeb(d3, new Object[0]);
            double nativeToWeb4 = this.h.e().nativeToWeb(d4, new Object[0]);
            hashMap.put("dx", Double.valueOf(nativeToWeb3));
            hashMap.put(Constants.Name.DISTANCE_Y, Double.valueOf(nativeToWeb4));
            double nativeToWeb5 = this.h.e().nativeToWeb(d5, new Object[0]);
            double nativeToWeb6 = this.h.e().nativeToWeb(d6, new Object[0]);
            hashMap.put("tdx", Double.valueOf(nativeToWeb5));
            hashMap.put("tdy", Double.valueOf(nativeToWeb6));
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            bb1.a(">>>>>>>>>>>fire event:(" + str + "," + nativeToWeb + "," + nativeToWeb2 + "," + nativeToWeb3 + "," + nativeToWeb4 + "," + nativeToWeb5 + "," + nativeToWeb6 + jn1.BRACKET_END_STR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        k(i, i2, i3, i4, i5, i6, "scroll");
    }

    protected void k(int i, int i2, int i3, int i4, int i5, int i6, String str) {
        a aVar;
        if (bb1.a) {
            bb1.a(String.format(Locale.getDefault(), "[ScrollHandler] scroll changed. (contentOffsetX:%d,contentOffsetY:%d,dx:%d,dy:%d,tdx:%d,tdy:%d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)));
        }
        this.n = i;
        this.o = i2;
        if (this.p) {
            aVar = this;
        } else {
            this.p = true;
            aVar = this;
            aVar.i("start", i, i2, i3, i4, i5, i6, new Object[0]);
        }
        try {
            JSMath.applyScrollValuesToScope(aVar.d, i, i2, i3, i4, i5, i6, aVar.h.e());
            if (aVar.d(aVar.j, aVar.d)) {
                return;
            }
            aVar.c(aVar.a, aVar.d, str);
        } catch (Exception e) {
            bb1.c("runtime error", e);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        this.p = false;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    @CallSuper
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        b();
        this.p = false;
        i("end", this.n, this.o, 0.0d, 0.0d, 0.0d, 0.0d, new Object[0]);
        return true;
    }
}
