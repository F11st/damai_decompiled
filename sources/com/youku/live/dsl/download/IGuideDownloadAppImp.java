package com.youku.live.dsl.download;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.content.pm.PackageManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IGuideDownloadAppImp implements IGuideDownloadApp {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String getLatestApkDownloadUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631435711")) {
            return (String) ipChange.ipc$dispatch("1631435711", new Object[0]);
        }
        String config = OrangeConfig.getInstance().getConfig("laifeng_live_room", "laifeng_download_latest_apk_url", "");
        return TextUtils.isEmpty(config) ? "" : config.trim();
    }

    public static String getLiveRoomAppUrlSince0323(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1780236696")) {
            return (String) ipChange.ipc$dispatch("-1780236696", new Object[]{str});
        }
        String config = OrangeConfig.getInstance().getConfig("laifeng_live_room", "laifeng_live_room_app_url_since_0323", str);
        return TextUtils.isEmpty(config) ? str : config.trim();
    }

    @Override // com.youku.live.dsl.download.IGuideDownloadApp
    public void guideDownload(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163143843")) {
            ipChange.ipc$dispatch("163143843", new Object[]{this, context});
        } else if (context != null) {
            AppAutoDownloadUtils.navToPicWebView(context, "", getLiveRoomAppUrlSince0323("https://h5.m.youku.com/act/downlaifengroon.html"), getLatestApkDownloadUrl(), null);
        }
    }

    @Override // com.youku.live.dsl.download.IGuideDownloadApp
    public boolean isInstalled(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409326211")) {
            return ((Boolean) ipChange.ipc$dispatch("-1409326211", new Object[]{this, context, str})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        try {
            List installedPackages = PackageManager.getInstalledPackages(context.getPackageManager(), 0);
            if (installedPackages != null && installedPackages.size() > 0) {
                for (int i = 0; i < installedPackages.size(); i++) {
                    if (installedPackages.get(i) != null && str.equals(((PackageInfo) installedPackages.get(i)).packageName)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
