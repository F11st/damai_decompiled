package cn.damai.ticklet.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.ExchangeSiteInfo;
import cn.damai.ticklet.bean.GaoDeCode;
import cn.damai.ticklet.bean.TicketServiceFacility;
import cn.damai.ticklet.bean.TickletExchangeSiteNearbyResult;
import cn.damai.ticklet.bean.TickletVenueMapBean;
import cn.damai.ticklet.inteface.TickletVenueSiteCallback;
import cn.damai.ticklet.net.TickletExchangeTicketSiteRequest;
import cn.damai.ticklet.ui.activity.TickletVenueActivity;
import cn.damai.ticklet.ui.adapter.TickletVenueExchangeSiteListAdapter;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.OnRefreshListener;
import cn.damai.uikit.irecycler.widget.WrapLinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXComponent;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.jn1;
import tb.t60;
import tb.wh2;
import tb.xn2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletVenueServiceListFragment extends DamaiBaseMvpFragment implements OnLoadMoreListener, OnRefreshListener, PoiSearch.OnPoiSearchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletVenueActivity activity;
    private TickletVenueSiteCallback callBack;
    private String chosenLat;
    private String chosenLng;
    private Context context;
    private TickletVenueMapBean data;
    private LinearLayout errorPageView;
    private boolean isExchangeSite;
    private LinearLayout llView;
    private TickletVenueExchangeSiteListAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerView;
    private String performId;
    private String productSystemId;
    private PoiSearch.Query query;
    private ProgressBar ticklet_venue_progress;
    private int mFirstVisibleItemCount = 0;
    private int mFirstVisibleItems = 0;
    private int type = 0;
    private String stationTraCode = "150700|150702|150500";
    private String stationCode = "150900";
    private String bianlidianCode = "060200|060201|060202";
    private String waterhandCode = "200300|200301|200302|200303|200304";
    private String foodCode = "050000";
    private String shopMallCode = "060100|060101|060102|060103|";
    private String noResult = "亲，没有查询到相关信息！";
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-945823198")) {
                ipChange.ipc$dispatch("-945823198", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            super.onScrollStateChanged(recyclerView, i);
            int findFirstVisibleItemPosition = TickletVenueServiceListFragment.this.mLinearLayoutManager.findFirstVisibleItemPosition();
            if (TickletVenueServiceListFragment.this.mFirstVisibleItems <= 0) {
                TickletVenueServiceListFragment.this.mFirstVisibleItems = findFirstVisibleItemPosition;
                TickletVenueServiceListFragment tickletVenueServiceListFragment = TickletVenueServiceListFragment.this;
                tickletVenueServiceListFragment.mFirstVisibleItemCount = tickletVenueServiceListFragment.mLinearLayoutManager.getChildCount();
            }
            if (findFirstVisibleItemPosition < TickletVenueServiceListFragment.this.mFirstVisibleItemCount || TickletVenueServiceListFragment.this.callBack == null) {
                return;
            }
            TickletVenueServiceListFragment.this.callBack.addMapMarkData();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-438974531")) {
                ipChange.ipc$dispatch("-438974531", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            } else {
                super.onScrolled(recyclerView, i, i2);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void exchangeListErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-596853276")) {
            ipChange.ipc$dispatch("-596853276", new Object[]{this, str, str2});
        } else {
            xn2.d(xn2.i(xn2.TICKLET_EXCHANGE_LIST_API, "mtop.damai.wireless.ticklet2.extension.exchangesite.list", str, str2, this.performId), xn2.TICKLET_EXCHANGE_LIST_NETWORK_ERROR_CODE, str, xn2.TICKLET_EXCHANGE_LIST_NETWORK_ERROR_MSG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exchangeSiteListError(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849637743")) {
            ipChange.ipc$dispatch("-1849637743", new Object[]{this, str, str2, str3});
        } else if (TextUtils.isEmpty(str)) {
            loadDataFinishRefreshUI(2, getResources().getString(R$string.ticklet_venue_error), str2, str3);
        } else {
            loadDataFinishRefreshUI(2, str, str2, str3);
        }
    }

    private String getCityCodeByName(String str) {
        List parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602117965")) {
            return (String) ipChange.ipc$dispatch("-1602117965", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String cityCodeList = getCityCodeList();
        try {
            if (!TextUtils.isEmpty(cityCodeList) && (parseArray = JSON.parseArray(cityCodeList, GaoDeCode.class)) != null && parseArray.size() > 0) {
                for (int i = 0; i < parseArray.size(); i++) {
                    GaoDeCode gaoDeCode = (GaoDeCode) parseArray.get(i);
                    if (gaoDeCode != null && (str.contains(gaoDeCode.name) || gaoDeCode.name.contains(str))) {
                        return gaoDeCode.code;
                    }
                }
            }
        } catch (Exception e) {
            cb1.b("StackTrace", e.toString());
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getCityCodeList() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "Stacktrace"
            com.android.alibaba.ip.runtime.IpChange r2 = cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment.$ipChange
            java.lang.String r3 = "-398919783"
            boolean r4 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r2, r3)
            if (r4 == 0) goto L1b
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r8
            java.lang.Object r0 = r2.ipc$dispatch(r3, r0)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L1b:
            r2 = 0
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            android.content.res.Resources r4 = r8.getResources()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            java.lang.String r5 = "gaode_citycode.txt"
            java.io.InputStream r4 = r4.open(r5)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            r2 = r0
        L35:
            java.lang.String r5 = r4.readLine()     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            if (r5 == 0) goto L4b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            r6.<init>()     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            r6.append(r2)     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            r6.append(r5)     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            goto L35
        L4b:
            r3.close()     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            r4.close()     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> La1
            r3.close()     // Catch: java.io.IOException -> L55
            goto L5d
        L55:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            tb.cb1.b(r1, r0)
        L5d:
            r4.close()     // Catch: java.io.IOException -> L61
            goto L69
        L61:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            tb.cb1.b(r1, r0)
        L69:
            return r2
        L6a:
            r2 = move-exception
            goto L7b
        L6c:
            r0 = move-exception
            r4 = r2
            goto La2
        L6f:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
            goto L7b
        L74:
            r0 = move-exception
            r4 = r2
            goto La3
        L77:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
        L7b:
            java.lang.String r5 = "StackTrace"
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La1
            tb.cb1.b(r5, r2)     // Catch: java.lang.Throwable -> La1
            if (r3 == 0) goto L92
            r3.close()     // Catch: java.io.IOException -> L8a
            goto L92
        L8a:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            tb.cb1.b(r1, r2)
        L92:
            if (r4 == 0) goto La0
            r4.close()     // Catch: java.io.IOException -> L98
            goto La0
        L98:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            tb.cb1.b(r1, r2)
        La0:
            return r0
        La1:
            r0 = move-exception
        La2:
            r2 = r3
        La3:
            if (r2 == 0) goto Lb1
            r2.close()     // Catch: java.io.IOException -> La9
            goto Lb1
        La9:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            tb.cb1.b(r1, r2)
        Lb1:
            if (r4 == 0) goto Lbf
            r4.close()     // Catch: java.io.IOException -> Lb7
            goto Lbf
        Lb7:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            tb.cb1.b(r1, r2)
        Lbf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment.getCityCodeList():java.lang.String");
    }

    private boolean isTypeListEmpty() {
        ArrayList<ExchangeSiteInfo> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872670068")) {
            return ((Boolean) ipChange.ipc$dispatch("-872670068", new Object[]{this})).booleanValue();
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        return tickletVenueMapBean == null || (arrayList = tickletVenueMapBean.exchangeSiteInfos) == null || arrayList.size() == 0;
    }

    private void loadExchangesiteList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "581697961")) {
            ipChange.ipc$dispatch("581697961", new Object[]{this});
            return;
        }
        TickletExchangeTicketSiteRequest tickletExchangeTicketSiteRequest = new TickletExchangeTicketSiteRequest();
        if (!TextUtils.isEmpty(this.performId)) {
            tickletExchangeTicketSiteRequest.performId = this.performId;
            tickletExchangeTicketSiteRequest.productSystemId = this.productSystemId;
            isLoading(true);
            tickletExchangeTicketSiteRequest.request(new DMMtopRequestListener<TickletExchangeSiteNearbyResult>(TickletExchangeSiteNearbyResult.class) { // from class: cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-901634821")) {
                        ipChange2.ipc$dispatch("-901634821", new Object[]{this, str, str2});
                        return;
                    }
                    TickletVenueServiceListFragment.this.stopProgressDialog();
                    TickletVenueServiceListFragment.this.exchangeSiteListError(str2, str, "mtop.damai.wireless.ticklet2.extension.exchangesite.list");
                    TickletVenueServiceListFragment.this.exchangeListErrorXFlushMonitor(str, str2);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(TickletExchangeSiteNearbyResult tickletExchangeSiteNearbyResult) {
                    ArrayList<ExchangeSiteInfo> arrayList;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2032845710")) {
                        ipChange2.ipc$dispatch("2032845710", new Object[]{this, tickletExchangeSiteNearbyResult});
                        return;
                    }
                    TickletVenueServiceListFragment.this.stopProgressDialog();
                    if (tickletExchangeSiteNearbyResult != null && (arrayList = tickletExchangeSiteNearbyResult.exchangeSiteInfoList) != null && !arrayList.isEmpty()) {
                        TickletVenueServiceListFragment.this.returnExchangeSiteList(tickletExchangeSiteNearbyResult.exchangeSiteInfoList);
                        return;
                    }
                    TickletVenueServiceListFragment tickletVenueServiceListFragment = TickletVenueServiceListFragment.this;
                    tickletVenueServiceListFragment.loadDataFinishRefreshUI(3, tickletVenueServiceListFragment.getResources().getString(R$string.ticklet_venue_exchange_empty), "", "mtop.damai.wireless.ticklet2.extension.exchangesite.list");
                }
            });
            return;
        }
        exchangeSiteListError("", "", "");
    }

    public static TickletVenueServiceListFragment newInstance(TickletVenueMapBean tickletVenueMapBean, int i, String str, String str2, boolean z, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1299075817")) {
            return (TickletVenueServiceListFragment) ipChange.ipc$dispatch("-1299075817", new Object[]{tickletVenueMapBean, Integer.valueOf(i), str, str2, Boolean.valueOf(z), str3, str4});
        }
        TickletVenueServiceListFragment tickletVenueServiceListFragment = new TickletVenueServiceListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", tickletVenueMapBean);
        bundle.putInt("type", i);
        bundle.putString("chosenLat", str);
        bundle.putString("chosenLng", str2);
        bundle.putString(TicketDetailExtFragment.PERFORM_ID, str3);
        bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str4);
        bundle.putBoolean("isExchangeSite", z);
        tickletVenueServiceListFragment.setArguments(bundle);
        return tickletVenueServiceListFragment;
    }

    private void poiSearchErrorXFlushMonitor(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513343635")) {
            ipChange.ipc$dispatch("-513343635", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("info:{");
        sb.append("type:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(";");
        sb.append("code:");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(";");
        sb.append("venue:");
        sb.append(jn1.ARRAY_START_STR);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        sb.append(str4);
        sb.append("/");
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        sb.append(str5);
        sb.append(jn1.ARRAY_END_STR);
        sb.append("}");
        xn2.d(xn2.j(str, sb.toString(), this.performId), xn2.TICKLET_VENUE_POI_SEARCH_ERROR_CODE, xn2.TICKLET_VENUE_POI_SEARCH_ERROR_CODE, xn2.TICKLET_VENUE_POI_SEARCH_ERROR_MSG);
    }

    private String posType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125434654")) {
            return (String) ipChange.ipc$dispatch("-125434654", new Object[]{this, Integer.valueOf(i)});
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return i != 5 ? "" : this.shopMallCode;
                        }
                        return this.bianlidianCode;
                    }
                    return this.waterhandCode;
                }
                return this.foodCode;
            }
            return this.stationCode;
        }
        return this.stationTraCode;
    }

    private void searchMapData(int i) {
        TickletVenueSiteCallback tickletVenueSiteCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859973970")) {
            ipChange.ipc$dispatch("-859973970", new Object[]{this, Integer.valueOf(i)});
        } else if (!isTypeListEmpty() && (tickletVenueSiteCallback = this.callBack) != null) {
            tickletVenueSiteCallback.onServiceDataSuccess(i, this.data.exchangeSiteInfos);
        } else {
            String posType = posType(i);
            if (TextUtils.isEmpty(posType) || getContext() == null) {
                return;
            }
            String cityCodeByName = getCityCodeByName(z20.d());
            isLoading(true);
            if (!TextUtils.isEmpty(cityCodeByName) && !TextUtils.isEmpty(this.chosenLat) && !TextUtils.isEmpty(this.chosenLng)) {
                PoiSearch.Query query = new PoiSearch.Query("", posType, "");
                this.query = query;
                query.setPageSize(20);
                try {
                    PoiSearch poiSearch = new PoiSearch(getContext(), this.query);
                    poiSearch.setOnPoiSearchListener(this);
                    poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(Double.parseDouble(this.chosenLat), Double.parseDouble(this.chosenLng)), 1500));
                    poiSearch.searchPOIAsyn();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            loadDataFinishRefreshUI(2, "无法获取定位,搜索失败", null, null);
        }
    }

    private void showErrorPage(String str, boolean z, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848258395")) {
            ipChange.ipc$dispatch("-848258395", new Object[]{this, str, Boolean.valueOf(z), str2, str3});
        } else if (z) {
            onResponseError(str, str2, str3, this.errorPageView, true);
            this.mErrorPage.updateErrorPageGravity(48, t60.a(getContext(), 1.0f));
        } else {
            onResponseError(3, str, str2, str3, this.errorPageView, true);
            this.mErrorPage.updateErrorPageGravity(48, t60.a(getContext(), 1.0f));
        }
    }

    private String typeTitle(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1764213714") ? (String) ipChange.ipc$dispatch("1764213714", new Object[]{this, Integer.valueOf(i)}) : this.isExchangeSite ? TicketServiceFacility.EXCHANGE_SITE : i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : TicketServiceFacility.SHOP_MALL : TicketServiceFacility.CONVENINCE_STORE : TicketServiceFacility.TOILET : TicketServiceFacility.FINE_FOOD : TicketServiceFacility.PARKING : TicketServiceFacility.PUBLIC_TRANSIT;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-121024520") ? ((Integer) ipChange.ipc$dispatch("-121024520", new Object[]{this})).intValue() : R$layout.ticklet_venue_site_list;
    }

    public int getServiceType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "829067665") ? ((Integer) ipChange.ipc$dispatch("829067665", new Object[]{this})).intValue() : this.type;
    }

    public ArrayList<ExchangeSiteInfo> getTypeDataList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683255989")) {
            return (ArrayList) ipChange.ipc$dispatch("1683255989", new Object[]{this});
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        if (tickletVenueMapBean != null) {
            return tickletVenueMapBean.exchangeSiteInfos;
        }
        return null;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484949360")) {
            ipChange.ipc$dispatch("-484949360", new Object[]{this, Integer.valueOf(i)});
        } else {
            reloadData();
        }
    }

    public void initAdapter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618451692")) {
            ipChange.ipc$dispatch("-1618451692", new Object[]{this});
            return;
        }
        TickletVenueExchangeSiteListAdapter tickletVenueExchangeSiteListAdapter = new TickletVenueExchangeSiteListAdapter(getContext(), this.data.exchangeSiteInfos);
        this.mAdapter = tickletVenueExchangeSiteListAdapter;
        tickletVenueExchangeSiteListAdapter.f(this.callBack);
        WrapLinearLayoutManager wrapLinearLayoutManager = new WrapLinearLayoutManager(getContext());
        this.mLinearLayoutManager = wrapLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(wrapLinearLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777667173")) {
            ipChange.ipc$dispatch("-777667173", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "290518050")) {
            ipChange.ipc$dispatch("290518050", new Object[]{this});
            return;
        }
        this.mRecyclerView = (RecyclerView) this.rootView.findViewById(R$id.ticklet_venue_window_listview);
        this.llView = (LinearLayout) this.rootView.findViewById(R$id.ticklet_venue_exchange_view);
        this.errorPageView = (LinearLayout) this.rootView.findViewById(R$id.errorPageView);
        this.ticklet_venue_progress = (ProgressBar) this.rootView.findViewById(R$id.ticklet_venue_progress);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.data = (TickletVenueMapBean) arguments.getSerializable("data");
            this.type = arguments.getInt("type");
            this.chosenLat = arguments.getString("chosenLat");
            this.chosenLng = arguments.getString("chosenLng");
            this.isExchangeSite = arguments.getBoolean("isExchangeSite");
            this.performId = arguments.getString(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = arguments.getString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
        }
        if (this.data == null) {
            return;
        }
        initAdapter();
        if (this.isExchangeSite) {
            loadExchangesiteList();
        } else {
            searchMapData(this.type);
        }
    }

    public void isLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555769901")) {
            ipChange.ipc$dispatch("-1555769901", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.ticklet_venue_progress.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            this.errorPageView.setVisibility(8);
        }
    }

    public void loadDataFinishRefreshUI(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2143660346")) {
            ipChange.ipc$dispatch("2143660346", new Object[]{this, Integer.valueOf(i), str, str2, str3});
        } else if (1 == i) {
            this.mRecyclerView.setVisibility(0);
            this.errorPageView.setVisibility(8);
            this.ticklet_venue_progress.setVisibility(8);
        } else if (2 == i) {
            this.mRecyclerView.setVisibility(8);
            this.ticklet_venue_progress.setVisibility(8);
            this.errorPageView.setVisibility(0);
            showErrorPage(str, true, str2, str3);
            if (this.context != null) {
                ToastUtil.f(str);
            }
        } else if (3 == i) {
            this.mRecyclerView.setVisibility(8);
            this.ticklet_venue_progress.setVisibility(8);
            this.errorPageView.setVisibility(0);
            showErrorPage(str, false, str2, str3);
            if (this.context != null) {
                ToastUtil.f(str);
            }
        }
    }

    public void notifyChanged(ArrayList<ExchangeSiteInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775655006")) {
            ipChange.ipc$dispatch("-775655006", new Object[]{this, arrayList});
            return;
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        ArrayList<ExchangeSiteInfo> arrayList2 = tickletVenueMapBean.exchangeSiteInfos;
        if (arrayList2 == null) {
            tickletVenueMapBean.exchangeSiteInfos = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        loadDataFinishRefreshUI(1, "", null, null);
        this.data.exchangeSiteInfos.addAll(arrayList);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841488776")) {
            ipChange.ipc$dispatch("841488776", new Object[]{this, view});
        }
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1048605877")) {
            ipChange.ipc$dispatch("1048605877", new Object[]{this, view});
        }
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiItemSearched(PoiItem poiItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307913321")) {
            ipChange.ipc$dispatch("307913321", new Object[]{this, poiItem, Integer.valueOf(i)});
        }
    }

    @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
    public void onPoiSearched(PoiResult poiResult, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2118295817")) {
            ipChange.ipc$dispatch("-2118295817", new Object[]{this, poiResult, Integer.valueOf(i)});
            return;
        }
        String str = null;
        if (i == 1000) {
            if (poiResult != null && poiResult.getQuery() != null) {
                if (poiResult.getQuery().equals(this.query)) {
                    ArrayList<PoiItem> pois = poiResult.getPois();
                    cb1.b("TickletVenueActivity", pois.toString());
                    if (pois.size() > 0) {
                        ArrayList<ExchangeSiteInfo> arrayList = new ArrayList<>();
                        for (int i2 = 0; i2 < pois.size(); i2++) {
                            ExchangeSiteInfo exchangeSiteInfo = new ExchangeSiteInfo();
                            exchangeSiteInfo.detailLocation = pois.get(i2).getSnippet();
                            exchangeSiteInfo.distanceDesc = "距场馆" + pois.get(i2).getDistance() + WXComponent.PROP_FS_MATCH_PARENT;
                            if (pois.get(i2).getLatLonPoint() != null) {
                                exchangeSiteInfo.lat = String.valueOf(pois.get(i2).getLatLonPoint().getLatitude());
                                exchangeSiteInfo.lng = String.valueOf(pois.get(i2).getLatLonPoint().getLongitude());
                            }
                            exchangeSiteInfo.siteName = pois.get(i2).getTitle();
                            arrayList.add(exchangeSiteInfo);
                        }
                        notifyChanged(arrayList);
                        TickletVenueSiteCallback tickletVenueSiteCallback = this.callBack;
                        if (tickletVenueSiteCallback != null) {
                            tickletVenueSiteCallback.onServiceDataSuccess(this.type, arrayList);
                        }
                    } else {
                        loadDataFinishRefreshUI(3, getResources().getString(R$string.ticklet_venue_data_empty, typeTitle(this.type)), null, "poiResult结果返回空");
                    }
                }
            } else {
                loadDataFinishRefreshUI(2, getResources().getString(R$string.ticklet_venue_error), null, "poiResult结果返回空");
            }
        } else {
            TickletVenueSiteCallback tickletVenueSiteCallback2 = this.callBack;
            if (tickletVenueSiteCallback2 != null) {
                tickletVenueSiteCallback2.onFail("", "");
            }
            loadDataFinishRefreshUI(2, getResources().getString(R$string.ticklet_venue_error), String.valueOf(i), "poiResult返回错误");
            String category = (poiResult == null || poiResult.getQuery() == null) ? null : poiResult.getQuery().getCategory();
            TickletVenueMapBean tickletVenueMapBean = this.data;
            if (tickletVenueMapBean != null && !wh2.j(tickletVenueMapBean.pageTitle)) {
                str = this.data.pageTitle;
            }
            poiSearchErrorXFlushMonitor(String.valueOf(i), str, category, this.chosenLat, this.chosenLng);
        }
        TickletVenueSiteCallback tickletVenueSiteCallback3 = this.callBack;
        if (tickletVenueSiteCallback3 != null) {
            tickletVenueSiteCallback3.showPopIconUtil();
        }
    }

    @Override // cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-26519145")) {
            ipChange.ipc$dispatch("-26519145", new Object[]{this});
        }
    }

    public void reloadData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2082089940")) {
            ipChange.ipc$dispatch("2082089940", new Object[]{this});
            return;
        }
        TickletVenueMapBean tickletVenueMapBean = this.data;
        ArrayList<ExchangeSiteInfo> arrayList = tickletVenueMapBean.exchangeSiteInfos;
        if (arrayList == null) {
            tickletVenueMapBean.exchangeSiteInfos = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (this.isExchangeSite) {
            loadExchangesiteList();
        } else {
            searchMapData(this.type);
        }
    }

    public void returnExchangeSiteList(ArrayList<ExchangeSiteInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1683036533")) {
            ipChange.ipc$dispatch("-1683036533", new Object[]{this, arrayList});
        } else if (arrayList != null && arrayList.size() > 0) {
            notifyChanged(arrayList);
            TickletVenueSiteCallback tickletVenueSiteCallback = this.callBack;
            if (tickletVenueSiteCallback != null) {
                tickletVenueSiteCallback.onServiceDataSuccess(this.type, arrayList);
            }
        } else {
            loadDataFinishRefreshUI(3, getResources().getString(R$string.ticklet_venue_exchange_empty), null, "mtop.damai.wireless.ticklet2.extension.exchangesite.list");
        }
    }

    public void scrollPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152526615")) {
            ipChange.ipc$dispatch("152526615", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            if (i < this.mAdapter.getItemCount()) {
                if (i >= 0) {
                    this.mAdapter.c(i);
                }
                this.mAdapter.notifyDataSetChanged();
                if (i >= 0) {
                    ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            xn2.e(xn2.TICKLET_VENUE_LIST_ERROR_CODE, xn2.TICKLET_VENUE_LIST_ERROR_MSG, e.getMessage());
        }
    }

    public void setCallBack(TickletVenueSiteCallback tickletVenueSiteCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585562354")) {
            ipChange.ipc$dispatch("-585562354", new Object[]{this, tickletVenueSiteCallback});
        } else {
            this.callBack = tickletVenueSiteCallback;
        }
    }
}
