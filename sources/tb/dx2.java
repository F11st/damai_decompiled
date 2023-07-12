package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class dx2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PROJECT_DETAIL_VENUE_ERROR_CODE = "-3103";
    public static final String PROJECT_DETAIL_VENUE_ERROR_MSG = "场馆信息加载异常";
    public static final String PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_CODE = "-3102";
    public static final String PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_MSG = "项目详情-场馆POI检索结果与传入经纬度距离超过2公里";
    public static final String PROJECT_VENUE_POI_SEARCH_ERROR_CODE = "-3101";
    public static final String PROJECT_VENUE_POI_SEARCH_ERROR_MSG = "项目详情-场馆POI检索异常";

    public static void a(long j, String str, String str2, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247140216")) {
            ipChange.ipc$dispatch("247140216", new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pl.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        sb.append(TextUtils.isEmpty("mtop.damai.wireless.venue.info") ? "" : "mtop.damai.wireless.venue.info");
        sb.append(", retCode:");
        sb.append(str);
        sb.append(", retMsg:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", projectId:");
        sb.append(j2);
        sb.append(", venueId:");
        sb.append(j);
        sb.append("}");
        b23.a(sb.toString(), PROJECT_DETAIL_VENUE_ERROR_CODE, PROJECT_DETAIL_VENUE_ERROR_MSG);
    }

    public static void b(String str, long j, String str2, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296437283")) {
            ipChange.ipc$dispatch("296437283", new Object[]{str, Long.valueOf(j), str2, Long.valueOf(j2)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pl.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        sb.append(xn2.TICKLET_VENUE_POI_SEARCH_API_NAME);
        sb.append(", distance(m):");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", keyword:");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(", projectId:");
        sb.append(j2);
        sb.append(", venueId:");
        sb.append(j);
        sb.append("}");
        b23.a(sb.toString(), PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_CODE, PROJECT_VENUE_POI_SEARCH_DRIFT_ERROR_MSG);
    }

    public static void c(String str, long j, String str2, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208142754")) {
            ipChange.ipc$dispatch("1208142754", new Object[]{str, Long.valueOf(j), str2, Long.valueOf(j2)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pl.PROJECT_DETAIL_PAGE);
        sb.append(":jsondata={");
        sb.append("apiName: ");
        sb.append(xn2.TICKLET_VENUE_POI_SEARCH_API_NAME);
        sb.append(", retCode:");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(", keyword:");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(", projectId:");
        sb.append(j2);
        sb.append(", venueId:");
        sb.append(j);
        sb.append("}");
        b23.a(sb.toString(), PROJECT_VENUE_POI_SEARCH_ERROR_CODE, PROJECT_VENUE_POI_SEARCH_ERROR_MSG);
    }
}
