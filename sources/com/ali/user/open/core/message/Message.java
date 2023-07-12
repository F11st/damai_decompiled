package com.ali.user.open.core.message;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes9.dex */
public class Message implements Cloneable {
    public int code;
    public String message;

    public static Message create(int i, Object... objArr) {
        return MessageUtils.createMessage(i, objArr);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
