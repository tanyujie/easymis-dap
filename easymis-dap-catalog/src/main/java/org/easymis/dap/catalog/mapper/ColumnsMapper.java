package org.easymis.dap.catalog.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.dap.catalog.entity.Columns;
import org.easymis.dap.catalog.entity.Dbs;


@Mapper
public interface  ColumnsMapper {
    @Select("SELECT * FROM dam_columns WHERE dbs_id = #{dbsId}")
    Dbs findById(@Param("dbsId") String dbsId);
    @Insert("INSERT INTO dam_columns(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(#{dbsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insert(@Param("dbsId") String dbsId, @Param("leadsName") String leadsName, @Param("orgId") String orgId, @Param("creatorId") String creatorId, @Param("deleteStatus") String deleteStatus);

    @Insert("INSERT INTO dam_columns(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(" +
            "#{dbsId, jdbcType=VARCHAR}, #{leadsName, jdbcType=VARCHAR}, #{orgId, jdbcType=VARCHAR}, #{creatorId, jdbcType=VARCHAR}, #{deleteStatus, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO dam_columns(dbs_id, leads_name, org_id,creator_id,delete_status) VALUES(#{dbsId}, #{leadsName}, #{orgId}, #{creatorId}, #{deleteStatus})")
    int insertByDbs(Dbs bean);
    
    @InsertProvider(type = ColumnsDaoProvider.class, method = "insert")
    int insertByList(@Param("list") List<Columns> list);
    @Update("UPDATE dam_columns leads_name = #{leadsName} WHERE dbs_id = #{dbsId}")
    void update(Dbs leads);

    @Delete("DELETE FROM dam_columns WHERE dbs_id = #{dbsId}")
    void delete(String dbsId);

    @Results({
            @Result(property = "dbsId", column = "dbs_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "dbsUri", column = "dbs_uri")
    })
    @Select("SELECT * FROM dam_columns")
    List<Dbs> findAll();
}
