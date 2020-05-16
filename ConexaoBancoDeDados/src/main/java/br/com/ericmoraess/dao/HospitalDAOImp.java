package br.com.ericmoraess.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import br.com.ericmoraess.conexao.FabricaDeConexoes;
import br.com.ericmoraess.entidade.Hospital;

public class HospitalDAOImp implements HospitalDAO {

	public Set<Hospital> getAllHospitals() {

		Connection connection = FabricaDeConexoes.getConnection();

		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM hospital");
			Set hospitals = new HashSet();

			while (rs.next()){
				Hospital hospital = extractHospitalFromResultSet(rs);
				hospitals.add(hospital);
			}

			return hospitals;

		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return null;
	}

	public boolean insertHospital() {
		// TODO Auto-generated method stub
		
		System.out.println(" Memorial Guararapes ");
		
		return false;
	}

	public boolean updateHospital() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteHospital() {
		// TODO Auto-generated method stub
		return false;
	}

	private Hospital extractHospitalFromResultSet(ResultSet rs) throws SQLException {
		Hospital Hospital = new Hospital();
		// coloca o nome da coluna ou indice
		Hospital.setRazao_social(rs.getString(2));
		Hospital.setCnpj( rs.getString(3) );
		return Hospital;
	}

}
