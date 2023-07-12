package cn.damai.search.presenter;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.artist.ArtistFollowResultBean;
import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.message.observer.Action;
import cn.damai.search.bean.PageIndexParams;
import cn.damai.search.bean.SearchEggs;
import cn.damai.search.bean.SearchFindWordList;
import cn.damai.search.bean.SearchTourUT;
import cn.damai.search.bean.SearchWord;
import cn.damai.search.bean.youku.SearchNoteBean;
import cn.damai.search.bean.youku.SearchResultBeanV2;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.search.bean.youku.SearchThemeBean;
import cn.damai.search.bean.youku.SuggestRes;
import cn.damai.search.contract.SearchContract;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.model.SearchEggsRequest;
import cn.damai.search.model.SearchFindRequest;
import cn.damai.search.model.SearchListV2Request;
import cn.damai.search.model.SearchSugWordRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.cb2;
import tb.g82;
import tb.ja1;
import tb.mu0;
import tb.wh2;
import tb.x70;
import tb.y72;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchPresenter extends SearchContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int BRAND_SIZE = 3;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements Action<ArtistFollowResultBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(ArtistFollowResultBean artistFollowResultBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1654201956")) {
                ipChange.ipc$dispatch("1654201956", new Object[]{this, artistFollowResultBean});
            } else if (artistFollowResultBean != null) {
                ((SearchContract.View) SearchPresenter.this.mView).updateAccountFollowState(artistFollowResultBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements Action<ArtistFollowResultBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(ArtistFollowResultBean artistFollowResultBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-859265405")) {
                ipChange.ipc$dispatch("-859265405", new Object[]{this, artistFollowResultBean});
            } else if (artistFollowResultBean != null) {
                ((SearchContract.View) SearchPresenter.this.mView).updateAccountFollowState(artistFollowResultBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements Action<BaccountInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(BaccountInfo baccountInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "684186160")) {
                ipChange.ipc$dispatch("684186160", new Object[]{this, baccountInfo});
            } else {
                ((SearchContract.View) SearchPresenter.this.mView).requestAccountFollow(baccountInfo);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class d implements Action<BaccountInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(BaccountInfo baccountInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-482510159")) {
                ipChange.ipc$dispatch("-482510159", new Object[]{this, baccountInfo});
            } else if (baccountInfo != null) {
                ((SearchContract.View) SearchPresenter.this.mView).jumpAccountMainPage(baccountInfo);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class e implements Action<Integer> {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "586103898")) {
                ipChange.ipc$dispatch("586103898", new Object[]{this, num});
            } else if (num != null) {
                ((SearchContract.View) SearchPresenter.this.mView).pageRefresh(num.intValue());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class f implements Action<SearchTourUT> {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.message.observer.Action
        /* renamed from: a */
        public void call(SearchTourUT searchTourUT) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-692753679")) {
                ipChange.ipc$dispatch("-692753679", new Object[]{this, searchTourUT});
            } else {
                ((SearchContract.View) SearchPresenter.this.mView).tourCityJumpProject(searchTourUT);
            }
        }
    }

    private String getBAccountType(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1044881711")) {
            return (String) ipChange.ipc$dispatch("-1044881711", new Object[]{this, str});
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i != 10 ? i != 11 ? i != 13 ? "2" : "5" : "4" : "3";
    }

    private void hoistBrandAccountIfNeed(ArrayList<BaccountInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493327098")) {
            ipChange.ipc$dispatch("-1493327098", new Object[]{this, arrayList});
            return;
        }
        try {
            if (cb2.a(arrayList) > 1) {
                int size = arrayList.size();
                int i = -1;
                int i2 = -1;
                for (int i3 = 0; i3 < size; i3++) {
                    BaccountInfo baccountInfo = arrayList.get(i3);
                    if (i2 < 0 && TextUtils.equals("4", baccountInfo.type)) {
                        i2 = i3;
                    }
                    if (i < 0 && TextUtils.equals("3", baccountInfo.type)) {
                        i = i3;
                    }
                }
                if (i < 0 || i2 <= i) {
                    return;
                }
                arrayList.add(i, arrayList.remove(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String md5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508915668")) {
            return (String) ipChange.ipc$dispatch("1508915668", new Object[]{this, str});
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes());
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            if (bigInteger.length() < 32) {
                return 0 + bigInteger;
            }
            return bigInteger;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private BaccountInfo parse2BAccountBean(SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592762223")) {
            return (BaccountInfo) ipChange.ipc$dispatch("-1592762223", new Object[]{this, listBean});
        }
        BaccountInfo baccountInfo = new BaccountInfo();
        baccountInfo.fansCount = listBean.fansCount;
        baccountInfo.performanceCount = listBean.performanceCount;
        baccountInfo.type = getBAccountType(listBean.type);
        baccountInfo.headPic = listBean.headPic;
        baccountInfo.backgroundPic = listBean.backgroundPic;
        baccountInfo.damaiId = listBean.damaiId;
        baccountInfo.name = listBean.name;
        baccountInfo.moreInfo = listBean.moreInfo;
        baccountInfo.vaccount = listBean.vaccount;
        baccountInfo.subtype = listBean.subtype;
        return baccountInfo;
    }

    private void parseArtificialImageText(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998169634")) {
            ipChange.ipc$dispatch("998169634", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean == null || cb2.d(listBean.tabArray)) {
        } else {
            searchResultBeanV2.artificialImageTextList = SearchNoteBean.transfer(listBean.tabArray);
        }
    }

    private void parseArtificialInfo(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "547259416")) {
            ipChange.ipc$dispatch("547259416", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean == null || cb2.d(listBean.tabArray)) {
        } else {
            searchResultBeanV2.artificialThemeList = SearchThemeBean.transfer(listBean.tabArray);
        }
    }

    private void parseBAccount(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1467447189")) {
            ipChange.ipc$dispatch("1467447189", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean == null) {
        } else {
            if (searchResultBeanV2.baccountInfo == null) {
                searchResultBeanV2.baccountInfo = new ArrayList<>();
            }
            searchResultBeanV2.baccountInfo.clear();
            BaccountInfo baccountInfo = new BaccountInfo();
            baccountInfo.fansCount = listBean.fansCount;
            baccountInfo.performanceCount = listBean.performanceCount;
            baccountInfo.type = getBAccountType(listBean.type);
            baccountInfo.headPic = listBean.headPic;
            baccountInfo.backgroundPic = listBean.backgroundPic;
            baccountInfo.damaiId = listBean.damaiId;
            baccountInfo.name = listBean.name;
            baccountInfo.moreInfo = listBean.moreInfo;
            baccountInfo.vaccount = listBean.vaccount;
            baccountInfo.subtype = listBean.subtype;
            searchResultBeanV2.baccountInfo.add(baccountInfo);
        }
    }

    private void parseBrandOptimization(SearchResultBeanV2 searchResultBeanV2, List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530695519")) {
            ipChange.ipc$dispatch("530695519", new Object[]{this, searchResultBeanV2, list});
        } else if (wh2.e(list) >= 3) {
            if (searchResultBeanV2.brandOptimization == null) {
                searchResultBeanV2.brandOptimization = new ArrayList();
            }
            searchResultBeanV2.brandOptimization.clear();
            for (int i = 0; i < 3; i++) {
                SearchResultBeanYouKu.ListBean listBean = list.get(i);
                if (listBean != null) {
                    BrandOptimizationDO brandOptimizationDO = new BrandOptimizationDO();
                    brandOptimizationDO.type = listBean.type;
                    brandOptimizationDO.id = listBean.id;
                    brandOptimizationDO.cover = listBean.cover;
                    brandOptimizationDO.lable = listBean.label;
                    brandOptimizationDO.itemName = listBean.itemName;
                    brandOptimizationDO.tagUrl = listBean.tagUrl;
                    brandOptimizationDO.city = listBean.city;
                    searchResultBeanV2.brandOptimization.add(brandOptimizationDO);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        if (r0.equals(cn.damai.search.bean.youku.SearchResultBeanYouKu.FLAG_IMAGE_TEXT) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseByFlag(cn.damai.search.bean.youku.SearchResultBeanV2 r8, cn.damai.search.bean.youku.SearchResultBeanYouKu.ListBean r9) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.search.presenter.SearchPresenter.parseByFlag(cn.damai.search.bean.youku.SearchResultBeanV2, cn.damai.search.bean.youku.SearchResultBeanYouKu$ListBean):void");
    }

    private void parseNoteList(SearchResultBeanV2 searchResultBeanV2, List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970421813")) {
            ipChange.ipc$dispatch("-970421813", new Object[]{this, searchResultBeanV2, list});
        } else if (wh2.e(list) > 0) {
            ArrayList arrayList = new ArrayList();
            searchResultBeanV2.contentNoteList = arrayList;
            arrayList.clear();
            for (int i = 0; i < wh2.e(list); i++) {
                searchResultBeanV2.contentNoteList.add(g82.a(list.get(i), i));
            }
        }
    }

    private void parseOneProduct(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824994839")) {
            ipChange.ipc$dispatch("1824994839", new Object[]{this, searchResultBeanV2, listBean});
            return;
        }
        if (searchResultBeanV2.projectInfo == null) {
            searchResultBeanV2.projectInfo = new ArrayList();
        }
        searchResultBeanV2.projectInfo.add(g82.b(listBean));
    }

    private void parseServerInfo(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344124975")) {
            ipChange.ipc$dispatch("1344124975", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean != null) {
            long j = listBean.currentTime;
            if (j > 0) {
                searchResultBeanV2.currentTime = j * 1000;
            }
        }
    }

    private void parseSuggestProject(SearchResultBeanV2 searchResultBeanV2, List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "250769872")) {
            ipChange.ipc$dispatch("250769872", new Object[]{this, searchResultBeanV2, list});
        } else if (wh2.e(list) > 0) {
            searchResultBeanV2.recommendProjectList = new ArrayList();
            for (SearchResultBeanYouKu.ListBean listBean : list) {
                searchResultBeanV2.recommendProjectList.add(g82.b(listBean));
            }
        }
    }

    private void parseTour(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117340616")) {
            ipChange.ipc$dispatch("2117340616", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean.topItem == null || wh2.e(listBean.items) == 0) {
        } else {
            SearchTourBean searchTourBean = new SearchTourBean();
            searchResultBeanV2.tour = searchTourBean;
            searchTourBean.title = listBean.title;
            searchTourBean.items = listBean.items;
            searchTourBean.topItem = g82.b(listBean.topItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SearchResultBeanV2 transformResult(SearchResultBeanYouKu searchResultBeanYouKu, PageIndexParams.Params params) {
        SearchResultBeanYouKu.DataBean dataBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622094967")) {
            return (SearchResultBeanV2) ipChange.ipc$dispatch("-622094967", new Object[]{this, searchResultBeanYouKu, params});
        }
        SearchResultBeanV2 searchResultBeanV2 = new SearchResultBeanV2();
        if (searchResultBeanYouKu != null && (dataBean = searchResultBeanYouKu.data) != null && wh2.e(dataBean.resultList) != 0) {
            SearchResultBeanYouKu.DataBean dataBean2 = searchResultBeanYouKu.data;
            if (params.isHomeRequest()) {
                searchResultBeanV2.total = dataBean2.total;
                searchResultBeanV2.isEnd = dataBean2.isEnded;
                searchResultBeanV2.isImageTextEnd = SearchResultBeanYouKu.isResImageTextEnded(searchResultBeanYouKu);
            } else if (params.isProjectNextPageRequest()) {
                searchResultBeanV2.total = dataBean2.total;
                searchResultBeanV2.isEnd = dataBean2.isEnded;
            } else if (params.isNoteNextPageRequest()) {
                searchResultBeanV2.isImageTextEnd = SearchResultBeanYouKu.isResImageTextEnded(searchResultBeanYouKu);
            } else {
                searchResultBeanV2.total = 0;
                searchResultBeanV2.isEnd = true;
                searchResultBeanV2.isImageTextEnd = true;
            }
            for (SearchResultBeanYouKu.ListBean listBean : searchResultBeanYouKu.data.resultList) {
                if (listBean != null) {
                    if (!params.isNoteNextPageRequest()) {
                        parseByFlag(searchResultBeanV2, listBean);
                    } else if (TextUtils.equals(SearchResultBeanYouKu.FLAG_IMAGE_TEXT, listBean.flag)) {
                        parseNoteList(searchResultBeanV2, listBean.tabArray);
                    }
                }
            }
        } else {
            searchResultBeanV2.total = 0;
            searchResultBeanV2.isEnd = true;
            searchResultBeanV2.isImageTextEnd = true;
        }
        return searchResultBeanV2;
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchEggs(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273629186")) {
            ipChange.ipc$dispatch("-1273629186", new Object[]{this, str});
            return;
        }
        SearchEggsRequest searchEggsRequest = new SearchEggsRequest();
        searchEggsRequest.keyword = str;
        searchEggsRequest.request(new DMMtopRequestListener<SearchEggs>(SearchEggs.class) { // from class: cn.damai.search.presenter.SearchPresenter.9
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1528093686")) {
                    ipChange2.ipc$dispatch("1528093686", new Object[]{this, str2, str3});
                    return;
                }
                ((SearchContract.View) SearchPresenter.this.mView).stopLoading();
                ((SearchContract.View) SearchPresenter.this.mView).error(str2, str3, "mtop.damai.wireless.search.searchegg.get", str, 2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchEggs searchEggs) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-326106127")) {
                    ipChange2.ipc$dispatch("-326106127", new Object[]{this, searchEggs});
                } else {
                    ((SearchContract.View) SearchPresenter.this.mView).returnSearchEggs(searchEggs, str);
                }
            }
        });
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchFindList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306201813")) {
            ipChange.ipc$dispatch("-1306201813", new Object[]{this});
        } else {
            new SearchFindRequest().request(new DMMtopRequestListener<SearchFindWordList>(SearchFindWordList.class) { // from class: cn.damai.search.presenter.SearchPresenter.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1543612404")) {
                        ipChange2.ipc$dispatch("1543612404", new Object[]{this, str, str2});
                        return;
                    }
                    ((SearchContract.View) SearchPresenter.this.mView).stopLoading();
                    ((SearchContract.View) SearchPresenter.this.mView).error(str, str2, "mtop.damai.wireless.search.hotword.get", "", 0);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(SearchFindWordList searchFindWordList) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-243290244")) {
                        ipChange2.ipc$dispatch("-243290244", new Object[]{this, searchFindWordList});
                        return;
                    }
                    ((SearchContract.View) SearchPresenter.this.mView).stopLoading();
                    ((SearchContract.View) SearchPresenter.this.mView).returnSearchFindList(searchFindWordList);
                }
            });
        }
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchListV2(final String str, final PageIndexParams.Params params) {
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063722661")) {
            ipChange.ipc$dispatch("-2063722661", new Object[]{this, str, params});
            return;
        }
        SearchListV2Request searchListV2Request = new SearchListV2Request();
        searchListV2Request.keyword = str;
        int i = params.pageIndex;
        searchListV2Request.pg = i;
        String str4 = null;
        if (i == 1) {
            str4 = x70.c(mu0.a()).d();
            String md5 = md5(System.currentTimeMillis() + str4);
            if (md5 != null) {
                str4 = md5;
            }
        }
        searchListV2Request.categories = params.categories;
        searchListV2Request.aaid = str4;
        double[] b2 = ja1.b();
        if (b2 == null || b2.length <= 1) {
            str2 = "116.43672127748412";
            str3 = "39.93700227507351";
        } else {
            str2 = String.valueOf(b2[0]);
            str3 = String.valueOf(b2[1]);
        }
        searchListV2Request.longitude = str2;
        searchListV2Request.latitude = str3;
        searchListV2Request.request(new DMMtopRequestListener<SearchResultBeanYouKu>(SearchResultBeanYouKu.class) { // from class: cn.damai.search.presenter.SearchPresenter.10
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str5, String str6) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-902514110")) {
                    ipChange2.ipc$dispatch("-902514110", new Object[]{this, str5, str6});
                    return;
                }
                ((SearchContract.View) SearchPresenter.this.mView).stopLoading();
                if (params.isHomeRequest()) {
                    ((SearchContract.View) SearchPresenter.this.mView).error(str5, str6, y72.a, str, 1);
                } else {
                    ToastUtil.a().j(mu0.a(), str6);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchResultBeanYouKu searchResultBeanYouKu) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "184455023")) {
                    ipChange2.ipc$dispatch("184455023", new Object[]{this, searchResultBeanYouKu});
                    return;
                }
                ((SearchContract.View) SearchPresenter.this.mView).stopLoading();
                ((SearchContract.View) SearchPresenter.this.mView).returnSearchListV2(SearchPresenter.this.transformResult(searchResultBeanYouKu, params), str, params);
            }
        });
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchSuggest(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229509746")) {
            ipChange.ipc$dispatch("-229509746", new Object[]{this, str});
        } else {
            new SearchSugWordRequest(str).request(new DMMtopRequestListener<SuggestRes>(SuggestRes.class) { // from class: cn.damai.search.presenter.SearchPresenter.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1535853045")) {
                        ipChange2.ipc$dispatch("1535853045", new Object[]{this, str2, str3});
                        return;
                    }
                    ((SearchContract.View) SearchPresenter.this.mView).stopLoading();
                    ((SearchContract.View) SearchPresenter.this.mView).error(str2, str3, "mtop.damai.wireless.search.suggest", str, 3);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(SuggestRes suggestRes) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "392852548")) {
                        ipChange2.ipc$dispatch("392852548", new Object[]{this, suggestRes});
                        return;
                    }
                    ((SearchContract.View) SearchPresenter.this.mView).returnSearchSuggest(SearchWord.youKuSuggestToNative(suggestRes), str);
                    ((SearchContract.View) SearchPresenter.this.mView).stopLoading();
                }
            });
        }
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218643229")) {
            ipChange.ipc$dispatch("218643229", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b(SearchHelper.ACCOUNT_MORE_SEARCH_ATTENTION, new a());
        this.mDMMessage.b("artist_follow_status", new b());
        this.mDMMessage.b(SearchHelper.ATTENTION_SEARCH_ACCOUNT, new c());
        this.mDMMessage.b(SearchHelper.JUMP_ACCOUNT_MAIN_PAGE, new d());
        this.mDMMessage.b(y72.NOTIFY_RFRESH, new e());
        this.mDMMessage.b(SearchHelper.TOUR_JUMP_PROJECT_PAGE, new f());
    }
}
