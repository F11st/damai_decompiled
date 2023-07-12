package com.taobao.android.sopatch.storage;

import java.io.File;
import tb.me2;
import tb.pe2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface FileStorage {
    void deleteInvalidFiles();

    File getSoFile(me2 me2Var);

    File getSoPatchCacheFile();

    File getTmpFile(String str);

    File getZipFile(pe2 pe2Var);
}
