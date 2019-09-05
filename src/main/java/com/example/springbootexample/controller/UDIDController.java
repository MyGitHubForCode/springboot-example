package com.example.springbootexample.controller;

/**
 * ClassName:
 * Description:
 * date: 2019/9/5 0005 14:11
 *
 * @author SS
 * @since JDK 1.8
 */

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.UUID;


/**
 * @author ：iizvv
 * @date ：Created in 2019-06-26 20:39
 * @description：获取UDID
 * @modified By：
 * @version: 1.0
 */
@Controller
//@Api(tags = {"获取UDID下载APP"})
@RequestMapping("/udid")
public class UDIDController {

 /*   @RequestMapping(value = "/creatUDIDMobileconfig",method = RequestMethod.GET)
    public String creatUDIDMobileconfig(HttpServletRequest request,
                                        HttpServletResponse response) throws IOException, InterruptedException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "    <dict>\n" +
                "        <key>PayloadContent</key>\n" +
                "        <dict>\n" +
                "            <key>URL</key>\n" +
                "            <string>" + "Config.udidURL" + "/udid/getUDID?id=" + "Id" + "</string> <!--接收数据的接口地址-->\n" +
                "            <key>DeviceAttributes</key>\n" +
                "            <array>\n" +
                "                <string>SERIAL</string>\n" +
                "                <string>MAC_ADDRESS_EN0</string>\n" +
                "                <string>UDID</string>\n" +
                "                <string>IMEI</string>\n" +
                "                <string>ICCID</string>\n" +
                "                <string>VERSION</string>\n" +
                "                <string>PRODUCT</string>\n" +
                "            </array>\n" +
                "        </dict>\n" +
                "        <key>PayloadOrganization</key>\n" +
                "        <string>" + " Config.payloadOrganization" + "</string>  <!--组织名称-->\n" +
                "        <key>PayloadDisplayName</key>\n" +
                "        <string>" + "Config.payloadDisplayName " + "</string>  <!--安装时显示的标题-->\n" +
                "        <key>PayloadVersion</key>\n" +
                "        <integer>1</integer>\n" +
                "        <key>PayloadUUID</key>\n" +
                "        <string>" + "UUID.randomUUID().toString().replace(\"-\", \"\")" + "</string>  <!--自己随机填写的唯一字符串-->\n" +
                "        <key>PayloadIdentifier</key>\n" +
                "        <string>online.iizvv.profile-service</string>\n" +
                "        <key>PayloadDescription</key>\n" +
                "        <string>" + "Config.payloadDescription" + "</string>   <!--描述-->\n" +
                "        <key>PayloadType</key>\n" +
                "        <string>Profile Service</string>\n" +
                "    </dict>\n" +
                "</plist>";
        ClassLoader classLoader = this.getClass().getClassLoader();
        String name = "udid_";
        String filePath = name + ".mobileconfig";
       // FileWriter writer = new FileWriter(filePath);
        //writer.write(xml);

        //String serverKey = "serverKey";
        //String ca = "serverCrt";
        //String serverCrt = "serverCrt";


        String filePath2 = "name + \"_\" + id + \".mobileconfig\"";
        String com = "\"openssl smime -sign -in \" + filePath + \" -out \" + filePath2 + \" -signer \" + serverCrt + \" -inkey \" + serverKey + \"  -certfile \" + ca + \" -outform der -nodetach\"";
        //System.out.println(filePath2);
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filePath, "UTF-8"));
        //Shell.run(com);
        response.setContentType("text/XML");
        //response.setContentType("application/octet-stream");

        // 下载文件能正常显示中文
        //response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filePath, "UTF-8"));


        String text ="Converting String to InputStream Example";

        byte[] bytes = xml.getBytes();
        ServletOutputStream outputStream = response.getOutputStream();
        for (int i = 0; i < bytes.length; i++) {
            outputStream.write(bytes[i]);
        }
        outputStream.close();
        return "Download the song successfully!";
    }*/

}

