package cn.damai.common.badge.update;

import android.text.TextUtils;
import cn.damai.common.badge.bean.BadgeMarkResponse;
import cn.damai.common.badge.bean.BadgeNodeItem;
import cn.damai.common.badge.bean.BadgeQueryResponse;
import cn.damai.common.badge.listener.BadgeListenerManager;
import cn.damai.common.badge.request.BadgeMTopCallback;
import cn.damai.common.badge.request.BadgeMTopRequestHelper;
import cn.damai.common.badge.update.BadgeLoginMonitor;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;
import tb.ba;
import tb.lk;
import tb.y9;
import tb.z9;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class a implements BadgeLoginMonitor.LoginCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private BadgeListenerManager c;
    private y9 b = new y9();
    private BadgeMTopRequestHelper a = new BadgeMTopRequestHelper();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.badge.update.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0022a implements BadgeMTopCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;

        C0022a(List list) {
            this.a = list;
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void failed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1698801704")) {
                ipChange.ipc$dispatch("-1698801704", new Object[]{this, str, str2});
            } else {
                a.this.c.notifyFailListener(this.a, str, str2);
            }
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void success(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-127975998")) {
                ipChange.ipc$dispatch("-127975998", new Object[]{this, obj});
            } else if (obj == null || !(obj instanceof BadgeQueryResponse)) {
            } else {
                a.this.e((BadgeQueryResponse) obj);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements BadgeMTopCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void failed(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1706561063")) {
                ipChange.ipc$dispatch("-1706561063", new Object[]{this, str, str2});
            } else {
                a.this.c.notifyFailListener(this.a, str, str2);
            }
        }

        @Override // cn.damai.common.badge.request.BadgeMTopCallback
        public void success(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2138079839")) {
                ipChange.ipc$dispatch("-2138079839", new Object[]{this, obj});
                return;
            }
            BadgeMarkResponse badgeMarkResponse = (BadgeMarkResponse) obj;
            if (badgeMarkResponse == null) {
                return;
            }
            a.this.d(badgeMarkResponse);
        }
    }

    public a(BadgeListenerManager badgeListenerManager) {
        this.c = badgeListenerManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(BadgeMarkResponse badgeMarkResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145348926")) {
            ipChange.ipc$dispatch("145348926", new Object[]{this, badgeMarkResponse});
            return;
        }
        for (BadgeNodeItem badgeNodeItem : ba.a(badgeMarkResponse)) {
            if (badgeNodeItem != null && badgeNodeItem.getNodeId() != null && this.b.a(badgeNodeItem)) {
                h(badgeNodeItem);
                this.b.f(badgeNodeItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(BadgeQueryResponse badgeQueryResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169761765")) {
            ipChange.ipc$dispatch("-1169761765", new Object[]{this, badgeQueryResponse});
            return;
        }
        for (BadgeNodeItem badgeNodeItem : ba.b(badgeQueryResponse)) {
            if (badgeNodeItem != null && badgeNodeItem.getNodeId() != null && this.b.a(badgeNodeItem)) {
                h(badgeNodeItem);
                this.b.f(badgeNodeItem);
            }
        }
    }

    private void h(BadgeNodeItem badgeNodeItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133469550")) {
            ipChange.ipc$dispatch("1133469550", new Object[]{this, badgeNodeItem});
        } else if (badgeNodeItem == null) {
        } else {
            this.c.notifyListener(badgeNodeItem.getNodeId(), badgeNodeItem);
        }
    }

    private void i(List<String> list) {
        BadgeNodeItem badgeNodeItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075015464")) {
            ipChange.ipc$dispatch("1075015464", new Object[]{this, list});
        } else if (list == null) {
        } else {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                BadgeNodeItem e = this.b.e(it.next());
                if (e != null) {
                    if (e.getCount() == 0) {
                        h(e);
                        it.remove();
                    } else if (e.getElimination() == 0 && (badgeNodeItem = (BadgeNodeItem) e.clone()) != null) {
                        badgeNodeItem.setCount(0);
                        badgeNodeItem.setVersion(badgeNodeItem.getVersion() + 1);
                        h(badgeNodeItem);
                        this.b.f(badgeNodeItem);
                    }
                }
            }
        }
    }

    public void f(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975221194")) {
            ipChange.ipc$dispatch("-975221194", new Object[]{this, list});
        } else if (list == null || list.size() == 0) {
        } else {
            i(list);
            if (list.size() == 0) {
                return;
            }
            this.a.c(JSON.toJSONString(list), new b(list));
        }
    }

    public void g(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868186042")) {
            ipChange.ipc$dispatch("1868186042", new Object[]{this, strArr});
        } else if (strArr == null || strArr.length == 0) {
        } else {
            f(lk.a(strArr));
        }
    }

    public void j(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525211773")) {
            ipChange.ipc$dispatch("525211773", new Object[]{this, list});
        } else if (list == null || list.size() == 0) {
        } else {
            this.a.e(JSON.toJSONString(list), new C0022a(list));
        }
    }

    public void k(String str) {
        BadgeNodeItem c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777367471")) {
            ipChange.ipc$dispatch("-777367471", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || (c = this.b.c(str)) == null) {
        } else {
            h(c);
        }
    }

    public void l(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546234168")) {
            ipChange.ipc$dispatch("1546234168", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            for (String str : list) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                BadgeNodeItem c = this.b.c(str);
                if (c != null) {
                    h(c);
                }
            }
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor.LoginCallback
    public void onLoginSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1950697051")) {
            ipChange.ipc$dispatch("1950697051", new Object[]{this});
            return;
        }
        z9.c();
        y9 y9Var = this.b;
        if (y9Var != null) {
            y9Var.b();
        }
    }

    @Override // cn.damai.common.badge.update.BadgeLoginMonitor.LoginCallback
    public void onLogoutSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941126084")) {
            ipChange.ipc$dispatch("-1941126084", new Object[]{this});
            return;
        }
        z9.c();
        y9 y9Var = this.b;
        if (y9Var != null) {
            y9Var.b();
        }
    }
}
