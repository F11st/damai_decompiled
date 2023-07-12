package mtopsdk.mtop.global.init;

import android.os.Process;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.log.TLogAdapterImpl;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.manager.impl.ProductFilterManagerImpl;
import mtopsdk.mtop.antiattack.AntiAttackHandlerImpl;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.stat.UploadStatAppMonitorImpl;
import mtopsdk.network.impl.ANetworkCallFactory;
import mtopsdk.security.ISign;
import mtopsdk.security.ProductSignImpl;
import mtopsdk.xstate.XState;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ProductMtopInitTask implements IMtopInitTask {
    private static final String TAG = "mtopsdk.ProductMtopInitTask";

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
            XState.init(mtopConfig.context);
            XState.setValue(str, "ttid", mtopConfig.ttid);
            ProductSignImpl productSignImpl = new ProductSignImpl();
            productSignImpl.init(mtopConfig);
            mtopConfig.entrance = EntranceEnum.GW_INNER;
            mtopConfig.sign = productSignImpl;
            mtopConfig.appKey = productSignImpl.getAppKey(new ISign.SignCtx(mtopConfig.appKeyIndex, mtopConfig.authCode));
            mtopConfig.processId = Process.myPid();
            mtopConfig.filterManager = new ProductFilterManagerImpl();
            if (mtopConfig.antiAttackHandler == null) {
                mtopConfig.antiAttackHandler = new AntiAttackHandlerImpl(mtopConfig.context);
            }
            if (mtopConfig.callFactory == null) {
                mtopConfig.callFactory = new ANetworkCallFactory(mtopConfig.context);
            }
            if (mtopConfig.uploadStats == null) {
                mtopConfig.uploadStats = new UploadStatAppMonitorImpl();
            }
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
