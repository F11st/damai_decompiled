package mtopsdk.config.baseswitch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.global.SwitchConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SwitchConfigManager {
    private final String TAG;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SwitchConfigManagerInstanceHolder {
        private static SwitchConfigManager instance = new SwitchConfigManager();

        private SwitchConfigManagerInstanceHolder() {
        }
    }

    public static SwitchConfigManager getInstance() {
        return SwitchConfigManagerInstanceHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateApiCacheConfig() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.SwitchConfigManager", "[updateDegradeApiCacheList]updateDegradeApiCacheList called");
        }
        if (StringUtils.isNotBlank(RemoteConfig.getInstance().degradeApiCacheList)) {
            try {
                List parseArray = JSON.parseArray(RemoteConfig.getInstance().degradeApiCacheList, String.class);
                if (parseArray != null) {
                    SwitchConfig.getInstance().degradeApiCacheSet = new HashSet(parseArray);
                }
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.SwitchConfigManager", "[updateDegradeApiCacheList]parse and update degradeApiCacheList error.", th);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.SwitchConfigManager", "[updateDegradeApiCacheList]parse and update degradeApiCacheList succeed");
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.SwitchConfigManager", "[updateRemoveCacheBlockList]updateRemoveCacheBlockList called");
        }
        if (StringUtils.isNotBlank(RemoteConfig.getInstance().removeCacheBlockList)) {
            try {
                List parseArray2 = JSON.parseArray(RemoteConfig.getInstance().removeCacheBlockList, String.class);
                if (parseArray2 != null) {
                    for (int i = 0; i < parseArray2.size(); i++) {
                        String str = (String) parseArray2.get(i);
                        boolean removeCacheBlock = SDKUtils.removeCacheBlock(str);
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                            TBSdkLog.i("mtopsdk.SwitchConfigManager", "[updateRemoveCacheBlockList]removeCacheBlock result=" + removeCacheBlock + ",blockName=" + str);
                        }
                    }
                }
            } catch (Throwable th2) {
                TBSdkLog.e("mtopsdk.SwitchConfigManager", "[updateRemoveCacheBlockList]parse and update removeCacheBlockList error.", th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateErrorMappingConfig() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.SwitchConfigManager", "[updateDegradeBizErrorMappingApiList]updateDegradeBizErrorMappingApiList called");
        }
        if (StringUtils.isNotBlank(RemoteConfig.getInstance().degradeBizErrorMappingApiList)) {
            try {
                List parseArray = JSON.parseArray(RemoteConfig.getInstance().degradeBizErrorMappingApiList, String.class);
                if (parseArray != null) {
                    SwitchConfig.getInstance().degradeBizErrorMappingApiSet = new HashSet(parseArray);
                }
            } catch (Throwable th) {
                TBSdkLog.e("mtopsdk.SwitchConfigManager", "[updateDegradeBizErrorMappingApiList]parse and update degradeBizErrorMappingApiList error.", th);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.SwitchConfigManager", "[updateDegradeBizErrorMappingApiList]parse and update degradeBizErrorMappingApiList succeed");
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.SwitchConfigManager", "[updateErrorMappingMsgMap]updateErrorMappingMsgMap called");
        }
        if (StringUtils.isNotBlank(RemoteConfig.getInstance().errorMappingMsg)) {
            try {
                Map map = (Map) JSON.parseObject(RemoteConfig.getInstance().errorMappingMsg, new TypeReference<Map<String, String>>() { // from class: mtopsdk.config.baseswitch.SwitchConfigManager.2
                }, new Feature[0]);
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (StringUtils.isNotBlank((String) entry.getKey()) && StringUtils.isNotBlank((String) entry.getValue())) {
                            SwitchConfig.errorMappingMsgMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Throwable th2) {
                TBSdkLog.e("mtopsdk.SwitchConfigManager", "[updateErrorMappingMsgMap]update ErrorMappingMsgMap error.", th2);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.SwitchConfigManager", "[updateErrorMappingMsgMap]parse and update ErrorMappingMsgMap succeed.remoteErrorMappingMsgMap=");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    public void updateIndividualApiLockIntervalMap() {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.d("mtopsdk.SwitchConfigManager", "updateIndividualApiLockIntervalMap called");
        }
        Map<String, String> individualApiLockIntervalMap = SwitchConfig.getInstance().getIndividualApiLockIntervalMap();
        if (!individualApiLockIntervalMap.isEmpty()) {
            individualApiLockIntervalMap.clear();
        }
        if (StringUtils.isBlank(RemoteConfig.getInstance().individualApiLockInterval)) {
            return;
        }
        try {
            Map map = (Map) JSON.parseObject(RemoteConfig.getInstance().individualApiLockInterval, new TypeReference<Map<String, String>>() { // from class: mtopsdk.config.baseswitch.SwitchConfigManager.1
            }, new Feature[0]);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (StringUtils.isNotBlank((String) entry.getKey())) {
                        individualApiLockIntervalMap.put(((String) entry.getKey()).toLowerCase(), entry.getValue());
                    }
                }
            }
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.SwitchConfigManager", "[updateIndividualApiLockIntervalMap] deSerialize intervalStr error.---" + th.toString());
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i("mtopsdk.SwitchConfigManager", "[updateIndividualApiLockIntervalMap]parse and update individual ApiLock Interval Map succeed");
        }
    }

    private SwitchConfigManager() {
        this.TAG = "mtopsdk.SwitchConfigManager";
    }
}
