package com.google.vr.cardboard;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.sdk.proto.nano.Preferences;
import tb.bz2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b implements VrParamsProvider {
    private static final String f = "b";
    private final ContentProviderClient a;
    private final Uri b;
    private final Uri c;
    private final Uri d;
    private final Uri e;

    public b(ContentProviderClient contentProviderClient, String str) {
        if (contentProviderClient != null) {
            if (str != null && !str.isEmpty()) {
                this.a = contentProviderClient;
                this.b = bz2.a(str, bz2.DEVICE_PARAMS_SETTING);
                this.c = bz2.a(str, bz2.USER_PREFS_SETTING);
                this.d = bz2.a(str, bz2.PHONE_PARAMS_SETTING);
                this.e = bz2.a(str, bz2.SDK_CONFIGURATION_PARAMS_SETTING);
                return;
            }
            throw new IllegalArgumentException("Authority key must be non-null and non-empty");
        }
        throw new IllegalArgumentException("ContentProviderClient must not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T extends com.google.protobuf.nano.MessageNano> T a(T r8, android.net.Uri r9, java.lang.String r10) {
        /*
            r7 = this;
            r0 = 0
            android.content.ContentProviderClient r1 = r7.a     // Catch: java.lang.Throwable -> L55 android.os.RemoteException -> L57 java.lang.IllegalArgumentException -> L59 android.database.CursorIndexOutOfBoundsException -> L5b com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L5d
            r3 = 0
            r5 = 0
            r6 = 0
            r2 = r9
            r4 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L55 android.os.RemoteException -> L57 java.lang.IllegalArgumentException -> L59 android.database.CursorIndexOutOfBoundsException -> L5b com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L5d
            if (r10 == 0) goto L27
            boolean r1 = r10.moveToFirst()     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            if (r1 == 0) goto L27
            r9 = 0
            byte[] r9 = r10.getBlob(r9)     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            if (r9 != 0) goto L1f
            r10.close()
            return r0
        L1f:
            com.google.protobuf.nano.MessageNano r8 = com.google.protobuf.nano.MessageNano.mergeFrom(r8, r9)     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            r10.close()
            return r8
        L27:
            java.lang.String r8 = com.google.vr.cardboard.b.f     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            int r1 = r9.length()     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            int r1 = r1 + 50
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            r2.<init>(r1)     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            java.lang.String r1 = "Invalid params result from ContentProvider query: "
            r2.append(r1)     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            r2.append(r9)     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            java.lang.String r9 = r2.toString()     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            android.util.Log.e(r8, r9)     // Catch: android.os.RemoteException -> L4d java.lang.IllegalArgumentException -> L4f android.database.CursorIndexOutOfBoundsException -> L51 com.google.protobuf.nano.InvalidProtocolBufferNanoException -> L53 java.lang.Throwable -> L6c
            if (r10 == 0) goto L4c
            r10.close()
        L4c:
            return r0
        L4d:
            r8 = move-exception
            goto L5f
        L4f:
            r8 = move-exception
            goto L5f
        L51:
            r8 = move-exception
            goto L5f
        L53:
            r8 = move-exception
            goto L5f
        L55:
            r8 = move-exception
            goto L6e
        L57:
            r8 = move-exception
            goto L5e
        L59:
            r8 = move-exception
            goto L5e
        L5b:
            r8 = move-exception
            goto L5e
        L5d:
            r8 = move-exception
        L5e:
            r10 = r0
        L5f:
            java.lang.String r9 = com.google.vr.cardboard.b.f     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "Error reading params from ContentProvider"
            android.util.Log.e(r9, r1, r8)     // Catch: java.lang.Throwable -> L6c
            if (r10 == 0) goto L6b
            r10.close()
        L6b:
            return r0
        L6c:
            r8 = move-exception
            r0 = r10
        L6e:
            if (r0 == 0) goto L73
            r0.close()
        L73:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.vr.cardboard.b.a(com.google.protobuf.nano.MessageNano, android.net.Uri, java.lang.String):com.google.protobuf.nano.MessageNano");
    }

    private boolean b(MessageNano messageNano, Uri uri) {
        int update;
        try {
            if (messageNano == null) {
                update = this.a.delete(uri, null, null);
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", MessageNano.toByteArray(messageNano));
                update = this.a.update(uri, contentValues, null, null);
            }
            return update > 0;
        } catch (RemoteException e) {
            Log.e(f, "Failed to write params to ContentProvider", e);
            return false;
        } catch (SecurityException e2) {
            Log.e(f, "Insufficient permissions to write params to ContentProvider", e2);
            return false;
        }
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public void close() {
        this.a.release();
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public CardboardDevice.DeviceParams readDeviceParams() {
        return a(new CardboardDevice.DeviceParams(), this.b, null);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Phone.PhoneParams readPhoneParams() {
        return a(new Phone.PhoneParams(), this.d, null);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Vr$VREvent.SdkConfigurationParams readSdkConfigurationParams(com.google.vr.vrcore.nano.a aVar) {
        return a(SdkConfigurationReader.DEFAULT_PARAMS, this.e, Base64.encodeToString(MessageNano.toByteArray(aVar), 0));
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Preferences.UserPrefs readUserPrefs() {
        return a(new Preferences.UserPrefs(), this.c, null);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public boolean updateUserPrefs(Preferences.UserPrefs userPrefs) {
        return b(userPrefs, this.c);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        return b(deviceParams, this.b);
    }
}
