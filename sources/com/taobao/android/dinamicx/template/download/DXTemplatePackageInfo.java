package com.taobao.android.dinamicx.template.download;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXTemplatePackageInfo implements Cloneable {
    public String mainFilePath;
    public Map<String, String> subFilePathDict;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public DXTemplatePackageInfo m576clone() {
        DXTemplatePackageInfo dXTemplatePackageInfo = new DXTemplatePackageInfo();
        dXTemplatePackageInfo.mainFilePath = this.mainFilePath;
        dXTemplatePackageInfo.subFilePathDict = this.subFilePathDict;
        return dXTemplatePackageInfo;
    }
}
