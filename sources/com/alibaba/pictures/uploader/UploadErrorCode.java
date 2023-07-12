package com.alibaba.pictures.uploader;

import com.ali.user.open.core.exception.RpcException;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/alibaba/pictures/uploader/UploadErrorCode;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "<init>", "(Ljava/lang/String;II)V", "FAIL", "FAIL_SELF", "FAIL_UN_KNOW", "TIME_OUT", "uploader_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public enum UploadErrorCode {
    FAIL(400),
    FAIL_SELF(401),
    FAIL_UN_KNOW(402),
    TIME_OUT(RpcException.ErrorCode.API_UNAUTHORIZED);
    
    private int value;

    UploadErrorCode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i) {
        this.value = i;
    }
}
