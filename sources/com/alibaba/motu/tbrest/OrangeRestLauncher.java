package com.alibaba.motu.tbrest;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.motu.tbrest.data.RestOrangeConfigure;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class OrangeRestLauncher implements Serializable {
    private static final String ALL_SAMPLE = "all";
    private static final String DATA_SIZE = "dataSize";
    private static final int DEFAULT_DATA_SIZE = 40960;
    private static final int DEFAULT_MESSAGE_COUNT = 50;
    private static final float DEFAULT_SAMPLE = 1.0f;
    private static final String MESSAGE_COUNT = "messageCount";
    private static final String TB_REST_ORANGE = "TBRestOrange";
    private static final String USE_OLD_LOGIC = "useOldLogic";
    private static volatile boolean initOrange;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class OrangeListener implements OConfigListener {
        private final RestOrangeConfigure configure;

        private OrangeListener() {
            this.configure = RestOrangeConfigure.instance();
        }

        private boolean getSafeBoolean(String str, boolean z) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Boolean.valueOf(str).booleanValue();
                }
            } catch (Exception unused) {
            }
            return z;
        }

        private float getSafeFloat(String str, float f) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Float.valueOf(str).floatValue();
                }
            } catch (Exception unused) {
            }
            return f;
        }

        private int getSafeInt(String str, int i) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Integer.valueOf(str).intValue();
                }
            } catch (Exception unused) {
            }
            return i;
        }

        private boolean isStartWithNumber(String str) {
            char charAt;
            return str.length() > 0 && (charAt = str.charAt(0)) >= '0' && charAt <= '9';
        }

        private void onUpdate(Map<String, String> map) {
            this.configure.setAllSample(getSafeFloat(map.get("all"), 1.0f));
            this.configure.setDataSize(getSafeInt(map.get(OrangeRestLauncher.DATA_SIZE), OrangeRestLauncher.DEFAULT_DATA_SIZE));
            this.configure.setMessageCount(getSafeInt(map.get(OrangeRestLauncher.MESSAGE_COUNT), 50));
            this.configure.setUseOldLogic(getSafeBoolean(map.get(OrangeRestLauncher.USE_OLD_LOGIC), false));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && isStartWithNumber(key)) {
                    this.configure.setEventIDSample(key, getSafeFloat(entry.getValue(), 1.0f));
                }
            }
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            Map<String, String> configs = OrangeConfig.getInstance().getConfigs(OrangeRestLauncher.TB_REST_ORANGE);
            if (configs == null || configs.size() <= 0) {
                return;
            }
            onUpdate(configs);
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (initOrange) {
            return;
        }
        initOrange = true;
        OrangeConfig.getInstance().getConfigs(TB_REST_ORANGE);
        OrangeConfig.getInstance().registerListener(new String[]{TB_REST_ORANGE}, new OrangeListener(), true);
    }
}
