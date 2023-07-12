package com.taobao.opentracing.impl.exception;

import com.taobao.opentracing.api.propagation.Format;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UnsupportedFormatException extends RuntimeException {
    public UnsupportedFormatException(Format<?> format) {
        super(format.toString());
    }
}
