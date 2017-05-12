package proyectg.ftp;

import com.jcraft.jsch.JSchException;

public class ftp_main {

	public static void main(String[] args) throws IllegalAccessException, JSchException {
		
	
		//Datos
		String usuario="tu_usuario",password="tu_password",host="tu_host";
		
		ftputils ftp = new ftputils();
		
		ftp.conectarseFtp(usuario, password, host);
		
		ftp.conectarseSftp(usuario, password, host);
		ftp.desconectarse();
		
		
			
	}

}
