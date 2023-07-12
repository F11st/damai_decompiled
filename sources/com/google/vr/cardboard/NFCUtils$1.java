package com.google.vr.cardboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class NFCUtils$1 extends BroadcastReceiver {
    final /* synthetic */ d a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        str = d.a;
        Log.i(str, "Got an NFC tag!");
        this.a.b((Tag) intent.getParcelableExtra("android.nfc.extra.TAG"));
    }
}
