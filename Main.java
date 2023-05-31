import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        List<Integer> sequencia = List.of(1, 15, 16, 25, 32, 36);
        int quantidadeSorteios = 51000000; // 51 milhões

        System.out.println("Realizando sorteio de " + quantidadeSorteios + " números...");

        for (int i = 0; i < quantidadeSorteios; i++) {
            int numeroSorteado = sortearNumero();
            lista.add(numeroSorteado);
        }

        System.out.println("Sorteio concluído. Verificando sequência...");

        verificarSequenciaDireta(lista, sequencia);
        verificarSequenciaInversa(lista, sequencia);
    }

    private static int sortearNumero() {
        Random random = new Random();
        return random.nextInt(60) + 1; // números de 1 a 60 (inclusive)
    }

    private static void verificarSequenciaDireta(List<Integer> lista, List<Integer> sequencia) {
        int tamanhoSequencia = sequencia.size();
        int quantidadeSequencia = 0;
        int posicaoInicial = -1;

        for (int i = 0; i < lista.size() - tamanhoSequencia + 1; i++) {
            if (lista.subList(i, i + tamanhoSequencia).equals(sequencia)) {
                quantidadeSequencia++;
                if (posicaoInicial == -1) {
                    posicaoInicial = i;
                }
            }
        }

        System.out.println("Sequência encontrada (ordem direta):");
        if (quantidadeSequencia > 0) {
            System.out.println("Quantidade de vezes que a sequência aparece: " + quantidadeSequencia);
            System.out.println("Posição inicial da sequência: " + posicaoInicial);
        } else {
            System.out.println("A sequência não foi encontrada.");
        }
    }

    private static void verificarSequenciaInversa(List<Integer> lista, List<Integer> sequencia) {
        int tamanhoSequencia = sequencia.size();
        int quantidadeSequencia = 0;
        int posicaoInicial = -1;

        List<Integer> sequenciaInversa = new ArrayList<>(sequencia);
        java.util.Collections.reverse(sequenciaInversa);

        for (int i = 0; i < lista.size() - tamanhoSequencia + 1; i++) {
            if (lista.subList(i, i + tamanhoSequencia).equals(sequenciaInversa)) {
                quantidadeSequencia++;
                if (posicaoInicial == -1) {
                    posicaoInicial = i;
                }
            }
        }

        System.out.println("Sequência encontrada (ordem inversa):");
        if (quantidadeSequencia > 0) {
            System.out.println("Quantidade de vezes que a sequência aparece: " + quantidadeSequencia);
            System.out.println("Posição inicial da sequência: " + posicaoInicial);
        } else {
            System.out.println("A sequência não foi encontrada.");
        }
    }
}