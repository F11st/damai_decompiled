package com.youku.arch.v3.data.local;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.actions.SearchIntents;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016JE\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J-\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/youku/arch/v3/data/local/DataCacheProvider;", "Landroid/content/ContentProvider;", "", "onCreate", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", SearchIntents.EXTRA_QUERY, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "Landroid/content/ContentValues;", "values", "insert", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Lcom/youku/arch/v3/data/local/CacheDBHelper;", "dbHelper", "Lcom/youku/arch/v3/data/local/CacheDBHelper;", "getDbHelper", "()Lcom/youku/arch/v3/data/local/CacheDBHelper;", "setDbHelper", "(Lcom/youku/arch/v3/data/local/CacheDBHelper;)V", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DataCacheProvider extends ContentProvider {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String AUTHORITY = ".com.youku.arch.data";
    private static final int CACHE = 1;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final UriMatcher MATCHER = new UriMatcher(-1);
    @NotNull
    private static final String TABLE_NAME = "data_cache";
    @NotNull
    private static final String TAG = "OneArch.DataCache";
    @Nullable
    private CacheDBHelper dbHelper;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/youku/arch/v3/data/local/DataCacheProvider$Companion;", "", "", "AUTHORITY", "Ljava/lang/String;", "", "CACHE", "I", "Landroid/content/UriMatcher;", "MATCHER", "Landroid/content/UriMatcher;", "TABLE_NAME", "TAG", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @NotNull String str, @NotNull String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1033586232")) {
            return ((Integer) ipChange.ipc$dispatch("1033586232", new Object[]{this, uri, str, strArr})).intValue();
        }
        b41.i(uri, "uri");
        b41.i(str, "selection");
        b41.i(strArr, "selectionArgs");
        CacheDBHelper cacheDBHelper = this.dbHelper;
        b41.f(cacheDBHelper);
        SQLiteDatabase writableDatabase = cacheDBHelper.getWritableDatabase();
        if (MATCHER.match(uri) == 1) {
            return writableDatabase.delete(TABLE_NAME, str, strArr);
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.e(TAG, b41.r("Unknown Uri:", uri));
            return 0;
        }
        return 0;
    }

    @Nullable
    public final CacheDBHelper getDbHelper() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1589521101") ? (CacheDBHelper) ipChange.ipc$dispatch("1589521101", new Object[]{this}) : this.dbHelper;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462758961")) {
            return (String) ipChange.ipc$dispatch("1462758961", new Object[]{this, uri});
        }
        b41.i(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @NotNull
    public Uri insert(@NotNull Uri uri, @NotNull ContentValues contentValues) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882814891")) {
            return (Uri) ipChange.ipc$dispatch("-882814891", new Object[]{this, uri, contentValues});
        }
        b41.i(uri, "uri");
        b41.i(contentValues, "values");
        CacheDBHelper cacheDBHelper = this.dbHelper;
        b41.f(cacheDBHelper);
        SQLiteDatabase writableDatabase = cacheDBHelper.getWritableDatabase();
        Uri uri2 = null;
        if (MATCHER.match(uri) == 1) {
            long insert = writableDatabase.insert(TABLE_NAME, null, contentValues);
            if (insert != -1) {
                Uri withAppendedId = ContentUris.withAppendedId(uri, insert);
                getContext().getContentResolver().notifyChange(uri, null);
                uri2 = withAppendedId;
            }
        } else if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.e(TAG, b41.r("Unknown Uri:", uri));
        }
        b41.f(uri2);
        return uri2;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145204213")) {
            return ((Boolean) ipChange.ipc$dispatch("-145204213", new Object[]{this})).booleanValue();
        }
        if (getContext() != null) {
            MATCHER.addURI(b41.r(getContext().getPackageName(), AUTHORITY), TABLE_NAME, 1);
        }
        this.dbHelper = new CacheDBHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @NotNull String[] strArr, @NotNull String str, @NotNull String[] strArr2, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893566706")) {
            return (Cursor) ipChange.ipc$dispatch("-1893566706", new Object[]{this, uri, strArr, str, strArr2, str2});
        }
        b41.i(uri, "uri");
        b41.i(strArr, "projection");
        b41.i(str, "selection");
        b41.i(strArr2, "selectionArgs");
        b41.i(str2, "sortOrder");
        CacheDBHelper cacheDBHelper = this.dbHelper;
        SQLiteDatabase writableDatabase = cacheDBHelper == null ? null : cacheDBHelper.getWritableDatabase();
        if (MATCHER.match(uri) != 1 || writableDatabase == null) {
            return null;
        }
        return writableDatabase.query(TABLE_NAME, strArr, str, strArr2, null, null, str2);
    }

    public final void setDbHelper(@Nullable CacheDBHelper cacheDBHelper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-297397129")) {
            ipChange.ipc$dispatch("-297397129", new Object[]{this, cacheDBHelper});
        } else {
            this.dbHelper = cacheDBHelper;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @NotNull ContentValues contentValues, @NotNull String str, @NotNull String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891836090")) {
            return ((Integer) ipChange.ipc$dispatch("1891836090", new Object[]{this, uri, contentValues, str, strArr})).intValue();
        }
        b41.i(uri, "uri");
        b41.i(contentValues, "values");
        b41.i(str, "selection");
        b41.i(strArr, "selectionArgs");
        CacheDBHelper cacheDBHelper = this.dbHelper;
        b41.f(cacheDBHelper);
        SQLiteDatabase writableDatabase = cacheDBHelper.getWritableDatabase();
        if (MATCHER.match(uri) == 1) {
            return writableDatabase.update(TABLE_NAME, contentValues, str, strArr);
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.e(TAG, b41.r("Unknown Uri:", uri));
            return 0;
        }
        return 0;
    }
}
