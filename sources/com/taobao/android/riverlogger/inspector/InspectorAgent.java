package com.taobao.android.riverlogger.inspector;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface InspectorAgent {
    void connectionChanged(boolean z);

    Map<String, InspectorCommandHandler> getCommands();

    void sessionClosed(String str);
}
