package com.uc.webview.export.cyclone.service;

import android.content.Context;
import com.uc.webview.export.cyclone.Constant;
import java.io.FilenameFilter;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public interface UCUnzip extends UCServiceInterface {
    boolean deccompress(Context context, String str, String str2, FilenameFilter filenameFilter);
}
