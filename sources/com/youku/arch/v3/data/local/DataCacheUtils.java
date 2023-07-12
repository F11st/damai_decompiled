package com.youku.arch.v3.data.local;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nR\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/youku/arch/v3/data/local/DataCacheUtils;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "type", "", "Lcom/youku/arch/v3/data/local/Item;", "getCacheByType", "getAllCaches", "", "id", "getCacheById", "item", "", RemoteMessageConst.Notification.CHANNEL_ID, "", "updateCache", "removeCacheByType", "removeCacheById", "time", "removeCacheByTime", "TAG", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "uri", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DataCacheUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final DataCacheUtils INSTANCE = new DataCacheUtils();
    @NotNull
    private static final String TAG = "OneArch.DataCacheUtils";

    private DataCacheUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0095, code lost:
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0098, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b2, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<com.youku.arch.v3.data.local.Item> getCacheByType(android.content.Context r14, java.lang.String r15) {
        /*
            r13 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.data.local.DataCacheUtils.$ipChange
            java.lang.String r1 = "-360103862"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 3
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L1d
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r6] = r13
            r2[r5] = r14
            r2[r3] = r15
            java.lang.Object r14 = r0.ipc$dispatch(r1, r2)
            java.util.List r14 = (java.util.List) r14
            return r14
        L1d:
            java.lang.String r0 = r13.getUri()
            android.net.Uri r8 = android.net.Uri.parse(r0)
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r9 = 0
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r14.<init>()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r2 = "type='"
            r14.append(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r14.append(r15)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r15 = 39
            r14.append(r15)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r10 = r14.toString()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r11 = 0
            java.lang.String r12 = "timestamp desc"
            android.database.Cursor r0 = r7.query(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r0 == 0) goto L95
            boolean r14 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r14 == 0) goto L95
            int r14 = r0.getCount()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r14 <= 0) goto L95
            r15 = 0
        L5c:
            int r15 = r15 + r5
            com.youku.arch.v3.data.local.Item r2 = new com.youku.arch.v3.data.local.Item     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r2.<init>()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            long r7 = r0.getLong(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r2.id = r7     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r7 = r0.getString(r5)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r2.type = r7     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r7 = r0.getString(r3)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r2.content = r7     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            long r7 = r0.getLong(r4)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r2.time = r7     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r7 = 4
            long r7 = r0.getLong(r7)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r2.expire = r7     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r1.add(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r0.moveToNext()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r15 < r14) goto L5c
        L95:
            if (r0 != 0) goto L98
            goto Lb4
        L98:
            r0.close()
            goto Lb4
        L9c:
            r14 = move-exception
            goto Lb5
        L9e:
            r14 = move-exception
            boolean r15 = com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable()     // Catch: java.lang.Throwable -> L9c
            if (r15 == 0) goto Lb2
            java.lang.String r15 = "OneArch.DataCacheUtils"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> L9c
            r2[r6] = r14     // Catch: java.lang.Throwable -> L9c
            com.youku.arch.v3.util.LogUtil.e(r15, r2)     // Catch: java.lang.Throwable -> L9c
        Lb2:
            if (r0 != 0) goto L98
        Lb4:
            return r1
        Lb5:
            if (r0 != 0) goto Lb8
            goto Lbb
        Lb8:
            r0.close()
        Lbb:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.data.local.DataCacheUtils.getCacheByType(android.content.Context, java.lang.String):java.util.List");
    }

    private final String getUri() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822268612")) {
            return (String) ipChange.ipc$dispatch("822268612", new Object[]{this});
        }
        Context appContext = AppInfoProviderProxy.getAppContext();
        if (appContext != null) {
            return "content://" + ((Object) appContext.getPackageName()) + ".com.youku.arch.data/data_cache";
        }
        return "content://com.taobao.movie.android.com.youku.arch.data/data_cache";
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0087, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a1, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a3, code lost:
        return r1;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.youku.arch.v3.data.local.Item> getAllCaches(@org.jetbrains.annotations.NotNull android.content.Context r13) {
        /*
            r12 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.data.local.DataCacheUtils.$ipChange
            java.lang.String r1 = "2132862997"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1a
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r12
            r2[r4] = r13
            java.lang.Object r13 = r0.ipc$dispatch(r1, r2)
            java.util.List r13 = (java.util.List) r13
            return r13
        L1a:
            java.lang.String r0 = "context"
            tb.b41.i(r13, r0)
            java.lang.String r0 = r12.getUri()
            android.net.Uri r7 = android.net.Uri.parse(r0)
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.content.ContentResolver r6 = r13.getContentResolver()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r8 = 0
            r9 = 0
            java.lang.String[] r10 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.String r11 = "timestamp desc"
            android.database.Cursor r0 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            if (r0 == 0) goto L84
            boolean r13 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            if (r13 == 0) goto L84
            int r13 = r0.getCount()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            if (r13 <= 0) goto L84
            r2 = 0
        L4a:
            int r2 = r2 + r4
            com.youku.arch.v3.data.local.Item r6 = new com.youku.arch.v3.data.local.Item     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.<init>()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            long r7 = r0.getLong(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.id = r7     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.String r7 = r0.getString(r4)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.type = r7     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.String r7 = r0.getString(r3)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.content = r7     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r7 = 3
            long r7 = r0.getLong(r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.time = r7     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r7 = 4
            long r7 = r0.getLong(r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.expire = r7     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r1.add(r6)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r0.moveToNext()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            if (r2 < r13) goto L4a
        L84:
            if (r0 != 0) goto L87
            goto La3
        L87:
            r0.close()
            goto La3
        L8b:
            r13 = move-exception
            goto La4
        L8d:
            r13 = move-exception
            boolean r2 = com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable()     // Catch: java.lang.Throwable -> L8b
            if (r2 == 0) goto La1
            java.lang.String r2 = "OneArch.DataCacheUtils"
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L8b
            java.lang.String r13 = r13.getMessage()     // Catch: java.lang.Throwable -> L8b
            r3[r5] = r13     // Catch: java.lang.Throwable -> L8b
            com.youku.arch.v3.util.LogUtil.e(r2, r3)     // Catch: java.lang.Throwable -> L8b
        La1:
            if (r0 != 0) goto L87
        La3:
            return r1
        La4:
            if (r0 != 0) goto La7
            goto Laa
        La7:
            r0.close()
        Laa:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.data.local.DataCacheUtils.getAllCaches(android.content.Context):java.util.List");
    }

    @Nullable
    public final Item getCacheById(@NotNull Context context, long j) {
        Item item;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386735954")) {
            return (Item) ipChange.ipc$dispatch("1386735954", new Object[]{this, context, Long.valueOf(j)});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Cursor cursor = null;
        r1 = null;
        Item item2 = null;
        cursor = null;
        try {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(getUri()), new String[0], "_id='" + j + '\'', new String[0], "timestamp desc");
                if (query != null) {
                    try {
                        try {
                            if (query.moveToFirst()) {
                                item = new Item();
                                try {
                                    item.id = Long.valueOf(query.getLong(0));
                                    item.type = query.getString(1);
                                    item.content = query.getString(2);
                                    item.time = Long.valueOf(query.getLong(3));
                                    item.expire = Long.valueOf(query.getLong(4));
                                    item.retMsg = query.getString(6);
                                    item.retCode = query.getString(5);
                                    item2 = item;
                                } catch (Exception e) {
                                    e = e;
                                    cursor = query;
                                    if (AppInfoProviderProxy.isDebuggable()) {
                                        LogUtil.e(TAG, e.getMessage());
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return item;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            item = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query == null) {
                    return item2;
                }
                query.close();
                return item2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            item = null;
        }
    }

    public final int removeCacheById(@NotNull Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634604503")) {
            return ((Integer) ipChange.ipc$dispatch("1634604503", new Object[]{this, context, Long.valueOf(j)})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Uri parse = Uri.parse(getUri());
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return contentResolver.delete(parse, "(_id='" + j + "')", new String[0]);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, e.getMessage());
            }
            return -1;
        }
    }

    public final int removeCacheByTime(@NotNull Context context, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011909093")) {
            return ((Integer) ipChange.ipc$dispatch("1011909093", new Object[]{this, context, Long.valueOf(j)})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        Uri parse = Uri.parse(getUri());
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return contentResolver.delete(parse, "(timestamp<'" + j + "')", new String[0]);
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                LogUtil.e(TAG, e.getMessage());
            }
            return -1;
        }
    }

    @Nullable
    public final List<Long> removeCacheByType(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866728222")) {
            return (List) ipChange.ipc$dispatch("866728222", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "type");
        ArrayList arrayList = null;
        List<Item> cacheByType = getCacheByType(context, str);
        if (!cacheByType.isEmpty()) {
            arrayList = new ArrayList(cacheByType.size());
            for (Item item : cacheByType) {
                Long l = item.id;
                b41.h(l, "item.id");
                if (removeCacheById(context, l.longValue()) > 0) {
                    Long l2 = item.id;
                    b41.h(l2, "item.id");
                    arrayList.add(l2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0164 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean updateCache(@org.jetbrains.annotations.NotNull android.content.Context r24, @org.jetbrains.annotations.NotNull com.youku.arch.v3.data.local.Item r25, int r26) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.data.local.DataCacheUtils.updateCache(android.content.Context, com.youku.arch.v3.data.local.Item, int):boolean");
    }
}
