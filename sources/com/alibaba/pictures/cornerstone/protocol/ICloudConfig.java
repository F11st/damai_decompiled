package com.alibaba.pictures.cornerstone.protocol;

import cn.damai.category.categorygirl.ui.GirlShowAllActivity;
import com.taobao.aranger.constant.Constants;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001#J$\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\bH&J,\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000bH&JE\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J$\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0017\u001a\u00020\u0016H&J+\u0010\u001a\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0016H&J\b\u0010\u001d\u001a\u00020\u0016H&J$\u0010!\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u000bH&J\u0012\u0010\"\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006$"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/ICloudConfig;", "", "", GirlShowAllActivity.KEY_GROUPNAME, "key", "", "default", "getInt", "", "getFloat", "expectedValue", "", "isExpected", "T", "Ljava/lang/Class;", "objCls", "getConfigObj", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "getString", "getCustomConfig", "", "getAllConfig", "Ltb/wt2;", "forceCheckUpdate", "", Constants.PARAM_KEYS, "markCacheableKeys", "(Ljava/lang/String;[Ljava/lang/String;)V", "startCheckAndUpdateCacheableKV", "stopCheckAndUpdateCacheableKV", "Lcom/alibaba/pictures/cornerstone/protocol/ICloudConfig$OnGroupUpdateListener;", "listener", "append", "registerGroupConfigUpdateListener", "unRegisterGroupConfigUpdateListener", "OnGroupUpdateListener", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface ICloudConfig {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/ICloudConfig$OnGroupUpdateListener;", "", "", GirlShowAllActivity.KEY_GROUPNAME, "", "args", "Ltb/wt2;", "onUpdate", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public interface OnGroupUpdateListener {
        void onUpdate(@NotNull String str, @NotNull Map<String, String> map);
    }

    void forceCheckUpdate();

    @Nullable
    Map<String, String> getAllConfig(@Nullable String str);

    @Nullable
    <T> T getConfigObj(@Nullable String str, @Nullable String str2, @Nullable Class<T> cls, @Nullable String str3);

    @Nullable
    String getCustomConfig(@Nullable String str, @Nullable String str2);

    float getFloat(@Nullable String str, @Nullable String str2, float f);

    int getInt(@Nullable String str, @Nullable String str2, int i);

    @Nullable
    String getString(@Nullable String str, @Nullable String str2, @Nullable String str3);

    boolean isExpected(@Nullable String str, @Nullable String str2, @NotNull String str3, boolean z);

    void markCacheableKeys(@Nullable String str, @Nullable String[] strArr);

    void registerGroupConfigUpdateListener(@Nullable String str, @Nullable OnGroupUpdateListener onGroupUpdateListener, boolean z);

    void startCheckAndUpdateCacheableKV();

    void stopCheckAndUpdateCacheableKV();

    void unRegisterGroupConfigUpdateListener(@Nullable String str);
}
