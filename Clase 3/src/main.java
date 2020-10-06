import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class main {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Copiar archivos preguntando el archivo de origen y la ruta de destino.
		// Crear un fichero nuevo indicando su ruta.
		// Borrar un fichero indicando su ruta.
		// Mostrar por pantalla el contenido de un fichero de texto.
		// Salir del programa.
		
		boolean salir = false;
		int opc = 0;
		
		while(!salir)
		{
			System.out.println("********MENÚ********");
			System.out.println("1.- Copiar archivos");
			System.out.println("2.- Crear un fichero");
			System.out.println("3.- Borrar fichero");
			System.out.println("4.- Mostrar por pantalla el contenido de un fichero de texto");
			System.out.println("0.- Salir del programa");
			System.out.println("***************");
			System.out.println("Elige una opción:");
			opc = teclado.nextInt();
			teclado.nextLine();
			
			switch(opc)
			{
				case 0:
					salir = true;
					break;
				case 1:
					opcion1();
					break;
				case 2:
					opcion2();
					break;
				case 3:
					opcion3();
					break;
				case 4:
					opcion4();
					break;
				default:
					System.out.println("Opción no válida");
			}
		}
		
	}
	
	public static void opcion4()
	{
		String ruta;
		
		System.out.println("Indica la ruta del fichero que quieras mostrar su contenido");
		ruta = teclado.nextLine();
		
		try(BufferedReader fichero = new BufferedReader(new FileReader(ruta)))
		{
			String linea = fichero.readLine();
			
			while(linea != null)
			{
				System.out.println(linea);
				System.out.println();
				linea = fichero.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la ruta o nombre del fichero: "+ ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void opcion2()
	{
		String ruta;
		
		System.out.println("Indica la ruta para crear tu fichero");
		ruta = teclado.nextLine();
		
		File fichero = new File(ruta);
		
		if(!fichero.exists())
		{
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("¡Fichero creado correctamente!");
		}
		else
		{
			System.out.println("¡El fichero ya existe!");
		}
	}
	
	public static void opcion3()
	{
		String ruta;
		
		System.out.println("Indica la ruta del fichero que desea eliminar");
		ruta = teclado.nextLine();
		
		File fichero = new File(ruta);
		
		if(fichero.exists())
		{
				if(fichero.delete())
				{
					System.out.println("Fichero encontrado y borrado exitosamente");
				}   
				else
				{
					System.out.println("El fichero no puede ser borrado");
				}
		}
		else
		{
			System.out.println("¡¡Puede que el fichero no exista, pusiste mal la ruta o su nombre!!");
		}
	}
	
	public static void opcion1()
	{
		String origen;
		String destino;
		
		System.out.println("Indica la ruta donde está el fichero a copiar junto su fichero");
		origen = teclado.nextLine();
		
		System.out.println("Indica la ruta donde quieras copiar tu fichero junto a su nombre del nuevo fichero");
		destino = teclado.nextLine();
		
	        
	        try {
	        	
	            File original = new File(origen);
	            
	            File copia = new File(destino);
	            
	            InputStream in = new FileInputStream(original);
	            
	            OutputStream out = new FileOutputStream(copia);
	            
	            byte[] buffer = new byte[1024];
	            
	            int caract;
	            
	            while ((caract = in.read(buffer)) > 0) 
	            {
	                out.write(caract);
	            }
	            
	            in.close();
	            out.close();
	            
	            System.out.println("Archivo copiado exitosamente");
	        } 
	        catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	}

}
