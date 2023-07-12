package tb;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.alibaba.pictures.request.BaseMtopRequest;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class hp2<BizResponse> implements IRemoteDataTransformer<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String KEY_RESULT_CODE = "returnCode";
    @NotNull
    public static final String KEY_RESULT_MSG = "returnMessage";
    @NotNull
    public static final String KEY_RESULT_VALUE = "returnValue";
    @NotNull
    public static final String TAG = "TppMtopDataTransformer";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    private final void a(String str, DoloresRequest<BizResponse> doloresRequest) {
        String str2;
        String obj;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1566687086")) {
            ipChange.ipc$dispatch("-1566687086", new Object[]{this, str, doloresRequest});
            return;
        }
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z = false;
                }
            } catch (Exception e) {
                rq.c(ip2.TAG, "checkResponseEmpty:" + e.getMessage());
                return;
            }
        }
        if (z || b41.d(str, "[]")) {
            String str3 = "unknown";
            if (doloresRequest instanceof BaseRequest) {
                str2 = ((BaseRequest) doloresRequest).API_NAME;
            } else if (doloresRequest instanceof BaseMtopRequest) {
                str2 = ((BaseMtopRequest) doloresRequest).getApiName();
            } else {
                str2 = doloresRequest instanceof na ? ((na) doloresRequest).a : "unknown";
            }
            HashMap hashMap = new HashMap();
            if (doloresRequest != null && (obj = doloresRequest.toString()) != null) {
                str3 = obj;
            }
            hashMap.put("Request", str3);
            wt2 wt2Var = wt2.INSTANCE;
            zb0.a(str2, hashMap);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        r9 = com.alibaba.pictures.dolores.response.BizResponseType.PARSE_ERROR;
        r1.h(r9.getCode());
        r1.j(r9.getDesc());
        r1.i(r9.getLocalDes());
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.dc0<BizResponse> transform(@org.jetbrains.annotations.Nullable com.alibaba.pictures.dolores.request.DoloresRequest<BizResponse> r9, @org.jetbrains.annotations.Nullable org.json.JSONObject r10, @org.jetbrains.annotations.Nullable java.lang.reflect.Type r11) {
        /*
            r8 = this;
            java.lang.String r0 = "TppMtopDataTransformer"
            com.android.alibaba.ip.runtime.IpChange r1 = tb.hp2.$ipChange
            java.lang.String r2 = "-475430851"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L22
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r5] = r8
            r0[r4] = r9
            r9 = 2
            r0[r9] = r10
            r9 = 3
            r0[r9] = r11
            java.lang.Object r9 = r1.ipc$dispatch(r2, r0)
            tb.dc0 r9 = (tb.dc0) r9
            return r9
        L22:
            tb.dc0 r1 = new tb.dc0
            r1.<init>()
            if (r10 == 0) goto Leb
            if (r11 != 0) goto L2d
            goto Leb
        L2d:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = "returnCode"
            com.alibaba.pictures.dolores.response.BizResponseType r7 = com.alibaba.pictures.dolores.response.BizResponseType.RESULT_FAIL     // Catch: java.lang.Exception -> L8e
            int r7 = r7.getCode()     // Catch: java.lang.Exception -> L8e
            int r6 = r10.optInt(r6, r7)     // Catch: java.lang.Exception -> L8e
            r1.h(r6)     // Catch: java.lang.Exception -> L8e
            java.lang.String r6 = "returnMessage"
            java.lang.String r6 = r10.optString(r6)     // Catch: java.lang.Exception -> L8e
            r1.j(r6)     // Catch: java.lang.Exception -> L8e
            java.lang.String r6 = "returnValue"
            java.lang.String r10 = r10.optString(r6)     // Catch: java.lang.Exception -> L8e
            r8.a(r10, r9)     // Catch: java.lang.Exception -> L8e
            tb.sb0$a r9 = tb.sb0.Companion     // Catch: java.lang.Exception -> L8e
            com.alibaba.pictures.dolores.convert.IJSONConverter r9 = r9.c()     // Catch: java.lang.Exception -> L8e
            if (r9 == 0) goto L5b
            goto L5d
        L5b:
            tb.xh0 r9 = tb.xh0.INSTANCE     // Catch: java.lang.Exception -> L8e
        L5d:
            java.lang.Object r9 = r9.parseJson(r10, r11)     // Catch: java.lang.Exception -> L8e
            r1.g(r9)     // Catch: java.lang.Exception -> L8e
            java.lang.Object r9 = r1.a()     // Catch: java.lang.Exception -> L8e
            if (r9 != 0) goto Lac
            if (r10 == 0) goto L74
            int r9 = r10.length()     // Catch: java.lang.Exception -> L8e
            if (r9 != 0) goto L73
            goto L74
        L73:
            r4 = 0
        L74:
            if (r4 != 0) goto Lac
            com.alibaba.pictures.dolores.response.BizResponseType r9 = com.alibaba.pictures.dolores.response.BizResponseType.PARSE_ERROR     // Catch: java.lang.Exception -> L8e
            int r10 = r9.getCode()     // Catch: java.lang.Exception -> L8e
            r1.h(r10)     // Catch: java.lang.Exception -> L8e
            java.lang.String r10 = r9.getDesc()     // Catch: java.lang.Exception -> L8e
            r1.j(r10)     // Catch: java.lang.Exception -> L8e
            java.lang.String r9 = r9.getLocalDes()     // Catch: java.lang.Exception -> L8e
            r1.i(r9)     // Catch: java.lang.Exception -> L8e
            goto Lac
        L8e:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "parse biz response error ("
            r10.append(r11)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            r9 = 41
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            tb.rq.c(r0, r9)
        Lac:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "bizReturnCode="
            r9.append(r10)
            int r10 = r1.b()
            r9.append(r10)
            java.lang.String r10 = ",bizReturnMessage="
            r9.append(r10)
            java.lang.String r10 = r1.c()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            tb.rq.a(r0, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "transform:耗时="
            r9.append(r10)
            long r10 = java.lang.System.currentTimeMillis()
            long r10 = r10 - r2
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "StandardDataTransformer"
            tb.rq.a(r10, r9)
        Leb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.hp2.transform(com.alibaba.pictures.dolores.request.DoloresRequest, org.json.JSONObject, java.lang.reflect.Type):tb.dc0");
    }
}
