package com.taobao.phenix.compat.mtop;

import com.taobao.phenix.loader.network.NetworkResponseException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopInvalidHostException extends NetworkResponseException {
    public MtopInvalidHostException(int i) {
        super(0, "Invalid Host", i, null);
    }
}
