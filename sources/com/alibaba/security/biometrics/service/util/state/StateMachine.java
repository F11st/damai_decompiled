package com.alibaba.security.biometrics.service.util.state;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.c.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class StateMachine {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;
    public static final int SM_INIT_CMD = -1;
    public static final int SM_QUIT_CMD = -1;
    private static final String TAG = "StateMachine";
    private String mName;
    private SmHandler mSmHandler;
    private HandlerThread mSmThread;
    private boolean mStarted;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ProcessedMessageInfo {
        private State orgState;
        private State state;
        private int what;

        ProcessedMessageInfo(Message message, State state, State state2) {
            update(message, state, state2);
        }

        private String cn(Object obj) {
            if (obj == null) {
                return "null";
            }
            String name = obj.getClass().getName();
            return name.substring(name.lastIndexOf(36) + 1);
        }

        public State getOriginalState() {
            return this.orgState;
        }

        public State getState() {
            return this.state;
        }

        public int getWhat() {
            return this.what;
        }

        public String toString() {
            return "what=" + this.what + " state=" + cn(this.state) + " orgState=" + cn(this.orgState);
        }

        public void update(Message message, State state, State state2) {
            this.what = message.what;
            this.state = state;
            this.orgState = state2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ProcessedMessages {
        private static final int DEFAULT_SIZE = 20;
        private Vector<ProcessedMessageInfo> mMessages = new Vector<>();
        private int mMaxSize = 20;
        private int mOldestIndex = 0;
        private int mCount = 0;

        ProcessedMessages() {
        }

        void add(Message message, State state, State state2) {
            this.mCount++;
            if (this.mMessages.size() < this.mMaxSize) {
                this.mMessages.add(new ProcessedMessageInfo(message, state, state2));
                return;
            }
            ProcessedMessageInfo processedMessageInfo = this.mMessages.get(this.mOldestIndex);
            int i = this.mOldestIndex + 1;
            this.mOldestIndex = i;
            if (i >= this.mMaxSize) {
                this.mOldestIndex = 0;
            }
            processedMessageInfo.update(message, state, state2);
        }

        int count() {
            return this.mCount;
        }

        ProcessedMessageInfo get(int i) {
            int i2 = this.mOldestIndex + i;
            int i3 = this.mMaxSize;
            if (i2 >= i3) {
                i2 -= i3;
            }
            if (i2 >= size()) {
                return null;
            }
            return this.mMessages.get(i2);
        }

        void setSize(int i) {
            this.mMaxSize = i;
            this.mCount = 0;
            this.mMessages.clear();
        }

        int size() {
            return this.mMessages.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class SmHandler extends Handler {
        private static final Object mQuitObj = new Object();
        private boolean mDbg;
        private ArrayList<Message> mDeferredMessages;
        private State mDestState;
        private HaltingState mHaltingState;
        private State mInitialState;
        private boolean mIsConstructionCompleted;
        private Message mMsg;
        private ProcessedMessages mProcessedMessages;
        private QuittingState mQuittingState;
        private StateMachine mSm;
        private HashMap<State, StateInfo> mStateInfo;
        private StateInfo[] mStateStack;
        private int mStateStackTopIndex;
        private StateInfo[] mTempStateStack;
        private int mTempStateStackCount;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public class HaltingState extends State {
            private HaltingState() {
            }

            @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
            public boolean processMessage(Message message) {
                SmHandler.this.mSm.haltedProcessMessage(message);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public class QuittingState extends State {
            private QuittingState() {
            }

            @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
            public boolean processMessage(Message message) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public class StateInfo {
            boolean active;
            StateInfo parentStateInfo;
            State state;

            private StateInfo() {
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("state=");
                sb.append(this.state.getName());
                sb.append(",active=");
                sb.append(this.active);
                sb.append(",parent=");
                StateInfo stateInfo = this.parentStateInfo;
                sb.append(stateInfo == null ? "null" : stateInfo.state.getName());
                return sb.toString();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final StateInfo addState(State state, State state2) {
            StateInfo stateInfo;
            if (this.mDbg) {
                StringBuilder sb = new StringBuilder("addStateInternal: E state=");
                sb.append(state.getName());
                sb.append(",parent=");
                sb.append(state2 == null ? "" : state2.getName());
                a.a(StateMachine.TAG, sb.toString());
            }
            if (state2 != null) {
                stateInfo = this.mStateInfo.get(state2);
                if (stateInfo == null) {
                    stateInfo = addState(state2, null);
                }
            } else {
                stateInfo = null;
            }
            StateInfo stateInfo2 = this.mStateInfo.get(state);
            if (stateInfo2 == null) {
                stateInfo2 = new StateInfo();
                this.mStateInfo.put(state, stateInfo2);
            }
            StateInfo stateInfo3 = stateInfo2.parentStateInfo;
            if (stateInfo3 != null && stateInfo3 != stateInfo) {
                throw new RuntimeException("state already added");
            }
            stateInfo2.state = state;
            stateInfo2.parentStateInfo = stateInfo;
            stateInfo2.active = false;
            if (this.mDbg) {
                a.a(StateMachine.TAG, "addStateInternal: X stateInfo: ".concat(String.valueOf(stateInfo2)));
            }
            return stateInfo2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void completeConstruction() {
            if (this.mDbg) {
                a.a(StateMachine.TAG, "completeConstruction: E");
            }
            int i = 0;
            for (StateInfo stateInfo : this.mStateInfo.values()) {
                int i2 = 0;
                while (stateInfo != null) {
                    stateInfo = stateInfo.parentStateInfo;
                    i2++;
                }
                if (i < i2) {
                    i = i2;
                }
            }
            if (this.mDbg) {
                a.a(StateMachine.TAG, "completeConstruction: maxDepth=".concat(String.valueOf(i)));
            }
            this.mStateStack = new StateInfo[i];
            this.mTempStateStack = new StateInfo[i];
            setupInitialStateStack();
            this.mIsConstructionCompleted = true;
            this.mMsg = obtainMessage(-1);
            invokeEnterMethods(0);
            performTransitions();
            if (this.mDbg) {
                a.a(StateMachine.TAG, "completeConstruction: X");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void deferMessage(Message message) {
            if (this.mDbg) {
                a.a(StateMachine.TAG, "deferMessage: msg=" + message.what);
            }
            Message obtainMessage = obtainMessage();
            obtainMessage.copyFrom(message);
            this.mDeferredMessages.add(obtainMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Message getCurrentMessage() {
            return this.mMsg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IState getCurrentState() {
            return this.mStateStack[this.mStateStackTopIndex].state;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ProcessedMessageInfo getProcessedMessageInfo(int i) {
            return this.mProcessedMessages.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getProcessedMessagesCount() {
            return this.mProcessedMessages.count();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getProcessedMessagesSize() {
            return this.mProcessedMessages.size();
        }

        private final void invokeEnterMethods(int i) {
            while (i <= this.mStateStackTopIndex) {
                if (this.mDbg) {
                    a.a(StateMachine.TAG, "invokeEnterMethods: " + this.mStateStack[i].state.getName());
                }
                this.mStateStack[i].state.enter();
                this.mStateStack[i].active = true;
                i++;
            }
        }

        private final void invokeExitMethods(StateInfo stateInfo) {
            while (true) {
                int i = this.mStateStackTopIndex;
                if (i < 0) {
                    return;
                }
                StateInfo[] stateInfoArr = this.mStateStack;
                if (stateInfoArr[i] == stateInfo) {
                    return;
                }
                State state = stateInfoArr[i].state;
                if (this.mDbg) {
                    a.a(StateMachine.TAG, "invokeExitMethods: " + state.getName());
                }
                state.exit();
                StateInfo[] stateInfoArr2 = this.mStateStack;
                int i2 = this.mStateStackTopIndex;
                stateInfoArr2[i2].active = false;
                this.mStateStackTopIndex = i2 - 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDbg() {
            return this.mDbg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isQuit(Message message) {
            return message.what == -1 && message.obj == mQuitObj;
        }

        private final void moveDeferredMessageAtFrontOfQueue() {
            for (int size = this.mDeferredMessages.size() - 1; size >= 0; size--) {
                Message message = this.mDeferredMessages.get(size);
                if (this.mDbg) {
                    a.a(StateMachine.TAG, "moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.mDeferredMessages.clear();
        }

        private final int moveTempStateStackToStateStack() {
            int i = this.mStateStackTopIndex + 1;
            int i2 = i;
            for (int i3 = this.mTempStateStackCount - 1; i3 >= 0; i3--) {
                if (this.mDbg) {
                    a.a(StateMachine.TAG, "moveTempStackToStateStack: i=" + i3 + ",j=" + i2);
                }
                this.mStateStack[i2] = this.mTempStateStack[i3];
                i2++;
            }
            this.mStateStackTopIndex = i2 - 1;
            if (this.mDbg) {
                a.a(StateMachine.TAG, "moveTempStackToStateStack: X mStateStackTop=" + this.mStateStackTopIndex + ",startingIndex=" + i + ",Top=" + this.mStateStack[this.mStateStackTopIndex].state.getName());
            }
            return i;
        }

        private void performTransitions() {
            State state = null;
            while (this.mDestState != null) {
                if (this.mDbg) {
                    a.a(StateMachine.TAG, "handleMessage: new destination call exit");
                }
                state = this.mDestState;
                this.mDestState = null;
                invokeExitMethods(setupTempStateStackWithStatesToEnter(state));
                invokeEnterMethods(moveTempStateStackToStateStack());
                moveDeferredMessageAtFrontOfQueue();
            }
            if (state != null) {
                if (state == this.mQuittingState) {
                    this.mSm.quitting();
                    if (this.mSm.mSmThread != null) {
                        getLooper().quit();
                        this.mSm.mSmThread = null;
                    }
                } else if (state == this.mHaltingState) {
                    this.mSm.halting();
                }
            }
        }

        private final void processMsg(Message message) {
            StateInfo stateInfo = this.mStateStack[this.mStateStackTopIndex];
            if (this.mDbg) {
                a.a(StateMachine.TAG, "processMsg: " + stateInfo.state.getName());
            }
            while (true) {
                if (stateInfo.state.processMessage(message)) {
                    break;
                }
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null) {
                    this.mSm.unhandledMessage(message);
                    if (isQuit(message)) {
                        transitionTo(this.mQuittingState);
                    }
                } else if (this.mDbg) {
                    a.a(StateMachine.TAG, "processMsg: " + stateInfo.state.getName());
                }
            }
            if (stateInfo != null) {
                this.mProcessedMessages.add(message, stateInfo.state, this.mStateStack[this.mStateStackTopIndex].state);
                return;
            }
            this.mProcessedMessages.add(message, null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void quit() {
            if (this.mDbg) {
                a.a(StateMachine.TAG, "quit:");
            }
            sendMessage(obtainMessage(-1, mQuitObj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setDbg(boolean z) {
            this.mDbg = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setInitialState(State state) {
            if (this.mDbg) {
                a.a(StateMachine.TAG, "setInitialState: initialState" + state.getName());
            }
            this.mInitialState = state;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setProcessedMessagesSize(int i) {
            this.mProcessedMessages.setSize(i);
        }

        private final void setupInitialStateStack() {
            if (this.mDbg) {
                a.a(StateMachine.TAG, "setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
            }
            StateInfo stateInfo = this.mStateInfo.get(this.mInitialState);
            this.mTempStateStackCount = 0;
            while (stateInfo != null) {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i = this.mTempStateStackCount;
                stateInfoArr[i] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                this.mTempStateStackCount = i + 1;
            }
            this.mStateStackTopIndex = -1;
            moveTempStateStackToStateStack();
        }

        private final StateInfo setupTempStateStackWithStatesToEnter(State state) {
            this.mTempStateStackCount = 0;
            StateInfo stateInfo = this.mStateInfo.get(state);
            do {
                StateInfo[] stateInfoArr = this.mTempStateStack;
                int i = this.mTempStateStackCount;
                this.mTempStateStackCount = i + 1;
                stateInfoArr[i] = stateInfo;
                stateInfo = stateInfo.parentStateInfo;
                if (stateInfo == null) {
                    break;
                }
            } while (!stateInfo.active);
            if (this.mDbg) {
                a.a(StateMachine.TAG, "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + stateInfo);
            }
            return stateInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void transitionTo(IState iState) {
            this.mDestState = (State) iState;
            if (this.mDbg) {
                a.a(StateMachine.TAG, "StateMachine.transitionTo EX destState" + this.mDestState.getName());
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.mDbg) {
                a.a(StateMachine.TAG, "handleMessage: E msg.what=" + message.what);
            }
            this.mMsg = message;
            if (this.mIsConstructionCompleted) {
                processMsg(message);
                performTransitions();
                if (this.mDbg) {
                    a.a(StateMachine.TAG, "handleMessage: X");
                }
            }
        }

        private SmHandler(Looper looper, StateMachine stateMachine) {
            super(looper);
            this.mDbg = false;
            this.mProcessedMessages = new ProcessedMessages();
            this.mStateStackTopIndex = -1;
            this.mHaltingState = new HaltingState();
            this.mQuittingState = new QuittingState();
            this.mStateInfo = new HashMap<>();
            this.mDeferredMessages = new ArrayList<>();
            this.mSm = stateMachine;
            addState(this.mHaltingState, null);
            addState(this.mQuittingState, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StateMachine(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        this.mSmThread = handlerThread;
        handlerThread.start();
        initStateMachine(str, this.mSmThread.getLooper());
    }

    private void initStateMachine(String str, Looper looper) {
        this.mName = str;
        this.mSmHandler = new SmHandler(looper, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addState(State state, State state2) {
        this.mSmHandler.addState(state, state2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void deferMessage(Message message) {
        this.mSmHandler.deferMessage(message);
    }

    protected final Message getCurrentMessage() {
        return this.mSmHandler.getCurrentMessage();
    }

    protected final IState getCurrentState() {
        return this.mSmHandler.getCurrentState();
    }

    public final Handler getHandler() {
        return this.mSmHandler;
    }

    public final String getName() {
        return this.mName;
    }

    public final ProcessedMessageInfo getProcessedMessageInfo(int i) {
        return this.mSmHandler.getProcessedMessageInfo(i);
    }

    public final int getProcessedMessagesCount() {
        return this.mSmHandler.getProcessedMessagesCount();
    }

    public final int getProcessedMessagesSize() {
        return this.mSmHandler.getProcessedMessagesSize();
    }

    protected void haltedProcessMessage(Message message) {
    }

    protected void halting() {
    }

    public boolean isDbg() {
        return this.mSmHandler.isDbg();
    }

    protected final boolean isQuit(Message message) {
        return this.mSmHandler.isQuit(message);
    }

    public final Message obtainMessage() {
        return Message.obtain(this.mSmHandler);
    }

    public final void quit() {
        if (this.mStarted) {
            this.mStarted = false;
            this.mSmHandler.quit();
        }
    }

    protected void quitting() {
    }

    public final void removeMessage(int i) {
        this.mSmHandler.removeMessages(i);
    }

    protected final void removeMessages(int i) {
        this.mSmHandler.removeMessages(i);
    }

    public final void sendMessage(int i) {
        this.mSmHandler.sendMessage(obtainMessage(i));
    }

    protected final void sendMessageAtFrontOfQueue(int i, Object obj) {
        this.mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(i, obj));
    }

    public final void sendMessageDelayed(int i, long j) {
        this.mSmHandler.sendMessageDelayed(obtainMessage(i), j);
    }

    public void setDbg(boolean z) {
        this.mSmHandler.setDbg(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setInitialState(State state) {
        this.mSmHandler.setInitialState(state);
    }

    public final void setProcessedMessagesSize(int i) {
        this.mSmHandler.setProcessedMessagesSize(i);
    }

    public void start() {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mSmHandler.completeConstruction();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void transitionTo(IState iState) {
        this.mSmHandler.transitionTo(iState);
    }

    protected final void transitionToHaltingState() {
        SmHandler smHandler = this.mSmHandler;
        smHandler.transitionTo(smHandler.mHaltingState);
    }

    protected void unhandledMessage(Message message) {
        if (this.mSmHandler.mDbg) {
            a.d(TAG, this.mName + " - unhandledMessage: msg.what=" + message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addState(State state) {
        this.mSmHandler.addState(state, null);
    }

    public final Message obtainMessage(int i) {
        return Message.obtain(this.mSmHandler, i);
    }

    public final void sendMessage(int i, Object obj) {
        this.mSmHandler.sendMessage(obtainMessage(i, obj));
    }

    protected final void sendMessageAtFrontOfQueue(int i) {
        this.mSmHandler.sendMessageAtFrontOfQueue(obtainMessage(i));
    }

    public final void sendMessageDelayed(int i, Object obj, long j) {
        this.mSmHandler.sendMessageDelayed(obtainMessage(i, obj), j);
    }

    public final Message obtainMessage(int i, Object obj) {
        return Message.obtain(this.mSmHandler, i, obj);
    }

    public final void sendMessage(Message message) {
        this.mSmHandler.sendMessage(message);
    }

    protected final void sendMessageAtFrontOfQueue(Message message) {
        this.mSmHandler.sendMessageAtFrontOfQueue(message);
    }

    public final void sendMessageDelayed(Message message, long j) {
        this.mSmHandler.sendMessageDelayed(message, j);
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        return Message.obtain(this.mSmHandler, i, i2, i3);
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        return Message.obtain(this.mSmHandler, i, i2, i3, obj);
    }

    protected StateMachine(String str, Looper looper) {
        initStateMachine(str, looper);
    }
}
