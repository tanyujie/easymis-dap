package org.easymis.dap.catalog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.dap.catalog.entity.Columns;
import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.entity.Repair;

public interface RepairMapper {
    @Select("SELECT * FROM dam_columns WHERE dbs_id = #{inspectId}")
    Repair findById(@Param("BusinessId") String BusinessId);
    @Insert("INSERT INTO dam_columns(Business_id, leads_name, org_id,creator_id,delete_status) VALUES(#{inspectId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("inspectId") String inspectId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO dam_columns(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{inspectId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO dam_columns(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(#{inspectId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insertByBean(Repair bean);
    
    @InsertProvider(type = ColumnsDaoProvider.class, method = "insert")
    int insertByList(List<Columns> columnsList);
    @Update("UPDATE dam_columns leads_name = #{leadsName} WHERE dbs_id = #{inspectId}")
    void update(Dbs leads);

    @Delete("DELETE FROM dam_columns WHERE dbs_id = #{inspectId}")
    void delete(String inspectId);

    @Results({
            @Result(property = "inspectId", column = "dbs_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "dbsUri", column = "dbs_uri")
    })
    @Select("SELECT * FROM dam_business")
    List<Repair> findAll();
}
