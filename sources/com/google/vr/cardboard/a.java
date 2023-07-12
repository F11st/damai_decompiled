package com.google.vr.cardboard;

import android.os.Environment;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import tb.bz2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public static final String CARDBOARD_CONFIG_FOLDER = "Cardboard";
    public static final String URI_KEY_PARAMS = "p";
    private static final String a = "a";

    private static File a(String str) throws IllegalStateException {
        File file = new File(Environment.getExternalStorageDirectory(), CARDBOARD_CONFIG_FOLDER);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            String valueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(valueOf.length() + 61);
            sb.append(valueOf);
            sb.append(" already exists as a file, but is expected to be a directory.");
            throw new IllegalStateException(sb.toString());
        }
        return new File(file, str);
    }

    public static CardboardDevice.DeviceParams b() {
        return c(CardboardDevice.DeviceParams.class, "current_device_params", 894990891, true);
    }

    private static <T extends MessageNano> T c(Class<T> cls, String str, int i, boolean z) {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(a(str)));
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
            try {
                T t = (T) d(cls, bufferedInputStream, i);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                return t;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                try {
                    throw th;
                } catch (FileNotFoundException e) {
                    if (z) {
                        String str2 = a;
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 39);
                        sb.append("Parameters file not found for reading: ");
                        sb.append(valueOf);
                        Log.d(str2, sb.toString());
                    }
                    return null;
                }
            }
        } catch (IllegalStateException e2) {
            String str3 = a;
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 26);
            sb2.append("Error reading parameters: ");
            sb2.append(valueOf2);
            Log.w(str3, sb2.toString());
            return null;
        }
    }

    private static <T extends MessageNano> T d(Class<T> cls, InputStream inputStream, int i) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            if (inputStream.read(allocate.array(), 0, allocate.array().length) == -1) {
                Log.e(a, "Error parsing param record: end of stream.");
                return null;
            }
            int i2 = allocate.getInt();
            int i3 = allocate.getInt();
            if (i2 != i) {
                Log.e(a, "Error parsing param record: incorrect sentinel.");
                return null;
            }
            byte[] bArr = new byte[i3];
            if (inputStream.read(bArr, 0, i3) == -1) {
                Log.e(a, "Error parsing param record: end of stream.");
                return null;
            }
            return (T) MessageNano.mergeFrom(cls.newInstance(), bArr);
        } catch (InstantiationException e) {
            String str = a;
            String valueOf = String.valueOf(e.toString());
            Log.w(str, valueOf.length() != 0 ? "Error creating parameters: ".concat(valueOf) : new String("Error creating parameters: "));
            return null;
        } catch (InvalidProtocolBufferNanoException e2) {
            String str2 = a;
            String valueOf2 = String.valueOf(e2.toString());
            Log.w(str2, valueOf2.length() != 0 ? "Error parsing protocol buffer: ".concat(valueOf2) : new String("Error parsing protocol buffer: "));
            return null;
        } catch (IOException e3) {
            String str3 = a;
            String valueOf3 = String.valueOf(e3.toString());
            Log.w(str3, valueOf3.length() != 0 ? "Error reading parameters: ".concat(valueOf3) : new String("Error reading parameters: "));
            return null;
        } catch (IllegalAccessException e4) {
            String str4 = a;
            String valueOf4 = String.valueOf(e4.toString());
            Log.w(str4, valueOf4.length() != 0 ? "Error accessing parameter type: ".concat(valueOf4) : new String("Error accessing parameter type: "));
            return null;
        }
    }

    public static Phone.PhoneParams e() {
        return c(Phone.PhoneParams.class, bz2.PHONE_PARAMS_SETTING, 779508118, false);
    }

    public static boolean f() {
        boolean z;
        try {
            File a2 = a("current_device_params");
            z = a2.exists() ? a2.delete() : true;
        } catch (IllegalStateException e) {
            String str = a;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 34);
            sb.append("Error clearing device parameters: ");
            sb.append(valueOf);
            Log.w(str, sb.toString());
            z = false;
        }
        if (!z) {
            Log.e(a, "Could not clear Cardboard parameters from external storage.");
        }
        return z;
    }

    public static boolean g(CardboardDevice.DeviceParams deviceParams) {
        boolean h = h(deviceParams, "current_device_params", 894990891);
        if (!h) {
            Log.e(a, "Could not write Cardboard parameters to external storage.");
        }
        return h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean h(com.google.protobuf.nano.MessageNano r3, java.lang.String r4, int r5) {
        /*
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L49
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L49
            java.io.File r4 = a(r4)     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L49
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L49
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L49
            boolean r3 = i(r3, r1, r5)     // Catch: java.lang.Throwable -> L17 java.lang.IllegalStateException -> L1a java.io.FileNotFoundException -> L1d
            r1.close()     // Catch: java.io.IOException -> L6e
            goto L6e
        L17:
            r3 = move-exception
            r0 = r1
            goto L6f
        L1a:
            r3 = move-exception
            r0 = r1
            goto L23
        L1d:
            r3 = move-exception
            r0 = r1
            goto L4a
        L20:
            r3 = move-exception
            goto L6f
        L22:
            r3 = move-exception
        L23:
            java.lang.String r4 = com.google.vr.cardboard.a.a     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L20
            int r5 = r3.length()     // Catch: java.lang.Throwable -> L20
            int r5 = r5 + 26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = "Error writing parameters: "
            r1.append(r5)     // Catch: java.lang.Throwable -> L20
            r1.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L20
            android.util.Log.w(r4, r3)     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L6d
        L45:
            r0.close()     // Catch: java.io.IOException -> L6d
            goto L6d
        L49:
            r3 = move-exception
        L4a:
            java.lang.String r4 = com.google.vr.cardboard.a.a     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L20
            int r5 = r3.length()     // Catch: java.lang.Throwable -> L20
            int r5 = r5 + 39
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = "Parameters file not found for writing: "
            r1.append(r5)     // Catch: java.lang.Throwable -> L20
            r1.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L20
            android.util.Log.e(r4, r3)     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L6d
            goto L45
        L6d:
            r3 = 0
        L6e:
            return r3
        L6f:
            if (r0 == 0) goto L74
            r0.close()     // Catch: java.io.IOException -> L74
        L74:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.vr.cardboard.a.h(com.google.protobuf.nano.MessageNano, java.lang.String, int):boolean");
    }

    private static boolean i(MessageNano messageNano, OutputStream outputStream, int i) {
        try {
            byte[] byteArray = MessageNano.toByteArray(messageNano);
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(i);
            allocate.putInt(byteArray.length);
            outputStream.write(allocate.array());
            outputStream.write(byteArray);
            return true;
        } catch (IOException e) {
            String str = a;
            String valueOf = String.valueOf(e.toString());
            Log.w(str, valueOf.length() != 0 ? "Error writing parameters: ".concat(valueOf) : new String("Error writing parameters: "));
            return false;
        }
    }
}
