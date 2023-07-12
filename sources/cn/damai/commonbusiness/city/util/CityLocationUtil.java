package cn.damai.commonbusiness.city.util;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.city.model.GroupsBean;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.net.CityListResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ga1;
import tb.ia1;
import tb.ir1;
import tb.mr1;
import tb.mu0;
import tb.wh2;
import tb.z20;

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
            if (AndroidInstantRuntime.support(ipChange, "1832440435")) {
                ipChange.ipc$dispatch("1832440435", new Object[]{this, Integer.valueOf(i), str});
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
            if (AndroidInstantRuntime.support(ipChange, "-1240161866")) {
                ipChange.ipc$dispatch("-1240161866", new Object[]{this, ga1Var});
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
            if (!TextUtils.isEmpty(CityLocationUtil.this.g) && CityLocationUtil.this.g.endsWith(CityLocationUtil.this.a.getString(R$string.unit_name_city)) && CityLocationUtil.this.g.length() > 1) {
                CityLocationUtil cityLocationUtil = CityLocationUtil.this;
                cityLocationUtil.g = cityLocationUtil.g.substring(0, CityLocationUtil.this.g.length() - 1);
            }
            CityLocationUtil cityLocationUtil2 = CityLocationUtil.this;
            long m = cityLocationUtil2.m(cityLocationUtil2.g);
            if (m != 0) {
                CityLocationUtil.this.c = m;
                if (CityLocationUtil.this.b != null) {
                    SitesBean sitesBean = new SitesBean();
                    sitesBean.setCityId(m + "");
                    sitesBean.setCityName(CityLocationUtil.this.g);
                    CityLocationUtil.this.b.onGetLocalSuccess(sitesBean);
                }
                if (CityLocationUtil.this.i) {
                    CityLocationUtil.this.o();
                }
                if (CityLocationUtil.this.h) {
                    return;
                }
                CityLocationUtil.this.q();
            }
        }
    }

    public CityLocationUtil(Context context, LocaltionListener localtionListener) {
        this.a = context;
        this.b = localtionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "274921347")) {
            return ((Long) ipChange.ipc$dispatch("274921347", new Object[]{this, str})).longValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String B = z20.B(ShareperfenceConstants.CITY_DATA_New);
        try {
            if (TextUtils.isEmpty(B)) {
                return 0L;
            }
            try {
                CityListResponse cityListResponse = (CityListResponse) JSON.parseObject(B, CityListResponse.class);
                if (cityListResponse == null) {
                    return 0L;
                }
                List<GroupsBean> groups = cityListResponse.getGroups();
                if (wh2.e(groups) <= 0) {
                    return 0L;
                }
                for (int i = 0; i < groups.size(); i++) {
                    GroupsBean groupsBean = groups.get(i);
                    if (groupsBean != null) {
                        List<SitesBean> sites = groupsBean.getSites();
                        if (wh2.e(sites) > 0) {
                            for (int i2 = 0; i2 < sites.size(); i2++) {
                                SitesBean sitesBean = sites.get(i2);
                                if (sitesBean != null && !TextUtils.isEmpty(sitesBean.getCityName()) && sitesBean.getCityName().equals(str) && !TextUtils.isEmpty(sitesBean.getCityId()) && !TextUtils.isEmpty(sitesBean.getCityId().trim())) {
                                    return wh2.m(sitesBean.getCityId(), 0L);
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
                List<HotCityBean> hotCity = cityListResponse.getHotCity();
                if (wh2.e(groups) <= 0) {
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

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301419846")) {
            ipChange.ipc$dispatch("1301419846", new Object[]{this});
        } else if (ir1.i(mr1.LOCATION)) {
            ia1.INSTANCE.c().startLocationWithCacheTime(new a(), 0L);
        }
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132526057")) {
            ipChange.ipc$dispatch("132526057", new Object[]{this});
        } else if (this.c != 0) {
            z20.o0(this.d.doubleValue());
            z20.p0(this.e.doubleValue());
            z20.m0(this.f);
            z20.q0(this.g);
            z20.n0(this.c + "," + this.d + "," + this.e);
        }
    }

    public void p(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271901251")) {
            ipChange.ipc$dispatch("-271901251", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.h = z;
        }
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746680300")) {
            ipChange.ipc$dispatch("746680300", new Object[]{this});
            return;
        }
        long j = this.c;
        if (j != 0) {
            mu0.b = j;
            mu0.c = this.g;
            z20.c0(this.c + "");
            z20.f0(this.g);
            z20.d0(this.d.doubleValue());
            z20.e0(this.e.doubleValue());
        }
    }
}
