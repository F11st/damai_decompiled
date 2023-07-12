package com.ali.user.open.cookies;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginCookie {
    public boolean discard;
    public String domain;
    public long expires;
    public boolean httpOnly;
    public String name;
    public String path;
    public boolean secure;
    public String value;
    public String version;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("=");
        sb.append(this.value);
        sb.append("; ");
        sb.append("Domain=");
        sb.append(this.domain);
        if (this.expires > 0) {
            sb.append("; ");
            sb.append("Expires=");
            sb.append(new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.ENGLISH).format(Long.valueOf(this.expires)));
        }
        sb.append("; ");
        sb.append("Path=");
        sb.append(this.path);
        if (!TextUtils.isEmpty(this.version)) {
            sb.append(";");
            sb.append("Version=");
            sb.append(this.version);
        }
        if (this.secure) {
            sb.append("; ");
            sb.append("Secure");
        }
        if (this.httpOnly) {
            sb.append("; ");
            sb.append("HttpOnly");
        }
        if (this.discard) {
            sb.append("; ");
            sb.append("Discard");
        }
        return sb.toString();
    }
}
