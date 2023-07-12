package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public class MustOverrideException extends RuntimeException {
    public MustOverrideException() {
        super("abstract function called: must be overriden!");
    }
}
