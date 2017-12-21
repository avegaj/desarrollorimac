package eb.dcbackend.dao;

import java.util.List;

import eb.dcbackend.model.AvanceVenta;

public interface AvanceVentaDAO {
	
	AvanceVenta findById (int id);
	
	AvanceVenta findByYear (int year);
	
	AvanceVenta findByMonth (int month);
	
	AvanceVenta findByChannel (String channel);
	
	List<AvanceVenta> findAllAvancesVenta();

}
