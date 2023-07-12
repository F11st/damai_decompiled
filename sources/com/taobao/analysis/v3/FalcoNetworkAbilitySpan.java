package com.taobao.analysis.v3;

import com.ali.user.open.tbauth.TbAuthConstants;
import tb.fc1;
import tb.o31;
import tb.ph2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface FalcoNetworkAbilitySpan extends FalcoAbilitySpan {
    public static final ph2 URL = new ph2("url");
    public static final ph2 HOST = new ph2("host");
    public static final ph2 IP = new ph2(TbAuthConstants.IP);
    public static final o31 RETRY_TIMES = new o31("retryTimes");
    public static final ph2 NET_TYPE = new ph2("netType");
    public static final ph2 PROTOCOL_TYPE = new ph2("protocolType");
    public static final o31 RET = new o31("ret");
    public static final ph2 BIZ_ID = new ph2("bizID");
    public static final fc1 REQ_INFLATE_SIZE = new fc1("reqInflateSize");
    public static final fc1 REQ_DEFLATE_SIZE = new fc1("reqDeflateSize");
    public static final fc1 RSP_INFLATE_SIZE = new fc1("rspInflateSize");
    public static final fc1 RSP_DEFLATE_SIZE = new fc1("rspDeflateSize");
    public static final fc1 SEND_DATA_TIME = new fc1("sendDataTime");
    public static final fc1 FIRST_DATA_TIME = new fc1("firstDataTime");
    public static final fc1 DESERIALIZE_TIME = new fc1("deserializeTime");
    public static final fc1 DISK_CACHE_LOOKUP_TIME = new fc1("diskCacheLookupTime");
    public static final o31 IS_REQ_SYNC = new o31("isReqSync");
    public static final o31 IS_REQ_MAIN = new o31("isReqMain");
    public static final o31 IS_CB_MAIN = new o31("isCbMain");
    public static final ph2 API_NAME = new ph2("apiName");
    public static final ph2 SERVER_TRACE_ID = new ph2("serverTraceID");
    public static final fc1 MTOP_SIGN_TIME = new fc1("signTime");
    public static final o31 PIC_DATA_FROM = new o31("dataFrom");
    public static final o31 PAGE_INDEX = new o31("pageIndex");
    public static final ph2 TOPIC = new ph2("topic");
    public static final o31 LAUNCH_TYPE = new o31("launchType");

    void callbackDispatch(Long l);

    void callbackEnd(Long l);

    void callbackStart(Long l);

    void requestProcessStart(Long l);

    void requestSendStart(Long l);

    void requestStart(Long l);

    void responseProcessStart(Long l);

    void responseReceiveEnd(Long l);

    void responseReceiveStart(Long l);

    void serverRT(long j);
}
