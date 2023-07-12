package com.taobao.aranger.utils;

import android.os.Build;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import com.taobao.aranger.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class c {
    private static Method a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(Parcelable parcelable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) parcelable;
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            while (channel.read(allocate) != -1) {
                byteArrayOutputStream.write(allocate.array());
                allocate.clear();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            fileInputStream.close();
            parcelFileDescriptor.close();
            return byteArray;
        } catch (Exception e) {
            throw new RuntimeException("big data decode error", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Parcelable b(byte[] bArr) {
        try {
            String uuid = UUID.randomUUID().toString();
            if (Build.VERSION.SDK_INT <= 26) {
                if (a == null) {
                    a = ReflectUtils.getHideMethod(MemoryFile.class, Constants.GET_FILE_DESCRIPTOR, new Class[0]);
                }
                MemoryFile memoryFile = new MemoryFile(uuid, bArr.length);
                memoryFile.writeBytes(bArr, 0, 0, bArr.length);
                return ParcelFileDescriptor.dup((FileDescriptor) a.invoke(memoryFile, new Object[0]));
            }
            if (a == null) {
                a = ReflectUtils.getHideMethod(SharedMemory.class, Constants.GET_FILE_DESCRIPTOR, new Class[0]);
            }
            SharedMemory create = SharedMemory.create(uuid, bArr.length);
            create.mapReadWrite().put(bArr, 0, bArr.length);
            return ParcelFileDescriptor.dup((FileDescriptor) a.invoke(create, new Object[0]));
        } catch (Exception e) {
            throw new RuntimeException("big data encode error", e);
        }
    }
}
