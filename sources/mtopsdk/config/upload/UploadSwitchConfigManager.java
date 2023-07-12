package mtopsdk.config.upload;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.orange.OrangeConfigLocal;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.SwitchConfigUtil;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploadSwitchConfigManager {
    private final String TAG;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class UploadSwitchConfigManagerInstanceHolder {
        private static UploadSwitchConfigManager instance = new UploadSwitchConfigManager();

        private UploadSwitchConfigManagerInstanceHolder() {
        }
    }

    public static UploadSwitchConfigManager getInstance() {
        return UploadSwitchConfigManagerInstanceHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseDegradeBizCodeSetConfig() {
        String config = OrangeConfigLocal.getInstance().getConfig(SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_UPLOAD_SWITCH, SwitchConfigUtil.DEGRADE_BIZCODE_SET_KEY, null);
        if (StringUtils.isBlank(config)) {
            return;
        }
        try {
            List parseArray = JSON.parseArray(config, String.class);
            if (parseArray != null) {
                RemoteConfig.getInstance().degradeBizcodeSets.clear();
                RemoteConfig.getInstance().degradeBizcodeSets.addAll(parseArray);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.UploadSwitchConfigManager", "parse degradeBizcodeSets succeed,degradeBizCodeSetStr=" + config);
                }
            }
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.UploadSwitchConfigManager", "[parseDegradeBizCodeSetConfig]parse degradeBizCodeSetStr error ---", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseRemoteSegmentSizeMapConfig() {
        String config = OrangeConfigLocal.getInstance().getConfig(SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_UPLOAD_SWITCH, SwitchConfigUtil.SEGMENT_SIZE_MAP_KEY, null);
        if (StringUtils.isBlank(config)) {
            return;
        }
        try {
            Map map = (Map) JSON.parseObject(config, new TypeReference<Map<String, Integer>>() { // from class: mtopsdk.config.upload.UploadSwitchConfigManager.1
            }, new Feature[0]);
            if (map == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Integer num = (Integer) entry.getValue();
                if (StringUtils.isNotBlank(str) && num != null) {
                    RemoteConfig.getInstance().setSegmentSize(str, num.intValue());
                }
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i("mtopsdk.UploadSwitchConfigManager", "[parseRemoteSegmentSizeMap]  remoteSegmentSizeMap=" + map);
            }
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.UploadSwitchConfigManager", "[parseRemoteSegmentSizeMap]  parse segmentSizeMap configitem key error." + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseUseHttpsBizCodeSetConfig() {
        String config = OrangeConfigLocal.getInstance().getConfig(SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_UPLOAD_SWITCH, SwitchConfigUtil.USEHTTPS_BIZCODE_SET_KEY, null);
        if (StringUtils.isBlank(config)) {
            return;
        }
        try {
            List parseArray = JSON.parseArray(config, String.class);
            if (parseArray != null) {
                RemoteConfig.getInstance().useHttpsBizcodeSets.clear();
                RemoteConfig.getInstance().useHttpsBizcodeSets.addAll(parseArray);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i("mtopsdk.UploadSwitchConfigManager", "parse useHttpsBizcodeSetStr succeed,useHttpsBizcodeSetStr=" + config);
                }
            }
        } catch (Throwable th) {
            TBSdkLog.e("mtopsdk.UploadSwitchConfigManager", "[parseUseHttpsBizCodeSetConfig]parse useHttpsBizcodeSetStr error ---" + th.toString());
        }
    }

    private UploadSwitchConfigManager() {
        this.TAG = "mtopsdk.UploadSwitchConfigManager";
    }
}
