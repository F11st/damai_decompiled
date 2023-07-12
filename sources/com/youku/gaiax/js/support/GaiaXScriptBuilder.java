package com.youku.gaiax.js.support;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.gaiax.js.utils.TimeUtils;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0002J(\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J(\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J(\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J.\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010#\u001a\u00020\u0002¨\u0006&"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXScriptBuilder;", "", "", "buildImportScript", "", "contextId", "", "engineType", "buildGlobalContext", "buildExtendAndAssignScript", "moduleName", "buildModuleGlobalDeclareScript", "buildModuleDeclareScript", "methodName", "moduleId", "methodId", "buildSyncMethodDeclareScript", "buildAsyncMethodDeclareScript", "buildPromiseMethodDeclareScript", "componentId", hh1.DIMEN_BIZ, "templateId", "templateVersion", "script", "buildInitComponentScript", "buildComponentReadyScript", "buildComponentShowScript", "buildComponentHideScript", "buildComponentDestroyScript", "buildDestroyComponentScript", "buildComponentReuseScript", "msg", "buildComponentLoadMoreScript", "buildPostMessage", "buildPostNativeMessage", "buildStyle", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXScriptBuilder {
    @NotNull
    public static final GaiaXScriptBuilder INSTANCE = new GaiaXScriptBuilder();

    private GaiaXScriptBuilder() {
    }

    @Nullable
    public final String buildAsyncMethodDeclareScript(@NotNull String str, @NotNull String str2, long j, long j2) {
        String e;
        b41.i(str, "moduleName");
        b41.i(str2, "methodName");
        if (str.length() == 0) {
            return null;
        }
        if ((str2.length() == 0) || j < 0 || j2 < 0) {
            return null;
        }
        e = StringsKt__IndentKt.e("\nGaiaX" + str + "Module.prototype." + str2 + " = function () {\n  var args = [];\n  for (var _i = 0; _i < arguments.length; _i++) {\n    args[_i] = arguments[_i];\n  }\n  GaiaX" + str + "Module.callAsync(\n    { moduleId: " + j + ", methodId: " + j2 + ", timestamp: " + TimeUtils.INSTANCE.elapsedRealtime() + ", args: (typeof args[args.length-1] == 'function') ? args.slice(0, args.length-1) : args },\n    function (result) {\n      let callback = args[args.length - 1];\n      callback && (typeof callback == 'function') && callback(result);\n    }\n  );\n};\n\n        ");
        return e;
    }

    @NotNull
    public final String buildComponentDestroyScript(long j) {
        String e;
        e = StringsKt__IndentKt.e("\n(function () {\n    var instance = IMs.getComponent(" + j + "); \n    if (instance) { \n        instance.onDestroy && instance.onDestroy(); \n    }\n})()\n        ");
        return e;
    }

    @NotNull
    public final String buildComponentHideScript(long j) {
        String e;
        e = StringsKt__IndentKt.e("\n(function () {\n    var instance = IMs.getComponent(" + j + "); \n    if (instance) { \n        instance.onHide && instance.onHide(); \n    }\n})()\n        ");
        return e;
    }

    @NotNull
    public final String buildComponentLoadMoreScript(long j, @NotNull String str) {
        String e;
        b41.i(str, "msg");
        e = StringsKt__IndentKt.e("\n(function () {\n    var instance = IMs.getComponent(" + j + "); \n    if (instance) { \n        instance.onLoadMore && instance.onLoadMore(" + str + "); \n    }\n})()\n        ");
        return e;
    }

    @NotNull
    public final String buildComponentReadyScript(long j) {
        String e;
        e = StringsKt__IndentKt.e("\n(function () {\n    var instance = IMs.getComponent(" + j + ");\n    if (instance) { \n        instance.onShow && instance.onShow(); \n        instance.onReady && instance.onReady(); \n    }\n})()\n        ");
        return e;
    }

    @NotNull
    public final String buildComponentReuseScript(long j) {
        String e;
        e = StringsKt__IndentKt.e("\n(function () {\n    var instance = IMs.getComponent(" + j + "); \n    if (instance) { \n        instance.onReuse && instance.onReuse(); \n    }\n})()\n        ");
        return e;
    }

    @NotNull
    public final String buildComponentShowScript(long j) {
        String e;
        e = StringsKt__IndentKt.e("\n(function () {\n    var instance = IMs.getComponent(" + j + "); \n    if (instance) { \n        instance.onShow && instance.onShow(); \n    }    \n})()\n        ");
        return e;
    }

    @NotNull
    public final String buildDestroyComponentScript(long j) {
        String e;
        e = StringsKt__IndentKt.e("\n(function () {\n    var instance = IMs.getComponent(" + j + "); \n    if (instance) {\n        IMs.removeComponent(" + j + ");\n    }\n})()\n        ");
        return e;
    }

    @NotNull
    public final String buildExtendAndAssignScript() {
        return "var __extends = (this && this.__extends) || (function () {\n    var extendStatics = function (d, b) {\n      extendStatics =\n        Object.setPrototypeOf ||\n        ({ __proto__: [] } instanceof Array &&\n          function (d, b) {\n            d.__proto__ = b;\n          }) ||\n        function (d, b) {\n          for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];\n        };\n      return extendStatics(d, b);\n    };\n    return function (d, b) {\n      extendStatics(d, b);\n      function __() {\n        this.constructor = d;\n      }\n      d.prototype =\n        b === null\n          ? Object.create(b)\n          : ((__.prototype = b.prototype), new __());\n    };\n  })();\nvar __assign = (this && this.__assign) || function () {\n    __assign =\n      Object.assign ||\n      function (t) {\n        for (var s, i = 1, n = arguments.length; i < n; i++) {\n          s = arguments[i];\n          for (var p in s)\n            if (Object.prototype.hasOwnProperty.call(s, p)) t[p] = s[p];\n        }\n        return t;\n      };\n    return __assign.apply(this, arguments);\n  };\n  ";
    }

    @NotNull
    public final String buildGlobalContext(long j, int i) {
        String e;
        e = StringsKt__IndentKt.e("\nvar __globalThis = globalThis; \n__globalThis.__CONTEXT_ID__ = " + j + ";\n__globalThis.__ENGINE_TYPE__ = " + i + ";\n\n        ");
        return e;
    }

    @NotNull
    public final String buildImportScript() {
        return "import * as GaiaXJSBridge from \"GaiaXJSBridge\";\n";
    }

    @NotNull
    public final String buildInitComponentScript(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        String e;
        String e2;
        String e3;
        String e4;
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "templateVersion");
        b41.i(str4, "script");
        e = StringsKt__IndentKt.e(str4);
        String str5 = "{ bizId: \"" + str + "\", templateId: \"" + str2 + "\", instanceId: " + j + ", templateVersion: " + str3 + " }";
        String substring = e.substring(0, e.length() - 2);
        b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        e2 = StringsKt__IndentKt.e(substring);
        String substring2 = e.substring(e.length() - 2);
        b41.h(substring2, "(this as java.lang.String).substring(startIndex)");
        e3 = StringsKt__IndentKt.e(substring2);
        e4 = StringsKt__IndentKt.e('\n' + e2 + AVFSCacheConstants.COMMA_SEP + str5 + '\n' + e3 + "\n        ");
        return e4;
    }

    @Nullable
    public final String buildModuleDeclareScript(@NotNull String str) {
        String e;
        b41.i(str, "moduleName");
        if (str.length() == 0) {
            return null;
        }
        e = StringsKt__IndentKt.e("\nvar GaiaX" + str + "Module = (function (_super) {\n  __extends(GaiaX" + str + "Module, _super);\n  function GaiaX" + str + "Module() {\n    return _super.call(this) || this;\n  }\n  return GaiaX" + str + "Module;\n})(Bridge);\n\n        ");
        return e;
    }

    @NotNull
    public final String buildModuleGlobalDeclareScript(@NotNull String str) {
        String e;
        String e2;
        b41.i(str, "moduleName");
        if (b41.d(str, "BuildIn")) {
            e2 = StringsKt__IndentKt.e("\n__globalThis.gaiax = new GaiaX" + str + "Module();\n\n                ");
            return e2;
        }
        e = StringsKt__IndentKt.e("\n__globalThis." + str + " = new GaiaX" + str + "Module();\n\n                ");
        return e;
    }

    @NotNull
    public final String buildPostMessage(@NotNull String str) {
        String e;
        b41.i(str, "msg");
        e = StringsKt__IndentKt.e("\nwindow.postMessage(" + str + ")\n        ");
        return e;
    }

    @NotNull
    public final String buildPostNativeMessage(@NotNull String str) {
        String e;
        b41.i(str, "msg");
        e = StringsKt__IndentKt.e("\nwindow.postNativeMessage(" + str + ")\n        ");
        return e;
    }

    @Nullable
    public final String buildPromiseMethodDeclareScript(@NotNull String str, @NotNull String str2, long j, long j2) {
        String e;
        b41.i(str, "moduleName");
        b41.i(str2, "methodName");
        if (str.length() == 0) {
            return null;
        }
        if ((str2.length() == 0) || j < 0 || j2 < 0) {
            return null;
        }
        e = StringsKt__IndentKt.e("\nGaiaX" + str + "Module.prototype." + str2 + " = function () {\n  var args = [];\n  for (var _i = 0; _i < arguments.length; _i++) {\n    args[_i] = arguments[_i];\n  }\n  return new Promise(function (resolve, reject) {\n    GaiaX" + str + "Module.callPromise({ moduleId: " + j + ", methodId: " + j2 + ", timestamp: " + TimeUtils.INSTANCE.elapsedRealtime() + ", args })\n      .then(function (result) {\n        resolve(result);\n      })\n      .catch(function (error) {\n        reject(error);\n      });\n  });\n};\n\n        ");
        return e;
    }

    @NotNull
    public final String buildStyle() {
        return "var Style = (function () {\n    function Style(data) {\n        this.__data__ = __assign({}, data);\n    }\n    Object.defineProperty(Style.prototype, \"targetData\", {\n        get: function () {\n            return this.__data__;\n        },\n        enumerable: true,\n        configurable: true\n    });\n    return Style;\n}());\n\nvar Props = (function () {\n    function Props() {\n    }\n    return Props;\n}());";
    }

    @Nullable
    public final String buildSyncMethodDeclareScript(@NotNull String str, @NotNull String str2, long j, long j2) {
        String e;
        b41.i(str, "moduleName");
        b41.i(str2, "methodName");
        if (str.length() == 0) {
            return null;
        }
        if ((str2.length() == 0) || j < 0 || j2 < 0) {
            return null;
        }
        e = StringsKt__IndentKt.e("\nGaiaX" + str + "Module.prototype." + str2 + " = function () {\n  var args = [];\n  for (var _i = 0; _i < arguments.length; _i++) {\n    args[_i] = arguments[_i];\n  }\n  return GaiaX" + str + "Module.callSync({ moduleId: " + j + ", methodId: " + j2 + ", timestamp: " + TimeUtils.INSTANCE.elapsedRealtime() + ", args });\n};\n\n        ");
        return e;
    }
}
