package tb;

import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.taobao.analysis.v3.FalcoGlobalTracer;
import com.taobao.analysis.v3.FalcoNetworkAbilitySpan;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.analysis.v3.FalcoTracer;
import com.taobao.opentracing.api.SpanContext;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class t50 implements IFullTraceAnalysisV3 {
    private boolean a;
    private FalcoTracer b;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements IFullTraceAnalysisV3.ISpan<FalcoNetworkAbilitySpan> {
        private final FalcoNetworkAbilitySpan a;

        a(t50 t50Var, FalcoNetworkAbilitySpan falcoNetworkAbilitySpan) {
            this.a = falcoNetworkAbilitySpan;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysisV3.ISpan
        /* renamed from: a */
        public FalcoNetworkAbilitySpan getSpan() {
            return this.a;
        }
    }

    public t50() {
        this.a = false;
        try {
            FalcoTracer falcoTracer = FalcoGlobalTracer.get();
            this.b = falcoTracer;
            if (falcoTracer != null) {
                this.a = true;
            }
        } catch (Exception unused) {
            ALog.e("awcn.DefaultFullTraceAnalysisV3", "not support FullTraceAnalysis v3", null, new Object[0]);
        }
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
    public IFullTraceAnalysisV3.ISpan createRequest(Map<String, String> map) {
        SpanContext extractMapToContext;
        if (this.a) {
            FalcoTracer.FalcoSpanBuilder buildSpan = this.b.buildSpan("network", "Network_UnknownScene");
            if (map != null && !map.isEmpty() && (extractMapToContext = this.b.extractMapToContext(map)) != null) {
                buildSpan.asChildOf(extractMapToContext);
            }
            return new a(this, buildSpan.startNetworkAbilitySpan());
        }
        return null;
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
    public void finishRequest(IFullTraceAnalysisV3.ISpan iSpan, RequestStatistic requestStatistic) {
        String str;
        if (!this.a || requestStatistic == null || iSpan == null) {
            return;
        }
        setRequestStage(iSpan, "netReqStart", requestStatistic.netReqStart);
        setRequestStage(iSpan, "netReqProcessStart", requestStatistic.reqStart);
        setRequestStage(iSpan, "netReqSendStart", requestStatistic.sendStart);
        setRequestStage(iSpan, IFullTraceAnalysisV3.Stage.SERVE_RT, requestStatistic.serverRT);
        setRequestStage(iSpan, IFullTraceAnalysisV3.Stage.RSP_RECV_START, requestStatistic.rspStart);
        setRequestStage(iSpan, "netRspRecvEnd", requestStatistic.rspEnd);
        setRequestStage(iSpan, "netRspCbDispatch", requestStatistic.rspCbDispatch);
        setRequestStage(iSpan, "netRspCbStart", requestStatistic.rspCbStart);
        setRequestStage(iSpan, "netRspCbEnd", requestStatistic.rspCbEnd);
        FalcoNetworkAbilitySpan falcoNetworkAbilitySpan = (FalcoNetworkAbilitySpan) iSpan.getSpan();
        FalcoNetworkAbilitySpan.HOST.set(falcoNetworkAbilitySpan, requestStatistic.host);
        FalcoNetworkAbilitySpan.URL.set(falcoNetworkAbilitySpan, requestStatistic.url);
        FalcoNetworkAbilitySpan.IP.set(falcoNetworkAbilitySpan, requestStatistic.ip);
        FalcoNetworkAbilitySpan.BIZ_ID.set(falcoNetworkAbilitySpan, requestStatistic.bizId);
        FalcoNetworkAbilitySpan.RETRY_TIMES.set(falcoNetworkAbilitySpan, Integer.valueOf(requestStatistic.retryTimes));
        FalcoNetworkAbilitySpan.PROTOCOL_TYPE.set(falcoNetworkAbilitySpan, requestStatistic.protocolType);
        FalcoSpan.ERROR_CODE.set(falcoNetworkAbilitySpan, String.valueOf(requestStatistic.statusCode));
        FalcoNetworkAbilitySpan.IS_CB_MAIN.set(falcoNetworkAbilitySpan, 0);
        FalcoNetworkAbilitySpan.IS_REQ_MAIN.set(falcoNetworkAbilitySpan, Integer.valueOf(requestStatistic.isReqMain ? 1 : 0));
        FalcoNetworkAbilitySpan.IS_REQ_SYNC.set(falcoNetworkAbilitySpan, Integer.valueOf(requestStatistic.isReqSync ? 1 : 0));
        FalcoNetworkAbilitySpan.RET.set(falcoNetworkAbilitySpan, Integer.valueOf(requestStatistic.ret));
        FalcoNetworkAbilitySpan.NET_TYPE.set(falcoNetworkAbilitySpan, requestStatistic.netType);
        FalcoNetworkAbilitySpan.SEND_DATA_TIME.set(falcoNetworkAbilitySpan, Long.valueOf(requestStatistic.sendDataTime));
        FalcoNetworkAbilitySpan.FIRST_DATA_TIME.set(falcoNetworkAbilitySpan, Long.valueOf(requestStatistic.firstDataTime));
        FalcoNetworkAbilitySpan.REQ_DEFLATE_SIZE.set(falcoNetworkAbilitySpan, Long.valueOf(requestStatistic.reqHeadDeflateSize + requestStatistic.reqBodyDeflateSize));
        FalcoNetworkAbilitySpan.REQ_INFLATE_SIZE.set(falcoNetworkAbilitySpan, Long.valueOf(requestStatistic.reqHeadInflateSize + requestStatistic.reqBodyInflateSize));
        FalcoNetworkAbilitySpan.RSP_DEFLATE_SIZE.set(falcoNetworkAbilitySpan, Long.valueOf(requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize));
        FalcoNetworkAbilitySpan.RSP_INFLATE_SIZE.set(falcoNetworkAbilitySpan, Long.valueOf(requestStatistic.rspHeadInflateSize + requestStatistic.rspBodyInflateSize));
        if (requestStatistic.ret == 0) {
            str = "failed";
        } else {
            str = requestStatistic.ret == 1 ? "succeed" : "cancel";
        }
        falcoNetworkAbilitySpan.finish(str);
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
    public void log(IFullTraceAnalysisV3.ISpan iSpan, String str, String str2) {
        if (this.a && iSpan != null) {
            ((FalcoNetworkAbilitySpan) iSpan.getSpan()).releaseLog("module=network,stage=" + str + ",content=" + str2);
        }
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
    public void setRequestStage(IFullTraceAnalysisV3.ISpan iSpan, String str, long j) {
        if (this.a && iSpan != null) {
            FalcoNetworkAbilitySpan falcoNetworkAbilitySpan = (FalcoNetworkAbilitySpan) iSpan.getSpan();
            if ("netReqStart".equals(str)) {
                falcoNetworkAbilitySpan.requestStart(Long.valueOf(j));
            } else if ("netReqProcessStart".equals(str)) {
                falcoNetworkAbilitySpan.requestProcessStart(Long.valueOf(j));
            } else if ("netReqSendStart".equals(str)) {
                falcoNetworkAbilitySpan.requestSendStart(Long.valueOf(j));
            } else if (IFullTraceAnalysisV3.Stage.RSP_RECV_START.equals(str)) {
                falcoNetworkAbilitySpan.responseReceiveStart(Long.valueOf(j));
            } else if ("netRspRecvEnd".equals(str)) {
                falcoNetworkAbilitySpan.responseReceiveEnd(Long.valueOf(j));
            } else if ("netRspCbDispatch".equals(str)) {
                falcoNetworkAbilitySpan.callbackDispatch(Long.valueOf(j));
            } else if ("netRspCbStart".equals(str)) {
                falcoNetworkAbilitySpan.callbackStart(Long.valueOf(j));
            } else if ("netRspCbEnd".equals(str)) {
                falcoNetworkAbilitySpan.callbackEnd(Long.valueOf(j));
            } else if (IFullTraceAnalysisV3.Stage.SERVE_RT.equals(str)) {
                falcoNetworkAbilitySpan.serverRT(j);
            }
        }
    }
}
