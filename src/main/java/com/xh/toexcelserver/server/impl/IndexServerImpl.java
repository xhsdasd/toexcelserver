package com.xh.toexcelserver.server.impl;

import com.xh.toexcelserver.dao.SqlParmsTO;
import com.xh.toexcelserver.dao.ztwlDTO;
import com.xh.toexcelserver.server.IndexServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IndexServerImpl implements IndexServer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getJson() {
        String sql = "select top 2000 *\n" +
                "from  goodsattr\n" +
                "\n";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    public List<ztwlDTO> getList(SqlParmsTO sqlPars) {
        String sql = "select  a.Remark,a.kkydh,a.BusinessName,a.kkcbqmc,a.kkmdd,a.kkdsk,a.kkdsksxf,a.kkjsje,a.kkqstime,a.kkjstime,a.kkcbqbm\n" +
                ",a.kkdfk,a.kkssdsk,a.kkssdfk,a.kkzdtype,a.kkxgdate,a.kkjszl,a.kkmdf,a.kkkhyf,a.kkkhfjf,a.kkzzf,a.kkczf,a.kksgyf,a.kkqsywy\n" +
                ",a.kkqsywycode,a.kkjsdxcode,a.kkywypf,a.kkzxpf,a.RecAmt,a.kkjsdx,a.kkzddate,a.CostAmt,a.kksjywy,a.kksjywycode,a.kkpjywy\n" +
                ",a.kkpjywycode,a.kkdsksxfcb,a.kkdfksxf,a.kkdfksxfcb,a.kksjtime,a.kktcje,a.kkjscode,a.kkjslsh,a.kkczlx,a.kkjsly,a.kkfkwd\n" +
                ",a.kkskwd,d.goodsname,d.goodscode,b.billcode,b.dates,f.businessname as kkdjlx,a.kkpiaoshu\n" +
                "from SaleNotesDt a\n" +
                "join SaleNotesMt b on a.billno=b.billno and a.entid=b.entid\n" +
                "left join goodsdoc d on a.goodsid=d.goodsid and a.entid=d.entid\n" +
                "join businessdoc f on b.clientid=f.businessid and b.entid=f.entid\n"+
                "where left(a.kkzddate,10) >= ? and left(a.kkzddate,10) <= ? and b.billstate='0' ";
        StringBuilder sqlC = new StringBuilder(sql);
    if(sqlPars.getBillcode().length()>1){
        sqlC.append(" and b.billcode like '" +  sqlPars.getBillcode() +"' ");
    }
        if(!StringUtils.isEmpty(sqlPars.getBusinessid())){
            sqlC.append(" and b.Clientid = '" +  sqlPars.getBusinessid() +"'");
        }
        if(!StringUtils.isEmpty(sqlPars.getGoodsid())){
            sqlC.append(" and a.goodsid = '" +  sqlPars.getGoodsid() +"'");
        }
        if(sqlPars.getKkydh().length()>2){
            sqlC.append(" and a.kkydh like '" +  sqlPars.getKkydh() +"'");
        }
        if(!StringUtils.isEmpty(sqlPars.getCaozy())){
            sqlC.append(" and b.caozy like '" +  sqlPars.getCaozy() +"'");
        }
        if(!StringUtils.isEmpty(sqlPars.getIsch())){
            sqlC.append(" and b.isch like '" +  sqlPars.getIsch() +"'");
        }
        if(sqlPars.getJslx().length()>2){
            sqlC.append(" and a.kkjsly like '" +  sqlPars.getJslx() +"'");
        }
        sqlC.append(" order by b.billcode");
                return jdbcTemplate.query(sqlC.toString(), p -> {
                    p.setString(1,sqlPars.getStartDate());
                    p.setString(2, sqlPars.getEndDate());
                },
                rs -> {
                    List<ztwlDTO> orders = new ArrayList<>();
                    while (rs.next()) {
                        ztwlDTO order = new ztwlDTO();
//                        order.setId(rs.getLong("n"));
                        order.setRemark(rs.getString("Remark"));
                        order.setKkydh(rs.getString("kkydh"));
                        order.setBusinessName(rs.getString("BusinessName"));
                        order.setKkcbqmc(rs.getString("kkcbqmc"));
                        order.setKkmdd(rs.getString("kkmdd"));
                        order.setKkdsk(rs.getString("kkdsk"));
                        order.setKkdsksxf(rs.getString("kkdsksxf"));
                        order.setKkjsje(rs.getString("kkjsje"));
                        order.setKkqstime(rs.getString("kkqstime"));
                        order.setKkjstime(rs.getString("kkjstime"));
                        order.setKkdfk(rs.getString("kkdfk"));
                        order.setKkssdsk(rs.getString("kkssdsk"));
                        order.setKkssdfk(rs.getString("kkssdfk"));
                        order.setKkzdtype(rs.getString("kkzdtype"));
                        order.setKkxgdate(rs.getString("kkxgdate"));
                        order.setKkjszl(rs.getString("kkjszl"));
                        order.setKkmdf(rs.getString("kkmdf"));
                        order.setKkkhyf(rs.getString("kkkhyf"));
                        order.setKkkhfjf(rs.getString("kkkhfjf"));
                        order.setKkzzf(rs.getString("kkzzf"));
                        order.setKkczf(rs.getString("kkczf"));
                        order.setKksgyf(rs.getString("kksgyf"));
                        order.setKkqsywy(rs.getString("kkqsywy"));
                        order.setKkqsywycode(rs.getString("kkqsywycode"));
                        order.setKkjsdxcode(rs.getString("kkjsdxcode"));
                        order.setKkywypf(rs.getString("kkywypf"));
                        order.setKkzxpf(rs.getString("kkzxpf"));
                        order.setRecAmt(rs.getString("RecAmt"));
                        order.setKkjsdx(rs.getString("kkjsdx"));
                        order.setKkzddate(rs.getString("kkzddate"));
                        order.setCostAmt(rs.getString("CostAmt"));
                        order.setKksjywy(rs.getString("kksjywy"));
                        order.setKksjywycode(rs.getString("kksjywycode"));
                        order.setKkpjywy(rs.getString("kkpjywy"));
                        order.setKkpjywycode(rs.getString("kkpjywycode"));
                        order.setKkdsksxfcb(rs.getString("kkdsksxfcb"));
                        order.setKkdfksxf(rs.getString("kkdfksxf"));
                        order.setKkdfksxfcb(rs.getString("kkdfksxfcb"));
                        order.setKksjtime(rs.getString("kksjtime"));
                        order.setKktcje(rs.getString("kktcje"));
                        order.setKkjscode(rs.getString("kkjscode"));
                        order.setKkjslsh(rs.getString("kkjslsh"));
                        order.setKkczlx(rs.getString("kkczlx"));
                        order.setKkjsly(rs.getString("kkjsly"));
                        order.setKkfkwd(rs.getString("kkfkwd"));
                        order.setKkskwd(rs.getString("kkskwd"));
                        order.setGooodsname(rs.getString("goodsname"));
                        order.setGoodscode(rs.getString("goodscode"));
                        order.setBillcode(rs.getString("billcode"));
                        order.setDates(rs.getString("dates"));
                        order.setKkdjlx(rs.getString("kkdjlx"));
                        order.setKkpiaoshu(rs.getString("kkpiaoshu"));

                        orders.add(order);
                    }

                    return orders;
                });
    }




//    public List<ztwlDTO> getList(long lastBatchMaxId, int limit) {
//
//        String sql = "select * from (\n" +
//                "    select top 100000 row_number() over(order by b.billcode ) as n, a.Remark,a.kkydh,a.BusinessName,a.kkcbqmc,a.kkmdd,a.kkdsk,a.kkdsksxf,a.kkjsje,a.kkqstime,a.kkjstime,a.kkcbqbm\n" +
//                ",a.kkdfk,a.kkssdsk,a.kkssdfk,a.kkzdtype,a.kkxgdate,a.kkjszl,a.kkmdf,a.kkkhyf,a.kkkhfjf,a.kkzzf,a.kkczf,a.kksgyf,a.kkqsywy\n" +
//                ",a.kkqsywycode,a.kkjsdxcode,a.kkywypf,a.kkzxpf,a.RecAmt,a.kkjsdx,a.kkzddate,a.CostAmt,a.kksjywy,a.kksjywycode,a.kkpjywy\n" +
//                ",a.kkpjywycode,a.kkdsksxfcb,a.kkdfksxf,a.kkdfksxfcb,a.kksjtime,a.kktcje,a.kkjscode,a.kkjslsh,a.kkczlx,a.kkjsly,a.kkfkwd\n" +
//                ",a.kkskwd,d.goodsname,d.goodscode,b.billcode,b.dates,f.businessname as kkdjlx,a.kkpiaoshu,billstate\n" +
//                "from SaleNotesDt a\n" +
//                "join SaleNotesMt b on a.billno=b.billno and a.entid=b.entid\n" +
//                "left join goodsdoc d on a.goodsid=d.goodsid and a.entid=d.entid\n" +
//                "join businessdoc f on b.clientid=f.businessid and b.entid=f.entid \n" +
//                "\n" +
//                "\t  )hhh \n" +
//                "\t where n>? and n<=?";
//        return jdbcTemplate.query(sql, p -> {
//                    p.setLong(1, lastBatchMaxId);
//                    p.setLong(2, lastBatchMaxId+limit);
//                },
//                rs -> {
//                    List<ztwlDTO> orders = new ArrayList<>();
//                    while (rs.next()) {
//                        ztwlDTO order = new ztwlDTO();
//                        order.setId(rs.getLong("n"));
//                        order.setRemark(rs.getString("Remark"));
//                        order.setKkydh(rs.getString("kkydh"));
//                        order.setBusinessName(rs.getString("BusinessName"));
//                        order.setKkcbqmc(rs.getString("kkcbqmc"));
//                        order.setKkmdd(rs.getString("kkmdd"));
//                        order.setKkdsk(rs.getString("kkdsk"));
//                        order.setKkdsksxf(rs.getString("kkdsksxf"));
//                        order.setKkjsje(rs.getString("kkjsje"));
//                        order.setKkqstime(rs.getString("kkqstime"));
//                        order.setKkjstime(rs.getString("kkjstime"));
//                        order.setKkdfk(rs.getString("kkdfk"));
//                        order.setKkssdsk(rs.getString("kkssdsk"));
//                        order.setKkssdfk(rs.getString("kkssdfk"));
//                        order.setKkzdtype(rs.getString("kkzdtype"));
//                        order.setKkxgdate(rs.getString("kkxgdate"));
//                        order.setKkjszl(rs.getString("kkjszl"));
//                        order.setKkmdf(rs.getString("kkmdf"));
//                        order.setKkkhyf(rs.getString("kkkhyf"));
//                        order.setKkkhfjf(rs.getString("kkkhfjf"));
//                        order.setKkzzf(rs.getString("kkzzf"));
//                        order.setKkczf(rs.getString("kkczf"));
//                        order.setKksgyf(rs.getString("kksgyf"));
//                        order.setKkqsywy(rs.getString("kkqsywy"));
//                        order.setKkqsywycode(rs.getString("kkqsywycode"));
//                        order.setKkjsdxcode(rs.getString("kkjsdxcode"));
//                        order.setKkywypf(rs.getString("kkywypf"));
//                        order.setKkzxpf(rs.getString("kkzxpf"));
//                        order.setRecAmt(rs.getString("RecAmt"));
//                        order.setKkjsdx(rs.getString("kkjsdx"));
//                        order.setKkzddate(rs.getString("kkzddate"));
//                        order.setCostAmt(rs.getString("CostAmt"));
//                        order.setKksjywy(rs.getString("kksjywy"));
//                        order.setKksjywycode(rs.getString("kksjywycode"));
//                        order.setKkpjywy(rs.getString("kkpjywy"));
//                        order.setKkpjywycode(rs.getString("kkpjywycode"));
//                        order.setKkdsksxfcb(rs.getString("kkdsksxfcb"));
//                        order.setKkdfksxf(rs.getString("kkdfksxf"));
//                        order.setKkdfksxfcb(rs.getString("kkdfksxfcb"));
//                        order.setKksjtime(rs.getString("kksjtime"));
//                        order.setKktcje(rs.getString("kktcje"));
//                        order.setKkjscode(rs.getString("kkjscode"));
//                        order.setKkjslsh(rs.getString("kkjslsh"));
//                        order.setKkczlx(rs.getString("kkczlx"));
//                        order.setKkjsly(rs.getString("kkjsly"));
//                        order.setKkfkwd(rs.getString("kkfkwd"));
//                        order.setKkskwd(rs.getString("kkskwd"));
//                        order.setGooodsname(rs.getString("goodsname"));
//                        order.setGoodscode(rs.getString("goodscode"));
//                        order.setBillcode(rs.getString("billcode"));
//                        order.setDates(rs.getString("dates"));
//                        order.setKkdjlx(rs.getString("kkdjlx"));
//                        order.setKkpiaoshu(rs.getString("kkpiaoshu"));
//
//                        orders.add(order);
//                    }
//
//                    return orders;
//                });
//    }


}
