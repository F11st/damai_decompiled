package androidx.core.net;

import android.net.Uri;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import androidx.annotation.NonNull;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (!scheme.equalsIgnoreCase("tel") && !scheme.equalsIgnoreCase("sip") && !scheme.equalsIgnoreCase("sms") && !scheme.equalsIgnoreCase("smsto") && !scheme.equalsIgnoreCase("mailto") && !scheme.equalsIgnoreCase("nfc")) {
                if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https") || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(WVUtils.URL_SEPARATOR);
                    sb.append(uri.getHost() != null ? uri.getHost() : "");
                    sb.append(uri.getPort() != -1 ? ":" + uri.getPort() : "");
                    sb.append("/...");
                    schemeSpecificPart = sb.toString();
                }
            } else {
                StringBuilder sb2 = new StringBuilder(64);
                sb2.append(scheme);
                sb2.append(jn1.CONDITION_IF_MIDDLE);
                if (schemeSpecificPart != null) {
                    for (int i = 0; i < schemeSpecificPart.length(); i++) {
                        char charAt = schemeSpecificPart.charAt(i);
                        if (charAt != '-' && charAt != '@' && charAt != '.') {
                            sb2.append('x');
                        } else {
                            sb2.append(charAt);
                        }
                    }
                }
                return sb2.toString();
            }
        }
        StringBuilder sb3 = new StringBuilder(64);
        if (scheme != null) {
            sb3.append(scheme);
            sb3.append(jn1.CONDITION_IF_MIDDLE);
        }
        if (schemeSpecificPart != null) {
            sb3.append(schemeSpecificPart);
        }
        return sb3.toString();
    }
}
