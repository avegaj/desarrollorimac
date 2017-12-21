package eb.dcbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.AvanceVentaDAO;
import eb.dcbackend.model.AvanceVenta;
import eb.dcbackend.service.AvanceVentaService;


@Service("avanceVentaService")
@Transactional
public class AvanceVentaServiceImpl implements AvanceVentaService{
	
	@Autowired
	private AvanceVentaDAO dao;
	
	public AvanceVenta findById(int id) {
		return dao.findById(id);
	}
	
	public AvanceVenta findByYear(int id) {
		return dao.findByYear(id);
	}
	
	public AvanceVenta findByMonth(int id) {
		return dao.findByMonth(id);
	}
	
	public AvanceVenta findByChannel(String channel) {
		return dao.findByChannel(channel);
	}

	public List<AvanceVenta> findAllAvancesVenta() {
		return dao.findAllAvancesVenta();
	}

}
