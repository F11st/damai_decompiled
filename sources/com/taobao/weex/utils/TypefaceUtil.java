package com.taobao.weex.utils;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.yo0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TypefaceUtil {
    public static final String ACTION_TYPE_FACE_AVAILABLE = "type_face_available";
    public static final String FONT_CACHE_DIR_NAME = "font-family";
    private static final Map<String, FontDO> a = new HashMap();

    public static void applyFontStyle(Paint paint, int i, int i2, String str) {
        Typeface typeface = paint.getTypeface();
        int i3 = 0;
        int style = typeface == null ? 0 : typeface.getStyle();
        if (i2 == 1 || ((style & 1) != 0 && i2 == -1)) {
            i3 = 1;
        }
        if (i == 2 || ((2 & style) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            typeface = getOrCreateTypeface(str, i3);
        }
        if (typeface != null) {
            paint.setTypeface(Typeface.create(typeface, i3));
        } else {
            paint.setTypeface(Typeface.defaultFromStyle(i3));
        }
    }

    private static void d(final String str, final String str2, final String str3) {
        IWXHttpAdapter n = WXSDKManager.v().n();
        if (n == null) {
            WXLogUtils.e("TypefaceUtil", "downloadFontByNetwork() IWXHttpAdapter == null");
            return;
        }
        WXRequest wXRequest = new WXRequest();
        wXRequest.url = str;
        wXRequest.method = "GET";
        n.sendRequest(wXRequest, new IWXHttpAdapter.OnHttpListener() { // from class: com.taobao.weex.utils.TypefaceUtil.1
            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHeadersReceived(int i, Map<String, List<String>> map) {
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onHttpFinish(com.taobao.weex.common.WXResponse r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = r5.statusCode
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    java.lang.String r1 = "TypefaceUtil"
                    r2 = 0
                    if (r0 != 0) goto L28
                    java.lang.String r0 = r5.statusCode     // Catch: java.lang.NumberFormatException -> L12
                    int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L12
                    goto L29
                L12:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r3 = "IWXHttpAdapter onHttpFinish statusCode:"
                    r0.append(r3)
                    java.lang.String r3 = r5.statusCode
                    r0.append(r3)
                    java.lang.String r0 = r0.toString()
                    com.taobao.weex.utils.WXLogUtils.e(r1, r0)
                L28:
                    r0 = 0
                L29:
                    r3 = 200(0xc8, float:2.8E-43)
                    if (r0 < r3) goto L56
                    r3 = 299(0x12b, float:4.19E-43)
                    if (r0 > r3) goto L56
                    byte[] r5 = r5.originalData
                    if (r5 == 0) goto L56
                    java.lang.String r0 = r2
                    android.app.Application r2 = com.taobao.weex.WXEnvironment.getApplication()
                    boolean r2 = com.taobao.weex.utils.WXFileUtils.saveFile(r0, r5, r2)
                    if (r2 == 0) goto L4b
                    java.lang.String r5 = r2
                    java.lang.String r0 = r3
                    r1 = 1
                    boolean r2 = com.taobao.weex.utils.TypefaceUtil.a(r5, r0, r1)
                    goto L56
                L4b:
                    boolean r5 = com.taobao.weex.WXEnvironment.isApkDebugable()
                    if (r5 == 0) goto L56
                    java.lang.String r5 = "downloadFontByNetwork() onHttpFinish success, but save file failed."
                    com.taobao.weex.utils.WXLogUtils.d(r1, r5)
                L56:
                    if (r2 != 0) goto L6a
                    java.util.Map r5 = com.taobao.weex.utils.TypefaceUtil.b()
                    java.lang.String r0 = r3
                    java.lang.Object r5 = r5.get(r0)
                    com.taobao.weex.utils.FontDO r5 = (com.taobao.weex.utils.FontDO) r5
                    if (r5 == 0) goto L6a
                    r0 = 3
                    r5.setState(r0)
                L6a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.utils.TypefaceUtil.AnonymousClass1.onHttpFinish(com.taobao.weex.common.WXResponse):void");
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpResponseProgress(int i) {
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpStart() {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("TypefaceUtil", "downloadFontByNetwork begin url:" + str);
                }
            }

            @Override // com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener
            public void onHttpUploadProgress(int i) {
            }
        });
    }

    private static String e() {
        return WXEnvironment.getApplication().getCacheDir() + "/" + FONT_CACHE_DIR_NAME;
    }

    private static void f(FontDO fontDO, String str) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(WXEnvironment.getApplication().getAssets(), str);
            if (createFromAsset != null) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("TypefaceUtil", "load asset file success");
                }
                fontDO.setState(2);
                fontDO.setTypeface(createFromAsset);
                return;
            }
            WXLogUtils.e("TypefaceUtil", "Font asset file not found " + fontDO.getUrl());
        } catch (Exception e) {
            WXLogUtils.e("TypefaceUtil", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (!new File(str).exists()) {
                    return false;
                }
                Typeface createFromFile = Typeface.createFromFile(str);
                if (createFromFile != null) {
                    final FontDO fontDO = a.get(str2);
                    if (fontDO != null) {
                        fontDO.setState(2);
                        fontDO.setTypeface(createFromFile);
                        fontDO.setFilePath(str);
                        if (WXEnvironment.isApkDebugable()) {
                            WXLogUtils.d("TypefaceUtil", "load local font file success");
                        }
                        if (z) {
                            WXSDKManager.v().G().postOnUiThread(new Runnable() { // from class: com.taobao.weex.utils.TypefaceUtil.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    TypefaceUtil.h(true, FontDO.this);
                                }
                            }, 100L);
                        } else {
                            h(true, fontDO);
                        }
                        return true;
                    }
                } else {
                    WXLogUtils.e("TypefaceUtil", "load local font file failed, can't create font.");
                }
            } catch (Exception e) {
                WXLogUtils.e("TypefaceUtil", e.toString());
            }
        }
        return false;
    }

    public static FontDO getFontDO(String str) {
        return a.get(str);
    }

    public static Typeface getOrCreateTypeface(String str, int i) {
        FontDO fontDO = a.get(str);
        if (fontDO != null && fontDO.getTypeface() != null) {
            return fontDO.getTypeface();
        }
        return Typeface.create(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(boolean z, FontDO fontDO) {
        if (z) {
            Intent intent = new Intent(ACTION_TYPE_FACE_AVAILABLE);
            intent.putExtra(Constants.Name.FONT_FAMILY, fontDO.getFontFamilyName());
            intent.putExtra("filePath", fontDO.getFilePath());
            intent.putExtra("fontUrl", fontDO.getUrl());
            LocalBroadcastManager.getInstance(WXEnvironment.getApplication()).sendBroadcast(intent);
        }
        yo0 m = WXSDKManager.v().m();
        if (m != null) {
            m.b(fontDO.getFontFamilyName(), fontDO.getUrl(), fontDO.getFilePath());
        }
    }

    public static void loadTypeface(FontDO fontDO, boolean z) {
        if (fontDO == null || fontDO.getTypeface() != null || (fontDO.getState() != 3 && fontDO.getState() != 0)) {
            if (z) {
                h(false, fontDO);
                return;
            }
            return;
        }
        fontDO.setState(1);
        if (fontDO.getType() == 3) {
            f(fontDO, Uri.parse(fontDO.getUrl()).getPath().substring(1));
        } else if (fontDO.getType() == 1) {
            String url = fontDO.getUrl();
            String fontFamilyName = fontDO.getFontFamilyName();
            String md5 = WXFileUtils.md5(url);
            File file = new File(e());
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = file.getAbsolutePath() + File.separator + md5;
            if (g(str, fontFamilyName, false)) {
                return;
            }
            d(url, str, fontFamilyName);
        } else if ((fontDO.getType() == 2 || fontDO.getType() == 5) && !g(fontDO.getUrl(), fontDO.getFontFamilyName(), false)) {
            fontDO.setState(3);
        }
    }

    public static void putFontDO(FontDO fontDO) {
        if (fontDO == null || TextUtils.isEmpty(fontDO.getFontFamilyName())) {
            return;
        }
        a.put(fontDO.getFontFamilyName(), fontDO);
    }

    public static void registerNativeFont(Map<String, Typeface> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, Typeface> entry : map.entrySet()) {
            putFontDO(new FontDO(entry.getKey(), entry.getValue()));
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("TypefaceUtil", "register new typeface: " + entry.getKey());
            }
        }
    }

    public static void removeFontDO(String str) {
        a.remove(str);
    }
}
