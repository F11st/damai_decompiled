package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IFullTraceAnalysisV3 {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface ISpan<T> {
        T getSpan();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Stage {
        public static final String REQ_PROCESS_START = "netReqProcessStart";
        public static final String REQ_SEND_START = "netReqSendStart";
        public static final String REQ_START = "netReqStart";
        public static final String RSP_CB_DISPATCH = "netRspCbDispatch";
        public static final String RSP_CB_END = "netRspCbEnd";
        public static final String RSP_CB_START = "netRspCbStart";
        public static final String RSP_RECV_END = "netRspRecvEnd";
        public static final String RSP_RECV_START = "netRspRecvStart";
        public static final String SERVE_RT = "serverRT";
    }

    ISpan createRequest(Map<String, String> map);

    void finishRequest(ISpan iSpan, RequestStatistic requestStatistic);

    void log(ISpan iSpan, String str, String str2);

    void setRequestStage(ISpan iSpan, String str, long j);
}
