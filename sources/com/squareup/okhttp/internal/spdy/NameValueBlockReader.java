package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.d;
import okio.g;
import okio.h;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
class NameValueBlockReader {
    private int compressedLimit;
    private final g inflaterSource;
    private final BufferedSource source;

    public NameValueBlockReader(BufferedSource bufferedSource) {
        g gVar = new g(new d(bufferedSource) { // from class: com.squareup.okhttp.internal.spdy.NameValueBlockReader.1
            @Override // okio.d, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                if (NameValueBlockReader.this.compressedLimit == 0) {
                    return -1L;
                }
                long read = super.read(buffer, Math.min(j, NameValueBlockReader.this.compressedLimit));
                if (read == -1) {
                    return -1L;
                }
                NameValueBlockReader nameValueBlockReader = NameValueBlockReader.this;
                nameValueBlockReader.compressedLimit = (int) (nameValueBlockReader.compressedLimit - read);
                return read;
            }
        }, new Inflater() { // from class: com.squareup.okhttp.internal.spdy.NameValueBlockReader.2
            @Override // java.util.zip.Inflater
            public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int inflate = super.inflate(bArr, i, i2);
                if (inflate == 0 && needsDictionary()) {
                    setDictionary(Spdy3.DICTIONARY);
                    return super.inflate(bArr, i, i2);
                }
                return inflate;
            }
        });
        this.inflaterSource = gVar;
        this.source = h.d(gVar);
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit > 0) {
            this.inflaterSource.a();
            if (this.compressedLimit == 0) {
                return;
            }
            throw new IOException("compressedLimit > 0: " + this.compressedLimit);
        }
    }

    private ByteString readByteString() throws IOException {
        return this.source.readByteString(this.source.readInt());
    }

    public void close() throws IOException {
        this.source.close();
    }

    public List<Header> readNameValueBlock(int i) throws IOException {
        this.compressedLimit += i;
        int readInt = this.source.readInt();
        if (readInt < 0) {
            throw new IOException("numberOfPairs < 0: " + readInt);
        } else if (readInt <= 1024) {
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                ByteString asciiLowercase = readByteString().toAsciiLowercase();
                ByteString readByteString = readByteString();
                if (asciiLowercase.size() != 0) {
                    arrayList.add(new Header(asciiLowercase, readByteString));
                } else {
                    throw new IOException("name.size == 0");
                }
            }
            doneReading();
            return arrayList;
        } else {
            throw new IOException("numberOfPairs > 1024: " + readInt);
        }
    }
}
