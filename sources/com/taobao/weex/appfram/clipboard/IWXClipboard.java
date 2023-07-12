package com.taobao.weex.appfram.clipboard;

import androidx.annotation.Nullable;
import com.taobao.weex.bridge.JSCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
interface IWXClipboard {
    void getString(@Nullable JSCallback jSCallback);

    void setString(String str);
}
