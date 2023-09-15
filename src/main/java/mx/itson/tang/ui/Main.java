/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.tang.ui;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Hector Lucero
 */
public class Main {
    
    public static void main(String[] args) {
        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese una serie de números separados por guion medio:");
            input = scanner.nextLine();
        }

        // Definir los patrones de códigos de área
        Pattern tijuanaPattern = Pattern.compile(".*(664|664-).*");
        Pattern hermosilloPattern = Pattern.compile(".*(662|662-).*");
        Pattern guaymasPattern = Pattern.compile(".*(622|622-).*");

        // Contadores para cada categoría
        int tijuanaCount = 0;
        int hermosilloCount = 0;
        int guaymasCount = 0;
        int desconocidoCount = 0;

        // Dividir la entrada en números individuales
        String[] numeros = input.split("-");

        // Verificar cada número
        for (String numero : numeros) {
            String numeroLimpio = numero.replaceAll("[^0-9]", ""); // Eliminar caracteres no numéricos
            Matcher tijuanaMatcher = tijuanaPattern.matcher(numeroLimpio);
            Matcher hermosilloMatcher = hermosilloPattern.matcher(numeroLimpio);
            Matcher guaymasMatcher = guaymasPattern.matcher(numeroLimpio);

            if (tijuanaMatcher.matches()) {
                System.out.println("Número de Tijuana: " + numero);
                tijuanaCount++;
            } else if (hermosilloMatcher.matches()) {
                System.out.println("Número de Hermosillo: " + numero);
                hermosilloCount++;
            } else if (guaymasMatcher.matches()) {
                System.out.println("Número de Guaymas: " + numero);
                guaymasCount++;
            } else {
                System.out.println("Número con código de área desconocido: " + numero);
                desconocidoCount++;
            }
        }

        // Mostrar resultados
        System.out.println("Hay " + tijuanaCount + " números de Tijuana");
        System.out.println("Hay " + hermosilloCount + " números de Hermosillo");
        System.out.println("Hay " + guaymasCount + " números de Guaymas");
        System.out.println("Hay " + desconocidoCount + " números con código de área desconocido");
    }
}

    

