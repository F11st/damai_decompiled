package com.youku.gaiax.impl.register.remote;

import android.content.Context;
import android.util.Base64;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.e;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.zi0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteCacheUtils;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "getCacheRootPath", "getCachePath", "fileName", "Ljava/io/File;", "genTemplateFile", "binaryData", "writeToSD", "GAIAX_TEMPLATE_DIR", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXRemoteCacheUtils {
    @NotNull
    private static final String GAIAX_TEMPLATE_DIR = "gaiax_templates";
    @NotNull
    public static final GaiaXRemoteCacheUtils INSTANCE = new GaiaXRemoteCacheUtils();

    private GaiaXRemoteCacheUtils() {
    }

    private final String getCacheRootPath(Context context) {
        try {
            File externalCacheDir = context.getExternalCacheDir();
            String absolutePath = externalCacheDir == null ? null : externalCacheDir.getAbsolutePath();
            if (absolutePath == null) {
                absolutePath = context.getCacheDir().getAbsolutePath();
            }
            b41.h(absolutePath, "{\n            context.ex…ir.absolutePath\n        }");
            return absolutePath;
        } catch (Exception e) {
            e.printStackTrace();
            String absolutePath2 = context.getCacheDir().getAbsolutePath();
            b41.h(absolutePath2, "{\n            e.printSta…ir.absolutePath\n        }");
            return absolutePath2;
        }
    }

    @NotNull
    public final File genTemplateFile(@NotNull String str) {
        b41.i(str, "fileName");
        return new File(getCachePath(), str);
    }

    @NotNull
    public final String getCachePath() {
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        Context applicationContext = app2 == null ? null : app2.applicationContext();
        if (applicationContext != null) {
            String absolutePath = new File(getCacheRootPath(applicationContext), GAIAX_TEMPLATE_DIR).getAbsolutePath();
            b41.h(absolutePath, "File(getCacheRootPath(co…EMPLATE_DIR).absolutePath");
            return absolutePath;
        }
        String absolutePath2 = new File(GAIAX_TEMPLATE_DIR).getAbsolutePath();
        b41.h(absolutePath2, "File(GAIAX_TEMPLATE_DIR).absolutePath");
        return absolutePath2;
    }

    @NotNull
    public final String writeToSD(@NotNull String str) {
        File file;
        b41.i(str, "binaryData");
        if (!(str.length() == 0)) {
            byte[] decode = Base64.decode(str, 0);
            if (decode != null) {
                String uuid = UUID.randomUUID().toString();
                b41.h(uuid, "randomUUID().toString()");
                File genTemplateFile = genTemplateFile(uuid);
                if (genTemplateFile.exists()) {
                    genTemplateFile.delete();
                }
                zi0.a(genTemplateFile, decode);
                if (genTemplateFile.exists()) {
                    if (genTemplateFile.length() > 0) {
                        String uuid2 = UUID.randomUUID().toString();
                        b41.h(uuid2, "randomUUID().toString()");
                        File genTemplateFile2 = genTemplateFile(uuid2);
                        if (genTemplateFile2.exists()) {
                            genTemplateFile2.delete();
                        }
                        GaiaXRemoteUnzipUtils gaiaXRemoteUnzipUtils = GaiaXRemoteUnzipUtils.INSTANCE;
                        String absolutePath = genTemplateFile2.getAbsolutePath();
                        b41.h(absolutePath, "unzipFile.absolutePath");
                        gaiaXRemoteUnzipUtils.unzip(genTemplateFile, absolutePath);
                        genTemplateFile.delete();
                        if (genTemplateFile2.isDirectory() && genTemplateFile2.exists()) {
                            File[] listFiles = genTemplateFile2.listFiles();
                            String str2 = null;
                            if (listFiles != null && (file = (File) e.v(listFiles)) != null) {
                                str2 = file.getAbsolutePath();
                            }
                            if (str2 != null) {
                                return str2;
                            }
                            throw new IllegalArgumentException("writeToSD unzip file is empty");
                        }
                    } else {
                        genTemplateFile.delete();
                    }
                    throw new IllegalArgumentException("writeToSD template file length is zero");
                }
                throw new IllegalArgumentException("writeToSD template file write bytes is fail");
            }
            throw new IllegalArgumentException("writeToSD Base64.decode binary data is null");
        }
        throw new IllegalArgumentException("writeToSD binary data is empty");
    }
}
