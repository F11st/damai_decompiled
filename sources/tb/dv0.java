package tb;

import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class dv0 {
    @NotNull
    public static final dv0 INSTANCE = new dv0();

    private dv0() {
    }

    @JvmStatic
    @Nullable
    public static final String c(@Nullable String str, @NotNull File file) {
        b41.i(file, "dataFile");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(Base64.decode(str, 0));
            fileOutputStream.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final Bundle a(@Nullable String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            Uri parse = Uri.parse(str);
            try {
                b41.h(parse, "uri");
                for (String str2 : parse.getQueryParameterNames()) {
                    bundle.putString(str2, parse.getQueryParameter(str2));
                }
            } catch (Exception e) {
                fb1.a("TaoMaiH5Util", "parse url error:" + e);
            }
        }
        return bundle;
    }

    @Nullable
    public final String b(@Nullable String str, @NotNull String str2) {
        Uri uri;
        String str3;
        int Y;
        int Y2;
        boolean u;
        b41.i(str2, "key");
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            uri = Uri.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            uri = null;
        }
        if (uri == null || uri.isOpaque()) {
            return null;
        }
        String queryParameter = uri.getQueryParameter(str2);
        if (!(queryParameter == null || queryParameter.length() == 0)) {
            return queryParameter;
        }
        try {
            str3 = uri.getQueryParameter("__webview_options__");
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = null;
        }
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        int length = str3.length();
        int i = 0;
        while (true) {
            Y = StringsKt__StringsKt.Y(str3, '&', i, false, 4, null);
            int i2 = Y != -1 ? Y : length;
            Y2 = StringsKt__StringsKt.Y(str3, com.alipay.sdk.m.n.a.h, i, false, 4, null);
            int i3 = (Y2 > i2 || Y2 == -1) ? i2 : Y2;
            if (i3 - i == str2.length()) {
                int i4 = i;
                int i5 = i3;
                u = kotlin.text.o.u(str3, i4, str2, 0, str2.length(), false, 16, null);
                if (u) {
                    if (i5 == i2) {
                        return "";
                    }
                    String substring = str3.substring(i5 + 1, i2);
                    b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return substring;
                }
            }
            if (Y == -1) {
                return null;
            }
            i = Y + 1;
        }
    }
}
