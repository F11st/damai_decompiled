package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.pictures.bricks.bean.HomeBallBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class xw0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static HomeBallBean a;

    public static HashMap<String, String> a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566972222")) {
            return (HashMap) ipChange.ipc$dispatch("-1566972222", new Object[0]);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            HomeBallBean homeBallBean = a;
            if (homeBallBean != null) {
                if (!TextUtils.isEmpty(homeBallBean.iconComboDispatchId)) {
                    hashMap.put("dispatch_id", a.iconComboDispatchId);
                    hashMap.put("tiplabeltype", "0");
                } else {
                    hashMap.put("tiplabeltype", "1");
                }
                HomeBallBean homeBallBean2 = a;
                String str = homeBallBean2.icon1;
                String str2 = homeBallBean2.icon2;
                if (str != null || str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    if (str != null) {
                        sb.append(",");
                        sb.append(str);
                    }
                    if (str2 != null) {
                        sb.append(",");
                        sb.append(str2);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(0);
                    }
                    hashMap.put("tiplabel", sb.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static boolean b(String str, HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1785290862")) {
            return ((Boolean) ipChange.ipc$dispatch("1785290862", new Object[]{str, homeBallBean})).booleanValue();
        }
        if (homeBallBean == null || TextUtils.isEmpty(homeBallBean.referItemId)) {
            return false;
        }
        return TextUtils.equals(homeBallBean.referItemId, str);
    }

    @Nullable
    public static HomeBallBean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-131126490") ? (HomeBallBean) ipChange.ipc$dispatch("-131126490", new Object[0]) : a;
    }

    public static void d(HomeBallBean homeBallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1916411166")) {
            ipChange.ipc$dispatch("-1916411166", new Object[]{homeBallBean});
        } else {
            a = homeBallBean;
        }
    }
}
