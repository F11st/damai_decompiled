package tb;

import android.database.Cursor;
import cn.damai.common.db.db.annotation.Column;
import cn.damai.common.db.db.converter.ColumnConverter;
import cn.damai.common.db.db.sqlite.ColumnDbType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class uk {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final String a;
    private final String b;
    private final boolean c;
    private final boolean d;
    protected final Method e;
    protected final Method f;
    protected final Field g;
    protected final ColumnConverter h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public uk(Class<?> cls, Field field, Column column) {
        field.setAccessible(true);
        this.g = field;
        this.a = column.name();
        this.b = column.property();
        boolean isId = column.isId();
        this.c = isId;
        Class<?> type = field.getType();
        this.d = isId && column.autoGen() && wk.f(type);
        this.h = tk.a(type);
        Method d = wk.d(cls, field);
        this.e = d;
        if (d != null && !d.isAccessible()) {
            d.setAccessible(true);
        }
        Method e = wk.e(cls, field);
        this.f = e;
        if (e == null || e.isAccessible()) {
            return;
        }
        e.setAccessible(true);
    }

    public ColumnDbType a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "247721047") ? (ColumnDbType) ipChange.ipc$dispatch("247721047", new Object[]{this}) : this.h.getColumnDbType();
    }

    public Object b(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139151005")) {
            return ipChange.ipc$dispatch("-2139151005", new Object[]{this, obj});
        }
        Object c = c(obj);
        if (this.d && (c.equals(0L) || c.equals(0))) {
            return null;
        }
        return this.h.fieldValue2DbValue(c);
    }

    public Object c(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942283025")) {
            return ipChange.ipc$dispatch("1942283025", new Object[]{this, obj});
        }
        if (obj != null) {
            Method method = this.e;
            if (method != null) {
                try {
                    return method.invoke(obj, new Object[0]);
                } catch (Throwable th) {
                    gb1.c(th.getMessage(), th);
                    return null;
                }
            }
            try {
                return this.g.get(obj);
            } catch (Throwable th2) {
                gb1.c(th2.getMessage(), th2);
                return null;
            }
        }
        return null;
    }

    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1954721713") ? (String) ipChange.ipc$dispatch("-1954721713", new Object[]{this}) : this.a;
    }

    public String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "919914009") ? (String) ipChange.ipc$dispatch("919914009", new Object[]{this}) : this.b;
    }

    public boolean f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "50375176") ? ((Boolean) ipChange.ipc$dispatch("50375176", new Object[]{this})).booleanValue() : this.d;
    }

    public boolean g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1318004471") ? ((Boolean) ipChange.ipc$dispatch("1318004471", new Object[]{this})).booleanValue() : this.c;
    }

    public void h(Object obj, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148996885")) {
            ipChange.ipc$dispatch("148996885", new Object[]{this, obj, Long.valueOf(j)});
            return;
        }
        Object valueOf = Long.valueOf(j);
        if (wk.h(this.g.getType())) {
            valueOf = Integer.valueOf((int) j);
        }
        Method method = this.f;
        if (method != null) {
            try {
                method.invoke(obj, valueOf);
                return;
            } catch (Throwable th) {
                gb1.c(th.getMessage(), th);
                return;
            }
        }
        try {
            this.g.set(obj, valueOf);
        } catch (Throwable th2) {
            gb1.c(th2.getMessage(), th2);
        }
    }

    public void i(Object obj, Cursor cursor, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952235055")) {
            ipChange.ipc$dispatch("-1952235055", new Object[]{this, obj, cursor, Integer.valueOf(i)});
            return;
        }
        Object fieldValue = this.h.getFieldValue(cursor, i);
        if (fieldValue == null) {
            return;
        }
        Method method = this.f;
        if (method != null) {
            try {
                method.invoke(obj, fieldValue);
                return;
            } catch (Throwable th) {
                gb1.c(th.getMessage(), th);
                return;
            }
        }
        try {
            this.g.set(obj, fieldValue);
        } catch (Throwable th2) {
            gb1.c(th2.getMessage(), th2);
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1955934060") ? (String) ipChange.ipc$dispatch("-1955934060", new Object[]{this}) : this.a;
    }
}
