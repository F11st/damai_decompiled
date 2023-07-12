package cn.damai.search.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.bean.youku.SearchResultBeanV2;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXComponent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.mu0;
import tb.vr;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ACCOUNT_MORE_ATTENTION = "account_more_attention";
    public static final String ACCOUNT_MORE_SEARCH_ATTENTION = "search_group_attention";
    public static final int ACCOUNT_VALUE = 7;
    public static final String ATTENTION_SEARCH_ACCOUNT = "search_account_attention";
    public static final String B_ACCOUNT_ARTIST = "2";
    public static final String B_ACCOUNT_BRAND = "4";
    public static final String B_ACCOUNT_REPERTORY = "5";
    public static final String B_ACCOUNT_VENUE = "3";
    public static final String JUMP_ACCOUNT_MAIN_PAGE = "jump_account_main_page";
    public static final int NO_FIND_ADVERT = 5;
    public static final int PROJECT_VALUE = 0;
    public static final int RECOMMEND_TITLE_VALUE = 1;
    public static final int REQUEST_SEARCH_EGG = 2;
    public static final int REQUEST_SEARCH_FIND_WORD = 0;
    public static final int REQUEST_SEARCH_LIST = 1;
    public static final int REQUEST_SEARCH_SUGGEST = 3;
    public static final int SEARCH_BRAND_LIST = 12;
    public static final int SEARCH_EGG_RECOMMEND = 11;
    public static final int SEARCH_FEED_SINGLE_CONTENT = 18;
    public static final int SEARCH_FEED_SINGLE_PROJECT = 19;
    public static final int SEARCH_FIND_VALUE = 2;
    public static final int SEARCH_HEAD_MULTI_TYPE = 20;
    public static final int SEARCH_HISTORY_VALUE = 3;
    public static final int SEARCH_JU_MU_LIST = 14;
    public static final int SEARCH_PASTPROJECT_PRIVILEGE_LIST = 17;
    public static final int SEARCH_PROJECT_PRIVILEGE_LIST = 13;
    public static final int SEARCH_PROJECT_PRIVILEGE_THEME_EVALUATE = 21;
    public static final int SEARCH_RESULT_END = 6;
    public static final int SEARCH_SUGGEST_PROJECT_VALUE = 9;
    public static final int SEARCH_SUGGEST_VALUE = 8;
    public static final int SEARCH_TEXT_SIZE_UNIT_DP_HINT = 12;
    public static final int SEARCH_TEXT_SIZE_UNIT_DP_NORMAL = 14;
    public static final int SEARCH_TOUR_VALUE = 10;
    public static final int SEARCH_WATER_FLOW_CONTENT = 16;
    public static final int SEARCH_WATER_FLOW_RECOMMEND = 15;
    public static final int TIP_DATA_VALUE = 4;
    public static final String TOUR_JUMP_PROJECT_PAGE = "tour_city_jump_project";
    public static int a;
    private static StringBuilder b = new StringBuilder();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum InputState {
        INIT,
        USER_INPUT_WORD,
        USER_CLICK_SEARCH_ENTER,
        USER_INPUT_WORD_ENTER,
        USER_CLICK_HOT_WORD,
        USER_CLICK_HISTORY_WORD,
        AUTO_INPUT_WORD,
        USER_CLICK_SUGGEST_WORD,
        USER_CLICK_SEARCH_ENTER_BRAND_TYPE
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum PageState {
        HOT_SEARCH_PAGE,
        SEARCH_SUGGEST_PAGE,
        SEARCH_RESULT_PAGE
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements Comparator<ArtificialProxy> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ArtificialProxy artificialProxy, ArtificialProxy artificialProxy2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-247659605") ? ((Integer) ipChange.ipc$dispatch("-247659605", new Object[]{this, artificialProxy, artificialProxy2})).intValue() : artificialProxy.index() - artificialProxy2.index();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "186201785")) {
                ipChange.ipc$dispatch("186201785", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        c(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1868396942")) {
                ipChange.ipc$dispatch("1868396942", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
            } else {
                this.a.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InputState.values().length];
            a = iArr;
            try {
                iArr[InputState.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InputState.USER_INPUT_WORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[InputState.USER_INPUT_WORD_ENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[InputState.USER_CLICK_SEARCH_ENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[InputState.USER_CLICK_HOT_WORD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[InputState.USER_CLICK_HISTORY_WORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[InputState.AUTO_INPUT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[InputState.USER_CLICK_SUGGEST_WORD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[InputState.USER_CLICK_SEARCH_ENTER_BRAND_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static String a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501245895")) {
            return (String) ipChange.ipc$dispatch("-1501245895", new Object[]{context});
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("history", 0).edit();
        edit.putString("keyhistory", "");
        edit.commit();
        return "";
    }

    private static void b(List<SearchDataHolder> list, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581580284")) {
            ipChange.ipc$dispatch("-1581580284", new Object[]{list, str, str2});
        } else if (!cb2.d(list)) {
            for (SearchDataHolder searchDataHolder : list) {
                searchDataHolder.keyword = str;
                searchDataHolder.aaid = str2;
            }
        }
    }

    public static void c(List<SearchDataHolder> list, boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821335890")) {
            ipChange.ipc$dispatch("-821335890", new Object[]{list, Boolean.valueOf(z), str});
        } else if (list == null) {
        } else {
            SearchDataHolder searchDataHolder = null;
            if (!cb2.d(list)) {
                Iterator<SearchDataHolder> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SearchDataHolder next = it.next();
                    if (next.mType == 4) {
                        if (z) {
                            next.mTipType = 6;
                            next.isProjectEnded = true;
                        } else {
                            next.mTipType = 2;
                        }
                        searchDataHolder = next;
                    }
                }
            }
            if (z || searchDataHolder != null) {
                return;
            }
            SearchDataHolder searchDataHolder2 = new SearchDataHolder(4);
            searchDataHolder2.isVisableLine = true;
            searchDataHolder2.mArtistName = str;
            searchDataHolder2.mTipType = 2;
            list.add(searchDataHolder2);
        }
    }

    public static String d(BaccountInfo baccountInfo) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1761725429")) {
            return (String) ipChange.ipc$dispatch("-1761725429", new Object[]{baccountInfo});
        }
        if (baccountInfo == null) {
            return "";
        }
        StringBuilder sb = b;
        sb.delete(0, sb.length());
        String g = g(baccountInfo.fansCount);
        if (TextUtils.isEmpty(g)) {
            z = false;
        } else {
            b.append(g);
        }
        if (TextUtils.isEmpty(baccountInfo.performanceCount) || baccountInfo.performanceCount.equals("0")) {
            baccountInfo.performanceCount = "0";
        }
        if (z) {
            b.append(" | ");
        }
        StringBuilder sb2 = b;
        sb2.append(baccountInfo.performanceCount + "场在售演出");
        return b.length() > 0 ? b.toString() : "";
    }

    public static String e(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-314964207") ? (String) ipChange.ipc$dispatch("-314964207", new Object[]{context}) : context.getSharedPreferences("history", 0).getString("keyhistory", "");
    }

    public static String f(String str) {
        double d2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "220634623")) {
            return (String) ipChange.ipc$dispatch("220634623", new Object[]{str});
        }
        try {
            d2 = Double.parseDouble(str);
        } catch (Exception unused) {
            d2 = 0.0d;
        }
        double d3 = d2 >= 0.0d ? d2 : 0.0d;
        if (d3 < 1000.0d) {
            return "距离" + str + WXComponent.PROP_FS_MATCH_PARENT;
        } else if (d3 < 100000.0d) {
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            return "距离" + decimalFormat.format(d3 / 1000.0d) + "km";
        } else {
            DecimalFormat decimalFormat2 = new DecimalFormat("0");
            return "距离" + decimalFormat2.format(d3 / 1000.0d) + "km";
        }
    }

    public static String g(String str) {
        double d2;
        double d3;
        DecimalFormat decimalFormat;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984039865")) {
            return (String) ipChange.ipc$dispatch("-984039865", new Object[]{str});
        }
        try {
            d2 = Double.parseDouble(str);
        } catch (Exception unused) {
            d2 = 0.0d;
        }
        if ((d2 >= 0.0d ? d2 : 0.0d) < 10000.0d) {
            return str + " 粉丝";
        }
        new DecimalFormat("0.0").setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(d3 / 10000.0d) + "万粉丝";
    }

    @Nullable
    public static List<SearchDataHolder> h(SearchResultBeanV2 searchResultBeanV2, String str, String str2, InputState inputState) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614498394")) {
            return (List) ipChange.ipc$dispatch("-614498394", new Object[]{searchResultBeanV2, str, str2, inputState});
        }
        if (searchResultBeanV2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<BrandOptimizationDO> list = searchResultBeanV2.brandOptimization;
        List<NoteBean> list2 = searchResultBeanV2.contentNoteList;
        List<ProjectItemBean> list3 = searchResultBeanV2.recommendProjectList;
        ArrayList<BaccountInfo> arrayList2 = searchResultBeanV2.baccountInfo;
        SearchTourBean searchTourBean = searchResultBeanV2.tour;
        int e = wh2.e(list3);
        boolean z2 = wh2.e(list2) > 0;
        boolean z3 = e > 0;
        if (searchResultBeanV2.isShowCombineHeadItemView()) {
            SearchDataHolder searchDataHolder = new SearchDataHolder(20);
            if (cb2.d(arrayList2)) {
                z = false;
            } else {
                BaccountInfo baccountInfo = arrayList2.get(0);
                baccountInfo.index = 0;
                baccountInfo.moreMessage = searchResultBeanV2.baccountMoreMessage;
                searchDataHolder.mAccountInfo = baccountInfo;
                searchDataHolder.isYouKuResponse = true;
                z = true;
            }
            if (searchTourBean != null) {
                searchDataHolder.tour = searchTourBean;
            }
            if (wh2.e(list) >= 3) {
                searchDataHolder.mBrandOptimizations = list;
            }
            List<? extends ArtificialProxy> list4 = searchResultBeanV2.artificialThemeList;
            List<? extends ArtificialProxy> list5 = searchResultBeanV2.artificialImageTextList;
            ArrayList arrayList3 = new ArrayList();
            if (!cb2.d(list4)) {
                arrayList3.addAll(list4);
            }
            if (!cb2.d(list5)) {
                arrayList3.addAll(list5);
            }
            if (!cb2.d(arrayList3)) {
                Collections.sort(arrayList3, new a());
                searchDataHolder.artificialList = arrayList3;
            }
            arrayList.add(searchDataHolder);
        } else {
            z = false;
        }
        int o = o(searchTourBean);
        List<ProjectItemBean> list6 = searchResultBeanV2.projectInfo;
        int e2 = wh2.e(list6);
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < e2; i++) {
            SearchDataHolder searchDataHolder2 = new SearchDataHolder(0);
            searchDataHolder2.mProjectItem = list6.get(i);
            searchDataHolder2.isRecommendProject = false;
            if (i < 6) {
                arrayList.add(searchDataHolder2);
            } else {
                arrayList4.add(searchDataHolder2);
            }
        }
        if (!z2) {
            arrayList.addAll(arrayList4);
            arrayList4 = null;
        }
        boolean z4 = searchResultBeanV2.isEnd;
        boolean z5 = o + e2 > 0;
        SearchDataHolder searchDataHolder3 = new SearchDataHolder(4);
        searchDataHolder3.isVisableLine = false;
        searchDataHolder3.mArtistName = str2;
        if (z4) {
            if (z5) {
                if (!z2 && !z3) {
                    searchDataHolder3.mTipType = 2;
                } else if (cb2.d(arrayList4)) {
                    searchDataHolder3.mTipType = 2;
                } else {
                    searchDataHolder3.mTipType = 6;
                    searchDataHolder3.foldProjectList = arrayList4;
                    searchDataHolder3.isProjectEnded = true;
                }
            } else if (z) {
                searchDataHolder3.mTipType = 1;
            } else if (e == 0) {
                searchDataHolder3.mTipType = 4;
            } else {
                searchDataHolder3.mTipType = 3;
            }
            arrayList.add(searchDataHolder3);
        } else if (z2) {
            searchDataHolder3.mTipType = 6;
            searchDataHolder3.foldProjectList = arrayList4;
            searchDataHolder3.isProjectEnded = false;
            arrayList.add(searchDataHolder3);
        }
        if (!cb2.d(list2)) {
            List<SearchDataHolder> k = k(list2);
            if (!cb2.d(k)) {
                SearchDataHolder searchDataHolder4 = new SearchDataHolder(1);
                searchDataHolder4.isNoteFeed = true;
                arrayList.add(searchDataHolder4);
                arrayList.addAll(k);
            }
        } else if (z4 && !cb2.d(list3)) {
            SearchDataHolder searchDataHolder5 = new SearchDataHolder(1);
            searchDataHolder5.isNoteFeed = false;
            arrayList.add(searchDataHolder5);
            for (ProjectItemBean projectItemBean : list3) {
                if (projectItemBean != null) {
                    SearchDataHolder searchDataHolder6 = new SearchDataHolder(19);
                    searchDataHolder6.mProjectItem = projectItemBean;
                    searchDataHolder6.inputType = i(inputState);
                    arrayList.add(searchDataHolder6);
                }
            }
        }
        b(arrayList, str2, str);
        return arrayList;
    }

    public static int i(InputState inputState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353462371")) {
            return ((Integer) ipChange.ipc$dispatch("-353462371", new Object[]{inputState})).intValue();
        }
        switch (d.a[inputState.ordinal()]) {
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 4;
            case 8:
                return 5;
            case 9:
                return 6;
            default:
                return 0;
        }
    }

    public static int j(SearchResultBeanV2 searchResultBeanV2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857970743")) {
            return ((Integer) ipChange.ipc$dispatch("-857970743", new Object[]{searchResultBeanV2})).intValue();
        }
        if (searchResultBeanV2 == null) {
            return 0;
        }
        return wh2.e(searchResultBeanV2.contentNoteList);
    }

    @Nullable
    public static List<SearchDataHolder> k(List<NoteBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417729936")) {
            return (List) ipChange.ipc$dispatch("-1417729936", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NoteBean noteBean : list) {
            if (noteBean != null) {
                SearchDataHolder searchDataHolder = new SearchDataHolder(18);
                searchDataHolder.mNoteBean = noteBean;
                arrayList.add(searchDataHolder);
            }
        }
        return arrayList;
    }

    public static int l(boolean z, SearchResultBeanV2 searchResultBeanV2) {
        SearchTourBean searchTourBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112982092")) {
            return ((Integer) ipChange.ipc$dispatch("112982092", new Object[]{Boolean.valueOf(z), searchResultBeanV2})).intValue();
        }
        if (searchResultBeanV2 == null) {
            return 0;
        }
        int e = wh2.e(searchResultBeanV2.projectInfo);
        return (!z || (searchTourBean = searchResultBeanV2.tour) == null) ? e : e + wh2.e(searchTourBean.items);
    }

    @Nullable
    public static List<SearchDataHolder> m(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997872613")) {
            return (List) ipChange.ipc$dispatch("997872613", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ProjectItemBean projectItemBean : list) {
            if (projectItemBean != null) {
                SearchDataHolder searchDataHolder = new SearchDataHolder(0);
                searchDataHolder.mProjectItem = projectItemBean;
                searchDataHolder.isRecommendProject = false;
                arrayList.add(searchDataHolder);
            }
        }
        return arrayList;
    }

    public static String n(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-556671952") ? (String) ipChange.ipc$dispatch("-556671952", new Object[]{str}) : str == null ? "" : str.equals("2") ? ErrControlViewInfo.TYPE_ARTIST : str.equals("5") ? "剧目" : str.equals("4") ? ErrControlViewInfo.TYPE_BRAND_IP : str.equals("3") ? ErrControlViewInfo.TYPE_VENUE : "";
    }

    public static int o(SearchTourBean searchTourBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402119793")) {
            return ((Integer) ipChange.ipc$dispatch("-1402119793", new Object[]{searchTourBean})).intValue();
        }
        if (searchTourBean == null) {
            return 0;
        }
        return wh2.e(searchTourBean.items);
    }

    public static void p(List<SearchDataHolder> list, List<SearchDataHolder> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517367321")) {
            ipChange.ipc$dispatch("-517367321", new Object[]{list, list2});
        } else if (list != null) {
            try {
                if (cb2.d(list2)) {
                    return;
                }
                int i = -1;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2).mType == 0) {
                        i = i2;
                    }
                }
                list.addAll(i + 1, list2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    public static Pair<Integer, Integer> q(List<SearchDataHolder> list, List<SearchDataHolder> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922299529")) {
            return (Pair) ipChange.ipc$dispatch("-1922299529", new Object[]{list, list2});
        }
        try {
            if (!cb2.d(list2) && list != null) {
                int i = -1;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2).mType == 18) {
                        i = i2;
                    }
                }
                int i3 = i + 1;
                list.addAll(i3, list2);
                return new Pair<>(Integer.valueOf(i3), Integer.valueOf(list2.size()));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean r(List<SearchDataHolder> list, List<SearchDataHolder> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253212534")) {
            return ((Boolean) ipChange.ipc$dispatch("-1253212534", new Object[]{list, list2})).booleanValue();
        }
        if (list != null) {
            try {
                if (!cb2.d(list2)) {
                    int i = -1;
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (list.get(i2).mType == 0) {
                            i = i2;
                        }
                    }
                    list.addAll(i + 1, list2);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void s(ImageView imageView, String str, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069083657")) {
            ipChange.ipc$dispatch("2069083657", new Object[]{imageView, str, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        Object tag = imageView.getTag();
        if (tag instanceof vr) {
            ((vr) tag).cancel();
        }
        imageView.setTag(null);
        imageView.setImageDrawable(mu0.a().getResources().getDrawable(R$drawable.uikit_default_image_bg_gradient));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setTag(cn.damai.common.image.a.b().f(str, i, i2).n(new c(imageView)).e(new b()).f());
    }

    public static void t(Context context, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "651938114")) {
            ipChange.ipc$dispatch("651938114", new Object[]{context, list});
        } else if (list != null) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (String str : list) {
                if (z) {
                    sb.append(",");
                } else {
                    z = true;
                }
                sb.append(str);
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("history", 0).edit();
            edit.putString("keyhistory", sb.toString());
            edit.commit();
        }
    }
}
