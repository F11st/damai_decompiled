package cn.damai.projectfiltercopy.floatview;

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
import cn.damai.commonbusiness.citycopy.adapter.CitySelectAdapter;
import cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener;
import cn.damai.commonbusiness.citycopy.model.GroupsBean;
import cn.damai.commonbusiness.citycopy.model.HotCityBean;
import cn.damai.commonbusiness.citycopy.model.ManualBean;
import cn.damai.commonbusiness.citycopy.model.SitesBean;
import cn.damai.commonbusiness.citycopy.net.CityListResponse;
import cn.damai.commonbusiness.citycopy.util.CityLocationUtil;
import cn.damai.commonbusiness.citycopy.view.FloatingTitleDecoration;
import cn.damai.commonbusiness.citycopy.view.LetterSortBar;
import cn.damai.projectfiltercopy.bean.CityBean;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.Type;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.channel.bridge.OnBizListener;
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
import tb.ap2;
import tb.bb2;
import tb.bj;
import tb.gm;
import tb.k62;
import tb.kr1;
import tb.lr1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CityFloatLayer extends cn.damai.projectfiltercopy.floatview.a<CityBean> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String FILTER_CITY_CACHED_LASTTIME = "filter_city_cached_lasttime";
    View d;
    private CustomOnCityClickListener e;
    long f;
    String g;
    private List<String> h;
    private Map<Integer, String> i;
    private List<bj> j;
    private Map<String, String> k;
    private Map<String, String> l;
    private RecyclerView m;
    private CitySelectAdapter n;
    private CityLocationUtil o;
    private LetterSortBar p;
    private int q;
    private bj r;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface CustomOnCityClickListener {
        void onGroupCityClick(String str, String str2);

        void onHotCityClick(String str, String str2, String str3);

        void onLocationCityClick(String str, String str2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements CustomOnCityClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.projectfiltercopy.floatview.CityFloatLayer.CustomOnCityClickListener
        public void onGroupCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1480291699")) {
                ipChange.ipc$dispatch("1480291699", new Object[]{this, str, str2});
            } else {
                CityFloatLayer.this.u(str, str2);
            }
        }

        @Override // cn.damai.projectfiltercopy.floatview.CityFloatLayer.CustomOnCityClickListener
        public void onHotCityClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "221064395")) {
                ipChange.ipc$dispatch("221064395", new Object[]{this, str, str2, str3});
            } else {
                CityFloatLayer.this.u(str2, str);
            }
        }

        @Override // cn.damai.projectfiltercopy.floatview.CityFloatLayer.CustomOnCityClickListener
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1579272935")) {
                ipChange.ipc$dispatch("-1579272935", new Object[]{this, str, str2});
            } else {
                CityFloatLayer.this.u(str, str2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements OnCityListItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onGroupCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1760641588")) {
                ipChange.ipc$dispatch("1760641588", new Object[]{this, str, str2});
            } else {
                CityFloatLayer.this.e.onGroupCityClick(str, str2);
            }
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onHotCityClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1088116620")) {
                ipChange.ipc$dispatch("1088116620", new Object[]{this, str, str2, str3});
            } else {
                CityFloatLayer.this.e.onHotCityClick(str, str2, str3);
            }
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "907846840")) {
                ipChange.ipc$dispatch("907846840", new Object[]{this, str, str2});
            } else {
                CityFloatLayer.this.e.onLocationCityClick(str, str2);
            }
        }

        @Override // cn.damai.commonbusiness.citycopy.listener.OnCityListItemClickListener
        public void onRequestLocationPermission() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1152197351")) {
                ipChange.ipc$dispatch("-1152197351", new Object[]{this});
            } else {
                CityFloatLayer.this.k(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements LetterSortBar.OnTouchingLetterChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.citycopy.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onClickLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-370588929")) {
                ipChange.ipc$dispatch("-370588929", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            int i2 = i + 1;
            try {
                if (i2 < bb2.c(CityFloatLayer.this.j) - 1) {
                    CityFloatLayer.this.t(i2);
                } else {
                    CityFloatLayer cityFloatLayer = CityFloatLayer.this;
                    cityFloatLayer.t(bb2.c(cityFloatLayer.j) - 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.damai.commonbusiness.citycopy.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onDraggingLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1738470030")) {
                ipChange.ipc$dispatch("1738470030", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            try {
                if (i <= 0) {
                    CityFloatLayer.this.t(0);
                } else {
                    int i2 = i + 1;
                    if (i2 < bb2.c(CityFloatLayer.this.j) - 1) {
                        CityFloatLayer.this.t(i2);
                    } else {
                        CityFloatLayer cityFloatLayer = CityFloatLayer.this;
                        cityFloatLayer.t(bb2.c(cityFloatLayer.j) - 1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class d implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ bj b;

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1610702639")) {
                    ipChange.ipc$dispatch("-1610702639", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                Context context = CityFloatLayer.this.a;
                if (context instanceof Activity) {
                    kr1.f((Activity) context);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes15.dex */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b(d dVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-641121616")) {
                    ipChange.ipc$dispatch("-641121616", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        d(boolean z, bj bjVar) {
            this.a = z;
            this.b = bjVar;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1202031480")) {
                ipChange.ipc$dispatch("-1202031480", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1673247427")) {
                ipChange.ipc$dispatch("-1673247427", new Object[]{this});
                return;
            }
            if (!this.a) {
                CityFloatLayer.this.z(this.b, true);
            }
            CityFloatLayer.this.q(this.b);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "519743696")) {
                ipChange.ipc$dispatch("519743696", new Object[]{this, strArr});
            } else {
                gm.INSTANCE.a().showPermissionDialog(CityFloatLayer.this.a, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new a(), new b(this));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class e implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ bj a;

        e(bj bjVar) {
            this.a = bjVar;
        }

        @Override // cn.damai.commonbusiness.citycopy.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-67422842")) {
                ipChange.ipc$dispatch("-67422842", new Object[]{this});
                return;
            }
            SitesBean sitesBean = new SitesBean();
            sitesBean.setCityId("852");
            sitesBean.setCityName("北京");
            this.a.f(sitesBean);
            this.a.c = 136;
            CityFloatLayer.this.n.notifyDataSetChanged();
        }

        @Override // cn.damai.commonbusiness.citycopy.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-30820071")) {
                ipChange.ipc$dispatch("-30820071", new Object[]{this, sitesBean});
                return;
            }
            SitesBean sitesBean2 = new SitesBean();
            sitesBean2.setCityId(sitesBean.getCityId());
            sitesBean2.setCityName(sitesBean.getCityName());
            this.a.f(sitesBean2);
            this.a.c = 136;
            CityFloatLayer.this.n.notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class f implements OnBizListener<CityListResponse> {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // com.alibaba.pictures.bricks.channel.bridge.OnBizListener
        /* renamed from: a */
        public void onBizSuccess(CityListResponse cityListResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "888062764")) {
                ipChange.ipc$dispatch("888062764", new Object[]{this, cityListResponse});
                return;
            }
            if (cityListResponse != null) {
                try {
                    CityFloatLayer.this.o(cityListResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            gm.INSTANCE.a().saveSpValue("filter_city_cached_lasttime", String.valueOf(System.currentTimeMillis()));
        }

        @Override // com.alibaba.pictures.bricks.channel.bridge.OnBizListener
        public void onBizFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1319184650")) {
                ipChange.ipc$dispatch("1319184650", new Object[]{this, str, str2});
                return;
            }
            CityFloatLayer cityFloatLayer = CityFloatLayer.this;
            cityFloatLayer.s(cityFloatLayer.a);
        }
    }

    public CityFloatLayer(Context context) {
        super(context);
        this.e = new a();
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = new ArrayList();
        this.k = new HashMap();
        this.l = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922757870")) {
            ipChange.ipc$dispatch("922757870", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.r == null) {
        } else {
            if (z || ap2.INSTANCE.e(this.a)) {
                w(this.r);
            }
        }
    }

    private void l(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692341805")) {
            ipChange.ipc$dispatch("1692341805", new Object[]{this, context});
        } else if (this.d != null) {
        } else {
            View inflate = LayoutInflater.from(context).inflate(R$layout.copy_activity_city_select, (ViewGroup) null, false);
            this.d = inflate;
            inflate.findViewById(R$id.city_select_navtitle).setVisibility(8);
            this.q = k62.a(this.a, 40.0f);
            p();
            r();
            String spValue = gm.INSTANCE.a().getSpValue("filter_city_cached_lasttime");
            if (TextUtils.isEmpty(spValue)) {
                v();
                return;
            }
            try {
                if (System.currentTimeMillis() - Long.parseLong(spValue) > 86400000) {
                    v();
                    return;
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            s(context);
        }
    }

    private View m(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-89944186")) {
            return (View) ipChange.ipc$dispatch("-89944186", new Object[]{this, Integer.valueOf(i)});
        }
        View view = this.d;
        if (view != null) {
            return view.findViewById(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(CityListResponse cityListResponse) {
        List<SitesBean> sites;
        int c2;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "1755015754")) {
            ipChange.ipc$dispatch("1755015754", new Object[]{this, cityListResponse});
            return;
        }
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.i.put(0, "当前定位城市");
        bj bjVar = new bj(0);
        this.r = bjVar;
        z(bjVar, false);
        this.j.add(this.r);
        List<HotCityBean> hotCity = cityListResponse.getHotCity();
        int c3 = bb2.c(hotCity);
        if (c3 > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < c3; i2++) {
                HotCityBean hotCityBean = hotCity.get(i2);
                if (TextUtils.getTrimmedLength(hotCityBean.getCityId()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getCityName()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getUrl()) > 0) {
                    arrayList.add(hotCityBean);
                    this.l.put(hotCityBean.getCityId(), hotCityBean.getUrl());
                }
            }
            if (bb2.c(arrayList) > 0) {
                this.i.put(1, "热门城市");
                this.h.add("热");
                bj bjVar2 = new bj(1);
                bjVar2.e(arrayList);
                this.j.add(bjVar2);
                i = 2;
            }
        }
        List<GroupsBean> groups = cityListResponse.getGroups();
        int c4 = bb2.c(groups);
        if (c4 > 0) {
            for (int i3 = 0; i3 < c4; i3++) {
                GroupsBean groupsBean = groups.get(i3);
                if (groupsBean != null && (c2 = bb2.c((sites = groupsBean.getSites()))) > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i4 = 0; i4 < c2; i4++) {
                        SitesBean sitesBean = sites.get(i4);
                        if (sitesBean != null && TextUtils.getTrimmedLength(sitesBean.getCityId()) > 0 && TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                            arrayList2.add(sitesBean);
                        }
                    }
                    if (bb2.c(arrayList2) > 0) {
                        int i5 = i + 1;
                        this.i.put(Integer.valueOf(i), groupsBean.getSpellCode());
                        this.h.add(groupsBean.getSpellCode());
                        bj bjVar3 = new bj(2);
                        bjVar3.g(arrayList2);
                        this.j.add(bjVar3);
                        i = i5;
                    }
                }
            }
        }
        List<ManualBean> manual = cityListResponse.getManual();
        int c5 = bb2.c(manual);
        if (c5 > 0) {
            for (int i6 = 0; i6 < c5; i6++) {
                ManualBean manualBean = manual.get(i6);
                if (manualBean != null && !TextUtils.isEmpty(manualBean.getCityId().trim()) && !TextUtils.isEmpty(manualBean.getUrl().trim())) {
                    this.k.put(manualBean.getCityId(), manualBean.getUrl());
                }
            }
        }
        FloatingTitleDecoration floatingTitleDecoration = new FloatingTitleDecoration(this.a);
        floatingTitleDecoration.d(this.i);
        floatingTitleDecoration.c(this.q);
        this.m.addItemDecoration(floatingTitleDecoration);
        this.p.setLetters(this.h);
        this.n.notifyDataSetChanged();
        k(false);
    }

    private void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-800590372")) {
            ipChange.ipc$dispatch("-800590372", new Object[]{this});
            return;
        }
        LetterSortBar letterSortBar = (LetterSortBar) m(R$id.city_select_sort_letter);
        this.p = letterSortBar;
        letterSortBar.setOnTouchingLetterChangedListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(bj bjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875192727")) {
            ipChange.ipc$dispatch("-1875192727", new Object[]{this, bjVar});
            return;
        }
        CityLocationUtil cityLocationUtil = new CityLocationUtil(this.a, new e(bjVar));
        this.o = cityLocationUtil;
        cityLocationUtil.o(true);
        this.o.m();
    }

    private void r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040343387")) {
            ipChange.ipc$dispatch("2040343387", new Object[]{this});
            return;
        }
        this.m = (RecyclerView) m(R$id.city_select_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(1);
        this.m.setLayoutManager(linearLayoutManager);
        CitySelectAdapter citySelectAdapter = new CitySelectAdapter(this.a, this.j);
        this.n = citySelectAdapter;
        citySelectAdapter.g(new b());
        this.m.setAdapter(this.n);
        this.m.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: cn.damai.projectfiltercopy.floatview.CityFloatLayer.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "874778075")) {
                    ipChange2.ipc$dispatch("874778075", new Object[]{this, recyclerView, Integer.valueOf(i)});
                } else {
                    super.onScrollStateChanged(recyclerView, i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-715925532")) {
                    ipChange2.ipc$dispatch("-715925532", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    super.onScrolled(recyclerView, i, i2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2125637431")) {
            ipChange.ipc$dispatch("-2125637431", new Object[]{this, context});
            return;
        }
        try {
            CityListResponse localCityList = gm.INSTANCE.a().getLocalCityList();
            if (localCityList != null) {
                o(localCityList);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144376119")) {
            ipChange.ipc$dispatch("-2144376119", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.m.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition) {
            this.m.scrollToPosition(i);
        } else if (i <= findLastVisibleItemPosition) {
            this.m.scrollBy(0, this.m.getChildAt(i - findFirstVisibleItemPosition).getTop() - this.q);
        } else {
            this.m.scrollToPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424466309")) {
            ipChange.ipc$dispatch("1424466309", new Object[]{this, str, str2});
            return;
        }
        FilterData filterData = new FilterData();
        filterData.mCityBean = new CityBean(str2, str);
        getListener().onFloatCall(getType(), filterData);
        this.g = str2;
        CitySelectAdapter citySelectAdapter = this.n;
        if (citySelectAdapter != null) {
            citySelectAdapter.h(str2);
        }
        getFilterUt().g(str2);
    }

    private void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900377027")) {
            ipChange.ipc$dispatch("1900377027", new Object[]{this});
        } else {
            gm.INSTANCE.a().requestCityList(new f());
        }
    }

    private void w(bj bjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245743658")) {
            ipChange.ipc$dispatch("-245743658", new Object[]{this, bjVar});
            return;
        }
        new Permission(this.a, new PermissionModel(lr1.a, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new d(ap2.INSTANCE.e(this.a), bjVar)).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(bj bjVar, boolean z) {
        CitySelectAdapter citySelectAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148567771")) {
            ipChange.ipc$dispatch("148567771", new Object[]{this, bjVar, Boolean.valueOf(z)});
        } else if (bjVar == null || bjVar.d() != 0) {
        } else {
            if (ap2.INSTANCE.e(this.a)) {
                bjVar.c = 119;
            } else {
                bjVar.c = 102;
            }
            if (!z || (citySelectAdapter = this.n) == null) {
                return;
            }
            citySelectAdapter.notifyDataSetChanged();
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1704075195") ? (Type) ipChange.ipc$dispatch("-1704075195", new Object[]{this}) : Type.CITY;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1543992418")) {
            return (View) ipChange.ipc$dispatch("1543992418", new Object[]{this});
        }
        l(this.a);
        return this.d;
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525948147")) {
            ipChange.ipc$dispatch("-525948147", new Object[]{this});
        } else {
            getFilterUt().r(this.f, this.g);
        }
    }

    public View n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089474011")) {
            return (View) ipChange.ipc$dispatch("2089474011", new Object[]{this});
        }
        l(this.a);
        CitySelectAdapter citySelectAdapter = this.n;
        if (citySelectAdapter != null) {
            citySelectAdapter.h("城市未知");
        }
        return this.d;
    }

    public void x(CustomOnCityClickListener customOnCityClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1458902430")) {
            ipChange.ipc$dispatch("-1458902430", new Object[]{this, customOnCityClickListener});
        } else {
            this.e = customOnCityClickListener;
        }
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    /* renamed from: y */
    public void show(@Nullable CityBean cityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1962727499")) {
            ipChange.ipc$dispatch("1962727499", new Object[]{this, cityBean});
            return;
        }
        l(this.a);
        CitySelectAdapter citySelectAdapter = this.n;
        if (citySelectAdapter != null && cityBean != null) {
            citySelectAdapter.h(cityBean.cityName);
            this.n.notifyDataSetChanged();
            this.g = cityBean.cityName;
        }
        this.f = System.currentTimeMillis();
    }
}
