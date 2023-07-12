package cn.damai.commonbusiness.citycopy.util;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.commonbusiness.citycopy.model.GroupsBean;
import cn.damai.commonbusiness.citycopy.model.HotCityBean;
import cn.damai.commonbusiness.citycopy.model.SitesBean;
import cn.damai.commonbusiness.citycopy.net.CityListResponse;
import com.alibaba.pictures.bricks.channel.bean.LocationInfo;
import com.alibaba.pictures.bricks.channel.bean.NewLocationInfo;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ap2;
import tb.bb2;
import tb.ga1;
import tb.gm;
import tb.ia1;
import tb.vh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CityLocationUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    public LocaltionListener b;
    private long c;
    private Double d;
    private Double e;
    private String f;
    private String g;
    private boolean h = false;
    private boolean i = true;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface LocaltionListener {
        void onGetLocalFinsih();

        void onGetLocalSuccess(SitesBean sitesBean);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements LocateGpsPicListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.piclocation.listener.LocateGpsPicListener
        public void onFailed(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1539253406")) {
                ipChange.ipc$dispatch("1539253406", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            LocaltionListener localtionListener = CityLocationUtil.this.b;
            if (localtionListener != null) {
                localtionListener.onGetLocalFinsih();
            }
        }

        @Override // com.alibaba.pictures.piclocation.listener.LocateGpsPicListener
        public void onLocationSuccess(ga1 ga1Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "323497185")) {
                ipChange.ipc$dispatch("323497185", new Object[]{this, ga1Var});
                return;
            }
            CityLocationUtil.this.d = Double.valueOf(ga1Var.a);
            CityLocationUtil.this.e = Double.valueOf(ga1Var.b);
            CityLocationUtil.this.f = ga1Var.e;
            CityLocationUtil.this.g = ga1Var.d;
            if (CityLocationUtil.this.d.doubleValue() == 0.0d || CityLocationUtil.this.e.doubleValue() == 0.0d || TextUtils.isEmpty(CityLocationUtil.this.g)) {
                CityLocationUtil.this.d = Double.valueOf(39.907325d);
                CityLocationUtil.this.e = Double.valueOf(116.39145d);
                CityLocationUtil.this.f = "北京市天安门";
                CityLocationUtil.this.g = "北京";
                return;
            }
            if (!TextUtils.isEmpty(CityLocationUtil.this.g) && CityLocationUtil.this.g.endsWith("市") && CityLocationUtil.this.g.length() > 1) {
                CityLocationUtil cityLocationUtil = CityLocationUtil.this;
                cityLocationUtil.g = cityLocationUtil.g.substring(0, CityLocationUtil.this.g.length() - 1);
            }
            CityLocationUtil cityLocationUtil2 = CityLocationUtil.this;
            long l = cityLocationUtil2.l(cityLocationUtil2.g);
            if (l != 0) {
                CityLocationUtil.this.c = l;
                if (CityLocationUtil.this.b != null) {
                    SitesBean sitesBean = new SitesBean();
                    sitesBean.setCityId(l + "");
                    sitesBean.setCityName(CityLocationUtil.this.g);
                    CityLocationUtil.this.b.onGetLocalSuccess(sitesBean);
                }
                if (CityLocationUtil.this.i) {
                    CityLocationUtil.this.n();
                }
                if (CityLocationUtil.this.h) {
                    return;
                }
                CityLocationUtil.this.p();
            }
        }
    }

    public CityLocationUtil(Context context, LocaltionListener localtionListener) {
        this.a = context;
        this.b = localtionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111973266")) {
            return ((Long) ipChange.ipc$dispatch("-2111973266", new Object[]{this, str})).longValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            try {
                CityListResponse localCityList = gm.INSTANCE.a().getLocalCityList();
                if (localCityList == null) {
                    return 0L;
                }
                List<GroupsBean> groups = localCityList.getGroups();
                if (bb2.c(groups) <= 0) {
                    return 0L;
                }
                for (int i = 0; i < groups.size(); i++) {
                    GroupsBean groupsBean = groups.get(i);
                    if (groupsBean != null) {
                        List<SitesBean> sites = groupsBean.getSites();
                        if (bb2.c(sites) > 0) {
                            for (int i2 = 0; i2 < sites.size(); i2++) {
                                SitesBean sitesBean = sites.get(i2);
                                if (sitesBean != null && !TextUtils.isEmpty(sitesBean.getCityName()) && sitesBean.getCityName().equals(str) && !TextUtils.isEmpty(sitesBean.getCityId()) && !TextUtils.isEmpty(sitesBean.getCityId().trim())) {
                                    return vh2.INSTANCE.g(sitesBean.getCityId(), 0L);
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
                List<HotCityBean> hotCity = localCityList.getHotCity();
                if (bb2.c(groups) <= 0) {
                    return 0L;
                }
                for (int i3 = 0; i3 < hotCity.size(); i3++) {
                    HotCityBean hotCityBean = hotCity.get(i3);
                    if (hotCityBean != null && !TextUtils.isEmpty(hotCityBean.getCityName()) && hotCityBean.getCityName().equals(str) && !TextUtils.isEmpty(hotCityBean.getCityId()) && !TextUtils.isEmpty(hotCityBean.getCityId().trim())) {
                        return Integer.parseInt(hotCityBean.getCityId());
                    }
                }
                return 0L;
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-190255887")) {
            ipChange.ipc$dispatch("-190255887", new Object[]{this});
        } else if (ap2.INSTANCE.e(this.a)) {
            ia1.INSTANCE.c().startLocationWithCacheTime(new a(), 0L);
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432976862")) {
            ipChange.ipc$dispatch("432976862", new Object[]{this});
            return;
        }
        long j = this.c;
        if (j != 0) {
            gm.INSTANCE.a().saveLocationInfo(new LocationInfo(j, this.d.doubleValue(), this.e.doubleValue(), this.f, this.g));
        }
    }

    public void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1400358696")) {
            ipChange.ipc$dispatch("1400358696", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.h = z;
        }
    }

    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1717095073")) {
            ipChange.ipc$dispatch("1717095073", new Object[]{this});
            return;
        }
        long j = this.c;
        if (j != 0) {
            gm.INSTANCE.a().setNewLocationData(new NewLocationInfo(j, this.g, this.d.doubleValue(), this.e.doubleValue()));
        }
    }
}
