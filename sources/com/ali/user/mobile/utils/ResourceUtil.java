package com.ali.user.mobile.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class ResourceUtil {
    public static Drawable findDrawableById(String str) {
        return DataProviderFactory.getApplicationContext().getResources().getDrawable(getDrawableId(str));
    }

    public static View findViewById(View view, String str) {
        if (view == null) {
            return null;
        }
        return view.findViewById(getViewId(str));
    }

    public static int getDrawableId(String str) {
        return getIdentifierByName(str, "drawable");
    }

    private static int getIdentifierByName(String str, String str2) {
        int identifier = DataProviderFactory.getApplicationContext().getResources().getIdentifier(str, str2, DataProviderFactory.getApplicationContext().getPackageName());
        return identifier != 0 ? identifier : DataProviderFactory.getApplicationContext().getResources().getIdentifier(str, str2, DataProviderFactory.getDataProvider().getAppName());
    }

    public static String getLocaleStr() {
        return DataProviderFactory.getDataProvider().getCurrentLanguage() != null ? DataProviderFactory.getDataProvider().getCurrentLanguage().toString() : Locale.SIMPLIFIED_CHINESE.toString();
    }

    public static String getStringById(String str) {
        try {
            int stringId = getStringId(str);
            return stringId > 0 ? DataProviderFactory.getApplicationContext().getResources().getString(stringId) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getStringId(String str) {
        return getIdentifierByName(str, "string");
    }

    public static int getViewId(String str) {
        return getIdentifierByName(str, "id");
    }
}
