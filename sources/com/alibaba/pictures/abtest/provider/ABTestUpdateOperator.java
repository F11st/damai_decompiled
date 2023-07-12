package com.alibaba.pictures.abtest.provider;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/abtest/provider/ABTestUpdateOperator;", "", "", "mixUserId", "Ltb/wt2;", "doNotifyUserLogin", "doNotifyUserLogout", "abTest_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface ABTestUpdateOperator {
    void doNotifyUserLogin(@Nullable String str);

    void doNotifyUserLogout();
}
