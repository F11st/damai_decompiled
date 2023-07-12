package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import org.apache.commons.lang3.CharUtils;
import tb.b90;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class EncodeUtil {
    private static final String a = "EncodeUtil";
    private static final char[] b = {',', '.', '-'};
    private static final String[] c = new String[256];

    static {
        for (char c2 = 0; c2 < 255; c2 = (char) (c2 + 1)) {
            if ((c2 >= '0' && c2 <= '9') || ((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z'))) {
                c[c2] = null;
            } else {
                c[c2] = b(c2).intern();
            }
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(a(cArr, Character.valueOf(str.charAt(i))));
        }
        return sb.toString();
    }

    private static String b(char c2) {
        return Integer.toHexString(c2);
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            a aVar = new a(str);
            while (aVar.a()) {
                Character a2 = a(aVar);
                if (a2 != null) {
                    sb.append(a2);
                } else {
                    sb.append(aVar.d());
                }
            }
            return sb.toString();
        } catch (Exception e) {
            String str2 = a;
            Log.e(str2, "decode js: " + e.getMessage());
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, b);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(cArr, str);
        } catch (Exception e) {
            String str2 = a;
            Log.e(str2, "encode js: " + e.getMessage());
            return "";
        }
    }

    private static String a(char[] cArr, Character ch) {
        if (a(ch.charValue(), cArr)) {
            return "" + ch;
        } else if (a(ch.charValue()) == null) {
            return "" + ch;
        } else {
            String hexString = Integer.toHexString(ch.charValue());
            if (ch.charValue() < 256) {
                return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
            }
            return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
    }

    private static boolean a(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    private static String a(char c2) {
        if (c2 < 255) {
            return c[c2];
        }
        return b(c2);
    }

    private static Character a(a aVar) {
        aVar.c();
        Character d = aVar.d();
        if (d == null) {
            aVar.i();
            return null;
        } else if (d.charValue() != '\\') {
            aVar.i();
            return null;
        } else {
            Character d2 = aVar.d();
            if (d2 == null) {
                aVar.i();
                return null;
            } else if (d2.charValue() == 'b') {
                return '\b';
            } else {
                if (d2.charValue() == 't') {
                    return '\t';
                }
                if (d2.charValue() == 'n') {
                    return '\n';
                }
                if (d2.charValue() == 'v') {
                    return (char) 11;
                }
                if (d2.charValue() == 'f') {
                    return '\f';
                }
                if (d2.charValue() == 'r') {
                    return Character.valueOf(CharUtils.CR);
                }
                if (d2.charValue() == '\"') {
                    return Character.valueOf(jn1.QUOTE);
                }
                if (d2.charValue() == '\'') {
                    return '\'';
                }
                if (d2.charValue() == '\\') {
                    return Character.valueOf(b90.TokenESC);
                }
                int i = 0;
                if (Character.toLowerCase(d2.charValue()) == 'x') {
                    StringBuilder sb = new StringBuilder();
                    while (i < 2) {
                        Character e = aVar.e();
                        if (e != null) {
                            sb.append(e);
                            i++;
                        } else {
                            aVar.i();
                            return null;
                        }
                    }
                    try {
                        int parseInt = Integer.parseInt(sb.toString(), 16);
                        if (Character.isValidCodePoint(parseInt)) {
                            return Character.valueOf((char) parseInt);
                        }
                    } catch (NumberFormatException unused) {
                        aVar.i();
                        return null;
                    }
                } else if (Character.toLowerCase(d2.charValue()) == 'u') {
                    StringBuilder sb2 = new StringBuilder();
                    while (i < 4) {
                        Character e2 = aVar.e();
                        if (e2 != null) {
                            sb2.append(e2);
                            i++;
                        } else {
                            aVar.i();
                            return null;
                        }
                    }
                    try {
                        int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                        if (Character.isValidCodePoint(parseInt2)) {
                            return Character.valueOf((char) parseInt2);
                        }
                    } catch (NumberFormatException unused2) {
                        aVar.i();
                        return null;
                    }
                } else if (a.c(d2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(d2);
                    Character d3 = aVar.d();
                    if (!a.c(d3)) {
                        aVar.a(d3);
                    } else {
                        sb3.append(d3);
                        Character d4 = aVar.d();
                        if (!a.c(d4)) {
                            aVar.a(d4);
                        } else {
                            sb3.append(d4);
                        }
                    }
                    try {
                        int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                        if (Character.isValidCodePoint(parseInt3)) {
                            return Character.valueOf((char) parseInt3);
                        }
                    } catch (NumberFormatException unused3) {
                        aVar.i();
                        return null;
                    }
                }
                return d2;
            }
        }
    }
}
