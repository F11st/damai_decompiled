package mtopsdk.framework.domain;

import androidx.annotation.NonNull;
import java.util.Map;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ResponseSource;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.Response;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopContext {
    public ApiID apiId;
    public String baseUrl;
    public MtopBuilder mtopBuilder;
    public Mtop mtopInstance;
    public MtopListener mtopListener;
    public MtopRequest mtopRequest;
    public MtopResponse mtopResponse;
    public Request networkRequest;
    public Response networkResponse;
    public MtopNetworkProp property = new MtopNetworkProp();
    public Map<String, String> protocolParams;
    public Map<String, String> queryParams;
    public ResponseSource responseSource;
    public String seqNo;
    @NonNull
    public MtopStatistics stats;
}
