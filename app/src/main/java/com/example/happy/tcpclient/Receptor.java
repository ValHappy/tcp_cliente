package com.example.happy.tcpclient;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Receptor extends Thread {

	Socket socket;
	OnMessage observer;

	public Receptor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try {
			InputStream is = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			while (true) {
				String line = reader.readLine();
				System.out.println(line);

				Log.e("RECIBIDO", line);

				observer.onReceived(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public interface OnMessage{
		public void onReceived(String mensaje);
	}

	public void setObserver(OnMessage observer){
		this.observer = observer;
	}

}
