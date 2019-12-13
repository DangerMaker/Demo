//package com.compass.common.net;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.util.Log;
//
//import com.ez08.support.net.EzCommField;
//import com.ez08.support.net.EzMessage;
//import com.ez08.support.net.EzNet;
//import com.ez08.support.util.EzIntent;
//import com.ez08.support.util.EzKeyValue;
//import com.ez08.support.util.EzValue;
//import com.ez08.tools.IntentTools;
//
//public class NetInterface {
//
//    public static final int TIME_OUT = 15 * 1000;
//    private static final int TIME_OUT_PIC = 50 * 1000;
//
//    public static int authSetInfo(Handler handler, int requestCode,
//                                  String name, String pwd, String imageid, int sex, String realname,
//                                  String email, String city, String provice, String country) {
//
//        Intent intent = new Intent("ez08.auth.ver2.setinfo");
//        intent.putExtra("name", name);
//        intent.putExtra("pwd", pwd);
//        intent.putExtra("realname", realname);
//        intent.putExtra("email", email);
//        if (imageid != null) {
//            intent.putExtra("imageid", imageid);
//        }
//        intent.putExtra("sex", sex);
//        if (city != null) {
//            intent.putExtra("city", city);
//        }
//        if (provice != null) {
//            intent.putExtra("provice", provice);
//        }
//        if (country != null) {
//            intent.putExtra("country", country);
//        }
//        EzMessage message = IntentTools.intentToMessage(intent);
//
//        return EzNet.Request(message, handler, requestCode, 2, TIME_OUT);
//    }
//
//    public static void authgetPinYin(Handler handler, int requestCode,
//                                     String name) {
//        Intent intent = new Intent("ez08.auth.pinyin_name.q");
//        intent.putExtra("realname", name);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        EzNet.Request(message, handler, requestCode, 2, TIME_OUT);
//    }
//
//    /**
//     * 设置用户信息
//     *
//     * @param handler
//     * @param requestCode
//     * @param intent
//     * @return
//     */
//    public static int setUserInfo(Handler handler, int requestCode,
//                                  Intent intent) {
//
//        intent.setAction("ez08.cs.setconfig");
//        EzMessage msg = IntentTools.intentToMessage(intent);
//        EzNet.Request(msg, handler, requestCode, 0, TIME_OUT);
//        return requestCode;
//    }
//
//    /**
//     * 退出登录
//     *
//     * @param handler
//     * @param requestCode
//     * @param intent
//     * @return
//     */
//    public static int setlogOut(Handler handler, int requestCode, Intent intent) {
//
//        intent.setAction("ez08.auth.logout");
//        EzMessage msg = IntentTools.intentToMessage(intent);
//        EzNet.Request(msg, handler, requestCode, 0, TIME_OUT);
//        return requestCode;
//    }
//
//    /**
//     * 密碼設置
//     *
//     * @param intent
//     * @param handler
//     * @param requestCode
//     * @param sn
//     * @param timeout
//     * @return
//     */
//    public static int Request(Intent intent, Handler handler, int requestCode,
//                              int sn, int timeout) {
//        EzMessage msg = IntentTools.intentToMessage(intent);
//        return EzNet.Request(msg, handler, requestCode, sn, timeout);
//    }
//
//    public static int getMyInfo(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.cs.getconfig");
//        return EzNet.Request(IntentTools.intentToMessage(intent), handler,
//                requestCode, 0, TIME_OUT);
//    }
//
//    public static void requestUserInfo(Handler handler, int responseCode,
//                                       String targetCid, boolean dialog) {
//        Intent detailIntent = new Intent("ez08.cs.pubdetail.get");
//        detailIntent.putExtra("targcid", targetCid);
//        EzNet.Request(detailIntent, handler, responseCode, 0, 30);
//        // EzNetProxyRequest(detailIntent, handler, responseCode, 0, true, 0,
//        // dialog);
//    }
//
//    public static void requestGetInfo(Handler handler, int responseCode,
//                                      String targetCid, boolean dialog) {
//        Intent detailIntent = new Intent("ez08.cs.pubinfo.get");
//        detailIntent.putExtra("targcid", targetCid);
//        EzNet.Request(detailIntent, handler, responseCode, 0, 30);
//        // EzNetProxyRequest(detailIntent, handler, responseCode, 0, true, 0,
//        // dialog);
//    }
//
//    public static void EzNetProxyRequest(Intent intent, Handler handler,
//                                         int requestCode, int num1, boolean bool1, int num2, boolean bool2) {
//        EzMessage msg = IntentTools.intentToMessage(intent);
//        EzNet.Request(msg, handler, requestCode, num1, 30);
//    }
//
//    public static EzValue safeGetEzValueFromIntent(Intent intent, String key) {
//        Bundle bundle = intent.getExtras();
//        if (bundle.get(key) != null
//                && bundle.get(key).getClass().equals(EzValue.class)) {
//            EzValue ev = (EzValue) bundle.get(key);
//            return ev;
//        }
//        return null;
//    }
//
//    /**
//     * 首页数据列表
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int requestHomeList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.homelist.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 视频列表
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int requestVideoList(Handler handler, int requestCode,
//                                       String mark, int num) {
//        Intent intent = new Intent("ez08.znt.videolist.q");
//        if (mark != null) {
//            intent.putExtra("mark", mark);
//        }
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 直播列表
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int requestLiveList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.livelist.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 自选股列表
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int requestOptionalShareList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.mystock.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
////        Log.e("nett", message.description());
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    查找股票
//     */
//    public static int requestSearchStock(Handler handler, int requestCode, String key) {
//        Intent intent = new Intent("ez08.zntr.hq.search.q");
//        intent.putExtra("key", key);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 自选股列表2
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int requestGetMyStockList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.mystock3.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取股票基本信息
//     */
//
//    public static int getBaseStockInfo(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.basestockinfo.q");
//        secucode = secucode.substring(0, 2).toUpperCase() + secucode.substring(2);
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 直播心跳
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int requestRoomHeart(Handler handler, int requestCode,
//                                       String id) {
//        Intent intent = new Intent("ez08.znt.live.heartbeat.q");
//        intent.putExtra("id", id);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 关注或取消关注直播接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param operate
//     * @param targid
//     * @return
//     */
//    public static int requestLiveFollow(Handler handler, int requestCode,
//                                        String operate, String targid) {
//        Intent intent = new Intent("ez08.znt.livefollow.operate");
//        intent.putExtra("operate", operate);
//        intent.putExtra("targid", targid);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 资讯列表
//     *
//     * @param handler
//     * @param requestCode
//     * @param mark
//     * @param num
//     * @return
//     */
//    public static int requestInfoList(Handler handler, int requestCode,
//                                      String mark, int num, String category) {
//        Intent intent = new Intent("ez08.znt.infolist.q");
//        if (mark != null) {
//            intent.putExtra("mark", mark);
//        }
//        if (category != null) {
//            intent.putExtra("category", category);
//        }
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        Log.e("des", message.description());
//        String des = message.description();
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 资讯列表
//     *
//     * @param handler
//     * @param requestCode
//     * @param mark
//     * @param num
//     * @return
//     */
//    public static int requestNewInfoList(Handler handler, int requestCode,
//                                         String mark, int num, String category) {
//        Intent intent = new Intent("ez08.znt.infolist2.q");
//        if (mark != null) {
//            intent.putExtra("mark", mark);
//        }
//        if (category != null) {
//            intent.putExtra("category", category);
//        }
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        Log.e("des", message.description());
//        String des = message.description();
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 下发短信验证码接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param mobile
//     * @return
//     */
//    public static int getVerifyRequest(Handler handler, int requestCode,
//                                       String mobile) {
//        Intent intent = new Intent("ez08.auth.sms.send.q");
//        intent.putExtra("mobile", mobile);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 短信登录接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param mobile
//     * @return
//     */
//    public static int verifyLoginRequest(Handler handler, int requestCode,
//                                         String mobile, String code, String randno) {
//        Intent intent = new Intent("ez08.auth.sms.login");
//        intent.putExtra("mobile", mobile);
//        intent.putExtra("code", code);
//        intent.putExtra("randno", randno);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 短信注册接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param mobile
//     * @return
//     */
//    public static int verifyRegistRequest(Handler handler, int requestCode,
//                                          String mobile, String code, String randno) {
//        Intent intent = new Intent("ez08.auth.sms.reg");
//        intent.putExtra("mobile", mobile);
//        intent.putExtra("code", code);
//        intent.putExtra("randno", randno);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 加入某个直播接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param id
//     * @param pwd
//     * @return
//     */
//    public static int requestAddLiving(Handler handler, int requestCode,
//                                       String id, String pwd) {
//        Intent intent = new Intent("ez08.znt.live.join.q");
//        intent.putExtra("id", id);
//        if (pwd != null) {
//            intent.putExtra("pwd", pwd);
//        }
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 2, TIME_OUT);
//    }
//
//    /**
//     * 离开某个直播接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param id
//     * @return
//     */
//    public static int requestDelLiving(Handler handler, int requestCode,
//                                       String id) {
//        Intent intent = new Intent("ez08.znt.live.leave.q");
//        intent.putExtra("id", id);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int requestKefuInfo(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.service.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int sendMessage(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.message");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int requestServiceRating(Handler handler, int requestCode,
//                                           String targcid, int level, String cmt) {
//        Intent intent = new Intent("ez08.znt.service.rating");
//        intent.putExtra("targcid", targcid);
//        intent.putExtra("level", level);
//        intent.putExtra("cmt", cmt);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int selfStockManagment(String secuCode, String operate,
//                                         int newpos, Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.mystock.operate2.q");
//        intent.putExtra("operate", operate);
//        intent.putExtra("secucode", secuCode);
//        if (newpos >= 0) {
//            intent.putExtra("newpos", newpos);
//        }
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    //获取开户状态
//    public static int getYcStatus(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.getycstatus.q");
//        intent.putExtra("mode", 1);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    //创建开户流水单
//    public static int createYcWorkflow(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.createycworkflow.q");
//        intent.putExtra("mode", 1);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//
//    //获取开户状态
//    public static int getKhStatus(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.getkhstatus.q");
////        intent.putExtra("mode", 1);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    //创建开户流水单
//    public static int createKhWorkflow(Handler handler, String zqgs, int requestCode) {
//        Intent intent = new Intent("ez08.znt.createkhworkflow.q");
////        intent.putExtra("mode", 1);
//        intent.putExtra("zqgs", zqgs);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 推送接收成功反馈接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param pushid      推送消息id
//     * @param state       状态 1:成功接收 2:用户正向操作 9:用户取消
//     *                    * @return
//     */
//    public static int pushResultNotify(Handler handler, int requestCode, String pushid, int state) {
//        Intent intent = new Intent("ez08.push.notify");
//        intent.putExtra("pushid", pushid);
//        intent.putExtra("state", state);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 用户分享信息列表获取接口
//     */
//    public static int getShareInfoList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.push.share.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 分享成功回调接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param shareid
//     * @param sharetype
//     * @return
//     */
//    public static int shareResultNotify(Handler handler, int requestCode, String shareid, String sharetype) {
//        Intent intent = new Intent("ez08.push.share.notify");
//        intent.putExtra("shareid", shareid);
//        intent.putExtra("sharetype", sharetype);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取收藏列表
//     *
//     * @param handler
//     * @param requestCode
//     * @param mark
//     * @param num
//     * @return
//     */
//    public static int collectQuery(Handler handler, int requestCode, String mark, int num) {
//        Intent intent = new Intent("ez08.znt.collectlist.q");
//        if (mark != null) {
//            intent.putExtra("mark", mark);
//        }
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 删除收藏
//     *
//     * @param handler
//     * @param requestCode
//     * @param id
//     * @return
//     */
//    public static int collectdel(Handler handler, int requestCode, String id) {
//        Intent intent = new Intent("ez08.znt.collect.del");
//        intent.putExtra("id", id);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 添加收藏
//     *
//     * @param handler
//     * @param requestCode
//     * @param ezMessage
//     * @return
//     */
//    public static int addcollect(Handler handler, int requestCode, EzMessage ezMessage) {
//        Intent intent = new Intent("ez08.znt.collect.add");
//        intent.putExtra("collect", new EzValue(ezMessage));
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 某条消息是否被收藏接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param targetid
//     * @return
//     */
//    public static int iscollected(Handler handler, int requestCode, String targetid) {
//        Intent intent = new Intent("ez08.znt.infoid.iscollected");
//        intent.putExtra("targetid", targetid);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取资金信息接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param period      day（默认）week month
//     * @param secucode    股票代码，形如SH600900
//     * @param mark        日期（标记用）
//     * @param num         数量，>0表示按mark向后取 <0表示按mark向前
//     * @return
//     */
//    public static int getCaptialInfo(Handler handler, int requestCode, String period, String secucode, int mark, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.3cjhistory.q");
//        intent.putExtra("period", period);
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("mark", mark);
//        intent.putExtra("num", num);
//        intent.putExtra("precision", 1);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获得当日资金
//     *
//     * @param handler
//     * @param requestCode
//     * @param secucode
//     * @return
//     */
//    public static int getCurrentCaptialInfo(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.hq.3cjcurrent.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("precision", 1);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取热门信息
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getHotInfo(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.zntr.hq.hotwords.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取热门板块
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getHotPlate(Handler handler, int requestCode, int type, String key) {
//        Intent intent = new Intent("ez08.zntr.hq.hotwords.secucodes2_2.q");
//        intent.putExtra("key", key);
//        intent.putExtra("type", type);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 行情数据接口
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getMarketData(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.zntr.marketpreview.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取全部板块代码和名称（按涨幅排序）
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getPlateList(Handler handler, int requestCode, int sorttype) {
//        Intent intent = new Intent("ez08.zntr.allboard.q");
//        intent.putExtra("sorttype", sorttype);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取板块简要行情信息接口
//     *
//     * @param handler
//     * @param requestCode startindex	Int32	开始索引值，0开始。
//     *                    默认值为0
//     *                    num	Int32	获取数量
//     *                    默认值为20
//     *                    sorttype	Int32	排序类型0/1
//     *                    默认值为0
//     * @return
//     */
//    public static int getPlateInfo(Handler handler, int requestCode, String boardcodes, int startindex, int num, int sorttype) {
//        Intent intent = new Intent("ez08.zntr.boardbrief.q");
//        intent.putExtra("boardcodes", boardcodes);
//        intent.putExtra("startindex", startindex);
//        intent.putExtra("num", num);
//        intent.putExtra("sorttype", sorttype);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取股票简要行情信息接口
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockBrief(Handler handler, int requestCode, String secucodes) {
//        Intent intent = new Intent("ez08.zntr.stockbrief.q");
//        intent.putExtra("secucodes", secucodes);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    //
//    public static int getStockBrief1(Handler handler, String secucodes) {
//        EzIntent message = new EzIntent("ez08.zntr.stockbrief.q");
//        message.putExtraData(new EzKeyValue("secucodes", secucodes));
//        return EzNet.Request(message.toEzMessage(), handler, 1001, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取股票简要行情信息接口 接受4个字母
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockBrief2(Handler handler, int requestCode, String secucodes) {
//        Intent intent = new Intent("ez08.zntr.stockbrief2.q");
//        intent.putExtra("secucodes", secucodes);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取股票简要行情信息接口 接受4个字母
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockBriefWithZhu(Handler handler, int requestCode, String secucodes) {
//        Intent intent = new Intent("ez08.zntr.stockbrief2.q");
//        intent.putExtra("secucodes", secucodes);
//        intent.putExtra("flag", 1);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//
//    /**
//     * 获取股票榜单列表接口
//     *
//     * @param handler
//     * @param requestCode sorttype	int	操作类型
//     *                    0：涨跌幅幅排序从大到小
//     *                    1:  涨跌幅排序从小到大
//     *                    2:  涨跌值排序从大到小
//     *                    3:  涨跌值排序从小到大
//     *                    4:  最新价格从大到小
//     *                    5.  最新价格从小到大
//     *                    type	int	0:沪深A
//     *                    1:board板块
//     *                    其他扩展的暂不支持
//     *                    boardcode	String	板块代码，type=1时，需要提供
//     *                    startindex	Int32	可选，开始索引，默认值0
//     *                    num	Int32	可选，默认值 -1,获取全部；
//     *                    如果要部分数据，传入对应的数值;
//     * @return
//     */
////    public static int getSortStockList(Handler handler, int requestCode, int sorttype, int type, String boardcode, int startindex, int num) {
////        Intent intent = new Intent("ez08.zntr.sortstocklist.q");
////        intent.putExtra("sorttype", sorttype);
////        intent.putExtra("type", type);
////        intent.putExtra("boardcode", boardcode);
////        intent.putExtra("startindex", startindex);
////        intent.putExtra("num", num);
////        EzMessage message = IntentTools.intentToMessage(intent);
////        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
////    }
//    public static int getSortStockList(Handler handler, int requestCode, int sorttype, int type, String boardcode, int startindex, int num) {
//        Intent intent = new Intent("ez08.zntr.sortstocklist.q");
//        intent.putExtra("sorttype", sorttype);
//        intent.putExtra("type", type);
//        intent.putExtra("boardcode", boardcode);
//        intent.putExtra("startindex", startindex);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getSortStockList2(Handler handler, int requestCode, int sorttype, int type, String boardcode, int startindex, int num) {
//        Intent intent = new Intent("ez08.zntr.sortstocklist2.q");
//        intent.putExtra("sorttype", sorttype);
//        intent.putExtra("type", type);
//        intent.putExtra("boardcode", boardcode);
//        intent.putExtra("startindex", startindex);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 指数列表接口
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getIndexList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.zntr.hq.indexmonitor.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
////    /**
////     * 获取服务等级
////     *
////     * @param handler
////     * @param requestCode
////     * @param card
////     * @return
////     */
////    public static int getMyCardLevel(Handler handler, int requestCode, String card) {
////        Intent intent = new Intent("ez08.znt.custinfo.q");
////        intent.putExtra("mobile", card);
////        EzMessage message = IntentTools.intentToMessage(intent);
////        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
////    }
//
//    /**
//     * 龙虎榜
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockCharts(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.zntr.hq.hotwords2.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 三看榜
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStock3(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.zntr.hq.top3.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取股票详细报价信息
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockDetailNew(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.hq.stockdetail.q");
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取成交明细
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockReport(Handler handler, int requestCode, String secucode, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.report.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取股票详细报价信息
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockCapitalNew(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.hq.3cjcurrent.detail.q");
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 分时
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockmLineNew(Handler handler, int requestCode, String secucode, int mark) {
//        Intent intent = new Intent("ez08.zntr.hq.mline.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("mark", mark);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getStockCapitalListNew(Handler handler, int requestCode, String secucode, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.3cjhistory.detail.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//       获取k线数据
//     */
//    public static int getStockKlineNew(Handler handler, int requestCode, String secucode, String period, int mark, int time, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.kline.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("time", time);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获取dr
//     */
//    public static int getStockDrHistory(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.hq.drhistory.q");
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获得十档买卖盘
//    */
//    public static int getLevel2Trade10(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.hq.l2.bs10.q");
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获取逐笔成交明细
//    */
//    public static int getLevel2EachDetail(Handler handler, int requestCode, String secucode, int time, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.l2.trans.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("time", time);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 刷新时获取逐笔成交明细
//     */
//    public static int getLevel2EachDetail(Handler handler, int requestCode, String secucode, int time, int flowid, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.l2.trans.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("time", time);
//        intent.putExtra("num", num);
//        intent.putExtra("flowid", flowid);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获得买卖队列
//    */
//    public static int getLevel2Queue(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.hq.l2.orderqueue.q");
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获得券商列表
//    */
//    public static int getTradeList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.tradelist.q");
//        intent.putExtra("model", android.os.Build.MODEL);
//        intent.putExtra("manufacturer", android.os.Build.MANUFACTURER);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    我的券商操作
//    */
//    public static int setMyTrade(Handler handler, int requestCode, String op, String trader) {
//        Intent intent = new Intent("ez08.znt.mytrader.operate.q");
//        intent.putExtra("op", op);
//        intent.putExtra("trader", trader);
//        intent.putExtra("model", android.os.Build.MODEL);
//        intent.putExtra("manufacturer", android.os.Build.MANUFACTURER);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获取最新一条财报数据
//    */
//    public static int getFinLast(Handler handler, int requestCode, String secucode, String tablenames) {
//        Intent intent = new Intent("ez08.zntr.hq.fin.last.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("tablenames", tablenames);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获取历史财报数据
//    */
//    public static int getFinHistory(Handler handler, int requestCode, String secucode, String tablenames, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.fin.list.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("tablenames", tablenames);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获取历史财报数据 /十大股东
//    */
//    public static int getFinHistory(Handler handler, int requestCode, String secucode, String tablenames, int num, int shareholders_num) {
//        Intent intent = new Intent("ez08.zntr.hq.fin.list.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("tablenames", tablenames);
//        intent.putExtra("num", num);
//        intent.putExtra("shareholders_num", shareholders_num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    获取公司基本信息
//    */
//    public static int getCompanyProfile(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.hq.fin.company.profile.q");
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    统计
//    */
//    public static int setControlStatis(Handler handler, int requestCode, String[] list) {
//        Intent intent = new Intent("ez08.zntlog.log.q");
//
//        for (int i = 0; i < list.length; i++) {
//            Log.e("zntlog", list[i]);
//        }
//
//        intent.putExtra("list", list);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    上传异常log
//    */
//    public static int setLogException(Handler handler, int requestCode, String exception) {
//        Intent intent = new Intent("ez08.zntlog.exception");
//        intent.putExtra("exception", exception);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    筹码分布
//    */
//    public static int getCMFB(Handler handler, int requestCode, String secucode, String period, int date, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.cmfb.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", date);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    发开户短信接口
//    */
//    public static int getKHSendCode(Handler handler, int requestCode, String mobile) {
//        Intent intent = new Intent("ez08.znt.kh.sendcode.q");
//        intent.putExtra("mobile", mobile);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /*
//    验证短信接口
//    */
//    public static int getKHVerifyCode(Handler handler, int requestCode, String mobile, String code) {
//        Intent intent = new Intent("ez08.znt.kh.verifycode.q");
//        intent.putExtra("mobile", mobile);
//        intent.putExtra("code", code);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 提交猜猜
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockPostGuess(Handler handler, int requestCode, String secucode, int myvote) {
//        Intent intent = new Intent("ez08.znt.caicai.vote.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("myvote", myvote);
//
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 获取猜猜
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getStockGuess(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.zntr.caicai.q");
//        intent.putExtra("secucode", secucode);
//
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//
//    /**
//     * 发送绑定验证码接口
//     *
//     * @param handler
//     * @param requestCode
//     * @param mobile
//     * @return
//     */
//    public static int bindSendCode(Handler handler, int requestCode, String mobile) {
//        Intent intent = new Intent("ez08.auth.bindmobile.sendsms");
//        intent.putExtra("mobile", mobile);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//
//    /**
//     * 绑定手机
//     *
//     * @param handler
//     * @param requestCode
//     * @param mobile
//     * @param code
//     * @return
//     */
//    public static int bindVerifyCode(Handler handler, int requestCode, String mobile, String code) {
//        Intent intent = new Intent("ez08.auth.bindmobile.bind");
//        intent.putExtra("mobile", mobile);
//        intent.putExtra("smscode", code);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 盯盘数据接口
//     *
//     * @param handler
//     * @param requestCode
//     * @return
//     */
//    public static int getDingPanData(Handler handler, int requestCode, int day) {
//        Intent intent = new Intent("ez08.zntr.dingpan.q");
//        intent.putExtra("day", day);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getFundsData(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.zntr.hq.toplh.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    //添加 修改自选股
//    public static int editMyStock(Handler handler, int requestCode, String[] secucodes) {
//        Intent intent = new Intent("ez08.znt.mystock3.edit.q");
//        intent.putExtra("secucodes", secucodes);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    //查询 自选股
//    public static int getMyStock(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.znt.mystock3.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int deleteMyStock(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.znt.mystock3.delete.q");
//        intent.putExtra("secucode", secucode);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//
//    public static int getStockDHYD(Handler handler, int requestCode, String secucode, String period, int mark, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.dhyd.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getStockHJK(Handler handler, int requestCode, String secucode, String period, int mark, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.dcys.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getStockHJK(Handler handler, int requestCode, String secucode, String period, int mark, int min, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.dcys.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("time", min);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getStockDLD(Handler handler, int requestCode, String secucode, String period, int mark, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.dld.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getStockDLD(Handler handler, int requestCode, String secucode, String period, int mark, int min, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.dld.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("time", min);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//
//    public static int getStockCXJC(Handler handler, int requestCode, String secucode, String period, int mark, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.cw.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getStockCXJC(Handler handler, int requestCode, String secucode, String period, int mark, int min, int num) {
//        Intent intent = new Intent("ez08.zntr.hq.cw.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("period", period);
//        intent.putExtra("date", mark);
//        intent.putExtra("time", min);
//        intent.putExtra("num", num);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//    public static int getPushList(Handler handler, int requestCode) {
//        Intent intent = new Intent("ez08.push.list.q");
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int addStockWarn(Handler handler, int requestCode, String secucode, String[] subslist) {
//        Intent intent = new Intent("ez08.znt.stock.subscribe.q");
//        intent.putExtra("secucode", secucode);
//        intent.putExtra("subslist", subslist);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int refreshStockWarn(Handler handler, int requestCode, String secucode) {
//        Intent intent = new Intent("ez08.znt.stock.subslist.q");
//        if (secucode != null) {
//            intent.putExtra("secucode", secucode);
//        }
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int deleteStockWarn(Handler handler, int requestCode, String secucodes) {
//        Intent intent = new Intent("ez08.znt.stock.subsdelete.q");
//        if (secucodes != null) {
//            intent.putExtra("secucodes", secucodes);
//        }
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getKeFuList(Handler handler, long lastts, int requestCode) {
//        Intent intent = new Intent("ez08.znt.servicemessage.q");
//        intent.putExtra("lastts", lastts);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getLivingList(Handler handler, String roomId, long lastts, int requestCode) {
//        Intent intent = new Intent("ez08.znt.roommessage.q");
//        intent.putExtra("roomid", roomId);
//        intent.putExtra("lastts", lastts);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int setToken(Handler handler, int requestCode, int state, String token) {
//        Log.e("setToken", state + "----token" + token);
//        Intent intent = new Intent("ez08.push.apntoken.sync");
//        intent.putExtra("state", state);
//        intent.putExtra("apntoken", token);
//        intent.putExtra("model", android.os.Build.MODEL);
//        intent.putExtra("manufacturer", android.os.Build.MANUFACTURER);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    public static int getFromPushId(Handler handler, int requestCode, String pushid) {
//        Intent intent = new Intent("ez08.push.info.id.q");
//        intent.putExtra("id", pushid);
//        EzMessage message = IntentTools.intentToMessage(intent);
//        return EzNet.Request(message, handler, requestCode, 0, TIME_OUT);
//    }
//
//    /**
//     * 擒龙平台战区、板块列表
//     * @param handler
//     * @param sortfield1 战区排序类型 0 涨幅 1卡位 2 轮动 3 决策 4 最新价
//     * @param sorttype1  排序 0降序  1升序
//     * @param sortfield2 行业排序类型  0 涨幅 1卡位 2 轮动 3 决策 4 最新价
//     * @param sorttype2
//     * @param policy     决策  0长线  1小时
//     * @return
//     */
//    public static int getBoardList(Handler handler, int requestCode, int sortfield1, int sorttype1, int sortfield2, int sorttype2, int policy) {
//        Intent intent = new Intent("ez08.zntr.ql.boardlist.q");
//        intent.putExtra("sortfield1", sortfield1);
//        intent.putExtra("sorttype1", sorttype1);
//        intent.putExtra("sortfield2", sortfield2);
//        intent.putExtra("sorttype2", sorttype2);
//        intent.putExtra("policy", policy);
//        EzMessage ezMessage = IntentTools.intentToMessage(intent);
//        return EzNet.Request(ezMessage,handler,requestCode,0,TIME_OUT);
//
//    }
//
//    /**
//     * 获取擒龙平台战区、板块信息
//     * @param handler
//     * @param requestCode
//     * @param codes  代码字符串，逗号分隔
//     * @param policy 决策,0长线，1小时
//     * @return
//     */
//    public static int getBoardBrief(Handler handler, int requestCode, String codes, int policy){
//        Intent intent = new Intent("ez08.zntr.ql.boardbrief.q");
//        intent.putExtra("codes", codes);
//        intent.putExtra("policy", policy);
//        EzMessage ezMessage = IntentTools.intentToMessage(intent);
//        return EzNet.Request(ezMessage,handler,requestCode,0,TIME_OUT);
//    }
//
//    /**
//     * 擒龙平台股票列表
//     * @param handler
//     * @param requestCode
//     * @param boardlist
//     * @param policy
//     * @param sortfield
//     * @param sorttype
//     * @param filter
//     * @return
//     */
//
//    public static int getStockList(Handler handler, int requestCode, String boardlist, String marketlist, int policy, int class1, int sortfield, int sorttype, int filter){
//        Log.e("boardlist",boardlist + "");
//        Log.e("marketlist",marketlist + "");
//        Log.e("policy",policy + "");
//        Log.e("class1",class1 + "");
//        Log.e("sortfield",sortfield + "");
//        Log.e("sorttype",sorttype + "");
//        Log.e("filter",filter + "");
//        Intent intent = new Intent("ez08.zntr.ql.stocklist.q");
//        intent.putExtra("boardlist", boardlist);
//        intent.putExtra("marketlist", marketlist);
//        intent.putExtra("class", class1);
//        intent.putExtra("sortfield", sortfield);
//        intent.putExtra("sorttype", sorttype);
//        intent.putExtra("filter", filter);
//        intent.putExtra("policy", policy);
//        EzMessage ezMessage = IntentTools.intentToMessage(intent);
//        return EzNet.Request(ezMessage,handler,requestCode,0,TIME_OUT);
//    }
//
//    /**
//     *
//     * @param handler
//     * @param requestCode
//     * @param codes
//     * @param policy
//     * @return
//     */
//    public static int getStocksBrief(Handler handler, int requestCode, String codes, int policy){
//        Intent intent = new Intent("ez08.zntr.ql.stockbrief.q");
//        intent.putExtra("codes", codes);
//        intent.putExtra("policy", policy);
//        EzMessage ezMessage = IntentTools.intentToMessage(intent);
//        return EzNet.Request(ezMessage,handler,requestCode,0,TIME_OUT);
//    }
//
//    //获取资金板块列表
//    public static int getFundsBroad(Handler handler, int requestCode, int period, int sortfield, int sorttype, int type){
//        Intent intent = new Intent("ez08.zntr.qlzj.boardlist.q");
//        intent.putExtra("period", period);
//        intent.putExtra("sortfield", sortfield);
//        intent.putExtra("sorttype", sorttype);
//        intent.putExtra("type", type);
//        EzMessage ezMessage = IntentTools.intentToMessage(intent);
//        return EzNet.Request(ezMessage,handler,requestCode,0,TIME_OUT);
//    }
//
//    //获取资金板块内股票列表
//    public static int getFundsBroadStocks(Handler handler, int requestCode, int period, int sortfield, int sorttype, String boardcode){
//        Intent intent = new Intent("ez08.zntr.qlzj.stocklist.q");
//        intent.putExtra("period", period);
//        intent.putExtra("sortfield", sortfield);
//        intent.putExtra("sorttype", sorttype);
//        intent.putExtra("boardcode", boardcode);
//        EzMessage ezMessage = IntentTools.intentToMessage(intent);
//        return EzNet.Request(ezMessage,handler,requestCode,0,TIME_OUT);
//    }
//
//    //获取资金股票列表
//    public static int getFundsStocks(Handler handler, int requestCode, String codes, int period){
//        Intent intent = new Intent("ez08.zntr.qlzj.stockbrief.q");
//        intent.putExtra("codes", codes);
//        intent.putExtra("period", period);
//        EzMessage ezMessage = IntentTools.intentToMessage(intent);
//        return EzNet.Request(ezMessage,handler,requestCode,0,TIME_OUT);
//    }
//
//}
