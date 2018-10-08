package com.example.happy.tcpclient;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
	Pantalla4 activity; //Pantalla de juego

	/**
	 * Constructor del Receptor
	 * @param socket
	 * @param activity
	 */
	public Receptor(Socket socket, Pantalla4 activity) {
		this.socket = socket;
		this.activity = activity;
	}

	/**
	 * Metodo para correr el hilo y finalizar el juego
	 */
	@Override
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			while (true) {
				System.out.println("Esperando mensaje");
				String mensaje = dis.readUTF();
				if (mensaje.equals("EndGame")){
					//Cambiar la pantalla aqui
					Intent game = new Intent(activity.getApplicationContext(),Pantalla5.class);
					activity.startActivity(game);
				}
				System.out.println("termina de mover");
			}
		} catch (IOException e) {
			System.out.println("Cliente desconectado: " + e.getMessage());
		}
	}

	public interface OnMessage{
		public void onReceived(String mensaje);
	}

	public void setObserver(OnMessage observer){
		this.observer = observer;
	}

}
