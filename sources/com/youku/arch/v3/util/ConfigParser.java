package com.youku.arch.v3.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.analysis.StageType;
import com.vivo.push.PushClientConstants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hi;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/youku/arch/v3/util/ConfigParser;", "T", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/net/Uri;", "uri", "Ljava/lang/Class;", PushClientConstants.TAG_CLASS_NAME, StageType.PARSE, "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/Class;)Ljava/lang/Object;", "<init>", "()V", "Companion", "OneArchContentProvider", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ConfigParser<T> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int BUFFER_SIZE = 8192;
    @NotNull
    private static final String TAG = "OneArch.ConfigParser";
    @Nullable
    private static HashMap<Uri, OneArchContentProvider> contentProvides;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final LruCache<String, Integer> idCaches = new LruCache<>(32);
    @NotNull
    private static final LruCache<Uri, Object> resultCaches = new LruCache<>(32);

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/youku/arch/v3/util/ConfigParser$Companion;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/net/Uri;", "uri", "", "getResId", "Lcom/youku/arch/v3/util/ConfigParser$OneArchContentProvider;", "getContentProvider", "", "getContentByUri", "provider", "Ltb/wt2;", "addContentProvider", "BUFFER_SIZE", "I", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "contentProvides", "Ljava/util/HashMap;", "Landroid/util/LruCache;", "idCaches", "Landroid/util/LruCache;", "resultCaches", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v13, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r0v6, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r0v9 */
        public final String getContentByUri(Context context, Uri uri) {
            InputStream openInputStream;
            int i;
            ?? r0;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1379614385")) {
                return (String) ipChange.ipc$dispatch("-1379614385", new Object[]{this, context, uri});
            }
            OneArchContentProvider contentProvider = getContentProvider(uri);
            String contentByUri = contentProvider != null ? contentProvider.getContentByUri(uri) : null;
            if (contentByUri != null) {
                return contentByUri;
            }
            boolean d = b41.d("android.resource", uri.getScheme());
            if (d) {
                int resId = getResId(context, uri);
                if (resId > 0) {
                    openInputStream = context.getResources().openRawResource(resId);
                    r0 = resId;
                } else {
                    i = resId;
                    if (AppInfoProviderProxy.isDebuggable()) {
                        LogUtil.e(ConfigParser.TAG, b41.r("uri resource not found ", uri));
                        i = "uri resource not found ";
                    }
                    openInputStream = null;
                    r0 = i;
                }
            } else {
                try {
                    openInputStream = context.getContentResolver().openInputStream(uri);
                    r0 = d;
                } catch (FileNotFoundException e) {
                    ?? isDebuggable = AppInfoProviderProxy.isDebuggable();
                    i = isDebuggable;
                    if (isDebuggable != 0) {
                        ?? r02 = {"parseFile " + uri + " FileNotFoundException :" + ((Object) e.getMessage())};
                        LogUtil.e(ConfigParser.TAG, r02);
                        i = r02;
                    }
                }
            }
            if (openInputStream != null) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openInputStream);
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(openInputStream.available());
                    } catch (IOException e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        r0 = 0;
                        FileUtil.closeQuietly(openInputStream);
                        FileUtil.closeQuietly(r0);
                        FileUtil.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[8192];
                        Ref$IntRef ref$IntRef = new Ref$IntRef();
                        ref$IntRef.element = -1;
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            ref$IntRef.element = read;
                            if (read > 0) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                b41.h(byteArray, "rawData");
                                String str = new String(byteArray, hi.UTF_8);
                                FileUtil.closeQuietly(openInputStream);
                                FileUtil.closeQuietly(byteArrayOutputStream);
                                FileUtil.closeQuietly(bufferedInputStream);
                                return str;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        if (AppInfoProviderProxy.isDebuggable()) {
                            e.printStackTrace();
                        }
                        FileUtil.closeQuietly(openInputStream);
                        FileUtil.closeQuietly(byteArrayOutputStream);
                        FileUtil.closeQuietly(bufferedInputStream);
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    FileUtil.closeQuietly(openInputStream);
                    FileUtil.closeQuietly(r0);
                    FileUtil.closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
            return null;
        }

        private final synchronized OneArchContentProvider getContentProvider(Uri uri) {
            OneArchContentProvider oneArchContentProvider;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-407349889")) {
                return (OneArchContentProvider) ipChange.ipc$dispatch("-407349889", new Object[]{this, uri});
            }
            if (ConfigParser.contentProvides != null) {
                HashMap hashMap = ConfigParser.contentProvides;
                b41.f(hashMap);
                if (hashMap.size() != 0) {
                    HashMap hashMap2 = ConfigParser.contentProvides;
                    b41.f(hashMap2);
                    oneArchContentProvider = (OneArchContentProvider) hashMap2.get(uri);
                    return oneArchContentProvider;
                }
            }
            oneArchContentProvider = null;
            return oneArchContentProvider;
        }

        private final int getResId(Context context, Uri uri) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-465160973")) {
                return ((Integer) ipChange.ipc$dispatch("-465160973", new Object[]{this, context, uri})).intValue();
            }
            int i = -1;
            Integer num = (Integer) ConfigParser.idCaches.get(uri.toString());
            if (num != null && num.intValue() > 0) {
                return num.intValue();
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments != null && pathSegments.size() == 2 && (i = context.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), context.getClass().getPackage().getName())) == 0 && (i = context.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), context.getPackageName())) == 0 && AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(ConfigParser.TAG, uri + " is missing!");
            }
            if (i > 0) {
                ConfigParser.idCaches.put(uri.toString(), Integer.valueOf(i));
            }
            return i;
        }

        public final synchronized void addContentProvider(@NotNull Uri uri, @NotNull OneArchContentProvider oneArchContentProvider) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1697750920")) {
                ipChange.ipc$dispatch("1697750920", new Object[]{this, uri, oneArchContentProvider});
                return;
            }
            b41.i(uri, "uri");
            b41.i(oneArchContentProvider, "provider");
            if (ConfigParser.contentProvides == null) {
                ConfigParser.contentProvides = new HashMap(3);
            }
            HashMap hashMap = ConfigParser.contentProvides;
            b41.f(hashMap);
            hashMap.put(uri, oneArchContentProvider);
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/youku/arch/v3/util/ConfigParser$OneArchContentProvider;", "", "Landroid/net/Uri;", "uri", "", "getContentByUri", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface OneArchContentProvider {
        @Nullable
        String getContentByUri(@Nullable Uri uri);
    }

    @Nullable
    public final T parse(@NotNull Context context, @Nullable Uri uri, @Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466790963")) {
            return (T) ipChange.ipc$dispatch("-1466790963", new Object[]{this, context, uri, cls});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (uri != null) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.v(TAG, b41.r("load config form ", uri));
            }
            LruCache<Uri, Object> lruCache = resultCaches;
            T t = (T) lruCache.get(uri);
            if (t != null) {
                return t;
            }
            String contentByUri = Companion.getContentByUri(context, uri);
            if (TextUtils.isEmpty(contentByUri)) {
                return t;
            }
            T t2 = (T) JSON.parseObject(contentByUri, (Type) cls, new Feature[0]);
            lruCache.put(uri, t2);
            return t2;
        }
        return null;
    }
}
