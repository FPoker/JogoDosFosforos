import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int op = -1;
        do {
            try {
                in = new Scanner(System.in);
                System.out.println("=======================================================");
                System.out.println("             Bem-vindo ao Jogo dos Fósforos!");
                System.out.println("=======================================================");
                System.out.println("[1] Dois jogadores (jogador vs jogador)");
                System.out.println("[2] Jogue contra o computador (jogador vs PC) modo fácil");
                System.out.println("[3] Jogue contra o computador (jogador vs PC) modo difícil");
                System.out.println("[4] Condições de Jogo");
                System.out.println("[5] Sobre Jogo dos Fósforos");
                System.out.println("[0] Sair");
                System.out.println("=======================================================");

                String valorInserido = in.nextLine().trim();
                if (valorInserido.length() == 1 && valorInserido.matches("\\d")) {
                    op = Integer.parseInt(valorInserido);
                } else {
                    System.out.println("Por favor, insira um número válido.");
                    continue;
                }

                    switch (op) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> jogadorVSjogador();
                        case 2 -> jogadorVScomputadorMF();
                        case 3 -> jogadorVScomputadorMD();
                        case 4 -> ConsultarCondicoesJogo();
                        case 5 -> SobreOJogoDosFosforos();
                        default -> {
                            System.out.println("Opção inválida");
                        }
                    }
                } catch(InputMismatchException e){
                    System.out.println("Por favor, insira um número válido.");
                    in.nextLine();
                }
            } while (op != 0) ;
        }

    private static void jogadorVSjogador() {
        System.out.println("=======================================================");
        System.out.println("               Jogador vs Jogador");
        System.out.println("=======================================================");
        int totalFosforos = 21, valorInserido, nmrMax = 4, nmrUtil = 1;

        while (totalFosforos > 1) {
            if (totalFosforos <= 4) {
                nmrMax = (totalFosforos - 1);
            }

            System.out.println("Jogador número " + nmrUtil + ", por favor, retire no máximo " + nmrMax + " fósforos. Existem " + totalFosforos + " fósforos.");
            valorInserido = in.nextInt();
            System.out.println("-------------------------------------------------------");
            if (valorInserido <= nmrMax && valorInserido >= 1) {
                totalFosforos = totalFosforos - valorInserido;
                if (nmrUtil == 1) {
                    nmrUtil = 2;
                } else {
                    nmrUtil = 1;
                }
            } else {
                System.out.println("Jogada Inválida! Repita.");
                System.out.println("-------------------------------------------------------");
            }
        }
        if (nmrUtil == 1) {
            System.out.println("Jogador número 2 ganhou!");
        } else {
            System.out.println("Jogador número 1 ganhou!");
        }
    }

    private static void jogadorVScomputadorMF() {
        System.out.println("=======================================================");
        System.out.println("        Humano vs Computador (modo fácil)!");
        System.out.println("=======================================================");
        int totalFosforos = 21, valorInserido, nmrMax = 4, jogadaPC;
        Random rnd = new Random();
        int nmrUtil;
        while (true) {
            System.out.println("Quem vai jogar primeiro? Digite 1 para utilizador, 2 para o computador:");
            nmrUtil = in.nextInt();
            System.out.println("-------------------------------------------------------");
            if (nmrUtil == 1 || nmrUtil == 2) {
                break;
            }
            System.out.println("Valor inválido, escolha entre 1 e 2");
            System.out.println("-------------------------------------------------------");
        }
        while (totalFosforos > 1) {
            if (totalFosforos <= 4) {
                nmrMax = (totalFosforos - 1);
            }
            if (nmrUtil == 1) {
                System.out.println("Por favor, retira no máximo " + nmrMax + " fósforos. Existem " + totalFosforos + " fósforos.");
                valorInserido = in.nextInt();
                System.out.println("-------------------------------------------------------");
                if (valorInserido <= nmrMax && valorInserido >= 1) {
                    totalFosforos = totalFosforos - valorInserido;
                    System.out.println("Retiraste " + valorInserido + " fósforos. Existem " + totalFosforos + " fósforos.");
                    nmrUtil = 2;
                    System.out.println("-------------------------------------------------------");
                } else {
                    System.out.println("Jogada Inválida! Repete.");
                    System.out.println("-------------------------------------------------------");
                }
            } else {
                jogadaPC = rnd.nextInt(nmrMax) + 1;
                totalFosforos = totalFosforos - jogadaPC;
                System.out.println("O computador retirou " + jogadaPC + " fósforos. Restam " + totalFosforos + " fósforos.");
                nmrUtil = 1;
                System.out.println("-------------------------------------------------------");
            }
        }
        if (nmrUtil == 1) {
            System.out.println("Que azar! O computador ganhou!");
        } else {
            System.out.println("Parabéns!! Ganhaste o jogo contra o computador!");
        }
    }

    private static void jogadorVScomputadorMD() {
        System.out.println("=======================================================");
        System.out.println("        Humano vs Computador (modo difícil)!");
        System.out.println("=======================================================");
        int totalFosforos = 21, valorInserido, nmrMax = 4, jogadaPC;
        int nmrUtil;
        while (true) {
            System.out.println("Quem vai jogar primeiro? Digite 1 para utilizador, 2 para o computador:");
            nmrUtil = in.nextInt();
            System.out.println("-------------------------------------------------------");
            if (nmrUtil == 1 || nmrUtil == 2) {
                break;
            }
            System.out.println("Valor inválido, escolha entre 1 e 2");
            System.out.println("-------------------------------------------------------");
        }
        while (totalFosforos > 1) {
            if (totalFosforos <= 4) {
                nmrMax = (totalFosforos - 1);
            }
            if (nmrUtil == 1) {
                System.out.println("Por favor, retira no máximo " + nmrMax + " fósforos. Existem " + totalFosforos + " fósforos.");
                valorInserido = in.nextInt();
                System.out.println("-------------------------------------------------------");
                if (valorInserido <= nmrMax && valorInserido >= 1) {
                    totalFosforos = totalFosforos - valorInserido;
                    System.out.println("Retiraste " + valorInserido + " fósforos. Existem " + totalFosforos + " fósforos.");
                    nmrUtil = 2;
                    System.out.println("-------------------------------------------------------");
                } else {
                    System.out.println("Jogada Inválida! Repete.");
                    System.out.println("-------------------------------------------------------");
                }
            } else {
                if (totalFosforos <= 4) {
                    jogadaPC = totalFosforos - 1;
                } else {
                    jogadaPC = (totalFosforos - 1) % 5;
                    if (jogadaPC == 0) {
                        jogadaPC = 1;
                    }
                }
                totalFosforos = totalFosforos - jogadaPC;
                System.out.println("O computador retirou " + jogadaPC + " fósforos. Restam " + totalFosforos + " fósforos.");
                nmrUtil = 1;
                System.out.println("-------------------------------------------------------");
            }
        }
        if (nmrUtil == 1) {
            System.out.println("Que azar! O computador ganhou!");
        } else {
            System.out.println("Parabéns!! Ganhaste o jogo contra o computador!");
        }
    }

    private static void ConsultarCondicoesJogo() {
        System.out.println("========================================================================================================================");
        System.out.println("                                                    Condições de Jogo");
        System.out.println("========================================================================================================================");
        System.out.println("O jogo inicia com um total de 21 fósforos.\n" +
                "Os jogadores vão jogando por turnos, podendo tirar apenas um máximo de 4 fósforos por turno.\n" +
                "As regras aplicam-se tanto a jogadores como ao computador.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                    Tipo de jogo");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Existem três tipos de jogo:\n--------------------------\n" +
                "Jogador VS Jogador: ao optar por este modo, pode inserir os valores pelo Jogador 1 e Jogador 2\n--------------------------\n" +
                "Jogador vs PC - Modo Fácil: O utilizador joga contra o computador que na sua jogada escolhe um valor random.\n--------------------------\n" +
                "Jogador vs PC - Modo Difícil: O utilizador joga contra o computador que na sua jogada usa um algoritmo com o intuito de ganhar.");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                               Condições de Vitória");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("O jogador que tiver apenas um fósforo no início do seu turno, perde o jogo.\n" +
                "Por exemplo, se na última jogada do jogador 1 existirem 5 fósforos e ele remover 4, fica um total de 1 fósforo.\n" +
                "O jogador 2 ao iniciar a sua jogada só tem 1 fósforo. Não podendo remover nenhum fósforo, perde.");
        System.out.println("========================================================================================================================");
    }

    private static void SobreOJogoDosFosforos() {
        System.out.println("============================================================================================================");
        System.out.println("                                          Sobre Jogo dos Fósforos");
        System.out.println("============================================================================================================");
        System.out.println("                                          Informações Legais");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Este projeto foi elaborado no âmbito de uma disciplina do Curso Software Developer e não se destina a fins\n" +
                "comerciais. O projeto 'Jogo dos Fósforos' teve como objetivo permitir que os estudantes desenvolvessem habilidades\n" +
                "práticas e teóricas na área da programação em Java, aplicando os conhecimentos adquiridos durante o curso.");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("                                          Informações Adicionais");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Instituição:\nCESAE Digital\n----------------------------------");
        System.out.println("Curso:\nSoftware Developer\n----------------------------------");
        System.out.println("Disciplina:\nProgramação de Computadores - Estruturada\n----------------------------------");
        System.out.println("Projeto:\nJogo dos Fósforos\nVersão: 1.0.0\nÚltima atualização: 30/11/2022\n----------------------------------");
        System.out.println("Formador:\nBruno Santos\n----------------------------------");
        System.out.println("Alunos:\nFilipe Ramos\nLuís Macieira\n----------------------------------");
        System.out.println("============================================================================================================");
    }

}