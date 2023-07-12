package com.alibaba.pictures.cornerstone.protocol;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\nH&J\u001a\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH&J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\rH&J\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\rH&J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0010H&J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0010H&J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J;\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&J\"\u0010\u001c\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0010H&J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u001f"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/IKVData;", "", "", "key", "", "default", "getInt", "value", "Ltb/wt2;", "putInt", "", "getFloat", "putFloat", "", "getLong", "putLong", "", "getBoolean", "putBoolean", "getString", "putString", "T", "Ljava/lang/Class;", "objCls", "getConfigObj", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "putConfigObj", "expectedValue", "isExpected", "containsKey", "removeKey", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IKVData {
    boolean containsKey(@Nullable String str);

    boolean getBoolean(@Nullable String str, boolean z);

    @Nullable
    <T> T getConfigObj(@Nullable String str, @Nullable Class<T> cls, @Nullable String str2);

    float getFloat(@Nullable String str, float f);

    int getInt(@Nullable String str, int i);

    long getLong(@Nullable String str, long j);

    @Nullable
    String getString(@Nullable String str, @Nullable String str2);

    boolean isExpected(@Nullable String str, @NotNull String str2, boolean z);

    void putBoolean(@Nullable String str, boolean z);

    void putConfigObj(@Nullable String str, @Nullable Object obj);

    void putFloat(@Nullable String str, float f);

    void putInt(@Nullable String str, int i);

    void putLong(@Nullable String str, long j);

    void putString(@Nullable String str, @Nullable String str2);

    void removeKey(@Nullable String str);
}
