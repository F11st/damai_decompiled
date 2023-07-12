package com.youku.gaiax.js.support.module;

import android.util.Base64;
import androidx.annotation.Keep;
import com.taobao.orange.util.MD5Util;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import com.youku.gaiax.js.utils.Log;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hi;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/youku/gaiax/js/support/module/GaiaXNativeUtilModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "", "content", "base64Decode", "base64Encode", "urlDecode", "urlEncode", "md5", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXNativeUtilModule extends GaiaXBaseModule {
    @GaiaXSyncMethod
    @NotNull
    public final String base64Decode(@NotNull String str) {
        b41.i(str, "content");
        byte[] bytes = str.getBytes(hi.UTF_8);
        b41.h(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] decode = Base64.decode(bytes, 0);
        b41.h(decode, "decode(content.toByteArray(), Base64.DEFAULT)");
        Charset forName = Charset.forName("utf-8");
        b41.h(forName, "forName(\"utf-8\")");
        String str2 = new String(decode, forName);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("base64Decode() called with: content = " + str + ", result = " + str2);
        }
        return str2;
    }

    @GaiaXSyncMethod
    @NotNull
    public final String base64Encode(@NotNull String str) {
        b41.i(str, "content");
        byte[] bytes = str.getBytes(hi.UTF_8);
        b41.h(bytes, "(this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 0);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("base64Encode() called with: content = " + str + ", result = " + ((Object) encodeToString));
        }
        b41.h(encodeToString, "result");
        return encodeToString;
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "NativeUtil";
    }

    @GaiaXSyncMethod
    @NotNull
    public final String md5(@NotNull String str) {
        b41.i(str, "content");
        String md5 = MD5Util.md5(str);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("md5() called with: content = " + str + ", result = " + ((Object) md5));
        }
        b41.h(md5, "result");
        return md5;
    }

    @GaiaXSyncMethod
    @NotNull
    public final String urlDecode(@NotNull String str) {
        b41.i(str, "content");
        String decode = URLDecoder.decode(str, "utf-8");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("urlDecode() called with: content = " + str + ", result = " + ((Object) decode));
        }
        b41.h(decode, "result");
        return decode;
    }

    @GaiaXSyncMethod
    @NotNull
    public final String urlEncode(@NotNull String str) {
        b41.i(str, "content");
        String encode = URLEncoder.encode(str, "utf-8");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("urlEncode() called with: content = " + str + ", result = " + ((Object) encode));
        }
        b41.h(encode, "result");
        return encode;
    }
}
