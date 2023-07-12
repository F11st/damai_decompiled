package com.alibaba.pictures.dolores.cache;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.af;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J&\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\rH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0011"}, d2 = {"Lcom/alibaba/pictures/dolores/cache/ICacheManager;", "", "", "key", "", "needEncrypt", "Ltb/af;", "obtain", "value", "save", "remove", "", "getCachedTime", "Ltb/wt2;", "updateCachedTime", "clearCache", "getCacheFileName", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface ICacheManager {
    void clearCache();

    @Nullable
    String getCacheFileName();

    long getCachedTime(@Nullable String str);

    @Nullable
    af obtain(@Nullable String str, boolean z);

    @Nullable
    String remove(@Nullable String str);

    @Nullable
    String save(@Nullable String str, @Nullable String str2, boolean z);

    void updateCachedTime(@Nullable String str, long j);
}
