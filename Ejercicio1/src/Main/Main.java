package Main;

import Person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        try{

            BufferedReader br = new BufferedReader(new FileReader("src\\FicheroPersona.txt"));
            List<Person> personList = new ArrayList<Person>();
            String line;

            while((line = br.readLine())!= null){

                String nombre = getDataOptional(line.split(":"), 0).orElse("Desconocido");
                String poblacion = getDataOptional(line.split(":"), 1).orElse("Desconocida");
                String edad = getDataOptional(line.split(":"), 2).orElse("Desconocida");

                Person p = new Person(nombre, poblacion, edad);
                personList.add(p);

                System.out.println( "Nombre: " + p.getName() + ", poblacion: " + p.getPopulation() +
                        ", edad: " +p.getAge());

            }

            System.out.println("\nMenores de 25 anios: ");
            personList.stream().filter(e -> parseInt(e.getAge()) < 25).forEach(e-> System.out.println("Nombre: "+e.getName()));

        }  catch (FileNotFoundException e){
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }

    }

    public static Optional<String> getDataOptional(String[] data, int index){
        try{
            if(data[index].isEmpty()) return Optional.empty();
            return Optional.of(data[index]);
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
