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
public final class ip2<BizResponse> implements IRemoteDataTransformer<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C9272a Companion = new C9272a(null);
    @NotNull
    public static final String KEY_RESULT_CODE = "returnCode";
    @NotNull
    public static final String KEY_RESULT_MSG = "returnMessage";
    @NotNull
    public static final String KEY_RESULT_VALUE = "returnValue";
    @NotNull
    public static final String TAG = "TppShawshankDataTransformer";

    /* compiled from: Taobao */
    /* renamed from: tb.ip2$a */
    /* loaded from: classes7.dex */
    public static final class C9272a {
        private C9272a() {
        }

        public /* synthetic */ C9272a(k50 k50Var) {
            this();
        }
    }

    private final void a(String str, DoloresRequest<BizResponse> doloresRequest) {
        String str2;
        String obj;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "433273492")) {
            ipChange.ipc$dispatch("433273492", new Object[]{this, str, doloresRequest});
            return;
        }
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z = false;
                }
            } catch (Exception e) {
                rq.c(TAG, "checkResponseEmpty:" + e.getMessage());
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
        r10 = com.alibaba.pictures.dolores.response.BizResponseType.PARSE_ERROR;
        r1.h(r10.getCode());
        r1.j(r10.getDesc());
        r1.i(r10.getLocalDes());
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.dc0<BizResponse> transform(@org.jetbrains.annotations.Nullable com.alibaba.pictures.dolores.request.DoloresRequest<BizResponse> r10, @org.jetbrains.annotations.Nullable org.json.JSONObject r11, @org.jetbrains.annotations.Nullable java.lang.reflect.Type r12) {
        /*
            r9 = this;
            java.lang.String r0 = "TppShawshankDataTransformer"
            com.android.alibaba.ip.runtime.IpChange r1 = tb.ip2.$ipChange
            java.lang.String r2 = "1955350591"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L22
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r5] = r9
            r0[r4] = r10
            r10 = 2
            r0[r10] = r11
            r10 = 3
            r0[r10] = r12
            java.lang.Object r10 = r1.ipc$dispatch(r2, r0)
            tb.dc0 r10 = (tb.dc0) r10
            return r10
        L22:
            tb.dc0 r1 = new tb.dc0
            r1.<init>()
            if (r11 == 0) goto Lf4
            if (r12 != 0) goto L2d
            goto Lf4
        L2d:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = r11.toString()     // Catch: java.lang.Exception -> L97
            java.lang.String r7 = "jsonObject.toString()"
            tb.b41.h(r6, r7)     // Catch: java.lang.Exception -> L97
            java.lang.String r7 = "returnCode"
            com.alibaba.pictures.dolores.response.BizResponseType r8 = com.alibaba.pictures.dolores.response.BizResponseType.RESULT_FAIL     // Catch: java.lang.Exception -> L97
            int r8 = r8.getCode()     // Catch: java.lang.Exception -> L97
            int r7 = r11.optInt(r7, r8)     // Catch: java.lang.Exception -> L97
            r1.h(r7)     // Catch: java.lang.Exception -> L97
            java.lang.String r7 = "returnMessage"
            java.lang.String r7 = r11.optString(r7)     // Catch: java.lang.Exception -> L97
            r1.j(r7)     // Catch: java.lang.Exception -> L97
            java.lang.String r7 = "returnValue"
            java.lang.String r11 = r11.optString(r7)     // Catch: java.lang.Exception -> L97
            r9.a(r11, r10)     // Catch: java.lang.Exception -> L97
            tb.sb0$a r10 = tb.sb0.Companion     // Catch: java.lang.Exception -> L97
            com.alibaba.pictures.dolores.convert.IJSONConverter r10 = r10.c()     // Catch: java.lang.Exception -> L97
            if (r10 == 0) goto L64
            goto L66
        L64:
            tb.xh0 r10 = tb.xh0.INSTANCE     // Catch: java.lang.Exception -> L97
        L66:
            java.lang.Object r10 = r10.parseJson(r6, r12)     // Catch: java.lang.Exception -> L97
            r1.g(r10)     // Catch: java.lang.Exception -> L97
            java.lang.Object r10 = r1.a()     // Catch: java.lang.Exception -> L97
            if (r10 != 0) goto Lb5
            if (r6 == 0) goto L7d
            int r10 = r6.length()     // Catch: java.lang.Exception -> L97
            if (r10 != 0) goto L7c
            goto L7d
        L7c:
            r4 = 0
        L7d:
            if (r4 != 0) goto Lb5
            com.alibaba.pictures.dolores.response.BizResponseType r10 = com.alibaba.pictures.dolores.response.BizResponseType.PARSE_ERROR     // Catch: java.lang.Exception -> L97
            int r11 = r10.getCode()     // Catch: java.lang.Exception -> L97
            r1.h(r11)     // Catch: java.lang.Exception -> L97
            java.lang.String r11 = r10.getDesc()     // Catch: java.lang.Exception -> L97
            r1.j(r11)     // Catch: java.lang.Exception -> L97
            java.lang.String r10 = r10.getLocalDes()     // Catch: java.lang.Exception -> L97
            r1.i(r10)     // Catch: java.lang.Exception -> L97
            goto Lb5
        L97:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "parse biz response error ("
            r11.append(r12)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            r10 = 41
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            tb.rq.c(r0, r10)
        Lb5:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "bizReturnCode="
            r10.append(r11)
            int r11 = r1.b()
            r10.append(r11)
            java.lang.String r11 = ",bizReturnMessage="
            r10.append(r11)
            java.lang.String r11 = r1.c()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            tb.rq.a(r0, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "transform:耗时="
            r10.append(r11)
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = r11 - r2
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "StandardDataTransformer"
            tb.rq.a(r11, r10)
        Lf4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ip2.transform(com.alibaba.pictures.dolores.request.DoloresRequest, org.json.JSONObject, java.lang.reflect.Type):tb.dc0");
    }
}
