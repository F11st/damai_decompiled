package com.uc.crashsdk.export;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DumpFileInfo {
    public String mCategory;
    public boolean mDeleteAfterDump;
    public String mFileTobeDump;
    public boolean mIsEncrypted;
    public int mLogType;
    public boolean mWriteCategory;

    public DumpFileInfo(String str, String str2, int i) {
        this.mWriteCategory = true;
        this.mDeleteAfterDump = false;
        this.mIsEncrypted = false;
        this.mCategory = str;
        this.mFileTobeDump = str2;
        this.mLogType = i;
    }

    public DumpFileInfo(DumpFileInfo dumpFileInfo) {
        this.mWriteCategory = true;
        this.mDeleteAfterDump = false;
        this.mIsEncrypted = false;
        this.mCategory = dumpFileInfo.mCategory;
        this.mFileTobeDump = dumpFileInfo.mFileTobeDump;
        this.mLogType = dumpFileInfo.mLogType;
        this.mWriteCategory = dumpFileInfo.mWriteCategory;
        this.mDeleteAfterDump = dumpFileInfo.mDeleteAfterDump;
        this.mIsEncrypted = dumpFileInfo.mIsEncrypted;
    }
}
