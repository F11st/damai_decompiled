package cn.damai.commonbusiness.city;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.city.adapter.CitySelectAdapter;
import cn.damai.commonbusiness.city.bean.CityParam;
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
import tb.mu0;
import tb.ns2;
import tb.pl;
import tb.t60;
import tb.tr2;
import tb.wh2;
import tb.xr;
import tb.yi;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CitySelectActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CITY_ID = "ex_city_id";
    public static final String CITY_NAME = "ex_city_name";
    public static final String OBTAIN_CITY_PARAM = "extra_obtain_city_param";
    private CitySelectAdapter mAdapter;
    private RecyclerView mCityList;
    private CityLocationUtil mCityLocationUtil;
    private CityParam mExtraCity;
    private int mIndex;
    private LetterSortBar mLetterSortBar;
    private cj mLocationCityHolder;
    private int mSectionTitleHeight;
    private List<String> mLetterIndexList = new ArrayList();
    private Map<Integer, String> mSectionTitle = new HashMap();
    private List<cj> mCityListData = new ArrayList();
    private Map<String, String> mGroupCityListManualMap = new HashMap();
    private Map<String, String> mHotCityListManualMap = new HashMap();
    private boolean mMoveAgain = false;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.commonbusiness.city.CitySelectActivity.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2087776039")) {
                ipChange.ipc$dispatch("2087776039", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            super.onScrolled(recyclerView, i, i2);
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (CitySelectActivity.this.mMoveAgain) {
                CitySelectActivity.this.mMoveAgain = false;
                int i3 = CitySelectActivity.this.mIndex - findFirstVisibleItemPosition;
                if (i3 < 0 || i3 >= CitySelectActivity.this.mCityList.getChildCount()) {
                    return;
                }
                CitySelectActivity.this.mCityList.scrollBy(0, CitySelectActivity.this.mCityList.getChildAt(i3).getTop() - CitySelectActivity.this.mSectionTitleHeight);
            }
        }
    };
    private OnCityListItemClickListener mOnCityListItemClickListener = new C0599a();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.city.CitySelectActivity$a */
    /* loaded from: classes4.dex */
    public class C0599a implements OnCityListItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0599a() {
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onGroupCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1024050003")) {
                ipChange.ipc$dispatch("1024050003", new Object[]{this, str, str2});
                return;
            }
            C0529c.e().x(pl.j().f(str2));
            if (CitySelectActivity.this.trySetCityResultAndFinish(str, str2)) {
                return;
            }
            if (CitySelectActivity.this.mGroupCityListManualMap.size() > 0 && CitySelectActivity.this.mGroupCityListManualMap.containsKey(str) && !((String) CitySelectActivity.this.mGroupCityListManualMap.get(str)).contains(tr2.SCHEME_HOMEPAGE)) {
                DMNav.from(CitySelectActivity.this.mContext).toUri((String) CitySelectActivity.this.mGroupCityListManualMap.get(str));
                CitySelectActivity.this.finish();
            } else if (TextUtils.getTrimmedLength(z20.c()) > 0 && z20.c().equals(str)) {
                CitySelectActivity.this.finish();
            } else {
                z20.c0(str);
                z20.f0(str2);
                z20.g0();
                mu0.b = new Integer(str).intValue();
                mu0.c = str2;
                xr.c(DamaiConstants.CITY_CHANGED, "");
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
                    return;
                }
                CitySelectActivity.this.setResult(-1, null);
                CitySelectActivity.this.finish();
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onHotCityClick(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1113832107")) {
                ipChange.ipc$dispatch("1113832107", new Object[]{this, str, str2, str3});
            } else if (CitySelectActivity.this.trySetCityResultAndFinish(str2, str)) {
            } else {
                if (!TextUtils.isEmpty(str3) && str3.contains(tr2.SCHEME_HOMEPAGE)) {
                    if (TextUtils.getTrimmedLength(z20.c()) > 0 && z20.c().equals(str2)) {
                        CitySelectActivity.this.finish();
                        return;
                    }
                    z20.c0(str2);
                    z20.f0(str);
                    z20.g0();
                    mu0.b = new Integer(str2).intValue();
                    mu0.c = str;
                    xr.c(DamaiConstants.CITY_CHANGED, "");
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str2.trim())) {
                        return;
                    }
                    CitySelectActivity.this.setResult(-1, null);
                    CitySelectActivity.this.finish();
                    return;
                }
                C0529c.e().x(pl.j().f(str));
                DMNav.from(CitySelectActivity.this.mContext).toUri(str3);
                CitySelectActivity.this.finish();
            }
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onLocationCityClick(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "95853369")) {
                ipChange.ipc$dispatch("95853369", new Object[]{this, str, str2});
                return;
            }
            C0529c.e().x(pl.j().f(str2));
            if (CitySelectActivity.this.trySetCityResultAndFinish(str, str2)) {
                return;
            }
            if (CitySelectActivity.this.mHotCityListManualMap.size() <= 0 || !CitySelectActivity.this.mHotCityListManualMap.containsKey(str) || ((String) CitySelectActivity.this.mHotCityListManualMap.get(str)).contains(tr2.SCHEME_HOMEPAGE)) {
                if (CitySelectActivity.this.mGroupCityListManualMap.size() > 0 && CitySelectActivity.this.mGroupCityListManualMap.containsKey(str) && !((String) CitySelectActivity.this.mGroupCityListManualMap.get(str)).contains(tr2.SCHEME_HOMEPAGE)) {
                    DMNav.from(CitySelectActivity.this.mContext).toUri((String) CitySelectActivity.this.mGroupCityListManualMap.get(str));
                    CitySelectActivity.this.finish();
                    return;
                } else if (TextUtils.getTrimmedLength(z20.c()) > 0 && z20.c().equals(str)) {
                    CitySelectActivity.this.finish();
                    return;
                } else {
                    z20.c0(str);
                    z20.f0(str2);
                    z20.g0();
                    mu0.b = wh2.m(str, 0L);
                    mu0.c = str2;
                    xr.c(DamaiConstants.CITY_CHANGED, "");
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
                        return;
                    }
                    CitySelectActivity.this.setResult(-1, null);
                    CitySelectActivity.this.finish();
                    return;
                }
            }
            DMNav.from(CitySelectActivity.this.mContext).toUri((String) CitySelectActivity.this.mHotCityListManualMap.get(str));
            CitySelectActivity.this.finish();
        }

        @Override // cn.damai.commonbusiness.city.listener.OnCityListItemClickListener
        public void onRequestLocationPermission() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "587984666")) {
                ipChange.ipc$dispatch("587984666", new Object[]{this});
            } else {
                CitySelectActivity.this.dispatchLocationChecking(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.city.CitySelectActivity$b */
    /* loaded from: classes4.dex */
    public class C0600b implements LetterSortBar.OnTouchingLetterChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0600b() {
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onClickLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-274543135")) {
                ipChange.ipc$dispatch("-274543135", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            int i2 = i + 1;
            try {
                if (i2 < wh2.e(CitySelectActivity.this.mCityListData) - 1) {
                    CitySelectActivity.this.moveToPosition(i2);
                } else {
                    CitySelectActivity citySelectActivity = CitySelectActivity.this;
                    citySelectActivity.moveToPosition(wh2.e(citySelectActivity.mCityListData) - 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.damai.commonbusiness.city.view.LetterSortBar.OnTouchingLetterChangedListener
        public void onDraggingLetterChanged(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1704467348")) {
                ipChange.ipc$dispatch("-1704467348", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            try {
                if (i <= 0) {
                    CitySelectActivity.this.moveToPosition(0);
                } else {
                    int i2 = i + 1;
                    if (i2 < wh2.e(CitySelectActivity.this.mCityListData) - 1) {
                        CitySelectActivity.this.moveToPosition(i2);
                    } else {
                        CitySelectActivity citySelectActivity = CitySelectActivity.this;
                        citySelectActivity.moveToPosition(wh2.e(citySelectActivity.mCityListData) - 1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.city.CitySelectActivity$c */
    /* loaded from: classes4.dex */
    public class C0601c implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ cj b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.city.CitySelectActivity$c$a */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnClickListenerC0602a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC0602a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1208119086")) {
                    ipChange.ipc$dispatch("-1208119086", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                kr1.f(CitySelectActivity.this);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.city.CitySelectActivity$c$b */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnClickListenerC0603b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC0603b(C0601c c0601c) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-238538063")) {
                    ipChange.ipc$dispatch("-238538063", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        C0601c(boolean z, cj cjVar) {
            this.a = z;
            this.b = cjVar;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "910801225")) {
                ipChange.ipc$dispatch("910801225", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1811158978")) {
                ipChange.ipc$dispatch("-1811158978", new Object[]{this});
                return;
            }
            if (!this.a) {
                CitySelectActivity.this.updateLocationCityHolder(this.b, true);
            }
            CitySelectActivity.this.initLocation(this.b);
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2111142993")) {
                ipChange.ipc$dispatch("-2111142993", new Object[]{this, strArr});
            } else {
                gr1.a(CitySelectActivity.this, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new DialogInterface$OnClickListenerC0602a(), new DialogInterface$OnClickListenerC0603b(this));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.city.CitySelectActivity$d */
    /* loaded from: classes4.dex */
    public class C0604d implements CityLocationUtil.LocaltionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ cj a;

        C0604d(cj cjVar) {
            this.a = cjVar;
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalFinsih() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "941185573")) {
                ipChange.ipc$dispatch("941185573", new Object[]{this});
                return;
            }
            SitesBean sitesBean = new SitesBean();
            sitesBean.setCityId("852");
            sitesBean.setCityName("北京");
            this.a.f(sitesBean);
            this.a.c = 136;
            CitySelectActivity.this.mAdapter.notifyDataSetChanged();
        }

        @Override // cn.damai.commonbusiness.city.util.CityLocationUtil.LocaltionListener
        public void onGetLocalSuccess(SitesBean sitesBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-196312401")) {
                ipChange.ipc$dispatch("-196312401", new Object[]{this, sitesBean});
                return;
            }
            SitesBean sitesBean2 = new SitesBean();
            sitesBean2.setCityId(sitesBean.getCityId());
            sitesBean2.setCityName(sitesBean.getCityName());
            this.a.f(sitesBean2);
            this.a.c = 136;
            CitySelectActivity.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLocationChecking(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-330537617")) {
            ipChange.ipc$dispatch("-330537617", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mLocationCityHolder == null) {
        } else {
            if (z || ir1.i(mr1.LOCATION)) {
                requestLocation(this.mLocationCityHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(CityListResponse cityListResponse) {
        List<SitesBean> sites;
        int e;
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "996515862")) {
            ipChange.ipc$dispatch("996515862", new Object[]{this, cityListResponse});
            return;
        }
        this.mSectionTitle.clear();
        this.mCityListData.clear();
        this.mGroupCityListManualMap.clear();
        this.mSectionTitle.put(0, "当前定位城市");
        cj cjVar = new cj(0);
        this.mLocationCityHolder = cjVar;
        updateLocationCityHolder(cjVar, false);
        this.mCityListData.add(this.mLocationCityHolder);
        List<HotCityBean> hotCity = cityListResponse.getHotCity();
        int e2 = wh2.e(hotCity);
        if (e2 > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < e2; i2++) {
                HotCityBean hotCityBean = hotCity.get(i2);
                if (TextUtils.getTrimmedLength(hotCityBean.getCityId()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getCityName()) > 0 && TextUtils.getTrimmedLength(hotCityBean.getUrl()) > 0) {
                    arrayList.add(hotCityBean);
                    this.mHotCityListManualMap.put(hotCityBean.getCityId(), hotCityBean.getUrl());
                }
            }
            if (wh2.e(arrayList) > 0) {
                this.mSectionTitle.put(1, "热门城市");
                this.mLetterIndexList.add("热");
                cj cjVar2 = new cj(1);
                cjVar2.e(arrayList);
                this.mCityListData.add(cjVar2);
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
                        this.mSectionTitle.put(Integer.valueOf(i), groupsBean.getSpellCode());
                        this.mLetterIndexList.add(groupsBean.getSpellCode());
                        cj cjVar3 = new cj(2);
                        cjVar3.g(arrayList2);
                        this.mCityListData.add(cjVar3);
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
                    this.mGroupCityListManualMap.put(manualBean.getCityId(), manualBean.getUrl());
                }
            }
        }
        FloatingTitleDecoration floatingTitleDecoration = new FloatingTitleDecoration(this.mContext);
        floatingTitleDecoration.d(this.mSectionTitle);
        floatingTitleDecoration.c(this.mSectionTitleHeight);
        this.mCityList.addItemDecoration(floatingTitleDecoration);
        this.mLetterSortBar.setLetters(this.mLetterIndexList);
        this.mAdapter.notifyDataSetChanged();
        dispatchLocationChecking(false);
    }

    private void initLetterSortBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1033060701")) {
            ipChange.ipc$dispatch("1033060701", new Object[]{this});
            return;
        }
        LetterSortBar letterSortBar = (LetterSortBar) findViewById(R$id.city_select_sort_letter);
        this.mLetterSortBar = letterSortBar;
        letterSortBar.setOnTouchingLetterChangedListener(new C0600b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLocation(cj cjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227674141")) {
            ipChange.ipc$dispatch("1227674141", new Object[]{this, cjVar});
            return;
        }
        CityLocationUtil cityLocationUtil = new CityLocationUtil(this.mContext, new C0604d(cjVar));
        this.mCityLocationUtil = cityLocationUtil;
        cityLocationUtil.p(true);
        this.mCityLocationUtil.n();
    }

    private void initRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1779831878")) {
            ipChange.ipc$dispatch("-1779831878", new Object[]{this});
            return;
        }
        this.mCityList = (RecyclerView) findViewById(R$id.city_select_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(1);
        this.mCityList.setLayoutManager(linearLayoutManager);
        CitySelectAdapter citySelectAdapter = new CitySelectAdapter(this, this.mCityListData);
        this.mAdapter = citySelectAdapter;
        citySelectAdapter.g(this.mOnCityListItemClickListener);
        CityParam cityParam = this.mExtraCity;
        if (cityParam != null && cityParam.isOnlyObtainCityId && !TextUtils.isEmpty(cityParam.selectCityName)) {
            this.mAdapter.h(this.mExtraCity.selectCityName);
        }
        this.mCityList.setAdapter(this.mAdapter);
        this.mCityList.addOnScrollListener(this.mOnScrollListener);
    }

    private void initTitleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920365681")) {
            ipChange.ipc$dispatch("-1920365681", new Object[]{this});
            return;
        }
        this.mSectionTitleHeight = t60.a(this.mContext, 40.0f);
        findViewById(R$id.city_select_cancel).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020681590")) {
            ipChange.ipc$dispatch("-1020681590", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mIndex = i;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mCityList.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition) {
            this.mCityList.scrollToPosition(i);
        } else if (i <= findLastVisibleItemPosition) {
            this.mCityList.scrollBy(0, this.mCityList.getChildAt(i - findFirstVisibleItemPosition).getTop() - this.mSectionTitleHeight);
        } else {
            this.mCityList.scrollToPosition(i);
            this.mMoveAgain = true;
        }
    }

    private void requestCityList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1270895740")) {
            ipChange.ipc$dispatch("-1270895740", new Object[]{this});
            return;
        }
        CityListRequest cityListRequest = new CityListRequest();
        cityListRequest.showLoginUI(false);
        cityListRequest.request(new DMMtopRequestListener<CityListResponse>(CityListResponse.class) { // from class: cn.damai.commonbusiness.city.CitySelectActivity.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1989172907")) {
                    ipChange2.ipc$dispatch("-1989172907", new Object[]{this, str, str2});
                    return;
                }
                CitySelectActivity.this.stopProgressDialog();
                String B = z20.B(ShareperfenceConstants.CITY_DATA_New);
                if (TextUtils.isEmpty(B)) {
                    B = yi.a(CitySelectActivity.this);
                }
                try {
                    CityListResponse cityListResponse = (CityListResponse) JSON.parseObject(B, CityListResponse.class);
                    if (cityListResponse != null) {
                        CitySelectActivity.this.initData(cityListResponse);
                    }
                } catch (Exception e) {
                    cb1.b("CitySelectActivity", e.getMessage());
                }
                ToastUtil.a().e(CitySelectActivity.this.mContext, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CityListResponse cityListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "798063426")) {
                    ipChange2.ipc$dispatch("798063426", new Object[]{this, cityListResponse});
                    return;
                }
                CitySelectActivity.this.stopProgressDialog();
                if (cityListResponse != null) {
                    CitySelectActivity.this.initData(cityListResponse);
                    try {
                        z20.T(ShareperfenceConstants.CITY_DATA_New, JSON.toJSONString(cityListResponse));
                        z20.T(ShareperfenceConstants.CITY_CACHE_TIME_New, String.valueOf(System.currentTimeMillis()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        startProgressDialog();
    }

    private void requestLocation(cj cjVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281023380")) {
            ipChange.ipc$dispatch("-281023380", new Object[]{this, cjVar});
            return;
        }
        String[] strArr = mr1.LOCATION;
        new Permission(this, new PermissionModel(strArr, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new C0601c(ir1.i(strArr), cjVar)).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean trySetCityResultAndFinish(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697982407")) {
            return ((Boolean) ipChange.ipc$dispatch("-1697982407", new Object[]{this, str, str2})).booleanValue();
        }
        CityParam cityParam = this.mExtraCity;
        if (cityParam == null || !cityParam.isOnlyObtainCityId) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent();
            intent.putExtra(CITY_ID, str);
            intent.putExtra(CITY_NAME, str2);
            setResult(-1, intent);
            finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocationCityHolder(cj cjVar, boolean z) {
        CitySelectAdapter citySelectAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086553639")) {
            ipChange.ipc$dispatch("1086553639", new Object[]{this, cjVar, Boolean.valueOf(z)});
        } else if (cjVar == null || cjVar.d() != 0) {
        } else {
            if (ir1.i(mr1.LOCATION)) {
                cjVar.c = 119;
            } else {
                cjVar.c = 102;
            }
            if (!z || (citySelectAdapter = this.mAdapter) == null) {
                return;
            }
            citySelectAdapter.notifyDataSetChanged();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147461866")) {
            ipChange.ipc$dispatch("-1147461866", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2138815764") ? ((Integer) ipChange.ipc$dispatch("2138815764", new Object[]{this})).intValue() : R$layout.activity_city_select;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16780519")) {
            ipChange.ipc$dispatch("16780519", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891057188")) {
            ipChange.ipc$dispatch("1891057188", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260996615")) {
            ipChange.ipc$dispatch("-260996615", new Object[]{this});
            return;
        }
        this.mExtraCity = (CityParam) getIntent().getParcelableExtra(OBTAIN_CITY_PARAM);
        hideBaseLayout();
        initTitleView();
        initLetterSortBar();
        initRecyclerView();
        requestCityList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482531936")) {
            ipChange.ipc$dispatch("-1482531936", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 2168) {
            updateLocationCityHolder(this.mLocationCityHolder, true);
            dispatchLocationChecking(false);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456621983")) {
            ipChange.ipc$dispatch("456621983", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view.getId() == R$id.city_select_cancel) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101829215")) {
            ipChange.ipc$dispatch("-2101829215", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(pl.j().g());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259331094")) {
            ipChange.ipc$dispatch("1259331094", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061197119")) {
            ipChange.ipc$dispatch("1061197119", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "409830274")) {
            ipChange.ipc$dispatch("409830274", new Object[]{this});
            return;
        }
        super.onResume();
        ns2.a().c();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139304072")) {
            return (String) ipChange.ipc$dispatch("2139304072", new Object[]{this});
        }
        return null;
    }
}
