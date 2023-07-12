package com.taobao.phenix.loader.file;

import android.content.res.Resources;
import java.io.IOException;
import java.util.Map;
import tb.h62;
import tb.p22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface FileLoader {
    public static final int LOCAL_ASSET = 34;
    public static final int LOCAL_BASE64 = 40;
    public static final int LOCAL_EXTENDED = 48;
    public static final int LOCAL_FILE = 33;
    public static final int LOCAL_RES = 36;

    p22 load(h62 h62Var, String str, Map<String, String> map) throws IOException, Resources.NotFoundException, UnSupportedSchemeException;
}
