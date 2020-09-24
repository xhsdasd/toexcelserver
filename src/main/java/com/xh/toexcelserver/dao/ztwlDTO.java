package com.xh.toexcelserver.dao;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2020/7/11 16:27
 */
@Data
public class ztwlDTO {

    @ExcelIgnore
    private Long id;
  //  备注	运单号码	单位名称	承包区名称	目的地	代收款	代收款手续费
  @ExcelProperty(value = "备注")
  private String remark;
    @ExcelProperty(value = "运单号码")
    private String kkydh;
    @ExcelProperty(value = "单位名称")
    private String businessName;
    @ExcelProperty(value = "承包区名称")
    private String kkcbqmc;
    @ExcelProperty(value = "目的地")
    private String kkmdd;
    @ExcelProperty(value = "代收款")
    private String kkdsk;
    @ExcelProperty(value = "代收款手续费")
    private String kkdsksxf;
  //  结算金额	签收时间	结算时间	承包区编码	到付款	实收代收款
    @ExcelProperty(value = "结算金额")
    private String kkjsje;
    @ExcelProperty(value = "签收时间")
    private String kkqstime;
    @ExcelProperty(value = "结算时间")
    private String kkjstime;
    @ExcelProperty(value = "承包区编码")
    private String kkcbqbm;
    @ExcelProperty(value = "到付款")
    private String kkdfk;
    @ExcelProperty(value = "实收代收款")
    private String kkssdsk;
    @ExcelProperty(value = "实收到付款")
    private String kkssdfk;

//	账单类型	修改时间	结算重量	面单费	客户运费	客户附加费	中转费	操作费	手工运费	签收业务员	签收业务员工号
@ExcelProperty(value = "账单类型")
private String kkzdtype;
    @ExcelProperty(value = "修改时间")
    private String kkxgdate;
    @ExcelProperty(value = "结算重量")
    private String kkjszl;
    @ExcelProperty(value = "面单费")
    private String kkmdf;
    @ExcelProperty(value = "客户运费")
    private String kkkhyf;
    @ExcelProperty(value = "客户附加费")
    private String kkkhfjf;
    @ExcelProperty(value = "中转费")
    private String kkzzf;
    @ExcelProperty(value = "操作费")
    private String kkczf;
    @ExcelProperty(value = "手工运费")
    private String kksgyf;
    @ExcelProperty(value = "签收业务员")
    private String kkqsywy;
    @ExcelProperty(value = "签收业务员工号")
    private String kkqsywycode;
    //结算对象工号	业务员派费	中心派费	应收金额	结算对象	账单日期	成本金额	收件业务员
    @ExcelProperty(value = "结算对象工号")
    private String kkjsdxcode;
    @ExcelProperty(value = "业务员派费")
    private String kkywypf;
    @ExcelProperty(value = "中心派费")
    private String kkzxpf;
    @ExcelProperty(value = "应收金额")
    private String recAmt;
    @ExcelProperty(value = "结算对象")
    private String kkjsdx;
    @ExcelProperty(value = "账单日期")
    private String kkzddate;
    @ExcelProperty(value = "成本金额")
    private String costAmt;
    @ExcelProperty(value = "收件业务员")
    private String kksjywy;
    //收件业务员工号	派件业务员	派件业务员工号	代收款手续费成本
    @ExcelProperty(value = "收件业务员工号")
    private String kksjywycode;
    @ExcelProperty(value = "派件业务员")
    private String kkpjywy;
    @ExcelProperty(value = "派件业务员工号")
    private String kkpjywycode;
    @ExcelProperty(value = "代收款手续费成本")
    private String kkdsksxfcb;
//到付款手续费	到付款手续费成本	收件时间	提成金额	结算编号	结算流水号
@ExcelProperty(value = "到付款手续费")
private String kkdfksxf;
    @ExcelProperty(value = "到付款手续费成本")
    private String kkdfksxfcb;
    @ExcelProperty(value = "收件时间")
    private String kksjtime;
    @ExcelProperty(value = "提成金额")
    private String kktcje;
    @ExcelProperty(value = "结算编号")
    private String kkjscode;
    @ExcelProperty(value = "结算流水号")
    private String kkjslsh;
    //	操作类型	结算类型	付款网点	收款网点	商品名称	商品编号	单据编号	日期	kkdjlx	票数
    @ExcelProperty(value = "操作类型")
    private String kkczlx;
    @ExcelProperty(value = "结算类型")
    private String kkjsly;
    @ExcelProperty(value = "付款网点")
    private String kkfkwd;
    @ExcelProperty(value = "收款网点")
    private String kkskwd;
    @ExcelProperty(value = "商品名称")
    private String gooodsname;
    @ExcelProperty(value = "商品编号")
    private String goodscode;
    @ExcelProperty(value = "单据编号")
    private String billcode;
    @ExcelProperty(value = "日期")
    private String dates;
    @ExcelProperty(value = "单据类型")
    private String kkdjlx ;
    @ExcelProperty(value = "票数")
    private String kkpiaoshu;


}
