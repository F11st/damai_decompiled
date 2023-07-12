package com.efs.sdk.base.http;

import androidx.annotation.NonNull;
import java.io.File;
import java.util.Map;
import tb.l01;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IHttpUtil {
    @NonNull
    l01 get(String str, Map<String, String> map);

    @NonNull
    l01 post(String str, Map<String, String> map, File file);

    @NonNull
    l01 post(String str, Map<String, String> map, byte[] bArr);

    @NonNull
    l01 postAsFile(String str, Map<String, String> map, byte[] bArr);
}
