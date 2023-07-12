package com.alibaba.aliweex.adapter;

import android.content.Context;
import com.taobao.weex.bridge.JSCallback;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IUserModuleAdapter {
    void getUserInfo(Context context, JSCallback jSCallback);

    void login(Context context, JSCallback jSCallback);

    void logout(Context context, JSCallback jSCallback);
}
