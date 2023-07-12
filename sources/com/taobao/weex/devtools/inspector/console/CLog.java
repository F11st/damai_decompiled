package com.taobao.weex.devtools.inspector.console;

import com.taobao.weex.devtools.common.LogRedirector;
import com.taobao.weex.devtools.inspector.helper.ChromePeerManager;
import com.taobao.weex.devtools.inspector.protocol.module.Console;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CLog {
    private static final String TAG = "CLog";

    public static void writeToConsole(ChromePeerManager chromePeerManager, Console.MessageLevel messageLevel, Console.MessageSource messageSource, String str) {
        LogRedirector.d(TAG, str);
        Console.ConsoleMessage consoleMessage = new Console.ConsoleMessage();
        consoleMessage.source = messageSource;
        consoleMessage.level = messageLevel;
        consoleMessage.text = str;
        Console.MessageAddedRequest messageAddedRequest = new Console.MessageAddedRequest();
        messageAddedRequest.message = consoleMessage;
        chromePeerManager.sendNotificationToPeers("Console.messageAdded", messageAddedRequest);
    }

    public static void writeToConsole(Console.MessageLevel messageLevel, Console.MessageSource messageSource, String str) {
        ConsolePeerManager instanceOrNull = ConsolePeerManager.getInstanceOrNull();
        if (instanceOrNull == null) {
            return;
        }
        writeToConsole(instanceOrNull, messageLevel, messageSource, str);
    }
}
