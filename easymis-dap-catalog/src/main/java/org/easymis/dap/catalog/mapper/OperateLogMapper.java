package org.easymis.dap.catalog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.dap.catalog.entity.LoginLog;
import org.easymis.dap.catalog.entity.OperateLog;
@Mapper
public interface OperateLogMapper {
    @Select("SELECT * FROM dam_operate_log WHERE login_log_id = #{loginLogId}")
    OperateLog findById(@Param("loginLogId") String loginLogId);
    @Insert("INSERT INTO dam_operate_log(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(#{dbsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("dbsId") String dbsId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO dam_operate_log(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{dbsId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO dam_operate_log(operate_log_id, creator_id, creator, belong_type, operation_type_name, belong_type_name, object_name, create_date, ip, depict, content) "
    		+ " VALUES(#{operateLogId}, #{creatorId}, #{creator}, #{belongType}, #{operationTypeName}, #{belongTypeName}, #{objectName}, #{createDate}, #{ip}, #{depict}, #{content})")
    int insertByBean(OperateLog bean);

    @Update("UPDATE dam_operate_log leads_name = #{leadsName} WHERE dbs_id = #{dbsId}")
    void update(LoginLog bean);

    @Delete("DELETE FROM dam_operate_log WHERE role_id = #{roleId}")
    void delete(String roleId);


    @Select("SELECT * FROM dam_operate_log")
    List<OperateLog> findAll();
}
