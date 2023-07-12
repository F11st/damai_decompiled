package com.alibaba.appmonitor.delegate;

import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventRepo;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.sample.C3317a;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;

/* compiled from: Taobao */
/* renamed from: com.alibaba.appmonitor.delegate.b */
/* loaded from: classes15.dex */
public class C3314b {
    private static void a(Transaction transaction) {
        if (transaction == null || transaction.dimensionValues == null) {
            return;
        }
        EventRepo.s().i(transaction.transactionId, transaction.eventId, transaction.module, transaction.monitorPoint, DimensionValueSet.create().addValues(transaction.dimensionValues));
    }

    public static void b(Transaction transaction, String str) {
        try {
            if (C3309a.c && transaction != null) {
                Logger.f("TransactionDelegate", "statEvent begin. module: ", transaction.module, " monitorPoint: ", transaction.monitorPoint, " measureName: ", str);
                EventType eventType = EventType.STAT;
                if (eventType.isOpen()) {
                    if (C3309a.e() || C3317a.h().f(eventType, transaction.module, transaction.monitorPoint)) {
                        EventRepo.s().f(transaction.transactionId, transaction.eventId, transaction.module, transaction.monitorPoint, str);
                        a(transaction);
                    }
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static void c(Transaction transaction, String str) {
        try {
            if (C3309a.c && transaction != null) {
                Logger.f("TransactionDelegate", "statEvent end. module: ", transaction.module, " monitorPoint: ", transaction.monitorPoint, " measureName: ", str);
                EventType eventType = EventType.STAT;
                if (eventType.isOpen()) {
                    if (C3309a.e() || C3317a.h().f(eventType, transaction.module, transaction.monitorPoint)) {
                        a(transaction);
                        EventRepo.s().o(transaction.transactionId, str, false);
                    }
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }
}
