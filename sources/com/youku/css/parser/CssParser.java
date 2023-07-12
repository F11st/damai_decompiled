package com.youku.css.parser;

import android.text.TextUtils;
import com.youku.css.binder.CssBinder;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Css;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CssParser {
    private static final String regColor = "^(scene)+|(Text)*(Color)$";
    private static final Pattern patternColor = Pattern.compile(regColor);
    private static final String regBgColor = "(Bg)$";
    private static final Pattern patternBgColor = Pattern.compile(regBgColor);

    public static synchronized CssBinder parseCss(Map map) {
        synchronized (CssParser.class) {
            if (map == null) {
                return null;
            }
            long j = 0L;
            String str = map.containsKey("tag") ? (String) map.get("tag") : "";
            if (map.containsKey("updateTime")) {
                if (map.get("updateTime") instanceof Long) {
                    j = (Long) map.get("updateTime");
                } else if (map.get("updateTime") instanceof String) {
                    j = Long.valueOf(Long.parseLong((String) map.get("updateTime")));
                }
            }
            try {
                return new CssBinder(str, parseCss(map, new ConcurrentHashMap()), j);
            } catch (Exception unused) {
                return new CssBinder(str, new HashMap(1), j);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r2 == 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
        r1.color = (java.lang.String) r7.getValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void putCssMap(java.util.Map<java.lang.String, com.youku.css.dto.Css> r6, java.util.Map.Entry<java.lang.String, java.lang.Object> r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.Class<com.youku.css.parser.CssParser> r0 = com.youku.css.parser.CssParser.class
            monitor-enter(r0)
            r1 = 0
            if (r6 == 0) goto L15
            boolean r2 = r6.containsKey(r8)     // Catch: java.lang.Throwable -> L13
            if (r2 == 0) goto L15
            java.lang.Object r1 = r6.get(r8)     // Catch: java.lang.Throwable -> L13
            com.youku.css.dto.Css r1 = (com.youku.css.dto.Css) r1     // Catch: java.lang.Throwable -> L13
            goto L15
        L13:
            r6 = move-exception
            goto L60
        L15:
            if (r1 != 0) goto L1c
            com.youku.css.dto.Css r1 = new com.youku.css.dto.Css     // Catch: java.lang.Throwable -> L13
            r1.<init>()     // Catch: java.lang.Throwable -> L13
        L1c:
            r2 = -1
            int r3 = r9.hashCode()     // Catch: java.lang.Throwable -> L13
            r4 = 94842723(0x5a72f63, float:1.5722012E-35)
            r5 = 1
            if (r3 == r4) goto L37
            r4 = 1287124693(0x4cb7f6d5, float:9.6450216E7)
            if (r3 == r4) goto L2d
            goto L40
        L2d:
            java.lang.String r3 = "backgroundColor"
            boolean r9 = r9.equals(r3)     // Catch: java.lang.Throwable -> L13
            if (r9 == 0) goto L40
            r2 = 0
            goto L40
        L37:
            java.lang.String r3 = "color"
            boolean r9 = r9.equals(r3)     // Catch: java.lang.Throwable -> L13
            if (r9 == 0) goto L40
            r2 = 1
        L40:
            if (r2 == 0) goto L4e
            if (r2 == r5) goto L45
            goto L56
        L45:
            java.lang.Object r7 = r7.getValue()     // Catch: java.lang.Throwable -> L13
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L13
            r1.color = r7     // Catch: java.lang.Throwable -> L13
            goto L56
        L4e:
            java.lang.Object r7 = r7.getValue()     // Catch: java.lang.Throwable -> L13
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L13
            r1.backgroundColor = r7     // Catch: java.lang.Throwable -> L13
        L56:
            java.lang.String r7 = "css"
            android.util.Log.d(r7, r8)     // Catch: java.lang.Throwable -> L13
            r6.put(r8, r1)     // Catch: java.lang.Throwable -> L13
            monitor-exit(r0)
            return
        L60:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.css.parser.CssParser.putCssMap(java.util.Map, java.util.Map$Entry, java.lang.String, java.lang.String):void");
    }

    public static synchronized Map<String, Css> parseCss(Map map, Map<String, Css> map2) {
        synchronized (CssParser.class) {
            if (map != null) {
                if (!map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        Object value = entry.getValue();
                        if (value != null && (!(value instanceof String) || !TextUtils.isEmpty((String) value))) {
                            String str = (String) entry.getKey();
                            Pattern pattern = patternColor;
                            String[] split = pattern.split(str);
                            if (pattern.matcher(str).find() && split.length == 2) {
                                String str2 = split[1];
                                Pattern pattern2 = patternBgColor;
                                if (pattern2.matcher(str2).find()) {
                                    String[] split2 = pattern2.split(str2);
                                    if (split2.length > 0) {
                                        if (map2 == null) {
                                            map2 = new ConcurrentHashMap<>(32);
                                        }
                                        putCssMap(map2, entry, split2[0], "backgroundColor");
                                    } else {
                                        if (map2 == null) {
                                            map2 = new ConcurrentHashMap<>(32);
                                        }
                                        putCssMap(map2, entry, CssConst.CssScenes.VIEW, "backgroundColor");
                                    }
                                } else {
                                    if (map2 == null) {
                                        map2 = new ConcurrentHashMap<>(32);
                                    }
                                    putCssMap(map2, entry, str2, "color");
                                }
                            }
                        }
                    }
                    return map2;
                }
            }
            return null;
        }
    }
}
