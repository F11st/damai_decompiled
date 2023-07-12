package com.alibaba.pictures.cornerstone;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/cornerstone/APPClient;", "", "", "clientName", "Ljava/lang/String;", "getClientName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "TPP", "DM", "DENG_TA", "UN_KNOW", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public enum APPClient {
    TPP("tpp"),
    DM("dm"),
    DENG_TA("dengta"),
    UN_KNOW("unknow");
    
    @NotNull
    private final String clientName;

    APPClient(String str) {
        this.clientName = str;
    }

    @NotNull
    public final String getClientName() {
        return this.clientName;
    }
}
