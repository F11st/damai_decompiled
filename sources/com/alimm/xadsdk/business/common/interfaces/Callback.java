package com.alimm.xadsdk.business.common.interfaces;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.business.common.model.AdInfo;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface Callback {
    void onFail(int i, String str);

    void onSuccess(@NonNull List<AdInfo> list);
}
