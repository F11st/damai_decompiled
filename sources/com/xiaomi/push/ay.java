package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ay implements au {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f115a;

    /* renamed from: a  reason: collision with other field name */
    private Object f116a;

    /* renamed from: a  reason: collision with other field name */
    private Method f117a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public ay(Context context) {
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f116a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            AbstractC7535b.a("miui invoke error", e);
            return null;
        }
    }

    private void a(Context context) {
        try {
            Class<?> a = C7786v.a(context, "com.android.id.impl.IdProviderImpl");
            this.f115a = a;
            this.f116a = a.newInstance();
            this.f117a = this.f115a.getMethod("getUDID", Context.class);
            this.b = this.f115a.getMethod("getOAID", Context.class);
            this.c = this.f115a.getMethod("getVAID", Context.class);
            this.d = this.f115a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            AbstractC7535b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public String mo670a() {
        return a(this.a, this.b);
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public boolean mo671a() {
        return (this.f115a == null || this.f116a == null) ? false : true;
    }
}
