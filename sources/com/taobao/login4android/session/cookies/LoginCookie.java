package com.taobao.login4android.session.cookies;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginCookie {
    public String domain;
    public long expires;
    public boolean httpOnly;
    public String name;
    public String path;
    public boolean secure;
    public String value;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("=");
        sb.append(this.value);
        sb.append("; ");
        sb.append("Domain=");
        sb.append(this.domain);
        if (this.expires > 0) {
            try {
                sb.append("; ");
                sb.append("Expires=");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                sb.append(simpleDateFormat.format(Long.valueOf(this.expires)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        sb.append("; ");
        sb.append("Path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; ");
            sb.append("Secure");
        }
        if (this.httpOnly) {
            sb.append("; ");
            sb.append("HttpOnly");
        }
        return sb.toString();
    }
}
