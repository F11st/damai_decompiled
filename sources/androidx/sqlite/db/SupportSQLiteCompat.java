package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SupportSQLiteCompat {

    /* compiled from: Taobao */
    @RequiresApi(16)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api16Impl {
        private Api16Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void cancel(@NonNull CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean deleteDatabase(@NonNull File file) {
            return SQLiteDatabase.deleteDatabase(file);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void disableWriteAheadLogging(@NonNull SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean isWriteAheadLoggingEnabled(@NonNull SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Cursor rawQueryWithFactory(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str, @NonNull String[] strArr, @NonNull String str2, @NonNull CancellationSignal cancellationSignal, @NonNull SQLiteDatabase.CursorFactory cursorFactory) {
            return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setForeignKeyConstraintsEnabled(@NonNull SQLiteDatabase sQLiteDatabase, boolean z) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setWriteAheadLoggingEnabled(@NonNull SQLiteOpenHelper sQLiteOpenHelper, boolean z) {
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api19Impl {
        private Api19Impl() {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Uri getNotificationUri(@NonNull Cursor cursor) {
            return cursor.getNotificationUri();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api21Impl {
        private Api21Impl() {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static File getNoBackupFilesDir(@NonNull Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api23Impl {
        private Api23Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setExtras(@NonNull Cursor cursor, @NonNull Bundle bundle) {
            cursor.setExtras(bundle);
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api29Impl {
        private Api29Impl() {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static List<Uri> getNotificationUris(@NonNull Cursor cursor) {
            return cursor.getNotificationUris();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setNotificationUris(@NonNull Cursor cursor, @NonNull ContentResolver contentResolver, @NonNull List<Uri> list) {
            cursor.setNotificationUris(contentResolver, list);
        }
    }

    private SupportSQLiteCompat() {
    }
}
