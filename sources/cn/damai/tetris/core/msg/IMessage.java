package cn.damai.tetris.core.msg;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface IMessage extends Serializable {
    void onMessage(int i, Object obj);

    void sendMsg(Message message);
}
