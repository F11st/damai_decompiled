package com.alibaba.pictures.cornerstone;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/cornerstone/IAppBaseInfoProvider;", "", "", "getAppKey", "Lcom/alibaba/pictures/cornerstone/EnvMode;", "getEnv", "getTTID", "getChannelId", "key", "getExtraInfo", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IAppBaseInfoProvider {
    @Nullable
    String getAppKey();

    @Nullable
    String getChannelId();

    @Nullable
    EnvMode getEnv();

    @Nullable
    String getExtraInfo(@Nullable String str);

    @Nullable
    String getTTID();
}
