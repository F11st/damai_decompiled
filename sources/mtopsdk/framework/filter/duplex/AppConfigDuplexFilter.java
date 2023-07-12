package mtopsdk.framework.filter.duplex;

import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.AppConfigManager;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.mtop.xcommand.XcmdEventMgr;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AppConfigDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.AppConfigDuplexFilter";

    /* compiled from: Taobao */
    /* renamed from: mtopsdk.framework.filter.duplex.AppConfigDuplexFilter$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum;

        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum = iArr;
            try {
                iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void updateAppConf(final long j, final MtopContext mtopContext) {
        final MtopConfig mtopConfig = mtopContext.mtopInstance.getMtopConfig();
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.framework.filter.duplex.AppConfigDuplexFilter.1
            /* JADX WARN: Removed duplicated region for block: B:39:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 256
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: mtopsdk.framework.filter.duplex.AppConfigDuplexFilter.AnonymousClass1.run():void");
            }
        });
    }

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        Map<String, List<String>> headerFields = mtopContext.mtopResponse.getHeaderFields();
        MtopConfig mtopConfig = mtopContext.mtopInstance.getMtopConfig();
        String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, HttpHeaderConstant.X_COMMAND_ORANGE);
        if (StringUtils.isNotBlank(singleHeaderFieldByKey) && StringUtils.isNotBlank(singleHeaderFieldByKey)) {
            try {
                XcmdEventMgr.getInstance().onOrangeEvent(URLDecoder.decode(singleHeaderFieldByKey, "utf-8"));
            } catch (Exception e) {
                String str = mtopContext.seqNo;
                TBSdkLog.w(TAG, str, "parse XCommand header field x-orange-p error,xcmdOrange=" + singleHeaderFieldByKey, e);
            }
        }
        String singleHeaderFieldByKey2 = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, HttpHeaderConstant.X_APP_CONF_V);
        if (StringUtils.isBlank(singleHeaderFieldByKey2)) {
            return "CONTINUE";
        }
        long j = 0;
        try {
            j = Long.parseLong(singleHeaderFieldByKey2);
        } catch (NumberFormatException e2) {
            String str2 = mtopContext.seqNo;
            TBSdkLog.e(TAG, str2, "parse remoteAppConfigVersion error.appConfigVersion=" + singleHeaderFieldByKey2, e2);
        }
        if (j > mtopConfig.xAppConfigVersion) {
            updateAppConf(j, mtopContext);
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        EnvModeEnum envModeEnum;
        Mtop mtop = mtopContext.mtopInstance;
        MtopStatistics mtopStatistics = mtopContext.stats;
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        try {
            StringBuilder sb = new StringBuilder(64);
            sb.append(mtop.getMtopConfig().utdid);
            sb.append(System.currentTimeMillis());
            sb.append(new DecimalFormat("0000").format(mtopStatistics.intSeqNo % 10000));
            sb.append("1");
            sb.append(mtop.getMtopConfig().processId);
            String sb2 = sb.toString();
            mtopNetworkProp.clientTraceId = sb2;
            mtopStatistics.clientTraceId = sb2;
        } catch (Exception e) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "generate client-trace-id failed.", e);
        }
        try {
            if (!AppConfigManager.getInstance().isTradeUnitApi(mtopContext.mtopRequest.getKey()) || (envModeEnum = mtop.getMtopConfig().envMode) == null) {
                return "CONTINUE";
            }
            int i = AnonymousClass2.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
            if (i == 1) {
                mtopNetworkProp.customOnlineDomain = MtopUnitStrategy.TRADE_ONLINE_DOMAIN;
                return "CONTINUE";
            } else if (i == 2) {
                mtopNetworkProp.customPreDomain = MtopUnitStrategy.TRADE_PRE_DOMAIN;
                return "CONTINUE";
            } else if (i == 3 || i == 4) {
                mtopNetworkProp.customDailyDomain = MtopUnitStrategy.TRADE_DAILY_DOMAIN;
                return "CONTINUE";
            } else {
                return "CONTINUE";
            }
        } catch (Exception e2) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "setCustomDomain for trade unit api error", e2);
            return "CONTINUE";
        }
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
