//package com.itzhoujun.usercenter.controller;
//
//
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//public class ExcelController {
//
//
//        @SuppressWarnings("unchecked")
//
//        // 创建excel文件函数
//
//        // src为待保存的文件路径,json为待保存的json数据
//
//        public static JSONObject createExcel(String src, HashMap<String, String> msp) {
//
//            JSONObject result = new JSONObject(); // 用来反馈函数调用结果
//
//            try {
//
//                // 新建文件
//
//                File file = new File(src);
//
//                file.createNewFile();
//
//                OutputStream outputStream = new FileOutputStream(file);// 创建工作薄
//
//                WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);
//
//                WritableSheet sheet = writableWorkbook.createSheet("First sheet", 0);// 创建新的一页
//                String[] lik = {"uuid", "recyclestr","mark","money","wbout_datestr","create_username","zcuuid","name","classfullname","zc_cnt", "status","wbsupplierstr"};
//                String[] liv = {"编号","单据状态","报修原因","报修费用","处理日期","处理人","资产编号","资产名称","资产分类","数量","状态","备注"};
//
//                System.out.println("first"+msp.get("assets"));
//                JSONArray jsonArray = JSONArray.parseArray(msp.get("assets"));// 得到data对应的JSONArray
//
//                System.out.println("jsonArray"+jsonArray);
//                Label label; // 单元格对象
//
//                 // 列数计数
//                // 将第一行信息加到页中。如：姓名、年龄、性别
//
//                for (int column = 0;column<liv.length;column++) { // 遍历key集合
//                    label = new Label(column, 0, liv[column]); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
//
//                    sheet.addCell(label); // 将单元格加到页
//                    System.out.println(label.getString());
//                }
//
//
//                // 遍历jsonArray
//
//                for (int i = 0; i < jsonArray.size(); i++) {
//
//                    JSONObject item = jsonArray.getJSONObject(i); // 得到数组的每项
//                    System.out.println("item="+item);
//
//
//
//
////                    iterator = item.keys(); // 得到key集合
//
//
//
//                    for (int j = 0;j<lik.length;j++) {
//                        String keys = lik[j]; // 得到key
//                        System.out.println(keys);
//                        if(msp.containsKey(keys)){
//                            String value = msp.get(keys); // 得到key对应的value
//                            System.out.println("msp"+value);
//                            label = new Label(j, (i + 1), value); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
//                        }else {
//                            if(keys.equals("zcuuid")){
//                                keys = "uuid";
//                            }
//                            String value = item.getString(keys); // 得到key对应的value
//                            System.out.println("item"+value);
//                            label = new Label(j, (i + 1), value); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
//                        }
//
//                        sheet.addCell(label); // 将单元格加到页
//
//                    }
//
//                }
//
//
//                writableWorkbook.write(); // 加入到文件中
//
//                writableWorkbook.close(); // 关闭文件，释放资源
//
//            } catch (Exception e) {
//
//                result.put("result", "failed"); // 将调用该函数的结果返回
//
//                result.put("reason", e.getMessage()); // 将调用该函数失败的原因返回
//
//                return result;
//
//            }
//
//            result.put("result", "successed");
//
//            return result;
//
//        }
//
////   if(list.size()>1){
////                        JSONObject json = new JSONObject();
////                        file.createNewFile();
////                        OutputStream outputS = new FileOutputStream(file);// 创建工作薄
////
////                        WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputS);
////
////                        WritableSheet sheet = writableWorkbook.createSheet("First sheet", 0);// 创建新的一页
////
////                        JSONArray jsonArray = json.getJSONArray("data");// 得到data对应的JSONArray
////
////                        Label label; // 单元格对象
////
////                        int column = 0; // 列数计数
////
////                        // 将第一行信息加到页中。如：姓名、年龄、性别
////
////                        JSONObject first = jsonArray.getJSONObject(0);
////
////                        Iterator<String> iterator = first.keySet().iterator(); // 得到第一项的key集合
////
////                        while (iterator.hasNext()) { // 遍历key集合
////
////                            String key = (String) iterator.next(); // 得到key
////
////                            label = new Label(column++, 0, key); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
////
////                            sheet.addCell(label); // 将单元格加到页
////
////                        }
////
////                        // 遍历jsonArray
////
////                        for (int y = 0; y < jsonArray.size(); y++) {
////
////                            JSONObject item = jsonArray.getJSONObject(y); // 得到数组的每项
////
////                            iterator = item.keySet().iterator(); // 得到key集合
////
////                            column = 0;// 从第0列开始放
////
////                            while (iterator.hasNext()) {
////
////                                String key = iterator.next(); // 得到key
////
////                                String value = item.getString(key); // 得到key对应的value
////
////                                label = new Label(column++, (i + 1), value); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
////
////                                sheet.addCell(label); // 将单元格加到页
////
////                            }
////
////                        }
////
////                        writableWorkbook.write(); // 加入到文件中
//
////                        writableWorkbook.close(); // 关闭文件，释放资源
////                        FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xls");
//
////                        hssfWorkbook.write(out);
////
////                        out.flush();
////                        ZipEntry entry = new ZipEntry(busid + ".xls");
////                        zipOutputStream.putNextEntry(entry);
////                        hssfWorkbook.write(zipOutputStream);
////                        zipOutputStream.flush();
////                        hssfWorkbook.close();
//
////                    }else {
////
////                    }
//
//
////if (uulist.length > 2) {
////                String busid = "123";
////                HashMap<String, Object> m = new HashMap<String, Object>();
////                try {
////
////
////                WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);
////
////                WritableSheet sheet = writableWorkbook.createSheet("First sheet", 0);// 创建新的一页
////                String[] lik = {"uuid", "recyclestr", "mark", "money", "wbout_datestr", "create_username", "zcuuid", "name", "classfullname", "zc_cnt", "status", "wbsupplierstr"};
////                String[] liv = {"编号", "单据状态", "报修原因", "报修费用", "处理日期", "处理人", "资产编号", "资产名称", "资产分类", "数量", "状态", "备注"};
////
////
////
////                Label label; // 单元格对象
////
////                // 列数计数
////                // 将第一行信息加到页中。如：姓名、年龄、性别
////
////                for (int column = 0; column < liv.length; column++) { // 遍历key集合
////                    label = new Label(column, 0, liv[column]); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
////
////                    sheet.addCell(label); // 将单元格加到页
////
////
////                    System.out.println(label.getString());
////                }
////
////
////                for (int ex = 0; ex < uulist.length-1; ex++) {
////
////
////                        System.out.println("uu::" + uulist[ex]);
////                        busid = datars.getRcd(ex).getString("fuuid");
////                        m.put("name", datars.getRcd(ex).getString("fname"));
////                        m.put("uuid", busid);
////                        String status = datars.getRcd(ex).getString("fstatus");
////                        //underrepair,cancel,finish
////                        if ("finish".equals(status)) {
////                            m.put("status", "完成");
////                        } else if ("cancel".equals(status)) {
////                            m.put("status", "取消");
////                        } else if ("underrepair".equals(status)) {
////                            m.put("status", "维修中");
////                        }
////                        m.put("reason", datars.getRcd(ex).getString("freason"));
////                        m.put("processuser", datars.getRcd(ex).getString("fprocessuser"));
////                        m.put("processtime", datars.getRcd(ex).getString("fprocesstime"));
////                        m.put("money", datars.getRcd(ex).getString("fmoney"));
////                        m.put("mark", datars.getRcd(ex).getString("fmark"));
////
////                        String sqlassets = "select " + AssetsConstant.resSqlbody + " t.zc_cnt,t.name,t.uuid from res_repair_item a ,res t where a.dr='0' and a.resid =t.id and a.busuuid =?";
////                        RcdSet rs = db.query(sqlassets, busid);
////                        List<JSONObject> list = new ArrayList<>();
////                        for (int j = 0; j < rs.size(); j++) {
////                            list.add(ConvertUtil.OtherJSONObjectToFastJSONObject(rs.getRcd(j).toJsonObject()));
////
////                        }
////                        m.put("assets", list);
////
////
////                        file.createNewFile();
////
////                    outputStream = new FileOutputStream(file);// 创建工作薄
////                    JSONArray jsonArray = JSONArray.parseArray(m.get("assets").toString());// 得到data对应的JSONArray
////
////                    System.out.println("jsonArray" + jsonArray);
////
////
////                        // 遍历jsonArray
////
////                        for (int i = 0; i < jsonArray.size(); i++) {
////
////                            JSONObject item = jsonArray.getJSONObject(i); // 得到数组的每项
////                            System.out.println("item=" + item);
////
////
//////                    iterator = item.keys(); // 得到key集合
////
////
////                            for (int j = 0; j < lik.length; j++) {
////                                String keys = lik[j]; // 得到key
////                                System.out.println(keys);
////                                if (m.containsKey(keys)) {
////                                    Object value = m.get(keys); // 得到key对应的value
////                                    System.out.println("msp" + value);
////                                    if(value==""||value==null){
////                                        value = "无";
////                                    }
////                                    label = new Label(j, (i + 1), value.toString()); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
////                                } else {
////                                    if (keys.equals("zcuuid")) {
////                                        keys = "uuid";
////                                    }
////                                    String value = item.getString(keys); // 得到key对应的value
////                                    System.out.println("item" + value);
////                                    label = new Label(j, (i + 1), value); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
////                                }
////
////                                sheet.addCell(label); // 将单元格加到页
////
////                            }
////
////                        }
////
////
////                        writableWorkbook.write(); // 加入到文件中
////
////
////
////
////                    }
////                    writableWorkbook.close(); // 关闭文件，释放资源
////                }catch (Exception e) {
////                    e.printStackTrace();
////                }
////
////                HackLoopTableRenderPolicy hackLoopTableRenderPolicy = new HackLoopTableRenderPolicy();
////                Configure config = Configure.newBuilder().bind("assets", hackLoopTableRenderPolicy).build();
////                XWPFTemplate tpl = XWPFTemplate.compile(ToolUtil.getRealPathInWebApp("") + "tpl" + File.separatorChar + fname, config).render(m);
////                ZipEntry entry = new ZipEntry(busid + ".xls");
////                zipOutputStream.putNextEntry(entry);
////                tpl.write(zipOutputStream);
////                zipOutputStream.flush();
////                tpl.close();
////            } else {
//
//}
