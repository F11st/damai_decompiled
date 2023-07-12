package com.android.dingtalk.share.ddsharemodule.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.android.dingtalk.share.ddsharemodule.algorithm.MD5;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SignatureCheck {
    public static String getMD5Signature(Context context, String str) {
        Signature[] rawSignature = getRawSignature(context, str);
        if (rawSignature == null || rawSignature.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Signature signature : rawSignature) {
            stringBuffer.append(MD5.getMessageDigest(signature.toByteArray()));
        }
        return stringBuffer.toString();
    }

    private static Signature[] getRawSignature(Context context, String str) {
        if (str != null && str.length() != 0 && context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }
}
