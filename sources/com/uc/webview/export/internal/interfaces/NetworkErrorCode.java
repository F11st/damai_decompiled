package com.uc.webview.export.internal.interfaces;

import com.uc.webview.export.annotations.Reflection;

/* compiled from: Taobao */
@Reflection
/* loaded from: classes11.dex */
public class NetworkErrorCode {
    public static final int ATTACK_DNS_NEED_FORWARD = -55;
    public static final int ATTACK_FORCE_NEED_FORWARD = -57;
    public static final int ATTACK_HEADER_NEED_FORWARD = -56;
    public static final int BACKGROUND_NET_CUT = -50;
    public static final int BLOCK_APP = -71;
    public static final int CONNECT_ERROR_PRELOAD = -62;
    public static final int ERROR = -63;
    public static final int ERROR_AUTH = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_DETAIL_OPCON_EXP = -64;
    public static final int ERROR_DETAIL_RDREQ_EXP = -68;
    public static final int ERROR_DETAIL_RDREQ_TH = -69;
    public static final int ERROR_DETAIL_SDREQ_HTTP = -65;
    public static final int ERROR_DETAIL_SDREQ_NP = -66;
    public static final int ERROR_DETAIL_SDREQ_TH = -67;
    public static final int ERROR_FAILED_SSL_CERTIFICATE = -16;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_IO = -7;
    public static final int ERROR_LOOKUP = -2;
    public static final int ERROR_PROXYAUTH = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int FILE_ERROR = -13;
    public static final int FILE_NOT_FOUND_ERROR = -14;
    public static final int GZ2_CHECK_ERROR = -51;
    public static final int GZ2_CHECK_ERROR_NEED_FORWARD = -52;
    public static final int GZ2_NO_BODY_NEED_FORWARD = -54;
    public static final int GZ2_NO_GZHEADER_NEED_FORWARD = -53;
    public static final int HTTP_STATUSCODE_408 = -48;
    public static final int INVALID_URL = -70;
    public static final int NO_CACHE_NEED_FORWARD = -58;
    public static final int NO_NETWORK = -80;
    public static final int OK = 0;
    public static final int READ_ERROR_ILLEGAL_STATE = -45;
    public static final int READ_ERROR_IO = -44;
    public static final int READ_ERROR_PARSE = -43;
    public static final int READ_ERROR_SOCKET_ERROR = -47;
    public static final int READ_ERROR_SOCKET_TIMEOUT = -46;
    public static final int REQUEST_TOO_BIG = -49;
    public static final int SEND_ERROR_ILLEGAL_STATE = -41;
    public static final int SEND_ERROR_IO = -40;
    public static final int TOO_MANY_REQUESTS_ERROR = -15;
    public static final int UNKNOWN = -72;
    public static final int httpErrorAuth_Id = 4;
    public static final int httpErrorBadUrl_Id = 12;
    public static final int httpErrorConnect_Id = 6;
    public static final int httpErrorFailedSslHandshake_Id = 11;
    public static final int httpErrorFileNotFound_Id = 14;
    public static final int httpErrorFile_Id = 13;
    public static final int httpErrorIO_Id = 7;
    public static final int httpErrorLookup_Id = 2;
    public static final int httpErrorOk_Id = 0;
    public static final int httpErrorProxyAuth_Id = 5;
    public static final int httpErrorRedirectLoop_Id = 9;
    public static final int httpErrorSslCertError_Id = 16;
    public static final int httpErrorTimeout_Id = 8;
    public static final int httpErrorTooManyRequests_Id = 15;
    public static final int httpErrorUnsupportedAuthScheme_Id = 3;
    public static final int httpErrorUnsupportedScheme_Id = 10;
    public static final int httpError_Id = 1;
    static final int[] errorStringResources = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    static final String[] errorString = {"httpErrorOk_Id", "httpError_Id", "httpErrorLookup_Id", "httpErrorUnsupportedAuthScheme_Id", "httpErrorAuth_Id", "httpErrorProxyAuth_Id", "httpErrorConnect_Id", "httpErrorIO_Id", "httpErrorTimeout_Id", "httpErrorRedirectLoop_Id", "httpErrorUnsupportedScheme_Id", "httpErrorFailedSslHandshake_Id", "httpErrorBadUrl_Id", "httpErrorFile_Id", "httpErrorFileNotFound_Id", "httpErrorTooManyRequests_Id", "httpErrorSslCertError_Id"};
}
