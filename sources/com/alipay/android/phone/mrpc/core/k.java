package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class k {
    public static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    public static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class a {
        public int a;
        public int b;
        public int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static long a(String str) {
        int c;
        int d;
        int i;
        a aVar;
        int i2;
        int i3;
        int i4;
        Matcher matcher = a.matcher(str);
        if (matcher.find()) {
            i = b(matcher.group(1));
            c = c(matcher.group(2));
            d = d(matcher.group(3));
            aVar = e(matcher.group(4));
        } else {
            Matcher matcher2 = b.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            c = c(matcher2.group(1));
            int b2 = b(matcher2.group(2));
            a e = e(matcher2.group(3));
            d = d(matcher2.group(4));
            i = b2;
            aVar = e;
        }
        if (d >= 2038) {
            i2 = 1;
            i3 = 0;
            i4 = 2038;
        } else {
            i2 = i;
            i3 = c;
            i4 = d;
        }
        Time time = new Time("UTC");
        time.set(aVar.c, aVar.b, aVar.a, i2, i3, i4);
        return time.toMillis(false);
    }

    public static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    public static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase != 9) {
            if (lowerCase != 10) {
                if (lowerCase != 22) {
                    if (lowerCase != 26) {
                        if (lowerCase != 29) {
                            if (lowerCase != 32) {
                                if (lowerCase != 40) {
                                    if (lowerCase != 42) {
                                        if (lowerCase != 48) {
                                            switch (lowerCase) {
                                                case 35:
                                                    return 9;
                                                case 36:
                                                    return 4;
                                                case 37:
                                                    return 8;
                                                default:
                                                    throw new IllegalArgumentException();
                                            }
                                        }
                                        return 10;
                                    }
                                    return 5;
                                }
                                return 6;
                            }
                            return 3;
                        }
                        return 2;
                    }
                    return 7;
                }
                return 0;
            }
            return 1;
        }
        return 11;
    }

    public static int d(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        } else if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        } else {
            if (str.length() == 4) {
                return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
            }
            return 1970;
        }
    }

    public static a e(String str) {
        int i;
        int i2;
        int i3;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            i = 2;
            charAt = (charAt * 10) + (str.charAt(1) - '0');
        } else {
            i = 1;
        }
        int i4 = i + 1 + 1 + 1 + 1;
        return new a(charAt, ((str.charAt(i2) - '0') * 10) + (str.charAt(i3) - '0'), ((str.charAt(i4) - '0') * 10) + (str.charAt(i4 + 1) - '0'));
    }
}
