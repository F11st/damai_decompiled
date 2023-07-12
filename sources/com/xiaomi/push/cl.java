package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.cj;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class cl implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cj.AbstractRunnableC7617a f168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cj.AbstractRunnableC7617a abstractRunnableC7617a, Context context) {
        this.f168a = abstractRunnableC7617a;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f168a.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f168a.a(this.a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        e = e;
                        AbstractC7535b.a(e);
                        this.f168a.a(this.a);
                    }
                }
                ch chVar = this.f168a.f159a;
                if (chVar != null) {
                    chVar.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        AbstractC7535b.a(e2);
                        this.f168a.a(this.a);
                        throw th;
                    }
                }
                ch chVar2 = this.f168a.f159a;
                if (chVar2 != null) {
                    chVar2.close();
                }
                this.f168a.a(this.a);
                throw th;
            }
        } catch (Exception e3) {
            AbstractC7535b.a(e3);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    AbstractC7535b.a(e);
                    this.f168a.a(this.a);
                }
            }
            ch chVar3 = this.f168a.f159a;
            if (chVar3 != null) {
                chVar3.close();
            }
        }
        this.f168a.a(this.a);
    }
}
