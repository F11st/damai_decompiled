package com.taobao.securityjni;

import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.taobao.securityjni.tools.DataContext;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class UtilWX {
    private ContextWrapper context;

    public UtilWX(ContextWrapper contextWrapper) {
        this.context = contextWrapper;
    }

    public String DecryptData(String str, String str2) {
        byte[] staticBinarySafeDecrypt;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return null;
        }
        try {
            IStaticDataEncryptComponent staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp();
            if (staticDataEncryptComp == null || (staticBinarySafeDecrypt = staticDataEncryptComp.staticBinarySafeDecrypt(16, str2, str.getBytes(), "")) == null) {
                return null;
            }
            return new String(staticBinarySafeDecrypt);
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String EncryptData(String str, String str2) {
        byte[] staticBinarySafeEncrypt;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return null;
        }
        try {
            IStaticDataEncryptComponent staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp();
            if (staticDataEncryptComp == null || (staticBinarySafeEncrypt = staticDataEncryptComp.staticBinarySafeEncrypt(16, str2, str.getBytes(), "")) == null) {
                return null;
            }
            return new String(staticBinarySafeEncrypt);
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Get(String str, DataContext dataContext) {
        String appKeyByIndex;
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (str == null || str.length() <= 0 || dataContext == null) {
            return null;
        }
        try {
            IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(this.context).getStaticDataStoreComp();
            if (staticDataStoreComp != null) {
                byte[] bArr = dataContext.extData;
                if (bArr != null) {
                    appKeyByIndex = new String(bArr);
                } else {
                    int i = dataContext.index;
                    if (i < 0) {
                        i = 0;
                    }
                    appKeyByIndex = staticDataStoreComp.getAppKeyByIndex(i, "");
                }
                if (appKeyByIndex == null || (staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp()) == null) {
                    return null;
                }
                return staticDataEncryptComp.staticSafeDecrypt(16, appKeyByIndex, str, "");
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Put(String str, DataContext dataContext) {
        String appKeyByIndex;
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (str == null || str.length() <= 0 || dataContext == null) {
            return null;
        }
        try {
            IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(this.context).getStaticDataStoreComp();
            if (staticDataStoreComp != null) {
                byte[] bArr = dataContext.extData;
                if (bArr != null) {
                    appKeyByIndex = new String(bArr);
                } else {
                    int i = dataContext.index;
                    if (i < 0) {
                        i = 0;
                    }
                    appKeyByIndex = staticDataStoreComp.getAppKeyByIndex(i, "");
                }
                if (appKeyByIndex == null || (staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp()) == null) {
                    return null;
                }
                return staticDataEncryptComp.staticSafeEncrypt(16, appKeyByIndex, str, "");
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] DecryptData(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0 || bArr2 == null || bArr2.length <= 0) {
            return null;
        }
        try {
            IStaticDataEncryptComponent staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp();
            if (staticDataEncryptComp != null) {
                return staticDataEncryptComp.staticBinarySafeDecrypt(16, new String(bArr2), bArr, "");
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] EncryptData(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0 || bArr2 == null || bArr2.length <= 0) {
            return null;
        }
        try {
            IStaticDataEncryptComponent staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp();
            if (staticDataEncryptComp != null) {
                return staticDataEncryptComp.staticBinarySafeEncrypt(16, new String(bArr2), bArr, "");
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] Get(byte[] bArr, DataContext dataContext) {
        String appKeyByIndex;
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (bArr == null || bArr.length <= 0 || dataContext == null) {
            return null;
        }
        try {
            IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(this.context).getStaticDataStoreComp();
            if (staticDataStoreComp != null) {
                byte[] bArr2 = dataContext.extData;
                if (bArr2 != null) {
                    appKeyByIndex = new String(bArr2);
                } else {
                    int i = dataContext.index;
                    if (i < 0) {
                        i = 0;
                    }
                    appKeyByIndex = staticDataStoreComp.getAppKeyByIndex(i, "");
                }
                if (appKeyByIndex == null || (staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp()) == null) {
                    return null;
                }
                return staticDataEncryptComp.staticBinarySafeDecrypt(16, appKeyByIndex, bArr, "");
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] Put(byte[] bArr, DataContext dataContext) {
        String appKeyByIndex;
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (bArr == null || bArr.length <= 0 || dataContext == null) {
            return null;
        }
        try {
            IStaticDataStoreComponent staticDataStoreComp = SecurityGuardManager.getInstance(this.context).getStaticDataStoreComp();
            if (staticDataStoreComp != null) {
                byte[] bArr2 = dataContext.extData;
                if (bArr2 != null) {
                    appKeyByIndex = new String(bArr2);
                } else {
                    int i = dataContext.index;
                    if (i < 0) {
                        i = 0;
                    }
                    appKeyByIndex = staticDataStoreComp.getAppKeyByIndex(i, "");
                }
                if (appKeyByIndex == null || (staticDataEncryptComp = SecurityGuardManager.getInstance(this.context).getStaticDataEncryptComp()) == null) {
                    return null;
                }
                return staticDataEncryptComp.staticBinarySafeEncrypt(16, appKeyByIndex, bArr, "");
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Get(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = SecurityGuardManager.getInstance(this.context).getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp != null) {
                return dynamicDataEncryptComp.dynamicDecrypt(str);
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Put(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = SecurityGuardManager.getInstance(this.context).getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp != null) {
                return dynamicDataEncryptComp.dynamicEncrypt(str);
            }
            return null;
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] Get(byte[] bArr) {
        String dynamicDecrypt;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = SecurityGuardManager.getInstance(this.context).getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp == null || (dynamicDecrypt = dynamicDataEncryptComp.dynamicDecrypt(new String(bArr))) == null || dynamicDecrypt.length() <= 0) {
                return null;
            }
            return dynamicDecrypt.getBytes();
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] Put(byte[] bArr) {
        String dynamicEncrypt;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = SecurityGuardManager.getInstance(this.context).getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp == null || (dynamicEncrypt = dynamicDataEncryptComp.dynamicEncrypt(new String(bArr))) == null || dynamicEncrypt.length() <= 0) {
                return null;
            }
            return dynamicEncrypt.getBytes();
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }
}
