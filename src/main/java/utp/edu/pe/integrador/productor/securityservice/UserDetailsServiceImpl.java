package utp.edu.pe.integrador.productor.securityservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utp.edu.pe.integrador.productor.entity.Role;
import utp.edu.pe.integrador.productor.interfaces.IRegistroUsuario;
import utp.edu.pe.integrador.productor.interfacesservice.IRegistroUsuarioService;
import utp.edu.pe.integrador.productor.model.RegistroUsuario;
import utp.edu.pe.integrador.productor.repository.UserRepository;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    UserRepository userRepository;
	
	@Autowired
	private IRegistroUsuarioService servicio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		utp.edu.pe.integrador.productor.entity.User appUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));

		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>(); 
		for (Role role: appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
            grantList.add(grantedAuthority);
		}
		UserDetails user = (UserDetails) new User(username,appUser.getPassword(),grantList);	
		
		RegistroUsuario registro = new RegistroUsuario();
		registro.setFecha("12/05/2021");
		registro.setHora("12:20");
		registro.setUsername(user.getUsername());
		servicio.grabarRegistro(registro);

		return user;
	}

}