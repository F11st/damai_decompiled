package com.taobao.android.purchase.core.data;

import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface DataManager$ResponseProcessListener {
    void onError(String str, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map);

    void onSuccess(String str, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map);
}
