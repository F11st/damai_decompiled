package com.youku.danmaku.engine.danmaku.loader.android;

import android.net.Uri;
import com.youku.danmaku.engine.danmaku.loader.ILoader;
import com.youku.danmaku.engine.danmaku.loader.IllegalDataException;
import com.youku.danmaku.engine.danmaku.parser.android.JSONSource;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AcFunDanmakuLoader implements ILoader {
    private static volatile AcFunDanmakuLoader instance;
    private JSONSource dataSource;

    private AcFunDanmakuLoader() {
    }

    public static ILoader instance() {
        if (instance == null) {
            synchronized (AcFunDanmakuLoader.class) {
                if (instance == null) {
                    instance = new AcFunDanmakuLoader();
                }
            }
        }
        return instance;
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public void load(String str) throws IllegalDataException {
        try {
            this.dataSource = new JSONSource(Uri.parse(str));
        } catch (Exception e) {
            throw new IllegalDataException(e);
        }
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public JSONSource getDataSource() {
        return this.dataSource;
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public void load(InputStream inputStream) throws IllegalDataException {
        try {
            this.dataSource = new JSONSource(inputStream);
        } catch (Exception e) {
            throw new IllegalDataException(e);
        }
    }
}
