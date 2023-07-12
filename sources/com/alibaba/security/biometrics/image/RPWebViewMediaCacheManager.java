package com.alibaba.security.biometrics.image;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.util.WVConstants;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.security.common.d.e;
import com.alibaba.security.common.d.g;
import com.alibaba.security.common.d.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPWebViewMediaCacheManager {
    public static final String ID_CARD = "id_card";
    public static final String INVALID_KEY = "0";
    private static final String KEY_URL_TIMESTAMP = "t";
    private static final String KEY_URL_TYPE = "type";
    public static final String SKIN = "skin";
    private final String BASE_IMAGE_URL_KEY;
    private HashMap<String, PhotoTair> mImageCache;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static final class HOLDER {
        private static final RPWebViewMediaCacheManager SINGLE = new RPWebViewMediaCacheManager();

        private HOLDER() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class PhotoTair {
        boolean isAssets;
        String md5;
        String path;

        PhotoTair() {
        }
    }

    private String buildImageUrl(String str, String str2) {
        Uri.Builder buildUpon = Uri.parse("//127.0.0.1/wvcache/photo.jpg?_wvcrc=1").buildUpon();
        buildUpon.appendQueryParameter("type", str);
        buildUpon.appendQueryParameter("t", str2);
        return buildUpon.toString();
    }

    private String getCacheDir(Context context) {
        StringBuilder sb;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            sb = new StringBuilder();
            sb.append(externalCacheDir.getAbsolutePath());
            sb.append(File.separator);
        } else {
            File a = e.a(context);
            if (a != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a.getAbsolutePath());
                sb2.append(File.separator);
                sb = sb2;
            } else {
                sb = null;
            }
        }
        if (!TextUtils.isEmpty("caches") && sb != null) {
            sb.append("caches");
            sb.append(File.separator);
            sb.append(WVConstants.IMAGE_CACHE_FOLDER);
        }
        return sb.toString();
    }

    private FileInputStream getIdCardInputStream(Context context, String str) {
        String removeScheme = removeScheme(str);
        try {
            return new FileInputStream(new File(getCacheDir(context) + File.separator + j.b(removeScheme)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static RPWebViewMediaCacheManager getInstance() {
        return HOLDER.SINGLE;
    }

    private InputStream getSkinInputStream(Context context, String str, String str2) {
        PhotoTair photoTair;
        if (!this.mImageCache.isEmpty() && (photoTair = this.mImageCache.get(str2)) != null && photoTair.path != null) {
            try {
                if (photoTair.isAssets) {
                    return context.getAssets().open(photoTair.path);
                }
                return new FileInputStream(photoTair.path);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private String getVirtualImageKey(String str, String str2) {
        return buildImageUrl(str, str2);
    }

    private boolean isWebviewCacheEnabled(String str) {
        if (str.contains(WVConstants.LOCAL_CACHE_TAG)) {
            Uri parse = Uri.parse(str);
            return (parse != null && parse.isHierarchical() && TextUtils.isEmpty(parse.getQueryParameter(WVConstants.LOCAL_CACHE_TAG)) && "0".equals(parse.getQueryParameter(WVConstants.LOCAL_CACHE_TAG))) ? false : true;
        }
        return false;
    }

    private String removeScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String replace = str.startsWith("http:") ? str.replace("http:", "") : null;
        if (str.startsWith("https:")) {
            replace = str.replace("https:", "");
        }
        return TextUtils.isEmpty(replace) ? str : replace;
    }

    private Pair<String, String> saveBitmapToCache(Context context, File file) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String virtualImageKey = getVirtualImageKey(ID_CARD, valueOf);
        File file2 = new File(getCacheDir(context), j.b(getVirtualImageKey(ID_CARD, valueOf)));
        if (file != null && file.exists() && e.a(file, file2)) {
            return new Pair<>(valueOf, virtualImageKey);
        }
        return new Pair<>("0", virtualImageKey);
    }

    void clear() {
        synchronized (this.mImageCache) {
            this.mImageCache.clear();
        }
    }

    public InputStream genWebViewMediaStream(Context context, String str) {
        if (isWebviewCacheEnabled(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("type");
                String queryParameter2 = parse.getQueryParameter("t");
                if (TextUtils.isEmpty(queryParameter)) {
                    return null;
                }
                if (queryParameter.equals(ID_CARD)) {
                    return getIdCardInputStream(context, str);
                }
                if (queryParameter.equals("skin")) {
                    return getSkinInputStream(context, str, queryParameter2);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String get(String str) {
        synchronized (this.mImageCache) {
            if (this.mImageCache.containsKey(str)) {
                return this.mImageCache.get(str).path;
            }
            return null;
        }
    }

    public String getMd5(String str) {
        synchronized (this.mImageCache) {
            if (this.mImageCache.containsKey(str)) {
                return this.mImageCache.get(str).md5;
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Pair<String, String> putIdCardImage(Context context, String str) {
        Pair<String, String> saveBitmapToCache;
        synchronized (this.mImageCache) {
            File file = new File(str);
            saveBitmapToCache = saveBitmapToCache(context, file);
            String a = j.a(file);
            PhotoTair photoTair = new PhotoTair();
            photoTair.md5 = a;
            photoTair.path = str;
            photoTair.isAssets = false;
            this.mImageCache.put(saveBitmapToCache.first, photoTair);
        }
        return saveBitmapToCache;
    }

    public Pair<String, String> putSkinImage(Context context, String str, boolean z) {
        Pair<String, String> pair;
        synchronized (this.mImageCache) {
            PhotoTair photoTair = new PhotoTair();
            photoTair.path = str;
            photoTair.isAssets = z;
            this.mImageCache.put(str, photoTair);
            pair = new Pair<>(str, getVirtualImageKey("skin", str));
        }
        return pair;
    }

    void remove(String str) {
        synchronized (this.mImageCache) {
            if (this.mImageCache.containsKey(str)) {
                return;
            }
            this.mImageCache.remove(str);
        }
    }

    private RPWebViewMediaCacheManager() {
        this.BASE_IMAGE_URL_KEY = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1";
        this.mImageCache = new HashMap<>();
    }

    public String putIdCardImage(Context context, String str, String str2) {
        synchronized (this.mImageCache) {
            String a = g.a(context, str2, str);
            if (a != null) {
                String valueOf = String.valueOf((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                String a2 = j.a(new File(a));
                if (a2 == null) {
                    return "0";
                }
                PhotoTair photoTair = new PhotoTair();
                photoTair.md5 = a2;
                photoTair.path = a;
                this.mImageCache.put(valueOf, photoTair);
                return valueOf;
            }
            return "0";
        }
    }
}
