package com.alient.gaiax.container.util;

import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\u0007"}, d2 = {"Lcom/alient/gaiax/container/util/ChannelUtil;", "", "", "isDamaiApp", "isTppApp", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ChannelUtil {
    @NotNull
    public static final ChannelUtil INSTANCE = new ChannelUtil();

    private ChannelUtil() {
    }

    public final boolean isDamaiApp() {
        return b41.d("cn.damai", AppInfoProviderProxy.getPackageName());
    }

    public final boolean isTppApp() {
        return b41.d("com.taobao.movie.android", AppInfoProviderProxy.getPackageName());
    }
}
