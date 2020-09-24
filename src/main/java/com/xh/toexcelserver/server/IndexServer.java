package com.xh.toexcelserver.server;


import com.xh.toexcelserver.dao.SqlParmsTO;
import com.xh.toexcelserver.dao.ztwlDTO;

import java.util.List;
import java.util.Map;

public interface IndexServer {
    List<Map<String, Object>> getJson();


    List<ztwlDTO> getList(SqlParmsTO sqlPars);

}
