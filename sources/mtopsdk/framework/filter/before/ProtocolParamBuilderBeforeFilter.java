package mtopsdk.framework.filter.before;

import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.mtop.protocol.builder.ProtocolParamBuilder;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ProtocolParamBuilderBeforeFilter implements IBeforeFilter {
    private static final String TAG = "mtopsdk.ProtocolParamBuilderBeforeFilter";
    private ProtocolParamBuilder paramBuilder;

    public ProtocolParamBuilderBeforeFilter(ProtocolParamBuilder protocolParamBuilder) {
        this.paramBuilder = protocolParamBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    @Override // mtopsdk.framework.filter.IBeforeFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doBefore(mtopsdk.framework.domain.MtopContext r9) {
        /*
            r8 = this;
            mtopsdk.mtop.domain.MtopRequest r0 = r9.mtopRequest
            r1 = 0
            mtopsdk.mtop.protocol.builder.ProtocolParamBuilder r2 = r8.paramBuilder     // Catch: java.lang.Throwable -> L5f
            java.util.Map r2 = r2.buildParams(r9)     // Catch: java.lang.Throwable -> L5f
            if (r2 != 0) goto L1d
            mtopsdk.mtop.domain.MtopResponse r1 = new mtopsdk.mtop.domain.MtopResponse     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = r0.getApiName()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = r0.getVersion()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = "ANDROID_SYS_INIT_MTOP_ISIGN_ERROR"
            java.lang.String r6 = "初始化Mtop签名类ISign失败"
            r1.<init>(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L5d
            goto L7e
        L1d:
            java.lang.String r3 = "sign"
            java.lang.Object r3 = r2.get(r3)     // Catch: java.lang.Throwable -> L5d
            if (r3 != 0) goto L7e
            java.lang.String r1 = "SG_ERROR_CODE"
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L5d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d
            r4 = 48
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR"
            r3.append(r4)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L48
            java.lang.String r4 = "("
            r3.append(r4)     // Catch: java.lang.Throwable -> L5d
            r3.append(r1)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = ")"
            r3.append(r1)     // Catch: java.lang.Throwable -> L5d
        L48:
            mtopsdk.mtop.domain.MtopResponse r1 = new mtopsdk.mtop.domain.MtopResponse     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = r0.getApiName()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = r0.getVersion()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = "生成Mtop签名sign失败"
            r1.<init>(r4, r5, r3, r6)     // Catch: java.lang.Throwable -> L5d
            goto L7e
        L5d:
            r1 = move-exception
            goto L63
        L5f:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L63:
            java.lang.String r3 = r9.seqNo
            java.lang.String r4 = "mtopsdk.ProtocolParamBuilderBeforeFilter"
            java.lang.String r5 = "[deBefore]execute ProtocolParamBuilder buildParams error."
            mtopsdk.common.util.TBSdkLog.e(r4, r3, r5, r1)
            mtopsdk.mtop.domain.MtopResponse r1 = new mtopsdk.mtop.domain.MtopResponse
            java.lang.String r3 = r0.getApiName()
            java.lang.String r0 = r0.getVersion()
            java.lang.String r4 = "ANDROID_SYS_BUILD_PROTOCOL_PARAMS_ERROR"
            java.lang.String r5 = "组装MTOP协议参数错误"
            r1.<init>(r3, r0, r4, r5)
        L7e:
            if (r1 == 0) goto L88
            r9.mtopResponse = r1
            mtopsdk.framework.util.FilterUtils.handleExceptionCallBack(r9)
            java.lang.String r9 = "STOP"
            return r9
        L88:
            r9.protocolParams = r2
            java.lang.String r9 = "CONTINUE"
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.framework.filter.before.ProtocolParamBuilderBeforeFilter.doBefore(mtopsdk.framework.domain.MtopContext):java.lang.String");
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
