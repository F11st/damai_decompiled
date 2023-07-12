package tb;

import com.alibaba.poplayer.trigger.BaseConfigItem;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ip1 {
    public static final String MONITOR_ADAPTER_VERSION = "adapter_version";
    public static final String MONITOR_BLACKLIST = "black_list";
    public static final String MONITOR_CONFIG_ITEMS = "config_items";
    public static final String MONITOR_CONFIG_SET = "config_set";
    public static final String MONITOR_NATIVE_URL = "native_url";
    public static final String MONITOR_PAGE = "page";
    public static final String MONITOR_VERSION = "version";
    public static final String MONITOR_WHITELIST = "white_list";

    public static boolean a(BaseConfigItem baseConfigItem) {
        String str;
        return (baseConfigItem == null || (str = baseConfigItem.debugInfo) == null || !str.contains("force_display")) ? false : true;
    }
}
