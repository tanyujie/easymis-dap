package org.easymis.dap.catalog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.entity.SystemLog;
@Mapper
public interface LogMapper {
    @Select("SELECT * FROM dam_role WHERE dbs_id = #{dbsId}")
    Dbs findById(@Param("dbsId") String dbsId);
    @Insert("INSERT INTO dam_role(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(#{dbsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("dbsId") String dbsId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO dam_dbs(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{dbsId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO dam_log(log_id, url, request_type, request_method, request_body, request_date, response_body, response_status, response_message, response_date, ip, depict, creator_id, creator, create_date, valid) "
    		+ "VALUES(#{logId}, #{url}, #{requestType}, #{requestMethod}, #{requestBody}, #{requestDate}, #{responseBody}, #{responseStatus}, #{responseMessage}, #{responseDate}, #{ip}, #{depict}, #{creatorId}, #{creator}, #{createDate}, #{valid})")
    int insertByBean(SystemLog bean);

    @Update("UPDATE dam_role leads_name = #{leadsName} WHERE dbs_id = #{dbsId}")
    void update(Dbs bean);

    @Delete("DELETE FROM dam_role WHERE role_id = #{roleId}")
    void delete(String roleId);

    @Results({
            @Result(property = "roleId", column = "role_id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "depict", column = "depict")
    })
    @Select("SELECT * FROM dam_log")
    List<SystemLog> findAll();
}
