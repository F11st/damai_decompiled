package cn.damai.projectfilter.floatview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.city.adapter.CitySelectAdapter;
import cn.damai.commonbusiness.city.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.city.model.GroupsBean;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.ManualBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.net.CityListRequest;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.commonbusiness.city.view.FloatingTitleDecoration;
import cn.damai.commonbusiness.city.view.LetterSortBar;
import cn.damai.projectfilter.bean.CityBean;
import cn.damai.projectfilter.bean.FilterData;
import cn.damai.projectfilter.bean.Type;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.cb1;
import tb.cj;
import tb.gr1;
import tb.ir1;
import tb.kr1;
import tb.mr1;
import tb.t60;
import tb.wh2;
import tb.yi;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CityFloatLayer extends cn.damai.projectfilter.floatview.a<CityBean> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FILTER_CITY_CACHED_LASTTIME = "filter_city_cached_lasttime";
    View d;
    long e;
    String f;
    private List<String> g;
    private Map<Integer, String> h;
    private List<cj> i;
    private Map<String, String> j;
    private Map<String, String> k;
    private RecyclerView l;
    private CitySelectAdapter m;
    private CityLocationUtil n;
    private LetterSortBar o;
    private int p;
    private cj q;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements OnCityListItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onGroupCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "524447944")) {
                ipChange.ipc$dispatch("524447944", new Object[]{this, str, str2});
            } else {
                CityFloatLayer.this.s(str, str2);
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onHotCityClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1564794400")) {
                ipChange.ipc$dispatch("1564794400", new Object[]{this, str, str2, str3});
            } else {
                CityFloatLayer.this.s(str2, str);
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1487405660")) {
                ipChange.ipc$dispatch("-1487405660", new Object[]{this, str, str2});
            } else {
                CityFloatLayer.this.s(str, str2);
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onRequestLocationPermission() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2071556091")) {
                ipChange.ipc$dispatch("-2071556091", new Object[]{this});
            } else {
                CityFloatLayer.this.j(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements LetterSortBar.OnTouchingLetterChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onClickLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2045506539")) {
                ipChange.ipc$dispatch("2045506539", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            int i2 = i + 1;
            try {
                if (i2 < wh2.e(CityFloatLayer.this.i) - 1) {
                    CityFloatLayer.this.r(i2);
                } else {
                    CityFloatLayer cityFloatLayer = CityFloatLayer.this;
                    cityFloatLayer.r(wh2.e(cityFloatLayer.i) - 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onDraggingLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "281643554")) {
                ipChange.ipc$dispatch("281643554", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            try {
                if (i <= 0) {
                    CityFloatLayer.this.r(0);
                } else {
                    int i2 = i + 1;
                    if (i2 < wh2.e(CityFloatLayer.this.i) - 1) {
                        CityFloatLayer.this.r(i2);
                    } else {
                        CityFloatLayer cityFloatLayer = CityFloatLayer.this;
                        cityFloatLayer.r(wh2.e(cityFloatLayer.i) - 1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ cj b;

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "472316861")) {
                    ipChange.ipc$dispatch("472316861", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                kr1.f((Activity) CityFloatLayer.this.a);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b(c cVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1441897884")) {
                    ipChange.ipc$dispatch("1441897884", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        c(boolean z, cj cjVar) {
            this.a = z;
            this.b = cjVar;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "619475060")) {
                ipChange.ipc$dispatch("619475060", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "547333161")) {
                ipChange.ipc$dispatch("547333161", new Object[]{this});
                return;
            }
            if (!this.a) {
                CityFloatLayer.this.w(this.b, true);
            }
            CityFloatLayer.this.o(this.b);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2066748516")) {
                ipChange.ipc$dispatch("2066748516", new Object[]{this, strArr});
            } else {
                gr1.a(CityFloatLayer.this.a, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new a(), new b(this));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class d implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ cj a;

        d(cj cjVar) {
            this.a = cjVar;
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1264968166")) {
                ipChange.ipc$dispatch("-1264968166", new Object[]{this});
                return;
            }
            SitesBean sitesBean = new SitesBean();
            sitesBean.setCityId("852");
            sitesBean.setCityName("北京");
            this.a.f(sitesBean);
            this.a.c = 136;
            CityFloatLayer.this.m.notifyDataSetChanged();
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1878636006")) {
                ipChange.ipc$dispatch("-1878636006", new Object[]{this, sitesBean});
                return;
            }
            SitesBean sitesBean2 = new SitesBean();
            sitesBean2.setCityId(sitesBean.getCityId());
            sitesBean2.setCityName(sitesBean.getCityName());
            this.a.f(sitesBean2);
            this.a.c = 136;
            CityFloatLayer.this.m.notifyDataSetChanged();
        }
    }

    public CityFloatLayer(Context context) {
        super(context);
        this.g = new ArrayList();
        this.h = new HashMap();
        this.i = new ArrayList();
        this.j = new HashMap();
        this.k = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344724857")) {
            ipChange.ipc$dispatch("1344724857", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.q == null) {
        } else {
            if (z || ir1.i(mr1.LOCATION)) {
                u(this.q);
            }
        }
    }

    private void k(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320339838")) {
            ipChange.ipc$dispatch("-1320339838", new Object[]{this, context});
        } else if (this.d != null) {
        } else {
            View inflate = LayoutInflater.from(context).inflate(R$layout.activity_city_select, (ViewGroup) null, false);
            this.d = inflate;
            inflate.findViewById(R$id.city_select_navtitle).setVisibility(8);
            this.p = t60.a(this.a, 40.0f);
            n();
            p();
            String B = z20.B("filter_city_cached_lasttime");
            if (TextUtils.isEmpty(B)) {
                t();
                return;
            }
            try {
                if (System.currentTimeMillis() - Long.parseLong(B) > 86400000) {
                    t();
                    return;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            q(context);
        }
    }

    private View l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175097391")) {
            return (View) ipChange.ipc$dispatch("-1175097391", new Object[]{this, Integer.valueOf(i)});
        }
        View view = this.d;
        if (view != null) {
            return view.findViewById(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(CityListResponse cityListResponse) {
        List<SitesBean> sites;
        int e;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "2023298976")) {
            ipChange.ipc$dispatch("2023298976", new Object[]{this, cityListResponse});
            return;
        }
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.h.put(0, "当前定位城市");
        cj cjVar = new cj(0);
        this.q = cjVar;
        w(cjVar, false);
        this.i.add(this.q);
        List<HotCityBean> hotCity = cityListResponse.getHotCity();
        int e2 = wh2.e(hotCity);
        if (e2 > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < e2; i2++) {
                HotCityBean hotCityBean = hotCity.get(i2);
                if (TextUtils.getTrimmedLength(hotCityBean.getCityId()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getCityName()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getUrl()) > 0) {
                    arrayList.add(hotCityBean);
                    this.k.put(hotCityBean.getCityId(), hotCityBean.getUrl());
                }
            }
            if (wh2.e(arrayList) > 0) {
                this.h.put(1, "热门城市");
                this.g.add("热");
                cj cjVar2 = new cj(1);
                cjVar2.e(arrayList);
                this.i.add(cjVar2);
                i = 2;
            }
        }
        List<GroupsBean> groups = cityListResponse.getGroups();
        int e3 = wh2.e(groups);
        if (e3 > 0) {
            for (int i3 = 0; i3 < e3; i3++) {
                GroupsBean groupsBean = groups.get(i3);
                if (groupsBean != null && (e = wh2.e((sites = groupsBean.getSites()))) > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < e; i4++) {
                        SitesBean sitesBean = sites.get(i4);
                        if (sitesBean != null && TextUtils.getTrimmedLength(sitesBean.getCityId()) > 0 && TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                            arrayList2.add(sitesBean);
                        }
                    }
                    if (wh2.e(arrayList2) > 0) {
                        int i5 = i + 1;
                        this.h.put(Integer.valueOf(i), groupsBean.getSpellCode());
                        this.g.add(groupsBean.getSpellCode());
                        cj cjVar3 = new cj(2);
                        cjVar3.g(arrayList2);
                        this.i.add(cjVar3);
                        i = i5;
                    }
                }
            }
        }
        List<ManualBean> manual = cityListResponse.getManual();
        int e4 = wh2.e(manual);
        if (e4 > 0) {
            for (int i6 = 0; i6 < e4; i6++) {
                ManualBean manualBean = manual.get(i6);
                if (manualBean != null && !TextUtils.isEmpty(manualBean.getCityId().trim()) && !TextUtils.isEmpty(manualBean.getUrl().trim())) {
                    this.j.put(manualBean.getCityId(), manualBean.getUrl());
                }
            }
        }
        FloatingTitleDecoration floatingTitleDecoration = new FloatingTitleDecoration(this.a);
        floatingTitleDecoration.d(this.h);
        floatingTitleDecoration.c(this.p);
        this.l.addItemDecoration(floatingTitleDecoration);
        this.o.setLetters(this.g);
        this.m.notifyDataSetChanged();
        j(false);
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-383425177")) {
            ipChange.ipc$dispatch("-383425177", new Object[]{this});
            return;
        }
        LetterSortBar letterSortBar = (LetterSortBar) l(R$id.city_select_sort_letter);
        this.o = letterSortBar;
        letterSortBar.setOnTouchingLetterChangedListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(cj cjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106829139")) {
            ipChange.ipc$dispatch("106829139", new Object[]{this, cjVar});
            return;
        }
        CityLocationUtil cityLocationUtil = new CityLocationUtil(this.a, new d(cjVar));
        this.n = cityLocationUtil;
        cityLocationUtil.p(true);
        this.n.n();
    }

    private void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222516336")) {
            ipChange.ipc$dispatch("1222516336", new Object[]{this});
            return;
        }
        this.l = (RecyclerView) l(R$id.city_select_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(1);
        this.l.setLayoutManager(linearLayoutManager);
        CitySelectAdapter citySelectAdapter = new CitySelectAdapter(this.a, this.i);
        this.m = citySelectAdapter;
        citySelectAdapter.g(new a());
        this.l.setAdapter(this.m);
        this.l.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: cn.damai.projectfilter.floatview.CityFloatLayer.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1742732911")) {
                    ipChange2.ipc$dispatch("1742732911", new Object[]{this, recyclerView, Integer.valueOf(i)});
                } else {
                    super.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1183789264")) {
                    ipChange2.ipc$dispatch("1183789264", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    super.onScrolled(recyclerView, i, i2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705930594")) {
            ipChange.ipc$dispatch("-1705930594", new Object[]{this, context});
            return;
        }
        String B = z20.B(ShareperfenceConstants.CITY_DATA_New);
        if (TextUtils.isEmpty(B)) {
            B = yi.a(context);
        }
        try {
            CityListResponse cityListResponse = (CityListResponse) JSON.parseObject(B, CityListResponse.class);
            if (cityListResponse != null) {
                m(cityListResponse);
            }
        } catch (Exception e) {
            cb1.b("CitySelectActivity", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339473644")) {
            ipChange.ipc$dispatch("-1339473644", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.l.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition) {
            this.l.scrollToPosition(i);
        } else if (i <= findLastVisibleItemPosition) {
            this.l.scrollBy(0, this.l.getChildAt(i - findFirstVisibleItemPosition).getTop() - this.p);
        } else {
            this.l.scrollToPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1737743088")) {
            ipChange.ipc$dispatch("-1737743088", new Object[]{this, str, str2});
            return;
        }
        FilterData filterData = new FilterData();
        filterData.mCityBean = new CityBean(str2, str);
        getListener().onFloatCall(getType(), filterData);
        this.f = str2;
        CitySelectAdapter citySelectAdapter = this.m;
        if (citySelectAdapter != null) {
            citySelectAdapter.h(str2);
        }
        getFilterUt().j(str2);
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589687794")) {
            ipChange.ipc$dispatch("-1589687794", new Object[]{this});
            return;
        }
        CityListRequest cityListRequest = new CityListRequest();
        cityListRequest.showLoginUI(false);
        cityListRequest.request(new DMMtopRequestListener<CityListResponse>(CityListResponse.class) { // from class: cn.damai.projectfilter.floatview.CityFloatLayer.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-18580723")) {
                    ipChange2.ipc$dispatch("-18580723", new Object[]{this, str, str2});
                    return;
                }
                CityFloatLayer cityFloatLayer = CityFloatLayer.this;
                cityFloatLayer.q(cityFloatLayer.a);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CityListResponse cityListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-279423238")) {
                    ipChange2.ipc$dispatch("-279423238", new Object[]{this, cityListResponse});
                } else if (cityListResponse != null) {
                    CityFloatLayer.this.m(cityListResponse);
                    try {
                        z20.T(ShareperfenceConstants.CITY_DATA_New, JSON.toJSONString(cityListResponse));
                        z20.T("filter_city_cached_lasttime", String.valueOf(System.currentTimeMillis()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void u(cj cjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1996248438")) {
            ipChange.ipc$dispatch("1996248438", new Object[]{this, cjVar});
            return;
        }
        String[] strArr = mr1.LOCATION;
        new Permission(this.a, new PermissionModel(strArr, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new c(ir1.i(strArr), cjVar)).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(cj cjVar, boolean z) {
        CitySelectAdapter citySelectAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339762511")) {
            ipChange.ipc$dispatch("-339762511", new Object[]{this, cjVar, Boolean.valueOf(z)});
        } else if (cjVar == null || cjVar.d() != 0) {
        } else {
            if (ir1.i(mr1.LOCATION)) {
                cjVar.c = 119;
            } else {
                cjVar.c = 102;
            }
            if (!z || (citySelectAdapter = this.m) == null) {
                return;
            }
            citySelectAdapter.notifyDataSetChanged();
        }
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1509016721") ? (Type) ipChange.ipc$dispatch("-1509016721", new Object[]{this}) : Type.CITY;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965959405")) {
            return (View) ipChange.ipc$dispatch("1965959405", new Object[]{this});
        }
        k(this.a);
        return this.d;
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437507490")) {
            ipChange.ipc$dispatch("437507490", new Object[]{this});
        } else {
            getFilterUt().t(this.e, this.f);
        }
    }

    @Override // cn.damai.projectfilter.floatview.FloatLayer
    /* renamed from: v */
    public void show(@Nullable CityBean cityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109888651")) {
            ipChange.ipc$dispatch("-109888651", new Object[]{this, cityBean});
            return;
        }
        k(this.a);
        CitySelectAdapter citySelectAdapter = this.m;
        if (citySelectAdapter != null && cityBean != null) {
            citySelectAdapter.h(cityBean.cityName);
            this.m.notifyDataSetChanged();
            this.f = cityBean.cityName;
        }
        this.e = System.currentTimeMillis();
    }
}
