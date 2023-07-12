package com.taobao.weex.utils;

import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.adapter.URIAdapter;
import com.taomai.android.h5container.api.TaoMaiFilePlugin;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FontDO {
    public static final int STATE_FAILED = 3;
    public static final int STATE_INIT = 0;
    public static final int STATE_INVALID = -1;
    public static final int STATE_LOADING = 1;
    public static final int STATE_SUCCESS = 2;
    public static final int TYPE_BASE64 = 5;
    public static final int TYPE_FILE = 2;
    public static final int TYPE_LOCAL = 3;
    public static final int TYPE_NATIVE = 4;
    public static final int TYPE_NETWORK = 1;
    public static final int TYPE_UNKNOWN = 0;
    private final String a;
    private String b;
    private String c;
    private int d;
    private Typeface e;
    private int f;

    public FontDO(String str, String str2, WXSDKInstance wXSDKInstance) {
        this.b = "";
        this.d = 1;
        this.f = -1;
        this.a = str;
        a(str2, wXSDKInstance);
    }

    private void a(String str, WXSDKInstance wXSDKInstance) {
        String trim = str != null ? str.trim() : "";
        if (wXSDKInstance != null && wXSDKInstance.getCustomFontNetworkHandler() != null) {
            String fetchLocal = wXSDKInstance.getCustomFontNetworkHandler().fetchLocal(trim);
            if (!TextUtils.isEmpty(fetchLocal)) {
                trim = fetchLocal;
            }
        }
        if (trim.isEmpty()) {
            this.f = -1;
            WXLogUtils.e("TypefaceUtil", "font src is empty.");
            return;
        }
        if (trim.matches("^url\\((('.*')|(\".*\"))\\)$")) {
            Uri parse = Uri.parse(trim.substring(5, trim.length() - 2));
            if (wXSDKInstance != null) {
                parse = wXSDKInstance.rewriteUri(parse, URIAdapter.FONT);
            }
            this.b = parse.toString();
            try {
                String scheme = parse.getScheme();
                if (!"http".equals(scheme) && !"https".equals(scheme)) {
                    if ("file".equals(scheme)) {
                        this.d = 2;
                        this.b = parse.getEncodedSchemeSpecificPart();
                    } else if ("local".equals(scheme)) {
                        this.d = 3;
                    } else if ("data".equals(scheme)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String[] split = this.b.split(",");
                        if (split != null && split.length == 2) {
                            String str2 = split[0];
                            if (!TextUtils.isEmpty(str2) && str2.endsWith(TaoMaiFilePlugin.File_ENCODE_BASE64)) {
                                String str3 = split[1];
                                if (!TextUtils.isEmpty(str3)) {
                                    String md5 = WXFileUtils.md5(str3);
                                    File file = new File(WXEnvironment.getApplication().getCacheDir(), TypefaceUtil.FONT_CACHE_DIR_NAME);
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                    File file2 = new File(file, md5);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                        WXFileUtils.saveFile(file2.getPath(), Base64.decode(str3, 0), WXEnvironment.getApplication());
                                    }
                                    this.b = file2.getPath();
                                    this.d = 5;
                                    WXLogUtils.d("TypefaceUtil", "Parse base64 font cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                                }
                            }
                        }
                    } else {
                        WXLogUtils.e("TypefaceUtil", "Unknown scheme for font url: " + this.b);
                        this.d = 0;
                    }
                    this.f = 0;
                }
                this.d = 1;
                this.f = 0;
            } catch (Exception e) {
                this.d = -1;
                WXLogUtils.e("TypefaceUtil", "URI.create(mUrl) failed mUrl: " + this.b + StringUtils.LF + WXLogUtils.getStackTrace(e));
            }
        } else {
            this.b = trim;
            this.f = -1;
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("TypefaceUtil", "src:" + trim + ", mUrl:" + this.b + ", mType:" + this.d);
        }
    }

    public String getFilePath() {
        return this.c;
    }

    public String getFontFamilyName() {
        return this.a;
    }

    public int getState() {
        return this.f;
    }

    public int getType() {
        return this.d;
    }

    public Typeface getTypeface() {
        return this.e;
    }

    public String getUrl() {
        return this.b;
    }

    public void setFilePath(String str) {
        this.c = str;
    }

    public void setState(int i) {
        this.f = i;
    }

    public void setTypeface(Typeface typeface) {
        this.e = typeface;
    }

    public FontDO(String str, Typeface typeface) {
        this.b = "";
        this.d = 1;
        this.f = -1;
        this.a = str;
        this.e = typeface;
        this.d = 4;
        this.f = 2;
    }
}
