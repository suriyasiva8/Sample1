package com.itemWriter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.itemReader.Reader;

public class Writer implements RowMapper<Reader> {

	@Override
	public Reader mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Reader read=new Reader();
		read.setUNIT_ID(rs.getString("UNIT_ID"));
		read.setVMC_ID(rs.getString("VMC_ID"));
		read.setPLANT_LOC_CODE(rs.getString("PLANT_LOC_CODE"));
		read.setDEPT_CODE(rs.getString("DEPT_CODE"));
		read.setIMG_PACV_VAL(rs.getString("IMG_PACV_VAL"));
		read.setSPCNTRL_PACV_VAL(rs.getString("SPCNTRL_PACV_VAL"));
        read.setSPCNTRL_CHK(rs.getString("SPCNTRL_CHK"));	
        read.setUNIT_IMG_CHK(rs.getString("UNIT_IMG_CHK"));
        read.setK2_CHK(rs.getString("K2_CHK"));
        read.setCPK_VAL(rs.getString("CPK_VAL"));
        read.setMAINT_DATE(rs.getString("MAINT_DATE"));
        read.setUNIT_PACV_SCORE(rs.getString("UNIT_PACV_SCORE"));
				
		return read;
	}

}
