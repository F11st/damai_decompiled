package com.taobao.android.ultron.datamodel;

import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IRequestCallback {
    void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map);

    void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map);
}
