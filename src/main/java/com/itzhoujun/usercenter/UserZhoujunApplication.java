package com.itzhoujun.usercenter;



//import com.itzhoujun.usercenter.controller.ExcelController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.HashMap;

import static com.itzhoujun.usercenter.controller.api.qsort;

// 扫描mybatis哪些包里面的接口
@MapperScan("com.itzhoujun")
@SpringBootApplication
public class UserZhoujunApplication {

    public static void main(String[] args) {

//        SpringApplication.run(UserZhoujunApplication.class, args);

//        HashMap<String, String> map2 = new HashMap<String, String>();
//        map2.put("belongcomp_fullname","广西深联科技有限公司");
//        map2.put("zcsourcestr","自购");
//        map2.put("belongcomp_fullname","广西深联科技有限公司");
//        map2.put("zcsourcestr","自购");
//        map2.put("belongcomp_fullname","广西深联科技有限公司");
//        map2.put("zcsourcestr","自购");
//
//
//
//
//


//        HashMap<String, String> m = new HashMap<String, String>();
//        m.put("reason", "thrd");
//        m.put("assets", "[{\"ctid\":319,\"belongcomp_fullname\":\"安可宁波分公司\",\"zcsourcestr\":\"自购\",\"locstr\":\"数据中心--华东\",\"wbsupplierstr\":\"无\",\"uuid\":\"AS-0108-0888\",\"classfullname\":\"专用设备/医疗设备/针头\",\"create_username\":\"管理员\",\"usefullifestr\":\"1年\",\"classname\":\"针头\",\"recyclestr\":\"维修中\",\"brandstr\":\"惠普\",\"supplierstr\":\"华为\",\"belongcomp_name\":\"安可宁波分公司\",\"name\":\"gfjdj\",\"fd1str\":\"2021-04-21\",\"wbout_datestr\":\"2021-04-22\",\"reviewstr\":\"待核(录入)\",\"update_username\":\"管理员\",\"zc_cnt\":1,\"wbstr\":\"在保\",\"classrootname\":\"资产分类\",\"buy_timestr\":\"2021-04-21\"},{\"ctid\":319,\"belongcomp_fullname\":\"安可宁波分公司\",\"zcsourcestr\":\"自购\",\"locstr\":\"数据中心--华东\",\"wbsupplierstr\":\"无\",\"uuid\":\"AS-0108-0888\",\"classfullname\":\"专用设备/医疗设备/针头\",\"create_username\":\"管理员\",\"usefullifestr\":\"1年\",\"classname\":\"针头\",\"recyclestr\":\"维修中\",\"brandstr\":\"惠普\",\"supplierstr\":\"华为\",\"belongcomp_name\":\"安可宁波分公司\",\"name\":\"gfjdj\",\"fd1str\":\"2021-04-21\",\"wbout_datestr\":\"2021-04-22\",\"reviewstr\":\"待核(录入)\",\"update_username\":\"管理员\",\"zc_cnt\":1,\"wbstr\":\"在保\",\"classrootname\":\"资产分类\",\"buy_timestr\":\"2021-04-21\"}]");
//        m.put("uuid","dsafdsgfdsgg");
//
//        ExcelController.createExcel("C:\\Users\\Administrator\\Desktop\\testss.xls",m);
//        int[] arr = {6,5,2,3,3,4,5,1};
//        for(int i =0 ; i<arr.length-1 ; i++) {
//
//            for(int j=0 ; j<arr.length-1-i ; j++) {
//
//                if(arr[j]>arr[j+1]) {
//                    int temp = arr[j];
//
//                    arr[j]=arr[j+1];
//
//                    arr[j+1]=temp;
//                }
//            }
//
//        }

        int arr[] = new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
        int len = arr.length-1;
        arr=qsort(arr,0,len);
        for (int i:arr) {
            System.out.print(i+"\t");
        }


    }

}
