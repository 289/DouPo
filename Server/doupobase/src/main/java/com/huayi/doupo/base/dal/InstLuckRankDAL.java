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
import com.huayi.doupo.base.model.InstLuckRank;

public class InstLuckRankDAL extends DALFather {
	@SuppressWarnings("rawtypes")
	public class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			InstLuckRank instLuckRank = new InstLuckRank();
			instLuckRank.setId(rs.getInt("id"), 0);
			instLuckRank.setPlayerId(rs.getInt("playerId"), 0);
			instLuckRank.setName(rs.getString("name"), 0);
			instLuckRank.setRankValue(rs.getInt("rankValue"), 0);
			instLuckRank.setOrderIndex(rs.getInt("orderIndex"), 0);
			instLuckRank.setCountReset(rs.getString("countReset"), 0);
			instLuckRank.setStartRemain(rs.getInt("startRemain"), 0);
			instLuckRank.setRefreshRemain(rs.getInt("refreshRemain"), 0);
			instLuckRank.setItems(rs.getString("items"), 0);
			instLuckRank.setVersion(rs.getInt("version"), 0);
			instLuckRank.setPayStartCount(rs.getInt("payStartCount"), 0);
			instLuckRank.setPayRefreshCount(rs.getInt("payRefreshCount"), 0);
			instLuckRank.setGetLimitCount(rs.getInt("getLimitCount"), 0);
			instLuckRank.setLastLimitValue(rs.getInt("lastLimitValue"), 0);
			return instLuckRank;
		}
	}

	public InstLuckRank add(final InstLuckRank model, int instPlayerId) throws Exception {
		try {
			StringBuilder strSql = new StringBuilder();
			strSql.append(" insert into Inst_LuckRank (");
			strSql.append("playerId,name,rankValue,orderIndex,countReset,startRemain,refreshRemain,items,version,payStartCount,payRefreshCount,getLimitCount,lastLimitValue");
			strSql.append(" )");
			strSql.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");

			final String sql = strSql.toString();
			KeyHolder keyHolder = new GeneratedKeyHolder();

			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, model.getPlayerId());
					ps.setString(2, model.getName());
					ps.setInt(3, model.getRankValue());
					ps.setInt(4, model.getOrderIndex());
					ps.setString(5, model.getCountReset());
					ps.setInt(6, model.getStartRemain());
					ps.setInt(7, model.getRefreshRemain());
					ps.setString(8, model.getItems());
					ps.setInt(9, 0);
					ps.setInt(10, model.getPayStartCount());
					ps.setInt(11, model.getPayRefreshCount());
					ps.setInt(12, model.getGetLimitCount());
					ps.setInt(13, model.getLastLimitValue());
					return ps;
				}
			},keyHolder);

			model.setId(keyHolder.getKey().intValue());
			model.setVersion(0);
			PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				playerMemObj.instLuckRankMap.put(model.getId(), model);
			}
		} catch (Exception e) {
			throw e;
		}
		return model;
	}

	public void batchAdd (final List<InstLuckRank> list) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into Inst_LuckRank (");
		sql.append("playerId,name,rankValue,orderIndex,countReset,startRemain,refreshRemain,items,version,payStartCount,payRefreshCount,getLimitCount,lastLimitValue");
		sql.append(" )");
		sql.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter (){
			public void setValues(PreparedStatement ps, int i) throws SQLException{
				InstLuckRank model = (InstLuckRank)list.get(i);
					ps.setInt(1, model.getPlayerId());
					ps.setString(2, model.getName());
					ps.setInt(3, model.getRankValue());
					ps.setInt(4, model.getOrderIndex());
					ps.setString(5, model.getCountReset());
					ps.setInt(6, model.getStartRemain());
					ps.setInt(7, model.getRefreshRemain());
					ps.setString(8, model.getItems());
					ps.setInt(9, 0);
					ps.setInt(10, model.getPayStartCount());
					ps.setInt(11, model.getPayRefreshCount());
					ps.setInt(12, model.getGetLimitCount());
					ps.setInt(13, model.getLastLimitValue());
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
				playerMemObj.instLuckRankMap.remove(id);
			}
			String sql = "delete from Inst_LuckRank  where id = ?";
			Object[] params = new Object[]{id};
			return this.getJdbcTemplate().update(sql, params);
		} catch (Exception e) {
			throw e;
		}
	}

	public int deleteByWhere(String strWhere) throws Exception {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("delete from Inst_LuckRank where 1=1 ");
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

	public InstLuckRank update(InstLuckRank model, int instPlayerId) throws Exception {
		try {
			Object[] params = null;
			int version = model.getVersion() + 1;
			StringBuffer sql = new StringBuffer("update Inst_LuckRank set ");
			sql.append("playerId=?,name=?,rankValue=?,orderIndex=?,countReset=?,startRemain=?,refreshRemain=?,items=?,version=?,payStartCount=?,payRefreshCount=?,getLimitCount=?,lastLimitValue=? ");
			sql.append("where id=? and version=?");
			params = new Object[] { model.getPlayerId(),model.getName(),model.getRankValue(),model.getOrderIndex(),model.getCountReset(),model.getStartRemain(),model.getRefreshRemain(),model.getItems(),version,model.getPayStartCount(),model.getPayRefreshCount(),model.getGetLimitCount(),model.getLastLimitValue() , model.getId(), model.getVersion() };
			int count = this.getJdbcTemplate().update(sql.toString(), params);
			if (count == 0) {
				throw new Exception("Concurrent Exception");
			} else {
				model.setVersion(version, 0);
				PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
				if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
					playerMemObj.instLuckRankMap.put(model.getId(), model);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return model;
	}

	@SuppressWarnings("unchecked")
	public InstLuckRank getModel(int id, int instPlayerId) {
		try {
			PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				InstLuckRank model = playerMemObj.instLuckRankMap.get(id);
				if (model == null) {
					String sql = "select * from Inst_LuckRank where id=?";
					Object[] params = new Object[]{id};
					playerMemObj.instLuckRankMap.put(id, (InstLuckRank) this.getJdbcTemplate().queryForObject(sql, params, new ItemMapper()));
				} else {
					int cacheVersion = model.getVersion();
					List<Map<String, Object>> list = sqlHelper("select version from Inst_LuckRank where id = " + id);
					 int dbVersion = (int)list.get(0).get("version");
					if (cacheVersion != dbVersion) {
						String sql = "select * from Inst_LuckRank where id=?";
						Object[] params = new Object[]{id};
						playerMemObj.instLuckRankMap.put(id, (InstLuckRank) this.getJdbcTemplate().queryForObject(sql, params, new ItemMapper()));
					}
				}
				model = playerMemObj.instLuckRankMap.get(id);
				model.result = "";
				return model;
			} else {
				String sql = "select * from Inst_LuckRank where id=?";
				Object[] params = new Object[]{id};
				InstLuckRank model = ( InstLuckRank) this.getJdbcTemplate().queryForObject(sql, params, new ItemMapper());
				model.result = "";
				return model;
			}
		} catch (DataAccessException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<InstLuckRank> getList(String strWhere, int instPlayerId) {
		StringBuffer sql = null;
		PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			sql = new StringBuffer("select id, version from Inst_LuckRank ");
		}else {
			sql = new StringBuffer("select * from Inst_LuckRank ");
		}
		if (strWhere != null && !strWhere.equals("")) {
			sql.append(" where " + strWhere);
		}
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			return listCacheCommonHandler(sql.toString(), instPlayerId);
		} else {
			List<InstLuckRank> instLuckRankList = (List<InstLuckRank>) this.getJdbcTemplate().query(sql.toString(), new ItemMapper());
			return instLuckRankList;
		}
	}

	public List<Long> getListIdByWhere(String strWhere) throws Exception {
		try {
			List<Long> listLong = new ArrayList<Long>();
			StringBuffer sql = new StringBuffer("select id from Inst_LuckRank ");
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
	public List<InstLuckRank> getListPagination(int index, int size, String strWhere, int instPlayerId) throws Exception {
		try {
			StringBuffer sql = null;
			PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
			if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
				sql = new StringBuffer("select id, version from Inst_LuckRank ");
			}else {
				sql = new StringBuffer("select * from Inst_LuckRank ");
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
				return (List<InstLuckRank>) this.getJdbcTemplate().query(sql.toString(), new ItemMapper());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isExist(long id, String strWhere) throws Exception {
		try {
			StringBuffer sql = new StringBuffer("select count(*) from Inst_LuckRank where id =?");
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
			StringBuffer sql = new StringBuffer("select count(*) from Inst_LuckRank");
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
			StringBuffer sql = new StringBuffer("select count(*) as cnt from Inst_LuckRank ");
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
	public List<InstLuckRank> getListFromMoreTale(String afterSql, int instPlayerId) {
		StringBuffer sql = null;
		PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			sql = new StringBuffer("select a.id, a.version from Inst_LuckRank a ");
		}else {
			sql = new StringBuffer("select a.* from Inst_LuckRank a ");
		}
		if (afterSql != null && !afterSql.equals("")) {
			sql.append(afterSql);
		}
		if (instPlayerId != 0 && isUseCach() && playerMemObj != null) {
			return listCacheCommonHandler(sql.toString(), instPlayerId);
		} else {
			return (List<InstLuckRank>) this.getJdbcTemplate().query(sql.toString(), new ItemMapper());
		}
	}

	public List<Long> getListIdFromMoreTable(String afterSql) throws Exception {
		try {
			List<Long> listLong = new ArrayList<Long>();
			StringBuffer sql = new StringBuffer("select a.id from Inst_LuckRank a ");
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
			StringBuffer sql = new StringBuffer("select "+statType+"("+conParam+") from  Inst_LuckRank");
			if (strWhere != null && !strWhere.equals("")) {
				sql.append(" where " + strWhere);
			}
			return this.getJdbcTemplate().queryForObject(sql.toString(), Integer.class);
		} catch (Exception e) {
			return result;
		}
	}

	private List<InstLuckRank> listCacheCommonHandler(String sql, int instPlayerId){
		List<InstLuckRank> modelList = new ArrayList<InstLuckRank>();
		PlayerMemObj playerMemObj = getPlayerMemObjByPlayerId(instPlayerId);
		SqlRowSet rsSet = this.getJdbcTemplate().queryForRowSet(sql.toString());
		while (rsSet.next()) {
			int id = rsSet.getInt("id");
			int dbVersion = rsSet.getInt("version");
			InstLuckRank model = playerMemObj.instLuckRankMap.get(id);
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