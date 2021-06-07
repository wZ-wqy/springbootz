//package com.itzhoujun.usercenter.controller;
//
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import com.onewaveinc.mip.log.Logger;
//import com.onewaveinc.user.entity.UserInfo;
///**
// * 生成Excel文件工具类
// * @author wxin
// *
// */
//public class ExcelUtil {
//
//    private static Logger logger = Logger.getInstance(ExcelUtil.class);
//    /**
//     * 导出Excel
//     * @param sheetName sheet名称
//     * @param title 标题
//     * @param values 内容
//     * @param wb HSSFWorkbook对象
//     * @return
//     */
//    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,List<UserInfo> valueList, HSSFWorkbook wb){
//
//        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
//        if(wb == null){
//            wb = new HSSFWorkbook();
//        }
//
//        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
//        HSSFSheet sheet = wb.createSheet(sheetName);
//
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
//        HSSFRow row = sheet.createRow(0);
//
//        // 第四步，创建单元格，并设置值表头 设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        // 创建一个居中格式
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//        //声明列对象
//        HSSFCell cell = null;
//
//        //创建标题
//        for(int i=0;i<title.length;i++){
//            cell = row.createCell((short) i);
//            cell.setCellValue(title[i]);
//            cell.setCellStyle(style);
//        }
//
//        //创建内容
//        if (null != valueList && valueList.size() > 0) {
//            for(int i=0;i<valueList.size();i++){
//                row = sheet.createRow(i + 1);
//                UserInfo userInfo = valueList.get(i);
//                String []userInfoArray = {userInfo.getLoginName(),userInfo.getStbMac(),userInfo.getLoginIp(),
//                        userInfo.getServerDomain(), userInfo.getTerminalModel(),userInfo.getTerminalVersion(),
//                        userInfo.getServerIp(),    userInfo.getUpdateTime(),userInfo.getLoginTime()};
//                for(int j=0;j<userInfoArray.length;j++){
//                    //将内容按顺序赋给对应的列对象
//                    row.createCell((short) j).setCellValue(userInfoArray[j]);
//                }
//            }
//        } else {
//            logger.error("用户信息无数据");
//        }
//        return wb;
//    }
//}
//
//
