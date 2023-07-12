package cn.damai.ticklet.ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.view.PagerSlidingTabStrip;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.ExchangeSiteInfo;
import cn.damai.ticklet.bean.TicketServiceFacility;
import cn.damai.ticklet.bean.TickletVenueMapBean;
import cn.damai.ticklet.inteface.TickletVenueSiteCallback;
import cn.damai.ticklet.ui.adapter.TickletVenueServiceAdapter;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment;
import cn.damai.ticklet.view.ScrollLayout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.ed1;
import tb.t60;
import tb.un2;
import tb.vn2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletVenueActivity extends DamaiMapBaseActivity implements View.OnTouchListener, TickletVenueSiteCallback, AMap.InfoWindowAdapter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int TICKLET_VENUE_FROM_EXCHANGE_SITE = 1;
    public static int TICKLET_VENUE_FROM_MAP = 2;
    public static int TICKLET_VENUE_TYPE;
    private String allCoordinateSure;
    private String chosenLat;
    private String chosenLng;
    private RelativeLayout frameLayout;
    private ImageView ivBack;
    private ImageView ivVenueExchangeSite;
    private LatLng latLng;
    private ArrayList<ExchangeSiteInfo> listShowAllData;
    private VenuePageChangeListener mPageChangeListener;
    private vn2 mPoiOverlay;
    private ScrollLayout mScrollLayout;
    private MapView mapView;
    private TextView member_ticklet_exchange_title;
    private ViewPager myViewpager;
    private String performId;
    private String productSystemId;
    private Marker seletMarker;
    private PagerSlidingTabStrip tabs;
    private LinearLayout ticklet_ll_viewPager;
    private TextView tvMyPostion;
    private TextView tvVenuePostionNavi;
    private String venueName;
    private boolean loadUT_PageSelected = true;
    private ArrayList<TickletVenueMapBean> mTabTypeList = new ArrayList<>();
    private ArrayList<TickletVenueServiceListFragment> mTickletVenueServiceListFragments = new ArrayList<>();
    private TickletVenueMapBean exchangeSiteBean = new TickletVenueMapBean();
    private TickletVenueMapBean parkBean = new TickletVenueMapBean();
    private TickletVenueMapBean publicTransitBean = new TickletVenueMapBean();
    private TickletVenueMapBean conveninceStoreBean = new TickletVenueMapBean();
    private TickletVenueMapBean toiletBean = new TickletVenueMapBean();
    private TickletVenueMapBean fineFoodBean = new TickletVenueMapBean();
    private TickletVenueMapBean shopMallBean = new TickletVenueMapBean();
    private ed1 choose = new ed1();
    private boolean isFirstLoc = true;
    private boolean isClickMyPos = false;
    private int from = 0;
    private int clickType = 0;
    private boolean isFirstEnter = true;
    private ScrollLayout.OnScrollChangedListener mOnScrollChangedListener = new C2042a();
    private int currentChooseIndex = -1;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class VenuePageChangeListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        VenuePageChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1747880235")) {
                ipChange.ipc$dispatch("-1747880235", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1700616076")) {
                ipChange.ipc$dispatch("-1700616076", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-551883680")) {
                ipChange.ipc$dispatch("-551883680", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            cb1.a("onPageSelected/in pos:" + i);
            if (TickletVenueActivity.this.mTabTypeList == null || i >= TickletVenueActivity.this.mTabTypeList.size()) {
                return;
            }
            if (!TickletVenueActivity.this.loadUT_PageSelected) {
                TickletVenueActivity.this.loadUT_PageSelected = true;
            }
            TickletVenueActivity.this.clickType = i;
            TickletVenueActivity.this.clearSelectMark();
            try {
                TickletVenueActivity tickletVenueActivity = TickletVenueActivity.this;
                tickletVenueActivity.showData(((TickletVenueServiceListFragment) tickletVenueActivity.mTickletVenueServiceListFragments.get(i)).getTypeDataList());
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.activity.TickletVenueActivity$a */
    /* loaded from: classes7.dex */
    public class C2042a implements ScrollLayout.OnScrollChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2042a() {
        }

        @Override // cn.damai.ticklet.view.ScrollLayout.OnScrollChangedListener
        public void onChildScroll(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1880612194")) {
                ipChange.ipc$dispatch("-1880612194", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.ticklet.view.ScrollLayout.OnScrollChangedListener
        public void onScrollFinished(ScrollLayout.Status status) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1301659203")) {
                ipChange.ipc$dispatch("1301659203", new Object[]{this, status});
            } else {
                status.equals(ScrollLayout.Status.EXIT);
            }
        }

        @Override // cn.damai.ticklet.view.ScrollLayout.OnScrollChangedListener
        public void onScrollProgressChanged(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "891402316")) {
                ipChange.ipc$dispatch("891402316", new Object[]{this, Float.valueOf(f)});
                return;
            }
            float f2 = 0.0f;
            if (f >= 0.0f) {
                float f3 = f * 255.0f;
                if (f3 > 255.0f) {
                    f2 = 255.0f;
                } else if (f3 >= 0.0f) {
                    f2 = f3;
                }
                TickletVenueActivity.this.mScrollLayout.getBackground().setAlpha(255 - ((int) f2));
            }
        }
    }

    private void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731465755")) {
            ipChange.ipc$dispatch("-1731465755", new Object[]{this});
            return;
        }
        ArrayList<ExchangeSiteInfo> arrayList = this.listShowAllData;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.seletMarker = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelectMark() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200569402")) {
            ipChange.ipc$dispatch("-1200569402", new Object[]{this});
        } else {
            this.seletMarker = null;
        }
    }

    private int getLength(List<ExchangeSiteInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178546276")) {
            return ((Integer) ipChange.ipc$dispatch("178546276", new Object[]{this, list})).intValue();
        }
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return list.size();
    }

    private void handleMarkShowResult(List<ExchangeSiteInfo> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1161250864")) {
            ipChange.ipc$dispatch("-1161250864", new Object[]{this, list});
        } else if (list != null) {
            if (list.size() == 0) {
                vn2 vn2Var = this.mPoiOverlay;
                if (vn2Var != null) {
                    vn2Var.g();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            new ExchangeSiteInfo();
            int length = getLength(list);
            double d = 0.0d;
            double d2 = 0.0d;
            double d3 = 0.0d;
            while (i < length) {
                ExchangeSiteInfo exchangeSiteInfo = list.get(i);
                if (!TextUtils.isEmpty(exchangeSiteInfo.lat) && !TextUtils.isEmpty(exchangeSiteInfo.lng)) {
                    d2 = Double.parseDouble(exchangeSiteInfo.lat);
                    d3 = Double.parseDouble(exchangeSiteInfo.lng);
                    if (d2 > d && d3 > d) {
                        arrayList.add(new PoiItem(null, new LatLonPoint(d2, d3), String.valueOf(i + 1), null));
                    }
                }
                i++;
                d = 0.0d;
            }
            vn2 vn2Var2 = this.mPoiOverlay;
            if (vn2Var2 != null) {
                vn2Var2.g();
            }
            if (arrayList.size() > 0) {
                try {
                    vn2 vn2Var3 = new vn2(this.aMap, arrayList, getApplicationContext());
                    this.mPoiOverlay = vn2Var3;
                    vn2Var3.g();
                    this.mPoiOverlay.a();
                } catch (Exception e) {
                    cb1.b("StackTrace", e.toString());
                }
                if (list.size() == 1) {
                    this.aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d2, d3), 12.0f));
                    return;
                }
                try {
                    vn2 vn2Var4 = this.mPoiOverlay;
                    if (vn2Var4 != null) {
                        vn2Var4.h();
                    }
                } catch (Exception e2) {
                    cb1.c("StackTrace", e2.toString());
                }
            }
        }
    }

    private void initPage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25805868")) {
            ipChange.ipc$dispatch("-25805868", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ArrayList<TickletVenueMapBean> arrayList = this.mTabTypeList;
        if (arrayList == null) {
            this.mTabTypeList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        ArrayList<TickletVenueServiceListFragment> arrayList2 = this.mTickletVenueServiceListFragments;
        if (arrayList2 == null) {
            this.mTickletVenueServiceListFragments = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        if (this.from == TICKLET_VENUE_FROM_MAP) {
            this.member_ticklet_exchange_title.setVisibility(8);
            this.tabs.setVisibility(0);
            for (int i2 = 0; i2 < 6; i2++) {
                if (i2 == 0) {
                    TickletVenueMapBean tickletVenueMapBean = this.publicTransitBean;
                    tickletVenueMapBean.pageTitle = TicketServiceFacility.PUBLIC_TRANSIT;
                    tickletVenueMapBean.exchangeSiteInfos = new ArrayList<>();
                    TickletVenueServiceListFragment newInstance = TickletVenueServiceListFragment.newInstance(this.publicTransitBean, i2, this.chosenLat, this.chosenLng, false, this.performId, this.productSystemId);
                    newInstance.setCallBack(this);
                    this.mTickletVenueServiceListFragments.add(newInstance);
                    this.mTabTypeList.add(this.publicTransitBean);
                } else if (i2 == 1) {
                    TickletVenueMapBean tickletVenueMapBean2 = this.parkBean;
                    tickletVenueMapBean2.pageTitle = TicketServiceFacility.PARKING;
                    tickletVenueMapBean2.exchangeSiteInfos = new ArrayList<>();
                    TickletVenueServiceListFragment newInstance2 = TickletVenueServiceListFragment.newInstance(this.parkBean, i2, this.chosenLat, this.chosenLng, false, this.performId, this.productSystemId);
                    newInstance2.setCallBack(this);
                    this.mTickletVenueServiceListFragments.add(newInstance2);
                    this.mTabTypeList.add(this.parkBean);
                } else if (i2 == 2) {
                    TickletVenueMapBean tickletVenueMapBean3 = this.fineFoodBean;
                    tickletVenueMapBean3.pageTitle = TicketServiceFacility.FINE_FOOD;
                    tickletVenueMapBean3.exchangeSiteInfos = new ArrayList<>();
                    TickletVenueServiceListFragment newInstance3 = TickletVenueServiceListFragment.newInstance(this.fineFoodBean, i2, this.chosenLat, this.chosenLng, false, this.performId, this.productSystemId);
                    newInstance3.setCallBack(this);
                    this.mTickletVenueServiceListFragments.add(newInstance3);
                    this.mTabTypeList.add(this.fineFoodBean);
                } else if (i2 == 3) {
                    TickletVenueMapBean tickletVenueMapBean4 = this.toiletBean;
                    tickletVenueMapBean4.pageTitle = TicketServiceFacility.TOILET;
                    tickletVenueMapBean4.exchangeSiteInfos = new ArrayList<>();
                    TickletVenueServiceListFragment newInstance4 = TickletVenueServiceListFragment.newInstance(this.toiletBean, i2, this.chosenLat, this.chosenLng, false, this.performId, this.productSystemId);
                    newInstance4.setCallBack(this);
                    this.mTickletVenueServiceListFragments.add(newInstance4);
                    this.mTabTypeList.add(this.toiletBean);
                } else if (i2 == 4) {
                    TickletVenueMapBean tickletVenueMapBean5 = this.conveninceStoreBean;
                    tickletVenueMapBean5.pageTitle = TicketServiceFacility.CONVENINCE_STORE;
                    tickletVenueMapBean5.exchangeSiteInfos = new ArrayList<>();
                    TickletVenueServiceListFragment newInstance5 = TickletVenueServiceListFragment.newInstance(this.conveninceStoreBean, i2, this.chosenLat, this.chosenLng, false, this.performId, this.productSystemId);
                    newInstance5.setCallBack(this);
                    this.mTickletVenueServiceListFragments.add(newInstance5);
                    this.mTabTypeList.add(this.conveninceStoreBean);
                } else if (i2 == 5) {
                    TickletVenueMapBean tickletVenueMapBean6 = this.shopMallBean;
                    tickletVenueMapBean6.pageTitle = TicketServiceFacility.SHOP_MALL;
                    tickletVenueMapBean6.exchangeSiteInfos = new ArrayList<>();
                    TickletVenueServiceListFragment newInstance6 = TickletVenueServiceListFragment.newInstance(this.shopMallBean, i2, this.chosenLat, this.chosenLng, false, this.performId, this.productSystemId);
                    newInstance6.setCallBack(this);
                    this.mTickletVenueServiceListFragments.add(newInstance6);
                    this.mTabTypeList.add(this.shopMallBean);
                }
            }
        } else {
            TickletVenueMapBean tickletVenueMapBean7 = this.exchangeSiteBean;
            tickletVenueMapBean7.pageTitle = TicketServiceFacility.EXCHANGE_SITE;
            tickletVenueMapBean7.exchangeSiteInfos = new ArrayList<>();
            TickletVenueServiceListFragment newInstance7 = TickletVenueServiceListFragment.newInstance(this.exchangeSiteBean, TICKLET_VENUE_TYPE, this.chosenLat, this.chosenLng, true, this.performId, this.productSystemId);
            newInstance7.setCallBack(this);
            this.mTickletVenueServiceListFragments.add(newInstance7);
            this.mTabTypeList.add(this.exchangeSiteBean);
            this.member_ticklet_exchange_title.setVisibility(0);
            this.tabs.setVisibility(8);
        }
        if (i > 0) {
            this.loadUT_PageSelected = false;
        }
        this.myViewpager.setAdapter(new TickletVenueServiceAdapter(getSupportFragmentManager(), this.mTickletVenueServiceListFragments, this.mTabTypeList));
        VenuePageChangeListener venuePageChangeListener = new VenuePageChangeListener();
        this.mPageChangeListener = venuePageChangeListener;
        this.myViewpager.addOnPageChangeListener(venuePageChangeListener);
        this.myViewpager.setOffscreenPageLimit(1);
        this.myViewpager.setCurrentItem(i);
        this.tabs.setLineWidth(t60.a(this, 30.0f));
        this.tabs.setViewPager(this.myViewpager);
        this.tabs.setFadingEdgeLength(0);
        this.tabs.notifyDataSetChanged();
    }

    private void loadPageUT() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169266566")) {
            ipChange.ipc$dispatch("-1169266566", new Object[]{this});
        } else {
            C0529c.e().n(this, C0528b.getInstance().b("xxxxx"));
        }
    }

    private void realShowMapMarkByItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67140063")) {
            ipChange.ipc$dispatch("67140063", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= 0) {
            cb1.c("showMapMarkByItem", "chooseIndex1=" + i);
            List<Marker> mapScreenMarkers = this.aMap.getMapScreenMarkers();
            if (this.aMap.getMapScreenMarkers().size() > 0) {
                cb1.c("showMapMarkByItem", "aMap.getMapScreenMarkers().size()=" + this.aMap.getMapScreenMarkers().size());
                for (int i2 = 0; i2 < mapScreenMarkers.size(); i2++) {
                    Marker marker = mapScreenMarkers.get(i2);
                    cb1.c("showMapMarkByItem", "marker1.getTitle()=" + marker.getTitle());
                    if (String.valueOf(i + 1).equals(marker.getTitle())) {
                        cb1.c("showMapMarkByItem", "chooseIndex1+1 == marker1.getTitle()");
                        marker.setIcon(BitmapDescriptorFactory.fromView(this.mPoiOverlay.i(new PoiItem(null, new LatLonPoint(marker.getPosition().latitude, marker.getPosition().longitude), marker.getTitle(), null), 1)));
                        this.seletMarker = marker;
                        this.currentChooseIndex = -1;
                        return;
                    }
                    cb1.c("showMapMarkByItem", "String.valueOf(chooseIndex1+1).equals(marker1.getTitle())=false, marker1.getTitle()=" + marker.getTitle());
                }
                return;
            }
            cb1.c("showMapMarkByItem", "aMap.getMapScreenMarkers().size()=0");
        }
    }

    private void render(Marker marker, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180730808")) {
            ipChange.ipc$dispatch("-1180730808", new Object[]{this, marker, view});
        } else {
            ((TextView) view.findViewById(R$id.ticklet_map_custom_title)).setText(this.venueName);
        }
    }

    private void selectMarkBackNormal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055127255")) {
            ipChange.ipc$dispatch("2055127255", new Object[]{this});
            return;
        }
        Marker marker = this.seletMarker;
        if (marker == null || marker.getPosition() == null) {
            return;
        }
        this.seletMarker.setIcon(BitmapDescriptorFactory.fromView(this.mPoiOverlay.i(new PoiItem(null, new LatLonPoint(this.seletMarker.getPosition().latitude, this.seletMarker.getPosition().latitude), this.seletMarker.getTitle(), null), 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showData(ArrayList<ExchangeSiteInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85195907")) {
            ipChange.ipc$dispatch("85195907", new Object[]{this, arrayList});
            return;
        }
        this.ticklet_ll_viewPager.setVisibility(0);
        this.listShowAllData = arrayList;
        handleMarkShowResult(arrayList);
        showExchangeSite();
    }

    private void showExchangeSite() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-222222553")) {
            ipChange.ipc$dispatch("-222222553", new Object[]{this});
            return;
        }
        int i = -1;
        Marker marker = this.seletMarker;
        if (marker != null && !TextUtils.isEmpty(marker.getTitle())) {
            try {
                i = Integer.parseInt(this.seletMarker.getTitle()) - 1;
            } catch (Exception unused) {
                cb1.b("venueActivity", "Integer.parseInt fail");
            }
        }
        showVenueExchangeSiteWindow(i);
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void addMapMarkData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487666948")) {
            ipChange.ipc$dispatch("-487666948", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void callNavi(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "415203816")) {
            ipChange.ipc$dispatch("415203816", new Object[]{this, str, str2, str3});
        } else {
            this.choose.e(this, this.frameLayout, this, str, str2, str3);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void getDataType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-763380255")) {
            ipChange.ipc$dispatch("-763380255", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068869362")) {
            return (View) ipChange.ipc$dispatch("1068869362", new Object[]{this, marker});
        }
        View inflate = getLayoutInflater().inflate(R$layout.ticklet_map_custom_info_contents, (ViewGroup) null);
        render(marker, inflate);
        return inflate;
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1328411492")) {
            return (View) ipChange.ipc$dispatch("-1328411492", new Object[]{this, marker});
        }
        View inflate = getLayoutInflater().inflate(R$layout.ticklet_map_custom_info_contents, (ViewGroup) null);
        render(marker, inflate);
        return inflate;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1390966228") ? ((Integer) ipChange.ipc$dispatch("1390966228", new Object[]{this})).intValue() : R$layout.ticklet_venue_layout;
    }

    public vn2 getPoiOverlay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "69044752") ? (vn2) ipChange.ipc$dispatch("69044752", new Object[]{this}) : this.mPoiOverlay;
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity
    public void initMap(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-600897052")) {
            ipChange.ipc$dispatch("-600897052", new Object[]{this, bundle});
            return;
        }
        if (this.aMap == null) {
            if (this.mapView == null) {
                this.mapView = (MapView) findViewById(R$id.member_ticklet_venue_map);
            }
            this.aMap = this.mapView.getMap();
        }
        UiSettings uiSettings = this.aMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setMyLocationButtonEnabled(false);
        this.aMap.setLocationSource(this);
        this.aMap.setMyLocationEnabled(true);
        this.aMap.setOnCameraChangeListener(this);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R$drawable.location_marker));
        myLocationStyle.radiusFillColor(17170445);
        myLocationStyle.strokeColor(17170445);
        this.aMap.setMyLocationStyle(myLocationStyle);
        this.aMap.setOnMarkerClickListener(this);
        this.aMap.setOnMapClickListener(this);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1395491129")) {
            ipChange.ipc$dispatch("1395491129", new Object[]{this});
            return;
        }
        this.frameLayout = (RelativeLayout) findViewById(R$id.member_venue_fl);
        this.myViewpager = (ViewPager) findViewById(R$id.vPager);
        this.tabs = (PagerSlidingTabStrip) findViewById(R$id.indicator);
        this.mapView = (MapView) findViewById(R$id.member_ticklet_venue_map);
        this.ivBack = (ImageView) findViewById(R$id.member_ticklet_venue_back);
        this.tvMyPostion = (TextView) findViewById(R$id.member_ticklet_venue_my_pos);
        this.member_ticklet_exchange_title = (TextView) findViewById(R$id.member_ticklet_exchange_title);
        this.tvVenuePostionNavi = (TextView) findViewById(R$id.member_ticklet_venue_go_venue);
        this.ivVenueExchangeSite = (ImageView) findViewById(R$id.member_ticklet_venue_ExchangeSite_ainm);
        this.ticklet_ll_viewPager = (LinearLayout) findViewById(R$id.ticklet_ll_viewPager);
        this.mScrollLayout = (ScrollLayout) findViewById(R$id.scroll_down_layout);
        this.ivBack.setOnClickListener(this);
        this.tvMyPostion.setOnClickListener(this);
        this.tvVenuePostionNavi.setOnClickListener(this);
        this.member_ticklet_exchange_title.setOnClickListener(this);
        this.mapView.setOnTouchListener(this);
        this.mScrollLayout.setMinOffset(t60.a(this, 80.0f));
        this.mScrollLayout.setMaxOffset((int) ((DisplayMetrics.getheightPixels(t60.b(this)) * 0.5d) - t60.a(this, 25.0f)));
        this.mScrollLayout.setExitOffset(t60.a(this, 66.0f));
        this.mScrollLayout.setIsSupportExit(true);
        this.mScrollLayout.setAllowHorizontalScroll(true);
        this.mScrollLayout.setOnScrollChangedListener(this.mOnScrollChangedListener);
        this.mScrollLayout.setToOpen();
        this.mScrollLayout.getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "953060064")) {
            ipChange.ipc$dispatch("953060064", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852891803")) {
            ipChange.ipc$dispatch("-852891803", new Object[]{this, cameraPosition});
            return;
        }
        cb1.c("showMapMarkByItem", "移动位置完成" + this.aMap.getCameraPosition());
        int i = this.currentChooseIndex;
        if (i != -1) {
            realShowMapMarkByItem(i);
        }
        this.currentChooseIndex = -1;
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027278625")) {
            ipChange.ipc$dispatch("-2027278625", new Object[]{this, view});
        } else if (view.getId() == R$id.member_ticklet_venue_back) {
            onBackPressed();
        } else if (view.getId() == R$id.member_ticklet_venue_my_pos) {
            this.isFirstLoc = true;
            this.isClickMyPos = true;
            initLoc("方便您查询场馆或取票点位置信息");
        } else if (view.getId() == R$id.member_ticklet_venue_go_venue) {
            this.choose.e(this, this.frameLayout, this, this.chosenLat, this.chosenLng, this.venueName);
        }
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793336735")) {
            ipChange.ipc$dispatch("-1793336735", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = getIntent().getStringExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
            this.chosenLat = getIntent().getStringExtra("chosenLat");
            this.chosenLng = getIntent().getStringExtra("chosenLng");
            this.venueName = getIntent().getStringExtra("venueName");
            this.allCoordinateSure = getIntent().getStringExtra("allCoordinateSure");
            String stringExtra = getIntent().getStringExtra("from");
            if (TextUtils.isEmpty(stringExtra)) {
                this.from = getIntent().getIntExtra("from", 0);
            } else {
                try {
                    this.from = Integer.parseInt(stringExtra);
                } catch (Exception unused) {
                }
            }
            this.clickType = getIntent().getIntExtra(PushConstants.CLICK_TYPE, 0);
        }
        this.mapView.onCreate(bundle);
        if (!TextUtils.isEmpty(this.venueName)) {
            this.aMap.setInfoWindowAdapter(this);
        }
        hideBaseLayout();
        int i = this.from;
        if (i == TICKLET_VENUE_FROM_EXCHANGE_SITE) {
            if ("1".equals(this.allCoordinateSure)) {
                this.mapView.setVisibility(0);
                this.tvMyPostion.setVisibility(0);
            } else {
                this.mapView.setVisibility(8);
                this.tvMyPostion.setVisibility(8);
                this.mScrollLayout.setEnable(false);
                this.mScrollLayout.scrollTo(0, -t60.a(this, 90.0f));
            }
            this.tvVenuePostionNavi.setVisibility(8);
            this.clickType = TICKLET_VENUE_TYPE;
        } else if (i == TICKLET_VENUE_FROM_MAP && (str = this.chosenLat) != null && !"".equals(str) && (str2 = this.chosenLng) != null && !"".equals(str2)) {
            this.latLng = new LatLng(Double.parseDouble(this.chosenLat), Double.parseDouble(this.chosenLng));
        }
        initPage(this.clickType);
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_VENUEMAP));
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        VenuePageChangeListener venuePageChangeListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1649826273")) {
            ipChange.ipc$dispatch("1649826273", new Object[]{this});
            return;
        }
        super.onDestroy();
        this.mPoiOverlay = null;
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.onDestroy();
            this.mapView = null;
        }
        ViewPager viewPager = this.myViewpager;
        if (viewPager != null && (venuePageChangeListener = this.mPageChangeListener) != null) {
            viewPager.removeOnPageChangeListener(venuePageChangeListener);
        }
        this.myViewpager = null;
        clearData();
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198485179")) {
            ipChange.ipc$dispatch("-1198485179", new Object[]{this, str, str2});
            return;
        }
        cb1.a("onFail/in " + str + " msg:" + str2);
        vn2 vn2Var = this.mPoiOverlay;
        if (vn2Var != null) {
            vn2Var.g();
        }
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, com.alibaba.pictures.piclocation.listener.LocateMapListener
    public void onMapLocationFailed(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241339936")) {
            ipChange.ipc$dispatch("-1241339936", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        cb1.b("AmapError", "location Error, ErrCode:" + i + ", errInfo:" + str);
        ToastUtil.f("定位失败");
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, com.alibaba.pictures.piclocation.listener.LocateMapListener
    public void onMapLocationSuccess(AMapLocation aMapLocation) {
        AMap aMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1920673757")) {
            ipChange.ipc$dispatch("1920673757", new Object[]{this, aMapLocation});
        } else if (!this.isFirstLoc || (aMap = this.aMap) == null || this.mListener == null || !this.isClickMyPos) {
        } else {
            aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
            this.isClickMyPos = false;
            this.mListener.onLocationChanged(aMapLocation);
            this.isFirstLoc = false;
        }
    }

    @Override // cn.damai.ticklet.ui.activity.DamaiMapBaseActivity, com.amap.api.maps.AMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1857543459")) {
            return ((Boolean) ipChange.ipc$dispatch("1857543459", new Object[]{this, marker})).booleanValue();
        }
        if (marker != null && !TextUtils.isEmpty(marker.getTitle())) {
            i = Integer.parseInt(marker.getTitle()) - 1;
        }
        Marker marker2 = this.seletMarker;
        if (marker2 == null || marker2.getPosition() == null || this.seletMarker.getPosition().longitude != marker.getPosition().longitude || this.seletMarker.getPosition().latitude != marker.getPosition().latitude) {
            showVenueExchangeSiteWindow(i);
            selectMarkBackNormal();
            marker.setIcon(BitmapDescriptorFactory.fromView(this.mPoiOverlay.i(new PoiItem(null, new LatLonPoint(marker.getPosition().latitude, marker.getPosition().longitude), marker.getTitle(), null), 1)));
            this.seletMarker = marker;
            if (this.mScrollLayout.getCurrentStatus() == ScrollLayout.Status.EXIT) {
                this.mScrollLayout.setToOpen();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720984956")) {
            ipChange.ipc$dispatch("720984956", new Object[]{this, intent});
        } else {
            super.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429143013")) {
            ipChange.ipc$dispatch("429143013", new Object[]{this});
            return;
        }
        super.onPause();
        this.mapView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2066318018")) {
            ipChange.ipc$dispatch("2066318018", new Object[]{this});
            return;
        }
        super.onResume();
        this.mapView.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459555944")) {
            ipChange.ipc$dispatch("-1459555944", new Object[]{this, bundle});
            return;
        }
        super.onSaveInstanceState(bundle);
        this.mapView.onSaveInstanceState(bundle);
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void onServiceDataSuccess(int i, ArrayList arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307984850")) {
            ipChange.ipc$dispatch("307984850", new Object[]{this, Integer.valueOf(i), arrayList});
            return;
        }
        if (this.from == TICKLET_VENUE_FROM_EXCHANGE_SITE) {
            SpannableString spannableString = new SpannableString("取票点 共" + arrayList.size() + "个");
            spannableString.setSpan(new AbsoluteSizeSpan(t60.a(this, 16.0f)), 0, 3, 33);
            Resources resources = getResources();
            int i2 = R$color.color_000000;
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(i2)), 0, 3, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(t60.a(this, 14.0f)), 4, spannableString.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(i2)), 5, 6, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.color_fa1155)), 5, spannableString.length() - 1, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(i2)), spannableString.length(), spannableString.length(), 33);
            this.member_ticklet_exchange_title.setText(spannableString);
        }
        try {
            if (i == this.mTickletVenueServiceListFragments.get(this.myViewpager.getCurrentItem()).getServiceType()) {
                cb1.a("onServiceDataSuccess CALL SHOWDATA ");
                showData(arrayList);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678293487")) {
            return ((Boolean) ipChange.ipc$dispatch("678293487", new Object[]{this, view, motionEvent})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void reloadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190670549")) {
            ipChange.ipc$dispatch("-1190670549", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void showMapMarkByItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545967965")) {
            ipChange.ipc$dispatch("1545967965", new Object[]{this, Integer.valueOf(i)});
        } else if (this.seletMarker == null || !String.valueOf(i + 1).equals(this.seletMarker.getTitle())) {
            this.currentChooseIndex = i;
            selectMarkBackNormal();
            if (this.listShowAllData.size() > i && i >= 0 && !TextUtils.isEmpty(this.listShowAllData.get(i).lat) && !TextUtils.isEmpty(this.listShowAllData.get(i).lng)) {
                double parseDouble = Double.parseDouble(this.listShowAllData.get(i).lat);
                double parseDouble2 = Double.parseDouble(this.listShowAllData.get(i).lng);
                cb1.c("showMapMarkByItem", "移动位置latItem=" + parseDouble + "  lonItem=" + parseDouble2);
                this.aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(parseDouble, parseDouble2)));
                cb1.c("showMapMarkByItem", "移动位置");
                realShowMapMarkByItem(this.currentChooseIndex);
            }
            showVenueExchangeSiteWindow(i);
        }
    }

    @Override // cn.damai.ticklet.inteface.TickletVenueSiteCallback
    public void showPopIconUtil() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171413267")) {
            ipChange.ipc$dispatch("-1171413267", new Object[]{this});
        } else if (this.isFirstEnter) {
            Marker addMarker = this.aMap.addMarker(new MarkerOptions().position(this.latLng).icon(BitmapDescriptorFactory.fromResource(R$drawable.ticklet_venue_icon)).anchor(0.5f, 0.5f).title(this.venueName));
            this.aMap.moveCamera(CameraUpdateFactory.changeLatLng(this.latLng));
            addMarker.showInfoWindow();
            this.isFirstEnter = false;
        }
    }

    public void showVenueExchangeSiteWindow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732913389")) {
            ipChange.ipc$dispatch("-732913389", new Object[]{this, Integer.valueOf(i)});
        } else if (this.ticklet_ll_viewPager.getVisibility() == 0) {
            this.mTickletVenueServiceListFragments.get(this.clickType).scrollPos(i);
        }
    }
}
