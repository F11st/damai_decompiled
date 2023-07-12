package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class oa<T, E> implements RequestListener<T, E> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final wc2<T> a = new wc2<>();
    private final HashMap<String, AbstractC0818a> b = new HashMap<>();
    private final HashMap<String, List<RequestListener<T, E>>> c = new HashMap<>();

    private synchronized void a(String str, RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281031199")) {
            ipChange.ipc$dispatch("-1281031199", new Object[]{this, str, requestListener});
        } else if (requestListener == null) {
        } else {
            List<RequestListener<T, E>> list = this.c.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.c.put(str, list);
            }
            if (!list.contains(requestListener)) {
                list.add(requestListener);
            }
        }
    }

    private synchronized void f(kn1<E> kn1Var, @Nullable RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70585304")) {
            ipChange.ipc$dispatch("-70585304", new Object[]{this, kn1Var, requestListener});
            return;
        }
        k(kn1Var);
        String b = kn1Var.b();
        AbstractC0818a<T, E> e = e(kn1Var);
        if (e != null) {
            this.b.put(b, e);
            a(b, requestListener);
            e.c(this);
        }
    }

    private String g(kn1<E> kn1Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1044730429") ? (String) ipChange.ipc$dispatch("1044730429", new Object[]{this, kn1Var}) : kn1Var == null ? "" : kn1Var.getClass().getSimpleName();
    }

    public static void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1822376625")) {
            ipChange.ipc$dispatch("1822376625", new Object[]{str});
        } else {
            r92.f(str);
        }
    }

    private void j(kn1<E> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727214531")) {
            ipChange.ipc$dispatch("1727214531", new Object[]{this, kn1Var, str, str2});
        } else if (kn1Var != null) {
            i("onFail " + g(kn1Var) + " code=" + str + " msg=" + str2);
        }
    }

    private void k(kn1<E> kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-474137297")) {
            ipChange.ipc$dispatch("-474137297", new Object[]{this, kn1Var});
        } else if (AppConfig.v()) {
            i("fetch " + g(kn1Var) + " url=" + kn1Var.d());
        }
    }

    private void l(kn1<E> kn1Var, RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-90243784")) {
            ipChange.ipc$dispatch("-90243784", new Object[]{this, kn1Var, requestListener});
        } else if (AppConfig.v()) {
            i("load " + g(kn1Var) + " url=" + kn1Var.d());
        }
    }

    private void m(kn1<E> kn1Var, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571932801")) {
            ipChange.ipc$dispatch("-571932801", new Object[]{this, kn1Var, t});
        } else if (AppConfig.v()) {
            i("load " + g(kn1Var) + " 命中缓存数据直接返回 " + t.getClass().getSimpleName() + " data hash=" + t.hashCode());
        }
    }

    private void n(kn1<E> kn1Var, @Nullable RequestListener<T, E> requestListener) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40730202")) {
            ipChange.ipc$dispatch("40730202", new Object[]{this, kn1Var, requestListener});
        } else if (AppConfig.v()) {
            if (requestListener != null) {
                str = requestListener.getClass().getSimpleName() + "Listener入池等待";
            } else {
                str = "";
            }
            i("load " + g(kn1Var) + " 请求已存在" + str);
        }
    }

    private void o(kn1<E> kn1Var, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950562476")) {
            ipChange.ipc$dispatch("-1950562476", new Object[]{this, kn1Var, t});
        } else if (!AppConfig.v() || kn1Var == null || t == null) {
        } else {
            i("onSuccess " + g(kn1Var) + " T=" + t.getClass().getSimpleName() + " data hash=" + t.hashCode());
        }
    }

    public synchronized void b(kn1 kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119382355")) {
            ipChange.ipc$dispatch("119382355", new Object[]{this, kn1Var});
        } else if (kn1Var == null) {
        } else {
            String b = kn1Var.b();
            AbstractC0818a abstractC0818a = this.b.get(b);
            if (abstractC0818a != null) {
                abstractC0818a.a();
            }
            this.c.remove(b);
        }
    }

    public void c(kn1[] kn1VarArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399263352")) {
            ipChange.ipc$dispatch("-1399263352", new Object[]{this, kn1VarArr});
        } else if (kn1VarArr != null && kn1VarArr.length > 0) {
            for (kn1 kn1Var : kn1VarArr) {
                b(kn1Var);
            }
        }
    }

    public synchronized void d(List<kn1<?>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619470171")) {
            ipChange.ipc$dispatch("1619470171", new Object[]{this, list});
            return;
        }
        if (!cb2.d(list)) {
            this.a.a(list);
        }
    }

    public abstract AbstractC0818a<T, E> e(@NonNull kn1<E> kn1Var);

    public synchronized void h(kn1<E> kn1Var, @Nullable RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967020928")) {
            ipChange.ipc$dispatch("-1967020928", new Object[]{this, kn1Var, requestListener});
        } else if (kn1Var == null) {
        } else {
            l(kn1Var, requestListener);
            String b = kn1Var.b();
            if (this.b.get(b) != null) {
                n(kn1Var, requestListener);
                a(b, requestListener);
            } else if (kn1Var.e() && requestListener != null) {
                T b2 = this.a.b(kn1Var);
                if (b2 != null) {
                    m(kn1Var, b2);
                    requestListener.onSuccess(kn1Var, b2);
                } else {
                    f(kn1Var, requestListener);
                }
            } else {
                f(kn1Var, requestListener);
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public synchronized void onFail(kn1<E> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1855892214")) {
            ipChange.ipc$dispatch("-1855892214", new Object[]{this, kn1Var, str, str2});
            return;
        }
        j(kn1Var, str, str2);
        String b = kn1Var.b();
        this.b.remove(b);
        List<RequestListener<T, E>> list = this.c.get(b);
        this.c.remove(b);
        if (!cb2.d(list)) {
            for (RequestListener<T, E> requestListener : list) {
                requestListener.onFail(kn1Var, str, str2);
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public synchronized void onSuccess(kn1<E> kn1Var, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278978323")) {
            ipChange.ipc$dispatch("-278978323", new Object[]{this, kn1Var, t});
            return;
        }
        o(kn1Var, t);
        String b = kn1Var.b();
        this.b.remove(b);
        this.a.d(kn1Var, t);
        List<RequestListener<T, E>> list = this.c.get(b);
        this.c.remove(b);
        if (!cb2.d(list)) {
            for (RequestListener<T, E> requestListener : list) {
                requestListener.onSuccess(kn1Var, t);
            }
        }
    }

    public synchronized void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704074774")) {
            ipChange.ipc$dispatch("-1704074774", new Object[]{this});
        } else {
            this.a.e();
        }
    }

    public synchronized void q(kn1 kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428479695")) {
            ipChange.ipc$dispatch("-428479695", new Object[]{this, kn1Var});
        } else if (kn1Var == null) {
        } else {
            this.c.remove(kn1Var.b());
        }
    }
}
