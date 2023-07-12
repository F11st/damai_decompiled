package com.google.zxing;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class FormatException extends ReaderException {
    private static final FormatException instance = new FormatException();

    private FormatException() {
    }

    public static FormatException getFormatInstance() {
        return instance;
    }
}
