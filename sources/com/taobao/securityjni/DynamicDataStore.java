package com.taobao.securityjni;

import android.content.ContextWrapper;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.dynamicdatastore.IDynamicDataStoreComponent;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class DynamicDataStore {
    private IDynamicDataStoreComponent proxy;

    public DynamicDataStore(ContextWrapper contextWrapper) {
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(contextWrapper);
        if (securityGuardManager != null) {
            this.proxy = securityGuardManager.getDynamicDataStoreComp();
        }
    }

    public boolean getBoolean(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return false;
        }
        return iDynamicDataStoreComponent.getBoolean(str);
    }

    public byte[] getByteArray(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return null;
        }
        return iDynamicDataStoreComponent.getByteArray(str);
    }

    public byte[] getByteArrayDDp(String str) {
        return null;
    }

    public float getFloat(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1.0f;
        }
        return iDynamicDataStoreComponent.getFloat(str);
    }

    public int getInt(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1;
        }
        return iDynamicDataStoreComponent.getInt(str);
    }

    public long getLong(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1L;
        }
        return iDynamicDataStoreComponent.getLong(str);
    }

    public long getLongCompat(String str) {
        return getLong(str);
    }

    public String getString(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return null;
        }
        return iDynamicDataStoreComponent.getString(str);
    }

    public String getStringCompat(String str) {
        return getString(str);
    }

    public String getStringDDp(String str) {
        return null;
    }

    public int putBoolean(String str, boolean z) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1;
        }
        return iDynamicDataStoreComponent.putBoolean(str, z);
    }

    public int putByteArray(String str, byte[] bArr) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1;
        }
        return iDynamicDataStoreComponent.putByteArray(str, bArr);
    }

    public int putByteArrayDDp(String str, byte[] bArr) {
        return 0;
    }

    public int putFloat(String str, float f) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1;
        }
        return iDynamicDataStoreComponent.putFloat(str, f);
    }

    public int putInt(String str, int i) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1;
        }
        return iDynamicDataStoreComponent.putInt(str, i);
    }

    public int putLong(String str, long j) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1;
        }
        return iDynamicDataStoreComponent.putLong(str, j);
    }

    public int putString(String str, String str2) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent == null) {
            return -1;
        }
        return iDynamicDataStoreComponent.putString(str, str2);
    }

    public int putStringDDp(String str, String str2) {
        return 0;
    }

    public void removeBoolean(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent != null) {
            iDynamicDataStoreComponent.removeBoolean(str);
        }
    }

    public void removeByteArray(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent != null) {
            iDynamicDataStoreComponent.removeByteArray(str);
        }
    }

    public void removeByteArrayDDp(String str) {
    }

    public void removeFloat(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent != null) {
            iDynamicDataStoreComponent.removeFloat(str);
        }
    }

    public void removeInt(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent != null) {
            iDynamicDataStoreComponent.removeInt(str);
        }
    }

    public void removeLong(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent != null) {
            iDynamicDataStoreComponent.removeLong(str);
        }
    }

    public void removeString(String str) {
        IDynamicDataStoreComponent iDynamicDataStoreComponent = this.proxy;
        if (iDynamicDataStoreComponent != null) {
            iDynamicDataStoreComponent.removeString(str);
        }
    }

    public void removeStringDDp(String str) {
    }
}
