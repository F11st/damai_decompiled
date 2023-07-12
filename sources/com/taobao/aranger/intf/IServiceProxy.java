package com.taobao.aranger.intf;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public interface IServiceProxy {
    void create(String str, Object... objArr) throws Exception;

    Object invoke(String str, Object[] objArr) throws Exception;
}
