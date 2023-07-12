package com.youku.arch.v3.io;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/io/IMtopResponse;", "Lcom/youku/arch/v3/io/IResponse;", "", "getResponseCode", "()I", "responseCode", "", "getMappingCode", "()Ljava/lang/String;", "mappingCode", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IMtopResponse extends IResponse {
    @Nullable
    String getMappingCode();

    int getResponseCode();
}
