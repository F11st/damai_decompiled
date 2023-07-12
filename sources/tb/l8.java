package tb;

import cn.damai.live.LiveActivity;
import com.alibaba.fastjson.JSON;
import com.alient.onearch.adapter.request.DRParam;
import com.alient.oneservice.appinfo.AppInfoProviderProxy;
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
/* loaded from: classes7.dex */
public final class l8 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final l8 INSTANCE = new l8();
    @NotNull
    public static final String KEY_ARTIST_ID = "artistId";
    @NotNull
    public static final String PATTERN_NAME = "artist_home";
    @NotNull
    public static final String PATTERN_VERSION = "1.0";

    private l8() {
    }

    @NotNull
    public final Request a(long j, @NotNull Map<String, Object> map, @NotNull Map<String, Object> map2, @Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676311341")) {
            return (Request) ipChange.ipc$dispatch("-676311341", new Object[]{this, Long.valueOf(j), map, map2, str, str2});
        }
        b41.i(map, "args");
        b41.i(map2, "requestParams");
        String comboChannel = AppInfoProviderProxy.getComboChannel();
        b41.h(comboChannel, "getComboChannel()");
        map.put("comboChannel", comboChannel);
        String ttid = AppInfoProviderProxy.getTTID();
        b41.h(ttid, "getTTID()");
        map.put(LiveActivity.OPTION_TTID, ttid);
        String cityId = AppInfoProviderProxy.getCityId();
        b41.h(cityId, "getCityId()");
        map.put("comboDamaiCityId", cityId);
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
        return new Request.Builder().setApiName("mtop.damai.mec.aristotle.get").setVersion(LiveFullInfo.VER).setNeedECode(false).setNeedSession(false).setTimeout(10000).setStrategy(j).setDataParams(new HashMap(map2)).build();
    }
}
