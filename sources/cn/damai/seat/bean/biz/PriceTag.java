package cn.damai.seat.bean.biz;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PriceTag {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String POS_LEFT = "1";
    public static final String POS_RIGHT = "2";
    public String position;
    public String tag;
    public String tagDesc;

    @Nullable
    public static PriceTag get(List<PriceTag> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981182135")) {
            return (PriceTag) ipChange.ipc$dispatch("-1981182135", new Object[]{list, str});
        }
        if (cb2.d(list) || TextUtils.isEmpty(str)) {
            return null;
        }
        for (PriceTag priceTag : list) {
            if (str.equals(priceTag.position)) {
                return priceTag;
            }
        }
        return null;
    }
}
