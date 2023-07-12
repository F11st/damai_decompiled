package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface CustomCredentialsProvider {
    Task<Token> getTokens(boolean z);
}
