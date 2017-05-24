package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		//leer alumnos
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
		//leer agrupaciones
		num=buffAgru.readLine();
		String pc,alums;
		int totalAgru=Integer.parseInt(num);
		for(int i=0;i<totalAgru;++i){
			name=buffAgru.readLine();
			password=buffAgru.readLine();
			actIni=buffAgru.readLine();
			alums=buffAgru.readLine();
			pc=buffAgru.readLine();
			String[] actIniSplit=actIni.split(" ");
			String[] pcSplit=pc.split(" ");
			String[] alumsSplit=alums.split(" ");
			ArrayList<String> pcList=new ArrayList<String>();
			for(int j=0;j<pcSplit.length;++j) pcList.add(pcSplit[j]);
			agrupaciones.add(new Agrupacion(name,password,actIniSplit,pcList));
			for(int j=0;j<alumsSplit.length;++j){
				for(int k=0;k<alumnos.size();++k)
					if(alumsSplit[j].equalsIgnoreCase(alumnos.get(k).getName())){
						agrupaciones.get(i).apuntarAlumno(alumnos.get(k));
						alumnos.get(k).apuntarseAsociacion(agrupaciones.get(i));
					}
			}
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
		String agru,verified;
		num=buffAct.readLine();
		int totalAct=Integer.parseInt(num);
		for(int i=0;i<totalAct;++i){
			name=buffAct.readLine();
			desc=buffAct.readLine();
			pc=buffAct.readLine();
			lugar=buffAct.readLine();
			fecha=buffAct.readLine();
			alums=buffAct.readLine();
			agru=buffAct.readLine();
			verified=buffAct.readLine();
			String[]pcSplit=pc.split(" ");
			String[] alumsSplit=alums.split(" ");
			ArrayList<String> pcList=new ArrayList<String>();
			for(int j=0;j<pcSplit.length;++j) pcList.add(pcSplit[j]);
			for(int j=0;j<agrupaciones.size();++j){
				if(agru.equals(agrupaciones.get(j).getName())){
					actividades.add(new Actividad(name,desc,pcList,new Lugar(lugar),
							new Fecha(fecha),agrupaciones.get(j),verified));
					agrupaciones.get(j).apuntarActividad(actividades.get(i));
					}
			}
			for(int j=0;j<alumsSplit.length;++j){
				for(int k=0;k<alumnos.size();++k){
					if(alumsSplit[j].equalsIgnoreCase(alumnos.get(k).getName())){
						alumnos.get(k).apuntarseActividad(actividades.get(i));
					}
				}
			}
		}
		buffAct.close();
		buffIni.close();
		buffAgru.close();
		buffAlum.close();
	}
	
	public ArrayList<Actividad> getActividades(){
		return actividades;
	}
	public ArrayList<Iniciativa> getIniciativas(){
		return iniciativas;
	}
	public ArrayList<Alumno> getAlumnos(){
		return alumnos;
	}
	public ArrayList<Agrupacion> getAgrupaciones(){
		return agrupaciones;
	}
	public void guardarDAO()throws IOException{
		BufferedWriter buffAct = new BufferedWriter(new FileWriter(NAME_ACTIVITIES));
		BufferedWriter buffIni = new BufferedWriter(new FileWriter(NAME_INITIATIVES));
		BufferedWriter buffAlum = new BufferedWriter(new FileWriter(NAME_STUDENT));
		BufferedWriter buffAgru = new BufferedWriter(new FileWriter(NAME_AE));
		
		buffAct.write(String.valueOf(actividades.size())+'\n');
		for(int i=0;i<actividades.size();++i)
			buffAct.write(actividades.get(i).guardar());
		
		buffIni.write(String.valueOf(iniciativas.size())+'\n');
		for(int i=0;i<iniciativas.size();++i)
			buffIni.write(iniciativas.get(i).guardar());
		
		buffAlum.write(String.valueOf(alumnos.size())+'\n');
		for(int i=0;i<alumnos.size();++i)
			buffAlum.write(alumnos.get(i).guardar());
		
		buffAgru.write(String.valueOf(agrupaciones.size())+'\n');
		for(int i=0;i<agrupaciones.size();++i)
			buffAgru.write(agrupaciones.get(i).guardar());
		
		buffAct.close();
		buffIni.close();
		buffAgru.close();
		buffAlum.close();
	}
}