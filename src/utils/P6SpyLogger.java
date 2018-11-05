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
//     * ��д�������
//     * @param connectionId ����id
//     * @param now ��ǰʱ��
//     * @param elapsed ִ��ʱ��������ִ�� SQL �ʹ���������ʱ��(���Բο�������)
//     * @param category �����࣬statement��resultset ��
//     * @param prepared ��ѯ��䡣������ prepared statement������Ϊ select * from table1 where c1=?���ʺŲ�����ʽ
//     * @param sql ������ֵ�Ĳ�ѯ��䣬�� select * from from table1 where c1=7
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
//        //ƥ�䵽���һ��|��Ϊ�ָ���
//        String[] arrString = text.split("\\|(?![^\\|]*\\|)");
//        if (arrString.length > 1) {
//            sb.append(arrString[0]);
//            //ȥ���һ��������滻���и�ʽ��
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