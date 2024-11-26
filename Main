import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean salvo = false;
    static Node head = null;
    static int limiteLinhas = 20;
    static Exe exe = new Exe();

    public static int countLines() {
        int count = 0;
        Node aux = head;
    
        while (aux != null) {
            count++;
            aux = aux.getNext();
        }
    
        return count;
    }

    public static void insertLine(int index, String var){
        Node aux = head;

        if (countLines() >= limiteLinhas) {
            System.out.println("Erro: Número máximo de linhas (" + limiteLinhas + ") atingido.");
            return;
        }

        Node linha = findNode(index);
        if (linha != null) {
            linha.setLetra(var);
            salvo = false;
            System.out.println("Linha atualizada.");
            return;

        } 

        if (head == null) { 
                
            head = new Node();
            head.setId(index);
            head.setLetra(var);
            salvo = false;
            System.out.println("Linha inserida.");
            return;
        }

        while (aux != null) {

            if (aux.getNext() == null || (aux.getId() < index && index < aux.getNext().getId())) {
                Node novo = new Node();
                novo.setId(index);
                novo.setLetra(var);
                novo.setNext(aux.getNext());
                aux.setNext(novo);
                salvo = false; 
                System.out.println("Linha inserida.");
                return;
                
            }
            aux = aux.getNext();
        }

    }

    public static void deleteNode(int a1, int a2){

        if (head == null) {
            System.out.println("Erro: A lista está vazia.");
            return;
        }

        if (a1 <= 0 || (a2 != 0 && a2 < a1)) {
            System.out.println("Erro: Indices inválidos.");
            return;
        }

        if (a2 == 0) {
            
            if (head != null && head.getId() == a1) {
                head = head.getNext();
                System.out.println("Nó " + a1 + " deletado com sucesso.");
                salvo = false;
                return;
            }

            Node temp = head;
            while (temp != null && temp.getNext() != null) {
                if (temp.getNext().getId() == a1) {
                    temp.setNext(temp.getNext().getNext()); 
                    System.out.println("Nó " + a1 + " deletado com sucesso.");
                    salvo = false;
                    return;
                }
                temp = temp.getNext();
            }
    
            System.out.println("Erro: Indice " + a1 + " não encontrado.");
            return;
        }


        while (head != null && head.getId() >= a1 && head.getId() <= a2) {
            head = head.getNext();
        }

        if (head == null) {
            System.out.println("Nó(s) no intervalo [" + a1 + ", " + a2 + "] deletado(s).");
            salvo = false;
            return;
        }

       
        Node temp = head;
        while (temp != null && temp.getNext() != null) {
            if (temp.getNext().getId() >= a1 && (a2 == 0 || temp.getNext().getId() <= a2)) {
                temp.setNext(temp.getNext().getNext());
                salvo = false;
            } else {
                temp = temp.getNext();
            }
        }
        System.out.println("Nó(s) no intervalo [" + a1 + ", " + a2 + "] deletado(s).");
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Node findNode(int var) {
        Node aux = head;
        while(aux != null){
            if (aux.getId() == var) {
                return aux;
            } 
            aux = aux.getNext();
        }
        return null; 

    }

    public static void saveFile(String filePath) {

        if (!filePath.toLowerCase().endsWith(".txt")) {
            System.out.println("Erro: O arquivo precisa ter a extensão .txt");
            return;
        }

        if (salvo) {
            System.out.println("Nenhuma alteração a salvar.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Node aux = head;

            if (head == null) {
                System.out.println("A lista está vazia. Nenhum dado foi salvo.");
                return;
            }

            while (aux != null) {
                writer.write(aux.getId() + " " + aux.getLetra());
                writer.newLine();
                aux = aux.getNext();
            }
            salvo = true;
            System.out.println("Arquivo salvo em: " + filePath);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
        
    }

    public static void leitura (String[] var) {
        if (var.length > 1) {
            String filePath = var[1].replace("\\", "/");

            if (!filePath.toLowerCase().endsWith(".txt")) {
                System.out.println("Erro: O arquivo precisa ter a extensão .txt");
                return;
            }

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Erro: O arquivo não existe no caminho especificado.");
                return;
            }

            loadFile(filePath);
        } else {
            System.out.println("Caminho do arquivo não encontrado!");
        }

    };

    public static int minhaFunParaUsar(String[] var, Node index) {
        
        switch(exe.res(var)){
            case 1 :
                int valorMov;
                if (Character.isLetter(var[2].charAt(0))) {
                    valorMov = exe.getMemoria(var[2].charAt(0) - 'a');
                } else {
                    valorMov = Integer.parseInt(var[2]);
                }

                exe.setMemoria(var[1].charAt(0) - 'a', valorMov);
                return 1;
            case 2 :
                exe.inc(var[1].charAt(0) - 'a');
                return 1;
            case 3 :
                exe.dec(var[1].charAt(0) - 'a');
                return 1;
            case 4 :
                exe.add(var[1].charAt(0) - 'a', Integer.parseInt(var[2]));
                return 1;
            case 5 :
                exe.sub(var[1].charAt(0) - 'a', Integer.parseInt(var[2]));
                return 1;
            case 6 :
                exe.mult(var[1].charAt(0) - 'a', Integer.parseInt(var[2]));
                return 1;
            case 7 :
                exe.div(var[1].charAt(0) - 'a', Integer.parseInt(var[2]));
                return 1;
            case 8 :
                int valor = Character.isLetter(var[1].charAt(0)) ? exe.getMemoria(var[1].charAt(0) - 'a') : Integer.parseInt(var[1]);

                if(valor != 0) {

                    int destino;
                    if (Character.isLetter(var[2].charAt(0))) { 
                        destino = exe.getMemoria(var[2].charAt(0) - 'a');
                    } else {
                        destino = Integer.parseInt(var[2]);
                    }

                    Node aux = findNode(destino);
                    if (aux == null) {
                        System.out.println("Erro: Indice " + var[2] + " não encontrado.");
                        return 0;
                    }
                    
                    Node aux2 = aux;

                    for (int i = 0; i < valor; i++ ) {
                        if (aux == null) break;
                        
                        String[] varTemp = aux.getLetra().split(" ", 3);
                        minhaFunParaUsar(varTemp, aux);
                        
                        aux = aux.getNext();
                        if(aux != null && aux.getId() == index.getId()){
                            aux = aux2;
                        } 
                    }
                }
                return 1;
            case 9 :
                exe.out(exe.getMemoria(var[1].charAt(0) - 'a'));
                return 1;
            case 0 :
                System.out.println("Comando Invalido!");  
                return 0;                      
        }
        return 0;
    }

    public static void loadFile(String filePath) {

        if (!salvo && head != null) {
            System.out.println("Arquivo atual não foi salvo. Deseja carregar um novo arquivo e perder as alterações não salvas? (S/N)");
            Scanner scan = new Scanner(System.in);
            String resposta = scan.nextLine().trim();
            
            if (resposta.equalsIgnoreCase("n")) {
                return;
            }
        }

        head = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lastIndex = 0;
            Node aux = null;

            
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] var = line.split(" ", 2);
                int index;
                
                if (var.length > 1 && isInteger(var[0])) {

                    index = Integer.parseInt(var[0]);
                    line = var[1];
                } else {
                    
                    index = lastIndex + 10;
                }

                if (countLines() >= limiteLinhas) {
                    System.out.println("Erro: Número máximo de linhas (" + limiteLinhas + ") atingido. Carregamento interrompido.");
                    return;
                }

                Node aux2 = new Node();
                aux2.setId(index);
                aux2.setLetra(line);
                
                if(head == null){
                    head = aux2;
                } else {
                    aux.setNext(aux2);
                }

                aux = aux2;
                lastIndex = index;

            }
            salvo = true;
            System.out.println("Arquivo carregado: " + filePath);
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
        }
    }


     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         
         String msg;
         int laco = 0;
         
         do {
             msg = scan.nextLine().trim();
             
             if(msg.startsWith("load")){
                String[] var = msg.split(" ", 2);
                leitura(var);
             } else if (msg.startsWith("list")){

                Node aux = head != null? head : null;
                while (aux != null) {
                    System.out.println(aux.getId() + " " + aux.getLetra());
                    aux = aux.getNext();
                }
                
             } else if (msg.equalsIgnoreCase("run")){
                int val = 1;
                Node aux = head;
                while (val != 0 && aux != null) {
                    String[] var = aux.getLetra().split(" ", 3);
                    val = minhaFunParaUsar(var, aux);
                    aux = aux.getNext();
                }

             } else if (msg.startsWith("ins")){
                String[] var = msg.split(" ", 3);
                if(var.length == 3){
                    insertLine(Integer.parseInt(var[1]), var[2]);
                } else {
                    System.out.println("Comando escrito errado.");
                }

             } else if (msg.startsWith("del")){
                String[] var = msg.split(" ", 3);
                if(var.length == 3) {
                    deleteNode(Integer.parseInt(var[1]), Integer.parseInt(var[2]));
                } else if (var.length == 2) {
                    deleteNode(Integer.parseInt(var[1]), 0);
                } else {
                    System.out.println("Comando escrito errado.");
                }

             } else if (msg.startsWith("save")){
                String[] var = msg.split(" ", 2);
                if (var.length > 1) {
                    saveFile(var[1]);
                } else {
                    System.out.println("Erro: caminho do arquivo não especificado.");
                }

             } else if (msg.equalsIgnoreCase("exit")){
                if (!salvo) {
                    System.out.println("Há alterações não salvas. Deseja sair mesmo assim? (s/n)");
                    if (scan.nextLine().equalsIgnoreCase("n")) {
                        continue;
                    }
                }
                System.out.println("Obrigado!!! =)");
                laco = 1;
             } else {
                 System.out.println("Comando Inválido");
             }
         } while(laco != 1);
         
         scan.close();
     }
}
