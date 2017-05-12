package proyectg.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ftputils {
	
	/*
	 * Para conectarse por ftp usaremos la libreria de apache.commons
	 * 
	 */
	
	private Session session;

	public void conectarseFtp(String usuario, String password, String host)
	{
		FTPClient clienteftp = new FTPClient();
		
		try{
			clienteftp.connect(host);
			boolean login = clienteftp.login(usuario, password); 
			System.out.println("[[Estado]]::"+login);
			
			clienteftp.logout();
			clienteftp.disconnect();
		}
		catch(IOException error)
		{
			System.out.println("[[Error]]"+ error.toString());
		}
	}
	
	
	public void conectarseSftp(String usuario, String password, String host) throws JSchException, IllegalAccessException
	{
		int port = 22;
		

			if(this.session == null || !this.session.isConnected())
			{
					JSch clientesftp = new JSch();
					
					this.session = clientesftp.getSession(usuario,host,port);
					this.session.setPassword(password);
					
					//Esta linea no valida la key del sftp. o se quedaria esperando respuesta
					this.session.setConfig("StrictHostKeyChecking","no");
					
					this.session.connect();
					
					System.out.println("Ya estas conectado");
			}
			else
			{
				throw new IllegalAccessException("Session ya iniciada.");
			}
		
		
		
	}
	
	public final void desconectarse()
	{
		this.session.disconnect();
	}

}
