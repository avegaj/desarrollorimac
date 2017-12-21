package eb.dcbackend.service;

import java.util.List;

import eb.dcbackend.model.AvanceVenta;

public interface AvanceVentaService {

	AvanceVenta findById (int id);
	
	AvanceVenta findByYear (int year);
	
	AvanceVenta findByMonth (int month);
	
	AvanceVenta findByChannel (String channel);
	
	List<AvanceVenta> findAllAvancesVenta();
	
}
