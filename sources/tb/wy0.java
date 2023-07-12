package tb;

import cn.damai.common.AppConfig;
import cn.damai.live.LiveActivity;
import com.alibaba.fastjson.JSON;
import com.alient.onearch.adapter.request.DRParam;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Request;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class wy0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final wy0 INSTANCE = new wy0();
    @NotNull
    public static final String patternName = "app_home";
    @NotNull
    public static final String patternVersion = "3.2";

    private wy0() {
    }

    @NotNull
    public final Request a(long j, @NotNull Map<String, Object> map, @NotNull Map<String, Object> map2, @Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309907054")) {
            return (Request) ipChange.ipc$dispatch("-1309907054", new Object[]{this, Long.valueOf(j), map, map2, str, str2});
        }
        b41.i(map, "args");
        b41.i(map2, "requestParams");
        map2.put("patternName", patternName);
        map2.put("patternVersion", patternVersion);
        map.put("comboChannel", "1");
        String p = AppConfig.p();
        b41.h(p, "getTtid()");
        map.put(LiveActivity.OPTION_TTID, p);
        String c = z20.c();
        b41.h(c, "getCityId()");
        map.put("comboDamaiCityId", c);
        map.put(Constants.Name.PAGE_SIZE, 15);
        AMapLocation lastKnownLocation = ia1.INSTANCE.c().getLastKnownLocation();
        if (lastKnownLocation != null) {
            map.put("longitude", Double.valueOf(lastKnownLocation.getLongitude()));
            map.put("latitude", Double.valueOf(lastKnownLocation.getLatitude()));
        }
        if (str != null && str2 != null) {
            DRParam dRParam = new DRParam(str, str2);
            map2.put("dr", jn1.ARRAY_START + JSON.toJSONString(dRParam) + jn1.ARRAY_END);
        }
        String jSONString = JSON.toJSONString(map);
        b41.h(jSONString, "toJSONString(args)");
        map2.put("args", jSONString);
        return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion(LiveFullInfo.VER).setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(j).setDataParams(new HashMap(map2)).setRequestId(10000L).build();
    }
}
