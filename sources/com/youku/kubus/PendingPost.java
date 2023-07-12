package com.youku.kubus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class PendingPost {
    private static final List<PendingPost> pendingPostPool = new ArrayList();
    Event event;
    PendingPost next;
    Subscription subscription;

    private PendingPost(Event event, Subscription subscription) {
        this.event = event;
        this.subscription = subscription;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PendingPost obtainPendingPost(Subscription subscription, Event event) {
        List<PendingPost> list = pendingPostPool;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                PendingPost remove = list.remove(size - 1);
                remove.event = event;
                remove.subscription = subscription;
                remove.next = null;
                return remove;
            }
            return new PendingPost(event, subscription);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void releasePendingPost(PendingPost pendingPost) {
        pendingPost.event = null;
        pendingPost.subscription = null;
        pendingPost.next = null;
        List<PendingPost> list = pendingPostPool;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(pendingPost);
            }
        }
    }
}
