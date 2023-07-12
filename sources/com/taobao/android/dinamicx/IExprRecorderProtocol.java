package com.taobao.android.dinamicx;

import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import tb.wy;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IExprRecorderProtocol {
    void doAfterEvaluateMethodWithResult(wy wyVar, Object obj, DXRuntimeContext dXRuntimeContext);

    void doAfterExecuteASTWithEventAndContext(wy wyVar, Object obj, DXRuntimeContext dXRuntimeContext);

    void doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(wy wyVar, IDXDataParser iDXDataParser, Object[] objArr, DXRuntimeContext dXRuntimeContext);

    void doBeforeExecuteASTWithEventAndContext(wy wyVar, Object obj, DXRuntimeContext dXRuntimeContext);
}
