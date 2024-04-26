package utp.edu.pe.integrador.productor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfaces.ITipobaremo;
import utp.edu.pe.integrador.productor.interfacesservice.ITipobaremoService;
import utp.edu.pe.integrador.productor.model.Tipobaremo;

@Service
public class TipobaremoService implements ITipobaremoService {
	
	@Autowired
	private ITipobaremo tip;

	@Override
	public List<Tipobaremo> listarTipobaremos() {
		return (List<Tipobaremo>) tip.findAll();
	}

	@Override
	public int grabarTipobaremo(Tipobaremo pTipobaremo) {
		int res=0;
		Tipobaremo tipobaremo = tip.save(pTipobaremo);
		if (!tipobaremo.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public Tipobaremo tipobaremoPorCodigo(int cod) {
		return tip.findById(cod).orElse(null);
	}

	@Override
	public void eliminarTipobaremo(int cod) {
		tip.deleteById(cod);
	}

}
