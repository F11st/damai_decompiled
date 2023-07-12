package org.apache.commons.net;

import java.util.EventObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ProtocolCommandEvent extends EventObject {
    private static final long serialVersionUID = 403743538418947240L;
    private final String __command;
    private final boolean __isCommand;
    private final String __message;
    private final int __replyCode;

    public ProtocolCommandEvent(Object obj, String str, String str2) {
        super(obj);
        this.__replyCode = 0;
        this.__message = str2;
        this.__isCommand = true;
        this.__command = str;
    }

    public String getCommand() {
        return this.__command;
    }

    public String getMessage() {
        return this.__message;
    }

    public int getReplyCode() {
        return this.__replyCode;
    }

    public boolean isCommand() {
        return this.__isCommand;
    }

    public boolean isReply() {
        return !isCommand();
    }

    public ProtocolCommandEvent(Object obj, int i, String str) {
        super(obj);
        this.__replyCode = i;
        this.__message = str;
        this.__isCommand = false;
        this.__command = null;
    }
}
