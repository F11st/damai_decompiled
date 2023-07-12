package mtopsdk.mtop.global.init;

import android.os.Process;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.log.TLogAdapterImpl;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.AppConfigManager;
import mtopsdk.framework.manager.impl.InnerFilterManagerImpl;
import mtopsdk.mtop.antiattack.AntiAttackHandlerImpl;
import mtopsdk.mtop.deviceid.DeviceIDManager;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.network.NetworkPropertyServiceImpl;
import mtopsdk.mtop.stat.UploadStatAppMonitorImpl;
import mtopsdk.network.impl.ANetworkCallFactory;
import mtopsdk.security.ISign;
import mtopsdk.security.InnerSignImpl;
import mtopsdk.xstate.XState;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InnerMtopInitTask implements IMtopInitTask {
    private static final String TAG = "mtopsdk.InnerMtopInitTask";

    @Override // mtopsdk.mtop.global.init.IMtopInitTask
    public void executeCoreTask(MtopConfig mtopConfig) {
        LogAdapter logAdapter = MtopConfig.logAdapterImpl;
        if (logAdapter == null) {
            logAdapter = new TLogAdapterImpl();
        }
        TBSdkLog.setLogAdapter(logAdapter);
        String str = mtopConfig.instanceId;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitCoreTask]MtopSDK initcore start. ");
        }
        try {
            Mtop mtop = mtopConfig.mtopInstance;
            MtopFeatureManager.setMtopFeatureFlag(mtop, 1, true);
            MtopFeatureManager.setMtopFeatureFlag(mtop, 2, true);
            MtopFeatureManager.setMtopFeatureFlag(mtop, 4, true);
            MtopFeatureManager.setMtopFeatureFlag(mtop, 5, true);
            if (mtopConfig.uploadStats == null) {
                mtopConfig.uploadStats = new UploadStatAppMonitorImpl();
            }
            mtopConfig.networkPropertyService = new NetworkPropertyServiceImpl();
            XState.init(mtopConfig.context);
            XState.setValue(str, "ttid", mtopConfig.ttid);
            mtopConfig.networkPropertyService.setTtid(mtopConfig.ttid);
            RemoteConfig.getInstance().loadLocalConfig(mtopConfig.context);
            ISign iSign = mtopConfig.sign;
            if (iSign == null) {
                iSign = new InnerSignImpl();
            }
            iSign.init(mtopConfig);
            mtopConfig.entrance = EntranceEnum.GW_INNER;
            mtopConfig.sign = iSign;
            if (StringUtils.isEmpty(mtopConfig.appKey)) {
                mtopConfig.appKey = iSign.getAppKey(new ISign.SignCtx(mtopConfig.appKeyIndex, mtopConfig.authCode));
            }
            mtopConfig.processId = Process.myPid();
            mtopConfig.filterManager = new InnerFilterManagerImpl();
            if (mtopConfig.antiAttackHandler == null) {
                mtopConfig.antiAttackHandler = new AntiAttackHandlerImpl(mtopConfig.context);
            }
            if (mtopConfig.callFactory == null) {
                mtopConfig.callFactory = new ANetworkCallFactory(mtopConfig.context);
            }
        } catch (Throwable th) {
            TBSdkLog.e(TAG, str + " [executeInitCoreTask]MtopSDK initCore error", th);
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitCoreTask]MtopSDK initCore end");
        }
    }

    @Override // mtopsdk.mtop.global.init.IMtopInitTask
    public void executeExtraTask(MtopConfig mtopConfig) {
        String str = mtopConfig.instanceId;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitExtraTask]MtopSDK initExtra start");
        }
        try {
            if (mtopConfig.enableNewDeviceId) {
                DeviceIDManager.getInstance().getDeviceID(mtopConfig.context, mtopConfig.appKey);
            }
            SwitchConfig.getInstance().initConfig(mtopConfig.context);
            AppConfigManager.getInstance().reloadAppConfig(mtopConfig);
        } catch (Throwable th) {
            TBSdkLog.e(TAG, str + " [executeInitExtraTask] execute MtopSDK initExtraTask error.", th);
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitExtraTask]MtopSDK initExtra end");
        }
    }
}
