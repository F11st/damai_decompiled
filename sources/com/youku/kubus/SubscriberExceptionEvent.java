package com.youku.kubus;

import tb.jn1;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes2.dex */
public final class SubscriberExceptionEvent extends Event {
    public final Event causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable th, Event event, Object obj) {
        super("no_subscriber", "NoSubscriberEvent id [" + event.id + "] type [" + event.type + jn1.ARRAY_END_STR);
        this.eventBus = eventBus;
        this.throwable = th;
        this.causingEvent = event;
        this.causingSubscriber = obj;
    }
}
