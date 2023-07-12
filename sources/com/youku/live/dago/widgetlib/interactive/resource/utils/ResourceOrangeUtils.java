package com.youku.live.dago.widgetlib.interactive.resource.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ResourceOrangeUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String BATCH_DOWNLOAD_IN_4G = "resource_batch_download_in_4G";
    private static final String BATCH_DOWNLOAD_RESOURCE = "resource_batch_download";
    private static final String DOWNLOAD_IN_4G = "resource_download_in_4G";
    private static final String DOWNLOAD_RESOURCE = "resource_download";
    public static final String LIVE_GROUP_NAME = "YKLive";

    public static boolean isBatchDownLoadIn4G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867933219")) {
            return ((Boolean) ipChange.ipc$dispatch("-1867933219", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", BATCH_DOWNLOAD_IN_4G, "0");
        return config != null && config.compareTo("1") == 0;
    }

    public static boolean isBatchDownLoadResource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348073095")) {
            return ((Boolean) ipChange.ipc$dispatch("1348073095", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", BATCH_DOWNLOAD_RESOURCE, "0");
        return config != null && config.compareTo("1") == 0;
    }

    public static boolean isDownLoadIn4G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246361403")) {
            return ((Boolean) ipChange.ipc$dispatch("246361403", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", DOWNLOAD_IN_4G, "0");
        return config != null && config.compareTo("1") == 0;
    }

    public static boolean isDownLoadResource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619700453")) {
            return ((Boolean) ipChange.ipc$dispatch("1619700453", new Object[0])).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig("YKLive", DOWNLOAD_RESOURCE, "0");
        return config != null && config.compareTo("1") == 0;
    }
}
