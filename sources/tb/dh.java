package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class dh {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRANCH_NAME = "category";
    public static final String BRAND_LIST_ERROR_CODE = "-1103";
    public static final String BRAND_LIST_ERROR_MSG = "品牌列表加载失败";
    public static final String CATEGORY_LIST_ERROR_CODE = "-1100";
    public static final String CATEGORY_LIST_ERROR_MSG = "演出列表加载失败";
    public static final String STAR_LIST_ERROR_CODE = "-1102";
    public static final String STAR_LIST_ERROR_MSG = "大咖列表加载失败";

    public static void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1843232681")) {
            ipChange.ipc$dispatch("-1843232681", new Object[]{str});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("category");
        sb.append(":jsondata={apiName:");
        sb.append("mtop.damai.wireless.search.brand.search");
        sb.append(",request:" + str);
        sb.append("}");
        b23.a(sb.toString(), BRAND_LIST_ERROR_CODE, BRAND_LIST_ERROR_MSG);
    }

    public static void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644931794")) {
            ipChange.ipc$dispatch("1644931794", new Object[]{str});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("category");
        sb.append(":jsondata={apiName:");
        sb.append("mtop.damai.wireless.search.project.classify");
        sb.append(",request:" + str);
        sb.append("}");
        b23.a(sb.toString(), "-1100", "演出列表加载失败");
    }

    public static void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978060926")) {
            ipChange.ipc$dispatch("978060926", new Object[]{str});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("category");
        sb.append(":jsondata={apiName:");
        sb.append("mtop.damai.wireless.search.artist.search");
        sb.append(",request:" + str);
        sb.append("}");
        b23.a(sb.toString(), STAR_LIST_ERROR_CODE, STAR_LIST_ERROR_MSG);
    }
}
