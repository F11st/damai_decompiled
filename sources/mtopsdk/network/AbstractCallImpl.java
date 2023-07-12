package mtopsdk.network;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MockResponse;
import mtopsdk.network.domain.NetworkStats;
import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.Response;
import mtopsdk.network.domain.ResponseBody;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbstractCallImpl implements Call, Ext {
    private static final String TAG = "mtopsdk.AbstractCallImpl";
    protected static AtomicBoolean flag = new AtomicBoolean(false);
    public static volatile boolean isDebugApk;
    public static volatile boolean isOpenMock;
    protected volatile boolean canceled;
    protected Future future;
    protected Context mContext;
    protected Request mRequest;
    protected String seqNo;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractCallImpl(Request request, Context context) {
        this.mRequest = request;
        if (request != null) {
            this.seqNo = request.seqNo;
        }
        this.mContext = context;
        if (context == null || !flag.compareAndSet(false, true)) {
            return;
        }
        isDebugApk = MtopUtils.isApkDebug(this.mContext);
        isOpenMock = MtopUtils.isAppOpenMock(this.mContext);
        String str = this.seqNo;
        TBSdkLog.i(TAG, str, "isDebugApk=" + isDebugApk + ",isOpenMock=" + isOpenMock);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Response buildResponse(Request request, int i, String str, final Map<String, List<String>> map, final byte[] bArr, NetworkStats networkStats) {
        return new Response.Builder().request(request).code(i).message(str).headers(map).body(new ResponseBody() { // from class: mtopsdk.network.AbstractCallImpl.1
            @Override // mtopsdk.network.domain.ResponseBody
            public InputStream byteStream() {
                return null;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public long contentLength() throws IOException {
                byte[] bArr2 = bArr;
                if (bArr2 != null) {
                    return bArr2.length;
                }
                return 0L;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public String contentType() {
                return HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "Content-Type");
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public byte[] getBytes() throws IOException {
                return bArr;
            }
        }).stat(networkStats).build();
    }

    @Override // mtopsdk.network.Call
    public void cancel() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "try to cancel call.");
        }
        this.canceled = true;
        Future future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MockResponse getMockResponse(String str) {
        MockResponse mockResponse;
        Exception e;
        if (str == null) {
            TBSdkLog.e(TAG, this.seqNo, "[getMockResponse] apiName is null!");
            return null;
        } else if (this.mContext == null) {
            TBSdkLog.e(TAG, this.seqNo, "[getMockResponse] mContext is null!");
            return null;
        } else {
            try {
                byte[] readFile = MtopUtils.readFile(this.mContext.getFilesDir().getCanonicalPath() + "/mock/deMock/" + str + ".json");
                if (readFile != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(readFile));
                        mockResponse = new MockResponse();
                        try {
                            mockResponse.api = str;
                            String optString = jSONObject.optString("mock_body");
                            if (optString != null) {
                                mockResponse.byteData = optString.getBytes("utf-8");
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("response_header");
                            if (optJSONObject != null) {
                                mockResponse.headers = new HashMap();
                                Iterator<String> keys = optJSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    String string = optJSONObject.getString(next);
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(string);
                                    mockResponse.headers.put(next, arrayList);
                                }
                            }
                            String optString2 = jSONObject.optString("response_status");
                            if (optString2 != null) {
                                mockResponse.statusCode = Integer.parseInt(optString2);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            TBSdkLog.e(TAG, this.seqNo, "[getMockData] get MockData error.api=" + str, e);
                            return mockResponse;
                        }
                    } catch (Exception e3) {
                        mockResponse = null;
                        e = e3;
                    }
                    return mockResponse;
                }
                return null;
            } catch (IOException e4) {
                TBSdkLog.e(TAG, this.seqNo, "[getMockResponse] parse ExternalFilesDir/mock/deMock/" + str + ".json filePath error.", e4);
                return null;
            }
        }
    }

    @Override // mtopsdk.network.Call
    public Request request() {
        return this.mRequest;
    }
}
