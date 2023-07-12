package com.youku.danmaku.engine.danmaku.loader.android;

import com.youku.danmaku.engine.danmaku.loader.ILoader;
import com.youku.danmaku.engine.danmaku.loader.IllegalDataException;
import com.youku.danmaku.engine.danmaku.parser.android.JSONSource;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YoukuDanmakuLoader implements ILoader {
    private JSONSource dataSource;

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public void load(InputStream inputStream) throws IllegalDataException {
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public void load(String str) throws IllegalDataException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("result")) {
                this.dataSource = new JSONSource(jSONObject.optJSONArray("result").toString());
            }
        } catch (Exception e) {
            throw new IllegalDataException(e);
        }
    }

    public void release() {
        this.dataSource = null;
    }

    @Override // com.youku.danmaku.engine.danmaku.loader.ILoader
    public JSONSource getDataSource() {
        return this.dataSource;
    }
}
