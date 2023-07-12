package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();
}
