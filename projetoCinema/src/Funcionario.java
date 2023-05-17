 class Funcionario extends Base{

    private double salario;

     public Funcionario(String nome, int idade, String email, double salario) {
         super(nome, idade, email);
         this.salario = salario;
     }

     public double getSalario() {
         return salario;
     }

     public void setSalario(double salario) {
         this.salario = salario;
     }

//     metodos implementados em Base
//     Implementar métodos de interface gerência de filmes.
 }
