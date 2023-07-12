package com.youku.danmaku.engine.danmaku.loader.android;

import com.youku.danmaku.engine.danmaku.loader.ILoader;
import com.youku.danmaku.engine.danmaku.loader.IllegalDataException;
import com.youku.danmaku.engine.danmaku.parser.android.AndroidFileSource;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BiliDanmakuLoader implements ILoader {
    private static BiliDanmakuLoader _instance;
    private AndroidFileSource dataSource;

    private BiliDanmakuLoader() {
    }

    public static BiliDanmakuLoader instance() {
        if (_instance == null) {
            _instance = new BiliDanmakuLoader();
        }
        return _instance;
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public void load(String str) throws IllegalDataException {
        try {
            this.dataSource = new AndroidFileSource(str);
        } catch (Exception e) {
            throw new IllegalDataException(e);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public AndroidFileSource getDataSource() {
        return this.dataSource;
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public void load(InputStream inputStream) {
        this.dataSource = new AndroidFileSource(inputStream);
    }
}
