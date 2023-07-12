package cn.damai.category.category.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.ui.adapter.CitySelectAdapter;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.city.model.GroupsBean;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.ManualBean;
import cn.damai.commonbusiness.city.model.SitesBean;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.commonbusiness.city.util.CityLocationUtil;
import cn.damai.commonbusiness.city.view.FloatingTitleDecoration;
import cn.damai.commonbusiness.city.view.LetterSortBar;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.cj;
import tb.ir1;
import tb.mr1;
import tb.qw0;
import tb.t60;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CityView {
    private static transient /* synthetic */ IpChange $ipChange;
    private qw0 a;
    private int b;
    private View c;
    private View d;
    private Activity e;
    private DMIconFontTextView f;
    private TextView g;
    private RecyclerView l;
    private CitySelectAdapter m;
    private CityLocationUtil n;
    private LetterSortBar o;
    private int p;
    private int q;
    private View.OnClickListener r;
    private cj s;
    private int t;
    private List<String> h = new ArrayList();
    private Map<Integer, String> i = new HashMap();
    private List<cj> j = new ArrayList();
    private Map<String, String> k = new HashMap();
    private boolean u = false;
    private RecyclerView.OnScrollListener v = new RecyclerView.OnScrollListener() { // from class: cn.damai.category.category.ui.view.CityView.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1035593059")) {
                ipChange.ipc$dispatch("-1035593059", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (CityView.this.u) {
                CityView.this.u = false;
                int i3 = CityView.this.t - findFirstVisibleItemPosition;
                if (i3 < 0 || i3 >= CityView.this.l.getChildCount()) {
                    return;
                }
                CityView.this.l.scrollBy(0, CityView.this.l.getChildAt(i3).getTop() - CityView.this.p);
            }
        }
    };
    private CitySelectAdapter.OnCityListItemClickListener2 w = new d();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements LetterSortBar.OnTouchingLetterChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onClickLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "491977850")) {
                ipChange.ipc$dispatch("491977850", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            int i2 = i + 1;
            try {
                if (i2 < wh2.e(CityView.this.j) - 1) {
                    CityView.this.v(i2);
                } else {
                    CityView cityView = CityView.this;
                    cityView.v(wh2.e(cityView.j) - 1);
                }
            } catch (Exception unused) {
            }
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onDraggingLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1676051251")) {
                ipChange.ipc$dispatch("1676051251", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            try {
                if (i <= 0) {
                    CityView.this.v(0);
                } else {
                    int i2 = i + 1;
                    if (i2 < wh2.e(CityView.this.j) - 1) {
                        CityView.this.v(i2);
                    } else {
                        CityView cityView = CityView.this;
                        cityView.v(wh2.e(cityView.j) - 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ cj b;

        b(boolean z, cj cjVar) {
            this.a = z;
            this.b = cjVar;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1054876760")) {
                ipChange.ipc$dispatch("-1054876760", new Object[]{this});
                return;
            }
            if (!this.a) {
                CityView cityView = CityView.this;
                cityView.A(cityView.s, true);
            }
            CityView.this.t(this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ cj a;

        c(cj cjVar) {
            this.a = cjVar;
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1346462636")) {
                ipChange.ipc$dispatch("1346462636", new Object[]{this});
                return;
            }
            SitesBean sitesBean = new SitesBean();
            sitesBean.setCityId("852");
            sitesBean.setCityName("北京");
            this.a.f(sitesBean);
            this.a.c = 136;
            CityView.this.m.i(z20.d());
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1062160824")) {
                ipChange.ipc$dispatch("-1062160824", new Object[]{this, sitesBean});
                return;
            }
            SitesBean sitesBean2 = new SitesBean();
            sitesBean2.setCityId(sitesBean.getCityId());
            sitesBean2.setCityName(sitesBean.getCityName());
            this.a.f(sitesBean2);
            this.a.c = 136;
            CityView.this.m.i(z20.d());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements CitySelectAdapter.OnCityListItemClickListener2 {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onGroupCityClick(int i, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1350960108")) {
                ipChange.ipc$dispatch("1350960108", new Object[]{this, Integer.valueOf(i), str, str2});
            } else {
                CityView.this.x(2, i, str, str2);
            }
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onHotCityClick(int i, String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "283989288")) {
                ipChange.ipc$dispatch("283989288", new Object[]{this, Integer.valueOf(i), str, str2, str3});
            } else {
                CityView.this.x(1, i, str2, str);
            }
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1946723821")) {
                ipChange.ipc$dispatch("1946723821", new Object[]{this, str, str2});
            } else {
                CityView.this.x(0, 0, str, str2);
            }
        }

        @Override // cn.damai.category.category.ui.adapter.CitySelectAdapter.OnCityListItemClickListener2
        public void onRequestLocationPermission() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1627475918")) {
                ipChange.ipc$dispatch("1627475918", new Object[]{this});
            } else {
                CityView.this.o(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1647664058")) {
                ipChange.ipc$dispatch("1647664058", new Object[]{this, view});
                return;
            }
            CityView.this.q();
            if (CityView.this.r != null) {
                CityView.this.r.onClick(view);
            }
        }
    }

    public CityView(Activity activity, int i, View view, View view2, View view3) {
        this.e = activity;
        this.q = i;
        TextView textView = (TextView) view;
        this.g = textView;
        textView.setText(z20.d());
        this.c = view2;
        this.d = view3;
        this.b = (int) (this.q * 0.65d);
        u();
        s();
        this.a = qw0.b(this.e, view2, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(cj cjVar, boolean z) {
        CitySelectAdapter citySelectAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "564209598")) {
            ipChange.ipc$dispatch("564209598", new Object[]{this, cjVar, Boolean.valueOf(z)});
        } else if (cjVar == null) {
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

    private void n(cj cjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1198539419")) {
            ipChange.ipc$dispatch("1198539419", new Object[]{this, cjVar});
            return;
        }
        String[] strArr = mr1.LOCATION;
        ir1.b(this.e, false, strArr, "才能定位到当前所在城市～", new b(ir1.i(strArr), cjVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966064314")) {
            ipChange.ipc$dispatch("-1966064314", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.s == null) {
        } else {
            if (ir1.i(mr1.LOCATION) || z) {
                n(this.s);
            }
        }
    }

    private void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572252212")) {
            ipChange.ipc$dispatch("572252212", new Object[]{this});
            return;
        }
        LetterSortBar letterSortBar = (LetterSortBar) this.c.findViewById(R$id.city_select_sort_letter);
        this.o = letterSortBar;
        ViewGroup.LayoutParams layoutParams = letterSortBar.getLayoutParams();
        layoutParams.height = this.b - ScreenUtil.dip2px(this.e, 43.0f);
        this.o.setLayoutParams(layoutParams);
        this.o.setOnTouchingLetterChangedListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(cj cjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586653914")) {
            ipChange.ipc$dispatch("-586653914", new Object[]{this, cjVar});
            return;
        }
        CityLocationUtil cityLocationUtil = new CityLocationUtil(this.e, new c(cjVar));
        this.n = cityLocationUtil;
        cityLocationUtil.p(true);
        this.n.n();
    }

    private void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391891971")) {
            ipChange.ipc$dispatch("1391891971", new Object[]{this});
            return;
        }
        this.p = t60.a(this.e, 40.0f);
        this.l = (RecyclerView) this.c.findViewById(R$id.city_select_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.e);
        linearLayoutManager.setOrientation(1);
        this.l.setLayoutManager(linearLayoutManager);
        CitySelectAdapter citySelectAdapter = new CitySelectAdapter(this.e, this.j);
        this.m = citySelectAdapter;
        citySelectAdapter.h(this.w);
        this.l.setAdapter(this.m);
        this.l.addOnScrollListener(this.v);
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        layoutParams.height = this.b;
        this.l.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1714031393")) {
            ipChange.ipc$dispatch("1714031393", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.t = i;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.l.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition) {
            this.l.scrollToPosition(i);
        } else if (i <= findLastVisibleItemPosition) {
            this.l.scrollBy(0, this.l.getChildAt(i - findFirstVisibleItemPosition).getTop() - this.p);
        } else {
            this.l.scrollToPosition(i);
            this.u = true;
        }
    }

    public boolean p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-560007945") ? ((Boolean) ipChange.ipc$dispatch("-560007945", new Object[]{this})).booleanValue() : this.c.getVisibility() == 0;
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837847396")) {
            ipChange.ipc$dispatch("837847396", new Object[]{this});
        } else if (this.f != null) {
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            this.f.setText(this.e.getText(R$string.iconfont_shaixuanxia12));
        }
    }

    public void r(CityListResponse cityListResponse) {
        List<SitesBean> sites;
        int e2;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-499334611")) {
            ipChange.ipc$dispatch("-499334611", new Object[]{this, cityListResponse});
        } else if (cityListResponse != null) {
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.k.clear();
            RecyclerView recyclerView = this.l;
            if (recyclerView != null) {
                try {
                    recyclerView.removeAllViews();
                    for (int itemDecorationCount = this.l.getItemDecorationCount() - 1; itemDecorationCount >= 0; itemDecorationCount--) {
                        this.l.removeItemDecorationAt(itemDecorationCount);
                    }
                } catch (Exception unused) {
                }
            }
            this.i.put(0, "当前定位城市");
            cj cjVar = new cj(0);
            this.s = cjVar;
            A(cjVar, false);
            this.j.add(this.s);
            List<HotCityBean> hotCity = cityListResponse.getHotCity();
            int e3 = wh2.e(hotCity);
            if (e3 > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < e3; i2++) {
                    HotCityBean hotCityBean = hotCity.get(i2);
                    if (TextUtils.getTrimmedLength(hotCityBean.getCityId()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getCityName()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getUrl()) > 0) {
                        arrayList.add(hotCityBean);
                    }
                }
                HotCityBean hotCityBean2 = new HotCityBean();
                hotCityBean2.setCityId("0");
                hotCityBean2.setCityName("全部城市");
                arrayList.add(hotCityBean2);
                if (wh2.e(arrayList) > 0) {
                    this.i.put(1, "热门城市");
                    this.h.add("热");
                    cj cjVar2 = new cj(1);
                    cjVar2.e(arrayList);
                    this.j.add(cjVar2);
                    i = 2;
                }
            }
            List<GroupsBean> groups = cityListResponse.getGroups();
            int e4 = wh2.e(groups);
            if (e4 > 0) {
                for (int i3 = 0; i3 < e4; i3++) {
                    GroupsBean groupsBean = groups.get(i3);
                    if (groupsBean != null && (e2 = wh2.e((sites = groupsBean.getSites()))) > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < e2; i4++) {
                            SitesBean sitesBean = sites.get(i4);
                            if (sitesBean != null && TextUtils.getTrimmedLength(sitesBean.getCityId()) > 0 && TextUtils.getTrimmedLength(sitesBean.getCityName()) > 0) {
                                arrayList2.add(sitesBean);
                            }
                        }
                        if (wh2.e(arrayList2) > 0) {
                            int i5 = i + 1;
                            this.i.put(Integer.valueOf(i), groupsBean.getSpellCode());
                            this.h.add(groupsBean.getSpellCode());
                            cj cjVar3 = new cj(2);
                            cjVar3.g(arrayList2);
                            this.j.add(cjVar3);
                            i = i5;
                        }
                    }
                }
            }
            List<ManualBean> manual = cityListResponse.getManual();
            int e5 = wh2.e(manual);
            if (e5 > 0) {
                for (int i6 = 0; i6 < e5; i6++) {
                    ManualBean manualBean = manual.get(i6);
                    if (manualBean != null && !TextUtils.isEmpty(manualBean.getCityId().trim()) && !TextUtils.isEmpty(manualBean.getUrl().trim())) {
                        this.k.put(manualBean.getCityId(), manualBean.getUrl());
                    }
                }
            }
            FloatingTitleDecoration floatingTitleDecoration = new FloatingTitleDecoration(this.e);
            floatingTitleDecoration.d(this.i);
            floatingTitleDecoration.c(this.p);
            this.l.addItemDecoration(floatingTitleDecoration);
            this.o.setLetters(this.h);
            this.m.notifyDataSetChanged();
            o(false);
        }
    }

    public boolean w(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451693741")) {
            return ((Boolean) ipChange.ipc$dispatch("451693741", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        }
        if (i == 2168) {
            A(this.s, true);
            o(false);
            return true;
        }
        return false;
    }

    public void x(int i, int i2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880867503")) {
            ipChange.ipc$dispatch("-880867503", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), str, str2});
            return;
        }
        this.g.setText(str2);
        q();
    }

    public void y(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888232483")) {
            ipChange.ipc$dispatch("-1888232483", new Object[]{this, onClickListener});
        } else {
            this.r = onClickListener;
        }
    }

    public void z(DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429334156")) {
            ipChange.ipc$dispatch("429334156", new Object[]{this, dMIconFontTextView});
            return;
        }
        this.f = dMIconFontTextView;
        if (this.c.getVisibility() == 0) {
            this.d.setVisibility(8);
            q();
            dMIconFontTextView.setText(this.e.getText(R$string.iconfont_shaixuanxia12));
            return;
        }
        this.d.setOnClickListener(new e());
        this.c.setVisibility(0);
        this.a.d(250);
        dMIconFontTextView.setText(this.e.getText(R$string.iconfont_shaixuanshang12));
        this.d.setVisibility(0);
        this.m.notifyDataSetChanged();
    }
}
