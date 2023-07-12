package com.youku.android.liveservice.utils;

import android.net.Uri;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UriHelper {
    public static String appendUriParameter(String str, String str2, String str3) {
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(str2, str3);
            return buildUpon.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static Uri removeUriParameter(Uri uri, String str) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str2 : queryParameterNames) {
            if (!str2.equals(str)) {
                clearQuery.appendQueryParameter(str2, uri.getQueryParameter(str2));
            }
        }
        return clearQuery.build();
    }

    public static Uri replaceUriParameter(Uri uri, String str, String str2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str3 : queryParameterNames) {
            clearQuery.appendQueryParameter(str3, str3.equals(str) ? str2 : uri.getQueryParameter(str3));
        }
        return clearQuery.build();
    }
}
