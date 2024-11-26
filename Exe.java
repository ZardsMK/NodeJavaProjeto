public class Exe {
    private int [] memoria = new int[26];
    public void Exe (){

    };

    public int res(String[] x){
        if (x[0].equalsIgnoreCase("mov")) {
            return 1;
        } else if (x[0].equalsIgnoreCase("inc")) {
            return 2;
        } else if (x[0].equalsIgnoreCase("dec")) {
            return 3;
        } else if (x[0].equalsIgnoreCase("add")) {
            return 4;
        } else if (x[0].equalsIgnoreCase("sub")) {
            return 5;
        } else if (x[0].equalsIgnoreCase("mul")) {
            return 6;
        } else if (x[0].equalsIgnoreCase("div")) {
            return 7;
        } else if (x[0].equalsIgnoreCase("jnz")) {
            return 8;
        } else if (x[0].equalsIgnoreCase("out")) {
            return 9;
        } else {
            return 0;
        }
    }

    public void inc (int x){
        memoria[x] = memoria[x] + 1;
    }

    public void dec (int x){
        memoria[x] = memoria[x] - 1;
    }

    public void add(int x, int y) {
        memoria[x] = memoria[x] + y;
    }

    public void sub(int x, int y) {
        memoria[x] = memoria[x] - y;
    }

    public void mult(int x, int y){
        memoria[x] = memoria[x] * y;
    }

    public void div(int x, int y){
        if (memoria[x] == 0) {
            System.out.println("Zero/null não pode ser dividido.");
        } else {
            memoria[x] = memoria[x] / y;
        }
    }

    public void out(int x) {
        System.out.println(x);
    }

    public void setMemoria(int x, int y){
        memoria[x] = y;
    }

    public int getMemoria(int x){
        return (memoria[x]);
    }
}
