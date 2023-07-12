package com.alibaba.pictures.dolores.login;

import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/dolores/login/IDoloresLoginListener;", "", "Ltb/wt2;", "onLoginSuccess", "onLoginFail", "onLoginCancel", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IDoloresLoginListener {
    void onLoginCancel();

    void onLoginFail();

    void onLoginSuccess();
}
