package com.huayi.doupo.base.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.io.InputStream;

import java.sql.PreparedStatement;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.huayi.doupo.base.dal.base.DALFather;
import com.huayi.doupo.base.model.player.PlayerMemObj;
import com.huayi.doupo.base.model.DictBarrierDrop;

public class DictBarrierDropDAL extends DALFather {
	@SuppressWarnings("rawtypes")
	public class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			DictBarrierDrop dictBarrierDrop = new DictBarrierDrop();
			dictBarrierDrop.setId(rs.getInt("id"), 0);
			dictBarrierDrop.setBarrierId(rs.getInt("barrierId"), 0);
			dictBarrierDrop.setType(rs.getInt("type"), 0);
			dictBarrierDrop.setType2(rs.getInt("type2"), 0);
			dictBarrierDrop.setTableTypeId(rs.getInt("tableTypeId"), 0);
			dictBarrierDrop.setTableFieldId(rs.getInt("tableFieldId"), 0);
			dictBarrierDrop.setValue(rs.getInt("value"), 0);
			dictBarrierDrop.setChance(rs.getInt("chance"), 0);
			dictBarrierDrop.setDescription(rs.getString("description"), 0);
			dictBarrierDrop.setVersion(rs.getInt("version"), 0);
			return dictBarrierDrop;
		}
	}

	public DictBarrierDrop add(final DictBarrierDrop model, int instPlayerId) throws Exception {
		try {
			StringBuilder strSql = new StringBuilder();
			strSql.append(" insert into Dict_Barrier_Drop (");
			strSql.append("barrierId,type,type2,tableTypeId,tableFieldId,value,chance,description,version");
			strSql.append(" )");
			strSql.append(" values (?,?,?,?,?,?,?,?,?) ");

			final String sql = strSql.toString();
			KeyHolder keyHolder = new GeneratedKeyHolder();

			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, model.getBarrierId());
					ps.setInt(2, model.getType());
					ps.setInt(3, model.getType2());
					ps.setInt(4, model.getTableTypeId());
					ps.setInt(5, model.getTableFieldId());
					ps.setInt(6, model.getValue());
					ps.setInt(7, model.getChance());
					ps.setString(8, model.getDescription());
					ps.setInt(9, 0);
					return ps;
				}
			},keyHolder);

			model.setId(keyHolder.getKey().intValue());
			model.setVersion(0);
			PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				playerMemObj.dictBarrierDropMap.put(model.getId(), model);
			}
		} catch (Exception e) {
			throw e;
		}
		return model;
	}

	public void batchAdd (final List<DictBarrierDrop> list) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into Dict_Barrier_Drop (");
		sql.append("barrierId,type,type2,tableTypeId,tableFieldId,value,chance,description,version");
		sql.append(" )");
		sql.append(" values (?,?,?,?,?,?,?,?,?) ");
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter (){
			public void setValues(PreparedStatement ps, int i) throws SQLException{
				DictBarrierDrop model = (DictBarrierDrop)list.get(i);
					ps.setInt(1, model.getBarrierId());
					ps.setInt(2, model.getType());
					ps.setInt(3, model.getType2());
					ps.setInt(4, model.getTableTypeId());
					ps.setInt(5, model.getTableFieldId());
					ps.setInt(6, model.getValue());
					ps.setInt(7, model.getChance());
					ps.setString(8, model.getDescription());
					ps.setInt(9, 0);
			}
			public int getBatchSize(){
				return list.size();
			}
		};
		getJdbcTemplate().batchUpdate(sql.toString(), setter);
	}

	public int deleteById(int id, int instPlayerId) throws Exception {
		try {
			PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				playerMemObj.dictBarrierDropMap.remove(id);
			}
			String sql = "delete from Dict_Barrier_Drop  where id = ?";
			Object[] params = new Object[]{id};
			return this.getJdbcTemplate().update(sql, params);
		} catch (Exception e) {
			throw e;
		}
	}

	public int deleteByWhere(String strWhere) throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("delete from Dict_Barrier_Drop where 1=1 ");
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(" and " + strWhere);
			}
			return this.getJdbcTemplate().update(sql.toString());
		} catch (Exception e) {
			throw e;
		}
	}

	public int update(String sql) throws Exception {
		try {
			return this.getJdbcTemplate().update(sql.toString());
		} catch (Exception e) {
			throw e;
		}
	}

	public DictBarrierDrop update(DictBarrierDrop model, int instPlayerId) throws Exception {
		try {
			Object[] params = null;
			int version = model.getVersion() + 1;
			StringBuffer sql = new StringBuffer("update Dict_Barrier_Drop set ");
			sql.append("barrierId=?,type=?,type2=?,tableTypeId=?,tableFieldId=?,value=?,chance=?,description=?,version=? ");
			sql.append("where id=? and version=?");
			params = new Object[] { model.getBarrierId(),model.getType(),model.getType2(),model.getTableTypeId(),model.getTableFieldId(),model.getValue(),model.getChance(),model.getDescription(),version , model.getId(), model.getVersion() };
			int count = this.getJdbcTemplate().update(sql.toString(), params);
			if (count == 0) {
				throw new Exception("Concurrent Exception");
			} else {
				model.setVersion(version, 0);
				PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
				if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
					playerMemObj.dictBarrierDropMap.put(model.getId(), model);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	public DictBarrierDrop getModel(int id, int instPlayerId) {
		try {
			PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				DictBarrierDrop model = playerMemObj.dictBarrierDropMap.get(id);
				if (model == null) {
					String sql = "select * from Dict_Barrier_Drop where id=?";
					Object[] params = new Object[]{id};
					playerMemObj.dictBarrierDropMap.put(id, (DictBarrierDrop) this.getJdbcTemplate().queryForObject(sql, params, new ItemMapper()));
				} else {
					int cacheVersion = model.getVersion();
					List<Map<String, Object>> list = sqlHelper("select version from Dict_Barrier_Drop where id = " + id);
					 int dbVersion = (int)list.get(0).get("version");
					if (cacheVersion != dbVersion) {
						String sql = "select * from Dict_Barrier_Drop where id=?";
						Object[] params = new Object[]{id};
						playerMemObj.dictBarrierDropMap.put(id, (DictBarrierDrop) this.getJdbcTemplate().queryForObject(sql, params, new ItemMapper()));
					}
				}
				model = playerMemObj.dictBarrierDropMap.get(id);
				model.result = "";
				return model;
			} else {
				String sql = "select * from Dict_Barrier_Drop where id=?";
				Object[] params = new Object[]{id};
				DictBarrierDrop model = ( DictBarrierDrop) this.getJdbcTemplate().queryForObject(sql, params, new ItemMapper());
				model.result = "";
				return model;
			}
		} catch (DataAccessException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DictBarrierDrop> getList(String strWhere, int instPlayerId) {
		StringBuffer sql = null;
		PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			sql = new StringBuffer("select id, version from Dict_Barrier_Drop ");
		}else {
			sql = new StringBuffer("select * from Dict_Barrier_Drop ");
		}
		if (strWhere != null && !strWhere.equals("")) {
			sql.append(" where " + strWhere);
		}
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			return listCacheCommonHandler(sql.toString(), instPlayerId);
		} else {
			List<DictBarrierDrop> dictBarrierDropList = (List<DictBarrierDrop>) this.getJdbcTemplate().query(sql.toString(), new ItemMapper());
			return dictBarrierDropList;
		}
	}

	public List<Long> getListIdByWhere(String strWhere) throws Exception {
		try {
			List<Long> listLong = new ArrayList<Long>();
			StringBuffer sql = new StringBuffer("select id from Dict_Barrier_Drop ");
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(" where " + strWhere);
			}
			SqlRowSet rsSet = this.getJdbcTemplate().queryForRowSet(sql.toString());
			while (rsSet.next()) {
				listLong.add(rsSet.getLong("id"));
			}
			return listLong;
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<DictBarrierDrop> getListPagination(int index, int size, String strWhere, int instPlayerId) throws Exception {
		try {
			StringBuffer sql = null;
			PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				sql = new StringBuffer("select id, version from Dict_Barrier_Drop ");
			}else {
				sql = new StringBuffer("select * from Dict_Barrier_Drop ");
			}
			if(index <= 0 || size <= 0){
				throw new Exception("index or size must bigger than zero");
			}else{
				index = (index - 1) * size;
			}
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(" where " + strWhere);
			}
			sql.append(" limit " + index + "," + size + "");
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				return listCacheCommonHandler(sql.toString(), instPlayerId);
			} else {
				return (List<DictBarrierDrop>) this.getJdbcTemplate().query(sql.toString(), new ItemMapper());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isExist(long id, String strWhere) throws Exception {
		try {
			StringBuffer sql = new StringBuffer("select count(*) from Dict_Barrier_Drop where id =?");
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(" or " + strWhere);
			}
			int count = this.getJdbcTemplate().queryForObject(sql.toString(), Integer.class);
			return count > 0 ? true : false;
		} catch (Exception e) {
			throw e;
		}
	}

	public int getCount(String strWhere) throws Exception {
		try {
			StringBuffer sql = new StringBuffer("select count(*) from Dict_Barrier_Drop");
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(" where " + strWhere);
			}
			return this.getJdbcTemplate().queryForObject(sql.toString(), Integer.class);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Long> getCounts(String strWhere) throws Exception {
		try {
			List<Long> listLong = new ArrayList<Long>();
			StringBuffer sql = new StringBuffer("select count(*) as cnt from Dict_Barrier_Drop ");
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(strWhere);
			}
			SqlRowSet rsSet = this.getJdbcTemplate().queryForRowSet(sql.toString());
			while (rsSet.next()) {
				listLong.add(rsSet.getLong("cnt"));
			}
			return listLong;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Map<String,Object>> sqlHelper(String sql) {
		return this.getJdbcTemplate().queryForList(sql);
	}

	@SuppressWarnings("unchecked")
	public List<DictBarrierDrop> getListFromMoreTale(String afterSql, int instPlayerId) {
		StringBuffer sql = null;
		PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			sql = new StringBuffer("select a.id, a.version from Dict_Barrier_Drop a ");
		}else {
			sql = new StringBuffer("select a.* from Dict_Barrier_Drop a ");
		}
		if (afterSql != null && !afterSql.equals("")) {
			sql.append(afterSql);
		}
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			return listCacheCommonHandler(sql.toString(), instPlayerId);
		} else {
			return (List<DictBarrierDrop>) this.getJdbcTemplate().query(sql.toString(), new ItemMapper());
		}
	}

	public List<Long> getListIdFromMoreTable(String afterSql) throws Exception {
		try {
			List<Long> listLong = new ArrayList<Long>();
			StringBuffer sql = new StringBuffer("select a.id from Dict_Barrier_Drop a ");
			if (afterSql != null && !afterSql.equals("")) {
				sql.append(afterSql);
			}
			SqlRowSet rsSet = this.getJdbcTemplate().queryForRowSet(sql.toString());
			while (rsSet.next()) {
				listLong.add(rsSet.getLong("id"));
			}
			return listLong;
		} catch (Exception e) {
			throw e;
		}
	}

	public int getStatResult(String statType, String conParam, String strWhere) throws Exception {
		int result = 0;
		try {
			StringBuffer sql = new StringBuffer("select "+statType+"("+conParam+") from  Dict_Barrier_Drop");
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(" where " + strWhere);
			}
			return this.getJdbcTemplate().queryForObject(sql.toString(), Integer.class);
		} catch (Exception e) {
			return result;
		}
	}

	private List<DictBarrierDrop> listCacheCommonHandler(String sql, int instPlayerId){
		List<DictBarrierDrop> modelList = new ArrayList<DictBarrierDrop>();
		PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
		SqlRowSet rsSet = this.getJdbcTemplate().queryForRowSet(sql.toString());
		while (rsSet.next()) {
			int id = rsSet.getInt("id");
			int dbVersion = rsSet.getInt("version");
			DictBarrierDrop model = playerMemObj.dictBarrierDropMap.get(id);
			if (model == null) {
				model = getModel(id, instPlayerId);
				model.result = "";
				modelList.add(model);
			} else {
				int cacheVersion = model.getVersion();
				if (cacheVersion != dbVersion) {
					model = getModel(id, instPlayerId);
				}
				model.result = "";
				modelList.add(model);
			}
		}
		return modelList;
	}

}