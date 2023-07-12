package com.taobao.android;

import android.net.Uri;
import android.os.Bundle;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface AliNavInterface {
    Uri createPostUri(String str, JSONObject jSONObject);

    AliNavInterface forResult(int i);

    boolean toUri(Uri uri);

    boolean toUri(String str);

    AliNavInterface withCategory(String str);

    AliNavInterface withExtras(Bundle bundle);

    AliNavInterface withFlags(int i);
}
