package com.taobao.android.purchase.core.utils;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
final class ApiUtils$1 extends HashMap<String, String> {
    final /* synthetic */ String val$itemId;

    ApiUtils$1(String str) {
        this.val$itemId = str;
        put("x-itemid", str);
    }
}
