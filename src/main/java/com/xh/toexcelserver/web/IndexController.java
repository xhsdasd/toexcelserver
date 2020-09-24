package com.xh.toexcelserver.web;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.xh.toexcelserver.dao.SqlParmsTO;
import com.xh.toexcelserver.dao.ztwlDTO;
import com.xh.toexcelserver.server.IndexServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Slf4j
@Controller
public class IndexController {
    @Autowired
    private IndexServer indexServer;

    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("getJ")
    @ResponseBody
    public List<Map<String, Object>> getJson(){
        List<Map<String, Object>> json = indexServer.getJson();
        return json;
    }

//    @GetMapping(path = "/download")
//    public void download(HttpServletResponse response) throws Exception {
//        // 这里文件名如果涉及中文一定要使用URL编码,否则会乱码
//        String fileName = URLEncoder.encode("ccc.xlsx", StandardCharsets.UTF_8.toString());
//        // 封装标题行
//        List<List<String>> head = new ArrayList<>();
//        List<String> strings = new ArrayList<>();
//        strings.add("编号");
//        strings.add("id");
//        head.add(strings);
//
//        // 封装数据
//        List<List<String>> data = new LinkedList<>();
//        List<String> list = new LinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i+"");
//        }
//        data.add(list);
//        response.setContentType("application/force-download");
//        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//        EasyExcel.write(response.getOutputStream())
//                .head(head)
//                .autoCloseStream(true)
//                .excelType(ExcelTypeEnum.XLSX)
//                .sheet("111")
//                .doWrite(data);
//    }


    @RequestMapping(path = "/export")
    public void export(SqlParmsTO sqlPars,
                       HttpServletResponse response) throws Exception {
        long start = System.currentTimeMillis();

        String fileName = URLEncoder.encode(String.format("%s-(%s).xlsx", "订单支付数据", UUID.randomUUID().toString()),
                StandardCharsets.UTF_8.toString());
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        ExcelWriter writer = new ExcelWriterBuilder()
                .autoCloseStream(true)
                .excelType(ExcelTypeEnum.XLSX)
                .file(response.getOutputStream())
                .head(ztwlDTO.class)
                .build();
        // xlsx文件上上限是104W行左右,这里如果超过104W需要分Sheet
        WriteSheet writeSheet = new WriteSheet();
        writeSheet.setSheetName("target");
       long lastBatchMaxId=0L;

            List<ztwlDTO> list = indexServer.getList(sqlPars);
                writer.write(list, writeSheet);
                writer.finish();
                //System.out.println("已读取 "+lastBatchMaxId);
        log.info("导出数据耗时:{} ms,start:{},end:{}", System.currentTimeMillis() - start);
        }




//
//    @GetMapping(path = "/export")
//    public void export(
//            HttpServletResponse response) throws Exception {
//        long start = System.currentTimeMillis();
//        String fileName = URLEncoder.encode(String.format("%s-(%s).xlsx", "订单支付数据", UUID.randomUUID().toString()),
//                StandardCharsets.UTF_8.toString());
//        response.setContentType("application/force-download");
//        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//        ExcelWriter writer = new ExcelWriterBuilder()
//                .autoCloseStream(true)
//                .excelType(ExcelTypeEnum.XLSX)
//                .file(response.getOutputStream())
//                .head(ztwlDTO.class)
//                .build();
//        // xlsx文件上上限是104W行左右,这里如果超过104W需要分Sheet
//        WriteSheet writeSheet = new WriteSheet();
//        writeSheet.setSheetName("target");
//        long lastBatchMaxId=0L;
//        int limit = 500;
//        for (; ; ) {
//            List<ztwlDTO> list = indexServer.getList(lastBatchMaxId,limit);
//
//            if (list.isEmpty()) {
//                writer.finish();
//                break;
//            } else {
//
//                lastBatchMaxId=list.stream().map(ztwlDTO::getId).max(Long::compareTo).orElse(Long.MAX_VALUE);
//                writer.write(list, writeSheet);
//                System.out.println("已读取 "+lastBatchMaxId);
//            }
//        }
//
//
//
//        log.info("导出数据耗时:{} ms,start:{},end:{}", System.currentTimeMillis() - start);}
}
