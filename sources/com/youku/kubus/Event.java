package com.youku.kubus;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes2.dex */
public class Event {
    public String channel;
    private volatile boolean consumed;
    public Object data;
    public final long id;
    public String message;
    public Object target;
    public String type;

    public Event() {
        this("kubus://general");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void consume() {
        if (this.consumed) {
            return;
        }
        synchronized (this) {
            if (!this.consumed) {
                this.consumed = true;
            }
        }
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public Event(String str) {
        this(str, null);
    }

    public Event(String str, String str2) {
        this.id = IdGenerator.getId();
        this.type = str;
        this.message = str2;
    }
}
