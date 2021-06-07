package com.itzhoujun.usercenter.controller;



import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Arrays;


@RestController
@CrossOrigin
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Mapper


public class api {

    public static int[] qsort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) arr=qsort(arr,start,i-1);
        if (j+1<end) arr=qsort(arr,j+1,end);
        return (arr);
    }





    @PostMapping(value = "/testing")
    public  static OapiRobotSendRequest  ap(HttpServletRequest req) throws Exception{
        JSONObject ds = new JSONObject();
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String s = null;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            System.out.println(sb.toString());

            JSONObject jsonObject = JSONObject.fromObject(sb.toString());


            Long timestamp = System.currentTimeMillis();
            String secret = "SECe23ce396d7736521ff7c8b15e903e6af596e88c6a01fb64e0e529aedebf3f507";
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");



            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=6f8fbc338b882965428534c82e0ae01dde93c9d91481d30067e330f6ff85b176&timestamp=" + timestamp + "&sign=" + sign);

            request.setMsgtype("text");
            OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
            text.setContent(jsonObject.getString("text"));
            request.setText(text);
            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
            at.setAtMobiles(Arrays.asList("15077212838","13978075034","17774807004"));
// isAtAll类型如果不为Boolean，请升级至最新SDK
            at.setIsAtAll(false);
            request.setAt(at);

//            request.setMsgtype("link");
//            OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
//            link.setMessageUrl("https://www.dingtalk.com/");
//            link.setPicUrl("");
//            link.setTitle("时代的火车向前开");
//            link.setText("这个即将发布的新版本，创始人xx称它为红树林。而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是红树林");
//            request.setLink(link);
//
//            request.setMsgtype("markdown");
//            OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
//            markdown.setTitle("杭州天气");
//            markdown.setText("#### 杭州天气 @156xxxx8827\n" +
//                    "> 9度，西北风1级，空气良89，相对温度73%\n\n" +
//                    "> ![screenshot](https://gw.alicdn.com/tfs/TB1ut3xxbsrBKNjSZFpXXcXhFXa-846-786.png)\n" +
//                    "> ###### 10点20分发布 [天气](http://www.thinkpage.cn/) \n");
//            request.setMarkdown(markdown);
            OapiRobotSendResponse response = client.execute(request);


            int[] arr = {6,5,2,3,3,4,5,1};

            for(int i =0;i<arr.length-1;i++){
                for(int j = 0;j<arr.length-1-i;j++){
                    if(arr[j]>arr[j+1]){
                        int num = arr[j+1];
                        arr[j+1] = arr[j];
                        arr[j] = num;
                    }
                }

            }










        } catch (IOException e) {
            e.printStackTrace();
        }

        return request;

    }


}
