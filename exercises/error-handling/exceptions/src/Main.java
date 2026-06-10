import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        processarIdade("-5");
        String arquivo = "arquivo.txt";
        lerArquivo(arquivo);
    }

    // exception checked (quando o compilador te avisa)
    public static void lerArquivo(String arquivoNome) {
        // try-with-resources: fecha o br automaticamente
        // mesmo se der excecao no meio da leitura
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoNome))) {
            String linha = br.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo nao encontrado");
        } catch (IOException ioe) {
            System.out.println("Erro ao ler o arquivo");
        }
    }

    // exception unchecked (runtime exception)
    public static void processarIdade(String input) {
        // validacao de campo
        if (input == null || input.isEmpty()) {
            System.out.println("Campo obrigatório");
            return;
        }

        // try/catch para pegar erros que so consegue tentando
        try {
            int idade = Integer.parseInt(input);

            // validacao de regra de negocio usando custom exception
            if (idade < 0 || idade > 150) {
                validarIdade(idade); // chamada do metodo da exception custom
                return;
            }

            System.out.println("Idade: " + idade);
        } catch (NumberFormatException nfe) {
            System.out.println("Digite apenas números");
        }
    }

    // exception personalizada extendendo IllegalArgumentException
    public static void validarIdade(int idade){
        if(idade < 0){
            throw new IdadeMenorQueZeroException("Idade nao pode ser negativa");
        }
    }
}