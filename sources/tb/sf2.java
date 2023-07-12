package tb;

import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class sf2<BizResponse> implements IRemoteDataTransformer<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C9692a Companion = new C9692a(null);
    @NotNull
    public static final String TAG = "StandardDataTransformer";

    /* compiled from: Taobao */
    /* renamed from: tb.sf2$a */
    /* loaded from: classes7.dex */
    public static final class C9692a {
        private C9692a() {
        }

        public /* synthetic */ C9692a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        r9 = com.alibaba.pictures.dolores.response.BizResponseType.PARSE_ERROR;
        r8.h(r9.getCode());
        r8.j(r9.getDesc());
        r8.i(r9.getLocalDes());
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.dc0<BizResponse> transform(@org.jetbrains.annotations.Nullable com.alibaba.pictures.dolores.request.DoloresRequest<BizResponse> r8, @org.jetbrains.annotations.Nullable org.json.JSONObject r9, @org.jetbrains.annotations.Nullable java.lang.reflect.Type r10) {
        /*
            r7 = this;
            java.lang.String r0 = "StandardDataTransformer"
            com.android.alibaba.ip.runtime.IpChange r1 = tb.sf2.$ipChange
            java.lang.String r2 = "-1550538286"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L22
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r5] = r7
            r0[r4] = r8
            r8 = 2
            r0[r8] = r9
            r8 = 3
            r0[r8] = r10
            java.lang.Object r8 = r1.ipc$dispatch(r2, r0)
            tb.dc0 r8 = (tb.dc0) r8
            return r8
        L22:
            tb.dc0 r8 = new tb.dc0
            r8.<init>()
            if (r9 == 0) goto Lbe
            if (r10 != 0) goto L2d
            goto Lbe
        L2d:
            long r1 = java.lang.System.currentTimeMillis()
            com.alibaba.pictures.dolores.response.BizResponseType r3 = com.alibaba.pictures.dolores.response.BizResponseType.RESULT_SUCCESS     // Catch: java.lang.Exception -> L86
            int r6 = r3.getCode()     // Catch: java.lang.Exception -> L86
            r8.h(r6)     // Catch: java.lang.Exception -> L86
            java.lang.String r3 = r3.getDesc()     // Catch: java.lang.Exception -> L86
            r8.j(r3)     // Catch: java.lang.Exception -> L86
            tb.sb0$a r3 = tb.sb0.Companion     // Catch: java.lang.Exception -> L86
            com.alibaba.pictures.dolores.convert.IJSONConverter r3 = r3.c()     // Catch: java.lang.Exception -> L86
            if (r3 == 0) goto L4a
            goto L4c
        L4a:
            tb.xh0 r3 = tb.xh0.INSTANCE     // Catch: java.lang.Exception -> L86
        L4c:
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L86
            java.lang.String r6 = "jsonObject.toString()"
            tb.b41.h(r9, r6)     // Catch: java.lang.Exception -> L86
            java.lang.Object r10 = r3.parseJson(r9, r10)     // Catch: java.lang.Exception -> L86
            r8.g(r10)     // Catch: java.lang.Exception -> L86
            java.lang.Object r10 = r8.a()     // Catch: java.lang.Exception -> L86
            if (r10 != 0) goto La4
            if (r9 == 0) goto L6c
            int r9 = r9.length()     // Catch: java.lang.Exception -> L86
            if (r9 != 0) goto L6b
            goto L6c
        L6b:
            r4 = 0
        L6c:
            if (r4 != 0) goto La4
            com.alibaba.pictures.dolores.response.BizResponseType r9 = com.alibaba.pictures.dolores.response.BizResponseType.PARSE_ERROR     // Catch: java.lang.Exception -> L86
            int r10 = r9.getCode()     // Catch: java.lang.Exception -> L86
            r8.h(r10)     // Catch: java.lang.Exception -> L86
            java.lang.String r10 = r9.getDesc()     // Catch: java.lang.Exception -> L86
            r8.j(r10)     // Catch: java.lang.Exception -> L86
            java.lang.String r9 = r9.getLocalDes()     // Catch: java.lang.Exception -> L86
            r8.i(r9)     // Catch: java.lang.Exception -> L86
            goto La4
        L86:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "parse biz response error ("
            r10.append(r3)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            r9 = 41
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            tb.rq.c(r0, r9)
        La4:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "transform:耗时="
            r9.append(r10)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            tb.rq.a(r0, r9)
            return r8
        Lbe:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.sf2.transform(com.alibaba.pictures.dolores.request.DoloresRequest, org.json.JSONObject, java.lang.reflect.Type):tb.dc0");
    }
}
