package de.greenrobot.event;

import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class e {
    final Method a;
    final ThreadMode b;
    final Class<?> c;
    String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Method method, ThreadMode threadMode, Class<?> cls) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
    }

    private synchronized void a() {
        if (this.d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.d = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            a();
            e eVar = (e) obj;
            eVar.a();
            return this.d.equals(eVar.d);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
