package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    protected LimitOffsetDataSource(@NonNull RoomDatabase roomDatabase, @NonNull SupportSQLiteQuery supportSQLiteQuery, boolean z, @NonNull String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, strArr);
    }

    private RoomSQLiteQuery getSQLiteQuery(int i, int i2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.mSourceQuery);
        acquire.bindLong(acquire.getArgCount() - 1, i2);
        acquire.bindLong(acquire.getArgCount(), i);
        return acquire;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true)) {
            this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        }
    }

    @NonNull
    protected abstract List<T> convertRows(@NonNull Cursor cursor);

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        acquire.copyArgumentsFrom(this.mSourceQuery);
        Cursor query = this.mDb.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(@NonNull PositionalDataSource.LoadInitialParams loadInitialParams, @NonNull PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        RoomSQLiteQuery roomSQLiteQuery;
        int i;
        RoomSQLiteQuery roomSQLiteQuery2;
        registerObserverIfNecessary();
        List<T> emptyList = Collections.emptyList();
        this.mDb.beginTransaction();
        Cursor cursor = null;
        try {
            int countItems = countItems();
            if (countItems != 0) {
                int computeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, countItems);
                roomSQLiteQuery = getSQLiteQuery(computeInitialLoadPosition, computeInitialLoadSize(loadInitialParams, computeInitialLoadPosition, countItems));
                try {
                    cursor = this.mDb.query(roomSQLiteQuery);
                    List<T> convertRows = convertRows(cursor);
                    this.mDb.setTransactionSuccessful();
                    roomSQLiteQuery2 = roomSQLiteQuery;
                    i = computeInitialLoadPosition;
                    emptyList = convertRows;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.mDb.endTransaction();
                    if (roomSQLiteQuery != null) {
                        roomSQLiteQuery.release();
                    }
                    throw th;
                }
            } else {
                i = 0;
                roomSQLiteQuery2 = null;
            }
            if (cursor != null) {
                cursor.close();
            }
            this.mDb.endTransaction();
            if (roomSQLiteQuery2 != null) {
                roomSQLiteQuery2.release();
            }
            loadInitialCallback.onResult(emptyList, i, countItems);
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = null;
        }
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    protected LimitOffsetDataSource(@NonNull RoomDatabase roomDatabase, @NonNull SupportSQLiteQuery supportSQLiteQuery, boolean z, boolean z2, @NonNull String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, z2, strArr);
    }

    @NonNull
    public List<T> loadRange(int i, int i2) {
        RoomSQLiteQuery sQLiteQuery = getSQLiteQuery(i, i2);
        if (this.mInTransaction) {
            this.mDb.beginTransaction();
            Cursor cursor = null;
            try {
                cursor = this.mDb.query(sQLiteQuery);
                List<T> convertRows = convertRows(cursor);
                this.mDb.setTransactionSuccessful();
                return convertRows;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                this.mDb.endTransaction();
                sQLiteQuery.release();
            }
        }
        Cursor query = this.mDb.query(sQLiteQuery);
        try {
            return convertRows(query);
        } finally {
            query.close();
            sQLiteQuery.release();
        }
    }

    protected LimitOffsetDataSource(@NonNull RoomDatabase roomDatabase, @NonNull RoomSQLiteQuery roomSQLiteQuery, boolean z, @NonNull String... strArr) {
        this(roomDatabase, roomSQLiteQuery, z, true, strArr);
    }

    protected LimitOffsetDataSource(@NonNull RoomDatabase roomDatabase, @NonNull RoomSQLiteQuery roomSQLiteQuery, boolean z, boolean z2, @NonNull String... strArr) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = roomDatabase;
        this.mSourceQuery = roomSQLiteQuery;
        this.mInTransaction = z;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + roomSQLiteQuery.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + roomSQLiteQuery.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.paging.LimitOffsetDataSource.1
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> set) {
                LimitOffsetDataSource.this.invalidate();
            }
        };
        if (z2) {
            registerObserverIfNecessary();
        }
    }
}
