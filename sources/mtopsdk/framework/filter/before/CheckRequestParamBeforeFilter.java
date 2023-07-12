package mtopsdk.framework.filter.before;

import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IBeforeFilter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CheckRequestParamBeforeFilter implements IBeforeFilter {
    private static final String TAG = "mtopsdk.CheckRequestParamBeforeFilter";

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkRequiredParam(mtopsdk.framework.domain.MtopContext r9) {
        /*
            r8 = this;
            mtopsdk.mtop.domain.MtopRequest r0 = r9.mtopRequest
            mtopsdk.mtop.common.MtopNetworkProp r1 = r9.property
            java.lang.String r2 = r9.seqNo
            r3 = 0
            java.lang.String r4 = "ANDROID_SYS_MTOPCONTEXT_INIT_ERROR"
            if (r0 != 0) goto L16
            java.lang.String r3 = "mtopRequest is invalid.mtopRequest=null"
            mtopsdk.mtop.domain.MtopResponse r1 = new mtopsdk.mtop.domain.MtopResponse
            r1.<init>(r4, r3)
        L12:
            r7 = r3
            r3 = r1
            r1 = r7
            goto L52
        L16:
            boolean r5 = r0.isLegalRequest()
            if (r5 != 0) goto L3f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "mtopRequest is invalid. "
            r1.append(r3)
            java.lang.String r3 = r0.toString()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            mtopsdk.mtop.domain.MtopResponse r1 = new mtopsdk.mtop.domain.MtopResponse
            java.lang.String r5 = r0.getApiName()
            java.lang.String r6 = r0.getVersion()
            r1.<init>(r5, r6, r4, r3)
            goto L12
        L3f:
            if (r1 != 0) goto L51
            java.lang.String r3 = "MtopNetworkProp is invalid.property=null"
            mtopsdk.mtop.domain.MtopResponse r1 = new mtopsdk.mtop.domain.MtopResponse
            java.lang.String r5 = r0.getApiName()
            java.lang.String r6 = r0.getVersion()
            r1.<init>(r5, r6, r4, r3)
            goto L12
        L51:
            r1 = r3
        L52:
            r9.mtopResponse = r3
            boolean r4 = mtopsdk.common.util.StringUtils.isNotBlank(r1)
            java.lang.String r5 = "[checkRequiredParam]"
            java.lang.String r6 = "mtopsdk.CheckRequestParamBeforeFilter"
            if (r4 == 0) goto L78
            mtopsdk.common.util.TBSdkLog$LogEnable r4 = mtopsdk.common.util.TBSdkLog.LogEnable.ErrorEnable
            boolean r4 = mtopsdk.common.util.TBSdkLog.isLogEnable(r4)
            if (r4 == 0) goto L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            mtopsdk.common.util.TBSdkLog.e(r6, r2, r1)
        L78:
            if (r0 == 0) goto L98
            mtopsdk.common.util.TBSdkLog$LogEnable r1 = mtopsdk.common.util.TBSdkLog.LogEnable.DebugEnable
            boolean r1 = mtopsdk.common.util.TBSdkLog.isLogEnable(r1)
            if (r1 == 0) goto L98
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            mtopsdk.common.util.TBSdkLog.d(r6, r2, r0)
        L98:
            mtopsdk.framework.util.FilterUtils.handleExceptionCallBack(r9)
            mtopsdk.mtop.global.SwitchConfig r0 = mtopsdk.mtop.global.SwitchConfig.getInstance()
            boolean r0 = r0.isGlobalSpdySslSwitchOpen()
            if (r0 != 0) goto Lb0
            java.lang.String r0 = "[checkRequiredParam]MTOP SSL switch is false"
            mtopsdk.common.util.TBSdkLog.w(r6, r2, r0)
            mtopsdk.mtop.common.MtopNetworkProp r9 = r9.property
            mtopsdk.mtop.domain.ProtocolEnum r0 = mtopsdk.mtop.domain.ProtocolEnum.HTTP
            r9.protocol = r0
        Lb0:
            if (r3 != 0) goto Lb4
            r9 = 1
            goto Lb5
        Lb4:
            r9 = 0
        Lb5:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.framework.filter.before.CheckRequestParamBeforeFilter.checkRequiredParam(mtopsdk.framework.domain.MtopContext):boolean");
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        return checkRequiredParam(mtopContext) ? "CONTINUE" : "STOP";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
