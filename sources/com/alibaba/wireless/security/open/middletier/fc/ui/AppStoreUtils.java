package com.alibaba.wireless.security.open.middletier.fc.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppStoreUtils {
    public static HashMap<String, String> getInstalledMarketPackageName(Context context) {
        CharSequence charSequence;
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("market://details?id="));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                try {
                    ActivityInfo activityInfo = queryIntentActivities.get(i).activityInfo;
                    str = activityInfo.packageName;
                    try {
                        charSequence = activityInfo.loadLabel(context.getPackageManager());
                        try {
                            context.getResources().getString(context.getPackageManager().getPackageInfo(str, 0).applicationInfo.labelRes);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        charSequence = "";
                    }
                } catch (Exception unused3) {
                    charSequence = "";
                    str = charSequence;
                }
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(charSequence.toString(), str);
                }
            }
        }
        return hashMap;
    }

    public static boolean toMarket(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.addFlags(268435456);
        if (str2 != null) {
            intent.setPackage(str2);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
