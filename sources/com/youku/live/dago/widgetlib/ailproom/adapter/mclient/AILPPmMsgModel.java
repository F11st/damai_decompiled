package com.youku.live.dago.widgetlib.ailproom.adapter.mclient;

import com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPPmMsgModel {
    private int count;
    private LinkedBlockingDeque<Map> deque = new LinkedBlockingDeque<>();
    private int interval;
    private AILPMClientProtocol.MsgReceiver receiver;
    private Timer timer;
}
