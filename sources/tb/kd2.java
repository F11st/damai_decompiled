package tb;

import android.text.TextUtils;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class kd2 {
    private Comparator<jd2> d;
    private IStrategyFilter e;
    private String c = "";
    private int f = 0;
    private boolean g = false;
    private List<jd2> a = new ArrayList();
    private Set<String> b = new HashSet();

    /* compiled from: Taobao */
    /* renamed from: tb.kd2$a */
    /* loaded from: classes5.dex */
    class C9347a implements Comparator<jd2> {
        C9347a(kd2 kd2Var) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(jd2 jd2Var, jd2 jd2Var2) {
            return jd2Var.b() - jd2Var2.b();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.kd2$b */
    /* loaded from: classes5.dex */
    class C9348b implements IStrategyFilter {
        C9348b(kd2 kd2Var) {
        }

        @Override // anet.channel.strategy.IStrategyFilter
        public boolean accept(IConnStrategy iConnStrategy) {
            return iConnStrategy.getIpType() == 0 && iConnStrategy.getIpSource() == 0 && iConnStrategy.getPort() == 443;
        }
    }

    public kd2() {
        this.d = null;
        this.e = null;
        this.d = new C9347a(this);
        this.e = new C9348b(this);
    }

    private void a() {
        List<IConnStrategy> c = c();
        e(c);
        if (c != null && c.size() != 0) {
            boolean h = h(c);
            Logger.f("SipStrategyList", "shouldRefreshList", Boolean.valueOf(h));
            if (h) {
                this.a.clear();
                this.b.clear();
                vo2.b().g(c.size());
                for (IConnStrategy iConnStrategy : c) {
                    String ip = iConnStrategy.getIp();
                    this.a.add(new jd2(ip, iConnStrategy.getPort()));
                    this.b.add(ip);
                }
                return;
            }
            return;
        }
        this.a.clear();
        this.b.clear();
        vo2.b().g(0);
    }

    private List<IConnStrategy> c() {
        return C0213a.a().getConnStrategyListByHost(ro2.a().getTnetHostPort().a(), this.e);
    }

    private void e(List<IConnStrategy> list) {
        if (Logger.n()) {
            if (list != null && list.size() != 0) {
                for (IConnStrategy iConnStrategy : list) {
                    Logger.f("SipStrategyList", TbAuthConstants.IP, iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()), "IpType", Integer.valueOf(iConnStrategy.getIpType()), "IpSource", Integer.valueOf(iConnStrategy.getIpSource()));
                }
                return;
            }
            Logger.f("SipStrategyList", "connStrategyList is Empty");
        }
    }

    private void f() {
        if (Logger.n()) {
            List<jd2> list = this.a;
            if (list != null && list.size() != 0) {
                for (jd2 jd2Var : this.a) {
                    Logger.f("SipStrategyList", TbAuthConstants.IP, jd2Var.c(), h23.POINT_FAIL_COUNT_MEASURE, Integer.valueOf(jd2Var.b()));
                }
                Logger.f("SipStrategyList", "amdcSipFailCountAll", Integer.valueOf(this.f), "AmdcSipFailCountAll config", Integer.valueOf(w52.d().b()));
                return;
            }
            Logger.f("", "sipConnStrategyList is Empty");
        }
    }

    private boolean h(List<IConnStrategy> list) {
        if (this.a.size() != list.size()) {
            return true;
        }
        for (IConnStrategy iConnStrategy : list) {
            if (!this.b.contains(iConnStrategy.getIp())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if (this.g) {
            return 0;
        }
        List<IConnStrategy> c = c();
        e(c);
        if (c != null) {
            return c.size();
        }
        return 0;
    }

    public qo2 d() {
        if (this.f >= w52.d().b()) {
            this.g = true;
            this.c = "";
            return null;
        }
        try {
            a();
        } catch (Throwable th) {
            Logger.h("SipStrategyList", th, new Object[0]);
        }
        List<jd2> list = this.a;
        if (list != null && !list.isEmpty()) {
            jd2 jd2Var = this.a.get(0);
            if (jd2Var == null) {
                this.c = "";
                return null;
            } else if (jd2Var.b() >= w52.d().a()) {
                this.c = "";
                return null;
            } else {
                qo2 qo2Var = new qo2();
                qo2Var.e(jd2Var.c());
                qo2Var.h(2);
                qo2Var.g(2);
                this.c = jd2Var.c();
                return qo2Var;
            }
        }
        this.c = "";
        return null;
    }

    public void g(boolean z) {
        List<jd2> list;
        jd2 jd2Var;
        if (TextUtils.isEmpty(this.c) || (list = this.a) == null || list.isEmpty() || (jd2Var = this.a.get(0)) == null || !this.c.equalsIgnoreCase(jd2Var.c())) {
            return;
        }
        if (z) {
            jd2Var.d(0);
            this.f = 0;
        } else {
            jd2Var.a();
            this.f++;
            Collections.sort(this.a, this.d);
        }
        f();
    }
}
