package com.alibaba.pictures.dolores.login;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0002H&J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/dolores/login/IDoloresLoginDelegate;", "", "", "showUI", "Lcom/alibaba/pictures/dolores/login/IDoloresLoginListener;", "loginListener", "Ltb/wt2;", "doLogin", "isSessionValid", "", "api", "registerSession", "doRegisterSessionFail", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IDoloresLoginDelegate {
    void doLogin(boolean z, @NotNull IDoloresLoginListener iDoloresLoginListener);

    void doRegisterSessionFail(@Nullable String str);

    boolean isSessionValid();

    void registerSession(@Nullable String str);
}
