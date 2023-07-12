package com.ali.user.open.core.service;

import com.ali.user.open.core.callback.MemberCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface OneKeyLoginService {
    void getLoginMaskPhone(MemberCallback<String> memberCallback);

    void oneKeyLogin(Map<String, String> map, MemberCallback<String> memberCallback);
}
