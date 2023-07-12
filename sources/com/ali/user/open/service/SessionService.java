package com.ali.user.open.service;

import com.ali.user.open.core.model.LoginReturnData;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.session.Session;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface SessionService {
    Session getSession();

    Session getSession(String str);

    boolean isSessionValid();

    boolean isSessionValid(String str);

    ResultCode logout(String str);

    void refreshCookie(String str, LoginReturnData loginReturnData);

    void refreshWhenLogin(String str, LoginReturnData loginReturnData);
}
