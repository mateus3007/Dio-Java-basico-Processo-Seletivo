package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "ALGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "MATEUS" };
        selecaocandidato(candidatos);

    }
    static void selecaocandidato(String[] candidatos) {
        int cadidatosselecionados = 0;
        int cadidatoatual = 0;
        double salariobase = 2000.0;
        while (cadidatosselecionados < 5 && cadidatoatual < candidatos.length) {
            String candidato = candidatos[cadidatoatual];
            Double salariopretendido = valorPretendido();

            System.out.println("o candidato " + candidato + " solicitou o valor de salario " + salariopretendido);
            if (salariobase > salariopretendido) {
                cadidatosselecionados++;
                imprimirSelecionados(candidato);
            } else if (salariobase == salariopretendido) {
                System.out.println("LIGAR PARA O CANTIDADO COM A CONTRA PROPOSTA");
                entrandoEmContado(candidato);
            } else {
                System.out.println("AGUARDANDO O RESULDADO DOS DEMAIS CANDIDATOS");
            }
            cadidatoatual++;
        }

    }

    static void imprimirSelecionados(String candidatos) {
        System.out.println("o candidato selecionado foi o " + candidatos);
        entrandoEmContado(candidatos);
    }

    static void entrandoEmContado(String cantidado) {
        int tentativasrealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if (continuaTentando) {
                tentativasrealizadas++;
            } else {
                System.out.println("CONTADO REALIZADO COM SUCESSO");
            }
        } while (continuaTentando && tentativasrealizadas < 3);
        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO " + cantidado + " NA " + tentativasrealizadas);
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO " + cantidado + " NUMERO MAXIMO DE TENTATIVAS "
                    + tentativasrealizadas);
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2500);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

}
