package mtopsdk.framework.filter.before;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.mtop.protocol.converter.INetworkConverter;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.domain.Request;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkConvertBeforeFilter implements IBeforeFilter {
    private static final String TAG = "mtopsdk.NetworkConvertBeforeFilter";
    private INetworkConverter networkConverter;

    public NetworkConvertBeforeFilter(@NonNull INetworkConverter iNetworkConverter) {
        this.networkConverter = iNetworkConverter;
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        Request convert = this.networkConverter.convert(mtopContext);
        MtopStatistics mtopStatistics = mtopContext.stats;
        convert.fullTraceId = mtopStatistics.fullTraceId;
        String launchInfoValue = mtopStatistics.launchInfoValue();
        if (!TextUtils.isEmpty(launchInfoValue)) {
            convert.headers.put(HttpHeaderConstant.LAUNCH_INFO_KEY, launchInfoValue);
        }
        mtopContext.networkRequest = convert;
        mtopContext.stats.url = convert.url;
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
