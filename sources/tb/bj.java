package tb;

import cn.damai.commonbusiness.citycopy.model.HotCityBean;
import cn.damai.commonbusiness.citycopy.model.SitesBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class bj {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int GROUP_CITY = 2;
    public static final int HOT_CITY = 1;
    public static final int LOCATION_CITY = 0;
    public static final int LOC_CITY_STATUS_HAS_LOCATION = 136;
    public static final int LOC_CITY_STATUS_IN_LOCATION = 119;
    public static final int LOC_CITY_STATUS_NONE_PERMISSION = 102;
    private int a;
    private SitesBean b;
    public int c;
    private List<HotCityBean> d;
    private List<SitesBean> e;

    public bj(int i) {
        this.a = i;
    }

    public List<HotCityBean> a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1546452900") ? (List) ipChange.ipc$dispatch("1546452900", new Object[]{this}) : this.d;
    }

    public SitesBean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "403011222") ? (SitesBean) ipChange.ipc$dispatch("403011222", new Object[]{this}) : this.b;
    }

    public List<SitesBean> c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1652231121") ? (List) ipChange.ipc$dispatch("-1652231121", new Object[]{this}) : this.e;
    }

    public int d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1432088712") ? ((Integer) ipChange.ipc$dispatch("1432088712", new Object[]{this})).intValue() : this.a;
    }

    public void e(List<HotCityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202653376")) {
            ipChange.ipc$dispatch("-202653376", new Object[]{this, list});
        } else {
            this.d = list;
        }
    }

    public void f(SitesBean sitesBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "547393130")) {
            ipChange.ipc$dispatch("547393130", new Object[]{this, sitesBean});
        } else {
            this.b = sitesBean;
        }
    }

    public void g(List<SitesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343661693")) {
            ipChange.ipc$dispatch("1343661693", new Object[]{this, list});
        } else {
            this.e = list;
        }
    }
}
