package com.youku.danmaku.engine.danmaku.parser.android;

import android.net.Uri;
import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.parser.IDataSource;
import com.youku.danmaku.engine.danmaku.util.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class JSONSource implements IDataSource<JSONArray> {
    private InputStream mInput;
    private JSONArray mJSONArray;

    public JSONSource(String str) throws JSONException {
        init(str);
    }

    private void init(InputStream inputStream) throws JSONException {
        Objects.requireNonNull(inputStream, "input stream cannot be null!");
        this.mInput = inputStream;
        init(IOUtils.getString(inputStream));
    }

    @Override // com.youku.danmaku.engine.danmaku.parser.IDataSource
    public void release() {
        IOUtils.closeQuietly(this.mInput);
        this.mInput = null;
        this.mJSONArray = null;
    }

    @Override // com.youku.danmaku.engine.danmaku.parser.IDataSource
    public JSONArray data() {
        return this.mJSONArray;
    }

    public JSONSource(InputStream inputStream) throws JSONException {
        init(inputStream);
    }

    public JSONSource(URL url) throws JSONException, IOException {
        this(url.openStream());
    }

    private void init(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mJSONArray = new JSONArray(str);
    }

    public JSONSource(File file) throws FileNotFoundException, JSONException {
        init(new FileInputStream(file));
    }

    public JSONSource(Uri uri) throws IOException, JSONException {
        String scheme = uri.getScheme();
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            if ("file".equalsIgnoreCase(scheme)) {
                init(new FileInputStream(uri.getPath()));
                return;
            }
            return;
        }
        init(new URL(uri.getPath()).openStream());
    }
}
