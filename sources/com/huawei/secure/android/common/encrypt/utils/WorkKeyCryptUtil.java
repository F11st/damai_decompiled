package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class WorkKeyCryptUtil {
    private WorkKeyCryptUtil() {
    }

    public static String decryptWorkKey(String str, RootKeyUtil rootKeyUtil) {
        return AesCbc.decrypt(str, rootKeyUtil.getRootKey());
    }

    public static byte[] decryptWorkKey2Byte(byte[] bArr, RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return AesCbc.decrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static byte[] decryptWorkKey2ByteGcm(byte[] bArr, RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return AesGcm.decrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static String decryptWorkKeyGcm(String str, RootKeyUtil rootKeyUtil) {
        return AesGcm.decrypt(str, rootKeyUtil.getRootKey());
    }

    public static String encryptWorkKey(String str, RootKeyUtil rootKeyUtil) {
        return AesCbc.encrypt(str, rootKeyUtil.getRootKey());
    }

    public static byte[] encryptWorkKey2Byte(byte[] bArr, RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return AesCbc.encrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static byte[] encryptWorkKey2ByteGcm(byte[] bArr, RootKeyUtil rootKeyUtil, byte[] bArr2) {
        return AesGcm.encrypt(bArr, rootKeyUtil.getRootKey(), bArr2);
    }

    public static String encryptWorkKeyGcm(String str, RootKeyUtil rootKeyUtil) {
        return AesGcm.encrypt(str, rootKeyUtil.getRootKey());
    }

    public static String decryptWorkKey(String str, byte[] bArr) {
        return AesCbc.decrypt(str, bArr);
    }

    public static byte[] decryptWorkKey2Byte(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return AesCbc.decrypt(bArr, bArr2, bArr3);
    }

    public static byte[] decryptWorkKey2ByteGcm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return AesGcm.decrypt(bArr, bArr2, bArr3);
    }

    public static String decryptWorkKeyGcm(String str, byte[] bArr) {
        return AesGcm.decrypt(str, bArr);
    }

    public static String encryptWorkKey(String str, byte[] bArr) {
        return AesCbc.encrypt(str, bArr);
    }

    public static byte[] encryptWorkKey2Byte(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return AesCbc.encrypt(bArr, bArr2, bArr3);
    }

    public static byte[] encryptWorkKey2ByteGcm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return AesGcm.encrypt(bArr, bArr2, bArr3);
    }

    public static String encryptWorkKeyGcm(String str, byte[] bArr) {
        return AesGcm.encrypt(str, bArr);
    }
}
