package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class l {
    public static ComponentName a(Context context, Intent intent) {
        if (intent != null) {
            try {
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    ActivityInfo activityInfo = resolveActivity.activityInfo;
                    return new ComponentName(activityInfo.packageName, activityInfo.name);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static boolean a(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("checkService " + e);
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryIntentServices != null) {
                return !queryIntentServices.isEmpty();
            }
            return false;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("checkService action: " + str2 + AVFSCacheConstants.COMMA_SEP + e);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z = false;
        try {
            List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(null, 0, 8);
            if (queryContentProviders != null && !queryContentProviders.isEmpty()) {
                for (ProviderInfo providerInfo : queryContentProviders) {
                    if (providerInfo.enabled && providerInfo.exported && providerInfo.authority.equals(str)) {
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("checkProvider " + e);
        }
        return z;
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(str);
            return packageManager.resolveActivity(intent, 65536) != null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("checkActivity action: " + str2 + AVFSCacheConstants.COMMA_SEP + e);
            return false;
        }
    }
}
