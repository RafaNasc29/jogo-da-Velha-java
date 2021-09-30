package jogodavelha;
import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean ok = true;

        while(ok){
            imprimeMenu();
            int op = input.nextInt();
            switch(op){
                case 1: jogar(); break;
                case 2: manual();break;
                case 3: ok=false;break;
                default: break;
            }
        }
    }
    
    
    //menu
    public static void imprimeMenu(){
    	System.out.println("");
        System.out.println("================================================================");
        System.out.println("|                 Bem vindo ao jogo da velha!                  |");
        System.out.println("================================================================");
        System.out.println("| Operações:                                                   |");
        System.out.println("| 1) Jogar jogo da velha                                       |");
        System.out.println("| 2) MANUAL                                                    |");
        System.out.println("| 3) Sair                                                      |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.print("Escolha uma opção: ");

    }

    
    //jogo
    public static void jogar(){
        // Todo jogo terá obrigatoriamente 9 jogadas a menos que ocorra uma vitoria no meio
        boolean teste, resultado;
        int jogada, jogador, tab[][] = new int[3][3];
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha uma posição de 0 a 8\n");
        for (int k = 0; k <= 9; k++) {

            imprimeTab(tab);
            resultado = resJogo(tab, k);

            if(resultado){break;}

            if(k%2 == 0){
                System.out.print("\nJogador 1: ");
                jogador = 1;
            }else{
                System.out.print("\nJogador 2: ");
                jogador = 2;
            }

            teste = true;
            do{
                if(resultado){break;}

                jogada = input.nextInt();
                if(jogada < 9 && jogada >= 0){

                    // Checar se a posição está sendo ocupada
                    boolean pos = true;
                    switch(jogada){
                            case 0:     if(tab[0][0]==1 | tab[0][0]==2){pos=false;}break;
                            case 1:     if(tab[0][1]==1 | tab[0][1]==2){pos=false;}break;
                            case 2:     if(tab[0][2]==1 | tab[0][2]==2){pos=false;}break;
                            case 3:     if(tab[1][0]==1 | tab[1][0]==2){pos=false;}break;
                            case 4:     if(tab[1][1]==1 | tab[1][1]==2){pos=false;}break;
                            case 5:     if(tab[1][2]==1 | tab[1][2]==2){pos=false;}break;
                            case 6:     if(tab[2][0]==1 | tab[2][0]==2){pos=false;}break;
                            case 7:     if(tab[2][1]==1 | tab[2][1]==2){pos=false;}break;
                            case 8:     if(tab[2][2]==1 | tab[2][2]==2){pos=false;}break;
                            default:    break;
                    }

                    if(pos){
                        // Converter a posição escolhida na posição bidimensional
                        switch(jogada){
                            case 0:     if(jogador == 1){tab[0][0]=1;}else{tab[0][0]=2;} break;
                            case 1:     if(jogador == 1){tab[0][1]=1;}else{tab[0][1]=2;} break;
                            case 2:     if(jogador == 1){tab[0][2]=1;}else{tab[0][2]=2;} break;
                            case 3:     if(jogador == 1){tab[1][0]=1;}else{tab[1][0]=2;} break;
                            case 4:     if(jogador == 1){tab[1][1]=1;}else{tab[1][1]=2;} break;
                            case 5:     if(jogador == 1){tab[1][2]=1;}else{tab[1][2]=2;} break;
                            case 6:     if(jogador == 1){tab[2][0]=1;}else{tab[2][0]=2;} break;
                            case 7:     if(jogador == 1){tab[2][1]=1;}else{tab[2][1]=2;} break;
                            case 8:     if(jogador == 1){tab[2][2]=1;}else{tab[2][2]=2;} break;
                            default:    break;
                        }

                        // Se sucede
                        teste = false;
                        System.out.println("");

                    }else{
                        System.out.print("Posição ocupada! Tente novamente: ");
                    }

                }else{
                    System.out.print("Jogada inválida! Tente novamente: ");
                }
            }while(teste);
        }
    }

    //manual
    public static void manual(){
    	System.out.println("");
        System.out.println("Como jogar:");
        System.out.println("");
        System.out.println("- As posiçoes do tabuleiro são dispostas de 0 a 8");
        System.out.println("- Os jogadores tem suas respectivas jogadas alternadas,");
        System.out.println("  sendo primeiro o jogador 1, depois o 2, retornando ");
        System.out.println("  novamente ao 1 e assim por diante");
        System.out.println("- Ganha o jogador que fechar uma linha, ou uma coluna, ou uma diagonal");
        System.out.println("- Não pode ser escolhida a mesma posição");
        System.out.println("- Se nenhum jogador completar uma linha, coluna ou diagonal,");
        System.out.println("  ocorrera um impate, chamado de 'deu velha'");
    }

    //impressão do tabuleiro
    public static void imprimeTab(int tab[][]){

        for (int[] element : tab) {
                for (int j = 0; j < tab[0].length; j++) {
                    System.out.print(element[j] + "\t");
                }
                System.out.println("");
        }
    }

    //checagem do resultado
    public static boolean resJogo(int tab[][], int k){

        boolean resultado = false;

        // Checar linhas
        for (int[] element : tab) {
            if(element[0]==1 && element[1]==1 && element[2]==1){resultado = true;System.out.printf("\nVitória jogador 1!\n");}
            if(element[0]==2 && element[1]==2 && element[2]==2){resultado = true;System.out.printf("\nVitória jogador 1!\n");}
        }

        // Checar colunas
        for (int i = 0; i < tab[0].length; i++) {
            if(tab[0][i]==1 && tab[1][i]==1 && tab[2][i]==1){resultado = true;System.out.printf("\nVitória jogador 1!\n");}
            if(tab[0][i]==2 && tab[1][i]==2 && tab[2][i]==2){resultado = true;System.out.printf("\nVitória jogador 2!\n");}
        }

        // Checar diagonais
        if(tab[0][0]==1 && tab[1][1]==1 && tab[2][2]==1){resultado = true;System.out.printf("\nVitória jogador 1!\n");}
        if(tab[0][2]==1 && tab[1][1]==1 && tab[2][0]==1){resultado = true;System.out.printf("\nVitória jogador 1!\n");}
        if(tab[0][0]==2 && tab[1][1]==2 && tab[2][2]==2){resultado = true;System.out.printf("\nVitória jogador 2!\n");}
        if(tab[0][2]==2 && tab[1][1]==2 && tab[2][0]==2){resultado = true;System.out.printf("\nVitória jogador 2!\n");}

        if(k == 9){resultado = true;System.out.println("\nEmpate 'Deu Velha'!\n");}

        return resultado;
    }
}

