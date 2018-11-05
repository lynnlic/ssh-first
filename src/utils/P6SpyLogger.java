//package utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.p6spy.engine.logging.Category;
//import com.p6spy.engine.spy.appender.StdoutLogger;
//
//public class P6SpyLogger extends StdoutLogger {
//
//    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//	private Object strategy;
//
//
//    /**
//     * 重写输出方法
//     * @param connectionId 连接id
//     * @param now 当前时间
//     * @param elapsed 执行时长，包括执行 SQL 和处理结果集的时间(可以参考来调优)
//     * @param category 语句分类，statement、resultset 等
//     * @param prepared 查询语句。可能是 prepared statement，表现为 select * from table1 where c1=?，问号参数形式
//     * @param sql 含参数值的查询语句，如 select * from from table1 where c1=7
//     */
//    public void logSQL(int connectionId, String now, long elapsed, Category category, String prepared, String sql) {
//        if(!Category.COMMIT.equals(category) && !prepared.startsWith("select count("))
//        this.logText(this.strategy.formatMessage(connectionId, now, elapsed, category.toString(), "-prepared-", sql));
//
//    }
//
//    @Override
//    public void logText(String text) {
//        StringBuilder sb = new StringBuilder();
//        //匹配到最后一个|作为分隔符
//        String[] arrString = text.split("\\|(?![^\\|]*\\|)");
//        if (arrString.length > 1) {
//            sb.append(arrString[0]);
//            //去最后一段语句做替换进行格式化
//            String sss=arrString[1].trim();
//            if(StringUtil.isNotBlank(sss) && !";".equalsIgnoreCase(sss)){
//                String sql = new SQLFormatter().format(arrString[1]);
//                sb.append("\r\n");
//                sb.append(sql);
//                sb.append("\r\n");
//            }else {
//                sb.append(sss);
//            }
//            //this.getStream().println(sb.toString());
//            logger.debug(sb.toString());
//        } else {
//            //this.getStream().println(text);
//            logger.debug(text);
//        }
//        arrString = null;
//
//    }
//
//}