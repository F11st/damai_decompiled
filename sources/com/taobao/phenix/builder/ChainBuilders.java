package com.taobao.phenix.builder;

import android.content.Context;
import tb.be1;
import tb.f62;
import tb.i01;
import tb.li0;
import tb.u90;
import tb.v90;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ChainBuilders {
    Context applicationContext();

    u90 diskCacheBuilder();

    v90 diskCacheKVBuilder();

    li0 fileLoaderBuilder();

    i01 httpLoaderBuilder();

    boolean isGenericTypeCheckEnabled();

    be1 memCacheBuilder();

    f62 schedulerBuilder();
}
