package com.youku.danmaku.engine.danmaku.parser.android;

import android.net.Uri;
import com.youku.danmaku.engine.danmaku.parser.IDataSource;
import com.youku.danmaku.engine.danmaku.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AndroidFileSource implements IDataSource<InputStream> {
    private InputStream inStream;

    public AndroidFileSource(String str) {
        fillStreamFromFile(new File(str));
    }

    public void fillStreamFromFile(File file) {
        try {
            this.inStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fillStreamFromHttpFile(Uri uri) {
        try {
            URL url = new URL(uri.getPath());
            url.openConnection();
            this.inStream = new BufferedInputStream(url.openStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void fillStreamFromUri(Uri uri) {
        String scheme = uri.getScheme();
        if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            if ("file".equalsIgnoreCase(scheme)) {
                fillStreamFromFile(new File(uri.getPath()));
                return;
            }
            return;
        }
        fillStreamFromHttpFile(uri);
    }

    @Override // com.youku.danmaku.engine.danmaku.parser.IDataSource
    public void release() {
        IOUtils.closeQuietly(this.inStream);
        this.inStream = null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.youku.danmaku.engine.danmaku.parser.IDataSource
    public InputStream data() {
        return this.inStream;
    }

    public AndroidFileSource(Uri uri) {
        fillStreamFromUri(uri);
    }

    public AndroidFileSource(File file) {
        fillStreamFromFile(file);
    }

    public AndroidFileSource(InputStream inputStream) {
        this.inStream = inputStream;
    }
}
