package mtopsdk.mtop.global.init;

import android.os.Process;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.manager.impl.OpenFilterManagerImpl;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.impl.DefaultCallFactory;
import mtopsdk.security.ISign;
import mtopsdk.security.OpenSignImpl;
import mtopsdk.xstate.XState;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OpenMtopInitTask implements IMtopInitTask {
    private static final String TAG = "mtopsdk.OpenMtopInitTask";

    @Override // mtopsdk.mtop.global.init.IMtopInitTask
    public void executeCoreTask(MtopConfig mtopConfig) {
        LogAdapter logAdapter = MtopConfig.logAdapterImpl;
        if (logAdapter != null) {
            TBSdkLog.setLogAdapter(logAdapter);
        }
        String str = mtopConfig.instanceId;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitCoreTask]MtopSDK initcore start. ");
        }
        try {
            MtopFeatureManager.setMtopFeatureFlag(mtopConfig.mtopInstance, 5, true);
            XState.init(mtopConfig.context);
            XState.setValue(str, "ttid", mtopConfig.ttid);
            OpenSignImpl openSignImpl = new OpenSignImpl();
            openSignImpl.init(mtopConfig);
            mtopConfig.entrance = EntranceEnum.GW_OPEN;
            mtopConfig.sign = openSignImpl;
            mtopConfig.appKey = openSignImpl.getAppKey(new ISign.SignCtx(mtopConfig.appKeyIndex, mtopConfig.authCode));
            mtopConfig.processId = Process.myPid();
            mtopConfig.filterManager = new OpenFilterManagerImpl();
            if (mtopConfig.callFactory == null) {
                mtopConfig.callFactory = new DefaultCallFactory(mtopConfig.context, MtopSDKThreadPoolExecutorFactory.getRequestThreadPoolExecutor());
            }
            mtopConfig.mtopDomain.updateDomain(EnvModeEnum.ONLINE, "acs4baichuan.m.taobao.com");
            mtopConfig.mtopDomain.updateDomain(EnvModeEnum.PREPARE, "acs.wapa.taobao.com");
            mtopConfig.mtopDomain.updateDomain(EnvModeEnum.TEST, "acs.waptest.taobao.com");
            mtopConfig.mtopDomain.updateDomain(EnvModeEnum.TEST_SANDBOX, "api.waptest2nd.taobao.com");
        } catch (Throwable th) {
            TBSdkLog.e(TAG, str + " [executeInitCoreTask]MtopSDK initcore error.", th);
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitCoreTask]MtopSDK initcore end");
        }
    }

    @Override // mtopsdk.mtop.global.init.IMtopInitTask
    public void executeExtraTask(MtopConfig mtopConfig) {
        String str = mtopConfig.instanceId;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitExtraTask]MtopSDK initextra start");
        }
        try {
            SwitchConfig.getInstance().initConfig(mtopConfig.context);
        } catch (Throwable th) {
            TBSdkLog.e(TAG, str + " [executeInitExtraTask] execute MtopSDK initExtraTask error.", th);
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str + " [executeInitExtraTask]MtopSDK initextra end");
        }
    }
}
