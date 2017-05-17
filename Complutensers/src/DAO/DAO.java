package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ssactividades.*;
import ssactividades.map.Lugar;
import ssusuarios.*;

public class DAO {
	final static String NAME_STUDENT = "loginStudent.txt";
	final static String NAME_AE = "loginAE.txt";
	final static String NAME_ACTIVITIES = "activities.txt";
	final static String NAME_INITIATIVES = "initiatives.txt";
	
	private ArrayList<Actividad> actividades;
	private ArrayList<Iniciativa> iniciativas;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Agrupacion> agrupaciones;
	
	public DAO() throws IOException{
		actividades=new ArrayList<Actividad>();
		iniciativas=new ArrayList<Iniciativa>();
		alumnos=new ArrayList<Alumno>();
		agrupaciones=new ArrayList<Agrupacion>();
		BufferedReader buffAct = new BufferedReader(new FileReader(NAME_ACTIVITIES));
		BufferedReader buffIni = new BufferedReader(new FileReader(NAME_INITIATIVES));
		BufferedReader buffAlum = new BufferedReader(new FileReader(NAME_STUDENT));
		BufferedReader buffAgru = new BufferedReader(new FileReader(NAME_AE));
		String name,password,actIni;
		String num;
		num=buffAlum.readLine();
		int totalAlum=Integer.parseInt(num);
		for(int i=0;i<totalAlum;++i){
			name=buffAlum.readLine();
			password=buffAlum.readLine();
			actIni=buffAlum.readLine();
			String[] actIniSplit=actIni.split(" ");
			alumnos.add(new Alumno(name,password,actIniSplit));
		}
		num=buffAgru.readLine();
		String pc;
		int totalAgru=Integer.parseInt(num);
		for(int i=0;i<totalAgru;++i){
			name=buffAgru.readLine();
			password=buffAgru.readLine();
			actIni=buffAgru.readLine();
			pc=buffAgru.readLine();
			String[] actIniSplit=actIni.split(" ");
			String[]pcSplit=pc.split(" ");
			ArrayList<String> pcList=new ArrayList<String>();
			for(int j=0;j<pcSplit.length;++j) pcList.add(pcSplit[j]);
			agrupaciones.add(new Agrupacion(name,password,actIniSplit,pcList));
		}
		num=buffIni.readLine();
		int totalIni=Integer.parseInt(num);
		String desc,lugar,fecha,alum;
		for(int i=0;i<totalIni;++i){
			name=buffIni.readLine();
			desc=buffIni.readLine();
			pc=buffIni.readLine();
			lugar=buffIni.readLine();
			fecha=buffIni.readLine();
			alum=buffIni.readLine();
			String[]pcSplit=pc.split(" ");
			ArrayList<String> pcList=new ArrayList<String>();
			for(int j=0;j<pcSplit.length;++j) pcList.add(pcSplit[j]);
			for(int j=0;j<alumnos.size();++j){
				if(alum.equals(alumnos.get(j).getName()))
					iniciativas.add(new Iniciativa(name,new Lugar(lugar),new Fecha(fecha),desc,
							alumnos.get(j),pcList));
			}
		}
		
		
	}
}