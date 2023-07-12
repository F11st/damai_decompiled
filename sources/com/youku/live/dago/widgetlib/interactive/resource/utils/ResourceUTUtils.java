package com.youku.live.dago.widgetlib.interactive.resource.utils;

import android.text.TextUtils;
import cn.damai.category.categorygirl.ui.GirlShowAllActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ResourceUTUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String PAGE_NAME = "prefetch_resource";

    public static void downloadFileResult(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1509118929")) {
            ipChange.ipc$dispatch("1509118929", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("resourceId", str);
        hashMap.put("url", str2);
        if (z) {
            hashMap.put("success", "1");
        } else {
            hashMap.put("success", "0");
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGE_NAME, 19999, "download_resource", "", "", hashMap);
    }

    public static void getResourceById(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181406970")) {
            ipChange.ipc$dispatch("-181406970", new Object[]{str, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("success", "1");
        } else {
            hashMap.put("success", "0");
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("resourceId", str);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGE_NAME, 19999, "get_resource_list", "", "", hashMap);
    }

    public static void getResourceList(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966492984")) {
            ipChange.ipc$dispatch("-1966492984", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("success", "1");
        } else {
            hashMap.put("success", "0");
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("appName", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(GirlShowAllActivity.KEY_GROUPNAME, str2);
        }
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGE_NAME, 19999, "get_resource_list", "", "", hashMap);
    }

    public static void unZipFile(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1984331596")) {
            ipChange.ipc$dispatch("-1984331596", new Object[]{str, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("resourceId", str);
        ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom(PAGE_NAME, 19999, "unzip_resource", "", "", hashMap);
    }
}
