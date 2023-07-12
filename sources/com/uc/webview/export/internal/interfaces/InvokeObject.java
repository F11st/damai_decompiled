package com.uc.webview.export.internal.interfaces;

import com.uc.webview.export.annotations.Interface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface InvokeObject {
    public static final int METHOD_ADD_SHORTCUT_FOR_WEBAPP = 23;
    public static final int METHOD_CORE_TO_SDK_ON_CLEAR_RECORD = 201;
    public static final int METHOD_CORE_TO_SDK_ON_CONSOLE_MESSAGE = 205;
    public static final int METHOD_CORE_TO_SDK_ON_PERMISSION_REQUEST = 203;
    public static final int METHOD_CORE_TO_SDK_ON_PERMISSION_REQUEST_CANCELED = 204;
    public static final int METHOD_CORE_TO_SDK_ON_PROXY_CHANGED = 202;
    public static final int METHOD_CREATE_PRINT_DOCUMENT_ADAPTER = 11;
    public static final int METHOD_FORCE_UPDATE_TOPCONTROLS_OFFSET = 21;
    public static final int METHOD_GET_KEYWORD_HYPERLINK_ENABLED = 303;
    public static final int METHOD_GET_STARTUP_PERFORMANCE_STATISTICS = 26;
    public static final int METHOD_INJECT_JAVASCRIPT_NATIVE_CALLBACK = 24;
    public static final int METHOD_ISLOADFROMCACHEDPAGE = 4;
    public static final int METHOD_ISPRIVATEBROWSINGENABLED = 8;
    public static final int METHOD_IS_IN_COOL_VIDEO = 16;
    public static final int METHOD_LOAD_URL = 20;
    public static final int METHOD_OPENPICTUREVIEWER1 = 12;
    public static final int METHOD_REMOVE_RESOURCES_FROM_CACHE = 13;
    public static final int METHOD_REQUEST_PICTURE_BY_URL = 15;
    public static final int METHOD_SAVEPICTURE = 10;
    public static final int METHOD_SDK_TO_CORE_CLEAR_DNS_CACHE = 108;
    public static final int METHOD_SDK_TO_CORE_CLEAR_PRECACHE_RESOURCES = 104;
    public static final int METHOD_SDK_TO_CORE_CREATE_JS_INTERFACE_IMPL = 113;
    public static final int METHOD_SDK_TO_CORE_ENABLE_JS_COVERAGE_INFO = 111;
    public static final int METHOD_SDK_TO_CORE_EXT_IMAGE_DECODER = 105;
    public static final int METHOD_SDK_TO_CORE_EXT_IMAGE_DECODER_REQ_RESULT = 106;
    public static final int METHOD_SDK_TO_CORE_GENERATE_CODE_CACHE = 109;
    public static final int METHOD_SDK_TO_CORE_GET_JS_ROUTE = 114;
    public static final int METHOD_SDK_TO_CORE_GET_URL_FROM_JS_INTERFACE = 116;
    public static final int METHOD_SDK_TO_CORE_PRECACHE_RESOURCES = 103;
    public static final int METHOD_SDK_TO_CORE_RM_ALL_USERSCRIPT = 102;
    public static final int METHOD_SDK_TO_CORE_SEND_MESSAGE_TO_JS = 115;
    public static final int METHOD_SDK_TO_CORE_SET_CODE_CACHE = 110;
    public static final int METHOD_SDK_TO_CORE_SET_OFFLINE_RESOURCE_CLIENT = 112;
    public static final int METHOD_SDK_TO_CORE_SET_SDK_CLIENT = 101;
    public static final int METHOD_SDK_TO_CORE_UPDATE_DNS_CACHE = 107;
    public static final int METHOD_SETDEFAULTBROWSERCLIENT = 9;
    public static final int METHOD_SETTINGS_SET_STRING_VALUE = 304;
    public static final int METHOD_SET_CAMERA_TYPE = 305;
    public static final int METHOD_SET_HTTP_CACHE_MAX_SIZE = 17;
    public static final int METHOD_SET_KEYWORD_HYPERLINK_ENABLED = 302;
    public static final int METHOD_SET_TOOLBAR_HEIGHT = 22;
    public static final int METHOD_START_BIG_BANG = 14;
    public static final int METHOD_SUPERONINITIALIZEACCESSIBILITYEVENT = 2;
    public static final int METHOD_SUPERONINITIALIZEACCESSIBILITYNODEINFO = 1;
    public static final int METHOD_SUPERPERFORMACCESSIBILITYACTION = 3;
    public static final int METHOD_UCSETTINGS_TEST = 301;
    public static final int METHOD_UPDATE_CONTEXT = 25;
    public static final int METHOD_ZOOMBY = 7;

    Object invoke(int i, Object[] objArr);
}
