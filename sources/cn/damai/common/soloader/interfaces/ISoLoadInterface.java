package cn.damai.common.soloader.interfaces;

import cn.damai.common.soloader.SoFileInfo;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ISoLoadInterface {
    boolean checkSoFile(SoFileInfo soFileInfo);

    void downLoadSoFile(SoFileInfo soFileInfo, ISoDownLoadListener iSoDownLoadListener);

    boolean injectionSoPath();

    boolean isSoLoadSuccess();

    boolean loadLibrary(SoFileInfo soFileInfo);
}
