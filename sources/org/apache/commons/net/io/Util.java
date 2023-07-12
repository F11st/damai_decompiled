package org.apache.commons.net.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Util {
    public static final int DEFAULT_COPY_BUFFER_SIZE = 1024;

    private Util() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final long copyReader(Reader reader, Writer writer, int i, long j, CopyStreamListener copyStreamListener) throws CopyStreamException {
        long j2;
        char[] cArr = new char[i >= 0 ? i : 1024];
        long j3 = 0;
        while (true) {
            try {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                if (read == 0) {
                    int read2 = reader.read();
                    if (read2 < 0) {
                        break;
                    }
                    writer.write(read2);
                    writer.flush();
                    j2 = j3 + 1;
                    if (copyStreamListener != null) {
                        try {
                            copyStreamListener.bytesTransferred(j2, read2, j);
                        } catch (IOException e) {
                            e = e;
                            j3 = j2;
                            throw new CopyStreamException("IOException caught while copying.", j3, e);
                        }
                    } else {
                        continue;
                    }
                } else {
                    writer.write(cArr, 0, read);
                    writer.flush();
                    j2 = j3 + read;
                    if (copyStreamListener != null) {
                        copyStreamListener.bytesTransferred(j2, read, j);
                    }
                }
                j3 = j2;
            } catch (IOException e2) {
                e = e2;
            }
        }
        return j3;
    }

    public static final long copyStream(InputStream inputStream, OutputStream outputStream, int i, long j, CopyStreamListener copyStreamListener, boolean z) throws CopyStreamException {
        long j2;
        byte[] bArr = new byte[i >= 0 ? i : 1024];
        long j3 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                if (read == 0) {
                    int read2 = inputStream.read();
                    if (read2 < 0) {
                        break;
                    }
                    outputStream.write(read2);
                    if (z) {
                        outputStream.flush();
                    }
                    j2 = j3 + 1;
                    if (copyStreamListener != null) {
                        try {
                            copyStreamListener.bytesTransferred(j2, 1, j);
                        } catch (IOException e) {
                            e = e;
                            j3 = j2;
                            throw new CopyStreamException("IOException caught while copying.", j3, e);
                        }
                    } else {
                        continue;
                    }
                } else {
                    outputStream.write(bArr, 0, read);
                    if (z) {
                        outputStream.flush();
                    }
                    j2 = j3 + read;
                    if (copyStreamListener != null) {
                        copyStreamListener.bytesTransferred(j2, read, j);
                    }
                }
                j3 = j2;
            } catch (IOException e2) {
                e = e2;
            }
        }
        return j3;
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final long copyReader(Reader reader, Writer writer, int i) throws CopyStreamException {
        return copyReader(reader, writer, i, -1L, null);
    }

    public static final long copyStream(InputStream inputStream, OutputStream outputStream, int i, long j, CopyStreamListener copyStreamListener) throws CopyStreamException {
        return copyStream(inputStream, outputStream, i, j, copyStreamListener, true);
    }

    public static final long copyReader(Reader reader, Writer writer) throws CopyStreamException {
        return copyReader(reader, writer, 1024);
    }

    public static final long copyStream(InputStream inputStream, OutputStream outputStream, int i) throws CopyStreamException {
        return copyStream(inputStream, outputStream, i, -1L, null);
    }

    public static final long copyStream(InputStream inputStream, OutputStream outputStream) throws CopyStreamException {
        return copyStream(inputStream, outputStream, 1024);
    }
}
