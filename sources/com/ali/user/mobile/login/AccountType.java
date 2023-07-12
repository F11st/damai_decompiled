package com.ali.user.mobile.login;

import com.ali.user.open.core.Site;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public enum AccountType {
    TAOBAO_ACCOUNT("taobao"),
    ICBU_ACCOUNT(Site.ICBU),
    YOUKU_ACCOUNT("youku");
    
    private String type;

    AccountType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }
}
