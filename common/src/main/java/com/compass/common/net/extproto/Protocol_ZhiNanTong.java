package com.compass.common.net.extproto;

public class Protocol_ZhiNanTong {
    //
    public static final String proto_zhinantong = "message msg.znt.infomation(4801){" +
            "required string id = 1;" +
            "required string content = 2;" +
            "required string imageid = 3;" +
            "required string title = 4;" +
            "required string url = 5;" +
            "required int64 time = 6;" +
            "required string category  = 7;" +
            "required string source = 8;" +
            "}" +
            "message msg.znt.video(4802){" +
            "required string id = 1;" +
            "required string content = 2;" +
            "required string imageid = 3;" +
            "required string title = 4;" +
            "required string url = 5;" +
            "required int64 time = 6;" +
            "}" +
            "message msg.znt.live(4803){" +
            "required string id = 1;" +
            "required string content = 2;" +
            "required string imageid = 3;" +
            "required string title = 4;" +
            "required string url = 5;" +
            "required int64 starttime = 6;" +
            "required int64 endtime = 7;" +
            "required string professor = 8;" +
            "required int32 type = 9;" +
            "required boolean isfollow = 10;" +
            "required string roomid = 11;" +
            "}"  +
            "message msg.znt.home(4804){" +
            "required int32 type = 1;" +
            "required msg.znt.infomation info = 2;" +
            "required msg.znt.video video = 3;" +
            "required msg.znt.live live = 4;" +
            "}"  +
            "message msg.znt.room(4805){" +
            "required string id = 1;" +
            "required string name = 2;" +
            "required string imageid = 3;"+
            "required int32 type= 4;"+
            "}" +
            "message msg.znt.collect(4806){" +
            "required string id = 1;" +
            "required string content = 2;" +
            "required string imageid = 3;"+
            "required string title= 4;"+
            "required int64 time = 5;" +
            "required string url = 6;" +
            "required int32 type = 7;" +
            "required string category = 8;" +
            "}" +
            "message msg.push.info(5001){" +
            "required string id = 1;" +
            "required string pushtype = 2;" +
            "required string title = 3;" +
            "required string description = 4;" +
            "required string imgurl = 5;" +
            "required string uri = 6;" +
            "required int32 burnflg = 7;" +
            "required string creatorid = 8;" +
            "required string creatorname = 9;" +
            "required string publisherid = 10;" +
            "required string publishername = 11;" +
            "required int64 createtime = 12;" +
            "required int64 publishtime = 12;" +
            "required int64 updatetime = 14;" +
            "required int64 starttime = 15;" +
            "required int64 endtime = 16;" +
            "required int32 usertype = 17;" +
            "required int32 usergroupid = 18;" +
            "required string memo = 19;" +
            "required int32 state = 20;" +
            "required int32 imgpos = 21;" +
            "}" +
            "message msg.push.share(5002){" +
            "required string id = 1;" +
            "required string sharetype = 2;" +
            "required string title = 3;" +
            "required string description = 4;" +
            "required string imgurl = 5;" +
            "required string url = 6;" +
            "required string creatorid = 7;" +
            "required string creatorname = 8;" +
            "required int32 usertype = 9;" +
            "required int32 usergroupid = 10;" +
            "required int64 createtime = 11;" +
            "required int64 updatetime = 12;" +
            "required string memo = 13;" +
            "required int32 state = 14;" +
            "}"+
            "message msg.secu.index.3cj(4861){" +
            "required int32 date = 1;" +
            "required sint32 zhu = 2;" +
            "required sint32 gan = 3;" +
            "required sint32 duo = 4" +
            "}"+
            "message msg.secu.wavecj(4850){" +
            "required int32 bcount = 1;" +
            "required int64 bvolume = 2;" +
            "required int64 bamount = 3;" +
            "required int32 scount = 4;" +
            "required int64 svolume = 5;" +
            "required int64 samount = 6;" +
            "}" +
            "message msg.secu.base(4851){" +
            "required int32 idstk = 1;" +//品种ID
            "required int32 date = 2;" +//数据日期
            "required int32 decm = 3;" +//价格转换成整数时需要乘的幂数(0～7)，实际乘数应该是 10 exp (wDecm-2)。0:乘0.01  1:乘0.1  2:乘1 3:乘10 ……
            "required int32 volexp = 4;" +//计算均价时，成交量需要乘的幂数(0～3)，实际乘数应该是 (10 exp yVolExp)，总的来说成交量的乘数应该是 vol * (10 exp yVolExp) * (yVolMul+1)
            "required int32 volmul = 5;" +//计算均价时，成交量需要乘的数字(0～127)，实际乘数应该是 (yVolMul+1)，总的来说成交量的乘数应该是 vol * (10 exp yVolExp) * (yVolMul+1)
            "required int32 time = 6;" +
            "}" +
            "message msg.secu.dr(4852){" +
            "required int32 date = 1;" +
            "required int64 dr = 2;" +//除权
            "required int64 tq = 3;" +//流通盘
            "}" +
            "message msg.secu.wave3cj(4853){" +
            "required msg.secu.base base = 1;" +
            "required msg.secu.wavecj ge_z = 2;" +
            "required msg.secu.wavecj jg = 3;" +
            "required msg.secu.wavecj san_b = 4;" +
            "required msg.secu.wavecj san_z = 5;" +
            "required msg.secu.wavecj sg_z = 6;" +
            "required msg.secu.wavecj te_b = 7;" +
            "required msg.secu.wavecj zhu_b = 8;" +
            "required msg.secu.wavecj zhu_z = 9;" +
            "required int32 date = 10;" +
            "}"+
            "message msg.secu.l1(4854){" +
            "required msg.secu.base base = 1;" + //基本信息
            "required int32 open = 2;" + //开盘价格
            "required int32 high = 3;" + //最高价格
            "required int32 low = 4;" + //最低价格
            "required int32 current = 5;" + //当前最新价格
            "required int64 volume = 6;" + //成交量
            "required int64 amount = 7;" + //成交额
            "required int64 trans = 8;" + // 成交笔数
            "required int64 buyvolume = 9;" + // 主买盘，主卖盘=成交量-主买盘
            "repeated int32 b5prices = 10;" + // 买5价格数组
            "repeated int64 b5volumes = 11;" + // 买5量数组
            "repeated int32 s5prices = 12;" + // 卖5价格数组
            "repeated int64 s5volumes = 13;" +// 卖5量数组
            "required int32 lastclose = 14;" +//昨收盘
            "required string secuname = 15;" +//股票名称,这个往后是新加的
            "required string secucode = 16;" +//股票代码
            "required int32 state = 17;" + //状态（是否停盘,0正常，1停盘)
            "required int32 type = 18;" + //股票类型，完整分类数字
            "required string fullstate = 19;" +//完整状态，具体见之前的状态码说明
            "required int64 marketvalue = 20;" +//市值
            "required int64 tmarketvalue = 21;" +//流通市值
            "required int32 peratio = 22;" +//市盈率
            "required int32 toratio = 23;" +//换手率
            "}"+
            "message msg.secu.stockbrief(4855){" +
            "required string secucode = 1;" + //股票代码
            "required string secuname = 2;" + //股票名称
            "required int32 lastclose = 3;" + //昨收盘
            "required int32 current = 4;" + //当前最新价格
            "required int32 state = 5;" + //状态（是否停盘,0正常，1停盘)
            "required int32 exp = 6;" + //计算价时，成交量需要乘的幂数(0～3)，实际乘数应该是 (10 exp yVolExp)
            "required int32 date = 7;" +//日期,这个往后是新加的
            "required int32 time = 8;" +//时间
            "required int32 type = 9;" +//股票类型，完整分类数字
            "required string fullstate = 10;"+//完整状态，具体见之前的状态码说明
            "}"+
            "message msg.secu.indexl1(4856){" +
            "required msg.secu.base base = 1;" +//基本信息
            "required int32 open = 2;" +
            "required int32 high = 3;" +
            "required int32 low = 4;" +
            "required int32 current = 5;" +
            "required int64 volume = 6;" +
            "required int64 amount = 7;" +
            "required int64 zbidvolume = 8;" + //委买总量
            "required int64 zaskvolume = 9;" + //委卖总量
            "required int32 zup = 10;" +//涨家数
            "required int32 zdown = 11;" +//跌家数
            "required int32 zequal = 12;" +//平家数
            "required int32 lastclose = 13;" +
            "required string secuname = 14;" +//这个往后是新加的
            "required string secucode = 15;" +
            "required int32 exp = 16;" +//计算价时，成交量需要乘的幂数(0～3)，实际乘数应该是 (10 exp yVolExp)
            "}"+
            "message msg.secu.boardbrief(4857){" +
            "required string boardcode = 1;" +
            "required string boardname = 2;" +
            "required int32 lastclose = 3;" +
            "required int32 current = 4;" +
            "required int32 hsrate = 5;" +
            "required string firststockcode = 6;" +
            "required string firststockname = 7;" +
            "required int32 firststockzf = 8;" +
            "required int32 exp = 9;" +
            "}"+
            "message msg.secu.index.3cj(4861){" +
            "required int32 date = 1;" +
            "required sint32 zhu = 2;" +
            "required sint32 gan = 3;" +
            "required sint32 duo = 4" +
            "}"+
            "message msg.secu.kline(4901){" +
            "required int32 date = 1;" +//日期，如果是分钟k线，对应是时分秒
            "required int32 open = 2;" +//开盘价格
            "required int32 close = 3;" +//收盘价格
            "required int32 high = 4;" +//最高价格
            "required int32 low = 5;" +//最低价格
            "required int64 volume = 6;" +//成交量
            "required int64 amount = 7;" +//成交额
            "required int32 time = 8;" +//时分秒，分钟k线时需要使用
            "}"+
            "message msg.secu.mline(4903){" +
            "required int32 date = 1;" +//对应分时的时分秒格式
            "required int32 current = 2;" +//价格
            "required int64 volume = 3;" +//分时量
            "required int64 amount = 4;" +//分时额
            "}"+
            "message msg.secu.report(4904){" +//成交明细
            "required int32 date = 1;" +//日期
            "required int32 price = 2;" +//价格
            "required int64 volume = 3;" +//成交量
            "required int64 amount = 4;" +//成交额
            "required int32 flag = 5;" +//最低两位表示主买主卖，0:未知		1:(买价成交)		2:(卖价成交)
            "required int32 trans = 6;" +//在股票的成交明细中，这个域标识当前有多少笔逐笔
            "}"+
            "message msg.secu.fulldetail(4905){" +//完整报价信息，区分个股和指数
            "required int32 type = 1;" +//完整的类型
            "required msg.secu.l1 l1=2;"+//个股信息，个股时有效
            "required msg.secu.indexl1 indexl1=3;"+//指数信息，指数时有效
            "}"+
            "message msg.secu.l2.bs10(4910){" +
            "repeated int32 b10prices = 1;" +//买10价格数组
            "repeated int64 b10volumes = 2;" +//买10量数组
            "repeated int32 s10prices = 3;" +//卖10价格数组
            "repeated int64 s10volumes = 4;" +//卖10价格数组
            "required int32 decm = 5;" +//数据精度
            "required int32 date = 6;" +//日期
            "required int32 time = 7;" +//时间
            "}"+
            "message msg.secu.l2.orderqueue(4911){" +//买卖队列
            "required int32 totalcount = 1;" +//总委托数
            "required int32 price = 2;" +//委托价格
            "required int32 ordercount = 3;" +//委托数量，标识下面的 order 域有多少个节点
            "repeated int64 order = 4;" +//order数组
            "required int32 decm = 5;" +
            "required int32 date = 6;" +//日期
            "required int32 time = 7;" +//时间
            "}"+
            "message msg.secu.cmfb(4906){" +
            "required int32 date = 1;" +//日期
            "required int32 decm = 2;"+//
            "required int32 high = 3;"+//最高价
            "required int32 low = 4;"+//最低价
            "repeated int32 weights = 5;"+//int32[100]
            "}"+
            "message msg.secu.l2.trans(4912){" +//逐笔
            "required int32 time = 1;" +//时间
            "required int32 flowid = 2;" +//flowid 标识此笔逐笔是本股票的第几笔逐笔
            "required int32 price = 3;" +//价格
            "required int64 volume = 4;" +//量
            "required int32 ytype = 5;" +//操作类型
            "required int32 decm = 6;" +//数据精度
            "required int32 date = 7;" +//日期
            "}" +
            "message msg.secu.index.dhyd(4920){" +//d股价活跃度
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required int32 dhyd13 = 3;" +//股价活跃度13日
            "required int32 dhyd34 = 4;" +//股价活跃度34日
            "}"+
            "message msg.secu.index.cw(4921){" +//开减仓
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required int32 cw = 3;" +//仓位，仓位 0：不持仓，1-100，牛，128-255熊
            "required int64 poolincflag = 4;"+
            "}"+
            "message msg.secu.index.dcys(4922){" +//黄金坑
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required int32 hjk = 3;" +//黄金坑值
            "}" +
            "message msg.secu.index.ld(4923){" +//轮动指数
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required int32 ldmarket1 = 3;" +//市场轮动值1
            "required int32 ldmarket2 = 4;" +//市场轮动值2
            "required int32 ldmarket3 = 5;" +//市场轮动值3
            "required int32 ldtrade1 = 6;" +//行业轮动值1
            "required int32 ldtrade2 = 7;" +//行业轮动值2
            "required int32 ldtrade3 = 8;" +//行业轮动值3
            "required int32 ld0z1 = 9;" +//0Z轮动值1
            "required int32 ld0z2 = 10;" +//0Z轮动值2
            "required int32 ld0z3 = 11;" +//0Z轮动值3
            "}"+
            "message msg.secu.index.servercys(4925){" +//server黄金坑
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required int32 cys5 = 3;" +//黄金坑5*1000
            "required int32 cys34 = 4;" +//黄金坑34*1000
            "required int32 cys60 = 5;" +//黄金坑60*1000
            "required int32 cys120 = 6;" +//黄金坑120*1000
            "required int32 cys240 = 7;" +//黄金坑240*1000
            "required int32 cys480 = 8;" +//黄金坑480*1000
            "required int32 phyd34 = 9;" +//股价活跃度34*1000
            "required int32 phyd60 = 10;" +//股价活跃度60*1000
            "required int32 phyd120 = 11;" +//股价活跃度120*1000
            "}"+
            "message msg.secu.ql.board(4926){" +//擒龙平台 战区/行业数据
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required string code = 3;" +//代码
            "required string name = 4;" +//名称
            "required int32 policy = 5;" +//长线(或小时)决策 0:空仓 1:持仓 2：开仓
            "required int32 ldmarket = 6;" +//战区轮动,0:轮空，1:开始轮动，2:轮动中
            "required int32 ldtrade = 7;" +//行业轮动	,0:轮空，1:开始轮动，2:轮动中
            "required int32 ld0z = 8;" +//0Z轮动,0:轮空，1:开始轮动，2:轮动中
            "required int32 lastclose = 9;" +//昨收盘
            "required int32 current = 10;" +//当前价格
            "required int32 decm = 11;" +//价格数据精度
            "required int32 state = 12;" +//状态 0:正常 1:无效
            "}"+
            "message msg.secu.ql.stock(4927){" +//擒龙平台 个股数据
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required string code = 3;" +//代码
            "required string name = 4;" +//名称
            "required int32 policy = 5;" +//长线(或小时)决策 0:空仓 1:持仓 2：开仓
            "required int32 ldmarket = 6;" +//战区轮动,0:轮空，1:开始轮动，2:轮动中
            "required int32 ldtrade = 7;" +//行业轮动	,0:轮空，1:开始轮动，2:轮动中
            "required int32 ld0z = 8;" +//0Z轮动,0:轮空，1:开始轮动，2:轮动中
            "required string kawei = 9;" +//卡位
            "required int32 lanchou = 10;" +//蓝筹，0:非蓝筹，1：蓝筹
            "required int32 isnew = 11;" +//是否新股
            "required int32 isst = 12;" +//是否ST股
            "required int32 lastclose = 13;" +//昨收盘
            "required int32 current = 14;" +//当前价格
            "required int32 decm = 15;" +//价格数据精度
            "required int32 state = 16;" +//状态 0:正常 1:无效
            "}"+
            "message msg.secu.qlzj.stock(4928){" +//资金动向，数据
            "required int32 date = 1;"+
            "required int32 time = 2;"+
            "required string code = 3;" +//代码(股票或板块)
            "required string name = 4;" +//名称
            "required int64 duo = 5;" +//多空资金,元
            "required int32 duor = 6;" +//多空增减仓,原浮点值x100000
            "required int64 zhu = 7;" +//主力资金,元
            "required int32 zhur = 8;" +//主力增减仓,原浮点值x100000
            "required int64 gan = 9;" +//敢死队资金,元
            "required int32 ganr = 10;" +//敢死队增减仓,原浮点值x100000
            "required int32 lastclose = 11;" +//昨收盘
            "required int32 current = 12;" +//当前价格
            "required int32 decm = 13;" +//价格数据精度
            "required int32 state = 14;" +//状态 0:正常 1:无效
            "}";
}
