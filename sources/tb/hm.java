package tb;

import androidx.annotation.NonNull;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class hm implements ComponentTypeMapper.IComponentTypeTransfer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DIVIDER_COMPONENT = 2;
    public static final int EMPTY_COMPONENT = 1;
    public static final int NO_EXIST = 0;
    public static final int NO_MORE_COMPONENT = 3;
    static Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("search_for_peformance", 1000);
        a.put("search_for_artist", 1001);
        a.put("search_for_brand_ip", 1002);
        a.put("search_for_venue", 1003);
        a.put("search_for_infomartion", 1004);
        a.put("search_for_recommend", 1005);
        a.put("search_for_script_store", 1008);
        a.put("search_for_script", 1009);
        a.put("search_for_script_item", 1010);
        a.put(OneArchConstants.SectionHeaderType.NORMAL, 101);
        a.put(OneArchConstants.SectionFooterType.NORMAL, 102);
    }

    @Override // com.alient.onearch.adapter.ComponentTypeMapper.IComponentTypeTransfer
    public int transfer(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1560632763")) {
            return ((Integer) ipChange.ipc$dispatch("1560632763", new Object[]{this, str})).intValue();
        }
        Integer num = a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
