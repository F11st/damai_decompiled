package tb;

import android.taobao.windvane.util.FixedSizeLinkedHashMap;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class wc2<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long a = -1;
    private final FixedSizeLinkedHashMap<String, T> b = new FixedSizeLinkedHashMap<>(3);
    private final FixedSizeLinkedHashMap<String, SoftReference<T>> c = new FixedSizeLinkedHashMap<>(5);

    private void c() {
        int size;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1997262817")) {
            ipChange.ipc$dispatch("-1997262817", new Object[]{this});
        } else if (AppConfig.v() && (size = this.c.size()) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("缓存软引用数量:");
            sb.append(size);
            sb.append(",");
            sb.append(jn1.BLOCK_START_STR);
            for (Map.Entry<String, SoftReference<T>> entry : this.c.entrySet()) {
                T t = entry.getValue().get();
                if (t != null) {
                    sb.append(t.getClass().getSimpleName());
                    sb.append(m80.DINAMIC_PREFIX_AT);
                    sb.append(t.hashCode());
                    sb.append(",");
                }
            }
            sb.append("}");
            r92.f(sb.toString());
        }
    }

    public synchronized void a(List<kn1<?>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332443161")) {
            ipChange.ipc$dispatch("-332443161", new Object[]{this, list});
            return;
        }
        if (!cb2.d(list)) {
            for (kn1<?> kn1Var : list) {
                String b = kn1Var.b();
                long c = kn1Var.c();
                this.c.remove(b);
                this.b.remove(b);
                if (this.a == c) {
                    this.a = -1L;
                }
            }
        }
    }

    @Nullable
    public synchronized T b(kn1 kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501738745")) {
            return (T) ipChange.ipc$dispatch("-501738745", new Object[]{this, kn1Var});
        }
        SoftReference<T> softReference = this.c.get(kn1Var.b());
        return softReference != null ? softReference.get() : null;
    }

    public synchronized void d(kn1 kn1Var, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1958332832")) {
            ipChange.ipc$dispatch("1958332832", new Object[]{this, kn1Var, t});
            return;
        }
        long c = kn1Var.c();
        String b = kn1Var.b();
        if (c == this.a) {
            this.b.remove(b);
            this.b.put(b, t);
        } else {
            this.a = c;
            this.b.clear();
            this.b.put(b, t);
        }
        this.c.remove(b);
        this.c.put(b, new SoftReference<>(t));
        c();
    }

    public synchronized void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401774222")) {
            ipChange.ipc$dispatch("-401774222", new Object[]{this});
            return;
        }
        this.a = -1L;
        this.b.clear();
    }
}
