package tb;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class t03 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BUSINESS_NAME_MONITORPOINT = "tetriscore";
    public static final String TETRIS_CORE_ERROR_DATA_LESSTHAN_2_CODE = "-505";
    public static final String TETRIS_CORE_ERROR_DATA_LESSTHAN_2_MSG = "组件格式小于等于1";
    public static final String TETRIS_CORE_ERROR_MTOP_CODE = "-502";
    public static final String TETRIS_CORE_ERROR_MTOP_MSG = "接口请求错误";
    public static final String TETRIS_CORE_ERROR_NODATA_CODE = "-503";
    public static final String TETRIS_CORE_ERROR_NODATA_MSG = "接口数据为空";
    public static final String TETRIS_CORE_ERROR_NOPATTREN_CODE = "-501";
    public static final String TETRIS_CORE_ERROR_NOPATTREN_MSG = "页面模板不存在";
    public static final String TETRIS_CORE_ERROR_NOSECTION_CODE = "-504";
    public static final String TETRIS_CORE_ERROR_NOSECTION_MSG = "组件为空";
    public static final String TETRIS_HOME_CATEGORY_CMS_FAIL_CODE = "-510";
    public static final String TETRIS_HOME_CATEGORY_CMS_FAIL_MSG = "首页分类CMS接口异常";

    public static void a(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2015785958")) {
            ipChange.ipc$dispatch("2015785958", new Object[]{str, str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("patternName", str);
        hashMap.put("patternVersion", str2);
        hashMap.put("usedCdnUrl", str3);
        hashMap.put("cityId", z20.c());
        b23.a("Tetris:jsondata=" + m61.e(hashMap), TETRIS_HOME_CATEGORY_CMS_FAIL_CODE, TETRIS_HOME_CATEGORY_CMS_FAIL_MSG);
    }

    public static String b(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791844932")) {
            return (String) ipChange.ipc$dispatch("-791844932", new Object[]{str, str2, str3, str4, str5});
        }
        return str + ":jsondata={apiName:" + str2 + ",appVersion:" + AppConfig.q() + ",retCode:" + str3 + ",retMsg:" + str4 + ",args:" + str5 + "}";
    }

    public static void c(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102932917")) {
            ipChange.ipc$dispatch("1102932917", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.a(b("Tetris", "mtop.damai.mec.aristotle.get", str3, str4, str5), str, str2);
        }
    }

    public static void d(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-336648234")) {
            ipChange.ipc$dispatch("-336648234", new Object[]{str, str2, str3, str4, str5});
        } else {
            b23.g(b("Tetris", "mtop.damai.mec.aristotle.get", str3, str4, str5), str, str2);
        }
    }
}
