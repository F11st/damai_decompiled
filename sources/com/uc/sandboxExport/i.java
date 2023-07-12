package com.uc.sandboxExport;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.uc.sandboxExport.IChildProcessSetup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class i extends IChildProcessSetup.Stub {
    final /* synthetic */ SandboxedProcessService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SandboxedProcessService sandboxedProcessService) {
        this.a = sandboxedProcessService;
    }

    @Override // com.uc.sandboxExport.IChildProcessSetup
    public final IBinder preSetupConnection(Bundle bundle) {
        Intent intent;
        String str;
        ParcelFileDescriptor[] parcelFileDescriptorArr;
        String str2;
        String str3;
        IBinder iBinder;
        String str4;
        Intent intent2;
        intent = this.a.l;
        if (intent.getExtras() == null) {
            str4 = this.a.c;
            com.uc.sandboxExport.helper.c.a(4, str4, "preSetupConnection, mLastIntent has not extras", null);
            intent2 = this.a.l;
            intent2.putExtras(bundle);
            this.a.a();
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("dex.fd");
        Parcelable[] parcelableArray = bundle.getParcelableArray("lib.fd");
        ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) bundle.getParcelable("crash.fd");
        str = this.a.c;
        com.uc.sandboxExport.helper.c.a(str, "preSetupConnection, dex fd: %s", parcelFileDescriptor);
        if (parcelableArray != null) {
            parcelFileDescriptorArr = new ParcelFileDescriptor[parcelableArray.length];
            System.arraycopy(parcelableArray, 0, parcelFileDescriptorArr, 0, parcelableArray.length);
        } else {
            parcelFileDescriptorArr = null;
        }
        try {
            this.a.init(parcelFileDescriptor, parcelFileDescriptorArr, parcelFileDescriptor2);
            str3 = this.a.c;
            com.uc.sandboxExport.helper.c.a(4, str3, "preSetupConnection done.", null);
            iBinder = this.a.j;
            return iBinder;
        } catch (Throwable th) {
            str2 = this.a.c;
            com.uc.sandboxExport.helper.c.a(str2, "preSetupConnection.init exception", th);
            throw th;
        }
    }
}
