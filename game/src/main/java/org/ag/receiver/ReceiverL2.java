package org.ag.receiver;

import org.ag.Login2WsClient;
import org.ag.decode.Decode_L2_131073;
import org.ag.UserManage;

public class ReceiverL2 {

//    return this.code = t.getInt(),
//            this.token = t.getU(16),
//            this.datetime = t.getLong().high,
//            this.userFlag = t.getInt(),
//            this.plazaServer = Base.getString(t, 32),
//            this.serverId = Base.getString(t, 4),
//            this.uid = Base.getString(t, 16), this.freemode = t.getInt(), true;

//    var t = e.code;
//    Log.i("receive LoginBack " + t),
//    SocketClient.isOtherLogin = false, 0 == t ?
//            (this.mUserType = e.userFlag,
//            this.mToken = e.token, this.mUser.uuid = e.uid, this.freemode = e.getFreemode(), this.lineFreemode = e.getLineFreemode(), this.sessionId = e.getSession(), this.stamp = Math.floor(TimeAsyner.currentTimeMillis() - 1e3 * e.datetime), QueryManager.getInstance().setToken(e.token), SocketClient.setOtherLogin(false), this.mClient.setLoginState(true), PlazaManager.getInstance().loginSvr(e.plazaServer), Log.d("sid = " + this.sessionId), PlazaManager.getInstance().isReIn = false, TimeAsyner.setServerTime(e.datetime, false), this.sendHealth()) : (this.mClient.setLoginState(false), this.mClient.destroy(false)),
//            MessageBus.getBusFactory().send(MessageKeys.MSG_LOGIN_RESULT, t);

    public static void receive(Decode_L2_131073 l2){

        UserManage.mToken = l2.getToken();

        //触发登入2
        Login2WsClient.login(l2.getToken());

        //todo 发送心跳
    }

    private void sendHealth(){
//        var e = this;
//        BaseManager._exit = false, 0 == this.timerId && (this.timerId = setInterval(function () {
//            e.onHeart();
//        }, 1e4));
    }

    private void onHeart(){
//        this.checkHeart(),
//                this.H1.updateSeq(),
//                this.mClient.addCmd(this.H1),
//                this.lastSendH1Seq = this.H1.getcSeq(),
//                this.lastSendH1Time = TimeAsyner.currentTimeMillis(),
//                Log.i(this.getKey() + "-->H1 " + this.lastSendH1Seq);
    }
}
